/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.woodcutting

import eventbus.events.*
import meteor.plugins.Plugin
import meteor.plugins.PluginDependency
import meteor.plugins.PluginDescriptor
import meteor.plugins.xptracker.XpTrackerPlugin
import net.runelite.api.ChatMessageType
import net.runelite.api.GameObject
import net.runelite.api.GameState
import net.runelite.api.coords.WorldPoint
import org.rationalityfrontline.kevent.Event
import java.time.Instant
import java.util.regex.Pattern

@PluginDescriptor(
    name = "Woodcutting",
    description = "Show woodcutting statistics and/or bird nest notifications",
    tags = ["birds", "nest", "notifications", "overlay", "skilling", "wc"],
    enabledByDefault = false
)
@PluginDependency(
    XpTrackerPlugin::class
)
class WoodcuttingPlugin : Plugin() {

    var overlay = overlay(WoodcuttingOverlay(this))
    var TREES = overlay(WoodcuttingTreesOverlay(this))
    override val config = configuration<WoodcuttingConfig>()
    var session: WoodcuttingSession? = null
        private set
    lateinit var axe: Axe
    val treeObjects = HashSet<GameObject>()
    val respawns = ArrayList<TreeRespawn>()
    private var recentlyLoggedIn = false
    private var currentPlane = 0

    override fun onStop() {

        respawns.clear()
        treeObjects.clear()
        session = null

    }

/*    override fun onOverlayMenuClicked(): ((Event<OverlayMenuClicked>) -> Unit)? = {
        val overlayMenuEntry: OverlayMenuEntry = it.data.entry
        if (overlayMenuEntry.menuAction == MenuAction.RUNELITE_OVERLAY && it.data.entry.option == WoodcuttingOverlay.Companion.WOODCUTTING_RESET
            && it.data.overlay === overlay
        ) {
            session = null
        }
    }*/


/*
    override fun onGameTick(): ((Event<GameTick>) -> Unit)? = {
        recentlyLoggedIn = false
        currentPlane = client.plane
        respawns.removeIf { obj: TreeRespawn -> obj.isExpired }
        if (session == null || session!!.lastChopping  == null) {
            if (axe.matchesChoppingAnimation(client.localPlayer)) {
                session!!.setLastChopping()


                val statTimeout = Duration.ofMinutes(config.statTimeout().toLong())
                val sinceCut = Duration.between(session!!.lastChopping, Instant.now())
                if (sinceCut.compareTo(statTimeout) >= 0) {
                    session = null

                }
            }
        }

    }
*/

    override fun onChatMessage(it: ChatMessage) {
        if (it.type == ChatMessageType.SPAM || it.type == ChatMessageType.GAMEMESSAGE) {
            if (WOOD_CUT_PATTERN.matcher(it.message).matches()) {
                if (session == null) {
                    session = WoodcuttingSession()
                }
                session!!.setLastChopping()
            }
        }
    }

    override fun onGameObjectSpawned(it: GameObjectSpawned) {
        val gameObject = it.gameObject
        val tree: Tree? = Tree.findTree(gameObject.id)
        if (tree === Tree.REDWOOD) {
            treeObjects.add(gameObject)
        }
    }

    override fun onGameObjectDespawned(it: GameObjectDespawned) {
        val gameObject = it.gameObject
        val tree: Tree? = Tree.Companion.findTree(gameObject.id)
        if (tree != null) {
            if (tree.respawnTime != null && !recentlyLoggedIn && currentPlane == gameObject.plane) {
                val min = gameObject.sceneMinLocation
                val base = WorldPoint.fromScene(client, min.x, min.y, client.plane)
                val treeRespawn = TreeRespawn(
                    tree, gameObject.sizeX() - 1, gameObject.sizeY() - 1,
                    base, Instant.now(), tree.getRespawnTime(base.regionID)!!.toMillis().toInt()
                )
                respawns.add(treeRespawn)
            }
            if (tree === Tree.REDWOOD) {
                treeObjects.remove(it.gameObject)
            }
        }
    }

    override fun onGameObjectChanged(it: GameObjectChanged) {
        treeObjects.remove(it.newObject)
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.new) {
            GameState.HOPPING -> {
                respawns.clear()
                treeObjects.clear()
            }
            GameState.LOADING -> treeObjects.clear()
            GameState.LOGGED_IN ->                // After login trees that are depleted will be changed,
                // wait for the next game tick before watching for
                // trees to despawn
                recentlyLoggedIn = true
            else -> {}
        }
    }

    override fun onAnimationChanged(it: AnimationChanged) {
        val local = client.localPlayer
        if (it.actor !== local) {


            val animId = local!!.animation
            val axe: Axe? = Axe.Companion.findAxeByAnimId(animId)

            if (axe != null) {
                this.axe = axe
            }
        }
    }

    fun getTreeObjects(): Set<GameObject> {
        return treeObjects
    }

    fun getRespawns(): List<TreeRespawn> {
        return respawns
    }

    companion object {
        private val WOOD_CUT_PATTERN = Pattern.compile("You get (?:some|an)[\\w ]+(?:logs?|mushrooms)\\.")
    }
}