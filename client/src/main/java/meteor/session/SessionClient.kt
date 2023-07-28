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
package meteor.session

import com.google.gson.JsonParseException
import meteor.Logger
import meteor.Main.httpClient
import net.runelite.http.api.RuneLiteAPI
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull

import okhttp3.Request
import okhttp3.RequestBody
import java.io.IOException
import java.io.InputStreamReader
import java.net.SocketTimeoutException
import java.nio.charset.StandardCharsets
import java.util.*

internal class SessionClient {
    private val client = httpClient
    private var sessionUrl = RuneLiteAPI.getSessionBase()
    private val log = Logger("Session")
    @Throws(IOException::class)
    fun open(): UUID {
        val url = sessionUrl.newBuilder()
                .addPathSegment("new")
                .build()
        val request: Request = Request.Builder()
                .post(RequestBody.create(null, ByteArray(0)))
                .url(url)
                .build()
        try {
            log.warn("Built URI: $url")
            client.newCall(request).execute().use { response ->
                val body = response.body
                val `in` = body?.byteStream()
                return RuneLiteAPI.GSON.fromJson(InputStreamReader(`in`, StandardCharsets.UTF_8), UUID::class.java)
            }
        } catch (ex: JsonParseException) // UUID.fromString can throw IllegalArgumentException
        {
            throw IOException(ex)
        } catch (ex: IllegalArgumentException) {
            throw IOException(ex)
        } catch (ste: SocketTimeoutException) {
            throw ste
        }
    }

    @Throws(IOException::class)
    fun ping(uuid: UUID) {
        val url = sessionUrl.newBuilder()
                .addPathSegment("ping")
                .addQueryParameter("uuid", uuid.toString())
                .build()
        val request: Request = Request.Builder()
                .post(RequestBody.create(null, ByteArray(0)))
                .url(url)
                .build()
        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) {
                throw IOException("Unsuccessful ping")
            }
        }
    }
}