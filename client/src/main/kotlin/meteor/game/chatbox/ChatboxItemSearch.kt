/*
 * Copyright (c) 2019, Ron Young <https://github.com/raiyni>
 * All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *     list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *     this list of conditions and the following disclaimer in the documentation
 *     and/or other materials provided with the distribution.
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
package meteor.game.chatbox

import meteor.Main.client
import meteor.game.ItemManager
import meteor.util.JagexColors
import net.runelite.api.ItemComposition
import net.runelite.api.widgets.*
import java.awt.event.KeyEvent
import java.util.*


object ChatboxItemSearch : ChatboxTextInput() {
    private val results: MutableMap<Int, ItemComposition?> = LinkedHashMap()
    private var tooltipText: String? = null
    private var index = -1

    private var onItemSelected: ((Int)->Unit)? = {}

    class ItemIcon(private val texturesToReplace: ShortArray?, private val colorsToReplace: ShortArray?,
                           private val modelId: Int = 0
    ) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as ItemIcon

            if (texturesToReplace != null) {
                if (other.texturesToReplace == null) return false
                if (!texturesToReplace.contentEquals(other.texturesToReplace)) return false
            } else if (other.texturesToReplace != null) return false
            if (colorsToReplace != null) {
                if (other.colorsToReplace == null) return false
                if (!colorsToReplace.contentEquals(other.colorsToReplace)) return false
            } else if (other.colorsToReplace != null) return false
            if (modelId != other.modelId) return false

            return true
        }

        override fun hashCode(): Int {
            var result = texturesToReplace?.contentHashCode() ?: 0
            result = 31 * result + (colorsToReplace?.contentHashCode() ?: 0)
            result = 31 * result + modelId
            return result
        }
    }

    init {
        lines(1)
        prompt("Item Search")
        onChanged {
            clientThread.invokeLater {
                filterResults()
                update()
            }
        }
    }

    override fun update() {
        val container = ChatboxPanelManager.containerWidget
        container!!.deleteAllChildren()
        val promptWidget = container.createChild(-1, WidgetType.TEXT)
        promptWidget.text = prompt
        promptWidget.textColor = 0x800000
        promptWidget.fontId = fontID
        promptWidget.originalX = 0
        promptWidget.originalY = 5
        promptWidget.xPositionMode = WidgetPositionMode.ABSOLUTE_CENTER
        promptWidget.yPositionMode = WidgetPositionMode.ABSOLUTE_TOP
        promptWidget.originalHeight = FONT_SIZE
        promptWidget.xTextAlignment = WidgetTextAlignment.CENTER
        promptWidget.yTextAlignment = WidgetTextAlignment.CENTER
        promptWidget.widthMode = WidgetSizeMode.MINUS
        promptWidget.revalidate()
        buildEdit(0, 5 + FONT_SIZE, container.width, FONT_SIZE)
        val separator = container.createChild(-1, WidgetType.LINE)
        separator.originalX = 0
        separator.originalY = 8 + FONT_SIZE * 2
        separator.xPositionMode = WidgetPositionMode.ABSOLUTE_CENTER
        separator.yPositionMode = WidgetPositionMode.ABSOLUTE_TOP
        separator.originalHeight = 0
        separator.originalWidth = 16
        separator.widthMode = WidgetSizeMode.MINUS
        separator.textColor = 0x666666
        separator.revalidate()
        var x = PADDING
        var y = PADDING * 3
        for ((idx, itemComposition) in results.values.withIndex()) {
            val item = container.createChild(-1, WidgetType.GRAPHIC)
            item.xPositionMode = WidgetPositionMode.ABSOLUTE_LEFT
            item.yPositionMode = WidgetPositionMode.ABSOLUTE_TOP
            item.originalX = x
            item.originalY = y + FONT_SIZE * 2
            item.originalHeight = ICON_HEIGHT
            item.originalWidth = ICON_WIDTH
            item.name = JagexColors.MENU_TARGET_TAG + itemComposition!!.name
            item.itemId = itemComposition.id
            item.itemQuantity = 10000
            item.itemQuantityMode = ItemQuantityMode.NEVER
            item.borderType = 1
            item.setAction(0, tooltipText)
            item.setHasListener(true)
            if (index == idx) {
                item.opacity = HOVERED_OPACITY
            } else {
                item.setOnMouseOverListener(JavaScriptCallback { item.opacity = HOVERED_OPACITY } as JavaScriptCallback?)
                item.setOnMouseLeaveListener(JavaScriptCallback { item.opacity = 0 } as JavaScriptCallback?)
            }
            item.setOnOpListener(JavaScriptCallback {
                if (onItemSelected != null) {
                    onItemSelected!!(itemComposition.id)
                }
                ChatboxPanelManager.close()
            } as JavaScriptCallback?)
            x += ICON_WIDTH + PADDING
            if (x + ICON_WIDTH >= container.width) {
                y += ICON_HEIGHT + PADDING
                x = PADDING
            }
            item.revalidate()
        }
    }

    override fun keyPressed(ev: KeyEvent) {
        if (!ChatboxPanelManager.shouldTakeInput()) {
            return
        }
        when (ev.keyCode) {
            KeyEvent.VK_ENTER -> {
                ev.consume()
                if (index > -1) {
                    if (onItemSelected != null) {
                        onItemSelected!!(  results.keys.toTypedArray()[index])
                    }
                    ChatboxPanelManager.close()
                }
            }
            KeyEvent.VK_TAB, KeyEvent.VK_RIGHT -> {
                ev.consume()
                if (results.isNotEmpty()) {
                    index++
                    if (index >= results.size) {
                        index = 0
                    }
                    clientThread.invokeLater { update() }
                }
            }
            KeyEvent.VK_LEFT -> {
                ev.consume()
                if (results.isNotEmpty()) {
                    index--
                    if (index < 0) {
                        index = results.size - 1
                    }
                    clientThread.invokeLater { update() }
                }
            }
            KeyEvent.VK_UP -> {
                ev.consume()
                if (results.size >= MAX_RESULTS / 2) {
                    index -= MAX_RESULTS / 2
                    if (index < 0) {
                        index += if (results.size == MAX_RESULTS) {
                            results.size
                        } else {
                            MAX_RESULTS
                        }
                        index = index.coerceIn( 0, results.size - 1)
                    }
                    clientThread.invokeLater { update() }
                }
            }
            KeyEvent.VK_DOWN -> {
                ev.consume()
                if (results.size >= MAX_RESULTS / 2) {
                    index += MAX_RESULTS / 2
                    if (index >= MAX_RESULTS) {
                        index -= if (results.size == MAX_RESULTS) {
                            results.size
                        } else {
                            MAX_RESULTS
                        }
                        index = index.coerceIn( 0, results.size - 1)
                    }
                    clientThread.invokeLater { update() }
                }
            }
            else -> super.keyPressed(ev)
        }
    }

    override fun close() {
        // Clear search string when closed
        value("")
        results.clear()
        index = -1
        super.close()
    }



    private fun filterResults() {
        results.clear()
        index = -1
        val search = value.toString().lowercase()
        if (search.isEmpty()) {
            return
        }
        val itemIcons: MutableSet<ItemIcon> = HashSet()
        var i = 0
        while (i < client.itemCount && results.size < MAX_RESULTS) {
            val itemComposition = ItemManager.getItemComposition(ItemManager.canonicalize(i))
            val name = itemComposition!!.name.lowercase(Locale.getDefault())

            // The client assigns "null" to item names of items it doesn't know about
            // and the item might already be in the results from canonicalize
            if (name != "null" && name.contains(search) && !results.containsKey(itemComposition.id)) {
                // Check if the results already contain the same item image
                val itemIcon = ItemIcon(
                    itemComposition.textureToReplaceWith,
                            itemComposition.colorToReplaceWith,itemComposition.inventoryModel
                )
                if (itemIcons.contains(itemIcon)) {
                    i++
                    continue
                }
                itemIcons.add(itemIcon)
                results[itemComposition.id] = itemComposition
            }
            i++
        }
    }

    fun onItemSelected(onItemSelected: (Int)->Unit): ChatboxItemSearch {
        this.onItemSelected = onItemSelected
        return this
    }

    fun tooltipText(text: String?): ChatboxItemSearch {
        tooltipText = text
        return this
    }
    private const val ICON_HEIGHT = 32
    private const val ICON_WIDTH = 36
    private const val PADDING = 6
    private const val MAX_RESULTS = 24
    private const val FONT_SIZE = 16
    private const val HOVERED_OPACITY = 128

}