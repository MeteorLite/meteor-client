/*
 * Copyright (c) 2018 Abex
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
package meteor.rs

import Main.client
import io.reactivex.rxjava3.core.Scheduler
import java.util.concurrent.ConcurrentLinkedQueue
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import io.reactivex.rxjava3.schedulers.Schedulers
import java.lang.Runnable
import java.util.concurrent.Executor
import java.util.function.BooleanSupplier


object ClientThread : Executor {
    private val invokes = ConcurrentLinkedQueue<BooleanSupplier>()

    init {
        RxJavaPlugins.setSingleSchedulerHandler { old: Scheduler? -> Schedulers.from(this) }
    }

    override fun execute(r: Runnable) {
        invoke(r)
    }

    operator fun invoke(r: Runnable) {
        invoke(BooleanSupplier {
            r.run()
            true
        })
    }

    /**
     * Will run r on the game thread, at a unspecified point in the future. If r returns false, r will
     * be ran again, at a later point
     */
    private operator fun invoke(r: BooleanSupplier) {
        if (client.isClientThread) {
            if (!r.asBoolean) {
                invokes.add(r)
            }
            return
        }
        invokeLaterSecondary(r)
    }

    /**
     * Will run r on the game thread after this method returns If r returns false, r will be ran
     * again, at a later point
     */
    fun invokeLater(r: Runnable) {
        invokeLaterSecondary {
            r.run()
            true
        }
    }

    private fun invokeLaterSecondary(r: BooleanSupplier) {
        invokes.add(r)
    }

    operator fun invoke() {
        assert(client.isClientThread)
        val ir = invokes.iterator()
        while (ir.hasNext()) {
            val r = ir.next()
            var remove = true
            try {
                remove = r.asBoolean
            } catch (d: ThreadDeath) {
                throw d
            } catch (e: Throwable) {
                e.printStackTrace()
            }
            if (remove) {
                ir.remove()
            }
        }
    }
}