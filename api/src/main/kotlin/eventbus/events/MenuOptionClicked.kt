/*
 * Copyright (c) 2017, Robin <robin.weymans@gmail.com>
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
package eventbus.events

import lombok.Data
import net.runelite.api.MenuAction
import net.runelite.api.MenuEntry
import net.runelite.api.widgets.Widget
import java.lang.RuntimeException

/**
 * An event where a menu option has been clicked.
 *
 *
 * This event does not only trigger when clicking an option in a
 * right-clicked menu. The event will trigger for any left click
 * action performed (ie. clicking an item, walking to a tile, etc) as
 * well as any right-click menu option.
 *
 *
 * By default, when there is no action performed when left-clicking,
 * it seems that this event still triggers with the "Cancel" action.
 */

data class MenuOptionClicked(var menuEntry: MenuEntry? = null
) {
    var consumed: Boolean = false
    var selectedItemIndex: Int = -1
    var canvasX: Int = -1
    var canvasY: Int = -1
    var automated: Boolean = false

    /**
     * If this menu entry is an item op, get the item id
     * @return
     * @see net.runelite.api.ItemID
     *
     * @see net.runelite.api.NullItemID
     */
    fun getItemId(): Int {
        return menuEntry!!.itemId
    }

    fun setItemId(itemId: Int) {
        menuEntry!!.itemId = itemId
    }
    /**
     * Action parameter 0. Its value depends on the menuAction.
     */
    fun getParam0(): Int {
        return menuEntry!!.param0
    }

    /**
     * Action parameter 1. Its value depends on the menuAction.
     */
    fun getParam1(): Int {
        return menuEntry!!.param1
    }

    /**
     * The option text added to the menu.
     */
    fun getMenuOption(): String? {
        return menuEntry!!.option
    }

    /**
     * The target of the action.
     */
    fun getMenuTarget(): String? {
        return menuEntry!!.target
    }

    /**
     * The action performed.
     */
    fun getMenuAction(): MenuAction? {
        return menuEntry!!.type
    }

    /**
     * The ID of the object, actor, or item that the interaction targets.
     */
    fun getId(): Int {
        return menuEntry!!.identifier
    }

    /**
     * Test if this menu entry is an item op. "Use" and "Examine" are not considered item ops.
     * @return
     */
    fun isItemOp(): Boolean {
        return menuEntry!!.isItemOp
    }

    /**
     * If this menu entry is an item op, get the item op id
     * @return 1-5
     */
    fun getItemOp(): Int {
        return menuEntry!!.itemOp
    }

    /**
     * Get the widget this menu entry is on, if this is a menu entry
     * with an associated widget. Such as eg, CC_OP.
     * @return
     */
    fun getWidget(): Widget? {
        return menuEntry!!.widget
    }

    /**
     * Marks the event as having been consumed.
     *
     *
     * Setting this state indicates that a plugin has processed the menu
     * option being clicked and that the event will not be passed on
     * for handling by vanilla client code.
     */
    fun consume() {
        this.consumed = true
    }

    @Deprecated("")
    fun getActionParam(): Int {
        return menuEntry!!.param0
    }

    @Deprecated("")
    fun getWidgetId(): Int {
        return menuEntry!!.param1
    }
}