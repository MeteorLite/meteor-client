import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gk")
public class FloorOverlayDefinition extends DualNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   public static AbstractArchive FloorOverlayDefinition_archive;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ljv;"
   )
   public static EvictingDualNodeHashTable FloorOverlayDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1182759391
   )
   public int primaryRgb = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1895167641
   )
   public int texture = -1;
   @ObfuscatedName("m")
   public boolean hideUnderlay = true;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1072167613
   )
   public int secondaryRgb = -1;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 246160419
   )
   public int hue;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 569764261
   )
   public int saturation;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -958370413
   )
   public int lightness;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -549780663
   )
   public int secondaryHue;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -628893625
   )
   public int secondarySaturation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -245050165
   )
   public int secondaryLightness;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "263415737"
   )
   public void postDecode() {
      if (this.secondaryRgb != -1) {
         this.setHsl(this.secondaryRgb);
         this.secondaryHue = this.hue;
         this.secondarySaturation = this.saturation;
         this.secondaryLightness = this.lightness;
      }

      this.setHsl(this.primaryRgb);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqy;II)V",
      garbageValue = "1064972776"
   )
   public void decode(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.readUnsignedByte();
         if (var3 == 0) {
            return;
         }

         this.decodeNext(var1, var3, var2);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lqy;III)V",
      garbageValue = "-1744958281"
   )
   void decodeNext(Buffer var1, int var2, int var3) {
      if (var2 == 1) {
         this.primaryRgb = var1.readMedium();
      } else if (var2 == 2) {
         this.texture = var1.readUnsignedByte();
      } else if (var2 == 5) {
         this.hideUnderlay = false;
      } else if (var2 == 7) {
         this.secondaryRgb = var1.readMedium();
      } else if (var2 == 8) {
         ;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "596293894"
   )
   void setHsl(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if (var4 < var2) {
         var8 = var4;
      }

      if (var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if (var4 > var2) {
         var10 = var4;
      }

      if (var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if (var8 != var10) {
         if (var16 < 0.5D) {
            var14 = (var10 - var8) / (var8 + var10);
         }

         if (var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if (var2 == var10) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if (var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if (var6 == var10) {
            var12 = (var2 - var4) / (var10 - var8) + 4.0D;
         }
      }

      var12 /= 6.0D;
      this.hue = (int)(var12 * 256.0D);
      this.saturation = (int)(var14 * 256.0D);
      this.lightness = (int)(var16 * 256.0D);
      if (this.saturation < 0) {
         this.saturation = 0;
      } else if (this.saturation > 255) {
         this.saturation = 255;
      }

      if (this.lightness < 0) {
         this.lightness = 0;
      } else if (this.lightness > 255) {
         this.lightness = 255;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ldu;FI)F",
      garbageValue = "-297872691"
   )
   static float method3995(class125 var0, float var1) {
      if (var0 != null && var0.method2947() != 0) {
         if (var1 < (float)var0.field1541[0].field1502) {
            return var0.field1539 == class124.field1535 ? var0.field1541[0].field1497 : FriendSystem.method1828(var0, var1, true);
         } else if (var1 > (float)var0.field1541[var0.method2947() - 1].field1502) {
            return var0.field1540 == class124.field1535 ? var0.field1541[var0.method2947() - 1].field1497 : FriendSystem.method1828(var0, var1, false);
         } else if (var0.field1538) {
            return var0.field1541[0].field1497;
         } else {
            class121 var2 = var0.method2950(var1);
            boolean var3 = false;
            boolean var4 = false;
            if (var2 == null) {
               return 0.0F;
            } else {
               if ((double)var2.field1500 == 0.0D && 0.0D == (double)var2.field1498) {
                  var3 = true;
               } else if (var2.field1500 == Float.MAX_VALUE && var2.field1498 == Float.MAX_VALUE) {
                  var4 = true;
               } else if (var2.field1501 != null) {
                  if (var0.field1553) {
                     float var5 = (float)var2.field1502;
                     float var9 = var2.field1497;
                     float var6 = var5 + var2.field1500 * 0.33333334F;
                     float var10 = var2.field1498 * 0.33333334F + var9;
                     float var8 = (float)var2.field1501.field1502;
                     float var12 = var2.field1501.field1497;
                     float var7 = var8 - var2.field1501.field1496 * 0.33333334F;
                     float var11 = var12 - var2.field1501.field1499 * 0.33333334F;
                     if (var0.field1547) {
                        float var15 = var10;
                        float var16 = var11;
                        if (var0 != null) {
                           float var17 = var8 - var5;
                           if ((double)var17 != 0.0D) {
                              float var18 = var6 - var5;
                              float var19 = var7 - var5;
                              float[] var20 = new float[]{var18 / var17, var19 / var17};
                              var0.field1557 = var20[0] == 0.33333334F && 0.6666667F == var20[1];
                              float var21 = var20[0];
                              float var22 = var20[1];
                              if ((double)var20[0] < 0.0D) {
                                 var20[0] = 0.0F;
                              }

                              if ((double)var20[1] > 1.0D) {
                                 var20[1] = 1.0F;
                              }

                              float var23;
                              float var24;
                              float var25;
                              float var26;
                              float var27;
                              if ((double)var20[0] > 1.0D || var20[1] < -1.0F) {
                                 var20[1] = 1.0F - var20[1];
                                 if (var20[0] < 0.0F) {
                                    var20[0] = 0.0F;
                                 }

                                 if (var20[1] < 0.0F) {
                                    var20[1] = 0.0F;
                                 }

                                 if (var20[0] > 1.0F || var20[1] > 1.0F) {
                                    var23 = (float)(1.0D + (double)(var20[0] * (var20[0] - 2.0F + var20[1])) + ((double)var20[1] - 2.0D) * (double)var20[1]);
                                    if (var23 + class122.field1506 > 0.0F) {
                                       if (class122.field1506 + var20[0] < 1.3333334F) {
                                          var24 = var20[0] - 2.0F;
                                          var25 = var20[0] - 1.0F;
                                          var26 = (float)Math.sqrt((double)(var24 * var24 - var25 * 4.0F * var25));
                                          var27 = (-var24 + var26) * 0.5F;
                                          if (var20[1] + class122.field1506 > var27) {
                                             var20[1] = var27 - class122.field1506;
                                          } else {
                                             var27 = 0.5F * (-var24 - var26);
                                             if (var20[1] < var27 + class122.field1506) {
                                                var20[1] = var27 + class122.field1506;
                                             }
                                          }
                                       } else {
                                          var20[0] = 1.3333334F - class122.field1506;
                                          var20[1] = 0.33333334F - class122.field1506;
                                       }
                                    }
                                 }

                                 var20[1] = 1.0F - var20[1];
                              }

                              if (var21 != var20[0]) {
                                 float var10000 = var5 + var17 * var20[0];
                                 if (0.0D != (double)var21) {
                                    var15 = var9 + var20[0] * (var10 - var9) / var21;
                                 }
                              }

                              if (var20[1] != var22) {
                                 float var14 = var20[1] * var17 + var5;
                                 if ((double)var22 != 1.0D) {
                                    var16 = (float)((double)var12 - (1.0D - (double)var20[1]) * (double)(var12 - var11) / (1.0D - (double)var22));
                                 }
                              }

                              var0.field1543 = var5;
                              var0.field1544 = var8;
                              var23 = var20[0];
                              var24 = var20[1];
                              var25 = var23 - 0.0F;
                              var26 = var24 - var23;
                              var27 = 1.0F - var24;
                              float var28 = var26 - var25;
                              var0.field1548 = var27 - var26 - var28;
                              var0.field1537 = var28 + var28 + var28;
                              var0.field1559 = var25 + var25 + var25;
                              var0.field1545 = 0.0F;
                              var25 = var15 - var9;
                              var26 = var16 - var15;
                              var27 = var12 - var16;
                              var28 = var26 - var25;
                              var0.field1552 = var27 - var26 - var28;
                              var0.field1551 = var28 + var28 + var28;
                              var0.field1550 = var25 + var25 + var25;
                              var0.field1549 = var9;
                           }
                        }
                     } else {
                        class322.method6388(var0, var5, var6, var7, var8, var9, var10, var11, var12);
                     }

                     var0.field1553 = false;
                  }
               } else {
                  var3 = true;
               }

               if (var3) {
                  return var2.field1497;
               } else if (var4) {
                  return var1 != (float)var2.field1502 && var2.field1501 != null ? var2.field1501.field1497 : var2.field1497;
               } else {
                  return var0.field1547 ? class28.method425(var0, var1) : class102.method2625(var0, var1);
               }
            }
         }
      } else {
         return 0.0F;
      }
   }
}
