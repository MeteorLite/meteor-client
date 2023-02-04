package mixins;

import dev.hoot.api.events.PacketSent;
import eventbus.Events;
import net.runelite.api.mixins.*;
import net.runelite.api.packets.PacketBufferNode;
import net.runelite.rs.api.RSClient;
import net.runelite.rs.api.RSPacketBufferNode;
import net.runelite.rs.api.RSPacketWriter;

@Mixin(RSPacketWriter.class)
public abstract class RSPacketWriterMixin implements RSPacketWriter
{
	@Shadow("client")
	private static RSClient client;

	@Inject
	@Override
	public void queuePacket(PacketBufferNode packetBufferNode)
	{
		sendPacket((RSPacketBufferNode) packetBufferNode);
	}

	@Copy("addNode")
	public void rs$addNode(RSPacketBufferNode packetNode) {}
}
