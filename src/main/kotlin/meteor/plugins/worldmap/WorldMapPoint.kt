/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
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
package meteor.plugins.worldmap
import net.runelite.api.Point
import net.runelite.api.coords.WorldPoint
import java.awt.image.BufferedImage

open class WorldMapPoint() {
    var worldPoint: WorldPoint? = null
    var image: BufferedImage ?= null
    var type: MapPoint.Type? = null
    private var fishingPoint: FishingSpotLocation? = null
    /**
     * The WorldPoint which the worldmap will jump to when clicked
     */
    var target: WorldPoint? = null

    /**
     * The point on the image that will be drawn at WorldPoint WorldMapPointManager will center the
     * image if imagePoint is null
     */
    var imagePoint: Point? = null
    var snapToEdge = false
    var currentlyEdgeSnapped = false

    /**
     * Whether or not the map jumps to target, or worldPoint when the overlay is clicked
     */
    var jumpOnClick = false

    /**
     * Name in menu option when [.jumpOnClick] is set
     */
    var name: String? = null
    var tooltip: String? = null
    fun onEdgeSnap() {}
    fun onEdgeUnsnap() {}


    fun image(i: BufferedImage) : WorldMapPoint {
        image = i
        return this
    }

    fun type(m: MapPoint.Type) : WorldMapPoint {
        type = m
        return this
    }

    fun worldPoint(w: WorldPoint) : WorldMapPoint {
        worldPoint = w
        return this
    }

    fun tooltip(s: String?) : WorldMapPoint {
        tooltip = s
        return this
    }

    fun fishingPoint(f: FishingSpotLocation) : WorldMapPoint {
        fishingPoint = f
        return this
    }

    fun target(w: WorldPoint) : WorldMapPoint {
        target = w
        return this
    }

    fun jumpOnClick(b: Boolean) : WorldMapPoint {
        jumpOnClick = b
        return this
    }

    fun name(s: String) : WorldMapPoint {
        name = s
        return this
    }

    fun build() : WorldMapPoint {
        return this
    }

    companion object {
        fun builder(): WorldMapPoint {
            return WorldMapPoint()
        }
    }
}