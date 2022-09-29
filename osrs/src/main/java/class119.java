import java.util.LinkedList;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
public class class119 implements MouseWheel {
	@ObfuscatedName("tq")
	@ObfuscatedGetter(
		intValue = -1883864704
	)
	static int field1479;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Ldv;"
	)
	static final class119 field1480;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Ldv;"
	)
	static final class119 field1470;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Ldv;"
	)
	static final class119 field1473;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Ldv;"
	)
	static final class119 field1472;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Ldv;"
	)
	static final class119 field1471;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Ldv;"
	)
	static final class119 field1474;
	@ObfuscatedName("es")
	@ObfuscatedSignature(
		descriptor = "Llb;"
	)
	@Export("archive2")
	static Archive archive2;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1003591649
	)
	final int field1475;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -139197625
	)
	final int field1476;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -2132375559
	)
	final int field1481;

	static {
		field1480 = new class119(0, 0, (String)null, 0);
		field1470 = new class119(1, 1, (String)null, 9);
		field1473 = new class119(2, 2, (String)null, 3);
		field1472 = new class119(3, 3, (String)null, 6);
		field1471 = new class119(4, 4, (String)null, 1);
		field1474 = new class119(5, 5, (String)null, 3);
	}

	class119(int var1, int var2, String var3, int var4) {
		this.field1475 = var1;
		this.field1476 = var2;
		this.field1481 = var4;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	public int rsOrdinal() {
		return this.field1476;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1462804223"
	)
	int method2901() {
		return this.field1481;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)Lfo;",
		garbageValue = "-21"
	)
	@Export("VarpDefinition_get")
	public static VarpDefinition VarpDefinition_get(int var0) {
		VarpDefinition var1 = (VarpDefinition)VarpDefinition.VarpDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = VarpDefinition.VarpDefinition_archive.takeFile(16, var0);
			var1 = new VarpDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			VarpDefinition.VarpDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZB)I",
		garbageValue = "2"
	)
	static int method2911(int var0, Script var1, boolean var2) {
		int var3;
		Object var4;
		int var5;
		class438 var6;
		int var7;
		if (var0 != 7500 && var0 != 7508) {
			if (var0 != 7501) {
				int var19;
				int var20;
				if (var0 == 7502) {
					Interpreter.Interpreter_intStackSize -= 3;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var19 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
					var20 = class425.method7664(var19);
					var7 = TaskHandler.method3414(var19);
					int var21 = Renderable.method4462(var19);
					class439 var26 = SecureRandomCallable.method2201(var3);
					class437 var27 = class229.method5021(var20);
					int[] var28 = var27.field4706[var7];
					int var12 = 0;
					int var13 = var28.length;
					if (var21 >= 0) {
						if (var21 >= var13) {
							throw new RuntimeException("Tuple index out-of-bounds. Requested: " + var21 + ", Max: " + var13);
						}

						var12 = var21;
						var13 = var21 + 1;
					}

					Object[] var14 = var26.method7827(var7);
					if (var14 == null && var27.field4707 != null) {
						var14 = var27.field4707[var7];
					}

					int var15;
					int var16;
					if (var14 == null) {
						for (var15 = var12; var15 < var13; ++var15) {
							var16 = var28[var15];
							class434 var22 = class360.method6732(var16);
							if (var22 == class434.field4689) {
								Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = "";
							} else {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Bounds.method7118(var16);
							}
						}

						return 1;
					} else {
						var15 = var14.length / var28.length;
						if (var5 >= 0 && var5 < var15) {
							for (var16 = var12; var16 < var13; ++var16) {
								int var17 = var16 + var28.length * var5;
								class434 var18 = class360.method6732(var28[var16]);
								if (var18 == class434.field4689) {
									Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = (String)var14[var17];
								} else {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (Integer)var14[var17];
								}
							}

							return 1;
						} else {
							throw new RuntimeException();
						}
					}
				} else if (var0 == 7503) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var19 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					var5 = 0;
					var20 = class425.method7664(var19);
					var7 = TaskHandler.method3414(var19);
					class439 var25 = SecureRandomCallable.method2201(var3);
					class437 var9 = class229.method5021(var20);
					int[] var10 = var9.field4706[var7];
					Object[] var11 = var25.method7827(var7);
					if (var11 == null && var9.field4707 != null) {
						var11 = var9.field4707[var7];
					}

					if (var11 != null) {
						var5 = var11.length / var10.length;
					}

					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
					return 1;
				} else if (var0 != 7504 && var0 != 7509) {
					if (var0 == 7505) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						class439 var24 = SecureRandomCallable.method2201(var3);
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var24.field4713;
						return 1;
					} else if (var0 == 7506) {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var19 = -1;
						if (class161.field1784 != null && var3 >= 0 && var3 < class161.field1784.size()) {
							var19 = (Integer)class161.field1784.get(var3);
						}

						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var19;
						return 1;
					} else if (var0 != 7507 && var0 != 7510) {
						return 2;
					} else {
						var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var4 = class13.method184(var3);
						var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
						var6 = VarpDefinition.method3527(var5);
						if (var6 == null) {
							throw new RuntimeException();
						} else if (class425.method7664(var5) != Client.field618) {
							throw new RuntimeException();
						} else if (class161.field1784 == null && class161.field1784.isEmpty()) {
							throw new RuntimeException();
						} else {
							var7 = Renderable.method4462(var5);
							List var8 = var6.method7824(var4, var7);
							class161.field1784 = new LinkedList(class161.field1784);
							if (var8 != null) {
								class161.field1784.retainAll(var8);
							} else {
								class161.field1784.clear();
							}

							class17.field100 = class161.field1784.iterator();
							if (var0 == 7507) {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class161.field1784.size();
							}

							return 1;
						}
					}
				} else {
					--Interpreter.Interpreter_intStackSize;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					class438 var23 = Decimator.method1103(var3);
					if (var23 == null) {
						throw new RuntimeException();
					} else {
						class161.field1784 = var23.method7824(0, 0);
						var5 = 0;
						if (class161.field1784 != null) {
							Client.field618 = var3;
							class17.field100 = class161.field1784.iterator();
							var5 = class161.field1784.size();
						}

						if (var0 == 7504) {
							Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
						}

						return 1;
					}
				}
			} else {
				if (class17.field100 != null && class17.field100.hasNext()) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (Integer)class17.field100.next();
				} else {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
				}

				return 1;
			}
		} else {
			var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var4 = class13.method184(var3);
			var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
			var6 = VarpDefinition.method3527(var5);
			if (var6 == null) {
				throw new RuntimeException();
			} else {
				var7 = Renderable.method4462(var5);
				class161.field1784 = var6.method7824(var4, var7);
				if (class161.field1784 != null) {
					Client.field618 = class425.method7664(var5);
					class17.field100 = class161.field1784.iterator();
					if (var0 == 7500) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class161.field1784.size();
					}
				} else {
					Client.field618 = -1;
					class17.field100 = null;
					if (var0 == 7500) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}
				}

				return 1;
			}
		}
	}

	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "157009554"
	)
	static final void method2909() {
		int var0 = SceneTilePaint.field2638 * 128 + 64;
		int var1 = UrlRequester.field1355 * 16384 + 64;
		int var2 = class120.getTileHeight(var0, var1, Tiles.Client_plane) - Strings.field3978;
		Tile.method4128(var0, var2, var1);
		var0 = field1479 * 16384 + 64;
		var1 = MusicPatchNode.field3301 * 16384 + 64;
		var2 = class120.getTileHeight(var0, var1, Tiles.Client_plane) - class123.field1520;
		int var3 = var0 - TaskHandler.cameraX;
		int var4 = var2 - SecureRandomFuture.cameraY;
		int var5 = var1 - ApproximateRouteStrategy.cameraZ;
		int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
		int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.9490051269531D) & 2047;
		int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.9490051269531D) & 2047;
		class7.method67(var7, var8);
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		descriptor = "(Lco;IIII)V",
		garbageValue = "115669779"
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
						String var5 = var0.method2505();
						int var6;
						int var9;
						if (var4.combatLevel != 0 && var0.field1203 != 0) {
							var6 = var0.field1203 != -1 ? var0.field1203 : var4.combatLevel;
							var9 = class67.localPlayer.combatLevel;
							int var10 = var9 - var6;
							String var8;
							if (var10 < -9) {
								var8 = SoundCache.colorStartTag(16711680);
							} else if (var10 < -6) {
								var8 = SoundCache.colorStartTag(16723968);
							} else if (var10 < -3) {
								var8 = SoundCache.colorStartTag(16740352);
							} else if (var10 < 0) {
								var8 = SoundCache.colorStartTag(16756736);
							} else if (var10 > 9) {
								var8 = SoundCache.colorStartTag(65280);
							} else if (var10 > 6) {
								var8 = SoundCache.colorStartTag(4259584);
							} else if (var10 > 3) {
								var8 = SoundCache.colorStartTag(8453888);
							} else if (var10 > 0) {
								var8 = SoundCache.colorStartTag(12648192);
							} else {
								var8 = SoundCache.colorStartTag(16776960);
							}

							var5 = var5 + var8 + " " + " (" + "level-" + var6 + ")";
						}

						if (var4.isFollower && Client.followerOpsLowPriority) {
							class135.insertMenuItemNoShift("Examine", SoundCache.colorStartTag(16776960) + var5, 1003, var1, var2, var3);
						}

						if (Client.isItemSelected == 1) {
							class135.insertMenuItemNoShift("Use", Client.selectedItemName + " " + "->" + " " + SoundCache.colorStartTag(16776960) + var5, 7, var1, var2, var3);
						} else if (Client.isSpellSelected) {
							if ((UrlRequest.selectedSpellFlags & 2) == 2) {
								class135.insertMenuItemNoShift(Client.selectedSpellActionName, Client.selectedSpellName + " " + "->" + " " + SoundCache.colorStartTag(16776960) + var5, 8, var1, var2, var3);
							}
						} else {
							var6 = var4.isFollower && Client.followerOpsLowPriority ? 2000 : 0;
							String[] var7 = var4.actions;
							int var11;
							if (var7 != null) {
								for (var11 = 4; var11 >= 0; --var11) {
									if (var7[var11] != null && !var7[var11].equalsIgnoreCase("Attack")) {
										var9 = 0;
										if (var11 == 0) {
											var9 = var6 + 9;
										}

										if (var11 == 1) {
											var9 = var6 + 10;
										}

										if (var11 == 2) {
											var9 = var6 + 11;
										}

										if (var11 == 3) {
											var9 = var6 + 12;
										}

										if (var11 == 4) {
											var9 = var6 + 13;
										}

										class135.insertMenuItemNoShift(var7[var11], SoundCache.colorStartTag(16776960) + var5, var9, var1, var2, var3);
									}
								}
							}

							if (var7 != null) {
								for (var11 = 4; var11 >= 0; --var11) {
									if (var7[var11] != null && var7[var11].equalsIgnoreCase("Attack")) {
										short var12 = 0;
										if (Client.npcAttackOption != AttackOption.AttackOption_hidden) {
											if (Client.npcAttackOption == AttackOption.AttackOption_alwaysRightClick || AttackOption.AttackOption_dependsOnCombatLevels == Client.npcAttackOption && var4.combatLevel > class67.localPlayer.combatLevel) {
												var12 = 2000;
											}

											var9 = 0;
											if (var11 == 0) {
												var9 = var12 + 9;
											}

											if (var11 == 1) {
												var9 = var12 + 10;
											}

											if (var11 == 2) {
												var9 = var12 + 11;
											}

											if (var11 == 3) {
												var9 = var12 + 12;
											}

											if (var11 == 4) {
												var9 = var12 + 13;
											}

											class135.insertMenuItemNoShift(var7[var11], SoundCache.colorStartTag(16776960) + var5, var9, var1, var2, var3);
										}
									}
								}
							}

							if (!var4.isFollower || !Client.followerOpsLowPriority) {
								class135.insertMenuItemNoShift("Examine", SoundCache.colorStartTag(16776960) + var5, 1003, var1, var2, var3);
							}
						}

					}
				}
			}
		}
	}
}
