import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("uk")
public enum FillMode implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	@Export("SOLID")
	SOLID(0, 0),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	field4258(1, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Luk;"
	)
	field4259(2, 2);

	@ObfuscatedName("ao")
	public final int field4261;
	@ObfuscatedName("ab")
	final int field4260;

	FillMode(int var3, int var4) {
		this.field4261 = var3;
		this.field4260 = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field4260;
	}
}