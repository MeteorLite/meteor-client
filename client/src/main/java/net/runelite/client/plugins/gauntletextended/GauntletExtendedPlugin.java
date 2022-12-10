/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2019, kThisIsCvpv <https://github.com/kThisIsCvpv>
 * Copyright (c) 2019, ganom <https://github.com/Ganom>
 * Copyright (c) 2019, kyle <https://github.com/xKylee>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package net.runelite.client.plugins.gauntletextended;

import eventbus.events.*;
import lombok.Getter;
import lombok.Setter;
import meteor.Main;
import meteor.api.items.Items;
import meteor.game.SkillIconManager;
import meteor.plugins.Plugin;
import meteor.plugins.PluginDescriptor;
import meteor.rs.ClientThread;
import meteor.ui.overlay.OverlayManager;
import net.runelite.api.*;
import net.runelite.api.queries.GameObjectQuery;
import net.runelite.api.widgets.Widget;
import net.runelite.api.widgets.WidgetID;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.client.plugins.gauntletextended.entity.*;
import net.runelite.client.plugins.gauntletextended.overlay.*;
import net.runelite.client.plugins.gauntletextended.resource.ResourceManager;
import ui.overlay.outline.ModelOutlineRenderer;

import java.util.*;

@PluginDescriptor(
	name = "Gauntlet Extended",
	enabledByDefault = false,
	description = "All-in-one plugin for the Gauntlet.",
	tags = {"gauntlet"}
)
public class GauntletExtendedPlugin extends Plugin
{
	public static final int ONEHAND_SLASH_AXE_ANIMATION = 395;
	public static final int ONEHAND_CRUSH_PICKAXE_ANIMATION = 400;
	public static final int ONEHAND_CRUSH_AXE_ANIMATION = 401;
	public static final int UNARMED_PUNCH_ANIMATION = 422;
	public static final int UNARMED_KICK_ANIMATION = 423;
	public static final int BOW_ATTACK_ANIMATION = 426;
	public static final int ONEHAND_STAB_HALBERD_ANIMATION = 428;
	public static final int ONEHAND_SLASH_HALBERD_ANIMATION = 440;
	public static final int ONEHAND_SLASH_SWORD_ANIMATION = 390;
	public static final int ONEHAND_STAB_SWORD_ANIMATION = 386;
	public static final int HIGH_LEVEL_MAGIC_ATTACK = 1167;
	public static final int HUNLEFF_TORNADO = 8418;
	public boolean isFirstPlayerPhase = true;

	private static final List<Integer> MELEE_ANIM_IDS = List.of(
		ONEHAND_STAB_SWORD_ANIMATION, ONEHAND_SLASH_SWORD_ANIMATION,
		ONEHAND_SLASH_AXE_ANIMATION, ONEHAND_CRUSH_PICKAXE_ANIMATION,
		ONEHAND_CRUSH_AXE_ANIMATION, UNARMED_PUNCH_ANIMATION,
		UNARMED_KICK_ANIMATION, ONEHAND_STAB_HALBERD_ANIMATION,
		ONEHAND_SLASH_HALBERD_ANIMATION
	);
	private static final List<Integer> MELEE_WEAPONS = List.of(
			ItemID.CORRUPTED_HALBERD_BASIC, ItemID.CORRUPTED_HALBERD_ATTUNED,
			ItemID.CORRUPTED_HALBERD_PERFECTED, ItemID.CRYSTAL_HALBERD_BASIC, ItemID.CRYSTAL_HALBERD_ATTUNED,
			ItemID.CRYSTAL_HALBERD_PERFECTED
	);

	private static final List<Integer> RANGE_WEAPONS = List.of(
			ItemID.CORRUPTED_BOW_BASIC, ItemID.CORRUPTED_BOW_ATTUNED,
			ItemID.CORRUPTED_BOW_PERFECTED, ItemID.CRYSTAL_BOW_BASIC, ItemID.CRYSTAL_BOW_ATTUNED,
			ItemID.CRYSTAL_BOW_PERFECTED
	);

	private static final List<Integer> MAGE_WEAPONS = List.of(
			ItemID.CORRUPTED_STAFF_BASIC, ItemID.CORRUPTED_STAFF_ATTUNED,
			ItemID.CORRUPTED_STAFF_PERFECTED, ItemID.CRYSTAL_STAFF_BASIC,
			ItemID.CRYSTAL_STAFF_ATTUNED, ItemID.CRYSTAL_STAFF_PERFECTED
	);

