/*
 * Copyright (c) 2022, Adam <Adam@sigterm.info>
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
package meteor

import net.runelite.http.api.RuneLiteAPI
import okhttp3.*
import java.io.IOException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException
import java.util.function.Supplier

object RuntimeConfigLoader : Supplier<RuntimeConfig?> {
    val configFuture: CompletableFuture<RuntimeConfig>

    init {
        configFuture = fetch()
    }

    override fun get(): RuntimeConfig? {
        return try {
            configFuture.get()
        } catch (e: InterruptedException) {
            Logger("runtime").error("error fetching runtime config", e)
            null
        } catch (e: ExecutionException) {
            Logger("runtime").error("error fetching runtime config", e)
            null
        }
    }

    fun tryGet(): RuntimeConfig? {
        return try {
            configFuture[0, TimeUnit.SECONDS]
        } catch (e: InterruptedException) {
            null
        } catch (e: ExecutionException) {
            null
        } catch (e: TimeoutException) {
            null
        }
    }

    private fun fetch(): CompletableFuture<RuntimeConfig> {
        val future = CompletableFuture<RuntimeConfig>()
        val request: Request = Request.Builder()
                .url("https://static.runelite.net/config.json")
                .build()
        RuneLiteAPI.CLIENT.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                future.completeExceptionally(e)
            }

            override fun onResponse(call: Call, response: Response) {
                try  // NOPMD: UseTryWithResources
                {
                    val config = RuneLiteAPI.GSON.fromJson(response.body.charStream(), RuntimeConfig::class.java)
                    future.complete(config)
                } catch (ex: Throwable) {
                    future.completeExceptionally(ex)
                } finally {
                    response.close()
                }
            }
        })
        return future
    }
}