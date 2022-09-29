import java.util.Collections;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
public class class307 {
	static {
		int var0 = 0;
		int var1 = 0;
		class303[] var2 = PendingSpawn.method2330();

		for (int var3 = 0; var3 < var2.length; ++var3) {
			class303 var4 = var2[var3];
			if (var4.field3621 > var0) {
				var0 = var4.field3621;
			}

			if (var4.field3622 > var1) {
				var1 = var4.field3622;
			}
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "([I[IB)V",
		garbageValue = "47"
	)
	public static void method5930(int[] var0, int[] var1) {
		if (var0 != null && var1 != null) {
			ArchiveDiskActionHandler.ByteArrayPool_alternativeSizes = var0;
			class137.ByteArrayPool_altSizeArrayCounts = new int[var0.length];
			UrlRequest.ByteArrayPool_arrays = new byte[var0.length][][];

			for (int var2 = 0; var2 < ArchiveDiskActionHandler.ByteArrayPool_alternativeSizes.length; ++var2) {
				UrlRequest.ByteArrayPool_arrays[var2] = new byte[var1[var2]][];
				ByteArrayPool.field4259.add(var0[var2]);
			}

			Collections.sort(ByteArrayPool.field4259);
		} else {
			ArchiveDiskActionHandler.ByteArrayPool_alternativeSizes = null;
			class137.ByteArrayPool_altSizeArrayCounts = null;
			UrlRequest.ByteArrayPool_arrays = null;
			FriendSystem.method1807();
		}
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(CB)Z",
		garbageValue = "-98"
	)
	public static boolean method5928(char var0) {
		if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
			if (var0 != 0) {
				char[] var1 = class342.cp1252AsciiExtension;

				for (int var2 = 0; var2 < var1.length; ++var2) {
					char var3 = var1[var2];
					if (var0 == var3) {
						return true;
					}
				}
			}

			return false;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIII)V",
		garbageValue = "-1715477286"
	)
	static final void method5929(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
		var5 = Huffman.method5646(var5, var6);
		int var7 = 2048 - var3 & 2047;
		int var8 = 2048 - var4 & 2047;
		int var9 = 0;
		int var10 = 0;
		int var11 = var5;
		int var12;
		int var13;
		int var14;
		if (var7 != 0) {
			var12 = Rasterizer3D.Rasterizer3D_sine[var7];
			var13 = Rasterizer3D.Rasterizer3D_cosine[var7];
			var14 = var10 * var13 - var5 * var12 >> 16;
			var11 = var5 * var13 + var12 * var10 >> 16;
			var10 = var14;
		}

		if (var8 != 0) {
			var12 = Rasterizer3D.Rasterizer3D_sine[var8];
			var13 = Rasterizer3D.Rasterizer3D_cosine[var8];
			var14 = var9 * var13 + var11 * var12 >> 16;
			var11 = var13 * var11 - var9 * var12 >> 16;
			var9 = var14;
		}

		if (Client.isCameraLocked) {
			class402.field4479 = var0 - var9;
			class152.field1724 = var1 - var10;
			ArchiveDiskActionHandler.field4010 = var2 - var11;
			class21.field120 = var3;
			Client.field789 = var4;
		} else {
			TaskHandler.cameraX = var0 - var9;
			SecureRandomFuture.cameraY = var1 - var10;
			ApproximateRouteStrategy.cameraZ = var2 - var11;
			class163.cameraPitch = var3;
			class10.cameraYaw = var4;
		}

		if (Client.oculusOrbState == 1 && Client.staffModLevel >= 2 && Client.cycle % 50 == 0 && (class147.oculusOrbFocalPointX >> 7 != class67.localPlayer.x >> 7 || Language.oculusOrbFocalPointY >> 7 != class67.localPlayer.y >> 7)) {
			var12 = class67.localPlayer.plane;
			var13 = class128.baseX * 64 + (class147.oculusOrbFocalPointX >> 7);
			var14 = WorldMapData_1.baseY * 64 + (Language.oculusOrbFocalPointY >> 7);
			PacketBufferNode var15 = class120.getPacketBufferNode(ClientPacket.field3008, Client.packetWriter.isaacCipher);
			var15.packetBuffer.method7952(var12);
			var15.packetBuffer.writeShort(var14);
			var15.packetBuffer.method7971(Client.field754);
			var15.packetBuffer.method7961(var13);
			Client.packetWriter.addNode(var15);
		}

	}
}
