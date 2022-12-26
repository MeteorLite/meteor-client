/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
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
package meteor.hiscore

import com.google.common.cache.CacheBuilder
import com.google.common.cache.LoadingCache
import com.google.common.collect.ImmutableMap
import meteor.Main
import java.io.IOException
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

object HiscoreManager {
    private val hiscoreClient: HiscoreClient = HiscoreClient()
    private val executor: ScheduledExecutorService = Main.executor
    internal class HiscoreKey(var username: String, var type: HiscoreEndpoint)
    val EMPTY = HiscoreResult(null, ImmutableMap.of())
    val NONE = HiscoreResult(null, ImmutableMap.of())

    private val hiscoreCache: LoadingCache<HiscoreKey, HiscoreResult> = CacheBuilder.newBuilder()
        .maximumSize(128L)
        .expireAfterWrite(1, TimeUnit.HOURS)
        .build(HiscoreLoader(executor, hiscoreClient))

    /**
     * Synchronously look up a players hiscore from a specified endpoint
     *
     * @param username Players username
     * @param endpoint Hiscore endpoint
     * @return HiscoreResult or null
     * @throws IOException Upon error in fetching hiscore
     */
    @Throws(IOException::class)
    fun lookup(username: String, endpoint: HiscoreEndpoint): HiscoreResult? {
        val hiscoreKey = HiscoreKey(username, endpoint)
        var hiscoreResult = hiscoreCache.getIfPresent(hiscoreKey)
        if (hiscoreResult != null && hiscoreResult !== EMPTY) {
            return if (hiscoreResult === NONE) null else hiscoreResult
        }
        hiscoreResult = hiscoreClient.lookup(username, endpoint)
        if (hiscoreResult == null) {
            hiscoreCache.put(hiscoreKey, NONE)
            return null
        }
        hiscoreCache.put(hiscoreKey, hiscoreResult)
        return hiscoreResult
    }

    /**
     * Asynchronously look up a players hiscore from a specified endpoint
     *
     * @param username Players username
     * @param endpoint Hiscore endpoint
     * @return HiscoreResult or null
     */
    fun lookupAsync(username: String, endpoint: HiscoreEndpoint): HiscoreResult? {
        val hiscoreKey = HiscoreKey(username, endpoint)
        val hiscoreResult = hiscoreCache.getIfPresent(hiscoreKey)
        if (hiscoreResult != null && hiscoreResult !== EMPTY) {
            return if (hiscoreResult === NONE) null else hiscoreResult
        }
        hiscoreCache.refresh(hiscoreKey)
        return null
    }
}