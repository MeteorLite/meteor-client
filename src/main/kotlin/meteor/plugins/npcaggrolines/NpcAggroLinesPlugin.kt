/*
 * Copyright (c) 2018, Woox <https://github.com/wooxsolo>
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
package meteor.plugins.npcaggrolines

import meteor.Main
import eventbus.events.ConfigChanged
import eventbus.events.GameStateChanged
import eventbus.events.GameTick
import meteor.config.ConfigManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.ui.overlay.infobox.InfoBoxManager
import net.runelite.api.Constants
import net.runelite.api.GameState
import net.runelite.api.ItemID
import net.runelite.api.Perspective
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldArea
import net.runelite.api.coords.WorldPoint
import net.runelite.api.geometry.Geometry
import java.awt.Polygon
import java.awt.Rectangle
import java.awt.geom.Area
import java.awt.geom.GeneralPath
import java.awt.image.BufferedImage
import java.time.Duration
import java.time.Instant
import java.util.*

@PluginDescriptor(
    name = "NPC Aggro Lines",
    description = "Highlights the lines that will reset NPC aggro timer if crossed",
    tags = ["highlight", "lines", "unaggro", "aggro", "aggressive", "npcs", "area", "slayer"]
)
class NpcAggroLinesPlugin : Plugin() {

    override val config = configuration<NpcAggroLinesConfig>()

    private val overlay = overlay(NpcAggroLinesOverlay(config, this))
    private val itemManager = Main.itemManager
    private val infoBoxManager = InfoBoxManager
    private val configManager = ConfigManager

    val safeCenters = arrayOfNulls<WorldPoint>(2)
    val linesToDisplay = arrayOfNulls<GeneralPath>(Constants.MAX_Z)

    internal var currentTimer: AggressionTimer? = null
    private var lastPlayerLocation: WorldPoint? = null
    private var previousUnknownCenter: WorldPoint? = null
    private var loggingIn = false
    private var notifyOnce = false
    private var playerName = ""

    override fun onStop() {
        removeTimer()
        Arrays.fill(safeCenters, null)
        lastPlayerLocation = null
        currentTimer = null
        loggingIn = false

        Arrays.fill(linesToDisplay, null)
    }

    private fun generateSafeArea(): Area {
        val area = Area()
        for (wp in safeCenters) {
            if (wp == null) {
                continue
            }
            val poly = Polygon()
            poly.addPoint(wp.x - SAFE_AREA_RADIUS, wp.y - SAFE_AREA_RADIUS)
            poly.addPoint(wp.x - SAFE_AREA_RADIUS, wp.y + SAFE_AREA_RADIUS + 1)
            poly.addPoint(wp.x + SAFE_AREA_RADIUS + 1, wp.y + SAFE_AREA_RADIUS + 1)
            poly.addPoint(wp.x + SAFE_AREA_RADIUS + 1, wp.y - SAFE_AREA_RADIUS)
            area.add(Area(poly))
        }
        return area
    }

    private fun transformWorldToLocal(coords: FloatArray) {
        val lp = LocalPoint.fromWorld(client, coords[0].toInt(), coords[1].toInt())
        coords[0] = lp.x - Perspective.LOCAL_TILE_SIZE / 2f
        coords[1] = lp.y - Perspective.LOCAL_TILE_SIZE / 2f
    }

    private fun calculateLinesToDisplay() {
        if (!config.showAreaLines()) {
            Arrays.fill(linesToDisplay, null)
            return
        }
        val sceneRect = Rectangle(
            client.baseX + 1, client.baseY + 1,
            Constants.SCENE_SIZE - 2, Constants.SCENE_SIZE - 2
        )
        for (i in linesToDisplay.indices) {
            var lines: GeneralPath? = GeneralPath(generateSafeArea())
            lines = Geometry.clipPath(lines, sceneRect)
            lines = Geometry.splitIntoSegments(lines, 1f)
            lines = Geometry.transformPath(lines) { coords: FloatArray -> transformWorldToLocal(coords) }
            linesToDisplay[i] = lines
        }
    }

    private fun removeTimer() {
        infoBoxManager.removeInfoBox(currentTimer)
        currentTimer = null
        notifyOnce = false
    }

    private fun createTimer(duration: Duration) {
        removeTimer()
        val image: BufferedImage = itemManager.getImage(ItemID.ENSOULED_DEMON_HEAD) as BufferedImage
        currentTimer = AggressionTimer(duration, image, this, config.showTimer())
        infoBoxManager.addInfoBox(currentTimer!!)
        notifyOnce = true
    }

    private fun resetTimer() {
        createTimer(Duration.ofSeconds(AGGRESSIVE_TIME_SECONDS.toLong()))
    }

    override fun onGameTick(it: GameTick) {
        playerName = client.localPlayer!!.name!!
        if (playerName == "")
            return
        loadConfig(skipTimer = true)
        val newLocation = client.localPlayer!!.worldLocation
        if (currentTimer != null && currentTimer!!.cull() && notifyOnce) {
            if (config.notifyExpire()) {
                //notifier.notify("NPC aggression has expired!");
            }
            notifyOnce = false
        }
        if (lastPlayerLocation != null) {
            if (safeCenters[1] == null && newLocation.distanceTo2D(lastPlayerLocation) > SAFE_AREA_RADIUS * 4) {
                safeCenters[0] = null
                safeCenters[1] = newLocation
                resetTimer()

                // We don't know where the previous area was, so if the player e.g.
                // entered a dungeon and then goes back out, he/she may enter the previous
                // area which is unknown and would make the plugin inaccurate
                previousUnknownCenter = lastPlayerLocation
            }
        }
        if (safeCenters[0] == null && previousUnknownCenter != null && previousUnknownCenter!!.distanceTo2D(newLocation) <= UNKNOWN_AREA_RADIUS) {
            // Player went back to their previous unknown area before the 2nd
            // center point was found, which means we don't know where it is again.
            safeCenters[1] = null
            removeTimer()
        }
        if (safeCenters[1] != null) {
            if (Arrays.stream(safeCenters)
                    .noneMatch { x: WorldPoint? -> x != null && x.distanceTo2D(newLocation) <= SAFE_AREA_RADIUS }
            ) {
                safeCenters[0] = safeCenters[1]
                safeCenters[1] = newLocation
                resetTimer()
                previousUnknownCenter = null
            }
        }
        lastPlayerLocation = newLocation
        saveConfig()
        calculateLinesToDisplay()
    }

    override fun onConfigChanged(it: ConfigChanged) {
        val key = it.key
        when (key) {
            "npcUnaggroShowTimer" -> if (currentTimer != null) {
                currentTimer!!.visible = (config.showTimer())
            }
            "npcUnaggroCollisionDetection", "npcUnaggroShowAreaLines" -> calculateLinesToDisplay()
        }
    }

    private fun loadConfig(skipTimer: Boolean = false) {
        safeCenters[0] = configManager.getConfiguration(
            NpcAggroLinesConfig.CONFIG_GROUP,
            playerName + NpcAggroLinesConfig.CONFIG_CENTER1,
            WorldPoint::class.java
        )
        safeCenters[1] = configManager.getConfiguration(
            NpcAggroLinesConfig.CONFIG_GROUP,
            playerName + NpcAggroLinesConfig.CONFIG_CENTER2,
            WorldPoint::class.java
        )
        lastPlayerLocation = configManager.getConfiguration(
            NpcAggroLinesConfig.CONFIG_GROUP,
            playerName + NpcAggroLinesConfig.CONFIG_LOCATION,
            WorldPoint::class.java
        )
        if (!skipTimer) {
            val timeLeft = configManager.getConfiguration(
                NpcAggroLinesConfig.CONFIG_GROUP,
                playerName + NpcAggroLinesConfig.CONFIG_DURATION,
                Duration::class.java
            )
            if (timeLeft != null && !timeLeft.isNegative) {
                createTimer(timeLeft)
            }
        }
    }

    private fun saveConfig() {
        safeCenters[0]?.let {
            configManager.setConfiguration(
                NpcAggroLinesConfig.CONFIG_GROUP,
                playerName + NpcAggroLinesConfig.CONFIG_CENTER1,
                it
            )
        }
        safeCenters[1]?.let {
            configManager.setConfiguration(
                NpcAggroLinesConfig.CONFIG_GROUP,
                playerName + NpcAggroLinesConfig.CONFIG_CENTER2,
                it
            )
        }
        lastPlayerLocation?.let {
            configManager.setConfiguration(
                NpcAggroLinesConfig.CONFIG_GROUP,
                playerName + NpcAggroLinesConfig.CONFIG_LOCATION,
                it
            )
        }
        configManager.setConfiguration(
            NpcAggroLinesConfig.CONFIG_GROUP,
            playerName + NpcAggroLinesConfig.CONFIG_DURATION,
            Duration.between(
                Instant.now(), currentTimer!!.endTime
            )
        )
    }

    private fun onLogin() {
        loadConfig()
        val newLocation = client.localPlayer!!.worldLocation!!

        // If the player isn't at the location he/she logged out at,
        // the safe unaggro area probably changed, and should be disposed.
        if (lastPlayerLocation == null || newLocation.distanceTo(lastPlayerLocation) != 0) {
            safeCenters[0] = null
            safeCenters[1] = null
            lastPlayerLocation = newLocation
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gamestate) {
            GameState.LOGGED_IN -> {
                if (loggingIn) {
                    loggingIn = false
                    onLogin()
                }
            }
            GameState.LOGGING_IN -> loggingIn = true
            GameState.LOGIN_SCREEN -> {
                if (lastPlayerLocation != null) {
                    saveConfig()
                }
                safeCenters[0] = null
                safeCenters[1] = null
                lastPlayerLocation = null
            }
        }
    }

    companion object {
        /*
	How it works: The game remembers 2 tiles. When the player goes >10 steps
	away from both tiles, the oldest one is moved to under the player and the
	NPC aggression timer resets.
	So to first figure out where the 2 tiles are, we wait until the player teleports
	a long enough distance. At that point it's very likely that the player
	moved out of the radius of both tiles, which resets one of them. The other
	should reset shortly after as the player starts moving around.
	*/
        private const val SAFE_AREA_RADIUS = 10
        private const val UNKNOWN_AREA_RADIUS = SAFE_AREA_RADIUS * 2
        private const val AGGRESSIVE_TIME_SECONDS = 600
        private val WILDERNESS_ABOVE_GROUND = WorldArea(2944, 3523, 448, 448, 0)
        private val WILDERNESS_UNDERGROUND = WorldArea(2944, 9918, 320, 442, 0)
        private fun isInWilderness(location: WorldPoint): Boolean {
            return WILDERNESS_ABOVE_GROUND.distanceTo2D(location) == 0 || WILDERNESS_UNDERGROUND.distanceTo2D(location) == 0
        }
    }
}