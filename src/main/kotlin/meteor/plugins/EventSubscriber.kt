package meteor.plugins

import eventbus.Events
import eventbus.events.*
import org.rationalityfrontline.kevent.*

open class EventSubscriber : KEventSubscriber {
    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    val tag = generateTag()

    fun subscribe() {
        onActorDeath()?.let { subscribe(Events.ACTOR_DEATH, it) }
        onAnimationChanged()?.let { subscribe(Events.ANIMATION_CHANGED, it) }
        onAreaSoundEffectPlayed()?.let { subscribe(Events.AREA_SOUND_EFFECT_PLAYED, it) }
        onBeforeMenuRender()?.let { subscribe(Events.BEFORE_MENU_RENDER, it) }
        onCanvasSizeChanged()?.let { subscribe(Events.CANVAS_SIZE_CHANGED, it) }
        onChatMessage()?.let { subscribe(Events.CHAT_MESSAGE, it) }
        onClanChannelChanged()?.let { subscribe(Events.CLAN_CHANNEL_CHANGED, it) }
        onClanMemberJoined()?.let { subscribe(Events.CLAN_MEMBER_JOINED, it) }
        onClanMemberLeft()?.let { subscribe(Events.CLAN_MEMBER_LEFT, it) }
        onClientLoaded()?.let { subscribe(Events.CLIENT_LOADED, it) }
        onClientTick()?.let { subscribe(Events.CLIENT_TICK, it) }
        onConfigChanged()?.let { subscribe(Events.CONFIG_CHANGED, it) }
        onDecorativeObjectChanged()?.let { subscribe(Events.DECORATIVE_OBJECT_CHANGED, it) }
        onDecorativeObjectDespawned()?.let { subscribe(Events.DECORATIVE_OBJECT_DESPAWNED, it) }
        onDecorativeObjectSpawned()?.let { subscribe(Events.DECORATIVE_OBJECT_SPAWNED, it) }
        onDialogProcessed()?.let { subscribe(Events.DIALOG_PROCESSED, it) }
        onDynamicObjectAnimationChanged()?.let { subscribe(Events.DYNAMIC_OBJECT_ANIMATION_CHANGED, it) }
        onExperienceGained()?.let { subscribe(Events.EXPERIENCE_GAINED, it) }
        onFocusChanged()?.let { subscribe(Events.FOCUS_CHANGED, it) }
        onGameObjectChanged()?.let { subscribe(Events.GAME_OBJECT_CHANGED, it) }
        onGameObjectDespawned()?.let { subscribe(Events.GAME_OBJECT_DESPAWNED, it) }
        onGameObjectSpawned()?.let { subscribe(Events.GAME_OBJECT_SPAWNED, it) }
        onGameStateChanged()?.let { subscribe(Events.GAME_STATE_CHANGED, it) }
        onGameTick()?.let { subscribe(Events.GAME_TICK, it) }
        onGrandExchangeOfferChanged()?.let { subscribe(Events.GRAND_EXCHANGE_OFFER_CHANGED, it) }
        onGraphicsObjectCreated()?.let { subscribe(Events.GRAPHICS_OBJECT_CREATED, it) }
        onGroundObjectChanged()?.let { subscribe(Events.GROUND_OBJECT_CHANGED, it) }
        onGroundObjectDespawned()?.let { subscribe(Events.GROUND_OBJECT_DESPAWNED, it) }
        onGroundObjectSpawned()?.let { subscribe(Events.GROUND_OBJECT_SPAWNED, it) }
        onHealthBarUpdated()?.let { subscribe(Events.HEALTH_BAR_UPDATED, it) }
        onInteractingChanged()?.let { subscribe(Events.INTERACTING_CHANGED, it) }
        onInventoryChanged()?.let { subscribe(Events.INVENTORY_CHANGED, it) }
        onInvokeMenuAction()?.let { subscribe(Events.INVOKE_MENU_ACTION, it) }
        onItemContainerChanged()?.let { subscribe(Events.ITEM_CONTAINER_CHANGED, it) }
        onItemDespawned()?.let { subscribe(Events.ITEM_DESPAWNED, it) }
        onItemObtained()?.let { subscribe(Events.ITEM_OBAINED, it) }
        onItemQuantityChanged()?.let { subscribe(Events.ITEM_QUANTITY_CHANGED, it) }
        onItemSpawned()?.let { subscribe(Events.ITEM_SPAWNED, it) }
        onLoginStateChanged()?.let { subscribe(Events.LOGIN_STATE_CHANGED, it) }
        onMenuEntryAdded()?.let { subscribe(Events.MENU_ENTRY_ADDED, it) }
        onMenuOpened()?.let { subscribe(Events.MENU_OPENED, it) }
        onMenuOptionClicked()?.let { subscribe(Events.MENU_OPTION_CLICKED, it) }
        onNpcActionChanged()?.let { subscribe(Events.NPC_ACTION_CHANGED, it) }
        onNpcChanged()?.let { subscribe(Events.NPC_CHANGED, it) }
        onNpcDespawned()?.let { subscribe(Events.NPC_DESPAWNED, it) }
        onNpcSpawned()?.let { subscribe(Events.NPC_SPAWNED, it) }
        onPacketSent()?.let { subscribe(Events.PACKET_SENT, it) }
        onOverheadPrayerChanged()?.let { subscribe(Events.OVERHEAD_PRAYER_CHANGED, it) }
        onPlayerDespawned()?.let { subscribe(Events.PLAYER_DESPAWNED, it) }
        onPlayerMenuOptionsChanged()?.let { subscribe(Events.PLAYER_MENU_OPTIONS_CHANGED, it) }
        onPlayerSkullChanged()?.let { subscribe(Events.PLAYER_SKULL_CHANGED, it) }
        onPlayerSpawned()?.let { subscribe(Events.PLAYER_SPAWNED, it) }
        onPostItemComposition()?.let { subscribe(Events.POST_ITEM_COMPOSITION, it) }
        onProjectileMoved()?.let { subscribe(Events.PROJECTILE_MOVED, it) }
        onProjetileSpawned()?.let { subscribe(Events.PROJECTILE_SPAWNED, it) }
        onResizeableChanged()?.let { subscribe(Events.RESIZEABLE_CHANGED, it) }
        onScriptCallbackEvent()?.let { subscribe(Events.SCRIPT_CALLBACK, it) }
        onScriptPostFired()?.let { subscribe(Events.SCRIPT_POST_FIRED, it) }
        onScriptPreFired()?.let { subscribe(Events.SCRIPT_PRE_FIRED, it) }
        onSoundEffectPlayed()?.let { subscribe(Events.SOUND_EFFECT_PLAYED, it) }
        onStatChanged()?.let { subscribe(Events.STAT_CHANGED, it) }
        onVarbitChanged()?.let { subscribe(Events.VARBIT_CHANGED, it) }
        onWallObjectChanged()?.let { subscribe(Events.WALL_OBJECT_CHANGED, it) }
        onWallObjectDespawned()?.let { subscribe(Events.WALL_OBJECT_DESPAWNED, it) }
        onWallObjectSpawned()?.let { subscribe(Events.WALL_OBJECT_SPAWNED, it) }
        onWidgetHiddenChanged()?.let { subscribe(Events.WIDGET_HIDDEN_CHANGED, it) }
        onWidgetLoaded()?.let { subscribe(Events.WIDGET_LOADED, it) }
        onWidgetPositioned()?.let { subscribe(Events.WIDGET_POSITIONED, it) }
        onWidgetPressed()?.let { subscribe(Events.WIDGET_PRESSED, it) }
        onWorldListLoad()?.let { subscribe(Events.WORLD_LIST_LOAD, it) }
        onNPCSpawned()?.let { subscribe(Events.NPC_SPAWNED, it) }
        onNPCDespawned()?.let { subscribe(Events.NPC_DESPAWNED, it) }
    }

