package meteor.plugins.pvpkeys


import com.google.common.base.Supplier
import dev.hoot.api.items.Inventory
import dev.hoot.api.magic.Ancient
import dev.hoot.api.magic.Magic
import dev.hoot.api.widgets.Prayers
import eventbus.events.InteractingChanged
import meteor.api.items.Items
import meteor.input.KeyManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.util.HotkeyListener
import net.runelite.api.Actor
import net.runelite.api.Prayer
import java.util.*
import java.util.concurrent.ExecutorService
import kotlin.math.roundToInt

@PluginDescriptor(name = "pvpkeys", description = "hotkeys for pvp", enabledByDefault = false)
class PvPKeys : Plugin() {
    var r = Random()
    var target: Actor? = null
    private val keyManager= KeyManager
    override val config = configuration<PvPKeysConfig>()
    var executor: ExecutorService? = null
    val meleeGear: MutableList<String>
        get() = mutableListOf(*config.MeleeIDs()!!.split(",").toTypedArray())

    val melee
    get() = Inventory.getFirst{meleeGear.contains(it.name) }
    val mageGear: MutableList<String>
        get() = mutableListOf(*config.MageIDs()!!.split(",").toTypedArray())

    val mage
        get() = Inventory.getAll{mageGear.contains(it.name) }
    val rangeGear: MutableList<String>
        get() = mutableListOf(*config.RangeIDs()!!.split(",").toTypedArray())

    val range
        get() = Inventory.getFirst{rangeGear.contains(it.name) }




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
        keyManager.registerKeyListener(lasttarget!!, this.javaClass)

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
        keyManager.unregisterKeyListener(lasttarget!!)

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
    private val lasttarget: HotkeyListener? = object : HotkeyListener(Supplier { config.Lasttarget() }) {
        override fun hotkeyPressed() {
            target!!.interact(0)
        }
    }
    override fun onInteractingChanged(it: InteractingChanged) {
        if (it.source === client.localPlayer) {
            if (it.target != null ) {
                target = it.target
            }
        }
    }
}