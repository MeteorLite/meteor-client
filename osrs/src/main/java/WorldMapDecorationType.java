import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nm")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3123(0, 0),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3127(1, 0),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3121(2, 0),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3122(3, 0),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3119(9, 2),
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3131(4, 1),
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3141(5, 1),
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3135(6, 1),
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3124(7, 1),
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3128(8, 1),
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3126(12, 2),
	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3136(13, 2),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3132(14, 2),
	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3134(15, 2),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3137(16, 2),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3125(17, 2),
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3129(18, 2),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3133(19, 2),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3139(20, 2),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3130(21, 2),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3138(10, 2),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3140(11, 2),
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lnm;"
	)
	field3120(22, 3);

	@ObfuscatedName("av")
	@Export("id")
	public final int id;

	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "0"
	)
	WorldMapDecorationType(int var3, int var4) {
		this.id = var3;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}
}