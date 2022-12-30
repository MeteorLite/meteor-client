package meteor.plugins.prayervsplayer

import eventbus.events.GameTick
import eventbus.events.InteractingChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.HotkeyListener
import meteor.util.WeaponMap
import meteor.util.WeaponStyle
import net.runelite.api.*
import net.runelite.api.kit.KitType
import com.google.common.base.Supplier
import meteor.input.KeyManager

@PluginDescriptor(name = "Prayer vs Player", description = "Auto prayer.", enabledByDefault = false)
class PrayerVsPlayer : Plugin() {
    private var lastEnemy: Player? = null
    val config = configuration<PrayerVsPlayerConfig>()
    var enabled = false;

    override fun onGameTick(it: GameTick) {
        if (client.gameState != GameState.LOGGED_IN || !enabled) {
            return;
        }

        doAutoSwapPrayers();
    }

    override fun onStart() {
        enabled = true
        KeyManager.registerKeyListener(toggle, this.javaClass)
    }

    override fun onStop() {
        KeyManager.unregisterKeyListener(toggle)
    }

    private val toggle: HotkeyListener = object : HotkeyListener(Supplier { config.ToggleKey() }) {
        override fun hotkeyPressed() {
            enabled = !enabled
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Prayer vs Player ${if (enabled) "enabled" else "disabled"}", null)
        }
    }

    override fun onInteractingChanged(it: InteractingChanged) {
        if (it.source != client.localPlayer || client.gameState != GameState.LOGGED_IN) {
            return
        }
        val localPlayer = client.localPlayer
        val players = client.players

        for (player in players) {
            if (localPlayer != null && player === localPlayer.interacting) {
                lastEnemy = player
            }
        }
    }

    private fun activatePrayer(prayer: Prayer) {
        if (prayer == null) {
            return;
        }

        //check if prayer is already active this tick
        if (client.isPrayerActive(prayer)) {
            return;
        }

        var widgetInfo = prayer.widgetInfo ?: return
        var prayerWidget = client.getWidget(widgetInfo) ?: return

        if (client.getBoostedSkillLevel(Skill.PRAYER) <= 0) {
            return;
        }
        ClientThread.invoke {
            client.invokeMenuAction("Activate", prayerWidget.name, 1, MenuAction.CC_OP.id, prayerWidget.itemId, prayerWidget.id)
        }
    }

    private fun doAutoSwapPrayers() {
        try {
            if (lastEnemy == null) {
                return
            }
            val lastEnemyAppearance: PlayerComposition = lastEnemy?.playerComposition ?: return

            when (WeaponMap.StyleMap[lastEnemyAppearance.getEquipmentId(KitType.WEAPON)]) {
                WeaponStyle.MELEE -> activatePrayer(Prayer.PROTECT_FROM_MELEE)
                WeaponStyle.RANGE -> activatePrayer(Prayer.PROTECT_FROM_MISSILES)
                WeaponStyle.MAGIC -> activatePrayer(Prayer.PROTECT_FROM_MAGIC)
                else -> {}
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}