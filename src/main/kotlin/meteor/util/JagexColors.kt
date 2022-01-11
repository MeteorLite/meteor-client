/*
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
package meteor.util

import java.awt.Color

/**
 * This class serves to hold colors used in Oldschool RuneScape that are also used in client code.
 */
object JagexColors {
    /*
   * Colors of chat text when displayed on an opaque background.
   */
    val CHAT_PUBLIC_TEXT_OPAQUE_BACKGROUND = Color.BLUE
    val CHAT_PRIVATE_MESSAGE_TEXT_OPAQUE_BACKGROUND = Color.CYAN
    val CHAT_FC_TEXT_OPAQUE_BACKGROUND = Color(127, 0, 0)
    val CHAT_FC_NAME_OPAQUE_BACKGROUND = Color.BLUE
    val CHAT_GAME_EXAMINE_TEXT_OPAQUE_BACKGROUND = Color.BLACK
    val CHAT_TYPED_TEXT_OPAQUE_BACKGROUND = Color.BLUE

    /*
   * Colors of chat text when displayed on a transparent background.
   */
    val CHAT_PUBLIC_TEXT_TRANSPARENT_BACKGROUND = Color(144, 144, 255)
    val CHAT_PRIVATE_MESSAGE_TEXT_TRANSPARENT_BACKGROUND = Color.CYAN
    val CHAT_FC_TEXT_TRANSPARENT_BACKGROUND = Color(239, 80, 80)
    val CHAT_FC_NAME_TRANSPARENT_BACKGROUND = Color(144, 112, 255)
    val CHAT_GAME_EXAMINE_TEXT_TRANSPARENT_BACKGROUND = Color.WHITE
    val CHAT_TYPED_TEXT_TRANSPARENT_BACKGROUND = Color(144, 144, 255)

    /*
   * Colors relating to right-click menus.
   */
    val MENU_TARGET = Color(0xFF9040)
    const val MENU_TARGET_TAG = "<col=ff9040>"

    /*
   * Colors relating to tooltips.
   */
    val TOOLTIP_BACKGROUND = Color(255, 255, 160)
    val TOOLTIP_BORDER = Color.BLACK
    val TOOLTIP_TEXT = Color.BLACK

    /*
   * Colors used in interfaces
   */
    val DARK_ORANGE_INTERFACE_TEXT = Color(255, 152, 31)
    val YELLOW_INTERFACE_TEXT = Color.YELLOW
}