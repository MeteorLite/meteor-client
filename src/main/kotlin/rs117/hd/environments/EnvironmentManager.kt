/*
 * Copyright (c) 2021, 117 <https://twitter.com/117scape>
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
package rs117.hd.environments

import com.google.common.primitives.Floats
import rs117.hd.HDUtils.lerpVectors
import rs117.hd.HDUtils.lerp
import rs117.hd.HDUtils.colorRGBToInt
import meteor.Refs
import net.runelite.api.Constants
import net.runelite.api.coords.WorldPoint
import net.runelite.api.coords.LocalPoint
import net.runelite.api.GameState
import rs117.hd.GpuHDPlugin
import rs117.hd.HdPluginConfig
import rs117.hd.config.DefaultSkyColor
import java.util.ArrayList

class EnvironmentManager(private val config: HdPluginConfig, private val hdPlugin: GpuHDPlugin) {
    private val client = Main.client
    private var sceneEnvironments = ArrayList<Environment>()
    private var currentEnvironment: Environment? = null
    private val defaultEnvironment = Environment.OVERWORLD

    // transition time
    private val transitionDuration = 3000

    // distance in tiles to skip transition (e.g. entering cave, teleporting)
    private val skipTransitionTiles = 20

    // last environment change time
    private var startTime: Long = 0

    // transition complete time
    private var transitionCompleteTime: Long = 0

    // time of last frame; used for lightning
    var lastFrameTime: Long = -1

    // used for tracking changes to settings
    var lastSkyColor: DefaultSkyColor? = DefaultSkyColor.DEFAULT
    var lastEnvironmentLighting = true

    // previous camera target world X
    private var prevCamTargetX = 0

    // previous camera target world Y
    private var prevCamTargetY = 0
    private var startFogColor = floatArrayOf(0f, 0f, 0f)
    var currentFogColor = floatArrayOf(0f, 0f, 0f)
    var currentFogColorInt = 0
    private var targetFogColor = floatArrayOf(0f, 0f, 0f)
    private var startWaterColor = floatArrayOf(0f, 0f, 0f)
    var currentWaterColor = floatArrayOf(0f, 0f, 0f)
    private var targetWaterColor = floatArrayOf(0f, 0f, 0f)
    private var startFogDepth = 0
    var currentFogDepth = 0
    private var targetFogDepth = 0
    private var startAmbientStrength = 0f
    var currentAmbientStrength = 0f
    private var targetAmbientStrength = 0f
    private var startAmbientColor = floatArrayOf(0f, 0f, 0f)
    var currentAmbientColor = floatArrayOf(0f, 0f, 0f)
    private var targetAmbientColor = floatArrayOf(0f, 0f, 0f)
    private var startDirectionalStrength = 0f
    var currentDirectionalStrength = 0f
    private var targetDirectionalStrength = 0f
    private var startDirectionalColor = floatArrayOf(0f, 0f, 0f)
    var currentDirectionalColor = floatArrayOf(0f, 0f, 0f)
    private var targetDirectionalColor = floatArrayOf(0f, 0f, 0f)
    private var startUnderglowStrength = 0f
    var currentUnderglowStrength = 0f
    private var targetUnderglowStrength = 0f
    private var startUnderglowColor = floatArrayOf(0f, 0f, 0f)
    var currentUnderglowColor = floatArrayOf(0f, 0f, 0f)
    private var targetUnderglowColor = floatArrayOf(0f, 0f, 0f)
    private var startGroundFogStart = 0f
    var currentGroundFogStart = 0f
    private var targetGroundFogStart = 0f
    private var startGroundFogEnd = 0f
    var currentGroundFogEnd = 0f
    private var targetGroundFogEnd = 0f
    private var startGroundFogOpacity = 0f
    var currentGroundFogOpacity = 0f
    private var targetGroundFogOpacity = 0f
    var lightningEnabled = false
    fun update(): Boolean {
        val camPosition = localPointToWorldTile(hdPlugin.camTarget[0], hdPlugin.camTarget[1])
        val camTargetX = camPosition.x
        val camTargetY = camPosition.y
        val camTargetZ = camPosition.plane
        if (sceneEnvironments.isEmpty())
            return false
        for (environment in sceneEnvironments) {
            if (environment.area.containsPoint(camTargetX, camTargetY, camTargetZ)) {
                if (environment !== currentEnvironment) {
                    changeEnvironment(environment, camTargetX, camTargetY, false)
                }
                break
            }
        }
        if (lastSkyColor !== config.defaultSkyColor() || lastEnvironmentLighting != config.atmosphericLighting()) {
            changeEnvironment(currentEnvironment, camTargetX, camTargetY, true)
        }

        // modify all environment values during transition
        val currentTime = System.currentTimeMillis()
        if (currentTime >= transitionCompleteTime) {
            currentFogColor = targetFogColor
            currentWaterColor = targetWaterColor
            currentFogDepth = targetFogDepth
            currentAmbientStrength = targetAmbientStrength
            currentAmbientColor = targetAmbientColor
            currentDirectionalStrength = targetDirectionalStrength
            currentDirectionalColor = targetDirectionalColor
            currentUnderglowStrength = targetUnderglowStrength
            currentUnderglowColor = targetUnderglowColor
            currentGroundFogStart = targetGroundFogStart
            currentGroundFogEnd = targetGroundFogEnd
            currentGroundFogOpacity = targetGroundFogOpacity
        } else {
            // interpolate between start and target values
            val t = (currentTime - startTime).toFloat() / transitionDuration.toFloat()
            currentFogColor = lerpVectors(startFogColor, targetFogColor, t)
            currentWaterColor = lerpVectors(startWaterColor, targetWaterColor, t)
            currentFogDepth = lerp(startFogDepth.toFloat(), targetFogDepth.toFloat(), t).toInt()
            currentAmbientStrength = lerp(startAmbientStrength, targetAmbientStrength, t)
            currentAmbientColor = lerpVectors(startAmbientColor, targetAmbientColor, t)
            currentDirectionalStrength = lerp(startDirectionalStrength, targetDirectionalStrength, t)
            currentDirectionalColor = lerpVectors(startDirectionalColor, targetDirectionalColor, t)
            currentUnderglowStrength = lerp(startUnderglowStrength, targetUnderglowStrength, t)
            currentUnderglowColor = lerpVectors(startUnderglowColor, targetUnderglowColor, t)
            currentGroundFogStart = lerp(startGroundFogStart, targetGroundFogStart, t)
            currentGroundFogEnd = lerp(startGroundFogEnd, targetGroundFogEnd, t)
            currentGroundFogOpacity = lerp(startGroundFogOpacity, targetGroundFogOpacity, t)
        }
        updateLightning()
        currentFogColorInt = colorRGBToInt(currentFogColor)

        // update some things for use next frame
        prevCamTargetX = camTargetX
        prevCamTargetY = camTargetY
        lastFrameTime = System.currentTimeMillis()
        lastSkyColor = config.defaultSkyColor()
        lastEnvironmentLighting = config.atmosphericLighting()
        return true
    }

    /**
     * Updates variables used in transition effects
     *
     * @param newEnvironment
     * @param camTargetX
     * @param camTargetY
     */
    private fun changeEnvironment(
        newEnvironment: Environment?,
        camTargetX: Int,
        camTargetY: Int,
        instantChange: Boolean
    ) {
        currentEnvironment = newEnvironment
        //log.debug("currentEnvironment changed to " + newEnvironment);
        startTime = System.currentTimeMillis()
        transitionCompleteTime = if (instantChange) 0 else startTime + transitionDuration

        // set previous variables to current ones
        startFogColor = currentFogColor
        startWaterColor = currentWaterColor
        startFogDepth = currentFogDepth
        startAmbientStrength = currentAmbientStrength
        startAmbientColor = currentAmbientColor
        startDirectionalStrength = currentDirectionalStrength
        startDirectionalColor = currentDirectionalColor
        startUnderglowStrength = currentUnderglowStrength
        startUnderglowColor = currentUnderglowColor
        startGroundFogStart = currentGroundFogStart
        startGroundFogEnd = currentGroundFogEnd
        startGroundFogOpacity = currentGroundFogOpacity

        // set target variables to ones from new environment
        targetFogColor = newEnvironment!!.fogColor
        if (!newEnvironment.customFogColor) {
            val defaultSkyColor = config.defaultSkyColor()
            if (defaultSkyColor !== DefaultSkyColor.DEFAULT) {
                targetFogColor =
                    floatArrayOf(defaultSkyColor!!.r / 255f, defaultSkyColor.g / 255f, defaultSkyColor.b / 255f)
            }
        }
        targetWaterColor = newEnvironment.fogColor
        targetFogDepth = newEnvironment.fogDepth
        if (config.atmosphericLighting()) {
            targetAmbientStrength = newEnvironment.ambientStrength
            targetAmbientColor = newEnvironment.ambientColor
            targetDirectionalStrength = newEnvironment.directionalStrength
            targetDirectionalColor = newEnvironment.directionalColor
            targetUnderglowStrength = newEnvironment.underglowStrength
            targetUnderglowColor = newEnvironment.underglowColor
        } else {
            targetAmbientStrength = defaultEnvironment.ambientStrength
            targetAmbientColor = defaultEnvironment.ambientColor
            targetDirectionalStrength = defaultEnvironment.directionalStrength
            targetDirectionalColor = defaultEnvironment.directionalColor
            targetUnderglowStrength = defaultEnvironment.underglowStrength
            targetUnderglowColor = defaultEnvironment.underglowColor
        }
        targetGroundFogStart = newEnvironment.groundFogStart.toFloat()
        targetGroundFogEnd = newEnvironment.groundFogEnd.toFloat()
        targetGroundFogOpacity = newEnvironment.groundFogOpacity
        lightningEnabled = newEnvironment.lightningEnabled
        val tileChangeX = Math.abs(prevCamTargetX - camTargetX)
        val tileChangeY = Math.abs(prevCamTargetY - camTargetY)
        val tileChange = Math.max(tileChangeX, tileChangeY)

        // skip the transitional fade if the player has moved too far
        // since the previous frame. results in an instant transition when
        // teleporting, entering dungeons, etc.
        if (tileChange >= skipTransitionTiles) {
            transitionCompleteTime = startTime
        }
    }

    /**
     * Figures out which Areas exist in the current scene and
     * adds them to lists for easy access.
     */
    fun loadSceneEnvironments() {
        // loop through all Areas, check Rects of each Area. if any
        // coordinates overlap scene coordinates, add them to a list.
        // then loop through all Environments, checking to see if any
        // of their Areas match any of the ones in the current scene.
        // if so, add them to a list.
        sceneEnvironments = ArrayList()
        var sceneMinX = client.baseX
        var sceneMinY = client.baseY
        if (client.isInInstancedRegion) {
            val localPoint = if (client.localPlayer != null) client.localPlayer!!.localLocation else LocalPoint(0, 0)
            val worldPoint = WorldPoint.fromLocalInstance(client, localPoint)
            sceneMinX = worldPoint.x - localPoint.sceneX
            sceneMinY = worldPoint.y - localPoint.sceneY
        }
        val sceneMaxX = sceneMinX + Constants.SCENE_SIZE - 2
        val sceneMaxY = sceneMinY + Constants.SCENE_SIZE - 2

        //log.debug("adding environments for scene {},{} - {},{}..", sceneMinX, sceneMinY, sceneMaxX, sceneMaxY);
        for (environment in Environment.values()) {
            for (rect in environment.area.rects) {
                if (rect.minX > sceneMaxX || sceneMinX > rect.maxX || rect.minY > sceneMaxY || sceneMinY > rect.maxY) {
                    continue
                }
                //log.debug("added environment {} to sceneArea list", environment.name());
                sceneEnvironments!!.add(environment)
                break
            }
        }
        for (environment in sceneEnvironments!!) {
            //log.debug("sceneArea: " + environment.name());
        }
    }

    /* lightning */
    var lightningBrightness = 0f
    var lightningColor = floatArrayOf(1.0f, 1.0f, 1.0f)
    var nextLightningTime = -1.0
    var newLightningBrightness = 7f
    var lightningFadeSpeed = 80f // brightness units per second
    var minLightningInterval = 5500
    var maxLightningInterval = 17000
    var quickLightningChance = 2f
    var minQuickLightningInterval = 40
    var maxQuickLightningInterval = 150

    /**
     * Updates lightning variables and sets water reflection and sky
     * colors during lightning flashes.
     */
    fun updateLightning() {
        if (lightningBrightness > 0) {
            val frameTime = (System.currentTimeMillis() - lastFrameTime).toInt()
            val brightnessChange = frameTime / 1000f * lightningFadeSpeed
            lightningBrightness = Math.max(lightningBrightness - brightnessChange, 0f)
        }
        if (nextLightningTime == -1.0) {
            generateNextLightningTime()
            return
        }
        if (System.currentTimeMillis() > nextLightningTime) {
            lightningBrightness = newLightningBrightness
            generateNextLightningTime()
        }
        if (lightningEnabled && config.flashingEffects()) {
            val t = Floats.constrainToRange(lightningBrightness, 0.0f, 1.0f)
            currentFogColor = lerpVectors(currentFogColor, lightningColor, t)
            currentWaterColor = lerpVectors(currentWaterColor, lightningColor, t)
        } else {
            lightningBrightness = 0f
        }
    }

    /**
     * Determines when the next lighting strike will occur.
     * Produces a short interval for a quick successive strike
     * or a longer interval at the end of a cluster.
     */
    fun generateNextLightningTime() {
        val lightningInterval =
            (minLightningInterval + (maxLightningInterval - minLightningInterval) * Math.random()).toInt()
        val quickLightningInterval =
            (minQuickLightningInterval + (maxQuickLightningInterval - minQuickLightningInterval) * Math.random()).toInt()
        nextLightningTime = if (Math.random() <= 1f / quickLightningChance) {
            // chain together lighting strikes in quick succession
            (System.currentTimeMillis() + quickLightningInterval).toDouble()
        } else {
            // cool-down period before a new lightning cluster
            (System.currentTimeMillis() + lightningInterval).toDouble()
        }
    }

    /**
     * Returns the current fog color if logged in.
     * Else, returns solid black.
     *
     * @return
     */
    val fogColor: Int
        get() = if (client.gameState.state >= GameState.LOADING.state) currentFogColorInt else 0

    /**
     * Returns the world tile coordinates of a given local point, adjusted to template coordinates if within an instance.
     *
     * @param pointX
     * @param pointY
     * @return adjusted world coordinates
     */
    fun localPointToWorldTile(pointX: Int, pointY: Int): WorldPoint {
        val instanceTemplateChunks = client.instanceTemplateChunks
        val localPoint = LocalPoint(pointX, pointY)
        val chunkX = localPoint.sceneX / Constants.CHUNK_SIZE
        val chunkY = localPoint.sceneY / Constants.CHUNK_SIZE
        return if (client.isInInstancedRegion && chunkX >= 0 && chunkX < instanceTemplateChunks[client.plane].size && chunkY >= 0 && chunkY < instanceTemplateChunks[client.plane][chunkX].size
        ) {
            // In some scenarios, taking the detached camera outside of instances
            // will result in a crash if we don't check the chunk array indices first
            WorldPoint.fromLocalInstance(client, localPoint)
        } else {
            WorldPoint.fromLocal(client, localPoint)
        }
    }
}