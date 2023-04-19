package net.runelite.rs.api;

import net.runelite.api.ActorSpotAnim;
import net.runelite.mapping.Import;

public interface RSActorSpotAnim extends ActorSpotAnim
{
	@Import("id")
	@Override
	int getId();

	@Import("id")
	@Override
	void setId(int id);

	@Import("height")
	@Override
	int getHeight();

	@Import("height")
	@Override
	void setHeight(int height);

	@Import("frame")
	@Override
	int getFrame();

	@Import("frame")
	@Override
	void setFrame(int frame);
}