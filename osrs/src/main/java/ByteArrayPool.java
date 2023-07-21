import java.util.ArrayList;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pk")
@Implements("ByteArrayPool")
public class ByteArrayPool {
	@ObfuscatedName("as")
	@Export("ByteArrayPool_smallCount")
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("aj")
	@Export("ByteArrayPool_mediumCount")
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("ag")
	@Export("ByteArrayPool_largeCount")
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("az")
	static int field3736;
	@ObfuscatedName("av")
	static int field3735;
	@ObfuscatedName("ap")
	static int field3731;
	@ObfuscatedName("aq")
	static int field3732;
	@ObfuscatedName("at")
	static int field3734;
	@ObfuscatedName("ah")
	@Export("ByteArrayPool_small")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("ax")
	@Export("ByteArrayPool_medium")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("aa")
	@Export("ByteArrayPool_large")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("au")
	static byte[][] field3727;
	@ObfuscatedName("ae")
	@Export("ByteArrayPool_alternativeSizes")
	public static int[] ByteArrayPool_alternativeSizes;
	@ObfuscatedName("ab")
	static String[] field3737;
	@ObfuscatedName("ao")
	public static ArrayList field3724;

	static {
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		field3736 = 0;
		field3735 = 1000;
		field3731 = 250;
		field3732 = 100;
		field3734 = 50;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[100][];
		field3727 = new byte[50][];
		field3724 = new ArrayList();
		field3724.clear();
		field3724.add(100);
		field3724.add(5000);
		field3724.add(10000);
		field3724.add(30000);
		new HashMap();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IZI)[B",
		garbageValue = "-1680084006"
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
		} else if ((var0 == 30000 || var0 < 30000 && var1) && field3736 > 0) {
			var2 = field3727[--field3736];
			field3727[field3736] = null;
			return var2;
		} else {
			int var4;
			if (class152.ByteArrayPool_arrays != null) {
				for (var4 = 0; var4 < ByteArrayPool_alternativeSizes.length; ++var4) {
					if ((ByteArrayPool_alternativeSizes[var4] == var0 || var0 < ByteArrayPool_alternativeSizes[var4] && var1) && class125.ByteArrayPool_altSizeArrayCounts[var4] > 0) {
						byte[] var3 = class152.ByteArrayPool_arrays[var4][--class125.ByteArrayPool_altSizeArrayCounts[var4]];
						class152.ByteArrayPool_arrays[var4][class125.ByteArrayPool_altSizeArrayCounts[var4]] = null;
						return var3;
					}
				}
			}

			if (var1 && ByteArrayPool_alternativeSizes != null) {
				for (var4 = 0; var4 < ByteArrayPool_alternativeSizes.length; ++var4) {
					if (var0 <= ByteArrayPool_alternativeSizes[var4] && class125.ByteArrayPool_altSizeArrayCounts[var4] < class152.ByteArrayPool_arrays[var4].length) {
						return new byte[ByteArrayPool_alternativeSizes[var4]];
					}
				}
			}

			return new byte[var0];
		}
	}
}
