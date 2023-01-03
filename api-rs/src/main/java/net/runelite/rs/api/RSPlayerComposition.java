package net.runelite.rs.api;

import net.runelite.api.ObjTypeCustomisation;
import net.runelite.api.PlayerComposition;
import net.runelite.mapping.Import;
import org.jetbrains.annotations.Nullable;

public interface RSPlayerComposition extends PlayerComposition
{
	@Import("isFemale")
	boolean isFemale();

	@Import("bodyColors")
	int[] getColors();

	@Import("hash")
	long getHash();

	@Import("equipment")
	@Override
	int[] getEquipmentIds();

	@Import("npcTransformId")
	@Override
	void setTransformedNpcId(int id);

	@Import("setHash")
	@Override
	void setHash$api();

	// Kris changes:
	@Import("npcTransformId")
	@Override
	int getTransformedNpcId();

	@Import("customisations")
	@Nullable
	@Override
	ObjTypeCustomisation[] getColorTextureOverrides();
}
