import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public enum class138 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1314(0, 0),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1309(1, 1),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1311(2, 2),
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1313(3, 3),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1308(4, 4),
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1310(5, 5),
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1315(6, 6),
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1312(7, 7),
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lfb;"
	)
	field1307(8, 8);

	@ObfuscatedName("ix")
	static int field1306;
	@ObfuscatedName("af")
	final int field1317;
	@ObfuscatedName("ad")
	final int field1316;

	class138(int var3, int var4) {
		this.field1317 = var3;
		this.field1316 = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1316;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)Lhd;",
		garbageValue = "-2092352148"
	)
	@Export("WorldMapElement_get")
	public static WorldMapElement WorldMapElement_get(int var0) {
		return var0 >= 0 && var0 < WorldMapElement.WorldMapElement_cached.length && WorldMapElement.WorldMapElement_cached[var0] != null ? WorldMapElement.WorldMapElement_cached[var0] : new WorldMapElement(var0);
	}
}