	private static final List<Integer> POTIONS= List.of(
			ItemID.EGNIOL_POTION_1, ItemID.EGNIOL_POTION_2, ItemID.EGNIOL_POTION_3, ItemID.EGNIOL_POTION_4
	);

	private static final Set<Integer> FOOD = Set.of(
			ItemID.PADDLEFISH
	);
	private static final List<Integer> TICK_FOOD = List.of(
			ItemID.CRYSTAL_PADDLEFISH, ItemID.CORRUPTED_PADDLEFISH
	);

	private static final Set<Integer> ATTACK_ANIM_IDS = new HashSet<>();

	static
	{
		ATTACK_ANIM_IDS.addAll(MELEE_ANIM_IDS);
		ATTACK_ANIM_IDS.add(BOW_ATTACK_ANIMATION);
		ATTACK_ANIM_IDS.add(HIGH_LEVEL_MAGIC_ATTACK);
	}

	private static final Set<Integer> PROJECTILE_MAGIC_IDS = Set.of(
		ProjectileID.HUNLLEF_MAGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_MAGE_ATTACK
	);

	private static final Set<Integer> PROJECTILE_RANGE_IDS = Set.of(
		ProjectileID.HUNLLEF_RANGE_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_RANGE_ATTACK
	);

	private static final Set<Integer> PROJECTILE_PRAYER_IDS = Set.of(
		ProjectileID.HUNLLEF_PRAYER_ATTACK, ProjectileID.HUNLLEF_CORRUPTED_PRAYER_ATTACK
	);

	private static final Set<Integer> PROJECTILE_IDS = new HashSet<>();

	static
	{
		PROJECTILE_IDS.addAll(PROJECTILE_MAGIC_IDS);
		PROJECTILE_IDS.addAll(PROJECTILE_RANGE_IDS);
		PROJECTILE_IDS.addAll(PROJECTILE_PRAYER_IDS);
	}

	private static final Set<Integer> HUNLLEF_IDS = Set.of(
		NpcID.CRYSTALLINE_HUNLLEF, NpcID.CRYSTALLINE_HUNLLEF_9022,
		NpcID.CRYSTALLINE_HUNLLEF_9023, NpcID.CRYSTALLINE_HUNLLEF_9024,
		NpcID.CORRUPTED_HUNLLEF, NpcID.CORRUPTED_HUNLLEF_9036,
		NpcID.CORRUPTED_HUNLLEF_9037, NpcID.CORRUPTED_HUNLLEF_9038
	);

	private static final Set<Integer> TORNADO_IDS = Set.of(NullNpcID.NULL_9025, NullNpcID.NULL_9039);

	private static final Set<Integer> DEMIBOSS_IDS = Set.of(
		NpcID.CRYSTALLINE_BEAR, NpcID.CORRUPTED_BEAR,
		NpcID.CRYSTALLINE_DARK_BEAST, NpcID.CORRUPTED_DARK_BEAST,
		NpcID.CRYSTALLINE_DRAGON, NpcID.CORRUPTED_DRAGON
	);

	private static final Set<Integer> STRONG_NPC_IDS = Set.of(
		NpcID.CRYSTALLINE_SCORPION, NpcID.CORRUPTED_SCORPION,
		NpcID.CRYSTALLINE_UNICORN, NpcID.CORRUPTED_UNICORN,
		NpcID.CRYSTALLINE_WOLF, NpcID.CORRUPTED_WOLF
	);

	private static final Set<Integer> WEAK_NPC_IDS = Set.of(
		NpcID.CRYSTALLINE_BAT, NpcID.CORRUPTED_BAT,
		NpcID.CRYSTALLINE_RAT, NpcID.CORRUPTED_RAT,
		NpcID.CRYSTALLINE_SPIDER, NpcID.CORRUPTED_SPIDER
	);

	private static final Set<Integer> RESOURCE_IDS = Set.of(
		ObjectID.CRYSTAL_DEPOSIT, ObjectID.CORRUPT_DEPOSIT,
		ObjectID.PHREN_ROOTS, ObjectID.PHREN_ROOTS_36066,
		ObjectID.FISHING_SPOT_36068, ObjectID.FISHING_SPOT_35971,
		ObjectID.GRYM_ROOT, ObjectID.GRYM_ROOT_36070,
		ObjectID.LINUM_TIRINUM, ObjectID.LINUM_TIRINUM_36072
	);

