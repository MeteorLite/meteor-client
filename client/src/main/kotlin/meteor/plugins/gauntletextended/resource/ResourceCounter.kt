/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
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
package meteor.plugins.gauntletextended.resource

import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import java.awt.image.BufferedImage
import meteor.ui.overlay.infobox.InfoBoxPriority
import net.runelite.client.Counter

internal class ResourceCounter(
    plugin: GauntletExtendedPlugin?,
    private val resource: Resource,
    bufferedImage: BufferedImage?,
    count: Int
) : Counter(bufferedImage, plugin, count) {
    override var text = count.toString()

    init {
        this.count = count
        priority = getPriority(resource)
    }

    fun incrementCount(count: Int) {
        this.count += Math.max(0, count)
        text = this.count.toString()
    }

    fun decrementCount(count: Int) {
        this.count -= Math.max(0, count)
        text = this.count.toString()
    }

    companion object {
        private fun getPriority(resource: Resource): InfoBoxPriority {
            return when (resource) {
                Resource.CRYSTAL_ORE, Resource.CORRUPTED_ORE, Resource.PHREN_BARK, Resource.CORRUPTED_PHREN_BARK, Resource.LINUM_TIRINUM, Resource.CORRUPTED_LINUM_TIRINUM -> InfoBoxPriority.HIGH
                Resource.GRYM_LEAF, Resource.CORRUPTED_GRYM_LEAF -> InfoBoxPriority.MED
                Resource.CRYSTAL_SHARDS, Resource.CORRUPTED_SHARDS, Resource.RAW_PADDLEFISH -> InfoBoxPriority.NONE
                else -> InfoBoxPriority.LOW
            }
        }
    }
}