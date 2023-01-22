/*
 * Copyright (c) 2018 Abex
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
package meteor.game.chatbox


import meteor.input.KeyListener
import meteor.input.MouseListener
import meteor.rs.ClientThread
import net.runelite.api.FontID
import net.runelite.api.ScriptEvent
import net.runelite.api.util.Text
import net.runelite.api.widgets.*
import java.awt.Point
import java.awt.Rectangle
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import java.awt.datatransfer.UnsupportedFlavorException
import java.awt.event.KeyEvent
import java.awt.event.MouseEvent
import java.io.IOException
import java.util.function.Predicate
import java.util.regex.Pattern
import javax.swing.SwingUtilities

open class ChatboxTextInput : ChatboxInput(), KeyListener, MouseListener {
    private val chatboxPanelManager = ChatboxPanelManager
     val clientThread = ClientThread
    private class Line(val start: Int = 0, val end: Int = 0, val text: String? = null) {
    }

    var prompt: String? = null

    var lines = 0
    var value = StringBuffer()
    var cursorStart = 0
    var cursorEnd = 0
    var selectionStart = -1
    var selectionEnd = -1
    var charValidator: (Int) -> Boolean? = defaultCharValidator
    var onClose: (() -> Unit?)? = {}
    var onDone: (String) -> Boolean? = {false}
    var onChanged: ((String)->Unit?)? = {}

    var fontID = FontID.QUILL_8

    private var built = false

    // These are lambdas for atomic updates
    private var isInBounds: (MouseEvent)->Boolean? = {false}
    private var getLineOffset: ((Int)-> Int)? = null
    private var getPointCharOffset: ((Point) -> Int)? = null
    fun addCharValidator(validator: (Int) -> Boolean): ChatboxTextInput {
         charValidator =  validator
        return this
    }

    fun lines(lines: Int): ChatboxTextInput {
        this.lines = lines
        if (built) {
            clientThread.invoke { update() }
        }
        return this
    }

    fun prompt(prompt: String?): ChatboxTextInput {
        this.prompt = prompt
        if (built) {
            clientThread.invoke { update() }
        }
        return this
    }

    fun value(value: String): ChatboxTextInput {
        val sb = StringBuffer()
        for (c in value.toCharArray()) {
            if (charValidator(c.code)!!) {
                sb.append(c)
            }
        }
        this.value = sb
        cursorAt(this.value.length)
        return this
    }

    fun cursorAt(index: Int): ChatboxTextInput {
        return cursorAt(index, index)
    }

    fun cursorAt(indexA: Int, indexB: Int): ChatboxTextInput {
        var indexA = indexA
        var indexB = indexB
        if (indexA < 0) {
            indexA = 0
        }
        if (indexB < 0) {
            indexB = 0
        }
        if (indexA > value.length) {
            indexA = value.length
        }
        if (indexB > value.length) {
            indexB = value.length
        }
        var start = indexA
        var end = indexB
        if (start > end) {
            val v = start
            start = end
            end = v
        }
        cursorStart = start
        cursorEnd = end
        if (built) {
            clientThread.invoke { update() }
        }
        return this
    }

    fun getValue(): String {
        return value.toString()
    }

    fun charValidator(validator: ((Int)->Boolean?)?): ChatboxTextInput {
        var valid = validator
        if(valid != null) {
            valid = defaultCharValidator
            charValidator = valid
        }
        return this
    }

    fun onClose(onClose: ()->Unit): ChatboxTextInput {
        this.onClose = onClose
        return this
    }

    fun onDone(onDone: (String)->Unit?): ChatboxTextInput {
        this.onDone = { s: String ->
            onDone(s)
            true
        }

        return this
    }
    fun isDone(onDone: (String) -> Boolean): ChatboxTextInput {
        this.onDone = onDone
        return this
    }
    /**
     * Called when the user attempts to close the input by pressing enter
     * Return false to cancel the close
     */

    fun onChanged(onChanged: (String)-> Unit?): ChatboxTextInput {
        this.onChanged = onChanged

        return this
    }

    fun fontID(fontID: Int): ChatboxTextInput {
        this.fontID = fontID
        return this
    }

    open fun update() {
        val container = chatboxPanelManager.containerWidget
        container!!.deleteAllChildren()
        val promptWidget = container.createChild(-1, WidgetType.TEXT)
        promptWidget.text = prompt
        promptWidget.textColor = 0x800000
        promptWidget.fontId = fontID
        promptWidget.xPositionMode = WidgetPositionMode.ABSOLUTE_CENTER
        promptWidget.originalX = 0
        promptWidget.yPositionMode = WidgetPositionMode.ABSOLUTE_TOP
        promptWidget.originalY = 8
        promptWidget.originalHeight = 24
        promptWidget.xTextAlignment = WidgetTextAlignment.CENTER
        promptWidget.yTextAlignment = WidgetTextAlignment.CENTER
        promptWidget.widthMode = WidgetSizeMode.MINUS
        promptWidget.revalidate()
        buildEdit(0, 50, container.width, 0)
    }

    fun buildEdit(x: Int, y: Int, w: Int, h: Int) {
        var y = y
        var h = h
        val editLines: MutableList<Line> = ArrayList()
        val container = chatboxPanelManager.containerWidget
        val cursor = container!!.createChild(-1, WidgetType.RECTANGLE)
        val start = System.currentTimeMillis()
        cursor.setOnTimerListener(JavaScriptCallback { ev: ScriptEvent? ->
            val on = (System.currentTimeMillis() - start) % CURSOR_FLASH_RATE_MILLIS > CURSOR_FLASH_RATE_MILLIS / 2
            cursor.opacity = if (on) 255 else 0
        })
        cursor.textColor = 0xFFFFFF
        cursor.setHasListener(true)
        cursor.isFilled = true
        cursor.fontId = fontID
        val font = cursor.font
        if (h <= 0) {
            h = font.baseline
        }
        val oy = y
        val oh = h
        var breakIndex = -1
        val sb = StringBuilder()
        for (i in value.indices) {
            val count = i - sb.length
            val c = value[i].toString() + ""
            sb.append(c)
            if (BREAK_MATCHER.matcher(c).matches()) {
                breakIndex = sb.length
            }
            if (i == value.length - 1) {
                val line = Line(count, count + sb.length - 1, sb.toString())
                editLines.add(line)
                break
            }
            if (font.getTextWidth(sb.toString() + value[i + 1]) < w) {
                continue
            }
            if (editLines.size < lines - 1 || lines == 0) {
                if (breakIndex > 1) {
                    val str = sb.substring(0, breakIndex)
                    val line = Line(count, count + str.length - 1, str)
                    editLines.add(line)
                    sb.replace(0, breakIndex, "")
                    breakIndex = -1
                    continue
                }
                val line = Line(count, count + sb.length - 1, sb.toString())
                editLines.add(line)
                sb.replace(0, sb.length, "")
            }
        }
        val bounds = Rectangle(container.canvasLocation.x + container.width, y, 0, editLines.size * oh)
        var i = 0
        while (i < editLines.size || i == 0) {
            val line = if (editLines.size > 0) editLines[i] else Line(0, 0, "")
            val text = line.text
            val len = text!!.length
            var lt = Text.escapeJagex(text)
            var mt: String? = ""
            var rt: String? = ""
            val isStartLine = cursorOnLine(cursorStart, line.start, line.end) || cursorOnLine(
                cursorStart,
                line.start,
                line.end + 1
            ) && i == editLines.size - 1
            val isEndLine = cursorOnLine(cursorEnd, line.start, line.end)
            if (isStartLine || isEndLine || cursorEnd > line.end && cursorStart < line.start) {
                val cIdx = (cursorStart - line.start).coerceIn( 0, len)
                val ceIdx = (cursorEnd - line.start).coerceIn(0, len)
                lt = Text.escapeJagex(text.substring(0, cIdx))
                mt = Text.escapeJagex(text.substring(cIdx, ceIdx))
                rt = Text.escapeJagex(text.substring(ceIdx))
            }
            val ltw = font.getTextWidth(lt)
            val mtw = font.getTextWidth(mt)
            val rtw = font.getTextWidth(rt)
            val fullWidth = ltw + mtw + rtw
            var ltx = x
            if (w > 0) {
                ltx += (w - fullWidth) / 2
            }
            val mtx = ltx + ltw
            val rtx = mtx + mtw
            if (ltx < bounds.x) {
                bounds.setLocation(ltx, bounds.y)
            }
            if (fullWidth > bounds.width) {
                bounds.setSize(fullWidth, bounds.height)
            }
            if (editLines.size == 0 || isStartLine) {
                cursor.originalX = mtx - 1
                cursor.originalY = y
                cursor.originalWidth = 2
                cursor.originalHeight = h
                cursor.revalidate()
            }
            if (!lt.isNullOrEmpty()) {
                val leftText = container.createChild(-1, WidgetType.TEXT)
                leftText.fontId = fontID
                leftText.text = lt
                leftText.originalX = ltx
                leftText.originalY = y
                leftText.originalWidth = ltw
                leftText.originalHeight = h
                leftText.revalidate()
            }
            if (!mt.isNullOrEmpty()) {
                val background = container.createChild(-1, WidgetType.RECTANGLE)
                background.textColor = 0x113399
                background.isFilled = true
                background.originalX = mtx - 1
                background.originalY = y
                background.originalWidth = 2 + mtw
                background.originalHeight = h
                background.revalidate()
                val middleText = container.createChild(-1, WidgetType.TEXT)
                middleText.text = mt
                middleText.fontId = fontID
                middleText.originalX = mtx
                middleText.originalY = y
                middleText.originalWidth = mtw

                middleText.originalHeight = h
                middleText.textColor = 0xFFFFFF
                middleText.revalidate()
            }
            if (!rt.isNullOrEmpty()) {
                val rightText = container.createChild(-1, WidgetType.TEXT)
                rightText.text = rt
                rightText.fontId = fontID
                rightText.originalX = rtx
                rightText.originalY = y
                rightText.originalWidth = rtw
                rightText.originalHeight = h
                rightText.revalidate()
            }
            y += h
            i++
        }
        val ccl = container.canvasLocation
        isInBounds =  { ev: MouseEvent -> bounds.contains(Point(ev.x - ccl.x, ev.y - ccl.y)) }
        getPointCharOffset = label@{ p: Point ->
            if (bounds.width <= 0) {
                return@label 0
            }
            var cx = p.x - ccl.x - x
            val cy = p.y - ccl.y - oy
            val currentLine = (cy / oh).coerceIn( 0, (editLines.size - 1))
            val line = editLines[currentLine]
            val tsValue = line.text
            var charIndex = tsValue!!.length
            val fullWidth = font.getTextWidth(tsValue)
            var tx = x
            if (w > 0) {
                tx += (w - fullWidth) / 2
            }
            cx -= tx

            // `i` is used to track max execution time incase there is a font with ligature width data that causes this to fail
            var i = tsValue.length

            whileLabel@ while  (i >= 0 && charIndex >= 0 && charIndex <= tsValue.length) {
                val lcx = if (charIndex > 0) font.getTextWidth(
                    Text.escapeJagex(
                        tsValue.substring(
                            0,
                            charIndex - 1
                        )
                    )
                ) else 0
                val mcx =
                    font.getTextWidth(Text.escapeJagex(tsValue.substring(0, charIndex)))
                val rcx = if (charIndex + 1 <= tsValue.length) font.getTextWidth(
                    Text.escapeJagex(
                        tsValue.substring(0, charIndex + 1)
                    )
                ) else mcx
                val leftBound = (lcx + mcx) / 2
                val rightBound = (mcx + rcx) / 2
                if (cx < leftBound) {
                    charIndex--
                    i--
                    continue
                }
                if (cx > rightBound) {
                    charIndex++
                    i--
                    continue
                }
                break@whileLabel

            }
            charIndex = charIndex.coerceIn(0, tsValue.length)
            line.start + charIndex
        }
        getLineOffset = label@ { code: Int ->
            if (editLines.size < 2) {
                return@label cursorStart
            }
            var currentLine = -1
            var i = 0
            while (i < editLines.size) {
                val l = editLines[i]
                if (cursorOnLine(cursorStart, l.start, l.end) || cursorOnLine(
                        cursorStart,
                        l.start,
                        l.end + 1
                    ) && i == editLines.size - 1
                ) {
                    currentLine = i
                    break
                }
                i++
            }
            if (currentLine == -1 || code == KeyEvent.VK_UP && currentLine == 0 || code == KeyEvent.VK_DOWN && currentLine == editLines.size - 1) {
                return@label cursorStart
            }
            val line = editLines[currentLine]
            val direction = if (code == KeyEvent.VK_UP) -1 else 1
            val dest = Point(cursor.canvasLocation.x, cursor.canvasLocation.y + direction * oh)
            val charOffset = getPointCharOffset!!(dest)

            // Place cursor on right line if whitespace keep it on the same line or skip a line
            val nextLine = editLines[currentLine + direction]
            if(direction == -1 && charOffset >= line.start) {
                return@label nextLine.end
            }else if (charOffset > nextLine.end && currentLine + direction != editLines.size - 1)
                return@label nextLine.end
            charOffset
        }
    }

    private fun cursorOnLine(cursor: Int, start: Int, end: Int): Boolean {
        return cursor in start..end
    }

    private fun getCharOffset(ev: MouseEvent): Int {
        return if (getPointCharOffset == null) {
            0
        } else getPointCharOffset!!(ev.point)
    }

    override fun open() {
        built = true
        update()
    }

    override fun close() {
        if (onClose != null) {
            onClose?.invoke()
        }
    }

    fun build(): ChatboxTextInput {
        checkNotNull(prompt) { "prompt must be non-null" }
        chatboxPanelManager.openInput(this)
        return this
    }

    override fun keyTyped(e: KeyEvent) {
        if (!chatboxPanelManager.shouldTakeInput()) {
            return
        }
        val c = e.keyChar
        if (charValidator(c.code)!!) {
            if (cursorStart != cursorEnd) {
                value.delete(cursorStart, cursorEnd)
            }
            value.insert(cursorStart, c)
            cursorAt(cursorStart + 1)
            if(onChanged != null) {
                onChanged!!(getValue())
            }

        }
    }

    override fun keyPressed(ev: KeyEvent) {
        if (!chatboxPanelManager.shouldTakeInput()) {
            return
        }
        val code = ev.keyCode
        if (ev.isControlDown) {
            when (code) {
                KeyEvent.VK_X, KeyEvent.VK_C -> {
                    if (cursorStart != cursorEnd) {
                        val s = value.substring(cursorStart, cursorEnd)
                        if (code == KeyEvent.VK_X) {
                            value.delete(cursorStart, cursorEnd)
                            cursorAt(cursorStart)
                        }
                        Toolkit.getDefaultToolkit()
                            .systemClipboard
                            .setContents(StringSelection(s), null)
                    }
                    return
                }
                KeyEvent.VK_V -> {
                    try {
                        val s = Toolkit.getDefaultToolkit()
                            .systemClipboard
                            .getData(DataFlavor.stringFlavor)
                            .toString()
                        if (cursorStart != cursorEnd) {
                            value.delete(cursorStart, cursorEnd)
                        }
                        var i = 0
                        while (i < s.length) {
                            val ch = s[i]
                            if (charValidator(ch.code)!!) {
                                value.insert(cursorStart, ch)
                                cursorStart++
                            }
                            i++
                        }
                        cursorAt(cursorStart)
                        if(onChanged != null) {
                            onChanged!!(getValue())
                        }

                    } catch (ex: IOException) {
                       // ChatboxTextInput.log.warn("Unable to get clipboard", ex)
                    } catch (ex: UnsupportedFlavorException) {
                       // ChatboxTextInput.log.warn("Unable to get clipboard", ex)
                    }
                    return
                }
                KeyEvent.VK_A -> {
                    selectionStart = 0
                    selectionEnd = value.length
                    cursorAt(0, selectionEnd)
                    return
                }
            }
            return
        }
        var newPos = cursorStart
        if (ev.isShiftDown) {
            if (selectionEnd == -1 || selectionStart == -1) {
                selectionStart = cursorStart
                selectionEnd = cursorStart
            }
            newPos = selectionEnd
        } else {
            selectionStart = -1
            selectionEnd = -1
        }
        when (code) {
            KeyEvent.VK_DELETE -> {
                if (cursorStart != cursorEnd) {
                    value.delete(cursorStart, cursorEnd)
                    cursorAt(cursorStart)
                    if(onChanged != null) {
                        onChanged!!(getValue())
                    }
                    return
                }
                if (cursorStart < value.length) {
                    value.deleteCharAt(cursorStart)
                    cursorAt(cursorStart)
                    if(onChanged != null) {
                        onChanged!!(getValue())
                    }
                }
                return
            }
            KeyEvent.VK_BACK_SPACE -> {
                if (cursorStart != cursorEnd) {
                    value.delete(cursorStart, cursorEnd)
                    cursorAt(cursorStart)
                    if(onChanged != null) {
                        onChanged!!(getValue())
                    }
                    return
                }
                if (cursorStart > 0) {
                    value.deleteCharAt(cursorStart - 1)
                    cursorAt(cursorStart - 1)
                    if(onChanged != null) {
                        onChanged!!(getValue())
                    }
                }
                return
            }
            KeyEvent.VK_LEFT -> {
                ev.consume()
                if (cursorStart != cursorEnd) {
                    newPos = cursorStart
                } else {
                    newPos--
                }
            }
            KeyEvent.VK_RIGHT -> {
                ev.consume()
                if (cursorStart != cursorEnd) {
                    newPos = cursorEnd
                } else {
                    newPos++
                }
            }
            KeyEvent.VK_UP -> {
                ev.consume()
                newPos = getLineOffset!!(code)
            }
            KeyEvent.VK_DOWN -> {
                ev.consume()
                newPos = getLineOffset!!(code)
            }
            KeyEvent.VK_HOME -> {
                ev.consume()
                newPos = 0
            }
            KeyEvent.VK_END -> {
                ev.consume()
                newPos = value.length
            }
            KeyEvent.VK_ENTER -> {
                ev.consume()
                if ( !onDone(getValue())!!)
                chatboxPanelManager.close()
                return
            }
            KeyEvent.VK_ESCAPE -> {
                ev.consume()
                if (cursorStart != cursorEnd) {
                    cursorAt(cursorStart)
                    return
                }
                chatboxPanelManager.close()
                return
            }
            else -> return
        }
        if (newPos > value.length) {
            newPos = value.length
        }
        if (newPos < 0) {
            newPos = 0
        }
        if (ev.isShiftDown) {
            selectionEnd = newPos
            cursorAt(selectionStart, newPos)
        } else {
            cursorAt(newPos)
        }
    }

    override fun keyReleased(e: KeyEvent) {}
    override fun mouseClicked(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    override fun mousePressed(mouseEvent: MouseEvent): MouseEvent {
        if (mouseEvent.button != MouseEvent.BUTTON1) {
            return mouseEvent
        }
        if (!isInBounds(mouseEvent)!!) {
            if (cursorStart != cursorEnd) {
                selectionStart = -1
                selectionEnd = -1
                cursorAt(getCharOffset(mouseEvent))
            }
            return mouseEvent
        }
        val nco = getCharOffset(mouseEvent)
        if (mouseEvent.isShiftDown && selectionEnd != -1) {
            selectionEnd = nco
            cursorAt(selectionStart, selectionEnd)
        } else {
            selectionStart = nco
            cursorAt(nco)
        }
        return mouseEvent
    }

    override fun mouseReleased(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    override fun mouseEntered(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    override fun mouseExited(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }

    override fun mouseDragged(mouseEvent: MouseEvent): MouseEvent {
        if (!SwingUtilities.isLeftMouseButton(mouseEvent)) {
            return mouseEvent
        }
        val nco = getCharOffset(mouseEvent)
        if (selectionStart != -1) {
            selectionEnd = nco
            cursorAt(selectionStart, selectionEnd)
        }
        return mouseEvent
    }

    override fun mouseMoved(mouseEvent: MouseEvent): MouseEvent {
        return mouseEvent
    }
    private val CURSOR_FLASH_RATE_MILLIS = 1000
    private val BREAK_MATCHER = Pattern.compile("[^a-zA-Z\\d']")
    private val defaultCharValidator: (Int)-> Boolean
        get() = { i: Int -> i in 32..126 }

}