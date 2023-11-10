import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oi")
public enum class364 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Loi;"
	)
	field3511(-1),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Loi;"
	)
	field3508(0),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Loi;"
	)
	field3510(1),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Loi;"
	)
	field3509(2);

	@ObfuscatedName("ab")
	final int field3512;

	class364(int var3) {
		this.field3512 = var3;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3512;
	}
}