import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
public enum class89 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ldl;"
	)
	field884(0, -1),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Ldl;"
	)
	field881(1, 1),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ldl;"
	)
	field882(2, 7),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ldl;"
	)
	field883(3, 8),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ldl;"
	)
	field880(4, 9);

	@ObfuscatedName("ai")
	final int field885;
	@ObfuscatedName("az")
	final int field886;

	class89(int var3, int var4) {
		this.field885 = var3;
		this.field886 = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field886;
	}
}