import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
public class class27 {
   @ObfuscatedName("fm")
   @ObfuscatedSignature(
           descriptor = "Llm;"
   )
   static Archive archive20;
   @ObfuscatedName("pw")
   static int widgetDragDuration;
   @ObfuscatedName("i")
   int[] field96 = new int[112];
   @ObfuscatedName("n")
   int[] field95 = new int[192];

   public class27() {
      Arrays.fill(this.field96, 3);
      Arrays.fill(this.field95, 3);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1922919708"
   )
   public void method97(int var1, int var2) {
      if (this.method102(var1) && this.method103(var2)) {
         this.field96[var1] = var2;
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(CII)V",
      garbageValue = "2116821772"
   )
   public void method106(char var1, int var2) {
      if (this.method107(var1) && this.method103(var2)) {
         this.field95[var1] = var2;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "969220450"
   )
   public int method98(int var1) {
      return this.method102(var1) ? this.field96[var1] : 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(CI)I",
      garbageValue = "2077314756"
   )
   public int method99(char var1) {
      return this.method107(var1) ? this.field95[var1] : 0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "100"
   )
   public boolean method105(int var1) {
      return this.method102(var1) && (this.field96[var1] == 1 || this.field96[var1] == 3);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(CS)Z",
      garbageValue = "-12278"
   )
   public boolean method100(char var1) {
      return this.method107(var1) && (this.field95[var1] == 1 || this.field95[var1] == 3);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1145062404"
   )
   public boolean method104(int var1) {
      return this.method102(var1) && (this.field96[var1] == 2 || this.field96[var1] == 3);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(CB)Z",
      garbageValue = "25"
   )
   public boolean method101(char var1) {
      return this.method107(var1) && (this.field95[var1] == 2 || this.field95[var1] == 3);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1719071766"
   )
   boolean method102(int var1) {
      if (var1 >= 0 && var1 < 112) {
         return true;
      } else {
         System.out.println("Invalid keycode: " + var1);
         return false;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(CB)Z",
      garbageValue = "2"
   )
   boolean method107(char var1) {
      if (var1 >= 0 && var1 < 192) {
         return true;
      } else {
         System.out.println("Invalid keychar: " + var1);
         return false;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1586560827"
   )
   boolean method103(int var1) {
      if (var1 >= 0 && var1 < 4) {
         return true;
      } else {
         System.out.println("Invalid mode: " + var1);
         return false;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)[Ljs;",
      garbageValue = "-94"
   )
   public static ZoneOperation[] method108() {
      return new ZoneOperation[]{ZoneOperation.field2547, ZoneOperation.field2540, ZoneOperation.field2541, ZoneOperation.field2542, ZoneOperation.field2543, ZoneOperation.field2546, ZoneOperation.field2544, ZoneOperation.field2539, ZoneOperation.field2551, ZoneOperation.field2548, ZoneOperation.field2549, ZoneOperation.field2550, ZoneOperation.field2545};
   }

   @ObfuscatedName("jc")
   @ObfuscatedSignature(
           descriptor = "([Lkz;IIIIIIIIB)V",
           garbageValue = "101"
   )
   static final void drawInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
      Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();

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
            if (!var10.isIf3 || !class160.isComponentHidden(var10)) {
               if (var10.contentType > 0) {
                  DbRowType.method2356(var10);
               }

               int var12 = var10.x + var6;
               int var13 = var7 + var10.y;
               int var14 = var10.transparencyTop;
               int var15;
               int var16;
               if (var10 == Client.clickedWidget) {
                  if (var1 != -1412584499 && !var10.isScrollBar) {
                     MouseHandler.field159 = var0;
                     class288.field2691 = var6;
                     class366.field3575 = var7;
                     continue;
                  }

                  if (Client.isDraggingWidget && Client.field560) {
                     var15 = MouseHandler.MouseHandler_x;
                     var16 = MouseHandler.MouseHandler_y;
                     var15 -= Client.widgetClickX;
                     var16 -= Client.widgetClickY;
                     if (var15 < Client.field659) {
                        var15 = Client.field659;
                     }

                     if (var15 + var10.width > Client.field659 + Client.clickedWidgetParent.width) {
                        var15 = Client.field659 + Client.clickedWidgetParent.width - var10.width;
                     }

                     if (var16 < Client.field667) {
                        var16 = Client.field667;
                     }

                     if (var16 + var10.height > Client.field667 + Client.clickedWidgetParent.height) {
                        var16 = Client.field667 + Client.clickedWidgetParent.height - var10.height;
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
               if (var10.type == 2) {
                  var15 = var2;
                  var16 = var3;
                  var17 = var4;
                  var18 = var5;
               } else if (var10.type == 9) {
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
                        if (PacketWriter.clientPreferences.method526()) {
                           var13 += 15;
                           MenuAction.fontPlain12.drawRightAligned("Fps:" + GameEngine.fps, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var45 = Runtime.getRuntime();
                           var20 = (int)((var45.totalMemory() - var45.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if (var20 > 327680 && !Client.isLowDetail) {
                              var21 = 16711680;
                           }

                           MenuAction.fontPlain12.drawRightAligned("Mem:" + var20 + "k", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if (var10.contentType == 1337) {
                        Client.viewportX = var12;
                        Client.viewportY = var13;
                        VarpDefinition.drawEntities(var12, var13, var10.width, var10.height);
                        Client.field591[var10.rootIndex] = true;
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1338) {
                        WorldMapSectionType.drawMinimap(var10, var12, var13, var11);
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1339) {
                        CollisionMap.drawCompass(var10, var12, var13, var11);
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1400) {
                        GrandExchangeOfferUnitPriceComparator.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
                     }

                     if (var10.contentType == 1401) {
                        GrandExchangeOfferUnitPriceComparator.worldMap.drawOverview(var12, var13, var10.width, var10.height);
                     }

                     if (var10.contentType == 1402) {
                        class305.field2809.draw(var12, Client.cycle);
                     }
                  }

                  if (var10.type == 0) {
                     if (!var10.isIf3 && class160.isComponentHidden(var10) && var10 != KeyHandler.mousedOverWidgetIf1) {
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

                     InterfaceParent var30 = (InterfaceParent)Client.interfaceParents.get((long)var10.id);
                     if (var30 != null) {
                        class97.drawWidgets(var30.group, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                     Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
                  } else if (var10.type == 11) {
                     if (class160.isComponentHidden(var10) && var10 != KeyHandler.mousedOverWidgetIf1) {
                        continue;
                     }

                     if (var10.children != null) {
                        drawInterface(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                     Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
                  }

                  if (Client.isResizable || Client.field428[var11] || Client.gameDrawingMode > 1) {
                     if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
                        ParamComposition.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
                     }

                     if (var10.type != 1) {
                        int var23;
                        int var24;
                        int var25;
                        int var26;
                        if (var10.type == 2) {
                           var19 = 0;

                           for(var20 = 0; var20 < var10.rawHeight; ++var20) {
                              for(var21 = 0; var21 < var10.rawWidth; ++var21) {
                                 var22 = var12 + var21 * (var10.paddingX + 32);
                                 var23 = var13 + var20 * (var10.paddingY + 32);
                                 if (var19 < 20) {
                                    var22 += var10.inventoryXOffsets[var19];
                                    var23 += var10.inventoryYOffsets[var19];
                                 }

                                 if (var10.itemIds[var19] <= 0) {
                                    if (var10.inventorySprites != null && var19 < 20) {
                                       SpritePixels var48 = var10.getInventorySprite(var19);
                                       if (var48 != null) {
                                          var48.drawTransBgAt(var22, var23);
                                       } else if (Widget.field2885) {
                                          LoginScreenAnimation.invalidateWidget(var10);
                                       }
                                    }
                                 } else {
                                    boolean var40 = false;
                                    boolean var41 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == WorldMapLabelSize.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
                                       SpritePixels var27;
                                       if (Client.isItemSelected == 1 && var19 == WorldMapIcon_0.selectedItemSlot && var10.id == WorldMapLabel.selectedItemWidget) {
                                          var27 = TextureProvider.getItemSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = TextureProvider.getItemSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if (var27 != null) {
                                          if (var10 == WorldMapLabelSize.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
                                             var24 = MouseHandler.MouseHandler_x - Client.draggedWidgetX;
                                             var25 = MouseHandler.MouseHandler_y - Client.draggedWidgetY;
                                             if (var24 < 5 && var24 > -5) {
                                                var24 = 0;
                                             }

                                             if (var25 < 5 && var25 > -5) {
                                                var25 = 0;
                                             }

                                             if (Client.itemDragDuration < 5) {
                                                var24 = 0;
                                                var25 = 0;
                                             }

                                             var27.drawTransAt(var24 + var22, var25 + var23, 128);
                                             if (var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                int var29;
                                                if (var23 + var25 < Rasterizer2D.Rasterizer2D_yClipStart && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.Rasterizer2D_yClipStart - var23 - var25) * Client.field442 / 3;
                                                   if (var29 > Client.field442 * 10) {
                                                      var29 = Client.field442 * 10;
                                                   }

                                                   if (var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.draggedWidgetY += var29;
                                                   LoginScreenAnimation.invalidateWidget(var28);
                                                }

                                                if (var23 + var25 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field442 / 3;
                                                   if (var29 > Client.field442 * 10) {
                                                      var29 = Client.field442 * 10;
                                                   }

                                                   if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.draggedWidgetY -= var29;
                                                   LoginScreenAnimation.invalidateWidget(var28);
                                                }
                                             }
                                          } else if (var10 == class378.field3629 && var19 == Client.field487) {
                                             var27.drawTransAt(var22, var23, 128);
                                          } else {
                                             var27.drawTransBgAt(var22, var23);
                                          }
                                       } else {
                                          LoginScreenAnimation.invalidateWidget(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if (var10.type == 3) {
                           if (UserComparator5.runCs1(var10)) {
                              var19 = var10.color2;
                              if (var10 == KeyHandler.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
                                 var19 = var10.mouseOverColor2;
                              }
                           } else {
                              var19 = var10.color;
                              if (var10 == KeyHandler.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
                                 var19 = var10.mouseOverColor;
                              }
                           }

                           if (var10.fill) {
                              switch(var10.fillMode.field4071) {
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
                        } else {
                           Font var42;
                           if (var10.type == 4) {
                              var42 = var10.getFont();
                              if (var42 == null) {
                                 if (Widget.field2885) {
                                    LoginScreenAnimation.invalidateWidget(var10);
                                 }
                              } else {
                                 String var50 = var10.text;
                                 if (UserComparator5.runCs1(var10)) {
                                    var20 = var10.color2;
                                    if (var10 == KeyHandler.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
                                       var20 = var10.mouseOverColor2;
                                    }

                                    if (var10.text2.length() > 0) {
                                       var50 = var10.text2;
                                    }
                                 } else {
                                    var20 = var10.color;
                                    if (var10 == KeyHandler.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
                                       var20 = var10.mouseOverColor;
                                    }
                                 }

                                 if (var10.isIf3 && var10.itemId != -1) {
                                    ItemComposition var51 = TileItem.ItemDefinition_get(var10.itemId);
                                    var50 = var51.name;
                                    if (var50 == null) {
                                       var50 = "null";
                                    }

                                    if ((var51.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var50 = class149.colorStartTag(16748608) + var50 + "</col>" + " " + 'x' + WorldMapCacheName.formatItemStacks(var10.itemQuantity);
                                    }
                                 }

                                 if (var10 == Client.meslayerContinueWidget) {
                                    var50 = "Please wait...";
                                    var20 = var10.color;
                                 }

                                 if (!var10.isIf3) {
                                    var50 = FloorDecoration.method1141(var50, var10);
                                 }

                                 var42.drawLines(var50, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
                              }
                           } else if (var10.type == 5) {
                              SpritePixels var44;
                              if (!var10.isIf3) {
                                 var44 = var10.getSprite(UserComparator5.runCs1(var10), class245.urlRequester);
                                 if (var44 != null) {
                                    var44.drawTransBgAt(var12, var13);
                                 } else if (Widget.field2885) {
                                    LoginScreenAnimation.invalidateWidget(var10);
                                 }
                              } else {
                                 if (var10.itemId != -1) {
                                    var44 = TextureProvider.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
                                 } else {
                                    var44 = var10.getSprite(false, class245.urlRequester);
                                 }

                                 if (var44 == null) {
                                    if (Widget.field2885) {
                                       LoginScreenAnimation.invalidateWidget(var10);
                                    }
                                 } else {
                                    var20 = var44.width;
                                    var21 = var44.height;
                                    if (!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if (var10.spriteAngle != 0) {
                                          var44.method2520(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
                                       } else if (var14 != 0) {
                                          var44.drawTransScaledAt(var12, var13, var10.width, var10.height, 256 - (var14 & 255));
                                       } else if (var20 == var10.width && var21 == var10.height) {
                                          var44.drawTransBgAt(var12, var13);
                                       } else {
                                          var44.drawScaledAt(var12, var13, var10.width, var10.height);
                                       }
                                    } else {
                                       Rasterizer2D.Rasterizer2D_expandClip(var12, var13, var12 + var10.width, var13 + var10.height);
                                       var22 = (var20 - 1 + var10.width) / var20;
                                       var23 = (var21 - 1 + var10.height) / var21;

                                       for(var24 = 0; var24 < var22; ++var24) {
                                          for(var25 = 0; var25 < var23; ++var25) {
                                             if (var10.spriteAngle != 0) {
                                                var44.method2520(var20 / 2 + var12 + var20 * var24, var21 / 2 + var13 + var21 * var25, var10.spriteAngle, 4096);
                                             } else if (var14 != 0) {
                                                var44.drawTransAt(var12 + var20 * var24, var13 + var25 * var21, 256 - (var14 & 255));
                                             } else {
                                                var44.drawTransBgAt(var12 + var20 * var24, var13 + var21 * var25);
                                             }
                                          }
                                       }

                                       Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                                    }
                                 }
                              }
                           } else {
                              ItemComposition var34;
                              if (var10.type == 6) {
                                 boolean var39 = UserComparator5.runCs1(var10);
                                 if (var39) {
                                    var20 = var10.sequenceId2;
                                 } else {
                                    var20 = var10.sequenceId;
                                 }

                                 Model var46 = null;
                                 var22 = 0;
                                 if (var10.itemId != -1) {
                                    var34 = TileItem.ItemDefinition_get(var10.itemId);
                                    if (var34 != null) {
                                       var34 = var34.getCountObj(var10.itemQuantity);
                                       var46 = var34.getModel(1);
                                       if (var46 != null) {
                                          var46.calculateBoundsCylinder();
                                          var22 = var46.height / 2;
                                       } else {
                                          LoginScreenAnimation.invalidateWidget(var10);
                                       }
                                    }
                                 } else if (var10.modelType == 5) {
                                    if (var10.modelId == 0) {
                                       var46 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
                                    } else {
                                       var46 = class387.localPlayer.getModel();
                                    }
                                 } else {
                                    NPCComposition var52 = null;
                                    NewShit var47 = null;
                                    if (var10.modelType == 6) {
                                       var25 = var10.modelId;
                                       if (var25 >= 0 && var25 < Client.npcs.length) {
                                          NPC var35 = Client.npcs[var25];
                                          if (var35 != null) {
                                             var52 = var35.definition;
                                             var47 = var35.method569();
                                          }
                                       }
                                    }

                                    SequenceDefinition var36 = null;
                                    var26 = -1;
                                    if (var20 != -1) {
                                       var36 = class85.SequenceDefinition_get(var20);
                                       var26 = var10.modelFrame;
                                    }

                                    var46 = var10.getModel(var36, var26, var39, class387.localPlayer.appearance, var52, var47);
                                    if (var46 == null && Widget.field2885) {
                                       LoginScreenAnimation.invalidateWidget(var10);
                                    }
                                 }

                                 Rasterizer3D.method1174(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
                                 var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
                                 if (var46 != null) {
                                    if (!var10.isIf3) {
                                       var46.method1276(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
                                    } else {
                                       var46.calculateBoundsCylinder();
                                       if (var10.modelOrthog) {
                                          var46.method1292(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
                                       } else {
                                          var46.method1276(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY);
                                       }
                                    }
                                 }

                                 Rasterizer3D.Rasterizer3D_method3();
                              } else {
                                 if (var10.type == 7) {
                                    var42 = var10.getFont();
                                    if (var42 == null) {
                                       if (Widget.field2885) {
                                          LoginScreenAnimation.invalidateWidget(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.rawHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.rawWidth; ++var22) {
                                          if (var10.itemIds[var20] > 0) {
                                             var34 = TileItem.ItemDefinition_get(var10.itemIds[var20] - 1);
                                             String var31;
                                             if (var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var31 = class149.colorStartTag(16748608) + var34.name + "</col>";
                                             } else {
                                                var31 = class149.colorStartTag(16748608) + var34.name + "</col>" + " " + 'x' + WorldMapCacheName.formatItemStacks(var10.itemQuantities[var20]);
                                             }

                                             var25 = var12 + var22 * (var10.paddingX + 115);
                                             var26 = (var10.paddingY + 12) * var21 + var13;
                                             if (var10.textXAlignment == 0) {
                                                var42.draw(var31, var25, var26, var10.color, var10.textShadowed ? 0 : -1);
                                             } else if (var10.textXAlignment == 1) {
                                                var42.drawCentered(var31, var10.width / 2 + var25, var26, var10.color, var10.textShadowed ? 0 : -1);
                                             } else {
                                                var42.drawRightAligned(var31, var25 + var10.width - 1, var26, var10.color, var10.textShadowed ? 0 : -1);
                                             }
                                          }

                                          ++var20;
                                       }
                                    }
                                 }

                                 Font var32;
                                 if (var10.type == 8 && var10 == class18.field60 && Client.field534 == Client.field533) {
                                    var19 = 0;
                                    var20 = 0;
                                    var32 = MenuAction.fontPlain12;
                                    String var33 = var10.text;

                                    String var49;
                                    for(var33 = FloorDecoration.method1141(var33, var10); var33.length() > 0; var20 = var20 + var32.ascent + 1) {
                                       var24 = var33.indexOf("<br>");
                                       if (var24 != -1) {
                                          var49 = var33.substring(0, var24);
                                          var33 = var33.substring(var24 + 4);
                                       } else {
                                          var49 = var33;
                                          var33 = "";
                                       }

                                       var25 = var32.stringWidth(var49);
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

                                    if (var24 + var19 > var4) {
                                       var24 = var4 - var19;
                                    }

                                    if (var20 + var25 > var5) {
                                       var25 = var5 - var20;
                                    }

                                    Rasterizer2D.Rasterizer2D_fillRectangle(var24, var25, var19, var20, 16777120);
                                    Rasterizer2D.Rasterizer2D_drawRectangle(var24, var25, var19, var20, 0);
                                    var33 = var10.text;
                                    var26 = var25 + var32.ascent + 2;

                                    for(var33 = FloorDecoration.method1141(var33, var10); var33.length() > 0; var26 = var26 + var32.ascent + 1) {
                                       int var37 = var33.indexOf("<br>");
                                       if (var37 != -1) {
                                          var49 = var33.substring(0, var37);
                                          var33 = var33.substring(var37 + 4);
                                       } else {
                                          var49 = var33;
                                          var33 = "";
                                       }

                                       var32.draw(var49, var24 + 3, var26, 0, -1);
                                    }
                                 }

                                 if (var10.type == 9) {
                                    if (var10.field2912) {
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
                                       class17.method63(var19, var20, var21, var22, var10.color, var10.lineWid);
                                    }
                                 } else if (var10.type == 12) {
                                    class307 var43 = var10.method1750();
                                    class302 var38 = var10.method1745();
                                    if (var43 != null && var38 != null && var43.method1683()) {
                                       var32 = var10.getFont();
                                       if (var32 != null) {
                                          Client.field583.method2537(var12, var13, var10.width, var10.height, var43.method1684(), var43.method1704(), 0, 0, var43.method1716(), var43.method1682(), var43.method1681());
                                          var22 = var10.textShadowed ? var10.spriteShadow * -151995323 * -513345907 : -1;
                                          if (!var43.method1680() && var43.method1678().method1939()) {
                                             Client.field583.method2535(var38.field2795, var22, var38.field2794, var38.field2797);
                                             Client.field583.method2536(var43.method1714(), var32);
                                          } else {
                                             Client.field583.method2535(var10.color, var22, var38.field2794, var38.field2797);
                                             Client.field583.method2536(var43.method1678(), var32);
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
