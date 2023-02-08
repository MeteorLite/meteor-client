/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * Copyright (c) 2019, Wynadorn <https://github.com/Wynadorn>
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
package meteor.plugins.camera

import com.google.common.primitives.Ints
import eventbus.events.*
import meteor.input.KeyListener
import meteor.input.KeyManager
import meteor.input.MouseListener
import meteor.input.MouseManager
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import meteor.ui.overlay.Tooltip
import meteor.ui.overlay.TooltipManager
import net.runelite.api.*
import net.runelite.api.widgets.JavaScriptCallback
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.awt.Component
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import javax.swing.SwingUtilities

@PluginDescriptor(
    name = "Camera",
    description = "Expands zoom limit, provides vertical camera, and remaps mouse input keys",
    tags = ["zoom", "limit", "vertical", "click", "mouse"]
)
class CameraPlugin : Plugin(), KeyListener, MouseListener {
    private var controlDown = false
        val INNER_ZOOM_LIMIT = 1004
        val OUTER_LIMIT_MIN = -400
        val OUTER_LIMIT_MAX = 400
    // flags used to store the mousedown states
    private var rightClick = false
    private var middleClick = false

    /**
     * Whether or not the current menu has any non-ignored menu entries
     */
    private var menuHasEntries = false
    private var savedCameraYaw = 0

    private val clientThread = ClientThread
    private val config = configuration<CameraConfig>()
    private val keyManager = KeyManager
    private val mouseManager = MouseManager
    private val tooltipManager = TooltipManager
    private var sliderTooltip: Tooltip? = null
    override fun onStart() {
        rightClick = false
        middleClick = false
        menuHasEntries = false
        copyConfigs()
        keyManager.registerKeyListener(this, this.javaClass)
        mouseManager.registerMouseListener(this)
        clientThread.invoke {
            val sideSlider = client.getWidget(WidgetInfo.SETTINGS_SIDE_CAMERA_ZOOM_SLIDER_TRACK)
            sideSlider?.let { addZoomTooltip(it) }
            val settingsInit = client.getWidget(WidgetInfo.SETTINGS_INIT)
            if (settingsInit != null) {
                client.createScriptEvent(*settingsInit.onLoadListener)
                    .setSource(settingsInit)
                    .run()
            }
        }
    }

    override fun onStop() {
        client.setCameraPitchRelaxerEnabled(false)
        client.setInvertYaw(false)
        client.setInvertPitch(false)
        keyManager.unregisterKeyListener(this)
        mouseManager.unregisterMouseListener(this)
        controlDown = false
        clientThread.invoke {
            val sideSlider = client.getWidget(WidgetInfo.SETTINGS_SIDE_CAMERA_ZOOM_SLIDER_TRACK)
            sideSlider?.setOnMouseRepeatListener(null as Array<Any?>?)
            val settingsInit = client.getWidget(WidgetInfo.SETTINGS_INIT)
            if (settingsInit != null) {
                client.createScriptEvent(*settingsInit.onLoadListener)
                    .setSource(settingsInit)
                    .run()
            }
        }
    }

    fun copyConfigs() {
        client.setCameraPitchRelaxerEnabled(config.relaxCameraPitch())
        client.setInvertYaw(config.invertYaw())
        client.setInvertPitch(config.invertPitch())
    }

