import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "[Lrg;"
   )
   IndexedSprite[] field1021;
   @ObfuscatedName("i")
   int[] field1019 = new int[256];
   @ObfuscatedName("n")
   int field1017 = 0;
   @ObfuscatedName("l")
   int[] field1029;
   @ObfuscatedName("k")
   int[] field1026;
   @ObfuscatedName("c")
   int[] field1022;
   @ObfuscatedName("r")
   int[] field1023;
   @ObfuscatedName("b")
   int field1024 = 0;
   @ObfuscatedName("m")
   int field1025 = 0;
   @ObfuscatedName("t")
   int[] field1016;
   @ObfuscatedName("h")
   int[] field1027;
   @ObfuscatedName("p")
   int[] field1028;
   @ObfuscatedName("o")
   int[] field1018;
   @ObfuscatedName("u")
   int field1030 = 0;
   @ObfuscatedName("x")
   int field1031 = 0;
   @ObfuscatedName("a")
   int field1020 = 0;

   @ObfuscatedSignature(
      descriptor = "([Lrg;)V"
   )
   LoginScreenAnimation(IndexedSprite[] var1) {
      this.field1021 = var1;
      this.initColors();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
           descriptor = "(I)V",
           garbageValue = "-91507505"
   )
   void initColors() {
      this.field1026 = new int[256];

      int var1;
      for(var1 = 0; var1 < 64; ++var1) {
         this.field1026[var1] = var1 * 262144;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1026[var1 + 64] = var1 * 1024 + 16711680;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1026[var1 + 128] = var1 * 4 + 16776960;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1026[var1 + 192] = 16777215;
      }

      this.field1022 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1022[var1] = var1 * 1024;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1022[var1 + 64] = var1 * 4 + '\uff00';
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1022[var1 + 128] = var1 * 262144 + '\uffff';
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1022[var1 + 192] = 16777215;
      }

      this.field1023 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1023[var1] = var1 * 4;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1023[var1 + 64] = var1 * 262144 + 255;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1023[var1 + 128] = var1 * 1024 + 16711935;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1023[var1 + 192] = 16777215;
      }

      this.field1029 = new int[256];
      this.field1030 = 0;
      this.field1028 = new int['耀'];
      this.field1018 = new int['耀'];
      this.method514((IndexedSprite)null);
      this.field1016 = new int['耀'];
      this.field1027 = new int['耀'];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-232497301"
   )
   void method517() {
      this.field1026 = null;
      this.field1022 = null;
      this.field1023 = null;
      this.field1029 = null;
      this.field1028 = null;
      this.field1018 = null;
      this.field1016 = null;
      this.field1027 = null;
      this.field1030 = 0;
      this.field1031 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
           descriptor = "(III)V",
           garbageValue = "531628471"
   )
   void draw(int var1, int var2) {
      if (this.field1016 == null) {
         this.initColors();
      }

      if (this.field1020 == 0) {
         this.field1020 = var2;
      }

      int var3 = var2 - this.field1020;
      if (var3 >= 256) {
         var3 = 0;
      }

      this.field1020 = var2;
      if (var3 > 0) {
         this.method511(var3);
      }

      this.method513(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "13"
   )
   final void method511(int var1) {
      this.field1030 += var1 * 128;
      int var2;
      if (this.field1030 > this.field1028.length) {
         this.field1030 -= this.field1028.length;
         var2 = (int)(Math.random() * 12.0D);
         this.method514(this.field1021[var2]);
      }

      var2 = 0;
      int var3 = var1 * 128;
      int var4 = (256 - var1) * 128;

      int var6;
      for(int var5 = 0; var5 < var4; ++var5) {
         var6 = this.field1016[var2 + var3] - this.field1028[var2 + this.field1030 & this.field1028.length - 1] * var1 / 6;
         if (var6 < 0) {
            var6 = 0;
         }

         this.field1016[var2++] = var6;
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
               this.field1016[var8 + var9] = 255;
            } else {
               this.field1016[var8 + var9] = 0;
            }
         }
      }

      if (this.field1024 > 0) {
         this.field1024 -= var1 * 4;
      }

      if (this.field1025 > 0) {
         this.field1025 -= var1 * 4;
      }

      if (this.field1024 == 0 && this.field1025 == 0) {
         var7 = (int)(Math.random() * (double)(2000 / var1));
         if (var7 == 0) {
            this.field1024 = 1024;
         }

         if (var7 == 1) {
            this.field1025 = 1024;
         }
      }

      for(var7 = 0; var7 < 256 - var1; ++var7) {
         this.field1019[var7] = this.field1019[var7 + var1];
      }

      for(var7 = 256 - var1; var7 < 256; ++var7) {
         this.field1019[var7] = (int)(Math.sin((double)this.field1017 / 14.0D) * 16.0D + Math.sin((double)this.field1017 / 15.0D) * 14.0D + Math.sin((double)this.field1017 / 16.0D) * 12.0D);
         ++this.field1017;
      }

      this.field1031 += var1;
      var7 = ((Client.cycle & 1) + var1) / 2;
      if (var7 > 0) {
         short var16 = 128;
         byte var17 = 2;
         var10 = 128 - var17 - var17;

         int var11;
         int var12;
         int var13;
         for(var11 = 0; var11 < this.field1031 * 100; ++var11) {
            var12 = (int)(Math.random() * (double)var10) + var17;
            var13 = (int)(Math.random() * (double)var16) + var16;
            this.field1016[var12 + (var13 << 7)] = 192;
         }

         this.field1031 = 0;

         int var14;
         for(var11 = 0; var11 < 256; ++var11) {
            var12 = 0;
            var13 = var11 * 128;

            for(var14 = -var7; var14 < 128; ++var14) {
               if (var7 + var14 < 128) {
                  var12 += this.field1016[var13 + var14 + var7];
               }

               if (var14 - (var7 + 1) >= 0) {
                  var12 -= this.field1016[var14 + var13 - (var7 + 1)];
               }

               if (var14 >= 0) {
                  this.field1027[var14 + var13] = var12 / (var7 * 2 + 1);
               }
            }
         }

         for(var11 = 0; var11 < 128; ++var11) {
            var12 = 0;

            for(var13 = -var7; var13 < 256; ++var13) {
               var14 = var13 * 128;
               if (var7 + var13 < 256) {
                  var12 += this.field1027[var14 + var11 + var7 * 128];
               }

               if (var13 - (var7 + 1) >= 0) {
                  var12 -= this.field1027[var14 + var11 - (var7 + 1) * 128];
               }

               if (var13 >= 0) {
                  this.field1016[var11 + var14] = var12 / (var7 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "1478312132"
   )
   final int method512(int var1, int var2, int var3) {
      int var4 = 256 - var3;
      return (var4 * (var1 & 16711935) + var3 * (var2 & 16711935) & -16711936) + (var3 * (var2 & '\uff00') + var4 * (var1 & '\uff00') & 16711680) >> 8;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "893483018"
   )
   final void method513(int var1) {
      int var2 = this.field1029.length;
      if (this.field1024 > 0) {
         this.method515(this.field1024, this.field1022);
      } else if (this.field1025 > 0) {
         this.method515(this.field1025, this.field1023);
      } else {
         for(int var3 = 0; var3 < var2; ++var3) {
            this.field1029[var3] = this.field1026[var3];
         }
      }

      this.method518(var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I[II)V",
      garbageValue = "711796277"
   )
   final void method515(int var1, int[] var2) {
      int var3 = this.field1029.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if (var1 > 768) {
            this.field1029[var4] = this.method512(this.field1026[var4], var2[var4], 1024 - var1);
         } else if (var1 > 256) {
            this.field1029[var4] = var2[var4];
         } else {
            this.field1029[var4] = this.method512(var2[var4], this.field1026[var4], 256 - var1);
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "0"
   )
   final void method518(int var1) {
      int var2 = 0;

      for(int var3 = 1; var3 < 255; ++var3) {
         int var4 = (256 - var3) * this.field1019[var3] / 256;
         int var5 = var4 + var1;
         int var6 = 0;
         int var7 = 128;
         if (var5 < 0) {
            var6 = -var5;
            var5 = 0;
         }

         if (var5 + 128 >= KeyHandler.rasterProvider.width) {
            var7 = KeyHandler.rasterProvider.width - var5;
         }

         int var8 = var5 + (var3 + 8) * KeyHandler.rasterProvider.width;
         var2 += var6;

         for(int var9 = var6; var9 < var7; ++var9) {
            int var10 = this.field1016[var2++];
            int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
            if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
               int var12 = var10;
               int var13 = 256 - var10;
               var10 = this.field1029[var10];
               int var14 = KeyHandler.rasterProvider.pixels[var8];
               KeyHandler.rasterProvider.pixels[var8++] = -16777216 | ((var14 & 16711935) * var13 + (var10 & 16711935) * var12 & -16711936) + (var13 * (var14 & '\uff00') + var12 * (var10 & '\uff00') & 16711680) >> 8;
            } else {
               ++var8;
            }
         }

         var2 += 128 - var7;
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(Lrg;I)V",
      garbageValue = "-445402155"
   )
   final void method514(IndexedSprite var1) {
      int var2;
      for(var2 = 0; var2 < this.field1028.length; ++var2) {
         this.field1028[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * 256.0D);
         this.field1028[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < 255; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               this.field1018[var5] = (this.field1028[var5 - 128] + this.field1028[var5 + 1] + this.field1028[var5 + 128] + this.field1028[var5 - 1]) / 4;
            }
         }

         int[] var8 = this.field1028;
         this.field1028 = this.field1018;
         this.field1018 = var8;
      }

      if (var1 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var1.subHeight; ++var3) {
            for(var4 = 0; var4 < var1.subWidth; ++var4) {
               if (var1.pixels[var2++] != 0) {
                  var5 = var4 + var1.xOffset + 16;
                  int var6 = var3 + var1.yOffset + 16;
                  int var7 = var5 + (var6 << 7);
                  this.field1028[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("ko")
   @ObfuscatedSignature(
           descriptor = "(Lkz;I)V",
           garbageValue = "-1091260727"
   )
   public static void invalidateWidget(Widget var0) {
      if (var0 != null && var0.cycle == Client.field590) {
         Client.field591[var0.rootIndex] = true;
      }

   }

   @ObfuscatedName("kl")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "5494"
   )
   static final void method516(int var0) {
      var0 = Math.max(Math.min(var0, 100), 0);
      var0 = 100 - var0;
      float var1 = 0.5F + (float)var0 / 200.0F;
      Rasterizer3D.Rasterizer3D_setBrightness((double)var1);
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).setBrightness((double)var1);
      ItemComposition.ItemDefinition_cachedSprites.clear();
      PacketWriter.clientPreferences.setBrightness((double)var1);
   }
}
