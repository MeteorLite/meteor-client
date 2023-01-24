package meteor.plugins.autologhop

import dev.hoot.api.game.Worlds
import dev.hoot.api.packets.WidgetPackets
import eventbus.events.GameStateChanged
import eventbus.events.GameTick
import eventbus.events.PlayerSpawned
import meteor.Main
import meteor.Main.executor
import meteor.Main.worldService
import meteor.api.items.Items
import meteor.api.packets.ClientPackets
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetInfo
import net.runelite.http.api.worlds.World
import net.runelite.http.api.worlds.WorldResult
import net.runelite.http.api.worlds.WorldType
import java.awt.event.KeyEvent
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.math.abs

@PluginDescriptor(
    name = "AutoLogHop",
    description = "Auto hops/logs out when another player is seen.",
    enabledByDefault = false
)

class AutoLogHop : Plugin() {
    var config = configuration<AutoLogHopConfig>()

    private var login = false
    fun startup() {
        val full = Items.isFull()
    }

    fun shutdown() {}

    override fun onGameTick(it: GameTick) {
        if (nearPlayer()) {
            handleAction()
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {

        if (!login || Main.client.gameState != GameState.LOGIN_SCREEN || config.user().isBlank() || config.password()
                .isBlank()
        ) {
            return
        }
        hopWorlds()
        executor.submit(Runnable {
            sleep(600)
            pressKey(KeyEvent.VK_ENTER)
            client.username = config.user()
            client.password = config.password()
            sleep(600)
            pressKey(KeyEvent.VK_ENTER)
            pressKey(KeyEvent.VK_ENTER)
        })
        login = false
    }

    override fun onPlayerSpawned(it: PlayerSpawned) {
        if (isPlayerBad(it.player)) handleAction()
    }

    private fun nearPlayer(): Boolean {
        val players: List<Player> = client.players
        for (p in players) {
            if (!isPlayerBad(p)) continue
            return true
        }
        return false
    }

    private fun handleAction() {
        when (config.method()) {
            Method.HOP -> hopWorlds()
            Method.TELEPORT -> teleportAway()
            else -> {
                logout()
                login = config.method() == Method.LOGOUT_HOP //only login if we caused logout
            }
        }
    }

    fun getWildernessLevelFrom(point: WorldPoint): Int {
        val x = point.x
        val y = point.y
        val underLevel = (y - 9920) / 8 + 1
        val upperLevel = (y - 3520) / 8 + 1
        return if (y > 6400) underLevel else upperLevel
    }

    fun isAttackable(player: Player): Boolean {
        var wildernessLevel = 0
        if (!(client.getVarbitValue(Varbits.IN_WILDERNESS) == 1 || net.runelite.api.WorldType.isPvpWorld(client.worldType))) {
            return false
        }
        if (net.runelite.api.WorldType.isPvpWorld(client.worldType)) {
            if (client.getVarbitValue(Varbits.IN_WILDERNESS) != 1) {
                return abs(client.localPlayer!!.combatLevel - player.combatLevel) <= 15
            }
            wildernessLevel = 15
        }
        return (Math.abs(client.localPlayer!!.combatLevel - player.combatLevel)
                < getWildernessLevelFrom(client.localPlayer!!.worldLocation) + wildernessLevel)
    }

    private fun teleportAway() {
        //can't use ring of wealth above lv 30 wilderness.
        if (getWildernessLevelFrom(client.localPlayer!!.worldLocation) > 30) return
        //not as janky as inventory items kek
        val equipment: Widget = client.getWidget(WidgetInfo.EQUIPMENT_RING)!!
        val container: ItemContainer = client.getItemContainer(InventoryID.EQUIPMENT)!!
        //don't attempt to tele if we don't have a ring lol
        if (Arrays.stream<Item>(container.items).noneMatch { item: Item ->
                client.getItemComposition(item.id).name.lowercase(
                    Locale.getDefault()
                ).contains("ring of wealth (")
            }) return

        //client.invokeMenuAction("Grand Exchange", "<col=ff9040>Ring of wealth ( )</col>", 3, MenuAction.CC_OP.getId(), -1, equipment.getId());
        val ring: WidgetInfo = WidgetInfo.EQUIPMENT_RING
        val ringWidget: Widget = client.getWidget(ring)!!
        WidgetPackets.widgetAction(ringWidget, "Grand Exchange")
        ClientPackets.queueClickPacket(ringWidget.clickPoint)
    }

    private fun passedWildernessChecks(): Boolean {
        return config.disableWildyChecks() || inWilderness()
    }

    private fun isPlayerBad(player: Player): Boolean {
        if (player === client.localPlayer) return false
        if (isInWhitelist(player.name)) return false
        if (config.combatRange() && !isAttackable(player)) return false
        if (config.skulledOnly() && !isPlayerSkulled(player)) return false
        return passedWildernessChecks()
    }

    private val validWorld: Int
        private get() {
            val result: WorldResult = worldService.getWorlds() ?: return -1
            val worlds: List<World> = result.worlds
            Collections.shuffle(worlds)
            for (w in worlds) {
                if (client.world == w.id) continue
                if (w.types.contains(WorldType.HIGH_RISK) ||
                    w.types.contains(WorldType.DEADMAN) ||
                    w.types.contains(WorldType.PVP) ||
                    w.types.contains(WorldType.SKILL_TOTAL) ||
                    w.types.contains(WorldType.BOUNTY) || config.membersWorlds() != w.types.contains(WorldType.MEMBERS)
                ) continue
                return w.id
            }
            return -1
        }

    private fun hopWorlds() {
        assert(client.isClientThread)
        val world: net.runelite.api.World =
            Worlds.getRandom { x: net.runelite.api.World -> x.id != client.world && x.isNormal && x.isMembers }
        val rsWorld = client.createWorld()
        rsWorld.activity = world.activity
        rsWorld.address = world.address
        rsWorld.id = world.id
        rsWorld.playerCount = world.playerCount
        rsWorld.location = world.location
        rsWorld.types = world.types
        if (client.gameState == GameState.LOGIN_SCREEN) {
            // on the login screen we can just change the world by ourselves
            client.changeWorld(rsWorld)
            return
        }
        if (client.getWidget(WidgetInfo.WORLD_SWITCHER_LIST) == null) {
            client.openWorldHopper()
            executor.submit(Runnable {
                try {
                    Thread.sleep((25 + ThreadLocalRandom.current().nextInt(125)).toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
                ClientThread.invokeLater {
                    if (client.getWidget(WidgetInfo.WORLD_SWITCHER_LIST) != null) client.hopToWorld(rsWorld)
                }
            })
        } else {
            client.hopToWorld(rsWorld)
        }
    }

    private fun logout() {
        val logoutButton = client.getWidget(182, 8)
        val logoutDoorButton = client.getWidget(69, 23)
        var param1 = -1
        if (logoutButton != null) {
            param1 = logoutButton.id
        } else if (logoutDoorButton != null) {
            param1 = logoutDoorButton.id
        }
        if (param1 == -1) {
            return
        }
    }

    fun inWilderness(): Boolean {
        return client.getVar(Varbits.IN_WILDERNESS) === 1
    }

    fun isInWhitelist(username: String): Boolean {
        var username = username
        username = username.lowercase(Locale.getDefault()).replace(" ", "_")
        val names =
            config.whitelist().lowercase(Locale.getDefault()).replace(" ", "_").split(",".toRegex()).toTypedArray()
        for (whitelisted in names) {
            if (whitelisted.isBlank() || whitelisted.isEmpty() || whitelisted == "_") continue

            //remove trailing whitespace on names.
            //if (whitelisted.charAt(whitelisted.length() - 1) == ' ')
            //	whitelisted = whitelisted.substring(0, whitelisted.length() - 1);
            if (whitelisted == username) return true
        }
        return false
    }

    private fun isPlayerSkulled(player: Player?): Boolean {
        return if (player == null) {
            false
        } else player.skullIcon == SkullIcon.SKULL
    }

    fun pressKey(key: Int) {
        keyEvent(KeyEvent.KEY_PRESSED, key)
        keyEvent(KeyEvent.KEY_RELEASED, key)
    }

    private fun keyEvent(id: Int, key: Int) {
        val e = KeyEvent(
            client.canvas, id, System.currentTimeMillis(),
            0, key, KeyEvent.CHAR_UNDEFINED
        )
        client.canvas.dispatchEvent(e)
    }

    companion object {
        fun sleep(time: Long) {
            if (time > 0) {
                try {
                    Thread.sleep(time)
                } catch (e: InterruptedException) {
                    throw RuntimeException(e)
                }
            }
        }
    }
}