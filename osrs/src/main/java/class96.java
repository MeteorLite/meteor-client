import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class96 {
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "Lde;"
	)
	@Export("World_request")
	static UrlRequest World_request;

	@ObfuscatedName("gg")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "-1862516219"
	)
	static final void method2519(int var0, int var1, int var2) {
		if (TextureProvider.cameraX < var0) {
			TextureProvider.cameraX = (var0 - TextureProvider.cameraX) * UrlRequest.field1398 / 1000 + TextureProvider.cameraX + class323.field4093;
			if (TextureProvider.cameraX > var0) {
				TextureProvider.cameraX = var0;
			}
		}

		if (TextureProvider.cameraX > var0) {
			TextureProvider.cameraX -= (TextureProvider.cameraX - var0) * UrlRequest.field1398 / 1000 + class323.field4093;
			if (TextureProvider.cameraX < var0) {
				TextureProvider.cameraX = var0;
			}
		}

		if (class31.cameraY < var1) {
			class31.cameraY = (var1 - class31.cameraY) * UrlRequest.field1398 / 1000 + class31.cameraY + class323.field4093;
			if (class31.cameraY > var1) {
				class31.cameraY = var1;
			}
		}

		if (class31.cameraY > var1) {
			class31.cameraY -= (class31.cameraY - var1) * UrlRequest.field1398 / 1000 + class323.field4093;
			if (class31.cameraY < var1) {
				class31.cameraY = var1;
			}
		}

		if (class313.cameraZ < var2) {
			class313.cameraZ = (var2 - class313.cameraZ) * UrlRequest.field1398 / 1000 + class313.cameraZ + class323.field4093;
			if (class313.cameraZ > var2) {
				class313.cameraZ = var2;
			}
		}

		if (class313.cameraZ > var2) {
			class313.cameraZ -= (class313.cameraZ - var2) * UrlRequest.field1398 / 1000 + class323.field4093;
			if (class313.cameraZ < var2) {
				class313.cameraZ = var2;
			}
		}

	}

	@ObfuscatedName("iy")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/String;B)V",
		garbageValue = "64"
	)
	static void method2517(int var0, String var1) {
		int var2 = Players.Players_count;
		int[] var3 = Players.Players_indices;
		boolean var4 = false;
		Username var5 = new Username(var1, ViewportMouse.loginType);

		for (int var6 = 0; var6 < var2; ++var6) {
			Player var7 = Client.players[var3[var6]];
			if (var7 != null && var7 != class296.localPlayer && var7.username != null && var7.username.equals(var5)) {
				PacketBufferNode var8;
				if (var0 == 1) {
					var8 = FloorUnderlayDefinition.getPacketBufferNode(ClientPacket.field3067, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method8434(0);
					var8.packetBuffer.method8443(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 4) {
					var8 = FloorUnderlayDefinition.getPacketBufferNode(ClientPacket.field2999, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method8434(0);
					var8.packetBuffer.writeIntME(var3[var6]);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 6) {
					var8 = FloorUnderlayDefinition.getPacketBufferNode(ClientPacket.field3027, Client.packetWriter.isaacCipher);
					var8.packetBuffer.method8443(var3[var6]);
					var8.packetBuffer.method8434(0);
					Client.packetWriter.addNode(var8);
				} else if (var0 == 7) {
					var8 = FloorUnderlayDefinition.getPacketBufferNode(ClientPacket.field3046, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeShort(var3[var6]);
					var8.packetBuffer.writeByte(0);
					Client.packetWriter.addNode(var8);
				}

				var4 = true;
				break;
			}
		}

		if (!var4) {
			MouseHandler.addGameMessage(4, "", "Unable to find " + var1);
		}

	}
}
