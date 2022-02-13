package meteor.api.magic

import meteor.api.game.Vars
import meteor.api.items.Inventory
import java.util.*

object RunePouch {
    private const val SLOT_1_TYPE_BIT = 29
    private const val SLOT_1_QUANTITY_BIT = 1624
    private const val SLOT_2_TYPE_BIT = 1622
    private const val SLOT_2_QUANTITY_BIT = 1625
    private const val SLOT_3_TYPE_BIT = 1623
    private const val SLOT_3_QUANTITY_BIT = 1626
    fun getQuantity(rune: Rune): Int? {
        if (!hasPouch()) {
            return 0
        }
        val runeSlot = Arrays.stream(RuneSlot.values()).filter { x: RuneSlot? ->
            Arrays.stream(rune.runeNames)
                .anyMatch { name: String? ->
                    x!!.runeName != null && x.runeName!!.startsWith(
                        name!!
                    )
                }
        }
            .findFirst()
            .orElse(null) ?: return 0
        return runeSlot.quantity
    }

    fun hasPouch(): Boolean {
        return Inventory.getFirst("Rune pouch") != null
    }

    enum class RuneSlot(val type: Int, val quantityVarbitIdx: Int) {
        FIRST(SLOT_1_TYPE_BIT, SLOT_1_QUANTITY_BIT), SECOND(
            SLOT_2_TYPE_BIT,
            SLOT_2_QUANTITY_BIT
        ),
        THIRD(SLOT_3_TYPE_BIT, SLOT_3_QUANTITY_BIT);

        val runeName: String?
            get() = when (Vars.getBit(type)) {
                1 -> "Air rune"
                2 -> "Water rune"
                3 -> "Earth rune"
                4 -> "Fire rune"
                5 -> "Mind rune"
                6 -> "Chaos rune"
                7 -> "Death rune"
                8 -> "Blood rune"
                9 -> "Cosmic rune"
                10 -> "Nature rune"
                11 -> "Law rune"
                12 -> "Body rune"
                13 -> "Soul rune"
                14 -> "Astral rune"
                15 -> "Mist rune"
                16 -> "Mud rune"
                17 -> "Dust rune"
                18 -> "Lava rune"
                19 -> "Steam rune"
                20 -> "Smoke rune"
                else -> null
            }
        val quantity: Int?
            get() = Vars.getBit(quantityVarbitIdx)
    }
}