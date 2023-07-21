import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
@Implements("MenuAction")
public class MenuAction {
	@ObfuscatedName("aw")
	@Export("param0")
	int param0;
	@ObfuscatedName("ay")
	@Export("param1")
	int param1;
	@ObfuscatedName("ar")
	@Export("opcode")
	int opcode;
	@ObfuscatedName("am")
	@Export("identifier")
	int identifier;
	@ObfuscatedName("as")
	@Export("itemId")
	int itemId;
	@ObfuscatedName("aj")
	@Export("action")
	String action;
	@ObfuscatedName("ag")
	@Export("target")
	String target;

	MenuAction() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)[Lfg;",
		garbageValue = "-994330440"
	)
	static class132[] method434() {
		return new class132[]{class132.field1274, class132.field1276, class132.field1269, class132.field1266, class132.field1270, class132.field1265, class132.field1263, class132.field1277, class132.field1273, class132.field1267, class132.field1268, class132.field1271, class132.field1264, class132.field1275, class132.field1261, class132.field1272, class132.field1262};
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZB)I",
		garbageValue = "4"
	)
	static int method435(int var0, Script var1, boolean var2) {
		return 2;
	}

	@ObfuscatedName("mk")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1834048836"
	)
	@Export("changeGameOptions")
	static final void changeGameOptions(int var0) {
		DbRowType.process();
		class19.method67();
		int var1 = class158.VarpDefinition_get(var0).type;
		if (var1 != 0) {
			int var2 = Varps.Varps_main[var0];
			if (var1 == 1) {
				if (var2 == 1) {
					Rasterizer3D.method1164(0.9D);
					((TextureProvider)Rasterizer3D.field2012.Rasterizer3D_textureLoader).setBrightness(0.9D);
					HealthBar.method581();
					class150.clientPreferences.setBrightness(0.9D);
				}

				if (var2 == 2) {
					Rasterizer3D.method1164(0.8D);
					((TextureProvider)Rasterizer3D.field2012.Rasterizer3D_textureLoader).setBrightness(0.8D);
					HealthBar.method581();
					class150.clientPreferences.setBrightness(0.8D);
				}

				if (var2 == 3) {
					Rasterizer3D.method1164(0.7D);
					((TextureProvider)Rasterizer3D.field2012.Rasterizer3D_textureLoader).setBrightness(0.7D);
					HealthBar.method581();
					class150.clientPreferences.setBrightness(0.7D);
				}

				if (var2 == 4) {
					Rasterizer3D.method1164(0.6D);
					((TextureProvider)Rasterizer3D.field2012.Rasterizer3D_textureLoader).setBrightness(0.6D);
					HealthBar.method581();
					class150.clientPreferences.setBrightness(0.6D);
				}
			}

			if (var1 == 3) {
				if (var2 == 0) {
					StudioGame.method1839(255);
				}

				if (var2 == 1) {
					StudioGame.method1839(192);
				}

				if (var2 == 2) {
					StudioGame.method1839(128);
				}

				if (var2 == 3) {
					StudioGame.method1839(64);
				}

				if (var2 == 4) {
					StudioGame.method1839(0);
				}
			}

			if (var1 == 4) {
				if (var2 == 0) {
					ClanMate.method2184(127);
				}

				if (var2 == 1) {
					ClanMate.method2184(96);
				}

				if (var2 == 2) {
					ClanMate.method2184(64);
				}

				if (var2 == 3) {
					ClanMate.method2184(32);
				}

				if (var2 == 4) {
					ClanMate.method2184(0);
				}
			}

			if (var1 == 5) {
				Client.leftClickOpensMenu = var2 == 1;
			}

			if (var1 == 6) {
				Client.chatEffects = var2;
			}

			if (var1 == 9) {
			}

			if (var1 == 10) {
				if (var2 == 0) {
					Interpreter.method429(127);
				}

				if (var2 == 1) {
					Interpreter.method429(96);
				}

				if (var2 == 2) {
					Interpreter.method429(64);
				}

				if (var2 == 3) {
					Interpreter.method429(32);
				}

				if (var2 == 4) {
					Interpreter.method429(0);
				}
			}

			if (var1 == 17) {
				Client.followerIndex = var2 & 65535;
			}

			if (var1 == 18) {
				Client.playerAttackOption = (AttackOption)ClientPreferences.findEnumerated(ItemLayer.method1129(), var2);
				if (Client.playerAttackOption == null) {
					Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

			if (var1 == 19) {
				if (var2 == -1) {
					Client.combatTargetPlayerIndex = -1;
				} else {
					Client.combatTargetPlayerIndex = var2 & 2047;
				}
			}

			if (var1 == 22) {
				Client.npcAttackOption = (AttackOption)ClientPreferences.findEnumerated(ItemLayer.method1129(), var2);
				if (Client.npcAttackOption == null) {
					Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
				}
			}

		}
	}
}
