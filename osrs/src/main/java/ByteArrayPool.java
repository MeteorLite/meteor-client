import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.HashMap;

@ObfuscatedName("qo")
@Implements("ByteArrayPool")
public class ByteArrayPool {
	@ObfuscatedName("ao")
	@Export("ByteArrayPool_smallCount")
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("ah")
	@Export("ByteArrayPool_mediumCount")
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("ar")
	@Export("ByteArrayPool_largeCount")
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("ab")
	static int field3772;
	@ObfuscatedName("am")
	static int field3775;
	@ObfuscatedName("av")
	static int field3778;
	@ObfuscatedName("ag")
	static int field3773;
	@ObfuscatedName("aa")
	static int field3771;
	@ObfuscatedName("ap")
	@Export("ByteArrayPool_small")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("ay")
	@Export("ByteArrayPool_medium")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("as")
	@Export("ByteArrayPool_large")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("aj")
	static byte[][] field3767;
	@ObfuscatedName("an")
	@Export("ByteArrayPool_alternativeSizes")
	public static int[] ByteArrayPool_alternativeSizes;
	@ObfuscatedName("ae")
	public static ArrayList field3766;

	static {
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		field3772 = 0;
		field3775 = 1000;
		field3778 = 250;
		field3773 = 100;
		field3771 = 50;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[100][];
		field3767 = new byte[50][];
		field3766 = new ArrayList();
		field3766.clear();
		field3766.add(100);
		field3766.add(5000);
		field3766.add(10000);
		field3766.add(30000);
		new HashMap();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IZI)[B",
		garbageValue = "664601398"
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
		} else if ((var0 == 30000 || var0 < 30000 && var1) && field3772 > 0) {
			var2 = field3767[--field3772];
			field3767[field3772] = null;
			return var2;
		} else {
			int var4;
			if (class28.ByteArrayPool_arrays != null) {
				for (var4 = 0; var4 < ByteArrayPool_alternativeSizes.length; ++var4) {
					if ((ByteArrayPool_alternativeSizes[var4] == var0 || var0 < ByteArrayPool_alternativeSizes[var4] && var1) && class425.ByteArrayPool_altSizeArrayCounts[var4] > 0) {
						byte[] var3 = class28.ByteArrayPool_arrays[var4][--class425.ByteArrayPool_altSizeArrayCounts[var4]];
						class28.ByteArrayPool_arrays[var4][class425.ByteArrayPool_altSizeArrayCounts[var4]] = null;
						return var3;
					}
				}
			}

			if (var1 && ByteArrayPool_alternativeSizes != null) {
				for (var4 = 0; var4 < ByteArrayPool_alternativeSizes.length; ++var4) {
					if (var0 <= ByteArrayPool_alternativeSizes[var4] && class425.ByteArrayPool_altSizeArrayCounts[var4] < class28.ByteArrayPool_arrays[var4].length) {
						return new byte[ByteArrayPool_alternativeSizes[var4]];
					}
				}
			}

			return new byte[var0];
		}
	}
}