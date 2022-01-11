/*
 * Copyright (c) 2018, Tomas Slusny <slusnucky@gmail.com>
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
package meteor.plugins.grounditems

import net.runelite.api.coords.WorldPoint
import java.time.Instant
import javax.annotation.Nonnull

class GroundItem() {
    var id = 0
    var itemId = 0
    var name: String? = null
    var quantity = 0
    var location: WorldPoint? = null
    var height = 0
    var haPrice = 0
        get() = field * quantity
    var gePrice = 0
        get() = field * quantity
    var offset = 0
    var tradeable = false

    var lootType: LootType? = null
    var spawnTime: Instant? = null
    var stackable = false
    val isMine: Boolean
        get() = lootType !== LootType.UNKNOWN

    class GroundItemBuilder {
        private lateinit var groundItem: GroundItem
        fun builder() : GroundItemBuilder {
            val builder = GroundItemBuilder()
            builder.groundItem = GroundItem()
            return builder
        }
        fun id(i: Int) : GroundItemBuilder {
            groundItem.id = i
            return this
        }
        fun location(l: WorldPoint) : GroundItemBuilder {
            groundItem.location = l
            return this
        }
        fun itemId(i: Int) : GroundItemBuilder {
            groundItem.itemId = i
            return this
        }
        fun quantity(i: Int) : GroundItemBuilder {
            groundItem.quantity = i
            return this
        }
        fun name(s: String) : GroundItemBuilder {
            groundItem.name = s
            return this
        }
        fun haPrice(i: Int) : GroundItemBuilder {
            groundItem.haPrice = i
            return this
        }
        fun height(i: Int) : GroundItemBuilder {
            groundItem.height = i
            return this
        }
        fun tradeable(b: Boolean) : GroundItemBuilder {
            groundItem.tradeable = b
            return this
        }
        fun lootType(l: LootType) : GroundItemBuilder {
            groundItem.lootType = l
            return this
        }
        fun spawnTime(i: Instant) : GroundItemBuilder {
            groundItem.spawnTime = i
            return this
        }
        fun stackable(b: Boolean) : GroundItemBuilder {
            groundItem.stackable = b
            return this
        }
        fun gePrice(i: Int) : GroundItemBuilder {
            groundItem.gePrice = i
            return this
        }
        fun build() : GroundItem {
            return groundItem
        }
    }
}