import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
public class class71 {
	@ObfuscatedName("a")
	static final BigInteger field893;
	@ObfuscatedName("f")
	static final BigInteger field894;

	static {
		field893 = new BigInteger("10001", 16);
		field894 = new BigInteger("a65afc7b11a18da1a1bd0e144ea1883463fa040a57341006cec6556954e275446d8b0a222076a68fb0cb6d1fcaa9e7969affe6d5c42ccdba314e465d6dcf69a2bce2c6c70abc884349a2e31bf334ba712e4f7cda455562a80f3ceb1134e6459974780798ef38221e2fa1b9bd6560e120258f366e732b75bd7a385f07a5f5330d", 16);
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(Lqk;II)V",
		garbageValue = "1427665034"
	)
	@Export("readPlayerUpdate")
	static void readPlayerUpdate(PacketBuffer var0, int var1) {
		boolean var2 = var0.readBits(1) == 1;
		if (var2) {
			Players.Players_pendingUpdateIndices[++Players.Players_pendingUpdateCount - 1] = var1;
		}

		int var3 = var0.readBits(2);
		Player var4 = Client.players[var1];
		if (var3 == 0) {
			if (var2) {
				var4.field1116 = false;
			} else if (Client.localPlayerIndex == var1) {
				throw new RuntimeException();
			} else {
				Players.Players_regions[var1] = (var4.plane << 28) + (class158.baseY * 64 + var4.pathY[0] >> 13) + (
            KeyHandler.baseX * 64 + var4.pathX[0] >> 13 << 14);
				if (var4.field1203 != -1) {
					Players.Players_orientations[var1] = var4.field1203;
				} else {
					Players.Players_orientations[var1] = var4.orientation;
				}

				Players.Players_targetIndices[var1] = var4.targetIndex;
				Client.players[var1] = null;
				if (var0.readBits(1) != 0) {
					class412.updateExternalPlayer(var0, var1);
				}

			}
		} else {
			int var5;
			int var6;
			int var7;
			if (var3 == 1) {
				var5 = var0.readBits(3);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					--var6;
					--var7;
				} else if (var5 == 1) {
					--var7;
				} else if (var5 == 2) {
					++var6;
					--var7;
				} else if (var5 == 3) {
					--var6;
				} else if (var5 == 4) {
					++var6;
				} else if (var5 == 5) {
					--var6;
					++var7;
				} else if (var5 == 6) {
					++var7;
				} else if (var5 == 7) {
					++var6;
					++var7;
				}

				if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
					var4.resetPath(var6, var7);
					var4.field1116 = false;
				} else if (var2) {
					var4.field1116 = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.field1116 = false;
					var4.method2291(var6, var7, Players.field1314[var1]);
				}

			} else if (var3 == 2) {
				var5 = var0.readBits(4);
				var6 = var4.pathX[0];
				var7 = var4.pathY[0];
				if (var5 == 0) {
					var6 -= 2;
					var7 -= 2;
				} else if (var5 == 1) {
					--var6;
					var7 -= 2;
				} else if (var5 == 2) {
					var7 -= 2;
				} else if (var5 == 3) {
					++var6;
					var7 -= 2;
				} else if (var5 == 4) {
					var6 += 2;
					var7 -= 2;
				} else if (var5 == 5) {
					var6 -= 2;
					--var7;
				} else if (var5 == 6) {
					var6 += 2;
					--var7;
				} else if (var5 == 7) {
					var6 -= 2;
				} else if (var5 == 8) {
					var6 += 2;
				} else if (var5 == 9) {
					var6 -= 2;
					++var7;
				} else if (var5 == 10) {
					var6 += 2;
					++var7;
				} else if (var5 == 11) {
					var6 -= 2;
					var7 += 2;
				} else if (var5 == 12) {
					--var6;
					var7 += 2;
				} else if (var5 == 13) {
					var7 += 2;
				} else if (var5 == 14) {
					++var6;
					var7 += 2;
				} else if (var5 == 15) {
					var6 += 2;
					var7 += 2;
				}

				if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
					var4.resetPath(var6, var7);
					var4.field1116 = false;
				} else if (var2) {
					var4.field1116 = true;
					var4.tileX = var6;
					var4.tileY = var7;
				} else {
					var4.field1116 = false;
					var4.method2291(var6, var7, Players.field1314[var1]);
				}

			} else {
				var5 = var0.readBits(1);
				int var8;
				int var9;
				int var10;
				int var11;
				if (var5 == 0) {
					var6 = var0.readBits(12);
					var7 = var6 >> 10;
					var8 = var6 >> 5 & 31;
					if (var8 > 15) {
						var8 -= 32;
					}

					var9 = var6 & 31;
					if (var9 > 15) {
						var9 -= 32;
					}

					var10 = var8 + var4.pathX[0];
					var11 = var9 + var4.pathY[0];
					if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
						var4.resetPath(var10, var11);
						var4.field1116 = false;
					} else if (var2) {
						var4.field1116 = true;
						var4.tileX = var10;
						var4.tileY = var11;
					} else {
						var4.field1116 = false;
						var4.method2291(var10, var11, Players.field1314[var1]);
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						ApproximateRouteStrategy.Client_plane = var4.plane;
					}

				} else {
					var6 = var0.readBits(30);
					var7 = var6 >> 28;
					var8 = var6 >> 14 & 16383;
					var9 = var6 & 16383;
					var10 = (KeyHandler.baseX * 64 + var8 + var4.pathX[0] & 16383) - KeyHandler.baseX * 64;
					var11 = (class158.baseY * 64 + var9 + var4.pathY[0] & 16383) - class158.baseY * 64;
					if (Client.localPlayerIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
						var4.resetPath(var10, var11);
						var4.field1116 = false;
					} else if (var2) {
						var4.field1116 = true;
						var4.tileX = var10;
						var4.tileY = var11;
					} else {
						var4.field1116 = false;
						var4.method2291(var10, var11, Players.field1314[var1]);
					}

					var4.plane = (byte)(var7 + var4.plane & 3);
					if (Client.localPlayerIndex == var1) {
						ApproximateRouteStrategy.Client_plane = var4.plane;
					}

				}
			}
		}
	}
}
