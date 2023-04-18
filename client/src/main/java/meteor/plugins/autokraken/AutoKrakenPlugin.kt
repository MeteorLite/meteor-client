package meteor.plugins.autokraken

import eventbus.events.GameTick
import meteor.api.ClientPackets
import meteor.api.Items
import meteor.api.Loots
import meteor.api.NPCs
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.Skill
import rs117.hd.data.NpcID
import kotlin.random.Random

@PluginDescriptor(name = "Auto Kraken", description = "Automatically triggers Kraken & focuses the Kraken boss.", enabledByDefault = false)
class AutoKrakenPlugin: Plugin() {
    companion object Constants{
        private const val KRAKEN_POOL_ID = 496
        private const val KRAKEN = "Kraken"
        private const val FISHING_EXPLOSIVE = "Fishing explosive"
    }

    private var waitTicks: Int = 0
    private var config: AutoKrakenConfig = configuration()

    private var randomHealthThreshold = 0

    private val tasks = listOf(
        { loot() },
        { eat() },
        { attackKraken() },
        { triggerKraken() }
    )

    override fun onStart() {
        setRandomHealthThreshold()
        config = configuration()
        waitTicks = 0
    }

    /*
     * Requires fishing explosives to trigger the kraken.
     * Setting auto-retaliate to off is recommended, so you don't attack the tentacles the bot will autofocus kraken.
     */
    override fun onGameTick(it: GameTick) {
        if(waitTicks > 0){
            waitTicks--
            return
        }

        tasks.find { task -> task.invoke() }
    }

    private fun triggerKraken(): Boolean {
        val krakenPool = NPCs.getFirst(KRAKEN_POOL_ID) ?: return false
        val fishingExplosive = Items.getFirst(FISHING_EXPLOSIVE) ?: return false

        fishingExplosive.useOn(krakenPool)

        waitTicks = 11
        return true
    }

    private fun attackKraken(): Boolean {
        // NPC.interact("Attack") didn't work for the boss
        val local = client.localPlayer!!
        val kraken = NPCs.getFirst(KRAKEN) ?: return false
        if (local.interacting != kraken && local.isIdle) {
            val krakenMenu = kraken.getMenu(0) ?: return false

            NPCs.getFirst(KRAKEN)?.let {
                client.invokeMenuAction(
                    "Attack",
                    "<col=ffff00>${kraken.name}<col=ff0000>  (level-291)",
                    krakenMenu.identifier,
                    10,
                    0,
                    0
                )
            }
            return true
        } else {
            return false
        }
    }

    private fun loot(): Boolean{
        if(Items.isFull()) return false

        val itemsToLoot = config.loot().split(",").ifEmpty { return false }

        if(!Loots.exists(itemsToLoot)) return false

        val local = client.localPlayer!!
        Loots.getAll()?.filter {item ->
            (local.distanceTo(item.getWorldLocation()) < 5)
                    && (item.getName() != null && itemsToLoot.contains(item.getName()))
        }?.forEach {
            if (!local.isMoving)
                it.interact("Take")
        }

        waitTicks = 1
        return true
    }

    private fun eat(): Boolean {
        if (client.getBoostedSkillLevel(Skill.HITPOINTS) >= randomHealthThreshold) return false

            val edible = Items.getFirst(
                config.food()
            )

        return if (edible != null) {
            ClientPackets.queueClickPacket(edible.clickPoint)
            edible.interact("Eat")
            setRandomHealthThreshold()
            waitTicks = 3
            true
        } else {
            false
        }
    }

    private fun setRandomHealthThreshold(){
        randomHealthThreshold = Random.nextInt(config.healthMin(), config.healthMax())
    }
}