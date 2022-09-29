package mixins;

import eventbus.Events;
import eventbus.events.PostHealthBar;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.MethodHook;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSBuffer;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSHealthBarDefinition;

@Mixin(RSHealthBarDefinition.class)
public abstract class RSHealthBarDefinitionMixin implements RSHealthBarDefinition
{
	@Shadow("client")
	private static RSClient client;

	@MethodHook(value = "decode", end = true)
	@Inject
	public void onRead(RSBuffer buffer)
	{
		PostHealthBar postHealthBar = new PostHealthBar(this);
		client.getCallbacks().post(Events.POST_HEALTHBAR, postHealthBar);
	}
}
