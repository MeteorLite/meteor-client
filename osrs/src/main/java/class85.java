import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ch")
public enum class85 implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lch;"
   )
   field878(0, -1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lch;"
   )
   field874(1, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lch;"
   )
   field875(2, 7),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lch;"
   )
   field881(3, 8),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Lch;"
   )
   field876(4, 9);

   @ObfuscatedName("m")
   @ObfuscatedSignature(
           descriptor = "Lkz;"
   )
   static Widget scriptActiveWidget;
   @ObfuscatedName("j")
   final int field877;
   @ObfuscatedName("i")
   final int field879;

   class85(int var3, int var4) {
      this.field877 = var3;
      this.field879 = var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
           descriptor = "(B)I",
           garbageValue = "3"
   )
   public int rsOrdinal() {
      return this.field879;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lln;Lln;I)Z",
      garbageValue = "-473707369"
   )
   public static boolean method469(AbstractArchive var0, AbstractArchive var1) {
      WorldMapElement.WorldMapElement_archive = var1;
      if (!var0.isFullyLoaded()) {
         return false;
      } else {
         class361.WorldMapElement_count = var0.getGroupFileCount(35);
         GrandExchangeOfferNameComparator.WorldMapElement_cached = new WorldMapElement[class361.WorldMapElement_count];

         for(int var2 = 0; var2 < class361.WorldMapElement_count; ++var2) {
            byte[] var3 = var0.takeFile(35, var2);
            GrandExchangeOfferNameComparator.WorldMapElement_cached[var2] = new WorldMapElement(var2);
            if (var3 != null) {
               GrandExchangeOfferNameComparator.WorldMapElement_cached[var2].decode(new Buffer(var3));
               GrandExchangeOfferNameComparator.WorldMapElement_cached[var2].method922();
            }
         }

         return true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
           descriptor = "(II)Lge;",
           garbageValue = "-224639764"
   )
   public static SequenceDefinition SequenceDefinition_get(int var0) {
      SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = SequenceDefinition.SequenceDefinition_archive.takeFile(12, var0);
         var1 = new SequenceDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         SequenceDefinition.SequenceDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lru;I)V",
      garbageValue = "2050951825"
   )
   static final void method466(PacketBuffer var0) {
      int var1 = 0;
      var0.importIndex();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < Players.Players_count; ++var2) {
         var3 = Players.Players_indices[var2];
         if ((Players.activityFlags[var3] & 1) == 0) {
            if (var1 > 0) {
               --var1;
               Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
            } else {
               var4 = var0.readBits(1);
               if (var4 == 0) {
                  var1 = ArchiveLoader.method452(var0);
                  Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
               } else {
                  class137.readPlayerUpdate(var0, var3);
               }
            }
         }
      }

      var0.exportIndex();
      if (var1 != 0) {
         throw new RuntimeException();
      } else {
         var0.importIndex();

         for(var2 = 0; var2 < Players.Players_count; ++var2) {
            var3 = Players.Players_indices[var2];
            if ((Players.activityFlags[var3] & 1) != 0) {
               if (var1 > 0) {
                  --var1;
                  Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
               } else {
                  var4 = var0.readBits(1);
                  if (var4 == 0) {
                     var1 = ArchiveLoader.method452(var0);
                     Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                  } else {
                     class137.readPlayerUpdate(var0, var3);
                  }
               }
            }
         }

         var0.exportIndex();
         if (var1 != 0) {
            throw new RuntimeException();
         } else {
            var0.importIndex();

            for(var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
               var3 = Players.Players_emptyIndices[var2];
               if ((Players.activityFlags[var3] & 1) != 0) {
                  if (var1 > 0) {
                     --var1;
                     Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                  } else {
                     var4 = var0.readBits(1);
                     if (var4 == 0) {
                        var1 = ArchiveLoader.method452(var0);
                        Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                     } else if (class285.updateExternalPlayer(var0, var3)) {
                        Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                     }
                  }
               }
            }

            var0.exportIndex();
            if (var1 != 0) {
               throw new RuntimeException();
            } else {
               var0.importIndex();

               for(var2 = 0; var2 < Players.Players_emptyIdxCount; ++var2) {
                  var3 = Players.Players_emptyIndices[var2];
                  if ((Players.activityFlags[var3] & 1) == 0) {
                     if (var1 > 0) {
                        --var1;
                        Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                     } else {
                        var4 = var0.readBits(1);
                        if (var4 == 0) {
                           var1 = ArchiveLoader.method452(var0);
                           Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                        } else if (class285.updateExternalPlayer(var0, var3)) {
                           Players.activityFlags[var3] = (byte)(Players.activityFlags[var3] | 2);
                        }
                     }
                  }
               }

               var0.exportIndex();
               if (var1 != 0) {
                  throw new RuntimeException();
               } else {
                  Players.Players_count = 0;
                  Players.Players_emptyIdxCount = 0;

                  for(var2 = 1; var2 < 2048; ++var2) {
                     Players.activityFlags[var2] = (byte)(Players.activityFlags[var2] >> 1);
                     Player var5 = Client.players[var2];
                     if (var5 != null) {
                        Players.Players_indices[++Players.Players_count - 1] = var2;
                     } else {
                        Players.Players_emptyIndices[++Players.Players_emptyIdxCount - 1] = var2;
                     }
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1902403336"
   )
   public static void method471() {
      WorldMapElement.WorldMapElement_cachedSprites.clear();
   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
           descriptor = "([Lkz;IIIIIIII)V",
           garbageValue = "1937534206"
   )
   static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if (var9 != null && var9.parentId == var1 && (var9.method1734() || class173.getWidgetFlags(var9) != 0 || var9 == Client.clickedWidgetParent)) {
            if (var9.isIf3) {
               if (class160.isComponentHidden(var9)) {
                  continue;
               }
            } else if (var9.type == 0 && var9 != KeyHandler.mousedOverWidgetIf1 && class160.isComponentHidden(var9)) {
               continue;
            }

            if (var9.type == 11) {
               if (var9.method1742(class245.urlRequester)) {
                  if (var9.method1759()) {
                     LoginScreenAnimation.invalidateWidget(var9);
                     AbstractWorldMapData.revalidateWidgetScroll(var9.children, var9, true);
                  }

                  if (var9.field2984 != null) {
                     ScriptEvent var10 = new ScriptEvent();
                     var10.widget = var9;
                     var10.args = var9.field2984;
                     Client.scriptEvents.addFirst(var10);
                  }
               }
            } else if (var9.type == 12 && var9.method1758()) {
               LoginScreenAnimation.invalidateWidget(var9);
            }

            int var26 = var9.x + var6;
            int var11 = var7 + var9.y;
            int var12;
            int var13;
            int var14;
            int var15;
            int var17;
            int var18;
            if (var9.type == 2) {
               var12 = var2;
               var13 = var3;
               var14 = var4;
               var15 = var5;
            } else {
               int var16;
               if (var9.type == 9) {
                  var16 = var26;
                  var17 = var11;
                  var18 = var26 + var9.width;
                  int var19 = var11 + var9.height;
                  if (var18 < var26) {
                     var16 = var18;
                     var18 = var26;
                  }

                  if (var19 < var11) {
                     var17 = var19;
                     var19 = var11;
                  }

                  ++var18;
                  ++var19;
                  var12 = var16 > var2 ? var16 : var2;
                  var13 = var17 > var3 ? var17 : var3;
                  var14 = var18 < var4 ? var18 : var4;
                  var15 = var19 < var5 ? var19 : var5;
               } else {
                  var16 = var26 + var9.width;
                  var17 = var11 + var9.height;
                  var12 = var26 > var2 ? var26 : var2;
                  var13 = var11 > var3 ? var11 : var3;
                  var14 = var16 < var4 ? var16 : var4;
                  var15 = var17 < var5 ? var17 : var5;
               }
            }

            if (var9 == Client.clickedWidget) {
               Client.field563 = true;
               Client.field601 = var26;
               Client.field422 = var11;
            }

            boolean var34 = false;
            if (var9.field2936) {
               switch(Client.field662) {
               case 0:
                  var34 = true;
               case 1:
               default:
                  break;
               case 2:
                  if (Client.field545 == var9.id >>> 16) {
                     var34 = true;
                  }
                  break;
               case 3:
                  if (var9.id == Client.field545) {
                     var34 = true;
                  }
               }
            }

            if (var34 || !var9.isIf3 || var12 < var14 && var13 < var15) {
               if (var9.isIf3) {
                  ScriptEvent var27;
                  if (var9.noClickThrough) {
                     if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        for(var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
                           if (var27.isMouseInputEvent) {
                              var27.remove();
                              var27.widget.containsMouse = false;
                           }
                        }

                        class308.method1722();
                        if (class27.widgetDragDuration == 0) {
                           Client.clickedWidget = null;
                           Client.clickedWidgetParent = null;
                        }

                        if (!Client.isMenuOpen) {
                           class174.addCancelMenuEntry();
                        }
                     }
                  } else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                     for(var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
                        if (var27.isMouseInputEvent && var27.widget.onScroll == var27.args) {
                           var27.remove();
                        }
                     }
                  }
               }

               var17 = MouseHandler.MouseHandler_x;
               var18 = MouseHandler.MouseHandler_y;
               if (MouseHandler.MouseHandler_lastButton != 0) {
                  var17 = MouseHandler.MouseHandler_lastPressedX;
                  var18 = MouseHandler.MouseHandler_lastPressedY;
               }

               boolean var35 = var17 >= var12 && var18 >= var13 && var17 < var14 && var18 < var15;
               if (var9.contentType == 1337) {
                  if (!Client.isLoading && !Client.isMenuOpen && var35) {
                     MouseRecorder.addSceneMenuOptions(var17, var18, var12, var13);
                  }
               } else if (var9.contentType == 1338) {
                  Frames.checkIfMinimapClicked(var9, var26, var11);
               } else {
                  if (var9.contentType == 1400) {
                     GrandExchangeOfferUnitPriceComparator.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var35, var26, var11, var9.width, var9.height);
                  }

                  if (!Client.isMenuOpen && var35) {
                     if (var9.contentType == 1400) {
                        GrandExchangeOfferUnitPriceComparator.worldMap.addElementMenuOptions(var26, var11, var9.width, var9.height, var17, var18);
                     } else {
                        class103.Widget_addToMenu(var9, var17 - var26, var18 - var11);
                     }
                  }

                  boolean var21;
                  int var23;
                  if (var34) {
                     for(int var20 = 0; var20 < var9.field2937.length; ++var20) {
                        var21 = false;
                        boolean var22 = false;
                        if (!var21 && var9.field2937[var20] != null) {
                           for(var23 = 0; var23 < var9.field2937[var20].length; ++var23) {
                              boolean var24 = false;
                              if (var9.field2900 != null) {
                                 var24 = Client.keyHandlerInstance.getKeyPressed(var9.field2937[var20][var23]);
                              }

                              if (EnumComposition.method947(var9.field2937[var20][var23]) || var24) {
                                 var21 = true;
                                 if (var9.field2900 != null && var9.field2900[var20] > Client.cycle) {
                                    break;
                                 }

                                 byte var25 = var9.field2938[var20][var23];
                                 if (var25 == 0 || ((var25 & 8) == 0 || !Client.keyHandlerInstance.getKeyPressed(86) && !Client.keyHandlerInstance.getKeyPressed(82) && !Client.keyHandlerInstance.getKeyPressed(81)) && ((var25 & 2) == 0 || Client.keyHandlerInstance.getKeyPressed(86)) && ((var25 & 1) == 0 || Client.keyHandlerInstance.getKeyPressed(82)) && ((var25 & 4) == 0 || Client.keyHandlerInstance.getKeyPressed(81))) {
                                    var22 = true;
                                    break;
                                 }
                              }
                           }
                        }

                        if (var22) {
                           if (var20 < 10) {
                              class16.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
                           } else if (var20 == 10) {
                              class18.Widget_runOnTargetLeave();
                              ClanChannel.selectSpell(var9.id, var9.childIndex, MenuAction.Widget_unpackTargetMask(class173.getWidgetFlags(var9)), var9.itemId);
                              Client.selectedSpellActionName = class317.Widget_getSpellActionName(var9);
                              if (Client.selectedSpellActionName == null) {
                                 Client.selectedSpellActionName = "null";
                              }

                              Client.selectedSpellName = var9.dataText + class149.colorStartTag(16777215);
                           }

                           var23 = var9.field2939[var20];
                           if (var9.field2900 == null) {
                              var9.field2900 = new int[var9.field2937.length];
                           }

                           if (var9.field2940 == null) {
                              var9.field2940 = new int[var9.field2937.length];
                           }

                           if (var23 != 0) {
                              if (var9.field2900[var20] == 0) {
                                 var9.field2900[var20] = var23 + Client.cycle + var9.field2940[var20];
                              } else {
                                 var9.field2900[var20] = var23 + Client.cycle;
                              }
                           } else {
                              var9.field2900[var20] = Integer.MAX_VALUE;
                           }
                        }

                        if (!var21 && var9.field2900 != null) {
                           var9.field2900[var20] = 0;
                        }
                     }
                  }

                  if (var9.isIf3) {
                     if (MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        var35 = true;
                     } else {
                        var35 = false;
                     }

                     boolean var36 = false;
                     if ((MouseHandler.MouseHandler_currentButton == 1 || !ClanMate.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var35) {
                        var36 = true;
                     }

                     var21 = false;
                     if ((MouseHandler.MouseHandler_lastButton == 1 || !ClanMate.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
                        var21 = true;
                     }

                     if (var21) {
                        UserComparator9.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var26, MouseHandler.MouseHandler_lastPressedY - var11);
                     }

                     if (var9.method1735()) {
                        if (var21) {
                           Client.field587.addFirst(new class204(0, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
                        }

                        if (var36) {
                           Client.field587.addFirst(new class204(1, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
                        }
                     }

                     if (var9.contentType == 1400) {
                        GrandExchangeOfferUnitPriceComparator.worldMap.method2235(var17, var18, var35 & var36, var35 & var21);
                     }

                     if (Client.clickedWidget != null && var9 != Client.clickedWidget && var35 && AbstractArchive.method1837(class173.getWidgetFlags(var9))) {
                        Client.draggedOnWidget = var9;
                     }

                     if (var9 == Client.clickedWidgetParent) {
                        Client.field560 = true;
                        Client.field659 = var26;
                        Client.field667 = var11;
                     }

                     if (var9.hasListener) {
                        ScriptEvent var28;
                        if (var35 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
                           var28 = new ScriptEvent();
                           var28.isMouseInputEvent = true;
                           var28.widget = var9;
                           var28.mouseY = Client.mouseWheelRotation;
                           var28.args = var9.onScroll;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.clickedWidget != null || WorldMapLabelSize.dragInventoryWidget != null || Client.isMenuOpen) {
                           var21 = false;
                           var36 = false;
                           var35 = false;
                        }

                        if (!var9.field2979 && var21) {
                           var9.field2979 = true;
                           if (var9.onClick != null) {
                              var28 = new ScriptEvent();
                              var28.isMouseInputEvent = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_lastPressedX - var26;
                              var28.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
                              var28.args = var9.onClick;
                              Client.scriptEvents.addFirst(var28);
                           }
                        }

                        if (var9.field2979 && var36 && var9.onClickRepeat != null) {
                           var28 = new ScriptEvent();
                           var28.isMouseInputEvent = true;
                           var28.widget = var9;
                           var28.mouseX = MouseHandler.MouseHandler_x - var26;
                           var28.mouseY = MouseHandler.MouseHandler_y - var11;
                           var28.args = var9.onClickRepeat;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (var9.field2979 && !var36) {
                           var9.field2979 = false;
                           if (var9.onRelease != null) {
                              var28 = new ScriptEvent();
                              var28.isMouseInputEvent = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_x - var26;
                              var28.mouseY = MouseHandler.MouseHandler_y - var11;
                              var28.args = var9.onRelease;
                              Client.field586.addFirst(var28);
                           }
                        }

                        if (var36 && var9.onHold != null) {
                           var28 = new ScriptEvent();
                           var28.isMouseInputEvent = true;
                           var28.widget = var9;
                           var28.mouseX = MouseHandler.MouseHandler_x - var26;
                           var28.mouseY = MouseHandler.MouseHandler_y - var11;
                           var28.args = var9.onHold;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (!var9.containsMouse && var35) {
                           var9.containsMouse = true;
                           if (var9.onMouseOver != null) {
                              var28 = new ScriptEvent();
                              var28.isMouseInputEvent = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_x - var26;
                              var28.mouseY = MouseHandler.MouseHandler_y - var11;
                              var28.args = var9.onMouseOver;
                              Client.scriptEvents.addFirst(var28);
                           }
                        }

                        if (var9.containsMouse && var35 && var9.onMouseRepeat != null) {
                           var28 = new ScriptEvent();
                           var28.isMouseInputEvent = true;
                           var28.widget = var9;
                           var28.mouseX = MouseHandler.MouseHandler_x - var26;
                           var28.mouseY = MouseHandler.MouseHandler_y - var11;
                           var28.args = var9.onMouseRepeat;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (var9.containsMouse && !var35) {
                           var9.containsMouse = false;
                           if (var9.onMouseLeave != null) {
                              var28 = new ScriptEvent();
                              var28.isMouseInputEvent = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_x - var26;
                              var28.mouseY = MouseHandler.MouseHandler_y - var11;
                              var28.args = var9.onMouseLeave;
                              Client.field586.addFirst(var28);
                           }
                        }

                        if (var9.onTimer != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onTimer;
                           Client.field632.addFirst(var28);
                        }

                        ScriptEvent var29;
                        int var37;
                        int var38;
                        if (var9.onVarTransmit != null && Client.changedVarpCount > var9.field3001) {
                           if (var9.varTransmitTriggers != null && Client.changedVarpCount - var9.field3001 <= 32) {
                              label654:
                              for(var37 = var9.field3001; var37 < Client.changedVarpCount; ++var37) {
                                 var23 = Client.changedVarps[var37 & 31];

                                 for(var38 = 0; var38 < var9.varTransmitTriggers.length; ++var38) {
                                    if (var23 == var9.varTransmitTriggers[var38]) {
                                       var29 = new ScriptEvent();
                                       var29.widget = var9;
                                       var29.args = var9.onVarTransmit;
                                       Client.scriptEvents.addFirst(var29);
                                       break label654;
                                    }
                                 }
                              }
                           } else {
                              var28 = new ScriptEvent();
                              var28.widget = var9;
                              var28.args = var9.onVarTransmit;
                              Client.scriptEvents.addFirst(var28);
                           }

                           var9.field3001 = Client.changedVarpCount;
                        }

                        if (var9.onInvTransmit != null && Client.changedItemContainersCount > var9.field3002) {
                           if (var9.invTransmitTriggers != null && Client.changedItemContainersCount - var9.field3002 <= 32) {
                              label630:
                              for(var37 = var9.field3002; var37 < Client.changedItemContainersCount; ++var37) {
                                 var23 = Client.changedItemContainers[var37 & 31];

                                 for(var38 = 0; var38 < var9.invTransmitTriggers.length; ++var38) {
                                    if (var23 == var9.invTransmitTriggers[var38]) {
                                       var29 = new ScriptEvent();
                                       var29.widget = var9;
                                       var29.args = var9.onInvTransmit;
                                       Client.scriptEvents.addFirst(var29);
                                       break label630;
                                    }
                                 }
                              }
                           } else {
                              var28 = new ScriptEvent();
                              var28.widget = var9;
                              var28.args = var9.onInvTransmit;
                              Client.scriptEvents.addFirst(var28);
                           }

                           var9.field3002 = Client.changedItemContainersCount;
                        }

                        if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field3003) {
                           if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field3003 <= 32) {
                              label606:
                              for(var37 = var9.field3003; var37 < Client.changedSkillsCount; ++var37) {
                                 var23 = Client.changedSkills[var37 & 31];

                                 for(var38 = 0; var38 < var9.statTransmitTriggers.length; ++var38) {
                                    if (var23 == var9.statTransmitTriggers[var38]) {
                                       var29 = new ScriptEvent();
                                       var29.widget = var9;
                                       var29.args = var9.onStatTransmit;
                                       Client.scriptEvents.addFirst(var29);
                                       break label606;
                                    }
                                 }
                              }
                           } else {
                              var28 = new ScriptEvent();
                              var28.widget = var9;
                              var28.args = var9.onStatTransmit;
                              Client.scriptEvents.addFirst(var28);
                           }

                           var9.field3003 = Client.changedSkillsCount;
                        }

                        if (Client.chatCycle > var9.field3000 && var9.onChatTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onChatTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field577 > var9.field3000 && var9.onFriendTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onFriendTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field505 > var9.field3000 && var9.onClanTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onClanTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field562 > var9.field3000 && var9.field2977 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2977;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field561 > var9.field3000 && var9.field2978 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2978;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field580 > var9.field3000 && var9.onStockTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onStockTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field668 > var9.field3000 && var9.field2983 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2983;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field625 > var9.field3000 && var9.onMiscTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onMiscTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        var9.field3000 = Client.cycleCntr;
                        if (var9.onKey != null) {
                           for(var37 = 0; var37 < Client.field623; ++var37) {
                              ScriptEvent var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.keyTyped = Client.field610[var37];
                              var30.keyPressed = Client.field618[var37];
                              var30.args = var9.onKey;
                              Client.scriptEvents.addFirst(var30);
                           }
                        }

                        ScriptEvent var31;
                        int[] var39;
                        if (var9.field2910 != null) {
                           var39 = Client.keyHandlerInstance.method1090();

                           for(var23 = 0; var23 < var39.length; ++var23) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.keyTyped = var39[var23];
                              var31.args = var9.field2910;
                              Client.scriptEvents.addFirst(var31);
                           }
                        }

                        if (var9.field2974 != null) {
                           var39 = Client.keyHandlerInstance.method1088();

                           for(var23 = 0; var23 < var39.length; ++var23) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.keyTyped = var39[var23];
                              var31.args = var9.field2974;
                              Client.scriptEvents.addFirst(var31);
                           }
                        }
                     }
                  }

                  if (!var9.isIf3) {
                     if (Client.clickedWidget != null || WorldMapLabelSize.dragInventoryWidget != null || Client.isMenuOpen) {
                        continue;
                     }

                     if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        if (var9.mouseOverRedirect >= 0) {
                           KeyHandler.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
                        } else {
                           KeyHandler.mousedOverWidgetIf1 = var9;
                        }
                     }

                     if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        class18.field60 = var9;
                     }

                     if (var9.scrollHeight > var9.height) {
                        World.method382(var9, var26 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
                     }
                  }

                  if (var9.type == 0) {
                     updateInterface(var0, var9.id, var12, var13, var14, var15, var26 - var9.scrollX, var11 - var9.scrollY);
                     if (var9.children != null) {
                        updateInterface(var9.children, var9.id, var12, var13, var14, var15, var26 - var9.scrollX, var11 - var9.scrollY);
                     }

                     InterfaceParent var32 = (InterfaceParent)Client.interfaceParents.get((long)var9.id);
                     if (var32 != null) {
                        if (var32.type == 0 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15 && !Client.isMenuOpen) {
                           for(ScriptEvent var33 = (ScriptEvent)Client.scriptEvents.last(); var33 != null; var33 = (ScriptEvent)Client.scriptEvents.previous()) {
                              if (var33.isMouseInputEvent) {
                                 var33.remove();
                                 var33.widget.containsMouse = false;
                              }
                           }

                           if (class27.widgetDragDuration == 0) {
                              Client.clickedWidget = null;
                              Client.clickedWidgetParent = null;
                           }

                           if (!Client.isMenuOpen) {
                              class174.addCancelMenuEntry();
                           }
                        }

                        class144.updateRootInterface(var32.group, var12, var13, var14, var15, var26, var11);
                     }
                  }
               }
            }
         }
      }

   }
}
