import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.js.JSObject;

import java.util.ArrayList;
import java.util.Date;

@ObfuscatedName("cb")
@Implements("Interpreter")
public class Interpreter {
	@ObfuscatedName("ac")
	@Export("Interpreter_stringLocals")
	static String[] Interpreter_stringLocals;
	@ObfuscatedName("ai")
	@Export("Interpreter_arrayLengths")
	static int[] Interpreter_arrayLengths;
	@ObfuscatedName("az")
	@Export("Interpreter_arrays")
	static int[][] Interpreter_arrays;
	@ObfuscatedName("ap")
	@Export("Interpreter_intStack")
	static int[] Interpreter_intStack;
	@ObfuscatedName("af")
	@Export("Interpreter_stringStack")
	static String[] Interpreter_stringStack;
	@ObfuscatedName("aq")
	@Export("Interpreter_frameDepth")
	static int Interpreter_frameDepth;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "[Lcv;"
	)
	@Export("Interpreter_frames")
	static ScriptFrame[] Interpreter_frames;
	@ObfuscatedName("an")
	static int[] field710;
	@ObfuscatedName("ax")
	@Export("Interpreter_calendar")
	static java.util.Calendar Interpreter_calendar;
	@ObfuscatedName("ah")
	@Export("Interpreter_MONTHS")
	static final String[] Interpreter_MONTHS;
	@ObfuscatedName("ay")
	static boolean field705;
	@ObfuscatedName("aj")
	static boolean field704;
	@ObfuscatedName("av")
	static ArrayList field715;
	@ObfuscatedName("aw")
	static int field708;
	@ObfuscatedName("bk")
	static final double field717;

	static {
		Interpreter_arrayLengths = new int[5];
		Interpreter_arrays = new int[5][5000];
		Interpreter_intStack = new int[1000];
		Interpreter_stringStack = new String[1000];
		Interpreter_frameDepth = 0;
		Interpreter_frames = new ScriptFrame[50];
		Interpreter_calendar = java.util.Calendar.getInstance();
		Interpreter_MONTHS = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		field705 = false;
		field704 = false;
		field715 = new ArrayList();
		field708 = 0;
		field717 = Math.log(2.0D);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)[B",
		garbageValue = "-1581379999"
	)
	static byte[] method418(String var0) {
		boolean var1 = true;
		boolean var2 = true;
		int var3 = "pattern".length();
		int var4 = 0;
		byte[] var5 = new byte[8];

		while (true) {
			int var6 = var4 + var3;
			if (var6 >= var0.length()) {
				return null;
			}

			char var7 = var0.charAt(var6);
			if (var7 == ':') {
				if (var4 == 0) {
					return null;
				}

				byte[] var8 = new byte[var4];
				System.arraycopy(var5, 0, var8, 0, var4);
				return var8;
			}

			if (var5.length == var4) {
				return null;
			}

			if (var7 >= '0' && var7 <= '9') {
				var7 = (char)(var7 - '0');
			} else {
				if (var7 < 'a' || var7 > 'z') {
					return null;
				}

				var7 = (char)(var7 - 'W');
			}

			var5[var4++] = (byte)var7;
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-4"
	)
	public static int method417(int var0) {
		long var2 = ViewportMouse.ViewportMouse_entityTags[var0];
		int var1 = (int)(var2 >>> 0 & 127L);
		return var1;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-86107696"
	)
	static int method419(int var0, Script var1, boolean var2) {
		if (var0 == 5630) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(ILdh;ZI)I",
		garbageValue = "-752327040"
	)
	static int method420(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 6600) {
			var3 = HealthBar.Client_plane;
			int var9 = (VarbitComposition.localPlayer.x >> 7) + UrlRequester.baseX;
			int var5 = (VarbitComposition.localPlayer.y >> 7) + class47.baseY;
			class227.getWorldMap().method2394(var3, var9, var5, true);
			return 1;
		} else {
			WorldMapArea var11;
			if (var0 == 6601) {
				var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				String var16 = "";
				var11 = class227.getWorldMap().getMapArea(var3);
				if (var11 != null) {
					var16 = var11.getExternalName();
				}

				Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var16;
				return 1;
			} else if (var0 == 6602) {
				var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				class227.getWorldMap().setCurrentMapAreaId(var3);
				return 1;
			} else if (var0 == 6603) {
				Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().getZoomLevel();
				return 1;
			} else if (var0 == 6604) {
				var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
				class227.getWorldMap().setZoomPercentage(var3);
				return 1;
			} else if (var0 == 6605) {
				Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().isCacheLoaded() ? 1 : 0;
				return 1;
			} else {
				Coord var15;
				if (var0 == 6606) {
					var15 = new Coord(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
					class227.getWorldMap().setWorldMapPositionTarget(var15.x, var15.y);
					return 1;
				} else if (var0 == 6607) {
					var15 = new Coord(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
					class227.getWorldMap().setWorldMapPositionTargetInstant(var15.x, var15.y);
					return 1;
				} else if (var0 == 6608) {
					var15 = new Coord(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
					class227.getWorldMap().jumpToSourceCoord(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == 6609) {
					var15 = new Coord(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
					class227.getWorldMap().jumpToSourceCoordInstant(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == 6610) {
					Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().getDisplayX();
					Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().getDisplayY();
					return 1;
				} else {
					WorldMapArea var13;
					if (var0 == 6611) {
						var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var13 = class227.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var13.getOrigin().packed();
						}

						return 1;
					} else if (var0 == 6612) {
						var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var13 = class227.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (var13.getRegionHighX() - var13.getRegionLowX() + 1) * 64;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = (var13.getRegionHighY() - var13.getRegionLowY() + 1) * 64;
						}

						return 1;
					} else if (var0 == 6613) {
						var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var13 = class227.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var13.getRegionLowX() * 64;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var13.getRegionLowY() * 64;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var13.getRegionHighX() * 64 + 64 - 1;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var13.getRegionHighY() * 64 + 64 - 1;
						}

						return 1;
					} else if (var0 == 6614) {
						var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
						var13 = class227.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var13.getZoom();
						}

						return 1;
					} else if (var0 == 6615) {
						var15 = class227.getWorldMap().getDisplayCoord();
						if (var15 == null) {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var15.x;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var15.y;
						}

						return 1;
					} else if (var0 == 6616) {
						Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().currentMapAreaId();
						return 1;
					} else if (var0 == 6617) {
						var15 = new Coord(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
						var13 = class227.getWorldMap().getCurrentMapArea();
						if (var13 == null) {
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
							Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else {
							int[] var14 = var13.position(var15.plane, var15.x, var15.y);
							if (var14 == null) {
								Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
								Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
							} else {
								Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var14[0];
								Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var14[1];
							}

							return 1;
						}
					} else {
						Coord var7;
						if (var0 == 6618) {
							var15 = new Coord(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
							var13 = class227.getWorldMap().getCurrentMapArea();
							if (var13 == null) {
								Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
								Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
								return 1;
							} else {
								var7 = var13.coord(var15.x, var15.y);
								if (var7 == null) {
									Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7.packed();
								}

								return 1;
							}
						} else {
							Coord var12;
							if (var0 == 6619) {
								SoundCache.Interpreter_intStackSize -= 2;
								var3 = Interpreter_intStack[SoundCache.Interpreter_intStackSize];
								var12 = new Coord(Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
								class162.method854(var3, var12, false);
								return 1;
							} else if (var0 == 6620) {
								SoundCache.Interpreter_intStackSize -= 2;
								var3 = Interpreter_intStack[SoundCache.Interpreter_intStackSize];
								var12 = new Coord(Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
								class162.method854(var3, var12, true);
								return 1;
							} else if (var0 == 6621) {
								SoundCache.Interpreter_intStackSize -= 2;
								var3 = Interpreter_intStack[SoundCache.Interpreter_intStackSize];
								var12 = new Coord(Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
								var11 = class227.getWorldMap().getMapArea(var3);
								if (var11 == null) {
									Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = 0;
									return 1;
								} else {
									Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
									return 1;
								}
							} else if (var0 == 6622) {
								Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().getDisplayWith();
								Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().getDisplayHeight();
								return 1;
							} else if (var0 == 6623) {
								var15 = new Coord(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
								var13 = class227.getWorldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
								if (var13 == null) {
									Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var13.getId();
								}

								return 1;
							} else if (var0 == 6624) {
								class227.getWorldMap().setMaxFlashCount(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6625) {
								class227.getWorldMap().resetMaxFlashCount();
								return 1;
							} else if (var0 == 6626) {
								class227.getWorldMap().setCyclesPerFlash(Interpreter_intStack[--SoundCache.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6627) {
								class227.getWorldMap().resetCyclesPerFlash();
								return 1;
							} else {
								boolean var10;
								if (var0 == 6628) {
									var10 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
									class227.getWorldMap().setPerpetualFlash(var10);
									return 1;
								} else if (var0 == 6629) {
									var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
									class227.getWorldMap().flashElement(var3);
									return 1;
								} else if (var0 == 6630) {
									var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
									class227.getWorldMap().flashCategory(var3);
									return 1;
								} else if (var0 == 6631) {
									class227.getWorldMap().stopCurrentFlashes();
									return 1;
								} else if (var0 == 6632) {
									var10 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize] == 1;
									class227.getWorldMap().setElementsDisabled(var10);
									return 1;
								} else {
									boolean var4;
									if (var0 == 6633) {
										SoundCache.Interpreter_intStackSize -= 2;
										var3 = Interpreter_intStack[SoundCache.Interpreter_intStackSize];
										var4 = Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1] == 1;
										class227.getWorldMap().disableElement(var3, var4);
										return 1;
									} else if (var0 == 6634) {
										SoundCache.Interpreter_intStackSize -= 2;
										var3 = Interpreter_intStack[SoundCache.Interpreter_intStackSize];
										var4 = Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1] == 1;
										class227.getWorldMap().setCategoryDisabled(var3, var4);
										return 1;
									} else if (var0 == 6635) {
										Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().getElementsDisabled() ? 1 : 0;
										return 1;
									} else if (var0 == 6636) {
										var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
										Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().isElementDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6637) {
										var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
										Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = class227.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6638) {
										SoundCache.Interpreter_intStackSize -= 2;
										var3 = Interpreter_intStack[SoundCache.Interpreter_intStackSize];
										var12 = new Coord(Interpreter_intStack[SoundCache.Interpreter_intStackSize + 1]);
										var7 = class227.getWorldMap().method2438(var3, var12);
										if (var7 == null) {
											Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
										} else {
											Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var7.packed();
										}

										return 1;
									} else {
										AbstractWorldMapIcon var8;
										if (var0 == 6639) {
											var8 = class227.getWorldMap().iconStart();
											if (var8 == null) {
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else if (var0 == 6640) {
											var8 = class227.getWorldMap().iconNext();
											if (var8 == null) {
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else {
											WorldMapElement var6;
											if (var0 == 6693) {
												var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
												var6 = class138.WorldMapElement_get(var3);
												if (var6.name == null) {
													Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = "";
												} else {
													Interpreter_stringStack[++class137.Interpreter_stringStackSize - 1] = var6.name;
												}

												return 1;
											} else if (var0 == 6694) {
												var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
												var6 = class138.WorldMapElement_get(var3);
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var6.textSize;
												return 1;
											} else if (var0 == 6695) {
												var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
												var6 = class138.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var6.category;
												}

												return 1;
											} else if (var0 == 6696) {
												var3 = Interpreter_intStack[--SoundCache.Interpreter_intStackSize];
												var6 = class138.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = var6.sprite1;
												}

												return 1;
											} else if (var0 == 6697) {
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.worldMapEvent.mapElement;
												return 1;
											} else if (var0 == 6698) {
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.worldMapEvent.coord1.packed();
												return 1;
											} else if (var0 == 6699) {
												Interpreter_intStack[++SoundCache.Interpreter_intStackSize - 1] = GrandExchangeOfferOwnWorldComparator.worldMapEvent.coord2.packed();
												return 1;
											} else {
												return 2;
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}

	@ObfuscatedName("oy")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)V",
		garbageValue = "-1076140788"
	)
	static void method421(String var0) {
		MusicPatchPcmStream.param9 = var0;

		try {
			String var1 = class219.client.getParameter(Integer.toString(18));
			String var2 = class219.client.getParameter(Integer.toString(13));
			String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
			String var5;
			if (var0.length() == 0) {
				var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
			} else {
				String var4 = var3 + "; Expires=";
				long var6 = GameEngine.clockNow() + 94608000000L;
				Calendar.Calendar_calendar.setTime(new Date(var6));
				int var8 = Calendar.Calendar_calendar.get(7);
				int var9 = Calendar.Calendar_calendar.get(5);
				int var10 = Calendar.Calendar_calendar.get(2);
				int var11 = Calendar.Calendar_calendar.get(1);
				int var12 = Calendar.Calendar_calendar.get(11);
				int var13 = Calendar.Calendar_calendar.get(12);
				int var14 = Calendar.Calendar_calendar.get(13);
				var5 = Calendar.DAYS_OF_THE_WEEK[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + Calendar.MONTH_NAMES_ENGLISH_GERMAN[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
				var3 = var4 + var5 + "; Max-Age=" + 94608000L;
			}

			Client var16 = class219.client;
			var5 = "document.cookie=\"" + var3 + "\"";
			JSObject.getWindow(var16).eval(var5);
		} catch (Throwable var15) {
		}

	}
}