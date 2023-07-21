import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nb")
public enum class340 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	field3101(0),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	field3102(1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	field3099(2),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	field3098(3),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	field3100(4);

	@ObfuscatedName("aj")
	final int field3103;

	class340(int var3) {
		this.field3103 = var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3103;
	}
}
