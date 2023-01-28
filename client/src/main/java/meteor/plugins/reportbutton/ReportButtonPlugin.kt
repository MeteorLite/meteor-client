/*
 * Copyright (c) 2018, Cameron <https://github.com/noremac201>
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
package meteor.plugins.reportbutton

import eventbus.events.ConfigChanged
import eventbus.events.GameStateChanged
import eventbus.events.GameTick
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.plugins.attackstyles.AttackStylesConfig
import meteor.rs.ClientThread
import net.runelite.api.Constants
import net.runelite.api.GameState
import net.runelite.api.widgets.WidgetInfo
import meteor.task.Schedule
import org.apache.commons.lang3.time.DurationFormatUtils
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.time.temporal.ChronoUnit
import java.util.*

@PluginDescriptor(
    name = "Report Button",
    description = "Replace the text on the Report button with the current time",
    tags = ["time", "utc", "clock"]
)
class ReportButtonPlugin : Plugin() {
    private var timeFormat: DateTimeFormatter? = null
    private var loginTime: Instant? = null
    private var ticksSinceLogin = 0
    private var ready = false
    private val clientThread = ClientThread
    var config = configuration<ReportButtonConfig>()
    override fun onStart() {
        clientThread.invoke { updateReportButtonTime() }
        updateTimeFormat()
    }

    override fun onStop() {
        clientThread.invoke {
            val reportButton = client.getWidget(WidgetInfo.CHATBOX_REPORT_TEXT)
            if (reportButton != null) {
                reportButton.text = "Report"
            }
        }
    }

    override fun onGameStateChanged(it: GameStateChanged) {
        when (it.gameState) {
            GameState.LOGGING_IN, GameState.HOPPING, GameState.CONNECTION_LOST -> ready = true
            GameState.LOGGED_IN -> if (ready) {
                loginTime = Instant.now()
                ticksSinceLogin = 0
                ready = false
            }
            else -> {}
        }
    }

    override fun onGameTick(it: GameTick) {
        if (config.time() == TimeStyle.LOGIN_TIME){
            ticksSinceLogin++
        }
        updateReportButtonTime()
        if (config.time() == TimeStyle.GAME_TICKS) {
            ticksSinceLogin++
        }
    }

    override fun onConfigChanged(it: ConfigChanged) {
        if (it.group == "reportButton" && it.key == "switchTimeFormat") {
            updateTimeFormat()
        }
    }

    @Schedule(period = 500, unit = ChronoUnit.MILLIS)
    fun updateSchedule() {
        updateReportButtonTime()
    }

    private fun updateReportButtonTime() {
        if (client.gameState != GameState.LOGGED_IN) {
            return
        }
        val reportButton = client.getWidget(WidgetInfo.CHATBOX_REPORT_TEXT) ?: return
        when (config.time()) {
            TimeStyle.UTC -> reportButton.text = uTCTime
            TimeStyle.JAGEX -> reportButton.text = jagexTime
            TimeStyle.LOCAL_TIME -> reportButton.text = localTime
            TimeStyle.LOGIN_TIME -> reportButton.text = getLoginTime()
            TimeStyle.IDLE_TIME -> reportButton.text = idleTime
            TimeStyle.DATE -> reportButton.text = date
            TimeStyle.GAME_TICKS -> reportButton.text = gameTicks
            TimeStyle.OFF -> reportButton.text = "Report"
        }
    }

    private val idleTime: String
        get() {
            val lastActivity = java.lang.Long.min(client.mouseIdleTicks.toLong(), client.keyboardIdleTicks.toLong())
            return DurationFormatUtils.formatDuration(lastActivity * Constants.CLIENT_TICK_LENGTH, "mm:ss")
        }

    private fun getLoginTime(): String {
        if (loginTime == null) {
            return "Report"
        }
        val duration = Duration.between(loginTime, Instant.now())
        val time = LocalTime.ofSecondOfDay(duration.seconds)
        return time.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
    }

    private val gameTicks: String
        get() = Integer.toString(ticksSinceLogin)
    private val localTime: String
        get() = LocalTime.now().format(timeFormat)
    private val uTCTime: String
        get() {
            val time = LocalTime.now(UTC)
            return time.format(timeFormat)
        }
    private val jagexTime: String
        get() {
            val time = LocalTime.now(JAGEX)
            return time.format(timeFormat)
        }

    private fun updateTimeFormat() {
        timeFormat = if (config.switchTimeFormat() == TimeFormat.TIME_24H) {
            DateTimeFormatter.ofPattern("HH:mm:ss")
        } else {
            DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)
        }
    }

    companion object {
        private val UTC = ZoneId.of("UTC")
        private val JAGEX = ZoneId.of("Europe/London")
        private val DATE_FORMAT: DateFormat = SimpleDateFormat("MMM. dd, yyyy")
        private val date: String
            get() = DATE_FORMAT.format(Date())
    }
}