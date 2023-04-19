import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import org.bouncycastle.crypto.tls.Certificate;
import org.bouncycastle.crypto.tls.CertificateRequest;
import org.bouncycastle.crypto.tls.TlsAuthentication;
import org.bouncycastle.crypto.tls.TlsCredentials;

@ObfuscatedName("ao")
class class11 implements TlsAuthentication {
    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "Lez;"
    )
    static UrlRequest World_request;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lai;"
   )
   @ObfuscatedName("this$2")
   final class13 this$2;

   @ObfuscatedSignature(
      descriptor = "(Lai;)V"
   )
   class11(class13 var1) {
      this.this$2 = var1;
   }

    @ObfuscatedName("notifyServerCertificate")
    public void notifyServerCertificate(Certificate var1) throws IOException {
      try {
         CertificateFactory var2 = CertificateFactory.getInstance("X.509");
         LinkedList var3 = new LinkedList();
         org.bouncycastle.asn1.x509.Certificate[] var4 = var1.getCertificateList();

         for(int var5 = 0; var5 < var4.length; ++var5) {
            org.bouncycastle.asn1.x509.Certificate var6 = var4[var5];
            var3.add(var2.generateCertificate(new ByteArrayInputStream(var6.getEncoded())));
         }

         this.this$2.this$1.field40 = (java.security.cert.Certificate[])((java.security.cert.Certificate[])var3.toArray(new java.security.cert.Certificate[0]));
      } catch (CertificateException var7) {
         throw new IOException(var7);
      }
   }

    @ObfuscatedName("getClientCredentials")
    public TlsCredentials getClientCredentials(CertificateRequest var1) throws IOException {
      return null;
   }

    @ObfuscatedName("lh")
    @ObfuscatedSignature(
            descriptor = "([Lmq;IIIIIIIII)V",
            garbageValue = "-465475629"
    )
    static final void drawInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
      class18.method68();

      for(int var9 = 0; var9 < var0.length; ++var9) {
         Widget var10 = var0[var9];
         if (var10 != null && (var10.parentId == var1 || var1 == -1412584499 && var10 == Client.clickedWidget)) {
            int var11;
            if (var8 == -1) {
               Client.rootWidgetXs[Client.rootWidgetCount] = var10.x + var6;
               Client.rootWidgetYs[Client.rootWidgetCount] = var7 + var10.y;
               Client.rootWidgetWidths[Client.rootWidgetCount] = var10.width;
               Client.rootWidgetHeights[Client.rootWidgetCount] = var10.height;
               var11 = ++Client.rootWidgetCount - 1;
            } else {
               var11 = var8;
            }

            var10.rootIndex = var11;
            var10.cycle = Client.cycle;
            if (!var10.isIf3 || !class393.isComponentHidden(var10)) {
               if (var10.contentType > 0) {
                  MouseHandler.method193(var10);
               }

               int var12 = var10.x + var6;
               int var13 = var7 + var10.y;
               int var14 = var10.transparencyTop;
               int var15;
               int var16;
               if (var10 == Client.clickedWidget) {
                  if (var1 != -1412584499 && !var10.isScrollBar) {
                     WorldMapSection2.field2292 = var0;
                     class230.field2130 = var6;
                     class101.field1082 = var7;
                     continue;
                  }

                  if (Client.isDraggingWidget && Client.field540) {
                     var15 = MouseHandler.MouseHandler_x;
                     var16 = MouseHandler.MouseHandler_y;
                     var15 -= Client.widgetClickX;
                     var16 -= Client.widgetClickY;
                     if (var15 < Client.field495) {
                        var15 = Client.field495;
                     }

                     if (var15 + var10.width > Client.field495 + Client.clickedWidgetParent.width) {
                        var15 = Client.field495 + Client.clickedWidgetParent.width - var10.width;
                     }

                     if (var16 < Client.field542) {
                        var16 = Client.field542;
                     }

                     if (var16 + var10.height > Client.field542 + Client.clickedWidgetParent.height) {
                        var16 = Client.field542 + Client.clickedWidgetParent.height - var10.height;
                     }

                     var12 = var15;
                     var13 = var16;
                  }

                  if (!var10.isScrollBar) {
                     var14 = 128;
                  }
               }

               int var17;
               int var18;
               int var19;
               int var20;
               int var21;
               int var22;
               if (var10.type == 9) {
                  var19 = var12;
                  var20 = var13;
                  var21 = var12 + var10.width;
                  var22 = var13 + var10.height;
                  if (var21 < var12) {
                     var19 = var21;
                     var21 = var12;
                  }

                  if (var22 < var13) {
                     var20 = var22;
                     var22 = var13;
                  }

                  ++var21;
                  ++var22;
                  var15 = var19 > var2 ? var19 : var2;
                  var16 = var20 > var3 ? var20 : var3;
                  var17 = var21 < var4 ? var21 : var4;
                  var18 = var22 < var5 ? var22 : var5;
               } else {
                  var19 = var12 + var10.width;
                  var20 = var13 + var10.height;
                  var15 = var12 > var2 ? var12 : var2;
                  var16 = var13 > var3 ? var13 : var3;
                  var17 = var19 < var4 ? var19 : var4;
                  var18 = var20 < var5 ? var20 : var5;
               }

               if (!var10.isIf3 || var15 < var17 && var16 < var18) {
                  if (var10.contentType != 0) {
                     if (var10.contentType == 1336) {
                        if (class20.clientPreferences.method562()) {
                           var13 += 15;
                           WallDecoration.fontPlain12.drawRightAligned("Fps:" + GameEngine.fps, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var41 = Runtime.getRuntime();
                           var20 = (int)((var41.totalMemory() - var41.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if (var20 > 327680 && !Client.isLowDetail) {
                              var21 = 16711680;
                           }

                           WallDecoration.fontPlain12.drawRightAligned("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if (var10.contentType == 1337) {
                        Client.viewportX = var12;
                        Client.viewportY = var13;
                        class18.drawEntities(var12, var13, var10.width, var10.height);
                        Client.field573[var10.rootIndex] = true;
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1338) {
                        class155.drawMinimap(var10, var12, var13, var11);
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1339) {
                        DynamicObject.drawCompass(var10, var12, var13, var11);
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1400) {
                        class126.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
                     }

                     if (var10.contentType == 1401) {
                        class126.worldMap.drawOverview(var12, var13, var10.width, var10.height);
                     }

                     if (var10.contentType == 1402) {
                        class121.field1184.draw(var12, Client.cycle);
                     }
                  }

                  if (var10.type == 0) {
                     if (!var10.isIf3 && class393.isComponentHidden(var10) && var10 != MidiPcmStream.mousedOverWidgetIf1) {
                        continue;
                     }

                     if (!var10.isIf3) {
                        if (var10.scrollY > var10.scrollHeight - var10.height) {
                           var10.scrollY = var10.scrollHeight - var10.height;
                        }

                        if (var10.scrollY < 0) {
                           var10.scrollY = 0;
                        }
                     }

                     drawInterface(var0, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     if (var10.children != null) {
                        drawInterface(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     InterfaceParent var28 = (InterfaceParent)Client.interfaceParents.get((long)var10.id);
                     if (var28 != null) {
                        class13.drawWidgets(var28.group, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                     class18.method68();
                  } else if (var10.type == 11) {
                     if (class393.isComponentHidden(var10) && var10 != MidiPcmStream.mousedOverWidgetIf1) {
                        continue;
                     }

                     if (var10.children != null) {
                        drawInterface(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                     class18.method68();
                  }

                  if (Client.isResizable || Client.field519[var11] || Client.gameDrawingMode > 1) {
                     if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
                        class103.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if (var10.type != 1) {
                        if (var10.type == 3) {
                           if (class452.runCs1(var10)) {
                              var19 = var10.color2;
                              if (var10 == MidiPcmStream.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
                                 var19 = var10.mouseOverColor2;
                              }
                           } else {
                              var19 = var10.color;
                              if (var10 == MidiPcmStream.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
                                 var19 = var10.mouseOverColor;
                              }
                           }

                           if (var10.fill) {
                              switch(var10.fillMode.field4118) {
                              case 1:
                                 Rasterizer2D.Rasterizer2D_fillRectangleGradient(var12, var13, var10.width, var10.height, var10.color, var10.color2);
                                 break;
                              case 2:
                                 Rasterizer2D.Rasterizer2D_fillRectangleGradientAlpha(var12, var13, var10.width, var10.height, var10.color, var10.color2, 255 - (var10.transparencyTop & 255), 255 - (var10.transparencyBot & 255));
                                 break;
                              default:
                                 if (var14 == 0) {
                                    Rasterizer2D.Rasterizer2D_fillRectangle(var12, var13, var10.width, var10.height, var19);
                                 } else {
                                    Rasterizer2D.Rasterizer2D_fillRectangleAlpha(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                                 }
                              }
                           } else if (var14 == 0) {
                              Rasterizer2D.Rasterizer2D_drawRectangle(var12, var13, var10.width, var10.height, var19);
                           } else {
                              Rasterizer2D.Rasterizer2D_drawRectangleAlpha(var12, var13, var10.width, var10.height, var19, 256 - (var14 & 255));
                           }
                        } else if (var10.type == 4) {
                           Font var40 = var10.getFont();
                           if (var40 == null) {
                              if (Widget.field2877) {
                                 class144.invalidateWidget(var10);
                              }
                           } else {
                              String var42 = var10.text;
                              if (class452.runCs1(var10)) {
                                 var20 = var10.color2;
                                 if (var10 == MidiPcmStream.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
                                    var20 = var10.mouseOverColor2;
                                 }

                                 if (var10.text2.length() > 0) {
                                    var42 = var10.text2;
                                 }
                              } else {
                                 var20 = var10.color;
                                 if (var10 == MidiPcmStream.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
                                    var20 = var10.mouseOverColor;
                                 }
                              }

                              if (var10.isIf3 && var10.itemId != -1) {
                                 ItemComposition var43 = HealthBarUpdate.ItemDefinition_get(var10.itemId);
                                 var42 = var43.name;
                                 if (var42 == null) {
                                    var42 = "null";
                                 }

                                 if ((var43.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                    var42 = class383.colorStartTag(16748608) + var42 + "</col>" + " " + 'x' + ArchiveDiskAction.formatItemStacks(var10.itemQuantity);
                                 }
                              }

                              if (var10 == Client.meslayerContinueWidget) {
                                 var42 = "Please wait...";
                                 var20 = var10.color;
                              }

                              if (!var10.isIf3) {
                                 var42 = class121.method720(var42, var10);
                              }

                              var40.method2055(var42, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, Decimator.method332(var10.transparencyTop), var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
                           }
                        } else {
                           int var23;
                           int var24;
                           int var25;
                           if (var10.type == 5) {
                              SpritePixels var38;
                              if (!var10.isIf3) {
                                 var38 = var10.getSprite(class452.runCs1(var10), class14.urlRequester);
                                 if (var38 != null) {
                                    var38.drawTransBgAt(var12, var13);
                                 } else if (Widget.field2877) {
                                    class144.invalidateWidget(var10);
                                 }
                              } else {
                                 if (var10.itemId != -1) {
                                    var38 = class252.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
                                 } else {
                                    var38 = var10.getSprite(false, class14.urlRequester);
                                 }

                                 if (var38 == null) {
                                    if (Widget.field2877) {
                                       class144.invalidateWidget(var10);
                                    }
                                 } else {
                                    var20 = var38.width;
                                    var21 = var38.height;
                                    if (!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if (var10.spriteAngle != 0) {
                                          var38.method2632(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
                                       } else if (var14 != 0) {
                                          var38.drawTransScaledAt(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if (var20 == var10.width && var21 == var10.height) {
                                          var38.drawTransBgAt(var12, var13);
                                       } else {
                                          var38.drawScaledAt(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.Rasterizer2D_expandClip(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if (var10.spriteAngle != 0) {
                                                var38.method2632(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var25 * var21, var10.spriteAngle, 4096);
                                             } else if (var14 != 0) {
                                                var38.drawTransAt(var12 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var38.drawTransBgAt(var12 + var24 * var20, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              int var34;
                              if (var10.type == 6) {
                                 boolean var36 = class452.runCs1(var10);
                                 if (var36) {
                                    var20 = var10.sequenceId2;
                                 } else {
                                    var20 = var10.sequenceId;
                                 }

                                 Model var39 = null;
                                 var22 = 0;
                                 if (var10.itemId != -1) {
                                    ItemComposition var44 = HealthBarUpdate.ItemDefinition_get(var10.itemId);
                                    if (var44 != null) {
                                       var44 = var44.getCountObj(var10.itemQuantity);
                                       var39 = var44.getModel(1);
                                       if (var39 != null) {
                                          var39.calculateBoundsCylinder();
                                          var22 = var39.height / 2;
                                       } else {
                                          class144.invalidateWidget(var10);
                                       }
                                    }
                                 } else if (var10.modelType == 5) {
                                    if (var10.modelId == 0) {
                                       var39 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
                                    } else {
                                       var39 = MusicPatchNode.localPlayer.getModel();
                                    }
                                 } else if (var10.modelType == 7) {
                                    var39 = var10.field2894.getModel((SequenceDefinition)null, -1, ItemContainer.SequenceDefinition_get(MusicPatchNode.localPlayer.idleSequence), MusicPatchNode.localPlayer.movementFrame);
                                 } else {
                                    NPCComposition var45 = null;
                                    NewShit var32 = null;
                                    if (var10.modelType == 6) {
                                       var25 = var10.modelId;
                                       if (var25 >= 0 && var25 < Client.npcs.length) {
                                          NPC var26 = Client.npcs[var25];
                                          if (var26 != null) {
                                             var45 = var26.definition;
                                             var32 = var26.method599();
                                          }
                                       }
                                    }

                                    SequenceDefinition var33 = null;
                                    var34 = -1;
                                    if (var20 != -1) {
                                       var33 = ItemContainer.SequenceDefinition_get(var20);
                                       var34 = var10.modelFrame;
                                    }

                                    var39 = var10.getModel(var33, var34, var36, MusicPatchNode.localPlayer.appearance, var45, var32);
                                    if (var39 == null && Widget.field2877) {
                                       class144.invalidateWidget(var10);
                                    }
                                 }

                                 WorldMapArea.method1433(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
                                 var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
                                 if (var39 != null) {
                                    if (!var10.isIf3) {
                                       var39.method1343(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
                                    } else {
                                       var39.calculateBoundsCylinder();
                                       if (var10.modelOrthog) {
                                          var39.method1327(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
                                       } else {
                                          var39.method1343(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var23 + var22 + var10.modelOffsetY, var24 + var10.modelOffsetY);
                                       }
                                    }
                                 }

                                 Tiles.method474();
                              } else {
                                 Font var29;
                                 if (var10.type == 8 && var10 == class130.field1274 && Client.field515 == Client.field514) {
                                    var19 = 0;
                                    var20 = 0;
                                    var29 = WallDecoration.fontPlain12;
                                    String var30 = var10.text;

                                    String var31;
                                    for(var30 = class121.method720(var30, var10); var30.length() > 0; var20 = var20 + var29.ascent + 1) {
                                       var24 = var30.indexOf("<br>");
                                       if (var24 != -1) {
                                          var31 = var30.substring(0, var24);
                                          var30 = var30.substring(var24 + 4);
                                       } else {
                                          var31 = var30;
                                          var30 = "";
                                       }

                                       var25 = var29.stringWidth(var31);
                                       if (var25 > var19) {
                                          var19 = var25;
                                       }
                                    }

                                    var19 += 6;
                                    var20 += 7;
                                    var24 = var12 + var10.width - 5 - var19;
                                    var25 = var13 + var10.height + 5;
                                    if (var24 < var12 + 5) {
                                       var24 = var12 + 5;
                                    }

                                    if (var19 + var24 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if (var25 + var20 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.Rasterizer2D_drawRectangle(var24, var25, var19, var20, 0);
                                    var30 = var10.text;
                                    var34 = var25 + var29.ascent + 2;

                                    for(var30 = class121.method720(var30, var10); var30.length() > 0; var34 = var34 + var29.ascent + 1) {
                                       int var27 = var30.indexOf("<br>");
                                       if (var27 != -1) {
                                          var31 = var30.substring(0, var27);
                                          var30 = var30.substring(var27 + 4);
                                       } else {
                                          var31 = var30;
                                          var30 = "";
                                       }

                                       var29.draw(var31, var24 + 3, var34, 0, -1);
                                    }
                                 }

                                 if (var10.type == 9) {
                                    if (var10.field2913) {
                                       var19 = var12;
                                       var20 = var13 + var10.height;
                                       var21 = var12 + var10.width;
                                       var22 = var13;
                                    } else {
                                       var19 = var12;
                                       var20 = var13;
                                       var21 = var12 + var10.width;
                                       var22 = var13 + var10.height;
                                    }

                                    if (var10.lineWid == 1) {
                                       Rasterizer2D.Rasterizer2D_drawLine(var19, var20, var21, var22, var10.color);
                                    } else {
                                       class36.method196(var19, var20, var21, var22, var10.color, var10.lineWid);
                                    }
                                 } else if (var10.type == 12) {
                                    class314 var37 = var10.method1815();
                                    class309 var35 = var10.method1817();
                                    if (var37 != null && var35 != null && var37.method1748()) {
                                       var29 = var10.getFont();
                                       if (var29 != null) {
                                          Client.field565.method2637(var12, var13, var10.width, var10.height, var37.method1769(), var37.method1781(), var37.method1746(), var37.method1747(), var37.method1745());
                                          var22 = var10.textShadowed ? var10.spriteShadow * -140657215 * -353676735 : -1;
                                          if (!var37.method1743() && var37.method1740().method2004()) {
                                             Client.field565.method2639(var35.field2817, var22, var35.field2818, var35.field2816);
                                             Client.field565.method2638(var37.method1741(), var29);
                                          } else {
                                             Client.field565.method2639(var10.color, var22, var35.field2818, var35.field2816);
                                             Client.field565.method2638(var37.method1740(), var29);
                                          }

                                          Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
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
      }

   }
}
