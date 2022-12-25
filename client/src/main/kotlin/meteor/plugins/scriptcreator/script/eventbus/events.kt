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
import kotlin.random.Random


 val r = Random(233)
 inline infix operator fun Int.rem(block: () -> Unit) {
  if (r.nextInt(100) < this) block()
 }


 fun onGameTick(it: (GameTick) -> Unit) {
  onGameTick = it
 }

 var onGameTick: (GameTick) -> Unit = {}
 fun onNpcLootReceived(it: (NpcLootReceived) -> Unit) {
  onNpcLootReceived = it
 }

 var onNpcLootReceived: (NpcLootReceived) -> Unit = {}
 fun onPlayerLootReceived(it: (PlayerLootReceived) -> Unit) {
  onPlayerLootReceived = it
 }

 var onPlayerLootReceived: (PlayerLootReceived) -> Unit = {}
 fun onMenuShouldLeftClick(it: (MenuShouldLeftClick) -> Unit) {
  onMenuShouldLeftClick = it
 }

 var onMenuShouldLeftClick: (MenuShouldLeftClick) -> Unit = {}
 fun onWorldListLoad(it: (WorldListLoad) -> Unit) {
  onWorldListLoad = it
 }

 var onWorldListLoad: (WorldListLoad) -> Unit = {}
 fun onWidgetPressed(it: (WidgetPressed) -> Unit) {
  onWidgetPressed = it
 }

 var onWidgetPressed: (WidgetPressed) -> Unit = {}
 fun onWidgetPositioned(it: (WidgetPositioned) -> Unit) {
  onWidgetPositioned = it
 }

 var onWidgetPositioned: (WidgetPositioned) -> Unit = {}
 fun onWidgetLoaded(it: (WidgetLoaded) -> Unit) {
  onWidgetLoaded = it
 }

 var onWidgetLoaded: (WidgetLoaded) -> Unit = {}
 fun onWidgetHiddenChanged(it: (WidgetHiddenChanged) -> Unit) {
  onWidgetHiddenChanged = it
 }

 var onWidgetHiddenChanged: (WidgetHiddenChanged) -> Unit = {}
 fun onVarbitChanged(it: (VarbitChanged) -> Unit) {
  onVarbitChanged = it
 }

 var onVarbitChanged: (VarbitChanged) -> Unit = {}
 fun onSoundEffectPlayed(it: (SoundEffectPlayed) -> Unit) {
  onSoundEffectPlayed = it
 }

 var onSoundEffectPlayed: (SoundEffectPlayed) -> Unit = {}
 fun onScriptPreFired(it: (ScriptPreFired) -> Unit) {
  onScriptPreFired = it
 }

 var onScriptPreFired: (ScriptPreFired) -> Unit = {}
 fun onScriptPostFired(it: (ScriptPostFired) -> Unit) {
  onScriptPostFired = it
 }

 var onScriptPostFired: (ScriptPostFired) -> Unit = {}
 fun onScriptCallbackEvent(it: (ScriptCallbackEvent) -> Unit) {
  onScriptCallbackEvent = it
 }

 var onScriptCallbackEvent: (ScriptCallbackEvent) -> Unit = {}
 fun onResizeableChanged(it: (ResizeableChanged) -> Unit) {
  onResizeableChanged = it
 }

 var onResizeableChanged: (ResizeableChanged) -> Unit = {}
 fun onProjetileSpawned(it: (ProjectileSpawned) -> Unit) {
  onProjetileSpawned = it
 }

 var onProjetileSpawned: (ProjectileSpawned) -> Unit = {}
 fun onStatChanged(it: (StatChanged) -> Unit) {
  onStatChanged = it
 }

 var onStatChanged: (StatChanged) -> Unit = {}
 fun onPlayerSpawned(it: (PlayerSpawned) -> Unit) {
  onPlayerSpawned = it
 }

 var onPlayerSpawned: (PlayerSpawned) -> Unit = {}
 fun onPlayerSkullChanged(it: (PlayerSkullChanged) -> Unit) {
  onPlayerSkullChanged = it
 }

 var onPlayerSkullChanged: (PlayerSkullChanged) -> Unit = {}
 fun onPlayerMenuOptionsChanged(it: (PlayerMenuOptionsChanged) -> Unit) {
  onPlayerMenuOptionsChanged = it
 }

 var onPlayerMenuOptionsChanged: (PlayerMenuOptionsChanged) -> Unit = {}
 fun onPlayerDespawned(it: (PlayerDespawned) -> Unit) {
  onPlayerDespawned = it
 }

 var onPlayerDespawned: (PlayerDespawned) -> Unit = {}
 fun onOverheadPrayerChanged(it: (OverheadPrayerChanged) -> Unit) {
  onOverheadPrayerChanged = it
 }

 var onOverheadPrayerChanged: (OverheadPrayerChanged) -> Unit = {}
 fun onNpcActionChanged(it: (NpcActionChanged) -> Unit) {
  onNpcActionChanged = it
 }

 var onNpcActionChanged: (NpcActionChanged) -> Unit = {}
 fun onMenuOptionClicked(it: (MenuOptionClicked) -> Unit) {
  onMenuOptionClicked = it
 }

 var onMenuOptionClicked: (MenuOptionClicked) -> Unit = {}
 fun onMenuEntryAdded(it: (MenuEntryAdded) -> Unit) {
  onMenuEntryAdded = it
 }

 var onMenuEntryAdded: (MenuEntryAdded) -> Unit = {}
 fun onMenuActionProcessed(it: (MenuActionProcessed) -> Unit) {
  onMenuActionProcessed = it
 }

 var onMenuActionProcessed: (MenuActionProcessed) -> Unit = {}
 fun onLoginStateChanged(it: (LoginStateChanged) -> Unit) {
  onLoginStateChanged = it
 }

 var onLoginStateChanged: (LoginStateChanged) -> Unit = {}
 fun onItemQuantityChanged(it: (ItemQuantityChanged) -> Unit) {
  onItemQuantityChanged = it
 }

 var onItemQuantityChanged: (ItemQuantityChanged) -> Unit = {}
 fun onItemObtained(it: (ItemObtained) -> Unit) {
  onItemObtained = it
 }

 var onItemObtained: (ItemObtained) -> Unit = {}
 fun onItemContainerChanged(it: (ItemContainerChanged) -> Unit) {
  onItemContainerChanged = it
 }

 var onItemContainerChanged: (ItemContainerChanged) -> Unit = {}
 fun onHealthBarUpdated(it: (HealthBarUpdated) -> Unit) {
  onHealthBarUpdated = it
 }

 var onHealthBarUpdated: (HealthBarUpdated) -> Unit = {}
 fun onGraphicsObjectCreated(it: (GraphicsObjectCreated) -> Unit) {
  onGraphicsObjectCreated = it
 }

 var onGraphicsObjectCreated: (GraphicsObjectCreated) -> Unit = {}
 fun onGrandExchangeOfferChanged(it: (GrandExchangeOfferChanged) -> Unit) {
  onGrandExchangeOfferChanged = it
 }

 var onGrandExchangeOfferChanged: (GrandExchangeOfferChanged) -> Unit = {}
 fun onFocusChanged(it: (FocusChanged) -> Unit) {
  onFocusChanged = it
 }

 var onFocusChanged: (FocusChanged) -> Unit = {}
 fun onExperienceGained(it: (ExperienceGained) -> Unit) {
  onExperienceGained = it
 }

 var onExperienceGained: (ExperienceGained) -> Unit = {}
 fun onDynamicObjectAnimationChanged(it: (DynamicObjectAnimationChanged) -> Unit) {
  onDynamicObjectAnimationChanged = it
 }

 var onDynamicObjectAnimationChanged: (DynamicObjectAnimationChanged) -> Unit = {}
 fun onDialogProcessed(it: (DialogProcessed) -> Unit) {
  onDialogProcessed = it
 }

 var onDialogProcessed: (DialogProcessed) -> Unit = {}
 fun onClientTick(it: (ClientTick) -> Unit) {
  onClientTick = it
 }

 var onClientTick: (ClientTick) -> Unit = {}
 fun onClientLoaded(it: (ClientLoaded) -> Unit) {
  onClientLoaded = it
 }

 var onClientLoaded: (ClientLoaded) -> Unit = {}
 fun onClanMemberLeft(it: (ClanMemberLeft) -> Unit) {
  onClanMemberLeft = it
 }

 var onClanMemberLeft: (ClanMemberLeft) -> Unit = {}
 fun onClanMemberJoined(it: (ClanMemberJoined) -> Unit) {
  onClanMemberJoined = it
 }

 var onClanMemberJoined: (ClanMemberJoined) -> Unit = {}
 fun onClanChannelChanged(it: (ClanChannelChanged) -> Unit) {
  onClanChannelChanged = it
 }

 var onClanChannelChanged: (ClanChannelChanged) -> Unit = {}
 fun onChatMessage(it: (ChatMessage) -> Unit) {
  onChatMessage = it
 }

 var onChatMessage: (ChatMessage) -> Unit = {}
 fun onCanvasSizeChanged(it: (CanvasSizeChanged) -> Unit) {
  onCanvasSizeChanged = it
 }

 var onCanvasSizeChanged: (CanvasSizeChanged) -> Unit = {}
 fun onBeforeMenuRender(it: (BeforeMenuRender) -> Unit) {
  onBeforeMenuRender = it
 }

 var onBeforeMenuRender: (BeforeMenuRender) -> Unit = {}
 fun onAreaSoundEffectPlayed(it: (AreaSoundEffectPlayed) -> Unit) {
  onAreaSoundEffectPlayed = it
 }

 var onAreaSoundEffectPlayed: (AreaSoundEffectPlayed) -> Unit = {}
 fun onAnimationChanged(it: (AnimationChanged) -> Unit) {
  onAnimationChanged = it
 }

 var onAnimationChanged: (AnimationChanged) -> Unit = {}
 fun onActorDeath(it: (ActorDeath) -> Unit) {
  onActorDeath = it
 }

 var onActorDeath: (ActorDeath) -> Unit = {}
 fun onGameStateChanged(it: (GameStateChanged) -> Unit) {
  onGameStateChanged = it
 }

 var onGameStateChanged: (GameStateChanged) -> Unit = {}
 fun onInteractingChanged(it: (InteractingChanged) -> Unit) {
  onInteractingChanged = it
 }

 var onInteractingChanged: (InteractingChanged) -> Unit = {}
 fun onNPCSpawned(it: (NpcSpawned) -> Unit) {
  onNPCSpawned = it
 }

 var onNPCSpawned: (NpcSpawned) -> Unit = {}
 fun onNPCDespawned(it: (NpcDespawned) -> Unit) {
  onNPCDespawned = it
 }

 var onNPCDespawned: (NpcDespawned) -> Unit = {}
 fun onGameObjectSpawned(it: (GameObjectSpawned) -> Unit) {
  onGameObjectSpawned = it
 }

 var onGameObjectSpawned: (GameObjectSpawned) -> Unit = {}
 fun onGameObjectChanged(it: (GameObjectChanged) -> Unit) {
  onGameObjectChanged = it
 }

 var onGameObjectChanged: (GameObjectChanged) -> Unit = {}
 fun onGameObjectDespawned(it: (GameObjectDespawned) -> Unit) {
  onGameObjectDespawned = it
 }

 var onGameObjectDespawned: (GameObjectDespawned) -> Unit = {}
 fun onGroundObjectSpawned(it: (GroundObjectSpawned) -> Unit) {
  onGroundObjectSpawned = it
 }

 var onGroundObjectSpawned: (GroundObjectSpawned) -> Unit = {}
 fun onGroundObjectChanged(it: (GroundObjectChanged) -> Unit) {
  onGroundObjectChanged = it
 }

 var onGroundObjectChanged: (GroundObjectChanged) -> Unit = {}
 fun onGroundObjectDespawned(it: (GroundObjectDespawned) -> Unit) {
  onGroundObjectDespawned = it
 }

 var onGroundObjectDespawned: (GroundObjectDespawned) -> Unit = {}
 fun onWallObjectSpawned(it: (WallObjectSpawned) -> Unit) {
  onWallObjectSpawned = it
 }

 var onWallObjectSpawned: (WallObjectSpawned) -> Unit = {}
 fun onWallObjectChanged(it: (WallObjectChanged) -> Unit) {
  onWallObjectChanged = it
 }

 var onWallObjectChanged: (WallObjectChanged) -> Unit = {}
 fun onWallObjectDespawned(it: (WallObjectDespawned) -> Unit) {
  onWallObjectDespawned = it
 }

 var onWallObjectDespawned: (WallObjectDespawned) -> Unit = {}
 fun onDecorativeObjectSpawned(it: (DecorativeObjectSpawned) -> Unit) {
  onDecorativeObjectSpawned = it
 }

 var onDecorativeObjectSpawned: (DecorativeObjectSpawned) -> Unit = {}
 fun onDecorativeObjectChanged(it: (DecorativeObjectChanged) -> Unit) {
  onDecorativeObjectChanged = it
 }

 var onDecorativeObjectChanged: (DecorativeObjectChanged) -> Unit = {}
 fun onDecorativeObjectDespawned(it: (DecorativeObjectDespawned) -> Unit) {
  onDecorativeObjectDespawned = it
 }

 var onDecorativeObjectDespawned: (DecorativeObjectDespawned) -> Unit = {}
 fun onItemSpawned(it: (ItemSpawned) -> Unit) {
  onItemSpawned = it
 }

 var onItemSpawned: (ItemSpawned) -> Unit = {}
 fun onItemDespawned(it: ItemDespawned) {}
 var onItemDespawned: (ItemDespawned) -> Unit = {}
 fun onNpcSpawned(it: (NpcSpawned) -> Unit) {
  onNpcSpawned = it
 }

 var onNpcSpawned: (NpcSpawned) -> Unit = {}
 fun onNpcChanged(it: (NpcChanged) -> Unit) {
  onNpcChanged = it
 }

 var onNpcChanged: (NpcChanged) -> Unit = {}
 fun onNpcDespawned(it: (NpcDespawned) -> Unit) {
  onNpcDespawned = it
 }

 var onNpcDespawned: (NpcDespawned) -> Unit = {}
 fun onProjectileMoved(it: (ProjectileMoved) -> Unit) {
  onProjectileMoved = it
 }

 var onProjectileMoved: (ProjectileMoved) -> Unit = {}
 fun onConfigChanged(it: (ConfigChanged) -> Unit) {
  onConfigChanged = it
 }

 var onConfigChanged: (ConfigChanged) -> Unit = {}
 fun onPostItemComposition(it: (PostItemComposition) -> Unit) {
  onPostItemComposition = it
 }

 var onPostItemComposition: (PostItemComposition) -> Unit = {}
 fun onBeforeRender(it: (BeforeRender) -> Unit) {
  onBeforeRender = it
 }

 var onBeforeRender: (BeforeRender) -> Unit = {}
 fun onPluginChanged(it: (PluginChanged) -> Unit) {
  onPluginChanged = it
 }

 var onPluginChanged: (PluginChanged) -> Unit = {}
 fun onInfoBoxMenuClicked(it: (InfoBoxMenuClicked) -> Unit) {
  onInfoBoxMenuClicked = it
 }

 var onInfoBoxMenuClicked: (InfoBoxMenuClicked) -> Unit = {}
 fun onOverheadTextChanged(it: (OverheadTextChanged) -> Unit) {
  onOverheadTextChanged = it
 }

 var onOverheadTextChanged: (OverheadTextChanged) -> Unit = {}
 fun onInvokeMenuAction(it: (AutomatedMenu) -> Unit) {
  onInvokeMenuAction = it
 }

 var onInvokeMenuAction: (AutomatedMenu) -> Unit = {}
 fun onHitsplatApplied(it: (HitsplatApplied) -> Unit) {
  onHitsplatApplied = it
 }

 var onHitsplatApplied: (HitsplatApplied) -> Unit = {}
 fun onPacketSent(it: (PacketSent) -> Unit) {
  onPacketSent = it
 }

 var onPacketSent: (PacketSent) -> Unit = {}
 fun onPostHealthBar(it: (PostHealthBar) -> Unit) {
  onPostHealthBar = it
 }

 var onPostHealthBar: (PostHealthBar) -> Unit = {}
 fun onGraphicChanged(it: (GraphicChanged) -> Unit) {
  onGraphicChanged = it
 }

 var onGraphicChanged: (GraphicChanged) -> Unit = {}
 fun onProjectileSpawned(it: (ProjectileSpawned) -> Unit) {
  onProjectileSpawned = it
 }

 var onProjectileSpawned: (ProjectileSpawned) -> Unit = {}
 fun onWorldChanged(it: (WorldChanged) -> Unit) {
  onWorldChanged = it
 }

 var onWorldChanged: (WorldChanged) -> Unit = {}
 fun onGrandExchangeSearched(it: (GrandExchangeSearched) -> Unit) {
  onGrandExchangeSearched = it
 }

 var onGrandExchangeSearched: (GrandExchangeSearched) -> Unit = {}
 fun onCheatEntered(it: (CheatEntered) -> Unit) {
  onCheatEntered = it
 }

 var onCheatEntered: (CheatEntered) -> Unit = {}




