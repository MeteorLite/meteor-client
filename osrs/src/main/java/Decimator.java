import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

@ObfuscatedName("cx")
@Implements("Decimator")
public class Decimator {
	@ObfuscatedName("wm")
	static Iterator field296;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("Widget_archive")
	public static AbstractArchive Widget_archive;
	@ObfuscatedName("at")
	@Export("inputRate")
	int inputRate;
	@ObfuscatedName("ac")
	@Export("outputRate")
	int outputRate;
	@ObfuscatedName("ai")
	@Export("table")
	int[][] table;

	public Decimator(int var1, int var2) {
		if (var2 != var1) {
			int var4 = var1;
			int var5 = var2;
			if (var2 > var1) {
				var4 = var2;
				var5 = var1;
			}

			while (var5 != 0) {
				int var6 = var4 % var5;
				var4 = var5;
				var5 = var6;
			}

			var1 /= var4;
			var2 /= var4;
			this.inputRate = var1;
			this.outputRate = var2;
			this.table = new int[var1][14];

			for (int var7 = 0; var7 < var1; ++var7) {
				int[] var8 = this.table[var7];
				double var9 = 6.0D + (double)var7 / (double)var1;
				int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
				if (var11 < 0) {
					var11 = 0;
				}

				int var12 = (int)Math.ceil(var9 + 7.0D);
				if (var12 > 14) {
					var12 = 14;
				}

				for (double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
					double var15 = ((double)var11 - var9) * 3.141592653589793D;
					double var17 = var13;
					if (var15 < -1.0E-4D || var15 > 1.0E-4D) {
						var17 = var13 * (Math.sin(var15) / var15);
					}

					var17 *= 0.54D + 0.46D * Math.cos(0.2243994752564138D * ((double)var11 - var9));
					var8[var11] = (int)Math.floor(0.5D + var17 * 65536.0D);
				}
			}

		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "([BS)[B",
		garbageValue = "31853"
	)
	@Export("resample")
	byte[] resample(byte[] var1) {
		if (this.table != null) {
			int var2 = (int)((long)this.outputRate * (long)var1.length / (long)this.inputRate) + 14;
			int[] var3 = new int[var2];
			int var4 = 0;
			int var5 = 0;

			int var6;
			for (var6 = 0; var6 < var1.length; ++var6) {
				byte var7 = var1[var6];
				int[] var8 = this.table[var5];

				int var9;
				for (var9 = 0; var9 < 14; ++var9) {
					var3[var9 + var4] += var7 * var8[var9];
				}

				var5 += this.outputRate;
				var9 = var5 / this.inputRate;
				var4 += var9;
				var5 -= var9 * this.inputRate;
			}

			var1 = new byte[var2];

			for (var6 = 0; var6 < var2; ++var6) {
				int var10 = var3[var6] + 32768 >> 16;
				if (var10 < -128) {
					var1[var6] = -128;
				} else if (var10 > 127) {
					var1[var6] = 127;
				} else {
					var1[var6] = (byte)var10;
				}
			}
		}

		return var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "1"
	)
	@Export("scaleRate")
	int scaleRate(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate);
		}

