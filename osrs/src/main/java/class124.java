import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public enum class124 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Leb;"
	)
	field1208(3, 0),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Leb;"
	)
	field1205(0, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Leb;"
	)
	field1207(2, 2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Leb;"
	)
	field1206(1, 3),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Leb;"
	)
	field1204(4, 4);

	@ObfuscatedName("au")
	public final int field1210;
	@ObfuscatedName("aa")
	@Export("id")
	final int id;

	class124(int var3, int var4) {
		this.field1210 = var3;
		this.id = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}