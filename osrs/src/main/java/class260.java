import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kb")
public class class260 implements WorldMapSection {
	@ObfuscatedName("au")
	int field2394;
	@ObfuscatedName("ae")
	int field2388;
	@ObfuscatedName("ao")
	int field2391;
	@ObfuscatedName("at")
	int field2393;
	@ObfuscatedName("ac")
	int field2387;
	@ObfuscatedName("ai")
	int field2390;
	@ObfuscatedName("az")
	int field2395;
	@ObfuscatedName("ap")
	int field2392;
	@ObfuscatedName("aa")
	int field2386;
	@ObfuscatedName("af")
	int field2389;

	class260() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljf;I)V",
		garbageValue = "-474032336"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2387) {
			var1.regionLowX = this.field2387;
		}

		if (var1.regionHighX < this.field2387) {
			var1.regionHighX = this.field2387;
		}

		if (var1.regionLowY > this.field2390) {
			var1.regionLowY = this.field2390;
		}

		if (var1.regionHighY < this.field2390) {
			var1.regionHighY = this.field2390;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IIII)Z",
		garbageValue = "509257779"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field2394 && var1 < this.field2394 + this.field2388) {
			return var2 >= (this.field2391 << 6) + (this.field2395 << 3) && var2 <= (this.field2391 << 6) + (this.field2395 << 3) + 7 && var3 >= (this.field2393 << 6) + (this.field2392 << 3) && var3 <= (this.field2393 << 6) + (this.field2392 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "-94"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field2387 << 6) + (this.field2386 << 3) && var1 <= (this.field2387 << 6) + (this.field2386 << 3) + 7 && var2 >= (this.field2390 << 6) + (this.field2389 << 3) && var2 <= (this.field2390 << 6) + (this.field2389 << 3) + 7;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIII)[I",
		garbageValue = "1978048199"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.field2387 * 64 - this.field2391 * 64) + (this.field2386 * 8 - this.field2395 * 8), var3 + (this.field2390 * 64 - this.field2393 * 64) + (this.field2389 * 8 - this.field2392 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(III)Lmc;",
		garbageValue = "-1281040923"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field2391 * 64 - this.field2387 * 64 + (this.field2395 * 8 - this.field2386 * 8) + var1;
			int var4 = var2 + (this.field2393 * 64 - this.field2390 * 64) + (this.field2392 * 8 - this.field2389 * 8);
			return new Coord(this.field2394, var3, var4);
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "47"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field2394 = var1.readUnsignedByte();
		this.field2388 = var1.readUnsignedByte();
		this.field2391 = var1.readUnsignedShort();
		this.field2395 = var1.readUnsignedByte();
		this.field2393 = var1.readUnsignedShort();
		this.field2392 = var1.readUnsignedByte();
		this.field2387 = var1.readUnsignedShort();
		this.field2386 = var1.readUnsignedByte();
		this.field2390 = var1.readUnsignedShort();
		this.field2389 = var1.readUnsignedByte();
		this.method1498();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1425291786"
	)
	void method1498() {
	}

	@ObfuscatedName("lv")
	@ObfuscatedSignature(
		descriptor = "(Ldx;IIIB)V",
		garbageValue = "-28"
	)
	@Export("addNpcToMenu")
	static final void addNpcToMenu(NPC var0, int var1, int var2, int var3) {
		NPCComposition var4 = var0.definition;
		if (Client.menuOptionsCount < 400) {
			if (var4.transforms != null) {
				var4 = var4.transform();
			}

			if (var4 != null) {
				if (var4.isInteractable) {
					if (!var4.isFollower || Client.followerIndex == var1) {
						String var5 = var0.method581();
						int var6;
						if (var4.combatLevel != 0 && var0.combatLevelChange != 0) {
							var6 = var0.combatLevelChange != -1 ? var0.combatLevelChange * -611368101 * -1824049965 : var4.combatLevel * 989486243 * 599602955;
							var5 = var5 + class14.method42(var6, VarbitComposition.localPlayer.combatLevel) + " " + " (" + "level-" + var6 + ")";
						}

						if (var4.isFollower && Client.followerOpsLowPriority) {
							class385.insertMenuItemNoShift("Examine", MoveSpeed.colorStartTag(16776960) + var5, 1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							class385.insertMenuItemNoShift("Use", Client.field599 + " " + "->" + " " + MoveSpeed.colorStartTag(16776960) + var5, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((Canvas.selectedSpellFlags & 2) == 2) {
								class385.insertMenuItemNoShift(Client.field600, Client.field601 + " " + "->" + " " + MoveSpeed.colorStartTag(16776960) + var5, 8, var1, var2, var3);
							}
						} else {
							var6 = var4.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var7 = var4.actions;
							int var8;
							int var9;
							if (var7 != null) {
								for (var8 = 4; var8 >= 0; --var8) {
									if (var0.method580(var8) && var7[var8] != null && !var7[var8].equalsIgnoreCase("Attack")) {
										var9 = 0;
										if (var8 == 0) {
											var9 = var6 + 9;
										}

										if (var8 == 1) {
											var9 = var6 + 10;
										}

										if (var8 == 2) {
											var9 = var6 + 11;
										}

										if (var8 == 3) {
											var9 = var6 + 12;
										}

										if (var8 == 4) {
											var9 = var6 + 13;
										}

										class385.insertMenuItemNoShift(var7[var8], MoveSpeed.colorStartTag(16776960) + var5, var9, var1, var2, var3);
									}
								}
							}

							if (var7 != null) {
								for (var8 = 4; var8 >= 0; --var8) {
									if (var0.method580(var8) && var7[var8] != null && var7[var8].equalsIgnoreCase("Attack")) {
										short var10 = 0;
										if (AttackOption.AttackOption_hidden != Client.npcAttackOption) {
											if (AttackOption.AttackOption_alwaysRightClick == Client.npcAttackOption || Client.npcAttackOption == AttackOption.AttackOption_dependsOnCombatLevels && var4.combatLevel > VarbitComposition.localPlayer.combatLevel) {
												var10 = 2000;
											}

											var9 = 0;
											if (var8 == 0) {
												var9 = var10 + 9;
											}

											if (var8 == 1) {
												var9 = var10 + 10;
											}

											if (var8 == 2) {
												var9 = var10 + 11;
											}

											if (var8 == 3) {
												var9 = var10 + 12;
											}

											if (var8 == 4) {
												var9 = var10 + 13;
											}

											class385.insertMenuItemNoShift(var7[var8], MoveSpeed.colorStartTag(16776960) + var5, var9, var1, var2, var3);
										}
									}
								}
							}

							if (!var4.isFollower || !Client.followerOpsLowPriority) {
								class385.insertMenuItemNoShift("Examine", MoveSpeed.colorStartTag(16776960) + var5, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}
}