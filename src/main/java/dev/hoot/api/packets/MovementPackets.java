package dev.hoot.api.packets;

import dev.hoot.api.game.Game;
import net.runelite.api.Client;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.packets.ClientPacket;
import net.runelite.api.packets.PacketBufferNode;

public class MovementPackets
{
	public static void sendMovement(int worldX, int worldY)
	{
		MovementPackets.sendMovement(worldX, worldY, false);
	}

	public static void sendMovement(WorldPoint worldPoint, boolean ctrlDown)
	{
		MovementPackets.sendMovement(worldPoint.getX(), worldPoint.getY(), ctrlDown);
	}

	public static void sendMovement(WorldPoint worldPoint)
	{
		MovementPackets.sendMovement(worldPoint, false);
	}

	public static void sendMovement(int worldPointX, int worldPointY, boolean ctrlDown)
	{
		createMovement(worldPointX, worldPointY, ctrlDown).send();
	}

	public static PacketBufferNode createMovement(int worldPointX, int worldPointY, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.MOVE_GAMECLICK(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeByte(5);
		packetBufferNode.getPacketBuffer().writeByte(ctrlDown ? 2 : 0);	// Old: packetBufferNode.getPacketBuffer().writeByteSub(ctrlDown ? 2 : 0);
		packetBufferNode.getPacketBuffer().writeShort(worldPointX);	// Old: packetBufferNode.getPacketBuffer().writeShortAddLE(worldPointY);
		packetBufferNode.getPacketBuffer().writeShortLE(worldPointY);	// Old: packetBufferNode.getPacketBuffer().writeShort(worldPointX);
		return packetBufferNode;
	}
}