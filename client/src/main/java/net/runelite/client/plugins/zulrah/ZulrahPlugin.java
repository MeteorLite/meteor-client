package net.runelite.client.plugins.zulrah;

import com.google.common.base.Preconditions;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import eventbus.events.*;
import meteor.Main;
import meteor.api.Items;
import meteor.game.SkillIconManager;
import meteor.game.SpriteManager;
import meteor.rs.ClientThread;
import net.runelite.api.*;
import net.runelite.api.Point;
import net.runelite.api.coords.LocalPoint;

import meteor.input.KeyListener;
import meteor.input.KeyManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;


import meteor.ui.overlay.OverlayManager;

import meteor.ui.overlay.infobox.InfoBoxManager;
import meteor.util.ImageUtil;
import meteor.ui.overlay.infobox.Counter;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.zulrah.overlays.*;
import net.runelite.client.plugins.zulrah.rotationutils.RotationType;
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahData;
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahPhase;


@PluginDescriptor(
   name = "Zulrah Assist",
   description = "All-in-One tool to help during the Zulrah fight",
   tags = {"zulrah", "zul", "andra", "snakeling", "zhuri/nicole", "girls rule boys drool"},
   enabledByDefault = false//cringe
)
public class ZulrahPlugin extends Plugin implements KeyListener {


   public static meteor.Logger log = new meteor.Logger("Zulrah");

    private ZulrahConfig config = configuration(ZulrahConfig.class);

   private Client client = Main.INSTANCE.getClient();

   private KeyManager keyManager = KeyManager.INSTANCE;

   private InfoBoxManager infoBoxManager = InfoBoxManager.INSTANCE;

   private OverlayManager overlayManager = OverlayManager.INSTANCE;

   private ClientThread clientThread = ClientThread.INSTANCE;

   private InstanceTimerOverlay instanceTimerOverlay = new InstanceTimerOverlay(this, config);

   private PhaseOverlay phaseOverlay  = new PhaseOverlay(this, config);

   private PrayerHelperOverlay prayerHelperOverlay  = new PrayerHelperOverlay(client,this, config, SpriteManager.INSTANCE);

   private PrayerMarkerOverlay prayerMarkerOverlay  = new PrayerMarkerOverlay(client,this, config);

   private SceneOverlay sceneOverlay  = new SceneOverlay(client,this, config, SkillIconManager.INSTANCE);
   public List<String> getMageGear() {
      String[] mageIDs = config.MageIDs().split(",");
      return Arrays.asList(mageIDs);
   }

   public List<String> getRangeGear() {
      String[] rangeIDs = config.RangeIDs().split(",");
      return Arrays.asList(rangeIDs);
   }
   private NPC zulrahNpc = null;
   private int stage = 0;
   private int phaseTicks = -1;
   private int attackTicks = -1;
   private int totalTicks = 0;
   private RotationType currentRotation = null;
   private List<RotationType> potentialRotations = new ArrayList();
   private final Map<LocalPoint, Integer> projectilesMap = new HashMap();
   private final Map<GameObject, Integer> toxicCloudsMap = new HashMap();
   private static boolean flipStandLocation = false;
   private static boolean flipPhasePrayer = false;
   private static boolean zulrahReset = false;
   private final Collection<Renderable> snakelings = new ArrayList();
   private boolean holdingSnakelingHotkey = false;
   private Counter zulrahTotalTicksInfoBox;
   public static final BufferedImage[] ZULRAH_IMAGES = new BufferedImage[3];
   private static final BufferedImage CLOCK_ICON = ImageUtil.INSTANCE.loadImageResource(ZulrahPlugin.class, "clock.png");
   private final BiConsumer<RotationType, RotationType> phaseTicksHandler = (current, potential) -> {
      if (zulrahReset) {
         phaseTicks = 38;
      } else {
         ZulrahPhase p = current != null ? getCurrentPhase(current) : getCurrentPhase(potential);
         Preconditions.checkNotNull(p, "Attempted to set phase ticks but current Zulrah phase was somehow null. Stage: " + stage);
         phaseTicks = p.getAttributes().getPhaseTicks();
      }

   };

