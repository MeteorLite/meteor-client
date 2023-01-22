package meteor.plugins.oneclickglassblowing

import lombok.RequiredArgsConstructor

@RequiredArgsConstructor
class Types {
    enum class Banks {
        NPC, BOOTH, CHEST
    }

    enum class Product(val ID: Int) {
        BEER_GLASS(17694734), CANDLE_LANTERN(17694735), OIL_LAMP(17694736), VIAL(17694737), FISHBOWL(17694738), UNPOWERED_ORB(
            17694739
        ),
        LANTERN_LENS(17694740), LIGHT_ORB(17694741)
    }

    enum class Mode {
        GLASSBLOWING, SUPERGLASS_MAKE
    }

    enum class SuperGlassMakeMethod(val seaweedCount: Int) {
        THIRTEEN_THIRTEEN(1), TWO_TWELVE(2), THREE_EIGHTEEN(3)
    }
}