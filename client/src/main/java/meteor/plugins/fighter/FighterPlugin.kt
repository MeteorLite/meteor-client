package meteor.plugins.fighter

import dev.hoot.api.game.Combat
import dev.hoot.api.game.Game
import dev.hoot.api.magic.Regular
import dev.hoot.api.movement.Movement
import dev.hoot.api.packets.ItemPackets
import dev.hoot.api.widgets.Dialog
import dev.hoot.api.widgets.Prayers
import dev.hoot.api.widgets.Widgets
import eventbus.events.ChatMessage
import eventbus.events.GameTick
import meteor.Logger
import meteor.Main
import meteor.api.items.Items
import meteor.api.loot.Loots
import meteor.api.npcs.NPCs
import meteor.api.packets.ClientPackets
import meteor.game.ItemManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.autoalch.AutoAlchConfig
import net.runelite.api.TileItem
import net.runelite.api.coords.WorldPoint
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import javax.inject.Singleton

@PluginDescriptor(name = "Fighter", description = "Kills Monsters Automatically", enabledByDefault = false)
@Singleton
class FighterPlugin : Plugin() {
    private val log = Logger("Fighter")
    private val config = configuration<FighterConfig>()

    private var startPoint: WorldPoint? = null
    private val notOurItems: MutableList<TileItem> = ArrayList()
    override fun onStart() {

        if (config.quickPrayer() && !Prayers.isQuickPrayerEnabled()) {
            val widget = Widgets.get(WidgetInfo.MINIMAP_QUICK_PRAYER_ORB)
            widget?.let {
                Prayers.toggleQuickPrayer(true)
            }
        }

        if (Game.isLoggedIn()) {
            startPoint = Main.client.localPlayer!!.worldLocation
        }
    }

    fun Collection<String>.containsIgnoreCase(item: String) = any {
        it.equals(item, ignoreCase = true)
    }

    override fun onGameTick(it: GameTick) {
        try {
            if (Movement.isWalking()) {
                return
            }
            if (config.flick() && Prayers.isQuickPrayerEnabled()) {
                val widget = Widgets.get(WidgetInfo.MINIMAP_QUICK_PRAYER_ORB)
                widget?.let {
                    Prayers.toggleQuickPrayer(false)
                }
            }
            if (config.eat() && Combat.getHealthPercent() <= config.healthPercent()) {
                val foods = config.foods().split(",".toRegex()).toList()
                Items.getAll()?.filter { it.name in foods }?.forEach{
                        it.interact("Eat")
                        return
                }
            }
            if (config.restore() && Prayers.getPoints() < 5) {
                Items.getFirst("Prayer potion", "Super Restore")?.let {
                    it.interact("Drink")
                    return
                }
            }
            if (config.buryBones()) {
                Items.getFirstWithAction("Bury")?.let {
                    it.interact("Bury")
                    return
                }
            }
            val local = Main.client.localPlayer!!

            val itemsToLoot = config.loot().split(",")
            if (!Items.isFull()&& Loots.exists(itemsToLoot)) {
                Loots .getAll()?.filter{
                    (it.tile.worldLocation.distanceTo(local.worldLocation) < config.attackRange() && !notOurItems.contains(it)
                            && (it.getName() != null && itemsToLoot.contains(it.getName())
                            || config.lootValue() > -1
                            && ItemManager.getItemPrice(it.getId()) * it.quantity > config.lootValue()
                            || config.untradables()
                            && !it.isTradable
                            || it.hasInventoryAction("Destroy")))
                }?.forEach {
                    if(local.isIdle)
                    it.interact("Take")
               }
            }
            if (config.alching()) {
                val alchSpell = config.alchSpell()
                if (alchSpell!!.canCast()) {
                    val alchItems = config.alchItems().split(",".toRegex())
                    val alchItem = Items.getAll()?.filter {it.name != null && alchItems.contains(it.name) }
                    val spellToUse =
                        if (alchSpell.spell.name == AutoAlchConfig.AlchType.HIGH.name)
                            Regular.HIGH_LEVEL_ALCHEMY.widget.id
                        else
                            Regular.LOW_LEVEL_ALCHEMY.widget.id
                    alchItem?.forEach {
                        ItemPackets.queueSpellOnItemPacket(it.id, it.slot, spellToUse)
                        ClientPackets.queueClickPacket(it.clickPoint)
                        return
                    }
                }
            }
            if (local.interacting != null && !Dialog.canContinue()) {
                return
            }

            if (!Loots.exists(itemsToLoot) && local.isIdle && !local.isMoving) {
            val mob = NPCs.getAll(true, sortByDistance = true)?.firstOrNull {
                config.monster().split(",".toRegex()).toList().containsIgnoreCase(it.name)
                        && !it.isDead
                        && it.worldLocation.distanceTo(local.worldLocation) < config.attackRange()
            }
                mob?.let {
                    it.interact("Attack")
                }
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }


    override fun onChatMessage(it: ChatMessage) {
        val message = it.message
        if (message.contains("other players have dropped")) {
            val notOurs = Loots.getAt(Main.client.localPlayer!!.worldLocation)
            notOurs?.forEach {
                notOurItems.add(it)
            }
        }
    }
}