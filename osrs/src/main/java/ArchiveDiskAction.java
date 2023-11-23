import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Date;

@ObfuscatedName("or")
@Implements("ArchiveDiskAction")
public class ArchiveDiskAction extends Node {
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Liu;"
	)
	@Export("clock")
	static Clock clock;
	@ObfuscatedName("at")
	@Export("type")
	int type;
	@ObfuscatedName("ah")
	@Export("data")
	public byte[] data;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lrg;"
	)
	@Export("archiveDisk")
	public ArchiveDisk archiveDisk;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	@Export("archive")
	public Archive archive;

	ArchiveDiskAction() {
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZB)I",
		garbageValue = "20"
	)
	static int method1909(int var0, Script var1, boolean var2) {
		String var3;
		int var4;
		if (var0 == 4100) {
			var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
			var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
			Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3 + var4;
			return 1;
		} else {
			String var9;
			if (var0 == 4101) {
				class127.Interpreter_stringStackSize -= 2;
				var3 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize];
				var9 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 1];
				Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3 + var9;
				return 1;
			} else if (var0 == 4102) {
				var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
				var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3 + SceneTilePaint.intToString(var4, true);
				return 1;
			} else if (var0 == 4103) {
				var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
				Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.toLowerCase();
				return 1;
			} else {
				int var6;
				int var10;
				if (var0 == 4104) {
					var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
					long var11 = (11745L + (long)var10) * 86400000L;
					Interpreter.Interpreter_calendar.setTime(new Date(var11));
					var6 = Interpreter.Interpreter_calendar.get(5);
					int var17 = Interpreter.Interpreter_calendar.get(2);
					int var8 = Interpreter.Interpreter_calendar.get(1);
					Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var17] + "-" + var8;
					return 1;
				} else if (var0 != 4105) {
					if (var0 == 4106) {
						var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = Integer.toString(var10);
						return 1;
					} else if (var0 == 4107) {
						class127.Interpreter_stringStackSize -= 2;
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = GrandExchangeOfferAgeComparator.method1970(class189.compareStrings(Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 1], class85.clientLanguage));
						return 1;
					} else {
						int var5;
						byte[] var13;
						Font var14;
						if (var0 == 4108) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							DbTableType.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
							var13 = VarbitComposition.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
							return 1;
						} else if (var0 == 4109) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							DbTableType.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
							var13 = VarbitComposition.archive13.takeFile(var5, 0);
							var14 = new Font(var13);
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
							return 1;
						} else if (var0 == 4110) {
							class127.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 1];
							if (Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1) {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3;
							} else {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9;
							}

							return 1;
						} else if (var0 == 4111) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
							return 1;
						} else if (var0 == 4112) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3 + (char)var4;
							return 1;
						} else if (var0 == 4113) {
							var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapElement.isCharPrintable((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4114) {
							var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = KeyHandler.isAlphaNumeric((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4115) {
							var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class10.isCharAlphabetic((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4116) {
							var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = Player.isDigit((char)var10) ? 1 : 0;
							return 1;
						} else if (var0 == 4117) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							if (var3 != null) {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.length();
							} else {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							}

							return 1;
						} else if (var0 == 4118) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							DbTableType.Interpreter_intStackSize -= 2;
							var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
							var5 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1];
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
							return 1;
						} else if (var0 == 4119) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							StringBuilder var18 = new StringBuilder(var3.length());
							boolean var16 = false;

							for (var6 = 0; var6 < var3.length(); ++var6) {
								char var7 = var3.charAt(var6);
								if (var7 == '<') {
									var16 = true;
								} else if (var7 == '>') {
									var16 = false;
								} else if (!var16) {
									var18.append(var7);
								}
							}

							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var18.toString();
							return 1;
						} else if (var0 == 4120) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							var4 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.indexOf(var4);
							return 1;
						} else if (var0 == 4121) {
							class127.Interpreter_stringStackSize -= 2;
							var3 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 1];
							var5 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
							return 1;
						} else if (var0 == 4122) {
							var3 = Interpreter.Interpreter_stringStack[--class127.Interpreter_stringStackSize];
							Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3.toUpperCase();
							return 1;
						} else if (var0 == 4123) {
							class127.Interpreter_stringStackSize -= 3;
							var3 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize];
							var9 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 1];
							String var15 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 2];
							if (class229.localPlayer.appearance == null) {
								Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var15;
								return 1;
							} else {
								switch(class229.localPlayer.appearance.field2948) {
								case 0:
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3;
									break;
								case 1:
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9;
									break;
								case 2:
								default:
									Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var15;
								}

								return 1;
							}
						} else {
							return 2;
						}
					}
				} else {
					class127.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize];
					var9 = Interpreter.Interpreter_stringStack[class127.Interpreter_stringStackSize + 1];
					if (class229.localPlayer.appearance != null && class229.localPlayer.appearance.field2947 != 0) {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var9;
					} else {
						Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var3;
					}

					return 1;
				}
			}
		}
	}

	@ObfuscatedName("lr")
	@ObfuscatedSignature(
		descriptor = "(Lds;IIIB)V",
		garbageValue = "0"
	)
	@Export("addPlayerToMenu")
	static final void addPlayerToMenu(Player var0, int var1, int var2, int var3) {
		if (class229.localPlayer != var0) {
			if (Client.menuOptionsCount < 400) {
				String var4;
				if (var0.skillLevel == 0) {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + class28.method126(var0.combatLevel, class229.localPlayer.combatLevel) + " " + " (" + "level-" + var0.combatLevel + ")" + var0.actions[2];
				} else {
					var4 = var0.actions[0] + var0.username + var0.actions[1] + " " + " (" + "skill-" + var0.skillLevel + ")" + var0.actions[2];
				}

				int var5;
				if (Client.isItemSelected == 1) {
					WorldMapSectionType.insertMenuItemNoShift("Use", Client.field597 + " " + "->" + " " + class167.colorStartTag(16777215) + var4, 14, var1, var2, var3);
				} else if (Client.isSpellSelected) {
					if ((UrlRequest.selectedSpellFlags & 8) == 8) {
						WorldMapSectionType.insertMenuItemNoShift(Client.field599, Client.field598 + " " + "->" + " " + class167.colorStartTag(16777215) + var4, 15, var1, var2, var3);
					}
				} else {
					for (var5 = 7; var5 >= 0; --var5) {
						if (Client.playerMenuActions[var5] != null) {
							short var6 = 0;
							if (Client.playerMenuActions[var5].equalsIgnoreCase("Attack")) {
								if (Client.playerAttackOption == AttackOption.AttackOption_hidden) {
									continue;
								}

								if (Client.playerAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.playerAttackOption && var0.combatLevel > class229.localPlayer.combatLevel) {
									var6 = 2000;
								}

								if (class229.localPlayer.team != 0 && var0.team != 0) {
									if (var0.team == class229.localPlayer.team) {
										var6 = 2000;
									} else {
										var6 = 0;
									}
								} else if (Client.playerAttackOption == AttackOption.field1103 && var0.isClanMember()) {
									var6 = 2000;
								}
							} else if (Client.playerOptionsPriorities[var5]) {
								var6 = 2000;
							}

							boolean var7 = false;
							int var8 = Client.playerMenuOpcodes[var5] + var6;
							WorldMapSectionType.insertMenuItemNoShift(Client.playerMenuActions[var5], class167.colorStartTag(16777215) + var4, var8, var1, var2, var3);
						}
					}
				}

				for (var5 = 0; var5 < Client.menuOptionsCount; ++var5) {
					if (Client.menuOpcodes[var5] == 23) {
						Client.menuTargets[var5] = class167.colorStartTag(16777215) + var4;
						break;
					}
				}

			}
		}
	}

	@ObfuscatedName("mu")
	@ObfuscatedSignature(
		descriptor = "(Lnn;I)Lnn;",
		garbageValue = "725672133"
	)
	static Widget method1911(Widget var0) {
		Widget var1 = class227.method1165(var0);
		if (var1 == null) {
			var1 = var0.parent;
		}

		return var1;
	}
}