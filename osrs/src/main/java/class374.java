import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nq")
public class class374 {
   @ObfuscatedName("f")
   public char field3603;
   @ObfuscatedName("w")
   public int field3601 = 0;
   @ObfuscatedName("v")
   public int field3602 = 0;

   @ObfuscatedName("go")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "115"
   )
   static final void method1973() {
      if (WorldMapSectionType.ClanChat_inClanChat) {
         if (class463.friendsChat != null) {
            class463.friendsChat.sort();
         }

         PacketBufferNode.method1538();
         WorldMapSectionType.ClanChat_inClanChat = false;
      }

   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
           descriptor = "(Lcb;IIIIII)V",
           garbageValue = "978840164"
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
         boolean var8 = var1 < var75;
         int var9 = -2;
         if (var0.overheadText != null && (!var8 || !var0.showPublicPlayerChat && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            class31.method121(var0, var0.defaultHeight);
            if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
               Client.overheadTextXOffsets[Client.overheadTextCount] = class19.fontBold12.stringWidth(var0.overheadText) / 2;
               Client.overheadTextAscents[Client.overheadTextCount] = class19.fontBold12.ascent;
               Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
               Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY - var9;
               Client.overheadTextColors[Client.overheadTextCount] = var0.field937;
               Client.overheadTextEffects[Client.overheadTextCount] = var0.field961;
               Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadText[Client.overheadTextCount] = var0.overheadText;
               ++Client.overheadTextCount;
               var9 += 12;
            }
         }

         int var15;
         int var22;
         int var23;
         if (!var0.healthBars.method1912()) {
            class31.method121(var0, var0.defaultHeight + 15);

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
                  int var99;
                  if (var11.cycleOffset > var19) {
                     var21 = var12.field1519 == 0 ? 0 : var12.field1519 * (var19 / var12.field1519);
                     var22 = var15 * var11.health / var12.width;
                     var99 = var21 * (var20 - var22) / var11.cycleOffset + var22;
                  } else {
                     var99 = var20;
                     var21 = var12.int5 + var11.cycleOffset - var19;
                     if (var12.int3 >= 0) {
                        var17 = (var21 << 8) / (var12.int5 - var12.int3);
                     }
                  }

                  if (var11.health2 > 0 && var99 < 1) {
                     var99 = 1;
                  }

                  if (var13 != null && var14 != null) {
                     if (var15 == var99) {
                        var99 += var16 * 2;
                     } else {
                        var99 += var16;
                     }

                     var21 = var13.subHeight;
                     var9 += var21;
                     var22 = var2 + Client.viewportTempX - (var15 >> 1);
                     var23 = var3 + Client.viewportTempY - var9;
                     var22 -= var16;
                     if (var17 >= 0 && var17 < 255) {
                        var13.drawTransAt(var22, var23, var17);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var99 + var22, var21 + var23);
                        var14.drawTransAt(var22, var23, var17);
                     } else {
                        var13.drawTransBgAt(var22, var23);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var99 + var22, var23 + var21);
                        var14.drawTransBgAt(var22, var23);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
                     var9 += 2;
                  } else {
                     var9 += 5;
                     if (Client.viewportTempX > -1) {
                        var21 = var2 + Client.viewportTempX - (var15 >> 1);
                        var22 = var3 + Client.viewportTempY - var9;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var99, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var99 + var21, var22, var15 - var99, 5, 16711680);
                     }

                     var9 += 2;
                  }
               }
            }
         }

         if (var9 == -2) {
            var9 += 7;
         }

         if (var8 && var0.playerCycle == Client.cycle) {
            Player var92 = (Player)var0;
            boolean var76;
            if (Client.drawPlayerNames == 0) {
               var76 = false;
            } else if (var92 == class387.localPlayer) {
               var76 = BuddyRankComparator.method663();
            } else {
               boolean var77 = DirectByteArrayCopier.method1771();
               boolean var78;
               if (!var77) {
                  var78 = (Client.drawPlayerNames & 1) != 0;
                  var77 = var78 && var92.isFriend();
               }

               var78 = var77;
               if (!var77) {
                  boolean var79 = (Client.drawPlayerNames & 2) != 0;
                  var78 = var79 && var92.isFriendsChatMember();
               }

               var76 = var78;
            }

            if (var76) {
               Player var94 = (Player)var0;
               if (var8) {
                  class31.method121(var0, var0.defaultHeight + 15);
                  AbstractFont var96 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
                  var9 += 4;
                  var96.drawCentered(var94.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var9, 16777215, 0);
                  var9 += 18;
               }
            }
         }

         if (var8) {
            Player var90 = (Player)var0;
            if (var90.isHidden) {
               return;
            }

            if (var90.headIconPk != -1 || var90.headIconPrayer != -1) {
               class31.method121(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  if (var90.headIconPk != -1) {
                     var9 += 25;
                     ClanChannel.headIconPkSprites[var90.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
                  }

                  if (var90.headIconPrayer != -1) {
                     var9 += 25;
                     class367.headIconPrayerSprites[var90.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
                  }
               }
            }

            if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
               class31.method121(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  var9 += WorldMapSectionType.headIconHintSprites[1].subHeight;
                  WorldMapSectionType.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
               }
            }
         } else {
            NPC var91 = (NPC)var0;
            int[] var93 = var91.method573();
            short[] var95 = var91.method572();
            if (var95 != null && var93 != null) {
               for(int var103 = 0; var103 < var95.length; ++var103) {
                  if (var95[var103] >= 0 && var93[var103] >= 0) {
                     long var80 = (long)var93[var103] << 8 | (long)var95[var103];
                     SpritePixels var82 = (SpritePixels)Client.archive5.method2051(var80);
                     if (var82 == null) {
                        SpritePixels[] var83 = AABB.method1240(WorldMapEvent.archive8, var93[var103], 0);
                        if (var83 != null && var95[var103] < var83.length) {
                           var82 = var83[var95[var103]];
                           Client.archive5.method2052(var80, var82);
                        }
                     }

                     if (var82 != null) {
                        class31.method121(var0, var0.defaultHeight + 15);
                        if (Client.viewportTempX > -1) {
                           var82.drawTransBgAt(var2 + Client.viewportTempX - (var82.subWidth >> 1), Client.viewportTempY + (var3 - var82.subHeight) - 4);
                        }
                     }
                  }
               }
            }

            if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
               class31.method121(var0, var0.defaultHeight + 15);
               if (Client.viewportTempX > -1) {
                  WorldMapSectionType.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
               }
            }
         }

         for(int var101 = 0; var101 < 4; ++var101) {
            int var84 = var0.hitSplatCycles[var101];
            int var102 = var0.hitSplatTypes[var101];
            HitSplatDefinition var97 = null;
            int var104 = 0;
            if (var102 >= 0) {
               if (var84 <= Client.cycle) {
                  continue;
               }

               var97 = ChatChannel.method446(var0.hitSplatTypes[var101]);
               var104 = var97.field1655;
               if (var97 != null && var97.transforms != null) {
                  var97 = var97.transform();
                  if (var97 == null) {
                     var0.hitSplatCycles[var101] = -1;
                     continue;
                  }
               }
            } else if (var84 < 0) {
               continue;
            }

            var15 = var0.hitSplatTypes2[var101];
            HitSplatDefinition var105 = null;
            if (var15 >= 0) {
               var105 = ChatChannel.method446(var15);
               if (var105 != null && var105.transforms != null) {
                  var105 = var105.transform();
               }
            }

            if (var84 - var104 <= Client.cycle) {
               if (var97 == null) {
                  var0.hitSplatCycles[var101] = -1;
               } else {
                  class31.method121(var0, var0.defaultHeight / 2);
                  if (Client.viewportTempX > -1) {
                     boolean var98 = true;
                     if (var101 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if (var101 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if (var101 == 3) {
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
                     var85 = var97.method1007();
                     int var43;
                     if (var85 != null) {
                        var22 = var85.subWidth;
                        var43 = var85.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var85.xOffset;
                     }

                     var86 = var97.method1009();
                     if (var86 != null) {
                        var23 = var86.subWidth;
                        var43 = var86.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var86.xOffset;
                     }

                     var87 = var97.method1011();
                     if (var87 != null) {
                        var24 = var87.subWidth;
                        var43 = var87.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var87.xOffset;
                     }

                     var88 = var97.method1006();
                     if (var88 != null) {
                        var25 = var88.subWidth;
                        var43 = var88.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var88.xOffset;
                     }

                     if (var105 != null) {
                        var30 = var105.method1007();
                        if (var30 != null) {
                           var34 = var30.subWidth;
                           var43 = var30.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.xOffset;
                        }

                        var31 = var105.method1009();
                        if (var31 != null) {
                           var35 = var31.subWidth;
                           var43 = var31.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.xOffset;
                        }

                        var32 = var105.method1011();
                        if (var32 != null) {
                           var36 = var32.subWidth;
                           var43 = var32.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.xOffset;
                        }

                        var33 = var105.method1006();
                        if (var33 != null) {
                           var37 = var33.subWidth;
                           var43 = var33.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.xOffset;
                        }
                     }

                     Font var89 = var97.getFont();
                     if (var89 == null) {
                        var89 = class276.fontPlain11;
                     }

                     Font var44;
                     if (var105 != null) {
                        var44 = var105.getFont();
                        if (var44 == null) {
                           var44 = class276.fontPlain11;
                        }
                     } else {
                        var44 = class276.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var97.getString(var0.hitSplatValues[var101]);
                     int var100 = var89.stringWidth(var45);
                     if (var105 != null) {
                        var46 = var105.getString(var0.hitSplatValues2[var101]);
                        var48 = var44.stringWidth(var46);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if (var23 > 0) {
                        if (var87 == null && var88 == null) {
                           var49 = 1;
                        } else {
                           var49 = var100 / var23 + 1;
                        }
                     }

                     if (var105 != null && var35 > 0) {
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
                        var55 += (var56 - var100) / 2;
                     } else {
                        var51 += var100;
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
                     if (var105 != null) {
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

                     var62 = var0.hitSplatCycles[var101] - Client.cycle;
                     int var63 = var97.field1654 - var62 * var97.field1654 / var97.field1655;
                     int var64 = var62 * var97.field1661 / var97.field1655 + -var97.field1661;
                     int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
                     int var66 = var64 + (var3 + Client.viewportTempY - 12);
                     int var67 = var66;
                     int var68 = var66 + var42;
                     int var69 = var66 + var97.field1659 + 15;
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
                     if (var105 != null) {
                        var72 = var66 + var105.field1659 + 15;
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
                     if (var97.field1656 >= 0) {
                        var73 = (var62 << 8) / (var97.field1655 - var97.field1656);
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
                              var86.drawTransAt(var23 * var74 + (var65 + var54 - var27), var66, var73);
                           }
                        }

                        if (var88 != null) {
                           var88.drawTransAt(var56 + var65 - var29, var66, var73);
                        }

                        var89.drawAlpha(var45, var65 + var55, var69, var97.textColor, 0, var73);
                        if (var105 != null) {
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

                           var44.drawAlpha(var46, var65 + var61, var72, var105.textColor, 0, var73);
                        }
                     } else {
                        if (var85 != null) {
                           var85.drawTransBgAt(var52 + var65 - var26, var66);
                        }

                        if (var87 != null) {
                           var87.drawTransBgAt(var53 + var65 - var28, var66);
                        }

                        if (var86 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var86.drawTransBgAt(var23 * var74 + (var65 + var54 - var27), var66);
                           }
                        }

                        if (var88 != null) {
                           var88.drawTransBgAt(var65 + var56 - var29, var66);
                        }

                        var89.draw(var45, var65 + var55, var69, var97.textColor | -16777216, 0);
                        if (var105 != null) {
                           if (var30 != null) {
                              var30.drawTransBgAt(var57 + var65 - var38, var66);
                           }

                           if (var32 != null) {
                              var32.drawTransBgAt(var65 + var58 - var40, var66);
                           }

                           if (var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawTransBgAt(var74 * var35 + (var59 + var65 - var39), var66);
                              }
                           }

                           if (var33 != null) {
                              var33.drawTransBgAt(var60 + var65 - var41, var66);
                           }

                           var44.draw(var46, var61 + var65, var72, var105.textColor | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
           descriptor = "([Lkz;IIIZI)V",
           garbageValue = "2029451863"
   )
   static void resizeInterface(Widget[] var0, int var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < var0.length; ++var5) {
         Widget var6 = var0[var5];
         if (var6 != null && var6.parentId == var1) {
            Client.alignWidgetSize(var6, var2, var3, var4);
            Client.alignWidgetPosition(var6, var2, var3);
            if (var6.scrollX > var6.scrollWidth - var6.width) {
               var6.scrollX = var6.scrollWidth - var6.width;
            }

            if (var6.scrollX < 0) {
               var6.scrollX = 0;
            }

            if (var6.scrollY > var6.scrollHeight - var6.height) {
               var6.scrollY = var6.scrollHeight - var6.height;
            }

            if (var6.scrollY < 0) {
               var6.scrollY = 0;
            }

            if (var6.type == 0) {
               AbstractWorldMapData.revalidateWidgetScroll(var0, var6, var4);
            }
         }
      }

   }
}
