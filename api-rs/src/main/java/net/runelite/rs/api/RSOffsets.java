package net.runelite.rs.api;

import net.runelite.mapping.Import;

public interface RSOffsets {
    @Import("xMid")
    int getCenterX();

    @Import("yMid")
    int getCenterY();

    @Import("zMid")
    int getCenterZ();

    @Import("xMidOffset")
    int getExtremeX();

    @Import("yMidOffset")
    int getExtremeY();

    @Import("zMidOffset")
    int getExtremeZ();
}
