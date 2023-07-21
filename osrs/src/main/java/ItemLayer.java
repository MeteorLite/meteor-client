import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("ItemLayer")
public final class ItemLayer {
	@ObfuscatedName("aw")
	@Export("z")
	int z;
	@ObfuscatedName("ay")
	@Export("x")
	int x;
	@ObfuscatedName("ar")
	@Export("y")
	int y;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lit;"
	)
	@Export("first")
	Renderable first;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lit;"
	)
	@Export("second")
	Renderable second;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lit;"
	)
	@Export("third")
	Renderable third;
	@ObfuscatedName("ag")
	@Export("tag")
	long tag;
	@ObfuscatedName("az")
	@Export("height")
	int height;

	ItemLayer() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Ldw;",
		garbageValue = "-986587125"
	)
	static AttackOption[] method1129() {
		return new AttackOption[]{AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.field1089, AttackOption.field1090};
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Luc;",
		garbageValue = "643907738"
	)
	@Export("FillMode_values")
	public static class525[] FillMode_values() {
		return new class525[]{class525.SOLID, class525.field4185, class525.field4184};
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "2136056509"
	)
	public static int method1128(CharSequence var0) {
		int var1 = var0.length();
		int var2 = 0;

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = (var2 << 5) - var2 + var0.charAt(var3);
		}

		return var2;
	}
}