	private static final Set<Integer> UTILITY_IDS = Set.of(
		ObjectID.SINGING_BOWL_35966, ObjectID.SINGING_BOWL_36063,
		ObjectID.RANGE_35980, ObjectID.RANGE_36077,
		ObjectID.WATER_PUMP_35981, ObjectID.WATER_PUMP_36078
	);

	private Client client = Main.INSTANCE.getClient();
	private ClientThread clientThread = ClientThread.INSTANCE;
	public GauntletExtendedConfig config = (GauntletExtendedConfig) javaConfiguration(GauntletExtendedConfig.class);
	private ResourceManager resourceManager = new ResourceManager(this, config);
	private SkillIconManager skillIconManager = SkillIconManager.INSTANCE;
	private OverlayManager overlayManager = OverlayManager.INSTANCE;
	private ModelOutlineRenderer renderer = new ModelOutlineRenderer();
	private OverlayTimer overlayTimer = new OverlayTimer(this, config);
	private OverlayGauntlet overlayGauntlet = new OverlayGauntlet(this, config, renderer);
	private OverlayHunllef overlayHunllef = new OverlayHunllef(this, config, renderer);
	private OverlayPrayerWidget overlayPrayerWidget = new OverlayPrayerWidget(this, config);
	private OverlayPrayerBox overlayPrayerBox = new OverlayPrayerBox(this, config);

	private Set<Overlay> overlays;

	@Getter
	private final Set<Resource> resources = new HashSet<>();

	@Getter
	private final Set<GameObject> utilities = new HashSet<>();

	@Getter
	private final Set<Tornado> tornadoes = new HashSet<>();

	@Getter
	private final Set<Demiboss> demibosses = new HashSet<>();

	@Getter
	private final Set<NPC> strongNpcs = new HashSet<>();

	@Getter
	private final Set<NPC> weakNpcs = new HashSet<>();

	private final List<Set<?>> entitySets = Arrays.asList(resources, utilities, tornadoes, demibosses, strongNpcs, weakNpcs);

	@Getter
	private Missile missile;

	@Getter
	private Hunllef hunllef;

	@Getter
	@Setter
	private boolean wrongAttackStyle;

	@Getter
	@Setter
	private boolean switchWeapon;

	private boolean inGauntlet;
	private boolean inHunllef;

	@Override
	public void onStart()
	{
		if (overlays == null)
		{
			overlays = Set.of(overlayTimer, overlayGauntlet, overlayHunllef, overlayPrayerWidget, overlayPrayerBox);
		}

		if (client.getGameState() == GameState.LOGGED_IN)
		{
			clientThread.invoke(this::pluginEnabled);
		}
	}

	@Override
	public void onStop()
	{
		if (overlays != null)
			overlays.forEach(o -> overlayManager.remove(o));

		inGauntlet = false;
		inHunllef = false;

		hunllef = null;
		missile = null;
		wrongAttackStyle = false;
		switchWeapon = false;

		overlayTimer.reset();
		resourceManager.reset();

		entitySets.forEach(Set::clear);
	}

	@Override
	public void onConfigChanged(final ConfigChanged event)
	{
		if (!event.getGroup().equals("gauntlet"))
		{
			return;
		}

		switch (event.getKey())
		{
			case "resourceIconSize":
				if (!resources.isEmpty())
				{
					resources.forEach(r -> r.setIconSize(config.resourceIconSize()));
				}
				break;
			case "resourceTracker":
				if (inGauntlet && !inHunllef)
				{
					resourceManager.reset();
					resourceManager.init();
				}
				break;
			case "projectileIconSize":
				if (missile != null)
				{
					missile.setIconSize(config.projectileIconSize());
				}
				break;
			case "hunllefAttackStyleIconSize":
				if (hunllef != null)
				{
					hunllef.setIconSize(config.hunllefAttackStyleIconSize());
				}
				break;
			case "mirrorMode":
				overlays.forEach(overlay -> {
					overlay.determineLayer();

					if (overlayManager.anyMatch(o -> o == overlay))
					{
						overlayManager.remove(overlay);
						overlayManager.add(overlay);
					}
				});
				break;
			default:
				break;
		}
	}

	@Override
	public void onVarbitChanged(final VarbitChanged event)
	{
		if (isHunllefVarbitSet())
		{
			if (!inHunllef)
			{
				initHunllef();
			}
		}
		else if (isGauntletVarbitSet())
		{
			if (!inGauntlet)
			{
				initGauntlet();
			}
		}
		else
		{
			if (inGauntlet || inHunllef)
			{
				onStop();
			}
		}
	}

