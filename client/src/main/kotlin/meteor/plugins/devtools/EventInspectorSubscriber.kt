package meteor.plugins.devtools

import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.events.MenuActionProcessed
import dev.hoot.api.events.PacketSent
import eventbus.Events
import eventbus.events.*
import meteor.Main
import meteor.events.InfoBoxMenuClicked
import meteor.events.NpcLootReceived
import meteor.events.PlayerLootReceived
import meteor.events.PluginChanged
import net.runelite.api.events.MenuOpened
import org.rationalityfrontline.kevent.*

open class EventInspectorSubscriber : DevToolsFrame(), KEventSubscriber {
    private var eventListening: Boolean = false
    open fun onNpcLootReceived(it: NpcLootReceived) {}
    open fun onPlayerLootReceived(it: PlayerLootReceived) {}
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
    open fun onMenuActionProcessed(it: MenuActionProcessed) {}
    open fun onLoginStateChanged(it: LoginStateChanged) {}
    open fun onItemQuantityChanged(it: ItemQuantityChanged) {}
    open fun onItemObtained(it: ItemObtained) {}
    open fun onItemContainerChanged(it: ItemContainerChanged) {}
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
    open fun onPacketSent(it: PacketSent) {}
    open fun onMenuOpened(it: MenuOpened) {}
    open fun onPostHealthBar(it: PostHealthBar) {}
    open fun onGraphicChanged(it: GraphicChanged) {}
    open fun onProjectileSpawned(it: ProjectileSpawned) {}
    open fun onWorldChanged(it: WorldChanged) {}
    open fun onGrandExchangeSearched(it: GrandExchangeSearched) {}
    open fun onCheatEntered(it: CheatEntered) {}

    open fun onAnimationFrameIndexChanged(it: AnimationFrameIndexChanged) {}
    open fun onAttachedModelEvent(it: AttachedModelEvent) {}
    open fun onCameraLookAtEvent(it: CameraLookAtEvent) {}
    open fun onCameraMoveToEvent(it: CameraMoveToEvent) {}
    open fun onCameraResetEvent(it: CameraResetEvent) {}
    open fun onCameraShakeEvent(it: CameraShakeEvent) {}
    open fun onCombatLevelChangeEvent(it: CombatLevelChangeEvent) {}
    open fun onContainerItemChange(it: ContainerItemChange) {}
    open fun onExactMoveEvent(it: ExactMoveEvent) {}
    open fun onFacedDirectionChanged(it: FacedDirectionChanged) {}
    open fun onGetDynamicObjectForAnimationEvent(it: GetDynamicObjectForAnimationEvent) {}
    open fun onHashTableNodeGetCall(it: HashTableNodeGetCall) {}
    open fun onHashTableNodePut(it: HashTableNodePut) {}
    open fun onHintArrowEvent(it: HintArrowEvent) {}
    open fun onIfOpenSubEvent(it: IfOpenSubEvent) {}
    open fun onIfOpenTopEvent(it: IfOpenTopEvent) {}
    open fun onJinglePlayed(it: JinglePlayed) {}
    open fun onMinimapStateChange(it: MinimapStateChange) {}
    open fun onNameChangeEvent(it: NameChangeEvent) {}
    open fun onNPCMoved(it: NPCMoved) {}
    open fun onPendingSpawnUpdated(it: PendingSpawnUpdated) {}
    open fun onPlayerAnimationPlayed(it: PlayerAnimationPlayed) {}
    open fun onPlayerMoved(it: PlayerMoved) {}
    open fun onPostWidgetConstructed(it: PostWidgetConstructed) {}
    open fun onRebuildRegionEvent(it: RebuildRegionEvent) {}
    open fun onRecolourEvent(it: RecolourEvent) {}
    open fun onRunEnergyChangedEvent(it: RunEnergyChangedEvent) {}
    open fun onServerPacketReadCompleteEvent(it: ServerPacketReadCompleteEvent) {}
    open fun onServerPacketReadStartedEvent(it: ServerPacketReadStartedEvent) {}
    open fun onShowPublicPlayerChatChanged(it: ShowPublicPlayerChatChanged) {}
    open fun onSoundEffectReceived(it: SoundEffectReceived) {}
    open fun onWidgetColorChanged(it: WidgetColorChanged) {}
    open fun onWidgetModelChanged(it: WidgetModelChanged) {}
    open fun onWidgetModelRotate(it: WidgetModelRotate) {}
    open fun onWidgetPositionChanged(it: WidgetPositionChanged) {}
    open fun onWidgetScrollHeightChanged(it: WidgetScrollHeightChanged) {}
    open fun onWidgetSequenceChanged(it: WidgetSequenceChanged) {}
    open fun onWidgetSetNpcHead(it: WidgetSetNpcHead) {}
    open fun onWidgetSetObject(it: WidgetSetObject) {}
    open fun onWidgetSetPlayerHead(it: WidgetSetPlayerHead) {}
    open fun onWidgetTextChanged(it: WidgetTextChanged) {}
    open fun onWidgetVisibilityChange(it: WidgetVisibilityChange) {}
    open fun onWidgetZoomChanged(it: WidgetZoomChanged) {}
    open fun onPlayerChanged(it: PlayerChanged) {}
    open fun onWidgetClosed(it: WidgetClosed) {}

