import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class18 {
	@ObfuscatedName("je")
	@Export("xteaKeys")
	static int[][] xteaKeys;
	@ObfuscatedName("uj")
	static int field51;
	@ObfuscatedName("aw")
	Future field54;
	@ObfuscatedName("ay")
	String field53;

	class18(Future var1) {
		this.field54 = var1;
	}

	class18(String var1) {
		this.method58(var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "57"
	)
	void method58(String var1) {
		if (var1 == null) {
			var1 = "";
		}

		this.field53 = var1;
		if (this.field54 != null) {
			this.field54.cancel(true);
			this.field54 = null;
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "33"
	)
	public final String method59() {
		return this.field53;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "7786"
	)
	public boolean method61() {
		return this.field53 != null || this.field54 == null;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "12"
	)
	public final boolean method62() {
		return this.method61() ? true : this.field54.isDone();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)Lac;",
		garbageValue = "34"
	)
	public final class20 method63() {
		if (this.method61()) {
			return new class20(this.field53);
		} else if (!this.method62()) {
			return null;
		} else {
			try {
				return (class20)this.field54.get();
			} catch (Exception var3) {
				String var2 = "Error retrieving REST request reply";
				System.err.println(var2 + "\r\n" + var3);
				this.method58(var2);
				return new class20(var2);
			}
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;Ljava/lang/String;I)I",
		garbageValue = "2052181437"
	)
	public static int method57(Buffer var0, String var1) {
		int var2 = var0.offset;
		int var4 = var1.length();
		byte[] var5 = new byte[var4];

		for (int var6 = 0; var6 < var4; ++var6) {
			char var7 = var1.charAt(var6);
			if ((var7 <= 0 || var7 >= 128) && (var7 < 160 || var7 > 255)) {
				if (var7 == 8364) {
					var5[var6] = -128;
				} else if (var7 == 8218) {
					var5[var6] = -126;
				} else if (var7 == 402) {
					var5[var6] = -125;
				} else if (var7 == 8222) {
					var5[var6] = -124;
				} else if (var7 == 8230) {
					var5[var6] = -123;
				} else if (var7 == 8224) {
					var5[var6] = -122;
				} else if (var7 == 8225) {
					var5[var6] = -121;
				} else if (var7 == 710) {
					var5[var6] = -120;
				} else if (var7 == 8240) {
					var5[var6] = -119;
				} else if (var7 == 352) {
					var5[var6] = -118;
				} else if (var7 == 8249) {
					var5[var6] = -117;
				} else if (var7 == 338) {
					var5[var6] = -116;
				} else if (var7 == 381) {
					var5[var6] = -114;
				} else if (var7 == 8216) {
					var5[var6] = -111;
				} else if (var7 == 8217) {
					var5[var6] = -110;
				} else if (var7 == 8220) {
					var5[var6] = -109;
				} else if (var7 == 8221) {
					var5[var6] = -108;
				} else if (var7 == 8226) {
					var5[var6] = -107;
				} else if (var7 == 8211) {
					var5[var6] = -106;
				} else if (var7 == 8212) {
					var5[var6] = -105;
				} else if (var7 == 732) {
					var5[var6] = -104;
				} else if (var7 == 8482) {
					var5[var6] = -103;
				} else if (var7 == 353) {
					var5[var6] = -102;
				} else if (var7 == 8250) {
					var5[var6] = -101;
				} else if (var7 == 339) {
					var5[var6] = -100;
				} else if (var7 == 382) {
					var5[var6] = -98;
				} else if (var7 == 376) {
					var5[var6] = -97;
				} else {
					var5[var6] = 63;
				}
			} else {
				var5[var6] = (byte)var7;
			}
		}

		var0.writeSmartByteShort(var5.length);
		var0.offset += class335.huffman.compress(var5, 0, var5.length, var0.array, var0.offset);
		return var0.offset - var2;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Ldi;Ldc;III)V",
		garbageValue = "-2007406926"
	)
	static void method64(ScriptEvent var0, Script var1, int var2, int var3) {
		Object[] var4 = var0.args;
		Interpreter.Interpreter_intStackSize = 0;
		Interpreter.Interpreter_stringStackSize = 0;
		int var5 = -1;
		int[] var6 = var1.opcodes;
		int[] var7 = var1.intOperands;
		byte var8 = -1;
		Interpreter.Interpreter_frameDepth = 0;
		Interpreter.field698 = false;
		boolean var9 = false;
		int var10 = 0;
		boolean var29 = false;

		label859: {
			label860: {
				try {
					int var13;
					try {
						var29 = true;
						Interpreter.Interpreter_intLocals = new int[var1.localIntCount];
						int var11 = 0;
						Interpreter.Interpreter_stringLocals = new String[var1.localStringCount];
						int var12 = 0;

						int var14;
						String var20;
						for (var13 = 1; var13 < var4.length; ++var13) {
							if (var4[var13] instanceof Integer) {
								var14 = (Integer)var4[var13];
								if (var14 == -2147483647) {
									var14 = var0.mouseX;
								}

								if (var14 == -2147483646) {
									var14 = var0.mouseY;
								}

								if (var14 == -2147483645) {
									var14 = var0.widget != null ? var0.widget.id * -232044627 * -1780632539 : -1;
								}

								if (var14 == -2147483644) {
									var14 = var0.opIndex;
								}

								if (var14 == -2147483643) {
									var14 = var0.widget != null ? var0.widget.childIndex * 1116520775 * -72312713 : -1;
								}

								if (var14 == -2147483642) {
									var14 = var0.dragTarget != null ? var0.dragTarget.id * -232044627 * -1780632539 : -1;
								}

								if (var14 == -2147483641) {
									var14 = var0.dragTarget != null ? var0.dragTarget.childIndex * 1116520775 * -72312713 : -1;
								}

								if (var14 == -2147483640) {
									var14 = var0.keyTyped;
								}

								if (var14 == -2147483639) {
									var14 = var0.keyPressed;
								}

								Interpreter.Interpreter_intLocals[var11++] = var14;
							} else if (var4[var13] instanceof String) {
								var20 = (String)var4[var13];
								if (var20.equals("event_opbase")) {
									var20 = var0.targetName;
								}

								Interpreter.Interpreter_stringLocals[var12++] = var20;
							}
						}

						Interpreter.field701 = var0.field862;

						label840:
						while (true) {
							++var10;
							if (var10 > var2) {
								throw new RuntimeException();
							}

							++var5;
							int var32 = var6[var5];
							if (var32 >= 100) {
								boolean var34;
								if (var1.intOperands[var5] == 1) {
									var34 = true;
								} else {
									var34 = false;
								}

								var14 = class142.method757(var32, var1, var34);
								switch(var14) {
								case 0:
									var29 = false;
									break label840;
								case 1:
								default:
									break;
								case 2:
									throw new IllegalStateException();
								}
							} else if (var32 == 0) {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7[var5];
							} else if (var32 == 1) {
								var13 = var7[var5];
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.Varps_main[var13];
							} else if (var32 == 2) {
								var13 = var7[var5];
								Varps.Varps_main[var13] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
								MenuAction.changeGameOptions(var13);
							} else if (var32 == 3) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var1.stringOperands[var5];
							} else if (var32 == 6) {
								var5 += var7[var5];
							} else if (var32 == 7) {
								Interpreter.Interpreter_intStackSize -= 2;
								if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
									var5 += var7[var5];
								}
							} else if (var32 == 8) {
								Interpreter.Interpreter_intStackSize -= 2;
								if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
									var5 += var7[var5];
								}
							} else if (var32 == 9) {
								Interpreter.Interpreter_intStackSize -= 2;
								if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
									var5 += var7[var5];
								}
							} else if (var32 == 10) {
								Interpreter.Interpreter_intStackSize -= 2;
								if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
									var5 += var7[var5];
								}
							} else if (var32 == 21) {
								if (Interpreter.Interpreter_frameDepth == 0) {
									var29 = false;
									break label860;
								}

								ScriptFrame var39 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
								var1 = var39.script;
								var6 = var1.opcodes;
								var7 = var1.intOperands;
								var5 = var39.pc;
								Interpreter.Interpreter_intLocals = var39.intLocals;
								Interpreter.Interpreter_stringLocals = var39.stringLocals;
							} else if (var32 == 25) {
								var13 = var7[var5];
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WallDecoration.getVarbit(var13);
							} else if (var32 == 27) {
								var13 = var7[var5];
								class164.method858(var13, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
							} else if (var32 == 31) {
								Interpreter.Interpreter_intStackSize -= 2;
								if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
									var5 += var7[var5];
								}
							} else if (var32 == 32) {
								Interpreter.Interpreter_intStackSize -= 2;
								if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
									var5 += var7[var5];
								}
							} else if (var32 == 33) {
								Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var7[var5]];
							} else if (var32 == 34) {
								Interpreter.Interpreter_intLocals[var7[var5]] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
							} else if (var32 == 35) {
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var7[var5]];
							} else if (var32 == 36) {
								Interpreter.Interpreter_stringLocals[var7[var5]] = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
							} else if (var32 == 37) {
								var13 = var7[var5];
								Interpreter.Interpreter_stringStackSize -= var13;
								var20 = class153.method796(Interpreter.Interpreter_stringStack, Interpreter.Interpreter_stringStackSize, var13);
								Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var20;
							} else if (var32 == 38) {
								--Interpreter.Interpreter_intStackSize;
							} else if (var32 == 39) {
								--Interpreter.Interpreter_stringStackSize;
							} else {
								int var17;
								if (var32 != 40) {
									if (var32 == 42) {
										Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = PendingSpawn.varcs.getInt(var7[var5]);
									} else if (var32 == 43) {
										PendingSpawn.varcs.setInt(var7[var5], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
									} else if (var32 == 44) {
										var13 = var7[var5] >> 16;
										var14 = var7[var5] & 65535;
										int var23 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
										if (var23 < 0 || var23 > 5000) {
											throw new RuntimeException();
										}

										Interpreter.Interpreter_arrayLengths[var13] = var23;
										byte var24 = -1;
										if (var14 == 105) {
											var24 = 0;
										}

										for (var17 = 0; var17 < var23; ++var17) {
											Interpreter.Interpreter_arrays[var13][var17] = var24;
										}
									} else if (var32 == 45) {
										var13 = var7[var5];
										var14 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
										if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
											throw new RuntimeException();
										}

										Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var13][var14];
									} else if (var32 == 46) {
										var13 = var7[var5];
										Interpreter.Interpreter_intStackSize -= 2;
										var14 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
										if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
											throw new RuntimeException();
										}

										Interpreter.Interpreter_arrays[var13][var14] = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
									} else {
										String var21;
										if (var32 == 47) {
											var21 = PendingSpawn.varcs.getStringOld(var7[var5]);
											if (var21 == null) {
												var21 = "null";
											}

											Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var21;
										} else if (var32 == 48) {
											PendingSpawn.varcs.setStringOld(var7[var5], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
										} else if (var32 == 49) {
											var21 = PendingSpawn.varcs.getString(var7[var5]);
											Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var21;
										} else if (var32 == 50) {
											PendingSpawn.varcs.setString(var7[var5], Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
										} else if (var32 == 60) {
											IterableNodeHashTable var37 = var1.switches[var7[var5]];
											IntegerNode var36 = (IntegerNode)var37.get((long)Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
											if (var36 != null) {
												var5 += var36.integer;
											}
										} else {
											Integer var38;
											if (var32 == 74) {
												var38 = PacketBufferNode.field2591.getTitleGroupValue(var7[var5]);
												if (var38 == null) {
													Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var38;
												}
											} else {
												if (var32 != 76) {
													throw new IllegalStateException();
												}

												var38 = class135.varclan.method2297(var7[var5]);
												if (var38 == null) {
													Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var38;
												}
											}
										}
									}
								} else {
									var13 = var7[var5];
									Script var35 = Interpreter.getScript(var13);
									int[] var15 = new int[var35.localIntCount];
									String[] var16 = new String[var35.localStringCount];

									for (var17 = 0; var17 < var35.intArgumentCount; ++var17) {
										var15[var17] = Interpreter.Interpreter_intStack[var17 + (Interpreter.Interpreter_intStackSize - var35.intArgumentCount)];
									}

									for (var17 = 0; var17 < var35.stringArgumentCount; ++var17) {
										var16[var17] = Interpreter.Interpreter_stringStack[var17 + (Interpreter.Interpreter_stringStackSize - var35.stringArgumentCount)];
									}

									Interpreter.Interpreter_intStackSize -= var35.intArgumentCount;
									Interpreter.Interpreter_stringStackSize -= var35.stringArgumentCount;
									ScriptFrame var22 = new ScriptFrame();
									var22.script = var1;
									var22.pc = var5;
									var22.intLocals = Interpreter.Interpreter_intLocals;
									var22.stringLocals = Interpreter.Interpreter_stringLocals;
									Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var22;
									var1 = var35;
									var6 = var35.opcodes;
									var7 = var35.intOperands;
									var5 = -1;
									Interpreter.Interpreter_intLocals = var15;
									Interpreter.Interpreter_stringLocals = var16;
								}
							}
						}
					} catch (Exception var30) {
						var9 = true;
						StringBuilder var26 = new StringBuilder(30);
						var26.append("").append(var1.key).append(" ");

						for (var13 = Interpreter.Interpreter_frameDepth - 1; var13 >= 0; --var13) {
							var26.append("").append(Interpreter.Interpreter_frames[var13].script.key).append(" ");
						}

						var26.append("").append(var8);
						class317.RunException_sendStackTrace(var26.toString(), var30);
						var29 = false;
						break label859;
					}
				} finally {
					if (var29) {
						while (Interpreter.field711.size() > 0) {
							class102 var19 = (class102)Interpreter.field711.remove(0);
							BufferedSource.widgetDefaultMenuAction(var19.method601(), var19.method602(), var19.method603(), var19.method604(), "");
						}

						if (Interpreter.field698) {
							Interpreter.field698 = false;
							class390.method1987();
						}

						if (!var9 && var3 > 0 && var10 >= var3) {
							class317.RunException_sendStackTrace("Warning: Script " + var1.field815 + " finished at op count " + var10 + " of max " + var2, (Throwable)null);
						}

					}
				}

				while (Interpreter.field711.size() > 0) {
					class102 var33 = (class102)Interpreter.field711.remove(0);
					BufferedSource.widgetDefaultMenuAction(var33.method601(), var33.method602(), var33.method603(), var33.method604(), "");
				}

				if (Interpreter.field698) {
					Interpreter.field698 = false;
					class390.method1987();
				}

				if (!var9 && var3 > 0 && var10 >= var3) {
					class317.RunException_sendStackTrace("Warning: Script " + var1.field815 + " finished at op count " + var10 + " of max " + var2, (Throwable)null);
				}

				return;
			}

			while (Interpreter.field711.size() > 0) {
				class102 var40 = (class102)Interpreter.field711.remove(0);
				BufferedSource.widgetDefaultMenuAction(var40.method601(), var40.method602(), var40.method603(), var40.method604(), "");
			}

			if (Interpreter.field698) {
				Interpreter.field698 = false;
				class390.method1987();
			}

			if (!var9 && var3 > 0 && var10 >= var3) {
				class317.RunException_sendStackTrace("Warning: Script " + var1.field815 + " finished at op count " + var10 + " of max " + var2, (Throwable)null);
			}

			return;
		}

		while (Interpreter.field711.size() > 0) {
			class102 var25 = (class102)Interpreter.field711.remove(0);
			BufferedSource.widgetDefaultMenuAction(var25.method601(), var25.method602(), var25.method603(), var25.method604(), "");
		}

		if (Interpreter.field698) {
			Interpreter.field698 = false;
			class390.method1987();
		}

		if (!var9 && var3 > 0 && var10 >= var3) {
			class317.RunException_sendStackTrace("Warning: Script " + var1.field815 + " finished at op count " + var10 + " of max " + var2, (Throwable)null);
		}

	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "1361591852"
	)
	static int method65(int var0, Script var1, boolean var2) {
		if (var0 == 7463) {
			boolean var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
			class10.method38(var3);
			return 1;
		} else {
			return 2;
		}
	}
}
