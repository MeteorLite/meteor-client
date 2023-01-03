package net.runelite.rs.api;

import net.runelite.api.WorldMapManager;
import net.runelite.mapping.Import;

public interface RSWorldMapManager extends WorldMapManager
{
	@Import("isLoaded")
	@Override
	boolean isLoaded$api();

	@Import("tileX")
	int getSurfaceOffsetX();

	@Import("tileY")
	int getSurfaceOffsetY();

	@Import("getPixelsPerTile")
	float getPixelsPerTile$api(int graphicsDiff, int worldDiff);
}
