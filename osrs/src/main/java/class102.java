import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("db")
public class class102 {
	@ObfuscatedName("aw")
	int field1086;
	@ObfuscatedName("ay")
	int field1087;
	@ObfuscatedName("ar")
	int field1085;
	@ObfuscatedName("am")
	int field1084;

	class102(int var1, int var2, int var3, int var4) {
		this.field1086 = var1;
		this.field1087 = var2;
		this.field1085 = var3;
		this.field1084 = var4;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "96"
	)
	int method601() {
		return this.field1086;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1646176996"
	)
	int method602() {
		return this.field1087;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "257607839"
	)
	int method603() {
		return this.field1085;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1314819947"
	)
	int method604() {
		return this.field1084;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lmn;I)V",
		garbageValue = "2066839976"
	)
	public static void method605(class312 var0) {
		if (!class306.field2759.contains(var0)) {
			class306.field2759.add(var0);
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(CLot;B)C",
		garbageValue = "-1"
	)
	@Export("standardizeChar")
	static char standardizeChar(char var0, Language var1) {
		if (var0 >= 192 && var0 <= 255) {
			if (var0 >= 192 && var0 <= 198) {
				return 'A';
			}

			if (var0 == 199) {
				return 'C';
			}

			if (var0 >= 200 && var0 <= 203) {
				return 'E';
			}

			if (var0 >= 204 && var0 <= 207) {
				return 'I';
			}

			if (var0 == 209 && var1 != Language.Language_ES) {
				return 'N';
			}

			if (var0 >= 210 && var0 <= 214) {
				return 'O';
			}

			if (var0 >= 217 && var0 <= 220) {
				return 'U';
			}

			if (var0 == 221) {
				return 'Y';
			}

			if (var0 == 223) {
				return 's';
			}

			if (var0 >= 224 && var0 <= 230) {
				return 'a';
			}

			if (var0 == 231) {
				return 'c';
			}

			if (var0 >= 232 && var0 <= 235) {
				return 'e';
			}

			if (var0 >= 236 && var0 <= 239) {
				return 'i';
			}

			if (var0 == 241 && var1 != Language.Language_ES) {
				return 'n';
			}

			if (var0 >= 242 && var0 <= 246) {
				return 'o';
			}

			if (var0 >= 249 && var0 <= 252) {
				return 'u';
			}

			if (var0 == 253 || var0 == 255) {
				return 'y';
			}
		}

		if (var0 == 338) {
			return 'O';
		} else if (var0 == 339) {
			return 'o';
		} else {
			return var0 == 376 ? 'Y' : var0;
		}
	}

	@ObfuscatedName("cj")
	@ObfuscatedSignature(
		descriptor = "(IB)Ljava/lang/Object;",
		garbageValue = "2"
	)
	static Object method608(int var0) {
		return class144.method767((class503)ClientPreferences.findEnumerated(class503.method2469(), var0));
	}

	@ObfuscatedName("gq")
	@ObfuscatedSignature(
		descriptor = "(I)Lsq;",
		garbageValue = "293868513"
	)
	@Export("getWorldMap")
	static WorldMap getWorldMap() {
		return class127.worldMap;
	}
}