	@Override
	public void onGameTick(final GameTick event) {
		if (hunllef == null) {
			return;
		}

		hunllef.decrementTicksUntilNextAttack();

		if (missile != null && missile.getProjectile().getRemainingCycles() <= 0) {
			missile = null;
		}

		if (!tornadoes.isEmpty()) {
			tornadoes.forEach(Tornado::updateTimeLeft);
		}
		if (config.autoPray() && hunllef != null && inHunllef && !client
				.isPrayerActive(hunllef.getAttackPhase().getPrayer())) {
			activatePrayer(hunllef.getAttackPhase().getPrayer());
		}
		else if (inHunllef && hunllef.getNpc().getComposition().getOverheadIcon() == HeadIcon.MAGIC && isItemEquipped(MAGE_WEAPONS)) {
			if (getItems(RANGE_WEAPONS) != null) {
				rangeWeapon();
			} else if (getItems(MELEE_WEAPONS) != null) {
				meleeWeapon();
			}

		}
		else if (inHunllef && hunllef.getNpc().getComposition().getOverheadIcon() == HeadIcon.MELEE && isItemEquipped(MELEE_WEAPONS)) {
			if (getItems(MAGE_WEAPONS) != null) {
				mageWeapon();
			} else if (getItems(RANGE_WEAPONS) != null) {
				rangeWeapon();
			}

		}
		else if (inHunllef && hunllef.getNpc().getComposition().getOverheadIcon() == HeadIcon.RANGED && isItemEquipped(RANGE_WEAPONS)) {
			if (getItems(MELEE_WEAPONS) != null) {
				meleeWeapon();
			} else if (getItems(MAGE_WEAPONS) != null) {
				mageWeapon();
			}

		}
		if (isItemEquipped(RANGE_WEAPONS) && config.offensivePrayerToggle() && inHunllef) {
			activatePrayer(config.rangeoffensivePrayer().getPrayer());
		}
		else if (isItemEquipped(MAGE_WEAPONS) && config.offensivePrayerToggle() && inHunllef) {
			activatePrayer(config.magicoffensivePrayer().getPrayer());
		}
		else if (isItemEquipped(MELEE_WEAPONS) && config.offensivePrayerToggle() && inHunllef) {
			activatePrayer(config.meleeoffensivePrayer().getPrayer());
		}
		int currentPrayerPoints = client.getBoostedSkillLevel(Skill.PRAYER);
		int nextRestoreVal = 10;
		if (config.potionToggle() && currentPrayerPoints <= nextRestoreVal) {
			drinkPotion();
		}
		int currentHitpoints = client.getBoostedSkillLevel(Skill.HITPOINTS);
		int nextTickHeal = 20;
		if (config.autoTickEatToggle() && currentHitpoints <= nextTickHeal){
			autoEat();
			autoTickEat();
		}
	}

	private Object getItems(Collection<Integer> ids) {
		var array = ids.stream().mapToInt(i -> i).toArray();
		return Items.INSTANCE.getFirst(array, InventoryID.INVENTORY);
	}

	@Override
	public void onGameStateChanged(final GameStateChanged event)
	{
		switch (event.getGameState())
		{
			case LOADING:
				resources.clear();
				utilities.clear();
				break;
			case LOGIN_SCREEN:
			case HOPPING:
				onStop();
				break;
		}
	}

	@Override
	public void onWidgetLoaded(final WidgetLoaded event)
	{
		if (event.getGroupId() == WidgetID.GAUNTLET_TIMER_GROUP_ID)
		{
			overlayTimer.setGauntletStart();
			resourceManager.init();
		}
	}

	@Override
	public void onGameObjectSpawned(final GameObjectSpawned event)
	{
		final GameObject gameObject = event.getGameObject();

		final int id = gameObject.getId();

		if (RESOURCE_IDS.contains(id))
		{
			resources.add(new Resource(gameObject, skillIconManager, config.resourceIconSize()));
		}
		else if (UTILITY_IDS.contains(id))
		{
			utilities.add(gameObject);
		}
	}

	@Override
	public void onGameObjectDespawned(final GameObjectDespawned event)
	{
		final GameObject gameObject = event.getGameObject();

		final int id = gameObject.getId();

		if (RESOURCE_IDS.contains(gameObject.getId()))
		{
			resources.removeIf(o -> o.getGameObject() == gameObject);
		}
		else if (UTILITY_IDS.contains(id))
		{
			utilities.remove(gameObject);
		}
	}

