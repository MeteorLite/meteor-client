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
		short[] spriteIndexes = getHeadIconSpriteIndexes();
		int[] archiveIds = getHeadIconArchiveIds();
		if (archiveIds == null || spriteIndexes == null) {
			return null;
		}

		return HeadIcon.values()[spriteIndexes[0]];
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
