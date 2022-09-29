package mixins;

import eventbus.Events;
import eventbus.events.VarClientIntChanged;
import eventbus.events.VarClientStrChanged;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSVarcs;

@Mixin(RSVarcs.class)
public abstract class RSVarcsMixin implements RSVarcs
{
	@Shadow("client")
	private static RSClient client;

	@MethodHook(value = "setInt", end = true)
	@Inject
	public void onVarCIntChanged(int id, int value)
	{
		client.getCallbacks().post(Events.VARCLIENT_INT_CHANGED, new VarClientIntChanged(id));
	}

	@MethodHook(value = "setString", end = true)
	@Inject
	public void onVarCStrChanged(int id, String value)
	{
		client.getCallbacks().post(Events.VARCLIENT_STR_CHANGED, new VarClientStrChanged(id));
	}
}
