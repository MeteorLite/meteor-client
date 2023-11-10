import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
public enum class140 implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1326(0, 0),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1322(1, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1325(2, 2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1324(3, 3),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1320(4, 4),
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1327(5, 5),
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1319(6, 6),
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1321(7, 7),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lfw;"
	)
	field1323(8, 8);

	@ObfuscatedName("jp")
	@ObfuscatedSignature(
		descriptor = "Ltk;"
	)
	static Fonts field1318;
	@ObfuscatedName("az")
	final int field1329;
	@ObfuscatedName("ap")
	final int field1328;

	class140(int var3, int var4) {
		this.field1329 = var3;
		this.field1328 = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1328;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)Lgk;",
		garbageValue = "1249641264"
	)
	public static VarcInt method750(int var0) {
		VarcInt var1 = (VarcInt)VarcInt.VarcInt_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class30.VarcInt_archive.takeFile(19, var0);
			var1 = new VarcInt();
			if (var2 != null) {
				var1.method901(new Buffer(var2));
			}

			VarcInt.VarcInt_cached.put(var1, (long)var0);
			return var1;
		}
	}
}