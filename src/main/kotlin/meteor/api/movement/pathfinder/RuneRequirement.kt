package meteor.api.movement.pathfinder

import meteor.api.magic.Rune

class RuneRequirement(var quantity: Int, var rune: Rune) {
    fun meetsRequirements(): Boolean {
        return rune.quantity >= quantity
    }
}