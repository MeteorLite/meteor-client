package meteor.plugins.crabfighter


import dev.hoot.api.game.Worlds
import dev.hoot.api.movement.Movement
import eventbus.events.*
import meteor.api.Objects
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.NPC
import net.runelite.api.ObjectID
import net.runelite.api.TileObject
import net.runelite.api.coords.WorldPoint
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.random.Random

enum class CrabHome(
    val home: WorldPoint,
    val location: String,
    val npc1: String,
    val npc2: String,
    val distance: Int
) {
    RELLEKA_NORTH(
        WorldPoint(2704, 3726, 0),
        "Rellekka",
        "Rock Crab",
        "Rocks",
        2
    ),
    RELLEKA_SOUTH(
        WorldPoint(2701, 3719, 0),
        "Rellekka",
        "Rock Crab",
        "Rocks",
        2
    ),
    //    AMMONITE_SOUTH(WorldPoint(0,0,0), "Fossil Island"),
//        AMMONITE_CENTER(WorldPoint(3716,3880,0), "Fossil Island", "Ammonite Crab"),
//    AMMONITE_NORTH(WorldPoint(0,0,0), "Fossil Island"),
//    KOUREND_(WorldPoint(0,0,0), "Kourend"),
//    MORYTANIA_(WorldPoint(0,0,0), "Kourend"),
}

//    enum class Style(val style: AttackStyle, val switchRunnable: Runnable) {
//        ATTACK(AttackStyle.ACCURATE, { Switch}),
//        STRENGTH(AttackStyle.AGGRESSIVE),
//        DEFENCE(AttackStyle.DEFENSIVE)
//    }


@PluginDescriptor(
    name = "Crab Fighter",
    description = "Automatically aggros crabs",
    enabledByDefault = false,
    external = true)
class CrabFighterPlugin : Plugin() {
    val config = configuration<CrabFighterConfig>()
    var state_num: Int = 0
    private var overlay = overlay(CrabFighterOverlay(this, config))
    var log: String = ""

    var hop_ticker = -1
    var timeout_ticker = -1
    var afk_ticker = -1


    // Get location and npc info from the config file
    private val home_point = config.home().home
    private val attack_radius = config.home().distance
    private val dormant_npc = config.home().npc2
    private val attack_npc = config.home().npc1
    val area_name = config.home().location

    // Initialize lists for dormant and attack monsters
    var dormant_monsters: ArrayList<NPC> = ArrayList()
    var attack_monsters: ArrayList<NPC> = ArrayList()


    // Get the player's health and initialize executors and queues
    private var health: Double = 0.0
    private val executor = Executors.newWorkStealingPool()
    private val scheduledTaskExecutor = Executors.newScheduledThreadPool(3)
    val queue: LinkedBlockingQueue<Runnable> = LinkedBlockingQueue()
    var immediate: Runnable? = Runnable { go_home() }


    /**
     * Initializes the bot and runs any pending tasks.
     *
     * @implNote Calls `initialize()` and `immediate?.run()`.
     */
    override fun onGameTick(it: GameTick) {
        initialize()
        immediate?.run()
    }

    /**
     * Checks if a monster has spawned and adds it to the list of nearby monsters if applicable.
     *
     * @param it the `NpcSpawned` event.
     * @implNote Calls `monster_nearby()` with the spawned monster.
     */
    override fun onNpcSpawned(it: NpcSpawned) {
        monster_nearby(it.npc)
    }

    /**
     * Updates the list of attack monsters and dormant monsters.
     *
     * @param it the `HitsplatApplied` event.
     * @implNote Updates the `attack_monsters` and `dormant_monsters` lists based on the current location of the player and the NPCs.
     */
    override fun onHitsplatApplied(it: HitsplatApplied) {
        attack_monsters = client.npcs.filter { it.distanceTo(client.localPlayer!!.worldLocation) <= 2 && attack_npc == it.name} as ArrayList<NPC>
        dormant_monsters = client.npcs.filter { it.name == dormant_npc && it.distanceTo(home_point) <=  attack_radius } as ArrayList<NPC>
        health = (client.localPlayer!!.healthRatio).toDouble()
        log = "attacking ${attack_monsters.size} crabs"
    }

