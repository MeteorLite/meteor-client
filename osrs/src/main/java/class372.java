import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashMap;

@ObfuscatedName("ok")
public class class372 {
	@ObfuscatedName("wr")
	@Export("foundItemIndex")
	static int foundItemIndex;

	static {
		new HashMap();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "1337034941"
	)
	static final void method1970(int var0, int var1, int var2) {
		int var3;
		for (var3 = 0; var3 < 8; ++var3) {
			for (int var4 = 0; var4 < 8; ++var4) {
				Tiles.Tiles_heights[var0][var3 + var1][var4 + var2] = 0;
			}
		}

		if (var1 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var1][var3 + var2] = Tiles.Tiles_heights[var0][var1 - 1][var3 + var2];
			}
		}

		if (var2 > 0) {
			for (var3 = 1; var3 < 8; ++var3) {
				Tiles.Tiles_heights[var0][var3 + var1][var2] = Tiles.Tiles_heights[var0][var3 + var1][var2 - 1];
			}
		}

		if (var1 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2];
		} else if (var2 > 0 && Tiles.Tiles_heights[var0][var1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1][var2 - 1];
		} else if (var1 > 0 && var2 > 0 && Tiles.Tiles_heights[var0][var1 - 1][var2 - 1] != 0) {
			Tiles.Tiles_heights[var0][var1][var2] = Tiles.Tiles_heights[var0][var1 - 1][var2 - 1];
		}

	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZB)I",
		garbageValue = "-1"
	)
	static int method1971(int var0, Script var1, boolean var2) {
		if (var0 == 3300) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.cycle;
			return 1;
		} else {
			int var3;
			int var4;
			if (var0 == 3301) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class209.method1087(var3, var4);
				return 1;
			} else if (var0 == 3302) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = DynamicObject.ItemContainer_getCount(var3, var4);
				return 1;
			} else if (var0 == 3303) {
				SoundCache.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class212.method1099(var3, var4);
				return 1;
			} else if (var0 == 3304) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = AbstractArchive.getInvDefinition(var3).size;
				return 1;
			} else if (var0 == 3305) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
				return 1;
			} else if (var0 == 3306) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.levels[var3];
				return 1;
			} else if (var0 == 3307) {
				var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.experience[var3];
				return 1;
			} else {
				int var5;
				if (var0 == 3308) {
					var3 = HealthBar.Client_plane;
					var4 = (VarbitComposition.localPlayer.x >> 7) + UrlRequester.baseX;
					var5 = (VarbitComposition.localPlayer.y >> 7) + class47.baseY;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
					return 1;
				} else if (var0 == 3309) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
					return 1;
				} else if (var0 == 3310) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 >> 28;
					return 1;
				} else if (var0 == 3311) {
					var3 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3 & 16383;
					return 1;
				} else if (var0 == 3312) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
					return 1;
				} else if (var0 == 3313) {
					SoundCache.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class209.method1087(var3, var4);
					return 1;
				} else if (var0 == 3314) {
					SoundCache.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = DynamicObject.ItemContainer_getCount(var3, var4);
					return 1;
				} else if (var0 == 3315) {
					SoundCache.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class212.method1099(var3, var4);
					return 1;
				} else if (var0 == 3316) {
					if (Client.staffModLevel >= 2) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.staffModLevel;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3317) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.rebootTimer;
					return 1;
				} else if (var0 == 3318) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.worldId;
					return 1;
				} else if (var0 == 3321) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.runEnergy / 100;
					return 1;
				} else if (var0 == 3322) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.weight;
					return 1;
				} else if (var0 == 3323) {
					if (Client.playerMod) {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3324) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.worldProperties;
					return 1;
				} else if (var0 == 3325) {
					SoundCache.Interpreter_intStackSize -= 4;
					var3 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 2];
					int var6 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 3];
					var3 += var4 << 14;
					var3 += var5 << 28;
					var3 += var6;
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3;
					return 1;
				} else if (var0 == 3326) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.lastMouseRecordX;
					return 1;
				} else if (var0 == 3327) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.lastMouseRecordY;
					return 1;
				} else if (var0 == 3331) {
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Client.runEnergy;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}
}