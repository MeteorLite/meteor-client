package net.runelite.client.plugins.externals.oneclick.config

import net.runelite.client.plugins.externals.oneclick.clickables.skilling.farming.utils.FarmingPlot

enum class Compostable(val plot: FarmingPlot) {
    ALLOTMENT(FarmingPlot.ALLOTMENT), BELLADONNA(FarmingPlot.BELLADONNA), BUSH(FarmingPlot.BUSH), CACTUS(FarmingPlot.CACTUS), CALQUAT(
        FarmingPlot.CALQUAT
    ),
    CELASTRUS(FarmingPlot.CELASTRUS), FLOWER(FarmingPlot.FLOWER), FRUIT_TREE(FarmingPlot.FRUIT_TREE), HARDWOOD_TREE(
        FarmingPlot.HARDWOOD_TREE
    ),
    HERB(FarmingPlot.HERB), HOPS(FarmingPlot.HOPS), MUSHROOM(FarmingPlot.MUSHROOM), REDWOOD(FarmingPlot.REDWOOD), SEAWEED(
        FarmingPlot.SEAWEED
    ),
    SPIRIT_TREE(FarmingPlot.SPIRIT_TREE), TREE(FarmingPlot.TREE);
}