	@Override
	public void onNpcSpawned(final NpcSpawned event)
	{
		final NPC npc = event.getNpc();

		final int id = npc.getId();

		if (HUNLLEF_IDS.contains(id))
		{
			hunllef = new Hunllef(npc, skillIconManager, config.hunllefAttackStyleIconSize(), this);
		}
		else if (TORNADO_IDS.contains(id))
		{
			tornadoes.add(new Tornado(npc));
		}
		else if (DEMIBOSS_IDS.contains(id))
		{
			demibosses.add(new Demiboss(npc));
		}
		else if (STRONG_NPC_IDS.contains(id))
		{
			strongNpcs.add(npc);
		}
		else if (WEAK_NPC_IDS.contains(id))
		{
			weakNpcs.add(npc);
		}
	}

	@Override
	public void onNpcDespawned(final NpcDespawned event)
	{
		final NPC npc = event.getNpc();

		final int id = npc.getId();

		if (HUNLLEF_IDS.contains(id))
		{
			hunllef = null;
		}
		else if (TORNADO_IDS.contains(id))
		{
			tornadoes.removeIf(t -> t.getNpc() == npc);
		}
		else if (DEMIBOSS_IDS.contains(id))
		{
			demibosses.removeIf(d -> d.getNpc() == npc);
		}
		else if (STRONG_NPC_IDS.contains(id))
		{
			strongNpcs.remove(npc);
		}
		else if (WEAK_NPC_IDS.contains(id))
		{
			weakNpcs.remove(npc);
		}
	}

	@Override
	public void onProjectileSpawned(final ProjectileSpawned event)
	{
		if (hunllef == null)
		{
			return;
		}

		final Projectile projectile = event.getProjectile();

		final int id = projectile.getId();

		if (!PROJECTILE_IDS.contains(id))
		{
			return;
		}

		missile = new Missile(projectile, skillIconManager, config.projectileIconSize());

		hunllef.updateAttackCount();

		if (PROJECTILE_PRAYER_IDS.contains(id) && config.hunllefPrayerAudio())
		{
			client.playSoundEffect(SoundEffectID.MAGIC_SPLASH_BOING);
		}
	}

	@Override
	public void onChatMessage(final ChatMessage event)
	{
		final ChatMessageType type = event.getType();

		if (type == ChatMessageType.SPAM || type == ChatMessageType.GAMEMESSAGE)
		{
			resourceManager.parseChatMessage(event.getMessage());
		}
	}

	@Override
	public void onActorDeath(final ActorDeath event)
	{
		if (event.getActor() != client.getLocalPlayer())
		{
			return;
		}

		overlayTimer.onPlayerDeath();
	}

	@Override
	public void onAnimationChanged(final AnimationChanged event)
	{
		if (!isHunllefVarbitSet() || hunllef == null)
		{
			return;
		}

		final Actor actor = event.getActor();

		final int animationId = actor.getAnimation();

		if (actor instanceof Player)
		{
			if (!ATTACK_ANIM_IDS.contains(animationId))
			{
				return;
			}

			final boolean validAttack = isAttackAnimationValid(animationId);

			if (validAttack)
			{
				wrongAttackStyle = false;
				hunllef.updatePlayerAttackCount();

				if (hunllef.getPlayerAttackCount() == 1)
				{
					switchWeapon = true;
				}
			}
			else
			{
				wrongAttackStyle = true;
			}
		}
		else if (actor instanceof NPC)
		{
			if (animationId == HUNLEFF_TORNADO)
			{
				hunllef.updateAttackCount();
			}
		}
	}


	private boolean isAttackAnimationValid(final int animationId)
	{
		final HeadIcon headIcon = hunllef.getNpc().getComposition().getOverheadIcon();

		if (headIcon == null)
		{
			return true;
		}

		switch (headIcon)
		{
			case MELEE:
				if (MELEE_ANIM_IDS.contains(animationId))
				{
					return false;
				}
				break;
			case RANGED:
				if (animationId == BOW_ATTACK_ANIMATION)
				{
					return false;
				}
				break;
			case MAGIC:
				if (animationId == HIGH_LEVEL_MAGIC_ATTACK)
				{
					return false;
				}
				break;
		}

		return true;
	}

