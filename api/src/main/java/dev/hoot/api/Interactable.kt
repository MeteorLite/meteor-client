package dev.hoot.api


import dev.hoot.api.events.AutomatedMenu
import net.runelite.api.Client
import net.runelite.api.Point
import java.util.*

interface Interactable {
    companion object{
        var client: Client? = null
    }

    val clickPoint: java.awt.Point
    fun getActionOpcode(action: Int): Int
    val rawActions: Array<String?>?
    fun interact(predicate: (String)-> Boolean) {
        val raw = rawActions
        if (raw != null) {
            for (i in raw.indices) {
                if (raw[i]?.let { predicate(it) } == true) {
                    interact(i)
                    return
                }
            }
        }
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
    fun hasAction(vararg actions: String): Boolean? {
        val raw = this.rawActions
            return if (actions.isEmpty()) {
                raw?.any { it: String? -> Objects.nonNull(it) }
            } else actions.any {
                actions.toList().contains(it)
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