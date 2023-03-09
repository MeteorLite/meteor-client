import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dt")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      descriptor = "[Lsp;"
   )
   @Export("mapSceneSprites")
   static IndexedSprite[] mapSceneSprites;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "[Lsp;"
   )
   IndexedSprite[] field1020;
   @ObfuscatedName("av")
   int[] field1013 = new int[256];
   @ObfuscatedName("aq")
   int field1015 = 0;
   @ObfuscatedName("ap")
   int[] field1016;
   @ObfuscatedName("ar")
   int[] field1017;
   @ObfuscatedName("ak")
   int[] field1018;
   @ObfuscatedName("ax")
   int[] field1019;
   @ObfuscatedName("as")
   int field1027 = 0;
   @ObfuscatedName("ay")
   int field1012 = 0;
   @ObfuscatedName("am")
   int[] field1026;
   @ObfuscatedName("az")
   int[] field1022;
   @ObfuscatedName("ae")
   int[] field1023;
   @ObfuscatedName("au")
   int[] field1024;
   @ObfuscatedName("ag")
   int field1025 = 0;
   @ObfuscatedName("at")
   int field1021 = 0;
   @ObfuscatedName("af")
   int field1014 = 0;

   @ObfuscatedSignature(
      descriptor = "([Lsp;)V"
   )
   LoginScreenAnimation(IndexedSprite[] var1) {
      this.field1020 = var1;
      this.initColors();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-64"
   )
   @Export("initColors")
   void initColors() {
      this.field1017 = new int[256];

      int var1;
      for(var1 = 0; var1 < 64; ++var1) {
         this.field1017[var1] = var1 * 262144;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1017[var1 + 64] = var1 * 1024 + 16711680;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1017[var1 + 128] = var1 * 4 + 16776960;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1017[var1 + 192] = 16777215;
      }

      this.field1018 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1018[var1] = var1 * 1024;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1018[var1 + 64] = var1 * 4 + '\uff00';
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1018[var1 + 128] = var1 * 262144 + '\uffff';
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1018[var1 + 192] = 16777215;
      }

      this.field1019 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1019[var1] = var1 * 4;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1019[var1 + 64] = var1 * 262144 + 255;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1019[var1 + 128] = var1 * 1024 + 16711935;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1019[var1 + 192] = 16777215;
      }

      this.field1016 = new int[256];
      this.field1025 = 0;
      this.field1023 = new int['耀'];
      this.field1024 = new int['耀'];
      this.method517((IndexedSprite)null);
      this.field1026 = new int['耀'];
      this.field1022 = new int['耀'];
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1947284022"
   )
   void method520() {
      this.field1017 = null;
      this.field1018 = null;
      this.field1019 = null;
      this.field1016 = null;
      this.field1023 = null;
      this.field1024 = null;
      this.field1026 = null;
      this.field1022 = null;
      this.field1025 = 0;
      this.field1021 = 0;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-1856839217"
   )
   @Export("draw")
   void draw(int var1, int var2) {
      if (this.field1026 == null) {
         this.initColors();
      }

      if (this.field1014 == 0) {
         this.field1014 = var2;
      }

      int var3 = var2 - this.field1014;
      if (var3 >= 256) {
         var3 = 0;
      }

      this.field1014 = var2;
      if (var3 > 0) {
         this.method513(var3);
      }

      this.method514(var1);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-2069106519"
   )
   final void method513(int var1) {
      this.field1025 += var1 * 128;
      int var2;
      if (this.field1025 > this.field1023.length) {
         this.field1025 -= this.field1023.length;
         var2 = (int)(Math.random() * 12.0D);
         this.method517(this.field1020[var2]);
      }

      var2 = 0;
      int var3 = var1 * 128;
      int var4 = (256 - var1) * 128;

      int var6;
      for(int var5 = 0; var5 < var4; ++var5) {
         var6 = this.field1026[var2 + var3] - this.field1023[var2 + this.field1025 & this.field1023.length - 1] * var1 / 6;
         if (var6 < 0) {
            var6 = 0;
         }

         this.field1026[var2++] = var6;
      }

      byte var15 = 10;
      var6 = 128 - var15;

      int var7;
      int var10;
      for(var7 = 256 - var1; var7 < 256; ++var7) {
         int var8 = var7 * 128;

         for(int var9 = 0; var9 < 128; ++var9) {
            var10 = (int)(Math.random() * 100.0D);
            if (var10 < 50 && var9 > var15 && var9 < var6) {
               this.field1026[var8 + var9] = 255;
            } else {
               this.field1026[var9 + var8] = 0;
            }
         }
      }

      if (this.field1027 > 0) {
         this.field1027 -= var1 * 4;
      }

      if (this.field1012 > 0) {
         this.field1012 -= var1 * 4;
      }

      if (this.field1027 == 0 && this.field1012 == 0) {
         var7 = (int)(Math.random() * (double)(2000 / var1));
         if (var7 == 0) {
            this.field1027 = 1024;
         }

         if (var7 == 1) {
            this.field1012 = 1024;
         }
      }

      for(var7 = 0; var7 < 256 - var1; ++var7) {
         this.field1013[var7] = this.field1013[var7 + var1];
      }

      for(var7 = 256 - var1; var7 < 256; ++var7) {
         this.field1013[var7] = (int)(Math.sin((double)this.field1015 / 14.0D) * 16.0D + Math.sin((double)this.field1015 / 15.0D) * 14.0D + Math.sin((double)this.field1015 / 16.0D) * 12.0D);
         ++this.field1015;
      }

      this.field1021 += var1;
      var7 = ((Client.cycle & 1) + var1) / 2;
      if (var7 > 0) {
         short var16 = 128;
         byte var17 = 2;
         var10 = 128 - var17 - var17;

         int var11;
         int var12;
         int var13;
         for(var11 = 0; var11 < this.field1021 * 100; ++var11) {
            var12 = (int)(Math.random() * (double)var10) + var17;
            var13 = (int)(Math.random() * (double)var16) + var16;
            this.field1026[var12 + (var13 << 7)] = 192;
         }

         this.field1021 = 0;

         int var14;
         for(var11 = 0; var11 < 256; ++var11) {
            var12 = 0;
            var13 = var11 * 128;

            for(var14 = -var7; var14 < 128; ++var14) {
               if (var7 + var14 < 128) {
                  var12 += this.field1026[var7 + var14 + var13];
               }

               if (var14 - (var7 + 1) >= 0) {
                  var12 -= this.field1026[var14 + var13 - (var7 + 1)];
               }

               if (var14 >= 0) {
                  this.field1022[var13 + var14] = var12 / (var7 * 2 + 1);
               }
            }
         }

         for(var11 = 0; var11 < 128; ++var11) {
            var12 = 0;

            for(var13 = -var7; var13 < 256; ++var13) {
               var14 = var13 * 128;
               if (var13 + var7 < 256) {
                  var12 += this.field1022[var14 + var11 + var7 * 128];
               }

               if (var13 - (var7 + 1) >= 0) {
                  var12 -= this.field1022[var14 + var11 - (var7 + 1) * 128];
               }

               if (var13 >= 0) {
                  this.field1026[var11 + var14] = var12 / (var7 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "1192166879"
   )
   final int method518(int var1, int var2, int var3) {
      int var4 = 256 - var3;
      return (var3 * (var2 & '\uff00') + var4 * (var1 & '\uff00') & 16711680) + (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "114"
   )
   final void method514(int var1) {
      int var2 = this.field1016.length;
      if (this.field1027 > 0) {
         this.method515(this.field1027, this.field1018);
      } else if (this.field1012 > 0) {
         this.method515(this.field1012, this.field1019);
      } else {
         for(int var3 = 0; var3 < var2; ++var3) {
            this.field1016[var3] = this.field1017[var3];
         }
      }

      this.method516(var1);
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I[IB)V",
      garbageValue = "100"
   )
   final void method515(int var1, int[] var2) {
      int var3 = this.field1016.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if (var1 > 768) {
            this.field1016[var4] = this.method518(this.field1017[var4], var2[var4], 1024 - var1);
         } else if (var1 > 256) {
            this.field1016[var4] = var2[var4];
         } else {
            this.field1016[var4] = this.method518(var2[var4], this.field1017[var4], 256 - var1);
         }
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "7"
   )
   final void method516(int var1) {
      int var2 = 0;

      for(int var3 = 1; var3 < 255; ++var3) {
         int var4 = (256 - var3) * this.field1013[var3] / 256;
         int var5 = var4 + var1;
         int var6 = 0;
         int var7 = 128;
         if (var5 < 0) {
            var6 = -var5;
            var5 = 0;
         }

         if (var5 + 128 >= StudioGame.rasterProvider.width) {
            var7 = StudioGame.rasterProvider.width - var5;
         }

         int var8 = var5 + (var3 + 8) * StudioGame.rasterProvider.width;
         var2 += var6;

         for(int var9 = var6; var9 < var7; ++var9) {
            int var10 = this.field1026[var2++];
            int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
            if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
               int var12 = var10;
               int var13 = 256 - var10;
               var10 = this.field1016[var10];
               int var14 = StudioGame.rasterProvider.pixels[var8];
               StudioGame.rasterProvider.pixels[var8++] = -16777216 | (var13 * (var14 & '\uff00') + var12 * (var10 & '\uff00') & 16711680) + ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) >> 8;
            } else {
               ++var8;
            }
         }

         var2 += 128 - var7;
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(Lsp;B)V",
      garbageValue = "11"
   )
   final void method517(IndexedSprite var1) {
      int var2;
      for(var2 = 0; var2 < this.field1023.length; ++var2) {
         this.field1023[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * 256.0D);
         this.field1023[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < 255; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               this.field1024[var5] = (this.field1023[var5 - 128] + this.field1023[var5 + 1] + this.field1023[var5 + 128] + this.field1023[var5 - 1]) / 4;
            }
         }

         int[] var8 = this.field1023;
         this.field1023 = this.field1024;
         this.field1024 = var8;
      }

      if (var1 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var1.subHeight; ++var3) {
            for(var4 = 0; var4 < var1.subWidth; ++var4) {
               if (var1.pixels[var2++] != 0) {
                  var5 = var4 + var1.xOffset + 16;
                  int var6 = var3 + var1.yOffset + 16;
                  int var7 = var5 + (var6 << 7);
                  this.field1023[var7] = 0;
               }
            }
         }
      }

   }
}
