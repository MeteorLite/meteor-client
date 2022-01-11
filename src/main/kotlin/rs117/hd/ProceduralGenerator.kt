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
package rs117.hd

import com.google.common.primitives.Floats
import com.google.common.primitives.Ints
import com.jogamp.opengl.math.VectorUtil
import net.runelite.api.*
import rs117.hd.config.WaterEffects
import rs117.hd.materials.*
import java.util.*
import kotlin.collections.HashMap

class ProceduralGenerator(var hdPlugin: GpuHDPlugin) {
    private val client = Main.client
    private val VERTICES_PER_FACE = 3

    // terrain data
    var vertexTerrainColor: HashMap<Int, Int> = HashMap()
    var vertexTerrainTexture: HashMap<Int, Material> = HashMap()
    var vertexTerrainNormals: HashMap<Int, FloatArray> = HashMap()

    // used for overriding potentially low quality vertex colors
    var highPriorityColor: HashMap<Int, Boolean> = HashMap()

    // water-related data
    lateinit var tileIsWater: Array<Array<BooleanArray>>
    var vertexIsWater: HashMap<Int, Boolean> = HashMap()
    var vertexIsLand: HashMap<Int, Boolean> = HashMap()
    var vertexIsOverlay: HashMap<Int, Boolean> = HashMap()
    var vertexIsUnderlay: HashMap<Int, Boolean> = HashMap()
    lateinit var skipTile: Array<Array<BooleanArray>>
    var vertexUnderwaterDepth: HashMap<Int, Int> = HashMap()
    lateinit var underwaterDepthLevels: Array<Array<IntArray>>
    var depthLevelSlope = intArrayOf(150, 300, 470, 610, 700, 750, 820, 920, 1080, 1300, 1350, 1380)

    /**
     * Iterates through all Tiles in a given Scene, producing color and
     * material data for each vertex of each Tile. Then adds the resulting
     * data to appropriate HashMaps.
     *
     * @param scene
     */
    fun generateTerrainData(scene: Scene) {
        vertexTerrainColor = HashMap()
        // used for overriding potentially undesirable vertex colors
        // for example, colors that aren't supposed to be visible
        highPriorityColor = HashMap()
        vertexTerrainTexture = HashMap()
        // for faces without an overlay is set to true
        vertexIsUnderlay = HashMap()
        // for faces with an overlay is set to true
        // the result of these maps can be used to determine the vertices
        // between underlays and overlays for custom blending
        vertexIsOverlay = HashMap()
        val tiles = scene.tiles

        // first loop - assign land colors and textures to hashmap
        for (z in 0 until Constants.MAX_Z) {
            for (x in 0 until Constants.SCENE_SIZE) {
                for (y in 0 until Constants.SCENE_SIZE) {
                    if (tiles[z][x][y] != null) {
                        if (tiles[z][x][y]!!.bridge != null) {
                            generateDataForTile(tiles[z][x][y]!!.bridge)
                        }
                        generateDataForTile(tiles[z][x][y])
                    }
                }
            }
        }
    }

