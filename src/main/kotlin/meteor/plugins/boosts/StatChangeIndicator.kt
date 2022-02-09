/*
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
package meteor.plugins.boosts

import meteor.ui.overlay.infobox.InfoBox
import meteor.ui.overlay.infobox.InfoBoxPriority
import java.awt.Color
import java.awt.image.BufferedImage

class StatChangeIndicator internal constructor(
    private val up: Boolean,
    image: BufferedImage?,
    private val boostPlugin: BoostsPlugin,
    private val config: BoostsConfig?
) : InfoBox(image, boostPlugin) {
    init {
        priority = (InfoBoxPriority.MED)
        tooltip = (if (up) "Next debuff change" else "Next buff change")
    }

    override val text: String
        get() = String.format(
            "%02d",
            boostPlugin.getChangeTime(if (up) boostPlugin.changeUpTicks else boostPlugin.changeDownTicks)
        )
    override val textColor: Color
        get() = if ((if (up) boostPlugin.changeUpTicks else boostPlugin.changeDownTicks) < 10) Color.RED
            .brighter() else Color.WHITE

    override fun render(): Boolean {
        val time = if (up) boostPlugin.changeUpTicks else boostPlugin.changeDownTicks
        return config!!.displayInfoboxes() && time != -1
    }
}