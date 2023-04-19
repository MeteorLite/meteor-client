import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class103 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1108 = new class103(0);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1100 = new class103(1);
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1110 = new class103(2);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1102 = new class103(3);
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1101 = new class103(4);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1104 = new class103(5);
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1105 = new class103(6);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1103 = new class103(7);
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1106 = new class103(8);
   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1115 = new class103(9);
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1109 = new class103(10);
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1107 = new class103(11);
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1111 = new class103(12);
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1112 = new class103(13);
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1113 = new class103(14);
   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "Lda;"
   )
   static final class103 field1114 = new class103(15);
   @ObfuscatedName("av")
   int field1099;

   class103(int var1) {
      this.field1099 = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "([FIFZFZ[FB)I",
      garbageValue = "-57"
   )
   public static int method638(float[] var0, int var1, float var2, boolean var3, float var4, boolean var5, float[] var6) {
      float var7 = 0.0F;

      for(int var8 = 0; var8 < var1 + 1; ++var8) {
         var7 += Math.abs(var0[var8]);
      }

      float var24 = (Math.abs(var2) + Math.abs(var4)) * (float)(var1 + 1) * class121.field1180;
      if (var7 <= var24) {
         return -1;
      } else {
         float[] var9 = new float[var1 + 1];

         int var10;
         for(var10 = 0; var10 < var1 + 1; ++var10) {
            var9[var10] = 1.0F / var7 * var0[var10];
         }

         while(Math.abs(var9[var1]) < var24) {
            --var1;
         }

         var10 = 0;
         if (var1 == 0) {
            return var10;
         } else if (var1 == 1) {
            var6[0] = -var9[0] / var9[1];
            boolean var11 = var3 ? var2 < var24 + var6[0] : var2 < var6[0] - var24;
            boolean var12 = var5 ? var4 > var6[0] - var24 : var4 > var24 + var6[0];
            var10 = var11 && var12 ? 1 : 0;
            if (var10 > 0) {
               if (var3 && var6[0] < var2) {
                  var6[0] = var2;
               } else if (var5 && var6[0] > var4) {
                  var6[0] = var4;
               }
            }

            return var10;
         } else {
            class427 var21 = new class427(var9, var1);
            float[] var22 = new float[var1 + 1];

            for(int var13 = 1; var13 <= var1; ++var13) {
               var22[var13 - 1] = (float)var13 * var9[var13];
            }

            float[] var23 = new float[var1 + 1];
            int var14 = method638(var22, var1 - 1, var2, false, var4, false, var23);
            if (var14 == -1) {
               return 0;
            } else {
               boolean var15 = false;
               float var17 = 0.0F;
               float var18 = 0.0F;
               float var19 = 0.0F;

               for(int var20 = 0; var20 <= var14; ++var20) {
                  if (var10 > var1) {
                     return var10;
                  }

                  float var16;
                  if (var20 == 0) {
                     var16 = var2;
                     var18 = class424.method2245(var9, var1, var2);
                     if (Math.abs(var18) <= var24 && var3) {
                        var6[var10++] = var2;
                     }
                  } else {
                     var16 = var19;
                     var18 = var17;
                  }

                  if (var20 == var14) {
                     var19 = var4;
                     var15 = false;
                  } else {
                     var19 = var23[var20];
                  }

                  var17 = class424.method2245(var9, var1, var19);
                  if (var15) {
                     var15 = false;
                  } else if (Math.abs(var17) < var24) {
                     if (var20 != var14 || var5) {
                        var6[var10++] = var19;
                        var15 = true;
                     }
                  } else if (var18 < 0.0F && var17 > 0.0F || var18 > 0.0F && var17 < 0.0F) {
                     var6[var10++] = Frames.method1297(var21, var16, var19, 0.0F);
                     if (var10 > 1 && var6[var10 - 2] >= var6[var10 - 1] - var24) {
                        var6[var10 - 2] = (var6[var10 - 1] + var6[var10 - 2]) * 0.5F;
                        --var10;
                     }
                  }
               }

               return var10;
            }
         }
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)Lsh;",
      garbageValue = "1454430970"
   )
   public static class478 method639(int var0) {
      int var1 = class476.field4023[var0];
      if (var1 == 1) {
         return class478.field4028;
      } else if (var1 == 2) {
         return class478.field4026;
      } else {
         return var1 == 3 ? class478.field4027 : null;
      }
   }

    @ObfuscatedName("le")
    @ObfuscatedSignature(
            descriptor = "(IIIIIB)V",
            garbageValue = "0"
    )
    static final void drawScrollBar(int var0, int var1, int var2, int var3, int var4) {
      HealthBar.scrollBarSprites[0].drawAt(var0, var1);
      HealthBar.scrollBarSprites[1].drawAt(var0, var3 + var1 - 16);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1 + 16, 16, var3 - 32, Client.field443);
      int var5 = var3 * (var3 - 32) / var4;
      if (var5 < 8) {
         var5 = 8;
      }

      int var6 = (var3 - 32 - var5) * var2 / (var4 - var3);
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var6 + var1 + 16, 16, var5, Client.field451);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0, var6 + var1 + 16, var5, Client.field436);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 1, var6 + var1 + 16, var5, Client.field436);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 16, 16, Client.field436);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var6 + var1 + 17, 16, Client.field436);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 15, var6 + var1 + 16, var5, Client.field435);
      Rasterizer2D.Rasterizer2D_drawVerticalLine(var0 + 14, var6 + var1 + 17, var5 - 1, Client.field435);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0, var5 + var6 + var1 + 15, 16, Client.field435);
      Rasterizer2D.Rasterizer2D_drawHorizontalLine(var0 + 1, var6 + var5 + var1 + 14, 15, Client.field435);
   }

   @ObfuscatedName("mh")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "809507201"
   )
   static final int method636() {
      float var0 = 200.0F * ((float)class20.clientPreferences.getBrightness() - 0.5F);
      return 100 - Math.round(var0);
   }
}
