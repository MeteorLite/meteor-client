import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;
import java.util.concurrent.Callable;

@ObfuscatedName("dx")
@Implements("SecureRandomCallable")
public class SecureRandomCallable implements Callable {
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	public static AbstractArchive field851;

	SecureRandomCallable() {
	}

	@Export("call")
	@ObfuscatedName("call")
	public Object call() {
		return HealthBarDefinition.method911();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)[Lun;",
		garbageValue = "0"
	)
	static PrivateChatMode[] method456() {
		return new PrivateChatMode[]{PrivateChatMode.field4304, PrivateChatMode.field4305, PrivateChatMode.field4303};
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2131515534"
	)
	static void method457() {
		Iterator var0 = class316.musicSongs.iterator();

		while (true) {
			MusicSong var1;
			do {
				if (!var0.hasNext()) {
					class316.musicSongs.clear();
					return;
				}

				var1 = (MusicSong)var0.next();
			} while(var1 == null);

			var1.midiPcmStream.clear();
			var1.midiPcmStream.method1657();
			var1.midiPcmStream.setPcmStreamVolume(0);
			var1.midiPcmStream.field2830 = 0;
			int var2 = var1.musicTrackGroupId;
			int var3 = var1.musicTrackFileId;
			Iterator var4 = class316.field2793.iterator();

			while (var4.hasNext()) {
				class322 var5 = (class322)var4.next();
				var5.vmethod1644(var2, var3);
			}
		}
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(ILdt;ZI)I",
		garbageValue = "-732445486"
	)
	static int method458(int var0, Script var1, boolean var2) {
		int var3;
		if (var0 == 6600) {
			var3 = ItemLayer.Client_plane;
			int var9 = (class229.localPlayer.x >> 7) + NewShit.baseX;
			int var5 = (class229.localPlayer.y >> 7) + class101.baseY;
			WorldMapArchiveLoader.getWorldMap().method2408(var3, var9, var5, true);
			return 1;
		} else {
			WorldMapArea var11;
			if (var0 == 6601) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				String var16 = "";
				var11 = WorldMapArchiveLoader.getWorldMap().getMapArea(var3);
				if (var11 != null) {
					var16 = var11.getExternalName();
				}

				Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var16;
				return 1;
			} else if (var0 == 6602) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				WorldMapArchiveLoader.getWorldMap().setCurrentMapAreaId(var3);
				return 1;
			} else if (var0 == 6603) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().getZoomLevel();
				return 1;
			} else if (var0 == 6604) {
				var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
				WorldMapArchiveLoader.getWorldMap().setZoomPercentage(var3);
				return 1;
			} else if (var0 == 6605) {
				Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().isCacheLoaded() ? 1 : 0;
				return 1;
			} else {
				Coord var15;
				if (var0 == 6606) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
					WorldMapArchiveLoader.getWorldMap().setWorldMapPositionTarget(var15.x, var15.y);
					return 1;
				} else if (var0 == 6607) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
					WorldMapArchiveLoader.getWorldMap().setWorldMapPositionTargetInstant(var15.x, var15.y);
					return 1;
				} else if (var0 == 6608) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
					WorldMapArchiveLoader.getWorldMap().jumpToSourceCoord(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == 6609) {
					var15 = new Coord(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
					WorldMapArchiveLoader.getWorldMap().jumpToSourceCoordInstant(var15.plane, var15.x, var15.y);
					return 1;
				} else if (var0 == 6610) {
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().getDisplayX();
					Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().getDisplayY();
					return 1;
				} else {
					WorldMapArea var13;
					if (var0 == 6611) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var13 = WorldMapArchiveLoader.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var13.getOrigin().packed();
						}

						return 1;
					} else if (var0 == 6612) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var13 = WorldMapArchiveLoader.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (var13.getRegionHighX() - var13.getRegionLowX() + 1) * 64;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = (var13.getRegionHighY() - var13.getRegionLowY() + 1) * 64;
						}

						return 1;
					} else if (var0 == 6613) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var13 = WorldMapArchiveLoader.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var13.getRegionLowX() * 64;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var13.getRegionLowY() * 64;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var13.getRegionHighX() * 64 + 64 - 1;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var13.getRegionHighY() * 64 + 64 - 1;
						}

						return 1;
					} else if (var0 == 6614) {
						var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
						var13 = WorldMapArchiveLoader.getWorldMap().getMapArea(var3);
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var13.getZoom();
						}

						return 1;
					} else if (var0 == 6615) {
						var15 = WorldMapArchiveLoader.getWorldMap().getDisplayCoord();
						if (var15 == null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
						} else {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var15.x;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var15.y;
						}

						return 1;
					} else if (var0 == 6616) {
						Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().currentMapAreaId();
						return 1;
					} else if (var0 == 6617) {
						var15 = new Coord(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
						var13 = WorldMapArchiveLoader.getWorldMap().getCurrentMapArea();
						if (var13 == null) {
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
							Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
							return 1;
						} else {
							int[] var14 = var13.position(var15.plane, var15.x, var15.y);
							if (var14 == null) {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
							} else {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var14[0];
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var14[1];
							}

							return 1;
						}
					} else {
						Coord var7;
						if (var0 == 6618) {
							var15 = new Coord(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
							var13 = WorldMapArchiveLoader.getWorldMap().getCurrentMapArea();
							if (var13 == null) {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
								return 1;
							} else {
								var7 = var13.coord(var15.x, var15.y);
								if (var7 == null) {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7.packed();
								}

								return 1;
							}
						} else {
							Coord var12;
							if (var0 == 6619) {
								DbTableType.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
								FriendsChat.method2224(var3, var12, false);
								return 1;
							} else if (var0 == 6620) {
								DbTableType.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
								FriendsChat.method2224(var3, var12, true);
								return 1;
							} else if (var0 == 6621) {
								DbTableType.Interpreter_intStackSize -= 2;
								var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
								var12 = new Coord(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
								var11 = WorldMapArchiveLoader.getWorldMap().getMapArea(var3);
								if (var11 == null) {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = 0;
									return 1;
								} else {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
									return 1;
								}
							} else if (var0 == 6622) {
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().getDisplayWith();
								Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().getDisplayHeight();
								return 1;
							} else if (var0 == 6623) {
								var15 = new Coord(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
								var13 = WorldMapArchiveLoader.getWorldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
								if (var13 == null) {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
								} else {
									Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var13.getId();
								}

								return 1;
							} else if (var0 == 6624) {
								WorldMapArchiveLoader.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6625) {
								WorldMapArchiveLoader.getWorldMap().resetMaxFlashCount();
								return 1;
							} else if (var0 == 6626) {
								WorldMapArchiveLoader.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize]);
								return 1;
							} else if (var0 == 6627) {
								WorldMapArchiveLoader.getWorldMap().resetCyclesPerFlash();
								return 1;
							} else {
								boolean var10;
								if (var0 == 6628) {
									var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
									WorldMapArchiveLoader.getWorldMap().setPerpetualFlash(var10);
									return 1;
								} else if (var0 == 6629) {
									var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
									WorldMapArchiveLoader.getWorldMap().flashElement(var3);
									return 1;
								} else if (var0 == 6630) {
									var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
									WorldMapArchiveLoader.getWorldMap().flashCategory(var3);
									return 1;
								} else if (var0 == 6631) {
									WorldMapArchiveLoader.getWorldMap().stopCurrentFlashes();
									return 1;
								} else if (var0 == 6632) {
									var10 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize] == 1;
									WorldMapArchiveLoader.getWorldMap().setElementsDisabled(var10);
									return 1;
								} else {
									boolean var4;
									if (var0 == 6633) {
										DbTableType.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1] == 1;
										WorldMapArchiveLoader.getWorldMap().disableElement(var3, var4);
										return 1;
									} else if (var0 == 6634) {
										DbTableType.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
										var4 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1] == 1;
										WorldMapArchiveLoader.getWorldMap().setCategoryDisabled(var3, var4);
										return 1;
									} else if (var0 == 6635) {
										Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().getElementsDisabled() ? 1 : 0;
										return 1;
									} else if (var0 == 6636) {
										var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().isElementDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6637) {
										var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
										Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = WorldMapArchiveLoader.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
										return 1;
									} else if (var0 == 6638) {
										DbTableType.Interpreter_intStackSize -= 2;
										var3 = Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize];
										var12 = new Coord(Interpreter.Interpreter_intStack[DbTableType.Interpreter_intStackSize + 1]);
										var7 = WorldMapArchiveLoader.getWorldMap().method2452(var3, var12);
										if (var7 == null) {
											Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
										} else {
											Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var7.packed();
										}

										return 1;
									} else {
										AbstractWorldMapIcon var8;
										if (var0 == 6639) {
											var8 = WorldMapArchiveLoader.getWorldMap().iconStart();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else if (var0 == 6640) {
											var8 = WorldMapArchiveLoader.getWorldMap().iconNext();
											if (var8 == null) {
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
											} else {
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.getElement();
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var8.coord2.packed();
											}

											return 1;
										} else {
											WorldMapElement var6;
											if (var0 == 6693) {
												var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
												var6 = class141.WorldMapElement_get(var3);
												if (var6.name == null) {
													Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = "";
												} else {
													Interpreter.Interpreter_stringStack[++class127.Interpreter_stringStackSize - 1] = var6.name;
												}

												return 1;
											} else if (var0 == 6694) {
												var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
												var6 = class141.WorldMapElement_get(var3);
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6.textSize;
												return 1;
											} else if (var0 == 6695) {
												var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
												var6 = class141.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6.category;
												}

												return 1;
											} else if (var0 == 6696) {
												var3 = Interpreter.Interpreter_intStack[--DbTableType.Interpreter_intStackSize];
												var6 = class141.WorldMapElement_get(var3);
												if (var6 == null) {
													Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = -1;
												} else {
													Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = var6.sprite1;
												}

												return 1;
											} else if (var0 == 6697) {
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class133.worldMapEvent.mapElement;
												return 1;
											} else if (var0 == 6698) {
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class133.worldMapEvent.coord1.packed();
												return 1;
											} else if (var0 == 6699) {
												Interpreter.Interpreter_intStack[++DbTableType.Interpreter_intStackSize - 1] = class133.worldMapEvent.coord2.packed();
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
}