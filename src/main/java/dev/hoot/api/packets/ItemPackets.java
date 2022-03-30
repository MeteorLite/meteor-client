package dev.hoot.api.packets;

import dev.hoot.api.game.Game;
import dev.hoot.api.widgets.Widgets;
import meteor.api.packets.ClientPackets;
import net.runelite.api.Client;
import net.runelite.api.InventoryID;
import net.runelite.api.Item;
import net.runelite.api.packets.ClientPacket;
import net.runelite.api.packets.PacketBufferNode;
import net.runelite.api.widgets.WidgetInfo;
import net.runelite.packets.ObfuscatedClientPacket;

import java.util.List;

public class ItemPackets
{
	public static void itemAction(Item item, String action)
	{

		List<String> actions = List.of(Game.getClient().getItemDefinition(item.getId()).getInventoryActions());
		int index = actions.indexOf(action);
		System.out.println(index);
		switch (index) {
			case 0 -> itemFirstOption(item);
			case 1 -> itemSecondOption(item);
			case 2 -> itemThirdOption(item);
			case 3 -> itemFourthOption(item);
			case 4 -> itemFifthOption(item);
			default -> WidgetPackets.widgetAction(Widgets.fromId(item.getWidgetId()), action);
		}
	}

	public static void itemFirstOption(Item item)
	{
		queueItemAction1Packet(item.getWidgetId(), item.getId(), item.getSlot());
	}

	public static void itemSecondOption(Item item)
	{
		queueItemAction2Packet(item.getWidgetId(), item.getId(), item.getSlot());
	}

	public static void itemThirdOption(Item item)
	{
		queueItemAction3Packet(item.getWidgetId(), item.getId(), item.getSlot());
	}

	public static void itemFourthOption(Item item)
	{
		queueItemAction4Packet(item.getWidgetId(), item.getId(), item.getSlot());
	}

	public static void itemFifthOption(Item item)
	{
		queueItemAction5Packet(item.getWidgetId(), item.getId(), item.getSlot());
	}

	public static void useItemOnItem(Item item, Item item2)
	{
		if ((item.getType().getInventoryID() != InventoryID.INVENTORY) || (item2.getType().getInventoryID() != InventoryID.INVENTORY))
		{
			return;
		}

		queueItemOnItemPacket(item.getId(), item.getSlot(), item2.getId(), item2.getSlot());
	}

	public static void queueItemOnItemPacket(int sourceItemId, int sourceItemSlot, int itemId, int itemSlot)
	{
		createItemOnItem(sourceItemId, sourceItemSlot, itemId, itemSlot).send();
	}

	public static void queueSpellOnItemPacket(int itemId, int itemSlot, int spellWidgetId)
	{
		createSpellOnItem(itemId, itemSlot, spellWidgetId).send();
	}

	public static void queueItemAction1Packet(int itemWidgetId, int itemId, int itemSlot)
	{
		createFirstAction(itemWidgetId, itemId, itemSlot).send();
	}

	public static void queueItemAction2Packet(int itemWidgetId, int itemId, int itemSlot)
	{
		createSecondAction(itemWidgetId, itemId, itemSlot).send();;
	}

	public static void queueItemAction3Packet(int itemWidgetId, int itemId, int itemSlot)
	{
		createThirdAction(itemWidgetId, itemId, itemSlot).send();;
	}

	public static void queueItemAction4Packet(int itemWidgetId, int itemId, int itemSlot)
	{
		createFourthAction(itemWidgetId, itemId, itemSlot).send();;
	}

	public static void queueItemAction5Packet(int itemWidgetId, int itemId, int itemSlot)
	{
		createFifthAction(itemWidgetId, itemId, itemSlot).send();;
	}

	public static PacketBufferNode createFirstAction(int itemWidgetId, int itemId, int itemSlot)
	{
		ObfuscatedClientPacket packet = ClientPackets.INSTANCE.get("OPHELD1");
		return ClientPackets.INSTANCE.createItemPacket(packet, itemId, itemSlot, itemWidgetId);
	}

	public static PacketBufferNode createSecondAction(int itemWidgetId, int itemId, int itemSlot)
	{
		ObfuscatedClientPacket packet = ClientPackets.INSTANCE.get("OPHELD2");
		return ClientPackets.INSTANCE.createItemPacket(packet, itemId, itemSlot, itemWidgetId);
	}

	public static PacketBufferNode createThirdAction(int itemWidgetId, int itemId, int itemSlot)
	{
		ObfuscatedClientPacket packet = ClientPackets.INSTANCE.get("OPHELD3");
		return ClientPackets.INSTANCE.createItemPacket(packet, itemId, itemSlot, itemWidgetId);
	}

	public static PacketBufferNode createFourthAction(int itemWidgetId, int itemId, int itemSlot)
	{
		ObfuscatedClientPacket packet = ClientPackets.INSTANCE.get("OPHELD4");
		return ClientPackets.INSTANCE.createItemPacket(packet, itemId, itemSlot, itemWidgetId);
	}

	public static PacketBufferNode createFifthAction(int itemWidgetId, int itemId, int itemSlot)
	{
		ObfuscatedClientPacket packet = ClientPackets.INSTANCE.get("OPHELD5");
		return ClientPackets.INSTANCE.createItemPacket(packet, itemId, itemSlot, itemWidgetId);
	}

	public static PacketBufferNode createItemOnItem(int sourceItemId, int sourceItemSlot, int itemId, int itemSlot)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPHELDU(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeIntLE(WidgetInfo.INVENTORY.getId());
		packetBufferNode.getPacketBuffer().writeInt(WidgetInfo.INVENTORY.getId());
		packetBufferNode.getPacketBuffer().writeShortLE(sourceItemSlot);
		packetBufferNode.getPacketBuffer().writeShortLE(sourceItemId);
		packetBufferNode.getPacketBuffer().writeShortAdd(itemSlot);
		packetBufferNode.getPacketBuffer().writeShortAddLE(itemId);
		return packetBufferNode;
	}

	public static PacketBufferNode createSpellOnItem(int itemId, int itemSlot, int spellWidgetId)
	{
		Client client = Game.getClient();
		ClientPacket clientPacket = Game.getClientPacket();
		PacketBufferNode packetBufferNode = Game.getClient().preparePacket(clientPacket.OPHELDT(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortAdd(itemId);
		packetBufferNode.getPacketBuffer().writeShort(-1);
		packetBufferNode.getPacketBuffer().writeInt(spellWidgetId);
		packetBufferNode.getPacketBuffer().writeIntIME(WidgetInfo.INVENTORY.getId());
		packetBufferNode.getPacketBuffer().writeShortLE(itemSlot);
		return packetBufferNode;
	}
}