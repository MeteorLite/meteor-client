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
package meteor.util

import net.runelite.http.api.worlds.WorldType
import java.util.*

/**
 * Utility class for RuneScape worlds
 */
object WorldUtil {
    /**
     * Converts http-api world types to runelite-api world types
     * TODO: Find a better way to handle these to not have duplicate interfaces
     * @param apiTypes http-api world types
     * @return runelite-api world types
     */
    fun toWorldTypes(apiTypes: EnumSet<WorldType>): EnumSet<net.runelite.api.WorldType> {
        val types = EnumSet.noneOf(net.runelite.api.WorldType::class.java)
        for (apiType in apiTypes) {
            if (apiType == WorldType.TOURNAMENT) {
                types.add(net.runelite.api.WorldType.TOURNAMENT_WORLD)
                continue
            }
            types.add(net.runelite.api.WorldType.valueOf(apiType.name))
        }
        return types
    }
}