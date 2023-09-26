import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mw")
public class class317 {
	@ObfuscatedName("wo")
	@Export("foundItemIndex")
	static int foundItemIndex;
	@ObfuscatedName("ac")
	static int[] field2775;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	@Export("ItemDefinition_archive")
	static AbstractArchive ItemDefinition_archive;
	@ObfuscatedName("fx")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	static Archive field2776;

	static {
		new Object();
		field2775 = new int[33];
		field2775[0] = 0;
		int var0 = 2;

		for (int var1 = 1; var1 < 33; ++var1) {
			field2775[var1] = var0 - 1;
			var0 += var0;
		}

	}
}