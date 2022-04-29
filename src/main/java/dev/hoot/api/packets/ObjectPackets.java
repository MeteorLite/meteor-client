package dev.hoot.api.packets;

import dev.hoot.api.game.Game;
import meteor.api.packets.ClientPackets;
import net.runelite.api.Item;
import net.runelite.api.Point;
import net.runelite.api.TileObject;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.packets.PacketBufferNode;

import java.util.List;

public class ObjectPackets
{
	public static void tileObjectFirstOption(TileObject object, boolean ctrlDown)
	{
		Point p = object.menuPoint();
		LocalPoint lp = new LocalPoint(p.getX(), p.getY());
		WorldPoint wp = WorldPoint.fromScene(Game.getClient(), lp.getX(), lp.getY(), object.getPlane());
		queueTileObjectAction1Packet(object.getId(), wp.getX(), wp.getY(), ctrlDown);
	}

	public static void tileObjectSecondOption(TileObject object, boolean ctrlDown)
	{
		Point p = object.menuPoint();
		LocalPoint lp = new LocalPoint(p.getX(), p.getY());
		WorldPoint wp = WorldPoint.fromScene(Game.getClient(), lp.getX(), lp.getY(), object.getPlane());
		queueTileObjectAction2Packet(object.getId(), wp.getX(), wp.getY(), ctrlDown);
	}

	public static void tileObjectThirdOption(TileObject object, boolean ctrlDown)
	{
		Point p = object.menuPoint();
		LocalPoint lp = new LocalPoint(p.getX(), p.getY());
		WorldPoint wp = WorldPoint.fromScene(Game.getClient(), lp.getX(), lp.getY(), object.getPlane());
		queueTileObjectAction3Packet(object.getId(), wp.getX(), wp.getY(), ctrlDown);
	}

	public static void tileObjectFourthOption(TileObject object, boolean ctrlDown)
	{
		Point p = object.menuPoint();
		LocalPoint lp = new LocalPoint(p.getX(), p.getY());
		WorldPoint wp = WorldPoint.fromScene(Game.getClient(), lp.getX(), lp.getY(), object.getPlane());
		queueTileObjectAction4Packet(object.getId(), wp.getX(), wp.getY(), ctrlDown);
	}

	public static void tileObjectFifthOption(TileObject object, boolean ctrlDown)
	{
		Point p = object.menuPoint();
		LocalPoint lp = new LocalPoint(p.getX(), p.getY());
		WorldPoint wp = WorldPoint.fromScene(Game.getClient(), lp.getX(), lp.getY(), object.getPlane());
		queueTileObjectAction5Packet(object.getId(), wp.getX(), wp.getY(), ctrlDown);
	}

	public static void tileObjectAction(TileObject object, String action, boolean ctrlDown)
	{
		List<String> actions = object.getActions();
		int index = actions.indexOf(action);
		switch (index)
		{
			case 0:
				tileObjectFirstOption(object, ctrlDown);
				break;
			case 1:
				tileObjectSecondOption(object, ctrlDown);
				break;
			case 2:
				tileObjectThirdOption(object, ctrlDown);
				break;
			case 3:
				tileObjectFourthOption(object, ctrlDown);
				break;
			case 4:
				tileObjectFifthOption(object, ctrlDown);
				break;
		}
	}

	public static void useItemOnTileObject(Item item, TileObject object)
	{
		Point p = object.menuPoint();
		LocalPoint lp = new LocalPoint(p.getX(), p.getY());
		WorldPoint wp = WorldPoint.fromScene(Game.getClient(), lp.getX(), lp.getY(), object.getPlane());
		queueItemUseOnTileObjectPacket(object.getId(), wp.getX(), wp.getY(), item.getSlot(), item.getId(), item.getWidgetId(), false);
	}

	public static PacketBufferNode createObjectFirstActionPacket(int objectId, int worldPointX, int worldPointY,
															 boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createObjectActionPacket("OPLOC1", objectId, worldPointX, worldPointY, ctrlDown);
	}

	public static PacketBufferNode createObjectSecondActionPacket(int objectId, int worldPointX, int worldPointY,
																 boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createObjectActionPacket("OPLOC2", objectId, worldPointX, worldPointY, ctrlDown);
	}

