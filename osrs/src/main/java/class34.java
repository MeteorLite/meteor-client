import java.security.SecureRandom;
import java.text.DecimalFormat;

import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class34 {
   @ObfuscatedName("te")
   static int cameraMoveToY;
   @ObfuscatedName("u")
   public static int field95;
   @ObfuscatedName("ga")
   static SecureRandom secureRandom;
   @ObfuscatedName("qv")
   @ObfuscatedSignature(
      descriptor = "Lqk;"
   )
   static class451 HitSplatDefinition_cached;
   @ObfuscatedName("f")
   int field92;
   @ObfuscatedName("r")
   int field93;

   class34(int var1, int var2) {
      this.field92 = var1;
      this.field93 = var2;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lav;I)Z",
      garbageValue = "-30387471"
   )
   boolean method139(class30 var1) {
      if (var1 == null) {
         return false;
      } else {
         switch(this.field92) {
         case 1:
            return var1.vmethod3949(this.field93);
         case 2:
            return var1.vmethod3989(this.field93);
         case 3:
            return var1.vmethod3951((char)this.field93);
         case 4:
            return var1.vmethod3953(this.field93 == 1);
         default:
            return false;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(II)Ldz;",
      garbageValue = "-1802972375"
   )
   static class127 method142(int var0) {
      class127 var1 = (class127)World.findEnumerated(class182.method940(), var0);
      if (var1 == null) {
         var1 = class127.field1250;
      }

      return var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "27440"
   )
   public static void method141() {
      PlayerComposition.PlayerAppearance_cachedModels.clear();
   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-303589538"
   )
   static final void method138() {
      Scene.Scene_isLowDetail = false;
      Client.isLowDetail = false;
   }

   @ObfuscatedName("km")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/String;",
      garbageValue = "1908709885"
   )
   static String method143(int var0) {
      if (var0 < 0) {
         return "";
      } else {
         return Client.menuTargets[var0].length() > 0 ? Client.menuActions[var0] + " " + Client.menuTargets[var0] : Client.menuActions[var0];
      }
   }

   @ObfuscatedName("kv")
   @ObfuscatedSignature(
      descriptor = "([Lkd;IIIIIIIIB)V",
      garbageValue = "-10"
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
            if (!var10.isIf3 || !FriendSystem.isComponentHidden(var10)) {
               if (var10.contentType > 0) {
                  class413.method2152(var10);
               }

               int var12 = var10.x + var6;
               int var13 = var7 + var10.y;
               int var14 = var10.transparencyTop;
               int var15;
               int var16;
               if (var10 == Client.clickedWidget) {
                  if (var1 != -1412584499 && !var10.isScrollBar) {
                     MouseHandler.field151 = var0;
                     class142.field1316 = var6;
                     HealthBarDefinition.field1526 = var7;
                     continue;
                  }

                  if (Client.isDraggingWidget && Client.field590) {
                     var15 = MouseHandler.MouseHandler_x;
                     var16 = MouseHandler.MouseHandler_y;
                     var15 -= Client.widgetClickX;
                     var16 -= Client.widgetClickY;
                     if (var15 < Client.field544) {
                        var15 = Client.field544;
                     }

                     if (var15 + var10.width > Client.field544 + Client.clickedWidgetParent.width) {
                        var15 = Client.field544 + Client.clickedWidgetParent.width - var10.width;
                     }

                     if (var16 < Client.field458) {
                        var16 = Client.field458;
                     }

                     if (var16 + var10.height > Client.field458 + Client.clickedWidgetParent.height) {
                        var16 = Client.field458 + Client.clickedWidgetParent.height - var10.height;
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
                        if (StructComposition.clientPreferences.method538()) {
                           var13 += 15;
                           AbstractWorldMapData.fontPlain12.drawRightAligned("Fps:" + GameEngine.fps, var12 + var10.width, var13, 16776960, -1);
                           var13 += 15;
                           Runtime var45 = Runtime.getRuntime();
                           var20 = (int)((var45.totalMemory() - var45.freeMemory()) / 1024L);
                           var21 = 16776960;
                           if (var20 > (800 * 1024) && !Client.isLowDetail) {
                              var21 = 16711680;
                           }
                           double mb = var20 / 1024.0;
                           DecimalFormat df = new DecimalFormat("#.##");
                           AbstractWorldMapData.fontPlain12.drawRightAligned("Mem:" + df.format(mb) + " MB", var12 + var10.width, var13, var21, -1);
                           var13 += 15;
                        }
                        continue;
                     }

                     if (var10.contentType == 1337) {
                        Client.viewportX = var12;
                        Client.viewportY = var13;
                        Projectile.drawEntities(var12, var13, var10.width, var10.height);
                        Client.field576[var10.rootIndex] = true;
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1338) {
                        Player.drawMinimap(var10, var12, var13, var11);
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1339) {
                        SoundCache.drawCompass(var10, var12, var13, var11);
                        Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                        continue;
                     }

                     if (var10.contentType == 1400) {
                        KitDefinition.worldMap.draw(var12, var13, var10.width, var10.height, Client.cycle);
                     }

                     if (var10.contentType == 1401) {
                        KitDefinition.worldMap.drawOverview(var12, var13, var10.width, var10.height);
                     }

                     if (var10.contentType == 1402) {
                        class154.field1379.draw(var12, Client.cycle);
                     }
                  }

                  if (var10.type == 0) {
                     if (!var10.isIf3 && FriendSystem.isComponentHidden(var10) && var10 != WorldMapScaleHandler.mousedOverWidgetIf1) {
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
                        HealthBar.drawWidgets(var30.group, var15, var16, var17, var18, var12, var13, var11);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                     Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
                  } else if (var10.type == 11) {
                     if (FriendSystem.isComponentHidden(var10) && var10 != WorldMapScaleHandler.mousedOverWidgetIf1) {
                        continue;
                     }

                     if (var10.children != null) {
                        drawInterface(var10.children, var10.id, var15, var16, var17, var18, var12 - var10.scrollX, var13 - var10.scrollY, var11);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var4, var5);
                     Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
                  }

                  if (Client.isResizable || Client.field578[var11] || Client.gameDrawingMode > 1) {
                     if (var10.type == 0 && !var10.isIf3 && var10.scrollHeight > var10.height) {
                        Interpreter.drawScrollBar(var12 + var10.width, var13, var10.scrollY, var10.height, var10.scrollHeight);
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
                                       } else if (Widget.field2865) {
                                          class69.invalidateWidget(var10);
                                       }
                                    }
                                 } else {
                                    boolean var40 = false;
                                    boolean var41 = false;
                                    var26 = var10.itemIds[var19] - 1;
                                    if (var22 + 32 > var2 && var22 < var4 && var23 + 32 > var3 && var23 < var5 || var10 == class368.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
                                       SpritePixels var27;
                                       if (Client.isItemSelected == 1 && var19 == class101.selectedItemSlot && var10.id == ModeWhere.selectedItemWidget) {
                                          var27 = class200.getItemSprite(var26, var10.itemQuantities[var19], 2, 0, 2, false);
                                       } else {
                                          var27 = class200.getItemSprite(var26, var10.itemQuantities[var19], 1, 3153952, 2, false);
                                       }

                                       if (var27 != null) {
                                          if (var10 == class368.dragInventoryWidget && var19 == Client.dragItemSlotSource) {
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

                                             var27.drawTransAt(var22 + var24, var25 + var23, 128);
                                             if (var1 != -1) {
                                                Widget var28 = var0[var1 & '\uffff'];
                                                int var29;
                                                if (var23 + var25 < Rasterizer2D.Rasterizer2D_yClipStart && var28.scrollY > 0) {
                                                   var29 = (Rasterizer2D.Rasterizer2D_yClipStart - var23 - var25) * Client.field408 / 3;
                                                   if (var29 > Client.field408 * 10) {
                                                      var29 = Client.field408 * 10;
                                                   }

                                                   if (var29 > var28.scrollY) {
                                                      var29 = var28.scrollY;
                                                   }

                                                   var28.scrollY -= var29;
                                                   Client.draggedWidgetY += var29;
                                                   class69.invalidateWidget(var28);
                                                }

                                                if (var23 + var25 + 32 > Rasterizer2D.Rasterizer2D_yClipEnd && var28.scrollY < var28.scrollHeight - var28.height) {
                                                   var29 = (var23 + var25 + 32 - Rasterizer2D.Rasterizer2D_yClipEnd) * Client.field408 / 3;
                                                   if (var29 > Client.field408 * 10) {
                                                      var29 = Client.field408 * 10;
                                                   }

                                                   if (var29 > var28.scrollHeight - var28.height - var28.scrollY) {
                                                      var29 = var28.scrollHeight - var28.height - var28.scrollY;
                                                   }

                                                   var28.scrollY += var29;
                                                   Client.draggedWidgetY -= var29;
                                                   class69.invalidateWidget(var28);
                                                }
                                             }
                                          } else if (var10 == MusicPatchPcmStream.field2764 && var19 == Client.field470) {
                                             var27.drawTransAt(var22, var23, 128);
                                          } else {
                                             var27.drawTransBgAt(var22, var23);
                                          }
                                       } else {
                                          class69.invalidateWidget(var10);
                                       }
                                    }
                                 }

                                 ++var19;
                              }
                           }
                        } else if (var10.type == 3) {
                           if (KeyHandler.runCs1(var10)) {
                              var19 = var10.color2;
                              if (var10 == WorldMapScaleHandler.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
                                 var19 = var10.mouseOverColor2;
                              }
                           } else {
                              var19 = var10.color;
                              if (var10 == WorldMapScaleHandler.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
                                 var19 = var10.mouseOverColor;
                              }
                           }

                           if (var10.fill) {
                              switch(var10.fillMode.field4060) {
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
                                 if (Widget.field2865) {
                                    class69.invalidateWidget(var10);
                                 }
                              } else {
                                 String var50 = var10.text;
                                 if (KeyHandler.runCs1(var10)) {
                                    var20 = var10.color2;
                                    if (var10 == WorldMapScaleHandler.mousedOverWidgetIf1 && var10.mouseOverColor2 != 0) {
                                       var20 = var10.mouseOverColor2;
                                    }

                                    if (var10.text2.length() > 0) {
                                       var50 = var10.text2;
                                    }
                                 } else {
                                    var20 = var10.color;
                                    if (var10 == WorldMapScaleHandler.mousedOverWidgetIf1 && var10.mouseOverColor != 0) {
                                       var20 = var10.mouseOverColor;
                                    }
                                 }

                                 if (var10.isIf3 && var10.itemId != -1) {
                                    ItemComposition var51 = NPCComposition.ItemDefinition_get(var10.itemId);
                                    var50 = var51.name;
                                    if (var50 == null) {
                                       var50 = "null";
                                    }

                                    if ((var51.isStackable == 1 || var10.itemQuantity != 1) && var10.itemQuantity != -1) {
                                       var50 = MouseRecorder.colorStartTag(16748608) + var50 + "</col>" + " " + 'x' + FontName.formatItemStacks(var10.itemQuantity);
                                    }
                                 }

                                 if (var10 == Client.meslayerContinueWidget) {
                                    var50 = "Please wait...";
                                    var20 = var10.color;
                                 }

                                 if (!var10.isIf3) {
                                    var50 = HealthBarDefinition.method935(var50, var10);
                                 }

                                 var42.drawLines(var50, var12, var13, var10.width, var10.height, var20, var10.textShadowed ? 0 : -1, var10.textXAlignment, var10.textYAlignment, var10.textLineHeight);
                              }
                           } else if (var10.type == 5) {
                              SpritePixels var44;
                              if (!var10.isIf3) {
                                 var44 = var10.getSprite(KeyHandler.runCs1(var10), TaskHandler.urlRequester);
                                 if (var44 != null) {
                                    var44.drawTransBgAt(var12, var13);
                                 } else if (Widget.field2865) {
                                    class69.invalidateWidget(var10);
                                 }
                              } else {
                                 if (var10.itemId != -1) {
                                    var44 = class200.getItemSprite(var10.itemId, var10.itemQuantity, var10.outline, var10.spriteShadow, var10.itemQuantityMode, false);
                                 } else {
                                    var44 = var10.getSprite(false, TaskHandler.urlRequester);
                                 }

                                 if (var44 == null) {
                                    if (Widget.field2865) {
                                       class69.invalidateWidget(var10);
                                    }
                                 } else {
                                    var20 = var44.width;
                                    var21 = var44.height;
                                    if (!var10.spriteTiling) {
                                       var22 = var10.width * 4096 / var20;
                                       if (var10.spriteAngle != 0) {
                                          var44.method2480(var10.width / 2 + var12, var10.height / 2 + var13, var10.spriteAngle, var22);
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
                                                var44.method2480(var20 / 2 + var12 + var24 * var20, var21 / 2 + var13 + var25 * var21, var10.spriteAngle, 4096);
                                             } else if (var14 != 0) {
                                                var44.drawTransAt(var12 + var20 * var24, var13 + var21 * var25, 256 - (var14 & 255));
                                             } else {
                                                var44.drawTransBgAt(var12 + var20 * var24, var13 + var25 * var21);
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
                                 boolean var39 = KeyHandler.runCs1(var10);
                                 if (var39) {
                                    var20 = var10.sequenceId2;
                                 } else {
                                    var20 = var10.sequenceId;
                                 }

                                 Model var46 = null;
                                 var22 = 0;
                                 if (var10.itemId != -1) {
                                    var34 = NPCComposition.ItemDefinition_get(var10.itemId);
                                    if (var34 != null) {
                                       var34 = var34.getCountObj(var10.itemQuantity);
                                       var46 = var34.getModel(1);
                                       if (var46 != null) {
                                          var46.calculateBoundsCylinder();
                                          var22 = var46.height / 2;
                                       } else {
                                          class69.invalidateWidget(var10);
                                       }
                                    }
                                 } else if (var10.modelType == 5) {
                                    if (var10.modelId == 0) {
                                       var46 = Client.playerAppearance.getModel((SequenceDefinition)null, -1, (SequenceDefinition)null, -1);
                                    } else {
                                       var46 = class155.localPlayer.getModel();
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
                                             var47 = var35.method583();
                                          }
                                       }
                                    }

                                    SequenceDefinition var36 = null;
                                    var26 = -1;
                                    if (var20 != -1) {
                                       var36 = AABB.SequenceDefinition_get(var20);
                                       var26 = var10.modelFrame;
                                    }

                                    var46 = var10.getModel(var36, var26, var39, class155.localPlayer.appearance, var52, var47);
                                    if (var46 == null && Widget.field2865) {
                                       class69.invalidateWidget(var10);
                                    }
                                 }

                                 Rasterizer3D.method1167(var10.width / 2 + var12, var10.height / 2 + var13);
                                 var23 = Rasterizer3D.Rasterizer3D_sine[var10.modelAngleX] * var10.modelZoom >> 16;
                                 var24 = Rasterizer3D.Rasterizer3D_cosine[var10.modelAngleX] * var10.modelZoom >> 16;
                                 if (var46 != null) {
                                    if (!var10.isIf3) {
                                       var46.method1265(0, var10.modelAngleY, 0, var10.modelAngleX, 0, var23, var24);
                                    } else {
                                       var46.calculateBoundsCylinder();
                                       if (var10.modelOrthog) {
                                          var46.method1272(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY, var10.modelZoom);
                                       } else {
                                          var46.method1265(0, var10.modelAngleY, var10.modelAngleZ, var10.modelAngleX, var10.modelOffsetX, var22 + var23 + var10.modelOffsetY, var24 + var10.modelOffsetY);
                                       }
                                    }
                                 }

                                 Rasterizer3D.Rasterizer3D_method3();
                              } else {
                                 if (var10.type == 7) {
                                    var42 = var10.getFont();
                                    if (var42 == null) {
                                       if (Widget.field2865) {
                                          class69.invalidateWidget(var10);
                                       }
                                       continue;
                                    }

                                    var20 = 0;

                                    for(var21 = 0; var21 < var10.rawHeight; ++var21) {
                                       for(var22 = 0; var22 < var10.rawWidth; ++var22) {
                                          if (var10.itemIds[var20] > 0) {
                                             var34 = NPCComposition.ItemDefinition_get(var10.itemIds[var20] - 1);
                                             String var31;
                                             if (var34.isStackable != 1 && var10.itemQuantities[var20] == 1) {
                                                var31 = MouseRecorder.colorStartTag(16748608) + var34.name + "</col>";
                                             } else {
                                                var31 = MouseRecorder.colorStartTag(16748608) + var34.name + "</col>" + " " + 'x' + FontName.formatItemStacks(var10.itemQuantities[var20]);
                                             }

                                             var25 = var22 * (var10.paddingX + 115) + var12;
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
                                 if (var10.type == 8 && var10 == class380.field3655 && Client.field366 == Client.field398) {
                                    var19 = 0;
                                    var20 = 0;
                                    var32 = AbstractWorldMapData.fontPlain12;
                                    String var33 = var10.text;

                                    String var49;
                                    for(var33 = HealthBarDefinition.method935(var33, var10); var33.length() > 0; var20 = var20 + var32.ascent + 1) {
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

                                    for(var33 = HealthBarDefinition.method935(var33, var10); var33.length() > 0; var26 = var26 + var32.ascent + 1) {
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
                                    if (var10.field2899) {
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
                                       Buddy.method2086(var19, var20, var21, var22, var10.color, var10.lineWid);
                                    }
                                 } else if (var10.type == 12) {
                                    class303 var43 = var10.method1724();
                                    class298 var38 = var10.method1748();
                                    if (var43 != null && var38 != null && var43.method1706()) {
                                       var32 = var10.getFont();
                                       if (var32 != null) {
                                          Client.field350.method2500(var12, var13, var10.width, var10.height, var43.method1680(), var43.method1681(), 0, 0, var43.method1678(), var43.method1663(), var43.method1677());
                                          var22 = var10.textShadowed ? var10.spriteShadow * -1319117017 * -535977833 : -1;
                                          if (!var43.method1694() && var43.method1696().method1943()) {
                                             Client.field350.method2499(var38.field2801, var22, var38.field2800, var38.field2802);
                                             Client.field350.method2498(var43.method1647(), var32);
                                          } else {
                                             Client.field350.method2499(var10.color, var22, var38.field2800, var38.field2802);
                                             Client.field350.method2498(var43.method1696(), var32);
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
