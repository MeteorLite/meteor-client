import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
public class class216 {
	@ObfuscatedName("au")
	final int[][] field1919;
	@ObfuscatedName("ae")
	final int[][] field1918;
	@ObfuscatedName("ao")
	int field1913;
	@ObfuscatedName("at")
	int field1914;
	@ObfuscatedName("ac")
	final int[] field1916;
	@ObfuscatedName("ai")
	final int[] field1917;
	@ObfuscatedName("az")
	final int field1915;

	public class216(int var1, int var2) {
		this.field1919 = new int[var1][var2];
		this.field1918 = new int[var1][var2];
		int var3 = var2 * var1;
		int var4 = WorldMapIcon_1.method1401(var3 / 4);
		this.field1916 = new int[var4];
		this.field1917 = new int[var4];
		this.field1915 = var4 - 1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "87"
	)
	void method1128() {
		for (int var1 = 0; var1 < this.field1919.length; ++var1) {
			for (int var2 = 0; var2 < this.field1919[var1].length; ++var2) {
				this.field1919[var1][var2] = 0;
				this.field1918[var1][var2] = 99999999;
			}
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "335221263"
	)
	void method1129(int var1, int var2) {
		this.field1913 = var1;
		this.field1914 = var2;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "14"
	)
	int method1130() {
		return this.field1913;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "0"
	)
	int method1131() {
		return this.field1914;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1220057291"
	)
	int method1132() {
		return this.field1919.length;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "63"
	)
	int method1133() {
		return this.field1919[0].length;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)[[I",
		garbageValue = "1666372984"
	)
	int[][] method1134() {
		return this.field1919;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)[[I",
		garbageValue = "-1771437641"
	)
	int[][] method1135() {
		return this.field1918;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-1724623959"
	)
	int[] method1136() {
		return this.field1916;
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-968317767"
	)
	int[] method1137() {
		return this.field1917;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	int method1138() {
		return this.field1915;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ltm;Ljava/lang/String;I)I",
		garbageValue = "-1998833421"
	)
	public static int method1127(Buffer var0, String var1) {
		int var2 = var0.offset;
		byte[] var3 = TextureProvider.method1301(var1);
		var0.writeSmartByteShort(var3.length);
		var0.offset += class334.huffman.compress(var3, 0, var3.length, var0.array, var0.offset);
		return var0.offset - var2;
	}
}