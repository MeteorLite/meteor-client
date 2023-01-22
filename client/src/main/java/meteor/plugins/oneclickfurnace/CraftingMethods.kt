package meteor.plugins.oneclickfurnace

import lombok.AccessLevel
import lombok.Getter
import lombok.RequiredArgsConstructor
import net.runelite.api.ItemID


enum class CraftingMethods {
    CannonBalls(ItemID.STEEL_BAR, ItemID.CANNON_BALL, 17694734), Molten_Glass(
        ItemID.BUCKET_OF_SAND,
        ItemID.SODA_ASH,
        ItemID.MOLTEN_GLASS,
        17694734
    ),  //maybe the opcode for this should be a final variable + x in case of any future changes to the opcode.
    Gold_Ring(ItemID.GOLD_BAR, ItemID.GOLD_RING, 29229064), Sapphire_Ring(
        ItemID.GOLD_BAR,
        ItemID.SAPPHIRE,
        ItemID.SAPPHIRE_RING,
        29229065
    ),
    Emerald_Ring(ItemID.GOLD_BAR, ItemID.EMERALD, ItemID.EMERALD_RING, 29229066), Ruby_Ring(
        ItemID.GOLD_BAR,
        ItemID.RUBY,
        ItemID.RUBY_RING,
        29229067
    ),
    Diamond_Ring(ItemID.GOLD_BAR, ItemID.DIAMOND, ItemID.DIAMOND_RING, 29229068), Dragonstone_Ring(
        ItemID.GOLD_BAR,
        ItemID.DRAGONSTONE,
        ItemID.DRAGONSTONE_RING,
        29229069
    ),
    Gold_Necklace(ItemID.GOLD_BAR, ItemID.GOLD_NECKLACE, 29229079), Sapphire_Necklace(
        ItemID.GOLD_BAR,
        ItemID.SAPPHIRE,
        ItemID.SAPPHIRE_NECKLACE,
        29229080
    ),
    Emerald_Necklace(ItemID.GOLD_BAR, ItemID.EMERALD, ItemID.EMERALD_NECKLACE, 29229081), Ruby_Necklace(
        ItemID.GOLD_BAR,
        ItemID.RUBY,
        ItemID.RUBY_NECKLACE,
        29229082
    ),
    Diamond_Necklace(
        ItemID.GOLD_BAR,
        ItemID.DIAMOND,
        ItemID.DIAMOND_NECKLACE,
        29229083
    ),
    Dragonstone_Necklace(
        ItemID.GOLD_BAR,
        ItemID.DRAGONSTONE,
        ItemID.DRAGON_NECKLACE,
        29229084
    ),
    Gold_Amulet(ItemID.GOLD_BAR, ItemID.GOLD_AMULET_U, 29229093), Sapphire_Amulet(
        ItemID.GOLD_BAR,
        ItemID.SAPPHIRE,
        ItemID.SAPPHIRE_AMULET_U,
        29229094
    ),
    Emerald_Amulet(ItemID.GOLD_BAR, ItemID.EMERALD, ItemID.EMERALD_AMULET_U, 29229095), Ruby_Amulet(
        ItemID.GOLD_BAR,
        ItemID.RUBY,
        ItemID.RUBY_AMULET_U,
        29229096
    ),
    Diamond_Amulet(
        ItemID.GOLD_BAR,
        ItemID.DIAMOND,
        ItemID.DIAMOND_AMULET_U,
        29229097
    ),
    Dragonstone_Amulet(
        ItemID.GOLD_BAR,
        ItemID.DRAGONSTONE,
        ItemID.DRAGONSTONE_AMULET_U,
        29229098
    ),
    Gold_Bracelet(ItemID.GOLD_BAR, ItemID.GOLD_BRACELET_11069, 29229106), Sapphire_Bracelet(
        ItemID.GOLD_BAR,
        ItemID.EMERALD,
        ItemID.SAPPHIRE_BRACELET,
        29229108
    ),
    Emerald_Bracelet(ItemID.GOLD_BAR, ItemID.EMERALD, ItemID.EMERALD_BRACELET, 29229109), Ruby_Bracelet(
        ItemID.GOLD_BAR,
        ItemID.RUBY,
        ItemID.RUBY_BRACELET,
        29229110
    ),
    Diamond_Bracelet(
        ItemID.GOLD_BAR,
        ItemID.DIAMOND,
        ItemID.DIAMOND_BRACELET,
        29229111
    ),
    Dragonstone_Bracelet(ItemID.GOLD_BAR, ItemID.DRAGONSTONE, ItemID.DRAGONSTONE_BRACELET, 29229112), Opal_Bracelet(
        ItemID.SILVER_BAR,
        ItemID.OPAL,
        ItemID.OPAL_BRACELET,
        393235
    ),
    Topaz_Bracelet(ItemID.SILVER_BAR, ItemID.RED_TOPAZ, ItemID.TOPAZ_BRACELET, 393237), Bronze_Bar(
        ItemID.TIN_ORE,
        ItemID.COPPER_ORE,
        ItemID.BRONZE_BAR,
        17694734
    ),
    Iron_Bar(ItemID.IRON_ORE, ItemID.IRON_BAR, 17694736), Silver_Bar(
        ItemID.SILVER_ORE,
        ItemID.SILVER_BAR,
        17694737
    ),
    Steel_Bar(ItemID.IRON_ORE, ItemID.COAL, ItemID.STEEL_BAR, 17694738), Gold_Bar(
        ItemID.GOLD_ORE,
        ItemID.GOLD_BAR,
        17694739
    ),
    Mithril_Bar(ItemID.MITHRIL_ORE, ItemID.COAL, ItemID.MITHRIL_BAR, 17694740), Adamant_Bar(
        ItemID.ADAMANTITE_ORE,
        ItemID.COAL,
        ItemID.ADAMANTITE_BAR,
        17694741
    ),
    Rune_Bar(ItemID.RUNITE_ORE, ItemID.COAL, ItemID.RUNITE_BAR, 17694742);

    var material: Int
    var material2 = -1 //always set this as the X quantity as material will just withdraw all.
    var product: Int
    var opcode: Int

    constructor(material: Int, product: Int, opcode: Int) {
        this.material = material
        this.product = product
        this.opcode = opcode
    }

    constructor(material: Int, material2: Int, product: Int, opcode: Int) {
        this.material = material
        this.material2 = material2
        this.product = product
        this.opcode = opcode
    }
}