/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package rs117.hd

import com.google.common.base.Stopwatch
import com.google.common.primitives.Ints
import meteor.Refs
import com.jogamp.opengl.math.VectorUtil
import net.runelite.api.*
import rs117.hd.config.WaterEffects
import rs117.hd.materials.*

internal class SceneUploader(private val hdPlugin: GpuHDPlugin, var proceduralGenerator: ProceduralGenerator) {
    private val client = Refs.client
    var sceneId = (System.currentTimeMillis() / 1000L).toInt()
    private var offset = 0
    private var uvoffset = 0
    fun upload(scene: Scene, vertexBuffer: GpuIntBuffer, uvBuffer: GpuFloatBuffer, normalBuffer: GpuFloatBuffer) {
        val stopwatch = Stopwatch.createStarted()
        ++sceneId
        offset = 0
        uvoffset = 0
        vertexBuffer.clear()
        uvBuffer.clear()
        normalBuffer.clear()
        for (z in 0 until Constants.MAX_Z) {
            for (x in 0 until Constants.SCENE_SIZE) {
                for (y in 0 until Constants.SCENE_SIZE) {
                    val tile = scene.tiles[z][x][y]
                    tile?.let { upload(it, vertexBuffer, uvBuffer, normalBuffer) }
                }
            }
        }
        stopwatch.stop()
        //log.debug("Scene upload time: {}", stopwatch);
    }

    private fun uploadModel(
        model: Model,
        vertexBuffer: GpuIntBuffer,
        uvBuffer: GpuFloatBuffer,
        normalBuffer: GpuFloatBuffer,
        tileZ: Int,
        tileX: Int,
        tileY: Int,
        objectProperties: ObjectProperties?,
        objectType: ObjectType
    ) {
        if (model.sceneId == sceneId) {
            return  // model has already been uploaded
        }
        var skipObject: Byte = 0
        if (objectType == ObjectType.GROUND_OBJECT || objectType == ObjectType.DECORATIVE_OBJECT) {
            // mark it as low priority
            skipObject = 1
            if (client.baseX + tileX == 2558 && client.baseY + tileY >= 3249 && client.baseY + tileY <= 3252) {
                // fix for water by khazard spirit tree
                // marks object to never be drawn
                skipObject = 3
            }
        }
        // pack a bit into bufferoffset that we can use later to hide
        // some low-importance objects based on Level of Detail setting
        model.bufferOffset = offset shl 2 or skipObject.toInt()
        if (model.faceTextures != null || objectProperties != null && objectProperties.material != Material.NONE) {
            model.uvBufferOffset = uvoffset
        } else {
            model.uvBufferOffset = -1
        }
        model.sceneId = sceneId
        val faceCount = model.trianglesCount
        var vertexLength = 0
        var uvLength = 0
        for (face in 0 until faceCount) {
            val bufferLengths = pushFace(
                model,
                face,
                vertexBuffer,
                uvBuffer,
                normalBuffer,
                tileZ,
                tileX,
                tileY,
                objectProperties,
                objectType
            )
            vertexLength += bufferLengths[0]
            uvLength += bufferLengths[1]
        }
        offset += vertexLength
        uvoffset += uvLength
    }

    private fun upload(tile: Tile, vertexBuffer: GpuIntBuffer, uvBuffer: GpuFloatBuffer, normalBuffer: GpuFloatBuffer) {
        val bridge = tile.bridge
        bridge?.let { upload(it, vertexBuffer, uvBuffer, normalBuffer) }
        val tilePoint = tile.sceneLocation
        val tileX = tilePoint.x
        val tileY = tilePoint.y
        val tileZ = tile.renderLevel
        val sceneTilePaint = tile.sceneTilePaint
        if (sceneTilePaint != null) {
            val uploadedTilePaintData = upload(
                tile, sceneTilePaint,
                tileZ, tileX, tileY,
                vertexBuffer, uvBuffer, normalBuffer,
                0, 0
            )
            val bufferLength = uploadedTilePaintData[0]
            val uvBufferLength = uploadedTilePaintData[1]
            val underwaterTerrain = uploadedTilePaintData[2]
            // pack a boolean into the buffer length of tiles so we can tell
            // which tiles have procedurally generated underwater terrain.
            // shift the bufferLength to make space for the boolean:
            val packedBufferLength = bufferLength shl 1 or underwaterTerrain
            sceneTilePaint.bufferOffset = offset
            sceneTilePaint.uvBufferOffset = if (uvBufferLength > 0) uvoffset else -1
            sceneTilePaint.bufferLen = packedBufferLength
            offset += bufferLength
            uvoffset += uvBufferLength
        }
        val sceneTileModel = tile.sceneTileModel
        if (sceneTileModel != null) {
            val uploadedTileModelData = upload(
                tile, sceneTileModel,
                tileZ, tileX, tileY,
                vertexBuffer, uvBuffer, normalBuffer,
                0, 0
            )
            val bufferLength = uploadedTileModelData[0]
            val uvBufferLength = uploadedTileModelData[1]
            val underwaterTerrain = uploadedTileModelData[2]
            // pack a boolean into the buffer length of tiles so we can tell
            // which tiles have procedurally-generated underwater terrain
            val packedBufferLength = bufferLength shl 1 or underwaterTerrain
            sceneTileModel.bufferOffset = offset
            sceneTileModel.uvBufferOffset = if (uvBufferLength > 0) uvoffset else -1
            sceneTileModel.bufferLen = packedBufferLength
            offset += bufferLength
            uvoffset += uvBufferLength
        }
        var objectProperties: ObjectProperties?
        val wallObject = tile.wallObject
        if (wallObject != null) {
            objectProperties = ObjectProperties.getObjectProperties(tile.wallObject.id)
            val renderable1 = wallObject.renderable1
            if (renderable1 is Model) {
                uploadModel(
                    renderable1,
                    vertexBuffer,
                    uvBuffer,
                    normalBuffer,
                    tileZ,
                    tileX,
                    tileY,
                    objectProperties,
                    ObjectType.WALL_OBJECT
                )
            }
            val renderable2 = wallObject.renderable2
            if (renderable2 is Model) {
                uploadModel(
                    renderable2,
                    vertexBuffer,
                    uvBuffer,
                    normalBuffer,
                    tileZ,
                    tileX,
                    tileY,
                    objectProperties,
                    ObjectType.WALL_OBJECT
                )
            }
        }
        val groundObject = tile.groundObject
        if (groundObject != null) {
            objectProperties = ObjectProperties.getObjectProperties(tile.groundObject.id)
            val renderable = groundObject.renderable
            if (renderable is Model) {
                uploadModel(
                    renderable,
                    vertexBuffer,
                    uvBuffer,
                    normalBuffer,
                    tileZ,
                    tileX,
                    tileY,
                    objectProperties,
                    ObjectType.GROUND_OBJECT
                )
            }
        }
        val decorativeObject = tile.decorativeObject
        if (decorativeObject != null) {
            objectProperties = ObjectProperties.getObjectProperties(tile.decorativeObject.id)
            val renderable = decorativeObject.renderable
            if (renderable is Model) {
                uploadModel(
                    renderable,
                    vertexBuffer,
                    uvBuffer,
                    normalBuffer,
                    tileZ,
                    tileX,
                    tileY,
                    objectProperties,
                    ObjectType.DECORATIVE_OBJECT
                )
            }
            val renderable2 = decorativeObject.renderable2
            if (renderable2 is Model) {
                uploadModel(
                    renderable2,
                    vertexBuffer,
                    uvBuffer,
                    normalBuffer,
                    tileZ,
                    tileX,
                    tileY,
                    objectProperties,
                    ObjectType.DECORATIVE_OBJECT
                )
            }
        }
        val gameObjects = tile.gameObjects
        for (gameObject in gameObjects) {
            if (gameObject == null) {
                continue
            }
            objectProperties = ObjectProperties.getObjectProperties(gameObject.id)
            val renderable = gameObject.renderable
            if (renderable is Model) {
                val model = gameObject.renderable as Model
                uploadModel(
                    model,
                    vertexBuffer,
                    uvBuffer,
                    normalBuffer,
                    tileZ,
                    tileX,
                    tileY,
                    objectProperties,
                    ObjectType.GAME_OBJECT
                )
            }
        }
    }

