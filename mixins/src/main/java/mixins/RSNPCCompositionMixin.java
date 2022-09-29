package mixins;

import eventbus.Events;
import eventbus.events.NpcActionChanged;
import net.runelite.api.HeadIcon;
import net.runelite.api.mixins.FieldHook;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSNPCComposition;

@Mixin(RSNPCComposition.class)
public abstract class RSNPCCompositionMixin implements RSNPCComposition
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public HeadIcon getOverheadIcon()
	{
		int overheadIcon = getRsOverheadIcon();

		if (overheadIcon == -1)
		{
			return null;
		}

		return HeadIcon.values()[overheadIcon];
	}

	@FieldHook("actions")
	@Inject
	public void actionsHook(int idx)
	{
		NpcActionChanged npcActionChanged = new NpcActionChanged(this, idx);
		client.getCallbacks().post(Events.NPC_ACTION_CHANGED, npcActionChanged);
	}

	@Inject
	private int index;

	@Inject
	public void setIndex(int idx)
	{
		index = idx;
	}

	@Inject
	public int getIndex()
	{
		return index;
	}
}
