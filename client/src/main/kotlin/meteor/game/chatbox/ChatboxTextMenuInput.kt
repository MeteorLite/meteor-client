
package meteor.game.chatbox

import meteor.input.KeyListener
import net.runelite.api.FontID
import net.runelite.api.widgets.*
import java.awt.event.KeyEvent

object ChatboxTextMenuInput :
    ChatboxInput(), KeyListener {
    data class Entry(val text: String, val callback: (()->Unit)?) {
    }
    private val chatboxPanelManager = ChatboxPanelManager

    private var title: String? = null
    private val options: MutableList<Entry> = ArrayList()
    private var onClose: (() -> Unit?)? = null
    fun title(title: String?): ChatboxTextMenuInput {
        this.title = title
        return this
    }

    fun option(text: String, callback: (() -> Unit)?): ChatboxTextMenuInput {
        options.add(Entry(text, callback))
        return this
    }

    fun onClose(onClose: ()->Unit?): ChatboxTextMenuInput {
        this.onClose = onClose
        return this
    }

    fun build(): ChatboxTextMenuInput {
        checkNotNull(title) { "Title must be set" }
        check(options.size >= 1) { "You must have atleast 1 option" }
        chatboxPanelManager.openInput(this)
        return this
    }

    override fun open() {
        val container = chatboxPanelManager.containerWidget
        val prompt = container!!.createChild(-1, WidgetType.TEXT)
        prompt.text = title
        prompt.textColor = 0x800000
        prompt.fontId = FontID.QUILL_8
        prompt.xPositionMode = WidgetPositionMode.ABSOLUTE_CENTER
        prompt.originalX = 0
        prompt.yPositionMode = WidgetPositionMode.ABSOLUTE_TOP
        prompt.originalY = 8
        prompt.originalHeight = 24
        prompt.xTextAlignment = WidgetTextAlignment.CENTER
        prompt.yTextAlignment = WidgetTextAlignment.CENTER
        prompt.widthMode = WidgetSizeMode.MINUS
        prompt.revalidate()
        var y = prompt.relativeX + prompt.height + 6
        val height = container.height - y - 8
        var step = height / options.size
        val maxStep = if (options.size >= 3) 25 else 30
        if (step > maxStep) {
            val ds = step - maxStep
            step = maxStep
            y += ds * options.size / 2
        }
        for (option in options) {
            val optWidget = container.createChild(-1, WidgetType.TEXT)
            optWidget.text = option.text
            optWidget.fontId = FontID.QUILL_8
            optWidget.xPositionMode = WidgetPositionMode.ABSOLUTE_CENTER
            optWidget.originalX = 0
            optWidget.yPositionMode = WidgetPositionMode.ABSOLUTE_TOP
            optWidget.originalY = y
            optWidget.originalHeight = 24
            optWidget.xTextAlignment = WidgetTextAlignment.CENTER
            optWidget.yTextAlignment = WidgetTextAlignment.CENTER
            optWidget.widthMode = WidgetSizeMode.MINUS
            optWidget.setAction(0, "Continue")
            optWidget.setOnOpListener(JavaScriptCallback { callback(option) })
            optWidget.setOnMouseOverListener(JavaScriptCallback { optWidget.textColor = 0xFFFFFF })
            optWidget.setOnMouseLeaveListener(JavaScriptCallback { optWidget.textColor = 0 })
            optWidget.setHasListener(true)
            optWidget.revalidate()
            y += step
        }
    }

    private fun callback(entry: Entry) {
        val container = chatboxPanelManager.containerWidget
        container!!.setOnKeyListener()
        chatboxPanelManager.close()
        entry.callback?.invoke()
    }

    override fun close() {
        if (onClose != null) {
            onClose!!.invoke()
        }
    }

    override fun keyTyped(e: KeyEvent) {
        if (!chatboxPanelManager.shouldTakeInput()) {
            return
        }
        val c = e.keyChar
        if (c == '\u001b') {
            chatboxPanelManager.close()
            e.consume()
            return
        }
        val n = c.code - '1'.code
        if (n >= 0 && n < options.size) {
            callback(options[n])
            e.consume()
        }
    }

    override fun keyPressed(e: KeyEvent) {
        if (!chatboxPanelManager.shouldTakeInput()) {
            return
        }
        if (e.keyCode == KeyEvent.VK_ESCAPE) {
            e.consume()
        }
    }

    override fun keyReleased(e: KeyEvent) {}
}