    fun upload(
        tile: Tile?,
        sceneTilePaint: SceneTilePaint,
        tileZ: Int,
        tileX: Int,
        tileY: Int,
        vertexBuffer: GpuIntBuffer,
        uvBuffer: GpuFloatBuffer,
        normalBuffer: GpuFloatBuffer,
        offsetX: Int,
        offsetY: Int
    ): IntArray {
        var bufferLength = 0
        var uvBufferLength = 0
        var underwaterTerrain = 0
        var bufferLengths: IntArray
        bufferLengths = uploadHDTilePaintSurface(
            tile,
            sceneTilePaint,
            tileZ,
            tileX,
            tileY,
            vertexBuffer,
            uvBuffer,
            normalBuffer,
            0,
            0
        )
        bufferLength += bufferLengths[0]
        uvBufferLength += bufferLengths[1]
        underwaterTerrain += bufferLengths[2]
        bufferLengths = uploadHDTilePaintUnderwater(
            tile,
            sceneTilePaint,
            tileZ,
            tileX,
            tileY,
            vertexBuffer,
            uvBuffer,
            normalBuffer,
            0,
            0
        )
        bufferLength += bufferLengths[0]
        uvBufferLength += bufferLengths[1]
        underwaterTerrain += bufferLengths[2]
        return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
    }