    /**
     * Produces color and material data for the vertices of the provided Tile.
     * Then adds the resulting data to appropriate HashMaps.
     *
     * @param tile
     */
    fun generateDataForTile(tile: Tile?) {
        val faceCount: Int
        faceCount = if (tile!!.sceneTilePaint != null) {
            2
        } else if (tile.sceneTileModel != null) {
            tile.sceneTileModel.faceX.size
        } else {
            return
        }
        var vertexHashes = IntArray(faceCount * VERTICES_PER_FACE)
        val vertexColors = IntArray(faceCount * VERTICES_PER_FACE)
        val vertexOverlays = IntArray(faceCount * VERTICES_PER_FACE)
        val vertexUnderlays = IntArray(faceCount * VERTICES_PER_FACE)
        val vertexDefaultColor = BooleanArray(faceCount * VERTICES_PER_FACE)
        val z = tile.renderLevel
        val x = tile.sceneLocation.x
        val y = tile.sceneLocation.y
        val worldX = tile.worldLocation.x
        val worldY = tile.worldLocation.y
        if (tile.sceneTilePaint != null) {
            // tile paint
            if (tileWaterType(tile, tile.sceneTilePaint) !== WaterType.NONE) {
                // skip water tiles
                return
            }
            val swColor = tile.sceneTilePaint.swColor
            var seColor = tile.sceneTilePaint.seColor
            var nwColor = tile.sceneTilePaint.nwColor
            var neColor = tile.sceneTilePaint.neColor
            vertexHashes = tileVertexKeys(tile)
            if (x >= Constants.SCENE_SIZE - 2 && y >= Constants.SCENE_SIZE - 2) {
                // reduce the black scene edges by assigning surrounding colors
                neColor = swColor
                nwColor = swColor
                seColor = swColor
            } else if (y >= Constants.SCENE_SIZE - 2) {
                nwColor = swColor
                neColor = seColor
            } else if (x >= Constants.SCENE_SIZE - 2) {
                neColor = nwColor
                seColor = swColor
            }
            vertexColors[0] = swColor
            vertexColors[1] = seColor
            vertexColors[2] = nwColor
            vertexColors[3] = neColor
            vertexOverlays[3] = client.scene.overlayIds[z][x][y].toInt()
            vertexOverlays[2] = vertexOverlays[3]
            vertexOverlays[1] = vertexOverlays[2]
            vertexOverlays[0] = vertexOverlays[1]
            vertexUnderlays[3] = client.scene.underlayIds[z][x][y].toInt()
            vertexUnderlays[2] = vertexUnderlays[3]
            vertexUnderlays[1] = vertexUnderlays[2]
            vertexUnderlays[0] = vertexUnderlays[1]
            if (useDefaultColor(tile)) {
                vertexDefaultColor[3] = true
                vertexDefaultColor[2] = vertexDefaultColor[3]
                vertexDefaultColor[1] = vertexDefaultColor[2]
                vertexDefaultColor[0] = vertexDefaultColor[1]
            }
        } else if (tile.sceneTileModel != null) {
            // tile model
            val sceneTileModel = tile.sceneTileModel
            val faceColorsA = sceneTileModel.triangleColorA
            val faceColorsB = sceneTileModel.triangleColorB
            val faceColorsC = sceneTileModel.triangleColorC
            for (face in 0 until faceCount) {
                val faceColors = intArrayOf(faceColorsA[face], faceColorsB[face], faceColorsC[face])
                val vertexKeys = faceVertexKeys(tile, face)
                for (vertex in 0 until VERTICES_PER_FACE) {
                    if (faceWaterType(tile, face, sceneTileModel) !== WaterType.NONE) {
                        // skip water faces
                        continue
                    }
                    vertexHashes[face * VERTICES_PER_FACE + vertex] = vertexKeys[vertex]
                    val color = faceColors[vertex]
                    vertexColors[face * VERTICES_PER_FACE + vertex] = color
                    if (isOverlayFace(tile, face)) {
                        vertexOverlays[face * VERTICES_PER_FACE + vertex] = client.scene.overlayIds[z][x][y]
                            .toInt()
                    }
                    vertexUnderlays[face * VERTICES_PER_FACE + vertex] = client.scene.underlayIds[z][x][y]
                        .toInt()
                    if (isOverlayFace(tile, face) && useDefaultColor(tile)) {
                        vertexDefaultColor[face * VERTICES_PER_FACE + vertex] = true
                    }
                }
            }
        }
        for (vertex in vertexHashes.indices) {
            if (vertexHashes[vertex] == 0) {
                continue
            }
            if (vertexColors[vertex] < 0 || vertexColors[vertex] > 65535) {
                // skip invalid tile color
                continue
            }
            var lowPriorityColor = false
            // if this vertex already has a 'high priority' color assigned
            // skip assigning a 'low priority' color unless there is no color assigned
            if (vertexColors[vertex] <= 2) {
                // near-solid-black tiles that are used in some places under wall objects
                lowPriorityColor = true
            }
            var colorHSL = HDUtils.colorIntToHSL(vertexColors[vertex])
            val inverseLightDirection = VectorUtil.normalizeVec3(floatArrayOf(1.0f, 1.0f, 0.0f))
            val multiplier = 1.5f
            val base = 15
            val add = 3
            val vNormals = vertexTerrainNormals!!.getOrDefault(vertexHashes[vertex], floatArrayOf(0.0f, 0.0f, 0.0f))
            var dot = VectorUtil.dotVec3(VectorUtil.normalizeVec3(vNormals), inverseLightDirection)
            dot = Math.max(dot, 0f)
            val lighten = (Math.max(colorHSL[2] - add, 0) * multiplier).toInt() + base
            colorHSL[2] = HDUtils.lerp(colorHSL[2].toFloat(), lighten.toFloat(), dot).toInt()
            var isOverlay = false
            var material = Material.DIRT_1
            if (vertexOverlays[vertex] != 0) {
                val overlay = Overlay.getOverlay(vertexOverlays[vertex], tile, client)
                val groundMaterial = overlay.groundMaterial
                material = groundMaterial.getRandomMaterial(z, worldX, worldY)
                isOverlay = !overlay.blendedAsUnderlay
                colorHSL = recolorOverlay(overlay, colorHSL)
            } else if (vertexUnderlays[vertex] != 0) {
                val underlay = Underlay.getUnderlay(vertexUnderlays[vertex], tile, client)
                val groundMaterial = underlay.groundMaterial
                material = groundMaterial.getRandomMaterial(z, worldX, worldY)
                isOverlay = underlay.blendedAsOverlay
                colorHSL = recolorUnderlay(underlay, colorHSL)
            }
            val maxBrightness = 55 // reduces overexposure
            colorHSL[2] = Ints.constrainToRange(colorHSL[2], 0, maxBrightness)
            vertexColors[vertex] = HDUtils.colorHSLToInt(colorHSL)

            // mark the vertex as either an overlay or underlay.
            // this is used to determine how to blend between vertex colors
            if (isOverlay) {
                vertexIsOverlay[vertexHashes[vertex]] = true
            } else {
                vertexIsUnderlay[vertexHashes[vertex]] = true
            }

            // add color and texture to hashmap
            if ((!lowPriorityColor || !highPriorityColor.containsKey(vertexHashes[vertex])) && !vertexDefaultColor[vertex]) {
                if (vertexOverlays[vertex] != 0 || !vertexTerrainColor.containsKey(vertexHashes[vertex]) || !highPriorityColor.containsKey(
                        vertexHashes[vertex]
                    )
                ) {
                    vertexTerrainColor[vertexHashes[vertex]] = vertexColors[vertex]
                }
                if (vertexOverlays[vertex] != 0 || !vertexTerrainTexture.containsKey(vertexHashes[vertex]) || !highPriorityColor.containsKey(
                        vertexHashes[vertex]
                    )
                ) {
                    vertexTerrainTexture[vertexHashes[vertex]] = material
                }
                if (!lowPriorityColor) {
                    highPriorityColor!![vertexHashes[vertex]] = true
                }
            }
        }
    }

