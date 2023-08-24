import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.*;
import java.util.Map.Entry;

@ObfuscatedName("jm")
@Implements("WorldMapRegion")
public class WorldMapRegion {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lkg;"
	)
	@Export("WorldMapRegion_cachedSprites")
	static DemotingHashTable WorldMapRegion_cachedSprites;
	@ObfuscatedName("ai")
	@Export("regionX")
	int regionX;
	@ObfuscatedName("az")
	@Export("regionY")
	int regionY;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Ljx;"
	)
	@Export("worldMapData_0")
	WorldMapData_0 worldMapData_0;
	@ObfuscatedName("aa")
	@Export("worldMapData1List")
	LinkedList worldMapData1List;
	@ObfuscatedName("af")
	@Export("backgroundColor")
	int backgroundColor;
	@ObfuscatedName("ad")
	@Export("pixelsPerTile")
	int pixelsPerTile;
	@ObfuscatedName("aq")
	@Export("icon0List")
	List icon0List;
	@ObfuscatedName("al")
	@Export("iconMap")
	HashMap iconMap;
	@ObfuscatedName("an")
	@Export("fonts")
	final HashMap fonts;

	static {
		WorldMapRegion_cachedSprites = new DemotingHashTable(37748736, 256);
	}

	WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
		this.regionX = var1;
		this.regionY = var2;
		this.worldMapData1List = new LinkedList();
		this.icon0List = new LinkedList();
		this.iconMap = new HashMap();
		this.backgroundColor = var3 | -16777216;
		this.fonts = var4;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "-1536160939"
	)
	void method1436(int var1, int var2, int var3) {
		SpritePixels var4 = class135.method741(this.regionX, this.regionY, this.pixelsPerTile);
		if (var4 != null) {
			if (var3 == this.pixelsPerTile * 64) {
				var4.drawAt(var1, var2);
			} else {
				var4.drawScaledWorldmap(var1, var2, var3, var3);
			}

		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljx;Ljava/util/List;I)V",
		garbageValue = "-2004305210"
	)
	@Export("initWorldMapData0")
	void initWorldMapData0(WorldMapData_0 var1, List var2) {
		this.iconMap.clear();
		this.worldMapData_0 = var1;
		this.addAllToIconList(var2);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/HashSet;Ljava/util/List;I)V",
		garbageValue = "-1161990566"
	)
	@Export("initWorldMapData1")
	void initWorldMapData1(HashSet var1, List var2) {
		this.iconMap.clear();
		Iterator var3 = var1.iterator();

		while (var3.hasNext()) {
			WorldMapData_1 var4 = (WorldMapData_1)var3.next();
			if (var4.getRegionX() == this.regionX && var4.getRegionY() == this.regionY) {
				this.worldMapData1List.add(var4);
			}
		}

		this.addAllToIconList(var2);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IIIILke;I)V",
		garbageValue = "-1191453077"
	)
	@Export("getIconsForTiles")
	void getIconsForTiles(int var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		for (int var6 = var1; var6 < var3 + var1; ++var6) {
			label66:
			for (int var7 = var2; var7 < var2 + var4; ++var7) {
				for (int var8 = 0; var8 < var5.planes; ++var8) {
					WorldMapDecoration[] var9 = var5.decorations[var8][var6][var7];
					if (var9 != null && var9.length != 0) {
						WorldMapDecoration[] var10 = var9;

						for (int var11 = 0; var11 < var10.length; ++var11) {
							ObjectComposition var13;
							boolean var14;
							label57: {
								WorldMapDecoration var12 = var10[var11];
								var13 = WorldMapElement.getObjectDefinition(var12.objectDefinitionId);
								if (var13.transforms != null) {
									int[] var15 = var13.transforms;

									for (int var16 = 0; var16 < var15.length; ++var16) {
										int var17 = var15[var16];
										ObjectComposition var18 = WorldMapElement.getObjectDefinition(var17);
										if (var18.mapIconId != -1) {
											var14 = true;
											break label57;
										}
									}
								} else if (var13.mapIconId != -1) {
									var14 = true;
									break label57;
								}

								var14 = false;
							}

							if (var14) {
								this.getIcon(var13, var8, var6, var7, var5);
								continue label66;
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(Lhv;IIILke;I)V",
		garbageValue = "882689979"
	)
	@Export("getIcon")
	void getIcon(ObjectComposition var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
		Coord var6 = new Coord(var2, var3 + this.regionX * 64, this.regionY * 64 + var4);
		Coord var7 = null;
		if (this.worldMapData_0 != null) {
			var7 = new Coord(this.worldMapData_0.field2428 + var2, var3 + this.worldMapData_0.field2429 * 64, var4 + this.worldMapData_0.field2432 * 64);
		} else {
			WorldMapData_1 var8 = (WorldMapData_1)var5;
			var7 = new Coord(var2 + var8.field2428, var3 + var8.field2429 * 64 + var8.getChunkXLow() * 8, var4 + var8.field2432 * 64 + var8.getChunkYLow() * 8);
		}

		WorldMapElement var9;
		Object var10;
		if (var1.transforms != null) {
			var10 = new WorldMapIcon_1(var7, var6, var1.id, this);
		} else {
			var9 = class138.WorldMapElement_get(var1.mapIconId);
			var10 = new WorldMapIcon_0(var7, var6, var9.objectId, this.createMapLabel(var9));
		}

		var9 = class138.WorldMapElement_get(((AbstractWorldMapIcon)var10).getElement());
		if (var9.field1519) {
			this.iconMap.put(new Coord(0, var3, var4), var10);
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1774548488"
	)
	@Export("initWorldMapIcon1s")
	void initWorldMapIcon1s() {
		Iterator var1 = this.iconMap.values().iterator();

		while (var1.hasNext()) {
			AbstractWorldMapIcon var2 = (AbstractWorldMapIcon)var1.next();
			if (var2 instanceof WorldMapIcon_1) {
				((WorldMapIcon_1)var2).init();
			}
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/List;B)V",
		garbageValue = "67"
	)
	@Export("addAllToIconList")
	void addAllToIconList(List var1) {
		Iterator var2 = var1.iterator();

		while (var2.hasNext()) {
			WorldMapIcon_0 var3 = (WorldMapIcon_0)var2.next();
			if (class138.WorldMapElement_get(var3.element).field1519 && var3.coord2.x >> 6 == this.regionX && var3.coord2.y >> 6 == this.regionY) {
				WorldMapIcon_0 var4 = new WorldMapIcon_0(var3.coord2, var3.coord2, var3.element, this.method1465(var3.element));
				this.icon0List.add(var4);
			}
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2029792015"
	)
	void method1443() {
		if (this.worldMapData_0 != null) {
			this.worldMapData_0.reset();
		} else {
			Iterator var1 = this.worldMapData1List.iterator();

			while (var1.hasNext()) {
				WorldMapData_1 var2 = (WorldMapData_1)var1.next();
				var2.reset();
			}
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(Lnu;B)Z",
		garbageValue = "0"
	)
	@Export("loadGeography")
	boolean loadGeography(AbstractArchive var1) {
		this.iconMap.clear();
		if (this.worldMapData_0 != null) {
			this.worldMapData_0.loadGeography(var1);
			if (this.worldMapData_0.isFullyLoaded()) {
				this.getIconsForTiles(0, 0, 64, 64, this.worldMapData_0);
				return true;
			} else {
				return false;
			}
		} else {
			boolean var2 = true;

			Iterator var3;
			WorldMapData_1 var4;
			for (var3 = this.worldMapData1List.iterator(); var3.hasNext(); var2 &= var4.isFullyLoaded()) {
				var4 = (WorldMapData_1)var3.next();
				var4.loadGeography(var1);
			}

			if (var2) {
				var3 = this.worldMapData1List.iterator();

				while (var3.hasNext()) {
					var4 = (WorldMapData_1)var3.next();
					this.getIconsForTiles(var4.getChunkX() * 8, var4.getChunkY() * 8, 8, 8, var4);
				}
			}

			return var2;
		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(ILku;[Luk;Lnu;Lnu;I)V",
		garbageValue = "-2013967337"
	)
	@Export("drawTile")
	void drawTile(int var1, WorldMapScaleHandler var2, IndexedSprite[] var3, AbstractArchive var4, AbstractArchive var5) {
		this.pixelsPerTile = var1;
		if (this.worldMapData_0 != null || !this.worldMapData1List.isEmpty()) {
			if (class135.method741(this.regionX, this.regionY, var1) == null) {
				boolean var6 = true;
				var6 &= this.loadGeography(var4);
				int var8;
				if (this.worldMapData_0 != null) {
					var8 = this.worldMapData_0.groupId;
				} else {
					var8 = ((AbstractWorldMapData)this.worldMapData1List.getFirst()).groupId;
				}

				var6 &= var5.tryLoadGroup(var8);
				if (var6) {
					byte[] var7 = var5.takeFileFlat(var8);
					WorldMapSprite var9;
					if (var7 == null) {
						var9 = new WorldMapSprite();
					} else {
						var9 = new WorldMapSprite(WorldMapData_1.method1484(var7).pixels);
					}

					SpritePixels var11 = new SpritePixels(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
					var11.setRaster();
					if (this.worldMapData_0 != null) {
						this.method1448(var2, var3, var9);
					} else {
						this.method1449(var2, var3, var9);
					}

					int var12 = this.regionX;
					int var13 = this.regionY;
					int var14 = this.pixelsPerTile;
					DemotingHashTable var15 = WorldMapRegion_cachedSprites;
					long var17 = (long)(var14 << 16 | var12 << 8 | var13);
					var15.put(var11, var17, var11.pixels.length * 4);
					this.method1443();
				}
			}
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IIILjava/util/HashSet;I)V",
		garbageValue = "-949668643"
	)
	void method1446(int var1, int var2, int var3, HashSet var4) {
		if (var4 == null) {
			var4 = new HashSet();
		}

		this.drawNonLinkMapIcons(var1, var2, var4, var3);
		this.drawMapLinks(var1, var2, var4, var3);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/HashSet;III)V",
		garbageValue = "808374140"
	)
	@Export("flashElements")
	void flashElements(HashSet var1, int var2, int var3) {
		Iterator var4 = this.iconMap.values().iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				int var6 = var5.getElement();
				if (var1.contains(var6)) {
					WorldMapElement var7 = class138.WorldMapElement_get(var6);
					this.drawBackgroundCircle(var7, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

		this.method1457(var1, var2, var3);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lku;[Luk;Lkd;B)V",
		garbageValue = "-44"
	)
	void method1448(WorldMapScaleHandler var1, IndexedSprite[] var2, WorldMapSprite var3) {
		int var4;
		int var5;
		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.drawTileGround(var4, var5, this.worldMapData_0, var1, var3);
				this.method1452(var4, var5, this.worldMapData_0, var1);
			}
		}

		for (var4 = 0; var4 < 64; ++var4) {
			for (var5 = 0; var5 < 64; ++var5) {
				this.method1450(var4, var5, this.worldMapData_0, var1, var2);
			}
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Lku;[Luk;Lkd;I)V",
		garbageValue = "-2115982333"
	)
	void method1449(WorldMapScaleHandler var1, IndexedSprite[] var2, WorldMapSprite var3) {
		Iterator var4 = this.worldMapData1List.iterator();

		WorldMapData_1 var5;
		int var6;
		int var7;
		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.drawTileGround(var6, var7, var5, var1, var3);
					this.method1452(var6, var7, var5, var1);
				}
			}
		}

		var4 = this.worldMapData1List.iterator();

		while (var4.hasNext()) {
			var5 = (WorldMapData_1)var4.next();

			for (var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
				for (var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
					this.method1450(var6, var7, var5, var1, var2);
				}
			}
		}

	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IILke;Lku;[Luk;B)V",
		garbageValue = "32"
	)
	void method1450(int var1, int var2, AbstractWorldMapData var3, WorldMapScaleHandler var4, IndexedSprite[] var5) {
		this.method1455(var1, var2, var3);
		this.method1454(var1, var2, var3, var5);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IILke;Lku;Lkd;I)V",
		garbageValue = "-1336656209"
	)
	@Export("drawTileGround")
	void drawTileGround(int var1, int var2, AbstractWorldMapData var3, WorldMapScaleHandler var4, WorldMapSprite var5) {
		int var6 = var3.floorUnderlayIds[0][var1][var2] - 1;
		int var7 = var3.floorOverlayIds[0][var1][var2] - 1;
		if (var6 == -1 && var7 == -1) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, this.backgroundColor);
		}

		int var8 = 16711935;
		int var9;
		if (var7 != -1) {
			int var10 = this.backgroundColor;
			FloorOverlayDefinition var12 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var7);
			FloorOverlayDefinition var11;
			if (var12 != null) {
				var11 = var12;
			} else {
				byte[] var13 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var7);
				var12 = new FloorOverlayDefinition();
				if (var13 != null) {
					var12.decode(new Buffer(var13), var7);
				}

				var12.postDecode();
				FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var12, (long)var7);
				var11 = var12;
			}

			if (var11 == null) {
				var9 = var10;
			} else {
				int var14;
				int var15;
				if (var11.secondaryRgb >= 0) {
					var15 = HitSplatDefinition.method1026(var11.secondaryHue, var11.secondarySaturation, var11.secondaryLightness);
					var14 = ApproximateRouteStrategy.method342(var15, 96);
					var9 = Rasterizer3D.Rasterizer3D_colorPalette[var14] | -16777216;
				} else if (var11.texture >= 0) {
					var15 = ApproximateRouteStrategy.method342(Rasterizer3D.clips.Rasterizer3D_textureLoader.getAverageTextureRGB(var11.texture), 96);
					var9 = Rasterizer3D.Rasterizer3D_colorPalette[var15] | -16777216;
				} else if (var11.primaryRgb == 16711935) {
					var9 = var10;
				} else {
					var15 = HitSplatDefinition.method1026(var11.hue, var11.saturation, var11.lightness);
					var14 = ApproximateRouteStrategy.method342(var15, 96);
					var9 = Rasterizer3D.Rasterizer3D_colorPalette[var14] | -16777216;
				}
			}

			var8 = var9;
		}

		if (var7 > -1 && var3.field2427[0][var1][var2] == 0) {
			Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
		} else {
			var9 = this.method1453(var1, var2, var3, var5);
			if (var7 == -1) {
				Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
			} else {
				var4.method1575(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field2427[0][var1][var2], var3.field2426[0][var1][var2]);
			}
		}
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IILke;Lku;I)V",
		garbageValue = "-1187093526"
	)
	void method1452(int var1, int var2, AbstractWorldMapData var3, WorldMapScaleHandler var4) {
		for (int var5 = 1; var5 < var3.planes; ++var5) {
			int var6 = var3.floorOverlayIds[var5][var1][var2] - 1;
			if (var6 > -1) {
				int var8 = this.backgroundColor;
				FloorOverlayDefinition var10 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var6);
				FloorOverlayDefinition var9;
				if (var10 != null) {
					var9 = var10;
				} else {
					byte[] var11 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var6);
					var10 = new FloorOverlayDefinition();
					if (var11 != null) {
						var10.decode(new Buffer(var11), var6);
					}

					var10.postDecode();
					FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var10, (long)var6);
					var9 = var10;
				}

				int var7;
				if (var9 == null) {
					var7 = var8;
				} else {
					int var12;
					int var13;
					if (var9.secondaryRgb >= 0) {
						var13 = HitSplatDefinition.method1026(var9.secondaryHue, var9.secondarySaturation, var9.secondaryLightness);
						var12 = ApproximateRouteStrategy.method342(var13, 96);
						var7 = Rasterizer3D.Rasterizer3D_colorPalette[var12] | -16777216;
					} else if (var9.texture >= 0) {
						var13 = ApproximateRouteStrategy.method342(Rasterizer3D.clips.Rasterizer3D_textureLoader.getAverageTextureRGB(var9.texture), 96);
						var7 = Rasterizer3D.Rasterizer3D_colorPalette[var13] | -16777216;
					} else if (var9.primaryRgb == 16711935) {
						var7 = var8;
					} else {
						var13 = HitSplatDefinition.method1026(var9.hue, var9.saturation, var9.lightness);
						var12 = ApproximateRouteStrategy.method342(var13, 96);
						var7 = Rasterizer3D.Rasterizer3D_colorPalette[var12] | -16777216;
					}
				}

				if (var3.field2427[var5][var1][var2] == 0) {
					Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
				} else {
					var4.method1575(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field2427[var5][var1][var2], var3.field2426[var5][var1][var2]);
				}
			}
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IILke;Lkd;I)I",
		garbageValue = "-1267425507"
	)
	int method1453(int var1, int var2, AbstractWorldMapData var3, WorldMapSprite var4) {
		return var3.floorUnderlayIds[0][var1][var2] == 0 ? this.backgroundColor : var4.getTileColor(var1, var2);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IILke;[Luk;I)V",
		garbageValue = "-2109687749"
	)
	void method1454(int var1, int var2, AbstractWorldMapData var3, IndexedSprite[] var4) {
		for (int var5 = 0; var5 < var3.planes; ++var5) {
			WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
			if (var6 != null && var6.length != 0) {
				WorldMapDecoration[] var7 = var6;

				for (int var8 = 0; var8 < var7.length; ++var8) {
					WorldMapDecoration var9 = var7[var8];
					if (!WorldMapLabel.method1534(var9.decoration)) {
						int var11 = var9.decoration;
						boolean var10 = var11 == WorldMapDecorationType.field3120.id;
						if (!var10) {
							continue;
						}
					}

					ObjectComposition var12 = WorldMapElement.getObjectDefinition(var9.objectDefinitionId);
					if (var12.mapSceneId != -1) {
						if (var12.mapSceneId != 46 && var12.mapSceneId != 52) {
							var4[var12.mapSceneId].method2654(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
						} else {
							var4[var12.mapSceneId].method2654(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IILke;I)V",
		garbageValue = "-1752874267"
	)
	void method1455(int var1, int var2, AbstractWorldMapData var3) {
		for (int var4 = 0; var4 < var3.planes; ++var4) {
			WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
			if (var5 != null && var5.length != 0) {
				WorldMapDecoration[] var6 = var5;

				for (int var7 = 0; var7 < var6.length; ++var7) {
					WorldMapDecoration var8 = var6[var7];
					if (class101.method598(var8.decoration)) {
						ObjectComposition var9 = WorldMapElement.getObjectDefinition(var8.objectDefinitionId);
						int var10 = var9.int1 != 0 ? -3407872 : -3355444;
						if (var8.decoration == WorldMapDecorationType.field3123.id) {
							this.method1469(var1, var2, var8.rotation, var10);
						}

						if (var8.decoration == WorldMapDecorationType.field3121.id) {
							this.method1469(var1, var2, var8.rotation, -3355444);
							this.method1469(var1, var2, var8.rotation + 1, var10);
						}

						if (var8.decoration == WorldMapDecorationType.field3122.id) {
							if (var8.rotation == 0) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var10);
							}

							if (var8.rotation == 1) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), 1, var10);
							}

							if (var8.rotation == 2) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile + this.pixelsPerTile * var1 - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var10);
							}

							if (var8.rotation == 3) {
								Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var10);
							}
						}

						if (var8.decoration == WorldMapDecorationType.field3119.id) {
							int var11 = var8.rotation % 2;
							int var12;
							if (var11 == 0) {
								for (var12 = 0; var12 < this.pixelsPerTile; ++var12) {
									Rasterizer2D.Rasterizer2D_drawHorizontalLine(var12 + this.pixelsPerTile * var1, (64 - var2) * this.pixelsPerTile - 1 - var12, 1, var10);
								}
							} else {
								for (var12 = 0; var12 < this.pixelsPerTile; ++var12) {
									Rasterizer2D.Rasterizer2D_drawHorizontalLine(var12 + this.pixelsPerTile * var1, var12 + this.pixelsPerTile * (63 - var2), 1, var10);
								}
							}
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IILjava/util/HashSet;IB)V",
		garbageValue = "-13"
	)
	@Export("drawNonLinkMapIcons")
	void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
		float var5 = (float)var4 / 64.0F;
		float var6 = var5 / 2.0F;
		Iterator var7 = this.iconMap.entrySet().iterator();

		while (var7.hasNext()) {
			Entry var8 = (Entry)var7.next();
			Coord var9 = (Coord)var8.getKey();
			int var10 = (int)((float)var1 + var5 * (float)var9.x - var6);
			int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.y - var6);
			AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var8.getValue();
			if (var12 != null && var12.hasValidElement()) {
				var12.screenX = var10;
				var12.screenY = var11;
				WorldMapElement var13 = class138.WorldMapElement_get(var12.getElement());
				if (!var3.contains(var13.getObjectId())) {
					this.method1459(var12, var10, var11, var5);
				}
			}
		}

	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/HashSet;III)V",
		garbageValue = "1452687017"
	)
	void method1457(HashSet var1, int var2, int var3) {
		Iterator var4 = this.icon0List.iterator();

		while (var4.hasNext()) {
			AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
			if (var5.hasValidElement()) {
				WorldMapElement var6 = class138.WorldMapElement_get(var5.getElement());
				if (var6 != null && var1.contains(var6.getObjectId())) {
					this.drawBackgroundCircle(var6, var5.screenX, var5.screenY, var2, var3);
				}
			}
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lhd;IIIII)V",
		garbageValue = "-54232319"
	)
	@Export("drawBackgroundCircle")
	void drawBackgroundCircle(WorldMapElement var1, int var2, int var3, int var4, int var5) {
		SpritePixels var6 = var1.getSpriteBool(false);
		if (var6 != null) {
			var6.drawTransBgAt(var2 - var6.subWidth / 2, var3 - var6.subHeight / 2);
			if (var4 % var5 < var5 / 2) {
				Rasterizer2D.Rasterizer2D_drawCircleAlpha(var2, var3, 15, 16776960, 128);
				Rasterizer2D.Rasterizer2D_drawCircleAlpha(var2, var3, 7, 16777215, 256);
			}

		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lkp;IIFB)V",
		garbageValue = "-45"
	)
	void method1459(AbstractWorldMapIcon var1, int var2, int var3, float var4) {
		WorldMapElement var5 = class138.WorldMapElement_get(var1.getElement());
		this.method1460(var5, var2, var3);
		this.method1461(var1, var5, var2, var3, var4);
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(Lhd;III)V",
		garbageValue = "1788573667"
	)
	void method1460(WorldMapElement var1, int var2, int var3) {
		SpritePixels var4 = var1.getSpriteBool(false);
		if (var4 != null) {
			int var5 = this.method1463(var4, var1.horizontalAlignment);
			int var6 = this.method1464(var4, var1.verticalAlignment);
			var4.drawTransBgAt(var5 + var2, var3 + var6);
		}

	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(Lkp;Lhd;IIFI)V",
		garbageValue = "1203085844"
	)
	void method1461(AbstractWorldMapIcon var1, WorldMapElement var2, int var3, int var4, float var5) {
		WorldMapLabel var6 = var1.getLabel();
		if (var6 != null) {
			if (var6.size.method1394(var5)) {
				Font var7 = (Font)this.fonts.get(var6.size);
				var7.drawLines(var6.text, var3 - var6.width / 2, var4, var6.width, var6.height, -16777216 | var2.field1522, 0, 1, 0, var7.ascent / 2);
			}
		}
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(IILjava/util/HashSet;IB)V",
		garbageValue = "-21"
	)
	@Export("drawMapLinks")
	void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
		float var5 = (float)var4 / 64.0F;
		Iterator var6 = this.icon0List.iterator();

		while (var6.hasNext()) {
			AbstractWorldMapIcon var7 = (AbstractWorldMapIcon)var6.next();
			if (var7.hasValidElement()) {
				int var8 = var7.coord2.x % 64;
				int var9 = var7.coord2.y % 64;
				var7.screenX = (int)((float)var1 + var5 * (float)var8);
				var7.screenY = (int)(var5 * (float)(63 - var9) + (float)var2);
				if (!var3.contains(var7.getElement())) {
					this.method1459(var7, var7.screenX, var7.screenY, var5);
				}
			}
		}

	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(Lui;Lhe;I)I",
		garbageValue = "2074198968"
	)
	int method1463(SpritePixels var1, HorizontalAlignment var2) {
		switch(var2.value) {
		case 0:
			return 0;
		case 2:
			return -var1.subWidth / 2;
		default:
			return -var1.subWidth;
		}
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(Lui;Lhy;I)I",
		garbageValue = "693958436"
	)
	int method1464(SpritePixels var1, VerticalAlignment var2) {
		switch(var2.value) {
		case 0:
			return -var1.subHeight / 2;
		case 1:
			return 0;
		default:
			return -var1.subHeight;
		}
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(IB)Lkq;",
		garbageValue = "-90"
	)
	WorldMapLabel method1465(int var1) {
		WorldMapElement var2 = class138.WorldMapElement_get(var1);
		return this.createMapLabel(var2);
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(Lhd;I)Lkq;",
		garbageValue = "-1839741951"
	)
	@Export("createMapLabel")
	WorldMapLabel createMapLabel(WorldMapElement var1) {
		if (var1.name != null && this.fonts != null && this.fonts.get(WorldMapLabelSize.WorldMapLabelSize_small) != null) {
			int var3 = var1.textSize;
			WorldMapLabelSize[] var4 = new WorldMapLabelSize[]{WorldMapLabelSize.WorldMapLabelSize_small, WorldMapLabelSize.WorldMapLabelSize_medium, WorldMapLabelSize.WorldMapLabelSize_large};
			WorldMapLabelSize[] var5 = var4;
			int var6 = 0;

			WorldMapLabelSize var2;
			while (true) {
				if (var6 >= var5.length) {
					var2 = null;
					break;
				}

				WorldMapLabelSize var7 = var5[var6];
				if (var3 == var7.field2324) {
					var2 = var7;
					break;
				}

				++var6;
			}

			if (var2 == null) {
				return null;
			} else {
				Font var14 = (Font)this.fonts.get(var2);
				if (var14 == null) {
					return null;
				} else {
					var6 = var14.lineCount(var1.name, 1000000);
					String[] var15 = new String[var6];
					var14.breakLines(var1.name, (int[])null, var15);
					int var8 = var15.length * var14.ascent / 2;
					int var9 = 0;
					String[] var10 = var15;

					for (int var11 = 0; var11 < var10.length; ++var11) {
						String var12 = var10[var11];
						int var13 = var14.stringWidth(var12);
						if (var13 > var9) {
							var9 = var13;
						}
					}

					return new WorldMapLabel(var1.name, var9, var8, var2);
				}
			}
		} else {
			return null;
		}
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(IIIIIB)Ljava/util/List;",
		garbageValue = "4"
	)
	List method1467(int var1, int var2, int var3, int var4, int var5) {
		LinkedList var6 = new LinkedList();
		if (var4 >= var1 && var5 >= var2) {
			if (var4 < var3 + var1 && var5 < var3 + var2) {
				Iterator var7 = this.iconMap.values().iterator();

				AbstractWorldMapIcon var8;
				while (var7.hasNext()) {
					var8 = (AbstractWorldMapIcon)var7.next();
					if (var8.hasValidElement() && var8.fitsScreen(var4, var5)) {
						var6.add(var8);
					}
				}

				var7 = this.icon0List.iterator();

				while (var7.hasNext()) {
					var8 = (AbstractWorldMapIcon)var7.next();
					if (var8.hasValidElement() && var8.fitsScreen(var4, var5)) {
						var6.add(var8);
					}
				}

				return var6;
			} else {
				return var6;
			}
		} else {
			return var6;
		}
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/util/List;",
		garbageValue = "4"
	)
	@Export("icons")
	List icons() {
		LinkedList var1 = new LinkedList();
		var1.addAll(this.icon0List);
		var1.addAll(this.iconMap.values());
		return var1;
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "-29"
	)
	void method1469(int var1, int var2, int var3, int var4) {
		var3 %= 4;
		if (var3 == 0) {
			Rasterizer2D.Rasterizer2D_drawVerticalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 1) {
			Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 2) {
			Rasterizer2D.Rasterizer2D_drawVerticalLine(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, var4);
		}

		if (var3 == 3) {
			Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, this.pixelsPerTile, var4);
		}

	}
}