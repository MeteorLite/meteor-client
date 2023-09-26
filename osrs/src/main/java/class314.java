import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@ObfuscatedName("mj")
public final class class314 {
	@ObfuscatedName("ak")
	static final HashMap field2772;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lhu;"
	)
	@Export("clock")
	static Clock clock;

	static {
		field2772 = new HashMap();
		java.util.Calendar.getInstance(getMethodName("Europe/London"));
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/util/TimeZone;",
		garbageValue = "-1775212150"
	)
	@Export("getMethodName")
	static TimeZone getMethodName(String var0) {
		synchronized(field2772) {
			TimeZone var2 = (TimeZone)field2772.get(var0);
			if (var2 == null) {
				var2 = TimeZone.getTimeZone(var0);
				field2772.put(var0, var2);
			}

			return var2;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "27"
	)
	public static boolean method1650(int var0) {
		return var0 >= WorldMapDecorationType.field3171.id && var0 <= WorldMapDecorationType.field3166.id;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/Date;",
		garbageValue = "-13"
	)
	static Date method1652() {
		java.util.Calendar var0 = java.util.Calendar.getInstance();
		var0.set(2, 0);
		var0.set(5, 1);
		var0.set(1, 1900);
		return var0.getTime();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IIIIIILjt;Lih;I)V",
		garbageValue = "-1043876293"
	)
	@Export("addObjects")
	static final void addObjects(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
		if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
			if (var0 < Tiles.Tiles_minPlane) {
				Tiles.Tiles_minPlane = var0;
			}

			ObjectComposition var8 = class91.getObjectDefinition(var3);
			int var9;
			int var10;
			if (var4 != 1 && var4 != 3) {
				var9 = var8.sizeX;
				var10 = var8.sizeY;
			} else {
				var9 = var8.sizeY;
				var10 = var8.sizeX;
			}

			int var11;
			int var12;
			if (var9 + var1 <= 104) {
				var11 = (var9 >> 1) + var1;
				var12 = (var9 + 1 >> 1) + var1;
			} else {
				var11 = var1;
				var12 = var1 + 1;
			}

			int var13;
			int var14;
			if (var10 + var2 <= 104) {
				var13 = (var10 >> 1) + var2;
				var14 = var2 + (var10 + 1 >> 1);
			} else {
				var13 = var2;
				var14 = var2 + 1;
			}

			int[][] var15 = Tiles.Tiles_heights[var0];
			int var16 = var15[var12][var13] + var15[var11][var13] + var15[var11][var14] + var15[var12][var14] >> 2;
			int var17 = (var1 << 7) + (var9 << 6);
			int var18 = (var2 << 7) + (var10 << 6);
			long var19 = GrandExchangeOfferAgeComparator.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
			int var21 = var5 + (var4 << 6);
			if (var8.int3 == 1) {
				var21 += 256;
			}

			if (var8.hasSound()) {
				LoginScreenAnimation.method529(var0, var1, var2, var8, var4);
			}

			Object var22;
			if (var5 == 22) {
				if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
					if (var8.animationId == -1 && var8.transforms == null) {
						var22 = var8.getEntity(22, var4, var15, var17, var16, var18);
					} else {
						var22 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
					}

					var6.newFloorDecoration(var0, var1, var2, var16, (Renderable)var22, var19, var21);
					if (var8.interactType == 1 && var7 != null) {
						var7.setBlockedByFloorDec(var1, var2);
					}

				}
			} else {
				int var31;
				if (var5 != 10 && var5 != 11) {
					int[] var10000;
					if (var5 >= 12) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
						}

						var6.method1287(var0, var1, var2, var16, 1, 1, (Renderable)var22, 0, var19, var21);
						if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
							var10000 = UserComparator6.field1191[var0][var1];
							var10000[var2] |= 2340;
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
						}

					} else if (var5 == 0) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(0, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field844[var4], 0, var19, var21);
						if (var4 == 0) {
							if (var8.clipped) {
								Tiles.field835[var0][var1][var2] = 50;
								Tiles.field835[var0][var1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = UserComparator6.field1191[var0][var1];
								var10000[var2] |= 585;
							}
						} else if (var4 == 1) {
							if (var8.clipped) {
								Tiles.field835[var0][var1][var2 + 1] = 50;
								Tiles.field835[var0][var1 + 1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = UserComparator6.field1191[var0][var1];
								var10000[1 + var2] |= 1170;
							}
						} else if (var4 == 2) {
							if (var8.clipped) {
								Tiles.field835[var0][var1 + 1][var2] = 50;
								Tiles.field835[var0][var1 + 1][var2 + 1] = 50;
							}

							if (var8.modelClipped) {
								var10000 = UserComparator6.field1191[var0][var1 + 1];
								var10000[var2] |= 585;
							}
						} else if (var4 == 3) {
							if (var8.clipped) {
								Tiles.field835[var0][var1][var2] = 50;
								Tiles.field835[var0][var1 + 1][var2] = 50;
							}

							if (var8.modelClipped) {
								var10000 = UserComparator6.field1191[var0][var1];
								var10000[var2] |= 1170;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method1156(var1, var2, var5, var4, var8.boolean1);
						}

						if (var8.int2 != 16) {
							var6.method1293(var0, var1, var2, var8.int2);
						}

					} else if (var5 == 1) {
						if (var8.animationId == -1 && var8.transforms == null) {
							var22 = var8.getEntity(1, var4, var15, var17, var16, var18);
						} else {
							var22 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
						}

						var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field843[var4], 0, var19, var21);
						if (var8.clipped) {
							if (var4 == 0) {
								Tiles.field835[var0][var1][var2 + 1] = 50;
							} else if (var4 == 1) {
								Tiles.field835[var0][var1 + 1][var2 + 1] = 50;
							} else if (var4 == 2) {
								Tiles.field835[var0][var1 + 1][var2] = 50;
							} else if (var4 == 3) {
								Tiles.field835[var0][var1][var2] = 50;
							}
						}

						if (var8.interactType != 0 && var7 != null) {
							var7.method1156(var1, var2, var5, var4, var8.boolean1);
						}

					} else {
						int var28;
						if (var5 == 2) {
							var28 = var4 + 1 & 3;
							Object var23;
							Object var24;
							if (var8.animationId == -1 && var8.transforms == null) {
								var23 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
								var24 = var8.getEntity(2, var28, var15, var17, var16, var18);
							} else {
								var23 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								var24 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
							}

							var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var23, (Renderable)var24, Tiles.field844[var4], Tiles.field844[var28], var19, var21);
							if (var8.modelClipped) {
								if (var4 == 0) {
									var10000 = UserComparator6.field1191[var0][var1];
									var10000[var2] |= 585;
									var10000 = UserComparator6.field1191[var0][var1];
									var10000[var2 + 1] |= 1170;
								} else if (var4 == 1) {
									var10000 = UserComparator6.field1191[var0][var1];
									var10000[var2 + 1] |= 1170;
									var10000 = UserComparator6.field1191[var0][var1 + 1];
									var10000[var2] |= 585;
								} else if (var4 == 2) {
									var10000 = UserComparator6.field1191[var0][var1 + 1];
									var10000[var2] |= 585;
									var10000 = UserComparator6.field1191[var0][var1];
									var10000[var2] |= 1170;
								} else if (var4 == 3) {
									var10000 = UserComparator6.field1191[var0][var1];
									var10000[var2] |= 1170;
									var10000 = UserComparator6.field1191[var0][var1];
									var10000[var2] |= 585;
								}
							}

							if (var8.interactType != 0 && var7 != null) {
								var7.method1156(var1, var2, var5, var4, var8.boolean1);
							}

							if (var8.int2 != 16) {
								var6.method1293(var0, var1, var2, var8.int2);
							}

						} else if (var5 == 3) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(3, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
							}

							var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field843[var4], 0, var19, var21);
							if (var8.clipped) {
								if (var4 == 0) {
									Tiles.field835[var0][var1][var2 + 1] = 50;
								} else if (var4 == 1) {
									Tiles.field835[var0][var1 + 1][var2 + 1] = 50;
								} else if (var4 == 2) {
									Tiles.field835[var0][var1 + 1][var2] = 50;
								} else if (var4 == 3) {
									Tiles.field835[var0][var1][var2] = 50;
								}
							}

							if (var8.interactType != 0 && var7 != null) {
								var7.method1156(var1, var2, var5, var4, var8.boolean1);
							}

						} else if (var5 == 9) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
							}

							var6.method1287(var0, var1, var2, var16, 1, 1, (Renderable)var22, 0, var19, var21);
							if (var8.interactType != 0 && var7 != null) {
								var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
							}

							if (var8.int2 != 16) {
								var6.method1293(var0, var1, var2, var8.int2);
							}

						} else if (var5 == 4) {
							if (var8.animationId == -1 && var8.transforms == null) {
								var22 = var8.getEntity(4, var4, var15, var17, var16, var18);
							} else {
								var22 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
							}

							var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field844[var4], 0, 0, 0, var19, var21);
						} else {
							Object var25;
							long var29;
							if (var5 == 5) {
								var28 = 16;
								var29 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (var29 != 0L) {
									var28 = class91.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var29)).int2;
								}

								if (var8.animationId == -1 && var8.transforms == null) {
									var25 = var8.getEntity(4, var4, var15, var17, var16, var18);
								} else {
									var25 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, Tiles.field844[var4], 0, var28 * Tiles.field847[var4], var28 * Tiles.field845[var4], var19, var21);
							} else if (var5 == 6) {
								var28 = 8;
								var29 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (var29 != 0L) {
									var28 = class91.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var29)).int2 / 2;
								}

								if (var8.animationId == -1 && var8.transforms == null) {
									var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
								} else {
									var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, 256, var4, var28 * Tiles.field848[var4], var28 * Tiles.field846[var4], var19, var21);
							} else if (var5 == 7) {
								var31 = var4 + 2 & 3;
								if (var8.animationId == -1 && var8.transforms == null) {
									var22 = var8.getEntity(4, var31 + 4, var15, var17, var16, var18);
								} else {
									var22 = new DynamicObject(var3, 4, var31 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, 256, var31, 0, 0, var19, var21);
							} else if (var5 == 8) {
								var28 = 8;
								var29 = var6.getBoundaryObjectTag(var0, var1, var2);
								if (var29 != 0L) {
									var28 = class91.getObjectDefinition(SecureRandomFuture.Entity_unpackID(var29)).int2 / 2;
								}

								int var27 = var4 + 2 & 3;
								Object var26;
								if (var8.animationId == -1 && var8.transforms == null) {
									var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
									var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
								} else {
									var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
									var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
								}

								var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)var26, 256, var4, var28 * Tiles.field848[var4], var28 * Tiles.field846[var4], var19, var21);
							}
						}
					}
				} else {
					if (var8.animationId == -1 && var8.transforms == null) {
						var22 = var8.getEntity(10, var4, var15, var17, var16, var18);
					} else {
						var22 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
					}

					if (var22 != null && var6.method1287(var0, var1, var2, var16, var9, var10, (Renderable)var22, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
						var31 = 15;
						if (var22 instanceof Model) {
							var31 = ((Model)var22).method1363() / 4;
							if (var31 > 30) {
								var31 = 30;
							}
						}

						for (int var32 = 0; var32 <= var9; ++var32) {
							for (int var33 = 0; var33 <= var10; ++var33) {
								if (var31 > Tiles.field835[var0][var32 + var1][var33 + var2]) {
									Tiles.field835[var0][var32 + var1][var33 + var2] = (byte)var31;
								}
							}
						}
					}

					if (var8.interactType != 0 && var7 != null) {
						var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
					}

				}
			}
		}
	}

	@ObfuscatedName("hh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-176913511"
	)
	static void method1653() {
		int var0;
		if (Client.field416 == class94.field929) {
			class10.scene = new Scene(4, 104, 104, Tiles.Tiles_heights);

			for (var0 = 0; var0 < 4; ++var0) {
				Client.collisionMaps[var0] = new CollisionMap(104, 104);
			}

			SpriteMask.sceneMinimapSprite = new SpritePixels(512, 512);
			Login.Login_loadingText = "Starting game engine...";
			Login.Login_loadingPercent = 5;
			Client.field416 = class94.field934;
		} else if (class94.field934 == Client.field416) {
			Login.Login_loadingText = "Prepared visibility map";
			Login.Login_loadingPercent = 10;
			Client.field416 = class94.field933;
		} else {
			Archive var39;
			if (class94.field933 == Client.field416) {
				class92.field888 = class202.newArchive(0, false, true, true, false);
				class199.field1567 = class202.newArchive(1, false, true, true, false);
				SoundSystem.archive2 = class202.newArchive(2, true, false, true, false);
				AbstractByteArrayCopier.field3136 = class202.newArchive(3, false, true, true, false);
				class469.field3930 = class202.newArchive(4, false, true, true, false);
				class198.archive9 = class202.newArchive(5, true, true, true, false);
				CollisionMap.archive6 = class202.newArchive(6, true, true, true, false);
				GrandExchangeOfferOwnWorldComparator.field361 = class202.newArchive(7, false, true, true, false);
				class199.archive8 = class202.newArchive(8, false, true, true, false);
				class241.field2052 = class202.newArchive(9, false, true, true, false);
				class190.archive10 = class202.newArchive(10, false, true, true, false);
				Language.field3643 = class202.newArchive(11, false, true, true, false);
				SongTask.archive12 = class202.newArchive(12, false, true, true, false);
				class27.archive13 = class202.newArchive(13, true, false, true, false);
				ArchiveDiskAction.field3538 = class202.newArchive(14, false, true, true, false);
				class317.field2776 = class202.newArchive(15, false, true, true, false);
				WorldMapDecorationType.field3154 = class202.newArchive(17, true, true, true, false);
				class358.field3177 = class202.newArchive(18, false, true, true, false);
				AABB.field2123 = class202.newArchive(19, false, true, true, false);
				HorizontalAlignment.field1584 = class202.newArchive(20, false, true, true, false);
				class313.field2770 = class202.newArchive(21, false, true, true, false);
				ArchiveDisk var36 = null;
				if (JagexCache.JagexCache_dat2File != null) {
					var36 = new ArchiveDisk(22, JagexCache.JagexCache_dat2File, UserComparator8.JagexCache_idxFiles[22], 1000000);
				}

				var39 = new Archive(var36, UserComparator10.field1188, class59.field309, 22, false, true, true, true, true);
				class319.field2799 = var39;
				Login.Login_loadingText = "Connecting to update server";
				Login.Login_loadingPercent = 20;
				Client.field416 = class94.field941;
			} else if (class94.field941 == Client.field416) {
				byte var33 = 0;
				var0 = var33 + class92.field888.percentage() * 4 / 100;
				var0 += class199.field1567.percentage() * 4 / 100;
				var0 += SoundSystem.archive2.percentage() * 2 / 100;
				var0 += AbstractByteArrayCopier.field3136.percentage() * 2 / 100;
				var0 += class469.field3930.percentage() * 6 / 100;
				var0 += class198.archive9.percentage() * 4 / 100;
				var0 += CollisionMap.archive6.percentage() * 2 / 100;
				var0 += GrandExchangeOfferOwnWorldComparator.field361.percentage() * 54 / 100;
				var0 += class199.archive8.percentage() * 2 / 100;
				var0 += class241.field2052.percentage() * 2 / 100;
				var0 += class190.archive10.percentage() * 2 / 100;
				var0 += Language.field3643.percentage() * 2 / 100;
				var0 += SongTask.archive12.percentage() * 2 / 100;
				var0 += class27.archive13.percentage() * 2 / 100;
				var0 += ArchiveDiskAction.field3538.percentage() * 2 / 100;
				var0 += class317.field2776.percentage() * 2 / 100;
				var0 += AABB.field2123.percentage() / 100;
				var0 += class358.field3177.percentage() / 100;
				var0 += HorizontalAlignment.field1584.percentage() / 100;
				var0 += class313.field2770.percentage() / 100;
				var0 += class319.field2799.percentage() / 100;
				var0 += WorldMapDecorationType.field3154.method1915() && WorldMapDecorationType.field3154.isFullyLoaded() ? 1 : 0;
				if (var0 != 100) {
					if (var0 != 0) {
						Login.Login_loadingText = "Checking for updates - " + var0 + "%";
					}

					Login.Login_loadingPercent = 30;
				} else {
					MusicSong.method1732(class92.field888, "Animations");
					MusicSong.method1732(class199.field1567, "Skeletons");
					MusicSong.method1732(class469.field3930, "Sound FX");
					MusicSong.method1732(class198.archive9, "Maps");
					MusicSong.method1732(CollisionMap.archive6, "Music Tracks");
					MusicSong.method1732(GrandExchangeOfferOwnWorldComparator.field361, "Models");
					MusicSong.method1732(class199.archive8, "Sprites");
					MusicSong.method1732(Language.field3643, "Music Jingles");
					MusicSong.method1732(ArchiveDiskAction.field3538, "Music Samples");
					MusicSong.method1732(class317.field2776, "Music Patches");
					MusicSong.method1732(AABB.field2123, "World Map");
					MusicSong.method1732(class358.field3177, "World Map Geography");
					MusicSong.method1732(HorizontalAlignment.field1584, "World Map Ground");
					class241.field2053 = new GraphicsDefaults();
					class241.field2053.decode(WorldMapDecorationType.field3154);
					Login.Login_loadingText = "Loaded update list";
					Login.Login_loadingPercent = 30;
					Client.field416 = class94.field936;
				}
			} else {
				int var5;
				if (class94.field936 == Client.field416) {
					class133.method720(22050, !Client.isLowDetail, 2);
					ArrayList var41 = new ArrayList(3);
					TaskHandler var28 = GameEngine.taskHandler;
					short var29 = 2048;
					if (var29 < 256) {
						var29 = 256;
					}

					PcmPlayer var34;
					try {
						PcmPlayer var25 = class16.pcmPlayerProvider.player();
						var25.samples = new int[(class306.PcmPlayer_stereo ? 2 : 1) * 256];
						var25.field195 = var29;
						var25.init();
						var25.capacity = (var29 & -1024) + 1024;
						if (var25.capacity > 16384) {
							var25.capacity = 16384;
						}

						var25.open(var25.capacity);
						if (class225.field1884 > 0 && UserComparator4.soundSystem == null) {
							UserComparator4.soundSystem = new SoundSystem();
							class353.soundSystemExecutor = Executors.newScheduledThreadPool(1);
							class353.soundSystemExecutor.scheduleAtFixedRate(UserComparator4.soundSystem, 0L, 10L, TimeUnit.MILLISECONDS);
						}

						if (UserComparator4.soundSystem != null) {
							if (UserComparator4.soundSystem.players[0] != null) {
								throw new IllegalArgumentException();
							}

							UserComparator4.soundSystem.players[0] = var25;
						}

						var34 = var25;
					} catch (Throwable var22) {
						var34 = new PcmPlayer();
					}

					class171.pcmPlayer1 = var34;
					class140.pcmStreamMixer = new PcmStreamMixer();
					PcmStreamMixer var27 = new PcmStreamMixer();
					var27.addSubStream(class140.pcmStreamMixer);

					for (var5 = 0; var5 < 3; ++var5) {
						MidiPcmStream var31 = new MidiPcmStream();
						var31.method1671(9, 128);
						var27.addSubStream(var31);
						var41.add(var31);
					}

					class171.pcmPlayer1.setStream(var27);
					class1.method2(class317.field2776, ArchiveDiskAction.field3538, class469.field3930, var41);
					class136.decimator = new Decimator(22050, PcmPlayer.field179);
					Login.Login_loadingText = "Prepared sound engine";
					Login.Login_loadingPercent = 35;
					Client.field416 = class94.field931;
					class353.field3142 = new Fonts(class199.archive8, class27.archive13);
				} else {
					int var14;
					if (class94.field931 == Client.field416) {
						FontName[] var40 = new FontName[]{FontName.FontName_plain12, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_verdana13};
						var14 = var40.length;
						Fonts var26 = class353.field3142;
						FontName[] var42 = new FontName[]{FontName.FontName_plain12, FontName.FontName_verdana11, FontName.FontName_verdana15, FontName.FontName_bold12, FontName.FontName_plain11, FontName.FontName_verdana13};
						Client.fontsMap = var26.createMap(var42);
						if (Client.fontsMap.size() < var14) {
							Login.Login_loadingText = "Loading fonts - " + Client.fontsMap.size() * 100 / var14 + "%";
							Login.Login_loadingPercent = 40;
						} else {
							class14.fontPlain11 = (Font)Client.fontsMap.get(FontName.FontName_plain11);
							UserComparator6.fontPlain12 = (Font)Client.fontsMap.get(FontName.FontName_plain12);
							SoundCache.fontBold12 = (Font)Client.fontsMap.get(FontName.FontName_bold12);
							Skeleton.field2060 = Client.field641.get();
							Login.Login_loadingText = "Loaded fonts";
							Login.Login_loadingPercent = 40;
							Client.field416 = class94.field938;
						}
					} else {
						Archive var2;
						int var3;
						if (Client.field416 == class94.field938) {
							var0 = Archive.method1922(class190.archive10, class199.archive8);
							var2 = class199.archive8;
							var3 = Login.field769.length + Login.field767.length;
							String[] var24 = Login.field768;

							for (var5 = 0; var5 < var24.length; ++var5) {
								String var30 = var24[var5];
								if (var2.getGroupId(var30) != -1) {
									++var3;
								}
							}

							if (var0 < var3) {
								Login.Login_loadingText = "Loading title screen - " + var0 * 100 / var3 + "%";
								Login.Login_loadingPercent = 50;
							} else {
								Login.Login_loadingText = "Loaded title screen";
								Login.Login_loadingPercent = 50;
								DefaultsGroup.updateGameState(5);
								Client.field416 = class94.field928;
							}
						} else if (class94.field928 == Client.field416) {
							if (!SoundSystem.archive2.isFullyLoaded()) {
								Login.Login_loadingText = "Loading config - " + SoundSystem.archive2.loadPercent() + "%";
								Login.Login_loadingPercent = 60;
							} else if (!class313.field2770.isFullyLoaded()) {
								Login.Login_loadingText = "Loading config - " + (80 + SongTask.archive12.loadPercent() / 6) + "%";
								Login.Login_loadingPercent = 60;
							} else {
								class191.method958(SoundSystem.archive2);
								var39 = SoundSystem.archive2;
								FloorUnderlayDefinition.FloorUnderlayDefinition_archive = var39;
								class145.method763(SoundSystem.archive2, GrandExchangeOfferOwnWorldComparator.field361);
								class517.method2530(SoundSystem.archive2, GrandExchangeOfferOwnWorldComparator.field361, Client.isLowDetail);
								Archive var32 = SoundSystem.archive2;
								var2 = GrandExchangeOfferOwnWorldComparator.field361;
								NPCComposition.NpcDefinition_archive = var32;
								NPCComposition.field1595 = var2;
								class142.method753(SoundSystem.archive2);
								Projectile.method436(SoundSystem.archive2, GrandExchangeOfferOwnWorldComparator.field361, Client.isMembersWorld, class14.fontPlain11);
								class138.method732(SoundSystem.archive2, class92.field888, class199.field1567);
								Archive var15 = SoundSystem.archive2;
								Archive var4 = GrandExchangeOfferOwnWorldComparator.field361;
								SpotAnimationDefinition.SpotAnimationDefinition_archive = var15;
								SpotAnimationDefinition.SpotAnimationDefinition_modelArchive = var4;
								Archive var43 = SoundSystem.archive2;
								VarbitComposition.VarbitDefinition_archive = var43;
								Archive var6 = SoundSystem.archive2;
								VarpDefinition.VarpDefinition_archive = var6;
								VarpDefinition.field1501 = VarpDefinition.VarpDefinition_archive.getGroupFileCount(16);
								class33.field89 = new WidgetDefinition(AbstractByteArrayCopier.field3136, GrandExchangeOfferOwnWorldComparator.field361, class199.archive8, class27.archive13, class319.field2799);
								Decimator.method313(SoundSystem.archive2);
								class275.method1537(SoundSystem.archive2);
								class135.method727(SoundSystem.archive2);
								Message.method338(SoundSystem.archive2);
								FloorOverlayDefinition.method1108(SoundSystem.archive2);
								MilliClock.method935(SoundSystem.archive2);
								Varcs.method625(SoundSystem.archive2);
								HealthBarDefinition.Widget_cachedModels = new class512(UrlRequester.field1163, 54, WorldMapLabelSize.clientLanguage, SoundSystem.archive2);
								class53.Widget_cachedFonts = new class512(UrlRequester.field1163, 47, WorldMapLabelSize.clientLanguage, SoundSystem.archive2);
								class33.varcs = new Varcs();
								UserComparator9.method680(SoundSystem.archive2, class199.archive8, class27.archive13);
								Archive var35 = SoundSystem.archive2;
								Archive var8 = class199.archive8;
								HealthBarDefinition.HealthBarDefinition_archive = var35;
								HealthBarDefinition.field1549 = var8;
								Archive var37 = SoundSystem.archive2;
								Archive var10 = class199.archive8;
								WorldMapElement.WorldMapElement_archive = var10;
								if (var37.isFullyLoaded()) {
									DevicePcmPlayerProvider.WorldMapElement_count = var37.getGroupFileCount(35);
									WorldMapElement.WorldMapElement_cached = new WorldMapElement[DevicePcmPlayerProvider.WorldMapElement_count];

									for (int var11 = 0; var11 < DevicePcmPlayerProvider.WorldMapElement_count; ++var11) {
										byte[] var12 = var37.takeFile(35, var11);
										WorldMapElement.WorldMapElement_cached[var11] = new WorldMapElement(var11);
										if (var12 != null) {
											WorldMapElement.WorldMapElement_cached[var11].decode(new Buffer(var12));
											WorldMapElement.WorldMapElement_cached[var11].method967();
										}
									}
								}

								Login.Login_loadingText = "Loaded config";
								Login.Login_loadingPercent = 60;
								Client.field416 = class94.field935;
							}
						} else if (class94.field935 == Client.field416) {
							var0 = 0;
							if (JSException.compass == null) {
								JSException.compass = class47.SpriteBuffer_getSprite(class199.archive8, class241.field2053.compass, 0);
							} else {
								++var0;
							}

							if (ParamComposition.redHintArrowSprite == null) {
								ParamComposition.redHintArrowSprite = class47.SpriteBuffer_getSprite(class199.archive8, class241.field2053.field3881, 0);
							} else {
								++var0;
							}

							IndexedSprite[] var1;
							if (KitDefinition.mapSceneSprites == null) {
								var2 = class199.archive8;
								var3 = class241.field2053.mapScenes;
								if (!class164.method862(var2, var3, 0)) {
									var1 = null;
								} else {
									var1 = class512.method2517();
								}

								KitDefinition.mapSceneSprites = var1;
							} else {
								++var0;
							}

							SpritePixels var7;
							byte[] var9;
							SpritePixels[] var16;
							int var17;
							int var18;
							int var19;
							SpritePixels[] var23;
							if (UserComparator4.headIconPkSprites == null) {
								var2 = class199.archive8;
								var3 = class241.field2053.headIconsPk;
								if (!class164.method862(var2, var3, 0)) {
									var23 = null;
								} else {
									var16 = new SpritePixels[class544.SpriteBuffer_spriteCount];
									var17 = 0;

									while (true) {
										if (var17 >= class544.SpriteBuffer_spriteCount) {
											class407.method2062();
											var23 = var16;
											break;
										}

										var7 = var16[var17] = new SpritePixels();
										var7.width = class159.SpriteBuffer_spriteWidth;
										var7.height = class500.SpriteBuffer_spriteHeight;
										var7.xOffset = class326.SpriteBuffer_xOffsets[var17];
										var7.yOffset = ModelData0.SpriteBuffer_yOffsets[var17];
										var7.subWidth = class59.SpriteBuffer_spriteWidths[var17];
										var7.subHeight = class544.SpriteBuffer_spriteHeights[var17];
										var18 = var7.subWidth * var7.subHeight;
										var9 = AddRequestTask.SpriteBuffer_pixels[var17];
										var7.pixels = new int[var18];

										for (var19 = 0; var19 < var18; ++var19) {
											var7.pixels[var19] = class372.SpriteBuffer_spritePalette[var9[var19] & 255];
										}

										++var17;
									}
								}

								UserComparator4.headIconPkSprites = var23;
							} else {
								++var0;
							}

							if (class157.headIconPrayerSprites == null) {
								var2 = class199.archive8;
								var3 = class241.field2053.field3883;
								if (!class164.method862(var2, var3, 0)) {
									var23 = null;
								} else {
									var16 = new SpritePixels[class544.SpriteBuffer_spriteCount];
									var17 = 0;

									while (true) {
										if (var17 >= class544.SpriteBuffer_spriteCount) {
											class407.method2062();
											var23 = var16;
											break;
										}

										var7 = var16[var17] = new SpritePixels();
										var7.width = class159.SpriteBuffer_spriteWidth;
										var7.height = class500.SpriteBuffer_spriteHeight;
										var7.xOffset = class326.SpriteBuffer_xOffsets[var17];
										var7.yOffset = ModelData0.SpriteBuffer_yOffsets[var17];
										var7.subWidth = class59.SpriteBuffer_spriteWidths[var17];
										var7.subHeight = class544.SpriteBuffer_spriteHeights[var17];
										var18 = var7.subHeight * var7.subWidth;
										var9 = AddRequestTask.SpriteBuffer_pixels[var17];
										var7.pixels = new int[var18];

										for (var19 = 0; var19 < var18; ++var19) {
											var7.pixels[var19] = class372.SpriteBuffer_spritePalette[var9[var19] & 255];
										}

										++var17;
									}
								}

								class157.headIconPrayerSprites = var23;
							} else {
								++var0;
							}

							if (UserComparator8.headIconHintSprites == null) {
								var2 = class199.archive8;
								var3 = class241.field2053.field3879;
								if (!class164.method862(var2, var3, 0)) {
									var23 = null;
								} else {
									var16 = new SpritePixels[class544.SpriteBuffer_spriteCount];
									var17 = 0;

									while (true) {
										if (var17 >= class544.SpriteBuffer_spriteCount) {
											class407.method2062();
											var23 = var16;
											break;
										}

										var7 = var16[var17] = new SpritePixels();
										var7.width = class159.SpriteBuffer_spriteWidth;
										var7.height = class500.SpriteBuffer_spriteHeight;
										var7.xOffset = class326.SpriteBuffer_xOffsets[var17];
										var7.yOffset = ModelData0.SpriteBuffer_yOffsets[var17];
										var7.subWidth = class59.SpriteBuffer_spriteWidths[var17];
										var7.subHeight = class544.SpriteBuffer_spriteHeights[var17];
										var18 = var7.subHeight * var7.subWidth;
										var9 = AddRequestTask.SpriteBuffer_pixels[var17];
										var7.pixels = new int[var18];

										for (var19 = 0; var19 < var18; ++var19) {
											var7.pixels[var19] = class372.SpriteBuffer_spritePalette[var9[var19] & 255];
										}

										++var17;
									}
								}

								UserComparator8.headIconHintSprites = var23;
							} else {
								++var0;
							}

							if (class47.mapMarkerSprites == null) {
								class47.mapMarkerSprites = ScriptEvent.method468(class199.archive8, class241.field2053.field3884, 0);
							} else {
								++var0;
							}

							if (EnumComposition.crossSprites == null) {
								var2 = class199.archive8;
								var3 = class241.field2053.field3876;
								if (!class164.method862(var2, var3, 0)) {
									var23 = null;
								} else {
									var16 = new SpritePixels[class544.SpriteBuffer_spriteCount];
									var17 = 0;

									while (true) {
										if (var17 >= class544.SpriteBuffer_spriteCount) {
											class407.method2062();
											var23 = var16;
											break;
										}

										var7 = var16[var17] = new SpritePixels();
										var7.width = class159.SpriteBuffer_spriteWidth;
										var7.height = class500.SpriteBuffer_spriteHeight;
										var7.xOffset = class326.SpriteBuffer_xOffsets[var17];
										var7.yOffset = ModelData0.SpriteBuffer_yOffsets[var17];
										var7.subWidth = class59.SpriteBuffer_spriteWidths[var17];
										var7.subHeight = class544.SpriteBuffer_spriteHeights[var17];
										var18 = var7.subWidth * var7.subHeight;
										var9 = AddRequestTask.SpriteBuffer_pixels[var17];
										var7.pixels = new int[var18];

										for (var19 = 0; var19 < var18; ++var19) {
											var7.pixels[var19] = class372.SpriteBuffer_spritePalette[var9[var19] & 255];
										}

										++var17;
									}
								}

								EnumComposition.crossSprites = var23;
							} else {
								++var0;
							}

							if (class103.mapDotSprites == null) {
								class103.mapDotSprites = ScriptEvent.method468(class199.archive8, class241.field2053.field3882, 0);
							} else {
								++var0;
							}

							if (class36.scrollBarSprites == null) {
								var2 = class199.archive8;
								var3 = class241.field2053.field3885;
								if (!class164.method862(var2, var3, 0)) {
									var1 = null;
								} else {
									var1 = class512.method2517();
								}

								class36.scrollBarSprites = var1;
							} else {
								++var0;
							}

							if (class178.field1459 == null) {
								var2 = class199.archive8;
								var3 = class241.field2053.field3878;
								if (!class164.method862(var2, var3, 0)) {
									var1 = null;
								} else {
									var1 = class512.method2517();
								}

								class178.field1459 = var1;
							} else {
								++var0;
							}

							if (var0 < 11) {
								Login.Login_loadingText = "Loading sprites - " + var0 * 100 / 12 + "%";
								Login.Login_loadingPercent = 70;
							} else {
								AbstractFont.AbstractFont_modIconSprites = class178.field1459;
								ParamComposition.redHintArrowSprite.normalize();
								var14 = (int)(Math.random() * 21.0D) - 10;
								int var20 = (int)(Math.random() * 21.0D) - 10;
								var3 = (int)(Math.random() * 21.0D) - 10;
								int var21 = (int)(Math.random() * 41.0D) - 20;
								KitDefinition.mapSceneSprites[0].shiftColors(var21 + var14, var20 + var21, var21 + var3);
								Login.Login_loadingText = "Loaded sprites";
								Login.Login_loadingPercent = 70;
								Client.field416 = class94.field940;
							}
						} else if (class94.field940 == Client.field416) {
							if (!class241.field2052.isFullyLoaded()) {
								Login.Login_loadingText = "Loading textures - " + "0%";
								Login.Login_loadingPercent = 90;
							} else {
								class305.textureProvider = new TextureProvider(class241.field2052, class199.archive8, 20, class91.clientPreferences.getBrightness(), Client.isLowDetail ? 64 : 128);
								Rasterizer3D.method1235(class305.textureProvider);
								Rasterizer3D.method1236(class91.clientPreferences.getBrightness());
								Client.field416 = class94.field930;
							}
						} else if (class94.field930 == Client.field416) {
							var0 = class305.textureProvider.getLoadedPercentage();
							if (var0 < 100) {
								Login.Login_loadingText = "Loading textures - " + var0 + "%";
								Login.Login_loadingPercent = 90;
							} else {
								Login.Login_loadingText = "Loaded textures";
								Login.Login_loadingPercent = 90;
								Client.field416 = class94.field927;
							}
						} else if (class94.field927 == Client.field416) {
							class233.mouseRecorder = new MouseRecorder();
							GameEngine.taskHandler.newThreadTask(class233.mouseRecorder, 10);
							Login.Login_loadingText = "Loaded input handler";
							Login.Login_loadingPercent = 92;
							Client.field416 = class94.field937;
						} else if (Client.field416 == class94.field937) {
							if (!class190.archive10.tryLoadFileByNames("huffman", "")) {
								Login.Login_loadingText = "Loading wordpack - " + 0 + "%";
								Login.Login_loadingPercent = 94;
							} else {
								Huffman var38 = new Huffman(class190.archive10.takeFileByNames("huffman", ""));
								class349.huffman = var38;
								Login.Login_loadingText = "Loaded wordpack";
								Login.Login_loadingPercent = 94;
								Client.field416 = class94.field942;
							}
						} else if (class94.field942 == Client.field416) {
							if (!AbstractByteArrayCopier.field3136.isFullyLoaded()) {
								Login.Login_loadingText = "Loading interfaces - " + AbstractByteArrayCopier.field3136.loadPercent() * 4 / 5 + "%";
								Login.Login_loadingPercent = 96;
							} else if (!class319.field2799.isFullyLoaded()) {
								Login.Login_loadingText = "Loading interfaces - " + class319.field2799.loadPercent() * 4 / 5 + "%";
								Login.Login_loadingPercent = 96;
							} else if (!SongTask.archive12.isFullyLoaded()) {
								Login.Login_loadingText = "Loading interfaces - " + (80 + SongTask.archive12.loadPercent() / 6) + "%";
								Login.Login_loadingPercent = 96;
							} else if (!class27.archive13.isFullyLoaded()) {
								Login.Login_loadingText = "Loading interfaces - " + (96 + class27.archive13.loadPercent() / 50) + "%";
								Login.Login_loadingPercent = 96;
							} else {
								Login.Login_loadingText = "Loaded interfaces";
								Login.Login_loadingPercent = 98;
								if (SongTask.archive12.isValidFileName("version.dat", "")) {
									Buffer var13 = new Buffer(SongTask.archive12.takeFileByNames("version.dat", ""));
									var13.readUnsignedShort();
								}

								Client.field416 = class94.field939;
							}
						} else if (class94.field939 == Client.field416) {
							Login.Login_loadingPercent = 100;
							if (AABB.field2123.getGroupCount() > 0 && !AABB.field2123.tryLoadGroupByName(WorldMapCacheName.field2482.name)) {
								Login.Login_loadingText = "Loading world map - " + AABB.field2123.groupLoadPercentByName(WorldMapCacheName.field2482.name) / 10 + "%";
							} else {
								if (class434.worldMap == null) {
									class434.worldMap = new WorldMap();
									class434.worldMap.init(AABB.field2123, class358.field3177, HorizontalAlignment.field1584, SoundCache.fontBold12, Client.fontsMap, KitDefinition.mapSceneSprites);
								}

								Login.Login_loadingText = "Loaded world map";
								Client.field416 = class94.field932;
							}
						} else {
							if (class94.field932 == Client.field416) {
								DefaultsGroup.updateGameState(10);
							}

						}
					}
				}
			}
		}
	}
}