import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ru")
public enum class465 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lru;"
	)
	field3926(1, 1),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lru;"
	)
	field3923(0, 2),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lru;"
	)
	field3925(3, 3),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lru;"
	)
	field3924(2, 10);

	@ObfuscatedName("ab")
	final int field3927;
	@ObfuscatedName("au")
	final int field3928;

	class465(int var3, int var4) {
		this.field3927 = var3;
		this.field3928 = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field3928;
	}
}