	private void pluginEnabled()
	{
		if (isGauntletVarbitSet())
		{
			overlayTimer.setGauntletStart();
			resourceManager.init();
			addSpawnedEntities();
			initGauntlet();
		}

		if (isHunllefVarbitSet())
		{
			initHunllef();
		}
	}

	private void addSpawnedEntities()
	{
		for (final GameObject gameObject : new GameObjectQuery().result(client))
		{
			GameObjectSpawned gameObjectSpawned = new GameObjectSpawned(null, gameObject);
			onGameObjectSpawned(gameObjectSpawned);
		}

		for (final NPC npc : client.getNpcs())
		{
			onNpcSpawned(new NpcSpawned(npc));
		}
	}

	private void initGauntlet()
	{
		inGauntlet = true;

		overlayManager.add(overlayTimer);
		overlayManager.add(overlayGauntlet);
	}
	private void initHunllef()
	{
		inHunllef = true;

		overlayTimer.setHunllefStart();
		resourceManager.reset();

		overlayManager.remove(overlayGauntlet);
		overlayManager.add(overlayHunllef);
		overlayManager.add(overlayPrayerWidget);
		overlayManager.add(overlayPrayerBox);
	}
	public void activatePrayer(Prayer prayer)
	{
		if (prayer == null)
		{
			return;
		}

		//check if prayer is already active this tick
		if (client.isPrayerActive(prayer))
		{
			return;
		}

		WidgetInfo widgetInfo = prayer.getWidgetInfo();

		if (widgetInfo == null)
		{
			return;
		}
		Widget prayer_widget = client.getWidget(widgetInfo);

		if (prayer_widget == null)
		{
			return;
		}

		if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0)
		{
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
	public void meleeWeapon() {
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null) {
			return;
		}

		for (int mw: MELEE_WEAPONS) {
			var mi = Items.INSTANCE.getFirst(InventoryID.INVENTORY, mw);
			if (mi != null)
				mi.interact("Wield");
		}
	}
	public void rangeWeapon() {
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null) {
			return;
		}

		for (int rw: RANGE_WEAPONS) {
			var ri = Items.INSTANCE.getFirst(InventoryID.INVENTORY, rw);
			if (ri != null)
				ri.interact("Wield");
		}
	}

	public void mageWeapon() {
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null) {
			return;
		}

		for (int mw: MAGE_WEAPONS) {
			var mi = Items.INSTANCE.getFirst(InventoryID.INVENTORY, mw);
			if (mi != null)
				mi.interact("Wield");
		}
	}
	public void drinkPotion() {
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null) {
			return;
		}
		for (int potion: POTIONS) {
			var item = Items.INSTANCE.getFirst(InventoryID.INVENTORY, potion);
			if (item != null)
				item.interact("Drink");
		}


	}

	public void autoEat() {
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null) {
			return;
		}

		Item item = Items.INSTANCE.getFirst(InventoryID.INVENTORY, ItemID.PADDLEFISH);
		if (item != null)
			item.interact("Eat");

	}

	public void autoTickEat() {
		Widget inventory = client.getWidget(WidgetInfo.INVENTORY);

		if (inventory == null) {
			return;
		}

		for (int food: TICK_FOOD) {
			var item = Items.INSTANCE.getFirst(InventoryID.INVENTORY, food);
			if (item != null)
				item.interact("Eat");
		}

	}

	/*WidgetItem getItems(Collection<Integer> ids)
	{
		Widget inventoryWidget = client.getWidget(WidgetInfo.INVENTORY);
		List<WidgetItem> matchedItems = new ArrayList<>();

		if (inventoryWidget != null)
		{
			Collection<WidgetItem> items = inventoryWidget.getWidgetItems();
			for (WidgetItem item : items)
			{
				if (ids.contains(item.getWidget().getItemId()))
				{
					return item;
				}
			}
		}
		return null;
	}*/
	public boolean isItemEquipped(Collection<Integer> itemIds) {
		assert client.isClientThread();

		ItemContainer equipmentContainer = client.getItemContainer(InventoryID.EQUIPMENT);
		if (equipmentContainer != null) {
			Item[] items = equipmentContainer.getItems();
				for (Item item : items) {
				if (item == null) continue;
				if (itemIds.contains(item.getId())) {
					return true;
				}
			}
		}
		return false;
	}
	private boolean isGauntletVarbitSet()
	{
		return client.getVarbitValue(9178) == 1;
	}

	private boolean isHunllefVarbitSet()
	{
		return client.getVarbitValue(9177) == 1;
	}
}
