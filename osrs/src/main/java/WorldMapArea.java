import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("WorldMapArea")
public class WorldMapArea {
	@ObfuscatedName("ib")
	@ObfuscatedSignature(
		descriptor = "[Lqu;"
	)
	@Export("mapSceneSprites")
	static IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 400592753
	)
	@Export("id")
	int id;
	@ObfuscatedName("p")
	@Export("internalName")
	String internalName;
	@ObfuscatedName("f")
	@Export("externalName")
	String externalName;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 823667415
	)
	@Export("backGroundColor")
	int backGroundColor;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -822979577
	)
	@Export("zoom")
	int zoom;
	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "Lkz;"
	)
	@Export("origin")
	Coord origin;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = 622660925
	)
	@Export("regionLowX")
	int regionLowX;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 1974986689
	)
	@Export("regionHighX")
	int regionHighX;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 280680285
	)
	@Export("regionLowY")
	int regionLowY;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = -1545198049
	)
	@Export("regionHighY")
	int regionHighY;
	@ObfuscatedName("j")
	@Export("isMain")
	boolean isMain;
	@ObfuscatedName("v")
	@Export("sections")
	LinkedList sections;

	public WorldMapArea() {
		this.id = -1;
		this.backGroundColor = -1;
		this.zoom = -1;
		this.origin = null;
		this.regionLowX = Integer.MAX_VALUE;
		this.regionHighX = 0;
		this.regionLowY = Integer.MAX_VALUE;
		this.regionHighY = 0;
		this.isMain = false;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lqq;II)V",
		garbageValue = "-1793066214"
	)
	@Export("read")
	public void read(Buffer var1, int var2) {
		this.id = var2;
		this.internalName = var1.readStringCp1252NullTerminated();
		this.externalName = var1.readStringCp1252NullTerminated();
		this.origin = new Coord(var1.readInt());
		this.backGroundColor = var1.readInt();
		var1.readUnsignedByte();
		this.isMain = var1.readUnsignedByte() == 1;
		this.zoom = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		this.sections = new LinkedList();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.sections.add(this.readWorldMapSection(var1));
		}

		this.setBounds();
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lqq;B)Lis;",
		garbageValue = "43"
	)
	@Export("readWorldMapSection")
	WorldMapSection readWorldMapSection(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		WorldMapSectionType[] var3 = new WorldMapSectionType[]{WorldMapSectionType.WORLDMAPSECTIONTYPE0, WorldMapSectionType.WORLDMAPSECTIONTYPE3, WorldMapSectionType.WORLDMAPSECTIONTYPE1, WorldMapSectionType.WORLDMAPSECTIONTYPE2};
		WorldMapSectionType var4 = (WorldMapSectionType)Varps.findEnumerated(var3, var2);
		Object var5 = null;
		switch(var4.type) {
		case 0:
			var5 = new WorldMapSection1();
			break;
		case 1:
			var5 = new WorldMapSection0();
			break;
		case 2:
			var5 = new WorldMapSection2();
			break;
		case 3:
			var5 = new class229();
			break;
		default:
			throw new IllegalStateException("");
		}

		((WorldMapSection)var5).read(var1);
		return (WorldMapSection)var5;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(IIII)Z",
		garbageValue = "-2077461769"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return false;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return true;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "-59153460"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		int var3 = var1 / 64;
		int var4 = var2 / 64;
		if (var3 >= this.regionLowX && var3 <= this.regionHighX) {
			if (var4 >= this.regionLowY && var4 <= this.regionHighY) {
				Iterator var5 = this.sections.iterator();

				WorldMapSection var6;
				do {
					if (!var5.hasNext()) {
						return false;
					}

					var6 = (WorldMapSection)var5.next();
				} while(!var6.containsPosition(var1, var2));

				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(IIIB)[I",
		garbageValue = "1"
	)
	@Export("position")
	public int[] position(int var1, int var2, int var3) {
		Iterator var4 = this.sections.iterator();

		WorldMapSection var5;
		do {
			if (!var4.hasNext()) {
				return null;
			}

			var5 = (WorldMapSection)var4.next();
		} while(!var5.containsCoord(var1, var2, var3));

		return var5.getBorderTileLengths(var1, var2, var3);
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(III)Lkz;",
		garbageValue = "700857776"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		Iterator var3 = this.sections.iterator();

		WorldMapSection var4;
		do {
			if (!var3.hasNext()) {
				return null;
			}

			var4 = (WorldMapSection)var3.next();
		} while(!var4.containsPosition(var1, var2));

		return var4.coord(var1, var2);
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-824642614"
	)
	@Export("setBounds")
	void setBounds() {
		Iterator var1 = this.sections.iterator();

		while (var1.hasNext()) {
			WorldMapSection var2 = (WorldMapSection)var1.next();
			var2.expandBounds(this);
		}

	}

	@ObfuscatedName("q")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-664021074"
	)
	@Export("getId")
	public int getId() {
		return this.id;
	}

	@ObfuscatedName("m")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1872259243"
	)
	@Export("getIsMain")
	public boolean getIsMain() {
		return this.isMain;
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/lang/String;",
		garbageValue = "7"
	)
	@Export("getInternalName")
	public String getInternalName() {
		return this.internalName;
	}

	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-8855131"
	)
	@Export("getExternalName")
	public String getExternalName() {
		return this.externalName;
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1471188853"
	)
	@Export("getBackGroundColor")
	int getBackGroundColor() {
		return this.backGroundColor;
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1365898930"
	)
	@Export("getZoom")
	public int getZoom() {
		return this.zoom;
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "73"
	)
	@Export("getRegionLowX")
	public int getRegionLowX() {
		return this.regionLowX;
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "6"
	)
	@Export("getRegionHighX")
	public int getRegionHighX() {
		return this.regionHighX;
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-924051176"
	)
	@Export("getRegionLowY")
	public int getRegionLowY() {
		return this.regionLowY;
	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1942658021"
	)
	@Export("getRegionHighY")
	public int getRegionHighY() {
		return this.regionHighY;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-5"
	)
	@Export("getOriginX")
	public int getOriginX() {
		return this.origin.x;
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1287204919"
	)
	@Export("getOriginPlane")
	public int getOriginPlane() {
		return this.origin.plane;
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1899036968"
	)
	@Export("getOriginY")
	public int getOriginY() {
		return this.origin.y;
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "(B)Lkz;",
		garbageValue = "-114"
	)
	@Export("getOrigin")
	public Coord getOrigin() {
		return new Coord(this.origin);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(Lgp;[Lgj;I)V",
		garbageValue = "-1670152302"
	)
	static final void method4808(Scene var0, CollisionMap[] var1) {
		int var2;
		int var3;
		int var4;
		int var5;
		for (var2 = 0; var2 < 4; ++var2) {
			for (var3 = 0; var3 < 104; ++var3) {
				for (var4 = 0; var4 < 104; ++var4) {
					if ((Tiles.Tiles_renderFlags[var2][var3][var4] & 1) == 1) {
						var5 = var2;
						if ((Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
							var5 = var2 - 1;
						}

						if (var5 >= 0) {
							var1[var5].setBlockedByFloor(var3, var4);
						}
					}
				}
			}
		}

		Tiles.rndHue += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.rndHue < -8) {
			Tiles.rndHue = -8;
		}

		if (Tiles.rndHue > 8) {
			Tiles.rndHue = 8;
		}

		Tiles.rndLightness += (int)(Math.random() * 5.0D) - 2;
		if (Tiles.rndLightness < -16) {
			Tiles.rndLightness = -16;
		}

		if (Tiles.rndLightness > 16) {
			Tiles.rndLightness = 16;
		}

		int var9;
		int var10;
		int var11;
		int var12;
		int var13;
		int var14;
		int var15;
		int var16;
		int[] var10000;
		int var17;
		int var18;
		for (var2 = 0; var2 < 4; ++var2) {
			byte[][] var44 = SoundCache.field328[var2];
			boolean var51 = true;
			boolean var52 = true;
			boolean var6 = true;
			boolean var7 = true;
			boolean var8 = true;
			var9 = (int)Math.sqrt(5100.0D);
			var10 = var9 * 768 >> 8;

			int var19;
			int var20;
			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					var13 = Tiles.Tiles_heights[var2][var12 + 1][var11] - Tiles.Tiles_heights[var2][var12 - 1][var11];
					var14 = Tiles.Tiles_heights[var2][var12][var11 + 1] - Tiles.Tiles_heights[var2][var12][var11 - 1];
					var15 = (int)Math.sqrt((double)(var14 * var14 + var13 * var13 + 65536));
					var16 = (var13 << 8) / var15;
					var17 = 65536 / var15;
					var18 = (var14 << 8) / var15;
					var19 = (var16 * -50 + var18 * -50 + var17 * -10) / var10 + 96;
					var20 = (var44[var12 - 1][var11] >> 2) + (var44[var12][var11 - 1] >> 2) + (var44[var12 + 1][var11] >> 3) + (var44[var12][var11 + 1] >> 3) + (var44[var12][var11] >> 1);
					Tiles.field1002[var12][var11] = var19 - var20;
				}
			}

			for (var11 = 0; var11 < 104; ++var11) {
				TextureProvider.Tiles_hue[var11] = 0;
				FontName.Tiles_saturation[var11] = 0;
				class436.Tiles_lightness[var11] = 0;
				class434.Tiles_hueMultiplier[var11] = 0;
				Tiles.field1008[var11] = 0;
			}

			for (var11 = -5; var11 < 109; ++var11) {
				for (var12 = 0; var12 < 104; ++var12) {
					var13 = var11 + 5;
					int var10002;
					if (var13 >= 0 && var13 < 104) {
						var14 = class152.Tiles_underlays[var2][var13][var12] & 255;
						if (var14 > 0) {
							FloorUnderlayDefinition var49 = WorldMapSectionType.method5074(var14 - 1);
							var10000 = TextureProvider.Tiles_hue;
							var10000[var12] += var49.hue;
							var10000 = FontName.Tiles_saturation;
							var10000[var12] += var49.saturation;
							var10000 = class436.Tiles_lightness;
							var10000[var12] += var49.lightness;
							var10000 = class434.Tiles_hueMultiplier;
							var10000[var12] += var49.hueMultiplier;
							var10002 = Tiles.field1008[var12]++;
						}
					}

					var14 = var11 - 5;
					if (var14 >= 0 && var14 < 104) {
						var15 = class152.Tiles_underlays[var2][var14][var12] & 255;
						if (var15 > 0) {
							FloorUnderlayDefinition var50 = WorldMapSectionType.method5074(var15 - 1);
							var10000 = TextureProvider.Tiles_hue;
							var10000[var12] -= var50.hue;
							var10000 = FontName.Tiles_saturation;
							var10000[var12] -= var50.saturation;
							var10000 = class436.Tiles_lightness;
							var10000[var12] -= var50.lightness;
							var10000 = class434.Tiles_hueMultiplier;
							var10000[var12] -= var50.hueMultiplier;
							var10002 = Tiles.field1008[var12]--;
						}
					}
				}

				if (var11 >= 1 && var11 < 103) {
					var12 = 0;
					var13 = 0;
					var14 = 0;
					var15 = 0;
					var16 = 0;

					for (var17 = -5; var17 < 109; ++var17) {
						var18 = var17 + 5;
						if (var18 >= 0 && var18 < 104) {
							var12 += TextureProvider.Tiles_hue[var18];
							var13 += FontName.Tiles_saturation[var18];
							var14 += class436.Tiles_lightness[var18];
							var15 += class434.Tiles_hueMultiplier[var18];
							var16 += Tiles.field1008[var18];
						}

						var19 = var17 - 5;
						if (var19 >= 0 && var19 < 104) {
							var12 -= TextureProvider.Tiles_hue[var19];
							var13 -= FontName.Tiles_saturation[var19];
							var14 -= class436.Tiles_lightness[var19];
							var15 -= class434.Tiles_hueMultiplier[var19];
							var16 -= Tiles.field1008[var19];
						}

						if (var17 >= 1 && var17 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
							if (var2 < Tiles.Tiles_minPlane) {
								Tiles.Tiles_minPlane = var2;
							}

							var20 = class152.Tiles_underlays[var2][var11][var17] & 255;
							int var21 = class294.Tiles_overlays[var2][var11][var17] & 255;
							if (var20 > 0 || var21 > 0) {
								int var22 = Tiles.Tiles_heights[var2][var11][var17];
								int var23 = Tiles.Tiles_heights[var2][var11 + 1][var17];
								int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
								int var25 = Tiles.Tiles_heights[var2][var11][var17 + 1];
								int var26 = Tiles.field1002[var11][var17];
								int var27 = Tiles.field1002[var11 + 1][var17];
								int var28 = Tiles.field1002[var11 + 1][var17 + 1];
								int var29 = Tiles.field1002[var11][var17 + 1];
								int var30 = -1;
								int var31 = -1;
								int var32;
								int var33;
								int var34;
								if (var20 > 0) {
									var32 = var12 * 256 / var15;
									var33 = var13 / var16;
									var34 = var14 / var16;
									var30 = Language.hslToRgb(var32, var33, var34);
									var32 = var32 + Tiles.rndHue & 255;
									var34 += Tiles.rndLightness;
									if (var34 < 0) {
										var34 = 0;
									} else if (var34 > 255) {
										var34 = 255;
									}

									var31 = Language.hslToRgb(var32, var33, var34);
								}

								FloorOverlayDefinition var35;
								if (var2 > 0) {
									boolean var57 = true;
									if (var20 == 0 && Tiles.Tiles_shapes[var2][var11][var17] != 0) {
										var57 = false;
									}

									if (var21 > 0) {
										var34 = var21 - 1;
										var35 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var34);
										FloorOverlayDefinition var46;
										if (var35 != null) {
											var46 = var35;
										} else {
											byte[] var36 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var34);
											var35 = new FloorOverlayDefinition();
											if (var36 != null) {
												var35.decode(new Buffer(var36), var34);
											}

											var35.postDecode();
											FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var35, (long)var34);
											var46 = var35;
										}

										if (!var46.hideUnderlay) {
											var57 = false;
										}
									}

									if (var57 && var22 == var23 && var24 == var22 && var25 == var22) {
										var10000 = ChatChannel.field996[var2][var11];
										var10000[var17] |= 2340;
									}
								}

								var32 = 0;
								if (var31 != -1) {
									var32 = Rasterizer3D.Rasterizer3D_colorPalette[class9.method83(var31, 96)];
								}

								if (var21 == 0) {
									var0.addTile(var2, var11, var17, 0, 0, -1, var22, var23, var24, var25, class9.method83(var30, var26), class9.method83(var30, var27), class9.method83(var30, var28), class9.method83(var30, var29), 0, 0, 0, 0, var32, 0);
								} else {
									var33 = Tiles.Tiles_shapes[var2][var11][var17] + 1;
									byte var58 = Tiles.field1001[var2][var11][var17];
									int var47 = var21 - 1;
									FloorOverlayDefinition var37 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var47);
									if (var37 != null) {
										var35 = var37;
									} else {
										byte[] var38 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var47);
										var37 = new FloorOverlayDefinition();
										if (var38 != null) {
											var37.decode(new Buffer(var38), var47);
										}

										var37.postDecode();
										FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var37, (long)var47);
										var35 = var37;
									}

									int var48 = var35.texture;
									int var39;
									int var40;
									int var41;
									int var42;
									if (var48 >= 0) {
										var40 = Rasterizer3D.Rasterizer3D_textureLoader.getAverageTextureRGB(var48);
										var39 = -1;
									} else if (var35.primaryRgb == 16711935) {
										var39 = -2;
										var48 = -1;
										var40 = -2;
									} else {
										var39 = Language.hslToRgb(var35.hue, var35.saturation, var35.lightness);
										var41 = var35.hue + Tiles.rndHue & 255;
										var42 = var35.lightness + Tiles.rndLightness;
										if (var42 < 0) {
											var42 = 0;
										} else if (var42 > 255) {
											var42 = 255;
										}

										var40 = Language.hslToRgb(var41, var35.saturation, var42);
									}

									var41 = 0;
									if (var40 != -2) {
										var41 = Rasterizer3D.Rasterizer3D_colorPalette[class16.method216(var40, 96)];
									}

									if (var35.secondaryRgb != -1) {
										var42 = var35.secondaryHue + Tiles.rndHue & 255;
										int var43 = var35.secondaryLightness + Tiles.rndLightness;
										if (var43 < 0) {
											var43 = 0;
										} else if (var43 > 255) {
											var43 = 255;
										}

										var40 = Language.hslToRgb(var42, var35.secondarySaturation, var43);
										var41 = Rasterizer3D.Rasterizer3D_colorPalette[class16.method216(var40, 96)];
									}

									var0.addTile(var2, var11, var17, var33, var58, var48, var22, var23, var24, var25, class9.method83(var30, var26), class9.method83(var30, var27), class9.method83(var30, var28), class9.method83(var30, var29), class16.method216(var39, var26), class16.method216(var39, var27), class16.method216(var39, var28), class16.method216(var39, var29), var32, var41);
								}
							}
						}
					}
				}
			}

			for (var11 = 1; var11 < 103; ++var11) {
				for (var12 = 1; var12 < 103; ++var12) {
					if ((Tiles.Tiles_renderFlags[var2][var12][var11] & 8) != 0) {
						var17 = 0;
					} else if (var2 > 0 && (Tiles.Tiles_renderFlags[1][var12][var11] & 2) != 0) {
						var17 = var2 - 1;
					} else {
						var17 = var2;
					}

					var0.setTileMinPlane(var2, var12, var11, var17);
				}
			}

			class152.Tiles_underlays[var2] = null;
			class294.Tiles_overlays[var2] = null;
			Tiles.Tiles_shapes[var2] = null;
			Tiles.field1001[var2] = null;
			SoundCache.field328[var2] = null;
		}

		var0.method4290(-50, -10, -50);

		for (var2 = 0; var2 < 104; ++var2) {
			for (var3 = 0; var3 < 104; ++var3) {
				if ((Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
					var0.setLinkBelow(var2, var3);
				}
			}
		}

		var2 = 1;
		var3 = 2;
		var4 = 4;

		for (var5 = 0; var5 < 4; ++var5) {
			if (var5 > 0) {
				var2 <<= 3;
				var3 <<= 3;
				var4 <<= 3;
			}

			for (int var53 = 0; var53 <= var5; ++var53) {
				for (int var54 = 0; var54 <= 104; ++var54) {
					for (int var55 = 0; var55 <= 104; ++var55) {
						short var56;
						if ((ChatChannel.field996[var53][var55][var54] & var2) != 0) {
							var9 = var54;
							var10 = var54;
							var11 = var53;

							for (var12 = var53; var9 > 0 && (ChatChannel.field996[var53][var55][var9 - 1] & var2) != 0; --var9) {
							}

							while (var10 < 104 && (ChatChannel.field996[var53][var55][var10 + 1] & var2) != 0) {
								++var10;
							}

							label454:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((ChatChannel.field996[var11 - 1][var55][var13] & var2) == 0) {
										break label454;
									}
								}

								--var11;
							}

							label443:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((ChatChannel.field996[var12 + 1][var55][var13] & var2) == 0) {
										break label443;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var56 = 240;
								var15 = Tiles.Tiles_heights[var12][var55][var9] - var56;
								var16 = Tiles.Tiles_heights[var11][var55][var9];
								Scene.Scene_addOccluder(var5, 1, var55 * 128, var55 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = ChatChannel.field996[var17][var55];
										var10000[var18] &= ~var2;
									}
								}
							}
						}

						if ((ChatChannel.field996[var53][var55][var54] & var3) != 0) {
							var9 = var55;
							var10 = var55;
							var11 = var53;

							for (var12 = var53; var9 > 0 && (ChatChannel.field996[var53][var9 - 1][var54] & var3) != 0; --var9) {
							}

							while (var10 < 104 && (ChatChannel.field996[var53][var10 + 1][var54] & var3) != 0) {
								++var10;
							}

							label507:
							while (var11 > 0) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((ChatChannel.field996[var11 - 1][var13][var54] & var3) == 0) {
										break label507;
									}
								}

								--var11;
							}

							label496:
							while (var12 < var5) {
								for (var13 = var9; var13 <= var10; ++var13) {
									if ((ChatChannel.field996[var12 + 1][var13][var54] & var3) == 0) {
										break label496;
									}
								}

								++var12;
							}

							var13 = (var10 - var9 + 1) * (var12 + 1 - var11);
							if (var13 >= 8) {
								var56 = 240;
								var15 = Tiles.Tiles_heights[var12][var9][var54] - var56;
								var16 = Tiles.Tiles_heights[var11][var9][var54];
								Scene.Scene_addOccluder(var5, 2, var9 * 128, var10 * 128 + 128, var54 * 128, var54 * 128, var15, var16);

								for (var17 = var11; var17 <= var12; ++var17) {
									for (var18 = var9; var18 <= var10; ++var18) {
										var10000 = ChatChannel.field996[var17][var18];
										var10000[var54] &= ~var3;
									}
								}
							}
						}

						if ((ChatChannel.field996[var53][var55][var54] & var4) != 0) {
							var9 = var55;
							var10 = var55;
							var11 = var54;

							for (var12 = var54; var11 > 0 && (ChatChannel.field996[var53][var55][var11 - 1] & var4) != 0; --var11) {
							}

							while (var12 < 104 && (ChatChannel.field996[var53][var55][var12 + 1] & var4) != 0) {
								++var12;
							}

							label560:
							while (var9 > 0) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((ChatChannel.field996[var53][var9 - 1][var13] & var4) == 0) {
										break label560;
									}
								}

								--var9;
							}

							label549:
							while (var10 < 104) {
								for (var13 = var11; var13 <= var12; ++var13) {
									if ((ChatChannel.field996[var53][var10 + 1][var13] & var4) == 0) {
										break label549;
									}
								}

								++var10;
							}

							if ((var10 - var9 + 1) * (var12 - var11 + 1) >= 4) {
								var13 = Tiles.Tiles_heights[var53][var9][var11];
								Scene.Scene_addOccluder(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

								for (var14 = var9; var14 <= var10; ++var14) {
									for (var15 = var11; var15 <= var12; ++var15) {
										var10000 = ChatChannel.field996[var53][var14];
										var10000[var15] &= ~var4;
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