    /**
     * Updates the list of attack monsters and dormant monsters and checks if a monster has despawned.
     *
     * @param it the `NpcDespawned` event.
     * @implNote Calls `monster_nearby()` with the despawned monster and updates the `attack_monsters` list.
     */
    override fun onNPCDespawned(it: NpcDespawned) {
        monster_nearby(it.npc)
        attack_monsters = client.npcs.filter { it.distanceTo(client.localPlayer!!.worldLocation) <= 2 && attack_npc == it.name} as ArrayList<NPC>
        log = "attacking ${attack_monsters.size} crabs"
    }

    /**
     * Checks if a cannon has spawned and adds it to the list of nearby cannons if applicable.
     *
     * @param it the `GameObjectSpawned` event.
     * @implNote Calls `checkCannon()` with the spawned cannon.
     */
    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        checkCannon(it.gameObject.id)
    }

    /**
     * Determines whether the given NPC is near the home point and has the name 'dormant_npc'.
     * If the NPC satisfies these conditions, it is added to the dormant_monsters list.
     *
     * @param npc the NPC to check for proximity to the home point and name
     */
    fun monster_nearby(npc: NPC) {
        var near = npc.worldLocation.distanceTo(home_point) <= attack_radius

        if(npc.name == dormant_npc && near) {
            dormant_monsters.add(npc)
        }
    }

    /**
     * Initializes the script by checking if any other players are at home.
     */
    private fun initialize() {
        checkIfOtherPlayersIsAtHome()
    }

    /**
     * Starts an AFK timer for the player. If the `callable` argument returns `true`,
     * the `runnable` argument is executed after a specified `wait` time.
     *
     * @param callable a `Callable` object that determines whether the player is idle.
     * @param runnable a `Runnable` object that specifies the action to take when the timer expires.
     * @param wait an integer representing the time to wait before executing the `runnable` action.
     *
     * @see Callable
     * @see Runnable
     * @implNote Tracks the `timeout_ticker` to schedule the next execution of the method.
     *           Uses `immediate` to execute the `runnable` action.
     *           The `wait` argument specifies the duration of the timer.
     */
    private fun wait_until(callable: Callable<Boolean>, runnable: Runnable, wait: Int) {
        if (timeout_ticker == -1) {
            timeout_ticker = wait
        } else {
            if (timeout_ticker == 0) {
                if (callable.call()) {
                    immediate = runnable
                    timeout_ticker = -1
                }
            } else {
                timeout_ticker--
                immediate = Runnable { wait_until(callable, runnable, wait) }
            }
        }
    }

    /**
     * Checks if any other players are within 3 tiles of the `home_point`.
     * If there are other players nearby, increments `hop_ticker`.
     * If `hop_ticker` is greater than 15, calls `hop()` to switch to a different world.
     */
    fun checkIfOtherPlayersIsAtHome() {
        if (client.players.filter { it != client.localPlayer!! && it.worldLocation.distanceTo(home_point) <= 3 }
                .isNotEmpty()) {
            log = ("player at home")
            hop_ticker++
        }

        if (hop_ticker > 15) {
            hop()
        }
    }

    /**
     * Switches to a different world that meets specific criteria.
     *
     * @implNote Sets `state_num` to 5 and logs "hop worlds".
     *           Calls `client.hopToWorld()` with the first available world that meets the criteria.
     */
    private fun hop() {
        state_num = 5
        log = ("hop worlds")
        client.hopToWorld(Worlds.getFirst {
            it.isMembers && it.isAllPkWorld && !it.isLeague
                    && !it.isSkillTotal && !it.isTournament && it.id != client.world
        })
    }

    /**
     * Sends the player back to their designated `home_point`.
     *
     * @implNote Sets `state_num` to 1 and logs "Going home".
     *           Calls `wait_until()` with a `Runnable` that attempts to walk to `home_point`
     *           and sets `state_num` to 4 once the player has arrived.
     *           Calls `wait4agg()` once the player has arrived.
     */
    fun go_home() {
        log = "Going home"
        state_num = 1
        immediate = Runnable {
            wait_until(
                {
                    state_num = 4
                    timeout_ticker = Random.nextInt(0, 3)
                    Movement.walkTo(home_point) && (home_point == client.localPlayer!!.worldLocation)
                },
                { wait4agg() },
                Random.nextInt(0, 5)
            )
        }
    }

    /**
     * Waits at `home_point` for aggressive monsters to attack.
     *
     * @implNote Sets `log` to "at home" and `state_num` to 2.
     *           Calls `wait_until()` with a `Runnable` that checks for aggressive monsters.
     *           If aggressive monsters are detected, calls `check_aggression()`.
     *           If not, calls `deaggro()` after a random delay.
     */
    fun wait4agg() {
        log = "at home"
        state_num = 2
        dormant_monsters.clear()

        immediate = Runnable {
            wait_until(
                { check_aggression() },
                { deaggro() }, Random.nextInt(3, 10)
            )
        }
    }

    /**
     * Handles de-aggroing for specific areas.
     *
     * @implNote Sets `state_num` to 3 and logs "running -> deagg".
     *           Calls `relekka_deaggro()` for the area "Rellekka".
     */
    private fun deaggro() {
        state_num = 3
        when (area_name) {
            "Rellekka" -> {
                relekka_deaggro()
            }
        }
    }

    /**
     * Checks if the player is interacting with a cannon.
     *
     * @param it the `ObjectID` of the object being interacted with.
     *
     * @implNote If the `ObjectID` is `CANNON_BASE`, calls `hop()` to switch to a different world.
     */
    fun checkCannon(it: Int) {
        if (it == ObjectID.CANNON_BASE) {
            hop()
        }
    }

    /**
     * Handles de-aggroing for the area "Rellekka".
     *
     * @implNote Logs "running -> deagg".
     *           Determines whether the player is inside the tunnel.
     *           If not, interacts with the tunnel to enter it.
     *           If inside, calls `go_home()` to return to the designated `home_point`.
     */
    private fun relekka_deaggro() {
        log = ("running -> deagg")
        val tunnel: TileObject? = Objects.getFirst("Tunnel")
        val inside: Boolean = tunnel!!.id == 5014
        if (inside) {
            tunnel.interact("Enter")
            go_home()
        } else if (client.localPlayer!!.isIdle) {
            tunnel.interact("Enter")
        }
    }

    /**
     * Checks for aggressive monsters in the player's vicinity.
     *
     * @return `true` if the player is idle and there are no aggressive monsters nearby,
     *         `false` otherwise.
     *
     * @implNote Sets `state_num` to 4 and determines whether the player is idle.
     *           If the player is idle and there are no aggressive monsters nearby, returns `true`.
     *           Otherwise, increments `timeout_ticker` and returns `false`.
     */
    fun check_aggression(): Boolean {
        state_num = 4
        if(afk_ticker == -1) {
            afk_ticker = Random.nextInt(4, 8)
        }

        if(attack_monsters.size == 0 && client.localPlayer!!.isIdle) {
            log = ("afk, no enemy")
            return if (afk_ticker <= 0) {
                afk_ticker = -1
                true
            } else {
                afk_ticker--
                timeout_ticker += Random.nextInt(7, 15)
                false
            }
        }

        afk_ticker = -1
        timeout_ticker += Random.nextInt(7, 15)

        return false
    }
}

/**
TODO:
- do sand crabs in kourend, ammonite crabs on fossil island, rock crabs in rellekka / waterbirth?).
- change attack styles or weapons with level ceilings
- ammonite crab fossil looting and banking
if inventory is full, and fossil drops, eat food and pickup fossil
- break handler
logout and log back in after 5 minutes
whenever there's movement -- add a break before moving
 */
