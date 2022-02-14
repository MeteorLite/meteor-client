package meteor.plugins

import eventbus.Events
import eventbus.events.*
import meteor.events.InfoBoxMenuClicked
import meteor.events.PluginChanged
import net.runelite.api.events.MenuShouldLeftClick
import net.runelite.api.events.OverheadTextChanged
import org.rationalityfrontline.kevent.*
 open class EventSubscriber : KEventSubscriber {
    private val charPool : List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
    val tag = generateTag()

    fun subscribe() {
        if (!this::onMenuShouldLeftClick.isAbstract) { subscribeOnMenuShouldLeftClick() }
        if (!this::onActorDeath.isAbstract) { subscribeOnActorDeath() }
        if (!this::onAnimationChanged.isAbstract) { subscribeOnAnimationChanged() }
        if (!this::onAreaSoundEffectPlayed.isAbstract) { subscribeOnAreaSoundEffectPlayed() }
        if (!this::onBeforeRender.isAbstract) { subscribeOnBeforeRender() }
        if (!this::onBeforeMenuRender.isAbstract) { subscribeOnBeforeMenuRender() }
        if (!this::onCanvasSizeChanged.isAbstract) { subscribeOnCanvasSizeChanged() }
        if (!this::onChatMessage.isAbstract) { subscribeOnChatMessage() }
        if (!this::onClanChannelChanged.isAbstract) { subscribeOnClanChannelChanged() }
        if (!this::onClanMemberJoined.isAbstract) { subscribeOnClanMemberJoined() }
        if (!this::onClanMemberLeft.isAbstract) { subscribeOnClanMemberLeft() }
        if (!this::onClientLoaded.isAbstract) { subscribeOnClientLoaded() }
        if (!this::onClientTick.isAbstract) { subscribeOnClientTick() }
        if (!this::onConfigChanged.isAbstract) { subscribeOnConfigChanged() }
        if (!this::onDecorativeObjectChanged.isAbstract) { subscribeOnDecorativeObjectChanged() }
        if (!this::onDecorativeObjectDespawned.isAbstract) { subscribeOnDecorativeObjectDespawned() }
        if (!this::onDecorativeObjectSpawned.isAbstract) { subscribeOnDecorativeObjectSpawned() }
        if (!this::onDialogProcessed.isAbstract) { subscribeOnDialogProcessed() }
        if (!this::onDynamicObjectAnimationChanged.isAbstract) { subscribeOnDynamicObjectAnimationChanged() }
        if (!this::onExperienceGained.isAbstract) { subscribeOnExperienceGained() }
        if (!this::onFocusChanged.isAbstract) { subscribeOnFocusChanged() }
        if (!this::onGameObjectChanged.isAbstract) { subscribeOnGameObjectChanged() }
        if (!this::onGameObjectDespawned.isAbstract) { subscribeOnGameObjectDespawned() }
        if (!this::onGameObjectSpawned.isAbstract) { subscribeOnGameObjectSpawned() }
        if (!this::onGameStateChanged.isAbstract) { subscribeOnGameState() }
        if (!this::onGameTick.isAbstract) { subscribeOnGameTick() }
        if (!this::onGrandExchangeOfferChanged.isAbstract) { subscribeOnGrandExchangeOfferChanged() }
        if (!this::onGraphicsObjectCreated.isAbstract) { subscribeOnGraphicsObjectCreated() }
        if (!this::onGroundObjectChanged.isAbstract) { subscribeOnGroundObjectChanged() }
        if (!this::onGroundObjectDespawned.isAbstract) { subscribeOnGroundObjectDespawned() }
        if (!this::onGroundObjectSpawned.isAbstract) { subscribeOnGroundObjectSpawned() }
        if (!this::onHealthBarUpdated.isAbstract) { subscribeOnHealthBarUpdated() }
        if (!this::onInteractingChanged.isAbstract) { subscribeOnInteractingChanged() }
        if (!this::onInventoryChanged.isAbstract) { subscribeOnInventoryChanged() }
        if (!this::onInvokeMenuAction.isAbstract) { subscribeOnInvokeMenuAction() }
        if (!this::onItemContainerChanged.isAbstract) { subscribeOnItemContainerChanged() }
        if (!this::onItemDespawned.isAbstract) { subscribeOnItemDespawned() }
        if (!this::onItemObtained.isAbstract) { subscribeOnItemObtained() }
        if (!this::onItemQuantityChanged.isAbstract) { subscribeOnItemQuantityChanged() }
        if (!this::onItemSpawned.isAbstract) { subscribeOnItemSpawned() }
        if (!this::onLoginStateChanged.isAbstract) { subscribeOnItemSpawned() }
        if (!this::onMenuEntryAdded.isAbstract) { subscribeOnMenuEntryAdded() }
        if (!this::onMenuOpened.isAbstract) { subscribeOnMenuOpened() }
        if (!this::onMenuOptionClicked.isAbstract) { subscribeOnMenuOptionClicked() }
        if (!this::onNpcActionChanged.isAbstract) { subscribeOnNpcActionChanged() }
        if (!this::onNpcChanged.isAbstract) { subscribeOnNpcChanged() }
        if (!this::onNpcDespawned.isAbstract) { subscribeOnNpcDespawned() }
        if (!this::onNpcSpawned.isAbstract) { subscribeOnNpcSpawned() }
        if (!this::onPacketSent.isAbstract) { subscribeOnPacketSent() }
        if (!this::onOverheadTextChanged.isAbstract) { subscribeOnOverheadTextChanged() }
        if (!this::onOverheadPrayerChanged.isAbstract) { subscribeOnOverheadPrayerChanged() }
        if (!this::onPlayerDespawned.isAbstract) { subscribeOnPlayerDespawned() }
        if (!this::onPlayerMenuOptionsChanged.isAbstract) { subscribeOnPlayerMenuOptionsChanged() }
        if (!this::onPlayerSkullChanged.isAbstract) { subscribeOnPlayerSkullChanged() }
        if (!this::onPlayerSpawned.isAbstract) { subscribeOnPlayerSpawned() }
        if (!this::onPostItemComposition.isAbstract) { subscribeOnPostItemComposition() }
        if (!this::onProjectileMoved.isAbstract) { subscribeOnProjectileMoved() }
        if (!this::onProjetileSpawned.isAbstract) { subscribeOnProjetileSpawned() }
        if (!this::onResizeableChanged.isAbstract) { subscribeOnResizeableChanged() }
        if (!this::onScriptCallbackEvent.isAbstract) { subscribeOnScriptCallbackEvent() }
        if (!this::onScriptPostFired.isAbstract) { subscribeOnScriptPostFired() }
        if (!this::onScriptPreFired.isAbstract) { subscribeOnScriptPreFired() }
        if (!this::onSoundEffectPlayed.isAbstract) { subscribeOnSoundEffectPlayed() }
        if (!this::onStatChanged.isAbstract) { subscribeOnStatChanged() }
        if (!this::onVarbitChanged.isAbstract) { subscribeOnVarbitChanged() }
        if (!this::onWallObjectChanged.isAbstract) { subscribeOnWallObjectChanged() }
        if (!this::onWallObjectDespawned.isAbstract) { subscribeOnWallObjectDespawned() }
        if (!this::onWallObjectSpawned.isAbstract) { subscribeOnWallObjectSpawned() }
        if (!this::onWidgetHiddenChanged.isAbstract) { subscribeOnWidgetHiddenChanged() }
        if (!this::onWidgetLoaded.isAbstract) { subscribeOnWidgetLoaded() }
        if (!this::onWidgetPositioned.isAbstract) { subscribeOnWidgetPositioned() }
        if (!this::onWidgetPressed.isAbstract) { subscribeOnWidgetPressed() }
        if (!this::onWorldListLoad.isAbstract) { subscribeOnWorldListLoad() }
        if (!this::onNPCSpawned.isAbstract) { subscribeOnNPCSpawned() }
        if (!this::onNPCDespawned.isAbstract) { subscribeOnNPCDespawned() }
        if (!this::onPluginChanged.isAbstract) { subscribeOnPluginChanged() }
        if (!this::onInfoBoxMenuClicked.isAbstract) { subscribeOnInfoBoxMenuClicked() }
    }
    open fun onMenuShouldLeftClick(): ((Event<MenuShouldLeftClick>) -> Unit)?{return null}
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
    open fun onGameStateChanged(it: GameStateChanged) {}
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
    open fun onBeforeRender(): ((Event<BeforeRender>) -> Unit)? { return null }
    open fun onPluginChanged(): ((Event<PluginChanged>) -> Unit)? { return null }
    open fun onInfoBoxMenuClicked(): ((Event<InfoBoxMenuClicked>) -> Unit)? { return null }
    open fun onOverheadTextChanged(): ((Event<OverheadTextChanged>) -> Unit)?{return null}

    fun unregisterSubscribers() {
        if (!unsubscribeAll())
            throw RuntimeException("Failed to unregister Plugin")
    }

    inline fun <reified T : Any> subscribe(type: Enum<*>, noinline unit: (Event<T>) -> Unit) {
        KEVENT.subscribe<T>(eventType = type, tag = tag) {
            unit.invoke(it)
        }
    }

    fun subscribeOnGameState() {
        KEVENT.subscribe<GameStateChanged>(eventType = Events.GAME_STATE_CHANGED, tag = tag) {
            onGameStateChanged(it.data)
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