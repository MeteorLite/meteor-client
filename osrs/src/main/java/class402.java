import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pw")
public final class class402 {
	@ObfuscatedName("al")
	static int field3694;
	@ObfuscatedName("at")
	final Object field3696;
	@ObfuscatedName("ah")
	int field3695;

	class402(Object var1, int var2) {
		this.field3696 = var1;
		this.field3695 = var2;
	}

	@ObfuscatedName("kh")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;B)V",
		garbageValue = "-6"
	)
	static void method2043(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, class89.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != class229.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = class113.getPacketBufferNode(ClientPacket.OPPLAYER1, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3[var6]);
					var8.packetBuffer.writeByteNeg(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = class113.getPacketBufferNode(ClientPacket.OPPLAYER4, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByteSub(0);
					var8.packetBuffer.writeIntME(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = class113.getPacketBufferNode(ClientPacket.OPPLAYER6, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByteSub(0);
					var8.packetBuffer.writeShort(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = class113.getPacketBufferNode(ClientPacket.OPPLAYER7, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShortLE(var3[var6]);
					var8.packetBuffer.writeByteSub(0);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			GrandExchangeOfferUnitPriceComparator.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}