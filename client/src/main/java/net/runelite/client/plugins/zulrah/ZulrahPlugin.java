package net.runelite.client.plugins.zulrah;

import com.google.common.base.Preconditions;

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

import javax.annotation.Nullable;

import eventbus.events.*;
import meteor.Main;
import meteor.game.SkillIconManager;
import meteor.game.SpriteManager;
import net.runelite.api.*;
import net.runelite.api.coords.LocalPoint;

import meteor.input.KeyListener;
import meteor.input.KeyManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;


import meteor.ui.overlay.OverlayManager;

import meteor.ui.overlay.infobox.InfoBoxManager;
import meteor.util.ImageUtil;
import meteor.ui.overlay.infobox.Counter;
import net.runelite.client.plugins.zulrah.overlays.*;
import net.runelite.client.plugins.zulrah.rotationutils.RotationType;
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahData;
import net.runelite.client.plugins.zulrah.rotationutils.ZulrahPhase;


@PluginDescriptor(
   name = "Zulrah",
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


   private InstanceTimerOverlay instanceTimerOverlay = new InstanceTimerOverlay(this, config);

   private PhaseOverlay phaseOverlay  = new PhaseOverlay(this, config);

   private PrayerHelperOverlay prayerHelperOverlay  = new PrayerHelperOverlay(client,this, config, SpriteManager.INSTANCE);

   private PrayerMarkerOverlay prayerMarkerOverlay  = new PrayerMarkerOverlay(client,this, config);

   private SceneOverlay sceneOverlay  = new SceneOverlay(client,this, config, SkillIconManager.INSTANCE);

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

   public void keyTyped(KeyEvent e) {
   }

   public void keyPressed(KeyEvent e) {

      if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && config.snakelingMesHotkey().matches(e)) {
         holdingSnakelingHotkey = true;
      }

   }

   public void keyReleased(KeyEvent e) {
      if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && config.snakelingMesHotkey().matches(e)) {
         holdingSnakelingHotkey = false; }

   }
   @Override
   public void onConfigChanged(ConfigChanged it) {
      if (it.getGroup().equalsIgnoreCase("znzulrah")) {
         String var2 = it.getKey();
         byte var3 = -1;
         switch(var2.hashCode()) {
         case -1906254917:
            if (var2.equals("totalTickCounter")) {
               var3 = 1;
            }
            break;
         case -1662720966:
            if (var2.equals("snakelingSetting")) {
               var3 = 0;
            }
         }

         switch(var3) {
         case 0:
            if (config.snakelingSetting() != ZulrahConfig.SnakelingSettings.ENTITY) {
               clearSnakelingCollection();
            }

            if (config.snakelingSetting() != ZulrahConfig.SnakelingSettings.MES) {
               holdingSnakelingHotkey = false;
            }
            break;
         case 1:
            if (!config.totalTickCounter()) {
               handleTotalTicksInfoBox(true);
            }
         }
      }

   }

   private void clearSnakelingCollection() {
      snakelings.forEach((npc) -> {
         setHidden(npc, false);
      });
      snakelings.clear();
   }

   @Override
   public void onClientTick(ClientTick it) {
      if (client.getGameState() == GameState.LOGGED_IN && zulrahNpc != null) {
         if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.ENTITY) {
            snakelings.addAll(client.getNpcs().stream().filter((npc) -> npc != null && npc.getName() != null && npc.getName().equalsIgnoreCase("snakeling") && npc.getCombatLevel() == 90).toList());
            snakelings.forEach((npc) -> {
               setHidden(npc, true);
            });
         }

      }
   }
   @Override
   public void onGameTick(GameTick it) {
      if (client.getGameState() == GameState.LOGGED_IN && zulrahNpc != null) {
         ++totalTicks;
         if (attackTicks >= 0) {
            --attackTicks;
         }

         if (phaseTicks >= 0) {
            --phaseTicks;
         }

         if (projectilesMap.size() > 0) {
            projectilesMap.values().removeIf((v) -> v <= 0);
            projectilesMap.replaceAll((k, v) -> v - 1);
         }

         if (toxicCloudsMap.size() > 0) {
            toxicCloudsMap.values().removeIf((v) -> v <= 0);
            toxicCloudsMap.replaceAll((k, v) -> v - 1);
         }

         handleTotalTicksInfoBox(false);
      }
   }
   @Override
   public void onAnimationChanged(AnimationChanged it) {
      if (it.getActor() instanceof NPC) {
         NPC npc = (NPC)it.getActor();
         if (npc.getName() == null || npc.getName().equalsIgnoreCase("zulrah")) {
            switch(npc.getAnimation()) {
            case 5069:
               attackTicks = 4;
               if (currentRotation != null && getCurrentPhase(currentRotation).getZulrahNpc().isJad() && zulrahNpc.getInteracting() == client.getLocalPlayer()) {
                  flipPhasePrayer = !flipPhasePrayer;
               }
               break;
            case 5071:
                //

               zulrahNpc = npc;
               instanceTimerOverlay.setTimer();
               potentialRotations = RotationType.findPotentialRotations(npc, stage);
               phaseTicksHandler.accept(currentRotation, potentialRotations.get(0));

               log.info("New Zulrah Encounter Started");
               break;
            case 5072:
               if (zulrahReset) {
                  zulrahReset = false;
               }

               if (currentRotation != null && isLastPhase(currentRotation)) {
                  stage = -1;
                  currentRotation = null;
                  potentialRotations.clear();
                  snakelings.clear();
                  flipStandLocation = false;
                  flipPhasePrayer = false;
                  zulrahReset = true;
                  log.info("Resetting Zulrah");
               }
               break;
            case 5073:
               ++stage;
               if (currentRotation == null) {
                  potentialRotations = RotationType.findPotentialRotations(npc, stage);
                  currentRotation = potentialRotations.size() == 1 ? potentialRotations.get(0) : null;
               }

               phaseTicksHandler.accept(currentRotation, potentialRotations.get(0));
               break;
            case 5804:
               reset();
               break;
            case 5806:
            case 5807:

               attackTicks = 8;
               flipStandLocation = !flipStandLocation;
            }

         }
      }
   }
   @Override
   public void onFocusChanged(FocusChanged it) {
      if (!it.getFocused()) {
         holdingSnakelingHotkey = false;
      }

   }

   @Override
   public void onMenuEntryAdded(MenuEntryAdded it) {
      if (config.snakelingSetting() == ZulrahConfig.SnakelingSettings.MES && zulrahNpc != null && !zulrahNpc.isDead()) {
         if (!holdingSnakelingHotkey && it.getTarget().contains("Snakeling") && it.getOption().equalsIgnoreCase("attack")) {
            NPC npc = client.getCachedNPCs()[it.getIdentifier()];
            if (npc == null) {
               return;
            }

            client.setMenuEntries(Arrays.copyOf(client.getMenuEntries(), client.getMenuEntries().length - 1));
         }

      }
   }
   @Override
   public void onProjectileMoved(ProjectileMoved it) {
      if (zulrahNpc != null) {
         Projectile p = it.getProjectile();
         switch(p.getId()) {
         case 1045:
         case 1047:
            projectilesMap.put(it.getPosition(), p.getRemainingCycles() / 30);
         default:
         }
      }
   }
   @Override
   public void onGameObjectSpawned(GameObjectSpawned it) {
      if (zulrahNpc != null) {
         GameObject obj = it.getGameObject();
         if (obj.getId() == 11700) {
            toxicCloudsMap.put(obj, 30);
         }

      }
   }

   @Override
   public void onGameStateChanged(GameStateChanged it) {
      if (zulrahNpc != null) {
         switch(it.getGameState()) {
         case LOADING:
         case CONNECTION_LOST:
         case HOPPING:
            reset();
         default:
         }
      }
   }

   @Nullable
   private ZulrahPhase getCurrentPhase(RotationType type) {
      return stage >= type.getZulrahPhases().size() ? null : type.getZulrahPhases().get(stage);
   }

   @Nullable
   private ZulrahPhase getNextPhase(RotationType type) {
      return isLastPhase(type) ? null : type.getZulrahPhases().get(stage + 1);
   }

   private boolean isLastPhase(RotationType type) {
      return stage == type.getZulrahPhases().size() - 1;
   }

   public Set<ZulrahData> getZulrahData() {
      Set<ZulrahData> zulrahDataSet = new LinkedHashSet<>();
      if (currentRotation == null) {
         potentialRotations.forEach((type) -> {
            zulrahDataSet.add(new ZulrahData(getCurrentPhase(type), getNextPhase(type)));
         });
      } else {
         zulrahDataSet.add(new ZulrahData(getCurrentPhase(currentRotation), getNextPhase(currentRotation)));
      }

      return zulrahDataSet.size() > 0 ? zulrahDataSet : Collections.emptySet();
   }

   private void handleTotalTicksInfoBox(boolean remove) {
      if (remove) {
         infoBoxManager.removeInfoBox(zulrahTotalTicksInfoBox);
         zulrahTotalTicksInfoBox = null;
      } else if (config.totalTickCounter()) {
         if (zulrahTotalTicksInfoBox == null) {
            zulrahTotalTicksInfoBox = new Counter(CLOCK_ICON, this, totalTicks);
            zulrahTotalTicksInfoBox.setTooltip("Total Ticks Alive");
            infoBoxManager.addInfoBox(zulrahTotalTicksInfoBox);
         } else {
            zulrahTotalTicksInfoBox.setCount(totalTicks);
         }
      }

   }

   private static void setHidden(Renderable renderable, boolean hidden) {
      Method setHidden = null;

      try {
         setHidden = renderable.getClass().getMethod("setHidden", Boolean.TYPE);
      } catch (NoSuchMethodException var5) {


         log.info("Couldn't find method setHidden for class {}", renderable.getClass());
         return;
      }

      try {
         setHidden.invoke(renderable, hidden);
      } catch (InvocationTargetException | IllegalAccessException var4) {
         log.info("Couldn't call method setHidden for class {}", renderable.getClass());

      }

   }

   public NPC getZulrahNpc() {
      return zulrahNpc;
   }

   public int getPhaseTicks() {
      return phaseTicks;
   }

   public int getAttackTicks() {
      return attackTicks;
   }

   public RotationType getCurrentRotation() {
      return currentRotation;
   }

   public Map<LocalPoint, Integer>  getProjectilesMap() {
      return projectilesMap;
   }

   public Map<GameObject, Integer> getToxicCloudsMap() {
      return toxicCloudsMap;
   }

   public static boolean isFlipStandLocation() {
      return flipStandLocation;
   }

   public static boolean isFlipPhasePrayer() {
      return flipPhasePrayer;
   }

   public static boolean isZulrahReset() {
      return zulrahReset;
   }



   static {
      ZULRAH_IMAGES[0] = ImageUtil.INSTANCE.loadImageResource(ZulrahPlugin.class, "zulrah_range.png");
      ZULRAH_IMAGES[1] = ImageUtil.INSTANCE.loadImageResource(ZulrahPlugin.class, "zulrah_melee.png");
      ZULRAH_IMAGES[2] = ImageUtil.INSTANCE.loadImageResource(ZulrahPlugin.class, "zulrah_magic.png");
   }


}