    public void onStart() {
      log.info("Startup");
      overlayManager.add(instanceTimerOverlay);
      overlayManager.add(phaseOverlay);
      overlayManager.add(prayerHelperOverlay);
      overlayManager.add(prayerMarkerOverlay);
      overlayManager.add(sceneOverlay);
      keyManager.registerKeyListener(this, getClass());
   }

    public void onStop() {
      reset();
      overlayManager.remove(instanceTimerOverlay);
      overlayManager.remove(phaseOverlay);
      overlayManager.remove(prayerHelperOverlay);
      overlayManager.remove(prayerMarkerOverlay);
      overlayManager.remove(sceneOverlay);
      keyManager.unregisterKeyListener(this);
   }

    public void reset(){
      zulrahNpc = null;
      stage = 0;
      phaseTicks = -1;
      attackTicks = -1;
      totalTicks = 0;
      currentRotation = null;
      potentialRotations.clear();
      projectilesMap.clear();
      toxicCloudsMap.clear();
      flipStandLocation = false;
      flipPhasePrayer = false;
      instanceTimerOverlay.resetTimer();
      zulrahReset = false;
      clearSnakelingCollection();
      holdingSnakelingHotkey = false;
      handleTotalTicksInfoBox(true);
      //log.info("Zulrah Reset!");
   }

   public void keyTyped(KeyEvent e)
   {
   }

