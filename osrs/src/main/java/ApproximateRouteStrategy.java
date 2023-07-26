import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("ApproximateRouteStrategy")
public class ApproximateRouteStrategy extends RouteStrategy {
	ApproximateRouteStrategy() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIILij;I)Z",
		garbageValue = "2142084611"
	)
	@Export("hasArrived")
	protected boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
		return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lfm;FI)F",
		garbageValue = "451306103"
	)
	static float method348(class130 var0, float var1) {
		if (var0 != null && var0.method717() != 0) {
			if (var1 < (float)var0.field1232[0].field1193) {
				return var0.field1231 == class128.field1217 ? var0.field1232[0].field1192 : Language.method1942(var0, var1, true);
			} else if (var1 > (float)var0.field1232[var0.method717() - 1].field1193) {
				return var0.field1230 == class128.field1217 ? var0.field1232[var0.method717() - 1].field1192 : Language.method1942(var0, var1, false);
			} else if (var0.field1229) {
				return var0.field1232[0].field1192;
			} else {
				class125 var2 = var0.method716(var1);
				boolean var3 = false;
				boolean var4 = false;
				if (var2 == null) {
					return 0.0F;
				} else {
					if (0.0D == (double)var2.field1191 && (double)var2.field1188 == 0.0D) {
						var3 = true;
					} else if (Float.MAX_VALUE == var2.field1191 && Float.MAX_VALUE == var2.field1188) {
						var4 = true;
					} else if (var2.field1187 != null) {
						if (var0.field1226) {
							float var5 = (float)var2.field1193;
							float var9 = var2.field1192;
							float var6 = 0.33333334F * var2.field1191 + var5;
							float var10 = var9 + 0.33333334F * var2.field1188;
							float var8 = (float)var2.field1187.field1193;
							float var12 = var2.field1187.field1192;
							float var7 = var8 - 0.33333334F * var2.field1187.field1190;
							float var11 = var12 - 0.33333334F * var2.field1187.field1189;
							float var13;
							float var14;
							float var15;
							float var16;
							float var17;
							float var18;
							float var19;
							if (var0.field1228) {
								var15 = var10;
								var16 = var11;
								if (var0 != null) {
									var17 = var8 - var5;
									if ((double)var17 != 0.0D) {
										var18 = var6 - var5;
										var19 = var7 - var5;
										float[] var20 = new float[]{var18 / var17, var19 / var17};
										var0.field1227 = 0.33333334F == var20[0] && var20[1] == 0.6666667F;
										float var21 = var20[0];
										float var22 = var20[1];
										if ((double)var20[0] < 0.0D) {
											var20[0] = 0.0F;
										}

										if ((double)var20[1] > 1.0D) {
											var20[1] = 1.0F;
										}

										if ((double)var20[0] > 1.0D || var20[1] < -1.0F) {
											UserComparator3.method675(var20);
										}

										if (var21 != var20[0]) {
											var13 = var17 * var20[0] + var5;
											if ((double)var21 != 0.0D) {
												var15 = (var10 - var9) * var20[0] / var21 + var9;
											}
										}

										if (var22 != var20[1]) {
											var14 = var17 * var20[1] + var5;
											if (1.0D != (double)var22) {
												var16 = (float)((double)var12 - (double)(var12 - var11) * (1.0D - (double)var20[1]) / (1.0D - (double)var22));
											}
										}

										var0.field1234 = var5;
										var0.field1244 = var8;
										ParamComposition.method1001(0.0F, var20[0], var20[1], 1.0F, var0);
										float var23 = var15 - var9;
										float var24 = var16 - var15;
										float var25 = var12 - var16;
										float var26 = var24 - var23;
										var0.field1241 = var25 - var24 - var26;
										var0.field1233 = var26 + var26 + var26;
										var0.field1243 = var23 + var23 + var23;
										var0.field1235 = var9;
									}
								}
							} else if (var0 != null) {
								var0.field1234 = var5;
								var13 = var8 - var5;
								var14 = var12 - var9;
								var15 = var6 - var5;
								var16 = 0.0F;
								var17 = 0.0F;
								if ((double)var15 != 0.0D) {
									var16 = (var10 - var9) / var15;
								}

								var15 = var8 - var7;
								if (0.0D != (double)var15) {
									var17 = (var12 - var11) / var15;
								}

								var18 = 1.0F / (var13 * var13);
								var19 = var13 * var16;
								float var27 = var17 * var13;
								var0.field1242 = var18 * (var27 + var19 - var14 - var14) / var13;
								var0.field1238 = var18 * (var14 + var14 + var14 - var19 - var19 - var27);
								var0.field1239 = var16;
								var0.field1240 = var9;
							}

							var0.field1226 = false;
						}
					} else {
						var3 = true;
					}

					if (var3) {
						return var2.field1192;
					} else if (var4) {
						return (float)var2.field1193 != var1 && var2.field1187 != null ? var2.field1187.field1192 : var2.field1192;
					} else {
						return var0.field1228 ? NewShit.method961(var0, var1) : class165.method863(var0, var1);
					}
				}
			}
		} else {
			return 0.0F;
		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1468252059"
	)
	public static void method349(int var0) {
		MouseHandler.MouseHandler_idleCycles = var0;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZS)I",
		garbageValue = "-12497"
	)
	static int method350(int var0, Script var1, boolean var2) {
		if (var0 == 3300) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.cycle;
			return 1;
		} else {
			int var3;
			int var4;
			if (var0 == 3301) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = PacketBufferNode.method1571(var3, var4);
				return 1;
			} else if (var0 == 3302) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FontName.ItemContainer_getCount(var3, var4);
				return 1;
			} else if (var0 == 3303) {
				Interpreter.Interpreter_intStackSize -= 2;
				var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
				var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ObjectSound.method422(var3, var4);
				return 1;
			} else if (var0 == 3304) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GameEngine.getInvDefinition(var3).size;
				return 1;
			} else if (var0 == 3305) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
				return 1;
			} else if (var0 == 3306) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.levels[var3];
				return 1;
			} else if (var0 == 3307) {
				var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.experience[var3];
				return 1;
			} else {
				int var5;
				if (var0 == 3308) {
					var3 = class36.Client_plane;
					var4 = (class136.localPlayer.x >> 7) + AbstractArchive.baseX;
					var5 = (class136.localPlayer.y >> 7) + class148.baseY;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
					return 1;
				} else if (var0 == 3309) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
					return 1;
				} else if (var0 == 3310) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 >> 28;
					return 1;
				} else if (var0 == 3311) {
					var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & 16383;
					return 1;
				} else if (var0 == 3312) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
					return 1;
				} else if (var0 == 3313) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = PacketBufferNode.method1571(var3, var4);
					return 1;
				} else if (var0 == 3314) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FontName.ItemContainer_getCount(var3, var4);
					return 1;
				} else if (var0 == 3315) {
					Interpreter.Interpreter_intStackSize -= 2;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + 32768;
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ObjectSound.method422(var3, var4);
					return 1;
				} else if (var0 == 3316) {
					if (Client.staffModLevel >= 2) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.staffModLevel;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3317) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.rebootTimer;
					return 1;
				} else if (var0 == 3318) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.worldId;
					return 1;
				} else if (var0 == 3321) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.runEnergy / 100;
					return 1;
				} else if (var0 == 3322) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.weight;
					return 1;
				} else if (var0 == 3323) {
					if (Client.playerMod) {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
					} else {
						Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == 3324) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.worldProperties;
					return 1;
				} else if (var0 == 3325) {
					Interpreter.Interpreter_intStackSize -= 4;
					var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
					var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
					int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
					var3 += var4 << 14;
					var3 += var5 << 28;
					var3 += var6;
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
					return 1;
				} else if (var0 == 3326) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.lastMouseRecordX;
					return 1;
				} else if (var0 == 3327) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.lastMouseRecordY;
					return 1;
				} else if (var0 == 3331) {
					Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.runEnergy;
					return 1;
				} else {
					return 2;
				}
			}
		}
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZI)I",
		garbageValue = "2112043439"
	)
	static int method351(int var0, Script var1, boolean var2) {
		if (var0 == 6200) {
			Interpreter.Interpreter_intStackSize -= 2;
			Client.field634 = (short)GameObject.method1359(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
			if (Client.field634 <= 0) {
				Client.field634 = 256;
			}

			Client.field637 = (short)GameObject.method1359(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
			if (Client.field637 <= 0) {
				Client.field637 = 256;
			}

			return 1;
		} else if (var0 == 6201) {
			Interpreter.Interpreter_intStackSize -= 2;
			Client.zoomHeight = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			if (Client.zoomHeight <= 0) {
				Client.zoomHeight = 256;
			}

			Client.zoomWidth = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (Client.zoomWidth <= 0) {
				Client.zoomWidth = 320;
			}

			return 1;
		} else if (var0 == 6202) {
			Interpreter.Interpreter_intStackSize -= 4;
			Client.field631 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
			if (Client.field631 <= 0) {
				Client.field631 = 1;
			}

			Client.field630 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
			if (Client.field630 <= 0) {
				Client.field630 = 32767;
			} else if (Client.field630 < Client.field631) {
				Client.field630 = Client.field631;
			}

			Client.field633 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
			if (Client.field633 <= 0) {
				Client.field633 = 1;
			}

			Client.field636 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
			if (Client.field636 <= 0) {
				Client.field636 = 32767;
			} else if (Client.field636 < Client.field633) {
				Client.field636 = Client.field633;
			}

			return 1;
		} else if (var0 == 6203) {
			if (Client.viewportWidget != null) {
				class31.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportWidth;
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportHeight;
			} else {
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
				Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
			}

			return 1;
		} else if (var0 == 6204) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomHeight;
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomWidth;
			return 1;
		} else if (var0 == 6205) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class159.method837(Client.field634);
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class159.method837(Client.field637);
			return 1;
		} else if (var0 == 6220) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6221) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
			return 1;
		} else if (var0 == 6222) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeOfferTotalQuantityComparator.canvasWidth;
			return 1;
		} else if (var0 == 6223) {
			Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.canvasHeight;
			return 1;
		} else {
			return 2;
		}
	}
}
