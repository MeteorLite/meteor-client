package meteor.plugins.pvpkeys


import dev.hoot.api.magic.Ancient
import dev.hoot.api.magic.Magic
import dev.hoot.api.widgets.Prayers
import eventbus.events.ClientTick
import eventbus.events.InteractingChanged
import eventbus.events.MenuOptionClicked
import meteor.api.items.Items
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.scriptcreator.script.api.Item
import meteor.rs.ClientThread
import meteor.util.HotkeyListener
import net.runelite.api.*
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
    val meleeGear: MutableList<String>
        get() = mutableListOf(*config.MeleeIDs()!! .split(",").toTypedArray())

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

    }

    private val magepray: HotkeyListener = object : HotkeyListener( { config.Magepray() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.PROTECT_FROM_MAGIC)
        }
    }
    private val rangepray: HotkeyListener = object : HotkeyListener( { config.Rangepray() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.PROTECT_FROM_MISSILES)
        }
    }
    private val meleepray: HotkeyListener = object : HotkeyListener( { config.Meleepray() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.PROTECT_FROM_MELEE)
        }
    }
    private val smite: HotkeyListener = object : HotkeyListener( { config.Smite() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.SMITE)
        }
    }
    private val brew: HotkeyListener = object : HotkeyListener( { config.Brew() }) {
        override fun hotkeyPressed() {
            if (Items.getFirst(6691, 6689, 6687, 6685) != null) {
                Items.getFirst(6691, 6689, 6687, 6685)?.interact(0)
            }
        }
    }
    private val restore: HotkeyListener = object : HotkeyListener( { config.Restore() }) {
        override fun hotkeyPressed() {
            Items.getFirst(3030, 3028, 3026, 3024)?.interact(0)

        }
    }
    private val quickpray: HotkeyListener = object : HotkeyListener( { config.Quickpray() }) {
        override fun hotkeyPressed() {
            Prayers.toggleQuickPrayer(!Prayers.isQuickPrayerEnabled())
        }
    }
    private val magegear: HotkeyListener = object : HotkeyListener({ config.Magegear() }) {
        override fun hotkeyPressed() {

            ClientThread.invokeLater {
                mageGear.forEach {
                    Items.getFirst(it)?.interact(2)
                }
            }
        }
    }

    private val meleegear: HotkeyListener = object : HotkeyListener({ config.Meleegear() }) {
        override fun hotkeyPressed() {
            ClientThread.invokeLater {

                meleeGear.forEach {
                    Items.getFirst(it)?.interact(2)

                }
            }
        }
    }
    private val rangegear: HotkeyListener = object : HotkeyListener({ config.Rangegear() }) {
        override fun hotkeyPressed() {
            ClientThread.invokeLater {
                rangeGear.forEach {
                    Item first it interact 2
                }
            }
        }
    }
    private val icebarrage: HotkeyListener = object : HotkeyListener({ config.Icebarrage() }) {
        override fun hotkeyPressed() {
            Magic.selectSpell(Ancient.ICE_BARRAGE)
            if (target != null) {
                target!!.interact(0)
            }
        }
    }
    private val iceblitz: HotkeyListener = object : HotkeyListener( { config.Iceblitz() }) {
        override fun hotkeyPressed() {
            Magic.selectSpell(Ancient.ICE_BLITZ)
            if (target != null) {
                target!!.interact(0)
            }
        }
    }
    private val bloodblitz: HotkeyListener = object : HotkeyListener( { config.Bloodblitz() }) {
        override fun hotkeyPressed() {
            Magic.selectSpell(Ancient.BLOOD_BLITZ)
            if (target != null) {
                target!!.interact(0)
            }
        }
    }
    private val augury: HotkeyListener = object : HotkeyListener( { config.Augury() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.AUGURY)
        }
    }
    private val rigour: HotkeyListener = object : HotkeyListener( { config.Rigour() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.RIGOUR)
        }
    }
    private val piety: HotkeyListener = object : HotkeyListener( { config.Piety() }) {
        override fun hotkeyPressed() {
            Prayers.toggle(Prayer.PIETY)
        }
    }
    private val lasttarget: HotkeyListener = object : HotkeyListener( { config.Lasttarget() }) {
        override fun hotkeyPressed() {
            target as Player
            target!!.interact("Attack")
        }
    }

    override fun onClientTick(it: ClientTick) {
        val gear = client.getWidget(WidgetInfo.EQUIPMENT)?.bounds
        val mousePoint = client.mouseCanvasPosition
        if (gear != null && gear.contains(mousePoint.x,mousePoint.y)) {
                client.insertMenuItem(
                    "<col=00FFFF>Copy Gear</col>",
                    "",
                    10000000,
                    100000,
                    0,
                    0,
                    false
                )
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
        if (it.source === client.localPlayer) {
            if (it.target != null) {
                target = it.target
            }
        }
    }
}