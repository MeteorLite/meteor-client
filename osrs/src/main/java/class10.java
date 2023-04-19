import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class10 {
   @ObfuscatedName("af")
   final HttpsURLConnection field35;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lpc;"
   )
   final class394 field32;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Laa;"
   )
   final class9 field38;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lqq;"
   )
   class436 field37;
   @ObfuscatedName("au")
   boolean field36;
   @ObfuscatedName("ab")
   boolean field34;
   @ObfuscatedName("aq")
   int field33;

   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URL;Laa;Lpc;Z)V"
   )
   public class10(URL var1, class9 var2, class394 var3, boolean var4) throws IOException {
      this.field36 = false;
      this.field34 = false;
      this.field33 = 300000;
      if (!var2.method33()) {
         throw new UnsupportedEncodingException("Unsupported request method used " + var2.method30());
      } else {
         this.field35 = (HttpsURLConnection)var1.openConnection();
         if (!var4) {
            HttpsURLConnection var5 = this.field35;
            if (class15.field50 == null) {
               class15.field50 = new class15();
            }

            class15 var6 = class15.field50;
            var5.setSSLSocketFactory(var6);
         }

         this.field38 = var2;
         this.field32 = var3 != null ? var3 : new class394();
      }
   }

   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URL;Laa;Z)V"
   )
   public class10(URL var1, class9 var2, boolean var3) throws IOException {
      this(var1, var2, new class394(), var3);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)Lpc;",
      garbageValue = "1901364413"
   )
   public class394 method34() {
      return this.field32;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lqq;B)V",
      garbageValue = "1"
   )
   public void method38(class436 var1) {
      if (!this.field36) {
         if (var1 == null) {
            this.field32.method2115("Content-Type");
            this.field37 = null;
         } else {
            this.field37 = var1;
            if (this.field37.vmethod2213() != null) {
               this.field32.method2109(this.field37.vmethod2213());
            } else {
               this.field32.method2110();
            }

         }
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "4"
   )
   void method36() throws ProtocolException {
      if (!this.field36) {
         this.field35.setRequestMethod(this.field38.method30());
         this.field32.method2104(this.field35);
         if (this.field38.method31() && this.field37 != null) {
            this.field35.setDoOutput(true);
            ByteArrayOutputStream var1 = new ByteArrayOutputStream();

            try {
               var1.write(this.field37.vmethod7797());
               var1.writeTo(this.field35.getOutputStream());
            } catch (IOException var11) {
               var11.printStackTrace();
            } finally {
               try {
                  var1.close();
               } catch (IOException var10) {
                  var10.printStackTrace();
               }

            }
         }

         this.field35.setConnectTimeout(this.field33);
         this.field35.setInstanceFollowRedirects(this.field34);
         this.field36 = true;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "41"
   )
   boolean method37() throws IOException {
      if (!this.field36) {
         this.method36();
      }

      this.field35.connect();
      return this.field35.getResponseCode() == -1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)Laj;",
      garbageValue = "-27"
   )
   class20 method35() {
      try {
         if (!this.field36 || this.field35.getResponseCode() == -1) {
            return new class20("No REST response has been received yet.");
         }
      } catch (IOException var10) {
         this.field35.disconnect();
         return new class20("Error decoding REST response code: " + var10.getMessage());
      }

      class20 var3;
      try {
         class20 var1 = new class20(this.field35);
         return var1;
      } catch (IOException var8) {
         var3 = new class20("Error decoding REST response: " + var8.getMessage());
      } finally {
         this.field35.disconnect();
      }

      return var3;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lie;[Lif;I)V",
      garbageValue = "1670427112"
   )
   static final void method39(Scene var0, CollisionMap[] var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      for(var2 = 0; var2 < 4; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            for(var4 = 0; var4 < 104; ++var4) {
               if ((Tiles.Tiles_renderFlags[var2][var3][var4] & 1) == 1) {
                  var5 = var2;
                  if ((Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
                     var5 = var2 - 1;
                  }

                  if (var5 >= 0) {
                     var1[var5].setBlockedByFloor(var3, var4);
                  }
               }
            }
         }
      }

      Tiles.rndHue += (int)(Math.random() * 5.0D) - 2;
      if (Tiles.rndHue < -8) {
         Tiles.rndHue = -8;
      }

      if (Tiles.rndHue > 8) {
         Tiles.rndHue = 8;
      }

      Tiles.rndLightness += (int)(Math.random() * 5.0D) - 2;
      if (Tiles.rndLightness < -16) {
         Tiles.rndLightness = -16;
      }

      if (Tiles.rndLightness > 16) {
         Tiles.rndLightness = 16;
      }

      int var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      int var18;
      for(var2 = 0; var2 < 4; ++var2) {
         byte[][] var45 = Tiles.field819[var2];
         boolean var54 = true;
         boolean var55 = true;
         boolean var6 = true;
         boolean var7 = true;
         boolean var8 = true;
         var9 = (int)Math.sqrt(5100.0D);
         var10 = var9 * 768 >> 8;

         int var19;
         int var20;
         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var13 = Tiles.Tiles_heights[var2][var12 + 1][var11] - Tiles.Tiles_heights[var2][var12 - 1][var11];
               var14 = Tiles.Tiles_heights[var2][var12][var11 + 1] - Tiles.Tiles_heights[var2][var12][var11 - 1];
               var15 = (int)Math.sqrt((double)(var14 * var14 + var13 * var13 + 65536));
               var16 = (var13 << 8) / var15;
               var17 = 65536 / var15;
               var18 = (var14 << 8) / var15;
               var19 = (var18 * -50 + var16 * -50 + var17 * -10) / var10 + 96;
               var20 = (var45[var12 - 1][var11] >> 2) + (var45[var12][var11 - 1] >> 2) + (var45[var12 + 1][var11] >> 3) + (var45[var12][var11 + 1] >> 3) + (var45[var12][var11] >> 1);
               Tiles.field821[var12][var11] = var19 - var20;
            }
         }

         for(var11 = 0; var11 < 104; ++var11) {
            FileSystem.Tiles_hue[var11] = 0;
            Tiles.Tiles_saturation[var11] = 0;
            class283.Tiles_lightness[var11] = 0;
            UserComparator4.Tiles_hueMultiplier[var11] = 0;
            class31.field92[var11] = 0;
         }

         for(var11 = -5; var11 < 109; ++var11) {
            for(var12 = 0; var12 < 104; ++var12) {
               var13 = var11 + 5;
               if (var13 >= 0 && var13 < 104) {
                  var14 = (int)DynamicObject.method466(15);
                  var15 = class186.Tiles_underlays[var2][var13][var12] & var14;
                  if (var15 > 0) {
                     var17 = var15 - 1;
                     FloorUnderlayDefinition var46 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var17);
                     FloorUnderlayDefinition var47;
                     if (var46 != null) {
                        var47 = var46;
                     } else {
                        byte[] var48 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var17);
                        var46 = new FloorUnderlayDefinition();
                        if (var48 != null) {
                           var46.decode(new Buffer(var48), var17);
                        }

                        var46.postDecode();
                        FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var46, (long)var17);
                        var47 = var46;
                     }

                     FileSystem.Tiles_hue[var12] += var47.hue;
                     Tiles.Tiles_saturation[var12] += var47.saturation;
                     class283.Tiles_lightness[var12] += var47.lightness;
                     UserComparator4.Tiles_hueMultiplier[var12] += var47.hueMultiplier;
                     ++class31.field92[var12];
                  }
               }

               var14 = var11 - 5;
               if (var14 >= 0 && var14 < 104) {
                  var15 = (int)DynamicObject.method466(15);
                  var16 = class186.Tiles_underlays[var2][var14][var12] & var15;
                  if (var16 > 0) {
                     var18 = var16 - 1;
                     FloorUnderlayDefinition var62 = (FloorUnderlayDefinition)FloorUnderlayDefinition.FloorUnderlayDefinition_cached.get((long)var18);
                     FloorUnderlayDefinition var49;
                     if (var62 != null) {
                        var49 = var62;
                     } else {
                        byte[] var50 = FloorUnderlayDefinition.FloorUnderlayDefinition_archive.takeFile(1, var18);
                        var62 = new FloorUnderlayDefinition();
                        if (var50 != null) {
                           var62.decode(new Buffer(var50), var18);
                        }

                        var62.postDecode();
                        FloorUnderlayDefinition.FloorUnderlayDefinition_cached.put(var62, (long)var18);
                        var49 = var62;
                     }

                     FileSystem.Tiles_hue[var12] -= var49.hue;
                     Tiles.Tiles_saturation[var12] -= var49.saturation;
                     class283.Tiles_lightness[var12] -= var49.lightness;
                     UserComparator4.Tiles_hueMultiplier[var12] -= var49.hueMultiplier;
                     --class31.field92[var12];
                  }
               }
            }

            if (var11 >= 1 && var11 < 103) {
               var12 = 0;
               var13 = 0;
               var14 = 0;
               var15 = 0;
               var16 = 0;

               for(var17 = -5; var17 < 109; ++var17) {
                  var18 = var17 + 5;
                  if (var18 >= 0 && var18 < 104) {
                     var12 += FileSystem.Tiles_hue[var18];
                     var13 += Tiles.Tiles_saturation[var18];
                     var14 += class283.Tiles_lightness[var18];
                     var15 += UserComparator4.Tiles_hueMultiplier[var18];
                     var16 += class31.field92[var18];
                  }

                  var19 = var17 - 5;
                  if (var19 >= 0 && var19 < 104) {
                     var12 -= FileSystem.Tiles_hue[var19];
                     var13 -= Tiles.Tiles_saturation[var19];
                     var14 -= class283.Tiles_lightness[var19];
                     var15 -= UserComparator4.Tiles_hueMultiplier[var19];
                     var16 -= class31.field92[var19];
                  }

                  if (var17 >= 1 && var17 < 103 && (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var11][var17] & 2) != 0 || (Tiles.Tiles_renderFlags[var2][var11][var17] & 16) == 0)) {
                     if (var2 < Tiles.Tiles_minPlane) {
                        Tiles.Tiles_minPlane = var2;
                     }

                     var20 = (int)DynamicObject.method466(15);
                     int var21 = class186.Tiles_underlays[var2][var11][var17] & var20;
                     int var22 = Tiles.Tiles_overlays[var2][var11][var17] & var20;
                     if (var21 > 0 || var22 > 0) {
                        int var23 = Tiles.Tiles_heights[var2][var11][var17];
                        int var24 = Tiles.Tiles_heights[var2][var11 + 1][var17];
                        int var25 = Tiles.Tiles_heights[var2][var11 + 1][var17 + 1];
                        int var26 = Tiles.Tiles_heights[var2][var11][var17 + 1];
                        int var27 = Tiles.field821[var11][var17];
                        int var28 = Tiles.field821[var11 + 1][var17];
                        int var29 = Tiles.field821[var11 + 1][var17 + 1];
                        int var30 = Tiles.field821[var11][var17 + 1];
                        int var31 = -1;
                        int var32 = -1;
                        int var33;
                        int var34;
                        int var35;
                        if (var21 > 0) {
                           var33 = var12 * 256 / var15;
                           var34 = var13 / var16;
                           var35 = var14 / var16;
                           var31 = GameBuild.method1847(var33, var34, var35);
                           var33 = var33 + Tiles.rndHue & 255;
                           var35 += Tiles.rndLightness;
                           if (var35 < 0) {
                              var35 = 0;
                           } else if (var35 > 255) {
                              var35 = 255;
                           }

                           var32 = GameBuild.method1847(var33, var34, var35);
                        }

                        FloorOverlayDefinition var36;
                        if (var2 > 0) {
                           boolean var60 = true;
                           if (var21 == 0 && Tiles.Tiles_shapes[var2][var11][var17] != 0) {
                              var60 = false;
                           }

                           if (var22 > 0) {
                              var35 = var22 - 1;
                              var36 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var35);
                              FloorOverlayDefinition var51;
                              if (var36 != null) {
                                 var51 = var36;
                              } else {
                                 byte[] var37 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var35);
                                 var36 = new FloorOverlayDefinition();
                                 if (var37 != null) {
                                    var36.decode(new Buffer(var37), var35);
                                 }

                                 var36.postDecode();
                                 FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var36, (long)var35);
                                 var51 = var36;
                              }

                              if (!var51.hideUnderlay) {
                                 var60 = false;
                              }
                           }

                           if (var60 && var23 == var24 && var23 == var25 && var26 == var23) {
                              class161.field1407[var2][var11][var17] |= 2340;
                           }
                        }

                        var33 = 0;
                        if (var32 != -1) {
                           var33 = Rasterizer3D.Rasterizer3D_colorPalette[method41(var32, 96)];
                        }

                        if (var22 == 0) {
                           var0.addTile(var2, var11, var17, 0, 0, -1, var23, var24, var25, var26, method41(var31, var27), method41(var31, var28), method41(var31, var29), method41(var31, var30), 0, 0, 0, 0, var33, 0);
                        } else {
                           var34 = Tiles.Tiles_shapes[var2][var11][var17] + 1;
                           byte var61 = Tiles.field824[var2][var11][var17];
                           int var52 = var22 - 1;
                           FloorOverlayDefinition var38 = (FloorOverlayDefinition)FloorOverlayDefinition.FloorOverlayDefinition_cached.get((long)var52);
                           if (var38 != null) {
                              var36 = var38;
                           } else {
                              byte[] var39 = FloorOverlayDefinition.FloorOverlayDefinition_archive.takeFile(4, var52);
                              var38 = new FloorOverlayDefinition();
                              if (var39 != null) {
                                 var38.decode(new Buffer(var39), var52);
                              }

                              var38.postDecode();
                              FloorOverlayDefinition.FloorOverlayDefinition_cached.put(var38, (long)var52);
                              var36 = var38;
                           }

                           int var53 = var36.texture;
                           int var40;
                           int var41;
                           int var42;
                           int var43;
                           if (var53 >= 0) {
                              var41 = Rasterizer3D.clips.Rasterizer3D_textureLoader.getAverageTextureRGB(var53);
                              var40 = -1;
                           } else if (var36.primaryRgb == 16711935) {
                              var40 = -2;
                              var53 = -1;
                              var41 = -2;
                           } else {
                              var40 = GameBuild.method1847(var36.hue, var36.saturation, var36.lightness);
                              var42 = var36.hue + Tiles.rndHue & 255;
                              var43 = var36.lightness + Tiles.rndLightness;
                              if (var43 < 0) {
                                 var43 = 0;
                              } else if (var43 > 255) {
                                 var43 = 255;
                              }

                              var41 = GameBuild.method1847(var42, var36.saturation, var43);
                           }

                           var42 = 0;
                           if (var41 != -2) {
                              var42 = Rasterizer3D.Rasterizer3D_colorPalette[class478.method2437(var41, 96)];
                           }

                           if (var36.secondaryRgb != -1) {
                              var43 = var36.secondaryHue + Tiles.rndHue & 255;
                              int var44 = var36.secondaryLightness + Tiles.rndLightness;
                              if (var44 < 0) {
                                 var44 = 0;
                              } else if (var44 > 255) {
                                 var44 = 255;
                              }

                              var41 = GameBuild.method1847(var43, var36.secondarySaturation, var44);
                              var42 = Rasterizer3D.Rasterizer3D_colorPalette[class478.method2437(var41, 96)];
                           }

                           var0.addTile(var2, var11, var17, var34, var61, var53, var23, var24, var25, var26, method41(var31, var27), method41(var31, var28), method41(var31, var29), method41(var31, var30), class478.method2437(var40, var27), class478.method2437(var40, var28), class478.method2437(var40, var29), class478.method2437(var40, var30), var33, var42);
                        }
                     }
                  }
               }
            }
         }

         for(var11 = 1; var11 < 103; ++var11) {
            for(var12 = 1; var12 < 103; ++var12) {
               var0.setTileMinPlane(var2, var12, var11, PcmPlayer.method240(var2, var12, var11));
            }
         }

         class186.Tiles_underlays[var2] = null;
         Tiles.Tiles_overlays[var2] = null;
         Tiles.Tiles_shapes[var2] = null;
         Tiles.field824[var2] = null;
         Tiles.field819[var2] = null;
      }

      var0.method1274(-50, -10, -50);

      for(var2 = 0; var2 < 104; ++var2) {
         for(var3 = 0; var3 < 104; ++var3) {
            if ((Tiles.Tiles_renderFlags[1][var2][var3] & 2) == 2) {
               var0.setLinkBelow(var2, var3);
            }
         }
      }

      var2 = 1;
      var3 = 2;
      var4 = 4;

      for(var5 = 0; var5 < 4; ++var5) {
         if (var5 > 0) {
            var2 <<= 3;
            var3 <<= 3;
            var4 <<= 3;
         }

         for(int var56 = 0; var56 <= var5; ++var56) {
            for(int var57 = 0; var57 <= 104; ++var57) {
               for(int var58 = 0; var58 <= 104; ++var58) {
                  short var59;
                  if ((class161.field1407[var56][var58][var57] & var2) != 0) {
                     var9 = var57;
                     var10 = var57;
                     var11 = var56;

                     for(var12 = var56; var9 > 0 && (class161.field1407[var56][var58][var9 - 1] & var2) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class161.field1407[var56][var58][var10 + 1] & var2) != 0) {
                        ++var10;
                     }

                     label373:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if ((class161.field1407[var11 - 1][var58][var13] & var2) == 0) {
                              break label373;
                           }
                        }

                        --var11;
                     }

                     label362:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if ((class161.field1407[var12 + 1][var58][var13] & var2) == 0) {
                              break label362;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if (var13 >= 8) {
                        var59 = 240;
                        var15 = Tiles.Tiles_heights[var12][var58][var9] - var59;
                        var16 = Tiles.Tiles_heights[var11][var58][var9];
                        Scene.Scene_addOccluder(var5, 1, var58 * 128, var58 * 128, var9 * 128, var10 * 128 + 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class161.field1407[var17][var58][var18] &= ~var2;
                           }
                        }
                     }
                  }

                  if ((class161.field1407[var56][var58][var57] & var3) != 0) {
                     var9 = var58;
                     var10 = var58;
                     var11 = var56;

                     for(var12 = var56; var9 > 0 && (class161.field1407[var56][var9 - 1][var57] & var3) != 0; --var9) {
                        ;
                     }

                     while(var10 < 104 && (class161.field1407[var56][var10 + 1][var57] & var3) != 0) {
                        ++var10;
                     }

                     label426:
                     while(var11 > 0) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if ((class161.field1407[var11 - 1][var13][var57] & var3) == 0) {
                              break label426;
                           }
                        }

                        --var11;
                     }

                     label415:
                     while(var12 < var5) {
                        for(var13 = var9; var13 <= var10; ++var13) {
                           if ((class161.field1407[var12 + 1][var13][var57] & var3) == 0) {
                              break label415;
                           }
                        }

                        ++var12;
                     }

                     var13 = (var12 + 1 - var11) * (var10 - var9 + 1);
                     if (var13 >= 8) {
                        var59 = 240;
                        var15 = Tiles.Tiles_heights[var12][var9][var57] - var59;
                        var16 = Tiles.Tiles_heights[var11][var9][var57];
                        Scene.Scene_addOccluder(var5, 2, var9 * 128, var10 * 128 + 128, var57 * 128, var57 * 128, var15, var16);

                        for(var17 = var11; var17 <= var12; ++var17) {
                           for(var18 = var9; var18 <= var10; ++var18) {
                              class161.field1407[var17][var18][var57] &= ~var3;
                           }
                        }
                     }
                  }

                  if ((class161.field1407[var56][var58][var57] & var4) != 0) {
                     var9 = var58;
                     var10 = var58;
                     var11 = var57;

                     for(var12 = var57; var11 > 0 && (class161.field1407[var56][var58][var11 - 1] & var4) != 0; --var11) {
                        ;
                     }

                     while(var12 < 104 && (class161.field1407[var56][var58][var12 + 1] & var4) != 0) {
                        ++var12;
                     }

                     label479:
                     while(var9 > 0) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if ((class161.field1407[var56][var9 - 1][var13] & var4) == 0) {
                              break label479;
                           }
                        }

                        --var9;
                     }

                     label468:
                     while(var10 < 104) {
                        for(var13 = var11; var13 <= var12; ++var13) {
                           if ((class161.field1407[var56][var10 + 1][var13] & var4) == 0) {
                              break label468;
                           }
                        }

                        ++var10;
                     }

                     if ((var12 - var11 + 1) * (var10 - var9 + 1) >= 4) {
                        var13 = Tiles.Tiles_heights[var56][var9][var11];
                        Scene.Scene_addOccluder(var5, 4, var9 * 128, var10 * 128 + 128, var11 * 128, var12 * 128 + 128, var13, var13);

                        for(var14 = var9; var14 <= var10; ++var14) {
                           for(var15 = var11; var15 <= var12; ++var15) {
                              class161.field1407[var56][var14][var15] &= ~var4;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-42895178"
   )
   static final int method41(int var0, int var1) {
      if (var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if (var1 < 2) {
            var1 = 2;
         } else if (var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("od")
   @ObfuscatedSignature(
      descriptor = "(II)Lsk;",
      garbageValue = "1355800159"
   )
   static class482 method40(int var0) {
      class482 var1 = (class482)Client.Widget_cachedFonts.get((long)var0);
      if (var1 == null) {
         var1 = new class482(PcmPlayer.field211, var0);
      }

      return var1;
   }
}