	public static PacketBufferNode createObjectThirdActionPacket(int objectId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createObjectActionPacket("OPLOC3", objectId, worldPointX, worldPointY, ctrlDown);
	}

	public static PacketBufferNode createObjectFourthActionPacket(int objectId, int worldPointX, int worldPointY,
															 boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createObjectActionPacket("OPLOC4", objectId, worldPointX, worldPointY, ctrlDown);
	}

	public static PacketBufferNode createObjectFifthActionPacket(int objectId, int worldPointX, int worldPointY,
																  boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createObjectActionPacket("OPLOC5", objectId, worldPointX, worldPointY, ctrlDown);
	}

	public static PacketBufferNode createItemOnObjectPacket(int objectId, int worldPointX, int worldPointY, int slot, int itemID, int widgetID, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(client.createClientPacket(ClientPackets.INSTANCE.getPacket("OPOBJT").opcode, ClientPackets.INSTANCE.getPacket("OPOBJT").size), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortAdd(itemID);
		packetBufferNode.getPacketBuffer().writeByte(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeShortAddLE(worldPointY);
		packetBufferNode.getPacketBuffer().writeShortAdd(slot);
		packetBufferNode.getPacketBuffer().writeShortAdd(worldPointX);
		packetBufferNode.getPacketBuffer().writeIntME(widgetID);
		packetBufferNode.getPacketBuffer().writeShortLE(objectId);
		return packetBufferNode;
	}

	public static PacketBufferNode createSpellOnObjectPacket(int objectId, int worldPointX, int worldPointY, int slot, int ID, int widgetID, boolean ctrlDown)
	{
		return ClientPackets.INSTANCE.createWidgetOnObjectPacket("OPOBJT", objectId, worldPointX, worldPointY, slot, ID, widgetID, ctrlDown);
	}

	public static void queueItemUseOnTileObjectPacket(int objectId, int worldPointX, int worldPointY, int itemSlot, int itemId, int itemWidgetId, boolean ctrlDown)
	{
		createItemOnObjectPacket(objectId, worldPointX, worldPointY, itemSlot, itemId, itemWidgetId, ctrlDown).send();
	}

	public static void queueSpellOnTileObjectPacket(int objectId, int worldPointX, int worldPointY, int slot, int ID, int widgetID, boolean ctrlDown)
	{
		createSpellOnObjectPacket(objectId, worldPointX, worldPointY, slot, ID, widgetID, ctrlDown).send();
	}

	public static void queueTileObjectAction1Packet(int objectId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		createObjectFirstActionPacket(objectId, worldPointX, worldPointY, ctrlDown).send();
	}

	public static void queueTileObjectAction2Packet(int objectId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		createObjectSecondActionPacket(objectId, worldPointX, worldPointY, ctrlDown).send();
	}

	public static void queueTileObjectAction3Packet(int objectId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		createObjectThirdActionPacket(objectId, worldPointX, worldPointY, ctrlDown).send();
	}

	public static void queueTileObjectAction4Packet(int objectId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		createObjectFourthActionPacket(objectId, worldPointX, worldPointY, ctrlDown).send();
	}

	public static void queueTileObjectAction5Packet(int objectId, int worldPointX, int worldPointY, boolean ctrlDown)
	{
		createObjectFifthActionPacket(objectId, worldPointX, worldPointY, ctrlDown).send();
	}

	public static PacketBufferNode createWidgetOnObjectPacket(int objectId, int worldPointX, int worldPointY, int childIndex, int itemId, int widgetId, boolean ctrlDown)
	{
		var client = Game.getClient();
		var clientPacket = Game.getClientPacket();
		var packetBufferNode = Game.getClient().preparePacket(clientPacket.OPLOCT(), client.getPacketWriter().getIsaacCipher());
		packetBufferNode.getPacketBuffer().writeShortAdd(itemId);
		packetBufferNode.getPacketBuffer().writeByte(ctrlDown ? 1 : 0);
		packetBufferNode.getPacketBuffer().writeShortAddLE(worldPointY);
		packetBufferNode.getPacketBuffer().writeShortAdd(childIndex);
		packetBufferNode.getPacketBuffer().writeShortAdd(worldPointX);
		packetBufferNode.getPacketBuffer().writeIntME(widgetId);
		packetBufferNode.getPacketBuffer().writeShortLE(objectId);
		return packetBufferNode;
	}
}