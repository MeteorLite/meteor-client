package meteor.plugins

import dev.hoot.api.events.AutomatedMenu
import eventbus.Events
import eventbus.events.*
import meteor.events.InfoBoxMenuClicked
import meteor.events.PluginChanged
import org.rationalityfrontline.kevent.KEventSubscriber
import org.rationalityfrontline.kevent.subscribe as kSubscribe

open class EventSubscriber : KEventSubscriber {
    var eventListening: Boolean = false

    open fun onMenuShouldLeftClick(it: MenuShouldLeftClick) {}
    open fun onWorldListLoad(it: WorldListLoad) {}
    open fun onWidgetPressed(it: WidgetPressed) {}
    open fun onWidgetPositioned(it: WidgetPositioned) {}
    open fun onWidgetLoaded(it: WidgetLoaded) {}
    open fun onWidgetHiddenChanged(it: WidgetHiddenChanged) {}
    open fun onVarbitChanged(it: VarbitChanged) {}
    open fun onSoundEffectPlayed(it: SoundEffectPlayed) {}
    open fun onScriptPreFired(it: ScriptPreFired) {}
    open fun onScriptPostFired(it: ScriptPostFired) {}
    open fun onScriptCallbackEvent(it: ScriptCallbackEvent) {}
    open fun onResizeableChanged(it: ResizeableChanged) {}
    open fun onProjetileSpawned(it: ProjectileSpawned) {}
    open fun onStatChanged(it: StatChanged) {}
    open fun onPlayerSpawned(it: PlayerSpawned) {}
    open fun onPlayerSkullChanged(it: PlayerSkullChanged) {}
    open fun onPlayerMenuOptionsChanged(it: PlayerMenuOptionsChanged) {}
    open fun onPlayerDespawned(it: PlayerDespawned) {}
    open fun onOverheadPrayerChanged(it: OverheadPrayerChanged) {}
    open fun onNpcActionChanged(it: NpcActionChanged) {}
    open fun onMenuOptionClicked(it: MenuOptionClicked) {}
    open fun onMenuEntryAdded(it: MenuEntryAdded) {}
    open fun onLoginStateChanged(it: LoginStateChanged) {}
    open fun onItemQuantityChanged(it: ItemQuantityChanged) {}
    open fun onItemObtained(it: ItemObtained) {}
    open fun onItemContainerChanged(it: ItemContainerChanged) {}
    open fun onInventoryChanged(it: InventoryChanged) {}
    open fun onHealthBarUpdated(it: HealthBarUpdated) {}
    open fun onGraphicsObjectCreated(it: GraphicsObjectCreated) {}
    open fun onGrandExchangeOfferChanged(it: GrandExchangeOfferChanged) {}
    open fun onGameTick(it: GameTick) {}
    open fun onFocusChanged(it: FocusChanged) {}
    open fun onExperienceGained(it: ExperienceGained) {}
    open fun onDynamicObjectAnimationChanged(it: DynamicObjectAnimationChanged) {}
    open fun onDialogProcessed(it: DialogProcessed) {}
    open fun onClientTick(it: ClientTick) {}
    open fun onClientLoaded(it: ClientLoaded) {}
    open fun onClanMemberLeft(it: ClanMemberLeft) {}
    open fun onClanMemberJoined(it: ClanMemberJoined) {}
    open fun onClanChannelChanged(it: ClanChannelChanged) {}
    open fun onChatMessage(it: ChatMessage) {}
    open fun onCanvasSizeChanged(it: CanvasSizeChanged) {}
    open fun onBeforeMenuRender(it: BeforeMenuRender) {}
    open fun onAreaSoundEffectPlayed(it: AreaSoundEffectPlayed) {}
    open fun onAnimationChanged(it: AnimationChanged) {}
    open fun onActorDeath(it: ActorDeath) {}
    open fun onGameStateChanged(it: GameStateChanged) {}
    open fun onInteractingChanged(it: InteractingChanged) {}
    open fun onNPCSpawned(it: NpcSpawned) {}
    open fun onNPCDespawned(it: NpcDespawned) {}
    open fun onGameObjectSpawned(it: GameObjectSpawned) {}
    open fun onGameObjectChanged(it: GameObjectChanged) {}
    open fun onGameObjectDespawned(it: GameObjectDespawned) {}
    open fun onGroundObjectSpawned(it: GroundObjectSpawned) {}
    open fun onGroundObjectChanged(it: GroundObjectChanged) {}
    open fun onGroundObjectDespawned(it: GroundObjectDespawned) {}
    open fun onWallObjectSpawned(it: WallObjectSpawned) {}
    open fun onWallObjectChanged(it: WallObjectChanged) {}
    open fun onWallObjectDespawned(it: WallObjectDespawned) {}
    open fun onDecorativeObjectSpawned(it: DecorativeObjectSpawned) {}
    open fun onDecorativeObjectChanged(it: DecorativeObjectChanged) {}
    open fun onDecorativeObjectDespawned(it: DecorativeObjectDespawned) {}
    open fun onItemSpawned(it: ItemSpawned) {}
    open fun onItemDespawned(it: ItemDespawned) {}
    open fun onNpcSpawned(it: NpcSpawned) {}
    open fun onNpcChanged(it: NpcChanged) {}
    open fun onNpcDespawned(it: NpcDespawned) {}
    open fun onProjectileMoved(it: ProjectileMoved) {}
    open fun onConfigChanged(it: ConfigChanged) {}
    open fun onPostItemComposition(it: PostItemComposition) {}
    open fun onBeforeRender(it: BeforeRender) {}
    open fun onPluginChanged(it: PluginChanged) {}
    open fun onInfoBoxMenuClicked(it: InfoBoxMenuClicked) {}
    open fun onOverheadTextChanged(it: OverheadTextChanged) {}
    open fun onInvokeMenuAction(it: AutomatedMenu) {}
    open fun onHitsplatApplied(it: HitsplatApplied) {}

