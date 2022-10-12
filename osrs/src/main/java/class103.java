import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cp")
public class class103 {
	@ObfuscatedName("te")
	@ObfuscatedGetter(
		intValue = 421748945
	)
	static int field1344;
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1337;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1330;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1331;
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1332;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1333;
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1334;
	@ObfuscatedName("y")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1348;
	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1336;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1347;
	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1338;
	@ObfuscatedName("l")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1339;
	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1342;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1341;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	static final class103 field1340;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "Lmo;"
	)
	@Export("clientLanguage")
	static Language clientLanguage;
	@ObfuscatedName("ms")
	@ObfuscatedGetter(
		intValue = -962869657
	)
	@Export("menuX")
	static int menuX;
	@ObfuscatedName("o")
	@ObfuscatedGetter(
		intValue = 318532311
	)
	int field1343;

	static {
		field1337 = new class103(0);
		field1330 = new class103(1);
		field1331 = new class103(2);
		field1332 = new class103(3);
		field1333 = new class103(4);
		field1334 = new class103(5);
		field1348 = new class103(6);
		field1336 = new class103(7);
		field1347 = new class103(8);
		field1338 = new class103(9);
		field1339 = new class103(10);
		field1342 = new class103(11);
		field1341 = new class103(12);
		field1340 = new class103(13);
	}

	class103(int var1) {
		this.field1343 = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lca;III)V",
		garbageValue = "-1632793131"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1, int var2) {
		Object[] var3 = var0.args;
		Script var4;
		int var20;
		if (class417.isWorldMapEvent(var0.type)) {
			Decimator.worldMapEvent = (WorldMapEvent)var3[0];
			WorldMapElement var5 = Actor.WorldMapElement_get(Decimator.worldMapEvent.mapElement);
			var4 = Login.getWorldMapScript(var0.type, var5.objectId, var5.category);
		} else {
			var20 = (Integer)var3[0];
			var4 = class159.getScript(var20);
		}

		if (var4 != null) {
			class379.Interpreter_intStackSize = 0;
			class125.Interpreter_stringStackSize = 0;
			var20 = -1;
			int[] var6 = var4.opcodes;
			int[] var7 = var4.intOperands;
			byte var8 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field849 = false;
			boolean var9 = false;
			int var10 = 0;
			boolean var30 = false;

			label945: {
				label946: {
					try {
						int var13;
						try {
							var30 = true;
							Interpreter.Interpreter_intLocals = new int[var4.localIntCount];
							int var11 = 0;
							class447.Interpreter_stringLocals = new String[var4.localStringCount];
							int var12 = 0;

							int var14;
							String var21;
							for (var13 = 1; var13 < var3.length; ++var13) {
								if (var3[var13] instanceof Integer) {
									var14 = (Integer)var3[var13];
									if (var14 == -2147483647) {
										var14 = var0.mouseX;
									}

									if (var14 == -2147483646) {
										var14 = var0.mouseY;
									}

									if (var14 == -2147483645) {
										var14 = var0.widget != null ? var0.widget.id : -1;
									}

									if (var14 == -2147483644) {
										var14 = var0.opIndex;
									}

									if (var14 == -2147483643) {
										var14 = var0.widget != null ? var0.widget.childIndex : -1;
									}

									if (var14 == -2147483642) {
										var14 = var0.dragTarget != null ? var0.dragTarget.id : -1;
									}

									if (var14 == -2147483641) {
										var14 = var0.dragTarget != null ? var0.dragTarget.childIndex : -1;
									}

									if (var14 == -2147483640) {
										var14 = var0.keyTyped;
									}

									if (var14 == -2147483639) {
										var14 = var0.keyPressed;
									}

									Interpreter.Interpreter_intLocals[var11++] = var14;
								} else if (var3[var13] instanceof String) {
									var21 = (String)var3[var13];
									if (var21.equals("event_opbase")) {
										var21 = var0.targetName;
									}

									class447.Interpreter_stringLocals[var12++] = var21;
								}
							}

							Interpreter.field839 = var0.field1053;

							label930:
							while (true) {
								++var10;
								if (var10 > var1) {
									throw new RuntimeException();
								}

								++var20;
								int var33 = var6[var20];
								if (var33 >= 100) {
									boolean var35;
									if (var4.intOperands[var20] == 1) {
										var35 = true;
									} else {
										var35 = false;
									}

									var14 = AbstractUserComparator.method7354(var33, var4, var35);
									switch(var14) {
									case 0:
										var30 = false;
										break label930;
									case 1:
									default:
										break;
									case 2:
										throw new IllegalStateException();
									}
								} else if (var33 == 0) {
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var7[var20];
								} else if (var33 == 1) {
									var13 = var7[var20];
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = Varps.Varps_main[var13];
								} else if (var33 == 2) {
									var13 = var7[var20];
									Varps.Varps_main[var13] = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
									ClanChannel.changeGameOptions(var13);
								} else if (var33 == 3) {
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var4.stringOperands[var20];
								} else if (var33 == 6) {
									var20 += var7[var20];
								} else if (var33 == 7) {
									class379.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 8) {
									class379.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 9) {
									class379.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 10) {
									class379.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 21) {
									if (Interpreter.Interpreter_frameDepth == 0) {
										var30 = false;
										break label946;
									}

									ScriptFrame var40 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
									var4 = var40.script;
									var6 = var4.opcodes;
									var7 = var4.intOperands;
									var20 = var40.pc;
									Interpreter.Interpreter_intLocals = var40.intLocals;
									class447.Interpreter_stringLocals = var40.stringLocals;
								} else if (var33 == 25) {
									var13 = var7[var20];
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = Login.getVarbit(var13);
								} else if (var33 == 27) {
									var13 = var7[var20];
									TriBool.method7466(var13, Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize]);
								} else if (var33 == 31) {
									class379.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 32) {
									class379.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 33) {
									Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var7[var20]];
								} else if (var33 == 34) {
									Interpreter.Interpreter_intLocals[var7[var20]] = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
								} else if (var33 == 35) {
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = class447.Interpreter_stringLocals[var7[var20]];
								} else if (var33 == 36) {
									class447.Interpreter_stringLocals[var7[var20]] = Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize];
								} else if (var33 == 37) {
									var13 = var7[var20];
									class125.Interpreter_stringStackSize -= var13;
									var21 = Coord.method5704(Interpreter.Interpreter_stringStack, class125.Interpreter_stringStackSize, var13);
									Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var21;
								} else if (var33 == 38) {
									--class379.Interpreter_intStackSize;
								} else if (var33 == 39) {
									--class125.Interpreter_stringStackSize;
								} else {
									int var17;
									if (var33 != 40) {
										if (var33 == 42) {
											Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = Projectile.varcs.getInt(var7[var20]);
										} else if (var33 == 43) {
											Projectile.varcs.setInt(var7[var20], Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize]);
										} else if (var33 == 44) {
											var13 = var7[var20] >> 16;
											var14 = var7[var20] & 65535;
											int var24 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
											if (var24 < 0 || var24 > 5000) {
												throw new RuntimeException();
											}

											Interpreter.Interpreter_arrayLengths[var13] = var24;
											byte var25 = -1;
											if (var14 == 105) {
												var25 = 0;
											}

											for (var17 = 0; var17 < var24; ++var17) {
												Interpreter.Interpreter_arrays[var13][var17] = var25;
											}
										} else if (var33 == 45) {
											var13 = var7[var20];
											var14 = Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize];
											if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
												throw new RuntimeException();
											}

											Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var13][var14];
										} else if (var33 == 46) {
											var13 = var7[var20];
											class379.Interpreter_intStackSize -= 2;
											var14 = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize];
											if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
												throw new RuntimeException();
											}

											Interpreter.Interpreter_arrays[var13][var14] = Interpreter.Interpreter_intStack[class379.Interpreter_intStackSize + 1];
										} else {
											String var22;
											if (var33 == 47) {
												var22 = Projectile.varcs.getStringOld(var7[var20]);
												if (var22 == null) {
													var22 = "null";
												}

												Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var22;
											} else if (var33 == 48) {
												Projectile.varcs.setStringOld(var7[var20], Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize]);
											} else if (var33 == 49) {
												var22 = Projectile.varcs.getString(var7[var20]);
												Interpreter.Interpreter_stringStack[++class125.Interpreter_stringStackSize - 1] = var22;
											} else if (var33 == 50) {
												Projectile.varcs.setString(var7[var20], Interpreter.Interpreter_stringStack[--class125.Interpreter_stringStackSize]);
											} else if (var33 == 60) {
												IterableNodeHashTable var38 = var4.switches[var7[var20]];
												IntegerNode var37 = (IntegerNode)var38.get((long)Interpreter.Interpreter_intStack[--class379.Interpreter_intStackSize]);
												if (var37 != null) {
													var20 += var37.integer;
												}
											} else {
												Integer var39;
												if (var33 == 74) {
													var39 = class10.field56.getTitleGroupValue(var7[var20]);
													if (var39 == null) {
														Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = -1;
													} else {
														Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var39;
													}
												} else {
													if (var33 != 76) {
														throw new IllegalStateException();
													}

													var39 = class157.field1745.method7743(var7[var20]);
													if (var39 == null) {
														Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = -1;
													} else {
														Interpreter.Interpreter_intStack[++class379.Interpreter_intStackSize - 1] = var39;
													}
												}
											}
										}
									} else {
										var13 = var7[var20];
										Script var36 = class159.getScript(var13);
										int[] var15 = new int[var36.localIntCount];
										String[] var16 = new String[var36.localStringCount];

										for (var17 = 0; var17 < var36.intArgumentCount; ++var17) {
											var15[var17] = Interpreter.Interpreter_intStack[var17 + (class379.Interpreter_intStackSize - var36.intArgumentCount)];
										}

										for (var17 = 0; var17 < var36.stringArgumentCount; ++var17) {
											var16[var17] = Interpreter.Interpreter_stringStack[var17 + (class125.Interpreter_stringStackSize - var36.stringArgumentCount)];
										}

										class379.Interpreter_intStackSize -= var36.intArgumentCount;
										class125.Interpreter_stringStackSize -= var36.stringArgumentCount;
										ScriptFrame var23 = new ScriptFrame();
										var23.script = var4;
										var23.pc = var20;
										var23.intLocals = Interpreter.Interpreter_intLocals;
										var23.stringLocals = class447.Interpreter_stringLocals;
										Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var23;
										var4 = var36;
										var6 = var36.opcodes;
										var7 = var36.intOperands;
										var20 = -1;
										Interpreter.Interpreter_intLocals = var15;
										class447.Interpreter_stringLocals = var16;
									}
								}
							}
						} catch (Exception var31) {
							var9 = true;
							StringBuilder var27 = new StringBuilder(30);
							var27.append("").append(var4.key).append(" ");

							for (var13 = Interpreter.Interpreter_frameDepth - 1; var13 >= 0; --var13) {
								var27.append("").append(Interpreter.Interpreter_frames[var13].script.key).append(" ");
							}

							var27.append("").append(var8);
							class421.RunException_sendStackTrace(var27.toString(), var31);
							var30 = false;
							break label945;
						}
					} finally {
						if (var30) {
							while (Interpreter.field851.size() > 0) {
								class97 var19 = (class97)Interpreter.field851.remove(0);
								class279.widgetDefaultMenuAction(var19.method2520(), var19.method2521(), var19.method2523(), var19.method2524(), "");
							}

							if (Interpreter.field849) {
								Interpreter.field849 = false;
								class354.method6769();
							}

							if (!var9 && var2 > 0 && var10 >= var2) {
								class421.RunException_sendStackTrace("Warning: Script " + var4.field962 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
							}

						}
					}

					while (Interpreter.field851.size() > 0) {
						class97 var34 = (class97)Interpreter.field851.remove(0);
						class279.widgetDefaultMenuAction(var34.method2520(), var34.method2521(), var34.method2523(), var34.method2524(), "");
					}

					if (Interpreter.field849) {
						Interpreter.field849 = false;
						class354.method6769();
					}

					if (!var9 && var2 > 0 && var10 >= var2) {
						class421.RunException_sendStackTrace("Warning: Script " + var4.field962 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
					}

					return;
				}

				while (Interpreter.field851.size() > 0) {
					class97 var41 = (class97)Interpreter.field851.remove(0);
					class279.widgetDefaultMenuAction(var41.method2520(), var41.method2521(), var41.method2523(), var41.method2524(), "");
				}

				if (Interpreter.field849) {
					Interpreter.field849 = false;
					class354.method6769();
				}

				if (!var9 && var2 > 0 && var10 >= var2) {
					class421.RunException_sendStackTrace("Warning: Script " + var4.field962 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
				}

				return;
			}

			while (Interpreter.field851.size() > 0) {
				class97 var26 = (class97)Interpreter.field851.remove(0);
				class279.widgetDefaultMenuAction(var26.method2520(), var26.method2521(), var26.method2523(), var26.method2524(), "");
			}

			if (Interpreter.field849) {
				Interpreter.field849 = false;
				class354.method6769();
			}

			if (!var9 && var2 > 0 && var10 >= var2) {
				class421.RunException_sendStackTrace("Warning: Script " + var4.field962 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
			}

		}
	}
}
