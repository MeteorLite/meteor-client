package net.runelite.rs.api;

import net.runelite.api.packets.PacketBufferNode;
import net.runelite.mapping.Import;

public interface RSPacketBufferNode extends PacketBufferNode
{
	@Import("packetBuffer")
	@Override
	RSPacketBuffer getPacketBuffer();

	@Import("packetBuffer")
	void setPacketBuffer(RSPacketBuffer buffer);

	@Import("clientPacket")
	@Override
	RSClientPacket getClientPacket();

	@Import("clientPacket")
	void setClientPacket(RSClientPacket clientPacket);

	@Import("clientPacketLength")
	int getClientPacketLength();

	@Import("clientPacketLength")
	int setClientPacketLength(int length);
}
