import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
@Implements("ArchiveLoader")
public class ArchiveLoader {
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lsp;"
   )
   static IndexedSprite field836;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive")
   final Archive archive;
   @ObfuscatedName("ac")
   @Export("groupCount")
   final int groupCount;
   @ObfuscatedName("ab")
   @Export("loadedCount")
   int loadedCount = 0;

   @ObfuscatedSignature(
      descriptor = "(Lmx;Ljava/lang/String;)V"
   )
   ArchiveLoader(Archive var1, String var2) {
      this.archive = var1;
      this.groupCount = var1.getGroupCount();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2011929420"
   )
   @Export("isLoaded")
   boolean isLoaded() {
      this.loadedCount = 0;

      for(int var1 = 0; var1 < this.groupCount; ++var1) {
         if (!this.archive.method1818(var1) || this.archive.method1822(var1)) {
            ++this.loadedCount;
         }
      }

      return this.loadedCount >= this.groupCount;
   }

   @ObfuscatedName("ir")
   @ObfuscatedSignature(
      descriptor = "(Ldq;IIIIII)V",
      garbageValue = "16777215"
   )
   @Export("drawActor2d")
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
         boolean var8 = var1 < var75;
         int var9 = -2;
         if (var0.overheadText != null && (!var8 || !var0.showPublicPlayerChat && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            PendingSpawn.method504(var0, var0.defaultHeight);
            if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
               Client.overheadTextXOffsets[Client.overheadTextCount] = class7.fontBold12.stringWidth(var0.overheadText) / 2;
               Client.overheadTextAscents[Client.overheadTextCount] = class7.fontBold12.ascent;
               Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
               Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY - var9;
               Client.overheadTextColors[Client.overheadTextCount] = var0.field952;
               Client.overheadTextEffects[Client.overheadTextCount] = var0.field945;
               Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadText[Client.overheadTextCount] = var0.overheadText;
               ++Client.overheadTextCount;
               var9 += 12;
            }
         }

         int var15;
         int var22;
         int var23;
         if (!var0.healthBars.method1920()) {
            PendingSpawn.method504(var0, var0.defaultHeight + 15);

            for(HealthBar var10 = (HealthBar)var0.healthBars.last(); var10 != null; var10 = (HealthBar)var0.healthBars.previous()) {
               HealthBarUpdate var11 = var10.get(Client.cycle);
               if (var11 == null) {
                  if (var10.isEmpty()) {
                     var10.remove();
                  }
               } else {
                  HealthBarDefinition var12 = var10.definition;
                  SpritePixels var13 = var12.getBackSprite();
                  SpritePixels var14 = var12.getFrontSprite();
                  int var16 = 0;
                  if (var13 != null && var14 != null) {
                     if (var12.widthPadding * 2 < var14.subWidth) {
                        var16 = var12.widthPadding;
                     }

                     var15 = var14.subWidth - var16 * 2;
                  } else {
                     var15 = var12.width;
                  }

                  int var17 = 255;
                  boolean var18 = true;
                  int var19 = Client.cycle - var11.cycle;
                  int var20 = var15 * var11.health2 / var12.width;
                  int var21;
                  int var97;
                  if (var11.cycleOffset > var19) {
                     var21 = var12.field1508 == 0 ? 0 : var12.field1508 * (var19 / var12.field1508);
                     var22 = var15 * var11.health / var12.width;
                     var97 = var21 * (var20 - var22) / var11.cycleOffset + var22;
                  } else {
                     var97 = var20;
                     var21 = var12.int5 + var11.cycleOffset - var19;
                     if (var12.int3 >= 0) {
                        var17 = (var21 << 8) / (var12.int5 - var12.int3);
                     }
                  }

                  if (var11.health2 > 0 && var97 < 1) {
                     var97 = 1;
                  }

                  if (var13 != null && var14 != null) {
                     if (var15 == var97) {
                        var97 += var16 * 2;
                     } else {
                        var97 += var16;
                     }

                     var21 = var13.subHeight;
                     var9 += var21;
                     var22 = var2 + Client.viewportTempX - (var15 >> 1);
                     var23 = var3 + Client.viewportTempY - var9;
                     var22 -= var16;
                     if (var17 >= 0 && var17 < 255) {
                        var13.drawTransAt(var22, var23, var17);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var97, var23 + var21);
                        var14.drawTransAt(var22, var23, var17);
                     } else {
                        var13.drawTransBgAt(var22, var23);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var97, var23 + var21);
                        var14.drawTransBgAt(var22, var23);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
                     var9 += 2;
                  } else {
                     var9 += 5;
                     if (Client.viewportTempX > -1) {
                        var21 = var2 + Client.viewportTempX - (var15 >> 1);
                        var22 = var3 + Client.viewportTempY - var9;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var97, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var97 + var21, var22, var15 - var97, 5, 16711680);
                     }

                     var9 += 2;
                  }
               }
            }
         }

         if (var9 == -2) {
            var9 += 7;
         }

         Player var90;
         if (var8 && var0.playerCycle == Client.cycle && SoundCache.method231((Player)var0)) {
            var90 = (Player)var0;
            if (var8) {
               PendingSpawn.method504(var0, var0.defaultHeight + 15);
               AbstractFont var91 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
               var9 += 4;
               var91.drawCentered(var90.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var9, 16777215, 0);
               var9 += 18;
            }
         }

         if (var8) {
            var90 = (Player)var0;
            if (var90.isHidden) {
               return;
            }

            if (var90.headIconPk != -1 || var90.headIconPrayer != -1) {
               PendingSpawn.method504(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  if (var90.headIconPk != -1) {
                     var9 += 25;
                     class315.headIconPkSprites[var90.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
                  }

                  if (var90.headIconPrayer != -1) {
                     var9 += 25;
                     class287.headIconPrayerSprites[var90.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
                  }
               }
            }

            if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
               PendingSpawn.method504(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  var9 += EnumComposition.headIconHintSprites[1].subHeight;
                  EnumComposition.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
               }
            }
         } else {
            NPC var92 = (NPC)var0;
            int[] var93 = var92.method564();
            short[] var94 = var92.method565();
            if (var94 != null && var93 != null) {
               for(int var76 = 0; var76 < var94.length; ++var76) {
                  if (var94[var76] >= 0 && var93[var76] >= 0) {
                     long var77 = (long)var93[var76] << 8 | (long)var94[var76];
                     SpritePixels var79 = (SpritePixels)Client.archive5.method2066(var77);
                     if (var79 == null) {
                        SpritePixels[] var80 = class70.method416(class143.archive8, var93[var76], 0);
                        if (var80 != null && var94[var76] < var80.length) {
                           var79 = var80[var94[var76]];
                           Client.archive5.method2071(var77, var79);
                        }
                     }

                     if (var79 != null) {
                        PendingSpawn.method504(var0, var0.defaultHeight + 15);
                        if (Client.viewportTempX > -1) {
                           var79.drawTransBgAt(var2 + Client.viewportTempX - (var79.subWidth >> 1), Client.viewportTempY + (var3 - var79.subHeight) - 4);
                        }
                     }
                  }
               }
            }

            if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
               PendingSpawn.method504(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  EnumComposition.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
               }
            }
         }

         for(int var81 = 0; var81 < 4; ++var81) {
            int var82 = var0.hitSplatCycles[var81];
            int var83 = var0.hitSplatTypes[var81];
            HitSplatDefinition var95 = null;
            int var84 = 0;
            if (var83 >= 0) {
               if (var82 <= Client.cycle) {
                  continue;
               }

               var95 = NewShit.method958(var0.hitSplatTypes[var81]);
               var84 = var95.field1644;
               if (var95 != null && var95.transforms != null) {
                  var95 = var95.transform();
                  if (var95 == null) {
                     var0.hitSplatCycles[var81] = -1;
                     continue;
                  }
               }
            } else if (var82 < 0) {
               continue;
            }

            var15 = var0.hitSplatTypes2[var81];
            HitSplatDefinition var99 = null;
            if (var15 >= 0) {
               var99 = NewShit.method958(var15);
               if (var99 != null && var99.transforms != null) {
                  var99 = var99.transform();
               }
            }

            if (var82 - var84 <= Client.cycle) {
               if (var95 == null) {
                  var0.hitSplatCycles[var81] = -1;
               } else {
                  PendingSpawn.method504(var0, var0.defaultHeight / 2);
                  if (Client.viewportTempX > -1) {
                     boolean var96 = true;
                     if (var81 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if (var81 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if (var81 == 3) {
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
                     var85 = var95.method1018();
                     int var43;
                     if (var85 != null) {
                        var22 = var85.subWidth;
                        var43 = var85.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var85.xOffset;
                     }

                     var86 = var95.method1016();
                     if (var86 != null) {
                        var23 = var86.subWidth;
                        var43 = var86.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var86.xOffset;
                     }

                     var87 = var95.method1012();
                     if (var87 != null) {
                        var24 = var87.subWidth;
                        var43 = var87.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var87.xOffset;
                     }

                     var88 = var95.method1013();
                     if (var88 != null) {
                        var25 = var88.subWidth;
                        var43 = var88.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var88.xOffset;
                     }

                     if (var99 != null) {
                        var30 = var99.method1018();
                        if (var30 != null) {
                           var34 = var30.subWidth;
                           var43 = var30.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.xOffset;
                        }

                        var31 = var99.method1016();
                        if (var31 != null) {
                           var35 = var31.subWidth;
                           var43 = var31.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.xOffset;
                        }

                        var32 = var99.method1012();
                        if (var32 != null) {
                           var36 = var32.subWidth;
                           var43 = var32.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.xOffset;
                        }

                        var33 = var99.method1013();
                        if (var33 != null) {
                           var37 = var33.subWidth;
                           var43 = var33.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.xOffset;
                        }
                     }

                     Font var89 = var95.getFont();
                     if (var89 == null) {
                        var89 = Calendar.fontPlain11;
                     }

                     Font var44;
                     if (var99 != null) {
                        var44 = var99.getFont();
                        if (var44 == null) {
                           var44 = Calendar.fontPlain11;
                        }
                     } else {
                        var44 = Calendar.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var95.getString(var0.hitSplatValues[var81]);
                     int var98 = var89.stringWidth(var45);
                     if (var99 != null) {
                        var46 = var99.getString(var0.hitSplatValues2[var81]);
                        var48 = var44.stringWidth(var46);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if (var23 > 0) {
                        if (var87 == null && var88 == null) {
                           var49 = 1;
                        } else {
                           var49 = var98 / var23 + 1;
                        }
                     }

                     if (var99 != null && var35 > 0) {
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
                        var56 = var23 * var49;
                        var51 += var56;
                        var55 += (var56 - var98) / 2;
                     } else {
                        var51 += var98;
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
                     if (var99 != null) {
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
                           var62 = var35 * var50;
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

                     var62 = var0.hitSplatCycles[var81] - Client.cycle;
                     int var63 = var95.field1649 - var62 * var95.field1649 / var95.field1644;
                     int var64 = var62 * var95.field1656 / var95.field1644 + -var95.field1656;
                     int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
                     int var66 = var64 + (var3 + Client.viewportTempY - 12);
                     int var67 = var66;
                     int var68 = var66 + var42;
                     int var69 = var66 + var95.field1643 + 15;
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
                     if (var99 != null) {
                        var72 = var66 + var99.field1643 + 15;
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
                     if (var95.field1650 >= 0) {
                        var73 = (var62 << 8) / (var95.field1644 - var95.field1650);
                     }

                     if (var73 >= 0 && var73 < 255) {
                        if (var85 != null) {
                           var85.drawTransAt(var52 + var65 - var26, var66, var73);
                        }

                        if (var87 != null) {
                           var87.drawTransAt(var53 + var65 - var28, var66, var73);
                        }

                        if (var86 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var86.drawTransAt(var23 * var74 + (var54 + var65 - var27), var66, var73);
                           }
                        }

                        if (var88 != null) {
                           var88.drawTransAt(var56 + var65 - var29, var66, var73);
                        }

                        var89.drawAlpha(var45, var55 + var65, var69, var95.textColor, 0, var73);
                        if (var99 != null) {
                           if (var30 != null) {
                              var30.drawTransAt(var65 + var57 - var38, var66, var73);
                           }

                           if (var32 != null) {
                              var32.drawTransAt(var65 + var58 - var40, var66, var73);
                           }

                           if (var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawTransAt(var74 * var35 + (var65 + var59 - var39), var66, var73);
                              }
                           }

                           if (var33 != null) {
                              var33.drawTransAt(var60 + var65 - var41, var66, var73);
                           }

                           var44.drawAlpha(var46, var61 + var65, var72, var99.textColor, 0, var73);
                        }
                     } else {
                        if (var85 != null) {
                           var85.drawTransBgAt(var65 + var52 - var26, var66);
                        }

                        if (var87 != null) {
                           var87.drawTransBgAt(var65 + var53 - var28, var66);
                        }

                        if (var86 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var86.drawTransBgAt(var23 * var74 + (var54 + var65 - var27), var66);
                           }
                        }

                        if (var88 != null) {
                           var88.drawTransBgAt(var65 + var56 - var29, var66);
                        }

                        var89.draw(var45, var55 + var65, var69, var95.textColor | -16777216, 0);
                        if (var99 != null) {
                           if (var30 != null) {
                              var30.drawTransBgAt(var65 + var57 - var38, var66);
                           }

                           if (var32 != null) {
                              var32.drawTransBgAt(var65 + var58 - var40, var66);
                           }

                           if (var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawTransBgAt(var35 * var74 + (var59 + var65 - var39), var66);
                              }
                           }

                           if (var33 != null) {
                              var33.drawTransBgAt(var65 + var60 - var41, var66);
                           }

                           var44.draw(var46, var61 + var65, var72, var99.textColor | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }
}
