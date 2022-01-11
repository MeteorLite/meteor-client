/*
 * Copyright (c) 2017, Levi <me@levischuck.com>
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
package meteor.ui

import java.awt.Image
import java.lang.Exception
import java.lang.Runnable
import java.util.*
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.function.Consumer

object DrawManager {
    private val everyFrame: MutableList<Runnable> = CopyOnWriteArrayList()
    private val nextFrame: Queue<Consumer<Image>> = ConcurrentLinkedQueue()
    fun registerEveryFrameListener(everyFrameListener: Runnable) {
        if (!everyFrame.contains(everyFrameListener)) {
            everyFrame.add(everyFrameListener)
        }
    }

    fun unregisterEveryFrameListener(everyFrameListener: Runnable) {
        everyFrame.remove(everyFrameListener)
    }

    fun requestNextFrameListener(nextFrameListener: Consumer<Image>) {
        nextFrame.add(nextFrameListener)
    }

    fun processDrawComplete(imageSupplier: () -> Image) {
        for (everyFrameListener in everyFrame) {
            try {
                everyFrameListener.run()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        var nextFrameListener = nextFrame.poll()
        var image: Image? = null
        while (nextFrameListener != null) {
            if (image == null) {
                try {
                    image = imageSupplier.invoke()
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }
            if (image == null) {
                nextFrame.clear()
                break
            }
            try {
                nextFrameListener.accept(image)
            } catch (e: Exception) {
                e.printStackTrace()
            }
            nextFrameListener = nextFrame.poll()
        }
    }
}