    /**
     * Generates underwater terrain data by iterating through all Tiles in a given
     * Scene, increasing the depth of each tile based on its distance from the shore.
     * Then stores the resulting data in a HashMap.
     *
     * @param scene
     */
    fun generateUnderwaterTerrain(scene: Scene) {
        // true if a tile contains at least 1 face which qualifies as water
        tileIsWater = Array(Constants.MAX_Z) { Array(Constants.SCENE_SIZE) { BooleanArray(Constants.SCENE_SIZE) } }
        // true if a vertex is part of a face which qualifies as water; non-existent if not
        vertexIsWater = HashMap()
        // true if a vertex is part of a face which qualifies as land; non-existent if not
        // tiles along the shoreline will be true for both vertexIsWater and vertexIsLand
        vertexIsLand = HashMap()
        // if true, the tile will be skipped when the scene is drawn
        // this is due to certain edge cases with water on the same X/Y on different planes
        skipTile = Array(Constants.MAX_Z) { Array(Constants.SCENE_SIZE) { BooleanArray(Constants.SCENE_SIZE) } }
        // the height adjustment for each vertex, to be applied to the vertex'
        // real height to create the underwater terrain
        vertexUnderwaterDepth = HashMap()
        // the basic 'levels' of underwater terrain, used to sink terrain based on its distance
        // from the shore, then used to produce the world-space height offset
        // 0 = land
        underwaterDepthLevels =
            Array(Constants.MAX_Z) { Array(Constants.SCENE_SIZE + 1) { IntArray(Constants.SCENE_SIZE + 1) } }
        // the world-space height offsets of each vertex on the tile grid
        // these offsets are interpolated to calculate offsets for vertices not on the grid (tilemodels)
        val underwaterDepths =
            Array(Constants.MAX_Z) { Array(Constants.SCENE_SIZE + 1) { IntArray(Constants.SCENE_SIZE + 1) } }
        if (hdPlugin.configWaterEffects == WaterEffects.SIMPLE) {
            return
        }
        val tiles = scene.tiles
        for (z in 0 until Constants.MAX_Z) {
            for (x in 0 until Constants.SCENE_SIZE) {
                // set the array to 1 initially
                // this assumes that all vertices are water;
                // we will set non-water vertices to 0 in the next loop
                Arrays.fill(underwaterDepthLevels[z][x], 1)
            }
        }

        // figure out which vertices are water and assign some data
        for (z in 0 until Constants.MAX_Z) {
            for (x in 0 until Constants.SCENE_SIZE) {
                for (y in 0 until Constants.SCENE_SIZE) {
                    if (tiles[z][x][y] == null) {
                        underwaterDepthLevels[z][x][y] = 0
                        underwaterDepthLevels[z][x + 1][y] = 0
                        underwaterDepthLevels[z][x][y + 1] = 0
                        underwaterDepthLevels[z][x + 1][y + 1] = 0
                        continue
                    }
                    var tile = tiles[z][x][y]
                    if (tile!!.bridge != null) {
                        tile = tile.bridge
                    }
                    if (tile!!.sceneTilePaint != null) {
                        val vertexKeys = tileVertexKeys(tile)
                        if (tileWaterType(tile, tile.sceneTilePaint) === WaterType.NONE) {
                            for (vertexKey in vertexKeys) {
                                if (tile.sceneTilePaint.neColor != 12345678) {
                                    vertexIsLand[vertexKey] = true
                                }
                            }
                            underwaterDepthLevels[z][x][y] = 0
                            underwaterDepthLevels[z][x + 1][y] = 0
                            underwaterDepthLevels[z][x][y + 1] = 0
                            underwaterDepthLevels[z][x + 1][y + 1] = 0
                        } else {
                            // Stop tiles on the same X,Y coordinates on different planes from
                            // each generating water. Prevents undesirable results in certain places.
                            if (z > 0) {
                                var continueLoop = false
                                for (checkZ in 0 until z) {
                                    if (tileIsWater[checkZ][x][y]) {
                                        underwaterDepthLevels[z][x][y] = 0
                                        underwaterDepthLevels[z][x + 1][y] = 0
                                        underwaterDepthLevels[z][x][y + 1] = 0
                                        underwaterDepthLevels[z][x + 1][y + 1] = 0
                                        skipTile[z][x][y] = true
                                        continueLoop = true
                                        break
                                    }
                                }
                                if (continueLoop) continue
                            }
                            tileIsWater[z][x][y] = true
                            for (vertexKey in vertexKeys) {
                                vertexIsWater[vertexKey] = true
                            }
                        }
                    } else if (tile.sceneTileModel != null) {
                        val sceneTileModel = tile.sceneTileModel
                        val faceCount = sceneTileModel.faceX.size

                        // Stop tiles on the same X,Y coordinates on different planes from
                        // each generating water. Prevents undesirable results in certain places.
                        if (z > 0) {
                            var tileIncludesWater = false
                            for (face in 0 until faceCount) {
                                if (faceWaterType(tile, face, sceneTileModel) !== WaterType.NONE) {
                                    tileIncludesWater = true
                                    break
                                }
                            }
                            if (tileIncludesWater) {
                                var continueLoop = false
                                for (checkZ in 0 until z) {
                                    if (tileIsWater[checkZ][x][y]) {
                                        underwaterDepthLevels[z][x][y] = 0
                                        underwaterDepthLevels[z][x + 1][y] = 0
                                        underwaterDepthLevels[z][x][y + 1] = 0
                                        underwaterDepthLevels[z][x + 1][y + 1] = 0
                                        skipTile[z][x][y] = true
                                        continueLoop = true
                                        break
                                    }
                                }
                                if (continueLoop) continue
                            }
                        }
                        for (face in 0 until faceCount) {
                            val vertices = faceVertices(tile, face)
                            val vertexKeys = faceVertexKeys(tile, face)
                            if (faceWaterType(tile, face, sceneTileModel) === WaterType.NONE) {
                                for (vertex in 0 until VERTICES_PER_FACE) {
                                    if (sceneTileModel.triangleColorA[face] != 12345678) {
                                        vertexIsLand[vertexKeys[vertex]] = true
                                    }
                                    if (vertices[vertex][0] % Perspective.LOCAL_TILE_SIZE == 0 && vertices[vertex][1] % Perspective.LOCAL_TILE_SIZE == 0) {
                                        val vX = vertices[vertex][0] / Perspective.LOCAL_TILE_SIZE
                                        val vY = vertices[vertex][1] / Perspective.LOCAL_TILE_SIZE
                                        underwaterDepthLevels[z][vX][vY] = 0
                                    }
                                }
                            } else {
                                tileIsWater[z][x][y] = true
                                for (vertex in 0 until VERTICES_PER_FACE) {
                                    vertexIsWater[vertexKeys[vertex]] = true
                                }
                            }
                        }
                    } else {
                        underwaterDepthLevels[z][x][y] = 0
                        underwaterDepthLevels[z][x + 1][y] = 0
                        underwaterDepthLevels[z][x][y + 1] = 0
                        underwaterDepthLevels[z][x + 1][y + 1] = 0
                    }
                }
            }
        }

        // Sink terrain further from shore by desired levels.
        for (level in 0 until depthLevelSlope.size - 1) {
            for (z in 0 until Constants.MAX_Z) {
                for (x in 0 until underwaterDepthLevels[z].size) {
                    for (y in 0 until underwaterDepthLevels[z][x].size) {
                        if (underwaterDepthLevels[z][x][y] == 0) {
                            // Skip the tile if it isn't water.
                            continue
                        }
                        // If it's on the edge of the scene, reset the depth so
                        // it creates a 'wall' to prevent fog from passing through.
                        // Not incredibly effective, but better than nothing.
                        if (x == 0 || y == 0 || x == Constants.SCENE_SIZE || y == Constants.SCENE_SIZE) {
                            underwaterDepthLevels[z][x][y] = 0
                            continue
                        }
                        val tileHeight = underwaterDepthLevels[z][x][y]
                        if (underwaterDepthLevels[z][x - 1][y] < tileHeight) {
                            // West
                            continue
                        }
                        if (x < underwaterDepthLevels[z].size - 1 && underwaterDepthLevels[z][x + 1][y] < tileHeight) {
                            // East
                            continue
                        }
                        if (underwaterDepthLevels[z][x][y - 1] < tileHeight) {
                            // South
                            continue
                        }
                        if (y < underwaterDepthLevels[z].size - 1 && underwaterDepthLevels[z][x][y + 1] < tileHeight) {
                            // North
                            continue
                        }
                        // At this point, it's surrounded only by other depth-adjusted vertices.
                        underwaterDepthLevels[z][x][y]++
                    }
                }
            }
        }

        // Adjust the height levels to world coordinate offsets and add to an array.
        for (z in 0 until Constants.MAX_Z) {
            for (x in 0 until underwaterDepthLevels[z].size) {
                for (y in 0 until underwaterDepthLevels[z][x].size) {
                    if (underwaterDepthLevels[z][x][y] == 0) {
                        continue
                    }
                    val maxRange = depthLevelSlope[underwaterDepthLevels[z][x][y] - 1]
                    val minRange = (depthLevelSlope[underwaterDepthLevels[z][x][y] - 1] * 0.1f).toInt()
                    // Range from noise-generated terrain is 10-60.
                    // Translate the result from range 0-1.
//					float noiseOffset = (HeightCalc.calculate(baseX + x + 0xe3b7b, baseY + y + 0x87cce) - 10) / 50f;
                    var noiseOffset = 0.5f
                    // limit range of variation
                    val minOffset = 0.25f
                    val maxOffset = 0.75f
                    noiseOffset = HDUtils.lerp(minOffset, maxOffset, noiseOffset)
                    // apply offset to vertex height range
                    val heightOffset = HDUtils.lerp(minRange.toFloat(), maxRange.toFloat(), noiseOffset).toInt()
                    underwaterDepths[z][x][y] = heightOffset
                }
            }
        }

        // Store the height offsets in a hashmap and calculate interpolated
        // height offsets for non-corner vertices.
        for (z in 0 until Constants.MAX_Z) {
            for (x in 0 until Constants.SCENE_SIZE) {
                for (y in 0 until Constants.SCENE_SIZE) {
                    if (!tileIsWater[z][x][y]) {
                        continue
                    }
                    var tile = tiles[z][x][y]
                    if (tile!!.bridge != null) {
                        tile = tile.bridge
                    }
                    if (tile!!.sceneTilePaint != null) {
                        val vertexKeys = tileVertexKeys(tile)
                        val swVertexKey = vertexKeys[0]
                        val seVertexKey = vertexKeys[1]
                        val nwVertexKey = vertexKeys[2]
                        val neVertexKey = vertexKeys[3]
                        vertexUnderwaterDepth[swVertexKey] = underwaterDepths[z][x][y]
                        vertexUnderwaterDepth[seVertexKey] = underwaterDepths[z][x + 1][y]
                        vertexUnderwaterDepth[nwVertexKey] = underwaterDepths[z][x][y + 1]
                        vertexUnderwaterDepth[neVertexKey] = underwaterDepths[z][x + 1][y + 1]
                    } else if (tile.sceneTileModel != null) {
                        val sceneTileModel = tile.sceneTileModel
                        val faceCount = sceneTileModel.faceX.size
                        for (face in 0 until faceCount) {
                            val vertices = faceVertices(tile, face)
                            val vertexKeys = faceVertexKeys(tile, face)
                            for (vertex in 0 until VERTICES_PER_FACE) {
                                if (vertices[vertex][0] % Perspective.LOCAL_TILE_SIZE == 0 && vertices[vertex][1] % Perspective.LOCAL_TILE_SIZE == 0) {
                                    // The vertex is at the corner of the tile;
                                    // simply use the offset in the tile grid array.
                                    val vX = vertices[vertex][0] / Perspective.LOCAL_TILE_SIZE
                                    val vY = vertices[vertex][1] / Perspective.LOCAL_TILE_SIZE
                                    vertexUnderwaterDepth[vertexKeys[vertex]] = underwaterDepths[z][vX][vY]
                                } else {
                                    // If the tile is a tile model and this vertex is shared only by faces that are water,
                                    // interpolate between the height offsets at each corner to get the height offset
                                    // of the vertex.
                                    val localVertexX = vertices[vertex][0] - x * Perspective.LOCAL_TILE_SIZE
                                    val localVertexY = vertices[vertex][1] - y * Perspective.LOCAL_TILE_SIZE
                                    val lerpX = localVertexX.toFloat() / Perspective.LOCAL_TILE_SIZE.toFloat()
                                    val lerpY = localVertexY.toFloat() / Perspective.LOCAL_TILE_SIZE.toFloat()
                                    val northHeightOffset = HDUtils.lerp(
                                        underwaterDepths[z][x][y + 1].toFloat(), underwaterDepths[z][x + 1][y + 1]
                                            .toFloat(), lerpX
                                    )
                                    val southHeightOffset = HDUtils.lerp(
                                        underwaterDepths[z][x][y].toFloat(), underwaterDepths[z][x + 1][y]
                                            .toFloat(), lerpX
                                    )
                                    val heightOffset = HDUtils.lerp(southHeightOffset, northHeightOffset, lerpY).toInt()
                                    if (!vertexIsLand.containsKey(vertexKeys[vertex])) {
                                        vertexUnderwaterDepth[vertexKeys[vertex]] = heightOffset
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Iterates through all Tiles in a given Scene, calculating vertex normals
     * for each one, then stores resulting normal data in a HashMap.
     *
     * @param scene
     */
    fun calculateTerrainNormals(scene: Scene) {
        vertexTerrainNormals = HashMap()
        val tiles = scene.tiles
        for (tileZ in tiles.indices) {
            for (tileX in 0 until tiles[tileZ].size) {
                for (tileY in 0 until tiles[tileZ][tileX].size) {
                    if (tiles[tileZ][tileX][tileY] != null) {
                        var isBridge = false
                        if (tiles[tileZ][tileX][tileY]!!.bridge != null) {
                            calculateNormalsForTile(tiles[tileZ][tileX][tileY]!!.bridge, false)
                            isBridge = true
                        }
                        calculateNormalsForTile(tiles[tileZ][tileX][tileY], isBridge)
                    }
                }
            }
        }
    }

    /**
     * Calculates vertex normals for a given Tile,
     * then stores resulting normal data in a HashMap.
     *
     * @param tile
     * @param isBridge
     */
    fun calculateNormalsForTile(tile: Tile?, isBridge: Boolean) {
        // Make array of tile's tris with vertices
        val faceVertices: Array<Array<IntArray>> // Array of tile's tri vertices
        val faceVertexKeys: Array<IntArray>
        if (tile!!.sceneTileModel != null) {
            // Tile model
            val tileModel = tile.sceneTileModel
            faceVertices = Array(tileModel.faceX.size) { Array(VERTICES_PER_FACE) { IntArray(3) } }
            faceVertexKeys = Array(tileModel.faceX.size) { IntArray(VERTICES_PER_FACE) }
            for (face in tileModel.faceX.indices) {
                val vertices = faceVertices(tile, face)
                faceVertices[face][0] = intArrayOf(vertices[0][0], vertices[0][1], vertices[0][2])
                faceVertices[face][2] = intArrayOf(vertices[1][0], vertices[1][1], vertices[1][2])
                faceVertices[face][1] = intArrayOf(vertices[2][0], vertices[2][1], vertices[2][2])
                val vertexKeys = faceVertexKeys(tile, face)
                faceVertexKeys[face][0] = vertexKeys[0]
                faceVertexKeys[face][2] = vertexKeys[1]
                faceVertexKeys[face][1] = vertexKeys[2]
            }
        } else {
            faceVertices = Array(2) { Array(VERTICES_PER_FACE) { IntArray(3) } }
            faceVertexKeys = Array(VERTICES_PER_FACE) { IntArray(3) }
            val vertices = tileVertices(tile)
            faceVertices[0] = arrayOf(vertices[3], vertices[1], vertices[2])
            faceVertices[1] = arrayOf(vertices[0], vertices[2], vertices[1])
            val vertexKeys = tileVertexKeys(tile)
            faceVertexKeys[0] = intArrayOf(vertexKeys[3], vertexKeys[1], vertexKeys[2])
            faceVertexKeys[1] = intArrayOf(vertexKeys[0], vertexKeys[2], vertexKeys[1])
        }

        // Loop through tris to calculate and accumulate normals
        for (face in faceVertices.indices) {
            // XYZ
            val vertexHeights = intArrayOf(faceVertices[face][0][2], faceVertices[face][1][2], faceVertices[face][2][2])
            if (!isBridge) {
                vertexHeights[0] += vertexUnderwaterDepth!!.getOrDefault(faceVertexKeys[face][0], 0)
                vertexHeights[1] += vertexUnderwaterDepth!!.getOrDefault(faceVertexKeys[face][1], 0)
                vertexHeights[2] += vertexUnderwaterDepth!!.getOrDefault(faceVertexKeys[face][2], 0)
            }
            val vertexNormals = HDUtils.calculateSurfaceNormals(
                intArrayOf(faceVertices[face][0][0], faceVertices[face][1][0], faceVertices[face][2][0]), intArrayOf(
                    faceVertices[face][0][1], faceVertices[face][1][1], faceVertices[face][2][1]
                ), intArrayOf(vertexHeights[0], vertexHeights[1], vertexHeights[2])
            )
            for (vertex in 0 until VERTICES_PER_FACE) {
                val vertexKey = faceVertexKeys[face][vertex]
                // accumulate normals to hashmap
                vertexTerrainNormals.merge(
                    vertexKey,
                    vertexNormals
                ) { a: FloatArray, b: FloatArray -> HDUtils.vectorAdd(b, a) }
            }
        }
    }

    /**
     * Returns the WaterType of the provided SceneTilePaint Tile.
     *
     * @param tile
     * @return the WaterType of the specified Tile
     */
    fun tileWaterType(tile: Tile?, sceneTilePaint: SceneTilePaint?): WaterType {
        if (tile!!.bridge != null) {
            return WaterType.NONE
        }
        val tileZ = tile.renderLevel
        val tileX = tile.sceneLocation.x
        val tileY = tile.sceneLocation.y
        var waterType = WaterType.NONE
        if (sceneTilePaint != null) {
            waterType = if (client.scene.overlayIds[tileZ][tileX][tileY].toInt() != 0) {
                Overlay.getOverlay(
                    client.scene.overlayIds[tileZ][tileX][tileY].toInt(), tile, client
                ).waterType
            } else {
                Underlay.getUnderlay(client.scene.underlayIds[tileZ][tileX][tileY].toInt(), tile, client).waterType
            }
        }
        if (hdPlugin.configWaterEffects == WaterEffects.SIMPLE) {
            when (waterType) {
                WaterType.WATER -> waterType = WaterType.WATER_FLAT
                WaterType.SWAMP_WATER -> waterType = WaterType.SWAMP_WATER_FLAT
                WaterType.POISON_WASTE -> waterType = WaterType.POISON_WASTE_FLAT
                WaterType.ICE -> waterType = WaterType.ICE_FLAT
            }
        }
        return waterType
    }

    /**
     * Returns the WaterType of the provided SceneTileModel Tile's specified face.
     *
     * @param tile
     * @param face the index of the specified face
     * @return
     */
    fun faceWaterType(tile: Tile?, face: Int, sceneTileModel: SceneTileModel?): WaterType {
        if (tile!!.bridge != null) {
            return WaterType.NONE
        }
        val tileZ = tile.renderLevel
        val tileX = tile.sceneLocation.x
        val tileY = tile.sceneLocation.y
        var waterType = WaterType.NONE
        if (sceneTileModel != null) {
            waterType = if (isOverlayFace(tile, face)) {
                Overlay.getOverlay(
                    client.scene.overlayIds[tileZ][tileX][tileY].toInt(), tile, client
                ).waterType
            } else {
                Underlay.getUnderlay(
                    client.scene.underlayIds[tileZ][tileX][tileY].toInt(), tile, client
                ).waterType
            }
        }
        if (hdPlugin.configWaterEffects == WaterEffects.SIMPLE) {
            when (waterType) {
                WaterType.WATER -> waterType = WaterType.WATER_FLAT
                WaterType.SWAMP_WATER -> waterType = WaterType.SWAMP_WATER_FLAT
                WaterType.POISON_WASTE -> waterType = WaterType.POISON_WASTE_FLAT
            }
        }
        return waterType
    }

    var tileOverlayTris = arrayOf(
        booleanArrayOf(true, true, true, true),
        booleanArrayOf(false, true),
        booleanArrayOf(false, false, true),
        booleanArrayOf(false, false, true),
        booleanArrayOf(false, true, true),
        booleanArrayOf(false, true, true),
        booleanArrayOf(false, false, true, true),
        booleanArrayOf(false, false, false, true),
        booleanArrayOf(false, true, true, true),
        booleanArrayOf(false, false, false, true, true, true),
        booleanArrayOf(true, true, true, false, false, false),
        booleanArrayOf(true, true, false, false, false, false)
    )

    fun getTileOverlayTris(tileShapeIndex: Int): BooleanArray {
        return if (tileShapeIndex >= tileOverlayTris.size) {
            //log.debug("getTileOverlayTris(): unknown tileShapeIndex ({})", tileShapeIndex);
            booleanArrayOf(false, false, false, false, false, false, false, false, false, false)
        } else {
            tileOverlayTris[tileShapeIndex]
        }
    }

    fun isOverlayFace(tile: Tile?, face: Int): Boolean {
        val tileShapeIndex = tile!!.sceneTileModel.shape - 1
        return if (face >= getTileOverlayTris(tileShapeIndex).size) {
            false
        } else getTileOverlayTris(tileShapeIndex)[face]
    }

    fun tileVertices(tile: Tile?): Array<IntArray> {
        val x = tile!!.sceneLocation.x
        val y = tile.sceneLocation.y
        val z = tile.renderLevel
        val tileHeights = client.tileHeights
        val swVertex =
            intArrayOf(x * Perspective.LOCAL_TILE_SIZE, y * Perspective.LOCAL_TILE_SIZE, tileHeights[z][x][y])
        val seVertex =
            intArrayOf((x + 1) * Perspective.LOCAL_TILE_SIZE, y * Perspective.LOCAL_TILE_SIZE, tileHeights[z][x + 1][y])
        val nwVertex =
            intArrayOf(x * Perspective.LOCAL_TILE_SIZE, (y + 1) * Perspective.LOCAL_TILE_SIZE, tileHeights[z][x][y + 1])
        val neVertex = intArrayOf(
            (x + 1) * Perspective.LOCAL_TILE_SIZE,
            (y + 1) * Perspective.LOCAL_TILE_SIZE,
            tileHeights[z][x + 1][y + 1]
        )
        return arrayOf(swVertex, seVertex, nwVertex, neVertex)
    }

    fun faceVertices(tile: Tile?, face: Int): Array<IntArray> {
        val sceneTileModel = tile!!.sceneTileModel
        val faceA = sceneTileModel.faceX
        val faceB = sceneTileModel.faceY
        val faceC = sceneTileModel.faceZ
        val vertexX = sceneTileModel.vertexX
        val vertexY = sceneTileModel.vertexY
        val vertexZ = sceneTileModel.vertexZ
        val vertexFacesA = faceA[face]
        val vertexFacesB = faceB[face]
        val vertexFacesC = faceC[face]

        // scene X
        val sceneVertexXA = vertexX[vertexFacesA]
        val sceneVertexXB = vertexX[vertexFacesB]
        val sceneVertexXC = vertexX[vertexFacesC]
        // scene Y
        val sceneVertexZA = vertexZ[vertexFacesA]
        val sceneVertexZB = vertexZ[vertexFacesB]
        val sceneVertexZC = vertexZ[vertexFacesC]
        // scene Z - heights
        val sceneVertexYA = vertexY[vertexFacesA]
        val sceneVertexYB = vertexY[vertexFacesB]
        val sceneVertexYC = vertexY[vertexFacesC]
        val vertexA = intArrayOf(sceneVertexXA, sceneVertexZA, sceneVertexYA)
        val vertexB = intArrayOf(sceneVertexXB, sceneVertexZB, sceneVertexYB)
        val vertexC = intArrayOf(sceneVertexXC, sceneVertexZC, sceneVertexYC)
        return arrayOf(vertexA, vertexB, vertexC)
    }

    fun tileLocalVertices(tile: Tile): Array<IntArray> {
        val x = tile.sceneLocation.x
        val y = tile.sceneLocation.y
        val z = tile.renderLevel
        val tileHeights = client.tileHeights
        val swVertex = intArrayOf(0, 0, tileHeights[z][x][y])
        val seVertex = intArrayOf(Perspective.LOCAL_TILE_SIZE, 0, tileHeights[z][x + 1][y])
        val nwVertex = intArrayOf(0, Perspective.LOCAL_TILE_SIZE, tileHeights[z][x][y + 1])
        val neVertex =
            intArrayOf(Perspective.LOCAL_TILE_SIZE, Perspective.LOCAL_TILE_SIZE, tileHeights[z][x + 1][y + 1])
        return arrayOf(swVertex, seVertex, nwVertex, neVertex)
    }

    fun faceLocalVertices(tile: Tile, face: Int): Array<IntArray> {
        val x = tile.sceneLocation.x
        val y = tile.sceneLocation.y
        val baseX = x * Perspective.LOCAL_TILE_SIZE
        val baseY = y * Perspective.LOCAL_TILE_SIZE
        if (tile.sceneTileModel == null) {
            return Array(0) { IntArray(0) }
        }
        val sceneTileModel = tile.sceneTileModel
        val faceA = sceneTileModel.faceX
        val faceB = sceneTileModel.faceY
        val faceC = sceneTileModel.faceZ
        val vertexX = sceneTileModel.vertexX
        val vertexY = sceneTileModel.vertexY
        val vertexZ = sceneTileModel.vertexZ
        val vertexFacesA = faceA[face]
        val vertexFacesB = faceB[face]
        val vertexFacesC = faceC[face]

        // scene X
        val sceneVertexXA = vertexX[vertexFacesA]
        val sceneVertexXB = vertexX[vertexFacesB]
        val sceneVertexXC = vertexX[vertexFacesC]
        // scene Y
        val sceneVertexZA = vertexZ[vertexFacesA]
        val sceneVertexZB = vertexZ[vertexFacesB]
        val sceneVertexZC = vertexZ[vertexFacesC]
        // scene Z - heights
        val sceneVertexYA = vertexY[vertexFacesA]
        val sceneVertexYB = vertexY[vertexFacesB]
        val sceneVertexYC = vertexY[vertexFacesC]
        val vertexA = intArrayOf(sceneVertexXA - baseX, sceneVertexZA - baseY, sceneVertexYA)
        val vertexB = intArrayOf(sceneVertexXB - baseX, sceneVertexZB - baseY, sceneVertexYB)
        val vertexC = intArrayOf(sceneVertexXC - baseX, sceneVertexZC - baseY, sceneVertexYC)
        return arrayOf(vertexA, vertexB, vertexC)
    }

    /**
     * Gets the vertex keys of a Tile Paint tile for use in retrieving data from hashmaps.
     *
     * @param tile
     * @return Vertex keys in following order: SW, SE, NW, NE
     */
    fun tileVertexKeys(tile: Tile?): IntArray {
        val tileVertices = tileVertices(tile)
        val vertexHashes = IntArray(tileVertices.size)
        for (vertex in tileVertices.indices) {
            vertexHashes[vertex] = HDUtils.vertexHash(tileVertices[vertex])
        }
        return vertexHashes
    }

    fun faceVertexKeys(tile: Tile?, face: Int): IntArray {
        val faceVertices = faceVertices(tile, face)
        val vertexHashes = IntArray(faceVertices.size)
        for (vertex in faceVertices.indices) {
            vertexHashes[vertex] = HDUtils.vertexHash(faceVertices[vertex])
        }
        return vertexHashes
    }

    fun recolorOverlay(overlay: Overlay, colorHSL: IntArray): IntArray {
        colorHSL[0] = if (overlay.hue >= 0) overlay.hue else colorHSL[0]
        colorHSL[0] += overlay.shiftHue
        colorHSL[0] = Ints.constrainToRange(colorHSL[0], 0, 63)
        colorHSL[1] = if (overlay.saturation >= 0) overlay.saturation else colorHSL[1]
        colorHSL[1] += overlay.shiftSaturation
        colorHSL[1] = Ints.constrainToRange(colorHSL[1], 0, 7)
        colorHSL[2] = if (overlay.lightness >= 0) overlay.lightness else colorHSL[2]
        colorHSL[2] += overlay.shiftLightness
        colorHSL[2] = Ints.constrainToRange(colorHSL[2], 0, 127)
        return colorHSL
    }

    fun recolorUnderlay(underlay: Underlay, colorHSL: IntArray): IntArray {
        colorHSL[0] = if (underlay.hue >= 0) underlay.hue else colorHSL[0]
        colorHSL[0] += underlay.shiftHue
        colorHSL[0] = Ints.constrainToRange(colorHSL[0], 0, 63)
        colorHSL[1] = if (underlay.saturation >= 0) underlay.saturation else colorHSL[1]
        colorHSL[1] += underlay.shiftSaturation
        colorHSL[1] = Ints.constrainToRange(colorHSL[1], 0, 7)
        colorHSL[2] = if (underlay.lightness >= 0) underlay.lightness else colorHSL[2]
        colorHSL[2] += underlay.shiftLightness
        colorHSL[2] = Ints.constrainToRange(colorHSL[2], 0, 127)
        return colorHSL
    }

    fun useDefaultColor(tile: Tile?): Boolean {
        val z = tile!!.renderLevel
        val x = tile.sceneLocation.x
        val y = tile.sceneLocation.y
        if (!hdPlugin.configGroundBlending || tile.sceneTilePaint != null && tile.sceneTilePaint.texture >= 0 ||
            tile.sceneTileModel != null && tile.sceneTileModel.triangleTextureId != null
        ) {
            // skip tiles with textures provided by default
            return true
        }
        if (client.scene.overlayIds[z][x][y].toInt() != 0) {
            if (!Overlay.getOverlay(client.scene.overlayIds[z][x][y].toInt(), tile, client).blended) {
                return true
            }
        } else if (client.scene.underlayIds[z][x][y].toInt() != 0) {
            if (!Underlay.getUnderlay(client.scene.underlayIds[z][x][y].toInt(), tile, client).blended) {
                return true
            }
        }
        return false
    }

    var tzHaarRecolored = Array(4) { IntArray(3) }

    // used when calculating the gradient to apply to the walls of TzHaar
    // to emulate the style from 2008 HD rework
    val gradientBaseColor = intArrayOf(3, 4, 26)
    val gradientDarkColor = intArrayOf(3, 4, 10)
    val gradientBottom = 200
    val gradientTop = -200
    fun recolorTzHaar(
        objectProperties: ObjectProperties,
        aY: Int,
        bY: Int,
        cY: Int,
        packedAlphaPriority: Int,
        objectType: ObjectType,
        color1H: Int,
        color1S: Int,
        color1L: Int,
        color2H: Int,
        color2S: Int,
        color2L: Int,
        color3H: Int,
        color3S: Int,
        color3L: Int
    ): Array<IntArray> {
        // recolor tzhaar to look like the 2008+ HD version
        var packedAlphaPriority = packedAlphaPriority
        var color1H = color1H
        var color1S = color1S
        var color1L = color1L
        var color2H = color2H
        var color2S = color2S
        var color2L = color2L
        var color3H = color3H
        var color3S = color3S
        var color3L = color3L
        if (objectType == ObjectType.GROUND_OBJECT) {
            // remove the black parts of floor objects to allow the ground to show
            // so we can apply textures, ground blending, etc. to it
            if (color1S <= 1) {
                packedAlphaPriority = 0xFF shl 24
            }
        }

        // shift model hues from red->yellow
        val hue = 7
        color1H = hue
        color2H = hue
        color3H = hue
        if (objectProperties.tzHaarRecolorType == TzHaarRecolorType.GRADIENT) {
            // apply coloring to the rocky walls
            if (color1L < 20) {
                val pos = Floats.constrainToRange((aY - gradientTop).toFloat() / gradientBottom.toFloat(), 0.0f, 1.0f)
                color1H = HDUtils.lerp(gradientDarkColor[0].toFloat(), gradientBaseColor[0].toFloat(), pos).toInt()
                color1S = HDUtils.lerp(gradientDarkColor[1].toFloat(), gradientBaseColor[1].toFloat(), pos).toInt()
                color1L = HDUtils.lerp(gradientDarkColor[2].toFloat(), gradientBaseColor[2].toFloat(), pos).toInt()
            }
            if (color2L < 20) {
                val pos = Floats.constrainToRange((bY - gradientTop).toFloat() / gradientBottom.toFloat(), 0.0f, 1.0f)
                color2H = HDUtils.lerp(gradientDarkColor[0].toFloat(), gradientBaseColor[0].toFloat(), pos).toInt()
                color2S = HDUtils.lerp(gradientDarkColor[1].toFloat(), gradientBaseColor[1].toFloat(), pos).toInt()
                color2L = HDUtils.lerp(gradientDarkColor[2].toFloat(), gradientBaseColor[2].toFloat(), pos).toInt()
            }
            if (color3L < 20) {
                val pos = Floats.constrainToRange((cY - gradientTop).toFloat() / gradientBottom.toFloat(), 0.0f, 1.0f)
                color3H = HDUtils.lerp(gradientDarkColor[0].toFloat(), gradientBaseColor[0].toFloat(), pos).toInt()
                color3S = HDUtils.lerp(gradientDarkColor[1].toFloat(), gradientBaseColor[1].toFloat(), pos).toInt()
                color3L = HDUtils.lerp(gradientDarkColor[2].toFloat(), gradientBaseColor[2].toFloat(), pos).toInt()
            }
        } else if (objectProperties.tzHaarRecolorType == TzHaarRecolorType.HUE_SHIFT) {
            // objects around the entrance to The Inferno only need a hue-shift
            // and very slight lightening to match the lightened terrain
            color1L += 1
            color2L += 1
            color3L += 1
        }
        tzHaarRecolored[0][0] = color1H
        tzHaarRecolored[0][1] = color1S
        tzHaarRecolored[0][2] = color1L
        tzHaarRecolored[1][0] = color2H
        tzHaarRecolored[1][1] = color2S
        tzHaarRecolored[1][2] = color2L
        tzHaarRecolored[2][0] = color3H
        tzHaarRecolored[2][1] = color3S
        tzHaarRecolored[2][2] = color3L
        tzHaarRecolored[3][0] = packedAlphaPriority
        return tzHaarRecolored
    }
}