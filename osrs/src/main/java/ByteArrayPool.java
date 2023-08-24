import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@ObfuscatedName("pb")
@Implements("ByteArrayPool")
public class ByteArrayPool {
	@ObfuscatedName("ac")
	@Export("ByteArrayPool_smallCount")
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("ai")
	@Export("ByteArrayPool_mediumCount")
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("az")
	@Export("ByteArrayPool_largeCount")
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("ap")
	static int field3743;
	@ObfuscatedName("aa")
	static int field3738;
	@ObfuscatedName("af")
	static int field3741;
	@ObfuscatedName("ad")
	static int field3740;
	@ObfuscatedName("aq")
	static int field3744;
	@ObfuscatedName("al")
	@Export("ByteArrayPool_small")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("an")
	@Export("ByteArrayPool_medium")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("ar")
	@Export("ByteArrayPool_large")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("ab")
	static byte[][] field3734;
	@ObfuscatedName("ah")
	static ArrayList field3746;

	static {
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		field3743 = 0;
		field3738 = 1000;
		field3741 = 250;
		field3740 = 100;
		field3744 = 50;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[100][];
		field3734 = new byte[50][];
		field3746 = new ArrayList();
		class101.method599();
		new HashMap();
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IZI)[B",
		garbageValue = "1767173651"
	)
	@Export("ByteArrayPool_getArrayBool")
	public static synchronized byte[] ByteArrayPool_getArrayBool(int var0, boolean var1) {
		byte[] var2;
		if ((var0 == 100 || var0 < 100 && var1) && ByteArrayPool_smallCount > 0) {
			var2 = ByteArrayPool_small[--ByteArrayPool_smallCount];
			ByteArrayPool_small[ByteArrayPool_smallCount] = null;
			return var2;
		} else if ((var0 == 5000 || var0 < 5000 && var1) && ByteArrayPool_mediumCount > 0) {
			var2 = ByteArrayPool_medium[--ByteArrayPool_mediumCount];
			ByteArrayPool_medium[ByteArrayPool_mediumCount] = null;
			return var2;
		} else if ((var0 == 10000 || var0 < 10000 && var1) && ByteArrayPool_largeCount > 0) {
			var2 = ByteArrayPool_large[--ByteArrayPool_largeCount];
			ByteArrayPool_large[ByteArrayPool_largeCount] = null;
			return var2;
		} else if ((var0 == 30000 || var0 < 30000 && var1) && field3743 > 0) {
			var2 = field3734[--field3743];
			field3734[field3743] = null;
			return var2;
		} else {
			int var4;
			if (class410.ByteArrayPool_arrays != null) {
				for (var4 = 0; var4 < class416.ByteArrayPool_alternativeSizes.length; ++var4) {
					if ((class416.ByteArrayPool_alternativeSizes[var4] == var0 || var0 < class416.ByteArrayPool_alternativeSizes[var4] && var1) && StructComposition.ByteArrayPool_altSizeArrayCounts[var4] > 0) {
						byte[] var3 = class410.ByteArrayPool_arrays[var4][--StructComposition.ByteArrayPool_altSizeArrayCounts[var4]];
						class410.ByteArrayPool_arrays[var4][StructComposition.ByteArrayPool_altSizeArrayCounts[var4]] = null;
						return var3;
					}
				}
			}

			if (var1 && class416.ByteArrayPool_alternativeSizes != null) {
				for (var4 = 0; var4 < class416.ByteArrayPool_alternativeSizes.length; ++var4) {
					if (var0 <= class416.ByteArrayPool_alternativeSizes[var4] && StructComposition.ByteArrayPool_altSizeArrayCounts[var4] < class410.ByteArrayPool_arrays[var4].length) {
						return new byte[class416.ByteArrayPool_alternativeSizes[var4]];
					}
				}
			}

			return new byte[var0];
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-8"
	)
	static void method2148() {
		Iterator var0 = class305.musicSongs.iterator();

		while (true) {
			MusicSong var1;
			do {
				if (!var0.hasNext()) {
					class305.musicSongs.clear();
					return;
				}

				var1 = (MusicSong)var0.next();
			} while(var1 == null);

			var1.midiPcmStream.clear();
			var1.midiPcmStream.method1633();
			var1.midiPcmStream.setPcmStreamVolume(0);
			var1.midiPcmStream.field2809 = 0;
			int var2 = var1.musicTrackGroupId;
			int var3 = var1.musicTrackFileId;
			Iterator var4 = class305.field2778.iterator();

			while (var4.hasNext()) {
				class311 var5 = (class311)var4.next();
				var5.vmethod1644(var2, var3);
			}
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-2055623953"
	)
	static int method2149(int var0, Script var1, boolean var2) {
		Widget var3 = class92.getWidget(Interpreter.Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
		if (var0 == 2600) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.scrollX;
			return 1;
		} else if (var0 == 2601) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.scrollY;
			return 1;
		} else if (var0 == 2602) {
			Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var3.text;
			return 1;
		} else if (var0 == 2603) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.scrollWidth;
			return 1;
		} else if (var0 == 2604) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.scrollHeight;
			return 1;
		} else if (var0 == 2605) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelZoom;
			return 1;
		} else if (var0 == 2606) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelAngleX;
			return 1;
		} else if (var0 == 2607) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelAngleZ;
			return 1;
		} else if (var0 == 2608) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelAngleY;
			return 1;
		} else if (var0 == 2609) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.transparencyTop;
			return 1;
		} else if (var0 == 2610) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.transparencyBot;
			return 1;
		} else if (var0 == 2611) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.color;
			return 1;
		} else if (var0 == 2612) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.color2;
			return 1;
		} else if (var0 == 2613) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.fillMode.rsOrdinal();
			return 1;
		} else if (var0 == 2614) {
			Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var3.modelTransparency ? 1 : 0;
			return 1;
		} else {
			class324 var4;
			if (var0 == 2617) {
				var4 = var3.method1845();
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4 != null ? var4.field2892 * -1007608077 * 1891510843 : 0;
			}

			if (var0 == 2618) {
				var4 = var3.method1845();
				Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4 != null ? var4.field2890 * -113152143 * 439316881 : 0;
				return 1;
			} else {
				class329 var7;
				if (var0 == 2619) {
					var7 = var3.method1844();
					Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1780().method2041() : "";
					return 1;
				} else if (var0 == 2620) {
					var4 = var3.method1845();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var4 != null ? var4.field2891 * 1092445257 * -767308295 : 0;
					return 1;
				} else if (var0 == 2621) {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1790() : 0;
					return 1;
				} else if (var0 == 2622) {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1791() : 0;
					return 1;
				} else if (var0 == 2623) {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1792() : 0;
					return 1;
				} else if (var0 == 2624) {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null && var7.method1782() ? 1 : 0;
					return 1;
				} else if (var0 != 2625) {
					if (var0 == 2626) {
						var7 = var3.method1844();
						Interpreter.Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var7 != null ? var7.method1781().method2113() : "";
						return 1;
					} else if (var0 == 2627) {
						var7 = var3.method1844();
						int var5 = var7 != null ? var7.method1786() : 0;
						int var6 = var7 != null ? var7.method1785() : 0;
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Math.min(var5, var6);
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = Math.max(var5, var6);
						return 1;
					} else if (var0 == 2628) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1785() : 0;
						return 1;
					} else if (var0 == 2629) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1794() : 0;
						return 1;
					} else if (var0 == 2630) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1793() : 0;
						return 1;
					} else if (var0 == 2631) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1795() : 0;
						return 1;
					} else if (var0 == 2632) {
						var7 = var3.method1844();
						Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null ? var7.method1796() : 0;
						return 1;
					} else {
						class27 var8;
						if (var0 == 2633) {
							var8 = var3.method1846();
							Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = var8 != null ? var8.method98(Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else if (var0 == 2634) {
							var8 = var3.method1846();
							Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1] = var8 != null ? var8.method99((char)Interpreter.Interpreter_intStack[SoundCache.Interpreter_intStackSize - 1]) : 0;
							return 1;
						} else {
							return 2;
						}
					}
				} else {
					var7 = var3.method1844();
					Interpreter.Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7 != null && var7.method1783() ? 1 : 0;
					return 1;
				}
			}
		}
	}
}