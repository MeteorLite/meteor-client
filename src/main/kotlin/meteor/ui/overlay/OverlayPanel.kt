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
package meteor.ui.overlay

import meteor.FontManager
import meteor.ui.components.ComponentConstants
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics2D

abstract class OverlayPanel : Overlay() {

    val panelComponent: PanelComponent = PanelComponent()
    /**
     * Enables/disables automatic clearing of [OverlayPanel.getPanelComponent] children after
     * rendering (enabled by default)
     */
    private val clearChildren = true

    /**
     * Enables/disables automatic font size changes based on panel component size relative to default
     * panel component size.
     */
    private val dynamicFont = false

    /**
     * Preferred color used for panel component background
     */
    var preferredColor: Color? = null

    init {
        resizable = true
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val oldSize: Dimension? = panelComponent.preferredSize
        if (preferredSize != null)
        panelComponent.preferredSize = (preferredSize)
        if (dynamicFont) {
            if (preferredSize!!.width >= (ComponentConstants.STANDARD_WIDTH * 1.3)) {
                graphics.font = FontManager.runescapeBoldFont
            } else if (preferredSize!!.width <= ComponentConstants.STANDARD_WIDTH * 0.8) {
                graphics.font = FontManager.runescapeSmallFont
            }
        }
        val oldBackgroundColor: Color = panelComponent.backgroundColor
        if (preferredColor != null && ComponentConstants.STANDARD_BACKGROUND_COLOR == oldBackgroundColor) {
            panelComponent.backgroundColor = preferredColor as Color
        }
        val dimension: Dimension? = panelComponent.render(graphics)
        if (clearChildren) {
            panelComponent.children.clear()
        }
        panelComponent.preferredSize = (oldSize)
        panelComponent.backgroundColor = oldBackgroundColor
        return dimension
    }
}