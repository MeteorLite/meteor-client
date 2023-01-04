package net.runelite.rs.api;

import net.runelite.api.PendingLogin;
import net.runelite.mapping.Import;

public interface RSFriendLoginUpdate extends PendingLogin
{
	@Import("friendUsername")
	RSUsername getRsName();

	@Import("worldId")
	short getWorld();
}
