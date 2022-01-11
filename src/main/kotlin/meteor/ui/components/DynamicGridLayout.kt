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
package meteor.ui.components

import java.awt.Component
import java.awt.Container
import java.awt.Dimension
import java.awt.GridLayout
import java.util.function.Function

/**
 * Grid layout implementation with support for cells with unequal size.
 *
 * See https://www.javaworld.com/article/2077486/core-java/java-tip-121--flex-your-grid-layout.html
 */
class DynamicGridLayout @JvmOverloads constructor(rows: Int = 1, cols: Int = 0, hgap: Int = 0, vgap: Int = 0) :
    GridLayout(rows, cols, hgap, vgap) {
    override fun preferredLayoutSize(parent: Container): Dimension {
        synchronized(parent.treeLock) { return calculateSize(parent) { obj: Component -> obj.preferredSize } }
    }

    override fun minimumLayoutSize(parent: Container): Dimension {
        synchronized(parent.treeLock) { return calculateSize(parent) { obj: Component -> obj.minimumSize } }
    }

    override fun layoutContainer(parent: Container) {
        synchronized(parent.treeLock) {
            val insets = parent.insets
            val ncomponents = parent.componentCount
            var nrows = rows
            var ncols = columns
            if (ncomponents == 0) {
                return
            }
            if (nrows > 0) {
                ncols = (ncomponents + nrows - 1) / nrows
            } else {
                nrows = (ncomponents + ncols - 1) / ncols
            }
            val hgap = hgap
            val vgap = vgap

            // scaling factors
            val pd = preferredLayoutSize(parent)
            val parentInsets = parent.insets
            val wborder = parentInsets.left + parentInsets.right
            val hborder = parentInsets.top + parentInsets.bottom
            val sw = (1.0 * parent.width - wborder) / (pd.width - wborder)
            val sh = (1.0 * parent.height - hborder) / (pd.height - hborder)
            val w = IntArray(ncols)
            val h = IntArray(nrows)

            // calculate dimensions for all components + apply scaling
            for (i in 0 until ncomponents) {
                val r = i / ncols
                val c = i % ncols
                val comp = parent.getComponent(i)
                val d = comp.preferredSize
                d.width = (sw * d.width).toInt()
                d.height = (sh * d.height).toInt()
                if (w[c] < d.width) {
                    w[c] = d.width
                }
                if (h[r] < d.height) {
                    h[r] = d.height
                }
            }

            // Apply new bounds to all child components
            var c = 0
            var x = insets.left
            while (c < ncols) {
                var r = 0
                var y = insets.top
                while (r < nrows) {
                    val i = r * ncols + c
                    if (i < ncomponents) {
                        parent.getComponent(i).setBounds(x, y, w[c], h[r])
                    }
                    y += h[r] + vgap
                    r++
                }
                x += w[c] + hgap
                c++
            }
        }
    }

    /**
     * Calculate outer size of the layout based on it's children and sizer
     * @param parent parent component
     * @param sizer functioning returning dimension of the child component
     * @return outer size
     */
    private fun calculateSize(parent: Container, sizer: Function<Component, Dimension>): Dimension {
        val ncomponents = parent.componentCount
        var nrows = rows
        var ncols = columns
        if (nrows > 0) {
            ncols = (ncomponents + nrows - 1) / nrows
        } else {
            nrows = (ncomponents + ncols - 1) / ncols
        }
        val w = IntArray(ncols)
        val h = IntArray(nrows)

        // Calculate dimensions for all components
        for (i in 0 until ncomponents) {
            val r = i / ncols
            val c = i % ncols
            val comp = parent.getComponent(i)
            val d = sizer.apply(comp)
            if (w[c] < d.width) {
                w[c] = d.width
            }
            if (h[r] < d.height) {
                h[r] = d.height
            }
        }

        // Calculate total width and height of the layout
        var nw = 0
        for (j in 0 until ncols) {
            nw += w[j]
        }
        var nh = 0
        for (i in 0 until nrows) {
            nh += h[i]
        }
        val insets = parent.insets

        // Apply insets and horizontal and vertical gap to layout
        return Dimension(
            insets.left + insets.right + nw + (ncols - 1) * hgap,
            insets.top + insets.bottom + nh + (nrows - 1) * vgap
        )
    }
}