    open fun onWorldListLoad(): ((Event<WorldListLoad>) -> Unit)? { return null }
    open fun onWidgetPressed(): ((Event<WidgetPressed>) -> Unit)? { return null }
    open fun onWidgetPositioned(): ((Event<WidgetPositioned>) -> Unit)? { return null }
    open fun onWidgetLoaded(): ((Event<WidgetLoaded>) -> Unit)? { return null }
    open fun onWidgetHiddenChanged(): ((Event<WidgetHiddenChanged>) -> Unit)? { return null }
    open fun onVarbitChanged(): ((Event<VarbitChanged>) -> Unit)? { return null }
    open fun onSoundEffectPlayed(): ((Event<SoundEffectPlayed>) -> Unit)? { return null }
    open fun onScriptPreFired(): ((Event<ScriptPreFired>) -> Unit)? { return null }
    open fun onScriptPostFired(): ((Event<ScriptPostFired>) -> Unit)? { return null }
    open fun onScriptCallbackEvent(): ((Event<ScriptCallbackEvent>) -> Unit)? { return null }
    open fun onResizeableChanged(): ((Event<ResizeableChanged>) -> Unit)? { return null }
    open fun onProjetileSpawned(): ((Event<ProjectileSpawned>) -> Unit)? { return null }
    open fun onStatChanged(): ((Event<StatChanged>) -> Unit)? { return null }
    open fun onPlayerSpawned(): ((Event<PlayerSpawned>) -> Unit)? { return null }
    open fun onPlayerSkullChanged(): ((Event<PlayerSkullChanged>) -> Unit)? { return null }
    open fun onPlayerMenuOptionsChanged(): ((Event<PlayerMenuOptionsChanged>) -> Unit)? { return null }
    open fun onPlayerDespawned(): ((Event<PlayerDespawned>) -> Unit)? { return null }
    open fun onOverheadPrayerChanged(): ((Event<OverheadPrayerChanged>) -> Unit)? { return null }
    open fun onPacketSent(): ((Event<PacketSent>) -> Unit)? { return null }
    open fun onNpcActionChanged(): ((Event<NpcActionChanged>) -> Unit)? { return null }
    open fun onMenuOptionClicked(): ((Event<MenuOptionClicked>) -> Unit)? { return null }
    open fun onMenuOpened(): ((Event<MenuOpened>) -> Unit)? { return null }
    open fun onMenuEntryAdded(): ((Event<MenuEntryAdded>) -> Unit)? { return null }
    open fun onLoginStateChanged(): ((Event<LoginStateChanged>) -> Unit)? { return null }
    open fun onItemQuantityChanged(): ((Event<ItemQuantityChanged>) -> Unit)? { return null }
    open fun onItemObtained(): ((Event<ItemObtained>) -> Unit)? { return null }
    open fun onItemContainerChanged(): ((Event<ItemContainerChanged>) -> Unit)? { return null }
    open fun onInvokeMenuAction(): ((Event<InvokeMenuAction>) -> Unit)? { return null }
    open fun onInventoryChanged(): ((Event<InventoryChanged>) -> Unit)? { return null }
    open fun onHealthBarUpdated(): ((Event<HealthBarUpdated>) -> Unit)? { return null }
    open fun onGraphicsObjectCreated(): ((Event<GraphicsObjectCreated>) -> Unit)? { return null }
    open fun onGrandExchangeOfferChanged(): ((Event<GrandExchangeOfferChanged>) -> Unit)? { return null }
    open fun onGameTick(): ((Event<GameTick>) -> Unit)? { return null }
    open fun onFocusChanged(): ((Event<FocusChanged>) -> Unit)? { return null }
    open fun onExperienceGained(): ((Event<ExperienceGained>) -> Unit)? { return null }
    open fun onDynamicObjectAnimationChanged(): ((Event<DynamicObjectAnimationChanged>) -> Unit)? { return null }
    open fun onDialogProcessed(): ((Event<DialogProcessed>) -> Unit)? { return null }
    open fun onClientTick(): ((Event<ClientTick>) -> Unit)? { return null }
    open fun onClientLoaded(): ((Event<ClientLoaded>) -> Unit)? { return null }
    open fun onClanMemberLeft(): ((Event<ClanMemberLeft>) -> Unit)? { return null }
    open fun onClanMemberJoined(): ((Event<ClanMemberJoined>) -> Unit)? { return null }
    open fun onClanChannelChanged(): ((Event<ClanChannelChanged>) -> Unit)? { return null }
    open fun onChatMessage(): ((Event<ChatMessage>) -> Unit)? { return null }
    open fun onCanvasSizeChanged(): ((Event<CanvasSizeChanged>) -> Unit)? { return null }
    open fun onBeforeMenuRender(): ((Event<BeforeMenuRender>) -> Unit)? { return null }
    open fun onAreaSoundEffectPlayed(): ((Event<AreaSoundEffectPlayed>) -> Unit)? { return null }
    open fun onAnimationChanged(): ((Event<AnimationChanged>) -> Unit)? { return null }
    open fun onActorDeath(): ((Event<ActorDeath>) -> Unit)? { return null }
    open fun onGameStateChanged(): ((Event<GameStateChanged>) -> Unit)? { return null }
    open fun onInteractingChanged(): ((Event<InteractingChanged>) -> Unit)? { return null }
    open fun onNPCSpawned(): ((Event<NpcSpawned>) -> Unit)? { return null }
    open fun onNPCDespawned(): ((Event<NpcDespawned>) -> Unit)? { return null }
    open fun onGameObjectSpawned(): ((Event<GameObjectSpawned>) -> Unit)? { return null }
    open fun onGameObjectChanged(): ((Event<GameObjectChanged>) -> Unit)? { return null }
    open fun onGameObjectDespawned(): ((Event<GameObjectDespawned>) -> Unit)? { return null }
    open fun onGroundObjectSpawned(): ((Event<GroundObjectSpawned>) -> Unit)? { return null }
    open fun onGroundObjectChanged(): ((Event<GroundObjectChanged>) -> Unit)? { return null }
    open fun onGroundObjectDespawned(): ((Event<GroundObjectDespawned>) -> Unit)? { return null }
    open fun onWallObjectSpawned(): ((Event<WallObjectSpawned>) -> Unit)? { return null }
    open fun onWallObjectChanged(): ((Event<WallObjectChanged>) -> Unit)? { return null }
    open fun onWallObjectDespawned(): ((Event<WallObjectDespawned>) -> Unit)? { return null }
    open fun onDecorativeObjectSpawned(): ((Event<DecorativeObjectSpawned>) -> Unit)? { return null }
    open fun onDecorativeObjectChanged(): ((Event<DecorativeObjectChanged>) -> Unit)? { return null }
    open fun onDecorativeObjectDespawned(): ((Event<DecorativeObjectDespawned>) -> Unit)? { return null }
    open fun onItemSpawned(): ((Event<ItemSpawned>) -> Unit)? { return null }
    open fun onItemDespawned(): ((Event<ItemDespawned>) -> Unit)? { return null }
    open fun onNpcSpawned(): ((Event<NpcSpawned>) -> Unit)? { return null }
    open fun onNpcChanged(): ((Event<NpcChanged>) -> Unit)? { return null }
    open fun onNpcDespawned(): ((Event<NpcDespawned>) -> Unit)? { return null }
    open fun onProjectileMoved(): ((Event<ProjectileMoved>) -> Unit)? { return null }
    open fun onConfigChanged(): ((Event<ConfigChanged>) -> Unit)? { return null }
    open fun onPostItemComposition(): ((Event<PostItemComposition>) -> Unit)? { return null }

    fun unregisterSubscribers() {
        if (!unsubscribeAll())
            throw RuntimeException("Failed to unregister Plugin")
    }

    inline fun <reified T : Any> subscribe(type: Events, noinline unit: (Event<T>) -> Unit) {
        KEVENT.subscribe<T>(eventType = type, tag = tag) {
            unit.invoke(it)
        }
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