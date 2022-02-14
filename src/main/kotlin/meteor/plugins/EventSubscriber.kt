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
        if (!this::onGameStateChanged.isAbstract) { subscribe<GameStateChanged>(Events.GAME_STATE_CHANGED) { onGameStateChanged(it) } }
        if (!this::onMenuShouldLeftClick.isAbstract) { subscribe<MenuShouldLeftClick>(Events.MENU_SHOULD_LEFT_CLICK) { onMenuShouldLeftClick(it) } }
        if (!this::onActorDeath.isAbstract) { subscribe<ActorDeath>(Events.ACTOR_DEATH) { onActorDeath(it) } }
        if (!this::onAnimationChanged.isAbstract) { subscribe<AnimationChanged>(Events.ANIMATION_CHANGED) { onAnimationChanged(it) } }
        if (!this::onAreaSoundEffectPlayed.isAbstract) { subscribe<AreaSoundEffectPlayed>(Events.AREA_SOUND_EFFECT_PLAYED) { onAreaSoundEffectPlayed(it) } }
        if (!this::onBeforeRender.isAbstract) { subscribe<BeforeRender>(Events.BEFORE_RENDER) { onBeforeRender(it) } }
        if (!this::onBeforeMenuRender.isAbstract) { subscribe<BeforeMenuRender>(Events.BEFORE_MENU_RENDER) { onBeforeMenuRender(it) } }
        if (!this::onCanvasSizeChanged.isAbstract) { subscribe<CanvasSizeChanged>(Events.CANVAS_SIZE_CHANGED) { onCanvasSizeChanged(it) } }
        if (!this::onChatMessage.isAbstract) { subscribe<ChatMessage>(Events.CHAT_MESSAGE) { onChatMessage(it) } }
        if (!this::onClanChannelChanged.isAbstract) { subscribe<ClanChannelChanged>(Events.CLAN_CHANNEL_CHANGED) { onClanChannelChanged(it) } }
        if (!this::onClanMemberJoined.isAbstract) { subscribe<ClanMemberJoined>(Events.CLAN_CHANNEL_CHANGED) { onClanMemberJoined(it) } }
        if (!this::onClanMemberLeft.isAbstract) { subscribe<ClanMemberLeft>(Events.CLAN_MEMBER_LEFT) { onClanMemberLeft(it) } }
        if (!this::onClientLoaded.isAbstract) { subscribe<ClientLoaded>(Events.CLIENT_LOADED) { onClientLoaded(it) } }
        if (!this::onClientTick.isAbstract) { subscribe<ClientTick>(Events.CLIENT_TICK) { onClientTick(it) } }
        if (!this::onConfigChanged.isAbstract) { subscribe<ConfigChanged>(Events.CONFIG_CHANGED) { onConfigChanged(it) } }
        if (!this::onDecorativeObjectChanged.isAbstract) { subscribe<DecorativeObjectChanged>(Events.DECORATIVE_OBJECT_CHANGED) { onDecorativeObjectChanged(it) } }
        if (!this::onDecorativeObjectDespawned.isAbstract) { subscribe<DecorativeObjectDespawned>(Events.DECORATIVE_OBJECT_DESPAWNED) { onDecorativeObjectDespawned(it) } }
        if (!this::onDecorativeObjectSpawned.isAbstract) { subscribe<DecorativeObjectSpawned>(Events.DECORATIVE_OBJECT_SPAWNED) { onDecorativeObjectSpawned(it) } }
        if (!this::onDialogProcessed.isAbstract) { subscribe<DialogProcessed>(Events.DIALOG_PROCESSED) { onDialogProcessed(it) } }
        if (!this::onDynamicObjectAnimationChanged.isAbstract) { subscribe<DynamicObjectAnimationChanged>(Events.DYNAMIC_OBJECT_ANIMATION_CHANGED) { onDynamicObjectAnimationChanged(it) } }
        if (!this::onExperienceGained.isAbstract) { subscribe<ExperienceGained>(Events.EXPERIENCE_GAINED) { onExperienceGained(it) } }
        if (!this::onFocusChanged.isAbstract) { subscribe<FocusChanged>(Events.FOCUS_CHANGED) { onFocusChanged(it) } }
        if (!this::onGameObjectChanged.isAbstract) { subscribe<GameObjectChanged>(Events.GAME_OBJECT_CHANGED) { onGameObjectChanged(it) } }
        if (!this::onGameObjectDespawned.isAbstract) { subscribe<GameObjectDespawned>(Events.GAME_OBJECT_DESPAWNED) { onGameObjectDespawned(it) } }
        if (!this::onGameObjectSpawned.isAbstract) { subscribe<GameObjectSpawned>(Events.GAME_OBJECT_SPAWNED) { onGameObjectSpawned(it) } }
        if (!this::onGameStateChanged.isAbstract) { subscribe<GameStateChanged>(Events.GAME_STATE_CHANGED) { onGameStateChanged(it) } }
        if (!this::onGameTick.isAbstract) { subscribe<GameTick>(Events.GAME_TICK) { onGameTick(it) } }
        if (!this::onGrandExchangeOfferChanged.isAbstract) { subscribe<GrandExchangeOfferChanged>(Events.GRAND_EXCHANGE_OFFER_CHANGED) { onGrandExchangeOfferChanged(it) } }
        if (!this::onGraphicsObjectCreated.isAbstract) { subscribe<GraphicsObjectCreated>(Events.GRAPHICS_OBJECT_CREATED) { onGraphicsObjectCreated(it) } }
        if (!this::onGroundObjectChanged.isAbstract) { subscribe<GroundObjectChanged>(Events.GROUND_OBJECT_CHANGED) { onGroundObjectChanged(it) } }
        if (!this::onGroundObjectDespawned.isAbstract) { subscribe<GroundObjectDespawned>(Events.GROUND_OBJECT_DESPAWNED) { onGroundObjectDespawned(it) } }
        if (!this::onGroundObjectSpawned.isAbstract) { subscribe<GroundObjectSpawned>(Events.GROUND_OBJECT_SPAWNED) { onGroundObjectSpawned(it) } }
        if (!this::onHealthBarUpdated.isAbstract) { subscribe<HealthBarUpdated>(Events.HEALTH_BAR_UPDATED) { onHealthBarUpdated(it) } }
        if (!this::onInteractingChanged.isAbstract) { subscribe<InteractingChanged>(Events.INTERACTING_CHANGED) { onInteractingChanged(it) } }
        if (!this::onInventoryChanged.isAbstract) { subscribe<InventoryChanged>(Events.INVENTORY_CHANGED) { onInventoryChanged(it) } }
        if (!this::onInvokeMenuAction.isAbstract) { subscribe<InvokeMenuAction>(Events.INVOKE_MENU_ACTION) { onInvokeMenuAction(it) } }
        if (!this::onItemContainerChanged.isAbstract) { subscribe<ItemContainerChanged>(Events.ITEM_CONTAINER_CHANGED) { onItemContainerChanged(it) } }
        if (!this::onItemDespawned.isAbstract) { subscribe<ItemDespawned>(Events.ITEM_DESPAWNED) { onItemDespawned(it) } }
        if (!this::onItemObtained.isAbstract) { subscribe<ItemObtained>(Events.ITEM_OBAINED) { onItemObtained(it) } }
        if (!this::onItemQuantityChanged.isAbstract) { subscribe<ItemQuantityChanged>(Events.ITEM_QUANTITY_CHANGED) { onItemQuantityChanged(it) } }
        if (!this::onItemSpawned.isAbstract) { subscribe<ItemSpawned>(Events.ITEM_SPAWNED) { onItemSpawned(it) } }
        if (!this::onLoginStateChanged.isAbstract) { subscribe<LoginStateChanged>(Events.LOGIN_STATE_CHANGED) { onLoginStateChanged(it) } }
        if (!this::onMenuEntryAdded.isAbstract) { subscribe<MenuEntryAdded>(Events.MENU_ENTRY_ADDED) { onMenuEntryAdded(it) } }
        if (!this::onMenuOpened.isAbstract) { subscribe<MenuOpened>(Events.MENU_OPENED) { onMenuOpened(it) } }
        if (!this::onMenuOptionClicked.isAbstract) { subscribe<MenuOptionClicked>(Events.MENU_OPTION_CLICKED) { onMenuOptionClicked(it) } }
        if (!this::onNpcActionChanged.isAbstract) { subscribe<NpcActionChanged>(Events.NPC_ACTION_CHANGED) { onNpcActionChanged(it) } }
        if (!this::onNpcChanged.isAbstract) { subscribe<NpcChanged>(Events.NPC_CHANGED) { onNpcChanged(it) } }
        if (!this::onNpcDespawned.isAbstract) { subscribe<NpcDespawned>(Events.NPC_DESPAWNED) { onNpcDespawned(it) } }
        if (!this::onNpcSpawned.isAbstract) { subscribe<NpcSpawned>(Events.NPC_SPAWNED) { onNpcSpawned(it) } }
        if (!this::onPacketSent.isAbstract) { subscribe<PacketSent>(Events.PACKET_SENT) { onPacketSent(it) } }
        if (!this::onOverheadTextChanged.isAbstract) { subscribe<OverheadTextChanged>(Events.OVERHEAD_TEXT_CHANGED) { onOverheadTextChanged(it) } }
        if (!this::onOverheadPrayerChanged.isAbstract) { subscribe<OverheadPrayerChanged>(Events.OVERHEAD_PRAYER_CHANGED) { onOverheadPrayerChanged(it) } }
        if (!this::onPlayerDespawned.isAbstract) { subscribe<PlayerDespawned>(Events.PLAYER_DESPAWNED) { onPlayerDespawned(it) } }
        if (!this::onPlayerMenuOptionsChanged.isAbstract) { subscribe<PlayerMenuOptionsChanged>(Events.PLAYER_MENU_OPTIONS_CHANGED) { onPlayerMenuOptionsChanged(it) } }
        if (!this::onPlayerSkullChanged.isAbstract) { subscribe<PlayerSkullChanged>(Events.PLAYER_SKULL_CHANGED) { onPlayerSkullChanged(it) } }
        if (!this::onPlayerSpawned.isAbstract) { subscribe<PlayerSpawned>(Events.PLAYER_SPAWNED) { onPlayerSpawned(it) } }
        if (!this::onPostItemComposition.isAbstract) { subscribe<PostItemComposition>(Events.POST_ITEM_COMPOSITION) { onPostItemComposition(it) } }
        if (!this::onProjectileMoved.isAbstract) { subscribe<ProjectileMoved>(Events.PROJECTILE_MOVED) { onProjectileMoved(it) } }
        if (!this::onProjetileSpawned.isAbstract) { subscribe<ProjectileSpawned>(Events.PROJECTILE_MOVED) { onProjetileSpawned(it) } }
        if (!this::onResizeableChanged.isAbstract) { subscribe<ResizeableChanged>(Events.RESIZEABLE_CHANGED) { onResizeableChanged(it) } }
        if (!this::onScriptCallbackEvent.isAbstract) { subscribe<ScriptCallbackEvent>(Events.SCRIPT_CALLBACK) { onScriptCallbackEvent(it) } }
        if (!this::onScriptPostFired.isAbstract) { subscribe<ScriptPostFired>(Events.SCRIPT_POST_FIRED) { onScriptPostFired(it) } }
        if (!this::onScriptPreFired.isAbstract) { subscribe<ScriptPreFired>(Events.SCRIPT_PRE_FIRED) { onScriptPreFired(it) } }
        if (!this::onSoundEffectPlayed.isAbstract) { subscribe<SoundEffectPlayed>(Events.SOUND_EFFECT_PLAYED) { onSoundEffectPlayed(it) } }
        if (!this::onStatChanged.isAbstract) { subscribe<StatChanged>(Events.STAT_CHANGED) { onStatChanged(it) } }
        if (!this::onVarbitChanged.isAbstract) { subscribe<VarbitChanged>(Events.VARBIT_CHANGED) { onVarbitChanged(it) } }
        if (!this::onWallObjectChanged.isAbstract) { subscribe<WallObjectChanged>(Events.WALL_OBJECT_CHANGED) { onWallObjectChanged(it) } }
        if (!this::onWallObjectDespawned.isAbstract) { subscribe<WallObjectDespawned>(Events.WALL_OBJECT_DESPAWNED) { onWallObjectDespawned(it) } }
        if (!this::onWallObjectSpawned.isAbstract) { subscribe<WallObjectSpawned>(Events.WALL_OBJECT_SPAWNED) { onWallObjectSpawned(it) } }
        if (!this::onWidgetHiddenChanged.isAbstract) { subscribe<WidgetHiddenChanged>(Events.WIDGET_HIDDEN_CHANGED) { onWidgetHiddenChanged(it) } }
        if (!this::onWidgetLoaded.isAbstract) { subscribe<WidgetLoaded>(Events.WIDGET_LOADED) { onWidgetLoaded(it) } }
        if (!this::onWidgetPositioned.isAbstract) { subscribe<WidgetPositioned>(Events.WIDGET_POSITIONED) { onWidgetPositioned(it) } }
        if (!this::onWidgetPressed.isAbstract) { subscribe<WidgetPressed>(Events.WIDGET_PRESSED) { onWidgetPressed(it) } }
        if (!this::onWorldListLoad.isAbstract) { subscribe<WorldListLoad>(Events.WORLD_LIST_LOAD) { onWorldListLoad(it) } }
        if (!this::onNPCSpawned.isAbstract) { subscribe<NpcSpawned>(Events.NPC_SPAWNED) { onNPCSpawned(it) } }
        if (!this::onNPCDespawned.isAbstract) { subscribe<NpcDespawned>(Events.NPC_DESPAWNED) { onNPCDespawned(it) } }
        if (!this::onPluginChanged.isAbstract) { subscribe<PluginChanged>(Events.PLANE_CHANGED) { onPluginChanged(it) } }
        if (!this::onInfoBoxMenuClicked.isAbstract){ subscribe<InfoBoxMenuClicked>(meteor.events.Events.INFO_BOX_MENU_CLICKED) { onInfoBoxMenuClicked(it) } }
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