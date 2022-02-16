package meteor.api.widgets

import Main.client
import meteor.api.commons.Time
import meteor.api.game.GameThread
import meteor.api.input.Keyboard
import meteor.api.items.GrandExchange
import net.runelite.api.widgets.Widget
import net.runelite.api.widgets.WidgetID
import net.runelite.api.widgets.WidgetInfo
import java.util.*
import java.util.function.Supplier

object Dialog {
    private val DIALOG = Supplier { Widgets.get(162, 557) }
    private val WEIRD_CONT = Supplier { Widgets.get(193, 3) }
    private val WEIRD_CONT_2 = Supplier { Widgets.get(633, 0) }
    private val NPC_CONT = Supplier { Widgets.get(WidgetID.DIALOG_NPC_GROUP_ID, 4) }
    private val PLAYER_CONT = Supplier { Widgets.get(WidgetID.DIALOG_PLAYER_GROUP_ID, 3) }
    private val DEATH_CONT = Supplier { Widgets.get(663, 0) }
    private val TUT_CONT = Supplier { Widgets.get(229, 2) }
    private val OPTIONS = Supplier { Widgets.get(WidgetID.DIALOG_OPTION_GROUP_ID, 1) }

    // Tutorial island continue dialogs
    fun continueTutorial() {
        GameThread.invoke { client.runScript(299, 1, 1, 1) }
    }

    val isOpen: Boolean
        get() {
            val widget = DIALOG.get()
            return widget == null || widget.isHidden
        }

    fun canContinue(): Boolean {
        return (canContinueNPC() || canContinuePlayer() || canContinueDeath()
                || canWeirdContinue() || canWeirderContinue() || canWeirdestContinue() || canContinueTutIsland() || canContinueTutIsland2()
                || canContinueTutIsland3() || canLevelUpContinue())
    }

    fun canLevelUpContinue(): Boolean {
        val widget = Widgets.get(WidgetInfo.LEVEL_UP_LEVEL)
        return widget != null && !widget.isHidden
    }

    fun canWeirdContinue(): Boolean {
        val widget = Widgets.get(WidgetInfo.DIALOG2_SPRITE_CONTINUE)
        return widget != null && !widget.isHidden
    }

    fun canWeirderContinue(): Boolean {
        val widget = WEIRD_CONT.get()
        return widget != null && !widget.isHidden
    }

    fun canWeirdestContinue(): Boolean {
        val widget = WEIRD_CONT_2.get()
        return widget != null && !widget.isHidden
    }

    fun canContinueNPC(): Boolean {
        val widget = NPC_CONT.get()
        return widget != null && !widget.isHidden
    }

    fun canContinuePlayer(): Boolean {
        val widget = PLAYER_CONT.get()
        return widget != null && !widget.isHidden
    }

    fun canContinueDeath(): Boolean {
        val widget = DEATH_CONT.get()
        return widget != null && (!widget.isHidden
                && widget.getChild(2) != null && !widget.getChild(2).isHidden)
    }

    fun canContinueTutIsland(): Boolean {
        val widget = TUT_CONT.get()
        return widget != null && !widget.isHidden
    }

    fun canContinueTutIsland2(): Boolean {
        val widget = Widgets.get(WidgetInfo.DIALOG_SPRITE)
        return (widget != null
                && (!widget.isHidden
                && widget.getChild(2) != null && !widget.getChild(2).isHidden))
    }

    fun canContinueTutIsland3(): Boolean {
        val widget = Widgets.get(WidgetInfo.CHATBOX_FULL_INPUT)
        return (widget != null && !widget.isHidden
                && widget.text.lowercase(Locale.getDefault()).contains("continue"))
    }

    val isEnterInputOpen: Boolean
        get() {
            val widget = Widgets.get(WidgetInfo.CHATBOX_FULL_INPUT)
            return widget != null && widget.isHidden && !GrandExchange.isSearchingItem
        }

    fun enterInput(input: String) {
        Time.sleepUntil({ isEnterInputOpen }, 2000)
        if (isEnterInputOpen) {
            Keyboard.type(input, true)
        }
    }

    fun enterInput(input: Int) {
        enterInput(input.toString())
    }

    val isViewingOptions: Boolean
        get() = !options.isEmpty()

    fun continueSpace() {
        if (isOpen) {
            Keyboard.sendSpace()
        }
    }

    fun chooseOption(index: Int): Boolean {
        if (isViewingOptions) {
            Keyboard.type(index)
            return true
        }
        return false
    }

    fun chooseOption(vararg options: String?): Boolean {
        if (isViewingOptions) {
            for (i in Dialog.options.indices) {
                val widget = Dialog.options[i]
                for (option in options) {
                    if (widget.text.contains(option!!)) {
                        return chooseOption(i + 1)
                    }
                }
            }
        }
        return false
    }

    // Skip first child, it's not a dialog option
    val options: List<Widget>
        get() {
            val widget = OPTIONS.get()
            if (widget == null || widget.isHidden) {
                return emptyList()
            }
            val out: MutableList<Widget> = ArrayList()
            val children = widget.children ?: return out

            // Skip first child, it's not a dialog option
            for (i in 1 until children.size) {
                if (children[i].text.isBlank()) {
                    continue
                }
                out.add(children[i])
            }
            return out
        }

    fun quickProcess(vararg dialogOption: DialogOption) {
        GameThread.invokeLater {
            for (option in dialogOption) {
                option.process()
            }
            true
        }
    }
}