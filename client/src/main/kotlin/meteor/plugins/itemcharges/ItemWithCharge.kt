/*
 * Copyright (c) 2017, Seth <Sethtroll3@gmail.com>
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

import com.google.common.collect.ImmutableMap
import lombok.AllArgsConstructor
import lombok.Getter
import net.runelite.api.ItemID

@AllArgsConstructor
@Getter
internal enum class ItemWithCharge(val type: ItemChargeType? = null, private val id: Int = 0, val charges: Int = 0
) {
    ABRACE1(ItemChargeType.ABYSSAL_BRACELET, ItemID.ABYSSAL_BRACELET1, 1), ABRACE2(
        ItemChargeType.ABYSSAL_BRACELET,
        ItemID.ABYSSAL_BRACELET2,
        2
    ),
    ABRACE3(ItemChargeType.ABYSSAL_BRACELET, ItemID.ABYSSAL_BRACELET3, 3), ABRACE4(
        ItemChargeType.ABYSSAL_BRACELET,
        ItemID.ABYSSAL_BRACELET4,
        4
    ),
    ABRACE5(ItemChargeType.ABYSSAL_BRACELET, ItemID.ABYSSAL_BRACELET5, 5), ABSORPTION1(
        ItemChargeType.POTION,
        ItemID.ABSORPTION_1,
        1
    ),
    ABSORPTION2(ItemChargeType.POTION, ItemID.ABSORPTION_2, 2), ABSORPTION3(
        ItemChargeType.POTION,
        ItemID.ABSORPTION_3,
        3
    ),
    ABSORPTION4(ItemChargeType.POTION, ItemID.ABSORPTION_4, 4), AGILITY1(
        ItemChargeType.POTION,
        ItemID.AGILITY_POTION1,
        1
    ),
    AGILITY2(ItemChargeType.POTION, ItemID.AGILITY_POTION2, 2), AGILITY3(
        ItemChargeType.POTION,
        ItemID.AGILITY_POTION3,
        3
    ),
    AGILITY4(ItemChargeType.POTION, ItemID.AGILITY_POTION4, 4), ANTI1(
        ItemChargeType.POTION,
        ItemID.ANTIPOISON1,
        1
    ),
    ANTI2(ItemChargeType.POTION, ItemID.ANTIPOISON2, 2), ANTI3(ItemChargeType.POTION, ItemID.ANTIPOISON3, 3), ANTI4(
        ItemChargeType.POTION,
        ItemID.ANTIPOISON4,
        4
    ),
    ANTIDOTE_P1(ItemChargeType.POTION, ItemID.ANTIDOTE1, 1), ANTIDOTE_P2(
        ItemChargeType.POTION,
        ItemID.ANTIDOTE2,
        2
    ),
    ANTIDOTE_P3(ItemChargeType.POTION, ItemID.ANTIDOTE3, 3), ANTIDOTE_P4(
        ItemChargeType.POTION,
        ItemID.ANTIDOTE4,
        4
    ),
    ANTIDOTE_PP1(ItemChargeType.POTION, ItemID.ANTIDOTE1_5958, 1), ANTIDOTE_PP2(
        ItemChargeType.POTION,
        ItemID.ANTIDOTE2_5956,
        2
    ),
    ANTIDOTE_PP3(ItemChargeType.POTION, ItemID.ANTIDOTE3_5954, 3), ANTIDOTE_PP4(
        ItemChargeType.POTION,
        ItemID.ANTIDOTE4_5952,
        4
    ),
    ANCIENT_BR1(ItemChargeType.POTION, ItemID.ANCIENT_BREW1, 1), ANCIENT_BR2(
        ItemChargeType.POTION,
        ItemID.ANCIENT_BREW2,
        2
    ),
    ANCIENT_BR3(ItemChargeType.POTION, ItemID.ANCIENT_BREW3, 3), ANCIENT_BR4(
        ItemChargeType.POTION,
        ItemID.ANCIENT_BREW4,
        4
    ),
    ANTIFIRE1(ItemChargeType.POTION, ItemID.ANTIFIRE_POTION1, 1), ANTIFIRE2(
        ItemChargeType.POTION,
        ItemID.ANTIFIRE_POTION2,
        2
    ),
    ANTIFIRE3(ItemChargeType.POTION, ItemID.ANTIFIRE_POTION3, 3), ANTIFIRE4(
        ItemChargeType.POTION,
        ItemID.ANTIFIRE_POTION4,
        4
    ),
    ANTIVEN1(ItemChargeType.POTION, ItemID.ANTIVENOM1, 1), ANTIVEN2(
        ItemChargeType.POTION,
        ItemID.ANTIVENOM2,
        2
    ),
    ANTIVEN3(ItemChargeType.POTION, ItemID.ANTIVENOM3, 3), ANTIVEN4(
        ItemChargeType.POTION,
        ItemID.ANTIVENOM4,
        4
    ),
    ANTIVENOM_P1(ItemChargeType.POTION, ItemID.ANTIVENOM1_12919, 1), ANTIVENOM_P2(
        ItemChargeType.POTION,
        ItemID.ANTIVENOM2_12917,
        2
    ),
    ANTIVENOM_P3(ItemChargeType.POTION, ItemID.ANTIVENOM3_12915, 3), ANTIVENOM_P4(
        ItemChargeType.POTION,
        ItemID.ANTIVENOM4_12913,
        4
    ),
    ATTACK1(ItemChargeType.POTION, ItemID.ATTACK_POTION1, 1), ATTACK2(
        ItemChargeType.POTION,
        ItemID.ATTACK_POTION2,
        2
    ),
    ATTACK3(ItemChargeType.POTION, ItemID.ATTACK_POTION3, 3), ATTACK4(
        ItemChargeType.POTION,
        ItemID.ATTACK_POTION4,
        4
    ),
    BASKET_APPLES1(ItemChargeType.FRUIT_BASKET, ItemID.APPLES1, 1), BASKET_APPLES2(
        ItemChargeType.FRUIT_BASKET,
        ItemID.APPLES2,
        2
    ),
    BASKET_APPLES3(ItemChargeType.FRUIT_BASKET, ItemID.APPLES3, 3), BASKET_APPLES4(
        ItemChargeType.FRUIT_BASKET,
        ItemID.APPLES4,
        4
    ),
    BASKET_APPLES5(ItemChargeType.FRUIT_BASKET, ItemID.APPLES5, 5), BASKET_BANANAS1(
        ItemChargeType.FRUIT_BASKET,
        ItemID.BANANAS1,
        1
    ),
    BASKET_BANANAS2(ItemChargeType.FRUIT_BASKET, ItemID.BANANAS2, 2), BASKET_BANANAS3(
        ItemChargeType.FRUIT_BASKET,
        ItemID.BANANAS3,
        3
    ),
    BASKET_BANANAS4(ItemChargeType.FRUIT_BASKET, ItemID.BANANAS4, 4), BASKET_BANANAS5(
        ItemChargeType.FRUIT_BASKET,
        ItemID.BANANAS5,
        5
    ),
    BASKET_ORANGES1(ItemChargeType.FRUIT_BASKET, ItemID.ORANGES1, 1), BASKET_ORANGES2(
        ItemChargeType.FRUIT_BASKET,
        ItemID.ORANGES2,
        2
    ),
    BASKET_ORANGES3(ItemChargeType.FRUIT_BASKET, ItemID.ORANGES3, 3), BASKET_ORANGES4(
        ItemChargeType.FRUIT_BASKET,
        ItemID.ORANGES4,
        4
    ),
    BASKET_ORANGES5(ItemChargeType.FRUIT_BASKET, ItemID.ORANGES5, 5), BASKET_STRAWBERRIES1(
        ItemChargeType.FRUIT_BASKET,
        ItemID.STRAWBERRIES1,
        1
    ),
    BASKET_STRAWBERRIES2(
        ItemChargeType.FRUIT_BASKET,
        ItemID.STRAWBERRIES2,
        2
    ),
    BASKET_STRAWBERRIES3(
        ItemChargeType.FRUIT_BASKET,
        ItemID.STRAWBERRIES3,
        3
    ),
    BASKET_STRAWBERRIES4(
        ItemChargeType.FRUIT_BASKET,
        ItemID.STRAWBERRIES4,
        4
    ),
    BASKET_STRAWBERRIES5(
        ItemChargeType.FRUIT_BASKET,
        ItemID.STRAWBERRIES5,
        5
    ),
    BASKET_TOMATOES1(ItemChargeType.FRUIT_BASKET, ItemID.TOMATOES1, 1), BASKET_TOMATOES2(
        ItemChargeType.FRUIT_BASKET,
        ItemID.TOMATOES2,
        2
    ),
    BASKET_TOMATOES3(ItemChargeType.FRUIT_BASKET, ItemID.TOMATOES3, 3), BASKET_TOMATOES4(
        ItemChargeType.FRUIT_BASKET,
        ItemID.TOMATOES4,
        4
    ),
    BASKET_TOMATOES5(ItemChargeType.FRUIT_BASKET, ItemID.TOMATOES5, 5), BASTION1(
        ItemChargeType.POTION,
        ItemID.BASTION_POTION1,
        1
    ),
    BASTION2(ItemChargeType.POTION, ItemID.BASTION_POTION2, 2), BASTION3(
        ItemChargeType.POTION,
        ItemID.BASTION_POTION3,
        3
    ),
    BASTION4(ItemChargeType.POTION, ItemID.BASTION_POTION4, 4), BATTLEMAGE1(
        ItemChargeType.POTION,
        ItemID.BATTLEMAGE_POTION1,
        1
    ),
    BATTLEMAGE2(ItemChargeType.POTION, ItemID.BATTLEMAGE_POTION2, 2), BATTLEMAGE3(
        ItemChargeType.POTION,
        ItemID.BATTLEMAGE_POTION3,
        3
    ),
    BATTLEMAGE4(ItemChargeType.POTION, ItemID.BATTLEMAGE_POTION4, 4), BELLOWS0(
        ItemChargeType.BELLOWS,
        ItemID.OGRE_BELLOWS,
        0
    ),
    BELLOWS1(ItemChargeType.BELLOWS, ItemID.OGRE_BELLOWS_1, 1), BELLOWS2(
        ItemChargeType.BELLOWS,
        ItemID.OGRE_BELLOWS_2,
        2
    ),
    BELLOWS3(ItemChargeType.BELLOWS, ItemID.OGRE_BELLOWS_3, 3), BLIGHTED_SUPER_REST1(
        ItemChargeType.POTION,
        ItemID.BLIGHTED_SUPER_RESTORE1,
        1
    ),
    BLIGHTED_SUPER_REST2(
        ItemChargeType.POTION,
        ItemID.BLIGHTED_SUPER_RESTORE2,
        2
    ),
    BLIGHTED_SUPER_REST3(
        ItemChargeType.POTION,
        ItemID.BLIGHTED_SUPER_RESTORE3,
        3
    ),
    BLIGHTED_SUPER_REST4(ItemChargeType.POTION, ItemID.BLIGHTED_SUPER_RESTORE4, 4), BURNING1(
        ItemChargeType.TELEPORT,
        ItemID.BURNING_AMULET1,
        1
    ),
    BURNING2(ItemChargeType.TELEPORT, ItemID.BURNING_AMULET2, 2), BURNING3(
        ItemChargeType.TELEPORT,
        ItemID.BURNING_AMULET3,
        3
    ),
    BURNING4(ItemChargeType.TELEPORT, ItemID.BURNING_AMULET4, 4), BURNING5(
        ItemChargeType.TELEPORT,
        ItemID.BURNING_AMULET5,
        5
    ),
    CBRACE1(ItemChargeType.TELEPORT, ItemID.COMBAT_BRACELET1, 1), CBRACE2(
        ItemChargeType.TELEPORT,
        ItemID.COMBAT_BRACELET2,
        2
    ),
    CBRACE3(ItemChargeType.TELEPORT, ItemID.COMBAT_BRACELET3, 3), CBRACE4(
        ItemChargeType.TELEPORT,
        ItemID.COMBAT_BRACELET4,
        4
    ),
    CBRACE5(ItemChargeType.TELEPORT, ItemID.COMBAT_BRACELET5, 5), CBRACE6(
        ItemChargeType.TELEPORT,
        ItemID.COMBAT_BRACELET6,
        6
    ),
    COMBAT1(ItemChargeType.POTION, ItemID.COMBAT_POTION1, 1), COMBAT2(
        ItemChargeType.POTION,
        ItemID.COMBAT_POTION2,
        2
    ),
    COMBAT3(ItemChargeType.POTION, ItemID.COMBAT_POTION3, 3), COMBAT4(
        ItemChargeType.POTION,
        ItemID.COMBAT_POTION4,
        4
    ),
    COMPOST1(ItemChargeType.POTION, ItemID.COMPOST_POTION1, 1), COMPOST2(
        ItemChargeType.POTION,
        ItemID.COMPOST_POTION2,
        2
    ),
    COMPOST3(ItemChargeType.POTION, ItemID.COMPOST_POTION3, 3), COMPOST4(
        ItemChargeType.POTION,
        ItemID.COMPOST_POTION4,
        4
    ),
    DEFENCE1(ItemChargeType.POTION, ItemID.DEFENCE_POTION1, 1), DEFENCE2(
        ItemChargeType.POTION,
        ItemID.DEFENCE_POTION2,
        2
    ),
    DEFENCE3(ItemChargeType.POTION, ItemID.DEFENCE_POTION3, 3), DEFENCE4(
        ItemChargeType.POTION,
        ItemID.DEFENCE_POTION4,
        4
    ),
    DIGSITE1(ItemChargeType.TELEPORT, ItemID.DIGSITE_PENDANT_1, 1), DIGSITE2(
        ItemChargeType.TELEPORT,
        ItemID.DIGSITE_PENDANT_2,
        2
    ),
    DIGSITE3(ItemChargeType.TELEPORT, ItemID.DIGSITE_PENDANT_3, 3), DIGSITE4(
        ItemChargeType.TELEPORT,
        ItemID.DIGSITE_PENDANT_4,
        4
    ),
    DIGSITE5(ItemChargeType.TELEPORT, ItemID.DIGSITE_PENDANT_5, 5), DIVINE_BASTION1(
        ItemChargeType.POTION,
        ItemID.DIVINE_BASTION_POTION1,
        1
    ),
    DIVINE_BASTION2(ItemChargeType.POTION, ItemID.DIVINE_BASTION_POTION2, 2), DIVINE_BASTION3(
        ItemChargeType.POTION,
        ItemID.DIVINE_BASTION_POTION3,
        3
    ),
    DIVINE_BASTION4(ItemChargeType.POTION, ItemID.DIVINE_BASTION_POTION4, 4), DIVINE_BATTLEMAGE1(
        ItemChargeType.POTION,
        ItemID.DIVINE_BATTLEMAGE_POTION1,
        1
    ),
    DIVINE_BATTLEMAGE2(
        ItemChargeType.POTION,
        ItemID.DIVINE_BATTLEMAGE_POTION2,
        2
    ),
    DIVINE_BATTLEMAGE3(
        ItemChargeType.POTION,
        ItemID.DIVINE_BATTLEMAGE_POTION3,
        3
    ),
    DIVINE_BATTLEMAGE4(ItemChargeType.POTION, ItemID.DIVINE_BATTLEMAGE_POTION4, 4), DIVINE_MAGIC1(
        ItemChargeType.POTION,
        ItemID.DIVINE_MAGIC_POTION1,
        1
    ),
    DIVINE_MAGIC2(ItemChargeType.POTION, ItemID.DIVINE_MAGIC_POTION2, 2), DIVINE_MAGIC3(
        ItemChargeType.POTION,
        ItemID.DIVINE_MAGIC_POTION3,
        3
    ),
    DIVINE_MAGIC4(ItemChargeType.POTION, ItemID.DIVINE_MAGIC_POTION4, 4), DIVINE_RANGING1(
        ItemChargeType.POTION,
        ItemID.DIVINE_RANGING_POTION1,
        1
    ),
    DIVINE_RANGING2(ItemChargeType.POTION, ItemID.DIVINE_RANGING_POTION2, 2), DIVINE_RANGING3(
        ItemChargeType.POTION,
        ItemID.DIVINE_RANGING_POTION3,
        3
    ),
    DIVINE_RANGING4(
        ItemChargeType.POTION,
        ItemID.DIVINE_RANGING_POTION4,
        4
    ),
    DIVINE_SUPER_ATTACK1(ItemChargeType.POTION, ItemID.DIVINE_SUPER_ATTACK_POTION1, 1), DIVINE_SUPER_ATTACK2(
        ItemChargeType.POTION,
        ItemID.DIVINE_SUPER_ATTACK_POTION2,
        2
    ),
    DIVINE_SUPER_ATTACK3(ItemChargeType.POTION, ItemID.DIVINE_SUPER_ATTACK_POTION3, 3), DIVINE_SUPER_ATTACK4(
        ItemChargeType.POTION,
        ItemID.DIVINE_SUPER_ATTACK_POTION4,
        4
    ),
    DIVINE_SUPER_COMBAT1(ItemChargeType.POTION, ItemID.DIVINE_SUPER_COMBAT_POTION1, 1), DIVINE_SUPER_COMBAT2(
        ItemChargeType.POTION,
        ItemID.DIVINE_SUPER_COMBAT_POTION2,
        2
    ),
    DIVINE_SUPER_COMBAT3(ItemChargeType.POTION, ItemID.DIVINE_SUPER_COMBAT_POTION3, 3), DIVINE_SUPER_COMBAT4(
        ItemChargeType.POTION,
        ItemID.DIVINE_SUPER_COMBAT_POTION4,
        4
    ),
    DIVINE_SUPER_DEFENCE1(ItemChargeType.POTION, ItemID.DIVINE_SUPER_DEFENCE_POTION1, 1), DIVINE_SUPER_DEFENCE2(
        ItemChargeType.POTION,
        ItemID.DIVINE_SUPER_DEFENCE_POTION2,
        2
    ),
    DIVINE_SUPER_DEFENCE3(ItemChargeType.POTION, ItemID.DIVINE_SUPER_DEFENCE_POTION3, 3), DIVINE_SUPER_DEFENCE4(
        ItemChargeType.POTION,
        ItemID.DIVINE_SUPER_DEFENCE_POTION4,
        4
    ),
    DIVINE_SUPER_STRENGTH1(ItemChargeType.POTION, ItemID.DIVINE_SUPER_STRENGTH_POTION1, 1), DIVINE_SUPER_STRENGTH2(
        ItemChargeType.POTION,
        ItemID.DIVINE_SUPER_STRENGTH_POTION2,
        2
    ),
    DIVINE_SUPER_STRENGTH3(ItemChargeType.POTION, ItemID.DIVINE_SUPER_STRENGTH_POTION3, 3), DIVINE_SUPER_STRENGTH4(
        ItemChargeType.POTION,
        ItemID.DIVINE_SUPER_STRENGTH_POTION4,
        4
    ),
    ELYRE1(ItemChargeType.TELEPORT, ItemID.ENCHANTED_LYRE1, 1), ELYRE2(
        ItemChargeType.TELEPORT,
        ItemID.ENCHANTED_LYRE2,
        2
    ),
    ELYRE3(ItemChargeType.TELEPORT, ItemID.ENCHANTED_LYRE3, 3), ELYRE4(
        ItemChargeType.TELEPORT,
        ItemID.ENCHANTED_LYRE4,
        4
    ),
    ELYRE5(ItemChargeType.TELEPORT, ItemID.ENCHANTED_LYRE5, 5), ENERGY1(
        ItemChargeType.POTION,
        ItemID.ENERGY_POTION1,
        1
    ),
    ENERGY2(ItemChargeType.POTION, ItemID.ENERGY_POTION2, 2), ENERGY3(
        ItemChargeType.POTION,
        ItemID.ENERGY_POTION3,
        3
    ),
    ENERGY4(ItemChargeType.POTION, ItemID.ENERGY_POTION4, 4), EXTENDED_ANTIFI1(
        ItemChargeType.POTION,
        ItemID.EXTENDED_ANTIFIRE1,
        1
    ),
    EXTENDED_ANTIFI2(ItemChargeType.POTION, ItemID.EXTENDED_ANTIFIRE2, 2), EXTENDED_ANTIFI3(
        ItemChargeType.POTION,
        ItemID.EXTENDED_ANTIFIRE3,
        3
    ),
    EXTENDED_ANTIFI4(ItemChargeType.POTION, ItemID.EXTENDED_ANTIFIRE4, 4), EXTENDED_SUPER_ANTI1(
        ItemChargeType.POTION,
        ItemID.EXTENDED_SUPER_ANTIFIRE1,
        1
    ),
    EXTENDED_SUPER_ANTI2(
        ItemChargeType.POTION,
        ItemID.EXTENDED_SUPER_ANTIFIRE2,
        2
    ),
    EXTENDED_SUPER_ANTI3(
        ItemChargeType.POTION,
        ItemID.EXTENDED_SUPER_ANTIFIRE3,
        3
    ),
    EXTENDED_SUPER_ANTI4(ItemChargeType.POTION, ItemID.EXTENDED_SUPER_ANTIFIRE4, 4), FISHING1(
        ItemChargeType.POTION,
        ItemID.FISHING_POTION1,
        1
    ),
    FISHING2(ItemChargeType.POTION, ItemID.FISHING_POTION2, 2), FISHING3(
        ItemChargeType.POTION,
        ItemID.FISHING_POTION3,
        3
    ),
    FISHING4(ItemChargeType.POTION, ItemID.FISHING_POTION4, 4), FUNGICIDE0(
        ItemChargeType.FUNGICIDE_SPRAY,
        ItemID.FUNGICIDE_SPRAY_0,
        0
    ),
    FUNGICIDE1(ItemChargeType.FUNGICIDE_SPRAY, ItemID.FUNGICIDE_SPRAY_1, 1), FUNGICIDE2(
        ItemChargeType.FUNGICIDE_SPRAY,
        ItemID.FUNGICIDE_SPRAY_2,
        2
    ),
    FUNGICIDE3(ItemChargeType.FUNGICIDE_SPRAY, ItemID.FUNGICIDE_SPRAY_3, 3), FUNGICIDE4(
        ItemChargeType.FUNGICIDE_SPRAY,
        ItemID.FUNGICIDE_SPRAY_4,
        4
    ),
    FUNGICIDE5(ItemChargeType.FUNGICIDE_SPRAY, ItemID.FUNGICIDE_SPRAY_5, 5), FUNGICIDE6(
        ItemChargeType.FUNGICIDE_SPRAY,
        ItemID.FUNGICIDE_SPRAY_6,
        6
    ),
    FUNGICIDE7(ItemChargeType.FUNGICIDE_SPRAY, ItemID.FUNGICIDE_SPRAY_7, 7), FUNGICIDE8(
        ItemChargeType.FUNGICIDE_SPRAY,
        ItemID.FUNGICIDE_SPRAY_8,
        8
    ),
    FUNGICIDE9(ItemChargeType.FUNGICIDE_SPRAY, ItemID.FUNGICIDE_SPRAY_9, 9), FUNGICIDE10(
        ItemChargeType.FUNGICIDE_SPRAY,
        ItemID.FUNGICIDE_SPRAY_10,
        10
    ),
    GAMES1(ItemChargeType.TELEPORT, ItemID.GAMES_NECKLACE1, 1), GAMES2(
        ItemChargeType.TELEPORT,
        ItemID.GAMES_NECKLACE2,
        2
    ),
    GAMES3(ItemChargeType.TELEPORT, ItemID.GAMES_NECKLACE3, 3), GAMES4(
        ItemChargeType.TELEPORT,
        ItemID.GAMES_NECKLACE4,
        4
    ),
    GAMES5(ItemChargeType.TELEPORT, ItemID.GAMES_NECKLACE5, 5), GAMES6(
        ItemChargeType.TELEPORT,
        ItemID.GAMES_NECKLACE6,
        6
    ),
    GAMES7(ItemChargeType.TELEPORT, ItemID.GAMES_NECKLACE7, 7), GAMES8(
        ItemChargeType.TELEPORT,
        ItemID.GAMES_NECKLACE8,
        8
    ),
    GLORY1(ItemChargeType.TELEPORT, ItemID.AMULET_OF_GLORY1, 1), GLORY2(
        ItemChargeType.TELEPORT,
        ItemID.AMULET_OF_GLORY2,
        2
    ),
    GLORY3(ItemChargeType.TELEPORT, ItemID.AMULET_OF_GLORY3, 3), GLORY4(
        ItemChargeType.TELEPORT,
        ItemID.AMULET_OF_GLORY4,
        4
    ),
    GLORY5(ItemChargeType.TELEPORT, ItemID.AMULET_OF_GLORY5, 5), GLORY6(
        ItemChargeType.TELEPORT,
        ItemID.AMULET_OF_GLORY6,
        6
    ),
    GLORYT1(ItemChargeType.TELEPORT, ItemID.AMULET_OF_GLORY_T1, 1), GLORYT2(
        ItemChargeType.TELEPORT,
        ItemID.AMULET_OF_GLORY_T2,
        2
    ),
    GLORYT3(ItemChargeType.TELEPORT, ItemID.AMULET_OF_GLORY_T3, 3), GLORYT4(
        ItemChargeType.TELEPORT,
        ItemID.AMULET_OF_GLORY_T4,
        4
    ),
    GLORYT5(ItemChargeType.TELEPORT, ItemID.AMULET_OF_GLORY_T5, 5), GLORYT6(
        ItemChargeType.TELEPORT,
        ItemID.AMULET_OF_GLORY_T6,
        6
    ),
    GREST1(ItemChargeType.GUTHIX_REST, ItemID.GUTHIX_REST1, 1), GREST2(
        ItemChargeType.GUTHIX_REST,
        ItemID.GUTHIX_REST2,
        2
    ),
    GREST3(ItemChargeType.GUTHIX_REST, ItemID.GUTHIX_REST3, 3), GREST4(
        ItemChargeType.GUTHIX_REST,
        ItemID.GUTHIX_REST4,
        4
    ),
    GUTHIX_BAL1(ItemChargeType.POTION, ItemID.GUTHIX_BALANCE1, 1), GUTHIX_BAL2(
        ItemChargeType.POTION,
        ItemID.GUTHIX_BALANCE2,
        2
    ),
    GUTHIX_BAL3(ItemChargeType.POTION, ItemID.GUTHIX_BALANCE3, 3), GUTHIX_BAL4(
        ItemChargeType.POTION,
        ItemID.GUTHIX_BALANCE4,
        4
    ),
    HUNTER1(ItemChargeType.POTION, ItemID.HUNTER_POTION1, 1), HUNTER2(
        ItemChargeType.POTION,
        ItemID.HUNTER_POTION2,
        2
    ),
    HUNTER3(ItemChargeType.POTION, ItemID.HUNTER_POTION3, 3), HUNTER4(
        ItemChargeType.POTION,
        ItemID.HUNTER_POTION4,
        4
    ),
    IMP_IN_A_BOX1(ItemChargeType.IMPBOX, ItemID.IMPINABOX1, 1), IMP_IN_A_BOX2(
        ItemChargeType.IMPBOX,
        ItemID.IMPINABOX2,
        2
    ),
    MAGIC1(ItemChargeType.POTION, ItemID.MAGIC_POTION1, 1), MAGIC2(
        ItemChargeType.POTION,
        ItemID.MAGIC_POTION2,
        2
    ),
    MAGIC3(ItemChargeType.POTION, ItemID.MAGIC_POTION3, 3), MAGIC4(
        ItemChargeType.POTION,
        ItemID.MAGIC_POTION4,
        4
    ),
    MAGIC_ESS1(ItemChargeType.POTION, ItemID.MAGIC_ESSENCE1, 1), MAGIC_ESS2(
        ItemChargeType.POTION,
        ItemID.MAGIC_ESSENCE2,
        2
    ),
    MAGIC_ESS3(ItemChargeType.POTION, ItemID.MAGIC_ESSENCE3, 3), MAGIC_ESS4(
        ItemChargeType.POTION,
        ItemID.MAGIC_ESSENCE4,
        4
    ),
    OVERLOAD1(ItemChargeType.POTION, ItemID.OVERLOAD_1, 1), OVERLOAD2(
        ItemChargeType.POTION,
        ItemID.OVERLOAD_2,
        2
    ),
    OVERLOAD3(ItemChargeType.POTION, ItemID.OVERLOAD_3, 3), OVERLOAD4(
        ItemChargeType.POTION,
        ItemID.OVERLOAD_4,
        4
    ),
    PASSAGE1(ItemChargeType.TELEPORT, ItemID.NECKLACE_OF_PASSAGE1, 1), PASSAGE2(
        ItemChargeType.TELEPORT,
        ItemID.NECKLACE_OF_PASSAGE2,
        2
    ),
    PASSAGE3(ItemChargeType.TELEPORT, ItemID.NECKLACE_OF_PASSAGE3, 3), PASSAGE4(
        ItemChargeType.TELEPORT,
        ItemID.NECKLACE_OF_PASSAGE4,
        4
    ),
    PASSAGE5(ItemChargeType.TELEPORT, ItemID.NECKLACE_OF_PASSAGE5, 5), PRAYER1(
        ItemChargeType.POTION,
        ItemID.PRAYER_POTION1,
        1
    ),
    PRAYER2(ItemChargeType.POTION, ItemID.PRAYER_POTION2, 2), PRAYER3(
        ItemChargeType.POTION,
        ItemID.PRAYER_POTION3,
        3
    ),
    PRAYER4(ItemChargeType.POTION, ItemID.PRAYER_POTION4, 4), RANGING1(
        ItemChargeType.POTION,
        ItemID.RANGING_POTION1,
        1
    ),
    RANGING2(ItemChargeType.POTION, ItemID.RANGING_POTION2, 2), RANGING3(
        ItemChargeType.POTION,
        ItemID.RANGING_POTION3,
        3
    ),
    RANGING4(ItemChargeType.POTION, ItemID.RANGING_POTION4, 4), RELICYMS1(
        ItemChargeType.POTION,
        ItemID.RELICYMS_BALM1,
        1
    ),
    RELICYMS2(ItemChargeType.POTION, ItemID.RELICYMS_BALM2, 2), RELICYMS3(
        ItemChargeType.POTION,
        ItemID.RELICYMS_BALM3,
        3
    ),
    RELICYMS4(ItemChargeType.POTION, ItemID.RELICYMS_BALM4, 4), RESTORE1(
        ItemChargeType.POTION,
        ItemID.RESTORE_POTION1,
        1
    ),
    RESTORE2(ItemChargeType.POTION, ItemID.RESTORE_POTION2, 2), RESTORE3(
        ItemChargeType.POTION,
        ItemID.RESTORE_POTION3,
        3
    ),
    RESTORE4(ItemChargeType.POTION, ItemID.RESTORE_POTION4, 4), RETURNING1(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_RETURNING1,
        1
    ),
    RETURNING2(ItemChargeType.TELEPORT, ItemID.RING_OF_RETURNING2, 2), RETURNING3(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_RETURNING3,
        3
    ),
    RETURNING4(ItemChargeType.TELEPORT, ItemID.RING_OF_RETURNING4, 4), RETURNING5(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_RETURNING5,
        5
    ),
    ROD1(ItemChargeType.TELEPORT, ItemID.RING_OF_DUELING1, 1), ROD2(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_DUELING2,
        2
    ),
    ROD3(ItemChargeType.TELEPORT, ItemID.RING_OF_DUELING3, 3), ROD4(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_DUELING4,
        4
    ),
    ROD5(ItemChargeType.TELEPORT, ItemID.RING_OF_DUELING5, 5), ROD6(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_DUELING6,
        6
    ),
    ROD7(ItemChargeType.TELEPORT, ItemID.RING_OF_DUELING7, 7), ROD8(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_DUELING8,
        8
    ),
    ROS1(ItemChargeType.TELEPORT, ItemID.SLAYER_RING_1, 1), ROS2(
        ItemChargeType.TELEPORT,
        ItemID.SLAYER_RING_2,
        2
    ),
    ROS3(ItemChargeType.TELEPORT, ItemID.SLAYER_RING_3, 3), ROS4(
        ItemChargeType.TELEPORT,
        ItemID.SLAYER_RING_4,
        4
    ),
    ROS5(ItemChargeType.TELEPORT, ItemID.SLAYER_RING_5, 5), ROS6(
        ItemChargeType.TELEPORT,
        ItemID.SLAYER_RING_6,
        6
    ),
    ROS7(ItemChargeType.TELEPORT, ItemID.SLAYER_RING_7, 7), ROS8(
        ItemChargeType.TELEPORT,
        ItemID.SLAYER_RING_8,
        8
    ),
    ROW1(ItemChargeType.TELEPORT, ItemID.RING_OF_WEALTH_1, 1), ROW2(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_WEALTH_2,
        2
    ),
    ROW3(ItemChargeType.TELEPORT, ItemID.RING_OF_WEALTH_3, 3), ROW4(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_WEALTH_4,
        4
    ),
    ROW5(ItemChargeType.TELEPORT, ItemID.RING_OF_WEALTH_5, 5), ROWI1(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_WEALTH_I1,
        1
    ),
    ROWI2(ItemChargeType.TELEPORT, ItemID.RING_OF_WEALTH_I2, 2), ROWI3(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_WEALTH_I3,
        3
    ),
    ROWI4(ItemChargeType.TELEPORT, ItemID.RING_OF_WEALTH_I4, 4), ROWI5(
        ItemChargeType.TELEPORT,
        ItemID.RING_OF_WEALTH_I5,
        5
    ),
    SACK_CABBAGES1(ItemChargeType.SACK, ItemID.CABBAGES1, 1), SACK_CABBAGES2(
        ItemChargeType.SACK,
        ItemID.CABBAGES2,
        2
    ),
    SACK_CABBAGES3(ItemChargeType.SACK, ItemID.CABBAGES3, 3), SACK_CABBAGES4(
        ItemChargeType.SACK,
        ItemID.CABBAGES4,
        4
    ),
    SACK_CABBAGES5(ItemChargeType.SACK, ItemID.CABBAGES5, 5), SACK_CABBAGES6(
        ItemChargeType.SACK,
        ItemID.CABBAGES6,
        6
    ),
    SACK_CABBAGES7(ItemChargeType.SACK, ItemID.CABBAGES7, 7), SACK_CABBAGES8(
        ItemChargeType.SACK,
        ItemID.CABBAGES8,
        8
    ),
    SACK_CABBAGES9(ItemChargeType.SACK, ItemID.CABBAGES9, 9), SACK_CABBAGES10(
        ItemChargeType.SACK,
        ItemID.CABBAGES10,
        10
    ),
    SACK_ONIONS1(ItemChargeType.SACK, ItemID.ONIONS1, 1), SACK_ONIONS2(
        ItemChargeType.SACK,
        ItemID.ONIONS2,
        2
    ),
    SACK_ONIONS3(ItemChargeType.SACK, ItemID.ONIONS3, 3), SACK_ONIONS4(
        ItemChargeType.SACK,
        ItemID.ONIONS4,
        4
    ),
    SACK_ONIONS5(ItemChargeType.SACK, ItemID.ONIONS5, 5), SACK_ONIONS6(
        ItemChargeType.SACK,
        ItemID.ONIONS6,
        6
    ),
    SACK_ONIONS7(ItemChargeType.SACK, ItemID.ONIONS7, 7), SACK_ONIONS8(
        ItemChargeType.SACK,
        ItemID.ONIONS8,
        8
    ),
    SACK_ONIONS9(ItemChargeType.SACK, ItemID.ONIONS9, 9), SACK_ONIONS10(
        ItemChargeType.SACK,
        ItemID.ONIONS10,
        10
    ),
    SACK_POTATOES1(ItemChargeType.SACK, ItemID.POTATOES1, 1), SACK_POTATOES2(
        ItemChargeType.SACK,
        ItemID.POTATOES2,
        2
    ),
    SACK_POTATOES3(ItemChargeType.SACK, ItemID.POTATOES3, 3), SACK_POTATOES4(
        ItemChargeType.SACK,
        ItemID.POTATOES4,
        4
    ),
    SACK_POTATOES5(ItemChargeType.SACK, ItemID.POTATOES5, 5), SACK_POTATOES6(
        ItemChargeType.SACK,
        ItemID.POTATOES6,
        6
    ),
    SACK_POTATOES7(ItemChargeType.SACK, ItemID.POTATOES7, 7), SACK_POTATOES8(
        ItemChargeType.SACK,
        ItemID.POTATOES8,
        8
    ),
    SACK_POTATOES9(ItemChargeType.SACK, ItemID.POTATOES9, 9), SACK_POTATOES10(
        ItemChargeType.SACK,
        ItemID.POTATOES10,
        10
    ),
    SANFEW1(ItemChargeType.POTION, ItemID.SANFEW_SERUM1, 1), SANFEW2(
        ItemChargeType.POTION,
        ItemID.SANFEW_SERUM2,
        2
    ),
    SANFEW3(ItemChargeType.POTION, ItemID.SANFEW_SERUM3, 3), SANFEW4(
        ItemChargeType.POTION,
        ItemID.SANFEW_SERUM4,
        4
    ),
    SARADOMIN_BR1(ItemChargeType.POTION, ItemID.SARADOMIN_BREW1, 1), SARADOMIN_BR2(
        ItemChargeType.POTION,
        ItemID.SARADOMIN_BREW2,
        2
    ),
    SARADOMIN_BR3(ItemChargeType.POTION, ItemID.SARADOMIN_BREW3, 3), SARADOMIN_BR4(
        ItemChargeType.POTION,
        ItemID.SARADOMIN_BREW4,
        4
    ),
    SERUM_2071(ItemChargeType.POTION, ItemID.SERUM_207_1, 1), SERUM_2072(
        ItemChargeType.POTION,
        ItemID.SERUM_207_2,
        2
    ),
    SERUM_2073(ItemChargeType.POTION, ItemID.SERUM_207_3, 3), SERUM_2074(
        ItemChargeType.POTION,
        ItemID.SERUM_207_4,
        4
    ),
    SERUM_2081(ItemChargeType.POTION, ItemID.SERUM_208_1, 1), SERUM_2082(
        ItemChargeType.POTION,
        ItemID.SERUM_208_2,
        2
    ),
    SERUM_2083(ItemChargeType.POTION, ItemID.SERUM_208_3, 3), SERUM_2084(
        ItemChargeType.POTION,
        ItemID.SERUM_208_4,
        4
    ),
    SKILLS1(ItemChargeType.TELEPORT, ItemID.SKILLS_NECKLACE1, 1), SKILLS2(
        ItemChargeType.TELEPORT,
        ItemID.SKILLS_NECKLACE2,
        2
    ),
    SKILLS3(ItemChargeType.TELEPORT, ItemID.SKILLS_NECKLACE3, 3), SKILLS4(
        ItemChargeType.TELEPORT,
        ItemID.SKILLS_NECKLACE4,
        4
    ),
    SKILLS5(ItemChargeType.TELEPORT, ItemID.SKILLS_NECKLACE5, 5), SKILLS6(
        ItemChargeType.TELEPORT,
        ItemID.SKILLS_NECKLACE6,
        6
    ),
    STAMINA1(ItemChargeType.POTION, ItemID.STAMINA_POTION1, 1), STAMINA2(
        ItemChargeType.POTION,
        ItemID.STAMINA_POTION2,
        2
    ),
    STAMINA3(ItemChargeType.POTION, ItemID.STAMINA_POTION3, 3), STAMINA4(
        ItemChargeType.POTION,
        ItemID.STAMINA_POTION4,
        4
    ),
    STRENGTH1(ItemChargeType.POTION, ItemID.STRENGTH_POTION1, 1), STRENGTH2(
        ItemChargeType.POTION,
        ItemID.STRENGTH_POTION2,
        2
    ),
    STRENGTH3(ItemChargeType.POTION, ItemID.STRENGTH_POTION3, 3), STRENGTH4(
        ItemChargeType.POTION,
        ItemID.STRENGTH_POTION4,
        4
    ),
    SUPERANTI1(ItemChargeType.POTION, ItemID.SUPERANTIPOISON1, 1), SUPERANTI2(
        ItemChargeType.POTION,
        ItemID.SUPERANTIPOISON2,
        2
    ),
    SUPERANTI3(ItemChargeType.POTION, ItemID.SUPERANTIPOISON3, 3), SUPERANTI4(
        ItemChargeType.POTION,
        ItemID.SUPERANTIPOISON4,
        4
    ),
    SUPER_ANTIFIRE1(ItemChargeType.POTION, ItemID.SUPER_ANTIFIRE_POTION1, 1), SUPER_ANTIFIRE2(
        ItemChargeType.POTION,
        ItemID.SUPER_ANTIFIRE_POTION2,
        2
    ),
    SUPER_ANTIFIRE3(ItemChargeType.POTION, ItemID.SUPER_ANTIFIRE_POTION3, 3), SUPER_ANTIFIRE4(
        ItemChargeType.POTION,
        ItemID.SUPER_ANTIFIRE_POTION4,
        4
    ),
    SUPER_ATT1(ItemChargeType.POTION, ItemID.SUPER_ATTACK1, 1), SUPER_ATT2(
        ItemChargeType.POTION,
        ItemID.SUPER_ATTACK2,
        2
    ),
    SUPER_ATT3(ItemChargeType.POTION, ItemID.SUPER_ATTACK3, 3), SUPER_ATT4(
        ItemChargeType.POTION,
        ItemID.SUPER_ATTACK4,
        4
    ),
    SUPER_COMB1(ItemChargeType.POTION, ItemID.SUPER_COMBAT_POTION1, 1), SUPER_COMB2(
        ItemChargeType.POTION,
        ItemID.SUPER_COMBAT_POTION2,
        2
    ),
    SUPER_COMB3(ItemChargeType.POTION, ItemID.SUPER_COMBAT_POTION3, 3), SUPER_COMB4(
        ItemChargeType.POTION,
        ItemID.SUPER_COMBAT_POTION4,
        4
    ),
    SUPER_DEF1(ItemChargeType.POTION, ItemID.SUPER_DEFENCE1, 1), SUPER_DEF2(
        ItemChargeType.POTION,
        ItemID.SUPER_DEFENCE2,
        2
    ),
    SUPER_DEF3(ItemChargeType.POTION, ItemID.SUPER_DEFENCE3, 3), SUPER_DEF4(
        ItemChargeType.POTION,
        ItemID.SUPER_DEFENCE4,
        4
    ),
    SUPER_ENERG1(ItemChargeType.POTION, ItemID.SUPER_ENERGY1, 1), SUPER_ENERG2(
        ItemChargeType.POTION,
        ItemID.SUPER_ENERGY2,
        2
    ),
    SUPER_ENERG3(ItemChargeType.POTION, ItemID.SUPER_ENERGY3, 3), SUPER_ENERG4(
        ItemChargeType.POTION,
        ItemID.SUPER_ENERGY4,
        4
    ),
    SUPER_MAG1(ItemChargeType.POTION, ItemID.SUPER_MAGIC_POTION_1, 1), SUPER_MAG2(
        ItemChargeType.POTION,
        ItemID.SUPER_MAGIC_POTION_2,
        2
    ),
    SUPER_MAG3(ItemChargeType.POTION, ItemID.SUPER_MAGIC_POTION_3, 3), SUPER_MAG4(
        ItemChargeType.POTION,
        ItemID.SUPER_MAGIC_POTION_4,
        4
    ),
    SUPER_RANG1(ItemChargeType.POTION, ItemID.SUPER_RANGING_1, 1), SUPER_RANG2(
        ItemChargeType.POTION,
        ItemID.SUPER_RANGING_2,
        2
    ),
    SUPER_RANG3(ItemChargeType.POTION, ItemID.SUPER_RANGING_3, 3), SUPER_RANG4(
        ItemChargeType.POTION,
        ItemID.SUPER_RANGING_4,
        4
    ),
    SUPER_REST1(ItemChargeType.POTION, ItemID.SUPER_RESTORE1, 1), SUPER_REST2(
        ItemChargeType.POTION,
        ItemID.SUPER_RESTORE2,
        2
    ),
    SUPER_REST3(ItemChargeType.POTION, ItemID.SUPER_RESTORE3, 3), SUPER_REST4(
        ItemChargeType.POTION,
        ItemID.SUPER_RESTORE4,
        4
    ),
    SUPER_STR1(ItemChargeType.POTION, ItemID.SUPER_STRENGTH1, 1), SUPER_STR2(
        ItemChargeType.POTION,
        ItemID.SUPER_STRENGTH2,
        2
    ),
    SUPER_STR3(ItemChargeType.POTION, ItemID.SUPER_STRENGTH3, 3), SUPER_STR4(
        ItemChargeType.POTION,
        ItemID.SUPER_STRENGTH4,
        4
    ),
    TCRYSTAL1(ItemChargeType.TELEPORT, ItemID.TELEPORT_CRYSTAL_1, 1), TCRYSTAL2(
        ItemChargeType.TELEPORT,
        ItemID.TELEPORT_CRYSTAL_2,
        2
    ),
    TCRYSTAL3(ItemChargeType.TELEPORT, ItemID.TELEPORT_CRYSTAL_3, 3), TCRYSTAL4(
        ItemChargeType.TELEPORT,
        ItemID.TELEPORT_CRYSTAL_4,
        4
    ),
    TCRYSTAL5(ItemChargeType.TELEPORT, ItemID.TELEPORT_CRYSTAL_5, 5), WCAN0(
        ItemChargeType.WATERCAN,
        ItemID.WATERING_CAN,
        0
    ),
    WCAN1(ItemChargeType.WATERCAN, ItemID.WATERING_CAN1, 1), WCAN2(
        ItemChargeType.WATERCAN,
        ItemID.WATERING_CAN2,
        2
    ),
    WCAN3(ItemChargeType.WATERCAN, ItemID.WATERING_CAN3, 3), WCAN4(
        ItemChargeType.WATERCAN,
        ItemID.WATERING_CAN4,
        4
    ),
    WCAN5(ItemChargeType.WATERCAN, ItemID.WATERING_CAN5, 5), WCAN6(
        ItemChargeType.WATERCAN,
        ItemID.WATERING_CAN6,
        6
    ),
    WCAN7(ItemChargeType.WATERCAN, ItemID.WATERING_CAN7, 7), WCAN8(
        ItemChargeType.WATERCAN,
        ItemID.WATERING_CAN8,
        8
    ),
    WSKIN0(ItemChargeType.WATERSKIN, ItemID.WATERSKIN0, 0), WSKIN1(
        ItemChargeType.WATERSKIN,
        ItemID.WATERSKIN1,
        1
    ),
    WSKIN2(ItemChargeType.WATERSKIN, ItemID.WATERSKIN2, 2), WSKIN3(
        ItemChargeType.WATERSKIN,
        ItemID.WATERSKIN3,
        3
    ),
    WSKIN4(ItemChargeType.WATERSKIN, ItemID.WATERSKIN4, 4), ZAMORAK_BR1(
        ItemChargeType.POTION,
        ItemID.ZAMORAK_BREW1,
        1
    ),
    ZAMORAK_BR2(ItemChargeType.POTION, ItemID.ZAMORAK_BREW2, 2), ZAMORAK_BR3(
        ItemChargeType.POTION,
        ItemID.ZAMORAK_BREW3,
        3
    ),
    ZAMORAK_BR4(ItemChargeType.POTION, ItemID.ZAMORAK_BREW4, 4), ELDER_MIN1(
        ItemChargeType.POTION,
        ItemID.ELDER_1,
        1
    ),
    ELDER_MIN2(ItemChargeType.POTION, ItemID.ELDER_2, 2), ELDER_MIN3(
        ItemChargeType.POTION,
        ItemID.ELDER_3,
        3
    ),
    ELDER_MIN4(ItemChargeType.POTION, ItemID.ELDER_4, 4), ELDER1(
        ItemChargeType.POTION,
        ItemID.ELDER_POTION_1,
        1
    ),
    ELDER2(ItemChargeType.POTION, ItemID.ELDER_POTION_2, 2), ELDER3(
        ItemChargeType.POTION,
        ItemID.ELDER_POTION_3,
        3
    ),
    ELDER4(ItemChargeType.POTION, ItemID.ELDER_POTION_4, 4), ELDER_MAX1(
        ItemChargeType.POTION,
        ItemID.ELDER_1_20921,
        1
    ),
    ELDER_MAX2(ItemChargeType.POTION, ItemID.ELDER_2_20922, 2), ELDER_MAX3(
        ItemChargeType.POTION,
        ItemID.ELDER_3_20923,
        3
    ),
    ELDER_MAX4(ItemChargeType.POTION, ItemID.ELDER_4_20924, 4), KODAI_MIN1(
        ItemChargeType.POTION,
        ItemID.KODAI_1,
        1
    ),
    KODAI_MIN2(ItemChargeType.POTION, ItemID.KODAI_2, 2), KODAI_MIN3(
        ItemChargeType.POTION,
        ItemID.KODAI_3,
        3
    ),
    KODAI_MIN4(ItemChargeType.POTION, ItemID.KODAI_4, 4), KODAI1(
        ItemChargeType.POTION,
        ItemID.KODAI_POTION_1,
        1
    ),
    KODAI2(ItemChargeType.POTION, ItemID.KODAI_POTION_2, 2), KODAI3(
        ItemChargeType.POTION,
        ItemID.KODAI_POTION_3,
        3
    ),
    KODAI4(ItemChargeType.POTION, ItemID.KODAI_POTION_4, 4), KODAI_MAX1(
        ItemChargeType.POTION,
        ItemID.KODAI_1_20945,
        1
    ),
    KODAI_MAX2(ItemChargeType.POTION, ItemID.KODAI_2_20946, 2), KODAI_MAX3(
        ItemChargeType.POTION,
        ItemID.KODAI_3_20947,
        3
    ),
    KODAI_MAX4(ItemChargeType.POTION, ItemID.KODAI_4_20948, 4), TWISTED_MIN1(
        ItemChargeType.POTION,
        ItemID.TWISTED_1,
        1
    ),
    TWISTED_MIN2(ItemChargeType.POTION, ItemID.TWISTED_2, 2), TWISTED_MIN3(
        ItemChargeType.POTION,
        ItemID.TWISTED_3,
        3
    ),
    TWISTED_MIN4(ItemChargeType.POTION, ItemID.TWISTED_4, 4), TWISTED1(
        ItemChargeType.POTION,
        ItemID.TWISTED_POTION_1,
        1
    ),
    TWISTED2(ItemChargeType.POTION, ItemID.TWISTED_POTION_2, 2), TWISTED3(
        ItemChargeType.POTION,
        ItemID.TWISTED_POTION_3,
        3
    ),
    TWISTED4(ItemChargeType.POTION, ItemID.TWISTED_POTION_4, 4), TWISTED_MAX1(
        ItemChargeType.POTION,
        ItemID.TWISTED_1_20933,
        1
    ),
    TWISTED_MAX2(ItemChargeType.POTION, ItemID.TWISTED_2_20934, 2), TWISTED_MAX3(
        ItemChargeType.POTION,
        ItemID.TWISTED_3_20935,
        3
    ),
    TWISTED_MAX4(ItemChargeType.POTION, ItemID.TWISTED_4_20936, 4), REVITALISATION_MIN1(
        ItemChargeType.POTION,
        ItemID.REVITALISATION_1,
        1
    ),
    REVITALISATION_MIN2(ItemChargeType.POTION, ItemID.REVITALISATION_2, 2), REVITALISATION_MIN3(
        ItemChargeType.POTION,
        ItemID.REVITALISATION_3,
        3
    ),
    REVITALISATION_MIN4(ItemChargeType.POTION, ItemID.REVITALISATION_4, 4), REVITALISATION1(
        ItemChargeType.POTION,
        ItemID.REVITALISATION_POTION_1,
        1
    ),
    REVITALISATION2(ItemChargeType.POTION, ItemID.REVITALISATION_POTION_2, 2), REVITALISATION3(
        ItemChargeType.POTION,
        ItemID.REVITALISATION_POTION_3,
        3
    ),
    REVITALISATION4(
        ItemChargeType.POTION,
        ItemID.REVITALISATION_POTION_4,
        4
    ),
    REVITALISATION_MAX1(
        ItemChargeType.POTION,
        ItemID.REVITALISATION_1_20957,
        1
    ),
    REVITALISATION_MAX2(
        ItemChargeType.POTION,
        ItemID.REVITALISATION_2_20958,
        2
    ),
    REVITALISATION_MAX3(
        ItemChargeType.POTION,
        ItemID.REVITALISATION_3_20959,
        3
    ),
    REVITALISATION_MAX4(ItemChargeType.POTION, ItemID.REVITALISATION_4_20960, 4), XERICS_AID_MIN1(
        ItemChargeType.POTION,
        ItemID.XERICS_AID_1,
        1
    ),
    XERICS_AID_MIN2(ItemChargeType.POTION, ItemID.XERICS_AID_2, 2), XERICS_AID_MIN3(
        ItemChargeType.POTION,
        ItemID.XERICS_AID_3,
        3
    ),
    XERICS_AID_MIN4(ItemChargeType.POTION, ItemID.XERICS_AID_4, 4), XERICS_AID1(
        ItemChargeType.POTION,
        ItemID.XERICS_AID_1_20977,
        1
    ),
    XERICS_AID2(ItemChargeType.POTION, ItemID.XERICS_AID_2_20978, 2), XERICS_AID3(
        ItemChargeType.POTION,
        ItemID.XERICS_AID_3_20979,
        3
    ),
    XERICS_AID4(ItemChargeType.POTION, ItemID.XERICS_AID_4_20980, 4), XERICS_AID_MAX1(
        ItemChargeType.POTION,
        ItemID.XERICS_AID_1_20981,
        1
    ),
    XERICS_AID_MAX2(ItemChargeType.POTION, ItemID.XERICS_AID_2_20982, 2), XERICS_AID_MAX3(
        ItemChargeType.POTION,
        ItemID.XERICS_AID_3_20983,
        3
    ),
    XERICS_AID_MAX4(ItemChargeType.POTION, ItemID.XERICS_AID_4_20984, 4), PRAYER_ENHANCE_MIN1(
        ItemChargeType.POTION,
        ItemID.PRAYER_ENHANCE_1,
        1
    ),
    PRAYER_ENHANCE_MIN2(ItemChargeType.POTION, ItemID.PRAYER_ENHANCE_2, 2), PRAYER_ENHANCE_MIN3(
        ItemChargeType.POTION,
        ItemID.PRAYER_ENHANCE_3,
        3
    ),
    PRAYER_ENHANCE_MIN4(ItemChargeType.POTION, ItemID.PRAYER_ENHANCE_4, 4), PRAYER_ENHANCE1(
        ItemChargeType.POTION,
        ItemID.PRAYER_ENHANCE_1_20965,
        1
    ),
    PRAYER_ENHANCE2(ItemChargeType.POTION, ItemID.PRAYER_ENHANCE_2_20966, 2), PRAYER_ENHANCE3(
        ItemChargeType.POTION,
        ItemID.PRAYER_ENHANCE_3_20967,
        3
    ),
    PRAYER_ENHANCE4(ItemChargeType.POTION, ItemID.PRAYER_ENHANCE_4_20968, 4), PRAYER_ENHANCE_MAX1(
        ItemChargeType.POTION,
        ItemID.PRAYER_ENHANCE_1_20969,
        1
    ),
    PRAYER_ENHANCE_MAX2(
        ItemChargeType.POTION,
        ItemID.PRAYER_ENHANCE_2_20970,
        2
    ),
    PRAYER_ENHANCE_MAX3(
        ItemChargeType.POTION,
        ItemID.PRAYER_ENHANCE_3_20971,
        3
    ),
    PRAYER_ENHANCE_MAX4(
        ItemChargeType.POTION,
        ItemID.PRAYER_ENHANCE_4_20972,
        4
    ),
    COX_OVERLOAD_MIN1(ItemChargeType.POTION, ItemID.OVERLOAD_1_20985, 1), COX_OVERLOAD_MIN2(
        ItemChargeType.POTION,
        ItemID.OVERLOAD_2_20986,
        2
    ),
    COX_OVERLOAD_MIN3(ItemChargeType.POTION, ItemID.OVERLOAD_3_20987, 3), COX_OVERLOAD_MIN4(
        ItemChargeType.POTION,
        ItemID.OVERLOAD_4_20988,
        4
    ),
    COX_OVERLOAD1(ItemChargeType.POTION, ItemID.OVERLOAD_1_20989, 1), COX_OVERLOAD2(
        ItemChargeType.POTION,
        ItemID.OVERLOAD_2_20990,
        2
    ),
    COX_OVERLOAD3(ItemChargeType.POTION, ItemID.OVERLOAD_3_20991, 3), COX_OVERLOAD4(
        ItemChargeType.POTION,
        ItemID.OVERLOAD_4_20992,
        4
    ),
    COX_OVERLOAD_MAX1(ItemChargeType.POTION, ItemID.OVERLOAD_1_20993, 1), COX_OVERLOAD_MAX2(
        ItemChargeType.POTION,
        ItemID.OVERLOAD_2_20994,
        2
    ),
    COX_OVERLOAD_MAX3(ItemChargeType.POTION, ItemID.OVERLOAD_3_20995, 3), COX_OVERLOAD_MAX4(
        ItemChargeType.POTION,
        ItemID.OVERLOAD_4_20996,
        4
    );

    companion object {
        private var ID_MAP: Map<Int, ItemWithCharge>? = null

        init {
            val builder = ImmutableMap.Builder<Int, ItemWithCharge>()
            for (itemCharge in values()) {
                builder.put(
                    itemCharge.id, itemCharge
                )
            }
            ID_MAP = builder.build()
        }

        fun findItem(itemId: Int): ItemWithCharge? {
            return ID_MAP!![itemId]
        }
    }
}