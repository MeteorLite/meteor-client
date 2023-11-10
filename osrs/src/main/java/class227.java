import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
public class class227 {
	@ObfuscatedName("at")
	final int[][] field1928;
	@ObfuscatedName("ah")
	final int[][] field1927;
	@ObfuscatedName("ar")
	int field1923;
	@ObfuscatedName("ao")
	int field1922;
	@ObfuscatedName("ab")
	final int[] field1925;
	@ObfuscatedName("au")
	final int[] field1926;
	@ObfuscatedName("aa")
	final int field1924;

	class227(int var1, int var2) {
		this.field1928 = new int[var1][var2];
		this.field1927 = new int[var1][var2];
		int var3 = var2 * var1;
		int var4 = class184.method927(var3 / 4);
		this.field1925 = new int[var4];
		this.field1926 = new int[var4];
		this.field1924 = var4 - 1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1222193481"
	)
	void method1153() {
		for (int var1 = 0; var1 < this.field1928.length; ++var1) {
			for (int var2 = 0; var2 < this.field1928[var1].length; ++var2) {
				this.field1928[var1][var2] = 0;
				this.field1927[var1][var2] = 99999999;
			}
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "19"
	)
	void method1154(int var1, int var2) {
		this.field1923 = var1;
		this.field1922 = var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "40323441"
	)
	int method1155() {
		return this.field1923;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1750478119"
	)
	int method1156() {
		return this.field1922;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1487241351"
	)
	int method1157() {
		return this.field1928.length;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-63"
	)
	int method1158() {
		return this.field1928[0].length;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)[[I",
		garbageValue = "-32547244"
	)
	int[][] method1159() {
		return this.field1928;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)[[I",
		garbageValue = "2082106732"
	)
	int[][] method1160() {
		return this.field1927;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "-33"
	)
	int[] method1161() {
		return this.field1925;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "1805149245"
	)
	int[] method1162() {
		return this.field1926;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "3128"
	)
	int method1163() {
		return this.field1924;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "516019890"
	)
	public static void method1164() {
		synchronized(ArchiveDiskActionHandler.field3543) {
			if (ArchiveDiskActionHandler.field3542 != 0) {
				ArchiveDiskActionHandler.field3542 = 1;
				ArchiveDiskActionHandler.field3541 = true;

				try {
					ArchiveDiskActionHandler.field3543.wait();
				} catch (InterruptedException var3) {
				}
			}

		}
	}

	@ObfuscatedName("nm")
	@ObfuscatedSignature(
		descriptor = "(Lnn;I)Lnn;",
		garbageValue = "16221133"
	)
	static Widget method1165(Widget var0) {
		int var2 = class361.getWidgetFlags(var0);
		int var1 = var2 >> 17 & 7;
		int var3 = var1;
		if (var1 == 0) {
			return null;
		} else {
			for (int var4 = 0; var4 < var3; ++var4) {
				var0 = HealthBarDefinition.widgetDefinition.method1733(var0.parentId);
				if (var0 == null) {
					return null;
				}
			}

			return var0;
		}
	}
}