/*
 * Copyright (c) 2019, Adam <Adam@sigterm.info>
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
package meteor.game;


import meteor.Logger
import meteor.util.RunnableExceptionLogger
import net.runelite.api.GameState
import net.runelite.http.api.worlds.World
import net.runelite.http.api.worlds.WorldClient
import net.runelite.http.api.worlds.WorldResult
import java.io.IOException
import java.util.Comparator
import java.util.concurrent.*
import java.util.function.ToIntFunction


object WorldService {
    private val worldClient = WorldClient(Main.httpClient)
    private val executor = Main.executor
    private val firstRunFuture: CompletableFuture<WorldResult> = CompletableFuture<WorldResult>()
    private var worlds: WorldResult? = null
    private val log: Logger = Logger("WorldService")
    private const val WORLD_FETCH_TIMER = 10 // minutes
    init {


        executor.scheduleWithFixedDelay(
            RunnableExceptionLogger.wrap { tick() },
            0,
            WORLD_FETCH_TIMER.toLong(),
            TimeUnit.MINUTES
        )
    }

    private fun tick() {
        try {
            if (worlds == null || Main.client!!.gameState == GameState.LOGGED_IN) {
                fetch()
            }
        } finally {
            firstRunFuture.complete(worlds)
        }
    }

    private fun fetch() {
        try {
            val worldResult: WorldResult = worldClient.lookupWorlds()
            worldResult.getWorlds().sortWith(
                Comparator.comparingInt<World>(
                    ToIntFunction<World> { obj: World -> obj.id })
            )
            worlds = worldResult
            //   Main.KEVENT_INSTANCE.post(worldResult)
        } catch (ex: IOException) {
            log.warn("Error looking up worlds", ex)
        }
    }

    fun refresh() {
        executor.execute(Runnable { fetch() })
    }

    fun getWorlds(): WorldResult? {
        if (!firstRunFuture.isDone()) {
            try {
                return firstRunFuture.get(10, TimeUnit.SECONDS)
            } catch (e: InterruptedException) {
                log.warn("Failed to retrieve worlds on first run", e)
            } catch (e: ExecutionException) {
                log.warn("Failed to retrieve worlds on first run", e)
            } catch (e: TimeoutException) {
                log.warn("Failed to retrieve worlds on first run", e)
            }
        }
        return worlds
    }
}