/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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
package meteor.ui.overlay.infobox

import com.google.common.base.Strings
import eventbus.events.MenuOptionClicked
import meteor.Main
import meteor.events.Events
import meteor.events.InfoBoxMenuClicked
import meteor.ui.components.ComponentConstants.STANDARD_BACKGROUND_COLOR
import meteor.ui.overlay.*
import meteor.ui.overlay.components.InfoBoxComponent
import net.runelite.api.MenuAction
import java.awt.Dimension
import java.awt.Graphics2D
import java.awt.Point
import java.awt.Rectangle
import java.util.concurrent.CopyOnWriteArrayList

class InfoBoxOverlay internal constructor(
    name: String,
    orientation: ComponentOrientation
) : OverlayPanel() {
    private val infoboxManager = InfoBoxManager
    private val tooltipManager = TooltipManager
    override val name: String
    val config = Main.meteorConfig

    val infoBoxes = CopyOnWriteArrayList<InfoBox>()
    var orientation: ComponentOrientation
    var hoveredComponent: InfoBoxComponent? = null

    init {
        this.name = name
        this.orientation = orientation
        position = OverlayPosition.ABOVE_CHATBOX_RIGHT
        clearChildren = (false)
        dragTargetable = (true)
        panelComponent.wrap = (true)
        panelComponent.backgroundColor = STANDARD_BACKGROUND_COLOR
        panelComponent.border = Rectangle()
        panelComponent.gap = Point(GAP, GAP)
        setPreferredSize(Dimension(300, 800))
    }

    override fun render(graphics: Graphics2D): Dimension? {
        val menuOpen = client.isMenuOpen
        if (!menuOpen) {
            hoveredComponent = null
        }
        if (infoBoxes.isEmpty()) {
            return null
        }

        // Set preferred size to the size of DEFAULT_WRAP_COUNT infoboxes, including the padding - which is applied
        // to the last infobox prior to wrapping too.
        panelComponent.setPreferredSize(
            Dimension(
                DEFAULT_WRAP_COUNT * (config.infoBoxSize() + GAP),
                DEFAULT_WRAP_COUNT * (config.infoBoxSize() + GAP)
            )
        )
        panelComponent.orientation = (orientation)
        for (box in infoBoxes) {
            if (!box.render()) {
                continue
            }
            val text = box.text
            val color = box.textColor
            val infoBoxComponent = InfoBoxComponent()
            infoBoxComponent.text = (text)
            if (color != null) {
                infoBoxComponent.color = (color)
            }
            infoBoxComponent.outline = (config.infoBoxTextOutline())
            infoBoxComponent.image = (box.scaledImage)
            infoBoxComponent.tooltip = (box.tooltip)
            infoBoxComponent.setPreferredSize(Dimension(config.infoBoxSize(), config.infoBoxSize()))
            infoBoxComponent.backgroundColor = (config.overlayBackgroundColor())
            infoBoxComponent.infoBox = (box)
            panelComponent.children.add(infoBoxComponent)
        }
        val dimension: Dimension? = super.render(graphics)

        // Handle tooltips
        val mouse = Point(
            client.mouseCanvasPosition.x,
            client.mouseCanvasPosition.y
        )
        for (child in panelComponent.children) {
            val component: InfoBoxComponent = child as InfoBoxComponent

            // Create intersection rectangle
            val intersectionRectangle: Rectangle = Rectangle(component.bounds)
            intersectionRectangle.translate(bounds!!.x, bounds!!.y)
            if (intersectionRectangle.contains(mouse)) {
                val tooltip: String? = component.tooltip
                if (!Strings.isNullOrEmpty(tooltip)) {
                    tooltipManager.add(Tooltip(tooltip))
                }
                if (!menuOpen) {
                    hoveredComponent = component
                }
                break
            }
        }
        panelComponent.children.clear()
        return dimension
    }

    // we dynamically build the menu options based on which infobox is hovered
    override val menuEntries: ArrayList<OverlayMenuEntry>
        get() =// we dynamically build the menu options based on which infobox is hovered
            if (hoveredComponent == null) ArrayList() else hoveredComponent!!.infoBox!!.menuEntries

    override fun onMenuOptionClicked(it: MenuOptionClicked) {
        if (it.getMenuAction() != MenuAction.RUNELITE_INFOBOX
            || hoveredComponent == null
        ) {
            return
        }
        val infoBox: InfoBox = hoveredComponent!!.infoBox!!
        val overlayMenuEntry: OverlayMenuEntry? = infoBox.menuEntries.stream()
            .filter { me: OverlayMenuEntry -> me.option == it.getMenuOption() }
            .findAny()
            .orElse(null)
        if (overlayMenuEntry != null) {
            client.callbacks.post(Events.INFO_BOX_MENU_CLICKED, InfoBoxMenuClicked(overlayMenuEntry, infoBox))
        }
    }

    override fun onDrag(other: Overlay?): Boolean {
        if (other !is InfoBoxOverlay) {
            return false
        }
        infoboxManager.mergeInfoBoxes(other as InfoBoxOverlay?, this)
        return true
    }

    fun flip(): ComponentOrientation {
        return if (orientation == ComponentOrientation.HORIZONTAL) ComponentOrientation.VERTICAL else ComponentOrientation.HORIZONTAL.also {
            orientation = it
        }
    }

    companion object {
        private const val GAP = 1
        private const val DEFAULT_WRAP_COUNT = 4
    }
}