import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nu")
public enum class351 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	field3148(0),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	field3146(1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	field3147(2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	field3144(3),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	field3145(4);

	@ObfuscatedName("au")
	final int field3149;

	class351(int var3) {
		this.field3149 = var3;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3149;
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(Lhs;B)Z",
		garbageValue = "113"
	)
	static boolean method1892(ObjectComposition var0) {
		if (var0.transforms != null) {
			int[] var1 = var0.transforms;

			for (int var2 = 0; var2 < var1.length; ++var2) {
				int var3 = var1[var2];
				ObjectComposition var4 = WorldMapSection2.getObjectDefinition(var3);
				if (var4.mapIconId != -1) {
					return true;
				}
			}
		} else if (var0.mapIconId != -1) {
			return true;
		}

		return false;
	}
}