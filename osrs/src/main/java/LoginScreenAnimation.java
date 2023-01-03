import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("LoginScreenAnimation")
public class LoginScreenAnimation {
   @ObfuscatedName("tn")
   @Export("cameraLookAtAcceleration")
   static int cameraLookAtAcceleration;
   @ObfuscatedName("qk")
   @ObfuscatedSignature(
      descriptor = "Lob;"
   )
   static class414 field1028;
   @ObfuscatedName("ri")
   @ObfuscatedSignature(
      descriptor = "Lrt;"
   )
   @Export("privateChatMode")
   static PrivateChatMode privateChatMode;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "[Lra;"
   )
   IndexedSprite[] field1014;
   @ObfuscatedName("f")
   int[] field1016 = new int[256];
   @ObfuscatedName("r")
   int field1013 = 0;
   @ObfuscatedName("u")
   int[] field1025;
   @ObfuscatedName("b")
   int[] field1020;
   @ObfuscatedName("j")
   int[] field1015;
   @ObfuscatedName("g")
   int[] field1012;
   @ObfuscatedName("i")
   int field1027 = 0;
   @ObfuscatedName("o")
   int field1018 = 0;
   @ObfuscatedName("n")
   int[] field1019;
   @ObfuscatedName("k")
   int[] field1023;
   @ObfuscatedName("a")
   int[] field1021;
   @ObfuscatedName("s")
   int[] field1022;
   @ObfuscatedName("l")
   int field1011 = 0;
   @ObfuscatedName("t")
   int field1024 = 0;
   @ObfuscatedName("c")
   int field1017 = 0;

   @ObfuscatedSignature(
      descriptor = "([Lra;)V"
   )
   LoginScreenAnimation(IndexedSprite[] var1) {
      this.field1014 = var1;
      this.initColors();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "87"
   )
   @Export("initColors")
   void initColors() {
      this.field1020 = new int[256];

      int var1;
      for(var1 = 0; var1 < 64; ++var1) {
         this.field1020[var1] = var1 * 262144;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1020[var1 + 64] = var1 * 1024 + 16711680;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1020[var1 + 128] = var1 * 4 + 16776960;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1020[var1 + 192] = 16777215;
      }

      this.field1015 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1015[var1] = var1 * 1024;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1015[var1 + 64] = var1 * 4 + '\uff00';
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1015[var1 + 128] = var1 * 262144 + '\uffff';
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1015[var1 + 192] = 16777215;
      }

      this.field1012 = new int[256];

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1012[var1] = var1 * 4;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1012[var1 + 64] = var1 * 262144 + 255;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1012[var1 + 128] = var1 * 1024 + 16711935;
      }

      for(var1 = 0; var1 < 64; ++var1) {
         this.field1012[var1 + 192] = 16777215;
      }

      this.field1025 = new int[256];
      this.field1011 = 0;
      this.field1021 = new int['耀'];
      this.field1022 = new int['耀'];
      this.method526((IndexedSprite)null);
      this.field1019 = new int['耀'];
      this.field1023 = new int['耀'];
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "0"
   )
   void method528() {
      this.field1020 = null;
      this.field1015 = null;
      this.field1012 = null;
      this.field1025 = null;
      this.field1021 = null;
      this.field1022 = null;
      this.field1019 = null;
      this.field1023 = null;
      this.field1011 = 0;
      this.field1024 = 0;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1789761719"
   )
   @Export("draw")
   void draw(int var1, int var2) {
      if (this.field1019 == null) {
         this.initColors();
      }

      if (this.field1017 == 0) {
         this.field1017 = var2;
      }

      int var3 = var2 - this.field1017;
      if (var3 >= 256) {
         var3 = 0;
      }

      this.field1017 = var2;
      if (var3 > 0) {
         this.method524(var3);
      }

      this.method522(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1516509810"
   )
   final void method524(int var1) {
      this.field1011 += 128 * var1;
      int var2;
      if (this.field1011 > this.field1021.length) {
         this.field1011 -= this.field1021.length;
         var2 = (int)(Math.random() * 12.0D);
         this.method526(this.field1014[var2]);
      }

      var2 = 0;
      int var3 = var1 * 128;
      int var4 = (256 - var1) * 128;

      int var6;
      for(int var5 = 0; var5 < var4; ++var5) {
         var6 = this.field1019[var3 + var2] - this.field1021[var2 + this.field1011 & this.field1021.length - 1] * var1 / 6;
         if (var6 < 0) {
            var6 = 0;
         }

         this.field1019[var2++] = var6;
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
               this.field1019[var9 + var8] = 255;
            } else {
               this.field1019[var8 + var9] = 0;
            }
         }
      }

      if (this.field1027 > 0) {
         this.field1027 -= var1 * 4;
      }

      if (this.field1018 > 0) {
         this.field1018 -= var1 * 4;
      }

      if (this.field1027 == 0 && this.field1018 == 0) {
         var7 = (int)(Math.random() * (double)(2000 / var1));
         if (var7 == 0) {
            this.field1027 = 1024;
         }

         if (var7 == 1) {
            this.field1018 = 1024;
         }
      }

      for(var7 = 0; var7 < 256 - var1; ++var7) {
         this.field1016[var7] = this.field1016[var7 + var1];
      }

      for(var7 = 256 - var1; var7 < 256; ++var7) {
         this.field1016[var7] = (int)(Math.sin((double)this.field1013 / 14.0D) * 16.0D + Math.sin((double)this.field1013 / 15.0D) * 14.0D + Math.sin((double)this.field1013 / 16.0D) * 12.0D);
         ++this.field1013;
      }

      this.field1024 += var1;
      var7 = ((Client.cycle & 1) + var1) / 2;
      if (var7 > 0) {
         short var16 = 128;
         byte var17 = 2;
         var10 = 128 - var17 - var17;

         int var11;
         int var12;
         int var13;
         for(var11 = 0; var11 < this.field1024 * 100; ++var11) {
            var12 = (int)(Math.random() * (double)var10) + var17;
            var13 = (int)(Math.random() * (double)var16) + var16;
            this.field1019[var12 + (var13 << 7)] = 192;
         }

         this.field1024 = 0;

         int var14;
         for(var11 = 0; var11 < 256; ++var11) {
            var12 = 0;
            var13 = var11 * 128;

            for(var14 = -var7; var14 < 128; ++var14) {
               if (var14 + var7 < 128) {
                  var12 += this.field1019[var7 + var13 + var14];
               }

               if (var14 - (var7 + 1) >= 0) {
                  var12 -= this.field1019[var13 + var14 - (var7 + 1)];
               }

               if (var14 >= 0) {
                  this.field1023[var14 + var13] = var12 / (var7 * 2 + 1);
               }
            }
         }

         for(var11 = 0; var11 < 128; ++var11) {
            var12 = 0;

            for(var13 = -var7; var13 < 256; ++var13) {
               var14 = var13 * 128;
               if (var7 + var13 < 256) {
                  var12 += this.field1023[var11 + var14 + var7 * 128];
               }

               if (var13 - (var7 + 1) >= 0) {
                  var12 -= this.field1023[var11 + var14 - (var7 + 1) * 128];
               }

               if (var13 >= 0) {
                  this.field1019[var14 + var11] = var12 / (var7 * 2 + 1);
               }
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IIIS)I",
      garbageValue = "-25186"
   )
   final int method531(int var1, int var2, int var3) {
      int var4 = 256 - var3;
      return (var3 * (var2 & '\uff00') + var4 * (var1 & '\uff00') & 16711680) + (var3 * (var2 & 16711935) + var4 * (var1 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "854312768"
   )
   final void method522(int var1) {
      int var2 = this.field1025.length;
      if (this.field1027 > 0) {
         this.method525(this.field1027, this.field1015);
      } else if (this.field1018 > 0) {
         this.method525(this.field1018, this.field1012);
      } else {
         for(int var3 = 0; var3 < var2; ++var3) {
            this.field1025[var3] = this.field1020[var3];
         }
      }

      this.method530(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I[II)V",
      garbageValue = "-583340799"
   )
   final void method525(int var1, int[] var2) {
      int var3 = this.field1025.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         if (var1 > 768) {
            this.field1025[var4] = this.method531(this.field1020[var4], var2[var4], 1024 - var1);
         } else if (var1 > 256) {
            this.field1025[var4] = var2[var4];
         } else {
            this.field1025[var4] = this.method531(var2[var4], this.field1020[var4], 256 - var1);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-59"
   )
   final void method530(int var1) {
      int var2 = 0;

      for(int var3 = 1; var3 < 255; ++var3) {
         int var4 = (256 - var3) * this.field1016[var3] / 256;
         int var5 = var4 + var1;
         int var6 = 0;
         int var7 = 128;
         if (var5 < 0) {
            var6 = -var5;
            var5 = 0;
         }

         if (var5 + 128 >= RouteStrategy.rasterProvider.width) {
            var7 = RouteStrategy.rasterProvider.width - var5;
         }

         int var8 = var5 + (var3 + 8) * RouteStrategy.rasterProvider.width;
         var2 += var6;

         for(int var9 = var6; var9 < var7; ++var9) {
            int var10 = this.field1019[var2++];
            int var11 = var8 % Rasterizer2D.Rasterizer2D_width;
            if (var10 != 0 && var11 >= Rasterizer2D.Rasterizer2D_xClipStart && var11 < Rasterizer2D.Rasterizer2D_xClipEnd) {
               int var12 = var10;
               int var13 = 256 - var10;
               var10 = this.field1025[var10];
               int var14 = RouteStrategy.rasterProvider.pixels[var8];
               RouteStrategy.rasterProvider.pixels[var8++] = -16777216 | ((var10 & 16711935) * var12 + (var14 & 16711935) * var13 & -16711936) + (var12 * (var10 & '\uff00') + var13 * (var14 & '\uff00') & 16711680) >> 8;
            } else {
               ++var8;
            }
         }

         var2 += 128 - var7;
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(Lra;B)V",
      garbageValue = "-14"
   )
   final void method526(IndexedSprite var1) {
      int var2;
      for(var2 = 0; var2 < this.field1021.length; ++var2) {
         this.field1021[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * 256.0D);
         this.field1021[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < 255; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               this.field1022[var5] = (this.field1021[var5 + 128] + this.field1021[var5 - 128] + this.field1021[var5 + 1] + this.field1021[var5 - 1]) / 4;
            }
         }

         int[] var8 = this.field1021;
         this.field1021 = this.field1022;
         this.field1022 = var8;
      }

      if (var1 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var1.subHeight; ++var3) {
            for(var4 = 0; var4 < var1.subWidth; ++var4) {
               if (var1.pixels[var2++] != 0) {
                  var5 = var4 + var1.xOffset + 16;
                  int var6 = var3 + var1.yOffset + 16;
                  int var7 = var5 + (var6 << 7);
                  this.field1021[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "1833502915"
   )
   static String method529() {
      StringBuilder var0 = new StringBuilder();

      Message var2;
      for(Iterator var1 = Messages.Messages_hashTable.iterator(); var1.hasNext(); var0.append(var2.text).append('\n')) {
         var2 = (Message)var1.next();
         if (var2.sender != null && !var2.sender.isEmpty()) {
            var0.append(var2.sender).append(':');
         }
      }

      return var0.toString();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(Lkd;I)I",
      garbageValue = "1493565771"
   )
   static int method527(Widget var0) {
      if (var0.type != 11) {
         Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize - 1] = "";
         return 1;
      } else {
         String var1 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var0.method1726(var1);
         return 1;
      }
   }

   @ObfuscatedName("na")
   @ObfuscatedSignature(
      descriptor = "(II)Lqf;",
      garbageValue = "1223108366"
   )
   static class460 method532(int var0) {
      class460 var1 = (class460)Client.Widget_cachedModels.get((long)var0);
      if (var1 == null) {
         var1 = new class460(Ignored.field3698, class300.method1620(var0), DbTableType.method2315(var0));
         Client.Widget_cachedModels.put(var1, (long)var0);
      }

      return var1;
   }
}
