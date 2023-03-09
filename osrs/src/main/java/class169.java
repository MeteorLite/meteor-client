import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class169 {
   @ObfuscatedName("al")
   static final void method900(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("ax")
   static final void method898(long var0) {
      ViewportMouse.ViewportMouse_entityTags[++ViewportMouse.ViewportMouse_entityCount - 1] = var0;
   }

   @ObfuscatedName("lm")
   @ObfuscatedSignature(
      descriptor = "([Lmy;IIIIIIII)V",
      garbageValue = "-2079694951"
   )
   @Export("updateInterface")
   static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if (var9 != null && var9.parentId == var1 && (var9.method1745() || ParamComposition.getWidgetFlags(var9) != 0 || var9 == Client.clickedWidgetParent)) {
            if (var9.isIf3) {
               if (WallDecoration.isComponentHidden(var9)) {
                  continue;
               }
            } else if (var9.type == 0 && var9 != InvDefinition.mousedOverWidgetIf1 && WallDecoration.isComponentHidden(var9)) {
               continue;
            }

            if (var9.type == 11) {
               if (var9.method1755(class345.urlRequester)) {
                  if (var9.method1772()) {
                     class69.invalidateWidget(var9);
                     class278.revalidateWidgetScroll(var9.children, var9, true);
                  }

                  if (var9.field2955 != null) {
                     ScriptEvent var10 = new ScriptEvent();
                     var10.widget = var9;
                     var10.args = var9.field2955;
                     Client.scriptEvents.addFirst(var10);
                  }
               }
            } else if (var9.type == 12 && var9.method1763()) {
               class69.invalidateWidget(var9);
            }

            int var26 = var9.x + var6;
            int var11 = var7 + var9.y;
            int var12;
            int var13;
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
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

            if (var9 == Client.clickedWidget) {
               Client.field643 = true;
               Client.field445 = var26;
               Client.field541 = var11;
            }

            boolean var34 = false;
            if (var9.field2909) {
               switch(Client.field521) {
               case 0:
                  var34 = true;
               case 1:
               default:
                  break;
               case 2:
                  if (Client.field635 == var9.id >>> 16) {
                     var34 = true;
                  }
                  break;
               case 3:
                  if (var9.id == Client.field635) {
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
                           if (var27.field848) {
                              var27.remove();
                              var27.widget.field2969 = false;
                           }
                        }

                        class123.method679();
                        if (class371.widgetDragDuration == 0) {
                           Client.clickedWidget = null;
                           Client.clickedWidgetParent = null;
                        }

                        if (!Client.isMenuOpen) {
                           ClanMate.addCancelMenuEntry();
                        }
                     }
                  } else if (var9.noScrollThrough && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                     for(var27 = (ScriptEvent)Client.scriptEvents.last(); var27 != null; var27 = (ScriptEvent)Client.scriptEvents.previous()) {
                        if (var27.field848 && var27.widget.onScroll == var27.args) {
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
                     TextureProvider.addSceneMenuOptions(var17, var18, var12, var13);
                  }
               } else if (var9.contentType == 1338) {
                  class110.checkIfMinimapClicked(var9, var26, var11);
               } else {
                  if (var9.contentType == 1400) {
                     WorldMapData_1.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var35, var26, var11, var9.width, var9.height);
                  }

                  if (!Client.isMenuOpen && var35) {
                     if (var9.contentType == 1400) {
                        WorldMapData_1.worldMap.addElementMenuOptions(var26, var11, var9.width, var9.height, var17, var18);
                     } else {
                        Client.method369(var9);
                     }
                  }

                  boolean var21;
                  int var23;
                  if (var34) {
                     for(int var20 = 0; var20 < var9.field2885.length; ++var20) {
                        var21 = false;
                        boolean var22 = false;
                        if (!var21 && var9.field2885[var20] != null) {
                           for(var23 = 0; var23 < var9.field2885[var20].length; ++var23) {
                              boolean var24 = false;
                              if (var9.field2976 != null) {
                                 var24 = Client.keyHandlerInstance.getKeyPressed(var9.field2885[var20][var23]);
                              }

                              if (class150.method788(var9.field2885[var20][var23]) || var24) {
                                 var21 = true;
                                 if (var9.field2976 != null && var9.field2976[var20] > Client.cycle) {
                                    break;
                                 }

                                 byte var25 = var9.field2911[var20][var23];
                                 if (var25 == 0 || ((var25 & 8) == 0 || !Client.keyHandlerInstance.getKeyPressed(86) && !Client.keyHandlerInstance.getKeyPressed(82) && !Client.keyHandlerInstance.getKeyPressed(81)) && ((var25 & 2) == 0 || Client.keyHandlerInstance.getKeyPressed(86)) && ((var25 & 1) == 0 || Client.keyHandlerInstance.getKeyPressed(82)) && ((var25 & 4) == 0 || Client.keyHandlerInstance.getKeyPressed(81))) {
                                    var22 = true;
                                    break;
                                 }
                              }
                           }
                        }

                        if (var22) {
                           if (var20 < 10) {
                              class333.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
                           } else if (var20 == 10) {
                              GameEngine.Widget_runOnTargetLeave();
                              TaskHandler.selectSpell(var9.id, var9.childIndex, WorldMapDecorationType.Widget_unpackTargetMask(ParamComposition.getWidgetFlags(var9)), var9.itemId);
                              Client.field583 = Archive.Widget_getSpellActionName(var9);
                              if (Client.field583 == null) {
                                 Client.field583 = "null";
                              }

                              Client.field518 = var9.dataText + Canvas.colorStartTag(16777215);
                           }

                           var23 = var9.field2893[var20];
                           if (var9.field2976 == null) {
                              var9.field2976 = new int[var9.field2885.length];
                           }

                           if (var9.field2913 == null) {
                              var9.field2913 = new int[var9.field2885.length];
                           }

                           if (var23 != 0) {
                              if (var9.field2976[var20] == 0) {
                                 var9.field2976[var20] = var23 + Client.cycle + var9.field2913[var20];
                              } else {
                                 var9.field2976[var20] = var23 + Client.cycle;
                              }
                           } else {
                              var9.field2976[var20] = Integer.MAX_VALUE;
                           }
                        }

                        if (!var21 && var9.field2976 != null) {
                           var9.field2976[var20] = 0;
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
                     if ((MouseHandler.MouseHandler_currentButton == 1 || !class319.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var35) {
                        var36 = true;
                     }

                     var21 = false;
                     if ((MouseHandler.MouseHandler_lastButton == 1 || !class319.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
                        var21 = true;
                     }

                     if (var21) {
                        AbstractWorldMapData.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var26, MouseHandler.MouseHandler_lastPressedY - var11);
                     }

                     if (var9.method1746()) {
                        if (var21) {
                           Client.field565.addFirst(new class207(0, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
                        }

                        if (var36) {
                           Client.field565.addFirst(new class207(1, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
                        }
                     }

                     if (var9.contentType == 1400) {
                        WorldMapData_1.worldMap.method2252(var17, var18, var35 & var36, var35 & var21);
                     }

                     if (Client.clickedWidget != null && var9 != Client.clickedWidget && var35 && ZoneOperation.method1542(ParamComposition.getWidgetFlags(var9))) {
                        Client.draggedOnWidget = var9;
                     }

                     if (var9 == Client.clickedWidgetParent) {
                        Client.field536 = true;
                        Client.field537 = var26;
                        Client.field470 = var11;
                     }

                     if (var9.hasListener) {
                        ScriptEvent var28;
                        if (var35 && Client.mouseWheelRotation != 0 && var9.onScroll != null) {
                           var28 = new ScriptEvent();
                           var28.field848 = true;
                           var28.widget = var9;
                           var28.mouseY = Client.mouseWheelRotation;
                           var28.args = var9.onScroll;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.clickedWidget != null || Client.isMenuOpen) {
                           var21 = false;
                           var36 = false;
                           var35 = false;
                        }

                        if (!var9.field2970 && var21) {
                           var9.field2970 = true;
                           if (var9.onClick != null) {
                              var28 = new ScriptEvent();
                              var28.field848 = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_lastPressedX - var26;
                              var28.mouseY = MouseHandler.MouseHandler_lastPressedY - var11;
                              var28.args = var9.onClick;
                              Client.scriptEvents.addFirst(var28);
                           }
                        }

                        if (var9.field2970 && var36 && var9.onClickRepeat != null) {
                           var28 = new ScriptEvent();
                           var28.field848 = true;
                           var28.widget = var9;
                           var28.mouseX = MouseHandler.MouseHandler_x - var26;
                           var28.mouseY = MouseHandler.MouseHandler_y - var11;
                           var28.args = var9.onClickRepeat;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (var9.field2970 && !var36) {
                           var9.field2970 = false;
                           if (var9.onRelease != null) {
                              var28 = new ScriptEvent();
                              var28.field848 = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_x - var26;
                              var28.mouseY = MouseHandler.MouseHandler_y - var11;
                              var28.args = var9.onRelease;
                              Client.field403.addFirst(var28);
                           }
                        }

                        if (var36 && var9.onHold != null) {
                           var28 = new ScriptEvent();
                           var28.field848 = true;
                           var28.widget = var9;
                           var28.mouseX = MouseHandler.MouseHandler_x - var26;
                           var28.mouseY = MouseHandler.MouseHandler_y - var11;
                           var28.args = var9.onHold;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (!var9.field2969 && var35) {
                           var9.field2969 = true;
                           if (var9.onMouseOver != null) {
                              var28 = new ScriptEvent();
                              var28.field848 = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_x - var26;
                              var28.mouseY = MouseHandler.MouseHandler_y - var11;
                              var28.args = var9.onMouseOver;
                              Client.scriptEvents.addFirst(var28);
                           }
                        }

                        if (var9.field2969 && var35 && var9.onMouseRepeat != null) {
                           var28 = new ScriptEvent();
                           var28.field848 = true;
                           var28.widget = var9;
                           var28.mouseX = MouseHandler.MouseHandler_x - var26;
                           var28.mouseY = MouseHandler.MouseHandler_y - var11;
                           var28.args = var9.onMouseRepeat;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (var9.field2969 && !var35) {
                           var9.field2969 = false;
                           if (var9.onMouseLeave != null) {
                              var28 = new ScriptEvent();
                              var28.field848 = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_x - var26;
                              var28.mouseY = MouseHandler.MouseHandler_y - var11;
                              var28.args = var9.onMouseLeave;
                              Client.field403.addFirst(var28);
                           }
                        }

                        if (var9.onTimer != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onTimer;
                           Client.field563.addFirst(var28);
                        }

                        ScriptEvent var29;
                        int var37;
                        int var38;
                        if (var9.onVarTransmit != null && Client.changedVarpCount > var9.field2857) {
                           if (var9.varTransmitTriggers != null && Client.changedVarpCount - var9.field2857 <= 32) {
                              label647:
                              for(var37 = var9.field2857; var37 < Client.changedVarpCount; ++var37) {
                                 var23 = Client.changedVarps[var37 & 31];

                                 for(var38 = 0; var38 < var9.varTransmitTriggers.length; ++var38) {
                                    if (var23 == var9.varTransmitTriggers[var38]) {
                                       var29 = new ScriptEvent();
                                       var29.widget = var9;
                                       var29.args = var9.onVarTransmit;
                                       Client.scriptEvents.addFirst(var29);
                                       break label647;
                                    }
                                 }
                              }
                           } else {
                              var28 = new ScriptEvent();
                              var28.widget = var9;
                              var28.args = var9.onVarTransmit;
                              Client.scriptEvents.addFirst(var28);
                           }

                           var9.field2857 = Client.changedVarpCount;
                        }

                        if (var9.onInvTransmit != null && Client.changedItemContainersCount > var9.field2972) {
                           if (var9.invTransmitTriggers != null && Client.changedItemContainersCount - var9.field2972 <= 32) {
                              label623:
                              for(var37 = var9.field2972; var37 < Client.changedItemContainersCount; ++var37) {
                                 var23 = Client.changedItemContainers[var37 & 31];

                                 for(var38 = 0; var38 < var9.invTransmitTriggers.length; ++var38) {
                                    if (var23 == var9.invTransmitTriggers[var38]) {
                                       var29 = new ScriptEvent();
                                       var29.widget = var9;
                                       var29.args = var9.onInvTransmit;
                                       Client.scriptEvents.addFirst(var29);
                                       break label623;
                                    }
                                 }
                              }
                           } else {
                              var28 = new ScriptEvent();
                              var28.widget = var9;
                              var28.args = var9.onInvTransmit;
                              Client.scriptEvents.addFirst(var28);
                           }

                           var9.field2972 = Client.changedItemContainersCount;
                        }

                        if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2904) {
                           if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2904 <= 32) {
                              label599:
                              for(var37 = var9.field2904; var37 < Client.changedSkillsCount; ++var37) {
                                 var23 = Client.changedSkills[var37 & 31];

                                 for(var38 = 0; var38 < var9.statTransmitTriggers.length; ++var38) {
                                    if (var23 == var9.statTransmitTriggers[var38]) {
                                       var29 = new ScriptEvent();
                                       var29.widget = var9;
                                       var29.args = var9.onStatTransmit;
                                       Client.scriptEvents.addFirst(var29);
                                       break label599;
                                    }
                                 }
                              }
                           } else {
                              var28 = new ScriptEvent();
                              var28.widget = var9;
                              var28.args = var9.onStatTransmit;
                              Client.scriptEvents.addFirst(var28);
                           }

                           var9.field2904 = Client.changedSkillsCount;
                        }

                        if (Client.chatCycle > var9.field2932 && var9.onChatTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onChatTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field573 > var9.field2932 && var9.onFriendTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onFriendTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field399 > var9.field2932 && var9.onClanTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onClanTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field555 > var9.field2932 && var9.field2948 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2948;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field357 > var9.field2932 && var9.field2949 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2949;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field516 > var9.field2932 && var9.onStockTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onStockTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field558 > var9.field2932 && var9.field2954 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2954;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field559 > var9.field2932 && var9.onMiscTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onMiscTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        var9.field2932 = Client.cycleCntr;
                        if (var9.onKey != null) {
                           for(var37 = 0; var37 < Client.field586; ++var37) {
                              ScriptEvent var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.keyTyped = Client.field588[var37];
                              var30.keyPressed = Client.field514[var37];
                              var30.args = var9.onKey;
                              Client.scriptEvents.addFirst(var30);
                           }
                        }

                        ScriptEvent var31;
                        int[] var39;
                        if (var9.field2944 != null) {
                           var39 = Client.keyHandlerInstance.method1096();

                           for(var23 = 0; var23 < var39.length; ++var23) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.keyTyped = var39[var23];
                              var31.args = var9.field2944;
                              Client.scriptEvents.addFirst(var31);
                           }
                        }

                        if (var9.field2852 != null) {
                           var39 = Client.keyHandlerInstance.method1094();

                           for(var23 = 0; var23 < var39.length; ++var23) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.keyTyped = var39[var23];
                              var31.args = var9.field2852;
                              Client.scriptEvents.addFirst(var31);
                           }
                        }
                     }
                  }

                  if (!var9.isIf3) {
                     if (Client.clickedWidget != null || Client.isMenuOpen) {
                        continue;
                     }

                     if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        if (var9.mouseOverRedirect >= 0) {
                           InvDefinition.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
                        } else {
                           InvDefinition.mousedOverWidgetIf1 = var9;
                        }
                     }

                     if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        Script.field803 = var9;
                     }

                     if (var9.scrollHeight > var9.height) {
                        InterfaceParent.method463(var9, var26 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
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
                              if (var33.field848) {
                                 var33.remove();
                                 var33.widget.field2969 = false;
                              }
                           }

                           if (class371.widgetDragDuration == 0) {
                              Client.clickedWidget = null;
                              Client.clickedWidgetParent = null;
                           }

                           if (!Client.isMenuOpen) {
                              ClanMate.addCancelMenuEntry();
                           }
                        }

                        AbstractWorldMapData.updateRootInterface(var32.group, var12, var13, var14, var15, var26, var11);
                     }
                  }
               }
            }
         }
      }

   }

   @ObfuscatedName("mb")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1184231221"
   )
   static final void method899() {
      for(int var0 = 0; var0 < Players.Players_count; ++var0) {
         Player var1 = Client.players[Players.Players_indices[var0]];
         var1.clearIsInFriendsChat();
      }

   }
}
