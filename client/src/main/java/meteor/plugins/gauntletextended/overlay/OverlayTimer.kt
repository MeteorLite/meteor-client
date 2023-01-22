/*
 * Copyright (c) 2020, dutta64 <https://github.com/dutta64>
 * Copyright (c) 2018, Seth <http://github.com/sethtroll>
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
package meteor.plugins.gauntletextended.overlay

import meteor.plugins.gauntletextended.GauntletExtendedPlugin
import meteor.ui.overlay.OverlayLayer
import java.awt.Graphics2D
import meteor.plugins.gauntletextended.GauntletExtendedConfig
import meteor.ui.overlay.PanelComponent
import meteor.ui.overlay.OverlayPosition
import meteor.ui.overlay.OverlayPriority
import java.awt.Dimension
import meteor.chat.ChatMessageBuilder
import meteor.chat.ChatColorType
import meteor.chat.QueuedMessage
import net.runelite.api.ChatMessageType
import meteor.Main
import meteor.ui.table.*
import java.awt.Color
import java.time.Instant
import java.util.*

class OverlayTimer(plugin: GauntletExtendedPlugin?, private val config: GauntletExtendedConfig) : Overlay(plugin) {
    private val chatMessageManager = Main.chatMessageManager
    private val panelComponent: PanelComponent
    private val tableComponent: TableComponent
    private val rowPrepTime: TableRow
    private val rowTotalTime: TableRow
    private var timeGauntletStart: Long
    private var timeHunllefStart: Long

    init {
        panelComponent = PanelComponent()
        tableComponent = TableComponent()
        panelComponent.children.add(TitleComponent.builder().text("Gauntlet Timer"))
        panelComponent.children.add(tableComponent)
        tableComponent.setColumnAlignments(TableAlignment.LEFT, TableAlignment.RIGHT)
        rowPrepTime = TableRow.builder()
            .elements(
                Arrays.asList(
                    TableElement.builder()
                        .content("Prep Time:"),
                    TableElement.builder()
                        .content("")
                )
            )
        rowTotalTime = TableRow.builder()
            .elements(
                Arrays.asList(
                    TableElement.builder()
                        .content("Total Time:"),
                    TableElement.builder()
                        .content("")
                )
            )
        timeGauntletStart = -1
        timeHunllefStart = -1
        position = OverlayPosition.ABOVE_CHATBOX_RIGHT
        priority = OverlayPriority.HIGH
        determineLayer()
    }

    override fun render(graphics2D: Graphics2D): Dimension? {
        if (!config.timerOverlay() || timeGauntletStart == -1L) {
            return null
        }
        val tableRow = if (timeHunllefStart == -1L) rowPrepTime else rowTotalTime
        tableRow.elements[1]
            .content = calculateElapsedTime(Instant.now().epochSecond, timeGauntletStart)
        return panelComponent.render(graphics2D)
    }

    override fun determineLayer() {
        layer = OverlayLayer.UNDER_WIDGETS
    }

    fun reset() {
        timeGauntletStart = -1
        timeHunllefStart = -1
        rowPrepTime.elements[1].content = ""
        rowTotalTime.elements[1].content = ""
        tableComponent.rows.clear()
    }

    fun setGauntletStart() {
        timeGauntletStart = Instant.now().epochSecond
        rowPrepTime.rowColor = Color.WHITE
        tableComponent.setRows(rowPrepTime)
    }

    fun setHunllefStart() {
        timeHunllefStart = Instant.now().epochSecond
        rowPrepTime.rowColor = Color.LIGHT_GRAY
        tableComponent.setRows(rowPrepTime)
        tableComponent.addRows(rowTotalTime)
    }

    fun onPlayerDeath() {
        if (!config.timerChatMessage()) {
            return
        }
        printTime()
        reset()
    }

    private fun printTime() {
        if (timeGauntletStart == -1L || timeHunllefStart == -1L) {
            return
        }
        val current = Instant.now().epochSecond
        val elapsedPrepTime = calculateElapsedTime(timeHunllefStart, timeGauntletStart)
        val elapsedBossTime = calculateElapsedTime(current, timeHunllefStart)
        val elapsedTotalTime = calculateElapsedTime(current, timeGauntletStart)
        val chatMessageBuilder = ChatMessageBuilder()
            .append(ChatColorType.NORMAL)
            .append("Preparation time: ")
            .append(ChatColorType.HIGHLIGHT)
            .append(elapsedPrepTime)
            .append(ChatColorType.NORMAL)
            .append(". Hunllef kill time: ")
            .append(ChatColorType.HIGHLIGHT)
            .append(elapsedBossTime)
            .append(ChatColorType.NORMAL)
            .append(". Total time: ")
            .append(ChatColorType.HIGHLIGHT)
            .append("$elapsedTotalTime.")
        chatMessageManager.queue(
            QueuedMessage.builder()
                .type(ChatMessageType.CONSOLE)
                .runeLiteFormattedMessage(chatMessageBuilder.build())
        )
    }

    companion object {
        private fun calculateElapsedTime(end: Long, start: Long): String {
            val elapsed = end - start
            val minutes = elapsed % 3600 / 60
            val seconds = elapsed % 60
            return String.format("%01d:%02d", minutes, seconds)
        }
    }
}