import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.List;

@ObfuscatedName("an")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements class51 {
	@ObfuscatedName("wu")
	static List field67;
	@ObfuscatedName("cl")
	static int field66;

	DevicePcmPlayerProvider() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(S)Lby;",
		garbageValue = "-2211"
	)
	@Export("player")
	public PcmPlayer player() {
		return new DevicePcmPlayer();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Luj;II)Ljava/lang/String;",
		garbageValue = "1966437671"
	)
	static String method82(Buffer var0, int var1) {
		try {
			int var2 = var0.readUShortSmart();
			if (var2 > var1) {
				var2 = var1;
			}

			byte[] var3 = new byte[var2];
			var0.offset += class350.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
			String var4 = World.decodeStringCp1252(var3, 0, var2);
			return var4;
		} catch (Exception var6) {
			return "Cabbage";
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-26053498"
	)
	static final int method83(int var0, int var1) {
		int var2 = WorldMapIcon_0.method1301(45365 + var0, var1 + 91923, 4) - 128 + (WorldMapIcon_0.method1301(var0 + 10294, var1 + 37821, 2) - 128 >> 1) + (WorldMapIcon_0.method1301(var0, var1, 1) - 128 >> 2);
		var2 = (int)((double)var2 * 0.3D) + 35;
		if (var2 < 10) {
			var2 = 10;
		} else if (var2 > 60) {
			var2 = 60;
		}

		return var2;
	}

	@ObfuscatedName("ir")
	@ObfuscatedSignature(
		descriptor = "(Ldf;I)V",
		garbageValue = "1536572289"
	)
	static final void method84(Actor var0) {
		var0.movementSequence = var0.idleSequence;
		if (var0.pathLength == 0) {
			var0.field1028 = 0;
		} else {
			if (var0.sequence != -1 && var0.sequenceDelay == 0) {
				SequenceDefinition var1 = DynamicObject.SequenceDefinition_get(var0.sequence);
				if (var0.field1029 > 0 && var1.precedenceAnimating == 0) {
					++var0.field1028;
					return;
				}

				if (var0.field1029 <= 0 && var1.priority == 0) {
					++var0.field1028;
					return;
				}
			}

			int var10 = var0.x;
			int var2 = var0.y;
			int var3 = var0.field983 * 64 + var0.pathX[var0.pathLength - 1] * 128;
			int var4 = var0.field983 * 64 + var0.pathY[var0.pathLength - 1] * 128;
			if (var10 < var3) {
				if (var2 < var4) {
					var0.orientation = 1280;
				} else if (var2 > var4) {
					var0.orientation = 1792;
				} else {
					var0.orientation = 1536;
				}
			} else if (var10 > var3) {
				if (var2 < var4) {
					var0.orientation = 768;
				} else if (var2 > var4) {
					var0.orientation = 256;
				} else {
					var0.orientation = 512;
				}
			} else if (var2 < var4) {
				var0.orientation = 1024;
			} else if (var2 > var4) {
				var0.orientation = 0;
			}

			MoveSpeed var5 = var0.pathTraversed[var0.pathLength - 1];
			if (var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
				int var6 = var0.orientation - var0.rotation & 2047;
				if (var6 > 1024) {
					var6 -= 2048;
				}

				int var7 = var0.walkBackSequence;
				if (var6 >= -256 && var6 <= 256) {
					var7 = var0.walkSequence;
				} else if (var6 >= 256 && var6 < 768) {
					var7 = var0.walkRightSequence;
				} else if (var6 >= -768 && var6 <= -256) {
					var7 = var0.walkLeftSequence;
				}

				if (var7 == -1) {
					var7 = var0.walkSequence;
				}

				var0.movementSequence = var7;
				int var8 = 4;
				boolean var9 = true;
				if (var0 instanceof NPC) {
					var9 = ((NPC)var0).definition.isClickable;
				}

				if (var9) {
					if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field1018 != 0) {
						var8 = 2;
					}

					if (var0.pathLength > 2) {
						var8 = 6;
					}

					if (var0.pathLength > 3) {
						var8 = 8;
					}

					if (var0.field1028 > 0 && var0.pathLength > 1) {
						var8 = 8;
						--var0.field1028;
					}
				} else {
					if (var0.pathLength > 1) {
						var8 = 6;
					}

					if (var0.pathLength > 2) {
						var8 = 8;
					}

					if (var0.field1028 > 0 && var0.pathLength > 1) {
						var8 = 8;
						--var0.field1028;
					}
				}

				if (var5 == MoveSpeed.RUN) {
					var8 <<= 1;
				} else if (var5 == MoveSpeed.CRAWL) {
					var8 >>= 1;
				}

				if (var8 >= 8) {
					if (var0.walkSequence == var0.movementSequence && var0.runSequence != -1) {
						var0.movementSequence = var0.runSequence;
					} else if (var0.movementSequence == var0.walkBackSequence && var0.runBackSequence != -1) {
						var0.movementSequence = var0.runBackSequence;
					} else if (var0.movementSequence == var0.walkLeftSequence && var0.runLeftSequence != -1) {
						var0.movementSequence = var0.runLeftSequence;
					} else if (var0.walkRightSequence == var0.movementSequence && var0.runRightSequence != -1) {
						var0.movementSequence = var0.runRightSequence;
					}
				} else if (var8 <= 2) {
					if (var0.walkSequence == var0.movementSequence && var0.crawlSequence != -1) {
						var0.movementSequence = var0.crawlSequence;
					} else if (var0.walkBackSequence == var0.movementSequence && var0.crawlBackSequence != -1) {
						var0.movementSequence = var0.crawlBackSequence;
					} else if (var0.walkLeftSequence == var0.movementSequence && var0.crawlLeftSequence != -1) {
						var0.movementSequence = var0.crawlLeftSequence;
					} else if (var0.walkRightSequence == var0.movementSequence && var0.crawlRightSequence != -1) {
						var0.movementSequence = var0.crawlRightSequence;
					}
				}

				if (var3 != var10 || var4 != var2) {
					if (var10 < var3) {
						var0.x += var8;
						if (var0.x > var3) {
							var0.x = var3;
						}
					} else if (var10 > var3) {
						var0.x -= var8;
						if (var0.x < var3) {
							var0.x = var3;
						}
					}

					if (var2 < var4) {
						var0.y += var8;
						if (var0.y > var4) {
							var0.y = var4;
						}
					} else if (var2 > var4) {
						var0.y -= var8;
						if (var0.y < var4) {
							var0.y = var4;
						}
					}
				}

				if (var3 == var0.x && var4 == var0.y) {
					--var0.pathLength;
					if (var0.field1029 > 0) {
						--var0.field1029;
					}
				}

			} else {
				var0.x = var3;
				var0.y = var4;
				--var0.pathLength;
				if (var0.field1029 > 0) {
					--var0.field1029;
				}

			}
		}
	}
}