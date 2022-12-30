package meteor.plugins.pvpkeys


import com.google.common.base.Supplier
import dev.hoot.api.magic.Ancient
import dev.hoot.api.magic.Magic
import dev.hoot.api.widgets.Prayers
import eventbus.events.ClientTick
import eventbus.events.GameTick
import eventbus.events.InteractingChanged
import eventbus.events.MenuOptionClicked
import meteor.api.items.Items
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.HotkeyListener
import meteor.util.WeaponMap
import meteor.util.WeaponStyle
import net.runelite.api.*
import net.runelite.api.kit.KitType
import net.runelite.api.widgets.WidgetInfo
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import java.util.*
import java.util.concurrent.ExecutorService

@PluginDescriptor(name = "pvpkeys", description = "hotkeys for pvp", enabledByDefault = false)
class PvPKeys : Plugin() {
    var r = Random()
    var target: Actor? = null
    private val keyManager = KeyManager
    val config = configuration<PvPKeysConfig>()
    var executor: ExecutorService? = null
    private var lastEnemy: Player? = null
    private var autoPrayEnabled = false

    override fun onGameTick(it: GameTick) {
        if (client.gameState != GameState.LOGGED_IN || !autoPrayEnabled) {
            return;
        }
        doAutoSwapPrayers();
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

    val meleeGear: MutableList<String>
        get() = mutableListOf(*config.MeleeIDs()!!.split(",").toTypedArray())

    val mageGear: MutableList<String>
        get() = mutableListOf(*config.MageIDs()!!.split(",").toTypedArray())

    val rangeGear: MutableList<String>
        get() = mutableListOf(*config.RangeIDs()!!.split(",").toTypedArray())


    override fun onStart() {
        keyManager.registerKeyListener(magepray, this.javaClass)
        keyManager.registerKeyListener(rangepray, this.javaClass)
        keyManager.registerKeyListener(meleepray, this.javaClass)
        keyManager.registerKeyListener(smite, this.javaClass)
        keyManager.registerKeyListener(brew, this.javaClass)
        keyManager.registerKeyListener(restore, this.javaClass)
        keyManager.registerKeyListener(quickpray, this.javaClass)
        keyManager.registerKeyListener(magegear, this.javaClass)
        keyManager.registerKeyListener(rangegear, this.javaClass)
        keyManager.registerKeyListener(meleegear, this.javaClass)
        keyManager.registerKeyListener(icebarrage, this.javaClass)
        keyManager.registerKeyListener(iceblitz, this.javaClass)
        keyManager.registerKeyListener(bloodblitz, this.javaClass)
        keyManager.registerKeyListener(augury, this.javaClass)
        keyManager.registerKeyListener(rigour, this.javaClass)
        keyManager.registerKeyListener(piety, this.javaClass)
        keyManager.registerKeyListener(lasttarget, this.javaClass)
        keyManager.registerKeyListener(ultimatestrength, this.javaClass)
        keyManager.registerKeyListener(eagleye, this.javaClass)
        keyManager.registerKeyListener(mysticmight, this.javaClass)
        keyManager.registerKeyListener(incrediblereflexes, this.javaClass)
        keyManager.registerKeyListener(toggleAutoprayer, this.javaClass)
    }

    override fun onStop() {
        keyManager.unregisterKeyListener(magepray)
        keyManager.unregisterKeyListener(rangepray)
        keyManager.unregisterKeyListener(meleepray)
        keyManager.unregisterKeyListener(smite)
        keyManager.unregisterKeyListener(brew)
        keyManager.unregisterKeyListener(restore)
        keyManager.unregisterKeyListener(quickpray)
        keyManager.unregisterKeyListener(magegear)
        keyManager.unregisterKeyListener(rangegear)
        keyManager.unregisterKeyListener(meleegear)
        keyManager.unregisterKeyListener(icebarrage)
        keyManager.unregisterKeyListener(iceblitz)
        keyManager.unregisterKeyListener(bloodblitz)
        keyManager.unregisterKeyListener(augury)
        keyManager.unregisterKeyListener(rigour)
        keyManager.unregisterKeyListener(piety)
        keyManager.unregisterKeyListener(lasttarget)
        keyManager.unregisterKeyListener(ultimatestrength)
        keyManager.unregisterKeyListener(eagleye)
        keyManager.unregisterKeyListener(mysticmight)
        keyManager.unregisterKeyListener(incrediblereflexes)
        keyManager.unregisterKeyListener(toggleAutoprayer)
    }

    private val toggleAutoprayer: HotkeyListener = object : HotkeyListener(Supplier { config.AutoPray() }) {
        override fun hotkeyPressed() {
            autoPrayEnabled = !autoPrayEnabled
            client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Autoprayer ${if (autoPrayEnabled) "enabled" else "disabled"}", null)
        }
    }


    private val magepray: HotkeyListener = object : HotkeyListener(Supplier { config.Magepray() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.PROTECT_FROM_MAGIC)
        }
    }

