/*
 * Copyright (c) 2017, Mitchell <https://github.com/Mitchell-Kovacs>
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

import java.util.function.Predicate


internal enum class ItemChargeType(val enabled: Predicate<ItemChargeConfig>? = null
) {
    ABYSSAL_BRACELET(Predicate { obj: ItemChargeConfig -> obj.showAbyssalBraceletCharges() }), AMULET_OF_CHEMISTRY(
        Predicate { obj: ItemChargeConfig -> obj.showAmuletOfChemistryCharges() }),
    AMULET_OF_BOUNTY(
        Predicate { obj: ItemChargeConfig -> obj.showAmuletOfBountyCharges() }),
    BELLOWS(
        Predicate { obj: ItemChargeConfig -> obj.showBellowCharges() }),
    BRACELET_OF_SLAUGHTER(
        Predicate { obj: ItemChargeConfig -> obj.showBraceletOfSlaughterCharges() }),
    EXPEDITIOUS_BRACELET(
        Predicate { obj: ItemChargeConfig -> obj.showExpeditiousBraceletCharges() }),
    FUNGICIDE_SPRAY(
        Predicate { obj: ItemChargeConfig -> obj.showFungicideCharges() }),
    IMPBOX(
        Predicate { obj: ItemChargeConfig -> obj.showImpCharges() }),
    TELEPORT(
        Predicate { obj: ItemChargeConfig -> obj.showTeleportCharges() }),
    WATERCAN(
        Predicate { obj: ItemChargeConfig -> obj.showWateringCanCharges() }),
    WATERSKIN(
        Predicate { obj: ItemChargeConfig -> obj.showWaterskinCharges() }),
    DODGY_NECKLACE(
        Predicate { obj: ItemChargeConfig -> obj.showDodgyCount() }),
    BINDING_NECKLACE(
        Predicate { obj: ItemChargeConfig -> obj.showBindingNecklaceCharges() }),
    EXPLORER_RING(
        Predicate { obj: ItemChargeConfig -> obj.showExplorerRingCharges() }),
    FRUIT_BASKET(
        Predicate { obj: ItemChargeConfig -> obj.showBasketCharges() }),
    SACK(Predicate { obj: ItemChargeConfig -> obj.showSackCharges() }), RING_OF_FORGING(
        Predicate { obj: ItemChargeConfig -> obj.showRingOfForgingCount() }),
    POTION(
        Predicate { obj: ItemChargeConfig -> obj.showPotionDoseCount() }),
    GUTHIX_REST(
        Predicate { obj: ItemChargeConfig -> obj.showGuthixRestDoses() }),
    BLOOD_ESSENCE(
        Predicate { obj: ItemChargeConfig -> obj.showBloodEssenceCharges() }),
    BRACELET_OF_CLAY(
        Predicate { obj: ItemChargeConfig -> obj.showBraceletOfClayCharges() });

}