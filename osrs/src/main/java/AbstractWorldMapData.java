import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ig")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -379785216
	)
	@Export("regionXLow")
	int regionXLow;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -133271552
	)
	@Export("regionYLow")
	int regionYLow;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 1717207833
	)
	@Export("regionX")
	int regionX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1635559809
	)
	@Export("regionY")
	int regionY;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 1974353605
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 1349661509
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("j")
	@ObfuscatedGetter(
		intValue = -2100978787
	)
	@Export("groupId")
	int groupId;
	@ObfuscatedName("v")
	@ObfuscatedGetter(
		intValue = -1614049497
	)
	@Export("fileId")
	int fileId;
	@ObfuscatedName("h")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("t")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("u")
	byte[][][] field2839;
	@ObfuscatedName("d")
	byte[][][] field2834;
	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "[[[[Lie;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("a")
	boolean field2841;
	@ObfuscatedName("l")
	boolean field2842;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field2841 = false;
		this.field2842 = false;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "1696330768"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-2003631521"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field2841 && this.field2842;
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		descriptor = "(Llv;I)V",
		garbageValue = "-378378532"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field2841 = true;
				this.field2842 = true;
			}

		}
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2112715667"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field2839 = null;
		this.field2834 = null;
		this.decorations = null;
		this.field2841 = false;
		this.field2842 = false;
	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "(IILqq;I)V",
		garbageValue = "-1887413247"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method5086(var1, var2, var3, var4);
			} else {
				this.method5083(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("z")
	@ObfuscatedSignature(
		descriptor = "(IILqq;II)V",
		garbageValue = "2046393761"
	)
	void method5086(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
	}

	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "(IILqq;IS)V",
		garbageValue = "173"
	)
	void method5083(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedByte();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var14 = var3.readUnsignedByte();
				if (var14 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var14;
					var11 = var3.readUnsignedByte();
					this.field2839[var9][var1][var2] = (byte)(var11 >> 2);
					this.field2834[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var10 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method8028();
						int var13 = var3.readUnsignedByte();
						var10[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "6826"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "728409939"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lcf;III)V",
		garbageValue = "570808655"
	)
	@Export("runScript")
	static void runScript(ScriptEvent var0, int var1, int var2) {
		Object[] var3 = var0.args;
		Script var4;
		int var20;
		if (GrandExchangeOfferAgeComparator.isWorldMapEvent(var0.type)) {
			class434.worldMapEvent = (WorldMapEvent)var3[0];
			WorldMapElement var5 = class139.WorldMapElement_get(class434.worldMapEvent.mapElement);
			var4 = Renderable.getWorldMapScript(var0.type, var5.objectId, var5.category);
		} else {
			var20 = (Integer)var3[0];
			var4 = class116.getScript(var20);
		}

		if (var4 != null) {
			Interpreter.Interpreter_intStackSize = 0;
			VarbitComposition.Interpreter_stringStackSize = 0;
			var20 = -1;
			int[] var6 = var4.opcodes;
			int[] var7 = var4.intOperands;
			byte var8 = -1;
			Interpreter.Interpreter_frameDepth = 0;
			Interpreter.field843 = false;
			boolean var9 = false;
			int var10 = 0;
			boolean var30 = false;

			label951: {
				label952: {
					try {
						int var13;
						try {
							var30 = true;
							Interpreter.Interpreter_intLocals = new int[var4.localIntCount];
							int var11 = 0;
							Interpreter.Interpreter_stringLocals = new String[var4.localStringCount];
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

									Interpreter.Interpreter_stringLocals[var12++] = var21;
								}
							}

							Interpreter.field849 = var0.field1041;

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

									var14 = Language.method6235(var33, var4, var35);
									switch(var14) {
									case 0:
										var30 = false;
										break label951;
									case 1:
									default:
										break;
									case 2:
										throw new IllegalStateException();
									}
								} else if (var33 == 0) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7[var20];
								} else if (var33 == 1) {
									var13 = var7[var20];
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Varps.Varps_main[var13];
								} else if (var33 == 2) {
									var13 = var7[var20];
									Varps.Varps_main[var13] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
									class269.changeGameOptions(var13);
								} else if (var33 == 3) {
									Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var4.stringOperands[var20];
								} else if (var33 == 6) {
									var20 += var7[var20];
								} else if (var33 == 7) {
									Interpreter.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] != Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 8) {
									Interpreter.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] == Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 9) {
									Interpreter.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] < Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 10) {
									Interpreter.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] > Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 21) {
									if (Interpreter.Interpreter_frameDepth == 0) {
										var30 = false;
										break;
									}

									ScriptFrame var40 = Interpreter.Interpreter_frames[--Interpreter.Interpreter_frameDepth];
									var4 = var40.script;
									var6 = var4.opcodes;
									var7 = var4.intOperands;
									var20 = var40.pc;
									Interpreter.Interpreter_intLocals = var40.intLocals;
									Interpreter.Interpreter_stringLocals = var40.stringLocals;
								} else if (var33 == 25) {
									var13 = var7[var20];
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator8.getVarbit(var13);
								} else if (var33 == 27) {
									var13 = var7[var20];
									class1.method9(var13, Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
								} else if (var33 == 31) {
									Interpreter.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] <= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 32) {
									Interpreter.Interpreter_intStackSize -= 2;
									if (Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] >= Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]) {
										var20 += var7[var20];
									}
								} else if (var33 == 33) {
									Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_intLocals[var7[var20]];
								} else if (var33 == 34) {
									Interpreter.Interpreter_intLocals[var7[var20]] = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
								} else if (var33 == 35) {
									Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = Interpreter.Interpreter_stringLocals[var7[var20]];
								} else if (var33 == 36) {
									Interpreter.Interpreter_stringLocals[var7[var20]] = Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize];
								} else if (var33 == 37) {
									var13 = var7[var20];
									VarbitComposition.Interpreter_stringStackSize -= var13;
									var21 = class297.method5904(Interpreter.Interpreter_stringStack, VarbitComposition.Interpreter_stringStackSize, var13);
									Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var21;
								} else if (var33 == 38) {
									--Interpreter.Interpreter_intStackSize;
								} else if (var33 == 39) {
									--VarbitComposition.Interpreter_stringStackSize;
								} else {
									int var17;
									if (var33 != 40) {
										if (var33 == 42) {
											Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = LoginType.varcs.getInt(var7[var20]);
										} else if (var33 == 43) {
											LoginType.varcs.setInt(var7[var20], Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
										} else if (var33 == 44) {
											var13 = var7[var20] >> 16;
											var14 = var7[var20] & 65535;
											int var24 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
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
											var14 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
											if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
												throw new RuntimeException();
											}

											Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Interpreter.Interpreter_arrays[var13][var14];
										} else if (var33 == 46) {
											var13 = var7[var20];
											Interpreter.Interpreter_intStackSize -= 2;
											var14 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
											if (var14 < 0 || var14 >= Interpreter.Interpreter_arrayLengths[var13]) {
												throw new RuntimeException();
											}

											Interpreter.Interpreter_arrays[var13][var14] = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
										} else {
											String var22;
											if (var33 == 47) {
												var22 = LoginType.varcs.getStringOld(var7[var20]);
												if (var22 == null) {
													var22 = "null";
												}

												Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var22;
											} else if (var33 == 48) {
												LoginType.varcs.setStringOld(var7[var20], Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize]);
											} else if (var33 == 49) {
												var22 = LoginType.varcs.getString(var7[var20]);
												Interpreter.Interpreter_stringStack[++VarbitComposition.Interpreter_stringStackSize - 1] = var22;
											} else if (var33 == 50) {
												LoginType.varcs.setString(var7[var20], Interpreter.Interpreter_stringStack[--VarbitComposition.Interpreter_stringStackSize]);
											} else if (var33 == 60) {
												IterableNodeHashTable var38 = var4.switches[var7[var20]];
												IntegerNode var37 = (IntegerNode)var38.get((long)Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
												if (var37 != null) {
													var20 += var37.integer;
												}
											} else {
												Integer var39;
												if (var33 == 74) {
													var39 = class230.field2798.getTitleGroupValue(var7[var20]);
													if (var39 == null) {
														Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
													} else {
														Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var39;
													}
												} else {
													if (var33 != 76) {
														throw new IllegalStateException();
													}

													var39 = class29.field182.method7265(var7[var20]);
													if (var39 == null) {
														Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
													} else {
														Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var39;
													}
												}
											}
										}
									} else {
										var13 = var7[var20];
										Script var36 = class116.getScript(var13);
										int[] var15 = new int[var36.localIntCount];
										String[] var16 = new String[var36.localStringCount];

										for (var17 = 0; var17 < var36.intArgumentCount; ++var17) {
											var15[var17] = Interpreter.Interpreter_intStack[var17 + (Interpreter.Interpreter_intStackSize - var36.intArgumentCount)];
										}

										for (var17 = 0; var17 < var36.stringArgumentCount; ++var17) {
											var16[var17] = Interpreter.Interpreter_stringStack[var17 + (VarbitComposition.Interpreter_stringStackSize - var36.stringArgumentCount)];
										}

										Interpreter.Interpreter_intStackSize -= var36.intArgumentCount;
										VarbitComposition.Interpreter_stringStackSize -= var36.stringArgumentCount;
										ScriptFrame var23 = new ScriptFrame();
										var23.script = var4;
										var23.pc = var20;
										var23.intLocals = Interpreter.Interpreter_intLocals;
										var23.stringLocals = Interpreter.Interpreter_stringLocals;
										Interpreter.Interpreter_frames[++Interpreter.Interpreter_frameDepth - 1] = var23;
										var4 = var36;
										var6 = var36.opcodes;
										var7 = var36.intOperands;
										var20 = -1;
										Interpreter.Interpreter_intLocals = var15;
										Interpreter.Interpreter_stringLocals = var16;
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
							Clock.RunException_sendStackTrace(var27.toString(), var31);
							var30 = false;
							break label952;
						}
					} finally {
						if (var30) {
							while (Interpreter.field848.size() > 0) {
								class93 var19 = (class93)Interpreter.field848.remove(0);
								ApproximateRouteStrategy.widgetDefaultMenuAction(var19.method2553(), var19.method2554(), var19.method2546(), var19.method2542(), "");
							}

							if (Interpreter.field843) {
								Interpreter.field843 = false;
								class21.method318();
							}

							if (!var9 && var2 > 0 && var10 >= var2) {
								Clock.RunException_sendStackTrace("Warning: Script " + var4.field967 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
							}

						}
					}

					while (Interpreter.field848.size() > 0) {
						class93 var41 = (class93)Interpreter.field848.remove(0);
						ApproximateRouteStrategy.widgetDefaultMenuAction(var41.method2553(), var41.method2554(), var41.method2546(), var41.method2542(), "");
					}

					if (Interpreter.field843) {
						Interpreter.field843 = false;
						class21.method318();
					}

					if (!var9 && var2 > 0 && var10 >= var2) {
						Clock.RunException_sendStackTrace("Warning: Script " + var4.field967 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
					}

					return;
				}

				while (Interpreter.field848.size() > 0) {
					class93 var26 = (class93)Interpreter.field848.remove(0);
					ApproximateRouteStrategy.widgetDefaultMenuAction(var26.method2553(), var26.method2554(), var26.method2546(), var26.method2542(), "");
				}

				if (Interpreter.field843) {
					Interpreter.field843 = false;
					class21.method318();
				}

				if (!var9 && var2 > 0 && var10 >= var2) {
					Clock.RunException_sendStackTrace("Warning: Script " + var4.field967 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
				}

				return;
			}

			while (Interpreter.field848.size() > 0) {
				class93 var34 = (class93)Interpreter.field848.remove(0);
				ApproximateRouteStrategy.widgetDefaultMenuAction(var34.method2553(), var34.method2554(), var34.method2546(), var34.method2542(), "");
			}

			if (Interpreter.field843) {
				Interpreter.field843 = false;
				class21.method318();
			}

			if (!var9 && var2 > 0 && var10 >= var2) {
				Clock.RunException_sendStackTrace("Warning: Script " + var4.field967 + " finished at op count " + var10 + " of max " + var1, (Throwable)null);
			}

		}
	}

	@ObfuscatedName("mz")
	@ObfuscatedSignature(
		descriptor = "(IIIZI)V",
		garbageValue = "-668830240"
	)
	public static void method5107(int var0, int var1, int var2, boolean var3) {
		PacketBufferNode var4 = class120.getPacketBufferNode(ClientPacket.field3008, Client.packetWriter.isaacCipher);
		var4.packetBuffer.method7952(var2);
		var4.packetBuffer.writeShort(var1);
		var4.packetBuffer.method7971(0);
		var4.packetBuffer.method7961(var0);
		Client.packetWriter.addNode(var4);
	}
}