    open fun executeIfListening(unit: () -> (Unit)) {
        if (eventListening)
            unit()
    }

    fun subscribeEvents() {
        subscribeEvent<MenuShouldLeftClick>(Events.MENU_SHOULD_LEFT_CLICK) {
            executeIfListening {
                onMenuShouldLeftClick(
                    it
                )
            }
        }
        subscribeEvent<ActorDeath>(Events.ACTOR_DEATH) { executeIfListening { onActorDeath(it) } }
        subscribeEvent<AnimationChanged>(Events.ANIMATION_CHANGED) { executeIfListening { onAnimationChanged(it) } }
        subscribeEvent<AreaSoundEffectPlayed>(Events.AREA_SOUND_EFFECT_PLAYED) {
            executeIfListening {
                onAreaSoundEffectPlayed(
                    it
                )
            }
        }
        subscribeEvent<BeforeRender>(Events.BEFORE_RENDER) { executeIfListening { onBeforeRender(it) } }
        subscribeEvent<BeforeMenuRender>(Events.BEFORE_MENU_RENDER) { executeIfListening { onBeforeMenuRender(it) } }
        subscribeEvent<CanvasSizeChanged>(Events.CANVAS_SIZE_CHANGED) { executeIfListening { onCanvasSizeChanged(it) } }
        subscribeEvent<ChatMessage>(Events.CHAT_MESSAGE) { executeIfListening { onChatMessage(it) } }
        subscribeEvent<ClanChannelChanged>(Events.CLAN_CHANNEL_CHANGED) { executeIfListening { onClanChannelChanged(it) } }
        subscribeEvent<ClanMemberJoined>(Events.CLAN_MEMBER_JOINED) { executeIfListening { onClanMemberJoined(it) } }
        subscribeEvent<ClanMemberLeft>(Events.CLAN_MEMBER_LEFT) { executeIfListening { onClanMemberLeft(it) } }
        subscribeEvent<ClientLoaded>(Events.CLIENT_LOADED) { executeIfListening { onClientLoaded(it) } }
        subscribeEvent<ClientTick>(Events.CLIENT_TICK) { executeIfListening { onClientTick(it) } }
        subscribeEvent<ConfigChanged>(Events.CONFIG_CHANGED) { executeIfListening { onConfigChanged(it) } }
        subscribeEvent<DecorativeObjectChanged>(Events.DECORATIVE_OBJECT_CHANGED) {
            executeIfListening {
                onDecorativeObjectChanged(
                    it
                )
            }
        }
        subscribeEvent<DecorativeObjectDespawned>(Events.DECORATIVE_OBJECT_DESPAWNED) {
            executeIfListening {
                onDecorativeObjectDespawned(
                    it
                )
            }
        }
        subscribeEvent<DecorativeObjectSpawned>(Events.DECORATIVE_OBJECT_SPAWNED) {
            executeIfListening {
                onDecorativeObjectSpawned(
                    it
                )
            }
        }
        subscribeEvent<DialogProcessed>(Events.DIALOG_PROCESSED) { executeIfListening { onDialogProcessed(it) } }
        subscribeEvent<DynamicObjectAnimationChanged>(Events.DYNAMIC_OBJECT_ANIMATION_CHANGED) {
            executeIfListening {
                onDynamicObjectAnimationChanged(
                    it
                )
            }
        }
        subscribeEvent<ExperienceGained>(Events.EXPERIENCE_GAINED) { executeIfListening { onExperienceGained(it) } }
        subscribeEvent<FocusChanged>(Events.FOCUS_CHANGED) { executeIfListening { onFocusChanged(it) } }
        subscribeEvent<GameObjectChanged>(Events.GAME_OBJECT_CHANGED) { executeIfListening { onGameObjectChanged(it) } }
        subscribeEvent<GameObjectDespawned>(Events.GAME_OBJECT_DESPAWNED) {
            executeIfListening {
                onGameObjectDespawned(
                    it
                )
            }
        }
        subscribeEvent<GameObjectSpawned>(Events.GAME_OBJECT_SPAWNED) { executeIfListening { onGameObjectSpawned(it) } }
        subscribeEvent<GameStateChanged>(Events.GAME_STATE_CHANGED) { executeIfListening { onGameStateChanged(it) } }
        subscribeEvent<GameTick>(Events.GAME_TICK) { executeIfListening { onGameTick(it) } }
        subscribeEvent<GrandExchangeOfferChanged>(Events.GRAND_EXCHANGE_OFFER_CHANGED) {
            executeIfListening {
                onGrandExchangeOfferChanged(
                    it
                )
            }
        }
        subscribeEvent<GraphicsObjectCreated>(Events.GRAPHICS_OBJECT_CREATED) {
            executeIfListening {
                onGraphicsObjectCreated(
                    it
                )
            }
        }
        subscribeEvent<GroundObjectChanged>(Events.GROUND_OBJECT_CHANGED) {
            executeIfListening {
                onGroundObjectChanged(
                    it
                )
            }
        }
        subscribeEvent<GroundObjectDespawned>(Events.GROUND_OBJECT_DESPAWNED) {
            executeIfListening {
                onGroundObjectDespawned(
                    it
                )
            }
        }
        subscribeEvent<GroundObjectSpawned>(Events.GROUND_OBJECT_SPAWNED) {
            executeIfListening {
                onGroundObjectSpawned(
                    it
                )
            }
        }
        subscribeEvent<HealthBarUpdated>(Events.HEALTH_BAR_UPDATED) { executeIfListening { onHealthBarUpdated(it) } }
        subscribeEvent<InteractingChanged>(Events.INTERACTING_CHANGED) { executeIfListening { onInteractingChanged(it) } }
        subscribeEvent<ItemContainerChanged>(Events.ITEM_CONTAINER_CHANGED) {
            executeIfListening {
                onItemContainerChanged(
                    it
                )
            }
        }
        subscribeEvent<ItemDespawned>(Events.ITEM_DESPAWNED) { executeIfListening { onItemDespawned(it) } }
        subscribeEvent<ItemObtained>(Events.ITEM_OBTAINED) { executeIfListening { onItemObtained(it) } }
        subscribeEvent<ItemQuantityChanged>(Events.ITEM_QUANTITY_CHANGED) {
            executeIfListening {
                onItemQuantityChanged(
                    it
                )
            }
        }
        subscribeEvent<ItemSpawned>(Events.ITEM_SPAWNED) { executeIfListening { onItemSpawned(it) } }
        subscribeEvent<LoginStateChanged>(Events.LOGIN_STATE_CHANGED) { executeIfListening { onLoginStateChanged(it) } }
        subscribeEvent<MenuActionProcessed>(Events.MENU_ACTION_PROCESSED) {
            executeIfListening {
                onMenuActionProcessed(
                    it
                )
            }
        }
        subscribeEvent<MenuEntryAdded>(Events.MENU_ENTRY_ADDED) { executeIfListening { onMenuEntryAdded(it) } }
        subscribeEvent<MenuOptionClicked>(Events.MENU_OPTION_CLICKED) {
            executeIfListening {
                if (it.menuEntry != null)
                    onMenuOptionClicked(it)
            }
        }
        subscribeEvent<NpcActionChanged>(Events.NPC_ACTION_CHANGED) { executeIfListening { onNpcActionChanged(it) } }
        subscribeEvent<NpcChanged>(Events.NPC_CHANGED) { executeIfListening { onNpcChanged(it) } }
        subscribeEvent<NpcDespawned>(Events.NPC_DESPAWNED) { executeIfListening { onNpcDespawned(it) } }
        subscribeEvent<NpcLootReceived>(Events.NPC_LOOT_RECEIVED) { executeIfListening { onNpcLootReceived(it) } }
        subscribeEvent<NpcSpawned>(Events.NPC_SPAWNED) { executeIfListening { onNpcSpawned(it) } }
        subscribeEvent<AutomatedMenu>(Events.AUTOMATED_MENU) { executeIfListening { onInvokeMenuAction(it) } }
        subscribeEvent<OverheadTextChanged>(Events.OVERHEAD_TEXT_CHANGED) {
            executeIfListening {
                onOverheadTextChanged(
                    it
                )
            }
        }
        subscribeEvent<OverheadPrayerChanged>(Events.OVERHEAD_PRAYER_CHANGED) {
            executeIfListening {
                onOverheadPrayerChanged(
                    it
                )
            }
        }
        subscribeEvent<PlayerDespawned>(Events.PLAYER_DESPAWNED) { executeIfListening { onPlayerDespawned(it) } }
        subscribeEvent<PlayerMenuOptionsChanged>(Events.PLAYER_MENU_OPTIONS_CHANGED) {
            executeIfListening {
                onPlayerMenuOptionsChanged(
                    it
                )
            }
        }
        subscribeEvent<PlayerSkullChanged>(Events.PLAYER_SKULL_CHANGED) { executeIfListening { onPlayerSkullChanged(it) } }
        subscribeEvent<PlayerSpawned>(Events.PLAYER_SPAWNED) { executeIfListening { onPlayerSpawned(it) } }
        subscribeEvent<PlayerLootReceived>(Events.PLAYER_LOOT_RECEIVED) { executeIfListening { onPlayerLootReceived(it) } }
        subscribeEvent<PostItemComposition>(Events.POST_ITEM_COMPOSITION) {
            executeIfListening {
                onPostItemComposition(
                    it
                )
            }
        }
        subscribeEvent<ProjectileMoved>(Events.PROJECTILE_MOVED) { executeIfListening { onProjectileMoved(it) } }
        subscribeEvent<ProjectileSpawned>(Events.PROJECTILE_SPAWNED) { executeIfListening { onProjetileSpawned(it) } }
        subscribeEvent<ResizeableChanged>(Events.RESIZEABLE_CHANGED) { executeIfListening { onResizeableChanged(it) } }
        subscribeEvent<ScriptCallbackEvent>(Events.SCRIPT_CALLBACK) { executeIfListening { onScriptCallbackEvent(it) } }
        subscribeEvent<ScriptPostFired>(Events.SCRIPT_POST_FIRED) { executeIfListening { onScriptPostFired(it) } }
        subscribeEvent<ScriptPreFired>(Events.SCRIPT_PRE_FIRED) { executeIfListening { onScriptPreFired(it) } }
        subscribeEvent<SoundEffectPlayed>(Events.SOUND_EFFECT_PLAYED) { executeIfListening { onSoundEffectPlayed(it) } }
        subscribeEvent<StatChanged>(Events.STAT_CHANGED) { executeIfListening { onStatChanged(it) } }
        subscribeEvent<VarbitChanged>(Events.VARBIT_CHANGED) { executeIfListening { onVarbitChanged(it) } }
        subscribeEvent<WallObjectChanged>(Events.WALL_OBJECT_CHANGED) { executeIfListening { onWallObjectChanged(it) } }
        subscribeEvent<WallObjectDespawned>(Events.WALL_OBJECT_DESPAWNED) {
            executeIfListening {
                onWallObjectDespawned(
                    it
                )
            }
        }
        subscribeEvent<WallObjectSpawned>(Events.WALL_OBJECT_SPAWNED) { executeIfListening { onWallObjectSpawned(it) } }
        subscribeEvent<WidgetHiddenChanged>(Events.WIDGET_HIDDEN_CHANGED) {
            executeIfListening {
                onWidgetHiddenChanged(
                    it
                )
            }
        }
        subscribeEvent<WidgetLoaded>(Events.WIDGET_LOADED) { executeIfListening { onWidgetLoaded(it) } }
        subscribeEvent<WidgetPositioned>(Events.WIDGET_POSITIONED) { executeIfListening { onWidgetPositioned(it) } }
        subscribeEvent<WidgetPressed>(Events.WIDGET_PRESSED) { executeIfListening { onWidgetPressed(it) } }
        subscribeEvent<WorldListLoad>(Events.WORLD_LIST_LOAD) { executeIfListening { onWorldListLoad(it) } }
        subscribeEvent<NpcSpawned>(Events.NPC_SPAWNED) { executeIfListening { onNPCSpawned(it) } }
        subscribeEvent<NpcDespawned>(Events.NPC_DESPAWNED) { executeIfListening { onNPCDespawned(it) } }
        subscribeEvent<PluginChanged>(Events.PLUGIN_CHANGED) { executeIfListening { onPluginChanged(it) } }
        subscribeEvent<InfoBoxMenuClicked>(meteor.events.Events.INFO_BOX_MENU_CLICKED) {
            executeIfListening {
                onInfoBoxMenuClicked(
                    it
                )
            }
        }
        subscribeEvent<HitsplatApplied>(Events.HITSPLAT_APPLIED) { executeIfListening { onHitsplatApplied(it) } }
        subscribeEvent<PacketSent>(Events.PACKET_SENT) { executeIfListening { onPacketSent(it) } }
        subscribeEvent<MenuOpened>(Events.MENU_OPENED) { executeIfListening { onMenuOpened(it) } }
        subscribeEvent<PostHealthBar>(Events.POST_HEALTHBAR) { executeIfListening { onPostHealthBar(it) } }
        subscribeEvent<GraphicChanged>(Events.GRAPHIC_CHANGED) { executeIfListening { onGraphicChanged(it) } }
        subscribeEvent<ProjectileSpawned>(Events.PROJECTILE_SPAWNED) { executeIfListening { onProjectileSpawned(it) } }
        subscribeEvent<WorldChanged>(Events.WORLD_CHANGED) { executeIfListening { onWorldChanged(it) } }
        subscribeEvent<GrandExchangeSearched>(Events.GRAND_EXCHANGE_SEARCHED) {
            executeIfListening {
                onGrandExchangeSearched(
                    it
                )
            }
        }
        subscribeEvent<CheatEntered>(Events.CHEAT_ENTERED) { executeIfListening { onCheatEntered(it) } }

        subscribeEvent<AnimationFrameIndexChanged>(Events.ANIMATION_FRAME_INDEX_CHANGED) {
            executeIfListening {
                onAnimationFrameIndexChanged(
                    it
                )
            }
        }
        subscribeEvent<AreaSoundEffectPlayed>(Events.AREA_SOUND_EFFECT_PLAYED) {
            executeIfListening {
                onAreaSoundEffectPlayed(
                    it
                )
            }
        }
        subscribeEvent<AttachedModelEvent>(Events.ATTACHED_MODEL_EVENT) { executeIfListening { onAttachedModelEvent(it) } }
        subscribeEvent<CameraLookAtEvent>(Events.CAMERA_LOOK_AT_EVENT) { executeIfListening { onCameraLookAtEvent(it) } }
        subscribeEvent<CameraMoveToEvent>(Events.CAMERA_MOVE_TO_EVENT) { executeIfListening { onCameraMoveToEvent(it) } }
        subscribeEvent<CameraResetEvent>(Events.CAMERA_RESET_EVENT) { executeIfListening { onCameraResetEvent(it) } }
        subscribeEvent<CameraShakeEvent>(Events.CAMERA_SHAKE_EVENT) { executeIfListening { onCameraShakeEvent(it) } }
        subscribeEvent<CombatLevelChangeEvent>(Events.COMBAT_LEVEL_CHANGE_EVENT) {
            executeIfListening {
                onCombatLevelChangeEvent(
                    it
                )
            }
        }
        subscribeEvent<ContainerItemChange>(Events.CONTAINER_ITEM_CHANGE) {
            executeIfListening {
                onContainerItemChange(
                    it
                )
            }
        }
        subscribeEvent<DynamicObjectAnimationChanged>(Events.DYNAMIC_OBJECT_ANIMATION_CHANGED) {
            executeIfListening {
                onDynamicObjectAnimationChanged(
                    it
                )
            }
        }
        subscribeEvent<ExactMoveEvent>(Events.EXACT_MOVE_EVENT) { executeIfListening { onExactMoveEvent(it) } }
        subscribeEvent<FacedDirectionChanged>(Events.FACED_DIRECTION_CHANGED) {
            executeIfListening {
                onFacedDirectionChanged(
                    it
                )
            }
        }
        subscribeEvent<GetDynamicObjectForAnimationEvent>(Events.GET_DYNAMIC_OBJECT_FOR_ANIMATION_EVENT) {
            executeIfListening {
                onGetDynamicObjectForAnimationEvent(
                    it
                )
            }
        }
        subscribeEvent<HashTableNodeGetCall>(Events.HASH_TABLE_NODE_GET_CALL) {
            executeIfListening {
                onHashTableNodeGetCall(
                    it
                )
            }
        }
        subscribeEvent<HashTableNodePut>(Events.HASH_TABLE_NODE_PUT) { executeIfListening { onHashTableNodePut(it) } }
        subscribeEvent<HintArrowEvent>(Events.HINT_ARROW_EVENT) { executeIfListening { onHintArrowEvent(it) } }
        subscribeEvent<IfOpenSubEvent>(Events.IF_OPEN_SUB_EVENT) { executeIfListening { onIfOpenSubEvent(it) } }
        subscribeEvent<IfOpenTopEvent>(Events.IF_OPEN_TOP_EVENT) { executeIfListening { onIfOpenTopEvent(it) } }
        subscribeEvent<InteractingChanged>(Events.INTERACTING_CHANGED) { executeIfListening { onInteractingChanged(it) } }
        subscribeEvent<JinglePlayed>(Events.JINGLE_PLAYED) { executeIfListening { onJinglePlayed(it) } }
        subscribeEvent<MinimapStateChange>(Events.MINIMAP_STATE_CHANGE) { executeIfListening { onMinimapStateChange(it) } }
        subscribeEvent<NameChangeEvent>(Events.NAME_CHANGE_EVENT) { executeIfListening { onNameChangeEvent(it) } }
        subscribeEvent<NPCMoved>(Events.NPC_MOVED) { executeIfListening { onNPCMoved(it) } }
        subscribeEvent<PendingSpawnUpdated>(Events.PENDING_SPAWN_UPDATED) {
            executeIfListening {
                onPendingSpawnUpdated(
                    it
                )
            }
        }
        subscribeEvent<PlayerAnimationPlayed>(Events.PLAYER_ANIMATION_PLAYED) {
            executeIfListening {
                onPlayerAnimationPlayed(
                    it
                )
            }
        }
        subscribeEvent<PlayerMoved>(Events.PLAYER_MOVED) { executeIfListening { onPlayerMoved(it) } }
        subscribeEvent<PostWidgetConstructed>(Events.POST_WIDGET_CONSTRUCTED) {
            executeIfListening {
                onPostWidgetConstructed(
                    it
                )
            }
        }
        subscribeEvent<ProjectileSpawned>(Events.PROJECTILE_SPAWNED) { executeIfListening { onProjectileSpawned(it) } }
        subscribeEvent<RebuildRegionEvent>(Events.REBUILD_REGION_EVENT) { executeIfListening { onRebuildRegionEvent(it) } }
        subscribeEvent<RecolourEvent>(Events.RECOLOUR_EVENT) { executeIfListening { onRecolourEvent(it) } }
        subscribeEvent<RunEnergyChangedEvent>(Events.RUN_ENERGY_CHANGED_EVENT) {
            executeIfListening {
                onRunEnergyChangedEvent(
                    it
                )
            }
        }
        subscribeEvent<ServerPacketReadCompleteEvent>(Events.SERVER_PACKET_READ_COMPLETE_EVENT) {
            executeIfListening {
                onServerPacketReadCompleteEvent(
                    it
                )
            }
        }
        subscribeEvent<ServerPacketReadStartedEvent>(Events.SERVER_PACKET_READ_STARTED_EVENT) {
            executeIfListening {
                onServerPacketReadStartedEvent(
                    it
                )
            }
        }
        subscribeEvent<ShowPublicPlayerChatChanged>(Events.SHOW_PUBLIC_PLAYER_CHAT_CHANGED) {
            executeIfListening {
                onShowPublicPlayerChatChanged(
                    it
                )
            }
        }
        subscribeEvent<SoundEffectReceived>(Events.SOUND_EFFECT_RECEIVED) {
            executeIfListening {
                onSoundEffectReceived(
                    it
                )
            }
        }
        subscribeEvent<WidgetColorChanged>(Events.WIDGET_COLOR_CHANGED) { executeIfListening { onWidgetColorChanged(it) } }
        subscribeEvent<WidgetModelChanged>(Events.WIDGET_MODEL_CHANGED) { executeIfListening { onWidgetModelChanged(it) } }
        subscribeEvent<WidgetModelRotate>(Events.WIDGET_MODEL_ROTATE) { executeIfListening { onWidgetModelRotate(it) } }
        subscribeEvent<WidgetPositionChanged>(Events.WIDGET_POSITION_CHANGED) {
            executeIfListening {
                onWidgetPositionChanged(
                    it
                )
            }
        }
        subscribeEvent<WidgetScrollHeightChanged>(Events.WIDGET_SCROLL_HEIGHT_CHANGED) {
            executeIfListening {
                onWidgetScrollHeightChanged(
                    it
                )
            }
        }
        subscribeEvent<WidgetSequenceChanged>(Events.WIDGET_SEQUENCE_CHANGED) {
            executeIfListening {
                onWidgetSequenceChanged(
                    it
                )
            }
        }
        subscribeEvent<WidgetSetNpcHead>(Events.WIDGET_SET_NPC_HEAD) { executeIfListening { onWidgetSetNpcHead(it) } }
        subscribeEvent<WidgetSetObject>(Events.WIDGET_SET_OBJECT) { executeIfListening { onWidgetSetObject(it) } }
        subscribeEvent<WidgetSetPlayerHead>(Events.WIDGET_SET_PLAYER_HEAD) {
            executeIfListening {
                onWidgetSetPlayerHead(
                    it
                )
            }
        }
        subscribeEvent<WidgetTextChanged>(Events.WIDGET_TEXT_CHANGED) { executeIfListening { onWidgetTextChanged(it) } }
        subscribeEvent<WidgetVisibilityChange>(Events.WIDGET_VISIBILITY_CHANGE) {
            executeIfListening {
                onWidgetVisibilityChange(
                    it
                )
            }
        }
        subscribeEvent<WidgetZoomChanged>(Events.WIDGET_ZOOM_CHANGED) { executeIfListening { onWidgetZoomChanged(it) } }
        subscribeEvent<PlayerChanged>(Events.PLAYER_CHANGED) { executeIfListening { onPlayerChanged(it) } }
        subscribeEvent<WidgetClosed>(Events.WIDGET_CLOSED) { executeIfListening { onWidgetClosed(it) } }

    }

    private inline fun <reified T : Any> subscribeEvent(type: Enum<*>, noinline unit: (T) -> Unit) {
        subscribe(type, threadMode = SubscriberThreadMode.POSTING) { event -> unit.invoke(event.data) }
    }


    fun unsubscribe() {
        unsubscribeAll()
        eventListening = false
    }

    fun subscribe() {
        subscribeEvents()

        eventListening = true
    }

    private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

    val randomString = (1..10)
        .map { kotlin.random.Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")

    override val SUBSCRIBER_TAG: String
        get() = randomString

    override val KEVENT_INSTANCE: KEvent
        get() = Main.eventBus
}