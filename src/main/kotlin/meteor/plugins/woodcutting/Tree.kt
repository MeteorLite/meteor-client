/*
 * Copyright (c) 2018, Mantautas Jurksa <https://github.com/Juzzed>
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

import com.google.common.collect.ImmutableMap

import net.runelite.api.NullObjectID
import net.runelite.api.ObjectID
import java.time.Duration

enum class Tree(val respawnTime: Duration?, vararg val treeIds: Int) {
    REGULAR_TREE(
        null,
        ObjectID.TREE,
        ObjectID.TREE_1277,
        ObjectID.TREE_1278,
        ObjectID.TREE_1279,
        ObjectID.TREE_1280
    ),
    OAK_TREE(
        Duration.ofMillis(8500), ObjectID.OAK_TREE, ObjectID.OAK_TREE_4540, ObjectID.OAK_10820
    ),
    WILLOW_TREE(
        Duration.ofMillis(8500),
        ObjectID.WILLOW,
        ObjectID.WILLOW_10829,
        ObjectID.WILLOW_10831,
        ObjectID.WILLOW_10833
    ),
    MAPLE_TREE(
        Duration.ofSeconds(35), ObjectID.MAPLE_TREE, ObjectID.MAPLE_TREE_10832, ObjectID.MAPLE_TREE_36681
    ) {
        override fun getRespawnTime(region: Int): Duration? {
            return if (region == MISCELLANIA_REGION) Duration.ofMillis(8500) else super.respawnTime
        }
    },
    TEAK_TREE(Duration.ofMillis(8500), ObjectID.TEAK, ObjectID.TEAK_36686), MAHOGANY_TREE(
        Duration.ofMillis(8500),
        ObjectID.MAHOGANY,
        ObjectID.MAHOGANY_36688
    ),
    YEW_TREE(
        Duration.ofMinutes(1), ObjectID.YEW, NullObjectID.NULL_10823, ObjectID.YEW_36683
    ),
    MAGIC_TREE(Duration.ofMinutes(2), ObjectID.MAGIC_TREE_10834, NullObjectID.NULL_10835), REDWOOD(
        Duration.ofMinutes(2), ObjectID.REDWOOD, ObjectID.REDWOOD_29670
    );

    open fun getRespawnTime(region: Int): Duration? {
        return respawnTime
    }

    companion object {
        private const val MISCELLANIA_REGION = 10044
        private var TREES: Map<Int, Tree>? = null

        init {
            val builder = ImmutableMap.Builder<Int, Tree>()
            for (tree in values()) {
                for (treeId in tree.treeIds) {
                    builder.put(
                        treeId,
                        tree
                    )
                }
            }
            TREES = builder.build()
        }

        fun findTree(objectId: Int): Tree? {
            return TREES!![objectId]
        }
    }
}