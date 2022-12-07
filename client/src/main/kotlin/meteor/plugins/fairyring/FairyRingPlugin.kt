/*
 * Copyright (c) 2018 Abex
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
 * Copyright (c) 2018, Yoav Ram <https://github.com/yoyo421>
 * Copyright (c) 2018, Infinitay <https://github.com/Infinitay>
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
package meteor.plugins.fairyring

import com.google.common.base.Strings
import eventbus.events.GameTick
import eventbus.events.VarbitChanged
import eventbus.events.WidgetLoaded
import meteor.game.chatbox.ChatboxPanelManager
import meteor.game.chatbox.ChatboxTextInput
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.*
import net.runelite.api.util.Text
import net.runelite.api.widgets.*
import java.util.*

@PluginDescriptor(
    name = "Fairy Rings",
    description = "Show the location of the fairy ring teleport",
    tags = ["teleportation"]
)
class FairyRingPlugin : Plugin() {
    private val config = configuration<FairyRingConfig>()
    private val chatboxPanelManager = ChatboxPanelManager
    private val clientThread =  ClientThread
    private var searchInput = ChatboxTextInput()
    private var searchBtn: Widget? = null
    private var codes: Collection<CodeWidgets>? = listOf()

    data class CodeWidgets(// The fairy hideout has both of these null, because its not the same as the rest of them
        var favorite: Widget? = null, var code: Widget? = null, var description: Widget? = null
    )

    override fun onVarbitChanged(it: VarbitChanged) {
        setWidgetTextToDestination()
    }

    override fun onWidgetLoaded(it: WidgetLoaded) {
        if (it.groupId == WidgetID.FAIRY_RING_PANEL_GROUP_ID) {
            setWidgetTextToDestination()
            val header = client.getWidget(WidgetInfo.FAIRY_RING_HEADER)
            if (header != null) {
                searchBtn = header.createChild(-1, WidgetType.GRAPHIC)
                searchBtn?.spriteId = SpriteID.GE_SEARCH
                searchBtn?.originalWidth = 17
                searchBtn?.originalHeight = 17
                searchBtn?.originalX = 11
                searchBtn?.originalY = 11
                searchBtn?.setHasListener(true)
                searchBtn?.setAction(1, MENU_OPEN)
                searchBtn?.setOnOpListener(JavaScriptCallback { e: ScriptEvent -> menuOpen(e) })
                searchBtn?.name = "Search"
                searchBtn?.revalidate()
                codes = null
                if (config.autoOpen()) {
                    openSearch()
                }
            }
        }
    }

    private fun menuOpen(e: ScriptEvent) {
        openSearch()
        client.playSoundEffect(SoundEffectID.UI_BOOP)
    }

    private fun menuClose(e: ScriptEvent) {
        updateFilter("")
        chatboxPanelManager.close()
        client.playSoundEffect(SoundEffectID.UI_BOOP)
    }

    private fun setWidgetTextToDestination() {
        val fairyRingTeleportButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON)
        if (fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden) {
            val destination: String = try {
                val fairyRingDestination = getFairyRingDestination(
                    client.getVarbitValue(Varbits.FAIRY_RING_DIAL_ADCB),
                    client.getVarbitValue(Varbits.FAIRY_RIGH_DIAL_ILJK),
                    client.getVarbitValue(Varbits.FAIRY_RING_DIAL_PSRQ)
                )
                fairyRingDestination.destination
            } catch (ex: IllegalArgumentException) {
                "Invalid location"
            }
            fairyRingTeleportButton.text = destination
        }
    }

    private fun getFairyRingDestination(
        varbitValueDialLeft: Int,
        varbitValueDialMiddle: Int,
        varbitValueDialRight: Int
    ): FairyRings {
        return FairyRings.valueOf(leftDial[varbitValueDialLeft] + middleDial[varbitValueDialMiddle] + rightDial[varbitValueDialRight])
    }


    private fun openSearch() {
        updateFilter("")
        searchBtn?.setAction(1, MENU_CLOSE)
        searchBtn?.setOnOpListener(JavaScriptCallback { e: ScriptEvent? -> menuClose(e!!) })
        searchInput = chatboxPanelManager.openTextInput("Filter fairy rings")
            .onChanged { s: String? -> clientThread.invokeLater { updateFilter(s!!) } }
            .isDone { false }
            .onClose {
                clientThread.invokeLater { updateFilter("") }
                searchBtn?.setOnOpListener(JavaScriptCallback { e: ScriptEvent? -> menuOpen(e!!) })
                searchBtn?.setAction(1, MENU_OPEN)
            }
            .build()
    }

    override fun onGameTick(it: GameTick) {
        // This has to happen because the only widget that gets hidden is the tli one

        // This has to happen because the only widget that gets hidden is the tli one
        val fairyRingTeleportButton = client.getWidget(WidgetInfo.FAIRY_RING_TELEPORT_BUTTON)
        val fairyRingWidgetOpen = fairyRingTeleportButton != null && !fairyRingTeleportButton.isHidden
        val chatboxOpen =  chatboxPanelManager.currentInput === searchInput

        if (!fairyRingWidgetOpen && chatboxOpen) {
            chatboxPanelManager.close()
        }
    }

    private fun updateFilter(filter: String) {
        var filter = filter
        filter = filter.lowercase()
        val list = client.getWidget(WidgetInfo.FAIRY_RING_LIST)
        val favorites = client.getWidget(WidgetInfo.FAIRY_RING_FAVORITES)
        if (list == null) {
            return
        }
        if (codes != null) {
            // Check to make sure the list hasn't been rebuild since we were last her
            // Do this by making sure the list's dynamic children are the same as when we last saw them
            if (codes!!.none { w: CodeWidgets ->
                    val codeWidget: Widget = w.code ?: return@none false
                    list.getChild(codeWidget.index) == codeWidget
                }) {
                codes = null
            }
        }
        if (codes == null) {
            // Find all of the widgets that we care about, grouping by their Y value
            val codeMap: MutableMap<Int, CodeWidgets> = TreeMap()
            for (w in list.staticChildren) {
                if (w.isSelfHidden) {
                    continue
                }
                if (w.spriteId != -1) {
                    codeMap.computeIfAbsent(
                        w.relativeY
                    ) { CodeWidgets() }.favorite = w
                } else if (!w.text.isNullOrEmpty()) {
                    codeMap.computeIfAbsent(
                        w.relativeY
                    ) { CodeWidgets() }.description =  w
                }
            }
            for (w in list.dynamicChildren) {
                if (w.isSelfHidden) {
                    continue
                }
                val c = codeMap.computeIfAbsent(
                    w.relativeY
                ) { CodeWidgets() }
                c.code = w
            }
            codes = codeMap.values
        }

        // Relayout the panel
        var y = 0

            val hide = filter.isNotEmpty()
            favorites?.isHidden = hide
        if(favorites != null)
            if (!hide) {
                y += favorites.originalHeight + ENTRY_PADDING
            }
        for (c in codes!!) {
            val code: String = Text.removeTags(c.description?.name).replace(" ", "")
            var tags: String? = null
            if (code.isNotEmpty()) {
                    val ring = FairyRings.valueOf(code)
                    tags = ring.tags
            }
            val hidden = !((filter.isEmpty()
                    || Text.removeTags(c.description?.text).lowercase().contains(filter)
                    || code.lowercase().contains(filter)) || tags != null && tags.contains(filter))
            if (c.code != null) {
                c.code?.isHidden = hidden
                c.code?.originalY = y
            }
            if (c.favorite != null) {
                c.favorite?.isHidden = hidden
                c.favorite?.originalY = y
            }
            c.description?.isHidden = (hidden)
            c.description?.originalY = (y)
            if (!hidden) {
                y += c.description!!.height + ENTRY_PADDING
            }
        }
        y -= ENTRY_PADDING
        if (y < 0) {
            y = 0
        }
        var newHeight = 0
        if (list.scrollHeight > 0) {
            newHeight = list.scrollY * y / list.scrollHeight
        }
        list.scrollHeight = y
        list.revalidateScroll()
        client.runScript(
            ScriptID.UPDATE_SCROLLBAR,
            WidgetInfo.FAIRY_RING_LIST_SCROLLBAR.packedId,
            WidgetInfo.FAIRY_RING_LIST.packedId,
            newHeight
        )
    }

        private val leftDial = arrayOf("A", "D", "C", "B")
        private val middleDial = arrayOf("I", "L", "K", "J")
        private val rightDial = arrayOf("P", "S", "R", "Q")
        private val ENTRY_PADDING = 3
        private val MENU_OPEN = "Open"
        private val MENU_CLOSE = "Close"

}