package meteor.api.magic

import meteor.api.items.Equipment
import meteor.api.items.Inventory
import net.runelite.api.Item
import net.runelite.api.ItemID
import java.util.*

enum class Rune(val runeId: Int, vararg runeNames: String) {
    AIR(ItemID.AIR_RUNE, "Air", "Smoke", "Mist", "Dust"), EARTH(
        ItemID.EARTH_RUNE,
        "Earth",
        "Lava",
        "Mud",
        "Dust"
    ),
    FIRE(
        ItemID.FIRE_RUNE, "Fire", "Lava", "Smoke", "Steam"
    ),
    WATER(ItemID.WATER_RUNE, "Water", "Mud", "Steam", "Mist"), MIND(
        ItemID.MIND_RUNE, "Mind"
    ),
    BODY(ItemID.BODY_RUNE, "Body"), COSMIC(ItemID.COSMIC_RUNE, "Cosmic"), CHAOS(ItemID.CHAOS_RUNE, "Chaos"), NATURE(
        ItemID.NATURE_RUNE, "Nature"
    ),
    LAW(ItemID.LAW_RUNE, "Law"), DEATH(ItemID.DEATH_RUNE, "Death"), ASTRAL(ItemID.ASTRAL_RUNE, "Astral"), BLOOD(
        ItemID.BLOOD_RUNE, "Blood"
    ),
    SOUL(ItemID.SOUL_RUNE, "Soul"), WRATH(ItemID.WRATH_RUNE, "Wrath");

    val runeNames: Array<String>?=null



    val quantity: Int
        get() {
            if (isStaffEquipped) {
                return Int.MAX_VALUE
            }
            val rune: Item = Inventory.getFirst { x ->
                x!!.name != null && x.name.contains("rune") &&
                        Arrays.stream(runeNames)
                            .anyMatch { name: String -> x.id === runeId || x.name.contains(name) }
            }
                ?: return 0
            return rune.quantity + RunePouch.getQuantity(this)!!
        }
    private val isStaffEquipped: Boolean
        private get() = Equipment.contains { x ->
            x!!.name != null && x.name.contains(" staff") &&
                    Arrays.stream(values())
                        .anyMatch { v: Rune ->
                            Arrays.stream(v.runeNames)
                                .anyMatch { n: String -> x.name.contains(n) }
                        }
        }
}