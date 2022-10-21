package dev.hoot.api.packets;

import dev.hoot.api.game.Game;
import meteor.api.packets.ClientPackets;
import net.runelite.api.Client;
import net.runelite.api.packets.ClientPacket;
import net.runelite.api.packets.PacketBufferNode;

public class PlayerPackets
{
	public static void queueItemUseOnPlayerPacket(int playerIndex, int itemId, int itemSlot, int itemWidgetId, boolean ctrlDown)
	{
		createItemOnPlayerPacket(playerIndex, itemId, itemSlot, itemWidgetId, ctrlDown).send();
	}

	public static PacketBufferNode createItemOnPlayerPacket(int playerIndex, int itemId, int itemSlot, int itemWidgetId, boolean ctrlDown)
	{
		return createWidgetOnPlayer(playerIndex, itemId, itemSlot, itemWidgetId, ctrlDown);
	}

	public static void queueSpellOnPlayerPacket(int playerIndex, int spellWidgetId, boolean ctrlDown)
	{
		createSpellOnPlayer(playerIndex, spellWidgetId, ctrlDown).send();
	}

	public static void queuePlayerAction1Packet(int playerIndex, boolean ctrlDown)
	{
		createFirstAction(playerIndex, ctrlDown).send();
	}

	public static void queuePlayerAction2Packet(int playerIndex, boolean ctrlDown)
	{
		createSecondAction(playerIndex, ctrlDown).send();
	}

	public static void queuePlayerAction3Packet(int playerIndex, boolean ctrlDown)
	{
		createThirdAction(playerIndex, ctrlDown).send();
	}

	public static void queuePlayerAction4Packet(int playerIndex, boolean ctrlDown)
	{
		createFourthAction(playerIndex, ctrlDown).send();
	}

	public static void queuePlayerAction5Packet(int playerIndex, boolean ctrlDown)
	{
		createFifthAction(playerIndex, ctrlDown).send();
	}

	public static void queuePlayerAction6Packet(int playerIndex, boolean ctrlDown)
	{
		createSixthAction(playerIndex, ctrlDown).send();
	}

	public static void queuePlayerAction7Packet(int playerIndex, boolean ctrlDown)
	{
		createSeventhAction(playerIndex, ctrlDown).send();
	}

	public static void queuePlayerAction8Packet(int playerIndex, boolean ctrlDown)
	{
		createEighthAction(playerIndex, ctrlDown).send();
	}

	public static PacketBufferNode createWidgetOnPlayer(int playerIndex, int sourceItemId, int sourceSlot, int sourceWidgetId, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYERT(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShort(sourceSlot);	// Old: packetBufferNode.getPacketBuffer().writeInt(sourceWidgetId);
		packetBufferNode.getPacketBuffer().writeShortAddLE(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeByteSub(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeByteNeg(ctrlDown ? 1 : 0);	// Old: packetBufferNode.getPacketBuffer().writeShortLE(sourceItemId);
		packetBufferNode.getPacketBuffer().writeInt(sourceWidgetId);	// Old: packetBufferNode.getPacketBuffer().writeShort(sourceSlot);
		packetBufferNode.getPacketBuffer().writeShortLE(sourceItemId);	// Old: packetBufferNode.getPacketBuffer().writeShortAddLE(playerIndex);
		return packetBufferNode;
	}

	public static PacketBufferNode createSpellOnPlayer(int playerIndex, int spellWidgetId, boolean ctrlDown)
	{
		return createWidgetOnPlayer(playerIndex, -1, -1, spellWidgetId, ctrlDown);
	}

	public static PacketBufferNode createFirstAction(int playerIndex, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYER1(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShort(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeShort(playerIndex);
		packetBufferNode.getPacketBuffer().writeByte(ctrlDown ? 1 : 0);	// Old: packetBufferNode.getPacketBuffer().writeByteAdd(ctrlDown ? 1 : 0);
		return packetBufferNode;
	}

	public static PacketBufferNode createSecondAction(int playerIndex, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYER2(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortAdd(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeShortLE(playerIndex);
		packetBufferNode.getPacketBuffer().writeByteAdd(ctrlDown ? 1 : 0);	// Old: packetBufferNode.getPacketBuffer().writeByteNeg(ctrlDown ? 1 : 0);
		return packetBufferNode;
	}

	public static PacketBufferNode createThirdAction(int playerIndex, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYER3(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortAddLE(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeByteSub(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeByteNeg(ctrlDown ? 1 : 0);	// Old: packetBufferNode.getPacketBuffer().writeShort(playerIndex);
		return packetBufferNode;
	}

	public static PacketBufferNode createFourthAction(int playerIndex, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYER4(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeByteAdd(ctrlDown ? 1 : 0);	// Old: packetBufferNode.getPacketBuffer().writeByte(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeShortAdd(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeShortAddLE(playerIndex);
		return packetBufferNode;
	}

	public static PacketBufferNode createFifthAction(int playerIndex, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYER5(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortLE(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeShort(playerIndex);
		packetBufferNode.getPacketBuffer().writeByte(ctrlDown ? 1 : 0);	// Old: packetBufferNode.getPacketBuffer().writeByteSub(ctrlDown ? 1 : 0);
		return packetBufferNode;
	}

	public static PacketBufferNode createSixthAction(int playerIndex, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYER6(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortLE(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeShortAddLE(playerIndex);
		packetBufferNode.getPacketBuffer().writeByteAdd(ctrlDown ? 1 : 0);
		return packetBufferNode;
	}

	public static PacketBufferNode createSeventhAction(int playerIndex, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYER7(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShort(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeByteSub(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeByte(ctrlDown ? 1 : 0);	// Old: packetBufferNode.getPacketBuffer().writeShortAddLE(playerIndex);
		return packetBufferNode;
	}

	public static PacketBufferNode createEighthAction(int playerIndex, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPPLAYER8(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeByteNeg(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeShort(playerIndex);	// Old: packetBufferNode.getPacketBuffer().writeShortAddLE(playerIndex);
		return packetBufferNode;
	}

}