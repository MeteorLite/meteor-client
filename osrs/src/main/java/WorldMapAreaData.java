import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

@ObfuscatedName("jx")
@Implements("WorldMapAreaData")
public class WorldMapAreaData extends WorldMapArea {
	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		descriptor = "Loh;"
	)
	static Archive field2099;
	@ObfuscatedName("as")
	HashSet field2100;
	@ObfuscatedName("ay")
	HashSet field2101;
	@ObfuscatedName("ak")
	@Export("iconList")
	List iconList;

	WorldMapAreaData() {
	}

	@ObfuscatedName("cz")
	@ObfuscatedSignature(
		descriptor = "(Luj;Luj;IZZI)V",
		garbageValue = "-605935351"
	)
	void method1363(Buffer var1, Buffer var2, int var3, boolean var4, boolean var5) {
		this.method1205(var1, var3, var5);
		int var6 = var2.readUnsignedShort();
		this.field2100 = new HashSet(var6);

		int var7;
		for (var7 = 0; var7 < var6; ++var7) {
			WorldMapData_0 var8 = new WorldMapData_0();

			try {
				var8.init(var2);
			} catch (IllegalStateException var13) {
				continue;
			}

			this.field2100.add(var8);
		}

		var7 = var2.readUnsignedShort();
		this.field2101 = new HashSet(var7);

		for (int var11 = 0; var11 < var7; ++var11) {
			WorldMapData_1 var9 = new WorldMapData_1();

			try {
				var9.init(var2);
			} catch (IllegalStateException var12) {
				continue;
			}

			this.field2101.add(var9);
		}

		this.initIconsList(var2, var4);
	}

	@ObfuscatedName("cy")
	@ObfuscatedSignature(
		descriptor = "(Luj;ZI)V",
		garbageValue = "950262169"
	)
	@Export("initIconsList")
	void initIconsList(Buffer var1, boolean var2) {
		this.iconList = new LinkedList();
		int var3 = var1.readUnsignedShort();

		for (int var4 = 0; var4 < var3; ++var4) {
			int var5 = var1.readNullableLargeSmart();
			Coord var6 = new Coord(var1.readInt());
			boolean var7 = var1.readUnsignedByte() == 1;
			if (var2 || !var7) {
				this.iconList.add(new WorldMapIcon_0((Coord)null, var6, var5, (WorldMapLabel)null));
			}
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)F",
		garbageValue = "1883889398"
	)
	static final float method1364(int var0) {
		float var1 = 10075.0F - (float)var0;
		return (var1 * 1.0075567F - 75.56675F) / var1;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(Lnn;IIII)V",
		garbageValue = "-1973089018"
	)
	@Export("Widget_setKeyRate")
	static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
		if (var0.field3073 == null) {
			throw new RuntimeException();
		} else {
			var0.field3073[var1] = var2;
			var0.field3072[var1] = var3;
		}
	}

	@ObfuscatedName("kv")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIB)V",
		garbageValue = "-113"
	)
	@Export("addPendingSpawnToScene")
	static final void addPendingSpawnToScene(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if (var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
			if (Client.isLowDetail && var0 != ItemLayer.Client_plane) {
				return;
			}

			long var8 = 0L;
			boolean var10 = true;
			boolean var11 = false;
			boolean var12 = false;
			if (var1 == 0) {
				var8 = class36.scene.getBoundaryObjectTag(var0, var2, var3);
			}

			if (var1 == 1) {
				var8 = class36.scene.getWallDecorationTag(var0, var2, var3);
			}

			if (var1 == 2) {
				var8 = class36.scene.getGameObjectTag(var0, var2, var3);
			}

			if (var1 == 3) {
				var8 = class36.scene.getFloorDecorationTag(var0, var2, var3);
			}

			int var13;
			int var17;
			int var18;
			int var19;
			int var20;
			int var21;
			int var22;
			if (0L != var8) {
				var13 = class36.scene.getObjectFlags(var0, var2, var3, var8);
				int var44 = class232.Entity_unpackID(var8);
				int var45 = var13 & 31;
				int var46 = var13 >> 6 & 3;
				ObjectComposition var14 = WorldMapSection2.getObjectDefinition(var44);
				if (var14 != null && var14.hasSound()) {
					var17 = var14.sizeX;
					var18 = var14.sizeY;
					if (var46 == 1 || var46 == 3) {
						var17 = var14.sizeY;
						var18 = var14.sizeX;
					}

					var19 = (var17 + var2) * 128;
					var20 = (var3 + var18) * 128;
					int var15 = var2 * 128;
					int var16 = var3 * 128;
					var21 = var14.ambientSoundId;
					var22 = var14.int7 * 128;
					if (var14.transforms != null) {
						ObjectComposition var23 = var14.transform();
						if (var23 != null) {
							var21 = var23.ambientSoundId;
							var22 = var23.int7 * 128;
						}
					}

					Object var10000 = null;

					for (ObjectSound var48 = (ObjectSound)ObjectSound.objectSounds.last(); var48 != null; var48 = (ObjectSound)ObjectSound.objectSounds.previous()) {
						if (var0 == var48.plane && var15 == var48.x && var16 == var48.y && var19 == var48.maxX && var20 == var48.maxY && var21 == var48.soundEffectId && var22 == var48.field691) {
							if (var48.stream1 != null) {
								LoginScreenAnimation.pcmStreamMixer.removeSubStream(var48.stream1);
								var48.stream1 = null;
							}

							if (var48.stream2 != null) {
								LoginScreenAnimation.pcmStreamMixer.removeSubStream(var48.stream2);
								var48.stream2 = null;
							}

							var48.remove();
							break;
						}

						var10000 = null;
					}
				}

				if (var1 == 0) {
					class36.scene.removeBoundaryObject(var0, var2, var3);
					if (var14.interactType != 0) {
						Client.collisionMaps[var0].method1142(var2, var3, var45, var46, var14.boolean1);
					}
				}

				if (var1 == 1) {
					class36.scene.removeWallDecoration(var0, var2, var3);
				}

				if (var1 == 2) {
					class36.scene.removeGameObject(var0, var2, var3);
					if (var2 + var14.sizeX > 103 || var3 + var14.sizeX > 103 || var2 + var14.sizeY > 103 || var3 + var14.sizeY > 103) {
						return;
					}

					if (var14.interactType != 0) {
						Client.collisionMaps[var0].setFlagOffNonSquare(var2, var3, var14.sizeX, var14.sizeY, var46, var14.boolean1);
					}
				}

				if (var1 == 3) {
					class36.scene.removeFloorDecoration(var0, var2, var3);
					if (var14.interactType == 1) {
						Client.collisionMaps[var0].method1145(var2, var3);
					}
				}
			}

			if (var4 >= 0) {
				var13 = var0;
				if (var0 < 3 && (Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var13 = var0 + 1;
				}

				Scene var47 = class36.scene;
				CollisionMap var37 = Client.collisionMaps[var0];
				ObjectComposition var38 = WorldMapSection2.getObjectDefinition(var4);
				var17 = var7 >= 0 ? var7 : var38.animationId ;
				if (var5 != 1 && var5 != 3) {
					var18 = var38.sizeX;
					var19 = var38.sizeY;
				} else {
					var18 = var38.sizeY;
					var19 = var38.sizeX;
				}

				if (var18 + var2 <= 104) {
					var20 = (var18 >> 1) + var2;
					var21 = var2 + (var18 + 1 >> 1);
				} else {
					var20 = var2;
					var21 = var2 + 1;
				}

				int var39;
				if (var3 + var19 <= 104) {
					var22 = var3 + (var19 >> 1);
					var39 = var3 + (var19 + 1 >> 1);
				} else {
					var22 = var3;
					var39 = var3 + 1;
				}

				int[][] var24 = Tiles.Tiles_heights[var13];
				int var25 = var24[var20][var22] + var24[var21][var22] + var24[var20][var39] + var24[var21][var39] >> 2;
				int var26 = (var2 << 7) + (var18 << 6);
				int var27 = (var3 << 7) + (var19 << 6);
				long var28 = Player.calculateTag(var2, var3, 2, var38.int1 == 0, var4);
				int var30 = (var5 << 6) + var6;
				if (var38.int3 == 1) {
					var30 += 256;
				}

				Object var31;
				if (var6 == 22) {
					if (var17 == -1 && var38.transforms == null) {
						var31 = var38.getModel(22, var5, var24, var26, var25, var27);
					} else {
						var31 = new DynamicObject(var4, 22, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
					}

					var47.newFloorDecoration(var0, var2, var3, var25, (Renderable)var31, var28, var30);
					if (var38.interactType == 1) {
						var37.setBlockedByFloorDec(var2, var3);
					}
				} else if (var6 != 10 && var6 != 11) {
					if (var6 >= 12) {
						if (var17 == -1 && var38.transforms == null) {
							var31 = var38.getModel(var6, var5, var24, var26, var25, var27);
						} else {
							var31 = new DynamicObject(var4, var6, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
						}

						var47.method1467(var0, var2, var3, var25, 1, 1, (Renderable)var31, 0, var28, var30);
						if (var38.interactType != 0) {
							var37.addGameObject(var2, var3, var18, var19, var38.boolean1);
						}
					} else if (var6 == 0) {
						if (var17 == -1 && var38.transforms == null) {
							var31 = var38.getModel(0, var5, var24, var26, var25, var27);
						} else {
							var31 = new DynamicObject(var4, 0, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
						}

						var47.newBoundaryObject(var0, var2, var3, var25, (Renderable)var31, (Renderable)null, Tiles.field849[var5], 0, var28, var30);
						if (var38.interactType != 0) {
							var37.method1137(var2, var3, var6, var5, var38.boolean1);
						}
					} else if (var6 == 1) {
						if (var17 == -1 && var38.transforms == null) {
							var31 = var38.getModel(1, var5, var24, var26, var25, var27);
						} else {
							var31 = new DynamicObject(var4, 1, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
						}

						var47.newBoundaryObject(var0, var2, var3, var25, (Renderable)var31, (Renderable)null, Tiles.field847[var5], 0, var28, var30);
						if (var38.interactType != 0) {
							var37.method1137(var2, var3, var6, var5, var38.boolean1);
						}
					} else {
						int var40;
						if (var6 == 2) {
							var40 = var5 + 1 & 3;
							Object var32;
							Object var33;
							if (var17 == -1 && var38.transforms == null) {
								var32 = var38.getModel(2, var5 + 4, var24, var26, var25, var27);
								var33 = var38.getModel(2, var40, var24, var26, var25, var27);
							} else {
								var32 = new DynamicObject(var4, 2, var5 + 4, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
								var33 = new DynamicObject(var4, 2, var40, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
							}

							var47.newBoundaryObject(var0, var2, var3, var25, (Renderable)var32, (Renderable)var33, Tiles.field849[var5], Tiles.field849[var40], var28, var30);
							if (var38.interactType != 0) {
								var37.method1137(var2, var3, var6, var5, var38.boolean1);
							}
						} else if (var6 == 3) {
							if (var17 == -1 && var38.transforms == null) {
								var31 = var38.getModel(3, var5, var24, var26, var25, var27);
							} else {
								var31 = new DynamicObject(var4, 3, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
							}

							var47.newBoundaryObject(var0, var2, var3, var25, (Renderable)var31, (Renderable)null, Tiles.field847[var5], 0, var28, var30);
							if (var38.interactType != 0) {
								var37.method1137(var2, var3, var6, var5, var38.boolean1);
							}
						} else if (var6 == 9) {
							if (var17 == -1 && var38.transforms == null) {
								var31 = var38.getModel(var6, var5, var24, var26, var25, var27);
							} else {
								var31 = new DynamicObject(var4, var6, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
							}

							var47.method1467(var0, var2, var3, var25, 1, 1, (Renderable)var31, 0, var28, var30);
							if (var38.interactType != 0) {
								var37.addGameObject(var2, var3, var18, var19, var38.boolean1);
							}
						} else if (var6 == 4) {
							if (var17 == -1 && var38.transforms == null) {
								var31 = var38.getModel(4, var5, var24, var26, var25, var27);
							} else {
								var31 = new DynamicObject(var4, 4, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
							}

							var47.newWallDecoration(var0, var2, var3, var25, (Renderable)var31, (Renderable)null, Tiles.field849[var5], 0, 0, 0, var28, var30);
						} else {
							Object var34;
							long var41;
							if (var6 == 5) {
								var40 = 16;
								var41 = var47.getBoundaryObjectTag(var0, var2, var3);
								if (var41 != 0L) {
									var40 = WorldMapSection2.getObjectDefinition(class232.Entity_unpackID(var41)).int2;
								}

								if (var17 == -1 && var38.transforms == null) {
									var34 = var38.getModel(4, var5, var24, var26, var25, var27);
								} else {
									var34 = new DynamicObject(var4, 4, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
								}

								var47.newWallDecoration(var0, var2, var3, var25, (Renderable)var34, (Renderable)null, Tiles.field849[var5], 0, var40 * Tiles.field850[var5], var40 * Tiles.field845[var5], var28, var30);
							} else if (var6 == 6) {
								var40 = 8;
								var41 = var47.getBoundaryObjectTag(var0, var2, var3);
								if (0L != var41) {
									var40 = WorldMapSection2.getObjectDefinition(class232.Entity_unpackID(var41)).int2 / 2;
								}

								if (var17 == -1 && var38.transforms == null) {
									var34 = var38.getModel(4, var5 + 4, var24, var26, var25, var27);
								} else {
									var34 = new DynamicObject(var4, 4, var5 + 4, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
								}

								var47.newWallDecoration(var0, var2, var3, var25, (Renderable)var34, (Renderable)null, 256, var5, var40 * Tiles.field848[var5], var40 * Tiles.field846[var5], var28, var30);
							} else if (var6 == 7) {
								int var43 = var5 + 2 & 3;
								if (var17 == -1 && var38.transforms == null) {
									var31 = var38.getModel(4, var43 + 4, var24, var26, var25, var27);
								} else {
									var31 = new DynamicObject(var4, 4, var43 + 4, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
								}

								var47.newWallDecoration(var0, var2, var3, var25, (Renderable)var31, (Renderable)null, 256, var43, 0, 0, var28, var30);
							} else if (var6 == 8) {
								var40 = 8;
								var41 = var47.getBoundaryObjectTag(var0, var2, var3);
								if (var41 != 0L) {
									var40 = WorldMapSection2.getObjectDefinition(class232.Entity_unpackID(var41)).int2 / 2;
								}

								int var36 = var5 + 2 & 3;
								Object var35;
								if (var17 == -1 && var38.transforms == null) {
									var34 = var38.getModel(4, var5 + 4, var24, var26, var25, var27);
									var35 = var38.getModel(4, var36 + 4, var24, var26, var25, var27);
								} else {
									var34 = new DynamicObject(var4, 4, var5 + 4, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
									var35 = new DynamicObject(var4, 4, var36 + 4, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
								}

								var47.newWallDecoration(var0, var2, var3, var25, (Renderable)var34, (Renderable)var35, 256, var5, var40 * Tiles.field848[var5], var40 * Tiles.field846[var5], var28, var30);
							}
						}
					}
				} else {
					if (var17 == -1 && var38.transforms == null) {
						var31 = var38.getModel(10, var5, var24, var26, var25, var27);
					} else {
						var31 = new DynamicObject(var4, 10, var5, var13, var2, var3, var17, var38.boolean3, (Renderable)null);
					}

					if (var31 != null) {
						var47.method1467(var0, var2, var3, var25, var18, var19, (Renderable)var31, var6 == 11 ? 256 : 0, var28, var30);
					}

					if (var38.interactType != 0) {
						var37.addGameObject(var2, var3, var18, var19, var38.boolean1);
					}
				}

				var38 = WorldMapSection2.getObjectDefinition(var4);
				if (var38 != null && var38.hasSound()) {
					UrlRequester.method648(var13, var2, var3, var38, var5);
				}
			}
		}

	}
}