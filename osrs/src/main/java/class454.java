import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rr")
public enum class454 implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lrr;"
	)
	field3879(3, 1),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lrr;"
	)
	field3880(0, 2),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lrr;"
	)
	field3878(1, 3),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lrr;"
	)
	field3877(2, 10);

	@ObfuscatedName("as")
	final int field3882;
	@ObfuscatedName("aj")
	final int field3881;

	class454(int var3, int var4) {
		this.field3882 = var3;
		this.field3881 = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3881;
	}
}
