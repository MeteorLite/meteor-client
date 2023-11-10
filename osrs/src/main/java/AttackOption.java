import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
@Implements("AttackOption")
public enum AttackOption implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ldy;"
	)
	@Export("AttackOption_dependsOnCombatLevels")
	AttackOption_dependsOnCombatLevels(0),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ldy;"
	)
	@Export("AttackOption_alwaysRightClick")
	AttackOption_alwaysRightClick(1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ldy;"
	)
	field1106(2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ldy;"
	)
	@Export("AttackOption_hidden")
	AttackOption_hidden(3),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Ldy;"
	)
	field1103(4);

	@ObfuscatedName("au")
	@Export("id")
	final int id;

	AttackOption(int var3) {
		this.id = var3;
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

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-99"
	)
	public static void method606() {
		HealthBarDefinition.HealthBarDefinition_cached.clear();
		HealthBarDefinition.ItemDefinition_cachedModels.clear();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "3"
	)
	static final void method607() {
		WorldMapArea.method1213("Your friend list is full. Max of 200 for free users, and 400 for members");
	}
}