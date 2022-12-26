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

import com.google.common.cache.CacheLoader
import com.google.common.util.concurrent.ListenableFuture
import com.google.common.util.concurrent.ListeningExecutorService
import com.google.common.util.concurrent.MoreExecutors
import meteor.hiscore.HiscoreManager.HiscoreKey
import java.io.IOException
import java.util.concurrent.ScheduledExecutorService

internal class HiscoreLoader(executor: ScheduledExecutorService?, client: HiscoreClient) :
    CacheLoader<HiscoreKey, HiscoreResult>() {
    private val executorService: ListeningExecutorService
    private val hiscoreClient: HiscoreClient

    init {
        executorService = MoreExecutors.listeningDecorator(executor)
        hiscoreClient = client
    }

    @Throws(Exception::class)
    override fun load(hiscoreKey: HiscoreKey): HiscoreResult {
        return HiscoreManager.EMPTY
    }

    override fun reload(hiscoreKey: HiscoreKey, oldValue: HiscoreResult): ListenableFuture<HiscoreResult> {
        //log.debug("Submitting hiscore lookup for {} type {}", hiscoreKey.getUsername(), hiscoreKey.getType());
        return executorService.submit<HiscoreResult> { fetch(hiscoreKey) }
    }

    private fun fetch(hiscoreKey: HiscoreKey): HiscoreResult {
        val username = hiscoreKey.username
        val endpoint = hiscoreKey.type
        return try {
            val result = hiscoreClient.lookup(username, endpoint) ?: return HiscoreManager.NONE
            result
        } catch (ex: IOException) {
            //log.warn("Unable to look up hiscore!", ex);
            HiscoreManager.NONE
        }
    }
}