package meteor.api.movement.pathfinder

import meteor.api.magic.Rune


data class RuneRequirement(var quantity: Int = 0, var rune: Rune? = null) {
    fun meetsRequirements(): Boolean {
        return rune!!.quantity >= quantity
    }
}