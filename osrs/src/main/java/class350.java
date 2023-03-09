import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nb")
public class class350 {
   @ObfuscatedName("aj")
   @Export("spriteMap")
   final HashMap spriteMap = new HashMap();
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lqy;"
   )
   @Export("bounds")
   Bounds bounds = new Bounds(0, 0);
   @ObfuscatedName("ac")
   int[] field3486 = new int[2048];
   @ObfuscatedName("ab")
   int[] field3489 = new int[2048];
   @ObfuscatedName("an")
   int field3490 = 0;

   public class350() {
      class320.method1787();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1800570311"
   )
   void method1879(int var1) {
      int var2 = var1 * 2 + 1;
      double[] var3 = class293.method1558(0.0D, (double)((float)var1 / 3.0F), var1);
      double var4 = var3[var1] * var3[var1];
      int[] var6 = new int[var2 * var2];
      boolean var7 = false;

      for(int var8 = 0; var8 < var2; ++var8) {
         for(int var9 = 0; var9 < var2; ++var9) {
            int var10 = var6[var9 + var8 * var2] = (int)(var3[var9] * var3[var8] / var4 * 256.0D);
            if (!var7 && var10 > 0) {
               var7 = true;
            }
         }
      }

      SpritePixels var11 = new SpritePixels(var6, var2, var2);
      this.spriteMap.put(var1, var11);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)Lsn;",
      garbageValue = "2120633980"
   )
   SpritePixels method1880(int var1) {
      if (!this.spriteMap.containsKey(var1)) {
         this.method1879(var1);
      }

      return (SpritePixels)this.spriteMap.get(var1);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1905943490"
   )
   public final void method1881(int var1, int var2) {
      if (this.field3490 < this.field3486.length) {
         this.field3486[this.field3490] = var1;
         this.field3489[this.field3490] = var2;
         ++this.field3490;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2035050037"
   )
   public final void method1884() {
      this.field3490 = 0;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IILsn;FI)V",
      garbageValue = "2073173460"
   )
   public final void method1883(int var1, int var2, SpritePixels var3, float var4) {
      int var5 = (int)(var4 * 18.0F);
      SpritePixels var6 = this.method1880(var5);
      int var7 = var5 * 2 + 1;
      Bounds var8 = new Bounds(0, 0, var3.subWidth, var3.subHeight);
      Bounds var9 = new Bounds(0, 0);
      this.bounds.setHigh(var7, var7);
      System.nanoTime();

      int var10;
      int var11;
      int var12;
      for(var10 = 0; var10 < this.field3490; ++var10) {
         var11 = this.field3486[var10];
         var12 = this.field3489[var10];
         int var13 = (int)(var4 * (float)(var11 - var1)) - var5;
         int var14 = (int)((float)var3.subHeight - (float)(var12 - var2) * var4) - var5;
         this.bounds.setLow(var13, var14);
         this.bounds.method2175(var8, var9);
         this.method1882(var6, var3, var9);
      }

      System.nanoTime();
      System.nanoTime();

      for(var10 = 0; var10 < var3.pixels.length; ++var10) {
         if (var3.pixels[var10] == 0) {
            var3.pixels[var10] = -16777216;
         } else {
            var11 = (var3.pixels[var10] + 64 - 1) / 256;
            if (var11 <= 0) {
               var3.pixels[var10] = -16777216;
            } else {
               if (var11 > class150.field1331.length) {
                  var11 = class150.field1331.length;
               }

               var12 = class150.field1331[var11 - 1];
               var3.pixels[var10] = -16777216 | var12;
            }
         }
      }

      System.nanoTime();
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Lsn;Lsn;Lqy;I)V",
      garbageValue = "1656372641"
   )
   void method1882(SpritePixels var1, SpritePixels var2, Bounds var3) {
      if (var3.highX != 0 && var3.highY != 0) {
         int var4 = 0;
         int var5 = 0;
         if (var3.lowX == 0) {
            var4 = var1.subWidth - var3.highX;
         }

         if (var3.lowY == 0) {
            var5 = var1.subHeight - var3.highY;
         }

         int var6 = var4 + var5 * var1.subWidth;
         int var7 = var2.subWidth * var3.lowY + var3.lowX;

         for(int var8 = 0; var8 < var3.highY; ++var8) {
            for(int var9 = 0; var9 < var3.highX; ++var9) {
               int var10001 = var7++;
               var2.pixels[var10001] += var1.pixels[var6++];
            }

            var6 += var1.subWidth - var3.highX;
            var7 += var2.subWidth - var3.highX;
         }

      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;ZI)Lre;",
      garbageValue = "-2099916897"
   )
   @Export("getPreferencesFile")
   public static AccessFile getPreferencesFile(String var0, String var1, boolean var2) {
      File var3 = new File(SoundCache.cacheDir, "preferences" + var0 + ".dat");
      if (var3.exists()) {
         try {
            AccessFile var10 = new AccessFile(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if (class7.cacheGamebuild == 33) {
         var4 = "_rc";
      } else if (class7.cacheGamebuild == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class16.userHomeDirectory, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      AccessFile var6;
      if (!var2 && var5.exists()) {
         try {
            var6 = new AccessFile(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new AccessFile(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "-1712326468"
   )
   static final void method1886(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var3 + var1; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if (var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               Decimator.field300[0][var5][var4] = 127;
               if (var0 == var5 && var5 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 - 1][var4];
               }

               if (var5 == var0 + var2 && var5 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5 + 1][var4];
               }

               if (var4 == var1 && var4 > 0) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 - 1];
               }

               if (var4 == var3 + var1 && var4 < 103) {
                  Tiles.Tiles_heights[0][var5][var4] = Tiles.Tiles_heights[0][var5][var4 + 1];
               }
            }
         }
      }

   }
}
