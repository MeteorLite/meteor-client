package meteor.plugins.AIOCrabPlugin

import dev.hoot.api.game.Combat
import dev.hoot.api.game.Worlds
import dev.hoot.api.movement.Movement
import eventbus.events.GameObjectSpawned
import eventbus.events.GameTick
import meteor.api.objects.Objects
import meteor.plugins.AIOCrabPlugin.constants.CrabHome
import meteor.plugins.AIOCrabPlugin.constants.StateController
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.NPC
import net.runelite.api.ObjectID
import net.runelite.api.Player
import net.runelite.api.TileObject
import net.runelite.api.coords.WorldPoint
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.random.Random

@PluginDescriptor(
    name = "Crab Fighter",
    description = "Automatically aggros crabs",
    enabledByDefault = false,
    external = true)
class CrabFighterPlugin : Plugin() {
    private var afkTimer: Int = 0
    private val config = configuration<CrabFighterConfig>()
    private var timeout: Int = 0
    private val log: Logger = LoggerFactory.getLogger("CrabFighterPlugin")

    private lateinit var location: WorldPoint
    private var state: StateController = StateController.ZERO
    private var health: Double = 0.0
    private var otherPlayerAtHomeTile: Int = 0
    private var aggroTheseNpcs: List<NPC> = ArrayList()
    private var hopWorlds: Boolean = false

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


    override fun onGameTick(it: GameTick) {
        if (timeout == 0)
            timeout = refresh()
        else
            timeout--
    }

    private fun initialize() {
        location = client.localPlayer!!.worldLocation
        health = Combat.getHealthPercent()
        checkIfOtherPlayersIsAtHome()
    }

    private fun refresh(): Int {
        initialize()
        if(hopWorlds && client.localPlayer!!.isIdle) {
            hopWorlds()
        } else {
            when (state) {
                /********************************************
                 * __ State Zero __
                 * Log in state check
                 *******************************************/
                StateController.ZERO -> {
                    log.info("STATE ZERO")

                    if (true) {
                        log.info("next state!")
                        state = StateController.ONE
                    }

                    return 0
                }
                /********************************************
                 * __ State One __
                 * Checks if the player is at home.
                 * Walks to home if it's not.
                 * @see CrabFighterConfig.home
                 ********************************************/
                StateController.ONE -> {
                    log.info("STATE ONE")
                    log.info(config.toString())

                    log.info(config.home().home.toString())

                    return if (location == config.home().home) {
                        log.info("at home!")
                        state = StateController.TWO
                        rand(0, 10)
                    } else {
                        if (!client.localPlayer!!.isMoving) {
                            log.info("walking home!")
                            Movement.walkTo(config.home().home)
                            return 3
                        }
                        0
                    }
                }
                /********************************************
                 * __ State Two __
                 * wait until deaggroed
                 * gets aggressive npcs
                 * @see checkAggro for the returns and state changes
                 ********************************************/
                StateController.TWO -> {
                    log.info("STATE TWO")
                    val npcsAttackingPlayer: List<NPC>

                    if (aggroTheseNpcs.size < 2) {
                        log.info("logging npcs to aggro")
                        getNpcToAggro(config.home().npc1)
                    }

                    try {
                        npcsAttackingPlayer =
                            aggroTheseNpcs.filter { it.interacting?.name == client.localPlayer!!.name }
                        log.info("Npcs attacking player: " + npcsAttackingPlayer.toString())
                    } catch (e: Exception) {
                        log.info(e.message)
                        return rand(5, 10)
                    }
                    return checkAggro(npcsAttackingPlayer)
                }
                /**
                 * __ State THREE __
                 * Configurations for home location
                 * @see CrabHome.location for the switch case
                 */
                StateController.THREE -> {
                    log.info("STATE THREE")
                    when (config.home().location) {
                        "Rellekka" -> {
                            val tunnel: TileObject? = Objects.getFirst("Tunnel")
                            val inside: Boolean = tunnel!!.id == 5014
                            if (inside) {
                                tunnel.interact("Enter")
                                state = StateController.ONE
                                return rand(0, 10)
                            } else if (tunnel != null && client.localPlayer!!.isIdle) {
                                tunnel.interact("Enter")
                                return rand(0, 10)
                            }
                        }
                    }
                    state = StateController.ONE
                }

                //get check the aggression
                StateController.FOUR -> {

                }

                else -> {
                    return 0
                }
            }
        }

        return 0
    }


    /********************************************
     * if there's aggroed crabs do nothing
     *
     * checks if there's any crabs walking
     *  - no crabs: wait (the crabs are interacting with the player)
     *  - crabs walking: attack and go back to state two.
     *  - none: go to state three for deaggro
     ********************************************/
    private fun checkAggro(npcsAttackingPlayer: List<NPC>): Int {
        val walkingCrabs: List<NPC> = aggroTheseNpcs.filter { !it.isDead && it.isMoving }
        val noWalkingCrabs: Boolean = walkingCrabs.isEmpty()

        log.info("Walking crabs that should be aggroed: " + walkingCrabs.toString())

        if (!noWalkingCrabs && !client.localPlayer!!.isAnimating) {
            log.info("**!!aggro walking crabs!!**")
            walkingCrabs.first().interact("Attack")
            state = StateController.ONE
            return rand(3, 7)
        }

        return if (client.localPlayer!!.isAnimating) {
            afkTimer = 0
            rand(10, 15)
        } else {
            afkTimer++
            if (afkTimer >= rand(4,8)) {
                log.info("GO TO STATE THREE!!")
                state = StateController.THREE
                0
            } else {
                if(aggroTheseNpcs.size >= 2) {
                    log.info("Waiting for crabs: " + afkTimer.toString())
                    return rand(10, 15)
                } else {
                    log.info("Searching For Crabs")
                    afkTimer = 0
                    0
                }
            }
        }
    }

    private fun rand(min: Int, max: Int): Int {
        return Random.nextInt(min, max)
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        val gameObject = it.gameObject
        if(gameObject.id == ObjectID.CANNON_BASE) {
            hopWorlds()
        }
    }

    private fun getNpcToAggro(npc: String) {
        aggroTheseNpcs += client.npcs.filter { it.distanceTo(location) < 2 && !aggroTheseNpcs.contains(it) && it.name == npc}
    }

    private fun hopWorlds() {
        var timeout = 0

        while(timeout < 10000) {
            timeout++
            if(client.localPlayer!!.isIdle) {
                client.hopToWorld(Worlds.getFirst(client.world + 1))
            }
        }
    }

    private fun checkIfOtherPlayersIsAtHome() {
        val player: Player? = client.players.firstOrNull {
            it != client.localPlayer && it.worldLocation == config.home().home
        }

        if (player != null) {
            otherPlayerAtHomeTile++
            if (otherPlayerAtHomeTile > 15) {
                hopWorlds = true
            }
        }

        hopWorlds = false
    }
}
