package mixins;

import eventbus.Events;
import eventbus.events.AddedFriend;
import eventbus.events.RemovedFriend;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFriendSystem;

@Mixin(RSFriendSystem.class)
public abstract class RSFriendSystemMixin implements RSFriendSystem
{
	@Shadow("client")
	private static RSClient client;

	@MethodHook("removeFriend")
	@Inject
	public void rl$removeFriend(String friendName)
	{
		RemovedFriend removedFriend = new RemovedFriend(client.getFriendManager().getFriendContainer().findByName(friendName));
		client.getCallbacks().post(Events.REMOVED_FRIEND, removedFriend);
	}

	@MethodHook("addFriend")
	@Inject
	public void rl$addFriend(String friendName)
	{
		AddedFriend friendAdded = new AddedFriend(friendName);
		client.getCallbacks().post(Events.ADDED_FRIEND, friendAdded);
	}
}