    fun uploadHDTilePaintSurface(
        tile: Tile?,
        sceneTilePaint: SceneTilePaint,
        tileZ: Int,
        tileX: Int,
        tileY: Int,
        vertexBuffer: GpuIntBuffer,
        uvBuffer: GpuFloatBuffer,
        normalBuffer: GpuFloatBuffer,
        offsetX: Int,
        offsetY: Int
    ): IntArray {
        var ignoreTile = false
        if (sceneTilePaint.neColor == 12345678) {
            // ignore certain tiles that aren't supposed to be visible but
            // we can still make a height-adjusted version of it for underwater
            ignoreTile = true
        }
        val baseX = client.baseX
        val baseY = client.baseY
        val tileHeights = client.tileHeights
        val swHeight = tileHeights[tileZ][tileX][tileY]
        val seHeight = tileHeights[tileZ][tileX + 1][tileY]
        val neHeight = tileHeights[tileZ][tileX + 1][tileY + 1]
        val nwHeight = tileHeights[tileZ][tileX][tileY + 1]
        var bufferLength = 0
        var uvBufferLength = 0
        val underwaterTerrain = 0
        val localSeVertexX = offsetX + Perspective.LOCAL_TILE_SIZE
        val localNwVertexY = offsetY + Perspective.LOCAL_TILE_SIZE
        val localNeVertexX = offsetX + Perspective.LOCAL_TILE_SIZE
        val localNeVertexY = offsetY + Perspective.LOCAL_TILE_SIZE
        val vertexKeys = proceduralGenerator.tileVertexKeys(tile)
        val swVertexKey = vertexKeys[0]
        val seVertexKey = vertexKeys[1]
        val nwVertexKey = vertexKeys[2]
        val neVertexKey = vertexKeys[3]
        if (!ignoreTile) {
            var swColor = sceneTilePaint.swColor
            var seColor = sceneTilePaint.seColor
            var neColor = sceneTilePaint.neColor
            var nwColor = sceneTilePaint.nwColor
            val tileTexture = sceneTilePaint.texture
            var neVertexIsOverlay = false
            var nwVertexIsOverlay = false
            var seVertexIsOverlay = false
            var swVertexIsOverlay = false
            var swMaterial = Material.getTexture(tileTexture)
            var seMaterial = Material.getTexture(tileTexture)
            var neMaterial = Material.getTexture(tileTexture)
            var nwMaterial = Material.getTexture(tileTexture)
            val waterType = proceduralGenerator.tileWaterType(tile, sceneTilePaint)
            if (waterType !== WaterType.NONE) {
                if (nwMaterial != null) {
                    nwMaterial = waterType.groundMaterial!!.materials[0]
                }
                neMaterial = nwMaterial
                seMaterial = neMaterial
                swMaterial = seMaterial

                // set colors for the shoreline to create a foam effect in the water shader
                neColor = 127
                nwColor = neColor
                seColor = nwColor
                swColor = seColor
                if (proceduralGenerator.vertexIsWater.containsKey(swVertexKey) && proceduralGenerator.vertexIsLand.containsKey(
                        swVertexKey
                    )
                ) {
                    swColor = 0
                }
                if (proceduralGenerator.vertexIsWater.containsKey(seVertexKey) && proceduralGenerator.vertexIsLand.containsKey(
                        seVertexKey
                    )
                ) {
                    seColor = 0
                }
                if (proceduralGenerator.vertexIsWater.containsKey(nwVertexKey) && proceduralGenerator.vertexIsLand.containsKey(
                        nwVertexKey
                    )
                ) {
                    nwColor = 0
                }
                if (proceduralGenerator.vertexIsWater.containsKey(neVertexKey) && proceduralGenerator.vertexIsLand.containsKey(
                        neVertexKey
                    )
                ) {
                    neColor = 0
                }
            } else if (!proceduralGenerator.useDefaultColor(tile) && sceneTilePaint.texture == -1) {
                // get the vertices' colors and textures from hashmaps
                swColor = proceduralGenerator.vertexTerrainColor.getOrDefault(swVertexKey, swColor)
                seColor = proceduralGenerator.vertexTerrainColor.getOrDefault(seVertexKey, seColor)
                neColor = proceduralGenerator.vertexTerrainColor.getOrDefault(neVertexKey, neColor)
                nwColor = proceduralGenerator.vertexTerrainColor.getOrDefault(nwVertexKey, nwColor)
                if (hdPlugin.configGroundTextures) {
                    swMaterial = proceduralGenerator.vertexTerrainTexture.getOrDefault(swVertexKey, swMaterial)
                    seMaterial = proceduralGenerator.vertexTerrainTexture.getOrDefault(seVertexKey, seMaterial)
                    neMaterial = proceduralGenerator.vertexTerrainTexture.getOrDefault(neVertexKey, neMaterial)
                    nwMaterial = proceduralGenerator.vertexTerrainTexture.getOrDefault(nwVertexKey, nwMaterial)
                }
            } else {
                val groundMaterial: GroundMaterial
                if (client.scene.overlayIds[tileZ][tileX][tileY].toInt() != 0) {
                    val overlay = Overlay.getOverlay(
                        client.scene.overlayIds[tileZ][tileX][tileY].toInt(), tile!!, client
                    )
                    groundMaterial = overlay.groundMaterial
                    swColor = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorOverlay(
                            overlay,
                            HDUtils.colorIntToHSL(swColor)
                        )
                    )
                    seColor = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorOverlay(
                            overlay,
                            HDUtils.colorIntToHSL(seColor)
                        )
                    )
                    nwColor = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorOverlay(
                            overlay,
                            HDUtils.colorIntToHSL(nwColor)
                        )
                    )
                    neColor = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorOverlay(
                            overlay,
                            HDUtils.colorIntToHSL(neColor)
                        )
                    )
                } else {
                    val underlay = Underlay.getUnderlay(
                        client.scene.underlayIds[tileZ][tileX][tileY].toInt(),
                        tile!!,
                        client
                    )
                    groundMaterial = underlay.groundMaterial
                    swColor = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorUnderlay(
                            underlay,
                            HDUtils.colorIntToHSL(swColor)
                        )
                    )
                    seColor = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorUnderlay(
                            underlay,
                            HDUtils.colorIntToHSL(seColor)
                        )
                    )
                    nwColor = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorUnderlay(
                            underlay,
                            HDUtils.colorIntToHSL(nwColor)
                        )
                    )
                    neColor = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorUnderlay(
                            underlay,
                            HDUtils.colorIntToHSL(neColor)
                        )
                    )
                }
                if (hdPlugin.configGroundTextures) {
                    swMaterial = groundMaterial.getRandomMaterial(tileZ, baseX + tileX, baseY + tileY)
                    seMaterial = groundMaterial.getRandomMaterial(tileZ, baseX + tileX + 1, baseY + tileY)
                    nwMaterial = groundMaterial.getRandomMaterial(tileZ, baseX + tileX, baseY + tileY + 1)
                    neMaterial = groundMaterial.getRandomMaterial(tileZ, baseX + tileX + 1, baseY + tileY + 1)
                }
            }
            if (proceduralGenerator.vertexIsOverlay.containsKey(neVertexKey) && proceduralGenerator.vertexIsUnderlay.containsKey(
                    neVertexKey
                )
            ) {
                neVertexIsOverlay = true
            }
            if (proceduralGenerator.vertexIsOverlay.containsKey(nwVertexKey) && proceduralGenerator.vertexIsUnderlay.containsKey(
                    nwVertexKey
                )
            ) {
                nwVertexIsOverlay = true
            }
            if (proceduralGenerator.vertexIsOverlay.containsKey(seVertexKey) && proceduralGenerator.vertexIsUnderlay.containsKey(
                    seVertexKey
                )
            ) {
                seVertexIsOverlay = true
            }
            if (proceduralGenerator.vertexIsOverlay.containsKey(swVertexKey) && proceduralGenerator.vertexIsUnderlay.containsKey(
                    swVertexKey
                )
            ) {
                swVertexIsOverlay = true
            }
            var swNormals = floatArrayOf(0f, -1f, 0f)
            var seNormals = floatArrayOf(0f, -1f, 0f)
            var neNormals = floatArrayOf(0f, -1f, 0f)
            var nwNormals = floatArrayOf(0f, -1f, 0f)

            // retrieve normals from hashmap
            if (waterType === WaterType.NONE) {
                swNormals = proceduralGenerator.vertexTerrainNormals.getOrDefault(swVertexKey, swNormals)
                seNormals = proceduralGenerator.vertexTerrainNormals.getOrDefault(seVertexKey, seNormals)
                neNormals = proceduralGenerator.vertexTerrainNormals.getOrDefault(neVertexKey, neNormals)
                nwNormals = proceduralGenerator.vertexTerrainNormals.getOrDefault(nwVertexKey, nwNormals)
            }
            normalBuffer.ensureCapacity(24)
            normalBuffer.put(neNormals[0], neNormals[2], neNormals[1], 0f)
            normalBuffer.put(nwNormals[0], nwNormals[2], nwNormals[1], 0f)
            normalBuffer.put(seNormals[0], seNormals[2], seNormals[1], 0f)
            normalBuffer.put(swNormals[0], swNormals[2], swNormals[1], 0f)
            normalBuffer.put(seNormals[0], seNormals[2], seNormals[1], 0f)
            normalBuffer.put(nwNormals[0], nwNormals[2], nwNormals[1], 0f)
            vertexBuffer.ensureCapacity(24)
            vertexBuffer.put(localNeVertexX, neHeight, localNeVertexY, neColor)
            vertexBuffer.put(offsetX, nwHeight, localNwVertexY, nwColor)
            vertexBuffer.put(localSeVertexX, seHeight, offsetY, seColor)
            vertexBuffer.put(offsetX, swHeight, offsetY, swColor)
            vertexBuffer.put(localSeVertexX, seHeight, offsetY, seColor)
            vertexBuffer.put(offsetX, nwHeight, localNwVertexY, nwColor)
            bufferLength += 6
            val packedTextureDataSW =
                packTextureData(Material.getIndex(swMaterial), swVertexIsOverlay)
            val packedTextureDataSE =
                packTextureData(Material.getIndex(seMaterial), seVertexIsOverlay)
            val packedTextureDataNW =
                packTextureData(Material.getIndex(nwMaterial), nwVertexIsOverlay)
            val packedTextureDataNE =
                packTextureData(Material.getIndex(neMaterial), neVertexIsOverlay)
            uvBuffer.ensureCapacity(24)
            uvBuffer.put(packedTextureDataNE.toFloat(), 1.0f, 1.0f, 0f)
            uvBuffer.put(packedTextureDataNW.toFloat(), 0.0f, 1.0f, 0f)
            uvBuffer.put(packedTextureDataSE.toFloat(), 1.0f, 0.0f, 0f)
            uvBuffer.put(packedTextureDataSW.toFloat(), 0.0f, 0.0f, 0f)
            uvBuffer.put(packedTextureDataSE.toFloat(), 1.0f, 0.0f, 0f)
            uvBuffer.put(packedTextureDataNW.toFloat(), 0.0f, 1.0f, 0f)
            uvBufferLength += 6
        }
        return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
    }

    fun uploadHDTilePaintUnderwater(
        tile: Tile?,
        sceneTilePaint: SceneTilePaint?,
        tileZ: Int,
        tileX: Int,
        tileY: Int,
        vertexBuffer: GpuIntBuffer,
        uvBuffer: GpuFloatBuffer,
        normalBuffer: GpuFloatBuffer,
        offsetX: Int,
        offsetY: Int
    ): IntArray {
        val baseX = client.baseX
        val baseY = client.baseY
        if (baseX + offsetX >= 2816 && baseX + offsetX <= 2970 && baseY + offsetY <= 5375 && baseY + offsetY >= 5220) {
            // fix for God Wars Dungeon's water rendering over zamorak bridge
            return intArrayOf(0, 0, 0)
        }
        val tileHeights = client.tileHeights
        val swHeight = tileHeights[tileZ][tileX][tileY]
        val seHeight = tileHeights[tileZ][tileX + 1][tileY]
        val neHeight = tileHeights[tileZ][tileX + 1][tileY + 1]
        val nwHeight = tileHeights[tileZ][tileX][tileY + 1]
        var bufferLength = 0
        var uvBufferLength = 0
        var underwaterTerrain = 0
        val localSeVertexX = offsetX + Perspective.LOCAL_TILE_SIZE
        val localNwVertexY = offsetY + Perspective.LOCAL_TILE_SIZE
        val localNeVertexX = offsetX + Perspective.LOCAL_TILE_SIZE
        val localNeVertexY = offsetY + Perspective.LOCAL_TILE_SIZE
        val vertexKeys = proceduralGenerator.tileVertexKeys(tile)
        val swVertexKey = vertexKeys[0]
        val seVertexKey = vertexKeys[1]
        val nwVertexKey = vertexKeys[2]
        val neVertexKey = vertexKeys[3]
        if (hdPlugin.configWaterEffects == WaterEffects.ALL && proceduralGenerator.tileIsWater[tileZ][tileX][tileY]) {
            // underwater terrain
            underwaterTerrain = 1
            val swColor = 6676
            val seColor = 6676
            val neColor = 6676
            val nwColor = 6676
            val swDepth = proceduralGenerator.vertexUnderwaterDepth.getOrDefault(swVertexKey, 0)
            val seDepth = proceduralGenerator.vertexUnderwaterDepth.getOrDefault(seVertexKey, 0)
            val nwDepth = proceduralGenerator.vertexUnderwaterDepth.getOrDefault(nwVertexKey, 0)
            val neDepth = proceduralGenerator.vertexUnderwaterDepth.getOrDefault(neVertexKey, 0)
            val swNormals =
                proceduralGenerator.vertexTerrainNormals.getOrDefault(swVertexKey, floatArrayOf(0f, -1f, 0f))
            val seNormals =
                proceduralGenerator.vertexTerrainNormals.getOrDefault(seVertexKey, floatArrayOf(0f, -1f, 0f))
            val nwNormals =
                proceduralGenerator.vertexTerrainNormals.getOrDefault(nwVertexKey, floatArrayOf(0f, -1f, 0f))
            val neNormals =
                proceduralGenerator.vertexTerrainNormals.getOrDefault(neVertexKey, floatArrayOf(0f, -1f, 0f))
            var swMaterial = Material.NONE
            var seMaterial = Material.NONE
            var nwMaterial = Material.NONE
            var neMaterial = Material.NONE
            if (hdPlugin.configGroundTextures) {
                val groundMaterial = GroundMaterial.UNDERWATER_GENERIC
                swMaterial = groundMaterial.getRandomMaterial(tileZ, baseX + tileX, baseY + tileY)
                seMaterial = groundMaterial.getRandomMaterial(tileZ, baseX + tileX + 1, baseY + tileY)
                nwMaterial = groundMaterial.getRandomMaterial(tileZ, baseX + tileX, baseY + tileY + 1)
                neMaterial = groundMaterial.getRandomMaterial(tileZ, baseX + tileX + 1, baseY + tileY + 1)
            }
            val waterType = proceduralGenerator.tileWaterType(tile, sceneTilePaint)
            val swWaterData = swDepth shl 5 or waterType.value
            val seWaterData = seDepth shl 5 or waterType.value
            val nwWaterData = nwDepth shl 5 or waterType.value
            val neWaterData = neDepth shl 5 or waterType.value
            normalBuffer.ensureCapacity(24)
            normalBuffer.put(neNormals[0], neNormals[2], neNormals[1], neWaterData.toFloat())
            normalBuffer.put(nwNormals[0], nwNormals[2], nwNormals[1], nwWaterData.toFloat())
            normalBuffer.put(seNormals[0], seNormals[2], seNormals[1], seWaterData.toFloat())
            normalBuffer.put(swNormals[0], swNormals[2], swNormals[1], swWaterData.toFloat())
            normalBuffer.put(seNormals[0], seNormals[2], seNormals[1], seWaterData.toFloat())
            normalBuffer.put(nwNormals[0], nwNormals[2], nwNormals[1], nwWaterData.toFloat())
            vertexBuffer.ensureCapacity(24)
            vertexBuffer.put(localNeVertexX, neHeight + neDepth, localNeVertexY, neColor)
            vertexBuffer.put(offsetX, nwHeight + nwDepth, localNwVertexY, nwColor)
            vertexBuffer.put(localSeVertexX, seHeight + seDepth, offsetY, seColor)
            vertexBuffer.put(offsetX, swHeight + swDepth, offsetY, swColor)
            vertexBuffer.put(localSeVertexX, seHeight + seDepth, offsetY, seColor)
            vertexBuffer.put(offsetX, nwHeight + nwDepth, localNwVertexY, nwColor)
            bufferLength += 6
            val packedTextureDataSW = packTextureData(Material.getIndex(swMaterial), false)
            val packedTextureDataSE = packTextureData(Material.getIndex(seMaterial), false)
            val packedTextureDataNW = packTextureData(Material.getIndex(nwMaterial), false)
            val packedTextureDataNE = packTextureData(Material.getIndex(neMaterial), false)
            uvBuffer.ensureCapacity(24)
            uvBuffer.put(packedTextureDataNE.toFloat(), 1.0f, 1.0f, 0f)
            uvBuffer.put(packedTextureDataNW.toFloat(), 0.0f, 1.0f, 0f)
            uvBuffer.put(packedTextureDataSE.toFloat(), 1.0f, 0.0f, 0f)
            uvBuffer.put(packedTextureDataSW.toFloat(), 0.0f, 0.0f, 0f)
            uvBuffer.put(packedTextureDataSE.toFloat(), 1.0f, 0.0f, 0f)
            uvBuffer.put(packedTextureDataNW.toFloat(), 0.0f, 1.0f, 0f)
            uvBufferLength += 6
        }
        return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
    }

    fun upload(
        tile: Tile,
        sceneTileModel: SceneTileModel,
        tileZ: Int,
        tileX: Int,
        tileY: Int,
        vertexBuffer: GpuIntBuffer,
        uvBuffer: GpuFloatBuffer,
        normalBuffer: GpuFloatBuffer,
        offsetX: Int,
        offsetY: Int
    ): IntArray {
        var bufferLength = 0
        var uvBufferLength = 0
        var underwaterTerrain = 0
        var bufferLengths: IntArray
        bufferLengths = uploadHDTileModelSurface(
            tile,
            sceneTileModel,
            tileZ,
            tileX,
            tileY,
            vertexBuffer,
            uvBuffer,
            normalBuffer,
            offsetX,
            offsetY
        )
        bufferLength += bufferLengths[0]
        uvBufferLength += bufferLengths[1]
        underwaterTerrain += bufferLengths[2]
        bufferLengths = uploadHDTileModelUnderwater(
            tile,
            sceneTileModel,
            tileZ,
            tileX,
            tileY,
            vertexBuffer,
            uvBuffer,
            normalBuffer,
            offsetX,
            offsetY
        )
        bufferLength += bufferLengths[0]
        uvBufferLength += bufferLengths[1]
        underwaterTerrain += bufferLengths[2]
        return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
    }

    fun uploadHDTileModelSurface(
        tile: Tile,
        sceneTileModel: SceneTileModel,
        tileZ: Int,
        tileX: Int,
        tileY: Int,
        vertexBuffer: GpuIntBuffer,
        uvBuffer: GpuFloatBuffer,
        normalBuffer: GpuFloatBuffer,
        offsetX: Int,
        offsetY: Int
    ): IntArray {
        var bufferLength = 0
        var uvBufferLength = 0
        val underwaterTerrain = 0
        if (proceduralGenerator.skipTile[tileZ][tileX][tileY]) {
            return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
        }
        val faceColorA = sceneTileModel.triangleColorA
        val faceColorB = sceneTileModel.triangleColorB
        val faceColorC = sceneTileModel.triangleColorC
        val faceTextures = sceneTileModel.triangleTextureId
        val faceCount = sceneTileModel.faceX.size
        val baseX = client.baseX
        val baseY = client.baseY
        for (face in 0 until faceCount) {
            var colorA = faceColorA[face]
            var colorB = faceColorB[face]
            var colorC = faceColorC[face]
            if (colorA == 12345678) {
                continue
            }
            val localVertices = proceduralGenerator.faceLocalVertices(tile, face)
            val vertexKeys = proceduralGenerator.faceVertexKeys(tile, face)
            val vertexKeyA = vertexKeys[0]
            val vertexKeyB = vertexKeys[1]
            val vertexKeyC = vertexKeys[2]
            var vertexAIsOverlay = false
            var vertexBIsOverlay = false
            var vertexCIsOverlay = false
            var materialA = Material.NONE
            var materialB = Material.NONE
            var materialC = Material.NONE
            if (faceTextures != null) {
                materialA = Material.getTexture(faceTextures[face])
                materialB = Material.getTexture(faceTextures[face])
                materialC = Material.getTexture(faceTextures[face])
            }
            val waterType = proceduralGenerator.faceWaterType(tile, face, sceneTileModel)
            if (waterType !== WaterType.NONE) {
                // apply WaterType-specific texture to use as an identifier in the water shader
                materialC = waterType.groundMaterial!!.materials[0]
                materialB = materialC
                materialA = materialB

                // set colors for the shoreline to create a foam effect in the water shader
                colorC = 127
                colorB = colorC
                colorA = colorB
                if (proceduralGenerator.vertexIsWater.containsKey(vertexKeyA) && proceduralGenerator.vertexIsLand.containsKey(
                        vertexKeyA
                    )
                ) {
                    colorA = 0
                }
                if (proceduralGenerator.vertexIsWater.containsKey(vertexKeyB) && proceduralGenerator.vertexIsLand.containsKey(
                        vertexKeyB
                    )
                ) {
                    colorB = 0
                }
                if (proceduralGenerator.vertexIsWater.containsKey(vertexKeyC) && proceduralGenerator.vertexIsLand.containsKey(
                        vertexKeyC
                    )
                ) {
                    colorC = 0
                }
            } else if (!(proceduralGenerator.isOverlayFace(
                    tile,
                    face
                ) && proceduralGenerator.useDefaultColor(tile)) && materialA == Material.NONE
            ) {
                // get the vertices' colors and textures from hashmaps
                colorA = proceduralGenerator.vertexTerrainColor.getOrDefault(vertexKeyA, colorA)
                colorB = proceduralGenerator.vertexTerrainColor.getOrDefault(vertexKeyB, colorB)
                colorC = proceduralGenerator.vertexTerrainColor.getOrDefault(vertexKeyC, colorC)
                if (hdPlugin.configGroundTextures) {
                    materialA = proceduralGenerator.vertexTerrainTexture.getOrDefault(vertexKeyA, materialA)
                    materialB = proceduralGenerator.vertexTerrainTexture.getOrDefault(vertexKeyB, materialB)
                    materialC = proceduralGenerator.vertexTerrainTexture.getOrDefault(vertexKeyC, materialC)
                }
            } else {
                // ground textures without blending
                var groundMaterial: GroundMaterial
                if (proceduralGenerator.isOverlayFace(tile, face)) {
                    val overlay = Overlay.getOverlay(
                        client.scene.overlayIds[tileZ][tileX][tileY].toInt(), tile, client
                    )
                    groundMaterial = overlay.groundMaterial
                    colorA = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorOverlay(
                            overlay,
                            HDUtils.colorIntToHSL(colorA)
                        )
                    )
                    colorB = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorOverlay(
                            overlay,
                            HDUtils.colorIntToHSL(colorB)
                        )
                    )
                    colorC = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorOverlay(
                            overlay,
                            HDUtils.colorIntToHSL(colorC)
                        )
                    )
                } else {
                    val underlay = Underlay.getUnderlay(
                        client.scene.underlayIds[tileZ][tileX][tileY].toInt(), tile, client
                    )
                    groundMaterial = underlay.groundMaterial
                    colorA = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorUnderlay(
                            underlay,
                            HDUtils.colorIntToHSL(colorA)
                        )
                    )
                    colorB = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorUnderlay(
                            underlay,
                            HDUtils.colorIntToHSL(colorB)
                        )
                    )
                    colorC = HDUtils.colorHSLToInt(
                        proceduralGenerator.recolorUnderlay(
                            underlay,
                            HDUtils.colorIntToHSL(colorC)
                        )
                    )
                }
                if (hdPlugin.configGroundTextures) {
                    materialA = groundMaterial.getRandomMaterial(
                        tileZ, baseX + tileX + Math.floor(
                            (localVertices[0][0]
                                .toFloat() / Perspective.LOCAL_TILE_SIZE).toDouble()
                        ).toInt(), baseY + tileY + Math.floor(
                            (localVertices[0][1]
                                .toFloat() / Perspective.LOCAL_TILE_SIZE).toDouble()
                        ).toInt()
                    )
                    materialB = groundMaterial.getRandomMaterial(
                        tileZ, baseX + tileX + Math.floor(
                            (localVertices[1][0]
                                .toFloat() / Perspective.LOCAL_TILE_SIZE).toDouble()
                        ).toInt(), baseY + tileY + Math.floor(
                            (localVertices[1][1]
                                .toFloat() / Perspective.LOCAL_TILE_SIZE).toDouble()
                        ).toInt()
                    )
                    materialC = groundMaterial.getRandomMaterial(
                        tileZ, baseX + tileX + Math.floor(
                            (localVertices[2][0]
                                .toFloat() / Perspective.LOCAL_TILE_SIZE).toDouble()
                        ).toInt(), baseY + tileY + Math.floor(
                            (localVertices[2][1]
                                .toFloat() / Perspective.LOCAL_TILE_SIZE).toDouble()
                        ).toInt()
                    )
                }
            }
            if (proceduralGenerator.vertexIsOverlay.containsKey(vertexKeyA) && proceduralGenerator.vertexIsUnderlay.containsKey(
                    vertexKeyA
                )
            ) {
                vertexAIsOverlay = true
            }
            if (proceduralGenerator.vertexIsOverlay.containsKey(vertexKeyB) && proceduralGenerator.vertexIsUnderlay.containsKey(
                    vertexKeyB
                )
            ) {
                vertexBIsOverlay = true
            }
            if (proceduralGenerator.vertexIsOverlay.containsKey(vertexKeyC) && proceduralGenerator.vertexIsUnderlay.containsKey(
                    vertexKeyC
                )
            ) {
                vertexCIsOverlay = true
            }
            var normalsA = floatArrayOf(0f, -1f, 0f)
            var normalsB = floatArrayOf(0f, -1f, 0f)
            var normalsC = floatArrayOf(0f, -1f, 0f)

            // retrieve normals from hashmap
            if (waterType === WaterType.NONE) {
                normalsA = proceduralGenerator.vertexTerrainNormals.getOrDefault(vertexKeyA, normalsA)
                normalsB = proceduralGenerator.vertexTerrainNormals.getOrDefault(vertexKeyB, normalsB)
                normalsC = proceduralGenerator.vertexTerrainNormals.getOrDefault(vertexKeyC, normalsC)
            }
            normalBuffer.ensureCapacity(12)
            normalBuffer.put(normalsA[0], normalsA[2], normalsA[1], 0f)
            normalBuffer.put(normalsB[0], normalsB[2], normalsB[1], 0f)
            normalBuffer.put(normalsC[0], normalsC[2], normalsC[1], 0f)
            vertexBuffer.ensureCapacity(12)
            vertexBuffer.put(localVertices[0][0] + offsetX, localVertices[0][2], localVertices[0][1] + offsetY, colorA)
            vertexBuffer.put(localVertices[1][0] + offsetX, localVertices[1][2], localVertices[1][1] + offsetY, colorB)
            vertexBuffer.put(localVertices[2][0] + offsetX, localVertices[2][2], localVertices[2][1] + offsetY, colorC)
            bufferLength += 3
            val packedTextureDataA = packTextureData(Material.getIndex(materialA), vertexAIsOverlay)
            val packedTextureDataB = packTextureData(Material.getIndex(materialB), vertexBIsOverlay)
            val packedTextureDataC = packTextureData(Material.getIndex(materialC), vertexCIsOverlay)
            uvBuffer.ensureCapacity(12)
            uvBuffer.put(packedTextureDataA.toFloat(), localVertices[0][0] / 128f, localVertices[0][1] / 128f, 0f)
            uvBuffer.put(packedTextureDataB.toFloat(), localVertices[1][0] / 128f, localVertices[1][1] / 128f, 0f)
            uvBuffer.put(packedTextureDataC.toFloat(), localVertices[2][0] / 128f, localVertices[2][1] / 128f, 0f)
            uvBufferLength += 3
        }
        return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
    }

    fun uploadHDTileModelUnderwater(
        tile: Tile,
        sceneTileModel: SceneTileModel,
        tileZ: Int,
        tileX: Int,
        tileY: Int,
        vertexBuffer: GpuIntBuffer,
        uvBuffer: GpuFloatBuffer,
        normalBuffer: GpuFloatBuffer,
        offsetX: Int,
        offsetY: Int
    ): IntArray {
        var bufferLength = 0
        var uvBufferLength = 0
        var underwaterTerrain = 0
        if (proceduralGenerator.skipTile[tileZ][tileX][tileY]) {
            return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
        }
        val faceColorA = sceneTileModel.triangleColorA
        val faceColorB = sceneTileModel.triangleColorB
        val faceColorC = sceneTileModel.triangleColorC
        val faceCount = sceneTileModel.faceX.size
        val baseX = client.baseX
        val baseY = client.baseY
        if (baseX + offsetX >= 2816 && baseX + offsetX <= 2970 && baseY + offsetY <= 5375 && baseY + offsetY >= 5220) {
            // fix for God Wars Dungeon's water rendering over zamorak bridge
            return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
        }
        if (hdPlugin.configWaterEffects == WaterEffects.ALL && proceduralGenerator.tileIsWater[tileZ][tileX][tileY]) {
            underwaterTerrain = 1

            // underwater terrain
            for (face in 0 until faceCount) {
                val colorA = 6676
                val colorB = 6676
                val colorC = 6676
                if (faceColorA[face] == 12345678) {
                    continue
                }
                val localVertices = proceduralGenerator.faceLocalVertices(tile, face)
                var materialA = Material.NONE
                var materialB = Material.NONE
                var materialC = Material.NONE
                val vertexKeys = proceduralGenerator.faceVertexKeys(tile, face)
                val vertexKeyA = vertexKeys[0]
                val vertexKeyB = vertexKeys[1]
                val vertexKeyC = vertexKeys[2]
                val depthA = proceduralGenerator.vertexUnderwaterDepth.getOrDefault(vertexKeyA, 0)
                val depthB = proceduralGenerator.vertexUnderwaterDepth.getOrDefault(vertexKeyB, 0)
                val depthC = proceduralGenerator.vertexUnderwaterDepth.getOrDefault(vertexKeyC, 0)
                if (hdPlugin.configGroundTextures) {
                    val groundMaterial = GroundMaterial.UNDERWATER_GENERIC
                    var tileVertexX =
                        Math.round(localVertices[0][0].toFloat() / Perspective.LOCAL_TILE_SIZE.toFloat()) + tileX + baseX
                    var tileVertexY =
                        Math.round(localVertices[0][1].toFloat() / Perspective.LOCAL_TILE_SIZE.toFloat()) + tileY + baseY
                    materialA = groundMaterial.getRandomMaterial(tileZ, tileVertexX, tileVertexY)
                    tileVertexX =
                        Math.round(localVertices[1][0].toFloat() / Perspective.LOCAL_TILE_SIZE.toFloat()) + tileX + baseX
                    tileVertexY =
                        Math.round(localVertices[1][1].toFloat() / Perspective.LOCAL_TILE_SIZE.toFloat()) + tileY + baseY
                    materialB = groundMaterial.getRandomMaterial(tileZ, tileVertexX, tileVertexY)
                    tileVertexX =
                        Math.round(localVertices[2][0].toFloat() / Perspective.LOCAL_TILE_SIZE.toFloat()) + tileX + baseX
                    tileVertexY =
                        Math.round(localVertices[2][1].toFloat() / Perspective.LOCAL_TILE_SIZE.toFloat()) + tileY + baseY
                    materialC = groundMaterial.getRandomMaterial(tileZ, tileVertexX, tileVertexY)
                }
                var normalsA =
                    proceduralGenerator.vertexTerrainNormals.getOrDefault(vertexKeyA, floatArrayOf(0f, -1f, 0f))
                var normalsB =
                    proceduralGenerator.vertexTerrainNormals.getOrDefault(vertexKeyB, floatArrayOf(0f, -1f, 0f))
                var normalsC =
                    proceduralGenerator.vertexTerrainNormals.getOrDefault(vertexKeyC, floatArrayOf(0f, -1f, 0f))
                if (normalsA == null) {
                    normalsA = floatArrayOf(0f, -1f, 0f)
                }
                if (normalsB == null) {
                    normalsB = floatArrayOf(0f, -1f, 0f)
                }
                if (normalsC == null) {
                    normalsC = floatArrayOf(0f, -1f, 0f)
                }
                val waterType = proceduralGenerator.faceWaterType(tile, face, sceneTileModel)
                val aWaterData = depthA shl 5 or waterType.value
                val bWaterData = depthB shl 5 or waterType.value
                val cWaterData = depthC shl 5 or waterType.value
                normalBuffer.ensureCapacity(12)
                normalBuffer.put(normalsA[0], normalsA[2], normalsA[1], aWaterData.toFloat())
                normalBuffer.put(normalsB[0], normalsB[2], normalsB[1], bWaterData.toFloat())
                normalBuffer.put(normalsC[0], normalsC[2], normalsC[1], cWaterData.toFloat())
                vertexBuffer.ensureCapacity(12)
                vertexBuffer.put(
                    localVertices[0][0] + offsetX,
                    localVertices[0][2] + depthA,
                    localVertices[0][1] + offsetY,
                    colorA
                )
                vertexBuffer.put(
                    localVertices[1][0] + offsetX,
                    localVertices[1][2] + depthB,
                    localVertices[1][1] + offsetY,
                    colorB
                )
                vertexBuffer.put(
                    localVertices[2][0] + offsetX,
                    localVertices[2][2] + depthC,
                    localVertices[2][1] + offsetY,
                    colorC
                )
                bufferLength += 3
                val packedTextureDataA = packTextureData(Material.getIndex(materialA), false)
                val packedTextureDataB = packTextureData(Material.getIndex(materialB), false)
                val packedTextureDataC = packTextureData(Material.getIndex(materialC), false)
                uvBuffer.ensureCapacity(12)
                uvBuffer.put(packedTextureDataA.toFloat(), localVertices[0][0] / 128f, localVertices[0][1] / 128f, 0f)
                uvBuffer.put(packedTextureDataB.toFloat(), localVertices[1][0] / 128f, localVertices[1][1] / 128f, 0f)
                uvBuffer.put(packedTextureDataC.toFloat(), localVertices[2][0] / 128f, localVertices[2][1] / 128f, 0f)
                uvBufferLength += 3
            }
        }
        return intArrayOf(bufferLength, uvBufferLength, underwaterTerrain)
    }

    fun pushFace(
        model: Model,
        face: Int,
        vertexBuffer: GpuIntBuffer,
        uvBuffer: GpuFloatBuffer,
        normalBuffer: GpuFloatBuffer,
        tileZ: Int,
        tileX: Int,
        tileY: Int,
        objectProperties: ObjectProperties?,
        objectType: ObjectType
    ): IntArray {
        val vertexX = model.verticesX
        val vertexY = model.verticesY
        val vertexZ = model.verticesZ
        val trianglesX = model.trianglesX
        val trianglesY = model.trianglesY
        val trianglesZ = model.trianglesZ
        val color1s = model.faceColors1
        val color2s = model.faceColors2
        val color3s = model.faceColors3
        val transparencies = model.triangleTransparencies
        val faceTextures = model.faceTextures
        val facePriorities = model.faceRenderPriorities
        val triangleA = trianglesX[face]
        val triangleB = trianglesY[face]
        val triangleC = trianglesZ[face]
        var color1 = color1s[face]
        var color2 = color2s[face]
        var color3 = color3s[face]
        var uvLength = 0
        var packedAlphaPriority = packAlphaPriority(faceTextures, transparencies, facePriorities, face)
        if (color3 == -1) {
            color3 = color1
            color2 = color3
        } else if (color3 == -2) {
            vertexBuffer.ensureCapacity(12)
            vertexBuffer.put(0, 0, 0, 0)
            vertexBuffer.put(0, 0, 0, 0)
            vertexBuffer.put(0, 0, 0, 0)
            normalBuffer.ensureCapacity(12)
            normalBuffer.put(0f, 0f, 0f, 0f)
            normalBuffer.put(0f, 0f, 0f, 0f)
            normalBuffer.put(0f, 0f, 0f, 0f)
            if (faceTextures != null || objectProperties != null && objectProperties.material != Material.NONE) {
                uvBuffer.ensureCapacity(12)
                uvBuffer.put(0f, 0f, 0f, 0f)
                uvBuffer.put(0f, 0f, 0f, 0f)
                uvBuffer.put(0f, 0f, 0f, 0f)
                uvLength = 3
            }
            bufferLengths[0] = 3
            bufferLengths[1] = uvLength
            return bufferLengths
        }
        val vnAX: Int
        val vnAY: Int
        val vnAZ: Int
        val vnBX: Int
        val vnBY: Int
        val vnBZ: Int
        val vnCX: Int
        val vnCY: Int
        val vnCZ: Int
        val vertexNormalsX = model.vertexNormalsX
        val vertexNormalsY = model.vertexNormalsY
        val vertexNormalsZ = model.vertexNormalsZ
        vnAX = vertexNormalsX[triangleA]
        vnAY = vertexNormalsY[triangleA]
        vnAZ = vertexNormalsZ[triangleA]
        vnBX = vertexNormalsX[triangleB]
        vnBY = vertexNormalsY[triangleB]
        vnBZ = vertexNormalsZ[triangleB]
        vnCX = vertexNormalsX[triangleC]
        vnCY = vertexNormalsY[triangleC]
        vnCZ = vertexNormalsZ[triangleC]
        color1H = color1 shr 10 and 0x3F
        color1S = color1 shr 7 and 0x7
        color1L = color1 and 0x7F
        color2H = color2 shr 10 and 0x3F
        color2S = color2 shr 7 and 0x7
        color2L = color2 and 0x7F
        color3H = color3 shr 10 and 0x3F
        color3S = color3 shr 7 and 0x7
        color3L = color3 and 0x7F

        // reduce the effect of the baked shading by approximately inverting the process by which
        // the shading is added initially.
        lightenA = (Math.max(color1L - ignoreLowLightness, 0) * lightnessMultiplier).toInt() + baseLighten
        // use the dot product of the inverse light vector and each vertex' normal vector to
        // interpolate between the lightened color value and the original color value
        vertex[0] = vnAX.toFloat()
        vertex[1] = vnAY.toFloat()
        vertex[2] = vnAZ.toFloat()
        dotA = VectorUtil.dotVec3(VectorUtil.normalizeVec3(vertex), inverseLightDirection)
        dotA = Math.max(dotA, 0f)
        color1L = HDUtils.lerp(color1L.toFloat(), lightenA.toFloat(), dotA).toInt()
        lightenB = (Math.max(color2L - ignoreLowLightness, 0) * lightnessMultiplier).toInt() + baseLighten
        vertex[0] = vnBX.toFloat()
        vertex[1] = vnBY.toFloat()
        vertex[2] = vnBZ.toFloat()
        dotB = VectorUtil.dotVec3(VectorUtil.normalizeVec3(vertex), inverseLightDirection)
        dotB = Math.max(dotB, 0f)
        color2L = HDUtils.lerp(color2L.toFloat(), lightenB.toFloat(), dotB).toInt()
        lightenC = (Math.max(color3L - ignoreLowLightness, 0) * lightnessMultiplier).toInt() + baseLighten
        vertex[0] = vnCX.toFloat()
        vertex[1] = vnCY.toFloat()
        vertex[2] = vnCZ.toFloat()
        dotC = VectorUtil.dotVec3(VectorUtil.normalizeVec3(vertex), inverseLightDirection)
        dotC = Math.max(dotC, 0f)
        color3L = HDUtils.lerp(color3L.toFloat(), lightenC.toFloat(), dotC).toInt()
        if (faceTextures != null && faceTextures[face].toInt() != -1) {
            // set textured faces to pure white as they are harder to remove shadows from for some reason
            color3H = 0
            color2H = color3H
            color1H = color2H
            color3S = 0
            color2S = color3S
            color1S = color2S
            color3L = 127
            color2L = color3L
            color1L = color2L
        }
        if (objectProperties != null && objectProperties.inheritTileColor) {
            val tile = client.scene.tiles[tileZ][tileX][tileY]
            if (tile != null && (tile.sceneTilePaint != null || tile.sceneTileModel != null)) {
                val tileColorHSL: IntArray
                if (tile.sceneTilePaint != null && tile.sceneTilePaint.texture == -1) {
                    // pull any corner color as either one should be OK
                    tileColorHSL = HDUtils.colorIntToHSL(tile.sceneTilePaint.swColor)

                    // average saturation and lightness
                    tileColorHSL[1] = (tileColorHSL[1] +
                            HDUtils.colorIntToHSL(tile.sceneTilePaint.seColor)[1] +
                            HDUtils.colorIntToHSL(tile.sceneTilePaint.nwColor)[1] +
                            HDUtils.colorIntToHSL(tile.sceneTilePaint.neColor)[1]) / 4
                    tileColorHSL[2] = (tileColorHSL[2] +
                            HDUtils.colorIntToHSL(tile.sceneTilePaint.seColor)[2] +
                            HDUtils.colorIntToHSL(tile.sceneTilePaint.nwColor)[2] +
                            HDUtils.colorIntToHSL(tile.sceneTilePaint.neColor)[2]) / 4
                    color3H = tileColorHSL[0]
                    color2H = color3H
                    color1H = color2H
                    color3S = tileColorHSL[1]
                    color2S = color3S
                    color1S = color2S
                    color3L = tileColorHSL[2]
                    color2L = color3L
                    color1L = color2L
                } else if (tile.sceneTileModel != null && tile.sceneTileModel.triangleTextureId == null) {
                    var faceColorIndex = -1
                    for (i in tile.sceneTileModel.triangleColorA.indices) {
                        if (!proceduralGenerator.isOverlayFace(tile, i)) {
                            // get a color from an underlay face as it's generally more desirable
                            // than pulling colors from paths and other overlays
                            faceColorIndex = i
                            break
                        }
                    }
                    if (faceColorIndex != -1) {
                        tileColorHSL = HDUtils.colorIntToHSL(tile.sceneTileModel.triangleColorA[faceColorIndex])
                        color3H = tileColorHSL[0]
                        color2H = color3H
                        color1H = color2H
                        color3S = tileColorHSL[1]
                        color2S = color3S
                        color1S = color2S
                        color3L = tileColorHSL[2]
                        color2L = color3L
                        color1L = color2L
                    }
                }
            }
        }
        if (hdPlugin.configTzhaarHD && objectProperties != null && objectProperties.tzHaarRecolorType != TzHaarRecolorType.NONE) {
            val tzHaarRecolored = proceduralGenerator.recolorTzHaar(
                objectProperties,
                vertexY[triangleA],
                vertexY[triangleB],
                vertexY[triangleC],
                packedAlphaPriority,
                objectType,
                color1H,
                color1S,
                color1L,
                color2H,
                color2S,
                color2L,
                color3H,
                color3S,
                color3L
            )
            color1H = tzHaarRecolored[0][0]
            color1S = tzHaarRecolored[0][1]
            color1L = tzHaarRecolored[0][2]
            color2H = tzHaarRecolored[1][0]
            color2S = tzHaarRecolored[1][1]
            color2L = tzHaarRecolored[1][2]
            color3H = tzHaarRecolored[2][0]
            color3S = tzHaarRecolored[2][1]
            color3L = tzHaarRecolored[2][2]
            packedAlphaPriority = tzHaarRecolored[3][0]
        }

        // adjust overly-bright vertex colors to reduce ugly washed-out areas of
        // brightly-colored models
        var maxBrightness = 55
        if (faceTextures != null && faceTextures[face].toInt() != -1) {
            maxBrightness = 90
        }
        color1L = Ints.constrainToRange(color1L, 0, maxBrightness)
        color2L = Ints.constrainToRange(color2L, 0, maxBrightness)
        color3L = Ints.constrainToRange(color3L, 0, maxBrightness)
        color1 = color1H shl 3 or color1S shl 7 or color1L
        color2 = color2H shl 3 or color2S shl 7 or color2L
        color3 = color3H shl 3 or color3S shl 7 or color3L
        normalBuffer.ensureCapacity(12)

        // if color3 is -1, the object is flat-shaded
        if (color3s[face] == -1 || objectProperties != null && objectProperties.flatNormals) {
            normalBuffer.put(0f, 0f, 0f, 0f)
            normalBuffer.put(0f, 0f, 0f, 0f)
            normalBuffer.put(0f, 0f, 0f, 0f)
        } else {
            normalBuffer.put(vnAX.toFloat(), vnAY.toFloat(), vnAZ.toFloat(), 0f)
            normalBuffer.put(vnBX.toFloat(), vnBY.toFloat(), vnBZ.toFloat(), 0f)
            normalBuffer.put(vnCX.toFloat(), vnCY.toFloat(), vnCZ.toFloat(), 0f)
        }
        vertexBuffer.ensureCapacity(12)
        val aX = vertexX[triangleA]
        val aY = vertexY[triangleA]
        val aZ = vertexZ[triangleA]
        vertexBuffer.put(aX, aY, aZ, packedAlphaPriority or color1)
        val bX = vertexX[triangleB]
        val bY = vertexY[triangleB]
        val bZ = vertexZ[triangleB]
        vertexBuffer.put(bX, bY, bZ, packedAlphaPriority or color2)
        val cX = vertexX[triangleC]
        val cY = vertexY[triangleC]
        val cZ = vertexZ[triangleC]
        vertexBuffer.put(cX, cY, cZ, packedAlphaPriority or color3)
        val uv = model.faceTextureUVCoordinates
        val material: Material
        if (faceTextures != null && faceTextures[face].toInt() != -1 && uv != null) {
            material = Material.getTexture(faceTextures[face].toInt())
            val packedTextureData = packTextureData(Material.getIndex(material), false)
            val idx = face * 6
            uvBuffer.ensureCapacity(12)
            uvBuffer.put(packedTextureData.toFloat(), uv[idx], uv[idx + 1], 0f)
            uvBuffer.put(packedTextureData.toFloat(), uv[idx + 2], uv[idx + 3], 0f)
            uvBuffer.put(packedTextureData.toFloat(), uv[idx + 4], uv[idx + 5], 0f)
            uvLength = 3
        } else if (objectProperties != null && objectProperties.material != Material.NONE) {
            material = if (hdPlugin.configObjectTextures) objectProperties.material else Material.NONE
            val packedTextureData = packTextureData(Material.getIndex(material), false)
            uvBuffer.ensureCapacity(12)
            uvLength = if (objectProperties.uvType == UvType.GROUND_PLANE) {
                val aU = aX % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                val aV = aZ % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                val bU = bX % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                val bV = bZ % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                val cU = cX % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                val cV = cZ % Perspective.LOCAL_TILE_SIZE / Perspective.LOCAL_TILE_SIZE.toFloat()
                uvBuffer.put(packedTextureData.toFloat(), aU, aV, 0f)
                uvBuffer.put(packedTextureData.toFloat(), bU, bV, 0f)
                uvBuffer.put(packedTextureData.toFloat(), cU, cV, 0f)
                3
            } else {
                // UvType.GEOMETRY
                uvBuffer.put(packedTextureData.toFloat(), 0f, 0f, 0f)
                uvBuffer.put(packedTextureData.toFloat(), 1f, 0f, 0f)
                uvBuffer.put(packedTextureData.toFloat(), 0f, 1f, 0f)
                3
            }
        } else if (faceTextures != null) {
            uvBuffer.ensureCapacity(12)
            uvBuffer.put(0f, 0f, 0f, 0f)
            uvBuffer.put(0f, 0f, 0f, 0f)
            uvBuffer.put(0f, 0f, 0f, 0f)
            uvLength = 3
        }
        bufferLengths[0] = 3
        bufferLengths[1] = uvLength
        return bufferLengths
    }

    private fun packTextureData(texture: Int, isOverlay: Boolean): Int {
        return texture shl 1 or if (isOverlay) 1 else 0
    }

    companion object {
        var color1H = 0
        var color1S = 0
        var color1L = 0
        var color2H = 0
        var color2S = 0
        var color2L = 0
        var color3H = 0
        var color3S = 0
        var color3L = 0
        var HSL = IntArray(3)
        var vertex = FloatArray(3)
        var bufferLengths = IntArray(2)

        // a directional vector approximately opposite of the directional light
        // used by the client
        var inverseLightDirection = floatArrayOf(0.57735026f, 0.57735026f, 0.57735026f)

        // multiplier applied to vertex' lightness value.
        // results in greater lightening of lighter colors
        var lightnessMultiplier = 3f

        // the minimum amount by which each color will be lightened
        var baseLighten = 10

        // subtracts the X lowest lightness levels from the formula.
        // helps keep darker colors appropriately dark
        var ignoreLowLightness = 3
        var lightenA = 0
        var dotA = 0f
        var lightenB = 0
        var dotB = 0f
        var lightenC = 0
        var dotC = 0f
        private fun packAlphaPriority(
            faceTextures: ShortArray?,
            faceTransparencies: ByteArray?,
            facePriorities: ByteArray?,
            face: Int
        ): Int {
            var alpha = 0
            if (faceTransparencies != null && (faceTextures == null || faceTextures[face].toInt() == -1)) {
                alpha = faceTransparencies[face].toInt() and 0xFF shl 24
            }
            var priority = 0
            if (facePriorities != null) {
                priority = facePriorities[face].toInt() and 0xff shl 16
            }
            return alpha or priority
        }
    }
}