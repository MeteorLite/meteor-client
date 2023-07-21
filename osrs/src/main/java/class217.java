import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
public class class217 {
	@ObfuscatedName("aw")
	final int[][] field1897;
	@ObfuscatedName("ay")
	final int[][] field1898;
	@ObfuscatedName("ar")
	int field1893;
	@ObfuscatedName("am")
	int field1892;
	@ObfuscatedName("as")
	final int[] field1896;
	@ObfuscatedName("aj")
	final int[] field1895;
	@ObfuscatedName("ag")
	final int field1894;

	public class217(int var1, int var2) {
		this.field1897 = new int[var1][var2];
		this.field1898 = new int[var1][var2];
		int var3 = var2 * var1;
		int var4 = UrlRequest.method657(var3 / 4);
		this.field1896 = new int[var4];
		this.field1895 = new int[var4];
		this.field1894 = var4 - 1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-570470539"
	)
	void method1111() {
		for (int var1 = 0; var1 < this.field1897.length; ++var1) {
			for (int var2 = 0; var2 < this.field1897[var1].length; ++var2) {
				this.field1897[var1][var2] = 0;
				this.field1898[var1][var2] = 99999999;
			}
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "527120358"
	)
	void method1112(int var1, int var2) {
		this.field1893 = var1;
		this.field1892 = var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1077711185"
	)
	int method1113() {
		return this.field1893;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1117442087"
	)
	int method1114() {
		return this.field1892;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "793127968"
	)
	int method1115() {
		return this.field1897.length;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-58"
	)
	int method1116() {
		return this.field1897[0].length;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)[[I",
		garbageValue = "-1369726044"
	)
	int[][] method1117() {
		return this.field1897;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)[[I",
		garbageValue = "-1"
	)
	int[][] method1118() {
		return this.field1898;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-1326597582"
	)
	int[] method1119() {
		return this.field1896;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "-59"
	)
	int[] method1120() {
		return this.field1895;
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-8466104"
	)
	int method1121() {
		return this.field1894;
	}
}