    override fun onScriptCallbackEvent(it: ScriptCallbackEvent) {
        if (client.indexScripts.isOverlayOutdated) {
            // if any cache overlay fails to load then assume at least one of the zoom scripts is outdated
            // and prevent zoom extending entirely.
            return
        }
        val intStack = client.intStack
        val intStackSize = client.intStackSize
        if (!controlDown && "scrollWheelZoom" == it.eventName && config.controlFunction() == ControlFunction.CONTROL_TO_ZOOM) {
            intStack[intStackSize - 1] = 1
        }
        if ("innerZoomLimit" == it.eventName && config.innerLimit()) {
            intStack[intStackSize - 1] = INNER_ZOOM_LIMIT
            return
        }
        if ("outerZoomLimit" == it.eventName) {
            val outerLimit = Ints.constrainToRange(
                config.outerLimit(),
             OUTER_LIMIT_MIN,
                OUTER_LIMIT_MAX
            )
            val outerZoomLimit = DEFAULT_OUTER_ZOOM_LIMIT - outerLimit
            intStack[intStackSize - 1] = outerZoomLimit
            return
        }
        if ("scrollWheelZoomIncrement" == it.eventName && config.zoomIncrement() != DEFAULT_ZOOM_INCREMENT) {
            intStack[intStackSize - 1] = config.zoomIncrement()
            return
        }
        if ("lookPreservePitch" == it.eventName && config.compassLookPreservePitch()) {
            intStack[intStackSize - 1] = client.cameraPitch
            return
        }
        if (config.innerLimit()) {
            // This lets the options panel's slider have an exponential rate
            val exponent = 2.0
            when (it.eventName) {
                "zoomLinToExp" -> {
                    val range = intStack[intStackSize - 1].toDouble()
                    var value = intStack[intStackSize - 2].toDouble()
                    value = Math.pow(value / range, exponent) * range
                    intStack[intStackSize - 2] = value.toInt()
                }
                "zoomExpToLin" -> {
                    val range = intStack[intStackSize - 1].toDouble()
                    var value = intStack[intStackSize - 2].toDouble()
                    value = Math.pow(value / range, 1.0 / exponent) * range
                    intStack[intStackSize - 2] = value.toInt()
                }
            }
        }
    }

