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

import com.google.common.base.Strings
import com.google.common.cache.CacheLoader
import meteor.util.WildcardMatcher.matches
import java.util.*
import java.util.stream.Collectors
import javax.annotation.Nonnull

internal class WildcardMatchLoader(configEntries: List<String?>) : CacheLoader<NamedQuantity, Boolean>() {
    private val itemThresholds: MutableList<ItemThreshold>
    override fun load(@Nonnull key: NamedQuantity): Boolean {
        if (Strings.isNullOrEmpty(key.name)) {
            return false
        }
        val filteredName = key.name.trim { it <= ' ' }
        for (entry in itemThresholds) {
            if (matches(entry.itemName, filteredName)
                && entry.quantity == (key.quantity)
            ) {
                return true
            }
        }
        return false
    }

    init {
        itemThresholds = configEntries.stream()
            .map { entry: String? -> ItemThreshold.fromConfigEntry(entry!!) }
            .filter { obj: ItemThreshold? -> Objects.nonNull(obj) }
            .collect(Collectors.toList())
    }
}