    open fun executeIfListening(unit: () -> (Unit)) {
        if (eventListening)
            unit()
    }

    fun subscribeEvents() {
        subscribeEvent<MenuShouldLeftClick>(Events.MENU_SHOULD_LEFT_CLICK) { executeIfListening { onMenuShouldLeftClick(it) }}
        subscribeEvent<ActorDeath>(Events.ACTOR_DEATH) { executeIfListening { onActorDeath(it) }}
        subscribeEvent<AnimationChanged>(Events.ANIMATION_CHANGED) { executeIfListening { onAnimationChanged(it) }}
        subscribeEvent<AreaSoundEffectPlayed>(Events.AREA_SOUND_EFFECT_PLAYED) { executeIfListening { onAreaSoundEffectPlayed(it) }}
        subscribeEvent<BeforeRender>(Events.BEFORE_RENDER) { executeIfListening { onBeforeRender(it) }}
        subscribeEvent<BeforeMenuRender>(Events.BEFORE_MENU_RENDER) { executeIfListening { onBeforeMenuRender(it) }}
        subscribeEvent<CanvasSizeChanged>(Events.CANVAS_SIZE_CHANGED) { executeIfListening { onCanvasSizeChanged(it) }}
        subscribeEvent<ChatMessage>(Events.CHAT_MESSAGE) { executeIfListening { onChatMessage(it) }}
        subscribeEvent<ClanChannelChanged>(Events.CLAN_CHANNEL_CHANGED) { executeIfListening { onClanChannelChanged(it) }}
        subscribeEvent<ClanMemberJoined>(Events.CLAN_MEMBER_JOINED) { executeIfListening { onClanMemberJoined(it) }}
        subscribeEvent<ClanMemberLeft>(Events.CLAN_MEMBER_LEFT) { executeIfListening { onClanMemberLeft(it) }}
        subscribeEvent<ClientLoaded>(Events.CLIENT_LOADED) { executeIfListening { onClientLoaded(it) }}
        subscribeEvent<ClientTick>(Events.CLIENT_TICK) { executeIfListening { onClientTick(it) }}
        subscribeEvent<ConfigChanged>(Events.CONFIG_CHANGED) { executeIfListening { onConfigChanged(it) }}
        subscribeEvent<DecorativeObjectChanged>(Events.DECORATIVE_OBJECT_CHANGED) { executeIfListening { onDecorativeObjectChanged(it) }}
        subscribeEvent<DecorativeObjectDespawned>(Events.DECORATIVE_OBJECT_DESPAWNED) { executeIfListening { onDecorativeObjectDespawned(it) }}
        subscribeEvent<DecorativeObjectSpawned>(Events.DECORATIVE_OBJECT_SPAWNED) { executeIfListening { onDecorativeObjectSpawned(it) }}
        subscribeEvent<DialogProcessed>(Events.DIALOG_PROCESSED) { executeIfListening { onDialogProcessed(it) }}
        subscribeEvent<DynamicObjectAnimationChanged>(Events.DYNAMIC_OBJECT_ANIMATION_CHANGED) { executeIfListening { onDynamicObjectAnimationChanged(it) }}
        subscribeEvent<ExperienceGained>(Events.EXPERIENCE_GAINED) { executeIfListening { onExperienceGained(it) }}
        subscribeEvent<FocusChanged>(Events.FOCUS_CHANGED) { executeIfListening { onFocusChanged(it) }}
        subscribeEvent<GameObjectChanged>(Events.GAME_OBJECT_CHANGED) { executeIfListening { onGameObjectChanged(it) }}
        subscribeEvent<GameObjectDespawned>(Events.GAME_OBJECT_DESPAWNED) { executeIfListening { onGameObjectDespawned(it) }}
        subscribeEvent<GameObjectSpawned>(Events.GAME_OBJECT_SPAWNED) { executeIfListening { onGameObjectSpawned(it) }}
        subscribeEvent<GameStateChanged>(Events.GAME_STATE_CHANGED) { executeIfListening{ onGameStateChanged(it) }}
        subscribeEvent<GameTick>(Events.GAME_TICK) { executeIfListening { onGameTick(it) }}
        subscribeEvent<GrandExchangeOfferChanged>(Events.GRAND_EXCHANGE_OFFER_CHANGED) { executeIfListening { onGrandExchangeOfferChanged(it) }}
        subscribeEvent<GraphicsObjectCreated>(Events.GRAPHICS_OBJECT_CREATED) { executeIfListening { onGraphicsObjectCreated(it) }}
        subscribeEvent<GroundObjectChanged>(Events.GROUND_OBJECT_CHANGED) { executeIfListening { onGroundObjectChanged(it) }}
        subscribeEvent<GroundObjectDespawned>(Events.GROUND_OBJECT_DESPAWNED) { executeIfListening { onGroundObjectDespawned(it) }}
        subscribeEvent<GroundObjectSpawned>(Events.GROUND_OBJECT_SPAWNED) { executeIfListening { onGroundObjectSpawned(it) }}
        subscribeEvent<HealthBarUpdated>(Events.HEALTH_BAR_UPDATED) { executeIfListening { onHealthBarUpdated(it) }}
        subscribeEvent<InteractingChanged>(Events.INTERACTING_CHANGED) { executeIfListening { onInteractingChanged(it) }}
        subscribeEvent<InventoryChanged>(Events.INVENTORY_CHANGED) { executeIfListening { onInventoryChanged(it) }}
        subscribeEvent<ItemContainerChanged>(Events.ITEM_CONTAINER_CHANGED) { executeIfListening { onItemContainerChanged(it) }}
        subscribeEvent<ItemDespawned>(Events.ITEM_DESPAWNED) { executeIfListening { onItemDespawned(it) }}
        subscribeEvent<ItemObtained>(Events.ITEM_OBTAINED) { executeIfListening { onItemObtained(it) }}
        subscribeEvent<ItemQuantityChanged>(Events.ITEM_QUANTITY_CHANGED) { executeIfListening { onItemQuantityChanged(it) }}
        subscribeEvent<ItemSpawned>(Events.ITEM_SPAWNED) { executeIfListening { onItemSpawned(it) }}
        subscribeEvent<LoginStateChanged>(Events.LOGIN_STATE_CHANGED) { executeIfListening { onLoginStateChanged(it) }}
        subscribeEvent<MenuEntryAdded>(Events.MENU_ENTRY_ADDED) { executeIfListening { onMenuEntryAdded(it) }}
        subscribeEvent<MenuOptionClicked>(Events.MENU_OPTION_CLICKED) { executeIfListening { onMenuOptionClicked(it) }}
        subscribeEvent<NpcActionChanged>(Events.NPC_ACTION_CHANGED) { executeIfListening { onNpcActionChanged(it) }}
        subscribeEvent<NpcChanged>(Events.NPC_CHANGED) { executeIfListening { onNpcChanged(it) }}
        subscribeEvent<NpcDespawned>(Events.NPC_DESPAWNED) { executeIfListening { onNpcDespawned(it) }}
        subscribeEvent<NpcSpawned>(Events.NPC_SPAWNED) { executeIfListening { onNpcSpawned(it) }}
        subscribeEvent<AutomatedMenu>(Events.AUTOMATED_MENU) { executeIfListening { onInvokeMenuAction(it) }}
        subscribeEvent<OverheadTextChanged>(Events.OVERHEAD_TEXT_CHANGED) { executeIfListening { onOverheadTextChanged(it) }}
        subscribeEvent<OverheadPrayerChanged>(Events.OVERHEAD_PRAYER_CHANGED) { executeIfListening { onOverheadPrayerChanged(it) }}
        subscribeEvent<PlayerDespawned>(Events.PLAYER_DESPAWNED) { executeIfListening { onPlayerDespawned(it) }}
        subscribeEvent<PlayerMenuOptionsChanged>(Events.PLAYER_MENU_OPTIONS_CHANGED) { executeIfListening { onPlayerMenuOptionsChanged(it) }}
        subscribeEvent<PlayerSkullChanged>(Events.PLAYER_SKULL_CHANGED) { executeIfListening { onPlayerSkullChanged(it) }}
        subscribeEvent<PlayerSpawned>(Events.PLAYER_SPAWNED) { executeIfListening { onPlayerSpawned(it) }}
        subscribeEvent<PostItemComposition>(Events.POST_ITEM_COMPOSITION) { executeIfListening { onPostItemComposition(it) }}
        subscribeEvent<ProjectileMoved>(Events.PROJECTILE_MOVED) { executeIfListening { onProjectileMoved(it) }}
        subscribeEvent<ProjectileSpawned>(Events.PROJECTILE_SPAWNED) { executeIfListening { onProjetileSpawned(it) }}
        subscribeEvent<ResizeableChanged>(Events.RESIZEABLE_CHANGED) { executeIfListening { onResizeableChanged(it) }}
        subscribeEvent<ScriptCallbackEvent>(Events.SCRIPT_CALLBACK) { executeIfListening { onScriptCallbackEvent(it) }}
        subscribeEvent<ScriptPostFired>(Events.SCRIPT_POST_FIRED) { executeIfListening { onScriptPostFired(it) }}
        subscribeEvent<ScriptPreFired>(Events.SCRIPT_PRE_FIRED) { executeIfListening { onScriptPreFired(it) }}
        subscribeEvent<SoundEffectPlayed>(Events.SOUND_EFFECT_PLAYED) { executeIfListening { onSoundEffectPlayed(it) }}
        subscribeEvent<StatChanged>(Events.STAT_CHANGED) { executeIfListening { onStatChanged(it) }}
        subscribeEvent<VarbitChanged>(Events.VARBIT_CHANGED) { executeIfListening { onVarbitChanged(it) }}
        subscribeEvent<WallObjectChanged>(Events.WALL_OBJECT_CHANGED) { executeIfListening { onWallObjectChanged(it) }}
        subscribeEvent<WallObjectDespawned>(Events.WALL_OBJECT_DESPAWNED) { executeIfListening { onWallObjectDespawned(it) }}
        subscribeEvent<WallObjectSpawned>(Events.WALL_OBJECT_SPAWNED) { executeIfListening { onWallObjectSpawned(it) }}
        subscribeEvent<WidgetHiddenChanged>(Events.WIDGET_HIDDEN_CHANGED) { executeIfListening { onWidgetHiddenChanged(it) }}
        subscribeEvent<WidgetLoaded>(Events.WIDGET_LOADED) { executeIfListening { onWidgetLoaded(it) }}
        subscribeEvent<WidgetPositioned>(Events.WIDGET_POSITIONED) { executeIfListening { onWidgetPositioned(it) }}
        subscribeEvent<WidgetPressed>(Events.WIDGET_PRESSED) { executeIfListening { onWidgetPressed(it) }}
        subscribeEvent<WorldListLoad>(Events.WORLD_LIST_LOAD) { executeIfListening { onWorldListLoad(it) }}
        subscribeEvent<NpcSpawned>(Events.NPC_SPAWNED) { executeIfListening { onNPCSpawned(it) }}
        subscribeEvent<NpcDespawned>(Events.NPC_DESPAWNED) { executeIfListening { onNPCDespawned(it) }}
        subscribeEvent<PluginChanged>(Events.PLUGIN_CHANGED) { executeIfListening { onPluginChanged(it) }}
        subscribeEvent<InfoBoxMenuClicked>(meteor.events.Events.INFO_BOX_MENU_CLICKED) { executeIfListening { onInfoBoxMenuClicked(it) } }
        subscribeEvent<HitsplatApplied>(Events.HITSPLAT_APPLIED) { executeIfListening { onHitsplatApplied(it) } }
    }

    private inline fun <reified T : Any> subscribeEvent(type: Enum<*>, noinline unit: (T) -> Unit) {
        kSubscribe<T>(type) { event -> unit.invoke(event.data) }
    }


    fun unsubscribe() {
        eventListening = false
    }

    fun subscribe() {
        eventListening = true
    }
}