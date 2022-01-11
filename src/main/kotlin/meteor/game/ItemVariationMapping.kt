/*
 * Copyright (c) 2018, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
package meteor.game

import com.google.common.collect.ImmutableMap
import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.Multimap
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets

/**
 * Converts variation items to it's base item counterparts
 */
object ItemVariationMapping {
    private var MAPPINGS: Map<Int, Int>? = null
    private var INVERTED_MAPPINGS: Multimap<Int, Int>? = null

    init {
        val gson = Gson()
        val typeToken: TypeToken<Map<String?, Collection<Int?>?>> = object : TypeToken<Map<String?, Collection<Int?>?>>() {}
        val geLimitData = ItemVariationMapping::class.java
                .getResourceAsStream("/item_variations.json")
        val itemVariations: Map<String, Collection<Int>> = gson
                .fromJson(InputStreamReader(geLimitData, StandardCharsets.UTF_8), typeToken.type)
        val builder = ImmutableMap.Builder<Int, Int>()
        val invertedBuilder = ImmutableMultimap.Builder<Int, Int>()
        for (value in itemVariations.values) {
            val iterator: Iterator<Int> = value.iterator()
            val base: Int = iterator.next()
            while (iterator.hasNext()) {
                val id: Int = iterator.next()
                builder.put(id, base)
                invertedBuilder.put(base, id)
            }
            invertedBuilder.put(base, base)
        }
        INVERTED_MAPPINGS = invertedBuilder.build()
        MAPPINGS = builder.build()
    }

    /**
     * Get base item id for provided variation item id.
     *
     * @param itemId the item id
     * @return the base item id
     */
    fun map(itemId: Int): Int {
        return MAPPINGS!![itemId] ?: itemId
    }

    /**
     * Get item ids for provided variation item id.
     *
     * @param itemId the item id
     * @return the item ids
     */
    fun getVariations(itemId: Int): Collection<Int> {
        return INVERTED_MAPPINGS!!.asMap().getOrDefault(itemId, listOf(itemId))
    }
}