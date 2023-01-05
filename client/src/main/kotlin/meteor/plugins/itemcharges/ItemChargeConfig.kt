/*
 * Copyright (c) 2017, Devin French <https://github.com/devinfrench>
 * Copyright (c) 2019, Aleios <https://github.com/aleios>
 * Copyright (c) 2020, Unmoon <https://github.com/unmoon>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.itemcharges

import meteor.config.legacy.Config
import meteor.config.legacy.ConfigGroup
import meteor.config.legacy.ConfigItem
import meteor.config.legacy.ConfigSection
import java.awt.Color

@ConfigGroup("itemCharge")
interface ItemChargeConfig : Config {
    @ConfigItem(
        keyName = "veryLowWarningColor",
        name = "Very Low Warning",
        description = "The color of the overlay when charges are very low",
        position = 1
    )
    fun veryLowWarningColor(): Color? {
        return Color.RED
    }

    @ConfigItem(
        keyName = "lowWarningColor",
        name = "Low Warning",
        description = "The color of the overlay when charges are low",
        position = 2
    )
    fun lowWarningolor(): Color? {
        return Color.YELLOW
    }

    @ConfigItem(
        keyName = "veryLowWarning",
        name = "Very Low Warning",
        description = "The charge count for the very low warning color",
        position = 3
    )
    fun veryLowWarning(): Int {
        return 1
    }

    @ConfigItem(
        keyName = "lowWarning",
        name = "Low Warning",
        description = "The charge count for the low warning color",
        position = 4
    )
    fun lowWarning(): Int {
        return 2
    }

    @ConfigItem(
        keyName = "showTeleportCharges",
        name = "Teleport Charges",
        description = "Show teleport item charge counts",
        position = 5,
        section = "Charge Settings"
    )
    fun showTeleportCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showDodgyCount",
        name = "Dodgy Necklace Count",
        description = "Show Dodgy necklace charges",
        position = 6,
        section = "Charge Settings"
    )
    fun showDodgyCount(): Boolean {
        return true
    }


    @ConfigItem(
        keyName = "showImpCharges",
        name = "Imp-in-a-box charges",
        description = "Show Imp-in-a-box item charges",
        position = 8,
        section = "Charge Settings"
    )
    fun showImpCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showFungicideCharges",
        name = "Fungicide Charges",
        description = "Show Fungicide item charges",
        position = 9,
        section = "Charge Settings"
    )
    fun showFungicideCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showWateringCanCharges",
        name = "Watering Can Charges",
        description = "Show Watering can item charges",
        position = 10,
        section = "Charge Settings"
    )
    fun showWateringCanCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showWaterskinCharges",
        name = "Waterskin Charges",
        description = "Show Waterskin dose counts",
        position = 11,
        section = "Charge Settings"
    )
    fun showWaterskinCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showBellowCharges",
        name = "Bellows Charges",
        description = "Show Ogre bellows item charges",
        position = 12,
        section = "Charge Settings"
    )
    fun showBellowCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showBasketCharges",
        name = "Basket Charges",
        description = "Show Fruit basket item counts",
        position = 13,
        section = "Charge Settings"
    )
    fun showBasketCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showSackCharges",
        name = "Sack Charges",
        description = "Show Sack item counts",
        position = 14,
        section = "Charge Settings"
    )
    fun showSackCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showAbyssalBraceletCharges",
        name = "Abyssal Bracelet Charges",
        description = "Show Abyssal bracelet item charges",
        position = 15,
        section = "Charge Settings"
    )
    fun showAbyssalBraceletCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showAmuletOfChemistryCharges",
        name = "Amulet of Chemistry Charges",
        description = "Show Amulet of chemistry item charges",
        position = 16,
        section = "Charge Settings"
    )
    fun showAmuletOfChemistryCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showAmuletOfBountyCharges",
        name = "Amulet of Bounty Charges",
        description = "Show Amulet of bounty item charges",
        position = 17,
        section = "Charge Settings"
    )
    fun showAmuletOfBountyCharges(): Boolean {
        return true
    }


    @ConfigItem(
        keyName = "showBindingNecklaceCharges",
        name = "Binding Necklace Charges",
        description = "Show Binding necklace item charges",
        position = 19,
        section = "Charge Settings"
    )
    fun showBindingNecklaceCharges(): Boolean {
        return true
    }


    @ConfigItem(
        keyName = "showExplorerRingCharges",
        name = "Explorer's Ring Alch Charges",
        description = "Show Explorer's ring alchemy charges",
        position = 21,
        section = "Charge Settings"
    )
    fun showExplorerRingCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showRingOfForgingCount",
        name = "Ring of Forging Charges",
        description = "Show Ring of forging item charges",
        position = 22,
        section = "Charge Settings"
    )
    fun showRingOfForgingCount(): Boolean {
        return true
    }


    @ConfigItem(
        keyName = "showInfoboxes",
        name = "Infoboxes",
        description = "Show an infobox with remaining charges for equipped items",
        position = 24
    )
    fun showInfoboxes(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "showPotionDoseCount",
        name = "Potion Doses",
        description = "Show remaining potion doses",
        position = 25,
        section = "Charge Settings"
    )
    fun showPotionDoseCount(): Boolean {
        return false
    }

    @ConfigItem(
        keyName = "showBraceletOfSlaughterCharges",
        name = "Bracelet of Slaughter Charges",
        description = "Show Bracelet of Slaughter item charges",
        position = 26,
        section = "Charge Settings"
    )
    fun showBraceletOfSlaughterCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showExpeditiousBraceletCharges",
        name = "Expeditious Bracelet Charges",
        description = "Show Expeditious Bracelet item charges",
        position = 28,
        section = "Charge Settings"
    )
    fun showExpeditiousBraceletCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showGuthixRestDoses",
        name = "Guthix Rest Doses",
        description = "Show Guthix Rest doses",
        position = 29,
        section = "Charge Settings"
    )
    fun showGuthixRestDoses(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showBloodEssenceCharges",
        name = "Blood Essence Charges",
        description = "Show Blood Essence charges",
        position = 30,
        section = "Charge Settings"
    )
    fun showBloodEssenceCharges(): Boolean {
        return true
    }

    @ConfigItem(
        keyName = "showBraceletOfClayCharges",
        name = "Bracelet of Clay Charges",
        description = "Show Bracelet of Clay item charges",
        position = 31,
        section = "Charge Settings"
    )
    fun showBraceletOfClayCharges(): Boolean {
        return true
    }

    @ConfigSection(
        name = "Charge Settings",
        description = "Configuration for which charges should be displayed",
        position = 98
    )
    val chargesSection: String

    companion object {
        const val GROUP = "itemCharge"
        const val GROUP2 = "itemCharge2"
        const val KEY_AMULET_OF_BOUNTY = "amuletOfBounty"
        const val KEY_AMULET_OF_CHEMISTRY = "amuletOfChemistry"
        const val KEY_BINDING_NECKLACE = "bindingNecklace"
        const val KEY_BRACELET_OF_SLAUGHTER = "braceletOfSlaughter"
        const val KEY_CHRONICLE = "chronicle"
        const val KEY_DODGY_NECKLACE = "dodgyNecklace"
        const val KEY_EXPEDITIOUS_BRACELET = "expeditiousBracelet"
        const val KEY_EXPLORERS_RING = "explorerRing"
        const val KEY_RING_OF_FORGING = "ringOfForging"
        const val KEY_BLOOD_ESSENCE = "bloodEssence"
        const val KEY_BRACELET_OF_CLAY = "braceletOfClay"

    }
}