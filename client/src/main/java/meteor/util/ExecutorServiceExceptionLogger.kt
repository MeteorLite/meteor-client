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

import java.util.concurrent.*

/**
 * Wrapper for $[ScheduledExecutorService] that will log all uncaught exceptions as warning to
 * console
 */
class ExecutorServiceExceptionLogger(var service: ScheduledExecutorService) : ScheduledExecutorService {
    override fun <T> submit(task: Callable<T>): Future<T> {
        return service.submit(monitor(task))
    }

    override fun <T> submit(task: Runnable, result: T): Future<T> {
        return service.submit(monitor(task), result)
    }

    override fun submit(task: Runnable): Future<*> {
        return service.submit(monitor(task))
    }

    override fun execute(command: Runnable) {
        service.execute(monitor(command))
    }

    // Everything below is direct proxy to provided executor service
    override fun shutdown() {
        service.shutdown()
    }

    override fun shutdownNow(): List<Runnable> {
        return service.shutdownNow()
    }

    override fun isShutdown(): Boolean {
        return service.isShutdown
    }

    override fun isTerminated(): Boolean {
        return service.isTerminated
    }

    @Throws(InterruptedException::class)
    override fun awaitTermination(timeout: Long, unit: TimeUnit): Boolean {
        return service.awaitTermination(timeout, unit)
    }

    @Throws(InterruptedException::class)
    override fun <T> invokeAll(tasks: Collection<Callable<T>?>): List<Future<T>> {
        return service.invokeAll(tasks)
    }

    @Throws(InterruptedException::class)
    override fun <T> invokeAll(
        tasks: Collection<Callable<T>?>, timeout: Long,
        unit: TimeUnit
    ): List<Future<T>> {
        return service.invokeAll(tasks, timeout, unit)
    }

    @Throws(InterruptedException::class, ExecutionException::class)
    override fun <T> invokeAny(tasks: Collection<Callable<T>?>): T {
        return service.invokeAny(tasks)
    }

    @Throws(InterruptedException::class, ExecutionException::class, TimeoutException::class)
    override fun <T> invokeAny(tasks: Collection<Callable<T>?>, timeout: Long, unit: TimeUnit): T {
        return service.invokeAny(tasks, timeout, unit)
    }

    override fun schedule(command: Runnable, delay: Long, unit: TimeUnit): ScheduledFuture<*> {
        return service.schedule(command, delay, unit)
    }

    override fun <V> schedule(callable: Callable<V>, delay: Long, unit: TimeUnit): ScheduledFuture<V> {
        return service.schedule(callable, delay, unit)
    }

    override fun scheduleAtFixedRate(
        command: Runnable, initialDelay: Long, period: Long,
        unit: TimeUnit
    ): ScheduledFuture<*> {
        return service.scheduleAtFixedRate(command, initialDelay, period, unit)
    }

    override fun scheduleWithFixedDelay(
        command: Runnable, initialDelay: Long, delay: Long,
        unit: TimeUnit
    ): ScheduledFuture<*> {
        return service.scheduleWithFixedDelay(command, initialDelay, delay, unit)
    }

    companion object {
        private fun monitor(command: Runnable): Runnable {
            return RunnableExceptionLogger.wrap(command)
        }

        private fun <V> monitor(command: Callable<V>): Callable<V> {
            return CallableExceptionLogger.wrap(command)
        }
    }
}