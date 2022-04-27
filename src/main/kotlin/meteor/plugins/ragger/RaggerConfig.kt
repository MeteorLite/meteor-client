/*
 * Copyright (c) 2019-2020, ganom <https://github.com/Ganom>
 * All rights reserved.
 * Licensed under GPL3, see LICENSE for the full scope.
 */
package meteor.plugins.ragger

import meteor.config.Config
import meteor.config.ConfigAnnotations.ConfigGroup
import meteor.config.ConfigAnnotations.ConfigItem
import net.runelite.api.ItemID
import net.runelite.api.ItemID.*

@ConfigGroup(value = "ragger")
interface RaggerConfig : Config {

    @ConfigItem(
        keyName = "Raglist",
        name = "Raglist",
        description = "Configures the weirdos we want to rag",
        position = 0,
        textField = true
    )
    fun raggedPeople(): String {
        return "KKR VEEL XTC;Bens Pure";
    }

    @ConfigItem(
        position = 1,
        keyName = "tarAmount",
        name = "Amount of tar",
        description = "Amount of tar taken from bank"
    )
    fun tarAmount(): Int {
        return 7
    }

    @ConfigItem(
        position = 2,
        keyName = "salamander",
        name = "Salamander",
        description = "Default salamander to use"
    )
    fun salamander(): Salamander {
        return Salamander.BLACK
    }

    @ConfigItem(
        position = 3,
        keyName = "food",
        name = "Food",
        description = "Items to heal with"
    )
    fun food(): Food {
        return Food.JUG_OF_WINE
    }

    @ConfigItem(
        position = 4,
        keyName = "healAt",
        name = "Heal at",
        description = "When food should be eaten"
    )
    fun healAt(): Int {
        return 60
    }

    @ConfigItem(
        position = 5,
        keyName = "location",
        name = "Location",
        description = "Place the bot will return to if local player dies"
    )
    fun location(): Location {
        return Location.LUMBRIDGE
    }

    enum class Salamander(val itemID: Int) {
        SWAMP(SWAMP_LIZARD), ORANGE(ORANGE_SALAMANDER), RED(RED_SALAMANDER), BLACK(BLACK_SALAMANDER);

        override fun toString(): String {
            return this.name
        }
    }

    enum class Food(var ids: List<Int>) {
        SARADOMIN_BREW(listOf(SARADOMIN_BREW4, SARADOMIN_BREW3, SARADOMIN_BREW2, SARADOMIN_BREW1)),
        SHARK(listOf(ItemID.SHARK)),
        MANTA_RAY(listOf(ItemID.MANTA_RAY)),
        LOBSTER(listOf(ItemID.LOBSTER)),
        JUG_OF_WINE(listOf(ItemID.JUG_OF_WINE));
    }

    enum class Location(var s: String) {
        LUMBRIDGE("Lumbridge"),
        VARROCK_CENTER("Varrock Center"),
        GRAND_EXCHANGE("Grand Exchange"),
        RIMMINGTON("Rimmington"),
        EDGEVILLE("Edgeville"),
        FALADOR_PARK("Falador"),
        FALADOR_CENTER("Falador Center")
    }
}