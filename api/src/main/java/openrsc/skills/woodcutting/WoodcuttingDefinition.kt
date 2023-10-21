package openrsc.skills.woodcutting

import openrsc.constants.ObjectID
import openrsc.formulae.FormulaeUtil

/**
 * The definition wrapper for trees
 */
open class WoodcuttingDefinition(
        /**
         * Woodcut level required to cut
         */
        val reqLevel: Int,

        /**
         * The id of the log this turns into
         */
        val logId: Int,

        /**
         * How much experience identifying gives
         */
        val exp: Int,

        /**
         * Percent chance the tree will fall
         */
        val fell: Int,

        /**
         * How long the tree takes to respawn afterwards
         */
        val respawnTime: Int,
        lowBronze: Int,
        highBronze: Int,
        lowIron: Int,
        highIron: Int,
        lowSteel: Int,
        highSteel: Int,
        lowBlack: Int,
        highBlack: Int,
        lowMithril: Int,
        highMithril: Int,
        lowAdamantite: Int,
        highAdamantite: Int,
        lowRune: Int,
        highRune: Int,
        lowDragon: Int,
        highDragon: Int
) {

    // Math.random() must be less than these to succeed


    private var rateBronze: DoubleArray
    private var rateIron: DoubleArray
    private var rateSteel: DoubleArray
    private var rateBlack: DoubleArray
    private var rateMithril: DoubleArray
    private var rateAdamantite: DoubleArray
    private var rateRune: DoubleArray
    private var rateDragon: DoubleArray
    init {
        val maxLevelToCalcFor = 143

        rateBronze = DoubleArray(maxLevelToCalcFor)
        for (level in 0 until maxLevelToCalcFor)
            rateBronze[level] = FormulaeUtil.interp(lowBronze.toDouble(), highBronze.toDouble(), level)
        rateIron = DoubleArray(maxLevelToCalcFor)
        for (level in 0 until maxLevelToCalcFor)
            rateIron[level] = FormulaeUtil.interp(lowIron.toDouble(), highIron.toDouble(), level)
        rateSteel = DoubleArray(maxLevelToCalcFor)
        for (level in 0 until maxLevelToCalcFor)
            rateSteel[level] = FormulaeUtil.interp(lowSteel.toDouble(), highSteel.toDouble(), level)
        rateBlack = DoubleArray(maxLevelToCalcFor)
        for (level in 0 until maxLevelToCalcFor)
            rateBlack[level] = FormulaeUtil.interp(lowBlack.toDouble(), highBlack.toDouble(), level)
        rateMithril = DoubleArray(maxLevelToCalcFor)
        for (level in 0 until maxLevelToCalcFor)
            rateMithril[level] = FormulaeUtil.interp(lowMithril.toDouble(), highMithril.toDouble(), level)
        rateAdamantite = DoubleArray(maxLevelToCalcFor)
        for (level in 0 until maxLevelToCalcFor)
            rateAdamantite[level] = FormulaeUtil.interp(lowAdamantite.toDouble(), highAdamantite.toDouble(), level)
        rateRune = DoubleArray(maxLevelToCalcFor)
        for (level in 0 until maxLevelToCalcFor)
            rateRune[level] = FormulaeUtil.interp(lowRune.toDouble(), highRune.toDouble(), level)
        rateDragon = DoubleArray(maxLevelToCalcFor)
        for (level in 0 until maxLevelToCalcFor)
            rateDragon[level] = FormulaeUtil.interp(lowDragon.toDouble(), highDragon.toDouble(), level)
    }

    fun getRate(level: Int, axe: Int): Double {
        return when (axe) {
            87 -> rateBronze[level]
            12 -> rateIron[level]
            88 -> rateSteel[level]
            428 -> rateBlack[level]
            203 -> rateMithril[level]
            204 -> rateAdamantite[level]
            405 -> rateRune[level]
            1480 -> rateDragon[level]
            else -> rateBronze[level]
        }
    }

    companion object {
        fun of(id: Int): WoodcuttingDefinition? {
            return when (id) {
                ObjectID.POINTY_TREE.id(),
                ObjectID.LEAFY_TREE.id(),
                ObjectID.TREE_UNHEALTHY_GENERIC.id()
                    -> TreeWoodcuttingDef
                ObjectID.TREE_OAK.id() -> OakWoodcuttingDef
                ObjectID.TREE_WILLOW.id() -> WillowWoodcuttingDef
                ObjectID.TREE_MAPLE.id() -> MapleWoodcuttingDef
                ObjectID.TREE_YEW.id() -> YewWoodcuttingDef
                ObjectID.TREE_MAGIC.id() -> MagicWoodcuttingDef
                else -> null
            }
        }
    }
}
