import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("AttackOption")
public enum AttackOption implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lem;"
	)
	@Export("AttackOption_dependsOnCombatLevels")
	AttackOption_dependsOnCombatLevels(0),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lem;"
	)
	@Export("AttackOption_alwaysRightClick")
	AttackOption_alwaysRightClick(1),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lem;"
	)
	field1100(2),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lem;"
	)
	@Export("AttackOption_hidden")
	AttackOption_hidden(3),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lem;"
	)
	field1102(4);

	@ObfuscatedName("il")
	static long field1098;
	@ObfuscatedName("ah")
	@Export("id")
	final int id;

	AttackOption(int var3) {
		this.id = var3;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Ltp;III)I",
		garbageValue = "1550710334"
	)
	static int method607(IterableNodeHashTable var0, int var1, int var2) {
		if (var0 == null) {
			return var2;
		} else {
			IntegerNode var3 = (IntegerNode)var0.get((long)var1);
			return var3 == null ? var2 : var3.integer;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)Z",
		garbageValue = "1281251233"
	)
	@Export("isNumber")
	public static boolean isNumber(CharSequence var0) {
		return class135.method728(var0, 10, true);
	}

	@ObfuscatedName("lv")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-860429671"
	)
	static final int method609() {
		return Client.menuOptionsCount - 1;
	}
}