    override fun onFocusChanged(it: FocusChanged) {
        if (!it.focused) {
            controlDown = false
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        copyConfigs()
    }

    override fun keyTyped(e: KeyEvent) {}
    override fun keyPressed(e: KeyEvent) {
        if (e.keyCode == KeyEvent.VK_CONTROL) {
            controlDown = true
        }
    }

    override fun keyReleased(e: KeyEvent) {
        if (e.keyCode == KeyEvent.VK_CONTROL) {
            controlDown = false
            if (config.controlFunction() == ControlFunction.CONTROL_TO_RESET) {
                val zoomValue = Ints.constrainToRange(
                    config.ctrlZoomValue(),
                    OUTER_LIMIT_MIN,
                    INNER_ZOOM_LIMIT
                )
                clientThread.invokeLater { client.runScript(ScriptID.CAMERA_DO_ZOOM, zoomValue, zoomValue) }
            }
        }
    }

    /**
     * Checks if the menu has any non-ignored entries
     */
    private fun hasMenuEntries(menuEntries: Array<MenuEntry>): Boolean {
        for (menuEntry in menuEntries) {
            val action = menuEntry.type
            when (action) {
                MenuAction.CANCEL, MenuAction.WALK -> {}
                MenuAction.EXAMINE_OBJECT, MenuAction.EXAMINE_NPC, MenuAction.EXAMINE_ITEM_GROUND, MenuAction.EXAMINE_ITEM, MenuAction.CC_OP_LOW_PRIORITY -> {
                    if (config.ignoreExamine()) {
                        break
                    }
                    return true
                }
                else -> return true
            }
        }
        return false
    }

    /**
     * Checks if the menu has any options, because menu entries are built each
     * tick and the MouseListener runs on the awt thread
     */
    override fun onClientTick(it: ClientTick) {
        menuHasEntries = hasMenuEntries(client.menuEntries)
        sliderTooltip = null
    }

    override fun onScriptPreFired(it: ScriptPreFired) {
        when (it.scriptId) {
            ScriptID.SETTINGS_SLIDER_CHOOSE_ONOP -> {
                val arg = client.intStackSize - 11
                val intStack = client.intStack
                if (intStack[arg] == SettingID.CAMERA_ZOOM) {
                    addZoomTooltip(client.scriptActiveWidget)
                }
            }
            ScriptID.ZOOM_SLIDER_ONDRAG, ScriptID.SETTINGS_ZOOM_SLIDER_ONDRAG -> sliderTooltip = makeSliderTooltip()
        }
    }

    override fun onWidgetLoaded(it: WidgetLoaded) {
        if (it.groupId == WidgetID.SETTINGS_SIDE_GROUP_ID) {
            addZoomTooltip(client.getWidget(WidgetInfo.SETTINGS_SIDE_CAMERA_ZOOM_SLIDER_TRACK))
        }
    }

    private fun addZoomTooltip(w: Widget?) {
        w!!.setOnMouseRepeatListener(JavaScriptCallback { ev: ScriptEvent? -> sliderTooltip = makeSliderTooltip() })
    }

    private fun makeSliderTooltip(): Tooltip {
        val value = client.getVarcIntValue(VarClientInt.CAMERA_ZOOM_RESIZABLE_VIEWPORT.index)
        val max = if (config.innerLimit()) INNER_ZOOM_LIMIT else DEFAULT_INNER_ZOOM_LIMIT
        return Tooltip("Camera Zoom: $value / $max")
    }

    override fun onBeforeRender(it: BeforeRender) {
        if (sliderTooltip != null) {
            tooltipManager.add(sliderTooltip!!)
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gameState) {
            GameState.HOPPING -> savedCameraYaw = client.mapAngle
            GameState.LOGGED_IN -> {
                if (savedCameraYaw != 0 && config.preserveYaw()) {
                    client.setCameraYawTarget(savedCameraYaw)
                }
                savedCameraYaw = 0
            }
            else -> {GameState.UNKNOWN}
        }
    }

    /**
     * The event that is triggered when a mouse button is pressed
     * In this method the right click is changed to a middle-click to enable rotating the camera
     *
     *
     * This method also provides the config option to enable the middle-mouse button to always open the right click menu
     */
    override fun mousePressed(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (SwingUtilities.isRightMouseButton(mouseEvent) && config.rightClickMovesCamera()) {
            val oneButton = client.getVar(VarPlayer.MOUSE_BUTTONS) == 1
            // Only move the camera if there is nothing at the menu, or if
            // in one-button mode. In one-button mode, left and right click always do the same thing,
            // so always treat it as the menu is empty
            if (!menuHasEntries || oneButton) {
                // Set the rightClick flag to true so we can release the button in mouseReleased() later
                rightClick = true
                // Change the mousePressed() MouseEvent to the middle mouse button
                mouseEvent = MouseEvent(
                    mouseEvent.source as Component,
                    mouseEvent.id,
                    mouseEvent.getWhen(),
                    mouseEvent.modifiersEx,
                    mouseEvent.x,
                    mouseEvent.y,
                    mouseEvent.clickCount,
                    mouseEvent.isPopupTrigger,
                    MouseEvent.BUTTON2
                )
            }
        } else if (SwingUtilities.isMiddleMouseButton(mouseEvent) && config.middleClickMenu()) {
            // Set the middleClick flag to true so we can release it later in mouseReleased()
            middleClick = true
            // Chance the middle mouse button MouseEvent to a right-click
            mouseEvent = MouseEvent(
                mouseEvent.source as Component,
                mouseEvent.id,
                mouseEvent.getWhen(),
                mouseEvent.modifiersEx,
                mouseEvent.x,
                mouseEvent.y,
                mouseEvent.clickCount,
                mouseEvent.isPopupTrigger,
                MouseEvent.BUTTON3
            )
        }
        return mouseEvent
    }

    /**
     * Correct the MouseEvent to release the correct button
     */
    override fun mouseReleased(mouseEvent: MouseEvent): MouseEvent {
        var mouseEvent = mouseEvent
        if (rightClick) {
            rightClick = false
            // Change the MouseEvent to button 2 so the middle mouse button will be released
            mouseEvent = MouseEvent(
                mouseEvent.source as Component,
                mouseEvent.id,
                mouseEvent.getWhen(),
                mouseEvent.modifiersEx,
                mouseEvent.x,
                mouseEvent.y,
                mouseEvent.clickCount,
                mouseEvent.isPopupTrigger,
                MouseEvent.BUTTON2
            )
        }
        if (middleClick) {
            middleClick = false
            // Change the MouseEvent ot button 3 so the right mouse button will be released
            mouseEvent = MouseEvent(
                mouseEvent.source as Component,
                mouseEvent.id,
                mouseEvent.getWhen(),
                mouseEvent.modifiersEx,
                mouseEvent.x,
                mouseEvent.y,
                mouseEvent.clickCount,
                mouseEvent.isPopupTrigger,
                MouseEvent.BUTTON3
            )
        }
        return mouseEvent
    }

    /*
	 * These methods are unused but required to be present in a MouseListener implementation
	 */
    // region Unused MouseListener methods
    override fun mouseDragged(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    override fun mouseMoved(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    override fun mouseClicked(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    override fun mouseEntered(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    override fun mouseExited(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    // endregion
    override val isEnabledOnLoginScreen: Boolean
        get() = false

    companion object {
        private const val DEFAULT_ZOOM_INCREMENT = 25
        private const val DEFAULT_OUTER_ZOOM_LIMIT = 128
        const val DEFAULT_INNER_ZOOM_LIMIT = 896
    }
}