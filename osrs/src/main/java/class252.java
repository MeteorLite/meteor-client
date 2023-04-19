import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
public class class252 implements WorldMapSection {
   @ObfuscatedName("af")
   int field2350;
   @ObfuscatedName("an")
   int field2353;
   @ObfuscatedName("aw")
   int field2346;
   @ObfuscatedName("ac")
   int field2347;
   @ObfuscatedName("au")
   int field2345;
   @ObfuscatedName("ab")
   int field2354;
   @ObfuscatedName("aq")
   int field2349;
   @ObfuscatedName("al")
   int field2351;
   @ObfuscatedName("at")
   int field2352;
   @ObfuscatedName("aa")
   int field2348;

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Ljs;I)V",
            garbageValue = "1131699138"
    )
    public void expandBounds(WorldMapArea var1) {
      if (var1.regionLowX > this.field2345) {
         var1.regionLowX = this.field2345;
      }

      if (var1.regionHighX < this.field2345) {
         var1.regionHighX = this.field2345;
      }

      if (var1.regionLowY > this.field2354) {
         var1.regionLowY = this.field2354;
      }

      if (var1.regionHighY < this.field2354) {
         var1.regionHighY = this.field2354;
      }

   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(IIIB)Z",
            garbageValue = "3"
    )
    public boolean containsCoord(int var1, int var2, int var3) {
      if (var1 >= this.field2350 && var1 < this.field2353 + this.field2350) {
         return var2 >= (this.field2346 << 6) + (this.field2349 << 3) && var2 <= (this.field2346 << 6) + (this.field2349 << 3) + 7 && var3 >= (this.field2347 << 6) + (this.field2351 << 3) && var3 <= (this.field2347 << 6) + (this.field2351 << 3) + 7;
      } else {
         return false;
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(III)Z",
            garbageValue = "-1795894381"
    )
    public boolean containsPosition(int var1, int var2) {
      return var1 >= (this.field2345 << 6) + (this.field2352 << 3) && var1 <= (this.field2345 << 6) + (this.field2352 << 3) + 7 && var2 >= (this.field2354 << 6) + (this.field2348 << 3) && var2 <= (this.field2354 << 6) + (this.field2348 << 3) + 7;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(IIIB)[I",
            garbageValue = "21"
    )
    public int[] getBorderTileLengths(int var1, int var2, int var3) {
      if (!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{var2 + (this.field2345 * 64 - this.field2346 * 64) + (this.field2352 * 8 - this.field2349 * 8), var3 + (this.field2354 * 64 - this.field2347 * 64) + (this.field2348 * 8 - this.field2351 * 8)};
         return var4;
      }
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(IIB)Llb;",
            garbageValue = "-4"
    )
    public Coord coord(int var1, int var2) {
      if (!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.field2346 * 64 - this.field2345 * 64 + (this.field2349 * 8 - this.field2352 * 8) + var1;
         int var4 = var2 + (this.field2347 * 64 - this.field2354 * 64) + (this.field2351 * 8 - this.field2348 * 8);
         return new Coord(this.field2350, var3, var4);
      }
   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(Lsg;B)V",
            garbageValue = "0"
    )
    public void read(Buffer var1) {
      this.field2350 = var1.readUnsignedByte();
      this.field2353 = var1.readUnsignedByte();
      this.field2346 = var1.readUnsignedShort();
      this.field2349 = var1.readUnsignedByte();
      this.field2347 = var1.readUnsignedShort();
      this.field2351 = var1.readUnsignedByte();
      this.field2345 = var1.readUnsignedShort();
      this.field2352 = var1.readUnsignedByte();
      this.field2354 = var1.readUnsignedShort();
      this.field2348 = var1.readUnsignedByte();
      this.method1488();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1809982320"
   )
   void method1488() {
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(II)I",
            garbageValue = "1949946238"
    )
    public static int getVarbit(int var0) {
      VarbitComposition var1 = class158.method894(var0);
      int var2 = var1.baseVar;
      int var3 = var1.startBit;
      int var4 = var1.endBit;
      int var5 = Varps.Varps_masks[var4 - var3];
      return Varps.Varps_main[var2] >> var3 & var5;
   }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            descriptor = "(IIIIIZI)Ltq;",
            garbageValue = "13705148"
    )
    public static final SpritePixels getItemSprite(int var0, int var1, int var2, int var3, int var4, boolean var5) {
      if (var1 == -1) {
         var4 = 0;
      } else if (var4 == 2 && var1 != 1) {
         var4 = 1;
      }

      long var6 = ((long)var2 << 38) + (long)var0 + ((long)var1 << 16) + ((long)var4 << 40) + ((long)var3 << 42);
      SpritePixels var8;
      if (!var5) {
         var8 = (SpritePixels)ItemComposition.ItemDefinition_cachedSprites.get(var6);
         if (var8 != null) {
            return var8;
         }
      }

      ItemComposition var9 = HealthBarUpdate.ItemDefinition_get(var0);
      if (var1 > 1 && var9.countobj != null) {
         int var10 = -1;

         for(int var11 = 0; var11 < 10; ++var11) {
            if (var1 >= var9.countco[var11] && var9.countco[var11] != 0) {
               var10 = var9.countobj[var11];
            }
         }

         if (var10 != -1) {
            var9 = HealthBarUpdate.ItemDefinition_get(var10);
         }
      }

      Model var20 = var9.getModel(1);
      if (var20 == null) {
         return null;
      } else {
         SpritePixels var21 = null;
         if (var9.noteTemplate != -1) {
            var21 = getItemSprite(var9.note, 10, 1, 0, 0, true);
            if (var21 == null) {
               return null;
            }
         } else if (var9.notedId != -1) {
            var21 = getItemSprite(var9.unnotedId, var1, var2, var3, 0, false);
            if (var21 == null) {
               return null;
            }
         } else if (var9.placeholderTemplate != -1) {
            var21 = getItemSprite(var9.placeholder, var1, 0, 0, 0, false);
            if (var21 == null) {
               return null;
            }
         }

         int[] var12 = Rasterizer2D.Rasterizer2D_pixels;
         int var13 = Rasterizer2D.Rasterizer2D_width;
         int var14 = Rasterizer2D.Rasterizer2D_height;
         float[] var15 = Rasterizer2D.field4108;
         int[] var16 = new int[4];
         Rasterizer2D.Rasterizer2D_getClipArray(var16);
         var8 = new SpritePixels(36, 32);
         class1.method2(var8.pixels, 36, 32, (float[])null);
         Rasterizer2D.Rasterizer2D_clear();
         class18.method68();
         WorldMapArea.method1433(16, 16);
         Rasterizer3D.clips.field2226 = false;
         if (var9.placeholderTemplate != -1) {
            var21.drawTransBgAt(0, 0);
         }

         int var17 = var9.zoom2d;
         if (var5) {
            var17 = (int)(1.5D * (double)var17);
         } else if (var2 == 2) {
            var17 = (int)((double)var17 * 1.04D);
         }

         int var18 = var17 * Rasterizer3D.Rasterizer3D_sine[var9.xan2d] >> 16;
         int var19 = var17 * Rasterizer3D.Rasterizer3D_cosine[var9.xan2d] >> 16;
         var20.calculateBoundsCylinder();
         var20.method1343(0, var9.yan2d, var9.zan2d, var9.xan2d, var9.offsetX2d, var20.height / 2 + var18 + var9.offsetY2d, var19 + var9.offsetY2d);
         if (var9.notedId != -1) {
            var21.drawTransBgAt(0, 0);
         }

         if (var2 >= 1) {
            var8.outline(1);
         }

         if (var2 >= 2) {
            var8.outline(16777215);
         }

         if (var3 != 0) {
            var8.shadow(var3);
         }

         class1.method2(var8.pixels, 36, 32, (float[])null);
         if (var9.noteTemplate != -1) {
            var21.drawTransBgAt(0, 0);
         }

         if (var4 == 1 || var4 == 2 && var9.isStackable == 1) {
            class124.ItemDefinition_fontPlain11.draw(class101.method633(var1), 0, 9, 16776960, 1);
         }

         if (!var5) {
            ItemComposition.ItemDefinition_cachedSprites.put(var8, var6);
         }

         class1.method2(var12, var13, var14, var15);
         Rasterizer2D.Rasterizer2D_setClipArray(var16);
         class18.method68();
         Rasterizer3D.clips.field2226 = true;
         return var8;
      }
   }
}
