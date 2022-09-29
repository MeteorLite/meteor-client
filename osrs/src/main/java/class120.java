import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
public class class120 implements MouseWheel {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1498;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1486;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1492;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1488;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1489;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1487;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1491;
	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1501;
	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1490;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1494;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1495;
	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1496;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1497;
	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1503;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1499;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1500;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "Ldt;"
	)
	static final class120 field1493;
	@ObfuscatedName("jx")
	@ObfuscatedGetter(
		intValue = 511839437
	)
	static int field1505;
	@ObfuscatedName("a")
	@ObfuscatedGetter(
		intValue = -707953105
	)
	final int field1502;
	@ObfuscatedName("l")
	@ObfuscatedGetter(
		intValue = -962835261
	)
	final int field1485;
	@ObfuscatedName("e")
	@ObfuscatedGetter(
		intValue = -73804199
	)
	final int field1504;

	static {
		field1498 = new class120(0, 0, (String)null, -1, -1);
		field1486 = new class120(1, 1, (String)null, 0, 2);
		field1492 = new class120(2, 2, (String)null, 1, 2);
		field1488 = new class120(3, 3, (String)null, 2, 2);
		field1489 = new class120(4, 4, (String)null, 3, 1);
		field1487 = new class120(5, 5, (String)null, 4, 1);
		field1491 = new class120(6, 6, (String)null, 5, 1);
		field1501 = new class120(7, 7, (String)null, 6, 3);
		field1490 = new class120(8, 8, (String)null, 7, 3);
		field1494 = new class120(9, 9, (String)null, 8, 3);
		field1495 = new class120(10, 10, (String)null, 0, 7);
		field1496 = new class120(11, 11, (String)null, 1, 7);
		field1497 = new class120(12, 12, (String)null, 2, 7);
		field1503 = new class120(13, 13, (String)null, 3, 7);
		field1499 = new class120(14, 14, (String)null, 4, 7);
		field1500 = new class120(15, 15, (String)null, 5, 7);
		field1493 = new class120(16, 16, (String)null, 0, 5);
	}

	@ObfuscatedSignature(
		descriptor = "(IILjava/lang/String;II)V",
		garbageValue = "-1"
	)
	class120(int var1, int var2, String var3, int var4, int var5) {
		this.field1502 = var1;
		this.field1485 = var2;
		this.field1504 = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "98"
	)
	int method2914() {
		return this.field1504;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	public int rsOrdinal() {
		return this.field1485;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
		garbageValue = "62"
	)
	@Export("addChatMessage")
	static void addChatMessage(int var0, String var1, String var2, String var3) {
		ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
		if (var4 == null) {
			var4 = new ChatChannel();
			Messages.Messages_channels.put(var0, var4);
		}

		Message var5 = var4.addMessage(var0, var1, var2, var3);
		Messages.Messages_hashTable.put(var5, (long)var5.count);
		Messages.Messages_queue.add(var5);
		Client.chatCycle = Client.cycleCntr;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Ljf;Lqv;I)Ljm;",
		garbageValue = "-149759982"
	)
	@Export("getPacketBufferNode")
	public static PacketBufferNode getPacketBufferNode(ClientPacket var0, IsaacCipher var1) {
		PacketBufferNode var2 = PcmPlayer.method795();
		var2.clientPacket = var0;
		var2.clientPacketLength = var0.length;
		if (var2.clientPacketLength == -1) {
			var2.packetBuffer = new PacketBuffer(260);
		} else if (var2.clientPacketLength == -2) {
			var2.packetBuffer = new PacketBuffer(10000);
		} else if (var2.clientPacketLength <= 18) {
			var2.packetBuffer = new PacketBuffer(20);
		} else if (var2.clientPacketLength <= 98) {
			var2.packetBuffer = new PacketBuffer(100);
		} else {
			var2.packetBuffer = new PacketBuffer(260);
		}

		var2.packetBuffer.setIsaacCipher(var1);
		var2.packetBuffer.writeByteIsaac(var2.clientPacket.id);
		var2.index = 0;
		return var2;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(III)Lbt;",
		garbageValue = "1315361188"
	)
	static Script method2925(int var0, int var1) {
		Script var2 = (Script)Script.Script_cached.get((long)(var0 << 16));
		if (var2 != null) {
			return var2;
		} else {
			String var3 = String.valueOf(var0);
			int var4 = class102.archive12.getGroupId(var3);
			if (var4 == -1) {
				return null;
			} else {
				byte[] var5 = class102.archive12.takeFileFlat(var4);
				if (var5 != null) {
					if (var5.length <= 1) {
						return null;
					}

					var2 = WorldMapRegion.newScript(var5);
					if (var2 != null) {
						Script.Script_cached.put(var2, (long)(var0 << 16));
						return var2;
					}
				}

				return null;
			}
		}
	}

	@ObfuscatedName("ge")
	@ObfuscatedSignature(
		descriptor = "(Lcl;III)V",
		garbageValue = "-847441656"
	)
	@Export("performPlayerAnimation")
	static void performPlayerAnimation(Player var0, int var1, int var2) {
		if (var0.sequence == var1 && var1 != -1) {
			int var3 = class4.SequenceDefinition_get(var1).field2219;
			if (var3 == 1) {
				var0.sequenceFrame = 0;
				var0.sequenceFrameCycle = 0;
				var0.sequenceDelay = var2;
				var0.field1173 = 0;
			}

			if (var3 == 2) {
				var0.field1173 = 0;
			}
		} else if (var1 == -1 || var0.sequence == -1 || class4.SequenceDefinition_get(var1).field2212 >= class4.SequenceDefinition_get(var0.sequence).field2212) {
			var0.sequence = var1;
			var0.sequenceFrame = 0;
			var0.sequenceFrameCycle = 0;
			var0.sequenceDelay = var2;
			var0.field1173 = 0;
			var0.field1202 = var0.pathLength;
		}

	}

	@ObfuscatedName("hq")
	@ObfuscatedSignature(
		descriptor = "(IIII)I",
		garbageValue = "-678199790"
	)
	@Export("getTileHeight")
	static final int getTileHeight(int var0, int var1, int var2) {
		int var3 = var0 >> 7;
		int var4 = var1 >> 7;
		if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
			int var5 = var2;
			if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
				var5 = var2 + 1;
			}

			int var6 = var0 & 127;
			int var7 = var1 & 127;
			int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
			int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
			return var7 * var9 + var8 * (128 - var7) >> 7;
		} else {
			return 0;
		}
	}

	@ObfuscatedName("lb")
	@ObfuscatedSignature(
		descriptor = "(Lcv;ZB)V",
		garbageValue = "-126"
	)
	@Export("closeInterface")
	static final void closeInterface(InterfaceParent var0, boolean var1) {
		int var2 = var0.group;
		int var3 = (int)var0.key;
		var0.remove();
		if (var1) {
			WorldMapSection2.method4729(var2);
		}

		ObjectSound.method1850(var2);
		Widget var4 = SpotAnimationDefinition.getWidget(var3);
		if (var4 != null) {
			class403.invalidateWidget(var4);
		}

		if (Client.rootInterface != -1) {
			class18.runIntfCloseListeners(Client.rootInterface, 1);
		}

	}
}
