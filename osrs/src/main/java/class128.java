import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
public class class128 implements class120 {
   @ObfuscatedName("jp")
   static int cameraYaw;

   @ObfuscatedName("in")
   @ObfuscatedSignature(
      descriptor = "(Lct;IIIIIB)V",
      garbageValue = "0"
   )
   static final void drawActor2d(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if (var0 != null && var0.isVisible()) {
         if (var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).definition;
            if (var6.transforms != null) {
               var6 = var6.transform();
            }

            if (var6 == null) {
               return;
            }
         }

         int var75 = Players.Players_count;
         int[] var7 = Players.Players_indices;
         byte var8 = 0;
         Player var10;
         if (var1 < var75 && var0.playerCycle == Client.cycle) {
            var10 = (Player)var0;
            boolean var9;
            if (Client.drawPlayerNames == 0) {
               var9 = false;
            } else if (var10 != class155.localPlayer) {
               boolean var11 = (Client.drawPlayerNames & 4) != 0;
               var9 = var11 || SoundCache.method243() && var10.isFriend() || class121.method681() && var10.isFriendsChatMember();
            } else {
               var9 = GraphicsObject.method424();
            }

            if (var9) {
               Player var76 = (Player)var0;
               if (var1 < var75) {
                  ClientPreferences.method564(var0, var0.defaultHeight + 15);
                  AbstractFont var12 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
                  byte var13 = 9;
                  var12.drawCentered(var76.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var13, 16777215, 0);
                  var8 = 18;
               }
            }
         }

         int var90 = -2;
         int var15;
         int var22;
         int var23;
         if (!var0.healthBars.method1891()) {
            ClientPreferences.method564(var0, var0.defaultHeight + 15);

            for(HealthBar var91 = (HealthBar)var0.healthBars.last(); var91 != null; var91 = (HealthBar)var0.healthBars.previous()) {
               HealthBarUpdate var100 = var91.get(Client.cycle);
               if (var100 == null) {
                  if (var91.isEmpty()) {
                     var91.remove();
                  }
               } else {
                  HealthBarDefinition var94 = var91.definition;
                  SpritePixels var77 = var94.getBackSprite();
                  SpritePixels var14 = var94.getFrontSprite();
                  int var16 = 0;
                  if (var77 != null && var14 != null) {
                     if (var94.widthPadding * 2 < var14.subWidth) {
                        var16 = var94.widthPadding;
                     }

                     var15 = var14.subWidth - var16 * 2;
                  } else {
                     var15 = var94.width;
                  }

                  int var17 = 255;
                  boolean var18 = true;
                  int var19 = Client.cycle - var100.cycle;
                  int var20 = var15 * var100.health2 / var94.width;
                  int var21;
                  int var98;
                  if (var100.cycleOffset > var19) {
                     var21 = var94.field1514 == 0 ? 0 : var94.field1514 * (var19 / var94.field1514);
                     var22 = var15 * var100.health / var94.width;
                     var98 = var21 * (var20 - var22) / var100.cycleOffset + var22;
                  } else {
                     var98 = var20;
                     var21 = var94.int5 + var100.cycleOffset - var19;
                     if (var94.int3 >= 0) {
                        var17 = (var21 << 8) / (var94.int5 - var94.int3);
                     }
                  }

                  if (var100.health2 > 0 && var98 < 1) {
                     var98 = 1;
                  }

                  if (var77 != null && var14 != null) {
                     if (var98 == var15) {
                        var98 += var16 * 2;
                     } else {
                        var98 += var16;
                     }

                     var21 = var77.subHeight;
                     var90 += var21;
                     var22 = var2 + Client.viewportTempX - (var15 >> 1);
                     var23 = var3 + Client.viewportTempY - var90;
                     var22 -= var16;
                     if (var17 >= 0 && var17 < 255) {
                        var77.drawTransAt(var22, var23, var17);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var98, var21 + var23);
                        var14.drawTransAt(var22, var23, var17);
                     } else {
                        var77.drawTransBgAt(var22, var23);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var98, var21 + var23);
                        var14.drawTransBgAt(var22, var23);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
                     var90 += 2;
                  } else {
                     var90 += 5;
                     if (Client.viewportTempX > -1) {
                        var21 = var2 + Client.viewportTempX - (var15 >> 1);
                        var22 = var3 + Client.viewportTempY - var90;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var98, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21 + var98, var22, var15 - var98, 5, 16711680);
                     }

                     var90 += 2;
                  }
               }
            }
         }

         if (var90 == -2) {
            var90 += 7;
         }

         var90 += var8;
         if (var1 < var75) {
            var10 = (Player)var0;
            if (var10.isHidden) {
               return;
            }

            if (var10.headIconPk != -1 || var10.headIconPrayer != -1) {
               ClientPreferences.method564(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  if (var10.headIconPk != -1) {
                     var90 += 25;
                     World.headIconPkSprites[var10.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var90);
                  }

                  if (var10.headIconPrayer != -1) {
                     var90 += 25;
                     class410.headIconPrayerSprites[var10.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var90);
                  }
               }
            }

            if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
               ClientPreferences.method564(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  var90 += class358.headIconHintSprites[1].subHeight;
                  class358.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var90);
               }
            }
         } else {
            NPC var92 = (NPC)var0;
            int[] var101 = var92.method585();
            short[] var95 = var92.method578();
            if (var95 != null && var101 != null) {
               for(int var96 = 0; var96 < var95.length; ++var96) {
                  if (var95[var96] >= 0 && var101[var96] >= 0) {
                     long var78 = (long)var101[var96] << 8 | (long)var95[var96];
                     SpritePixels var80 = (SpritePixels)Client.archive5.method2016(var78);
                     if (var80 == null) {
                        SpritePixels[] var81 = SequenceDefinition.method1062(ClientPreferences.archive8, var101[var96], 0);
                        if (var81 != null && var95[var96] < var81.length) {
                           var80 = var81[var95[var96]];
                           Client.archive5.method2014(var78, var80);
                        }
                     }

                     if (var80 != null) {
                        ClientPreferences.method564(var0, var0.defaultHeight + 15);
                        if (Client.viewportTempX > -1) {
                           var3 -= var80.subHeight;
                           var80.drawTransBgAt(var2 + Client.viewportTempX - (var80.subWidth >> 1), var3 + Client.viewportTempY);
                           var3 -= 2;
                        }
                     }
                  }
               }
            }

            if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
               ClientPreferences.method564(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  class358.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
               }
            }
         }

         if (var0.overheadText != null && (var1 >= var75 || !var0.showPublicPlayerChat && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            ClientPreferences.method564(var0, var0.defaultHeight + 15);
            if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
               Client.overheadTextXOffsets[Client.overheadTextCount] = class146.fontBold12.stringWidth(var0.overheadText) / 2;
               Client.overheadTextAscents[Client.overheadTextCount] = class146.fontBold12.ascent;
               Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
               Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY - var90;
               Client.overheadTextColors[Client.overheadTextCount] = var0.overheadTextColor;
               Client.overheadTextEffects[Client.overheadTextCount] = var0.overheadTextEffect;
               Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadText[Client.overheadTextCount] = var0.overheadText;
               ++Client.overheadTextCount;
               var90 += 12;
            }
         }

         for(int var82 = 0; var82 < 4; ++var82) {
            int var93 = var0.hitSplatCycles[var82];
            int var83 = var0.hitSplatTypes[var82];
            HitSplatDefinition var102 = null;
            int var84 = 0;
            if (var83 >= 0) {
               if (var93 <= Client.cycle) {
                  continue;
               }

               var102 = class364.method1911(var0.hitSplatTypes[var82]);
               var84 = var102.field1649;
               if (var102 != null && var102.transforms != null) {
                  var102 = var102.transform();
                  if (var102 == null) {
                     var0.hitSplatCycles[var82] = -1;
                     continue;
                  }
               }
            } else if (var93 < 0) {
               continue;
            }

            var15 = var0.hitSplatTypes2[var82];
            HitSplatDefinition var103 = null;
            if (var15 >= 0) {
               var103 = class364.method1911(var15);
               if (var103 != null && var103.transforms != null) {
                  var103 = var103.transform();
               }
            }

            if (var93 - var84 <= Client.cycle) {
               if (var102 == null) {
                  var0.hitSplatCycles[var82] = -1;
               } else {
                  ClientPreferences.method564(var0, var0.defaultHeight / 2);
                  if (Client.viewportTempX > -1) {
                     boolean var97 = true;
                     if (var82 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if (var82 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if (var82 == 3) {
                        Client.viewportTempX += 15;
                        Client.viewportTempY -= 10;
                     }

                     SpritePixels var85 = null;
                     SpritePixels var86 = null;
                     SpritePixels var87 = null;
                     SpritePixels var88 = null;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     int var29 = 0;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     SpritePixels var33 = null;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     int var42 = 0;
                     var85 = var102.method1002();
                     int var43;
                     if (var85 != null) {
                        var22 = var85.subWidth;
                        var43 = var85.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var85.xOffset;
                     }

                     var86 = var102.method1003();
                     if (var86 != null) {
                        var23 = var86.subWidth;
                        var43 = var86.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var86.xOffset;
                     }

                     var87 = var102.method1010();
                     if (var87 != null) {
                        var24 = var87.subWidth;
                        var43 = var87.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var87.xOffset;
                     }

                     var88 = var102.method1004();
                     if (var88 != null) {
                        var25 = var88.subWidth;
                        var43 = var88.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var88.xOffset;
                     }

                     if (var103 != null) {
                        var30 = var103.method1002();
                        if (var30 != null) {
                           var34 = var30.subWidth;
                           var43 = var30.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.xOffset;
                        }

                        var31 = var103.method1003();
                        if (var31 != null) {
                           var35 = var31.subWidth;
                           var43 = var31.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.xOffset;
                        }

                        var32 = var103.method1010();
                        if (var32 != null) {
                           var36 = var32.subWidth;
                           var43 = var32.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.xOffset;
                        }

                        var33 = var103.method1004();
                        if (var33 != null) {
                           var37 = var33.subWidth;
                           var43 = var33.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.xOffset;
                        }
                     }

                     Font var89 = var102.getFont();
                     if (var89 == null) {
                        var89 = class151.fontPlain11;
                     }

                     Font var44;
                     if (var103 != null) {
                        var44 = var103.getFont();
                        if (var44 == null) {
                           var44 = class151.fontPlain11;
                        }
                     } else {
                        var44 = class151.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var102.getString(var0.hitSplatValues[var82]);
                     int var99 = var89.stringWidth(var45);
                     if (var103 != null) {
                        var46 = var103.getString(var0.hitSplatValues2[var82]);
                        var48 = var44.stringWidth(var46);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if (var23 > 0) {
                        if (var87 == null && var88 == null) {
                           var49 = 1;
                        } else {
                           var49 = var99 / var23 + 1;
                        }
                     }

                     if (var103 != null && var35 > 0) {
                        if (var32 == null && var33 == null) {
                           var50 = 1;
                        } else {
                           var50 = var48 / var35 + 1;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if (var22 > 0) {
                        var51 += var22;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if (var24 > 0) {
                        var51 += var24;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if (var23 > 0) {
                        var56 = var49 * var23;
                        var51 += var56;
                        var55 += (var56 - var99) / 2;
                     } else {
                        var51 += var99;
                     }

                     var56 = var51;
                     if (var25 > 0) {
                        var51 += var25;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if (var103 != null) {
                        var51 += 2;
                        var57 = var51;
                        if (var34 > 0) {
                           var51 += var34;
                        }

                        var51 += 2;
                        var58 = var51;
                        if (var36 > 0) {
                           var51 += var36;
                        }

                        var59 = var51;
                        var61 = var51;
                        if (var35 > 0) {
                           var62 = var50 * var35;
                           var51 += var62;
                           var61 += (var62 - var48) / 2;
                        } else {
                           var51 += var48;
                        }

                        var60 = var51;
                        if (var37 > 0) {
                           var51 += var37;
                        }
                     }

                     var62 = var0.hitSplatCycles[var82] - Client.cycle;
                     int var63 = var102.field1657 - var62 * var102.field1657 / var102.field1649;
                     int var64 = var62 * var102.field1652 / var102.field1649 + -var102.field1652;
                     int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
                     int var66 = var3 + Client.viewportTempY - 12 + var64;
                     int var67 = var66;
                     int var68 = var66 + var42;
                     int var69 = var66 + var102.field1662 + 15;
                     int var70 = var69 - var89.maxAscent;
                     int var71 = var69 + var89.maxDescent;
                     if (var70 < var66) {
                        var67 = var70;
                     }

                     if (var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if (var103 != null) {
                        var72 = var66 + var103.field1662 + 15;
                        var73 = var72 - var44.maxAscent;
                        var74 = var72 + var44.maxDescent;
                        if (var73 < var67) {
                           ;
                        }

                        if (var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if (var102.field1659 >= 0) {
                        var73 = (var62 << 8) / (var102.field1649 - var102.field1659);
                     }

                     if (var73 >= 0 && var73 < 255) {
                        if (var85 != null) {
                           var85.drawTransAt(var65 + var52 - var26, var66, var73);
                        }

                        if (var87 != null) {
                           var87.drawTransAt(var53 + var65 - var28, var66, var73);
                        }

                        if (var86 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var86.drawTransAt(var74 * var23 + (var65 + var54 - var27), var66, var73);
                           }
                        }

                        if (var88 != null) {
                           var88.drawTransAt(var56 + var65 - var29, var66, var73);
                        }

                        var89.drawAlpha(var45, var55 + var65, var69, var102.textColor, 0, var73);
                        if (var103 != null) {
                           if (var30 != null) {
                              var30.drawTransAt(var57 + var65 - var38, var66, var73);
                           }

                           if (var32 != null) {
                              var32.drawTransAt(var58 + var65 - var40, var66, var73);
                           }

                           if (var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawTransAt(var74 * var35 + (var65 + var59 - var39), var66, var73);
                              }
                           }

                           if (var33 != null) {
                              var33.drawTransAt(var60 + var65 - var41, var66, var73);
                           }

                           var44.drawAlpha(var46, var61 + var65, var72, var103.textColor, 0, var73);
                        }
                     } else {
                        if (var85 != null) {
                           var85.drawTransBgAt(var65 + var52 - var26, var66);
                        }

                        if (var87 != null) {
                           var87.drawTransBgAt(var53 + var65 - var28, var66);
                        }

                        if (var86 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var86.drawTransBgAt(var74 * var23 + (var54 + var65 - var27), var66);
                           }
                        }

                        if (var88 != null) {
                           var88.drawTransBgAt(var56 + var65 - var29, var66);
                        }

                        var89.draw(var45, var65 + var55, var69, var102.textColor | -16777216, 0);
                        if (var103 != null) {
                           if (var30 != null) {
                              var30.drawTransBgAt(var57 + var65 - var38, var66);
                           }

                           if (var32 != null) {
                              var32.drawTransBgAt(var65 + var58 - var40, var66);
                           }

                           if (var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawTransBgAt(var35 * var74 + (var65 + var59 - var39), var66);
                              }
                           }

                           if (var33 != null) {
                              var33.drawTransBgAt(var60 + var65 - var41, var66);
                           }

                           var44.draw(var46, var65 + var61, var72, var103.textColor | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
