import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class272 {
	@ObfuscatedName("c")
	static int[] field3209;

	static {
		new Object();
		field3209 = new int[33];
		field3209[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field3209[var1] = var0 - 1;
			var0 += var0;
		}

	}

	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		descriptor = "(ZLqf;I)V",
		garbageValue = "-1747382017"
	)
	static final void method5399(boolean var0, PacketBuffer var1) {
		while (true) {
			if (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= 27) {
				int var2 = var1.readBits(15);
				if (var2 != 32767) {
					boolean var3 = false;
					if (Client.npcs[var2] == null) {
						Client.npcs[var2] = new NPC();
						var3 = true;
					}

					NPC var4 = Client.npcs[var2];
					Client.npcIndices[++Client.npcCount - 1] = var2;
					var4.npcCycle = Client.cycle;
					int var5;
					int var6;
					int var7;
					int var8;
					int var9;
					boolean var10;
					if (WorldMapSectionType.field2826) {
						var5 = var1.readBits(1);
						var4.definition = class193.getNpcDefinition(var1.readBits(14));
						var8 = var1.readBits(1);
						if (var8 == 1) {
							Client.field550[++Client.field549 - 1] = var2;
						}

						var9 = Client.defaultRotations[var1.readBits(3)];
						if (var3) {
							var4.orientation = var4.rotation = var9;
						}

						if (var0) {
							var6 = var1.readBits(8);
							if (var6 > 127) {
								var6 -= 256;
							}
						} else {
							var6 = var1.readBits(5);
							if (var6 > 15) {
								var6 -= 32;
							}
						}

						if (var0) {
							var7 = var1.readBits(8);
							if (var7 > 127) {
								var7 -= 256;
							}
						} else {
							var7 = var1.readBits(5);
							if (var7 > 15) {
								var7 -= 32;
							}
						}

						var10 = var1.readBits(1) == 1;
						if (var10) {
							var1.readBits(32);
						}
					} else {
						var8 = var1.readBits(1);
						if (var8 == 1) {
							Client.field550[++Client.field549 - 1] = var2;
						}

						var9 = Client.defaultRotations[var1.readBits(3)];
						if (var3) {
							var4.orientation = var4.rotation = var9;
						}

						var10 = var1.readBits(1) == 1;
						if (var10) {
							var1.readBits(32);
						}

						if (var0) {
							var7 = var1.readBits(8);
							if (var7 > 127) {
								var7 -= 256;
							}
						} else {
							var7 = var1.readBits(5);
							if (var7 > 15) {
								var7 -= 32;
							}
						}

						var5 = var1.readBits(1);
						if (var0) {
							var6 = var1.readBits(8);
							if (var6 > 127) {
								var6 -= 256;
							}
						} else {
							var6 = var1.readBits(5);
							if (var6 > 15) {
								var6 -= 32;
							}
						}

						var4.definition = class193.getNpcDefinition(var1.readBits(14));
					}

					var4.field1131 = var4.definition.size;
					var4.field1196 = var4.definition.rotation;
					if (var4.field1196 == 0) {
						var4.rotation = 0;
					}

					var4.walkSequence = var4.definition.walkSequence;
					var4.walkBackSequence = var4.definition.walkBackSequence;
					var4.walkLeftSequence = var4.definition.walkLeftSequence;
					var4.walkRightSequence = var4.definition.walkRightSequence;
					var4.idleSequence = var4.definition.idleSequence;
					var4.turnLeftSequence = var4.definition.turnLeftSequence;
					var4.turnRightSequence = var4.definition.turnRightSequence;
					var4.runSequence = var4.definition.field1944;
					var4.field1189 = var4.definition.field1945;
					var4.field1193 = var4.definition.field1956;
					var4.field1143 = var4.definition.field1947;
					var4.field1144 = var4.definition.field1971;
					var4.field1179 = var4.definition.field1949;
					var4.field1182 = var4.definition.field1950;
					var4.field1171 = var4.definition.field1941;
					var4.method2507(class67.localPlayer.pathX[0] + var6, class67.localPlayer.pathY[0] + var7, var5 == 1);
					continue;
				}
			}

			var1.exportIndex();
			return;
		}
	}

	@ObfuscatedName("jk")
	@ObfuscatedSignature(
		descriptor = "(IIIIIB)V",
		garbageValue = "-43"
	)
	@Export("drawScrollBar")
	static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
		ChatChannel.scrollBarSprites[0].drawAt(var0, var1);
		ChatChannel.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field508);
		int var5 = var3 * (var3 - 32) / var4;
		if (var5 < 8) {
			var5 = 8;
		}

		int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
		Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field716);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field727);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field727);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field727);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field727);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field568);
		Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field568);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var5 + var1 + 15, 16, Client.field568);
		Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var5 + var6 + var1 + 14, 15, Client.field568);
	}
}
