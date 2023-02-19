package meteor.plugins.crabfighter

import dev.hoot.api.game.Combat
import dev.hoot.api.game.Worlds
import dev.hoot.api.movement.Movement
import eventbus.events.ClientTick
import eventbus.events.GameObjectSpawned
import eventbus.events.GameTick
import meteor.api.Objects
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import net.runelite.api.NPC
import net.runelite.api.ObjectID
import net.runelite.api.Player
import net.runelite.api.TileObject
import net.runelite.api.coords.WorldPoint
import kotlin.random.Random

@PluginDescriptor(
    name = "Crab Fighter",
    description = "Automatically aggros crabs",
    enabledByDefault = false,
    external = true)
class CrabFighterPlugin : Plugin() {
    private var afkTimer: Int = 0
    private val config = configuration<CrabFighterConfig>()
    var state_num: Int = 0
    private var overlay = overlay(CrabFighterOverlay(this, config))
    var timeout: Int = 0


    private lateinit var location: WorldPoint
    private var health: Double = 0.0
    private var otherPlayerAtHomeTile: Int = 0
    var aggroTheseNpcs: List<NPC> = ArrayList()
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
            when (state_num) {
                /********************************************
                 * __ State Zero __
                 * Log in state check
                 *******************************************/
                0 -> {

                    if (true) {
                        state_num = 1
                    }

                    return 0
                }
                /********************************************
                 * __ State One __
                 * Checks if the player is at home.
                 * Walks to home if it's not.
                 * @see CrabFighterConfig.home
                 ********************************************/
                1 -> {

                    return if (location == config.home().home) {
                        state_num = 2
                        rand(0, 10)
                    } else {
                        if (!client.localPlayer!!.isMoving) {
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
                2 -> {
                    val npcsAttackingPlayer: List<NPC>

                    if (aggroTheseNpcs.size < 2) {
                        getNpcToAggro(config.home().npc1)
                    }

                    try {
                        npcsAttackingPlayer =
                            aggroTheseNpcs.filter { it.interacting?.name == client.localPlayer!!.name }
                    } catch (e: Exception) {
                        return rand(5, 10)
                    }
                    return checkAggro(npcsAttackingPlayer)
                }
                /**
                 * __ State THREE __
                 * Configurations for home location
                 * @see CrabHome.location for the switch case
                 */
                3 -> {
                    when (config.home().location) {
                        "Rellekka" -> {
                            val tunnel: TileObject? = Objects.getFirst("Tunnel")
                            val inside: Boolean = tunnel!!.id == 5014
                            if (inside) {
                                tunnel.interact("Enter")
                                state_num = 1
                                return rand(0, 10)
                            } else if (tunnel != null && client.localPlayer!!.isIdle) {
                                tunnel.interact("Enter")
                                return rand(0, 10)
                            }
                        }
                    }
                    state_num = 1
                }

                //get check the aggression
                4 -> {

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


        if (!noWalkingCrabs && !client.localPlayer!!.isAnimating) {
            walkingCrabs.first().interact("Attack")
            state_num = 1
            return rand(3, 7)
        }

        return if (client.localPlayer!!.isAnimating) {
            afkTimer = 0
            rand(10, 15)
        } else {
            afkTimer++
            if (afkTimer >= rand(4,8)) {
                state_num = 3
                0
            } else {
                if(aggroTheseNpcs.size >= 2) {
                    return rand(10, 15)
                } else {
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
        client.hopToWorld(Worlds.getFirst {
            it.isMembers && it.isAllPkWorld && !it.isLeague
                    && !it.isSkillTotal && !it.isTournament && it.id != client.world
        })
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

    enum class CrabHome(val home: WorldPoint, val location: String, val npc1: String) {
        RELLEKA_NORTH(
            WorldPoint(2704, 3726, 0),
            "Rellekka",
            "Rock Crab"
        ),
        RELLEKA_SOUTH(
            WorldPoint(2701, 3719, 0),
            "Rellekka",
            "Rock Crab"),
        //    AMMONITE_SOUTH(WorldPoint(0,0,0), "Fossil Island"),
//        AMMONITE_CENTER(WorldPoint(3716,3880,0), "Fossil Island", "Ammonite Crab"),
//    AMMONITE_NORTH(WorldPoint(0,0,0), "Fossil Island"),
//    KOUREND_(WorldPoint(0,0,0), "Kourend"),
//    MORYTANIA_(WorldPoint(0,0,0), "Kourend"),
    }
}


