/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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

import com.google.common.annotations.VisibleForTesting
import com.google.common.base.CharMatcher
import com.google.common.base.Splitter
import com.google.common.collect.ImmutableMap
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import meteor.Main.httpClient
import meteor.Main.logger
import meteor.util.RuntimeConfigLoader.get
import okhttp3.*
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.function.Function
import java.util.stream.Collectors
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HiscoreClient @Inject constructor() {
    private val client = httpClient
    private val mappings: Map<HiscoreEndpoint, List<HiscoreSkill>?>
    private val runtimeConfig = get()
    private val gson = GsonBuilder().setPrettyPrinting().create()

    init {
        val strMapping = loadDiskMappings(gson)
        if (runtimeConfig?.hiscoreMapping != null) {
            strMapping.putAll(runtimeConfig.hiscoreMapping!!)
        }
        mappings = convertMappings(strMapping, false)
    }

    @JvmOverloads
    @Throws(IOException::class)
    fun lookup(username: String?, endpoint: HiscoreEndpoint = HiscoreEndpoint.NORMAL): HiscoreResult? {
        return lookup(username, endpoint, endpoint.hiscoreURL)
    }

    @VisibleForTesting
    @Throws(IOException::class)
    fun lookup(username: String?, endpoint: HiscoreEndpoint, url: HttpUrl): HiscoreResult? {
        client.newCall(buildRequest(username, url)).execute()
            .use { response -> return processResponse(username, endpoint, response) }
    }

    fun lookupAsync(username: String?, endpoint: HiscoreEndpoint): CompletableFuture<HiscoreResult?> {
        val future = CompletableFuture<HiscoreResult?>()
        client.newCall(buildRequest(username, endpoint.hiscoreURL)).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                future.completeExceptionally(e)
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                try  // NOPMD: UseTryWithResources
                {
                    future.complete(processResponse(username, endpoint, response))
                } finally {
                    response.close()
                }
            }
        })
        return future
    }

    @Throws(IOException::class)
    private fun processResponse(username: String?, endpoint: HiscoreEndpoint, response: Response): HiscoreResult? {
        if (!response.isSuccessful) {
            if (response.code == 404) {
                return null
            }
            throw IOException("Error retrieving data from Jagex Hiscores: $response")
        }
        val responseStr = response.body.string()
        val skills = ImmutableMap.builder<HiscoreSkill, Skill>()
        val map = mappings[endpoint]!!.iterator()
        for (line in NEWLINE_SPLITTER.split(responseStr)) {
            if (!map.hasNext()) {
                logger.warn("{} returned extra data", endpoint)
                break
            }
            val skill = map.next() ?: continue
            val record = COMMA_SPLITTER.splitToList(line)
            try {
                val rank = record[0].toInt()
                val level = record[1].toInt()
                var experience: Long = -1
                if (record.size == 3) {
                    experience = record[2].toLong()
                }
                skills.put(skill, Skill(rank, level, experience))
            } catch (e: Exception) {
                logger.warn("invalid hiscore line \"{}\"", line, e)
            }
        }
        if (map.hasNext()) {
            logger.warn("{} returned less data than expected ({} expected next)", endpoint, map.next())
        }
        return HiscoreResult(username!!, skills.build())
    }

    companion object {
        private val NEWLINE_SPLITTER = Splitter.on(CharMatcher.anyOf("\r\n")).omitEmptyStrings()
        private val COMMA_SPLITTER = Splitter.on(',').trimResults()
        @VisibleForTesting
        fun loadDiskMappings(gson: Gson): MutableMap<String, List<String>> {
            try {
                HiscoreClient::class.java.getResourceAsStream("mappings.json").use { `is` ->
                    return gson.fromJson(
                        InputStreamReader(`is`, StandardCharsets.UTF_8),
                        object : TypeToken<Map<String?, List<String?>?>?>() {}.type
                    )
                }
            } catch (e: IOException) {
                throw RuntimeException(e)
            }
        }

        @VisibleForTesting
        fun convertMappings(
            strMapping: Map<String, List<String>>,
            strict: Boolean
        ): Map<HiscoreEndpoint, List<HiscoreSkill>?> {
            val entries: MutableMap<String, List<HiscoreSkill>> = HashMap()
            for ((key, value) in strMapping) {
                entries[key] = Collections.unmodifiableList(value.stream()
                    .map { name: String? ->
                        try {
                            return@map HiscoreSkill.valueOf(name!!)
                        } catch (ex: IllegalArgumentException) {
                            //log.warn("invalid skill {}", name, ex);
                            if (strict) {
                                throw ex
                            }
                            return@map null
                        }
                    }.collect(Collectors.toList())
                )
            }
            val out: Map<HiscoreEndpoint, List<HiscoreSkill>?> = Arrays.stream(HiscoreEndpoint.values())
                .collect(
                    ImmutableMap.toImmutableMap(
                        Function.identity(),
                        Function { endpoint: HiscoreEndpoint ->
                            var map = entries.remove(endpoint.name)
                            if (map == null) {
                                map = entries["default"]
                            }
                            map
                        })
                )
            entries.remove("default")
            if (strict && !entries.isEmpty()) {
                logger.warn("invalid endpoint {}", entries.keys)
                throw IllegalArgumentException("invalid entrypoints")
            }
            return out
        }

        private fun buildRequest(username: String?, hiscoreUrl: HttpUrl): Request {
            val url = hiscoreUrl.newBuilder()
                .addQueryParameter("player", username)
                .build()
            logger.warn("Built URL {}", url)
            return Request.Builder()
                .url(url)
                .build()
        }
    }
}