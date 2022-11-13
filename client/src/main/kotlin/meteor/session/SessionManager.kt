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

import meteor.Logger
import meteor.Main
import meteor.Main.executor
import meteor.util.RunnableExceptionLogger.Companion.wrap
import net.runelite.api.Client
import net.runelite.api.GameState
import java.io.IOException
import java.util.*
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ScheduledFuture
import java.util.concurrent.TimeUnit

object SessionManager {
    private val executorService: ScheduledExecutorService = executor
    private val client = Main.client
    private val sessionClient = SessionClient()
    private val log = Logger("Session")
    private var scheduledFuture: ScheduledFuture<*>? = null
    private var sessionId: UUID? = null

    fun start() {
        executorService.execute {
            try {
                sessionId = sessionClient.open()
                log.debug("Opened session {}", sessionId!!)
            } catch (ex: IOException) {
                log.warn("error opening session", ex)
            }
        }
        scheduledFuture = executorService.scheduleWithFixedDelay(wrap { ping() }, 1, 10, TimeUnit.MINUTES)
    }

    private fun ping() {
        try {
            if (sessionId == null) {
                sessionId = sessionClient.open()
                log.debug("Opened session {}", sessionId!!)
                return
            }
        } catch (ex: IOException) {
            log.warn("unable to open session", ex)
            return
        }
        try {
            sessionClient.ping(sessionId!!)
        } catch (ex: IOException) {
            log.warn("Resetting session", ex)
            sessionId = null
        }
    }
}