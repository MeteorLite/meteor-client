/*
 * Copyright (c) 2019 Abex
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
package rs117.hd.lighting

import com.google.common.primitives.Floats
import com.google.common.primitives.Ints
import eventbus.events.ItemDespawned
import eventbus.events.ItemSpawned
import eventbus.events.NpcChanged
import eventbus.events.NpcDespawned
import meteor.config.ConfigManager
import meteor.plugins.PluginManager
import meteor.plugins.grounditems.GroundItemsPlugin
import net.runelite.api.*
import net.runelite.api.coords.LocalPoint
import net.runelite.api.coords.WorldPoint
import rs117.hd.GpuHDPlugin
import rs117.hd.HDUtils.lerp
import rs117.hd.HdPluginConfig
import java.awt.Color
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*
import java.util.regex.Pattern

class LightManager(private val config: HdPluginConfig, private val hdPlugin: GpuHDPlugin) {
    private val client = Main.client
    private val configManager = ConfigManager
    var allLights = ArrayList<Light>()
    var sceneLights = ArrayList<Light>()
    var sceneProjectiles = ArrayList<Projectile?>()
    var lastFrameTime: Long = -1
    var sceneMinX = 0
    var sceneMinY = 0
    var sceneMaxX = 0
    var sceneMaxY = 0
    var visibleLightsCount = 0

    enum class LightType {
        STATIC, FLICKER, PULSE
    }

    enum class Alignment(val orientation: Int, val radial: Boolean, val relative: Boolean) {
        CENTER(0, false, false), NORTH(0, true, false), NORTHEAST(256, true, false), NORTHEAST_CORNER(
            256,
            false,
            false
        ),
        EAST(512, true, false), SOUTHEAST(768, true, false), SOUTHEAST_CORNER(768, false, false), SOUTH(
            1024,
            true,
            false
        ),
        SOUTHWEST(1280, true, false), SOUTHWEST_CORNER(1280, false, false), WEST(1536, true, false), NORTHWEST(
            1792,
            true,
            false
        ),
        NORTHWEST_CORNER(1792, false, false), BACK(0, true, true), BACKLEFT(256, true, true), BACKLEFT_CORNER(
            256,
            false,
            true
        ),
        LEFT(512, true, true), FRONTLEFT(768, true, true), FRONTLEFT_CORNER(768, false, true), FRONT(
            1024,
            true,
            true
        ),
        FRONTRIGHT(1280, true, true), FRONTRIGHT_CORNER(1280, false, true), RIGHT(1536, true, true), BACKRIGHT(
            1792,
            true,
            true
        ),
        BACKRIGHT_CORNER(1792, false, true);
    }

    class Light(
        var worldX: Int,
        var worldY: Int,
        var plane: Int,
        var height: Int,
        var alignment: Alignment,
        var size: Int,
        var strength: Float,
        var color: FloatArray,
        var type: LightType,
        var duration: Float,
        var range: Float,
        var fadeInDuration: Int
    ) {
        var currentSize: Int
        var currentStrength: Float
        var currentColor: FloatArray
        var currentAnimation = 0.5f
        var currentFadeIn = 0
        var visible = true
        var x = 0
        var y = 0
        var z = 0
        var distance = 0
        var belowFloor = false
        var aboveFloor = false
        var projectile: Projectile? = null
        var npc: NPC? = null
        var `object`: TileObject? = null
        var tileItem: TileItem? = null

        init {
            currentSize = size
            currentStrength = strength
            currentColor = color
            if (type == LightType.PULSE) {
                currentAnimation = Math.random().toFloat()
            }
        }
    }

    fun update() {
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }
        val camX = hdPlugin.camTarget[0]
        val camY = hdPlugin.camTarget[1]
        val camZ = hdPlugin.camTarget[2]
        val lightIterator = sceneLights.iterator()
        while (lightIterator.hasNext()) {
            val light = lightIterator.next()
            val frameTime = System.currentTimeMillis() - lastFrameTime
            light.distance = Int.MAX_VALUE
            if (light.projectile != null) {
                if (light.projectile!!.remainingCycles <= 0) {
                    lightIterator.remove()
                    sceneProjectiles.remove(light.projectile)
                    continue
                }
                light.x = light.projectile!!.x.toInt()
                light.y = light.projectile!!.y.toInt()
                light.z = light.projectile!!.z.toInt()
                light.visible = hdPlugin.configProjectileLights
            }
            if (light.tileItem?.worldLocation != null) {
                val localPoint = LocalPoint.fromWorld(client, light.tileItem!!.worldLocation)
                if (localPoint != null) {
                    light.x = localPoint.x
                    light.y = localPoint.y
                    // Interpolate between tile heights based on specific scene coordinates.
                    val lerpX = light.x % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                    val lerpY = light.y % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                    val baseTileX = Math.floor((light.x / Perspective.LOCAL_TILE_SIZE.toFloat()).toDouble()).toInt()
                    val baseTileY = Math.floor((light.y / Perspective.LOCAL_TILE_SIZE.toFloat()).toDouble()).toInt()
                    val heightNorth = lerp(
                        client.tileHeights[light.tileItem!!.worldLocation.plane][baseTileX][baseTileY + 1]
                            .toFloat(),
                        client.tileHeights[light.tileItem!!.worldLocation.plane][baseTileX + 1][baseTileY + 1]
                            .toFloat(),
                        lerpX
                    )
                    val heightSouth = lerp(
                        client.tileHeights[light.tileItem!!.worldLocation.plane][baseTileX][baseTileY]
                            .toFloat(),
                        client.tileHeights[light.tileItem!!.worldLocation.plane][baseTileX + 1][baseTileY]
                            .toFloat(),
                        lerpX
                    )
                    val tileHeight = lerp(heightSouth, heightNorth, lerpY)
                    light.z = tileHeight.toInt() - 1 - light.height
                    light.visible = true
                } else light.visible = false
            }
            if (light.npc != null) {
                if (light.npc !== client.cachedNPCs[light.npc!!.index]) {
                    lightIterator.remove()
                    continue
                }
                light.x = light.npc!!.localLocation.x
                light.y = light.npc!!.localLocation.y

                // Offset the light's position based on its Alignment
                if (light.alignment == Alignment.NORTH || light.alignment == Alignment.NORTHEAST || light.alignment == Alignment.NORTHWEST) {
                    light.y += Perspective.LOCAL_HALF_TILE_SIZE
                }
                if (light.alignment == Alignment.SOUTH || light.alignment == Alignment.SOUTHEAST || light.alignment == Alignment.SOUTHWEST) {
                    light.y -= Perspective.LOCAL_HALF_TILE_SIZE
                }
                if (light.alignment == Alignment.EAST || light.alignment == Alignment.SOUTHEAST || light.alignment == Alignment.NORTHEAST) {
                    light.x += Perspective.LOCAL_HALF_TILE_SIZE
                }
                if (light.alignment == Alignment.WEST || light.alignment == Alignment.SOUTHWEST || light.alignment == Alignment.NORTHWEST) {
                    light.x -= Perspective.LOCAL_HALF_TILE_SIZE
                }
                var plane = light.npc!!.worldLocation.plane
                light.plane = plane
                val npcTileX = light.npc!!.localLocation.sceneX
                val npcTileY = light.npc!!.localLocation.sceneY

                // Some NPCs, such as Crystalline Hunllef in The Gauntlet, sometimes return scene X/Y values far outside of the possible range.
                if (npcTileX < Perspective.SCENE_SIZE && npcTileY < Perspective.SCENE_SIZE && npcTileX >= 0 && npcTileY >= 0) {
                    // Tile null check is to prevent oddities caused by - once again - Crystalline Hunllef.
                    // May also apply to other NPCs in instances.
                    if (client.scene.tiles[plane][npcTileX][npcTileY] != null && client.scene.tiles[plane][npcTileX][npcTileY].bridge != null) {
                        plane++
                    }

                    // Interpolate between tile heights based on specific scene coordinates.
                    val lerpX = light.x % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                    val lerpY = light.y % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                    val baseTileX = Math.floor((light.x / Perspective.LOCAL_TILE_SIZE.toFloat()).toDouble()).toInt()
                    val baseTileY = Math.floor((light.y / Perspective.LOCAL_TILE_SIZE.toFloat()).toDouble()).toInt()
                    val heightNorth = lerp(
                        client.tileHeights[plane][baseTileX][baseTileY + 1].toFloat(),
                        client.tileHeights[plane][baseTileX + 1][baseTileY + 1]
                            .toFloat(),
                        lerpX
                    )
                    val heightSouth = lerp(
                        client.tileHeights[plane][baseTileX][baseTileY].toFloat(),
                        client.tileHeights[plane][baseTileX + 1][baseTileY]
                            .toFloat(),
                        lerpX
                    )
                    val tileHeight = lerp(heightSouth, heightNorth, lerpY)
                    light.z = tileHeight.toInt() - 1 - light.height
                    light.visible = light.npc!!.`model$api` != null
                    if (!hdPlugin.configNpcLights) {
                        light.visible = false
                    }
                } else {
                    light.visible = false
                }
            }
            if (light.type == LightType.FLICKER) {
                val change = Math.random() * 2 - 1.0f
                val flickerRate = 1000 // 1800
                val sizeAdjustment = 15
                val maxFlicker = 1f + light.range / 100f
                val minFlicker = 1f - light.range / 100f
                light.currentStrength += (light.strength / (frameTime / 1000f * flickerRate) * change).toFloat()
                light.currentStrength = Floats.constrainToRange(
                    light.currentStrength,
                    light.strength * minFlicker,
                    light.strength * maxFlicker
                )
                light.currentSize += (light.size / sizeAdjustment * change).toInt()
                light.currentSize = Ints.constrainToRange(
                    light.currentSize,
                    (light.size * minFlicker).toInt(),
                    (light.size * maxFlicker).toInt()
                )
            } else if (light.type == LightType.PULSE) {
                val duration = light.duration / 1000f
                val range = light.range / 100f
                val fullRange = range * 2f
                val change = frameTime / 1000f / duration
                //				change = change % 1.0f;
                light.currentAnimation += change % 1.0f
                // lock animation to 0-1
                light.currentAnimation = light.currentAnimation % 1.0f
                var output: Float
                output = if (light.currentAnimation > 0.5f) {
                    // light is shrinking
                    1f - (light.currentAnimation - 0.5f) * 2
                } else {
                    // light is expanding
                    light.currentAnimation * 2f
                }
                val multiplier = 1.0f - range + output * fullRange
                light.currentSize = (light.size * multiplier).toInt()
                light.currentStrength = light.strength * multiplier
            } else {
                light.currentStrength = light.strength
                light.currentSize = light.size
                light.currentColor = light.color
            }
            // Apply fade-in
            if (light.fadeInDuration > 0) {
                light.currentStrength *= Math.min(light.currentFadeIn.toFloat() / light.fadeInDuration.toFloat(), 1.0f)
                light.currentFadeIn += frameTime.toInt()
            }

            // Calculate the distance between the player and the light to determine which
            // lights to display based on the 'max dynamic lights' config option
            light.distance = Math.sqrt(
                Math.pow((camX - light.x).toDouble(), 2.0) + Math.pow(
                    (camY - light.y).toDouble(),
                    2.0
                ) + Math.pow((camZ - light.z).toDouble(), 2.0)
            ).toInt()
            val tileX = Math.floor((light.x / 128f).toDouble()).toInt()
            val tileY = Math.floor((light.y / 128f).toDouble()).toInt()
            val tileZ = light.plane
            light.belowFloor = false
            light.aboveFloor = false
            if (tileX < Perspective.SCENE_SIZE && tileY < Perspective.SCENE_SIZE && tileX >= 0 && tileY >= 0) {
                val aboveTile = if (tileZ < 3) client.scene.tiles[tileZ + 1][tileX][tileY] else null
                if (aboveTile != null && (aboveTile.sceneTilePaint != null || aboveTile.sceneTileModel != null)) {
                    light.belowFloor = true
                }
                val lightTile = client.scene.tiles[tileZ][tileX][tileY]
                if (lightTile != null && (lightTile.sceneTilePaint != null || lightTile.sceneTileModel != null)) {
                    light.aboveFloor = true
                }
            }
        }
        sceneLights.sortWith(Comparator.comparingInt { light: Light -> light.distance })
        lastFrameTime = System.currentTimeMillis()
    }

    fun reset() {
        sceneLights = ArrayList()
        sceneProjectiles = ArrayList()
    }

    fun loadSceneLights() {
        sceneMinX = client.baseX
        sceneMinY = client.baseY
        if (client.isInInstancedRegion) {
            // adjust coordinates when inside an instanced area
            val localPoint = client.localPlayer!!.localLocation
            val worldPoint = WorldPoint.fromLocalInstance(client, localPoint)
            sceneMinX = worldPoint.x - localPoint.sceneX
            sceneMinY = worldPoint.y - localPoint.sceneY
        }
        sceneMaxX = sceneMinX + Constants.SCENE_SIZE - 2
        sceneMaxY = sceneMinY + Constants.SCENE_SIZE - 2
        for (light in allLights) {
            if (light.worldX >= sceneMinX && light.worldX <= sceneMaxX && light.worldY >= sceneMinY && light.worldY <= sceneMaxY) {
                sceneLights.add(light)
                calculateScenePosition(light)
            }
        }
        val tiles = client.scene.tiles
        for (i in tiles.indices) {
            for (j in 0 until tiles[i].size) {
                for (k in 0 until tiles[i][j].size) {
                    val tile = tiles[i][j][k] ?: continue
                    val decorativeObject = tile.decorativeObject
                    if (decorativeObject != null && decorativeObject.renderable != null) {
                        addObjectLight(decorativeObject, tile.renderLevel)
                    }
                    val wallObject = tile.wallObject
                    if (wallObject != null && wallObject.renderable1 != null) {
                        var orientation = 0
                        when (wallObject.orientationA) {
                            1 -> orientation = 512
                            2 -> orientation = 1024
                            4 -> orientation = 1536
                            8 -> orientation = 0
                            16 -> orientation = 768
                            32 -> orientation = 1280
                            64 -> orientation = 1792
                            128 -> orientation = 256
                        }
                        addObjectLight(wallObject, tile.renderLevel, 1, 1, orientation)
                    }
                    val groundObject = tile.groundObject
                    if (groundObject != null && groundObject.renderable != null) {
                        addObjectLight(groundObject, tile.renderLevel)
                    }
                    for (gameObject in tile.gameObjects) {
                        if (gameObject != null) {
                            addObjectLight(
                                gameObject,
                                tile.renderLevel,
                                gameObject.sizeX(),
                                gameObject.sizeY(),
                                gameObject.orientation.angle
                            )
                        }
                    }
                }
            }
        }
        updateSceneNpcs()
    }

    fun updateSceneNpcs() {
        // check the NPCs in the scene to make sure they have lights assigned, if applicable,
        // for scenarios in which HD mode or dynamic lights were disabled during NPC spawn
        val npcs = client.npcs
        for (npc in npcs) {
            val npcId = npc.id
            val npcLight = NpcLight.find(npcId) ?: continue
            addNpcLight(npc)
        }
    }

    fun updateNpcChanged(npcChanged: NpcChanged) {
        removeNpcLight(npcChanged)
        addNpcLight(npcChanged.npc)
    }

    fun getVisibleLights(maxDistance: Int, maxLights: Int): ArrayList<Light> {
        val visibleLights = ArrayList<Light>()
        var lightsCount = 0
        for (light in sceneLights) {
            if (lightsCount >= maxLights || light.distance > maxDistance * Perspective.LOCAL_TILE_SIZE) {
                break
            }
            if (!light.visible) {
                continue
            }
            // Hide certain lights on planes lower than the player to prevent light 'leaking' through the floor
            if (light.plane < client.plane && light.belowFloor) {
                continue
            }
            // Hide any light that is above the current plane and is above a solid floor
            if (light.plane > client.plane && light.aboveFloor) {
                continue
            }
            visibleLights.add(light)
            lightsCount++
        }
        visibleLightsCount = lightsCount
        return visibleLights
    }

    fun addProjectileLight(projectile: Projectile) {
        val id = projectile.id
        val projectileLight = ProjectileLight.find(id) ?: return
        if (sceneProjectiles.contains(projectile)) {
            // prevent duplicate lights being spawned for the same projectile
            return
        }
        val light = Light(
            0,
            0,
            projectile.floor,
            0,
            Alignment.CENTER,
            projectileLight.size,
            projectileLight.strength,
            projectileLight.color,
            projectileLight.lightType,
            projectileLight.duration.toFloat(),
            projectileLight.range.toFloat(),
            300
        )
        light.projectile = projectile
        light.x = projectile.x.toInt()
        light.y = projectile.y.toInt()
        light.z = projectile.z.toInt()
        sceneProjectiles.add(projectile)
        sceneLights.add(light)
    }

    fun addNpcLight(npc: NPC) {
        val id = npc.id
        val npcLight = NpcLight.find(id) ?: return

        // prevent duplicate lights being spawned for the same NPC
        for (light in sceneLights) {
            if (light.npc === npc) {
                return
            }
        }
        val light = Light(
            0,
            0,
            -1,
            npcLight.height,
            npcLight.alignment,
            npcLight.size,
            npcLight.strength,
            npcLight.color,
            npcLight.lightType,
            npcLight.duration.toFloat(),
            npcLight.range.toFloat(),
            0
        )
        light.npc = npc
        light.visible = false
        sceneLights.add(light)
    }

    fun removeNpcLight(npcDespawned: NpcDespawned) {
        sceneLights.removeIf { light: Light -> light.npc === npcDespawned.npc }
    }

    fun removeNpcLight(npcChanged: NpcChanged) {
        sceneLights.removeIf { light: Light -> light.npc === npcChanged.npc }
    }

    @JvmOverloads
    fun addObjectLight(tileObject: TileObject, plane: Int, sizeX: Int = 1, sizeY: Int = 1, orientation: Int = -1) {
        var orientation = orientation
        val id = tileObject.id
        val objectLight = ObjectLight.find(id) ?: return
        if (sceneLights.stream().anyMatch { light: Light ->
                light.`object` != null && tileObjectHash(light.`object`) == tileObjectHash(tileObject)
            }) {
            // prevent duplicate lights being spawned for the same object
            return
        }
        val worldLocation = tileObject.worldLocation
        val light = Light(
            worldLocation.x,
            worldLocation.y,
            worldLocation.plane,
            objectLight.height,
            objectLight.alignment,
            objectLight.size,
            objectLight.strength,
            objectLight.color,
            objectLight.lightType,
            objectLight.duration.toFloat(),
            objectLight.range.toFloat(),
            0
        )
        val localLocation = tileObject.localLocation
        light.x = localLocation.x
        light.y = localLocation.y
        var lightX = tileObject.x
        var lightY = tileObject.y
        val localSizeX = sizeX * Perspective.LOCAL_TILE_SIZE
        val localSizeY = sizeY * Perspective.LOCAL_TILE_SIZE
        if (orientation != -1 && light.alignment != Alignment.CENTER) {
            var radius = localSizeX / 2f
            if (!light.alignment.radial) {
                radius = Math.sqrt((localSizeX * localSizeX + localSizeX * localSizeX).toDouble()).toFloat() / 2
            }
            if (!light.alignment.relative) {
                orientation = 0
            }
            orientation += light.alignment.orientation
            orientation %= 2048
            val sine = Perspective.SINE[orientation] / 65536f
            var cosine = Perspective.COSINE[orientation] / 65536f
            cosine /= localSizeX.toFloat() / localSizeY.toFloat()
            val offsetX = (radius * sine).toInt()
            val offsetY = (radius * cosine).toInt()
            lightX += offsetX
            lightY += offsetY
        }
        val tileX = lightX.toFloat() / Perspective.LOCAL_TILE_SIZE
        val tileY = lightY.toFloat() / Perspective.LOCAL_TILE_SIZE
        val lerpX = lightX % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
        val lerpY = lightY % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
        var tileMinX = Math.floor(tileX.toDouble()).toInt()
        var tileMinY = Math.floor(tileY.toDouble()).toInt()
        var tileMaxX = tileMinX + 1
        var tileMaxY = tileMinY + 1
        tileMinX = Ints.constrainToRange(tileMinX, 0, Constants.SCENE_SIZE - 1)
        tileMinY = Ints.constrainToRange(tileMinY, 0, Constants.SCENE_SIZE - 1)
        tileMaxX = Ints.constrainToRange(tileMaxX, 0, Constants.SCENE_SIZE - 1)
        tileMaxY = Ints.constrainToRange(tileMaxY, 0, Constants.SCENE_SIZE - 1)
        val heightNorth = lerp(
            client.tileHeights[plane][tileMinX][tileMaxY].toFloat(),
            client.tileHeights[plane][tileMaxX][tileMaxY].toFloat(),
            lerpX
        )
        val heightSouth = lerp(
            client.tileHeights[plane][tileMinX][tileMinY].toFloat(),
            client.tileHeights[plane][tileMaxX][tileMinY].toFloat(),
            lerpX
        )
        val tileHeight = lerp(heightSouth, heightNorth, lerpY)
        light.x = lightX
        light.y = lightY
        light.z = tileHeight.toInt() - light.height - 1
        light.`object` = tileObject
        sceneLights.add(light)
    }

    fun removeObjectLight(tileObject: TileObject) {
        val id = tileObject.id
        val objectLight = ObjectLight.find(id) ?: return
        val localLocation = tileObject.localLocation
        val plane = tileObject.worldLocation.plane
        sceneLights.removeIf { light: Light -> light.x == localLocation.x && light.y == localLocation.y && light.plane == plane }
    }

    fun tileObjectHash(tileObject: TileObject?): Int {
        return tileObject!!.worldLocation.x * tileObject.worldLocation.y * (tileObject.plane + 1) + tileObject.id
    }

    fun calculateScenePosition(light: Light) {
        light.x = (light.worldX - sceneMinX) * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_HALF_TILE_SIZE
        light.y = (light.worldY - sceneMinY) * Perspective.LOCAL_TILE_SIZE + Perspective.LOCAL_HALF_TILE_SIZE
        light.z = client.tileHeights[light.plane][light.worldX - sceneMinX][light.worldY - sceneMinY] - light.height - 1
        if (light.alignment == Alignment.NORTH || light.alignment == Alignment.NORTHEAST || light.alignment == Alignment.NORTHWEST) {
            light.y += Perspective.LOCAL_HALF_TILE_SIZE
        }
        if (light.alignment == Alignment.EAST || light.alignment == Alignment.NORTHEAST || light.alignment == Alignment.SOUTHEAST) {
            light.x += Perspective.LOCAL_HALF_TILE_SIZE
        }
        if (light.alignment == Alignment.SOUTH || light.alignment == Alignment.SOUTHEAST || light.alignment == Alignment.SOUTHWEST) {
            light.y -= Perspective.LOCAL_HALF_TILE_SIZE
        }
        if (light.alignment == Alignment.WEST || light.alignment == Alignment.NORTHWEST || light.alignment == Alignment.SOUTHWEST) {
            light.x -= Perspective.LOCAL_HALF_TILE_SIZE
        }
    }

    @Throws(IOException::class)
    fun loadLightsFromFile() {
        // create arraylist of lights from text file
        allLights = ArrayList()
        val filename = "lights.txt"
        var commentBlock = false
        val defaultColor = floatArrayOf(1.0f, 1.0f, 1.0f)
        val defaultRadius = 500
        val defaultStrength = 1.0f
        val defaultRange = 0.2f
        val defaultDuration = 1000
        val defaultHeight = 0
        val defaultPlane = 0
        val defaultType = LightType.STATIC
        var color = defaultColor
        var radius = defaultRadius
        var strength = defaultStrength
        var range = defaultRange
        var duration = defaultDuration
        var height = defaultHeight
        var plane = defaultPlane
        var type = defaultType
        val lineNo = 1
        try {
            BufferedReader(InputStreamReader(javaClass.getResourceAsStream(filename)!!)).use { br ->
                val m = PATTERN.matcher("")
                var line: String? = br.readLine()
                while (line != null) {
                    m.reset(line)
                    var end = 0
                    while (end < line.length) {
                        m.region(end, line.length)
                        require(m.find()) { "Unexpected: \"" + line!!.substring(end) + "\" (" + filename + ":" + lineNo + ")" }
                        end = m.end()
                        val expr = m.group("expr")
                        if (expr == null || expr.isEmpty() || expr.startsWith("//")) {
                            continue
                        }
                        if (expr.startsWith("/*")) {
                            commentBlock = true
                            continue
                        } else if (expr.startsWith("*/")) {
                            commentBlock = false
                            continue
                        }
                        if (commentBlock) {
                            continue
                        }
                        if (expr.lowercase(Locale.getDefault()).startsWith("reset")) {
                            color = defaultColor
                            radius = defaultRadius
                            range = defaultRange
                            duration = defaultDuration
                            strength = defaultStrength
                            height = defaultHeight
                            plane = defaultPlane
                            type = defaultType
                            continue
                        }
                        val cha = expr.lowercase(Locale.getDefault())[0]
                        when (cha) {
                            '#' -> {
                                val sColor = m.group("color")
                                val RGB = Color.decode("#$sColor")
                                val RGBTmp = FloatArray(3)
                                RGB.getRGBColorComponents(RGBTmp)
                                color = RGBTmp.clone()
                            }
                            'c' -> {
                                val r = m.group("r").toInt()
                                val g = m.group("g").toInt()
                                val b = m.group("b").toInt()
                                color = floatArrayOf(r / 255f, g / 255f, b / 255f)
                            }
                            's' -> strength = m.group("strength").toInt() / 100f
                            'r' -> {
                                if (expr.lowercase(Locale.getDefault()).startsWith("radius")) {
                                    radius = m.group("radius").toInt()
                                    break
                                } else if (expr.lowercase(Locale.getDefault()).startsWith("range")) {
                                    range = m.group("range").toInt().toFloat()
                                    break
                                }
                                duration = m.group("duration").toInt()
                            }
                            'd' -> duration = m.group("duration").toInt()
                            'p' -> plane = m.group("plane").toInt()
                            'h' -> height = m.group("h").toInt()
                            't' -> {
                                val typeStr = m.group("type").lowercase(Locale.getDefault()).trim { it <= ' ' }
                                type = when (typeStr) {
                                    "flicker" -> LightType.FLICKER
                                    "pulse" -> LightType.PULSE
                                    else -> LightType.STATIC
                                }
                            }
                            else -> {
                                val x = m.group("x").toInt()
                                val y = m.group("y").toInt()
                                var alignment = Alignment.CENTER
                                if (m.group("alignment") != null) {
                                    alignment =
                                        when (m.group("alignment").lowercase(Locale.getDefault()).trim { it <= ' ' }) {
                                            "n" -> Alignment.NORTH
                                            "ne" -> Alignment.NORTHEAST
                                            "e" -> Alignment.EAST
                                            "se" -> Alignment.SOUTHEAST
                                            "s" -> Alignment.SOUTH
                                            "sw" -> Alignment.SOUTHWEST
                                            "w" -> Alignment.WEST
                                            "nw" -> Alignment.NORTHWEST
                                            else -> Alignment.CENTER
                                        }
                                }
                                allLights.add(
                                    Light(
                                        x,
                                        y,
                                        plane,
                                        height,
                                        alignment,
                                        radius,
                                        strength,
                                        color,
                                        type,
                                        duration.toFloat(),
                                        range,
                                        0
                                    )
                                )
                            }
                        }
                    }
                    line = br.readLine()
                }
            }
        } catch (ex: NumberFormatException) {
            throw IllegalArgumentException("Expected number ($filename:$lineNo)", ex)
        }
    }

    fun addGroundItemLight(itemSpawned: ItemSpawned) {
        val lowValueColor = configManager.getConfiguration(
            "grounditems", "lowValueColor",
            Color::class.java
        )
        val mediumValueColor = configManager.getConfiguration(
            "grounditems", "mediumValueColor",
            Color::class.java
        )
        val highValueColor = configManager.getConfiguration(
            "grounditems", "highValueColor",
            Color::class.java
        )
        val insaneValueColor = configManager.getConfiguration(
            "grounditems", "insaneValueColor",
            Color::class.java
        )
        val lowValuePrice = configManager.getConfiguration("grounditems", "lowValuePrice", Int::class.java)
        val mediumValuePrice = configManager.getConfiguration("grounditems", "mediumValuePrice", Int::class.java)
        val highValuePrice = configManager.getConfiguration("grounditems", "highValuePrice", Int::class.java)
        val insaneValuePrice = configManager.getConfiguration("grounditems", "insaneValuePrice", Int::class.java)
        for (groundItem in GroundItemsPlugin.collectedGroundItems.values()) {
            if (groundItem == null)
                continue
            if (itemSpawned.item.id == groundItem.itemId) if (groundItem.location!!.distanceTo(itemSpawned.tile.worldLocation) == 0) {

                // prevent duplicate lights being spawned for the same GroundItem
                for (light in sceneLights) {
                    if (light.tileItem == null)
                        continue
                    if (light.tileItem!!.name == groundItem.name) {
                        return
                    }
                }
                val haPrice = groundItem.haPrice
                val gePrice = groundItem.gePrice
                val topValue = Math.max(haPrice, gePrice)
                var finalColor: Color? = null
                if (topValue > insaneValuePrice!!) finalColor =
                    insaneValueColor else if (topValue > highValuePrice!!) finalColor =
                    highValueColor else if (topValue > mediumValuePrice!!) finalColor =
                    mediumValueColor else if (topValue > lowValuePrice!!) finalColor = lowValueColor
                else if (PluginManager.get<GroundItemsPlugin>()!!.highlightedItemsList!!.contains(itemSpawned.item.name)) {
                    finalColor = Color(150, 0, 200)
                }

                if (finalColor == null) return
                val rgb = rgb(finalColor.red, finalColor.green, finalColor.blue)
                val r = rgb ushr 16
                val g = rgb shr 8 and 0xff
                val b = rgb and 0xff
                val localPoint = LocalPoint.fromWorld(client, groundItem.location)
                val light = Light(
                    localPoint!!.x,
                    localPoint.y,
                    groundItem.location!!.plane,
                    25,
                    Alignment.CENTER,
                    120,
                    7f,
                    floatArrayOf(r.toFloat(), g.toFloat(), b.toFloat()),
                    LightType.FLICKER,
                    0f,
                    0f,
                    0
                )
                light.tileItem = itemSpawned.item
                light.visible = false
                sceneLights.add(light)
            }
        }
    }

    fun removeGroundItemLight(itemDespawned: ItemDespawned) {
        sceneLights.removeIf { light: Light -> light.tileItem === itemDespawned.item }
    }

    companion object {
        private val PATTERN = Pattern.compile(
            "^[ \\t]*(?<expr>" +
                    "//.*$|" +  // //comment
                    "/\\*.*$|" +  // /* start comment block
                    "\\*/.*$|" +  //    end comment block */
                    "Reset|" +  // sets all variables to defaults
                    "(?<x>[0-9-]+)(,)[ \\t]*(?<y>[0-9-]+)((,)[ \\t]*(?<alignment>[A-Za-z]+))?|" +  // 3124, 2843
                    "#([ \\t]*(?<color>[0-9a-fA-F]{6}|[0-9a-fA-F]{3}))|" +  // #<RRGGBB> or #<RGB> (hex color)
                    "Color[ \\t]*(?<r>[0-9-]+)(,)[ \\t]*(?<g>[0-9-]+)(,)[ \\t]*(?<b>[0-9-]+)|" +  // C 255, 128, 0 (RGB color)
                    "Strength[ \\t]*(?<strength>[0-9-]+)|" +  // S 100 (strength)
                    "Radius[ \\t]*(?<radius>[0-9-]+)|" +  // R 500 (radius)
                    "Range[ \\t]*(?<range>[0-9-]+)|" +  // R 500 (radius)
                    "Duration[ \\t]*(?<duration>[0-9-]+)|" +  // R 500 (radius)
                    "Plane[ \\t]*(?<plane>[0-9-]+)|" +  // P 0 (plane)
                    "Height[ \\t]*(?<h>[0-9-]+)|" +  // H 128 (height)
                    "Type[ \\t]*(?<type>[a-z]+)|" +  // T flicker (type)
                    ")[ \\t]*"
        )

        private fun rgb(r: Int, g: Int, b: Int): Int {
            return r shl 16 or (g shl 8) or b
        }
    }
}