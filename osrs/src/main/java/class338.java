import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@ObfuscatedName("nq")
public class class338 {
	@ObfuscatedName("ao")
	static int field3112;

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2066901929"
	)
	@Export("savePreferences")
	static void savePreferences() {
		AccessFile var0 = null;

		try {
			var0 = Decimator.getPreferencesFile("", WorldMapSectionType.field2417.name, true);
			Buffer var1 = class449.clientPreferences.toBuffer();
			var0.write(var1.array, 0, var1.offset);
		} catch (Exception var3) {
		}

		try {
			if (var0 != null) {
				var0.closeSync(true);
			}
		} catch (Exception var2) {
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(II)Lfv;",
		garbageValue = "1964561165"
	)
	static class137 method1862(int var0) {
		class137 var1 = (class137)SequenceDefinition.SequenceDefinition_cachedModel.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			AbstractArchive var3 = VarpDefinition.SequenceDefinition_animationsArchive;
			AbstractArchive var4 = class485.SequenceDefinition_skeletonsArchive;
			boolean var5 = true;
			byte[] var6 = var3.getFile(var0 >> 16 & 65535, var0 & 65535);
			class137 var2;
			if (var6 == null) {
				var5 = false;
				var2 = null;
			} else {
				int var7 = (var6[1] & 255) << 8 | var6[2] & 255;
				byte[] var8 = var4.getFile(var7, 0);
				if (var8 == null) {
					var5 = false;
				}

				if (!var5) {
					var2 = null;
				} else {
					if (class137.field1296 == null) {
						class291.field2496 = Runtime.getRuntime().availableProcessors();
						class137.field1296 = new ThreadPoolExecutor(0, class291.field2496, 0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue(class291.field2496 * 100 + 100), new class184());
					}

					try {
						var2 = new class137(var3, var4, var0, false);
					} catch (Exception var10) {
						var2 = null;
					}
				}
			}

			if (var2 != null) {
				SequenceDefinition.SequenceDefinition_cachedModel.put(var2, (long)var0);
			}

			return var2;
		}
	}
}