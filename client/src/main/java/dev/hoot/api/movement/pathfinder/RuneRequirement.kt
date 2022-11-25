package dev.hoot.api.movement.pathfinder

import dev.hoot.api.magic.Rune
import lombok.Value

@Value
class RuneRequirement(var quantity: Int = 0, var rune: Rune? = null) {
    fun meetsRequirements(): Boolean {
        return rune!!.quantity >= quantity
    }
}