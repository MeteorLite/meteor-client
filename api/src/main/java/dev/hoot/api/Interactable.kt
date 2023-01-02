package dev.hoot.api


import dev.hoot.api.events.AutomatedMenu
import net.runelite.api.Client

interface Interactable {
    companion object{
        var client: Client? = null
    }

    val clickPoint: java.awt.Point
    fun getActionOpcode(action: Int): Int
    val rawActions: Array<String?>?
    infix fun interact(actionPredicate: (String) -> Boolean) {
        val actions = ArrayList<String>()
        this.rawActions?.forEach {
            if (it == null) actions.add("null") else actions.add(it)
        }
        val index = actions.indexOfFirst(actionPredicate)
        if (index == -1) {
            return
        }
        interact(index)
    }

    infix fun interact(action: String) {
        val actions = ArrayList<String>()
        this.rawActions?.forEach {
            if (it ==null) actions.add("null") else actions.add(it)
        }
        val index = actions.indexOf(action)
        if (index == -1) {
            return
        }
        interact(index)
    }

   infix fun interact(index: Int)
    fun interact(index: Int, opcode: Int)
    fun interact(identifier: Int, opcode: Int, param0: Int, param1: Int)
    fun hasAction(vararg actions: String): Boolean {
        val raw = this.rawActions
        return if (actions.isEmpty()) {
            raw?.any { it: String? -> it != null } ?: false
        } else actions.any {
            raw?.contains(it) ?: false
        }
    }

    fun getMenu(actionIndex: Int): AutomatedMenu?
    fun getMenu(actionIndex: Int, opcode: Int): AutomatedMenu?
    fun getActionIndex(action: String?): Int {
        return rawActions!!.toList().indexOf(action)
    }


    fun getMenu(identifier: Int, opcode: Int, param0: Int, param1: Int): AutomatedMenu? {
        return if (this is SceneEntity) {
            AutomatedMenu(
                identifier, opcode, param0, param1, -1, -1,
                this.tag
            )
        } else {
            AutomatedMenu(identifier, opcode, param0, param1, -1, -1)
        }
    }
}