   public void keyPressed(KeyEvent e)
   {
      if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && config.snakelingMesHotkey().matches(e))
      {
         holdingSnakelingHotkey = true;
      }
   }

   public void keyReleased(KeyEvent e)
   {
      if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && config.snakelingMesHotkey().matches(e))
      {
         holdingSnakelingHotkey = false;
      }
   }

   @Override
   public void onConfigChanged(ConfigChanged it)
   {
      if (it.getGroup().equalsIgnoreCase("znzulrah"))
      {
         switch (it.getKey())
         {
            case "snakelingSetting":
            {
               if (config.snakelingSetting() != ZulrahConfig.SnakelingSettings.ENTITY)
               {
                  clearSnakelingCollection();
               }
               if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES) break;
               holdingSnakelingHotkey = false;
               break;
            }
            case "totalTickCounter":
            {
               if (config.totalTickCounter()) break;
               handleTotalTicksInfoBox(true);
            }
         }
      }
   }

   private void clearSnakelingCollection()
   {
      snakelings.forEach(npc -> ZulrahPlugin.setHidden(npc, false));
      snakelings.clear();
   }

   @Override
   public void onClientTick(ClientTick event)
   {
      Widget gear = client.getWidget(WidgetInfo.EQUIPMENT.getId());
      Point mousePoint = client.getMouseCanvasPosition();
      if (gear != null && gear.isVisible()) {
         Rectangle bounds = gear.getBounds();
         if (bounds.contains(mousePoint.getX(), mousePoint.getY())) {
            client.insertMenuItem(
                    "<col=00FFFF>Copy Gear</col>",
                    "",
                    MenuAction.RUNELITE.getId(),
                    InventoryID.EQUIPMENT.getId(),
                    0,
                    0,
                    false
            );
         }
      }
      if (client.getGameState() != GameState.LOGGED_IN || zulrahNpc == null)
      {
         return;
      }
      if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.ENTITY)
      {
         snakelings.addAll(client.getNpcs().stream().filter(npc -> npc != null && npc.getName() != null && npc.getName().equalsIgnoreCase("snakeling") && npc.getCombatLevel() == 90).collect(Collectors.toList()));
         snakelings.forEach(npc -> ZulrahPlugin.setHidden(npc, true));
      }
   }

   private boolean firstJadAttack = false;

   @Override
   public void onGameTick(GameTick it)
   {
      if (client.getGameState() != GameState.LOGGED_IN || zulrahNpc == null)
      {
         return;
      }
      ++totalTicks;
      if (attackTicks >= 0)
      {
         --attackTicks;
      }
      if (phaseTicks >= 0)
      {
         --phaseTicks;
      }
      if (projectilesMap.size() > 0)
      {
         projectilesMap.values().removeIf(v -> v <= 0);
         projectilesMap.replaceAll((k, v) -> v - 1);
      }
      if (toxicCloudsMap.size() > 0)
      {
         toxicCloudsMap.values().removeIf(v -> v <= 0);
         toxicCloudsMap.replaceAll((k, v) -> v - 1);
      }
      handleTotalTicksInfoBox(false);
      if (zulrahNpc != null && config.autoPray())
      {
         boolean jad = false;
         Prayer prayer = null;
         for (ZulrahData data : this.getZulrahData()) {
            if (!data.getCurrentPhasePrayer().isPresent()) {
               continue;
            }
            prayer = data.getCurrentPhasePrayer().get();
            jad = data.isJad();
         }
         if (prayer != null && !jad) {
            activatePrayer(prayer);
         }
         if (jad && !firstJadAttack)
         {
            firstJadAttack = true;
            activatePrayer(prayer);
         }
      }
   }

   @Override
   public void onNpcChanged(NpcChanged npcCompositionChanged)
   {
      NPC npc = npcCompositionChanged.getNpc();
      if (config.offensivePrayerToggle())
      {
         if (npc.getId() == NpcID.ZULRAH_2044) {
            activatePrayer(config.offensiveRangePrayer().getPrayer());
            equipRangeGear();
         } else {
            activatePrayer(config.offensiveMagePrayer().getPrayer());
            equipMageGear();
         }
      }
   }

   @Override
   public void onNpcSpawned(NpcSpawned npcSpawned)
   {
      NPC npc = npcSpawned.getNpc();
      if (npc.getId() == NpcID.ZULRAH)
      {
         if (npc.getId() == NpcID.ZULRAH) {
            activatePrayer(config.offensiveMagePrayer().getPrayer());
            equipMageGear();
         }
      }
   }

   @Override
   public void onAnimationChanged(AnimationChanged it)
   {
      if (!(it.getActor() instanceof NPC))
      {
         return;
      }
      NPC npc = (NPC)((Object)it.getActor());
      if (npc.getName() != null && !npc.getName().equalsIgnoreCase("zulrah"))
      {
         return;
      }
      switch (npc.getAnimation())
      {
         case 5071:
         {
            zulrahNpc = npc;
            instanceTimerOverlay.setTimer();
            potentialRotations = RotationType.findPotentialRotations(npc, stage);
            phaseTicksHandler.accept(currentRotation, potentialRotations.get(0));
            log.debug("New Zulrah Encounter Started");
            break;
         }
         case 5073:
         {
            ++stage;
            if (currentRotation == null)
            {
               potentialRotations = RotationType.findPotentialRotations(npc, stage);
               currentRotation = potentialRotations.size() == 1 ? potentialRotations.get(0) : null;
            }
            phaseTicksHandler.accept(currentRotation, potentialRotations.get(0));
            break;
         }
         case 5072:
         {
            if (zulrahReset)
            {
               zulrahReset = false;
            }
            if (currentRotation == null || !isLastPhase(currentRotation)) break;
            stage = -1;
            currentRotation = null;
            potentialRotations.clear();
            snakelings.clear();
            flipStandLocation = false;
            flipPhasePrayer = false;
            zulrahReset = true;
            firstJadAttack = false;
            log.debug("Resetting Zulrah");
            break;
         }
         case 5069:
         {
            attackTicks = 4;
            if (currentRotation == null || !getCurrentPhase(currentRotation).getZulrahNpc().isJad() || zulrahNpc.getInteracting() != client.getLocalPlayer()) break;
            flipPhasePrayer = !flipPhasePrayer;
            break;
         }
         case 5806:
         case 5807:
         {
            attackTicks = 8;
            flipStandLocation = !flipStandLocation;
            break;
         }
         case 5804:
         {
            reset();
         }
      }
   }

   @Override
   public void onFocusChanged(FocusChanged it)
   {
      if (!it.getFocused())
      {
         holdingSnakelingHotkey = false;
      }
   }

   @Override
   public void onMenuOptionClicked(MenuOptionClicked it) {
      String menuOption = it.getMenuOption();
      if (menuOption != null && menuOption.contains("<col=00FFFF>Copy Gear</col>")) {
         ItemContainer i = client.getItemContainer(InventoryID.EQUIPMENT);
         if (i == null) {
            return;
         }
         StringBuilder sb = new StringBuilder();
         for (Item item : i.getItems()) {
            if (item.getId() == -1 || item.getId() == 0) {
               continue;
            }
            sb.append(item.getName());
            sb.append(",");
         }
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(sb.toString()), null);
      }
   }

   @Override
   public void onMenuEntryAdded(MenuEntryAdded it)
   {
      if (config.snakelingSetting() != ZulrahConfig.SnakelingSettings.MES || zulrahNpc == null || zulrahNpc.isDead())
      {
         return;
      }
      if (!holdingSnakelingHotkey && it.getTarget().contains("Snakeling") && it.getOption().equalsIgnoreCase("attack"))
      {
         NPC npc = client.getCachedNPCs()[it.getIdentifier()];
         if (npc == null)
         {
            return;
         }
         client.setMenuEntries(Arrays.copyOf(client.getMenuEntries(), client.getMenuEntries().length - 1));
      }
   }

   @Override
   public void onProjectileMoved(ProjectileMoved it)
   {
      if (zulrahNpc == null)
      {
         return;
      }
      Projectile p = it.getProjectile();
      switch (p.getId())
      {
         case 1045:
         case 1047:
         {
            projectilesMap.put(it.getPosition(), p.getRemainingCycles() / 30);
         }
      }
      if (it.getProjectile().getId() == 1046 && this.currentRotation != null && this.getCurrentPhase(this.currentRotation).getZulrahNpc().isJad()) { //Mage attack and Jad
         activatePrayer(Prayer.PROTECT_FROM_MISSILES);
      }

      if (it.getProjectile().getId() == 1044 && this.currentRotation != null && this.getCurrentPhase(this.currentRotation).getZulrahNpc().isJad()) { //Range attack and Jad
         activatePrayer(Prayer.PROTECT_FROM_MAGIC);
      }
   }

   @Override
   public void onGameObjectSpawned(GameObjectSpawned it)
   {
      if (zulrahNpc == null)
      {
         return;
      }
      GameObject obj = it.getGameObject();
      if (obj.getId() == 11700)
      {
         toxicCloudsMap.put(obj, 30);
      }
   }

   @Override
   public void onGameStateChanged(GameStateChanged it)
   {
      if (zulrahNpc == null)
      {
         return;
      }
      switch (it.getGameState())
      {
         case LOADING:
         case CONNECTION_LOST:
         case HOPPING:
         {
            reset();
         }
      }
   }

   @Nullable
   private ZulrahPhase getCurrentPhase(RotationType type)
   {
      if (type != null)
         return stage >= type.getZulrahPhases().size() ? null : type.getZulrahPhases().get(stage);
      return null;
   }

   @Nullable
   private ZulrahPhase getNextPhase(RotationType type)
   {
      return isLastPhase(type) ? null : type.getZulrahPhases().get(stage + 1);
   }

   private boolean isLastPhase(RotationType type)
   {
      return stage == type.getZulrahPhases().size() - 1;
   }

   public Set<ZulrahData> getZulrahData()
   {
      LinkedHashSet<ZulrahData> zulrahDataSet = new LinkedHashSet<ZulrahData>();
      if (currentRotation == null)
      {
         potentialRotations.forEach(type -> zulrahDataSet.add(new ZulrahData(getCurrentPhase((RotationType)((Object)type)), getNextPhase((RotationType)((Object)type)))));
      }
      else
      {
         zulrahDataSet.add(new ZulrahData(getCurrentPhase(currentRotation), getNextPhase(currentRotation)));
      }
      return zulrahDataSet.size() > 0 ? zulrahDataSet : Collections.emptySet();
   }

   private void handleTotalTicksInfoBox(boolean remove)
   {
      if (remove)
      {
         infoBoxManager.removeInfoBox(zulrahTotalTicksInfoBox);
         zulrahTotalTicksInfoBox = null;
      }
      else if (config.totalTickCounter())
      {
         if (zulrahTotalTicksInfoBox == null)
         {
            zulrahTotalTicksInfoBox = new Counter(CLOCK_ICON, this, totalTicks);
            zulrahTotalTicksInfoBox.setTooltip("Total Ticks Alive");
            infoBoxManager.addInfoBox(zulrahTotalTicksInfoBox);
         }
         else
         {
            zulrahTotalTicksInfoBox.setCount(totalTicks);
         }
      }
   }

   private static void setHidden(Renderable renderable, boolean hidden)
   {
      Method setHidden = null;
      try
      {
         setHidden = renderable.getClass().getMethod("setHidden", Boolean.TYPE);
      }
      catch (NoSuchMethodException e)
      {
         log.debug("Couldn't find method setHidden for class {}", renderable.getClass());
         return;
      }
      try
      {
         setHidden.invoke(renderable, hidden);
      }
      catch (IllegalAccessException | InvocationTargetException e)
      {
         log.debug("Couldn't call method setHidden for class {}", renderable.getClass());
      }
   }

   public NPC getZulrahNpc()
   {
      return zulrahNpc;
   }

   public int getPhaseTicks()
   {
      return phaseTicks;
   }

   public int getAttackTicks()
   {
      return attackTicks;
   }

   public RotationType getCurrentRotation()
   {
      return currentRotation;
   }

   public Map<LocalPoint, Integer> getProjectilesMap()
   {
      return projectilesMap;
   }

   public Map<GameObject, Integer> getToxicCloudsMap()
   {
      return toxicCloudsMap;
   }

   public static boolean isFlipStandLocation()
   {
      return flipStandLocation;
   }

   public static boolean isFlipPhasePrayer()
   {
      return flipPhasePrayer;
   }

   public static boolean isZulrahReset()
   {
      return zulrahReset;
   }

   static
   {
      ZulrahPlugin.ZULRAH_IMAGES[0] = ImageUtil.INSTANCE.loadImageResource(ZulrahPlugin.class, "zulrah_range.png");
      ZulrahPlugin.ZULRAH_IMAGES[1] = ImageUtil.INSTANCE.loadImageResource(ZulrahPlugin.class, "zulrah_melee.png");
      ZulrahPlugin.ZULRAH_IMAGES[2] = ImageUtil.INSTANCE.loadImageResource(ZulrahPlugin.class, "zulrah_magic.png");
   }
   private void equipMageGear() {
      ClientThread.INSTANCE.invokeLater(() -> {
         for (String id : getMageGear()) {
            Item item = Items.INSTANCE.getFirst(new String[] {id}, InventoryID.INVENTORY);
            if (item != null) {
               item.interact(2);
            }
         }
      });
   }
   private void equipRangeGear() {
      ClientThread.INSTANCE.invokeLater(() -> {
         for (String id : getRangeGear()) {
            Item item = Items.INSTANCE.getFirst(new String[] {id}, InventoryID.INVENTORY);
            if (item != null) {
               item.interact(2);
            }
         }
      });
   }
   public void activatePrayer(Prayer prayer) {
      if (prayer == null) {
         return;
      }

      //check if prayer is already active this tick
      if (client.isPrayerActive(prayer)) {
         return;
      }

      WidgetInfo widgetInfo = prayer.getWidgetInfo();

      if (widgetInfo == null) {
         return;
      }
      Widget prayer_widget = client.getWidget(widgetInfo);

      if (prayer_widget == null) {
         return;
      }

      if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
         return;
      }

      clientThread.invoke(() ->
              client.invokeMenuAction(
                      "Activate",
                      prayer_widget.getName(),
                      1,
                      MenuAction.CC_OP.getId(),
                      prayer_widget.getItemId(),
                      prayer_widget.getId()
              )
      );
   }
}