    private val rangepray: HotkeyListener = object : HotkeyListener(Supplier { config.Rangepray() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.PROTECT_FROM_MISSILES)
        }
    }

    private val meleepray: HotkeyListener = object : HotkeyListener(Supplier { config.Meleepray() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.PROTECT_FROM_MELEE)
        }
    }

    private val smite: HotkeyListener = object : HotkeyListener(Supplier { config.Smite() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.SMITE)
        }
    }

    private val brew: HotkeyListener = object : HotkeyListener(Supplier { config.Brew() }) {
        override fun hotkeyPressed() {
            if (Items.getFirst(6691, 6689, 6687, 6685) != null) {
                Items.getFirst(6691, 6689, 6687, 6685)?.interact(0)
            }
        }
    }

    private val restore: HotkeyListener = object : HotkeyListener(Supplier { config.Restore() }) {
        override fun hotkeyPressed() {
            Items.getFirst(3030, 3028, 3026, 3024)?.interact(0)
        }
    }

    private val quickpray: HotkeyListener = object : HotkeyListener(Supplier { config.Quickpray() }) {
        override fun hotkeyPressed() {
            Prayers.toggleQuickPrayer(!Prayers.isQuickPrayerEnabled())
        }
    }

    private val magegear: HotkeyListener = object : HotkeyListener(Supplier { config.Magegear() }) {
        override fun hotkeyPressed() {

            ClientThread.invokeLater {
                mageGear.forEach {
                    Items.getFirst(it)?.interact(2)
                }
            }
        }
    }

    private val meleegear: HotkeyListener = object : HotkeyListener(Supplier { config.Meleegear() }) {
        override fun hotkeyPressed() {
            ClientThread.invokeLater {
                meleeGear.forEach {
                    Items.getFirst(it)?.interact(2)
                }
            }
        }
    }

    private val rangegear: HotkeyListener = object : HotkeyListener(Supplier { config.Rangegear() }) {
        override fun hotkeyPressed() {
            ClientThread.invokeLater {
                rangeGear.forEach {
                    Items.getFirst(it)?.interact(2)
                }
            }
        }
    }

    private val icebarrage: HotkeyListener = object : HotkeyListener(Supplier { config.Icebarrage() }) {
        override fun hotkeyPressed() {
            Magic.selectSpell(Ancient.ICE_BARRAGE)
            if (target != null) {
                target!!.interact(0)
            }
        }
    }

    private val iceblitz: HotkeyListener = object : HotkeyListener(Supplier { config.Iceblitz() }) {
        override fun hotkeyPressed() {
            Magic.selectSpell(Ancient.ICE_BLITZ)
            if (target != null) {
                target!!.interact(0)
            }
        }
    }

    private val bloodblitz: HotkeyListener = object : HotkeyListener(Supplier { config.Bloodblitz() }) {
        override fun hotkeyPressed() {
            Magic.selectSpell(Ancient.BLOOD_BLITZ)
            if (target != null) {
                target!!.interact(0)
            }
        }
    }

    private val augury: HotkeyListener = object : HotkeyListener(Supplier { config.Augury() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.AUGURY)
        }
    }

    private val rigour: HotkeyListener = object : HotkeyListener(Supplier { config.Rigour() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.RIGOUR)
        }
    }

    private val piety: HotkeyListener = object : HotkeyListener(Supplier { config.Piety() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.PIETY)
        }
    }

    private val eagleye: HotkeyListener = object : HotkeyListener(Supplier { config.Eagleyye() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.EAGLE_EYE)
        }
    }

    private val incrediblereflexes: HotkeyListener = object : HotkeyListener(Supplier { config.Incrediblereflexes() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.INCREDIBLE_REFLEXES)
        }
    }

    private val ultimatestrength: HotkeyListener = object : HotkeyListener(Supplier { config.Ultimatestrength() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.ULTIMATE_STRENGTH)
        }
    }

    private val mysticmight: HotkeyListener = object : HotkeyListener(Supplier { config.Mysticmight() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.MYSTIC_MIGHT)
        }
    }

    private val lasttarget: HotkeyListener = object : HotkeyListener(Supplier { config.Lasttarget() }) {
        override fun hotkeyPressed() {
            target as Player
            target!!.interact("Attack")
        }
    }

    override fun onClientTick(it: ClientTick) {
        val gear = client.getWidget(WidgetInfo.EQUIPMENT.id)
        val mousePoint = client.mouseCanvasPosition
        if (gear != null) {
            if (gear.bounds.contains(mousePoint.x, mousePoint.y)) client.insertMenuItem("<col=00FFFF>Copy Gear</col>", "", 10000000, 100000, 0, 0, false)
        }
    }

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if ("<col=00FFFF>Copy Gear</col>" in it.getMenuOption()!!) {
            val i: ItemContainer? = client.getItemContainer(InventoryID.EQUIPMENT)
            val sb = StringBuilder()
            i?.items?.forEach {
                if (it.id == -1 || it.id == 0) {
                    return@forEach
                }
                sb.append(it.name)
                sb.append(",")
            }
            Toolkit.getDefaultToolkit().systemClipboard.setContents(StringSelection(sb.toString()), null)
        }
    }

    override fun onInteractingChanged(it: InteractingChanged) {
        if (it.source != client.localPlayer || client.gameState != GameState.LOGGED_IN) {
            return
        }
        if (it.target != null) {
            target = it.target
        }
        val localPlayer = client.localPlayer
        val players = client.players

        for (player in players) {
            if (localPlayer != null && player === localPlayer.interacting) {
                lastEnemy = player
            }
        }
    }
}