package meteor.plugins.scriptcreator.script.eventbus

import dev.hoot.api.events.AutomatedMenu
import dev.hoot.api.events.MenuActionProcessed
import dev.hoot.api.events.PacketSent
import eventbus.Events
import eventbus.events.*
import meteor.events.InfoBoxMenuClicked
import meteor.events.NpcLootReceived
import meteor.events.PlayerLootReceived
import meteor.events.PluginChanged
import meteor.plugins.Plugin

open class ScriptSubscriber : Plugin() {
    open fun subscribeScript() {

        subscribeEvent<MenuShouldLeftClick>(Events.MENU_SHOULD_LEFT_CLICK) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onMenuShouldLeftClick(it)
            }
        }
        subscribeEvent<ActorDeath>(Events.ACTOR_DEATH) { executeIfListening { onActorDeath(it) } }
        subscribeEvent<AnimationChanged>(Events.ANIMATION_CHANGED) { executeIfListening { onAnimationChanged(it) } }
        subscribeEvent<AreaSoundEffectPlayed>(Events.AREA_SOUND_EFFECT_PLAYED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onAreaSoundEffectPlayed(
                    it
                )
            }
        }
        subscribeEvent<BeforeRender>(Events.BEFORE_RENDER) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onBeforeRender(
                    it
                )
            }
        }
        subscribeEvent<BeforeMenuRender>(Events.BEFORE_MENU_RENDER) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onBeforeMenuRender(
                    it
                )
            }
        }
        subscribeEvent<CanvasSizeChanged>(Events.CANVAS_SIZE_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onCanvasSizeChanged(
                    it
                )
            }
        }
        subscribeEvent<ChatMessage>(Events.CHAT_MESSAGE) { executeIfListening { onChatMessage(it) } }
        subscribeEvent<ClanChannelChanged>(Events.CLAN_CHANNEL_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onClanChannelChanged(
                    it
                )
            }
        }
        subscribeEvent<ClanMemberJoined>(Events.CLAN_MEMBER_JOINED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onClanMemberJoined(
                    it
                )
            }
        }
        subscribeEvent<ClanMemberLeft>(Events.CLAN_MEMBER_LEFT) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onClanMemberLeft(
                    it
                )
            }
        }
        subscribeEvent<ClientLoaded>(Events.CLIENT_LOADED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onClientLoaded(
                    it
                )
            }
        }
        subscribeEvent<ClientTick>(Events.CLIENT_TICK) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onClientTick(
                    it
                )
            }
        }
        subscribeEvent<ConfigChanged>(Events.CONFIG_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onConfigChanged(
                    it
                )
            }
        }
        subscribeEvent<DecorativeObjectChanged>(Events.DECORATIVE_OBJECT_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onDecorativeObjectChanged(
                    it
                )
            }
        }
        subscribeEvent<DecorativeObjectDespawned>(Events.DECORATIVE_OBJECT_DESPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onDecorativeObjectDespawned(
                    it
                )
            }
        }
        subscribeEvent<DecorativeObjectSpawned>(Events.DECORATIVE_OBJECT_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onDecorativeObjectSpawned(
                    it
                )
            }
        }
        subscribeEvent<DialogProcessed>(Events.DIALOG_PROCESSED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onDialogProcessed(
                    it
                )
            }
        }
        subscribeEvent<DynamicObjectAnimationChanged>(Events.DYNAMIC_OBJECT_ANIMATION_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onDynamicObjectAnimationChanged(
                    it
                )
            }
        }
        subscribeEvent<ExperienceGained>(Events.EXPERIENCE_GAINED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onExperienceGained(
                    it
                )
            }
        }
        subscribeEvent<FocusChanged>(Events.FOCUS_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onFocusChanged(
                    it
                )
            }
        }
        subscribeEvent<GameObjectChanged>(Events.GAME_OBJECT_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGameObjectChanged(
                    it
                )
            }
        }
        subscribeEvent<GameObjectDespawned>(Events.GAME_OBJECT_DESPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGameObjectDespawned(
                    it
                )
            }
        }
        subscribeEvent<GameObjectSpawned>(Events.GAME_OBJECT_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGameObjectSpawned(
                    it
                )
            }
        }
        subscribeEvent<GameStateChanged>(Events.GAME_STATE_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGameStateChanged(
                    it
                )
            }
        }
        subscribeEvent<GameTick>(Events.GAME_TICK) { gt ->
            executeIfListening {

                meteor.plugins.scriptcreator.script.eventbus.onGameTick(gt)
            }

        }



        subscribeEvent<GrandExchangeOfferChanged>(Events.GRAND_EXCHANGE_OFFER_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGrandExchangeOfferChanged(
                    it
                )
            }
        }
        subscribeEvent<GraphicsObjectCreated>(Events.GRAPHICS_OBJECT_CREATED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGraphicsObjectCreated(
                    it
                )
            }
        }
        subscribeEvent<GroundObjectChanged>(Events.GROUND_OBJECT_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGroundObjectChanged(
                    it
                )
            }
        }
        subscribeEvent<GroundObjectDespawned>(Events.GROUND_OBJECT_DESPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGroundObjectDespawned(
                    it
                )
            }
        }
        subscribeEvent<GroundObjectSpawned>(Events.GROUND_OBJECT_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGroundObjectSpawned(
                    it
                )
            }
        }
        subscribeEvent<HealthBarUpdated>(Events.HEALTH_BAR_UPDATED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onHealthBarUpdated(
                    it
                )
            }
        }
        subscribeEvent<InteractingChanged>(Events.INTERACTING_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onInteractingChanged(
                    it
                )
            }
        }
        subscribeEvent<ItemContainerChanged>(Events.ITEM_CONTAINER_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onItemContainerChanged(
                    it
                )
            }
        }
        subscribeEvent<ItemDespawned>(Events.ITEM_DESPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onItemDespawned(
                    it
                )
            }
        }
        subscribeEvent<ItemObtained>(Events.ITEM_OBTAINED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onItemObtained(
                    it
                )
            }
        }
        subscribeEvent<ItemQuantityChanged>(Events.ITEM_QUANTITY_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onItemQuantityChanged(
                    it
                )
            }
        }
        subscribeEvent<ItemSpawned>(Events.ITEM_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onItemSpawned(
                    it
                )
            }
        }
        subscribeEvent<LoginStateChanged>(Events.LOGIN_STATE_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onLoginStateChanged(
                    it
                )
            }
        }
        subscribeEvent<MenuActionProcessed>(Events.MENU_ACTION_PROCESSED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onMenuActionProcessed(
                    it
                )
            }
        }
        subscribeEvent<MenuEntryAdded>(Events.MENU_ENTRY_ADDED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onMenuEntryAdded(
                    it
                )
            }
        }
        subscribeEvent<MenuOptionClicked>(Events.MENU_OPTION_CLICKED) {
            executeIfListening {
                if (it.menuEntry != null)
                    meteor.plugins.scriptcreator.script.eventbus.onMenuOptionClicked(it)
            }
        }
        subscribeEvent<NpcActionChanged>(Events.NPC_ACTION_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onNpcActionChanged(
                    it
                )
            }
        }
        subscribeEvent<NpcChanged>(Events.NPC_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onNpcChanged(
                    it
                )
            }
        }
        subscribeEvent<NpcDespawned>(Events.NPC_DESPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onNpcDespawned(
                    it
                )
            }
        }
        subscribeEvent<NpcLootReceived>(Events.NPC_LOOT_RECEIVED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onNpcLootReceived(
                    it
                )
            }
        }
        subscribeEvent<NpcSpawned>(Events.NPC_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onNpcSpawned(
                    it
                )
            }
        }
        subscribeEvent<AutomatedMenu>(Events.AUTOMATED_MENU) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onInvokeMenuAction(
                    it
                )
            }
        }
        subscribeEvent<OverheadTextChanged>(Events.OVERHEAD_TEXT_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onOverheadTextChanged(
                    it
                )
            }
        }
        subscribeEvent<OverheadPrayerChanged>(Events.OVERHEAD_PRAYER_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onOverheadPrayerChanged(
                    it
                )
            }
        }
        subscribeEvent<PlayerDespawned>(Events.PLAYER_DESPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPlayerDespawned(
                    it
                )
            }
        }
        subscribeEvent<PlayerMenuOptionsChanged>(Events.PLAYER_MENU_OPTIONS_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPlayerMenuOptionsChanged(
                    it
                )
            }
        }
        subscribeEvent<PlayerSkullChanged>(Events.PLAYER_SKULL_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPlayerSkullChanged(
                    it
                )
            }
        }
        subscribeEvent<PlayerSpawned>(Events.PLAYER_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPlayerSpawned(
                    it
                )
            }
        }
        subscribeEvent<PlayerLootReceived>(Events.PLAYER_LOOT_RECEIVED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPlayerLootReceived(
                    it
                )
            }
        }
        subscribeEvent<PostItemComposition>(Events.POST_ITEM_COMPOSITION) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPostItemComposition(
                    it
                )
            }
        }
        subscribeEvent<ProjectileMoved>(Events.PROJECTILE_MOVED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onProjectileMoved(
                    it
                )
            }
        }
        subscribeEvent<ProjectileSpawned>(Events.PROJECTILE_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onProjetileSpawned(
                    it
                )
            }
        }
        subscribeEvent<ResizeableChanged>(Events.RESIZEABLE_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onResizeableChanged(
                    it
                )
            }
        }
        subscribeEvent<ScriptCallbackEvent>(Events.SCRIPT_CALLBACK) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onScriptCallbackEvent(
                    it
                )
            }
        }
        subscribeEvent<ScriptPostFired>(Events.SCRIPT_POST_FIRED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onScriptPostFired(
                    it
                )
            }
        }
        subscribeEvent<ScriptPreFired>(Events.SCRIPT_PRE_FIRED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onScriptPreFired(
                    it
                )
            }
        }
        subscribeEvent<SoundEffectPlayed>(Events.SOUND_EFFECT_PLAYED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onSoundEffectPlayed(
                    it
                )
            }
        }
        subscribeEvent<StatChanged>(Events.STAT_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onStatChanged(
                    it
                )
            }
        }
        subscribeEvent<VarbitChanged>(Events.VARBIT_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onVarbitChanged(
                    it
                )
            }
        }
        subscribeEvent<WallObjectChanged>(Events.WALL_OBJECT_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWallObjectChanged(
                    it
                )
            }
        }
        subscribeEvent<WallObjectDespawned>(Events.WALL_OBJECT_DESPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWallObjectDespawned(
                    it
                )
            }
        }
        subscribeEvent<WallObjectSpawned>(Events.WALL_OBJECT_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWallObjectSpawned(
                    it
                )
            }
        }
        subscribeEvent<WidgetHiddenChanged>(Events.WIDGET_HIDDEN_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWidgetHiddenChanged(
                    it
                )
            }
        }
        subscribeEvent<WidgetLoaded>(Events.WIDGET_LOADED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWidgetLoaded(
                    it
                )
            }
        }
        subscribeEvent<WidgetPositioned>(Events.WIDGET_POSITIONED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWidgetPositioned(
                    it
                )
            }
        }
        subscribeEvent<WidgetPressed>(Events.WIDGET_PRESSED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWidgetPressed(
                    it
                )
            }
        }
        subscribeEvent<WorldListLoad>(Events.WORLD_LIST_LOAD) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWorldListLoad(
                    it
                )
            }
        }
        subscribeEvent<NpcSpawned>(Events.NPC_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onNPCSpawned(
                    it
                )
            }
        }
        subscribeEvent<NpcDespawned>(Events.NPC_DESPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onNPCDespawned(
                    it
                )
            }
        }
        subscribeEvent<PluginChanged>(Events.PLUGIN_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPluginChanged(
                    it
                )
            }
        }
        subscribeEvent<InfoBoxMenuClicked>(meteor.events.Events.INFO_BOX_MENU_CLICKED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onInfoBoxMenuClicked(
                    it
                )
            }
        }
        subscribeEvent<HitsplatApplied>(Events.HITSPLAT_APPLIED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onHitsplatApplied(
                    it
                )
            }
        }
        subscribeEvent<PacketSent>(Events.PACKET_SENT) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPacketSent(
                    it
                )
            }
        }

        subscribeEvent<PostHealthBar>(Events.POST_HEALTHBAR) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onPostHealthBar(
                    it
                )
            }
        }
        subscribeEvent<GraphicChanged>(Events.GRAPHIC_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGraphicChanged(
                    it
                )
            }
        }
        subscribeEvent<ProjectileSpawned>(Events.PROJECTILE_SPAWNED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onProjectileSpawned(
                    it
                )
            }
        }
        subscribeEvent<WorldChanged>(Events.WORLD_CHANGED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onWorldChanged(
                    it
                )
            }
        }
        subscribeEvent<GrandExchangeSearched>(Events.GRAND_EXCHANGE_SEARCHED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onGrandExchangeSearched(
                    it
                )
            }
        }
        subscribeEvent<CheatEntered>(Events.CHEAT_ENTERED) {
            executeIfListening {
                meteor.plugins.scriptcreator.script.eventbus.onCheatEntered(
                    it
                )
            }
        }
    }

}