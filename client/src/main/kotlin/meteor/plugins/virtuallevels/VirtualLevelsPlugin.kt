/*
 * Copyright (c) 2018, Joshua Filby <joshua@filby.me>
 * Copyright (c) 2018, Jordan Atwood <jordan.atwood423@gmail.com>
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
package meteor.plugins.virtuallevels

import eventbus.events.ConfigChanged
import eventbus.events.ScriptCallbackEvent
import meteor.events.PluginChanged
import meteor.plugins.Plugin
import meteor.plugins.PluginDescriptor
import meteor.rs.ClientThread
import net.runelite.api.Experience
import net.runelite.api.Skill


@PluginDescriptor(
    name = "Virtual Levels",
    description = "Shows virtual levels (beyond 99) and virtual skill total on the skills tab.",
    tags = ["skill", "total", "max"],
    enabledByDefault = false
)
class VirtualLevelsPlugin : Plugin() {

    private val clientThread = ClientThread
    private val config = configuration<VirtualLevelsConfig>()

    override fun onStart() {
        clientThread?.invoke { simulateSkillChange() }
    }


    override fun onPluginChanged(it: PluginChanged) {
        // this is guaranteed to be called after the plugin has been registered by the eventbus. startUp is not.
        if (it.plugin == this) {
            clientThread?.invoke { simulateSkillChange() }
        }
    }


    override fun onConfigChanged(it: ConfigChanged) {
        if (!it.group.equals("virtuallevels")) {
            return
        }
        clientThread?.invoke { simulateSkillChange() }
    }


    override fun onScriptCallbackEvent(it: ScriptCallbackEvent) {
        val eventName: String = it.eventName
        val intStack = client.intStack
        val intStackSize = client.intStackSize
        val stringStack = client.stringStack
        val stringStackSize = client.stringStackSize
        when (eventName) {
            "skillTabBaseLevel" -> {
                val skillId = intStack[intStackSize - 2]
                val skill = Skill.values()[skillId]
                val exp = client.getSkillExperience(skill)

                // alter the local variable containing the level to show
                intStack[intStackSize - 1] = Experience.getLevelForXp(exp)
            }

            "skillTabMaxLevel" ->                // alter max level constant
                intStack[intStackSize - 1] = Experience.MAX_VIRT_LEVEL

            "skillTabTotalLevel" -> {
                if (!config.virtualTotalLevel()) {
                }
                var level = 0
                for (s in Skill.values()) {
                    if (s == Skill.OVERALL) {
                        continue
                    }
                    level += Experience.getLevelForXp(client.getSkillExperience(s))
                }
                stringStack[stringStackSize - 1] = TOTAL_LEVEL_TEXT_PREFIX + level
            }
        }
    }

    private fun simulateSkillChange() {
        // this fires widgets listening for all skill changes
        for (skill in Skill.values()) {
            if (skill != Skill.OVERALL) {
                client.queueChangedSkill(skill)
            }
        }
    }

    companion object {
        private const val TOTAL_LEVEL_TEXT_PREFIX = "Total level:<br>"
    }
}