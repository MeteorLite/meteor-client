package meteor.plugins

import eventbus.Events
import eventbus.events.*
import meteor.events.InfoBoxMenuClicked
import meteor.events.PluginChanged
import net.runelite.api.events.OverheadPrayerChanged
import net.runelite.api.events.OverheadTextChanged
import org.rationalityfrontline.kevent.KEventSubscriber
import org.rationalityfrontline.kevent.unsubscribeAll
import org.rationalityfrontline.kevent.subscribe as kSubscribe

open class EventSubscriber : KEventSubscriber {
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
    open fun onPacketSent(it: PacketSent) {}
    open fun onNpcActionChanged(it: NpcActionChanged) {}
    open fun onMenuOptionClicked(it: MenuOptionClicked) {}
    open fun onMenuOpened(it: MenuOpened) {}
    open fun onMenuEntryAdded(it: MenuEntryAdded) {}
    open fun onLoginStateChanged(it: LoginStateChanged) {}
    open fun onItemQuantityChanged(it: ItemQuantityChanged) {}
    open fun onItemObtained(it: ItemObtained) {}
    open fun onItemContainerChanged(it: ItemContainerChanged) {}
    open fun onInvokeMenuAction(it: InvokeMenuAction) {}
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

    fun subscribe() {
        subscribe<GameStateChanged>(Events.GAME_STATE_CHANGED) { onGameStateChanged(it) }
        subscribe<MenuShouldLeftClick>(Events.MENU_SHOULD_LEFT_CLICK) { onMenuShouldLeftClick(it) }
        subscribe<ActorDeath>(Events.ACTOR_DEATH) { onActorDeath(it) }
        subscribe<AnimationChanged>(Events.ANIMATION_CHANGED) { onAnimationChanged(it) }
        subscribe<AreaSoundEffectPlayed>(Events.AREA_SOUND_EFFECT_PLAYED) { onAreaSoundEffectPlayed(it) }
        subscribe<BeforeRender>(Events.BEFORE_RENDER) { onBeforeRender(it) }
        subscribe<BeforeMenuRender>(Events.BEFORE_MENU_RENDER) { onBeforeMenuRender(it) }
        subscribe<CanvasSizeChanged>(Events.CANVAS_SIZE_CHANGED) { onCanvasSizeChanged(it) }
        subscribe<ChatMessage>(Events.CHAT_MESSAGE) { onChatMessage(it) }
        subscribe<ClanChannelChanged>(Events.CLAN_CHANNEL_CHANGED) { onClanChannelChanged(it) }
        subscribe<ClanMemberJoined>(Events.CLAN_CHANNEL_CHANGED) { onClanMemberJoined(it) }
        subscribe<ClanMemberLeft>(Events.CLAN_MEMBER_LEFT) { onClanMemberLeft(it) }
        subscribe<ClientLoaded>(Events.CLIENT_LOADED) { onClientLoaded(it) }
        subscribe<ClientTick>(Events.CLIENT_TICK) { onClientTick(it) }
        subscribe<ConfigChanged>(Events.CONFIG_CHANGED) { onConfigChanged(it) }
        subscribe<DecorativeObjectChanged>(Events.DECORATIVE_OBJECT_CHANGED) { onDecorativeObjectChanged(it) }
        subscribe<DecorativeObjectDespawned>(Events.DECORATIVE_OBJECT_DESPAWNED) { onDecorativeObjectDespawned(it) }
        subscribe<DecorativeObjectSpawned>(Events.DECORATIVE_OBJECT_SPAWNED) { onDecorativeObjectSpawned(it) }
        subscribe<DialogProcessed>(Events.DIALOG_PROCESSED) { onDialogProcessed(it) }
        subscribe<DynamicObjectAnimationChanged>(Events.DYNAMIC_OBJECT_ANIMATION_CHANGED) { onDynamicObjectAnimationChanged(it) }
        subscribe<ExperienceGained>(Events.EXPERIENCE_GAINED) { onExperienceGained(it) }
        subscribe<FocusChanged>(Events.FOCUS_CHANGED) { onFocusChanged(it) }
        subscribe<GameObjectChanged>(Events.GAME_OBJECT_CHANGED) { onGameObjectChanged(it) }
        subscribe<GameObjectDespawned>(Events.GAME_OBJECT_DESPAWNED) { onGameObjectDespawned(it) }
        subscribe<GameObjectSpawned>(Events.GAME_OBJECT_SPAWNED) { onGameObjectSpawned(it) }
        subscribe<GameStateChanged>(Events.GAME_STATE_CHANGED) { onGameStateChanged(it) }
        subscribe<GameTick>(Events.GAME_TICK) { onGameTick(it) }
        subscribe<GrandExchangeOfferChanged>(Events.GRAND_EXCHANGE_OFFER_CHANGED) { onGrandExchangeOfferChanged(it) }
        subscribe<GraphicsObjectCreated>(Events.GRAPHICS_OBJECT_CREATED) { onGraphicsObjectCreated(it) }
        subscribe<GroundObjectChanged>(Events.GROUND_OBJECT_CHANGED) { onGroundObjectChanged(it) }
        subscribe<GroundObjectDespawned>(Events.GROUND_OBJECT_DESPAWNED) { onGroundObjectDespawned(it) }
        subscribe<GroundObjectSpawned>(Events.GROUND_OBJECT_SPAWNED) { onGroundObjectSpawned(it) }
        subscribe<HealthBarUpdated>(Events.HEALTH_BAR_UPDATED) { onHealthBarUpdated(it) }
        subscribe<InteractingChanged>(Events.INTERACTING_CHANGED) { onInteractingChanged(it) }
        subscribe<InventoryChanged>(Events.INVENTORY_CHANGED) { onInventoryChanged(it) }
        subscribe<InvokeMenuAction>(Events.INVOKE_MENU_ACTION) { onInvokeMenuAction(it) }
        subscribe<ItemContainerChanged>(Events.ITEM_CONTAINER_CHANGED) { onItemContainerChanged(it) }
        subscribe<ItemDespawned>(Events.ITEM_DESPAWNED) { onItemDespawned(it) }
        subscribe<ItemObtained>(Events.ITEM_OBAINED) { onItemObtained(it) }
        subscribe<ItemQuantityChanged>(Events.ITEM_QUANTITY_CHANGED) { onItemQuantityChanged(it) }
        subscribe<ItemSpawned>(Events.ITEM_SPAWNED) { onItemSpawned(it) }
        subscribe<LoginStateChanged>(Events.LOGIN_STATE_CHANGED) { onLoginStateChanged(it) }
        subscribe<MenuEntryAdded>(Events.MENU_ENTRY_ADDED) { onMenuEntryAdded(it) }
        subscribe<MenuOpened>(Events.MENU_OPENED) { onMenuOpened(it) }
        subscribe<MenuOptionClicked>(Events.MENU_OPTION_CLICKED) { onMenuOptionClicked(it) }
        subscribe<NpcActionChanged>(Events.NPC_ACTION_CHANGED) { onNpcActionChanged(it) }
        subscribe<NpcChanged>(Events.NPC_CHANGED) { onNpcChanged(it) }
        subscribe<NpcDespawned>(Events.NPC_DESPAWNED) { onNpcDespawned(it) }
        subscribe<NpcSpawned>(Events.NPC_SPAWNED) { onNpcSpawned(it) }
        subscribe<PacketSent>(Events.PACKET_SENT) { onPacketSent(it) }
        subscribe<OverheadTextChanged>(Events.OVERHEAD_TEXT_CHANGED) { onOverheadTextChanged(it) }
        subscribe<OverheadPrayerChanged>(Events.OVERHEAD_PRAYER_CHANGED) { onOverheadPrayerChanged(it) }
        subscribe<PlayerDespawned>(Events.PLAYER_DESPAWNED) { onPlayerDespawned(it) }
        subscribe<PlayerMenuOptionsChanged>(Events.PLAYER_MENU_OPTIONS_CHANGED) { onPlayerMenuOptionsChanged(it) }
        subscribe<PlayerSkullChanged>(Events.PLAYER_SKULL_CHANGED) { onPlayerSkullChanged(it) }
        subscribe<PlayerSpawned>(Events.PLAYER_SPAWNED) { onPlayerSpawned(it) }
        subscribe<PostItemComposition>(Events.POST_ITEM_COMPOSITION) { onPostItemComposition(it) }
        subscribe<ProjectileMoved>(Events.PROJECTILE_MOVED) { onProjectileMoved(it) }
        subscribe<ProjectileSpawned>(Events.PROJECTILE_MOVED) { onProjetileSpawned(it) }
        subscribe<ResizeableChanged>(Events.RESIZEABLE_CHANGED) { onResizeableChanged(it) }
        subscribe<ScriptCallbackEvent>(Events.SCRIPT_CALLBACK) { onScriptCallbackEvent(it) }
        subscribe<ScriptPostFired>(Events.SCRIPT_POST_FIRED) { onScriptPostFired(it) }
        subscribe<ScriptPreFired>(Events.SCRIPT_PRE_FIRED) { onScriptPreFired(it) }
        subscribe<SoundEffectPlayed>(Events.SOUND_EFFECT_PLAYED) { onSoundEffectPlayed(it) }
        subscribe<StatChanged>(Events.STAT_CHANGED) { onStatChanged(it) }
        subscribe<VarbitChanged>(Events.VARBIT_CHANGED) { onVarbitChanged(it) }
        subscribe<WallObjectChanged>(Events.WALL_OBJECT_CHANGED) { onWallObjectChanged(it) }
        subscribe<WallObjectDespawned>(Events.WALL_OBJECT_DESPAWNED) { onWallObjectDespawned(it) }
        subscribe<WallObjectSpawned>(Events.WALL_OBJECT_SPAWNED) { onWallObjectSpawned(it) }
        subscribe<WidgetHiddenChanged>(Events.WIDGET_HIDDEN_CHANGED) { onWidgetHiddenChanged(it) }
        subscribe<WidgetLoaded>(Events.WIDGET_LOADED) { onWidgetLoaded(it) }
        subscribe<WidgetPositioned>(Events.WIDGET_POSITIONED) { onWidgetPositioned(it) }
        subscribe<WidgetPressed>(Events.WIDGET_PRESSED) { onWidgetPressed(it) }
        subscribe<WorldListLoad>(Events.WORLD_LIST_LOAD) { onWorldListLoad(it) }
        subscribe<NpcSpawned>(Events.NPC_SPAWNED) { onNPCSpawned(it) }
        subscribe<NpcDespawned>(Events.NPC_DESPAWNED) { onNPCDespawned(it) }
        subscribe<PluginChanged>(Events.PLANE_CHANGED) { onPluginChanged(it) }
        subscribe<InfoBoxMenuClicked>(meteor.events.Events.INFO_BOX_MENU_CLICKED) { onInfoBoxMenuClicked(it) }
    }


    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    val tag = generateTag()

    fun unregisterSubscribers() {
        if (!unsubscribeAll())
            throw RuntimeException("Failed to unregister Plugin")
    }

    private inline fun <reified T : Any> subscribe(type: Enum<*>, noinline unit: (T) -> Unit) {
        kSubscribe<T>(type) { event -> unit.invoke(event.data) }
    }

    private fun generateTag(): String {
        while (true) {
            val r = (1..40)
                .map { i -> kotlin.random.Random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("");
            if (!tags.contains(r))
                return r
        }
    }

    companion object {
        var tags = ArrayList<String>()
    }
}