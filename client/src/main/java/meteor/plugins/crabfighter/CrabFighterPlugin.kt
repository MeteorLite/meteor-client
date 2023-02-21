package meteor.plugins.crabfighter


import dev.hoot.api.game.Worlds
import dev.hoot.api.movement.Movement
import eventbus.events.*
import meteor.api.Objects
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.*
import net.runelite.api.coords.WorldPoint
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.LinkedBlockingQueue
import kotlin.collections.ArrayList
import kotlin.random.Random

enum class CrabHome(
    var home: WorldPoint?,
    val location: String,
    val npc1: String,
    val npc2: String,
    val distance: Int,
    val deaggro: WorldPoint?
) {
    RELLEKA_NORTH(
        WorldPoint(2704, 3726, 0),
        "Rellekka",
        "Rock Crab",
        "Rocks",
        2,
        null
    ),
    RELLEKA_SOUTH(
        WorldPoint(2701, 3719, 0),
        "Rellekka",
        "Rock Crab",
        "Rocks",
        2,
        null
    ),
    //    AMMONITE_SOUTH(WorldPoint(0,0,0), "Fossil Island"),
//        AMMONITE_CENTER(WorldPoint(3716,3880,0), "Fossil Island", "Ammonite Crab"),
//    AMMONITE_NORTH(WorldPoint(0,0,0), "Fossil Island"),
    KOUREND_3(WorldPoint(1770, 3467, 0 ),
        "Kourend",
        "Sand Crab",
        "Sandy rocks",
        2,
        WorldPoint(1799, 3493, 0)
    ),
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
    private var overlay = overlay(CrabFighterOverlay(this, config))
    var log: String = ""

    var hop_ticker = -1
    var timeout_ticker = -1
    var afk_ticker = 30


    // Get location and npc info from the config file
    private var home_point: WorldPoint? = config.home().home
    private var deaggro_point = config.home().deaggro
    private var attack_radius = config.home().distance
    private var dormant_npc = config.home().npc2
    private var attack_npc = config.home().npc1
    var area_name = config.home().location
    var kourend_worldpoints =
        mutableListOf(WorldPoint(1765, 3468, 0), WorldPoint(1776, 3468, 0), WorldPoint(1773, 3461, 0))

    // Initialize lists for dormant and attack monsters
    var dormant_monsters: ArrayList<NPC> = ArrayList()
    var attack_monsters: ArrayList<NPC> = ArrayList()

    // Get the player's health and initialize executors and queues
    private var health: Double = 0.0
    private val executor = Executors.newWorkStealingPool()
    private val scheduledTaskExecutor = Executors.newScheduledThreadPool(3)
    val queue: LinkedBlockingQueue<Runnable> = LinkedBlockingQueue()
    var start_time = System.currentTimeMillis()
    var initialize_num = -1



    /**
     * Initializes the bot and runs any pending tasks.
     *
     * @implNote Calls `initialize()` and `immediate?.run()`.
     */
    override fun onGameTick(it: GameTick) {
        if(queue.size > 0) {
            println("queue size: ${queue.size}")
        }
        initialize()

        queue.poll()?.run()

        afk_ticker--
        if(afk_ticker <= 0) {
            if(client.localPlayer!!.isIdle) {
                println("afk timer called")
                if(dormant_monsters.size > 0) {
                    deaggro()
                }
                afk_ticker = Random.nextInt(25, 60)
            } else {
                afk_ticker = Random.nextInt(25, 60)
            }
        }
    }


    /**
     * Handles de-aggroing for specific areas.
     *
     * @implNote Sets `state_num` to 3 and logs "running -> deagg".
     *           Calls `relekka_deaggro()` for the area "Rellekka".
     */
    private fun deaggro() {
        println("deaggrooing")
        println(area_name)
        when (area_name) {
            "Rellekka" -> {
                relekka_deaggro()
            }

            "Kourend" -> {
                kourend_deaggro()
            }
        }
    }

    private fun kourend_deaggro() {
        var point = randWorldPoint(deaggro_point!!, 3)

        create_event(
            {
                Movement.walkTo(point) && (client.localPlayer!!.worldLocation.distanceTo(point) <= 10)
            },
            { go_home() },
            Random.nextInt(2, 5),
            "Kourend deaggro",
            3
        )
    }

    private fun kourend_findHome() {
        println("kourend_findHome")
        create_event(
            {
                Movement.walkTo(home_point)
                client.localPlayer!!.distanceTo(home_point) <= 3
            },
            { findOpenSpot() },
            Random.nextInt(0, 5),
            "Walking to home area",
            0
        )
        queue.add { go_home() }
    }

    fun findOpenSpot(): Boolean {
        println("finding spot")
        when (area_name) {
            "Kourend" -> {
                println("finding open spot")
                kourend_worldpoints = kourend3()

                println("spots: ${kourend_worldpoints.size}")

                for(spot in kourend3()) {
                    for(player in client.players) {
                        if(player.worldLocation == spot && player.name != client.localPlayer!!.name) {
                            println("spot taken: ${spot} by ${player.name}")
                            kourend_worldpoints.remove(spot)
                            break
                        }
                    }
                }
                if (kourend_worldpoints.isNotEmpty()) {
                    println("received world point successfully")
                    config.home().home = kourend_worldpoints.first()
                    home_point = kourend_worldpoints.first()
                    return true
                } else {
                    hop()
                }
            }
        }
        return false
    }

    fun randWorldPoint(point: WorldPoint, random: Int): WorldPoint {
        val rand_x = Random.nextInt(-random, random)
        val rand_y = Random.nextInt(-random, random)

        return WorldPoint(point.x + rand_x, point.y + rand_y, 0)
    }

    fun kourend2(): MutableList<WorldPoint> {
        return mutableListOf(
            WorldPoint(1863, 3543, 0),
            WorldPoint(1876, 3555, 0),
            WorldPoint(1868, 3556, 0),
            WorldPoint(1862, 3536, 0)
        )
    }

    fun kourend3(): MutableList<WorldPoint> {
        return mutableListOf(
            WorldPoint(1765, 3468, 0),
            WorldPoint(1776, 3468, 0),
            WorldPoint(1773, 3461, 0)
        )
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
        if (home_point != null) {
            attack_monsters =
                client.npcs.filter { it.distanceTo(client.localPlayer!!.worldLocation) <= 2 && attack_npc == it.name } as ArrayList<NPC>
            dormant_monsters =
                client.npcs.filter { it.name == dormant_npc && it.distanceTo(home_point) <= attack_radius } as ArrayList<NPC>
            health = (client.localPlayer!!.healthRatio).toDouble()
            log = "attacking ${attack_monsters.size} crabs"
        }
    }

    /**
     * Updates the list of attack monsters and dormant monsters and checks if a monster has despawned.
     *
     * @param it the `NpcDespawned` event.
     * @implNote Calls `monster_nearby()` with the despawned monster and updates the `attack_monsters` list.
     */
    override fun onNPCDespawned(it: NpcDespawned) {
        monster_nearby(it.npc)
        attack_monsters =
            client.npcs.filter { it.distanceTo(client.localPlayer!!.worldLocation) <= 2 && attack_npc == it.name } as ArrayList<NPC>
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

        if (npc.name == dormant_npc && near) {
            dormant_monsters.add(npc)
        }
    }

    override fun onLoginStateChanged(it: LoginStateChanged) {
        dormant_monsters = ArrayList()
        attack_monsters = ArrayList()
        afk_ticker = -1
        hop_ticker = -1
        start_time = System.currentTimeMillis()
    }

    /**
     * Initializes the script by checking if any other players are at home.
     */
    private fun initialize() {
        home_point = config.home().home
        deaggro_point = config.home().deaggro
        attack_radius = config.home().distance
        dormant_npc = config.home().npc2
        attack_npc = config.home().npc1
        area_name = config.home().location

        if (initialize_num == -1) {
            println("going to $area_name")
            when (area_name) {
                "Kourend" -> queue.add { kourend_findHome() }
                "Relekka" -> queue.add { go_home() }
            }
            initialize_num = 0
        }
        checkIfOtherPlayersIsAtHome()
    }

    /**
     * Checks if any other players are within 3 tiles of the `home_point`.
     * If there are other players nearby, increments `hop_ticker`.
     * If `hop_ticker` is greater than 15, calls `hop()` to switch to a different world.
     */
    fun checkIfOtherPlayersIsAtHome() {
        if (client.players.any { it != client.localPlayer!! && it.worldLocation.distanceTo(home_point) <= 3 }) {
            log = ("player at home")
            hop_ticker++
        }

        if (hop_ticker > 15) {
            println("hopping for other person is on tile")
            hop()
            hop_ticker = 0
        }
    }

    /**
     * Switches to a different world that meets specific criteria.
     *
     * @implNote Sets `state_num` to 5 and logs "hop worlds".
     *           Calls `client.hopToWorld()` with the first available world that meets the criteria.
     */
    private fun hop() {
        log = ("hop worlds")
        queue.add {
            client.hopToWorld(Worlds.getRandom {
                it.playerCount > 300 &&
                        it.isMembers && !it.isAllPkWorld && !it.isLeague
                        && !it.isSkillTotal && !it.isTournament && it.id != client.world
            })
        }
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
        create_event(
            {
                Movement.walkTo(home_point) && (config.home().home == client.localPlayer!!.worldLocation)
            },
            {
                Movement.walkTo(home_point)
//                wait4agg()
            },
            Random.nextInt(0, 5),
            "Going home",
            1
        )

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

    fun create_event(callable: Callable<Boolean>, runnable: Runnable, wait: Int, name: String, state: Int) {
        println("Event created::${name}")
        queue.add { wait_until(runnable, callable, wait, name, state) }
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
    fun wait_until(
        runnable: Runnable,
        callable: Callable<Boolean>,
        wait: Int,
        name: String,
        state: Int
    ) {
        println("Running::${name}")
        if(callable.call()) {
            println("Ending::${name}")
            queue.add(runnable)
            return
        }
        queue.add { wait_until(runnable, callable, wait, name, state) }
        println("ReRunning::${name}")
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