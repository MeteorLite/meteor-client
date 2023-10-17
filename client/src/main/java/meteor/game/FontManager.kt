/*
 * Copyright (c) 2017, Tyler <https://github.com/tylerthardy>
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
package meteor.game

import java.awt.Font
import java.awt.FontFormatException
import java.awt.GraphicsEnvironment
import java.io.IOException

object FontManager {
    var runescapeFont: Font
    var runescapeSmallFont: Font
    var runescapeBoldFont: Font
    var defaultFont: Font? = null
    var defaultBoldFont: Font? = null

    init {
        try {
            ClassLoader.getSystemClassLoader().getResourceAsStream("runescape.ttf").use { inRunescape ->
                ClassLoader.getSystemClassLoader().getResourceAsStream("runescape_small.ttf").use { inRunescapeSmall ->
                    ClassLoader.getSystemClassLoader().getResourceAsStream("runescape_bold.ttf").use { inRunescapeBold ->
                        // runescape
                        runescapeFont = Font.createFont(Font.TRUETYPE_FONT, inRunescape)
                            .deriveFont(Font.PLAIN, 16f)

                        // small
                        runescapeSmallFont = Font.createFont(Font.TRUETYPE_FONT, inRunescapeSmall)
                            .deriveFont(Font.PLAIN, 12f)

                        // bold
                        runescapeBoldFont = Font.createFont(Font.TRUETYPE_FONT, inRunescapeBold)
                            .deriveFont(Font.BOLD, 16f)
                    }
                }
            }
        } catch (ex: FontFormatException) {
            throw RuntimeException("Font loaded, but format incorrect.", ex)
        } catch (ex: IOException) {
            throw RuntimeException("Font file not found.", ex)
        }
        defaultFont = runescapeFont
        defaultBoldFont = runescapeBoldFont
    }
}