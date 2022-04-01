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

	public static PacketBufferNode createItemOnPlayerPacket(int playerIndex, int itemId, int itemSlot, int itemWidgetId,
										   boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createItemOnPlayerPacket("OPPLAYERU", playerIndex, itemId, itemSlot, itemWidgetId, ctrlDown);
	}

	public static PacketBufferNode createSpellOnPlayer(int playerIndex, int spellWidgetId, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createSpellOnPlayerPacket("OPPLAYERT", playerIndex, spellWidgetId, ctrlDown);
	}

	public static PacketBufferNode createFirstAction(int playerIndex, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createPlayerActionPacket("OPPLAYER1", playerIndex, ctrlDown);
	}

	public static PacketBufferNode createSecondAction(int playerIndex, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createPlayerActionPacket("OPPLAYER2", playerIndex, ctrlDown);
	}

	public static PacketBufferNode createThirdAction(int playerIndex, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createPlayerActionPacket("OPPLAYER3", playerIndex, ctrlDown);
	}

	public static PacketBufferNode createFourthAction(int playerIndex, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createPlayerActionPacket("OPPLAYER4", playerIndex, ctrlDown);
	}

	public static PacketBufferNode createFifthAction(int playerIndex, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createPlayerActionPacket("OPPLAYER5", playerIndex, ctrlDown);
	}

	public static PacketBufferNode createSixthAction(int playerIndex, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createPlayerActionPacket("OPPLAYER6", playerIndex, ctrlDown);
	}

	public static PacketBufferNode createSeventhAction(int playerIndex, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createPlayerActionPacket("OPPLAYER7", playerIndex, ctrlDown);
	}

	public static PacketBufferNode createEighthAction(int playerIndex, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createPlayerActionPacket("OPPLAYER8", playerIndex, ctrlDown);
	}
}