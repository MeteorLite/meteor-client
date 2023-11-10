import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("MenuAction")
public class MenuAction {
	@ObfuscatedName("ax")
	@Export("Tiles_hueMultiplier")
	static int[] Tiles_hueMultiplier;
	@ObfuscatedName("cq")
	@Export("param9")
	static String param9;
	@ObfuscatedName("at")
	@Export("param0")
	int param0;
	@ObfuscatedName("ah")
	@Export("param1")
	int param1;
	@ObfuscatedName("ar")
	@Export("opcode")
	int opcode;
	@ObfuscatedName("ao")
	@Export("identifier")
	int identifier;
	@ObfuscatedName("ab")
	@Export("itemId")
	int itemId;
	@ObfuscatedName("au")
	@Export("action")
	String action;
	@ObfuscatedName("aa")
	@Export("target")
	String target;

	MenuAction() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Ldy;",
		garbageValue = "-180597093"
	)
	static AttackOption[] method436() {
		return new AttackOption[]{AttackOption.field1103, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden, AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.field1106};
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lol;II)V",
		garbageValue = "1404218002"
	)
	static void method435(AbstractArchive var0, int var1) {
		if ((var1 & class522.field4160.rsOrdinal()) != 0) {
			Login.logoSprite = class313.SpriteBuffer_getIndexedSpriteByName(var0, "logo_deadman_mode", "");
		} else if ((var1 & class522.field4161.rsOrdinal()) != 0) {
			Login.logoSprite = class313.SpriteBuffer_getIndexedSpriteByName(var0, "logo_seasonal_mode", "");
		} else if ((var1 & class522.field4154.rsOrdinal()) != 0) {
			Login.logoSprite = class313.SpriteBuffer_getIndexedSpriteByName(var0, "logo_speedrunning", "");
		} else {
			Login.logoSprite = class313.SpriteBuffer_getIndexedSpriteByName(var0, "logo", "");
		}

	}
}