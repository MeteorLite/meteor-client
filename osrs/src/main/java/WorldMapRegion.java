import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("WorldMapRegion")
public class WorldMapRegion {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Ljj;"
   )
   public static DemotingHashTable WorldMapRegion_cachedSprites = new DemotingHashTable(37748736, 256);
   @ObfuscatedName("q")
   int regionX;
   @ObfuscatedName("f")
   int regionY;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "Lhd;"
   )
   WorldMapData_0 worldMapData_0;
   @ObfuscatedName("u")
   LinkedList worldMapData1List;
   @ObfuscatedName("b")
   int backgroundColor;
   @ObfuscatedName("j")
   int pixelsPerTile;
   @ObfuscatedName("g")
   List icon0List;
   @ObfuscatedName("i")
   HashMap iconMap;
   @ObfuscatedName("o")
   final HashMap fonts;

   WorldMapRegion(int var1, int var2, int var3, HashMap var4) {
      this.regionX = var1;
      this.regionY = var2;
      this.worldMapData1List = new LinkedList();
      this.icon0List = new LinkedList();
      this.iconMap = new HashMap();
      this.backgroundColor = var3 | -16777216;
      this.fonts = var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IIIB)V",
      garbageValue = "117"
   )
   void method1351(int var1, int var2, int var3) {
      SpritePixels var4 = ItemLayer.method1107(this.regionX, this.regionY, this.pixelsPerTile);
      if (var4 != null) {
         if (var3 == this.pixelsPerTile * 64) {
            var4.drawAt(var1, var2);
         } else {
            var4.drawScaledWorldmap(var1, var2, var3, var3);
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lhd;Ljava/util/List;I)V",
      garbageValue = "1558977159"
   )
   void initWorldMapData0(WorldMapData_0 var1, List var2) {
      this.iconMap.clear();
      this.worldMapData_0 = var1;
      this.addAllToIconList(var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/HashSet;Ljava/util/List;B)V",
      garbageValue = "-39"
   )
   void initWorldMapData1(HashSet var1, List var2) {
      this.iconMap.clear();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         WorldMapData_1 var4 = (WorldMapData_1)var3.next();
         if (var4.getRegionX() == this.regionX && var4.getRegionY() == this.regionY) {
            this.worldMapData1List.add(var4);
         }
      }

      this.addAllToIconList(var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(IIIILin;I)V",
      garbageValue = "469885005"
   )
   void getIconsForTiles(int var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
      for(int var6 = var1; var6 < var3 + var1; ++var6) {
         label45:
         for(int var7 = var2; var7 < var2 + var4; ++var7) {
            for(int var8 = 0; var8 < var5.planes; ++var8) {
               WorldMapDecoration[] var9 = var5.decorations[var8][var6][var7];
               if (var9 != null && var9.length != 0) {
                  WorldMapDecoration[] var10 = var9;

                  for(int var11 = 0; var11 < var10.length; ++var11) {
                     WorldMapDecoration var12 = var10[var11];
                     ObjectComposition var13 = VarpDefinition.getObjectDefinition(var12.objectDefinitionId);
                     if (class98.method597(var13)) {
                        this.getIcon(var13, var8, var6, var7, var5);
                        continue label45;
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lgn;IIILin;I)V",
      garbageValue = "-1481118072"
   )
   void getIcon(ObjectComposition var1, int var2, int var3, int var4, AbstractWorldMapData var5) {
      Coord var6 = new Coord(var2, var3 + this.regionX * 64, this.regionY * 64 + var4);
      Coord var7 = null;
      if (this.worldMapData_0 != null) {
         var7 = new Coord(this.worldMapData_0.minPlane + var2, var3 + this.worldMapData_0.regionXLow * 64, var4 + this.worldMapData_0.regionYLow * 64);
      } else {
         WorldMapData_1 var8 = (WorldMapData_1)var5;
         var7 = new Coord(var2 + var8.minPlane, var8.regionXLow * 64 + var3 + var8.getChunkXLow() * 8, var4 + var8.regionYLow * 64 + var8.getChunkYLow() * 8);
      }

      WorldMapElement var9;
      Object var10;
      if (var1.transforms != null) {
         var10 = new WorldMapIcon_1(var7, var6, var1.id, this);
      } else {
         var9 = JagexCache.WorldMapElement_get(var1.mapIconId);
         var10 = new WorldMapIcon_0(var7, var6, var9.objectId, this.createMapLabel(var9));
      }

      var9 = JagexCache.WorldMapElement_get(((AbstractWorldMapIcon)var10).getElement());
      if (var9.field1481) {
         this.iconMap.put(new Coord(0, var3, var4), var10);
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "16842753"
   )
   void initWorldMapIcon1s() {
      Iterator var1 = this.iconMap.values().iterator();

      while(var1.hasNext()) {
         AbstractWorldMapIcon var2 = (AbstractWorldMapIcon)var1.next();
         if (var2 instanceof WorldMapIcon_1) {
            ((WorldMapIcon_1)var2).init();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/List;B)V",
      garbageValue = "69"
   )
   void addAllToIconList(List var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         WorldMapIcon_0 var3 = (WorldMapIcon_0)var2.next();
         if (JagexCache.WorldMapElement_get(var3.element).field1481 && var3.coord2.x >> 6 == this.regionX && var3.coord2.y >> 6 == this.regionY) {
            WorldMapIcon_0 var4 = new WorldMapIcon_0(var3.coord2, var3.coord2, var3.element, this.method1372(var3.element));
            this.icon0List.add(var4);
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1768631519"
   )
   void method1383() {
      if (this.worldMapData_0 != null) {
         this.worldMapData_0.reset();
      } else {
         Iterator var1 = this.worldMapData1List.iterator();

         while(var1.hasNext()) {
            WorldMapData_1 var2 = (WorldMapData_1)var1.next();
            var2.reset();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Lly;B)Z",
      garbageValue = "21"
   )
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
         for(var3 = this.worldMapData1List.iterator(); var3.hasNext(); var2 &= var4.isFullyLoaded()) {
            var4 = (WorldMapData_1)var3.next();
            var4.loadGeography(var1);
         }

         if (var2) {
            var3 = this.worldMapData1List.iterator();

            while(var3.hasNext()) {
               var4 = (WorldMapData_1)var3.next();
               this.getIconsForTiles(var4.getChunkX() * 8, var4.getChunkY() * 8, 8, 8, var4);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(ILih;[Lra;Lly;Lly;B)V",
      garbageValue = "6"
   )
   void drawTile(int var1, WorldMapScaleHandler var2, IndexedSprite[] var3, AbstractArchive var4, AbstractArchive var5) {
      this.pixelsPerTile = var1;
      if (this.worldMapData_0 != null || !this.worldMapData1List.isEmpty()) {
         if (ItemLayer.method1107(this.regionX, this.regionY, var1) == null) {
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
                  var9 = new WorldMapSprite(Language.method1865(var7).pixels);
               }

               SpritePixels var11 = new SpritePixels(this.pixelsPerTile * 64, this.pixelsPerTile * 64);
               var11.setRaster();
               if (this.worldMapData_0 != null) {
                  this.method1359(var2, var3, var9);
               } else {
                  this.method1376(var2, var3, var9);
               }

               VerticalAlignment.method968(var11, this.regionX, this.regionY, this.pixelsPerTile);
               this.method1383();
            }
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(IIILjava/util/HashSet;S)V",
      garbageValue = "22940"
   )
   void method1358(int var1, int var2, int var3, HashSet var4) {
      if (var4 == null) {
         var4 = new HashSet();
      }

      this.drawNonLinkMapIcons(var1, var2, var4, var3);
      this.drawMapLinks(var1, var2, var4, var3);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/HashSet;III)V",
      garbageValue = "1301690164"
   )
   void flashElements(HashSet var1, int var2, int var3) {
      Iterator var4 = this.iconMap.values().iterator();

      while(var4.hasNext()) {
         AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
         if (var5.hasValidElement()) {
            int var6 = var5.getElement();
            if (var1.contains(var6)) {
               WorldMapElement var7 = JagexCache.WorldMapElement_get(var6);
               this.drawBackgroundCircle(var7, var5.screenX, var5.screenY, var2, var3);
            }
         }
      }

      this.method1377(var1, var2, var3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(Lih;[Lra;Lir;B)V",
      garbageValue = "3"
   )
   void method1359(WorldMapScaleHandler var1, IndexedSprite[] var2, WorldMapSprite var3) {
      int var4;
      int var5;
      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.drawTileGround(var4, var5, this.worldMapData_0, var1, var3);
            this.method1363(var4, var5, this.worldMapData_0, var1);
         }
      }

      for(var4 = 0; var4 < 64; ++var4) {
         for(var5 = 0; var5 < 64; ++var5) {
            this.method1361(var4, var5, this.worldMapData_0, var1, var2);
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(Lih;[Lra;Lir;B)V",
      garbageValue = "0"
   )
   void method1376(WorldMapScaleHandler var1, IndexedSprite[] var2, WorldMapSprite var3) {
      Iterator var4 = this.worldMapData1List.iterator();

      WorldMapData_1 var5;
      int var6;
      int var7;
      while(var4.hasNext()) {
         var5 = (WorldMapData_1)var4.next();

         for(var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
            for(var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
               this.drawTileGround(var6, var7, var5, var1, var3);
               this.method1363(var6, var7, var5, var1);
            }
         }
      }

      var4 = this.worldMapData1List.iterator();

      while(var4.hasNext()) {
         var5 = (WorldMapData_1)var4.next();

         for(var6 = var5.getChunkX() * 8; var6 < var5.getChunkX() * 8 + 8; ++var6) {
            for(var7 = var5.getChunkY() * 8; var7 < var5.getChunkY() * 8 + 8; ++var7) {
               this.method1361(var6, var7, var5, var1, var2);
            }
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(IILin;Lih;[Lra;I)V",
      garbageValue = "1436785545"
   )
   void method1361(int var1, int var2, AbstractWorldMapData var3, WorldMapScaleHandler var4, IndexedSprite[] var5) {
      this.method1365(var1, var2, var3);
      this.method1373(var1, var2, var3, var5);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(IILin;Lih;Lir;I)V",
      garbageValue = "2001748822"
   )
   void drawTileGround(int var1, int var2, AbstractWorldMapData var3, WorldMapScaleHandler var4, WorldMapSprite var5) {
      int var6 = var3.floorUnderlayIds[0][var1][var2] - 1;
      int var7 = var3.floorOverlayIds[0][var1][var2] - 1;
      if (var6 == -1 && var7 == -1) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, this.backgroundColor);
      }

      int var8 = 16711935;
      if (var7 != -1) {
         var8 = Interpreter.method419(var7, this.backgroundColor);
      }

      if (var7 > -1 && var3.field2359[0][var1][var2] == 0) {
         Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var8);
      } else {
         int var9 = this.method1364(var1, var2, var3, var5);
         if (var7 == -1) {
            Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var9);
         } else {
            var4.method1478(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), var9, var8, this.pixelsPerTile, this.pixelsPerTile, var3.field2359[0][var1][var2], var3.field2360[0][var1][var2]);
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(IILin;Lih;I)V",
      garbageValue = "-1969198767"
   )
   void method1363(int var1, int var2, AbstractWorldMapData var3, WorldMapScaleHandler var4) {
      for(int var5 = 1; var5 < var3.planes; ++var5) {
         int var6 = var3.floorOverlayIds[var5][var1][var2] - 1;
         if (var6 > -1) {
            int var7 = Interpreter.method419(var6, this.backgroundColor);
            if (var3.field2359[var5][var1][var2] == 0) {
               Rasterizer2D.Rasterizer2D_fillRectangle(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile, this.pixelsPerTile, var7);
            } else {
               var4.method1478(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 0, var7, this.pixelsPerTile, this.pixelsPerTile, var3.field2359[var5][var1][var2], var3.field2360[var5][var1][var2]);
            }
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(IILin;Lir;I)I",
      garbageValue = "-1742874756"
   )
   int method1364(int var1, int var2, AbstractWorldMapData var3, WorldMapSprite var4) {
      return var3.floorUnderlayIds[0][var1][var2] == 0 ? this.backgroundColor : var4.getTileColor(var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(IILin;[Lra;B)V",
      garbageValue = "1"
   )
   void method1373(int var1, int var2, AbstractWorldMapData var3, IndexedSprite[] var4) {
      for(int var5 = 0; var5 < var3.planes; ++var5) {
         WorldMapDecoration[] var6 = var3.decorations[var5][var1][var2];
         if (var6 != null && var6.length != 0) {
            WorldMapDecoration[] var7 = var6;

            for(int var8 = 0; var8 < var7.length; ++var8) {
               WorldMapDecoration var9 = var7[var8];
               int var11 = var9.decoration;
               boolean var10 = var11 >= WorldMapDecorationType.field3053.id && var11 <= WorldMapDecorationType.field3054.id;
               if (var10 || class150.method809(var9.decoration)) {
                  ObjectComposition var12 = VarpDefinition.getObjectDefinition(var9.objectDefinitionId);
                  if (var12.mapSceneId != -1) {
                     if (var12.mapSceneId != 46 && var12.mapSceneId != 52) {
                        var4[var12.mapSceneId].method2459(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2, this.pixelsPerTile * 2);
                     } else {
                        var4[var12.mapSceneId].method2459(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), this.pixelsPerTile * 2 + 1, this.pixelsPerTile * 2 + 1);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(IILin;I)V",
      garbageValue = "-731314133"
   )
   void method1365(int var1, int var2, AbstractWorldMapData var3) {
      for(int var4 = 0; var4 < var3.planes; ++var4) {
         WorldMapDecoration[] var5 = var3.decorations[var4][var1][var2];
         if (var5 != null && var5.length != 0) {
            WorldMapDecoration[] var6 = var5;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               WorldMapDecoration var8 = var6[var7];
               int var10 = var8.decoration;
               boolean var9 = var10 >= WorldMapDecorationType.field3034.id && var10 <= WorldMapDecorationType.field3042.id || var10 == WorldMapDecorationType.field3048.id;
               if (var9) {
                  ObjectComposition var11 = VarpDefinition.getObjectDefinition(var8.objectDefinitionId);
                  int var12 = var11.int1 != 0 ? -3407872 : -3355444;
                  if (var8.decoration == WorldMapDecorationType.field3034.id) {
                     this.method1375(var1, var2, var8.rotation, var12);
                  }

                  if (var8.decoration == WorldMapDecorationType.field3036.id) {
                     this.method1375(var1, var2, var8.rotation, -3355444);
                     this.method1375(var1, var2, var8.rotation + 1, var12);
                  }

                  if (var8.decoration == WorldMapDecorationType.field3042.id) {
                     if (var8.rotation == 0) {
                        Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2), 1, var12);
                     }

                     if (var8.rotation == 1) {
                        Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2), 1, var12);
                     }

                     if (var8.rotation == 2) {
                        Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1 + this.pixelsPerTile - 1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
                     }

                     if (var8.rotation == 3) {
                        Rasterizer2D.Rasterizer2D_drawHorizontalLine(this.pixelsPerTile * var1, this.pixelsPerTile * (63 - var2) + this.pixelsPerTile - 1, 1, var12);
                     }
                  }

                  if (var8.decoration == WorldMapDecorationType.field3048.id) {
                     int var13 = var8.rotation % 2;
                     int var14;
                     if (var13 == 0) {
                        for(var14 = 0; var14 < this.pixelsPerTile; ++var14) {
                           Rasterizer2D.Rasterizer2D_drawHorizontalLine(var14 + this.pixelsPerTile * var1, (64 - var2) * this.pixelsPerTile - 1 - var14, 1, var12);
                        }
                     } else {
                        for(var14 = 0; var14 < this.pixelsPerTile; ++var14) {
                           Rasterizer2D.Rasterizer2D_drawHorizontalLine(var14 + this.pixelsPerTile * var1, var14 + this.pixelsPerTile * (63 - var2), 1, var12);
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(IILjava/util/HashSet;II)V",
      garbageValue = "1350959975"
   )
   void drawNonLinkMapIcons(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      float var6 = var5 / 2.0F;
      Iterator var7 = this.iconMap.entrySet().iterator();

      while(var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         Coord var9 = (Coord)var8.getKey();
         int var10 = (int)((float)var9.x * var5 + (float)var1 - var6);
         int var11 = (int)((float)(var2 + var4) - var5 * (float)var9.y - var6);
         AbstractWorldMapIcon var12 = (AbstractWorldMapIcon)var8.getValue();
         if (var12 != null && var12.hasValidElement()) {
            var12.screenX = var10;
            var12.screenY = var11;
            WorldMapElement var13 = JagexCache.WorldMapElement_get(var12.getElement());
            if (!var3.contains(var13.getObjectId())) {
               this.method1379(var12, var10, var11, var5);
            }
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(Ljava/util/HashSet;III)V",
      garbageValue = "1289511837"
   )
   void method1377(HashSet var1, int var2, int var3) {
      Iterator var4 = this.icon0List.iterator();

      while(var4.hasNext()) {
         AbstractWorldMapIcon var5 = (AbstractWorldMapIcon)var4.next();
         if (var5.hasValidElement()) {
            WorldMapElement var6 = JagexCache.WorldMapElement_get(var5.getElement());
            if (var6 != null && var1.contains(var6.getObjectId())) {
               this.drawBackgroundCircle(var6, var5.screenX, var5.screenY, var2, var3);
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Lfm;IIIIB)V",
      garbageValue = "-8"
   )
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Lix;IIFI)V",
      garbageValue = "314321366"
   )
   void method1379(AbstractWorldMapIcon var1, int var2, int var3, float var4) {
      WorldMapElement var5 = JagexCache.WorldMapElement_get(var1.getElement());
      this.method1382(var5, var2, var3);
      this.method1369(var1, var5, var2, var3, var4);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(Lfm;III)V",
      garbageValue = "-1811455271"
   )
   void method1382(WorldMapElement var1, int var2, int var3) {
      SpritePixels var4 = var1.getSpriteBool(false);
      if (var4 != null) {
         int var5 = this.method1381(var4, var1.horizontalAlignment);
         int var6 = this.method1367(var4, var1.verticalAlignment);
         var4.drawTransBgAt(var5 + var2, var3 + var6);
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(Lix;Lfm;IIFI)V",
      garbageValue = "-1717501749"
   )
   void method1369(AbstractWorldMapIcon var1, WorldMapElement var2, int var3, int var4, float var5) {
      WorldMapLabel var6 = var1.getLabel();
      if (var6 != null) {
         if (var6.size.method1308(var5)) {
            Font var7 = (Font)this.fonts.get(var6.size);
            var7.drawLines(var6.text, var3 - var6.width / 2, var4, var6.width, var6.height, -16777216 | var2.field1491, 0, 1, 0, var7.ascent / 2);
         }
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IILjava/util/HashSet;IB)V",
      garbageValue = "106"
   )
   void drawMapLinks(int var1, int var2, HashSet var3, int var4) {
      float var5 = (float)var4 / 64.0F;
      Iterator var6 = this.icon0List.iterator();

      while(var6.hasNext()) {
         AbstractWorldMapIcon var7 = (AbstractWorldMapIcon)var6.next();
         if (var7.hasValidElement()) {
            int var8 = var7.coord2.x % 64;
            int var9 = var7.coord2.y % 64;
            var7.screenX = (int)((float)var1 + var5 * (float)var8);
            var7.screenY = (int)((float)(63 - var9) * var5 + (float)var2);
            if (!var3.contains(var7.getElement())) {
               this.method1379(var7, var7.screenX, var7.screenY, var5);
            }
         }
      }

   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(Lrx;Lgj;I)I",
      garbageValue = "2040136984"
   )
   int method1381(SpritePixels var1, HorizontalAlignment var2) {
      switch(var2.value) {
      case 1:
         return -var1.subWidth / 2;
      case 2:
         return 0;
      default:
         return -var1.subWidth;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Lrx;Lgl;B)I",
      garbageValue = "-74"
   )
   int method1367(SpritePixels var1, VerticalAlignment var2) {
      switch(var2.value) {
      case 0:
         return 0;
      case 2:
         return -var1.subHeight / 2;
      default:
         return -var1.subHeight;
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(II)Lii;",
      garbageValue = "-1016818948"
   )
   WorldMapLabel method1372(int var1) {
      WorldMapElement var2 = JagexCache.WorldMapElement_get(var1);
      return this.createMapLabel(var2);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(Lfm;I)Lii;",
      garbageValue = "-824345653"
   )
   WorldMapLabel createMapLabel(WorldMapElement var1) {
      if (var1.name != null && this.fonts != null && this.fonts.get(WorldMapLabelSize.WorldMapLabelSize_small) != null) {
         int var3 = var1.textSize;
         WorldMapLabelSize[] var4 = WorldMapLabelSize.method1305();
         int var5 = 0;

         WorldMapLabelSize var2;
         while(true) {
            if (var5 >= var4.length) {
               var2 = null;
               break;
            }

            WorldMapLabelSize var6 = var4[var5];
            if (var3 == var6.field2247) {
               var2 = var6;
               break;
            }

            ++var5;
         }

         if (var2 == null) {
            return null;
         } else {
            Font var14 = (Font)this.fonts.get(var2);
            if (var14 == null) {
               return null;
            } else {
               int var15 = var14.lineCount(var1.name, 1000000);
               String[] var7 = new String[var15];
               var14.breakLines(var1.name, (int[])null, var7);
               int var8 = var7.length * var14.ascent / 2;
               int var9 = 0;
               String[] var10 = var7;

               for(int var11 = 0; var11 < var10.length; ++var11) {
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

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(IIIIIS)Ljava/util/List;",
      garbageValue = "1000"
   )
   List method1378(int var1, int var2, int var3, int var4, int var5) {
      LinkedList var6 = new LinkedList();
      if (var4 >= var1 && var5 >= var2) {
         if (var4 < var3 + var1 && var5 < var3 + var2) {
            Iterator var7 = this.iconMap.values().iterator();

            AbstractWorldMapIcon var8;
            while(var7.hasNext()) {
               var8 = (AbstractWorldMapIcon)var7.next();
               if (var8.hasValidElement() && var8.fitsScreen(var4, var5)) {
                  var6.add(var8);
               }
            }

            var7 = this.icon0List.iterator();

            while(var7.hasNext()) {
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

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/util/List;",
      garbageValue = "-27"
   )
   List icons() {
      LinkedList var1 = new LinkedList();
      var1.addAll(this.icon0List);
      var1.addAll(this.iconMap.values());
      return var1;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "350887459"
   )
   void method1375(int var1, int var2, int var3, int var4) {
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
