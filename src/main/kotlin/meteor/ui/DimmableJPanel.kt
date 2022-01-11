/*
 * Copyright (c) 2018, Levi <me@levischuck.com>
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

import java.awt.Color
import javax.swing.JPanel

open class DimmableJPanel : JPanel() {
    // Dimming state, allows for restoring original colors before dimming
    open var dimmed = false
    set(dimmed) {
        field = dimmed
        if (dimmed) {
            super.setBackground(dimmedBackground)
            super.setForeground(dimmedForeground)
        } else {
            super.setBackground(undimmedBackground)
            super.setForeground(undimmedForeground)
        }
    }

    private var dimmedForeground: Color? = null
    private var dimmedBackground: Color? = null
    private var undimmedForeground: Color? = null
    private var undimmedBackground: Color? = null
    override fun setForeground(color: Color) {
        undimmedForeground = color
        dimmedForeground = color.darker()
        super.setForeground(color)
    }

    override fun setBackground(color: Color) {
        undimmedBackground = color
        dimmedBackground = color.darker()
        super.setBackground(color)
    }

    override fun getForeground(): Color {
        return if (dimmed) dimmedForeground!! else undimmedForeground!!
    }

    override fun getBackground(): Color {
        return if (dimmed) dimmedBackground!! else undimmedBackground!!
    }
}