		return var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "429071526"
	)
	@Export("scalePosition")
	int scalePosition(int var1) {
		if (this.table != null) {
			var1 = (int)((long)var1 * (long)this.outputRate / (long)this.inputRate) + 6;
		}

		return var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;Lsf;I)Lsf;",
		garbageValue = "-738926216"
	)
	@Export("readStringIntParameters")
	static final IterableNodeHashTable readStringIntParameters(Buffer var0, IterableNodeHashTable var1) {
		int var2 = var0.readUnsignedByte();
		int var3;
		if (var1 == null) {
			var3 = WorldMapIcon_1.method1401(var2);
			var1 = new IterableNodeHashTable(var3);
		}

		for (var3 = 0; var3 < var2; ++var3) {
			boolean var4 = var0.readUnsignedByte() == 1;
			int var5 = var0.readMedium();
			Object var6;
			if (var4) {
				var6 = new ObjectNode(var0.readStringCp1252NullTerminated());
			} else {
				var6 = new IntegerNode(var0.readInt());
			}

			var1.put((Node)var6, (long)var5);
		}

		return var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;ZI)Ltu;",
		garbageValue = "1734618555"
	)
	@Export("getPreferencesFile")
	public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
		File var3 = new File(JagexCache.cacheDir, "preferences" + var0 + ".dat");
		if (var3.exists()) {
			try {
				AccessFile var10 = new AccessFile(var3, "rw", 10000L);
				return var10;
			} catch (IOException var9) {
			}
		}

		String var4 = "";
		if (JagexCache.cacheGamebuild == 33) {
			var4 = "_rc";
		} else if (JagexCache.cacheGamebuild == 34) {
			var4 = "_wip";
		}

		File var5 = new File(class36.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
		AccessFile var6;
		if (!var2 && var5.exists()) {
			try {
				var6 = new AccessFile(var5, "rw", 10000L);
				return var6;
			} catch (IOException var8) {
			}
		}

		try {
			var6 = new AccessFile(var3, "rw", 10000L);
			return var6;
		} catch (IOException var7) {
			throw new RuntimeException();
		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "88"
	)
	static final boolean method312() {
		return ViewportMouse.ViewportMouse_isInViewport;
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Lnu;IB)Z",
		garbageValue = "0"
	)
	public static boolean method313(AbstractArchive var0, int var1) {
		byte[] var2 = var0.takeFileFlat(var1);
		if (var2 == null) {
			return false;
		} else {
			class137.SpriteBuffer_decode(var2);
			return true;
		}
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZB)I",
		garbageValue = "-94"
	)
	static int method315(int var0, Script var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == 4100) {
			var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == 4101) {
				class137.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == 4102) {
				var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3 + class60.intToString(var4, true);
				return 1;
			} else if (var0 == 4103) {
				var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == 4104) {
					var10 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
					long var11 = 86400000L * ((long)var10 + 11745L);
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var17 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var17] + "-" + var8;
					return 1;
				} else if (var0 != 4105) {
					if (var0 == 4106) {
						var10 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == 4107) {
						class137.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = ItemComposition.method1054(StudioGame.compareStrings(Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 1], ClanChannelMember.clientLanguage));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == 4108) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							SoundCache.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
							var13 = Player.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
							return 1;
						} else if (var0 == 4109) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							SoundCache.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
							var13 = Player.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
							return 1;
						} else if (var0 == 4110) {
							class137.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == 4111) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == 4112) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == 4113) {
							var10 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.isCharPrintable((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4114) {
							var10 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = WorldMapLabel.isAlphaNumeric((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4115) {
							var10 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class200.isCharAlphabetic((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4116) {
							var10 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class330.isDigit((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4117) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == 4118) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							SoundCache.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == 4119) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							StringBuilder var18 = new StringBuilder(var3.length());
							boolean var16 = false;

							for (var6 = 0; var6 < var3.length(); ++var6) {
								char var7 = var3.charAt(var6);
								if (var7 == '<') {
									var16 = true;
								} else if (var7 == '>') {
									var16 = false;
								} else if (!var16) {
									var18.append(var7);
								}
							}

							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var18.toString();
							return 1;
						} else if (var0 == 4120) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == 4121) {
							class137.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == 4122) {
							var3 = Interpreter.Interpreter_stringStack[--class137.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else if (var0 == 4123) {
							class137.Interpreter_stringStackSize -= 3;
							var3 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 1];
							String var15 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 2];
							if (VarbitComposition.localPlayer.appearance == null) {
								Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var15;
								return 1;
							} else {
								switch(VarbitComposition.localPlayer.appearance.field2918) {
								case 0:
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3;
									break;
								case 1:
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9;
									break;
								case 2:
								default:
									Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var15;
								}

								return 1;
							}
						} else {
							return 2;
						}
					}
				} else {
					class137.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[class137.Interpreter_stringStackSize + 1];
					if (VarbitComposition.localPlayer.appearance != null && VarbitComposition.localPlayer.appearance.field2916 != 0) {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}
}