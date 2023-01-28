package mixins;

import net.runelite.api.mixins.Copy;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.api.mixins.Replace;
import net.runelite.api.mixins.Shadow;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSFrames;
import net.runelite.rs.api.RSModel;
import net.runelite.rs.api.RSSequenceDefinition;

@Mixin(RSSequenceDefinition.class)
public abstract class RSSequenceDefinitionMixin implements RSSequenceDefinition
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	private int id;

	@Inject
	public int getId()
	{
		return id;
	}

	@Inject
	public void setId(int id)
	{
		this.id = id;
	}

	@Copy("SequenceDefinition_get")
	@Replace("SequenceDefinition_get")
	public static RSSequenceDefinition copy$sequenceDefinitionGet(int var0)
	{
		RSSequenceDefinition sequenceDefinition = copy$sequenceDefinitionGet(var0);

		if (sequenceDefinition.getFrameIDs() == null && !sequenceDefinition.isCachedModelIdSet$api())
		{
			return null;
		}
		else
		{
			sequenceDefinition.setId(var0);
			return sequenceDefinition;
		}
	}
}
