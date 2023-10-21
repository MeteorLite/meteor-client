package openrsc.formulae

import openrsc.skills.woodcutting.WoodcuttingDefinition

object WoodcuttingFormulae {
    fun getLog(def: WoodcuttingDefinition, woodcutLevel: Int, axeId: Int): Boolean {
        val roll = Math.random()
        return def.getRate(woodcutLevel, axeId) > roll
    }
}