import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.List;
import java.util.*;

@ObfuscatedName("kk")
@Implements("WorldMapManager")
public final class WorldMapManager {
	@ObfuscatedName("ac")
	@Export("loaded")
	boolean loaded;
	@ObfuscatedName("al")
	boolean field2380;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Llj;"
	)
	@Export("mapAreaData")
	WorldMapAreaData mapAreaData;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lud;"
	)
	@Export("compositeTextureSprite")
	SpritePixels compositeTextureSprite;
	@ObfuscatedName("ao")
	@Export("icons")
	HashMap icons;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "[[Lke;"
	)
	@Export("regions")
	WorldMapRegion[][] regions;
	@ObfuscatedName("ar")
	@Export("scaleHandlers")
	HashMap scaleHandlers;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "[Lun;"
	)
	@Export("mapSceneSprites")
	IndexedSprite[] mapSceneSprites;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	@Export("geographyArchive")
	final AbstractArchive geographyArchive;
	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	@Export("groundArchive")
	final AbstractArchive groundArchive;
	@ObfuscatedName("ag")
	@Export("fonts")
	final HashMap fonts;
	@ObfuscatedName("aa")
	@Export("tileX")
	int tileX;
	@ObfuscatedName("ap")
	@Export("tileY")
	int tileY;
	@ObfuscatedName("ay")
	@Export("tileWidth")
	int tileWidth;
	@ObfuscatedName("as")
	@Export("tileHeight")
	int tileHeight;
	@ObfuscatedName("aj")
	@Export("pixelsPerTile")
	public int pixelsPerTile;

	@ObfuscatedSignature(
		descriptor = "([Lun;Ljava/util/HashMap;Lom;Lom;)V"
	)
	public WorldMapManager(IndexedSprite[] var1, HashMap var2, AbstractArchive var3, AbstractArchive var4) {
		this.loaded = false;
		this.field2380 = false;
		this.scaleHandlers = new HashMap();
		this.pixelsPerTile = 0;
		this.mapSceneSprites = var1;
		this.fonts = var2;
		this.geographyArchive = var3;
		this.groundArchive = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;Ljava/lang/String;ZZB)V",
		garbageValue = "121"
	)
	public void method1509(AbstractArchive var1, String var2, boolean var3, boolean var4) {
		if (!this.field2380) {
			this.loaded = false;
			this.field2380 = true;
			System.nanoTime();
			int var5 = var1.getGroupId(WorldMapCacheName.field2482.name);
			int var6 = var1.getFileId(var5, var2);
			Buffer var7 = new Buffer(var1.takeFileByNames(WorldMapCacheName.field2482.name, var2));
			Buffer var8 = new Buffer(var1.takeFileByNames(WorldMapCacheName.field2484.name, var2));
			System.nanoTime();
			System.nanoTime();
			this.mapAreaData = new WorldMapAreaData();

			try {
				this.mapAreaData.method1599(var7, var8, var6, var3, var4);
			} catch (IllegalStateException var20) {
				return;
			}

			this.mapAreaData.getOriginX();
			this.mapAreaData.getOriginPlane();
			this.mapAreaData.getOriginY();
			this.tileX = this.mapAreaData.getRegionLowX() * 64;
			this.tileY = this.mapAreaData.getRegionLowY() * 64;
			this.tileWidth = (this.mapAreaData.getRegionHighX() - this.mapAreaData.getRegionLowX() + 1) * 64;
			this.tileHeight = (this.mapAreaData.getRegionHighY() - this.mapAreaData.getRegionLowY() + 1) * 64;
			int var17 = this.mapAreaData.getRegionHighX() - this.mapAreaData.getRegionLowX() + 1;
			int var10 = this.mapAreaData.getRegionHighY() - this.mapAreaData.getRegionLowY() + 1;
			System.nanoTime();
			System.nanoTime();
			class139.method737();
			this.regions = new WorldMapRegion[var17][var10];
			Iterator var11 = this.mapAreaData.field2489.iterator();

			while (var11.hasNext()) {
				WorldMapData_0 var12 = (WorldMapData_0)var11.next();
				int var13 = var12.regionX;
				int var14 = var12.regionY;
				int var15 = var13 - this.mapAreaData.getRegionLowX();
				int var16 = var14 - this.mapAreaData.getRegionLowY();
				this.regions[var15][var16] = new WorldMapRegion(var13, var14, this.mapAreaData.method1463(), this.fonts);
				this.regions[var15][var16].initWorldMapData0(var12, this.mapAreaData.iconList);
			}

			for (int var18 = 0; var18 < var17; ++var18) {
				for (int var19 = 0; var19 < var10; ++var19) {
					if (this.regions[var18][var19] == null) {
						this.regions[var18][var19] = new WorldMapRegion(this.mapAreaData.getRegionLowX() + var18, this.mapAreaData.getRegionLowY() + var19, this.mapAreaData.method1463(), this.fonts);
						this.regions[var18][var19].initWorldMapData1(this.mapAreaData.field2488, this.mapAreaData.iconList);
					}
				}
			}

			System.nanoTime();
			System.nanoTime();
			if (var1.isValidFileName(WorldMapCacheName.field2483.name, var2)) {
				byte[] var21 = var1.takeFileByNames(WorldMapCacheName.field2483.name, var2);
				this.compositeTextureSprite = Frames.method1335(var21);
			}

			System.nanoTime();
			var1.clearGroups();
			var1.method1950();
			this.loaded = true;
		}
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-236187865"
	)
	@Export("clearIcons")
	public final void clearIcons() {
		this.icons = null;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIII)V",
		garbageValue = "909385403"
	)
	@Export("drawTiles")
	public final void drawTiles(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		int[] var9 = Rasterizer2D.Rasterizer2D_pixels;
		int var10 = Rasterizer2D.Rasterizer2D_width;
		int var11 = Rasterizer2D.Rasterizer2D_height;
		float[] var12 = Rasterizer2D.field4244;
		int[] var13 = new int[4];
		Rasterizer2D.Rasterizer2D_getClipArray(var13);
		WorldMapRectangle var14 = this.createWorldMapRectangle(var1, var2, var3, var4);
		float var15 = this.getPixelsPerTile(var7 - var5, var3 - var1);
		int var16 = (int)Math.ceil((double)var15);
		this.pixelsPerTile = var16;
		if (!this.scaleHandlers.containsKey(var16)) {
			WorldMapScaleHandler var17 = new WorldMapScaleHandler(var16);
			var17.init();
			this.scaleHandlers.put(var16, var17);
		}

		int var24 = var14.width + var14.x - 1;
		int var18 = var14.y + var14.height - 1;

		int var19;
		int var20;
		for (var19 = var14.x; var19 <= var24; ++var19) {
			for (var20 = var14.y; var20 <= var18; ++var20) {
				this.regions[var19][var20].drawTile(var16, (WorldMapScaleHandler)this.scaleHandlers.get(var16), this.mapSceneSprites, this.geographyArchive, this.groundArchive);
			}
		}

		Rasterizer3D.method1247(var9, var10, var11, var12);
		Rasterizer2D.Rasterizer2D_setClipArray(var13);
		var19 = (int)(var15 * 64.0F);
		var20 = this.tileX + var1;
		int var21 = var2 + this.tileY;

		for (int var22 = var14.x; var22 < var14.x + var14.width; ++var22) {
			for (int var23 = var14.y; var23 < var14.height + var14.y; ++var23) {
				this.regions[var22][var23].method1475(var5 + (this.regions[var22][var23].regionX * 64 - var20) * var19 / 64, var8 - (this.regions[var22][var23].regionY * 64 - var21 + 64) * var19 / 64, var19);
			}
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIILjava/util/HashSet;Ljava/util/HashSet;IIZI)V",
		garbageValue = "-1519783799"
	)
	@Export("drawElements")
	public final void drawElements(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, HashSet var9, HashSet var10, int var11, int var12, boolean var13) {
		WorldMapRectangle var14 = this.createWorldMapRectangle(var1, var2, var3, var4);
		float var15 = this.getPixelsPerTile(var7 - var5, var3 - var1);
		int var16 = (int)(var15 * 64.0F);
		int var17 = this.tileX + var1;
		int var18 = var2 + this.tileY;

		int var19;
		int var20;
		for (var19 = var14.x; var19 < var14.x + var14.width; ++var19) {
			for (var20 = var14.y; var20 < var14.y + var14.height; ++var20) {
				if (var13) {
					this.regions[var19][var20].initWorldMapIcon1s();
				}

				this.regions[var19][var20].method1485(var5 + (this.regions[var19][var20].regionX * 64 - var17) * var16 / 64, var8 - (this.regions[var19][var20].regionY * 64 - var18 + 64) * var16 / 64, var16, var9);
			}
		}

		if (var10 != null && var11 > 0) {
			for (var19 = var14.x; var19 < var14.width + var14.x; ++var19) {
				for (var20 = var14.y; var20 < var14.height + var14.y; ++var20) {
					this.regions[var19][var20].flashElements(var10, var11, var12);
				}
			}
		}

	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIIILjava/util/HashSet;IIB)V",
		garbageValue = "65"
	)
	@Export("drawOverview")
	public void drawOverview(int var1, int var2, int var3, int var4, HashSet var5, int var6, int var7) {
		if (this.compositeTextureSprite != null) {
			this.compositeTextureSprite.drawScaledAt(var1, var2, var3, var4);
			if (var6 > 0 && var6 % var7 < var7 / 2) {
				if (this.icons == null) {
					this.buildIcons0();
				}

				Iterator var8 = var5.iterator();

				while (true) {
					List var10;
					do {
						if (!var8.hasNext()) {
							return;
						}

						int var9 = (Integer)var8.next();
						var10 = (List)this.icons.get(var9);
					} while(var10 == null);

					Iterator var11 = var10.iterator();

					while (var11.hasNext()) {
						AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var11.next();
						int var13 = var3 * (var12.coord2.x - this.tileX) / this.tileWidth;
						int var14 = var4 - (var12.coord2.y - this.tileY) * var4 / this.tileHeight;
						Rasterizer2D.Rasterizer2D_drawCircleAlpha(var13 + var1, var14 + var2, 2, 16776960, 256);
					}
				}
			}
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIIIB)Ljava/util/List;",
		garbageValue = "13"
	)
	public List method1514(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
		LinkedList var11 = new LinkedList();
		if (!this.loaded) {
			return var11;
		} else {
			WorldMapRectangle var12 = this.createWorldMapRectangle(var1, var2, var3, var4);
			float var13 = this.getPixelsPerTile(var7, var3 - var1);
			int var14 = (int)(64.0F * var13);
			int var15 = this.tileX + var1;
			int var16 = var2 + this.tileY;

			for (int var17 = var12.x; var17 < var12.x + var12.width; ++var17) {
				for (int var18 = var12.y; var18 < var12.y + var12.height; ++var18) {
					List var19 = this.regions[var17][var18].method1506(var5 + (this.regions[var17][var18].regionX * 64 - var15) * var14 / 64, var8 + var6 - (this.regions[var17][var18].regionY * 64 - var16 + 64) * var14 / 64, var14, var9, var10);
					if (!var19.isEmpty()) {
						var11.addAll(var19);
					}
				}
			}

			return var11;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIIII)Lkx;",
		garbageValue = "-1144444981"
	)
	@Export("createWorldMapRectangle")
	WorldMapRectangle createWorldMapRectangle(int var1, int var2, int var3, int var4) {
		WorldMapRectangle var5 = new WorldMapRectangle(this);
		int var6 = this.tileX + var1;
		int var7 = var2 + this.tileY;
		int var8 = var3 + this.tileX;
		int var9 = var4 + this.tileY;
		int var10 = var6 / 64;
		int var11 = var7 / 64;
		int var12 = var8 / 64;
		int var13 = var9 / 64;
		var5.width = var12 - var10 + 1;
		var5.height = var13 - var11 + 1;
		var5.x = var10 - this.mapAreaData.getRegionLowX();
		var5.y = var11 - this.mapAreaData.getRegionLowY();
		if (var5.x < 0) {
			var5.width += var5.x;
			var5.x = 0;
		}

		if (var5.x > this.regions.length - var5.width) {
			var5.width = this.regions.length - var5.x;
		}

		if (var5.y < 0) {
			var5.height += var5.y;
			var5.y = 0;
		}

		if (var5.y > this.regions[0].length - var5.height) {
			var5.height = this.regions[0].length - var5.y;
		}

		var5.width = Math.min(var5.width, this.regions.length);
		var5.height = Math.min(var5.height, this.regions[0].length);
		return var5;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1564953955"
	)
	@Export("isLoaded")
	public boolean isLoaded() {
		return this.loaded;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1360371503"
	)
	public int method1517() {
		return this.mapAreaData.method1464();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/util/HashMap;",
		garbageValue = "-868447675"
	)
	@Export("buildIcons")
	public HashMap buildIcons() {
		this.buildIcons0();
		return this.icons;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "76"
	)
	@Export("buildIcons0")
	void buildIcons0() {
		if (this.icons == null) {
			this.icons = new HashMap();
		}

		this.icons.clear();

		for (int var1 = 0; var1 < this.regions.length; ++var1) {
			for (int var2 = 0; var2 < this.regions[var1].length; ++var2) {
				List var3 = this.regions[var1][var2].icons();
				Iterator var4 = var3.iterator();

				while (var4.hasNext()) {
					AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
					if (var5.hasValidElement()) {
						int var6 = var5.getElement();
						if (!this.icons.containsKey(var6)) {
							LinkedList var7 = new LinkedList();
							var7.add(var5);
							this.icons.put(var6, var7);
						} else {
							List var8 = (List)this.icons.get(var6);
							var8.add(var5);
						}
					}
				}
			}
		}

	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(III)F",
		garbageValue = "-56693416"
	)
	@Export("getPixelsPerTile")
	float getPixelsPerTile(int var1, int var2) {
		float var3 = (float)var1 / (float)var2;
		if (var3 > 8.0F) {
			return 8.0F;
		} else if (var3 < 1.0F) {
			return 1.0F;
		} else {
			int var4 = Math.round(var3);
			return Math.abs((float)var4 - var3) < 0.05F ? (float)var4 : var3;
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lbb;Lpu;Lpu;B)V",
		garbageValue = "77"
	)
	static void method1521(GameEngine var0, Font var1, Font var2) {
		int var5;
		boolean var11;
		int var40;
		int var41;
		boolean var55;
		if (Login.worldSelectOpen) {
			class226 var39 = class284.method1573();

			while (true) {
				if (!var39.method1148()) {
					if (MouseHandler.MouseHandler_lastButton != 1 && (UserComparator8.mouseCam || MouseHandler.MouseHandler_lastButton != 4)) {
						break;
					}

					int var4 = Login.xPadding + 280;
					if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						MouseHandler.changeWorldSelectSorting(0, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						MouseHandler.changeWorldSelectSorting(0, 1);
						break;
					}

					var5 = Login.xPadding + 390;
					if (MouseHandler.MouseHandler_lastPressedX >= var5 && MouseHandler.MouseHandler_lastPressedX <= var5 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						MouseHandler.changeWorldSelectSorting(1, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var5 + 15 && MouseHandler.MouseHandler_lastPressedX <= var5 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						MouseHandler.changeWorldSelectSorting(1, 1);
						break;
					}

					var40 = Login.xPadding + 500;
					if (MouseHandler.MouseHandler_lastPressedX >= var40 && MouseHandler.MouseHandler_lastPressedX <= var40 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						MouseHandler.changeWorldSelectSorting(2, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var40 + 15 && MouseHandler.MouseHandler_lastPressedX <= var40 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						MouseHandler.changeWorldSelectSorting(2, 1);
						break;
					}

					var41 = Login.xPadding + 610;
					if (MouseHandler.MouseHandler_lastPressedX >= var41 && MouseHandler.MouseHandler_lastPressedX <= var41 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						MouseHandler.changeWorldSelectSorting(3, 0);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= var41 + 15 && MouseHandler.MouseHandler_lastPressedX <= var41 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
						MouseHandler.changeWorldSelectSorting(3, 1);
						break;
					}

					if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
						Login.worldSelectOpen = false;
						PcmPlayer.leftTitleSprite.drawAt(Login.xPadding, 0);
						Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
						break;
					}

					if (Login.hoveredWorldIndex != -1) {
						World var42 = UserComparator3.World_worlds[Login.hoveredWorldIndex];
						if (var42.isDeadman()) {
							var42.field680 = "beta";
						}

						var55 = false;
						if (var42.properties != Client.worldProperties) {
							boolean var56 = (Client.worldProperties & class525.field4156.rsOrdinal()) != 0;
							var11 = var42.isDeadman();
							if (var56 && !var11 || !var56 && var11) {
								var55 = true;
							}
						}

						Language.changeWorld(var42);
						Login.worldSelectOpen = false;
						PcmPlayer.leftTitleSprite.drawAt(Login.xPadding, 0);
						Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
						Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
						if (var55) {
							class140.reloadJS5();
						}
					} else {
						if (Login.worldSelectPage > 0 && class372.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= class372.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= class491.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class491.canvasHeight / 2 + 50) {
							--Login.worldSelectPage;
						}

						if (Login.worldSelectPage < Login.worldSelectPagesCount && class230.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= class340.canvasWidth - class230.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= class340.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= class491.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class491.canvasHeight / 2 + 50) {
							++Login.worldSelectPage;
						}
					}
					break;
				}

				if (var39.field1901 == 13) {
					Login.worldSelectOpen = false;
					PcmPlayer.leftTitleSprite.drawAt(Login.xPadding, 0);
					Login.rightTitleSprite.drawAt(Login.xPadding + 382, 0);
					Login.logoSprite.drawAt(Login.xPadding + 382 - Login.logoSprite.subWidth / 2, 18);
					break;
				}

				if (var39.field1901 == 96) {
					if (Login.worldSelectPage > 0 && class372.worldSelectLeftSprite != null) {
						--Login.worldSelectPage;
					}
				} else if (var39.field1901 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && class230.worldSelectRightSprite != null) {
					++Login.worldSelectPage;
				}
			}

		} else {
			if ((MouseHandler.MouseHandler_lastButton == 1 || !UserComparator8.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 765 - 50 && MouseHandler.MouseHandler_lastPressedY >= 453) {
				class91.clientPreferences.getTitleMusicDisabled(!class91.clientPreferences.getTitleMusicDisabled());
				if (!class91.clientPreferences.getTitleMusicDisabled()) {
					ArrayList var3 = new ArrayList();
					var3.add(new MusicSong(CollisionMap.archive6, "scape main", "", 255, false));
					class148.method776(var3, 0, 0, 0, 100, false);
				} else {
					ItemComposition.method1088(0, 0);
				}

				class470.method2362();
			}

			if (Client.gameState != 5) {
				if (Login.field771 == -1L) {
					Login.field771 = GrandExchangeOfferTotalQuantityComparator.method1971() + 1000L;
				}

				long var23 = GrandExchangeOfferTotalQuantityComparator.method1971();
				if (ObjectSound.method415() && Login.field770 == -1L) {
					Login.field770 = var23;
					if (Login.field770 > Login.field771) {
						Login.field771 = Login.field770;
					}
				}

				if (Client.gameState == 10 || Client.gameState == 11) {
					if (WorldMapLabelSize.clientLanguage == Language.Language_EN) {
						if (MouseHandler.MouseHandler_lastButton == 1 || !UserComparator8.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
							var5 = Login.xPadding + 5;
							short var6 = 463;
							byte var7 = 100;
							byte var25 = 35;
							if (MouseHandler.MouseHandler_lastPressedX >= var5 && MouseHandler.MouseHandler_lastPressedX <= var5 + var7 && MouseHandler.MouseHandler_lastPressedY >= var6 && MouseHandler.MouseHandler_lastPressedY <= var6 + var25) {
								if (Canvas.loadWorlds()) {
									Login.worldSelectOpen = true;
									Login.worldSelectPage = 0;
									Login.worldSelectPagesCount = 0;
								}

								return;
							}
						}

						if (class91.World_request != null && Canvas.loadWorlds()) {
							Login.worldSelectOpen = true;
							Login.worldSelectPage = 0;
							Login.worldSelectPagesCount = 0;
						}
					}

					var5 = MouseHandler.MouseHandler_lastButton;
					var40 = MouseHandler.MouseHandler_lastPressedX;
					var41 = MouseHandler.MouseHandler_lastPressedY;
					if (var5 == 0) {
						var40 = MouseHandler.MouseHandler_x;
						var41 = MouseHandler.MouseHandler_y;
					}

					if (!UserComparator8.mouseCam && var5 == 4) {
						var5 = 1;
					}

					class226 var8 = class284.method1573();
					short var44;
					int var45;
					if (Login.loginIndex == 0) {
						var55 = false;

						while (var8.method1148()) {
							if (var8.field1901 == 84) {
								var55 = true;
							}
						}

						var45 = class379.loginBoxCenter - 80;
						var44 = 291;
						if (var5 == 1 && var40 >= var45 - 75 && var40 <= var45 + 75 && var41 >= var44 - 20 && var41 <= var44 + 20) {
							VertexNormal.openURL(ScriptEvent.method474("secure", true) + "m=account-creation/g=oldscape/create_account_funnel.ws", true, false);
						}

						var45 = class379.loginBoxCenter + 80;
						if (var5 == 1 && var40 >= var45 - 75 && var40 <= var45 + 75 && var41 >= var44 - 20 && var41 <= var44 + 20 || var55) {
							if ((Client.worldProperties & class525.field4151.rsOrdinal()) != 0) {
								Login.Login_response0 = "";
								Login.Login_response1 = "This is a <col=00ffff>Beta<col=ffffff> world.";
								Login.Login_response2 = "Your normal account will not be affected.";
								Login.Login_response3 = "";
								GameEngine.method166(1);
								if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
									Login.currentLoginField = 1;
								} else {
									Login.currentLoginField = 0;
								}
							} else if ((Client.worldProperties & class525.field4153.rsOrdinal()) != 0) {
								if ((Client.worldProperties & class525.field4152.rsOrdinal()) != 0) {
									Login.Login_response1 = "This is a <col=ffff00>High Risk <col=ff0000>PvP<col=ffffff> world.";
									Login.Login_response2 = "Players can attack each other almost everywhere";
									Login.Login_response3 = "and the Protect Item prayer won't work.";
								} else {
									Login.Login_response1 = "This is a <col=ff0000>PvP<col=ffffff> world.";
									Login.Login_response2 = "Players can attack each other";
									Login.Login_response3 = "almost everywhere.";
								}

								Login.Login_response0 = "Warning!";
								GameEngine.method166(1);
								if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
									Login.currentLoginField = 1;
								} else {
									Login.currentLoginField = 0;
								}
							} else if ((Client.worldProperties & class525.field4152.rsOrdinal()) != 0) {
								Login.Login_response1 = "This is a <col=ffff00>High Risk<col=ffffff> world.";
								Login.Login_response2 = "The Protect Item prayer will";
								Login.Login_response3 = "not work on this world.";
								Login.Login_response0 = "Warning!";
								GameEngine.method166(1);
								if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
									Login.currentLoginField = 1;
								} else {
									Login.currentLoginField = 0;
								}
							} else {
								class429.Login_promptCredentials(false);
							}
						}
					} else {
						int var9;
						short var10;
						if (Login.loginIndex == 1) {
							while (true) {
								if (!var8.method1148()) {
									var9 = class379.loginBoxCenter - 80;
									var10 = 321;
									if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
										class429.Login_promptCredentials(false);
									}

									var9 = class379.loginBoxCenter + 80;
									if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
										GameEngine.method166(0);
									}
									break;
								}

								if (var8.field1901 == 84) {
									class429.Login_promptCredentials(false);
								} else if (var8.field1901 == 13) {
									GameEngine.method166(0);
								}
							}
						} else {
							int var13;
							int var14;
							int var30;
							short var43;
							boolean var47;
							if (Login.loginIndex == 2) {
								var43 = 201;
								var9 = var43 + 52;
								if (var5 == 1 && var41 >= var9 - 12 && var41 < var9 + 2) {
									Login.currentLoginField = 0;
								}

								var9 += 15;
								if (var5 == 1 && var41 >= var9 - 12 && var41 < var9 + 2) {
									Login.currentLoginField = 1;
								}

								var9 += 15;
								var43 = 361;
								if (class481.field3945 != null) {
									var45 = class481.field3945.highX / 2;
									if (var5 == 1 && var40 >= class481.field3945.lowX - var45 && var40 <= var45 + class481.field3945.lowX && var41 >= var43 - 15 && var41 < var43) {
										switch(Login.field749) {
										case 1:
											VertexNormal.openURL("https://support.runescape.com/hc/en-gb/articles/360001552065", true, false);
											return;
										case 2:
											VertexNormal.openURL("https://support.runescape.com/hc/en-gb", true, false);
										}
									}
								}

								var45 = class379.loginBoxCenter - 80;
								var44 = 321;
								if (var5 == 1 && var40 >= var45 - 75 && var40 <= var45 + 75 && var41 >= var44 - 20 && var41 <= var44 + 20) {
									class148.method780();
									return;
								}

								var45 = Login.loginBoxX + 180 + 80;
								if (var5 == 1 && var40 >= var45 - 75 && var40 <= var45 + 75 && var41 >= var44 - 20 && var41 <= var44 + 20) {
									GameEngine.method166(0);
									Login.Login_username = "";
									Login.Login_password = "";
									ClientPreferences.field1059 = 0;
									class186.otp = "";
									Login.field741 = true;
								}

								var45 = class379.loginBoxCenter + -117;
								var44 = 277;
								Login.field742 = var40 >= var45 && var40 < var45 + class274.field2399 && var41 >= var44 && var41 < var44 + class202.field1581;
								if (var5 == 1 && Login.field742) {
									Client.Login_isUsernameRemembered = !Client.Login_isUsernameRemembered;
									if (!Client.Login_isUsernameRemembered && class91.clientPreferences.getUsernameToRemember() != null) {
										class91.clientPreferences.setUsernameToRemember((String)null);
									}
								}

								var45 = class379.loginBoxCenter + 24;
								var44 = 277;
								Login.field743 = var40 >= var45 && var40 < var45 + class274.field2399 && var41 >= var44 && var41 < var44 + class202.field1581;
								if (var5 == 1 && Login.field743) {
									class91.clientPreferences.setIsUsernameHidden(!class91.clientPreferences.getIsUsernameHidden());
									if (!class91.clientPreferences.getIsUsernameHidden()) {
										Login.Login_username = "";
										class91.clientPreferences.setUsernameToRemember((String)null);
										if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
											Login.currentLoginField = 1;
										} else {
											Login.currentLoginField = 0;
										}
									}
								}

								label1341:
								while (true) {
									Transferable var59;
									do {
										while (true) {
											label1257:
											do {
												while (true) {
													while (var8.method1148()) {
														if (var8.field1901 != 13) {
															if (Login.currentLoginField != 0) {
																continue label1257;
															}

															char var48 = var8.field1899;

															for (var13 = 0; var13 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length() && var48 != "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var13); ++var13) {
															}

															if (var8.field1901 == 85 && Login.Login_username.length() > 0) {
																Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
															}

															if (var8.field1901 == 84 || var8.field1901 == 80) {
																Login.currentLoginField = 1;
															}

															char var50 = var8.field1899;
															boolean var53 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var50) != -1;
															if (var53 && Login.Login_username.length() < 320) {
																Login.Login_username = Login.Login_username + var8.field1899;
															}
														} else {
															GameEngine.method166(0);
															Login.Login_username = "";
															Login.Login_password = "";
															ClientPreferences.field1059 = 0;
															class186.otp = "";
															Login.field741 = true;
														}
													}

													return;
												}
											} while(Login.currentLoginField != 1);

											if (var8.field1901 == 85 && Login.Login_password.length() > 0) {
												Login.Login_password = Login.Login_password.substring(0, Login.Login_password.length() - 1);
											} else if (var8.field1901 == 84 || var8.field1901 == 80) {
												Login.currentLoginField = 0;
												if (var8.field1901 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														AbstractWorldMapIcon.setLoginResponseString("", "Please enter your username/email address.", "");
														return;
													}

													if (Login.Login_password.length() == 0) {
														AbstractWorldMapIcon.setLoginResponseString("", "Please enter your password.", "");
														return;
													}

													AbstractWorldMapIcon.setLoginResponseString("", "Connecting to server...", "");
													UserComparator6.method690(false);
													DefaultsGroup.updateGameState(20);
													return;
												}
											}

											if ((var8.getKeyPressed(82) || var8.getKeyPressed(87)) && var8.field1901 == 67) {
												Clipboard var58 = Toolkit.getDefaultToolkit().getSystemClipboard();
												var59 = var58.getContents(class159.client);
												var14 = 20 - Login.Login_password.length();
												break;
											}

											char var54 = var8.field1899;
											if ((var54 < ' ' || var54 >= 127) && (var54 <= 127 || var54 >= 160) && (var54 <= 160 || var54 > 255)) {
												label1495: {
													if (var54 != 0) {
														char[] var60 = class399.cp1252AsciiExtension;

														for (var30 = 0; var30 < var60.length; ++var30) {
															char var16 = var60[var30];
															if (var16 == var54) {
																var47 = true;
																break label1495;
															}
														}
													}

													var47 = false;
												}
											} else {
												var47 = true;
											}

											if (var47) {
												char var62 = var8.field1899;
												boolean var51 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var62) != -1;
												if (var51 && Login.Login_password.length() < 20) {
													Login.Login_password = Login.Login_password + var8.field1899;
												}
											}
										}
									} while(var14 <= 0);

									try {
										String var15 = (String)var59.getTransferData(DataFlavor.stringFlavor);
										int var52 = Math.min(var14, var15.length());
										int var17 = 0;

										while (true) {
											if (var17 >= var52) {
												Login.Login_password = Login.Login_password + var15.substring(0, var52);
												continue label1341;
											}

											char var19 = var15.charAt(var17);
											boolean var18;
											if (var19 >= ' ' && var19 < 127 || var19 > 127 && var19 < 160 || var19 > 160 && var19 <= 255) {
												var18 = true;
											} else {
												label1513: {
													if (var19 != 0) {
														char[] var20 = class399.cp1252AsciiExtension;

														for (int var21 = 0; var21 < var20.length; ++var21) {
															char var22 = var20[var21];
															if (var19 == var22) {
																var18 = true;
																break label1513;
															}
														}
													}

													var18 = false;
												}
											}

											if (!var18) {
												break;
											}

											char var57 = var15.charAt(var17);
											boolean var28 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".indexOf(var57) != -1;
											if (!var28) {
												break;
											}

											++var17;
										}

										GameEngine.method166(3);
										return;
									} catch (UnsupportedFlavorException var37) {
									} catch (IOException var38) {
									}
								}
							} else {
								Bounds var31;
								if (Login.loginIndex == 3) {
									var9 = Login.loginBoxX + 180;
									var10 = 241;
									var31 = var1.method2119(25, "need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.".length() - 34, "need to log in using the <u=ffd200><col=ffd200>Jagex Launcher</col></u> instead.", var9, var10);
									if (var5 == 1 && var31.method2321(var40, var41)) {
										VertexNormal.openURL("https://oldschool.runescape.com/launcher", true, false);
									}

									var9 = Login.loginBoxX + 180;
									var10 = 276;
									if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
										MusicPatchNode2.method1657(false);
									}

									var9 = Login.loginBoxX + 180;
									var10 = 326;
									if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
										VertexNormal.openURL("https://support.runescape.com/hc/en-gb/articles/360001552065", true, false);
										return;
									}
								} else {
									int var12;
									if (Login.loginIndex == 4) {
										var9 = Login.loginBoxX + 180 - 80;
										var10 = 321;
										if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
											class186.otp.trim();
											if (class186.otp.length() != 6) {
												AbstractWorldMapIcon.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
												return;
											}

											ClientPreferences.field1059 = Integer.parseInt(class186.otp);
											class186.otp = "";
											UserComparator6.method690(true);
											AbstractWorldMapIcon.setLoginResponseString("", "Connecting to server...", "");
											DefaultsGroup.updateGameState(20);
											return;
										}

										if (var5 == 1 && var40 >= Login.loginBoxX + 180 - 9 && var40 <= Login.loginBoxX + 180 + 130 && var41 >= 263 && var41 <= 296) {
											Login.field741 = !Login.field741;
										}

										if (var5 == 1 && var40 >= Login.loginBoxX + 180 - 34 && var40 <= Login.loginBoxX + 34 + 180 && var41 >= 351 && var41 <= 363) {
											VertexNormal.openURL("https://support.runescape.com/hc/en-gb/articles/360001552065", true, false);
										}

										var9 = Login.loginBoxX + 180 + 80;
										if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
											GameEngine.method166(0);
											Login.Login_username = "";
											Login.Login_password = "";
											ClientPreferences.field1059 = 0;
											class186.otp = "";
										}

										while (var8.method1148()) {
											var11 = false;

											for (var12 = 0; var12 < "1234567890".length(); ++var12) {
												if (var8.field1899 == "1234567890".charAt(var12)) {
													var11 = true;
													break;
												}
											}

											if (var8.field1901 == 13) {
												GameEngine.method166(0);
												Login.Login_username = "";
												Login.Login_password = "";
												ClientPreferences.field1059 = 0;
												class186.otp = "";
											} else {
												if (var8.field1901 == 85 && class186.otp.length() > 0) {
													class186.otp = class186.otp.substring(0, class186.otp.length() - 1);
												}

												if (var8.field1901 == 84) {
													class186.otp.trim();
													if (class186.otp.length() != 6) {
														AbstractWorldMapIcon.setLoginResponseString("", "Please enter a 6-digit PIN.", "");
														return;
													}

													ClientPreferences.field1059 = Integer.parseInt(class186.otp);
													class186.otp = "";
													UserComparator6.method690(true);
													AbstractWorldMapIcon.setLoginResponseString("", "Connecting to server...", "");
													DefaultsGroup.updateGameState(20);
													return;
												}

												if (var11 && class186.otp.length() < 6) {
													class186.otp = class186.otp + var8.field1899;
												}
											}
										}
									} else if (Login.loginIndex == 5) {
										var9 = Login.loginBoxX + 180 - 80;
										var10 = 321;
										if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
											Login.Login_username = Login.Login_username.trim();
											if (Login.Login_username.length() == 0) {
												AbstractWorldMapIcon.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
											} else {
												long var32 = class7.method20();
												int var46;
												if (0L == var32) {
													var46 = 5;
												} else {
													var46 = class178.method924(var32, Login.Login_username);
												}

												switch(var46) {
												case 2:
													AbstractWorldMapIcon.setLoginResponseString(Strings.field3466, Strings.field3468, Strings.field3464);
													GameEngine.method166(6);
													break;
												case 3:
													AbstractWorldMapIcon.setLoginResponseString("", "Error connecting to server.", "");
													break;
												case 4:
													AbstractWorldMapIcon.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
													break;
												case 5:
													AbstractWorldMapIcon.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
													break;
												case 6:
													AbstractWorldMapIcon.setLoginResponseString("", "Error connecting to server.", "");
													break;
												case 7:
													AbstractWorldMapIcon.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
												}
											}

											return;
										}

										var9 = Login.loginBoxX + 180 + 80;
										if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
											class429.Login_promptCredentials(true);
										}

										var44 = 361;
										if (Message.field349 != null) {
											var12 = Message.field349.highX / 2;
											if (var5 == 1 && var40 >= Message.field349.lowX - var12 && var40 <= var12 + Message.field349.lowX && var41 >= var44 - 15 && var41 < var44) {
												VertexNormal.openURL(ScriptEvent.method474("secure", true) + "m=weblogin/g=oldscape/cant_log_in", true, false);
											}
										}

										while (var8.method1148()) {
											var47 = false;

											for (var13 = 0; var13 < "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".length(); ++var13) {
												if (var8.field1899 == "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\u00ef\u00bf\u00bd$%^&*()-_=+[{]};:'@#~,<.>/?\\| ".charAt(var13)) {
													var47 = true;
													break;
												}
											}

											if (var8.field1901 == 13) {
												class429.Login_promptCredentials(true);
											} else {
												if (var8.field1901 == 85 && Login.Login_username.length() > 0) {
													Login.Login_username = Login.Login_username.substring(0, Login.Login_username.length() - 1);
												}

												if (var8.field1901 == 84) {
													Login.Login_username = Login.Login_username.trim();
													if (Login.Login_username.length() == 0) {
														AbstractWorldMapIcon.setLoginResponseString("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
													} else {
														long var34 = class7.method20();
														if (0L == var34) {
															var13 = 5;
														} else {
															var13 = class178.method924(var34, Login.Login_username);
														}

														switch(var13) {
														case 2:
															AbstractWorldMapIcon.setLoginResponseString(Strings.field3466, Strings.field3468, Strings.field3464);
															GameEngine.method166(6);
															break;
														case 3:
															AbstractWorldMapIcon.setLoginResponseString("", "Error connecting to server.", "");
															break;
														case 4:
															AbstractWorldMapIcon.setLoginResponseString("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
															break;
														case 5:
															AbstractWorldMapIcon.setLoginResponseString("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
															break;
														case 6:
															AbstractWorldMapIcon.setLoginResponseString("", "Error connecting to server.", "");
															break;
														case 7:
															AbstractWorldMapIcon.setLoginResponseString("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
														}
													}

													return;
												}

												if (var47 && Login.Login_username.length() < 320) {
													Login.Login_username = Login.Login_username + var8.field1899;
												}
											}
										}
									} else if (Login.loginIndex != 6) {
										if (Login.loginIndex == 7) {
											if (MusicPatchNode2.field2778 && !Client.onMobile) {
												var9 = class379.loginBoxCenter - 150;
												var45 = var9 + 40 + 240 + 25;
												var44 = 231;
												var12 = var44 + 40;
												if (var5 == 1 && var40 >= var9 && var40 <= var45 && var41 >= var44 && var41 <= var12) {
													var14 = var9;
													var30 = 0;

													while (true) {
														if (var30 >= 8) {
															var13 = 0;
															break;
														}

														if (var40 <= var14 + 30) {
															var13 = var30;
															break;
														}

														var14 += 30;
														var14 += var30 != 1 && var30 != 3 ? 5 : 20;
														++var30;
													}

													Login.field751 = var13;
												}

												var13 = Login.loginBoxX + 180 - 80;
												short var49 = 321;
												boolean var61;
												if (var5 == 1 && var40 >= var13 - 75 && var40 <= var13 + 75 && var41 >= var49 - 20 && var41 <= var49 + 20) {
													var61 = class159.method840();
													if (var61) {
														DefaultsGroup.updateGameState(50);
														return;
													}
												}

												var13 = Login.loginBoxX + 180 + 80;
												if (var5 == 1 && var40 >= var13 - 75 && var40 <= var13 + 75 && var41 >= var49 - 20 && var41 <= var49 + 20) {
													Login.field766 = new String[8];
													class429.Login_promptCredentials(true);
												}

												while (var8.method1148()) {
													if (var8.field1901 == 101) {
														Login.field766[Login.field751] = null;
													}

													if (var8.field1901 == 85) {
														if (Login.field766[Login.field751] == null && Login.field751 > 0) {
															--Login.field751;
														}

														Login.field766[Login.field751] = null;
													}

													if (var8.field1899 >= '0' && var8.field1899 <= '9') {
														Login.field766[Login.field751] = "" + var8.field1899;
														if (Login.field751 < 7) {
															++Login.field751;
														}
													}

													if (var8.field1901 == 84) {
														var61 = class159.method840();
														if (var61) {
															DefaultsGroup.updateGameState(50);
														}

														return;
													}
												}
											} else {
												var9 = Login.loginBoxX + 180 - 80;
												var10 = 321;
												if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
													VertexNormal.openURL(ScriptEvent.method474("secure", true) + "m=dob/set_dob.ws", true, false);
													AbstractWorldMapIcon.setLoginResponseString("", "Page has opened in the browser.", "");
													GameEngine.method166(6);
													return;
												}

												var9 = Login.loginBoxX + 180 + 80;
												if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
													class429.Login_promptCredentials(true);
												}
											}
										} else if (Login.loginIndex == 8) {
											var9 = Login.loginBoxX + 180 - 80;
											var10 = 321;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												VertexNormal.openURL("https://www.jagex.com/terms/privacy", true, false);
												AbstractWorldMapIcon.setLoginResponseString("", "Page has opened in the browser.", "");
												GameEngine.method166(6);
												return;
											}

											var9 = Login.loginBoxX + 180 + 80;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												class429.Login_promptCredentials(true);
											}
										} else if (Login.loginIndex == 9) {
											var9 = Login.loginBoxX + 180;
											var10 = 311;
											if (var8.field1901 == 84 || var8.field1901 == 13 || var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												MusicPatchNode2.method1657(false);
											}
										} else if (Login.loginIndex == 10) {
											var9 = Login.loginBoxX + 180;
											var10 = 209;
											if (var8.field1901 == 84 || var5 == 1 && var40 >= var9 - 109 && var40 <= var9 + 109 && var41 >= var10 && var41 <= var10 + 68) {
												AbstractWorldMapIcon.setLoginResponseString("", "Connecting to server...", "");
												Client.field648 = class534.field4232;
												UserComparator6.method690(false);
												DefaultsGroup.updateGameState(20);
											}
										} else if (Login.loginIndex == 12) {
											var9 = class379.loginBoxCenter;
											var10 = 233;
											var31 = var2.method2119(0, 30, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var9, var10);
											Bounds var26 = var2.method2119(32, 32, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var9, var10);
											Bounds var27 = var2.method2119(70, 34, "<col=ffd200>terms of use</col>, <col=ffd200>privacy policy</col>, and <col=ffd200>end user licence</col>", var9, var10);
											var45 = var10 + 17;
											Bounds var29 = var2.method2119(0, 34, "<col=ffd200>agreement (EULA)</col>.", var9, var45);
											if (var5 == 1) {
												if (var31.method2321(var40, var41)) {
													VertexNormal.openURL("https://www.jagex.com/terms", true, false);
												} else if (var26.method2321(var40, var41)) {
													VertexNormal.openURL("https://www.jagex.com/terms/privacy", true, false);
												} else if (var27.method2321(var40, var41) || var29.method2321(var40, var41)) {
													VertexNormal.openURL("https://www.jagex.com/en-GB/legal/eula-runescape-oldschool", true, false);
												}
											}

											var9 = class379.loginBoxCenter - 80;
											var10 = 311;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												Tile.method1233();
												MusicPatchNode2.method1657(true);
											}

											var9 = class379.loginBoxCenter + 80;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												Login.loginIndex = 13;
											}
										} else if (Login.loginIndex == 13) {
											var9 = class379.loginBoxCenter;
											var10 = 321;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												MusicPatchNode2.method1657(true);
											}
										} else if (Login.loginIndex == 14) {
											String var36 = "";
											switch(Login.field748) {
											case 0:
												var36 = "https://secure.runescape.com/m=offence-appeal/account-history";
												break;
											case 1:
												var36 = "https://secure.runescape.com/m=accountappeal/passwordrecovery";
												break;
											case 2:
												var36 = "https://support.runescape.com/hc/en-gb/articles/207256855-Settle-an-Unpaid-Balance";
												break;
											default:
												class429.Login_promptCredentials(false);
											}

											var45 = Login.loginBoxX + 180;
											var44 = 276;
											if (var5 == 1 && var40 >= var45 - 75 && var40 <= var45 + 75 && var41 >= var44 - 20 && var41 <= var44 + 20) {
												VertexNormal.openURL(var36, true, false);
												AbstractWorldMapIcon.setLoginResponseString("", "Page has opened in the browser.", "");
												GameEngine.method166(6);
												return;
											}

											var45 = Login.loginBoxX + 180;
											var44 = 326;
											if (var5 == 1 && var40 >= var45 - 75 && var40 <= var45 + 75 && var41 >= var44 - 20 && var41 <= var44 + 20) {
												class429.Login_promptCredentials(false);
											}
										} else if (Login.loginIndex == 24) {
											var9 = Login.loginBoxX + 180;
											var10 = 301;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												MusicPatchNode2.method1657(false);
											}
										} else if (Login.loginIndex == 32) {
											var9 = Login.loginBoxX + 180 - 80;
											var10 = 321;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												VertexNormal.openURL(ScriptEvent.method474("secure", true) + "m=dob/set_dob.ws", true, false);
												AbstractWorldMapIcon.setLoginResponseString("", "Page has opened in the browser.", "");
												GameEngine.method166(6);
												return;
											}

											var9 = Login.loginBoxX + 180 + 80;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												class429.Login_promptCredentials(true);
											}
										} else if (Login.loginIndex == 33) {
											var9 = Login.loginBoxX + 180;
											var10 = 276;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												VertexNormal.openURL("https://oldschool.runescape.com/launcher", true, false);
											}

											var9 = Login.loginBoxX + 180;
											var10 = 326;
											if (var5 == 1 && var40 >= var9 - 75 && var40 <= var9 + 75 && var41 >= var10 - 20 && var41 <= var10 + 20) {
												class429.Login_promptCredentials(true);
											}
										}
									} else {
										while (true) {
											do {
												if (!var8.method1148()) {
													var43 = 321;
													if (var5 == 1 && var41 >= var43 - 20 && var41 <= var43 + 20) {
														class429.Login_promptCredentials(true);
													}

													return;
												}
											} while(var8.field1901 != 84 && var8.field1901 != 13);

											class429.Login_promptCredentials(true);
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