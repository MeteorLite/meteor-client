package net.runelite.rs.api;

import java.util.function.Consumer;
import net.runelite.api.MenuEntry;
import net.runelite.mapping.Import;

public interface RSRuneLiteMenuEntry extends MenuEntry
{
	Consumer getConsumer();
	void setConsumer(Consumer consumer);

	int getIdx();
	void setIdx(int idx);

	@Import("itemIdOverride")
	void setItemIdOverride(int i);

	@Import("itemIdOverride")
	int getItemIdOverride();
}