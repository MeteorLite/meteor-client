import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class144 extends class152 {
   @ObfuscatedName("il")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   @Export("mapMarkerSprites")
   static SpritePixels[] mapMarkerSprites;
   @ObfuscatedName("h")
   int field1324;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   final class153 this$0;

   @ObfuscatedSignature(
      descriptor = "(Led;)V"
   )
   class144(class153 var1) {
      this.this$0 = var1;
      this.field1324 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "468341515"
   )
   @Export("vmethod3238")
   void vmethod3238(Buffer var1) {
      this.field1324 = var1.readUnsignedShort();
      var1.readUnsignedByte();
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         var1.readLong();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lfn;I)V",
      garbageValue = "1227548281"
   )
   @Export("vmethod3239")
   void vmethod3239(ClanChannel var1) {
      var1.removeMember(this.field1324);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "-714698284"
   )
   static int method771(String var0) {
      if (var0.equals("centre")) {
         return 1;
      } else {
         return !var0.equals("bottom") && !var0.equals("right") ? 0 : 2;
      }
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZB)I",
      garbageValue = "127"
   )
   static int method770(int var0, Script var1, boolean var2) {
      if (var0 == 5000) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else if (var0 == 5001) {
         class87.Interpreter_intStackSize -= 3;
         Client.publicChatMode = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
         LoginScreenAnimation.privateChatMode = SceneTilePaint.method1286(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
         if (LoginScreenAnimation.privateChatMode == null) {
            LoginScreenAnimation.privateChatMode = PrivateChatMode.field4103;
         }

         Client.tradeChatMode = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
         PacketBufferNode var11 = class136.getPacketBufferNode(ClientPacket.field2469, Client.packetWriter.isaacCipher);
         var11.packetBuffer.writeByte(Client.publicChatMode);
         var11.packetBuffer.writeByte(LoginScreenAnimation.privateChatMode.field4105);
         var11.packetBuffer.writeByte(Client.tradeChatMode);
         Client.packetWriter.addNode(var11);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         PacketBufferNode var6;
         if (var0 == 5002) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            class87.Interpreter_intStackSize -= 2;
            var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
            var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
            var6 = class136.getPacketBufferNode(ClientPacket.field2471, Client.packetWriter.isaacCipher);
            var6.packetBuffer.writeByte(class13.stringCp1252NullTerminatedByteSize(var3) + 2);
            var6.packetBuffer.writeStringCp1252NullTerminated(var3);
            var6.packetBuffer.writeByte(var4 - 1);
            var6.packetBuffer.writeByte(var5);
            Client.packetWriter.addNode(var6);
            return 1;
         } else {
            int var7;
            Message var8;
            if (var0 == 5003) {
               class87.Interpreter_intStackSize -= 2;
               var7 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
               var8 = class130.Messages_getByChannelAndID(var7, var4);
               if (var8 != null) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.count;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.cycle;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               Message var9;
               if (var0 == 5004) {
                  var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var9 = Script.Messages_getMessage(var7);
                  if (var9 != null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var9.type;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var9.cycle;
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 5005) {
                  if (LoginScreenAnimation.privateChatMode == null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = LoginScreenAnimation.privateChatMode.field4105;
                  }

                  return 1;
               } else {
                  PacketBufferNode var12;
                  if (var0 == 5008) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     var12 = class467.method2412(var4, var3, class173.clientLanguage, -1);
                     Client.packetWriter.addNode(var12);
                     return 1;
                  } else if (var0 == 5009) {
                     Interpreter.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                     String var13 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                     var12 = class136.getPacketBufferNode(ClientPacket.field2502, Client.packetWriter.isaacCipher);
                     var12.packetBuffer.writeShort(0);
                     int var10 = var12.packetBuffer.offset;
                     var12.packetBuffer.writeStringCp1252NullTerminated(var3);
                     BufferedSource.method2105(var12.packetBuffer, var13);
                     var12.packetBuffer.writeLengthShort(var12.packetBuffer.offset - var10);
                     Client.packetWriter.addNode(var12);
                     return 1;
                  } else if (var0 == 5010) {
                     var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                     class87.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                     var6 = class467.method2412(var4, var3, class173.clientLanguage, var5);
                     Client.packetWriter.addNode(var6);
                     return 1;
                  } else if (var0 != 5015) {
                     if (var0 == 5016) {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.tradeChatMode;
                        return 1;
                     } else if (var0 == 5017) {
                        var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class137.Messages_getHistorySize(var7);
                        return 1;
                     } else if (var0 == 5018) {
                        var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class313.Messages_getLastChatID(var7);
                        return 1;
                     } else if (var0 == 5019) {
                        var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = DynamicObject.method454(var7);
                        return 1;
                     } else if (var0 == 5020) {
                        var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                        class152.doCheat(var3);
                        return 1;
                     } else if (var0 == 5021) {
                        Client.field589 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize].toLowerCase().trim();
                        return 1;
                     } else if (var0 == 5022) {
                        Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = Client.field589;
                        return 1;
                     } else if (var0 == 5023) {
                        var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                        System.out.println(var3);
                        return 1;
                     } else if (var0 == 5030) {
                        class87.Interpreter_intStackSize -= 2;
                        var7 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                        var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                        var8 = class130.Messages_getByChannelAndID(var7, var4);
                        if (var8 != null) {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.count;
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.cycle;
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                        } else {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if (var0 == 5031) {
                        var7 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                        var9 = Script.Messages_getMessage(var7);
                        if (var9 != null) {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var9.type;
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var9.cycle;
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                        } else {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     if (class155.localPlayer != null && class155.localPlayer.username != null) {
                        var3 = class155.localPlayer.username.getName();
                     } else {
                        var3 = "";
                     }

                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var3;
                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ll")
   @ObfuscatedSignature(
      descriptor = "([Lkd;IIIIIIII)V",
      garbageValue = "-1314248659"
   )
   @Export("updateInterface")
   static final void updateInterface(Widget[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      for(int var8 = 0; var8 < var0.length; ++var8) {
         Widget var9 = var0[var8];
         if (var9 != null && var9.parentId == var1 && (var9.method1749() || Clock.getWidgetFlags(var9) != 0 || var9 == Client.clickedWidgetParent)) {
            if (var9.isIf3) {
               if (FriendSystem.isComponentHidden(var9)) {
                  continue;
               }
            } else if (var9.type == 0 && var9 != WorldMapScaleHandler.mousedOverWidgetIf1 && FriendSystem.isComponentHidden(var9)) {
               continue;
            }

            if (var9.type == 11) {
               if (var9.method1745(TaskHandler.urlRequester)) {
                  if (var9.method1727()) {
                     class69.invalidateWidget(var9);
                     class169.revalidateWidgetScroll(var9.children, var9, true);
                  }

                  if (var9.field2992 != null) {
                     ScriptEvent var10 = new ScriptEvent();
                     var10.widget = var9;
                     var10.args = var9.field2992;
                     Client.scriptEvents.addFirst(var10);
                  }
               }
            } else if (var9.type == 12 && var9.method1742()) {
               class69.invalidateWidget(var9);
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
               Client.field546 = true;
               Client.field364 = var26;
               Client.field548 = var11;
            }

            boolean var34 = false;
            if (var9.field2945) {
               switch(Client.field636) {
               case 0:
                  var34 = true;
               case 1:
               default:
                  break;
               case 2:
                  if (Client.field528 == var9.id >>> 16) {
                     var34 = true;
                  }
                  break;
               case 3:
                  if (var9.id == Client.field528) {
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

                        ClientPacket.method1520();
                        if (class87.widgetDragDuration == 0) {
                           Client.clickedWidget = null;
                           Client.clickedWidgetParent = null;
                        }

                        if (!Client.isMenuOpen) {
                           FriendsChat.addCancelMenuEntry();
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
                     class17.addSceneMenuOptions(var17, var18, var12, var13);
                  }
               } else if (var9.contentType == 1338) {
                  DevicePcmPlayerProvider.checkIfMinimapClicked(var9, var26, var11);
               } else {
                  if (var9.contentType == 1400) {
                     KitDefinition.worldMap.onCycle(MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y, var35, var26, var11, var9.width, var9.height);
                  }

                  if (!Client.isMenuOpen && var35) {
                     if (var9.contentType == 1400) {
                        KitDefinition.worldMap.addElementMenuOptions(var26, var11, var9.width, var9.height, var17, var18);
                     } else {
                        class273.Widget_addToMenu(var9, var17 - var26, var18 - var11);
                     }
                  }

                  boolean var21;
                  int var23;
                  if (var34) {
                     for(int var20 = 0; var20 < var9.field2946.length; ++var20) {
                        var21 = false;
                        boolean var22 = false;
                        if (!var21 && var9.field2946[var20] != null) {
                           for(var23 = 0; var23 < var9.field2946[var20].length; ++var23) {
                              boolean var24 = false;
                              if (var9.field3013 != null) {
                                 var24 = Client.keyHandlerInstance.getKeyPressed(var9.field2946[var20][var23]);
                              }

                              if (class281.method1529(var9.field2946[var20][var23]) || var24) {
                                 var21 = true;
                                 if (var9.field3013 != null && var9.field3013[var20] > Client.cycle) {
                                    break;
                                 }

                                 byte var25 = var9.field2947[var20][var23];
                                 if (var25 == 0 || ((var25 & 8) == 0 || !Client.keyHandlerInstance.getKeyPressed(86) && !Client.keyHandlerInstance.getKeyPressed(82) && !Client.keyHandlerInstance.getKeyPressed(81)) && ((var25 & 2) == 0 || Client.keyHandlerInstance.getKeyPressed(86)) && ((var25 & 1) == 0 || Client.keyHandlerInstance.getKeyPressed(82)) && ((var25 & 4) == 0 || Client.keyHandlerInstance.getKeyPressed(81))) {
                                    var22 = true;
                                    break;
                                 }
                              }
                           }
                        }

                        if (var22) {
                           if (var20 < 10) {
                              ModelData0.widgetDefaultMenuAction(var20 + 1, var9.id, var9.childIndex, var9.itemId, "");
                           } else if (var20 == 10) {
                              Widget.Widget_runOnTargetLeave();
                              class32.selectSpell(var9.id, var9.childIndex, PacketWriter.Widget_unpackTargetMask(Clock.getWidgetFlags(var9)), var9.itemId);
                              Client.selectedSpellActionName = ArchiveLoader.Widget_getSpellActionName(var9);
                              if (Client.selectedSpellActionName == null) {
                                 Client.selectedSpellActionName = "null";
                              }

                              Client.selectedSpellName = var9.dataText + MouseRecorder.colorStartTag(16777215);
                           }

                           var23 = var9.field2954[var20];
                           if (var9.field3013 == null) {
                              var9.field3013 = new int[var9.field2946.length];
                           }

                           if (var9.field2949 == null) {
                              var9.field2949 = new int[var9.field2946.length];
                           }

                           if (var23 != 0) {
                              if (var9.field3013[var20] == 0) {
                                 var9.field3013[var20] = var23 + Client.cycle + var9.field2949[var20];
                              } else {
                                 var9.field3013[var20] = var23 + Client.cycle;
                              }
                           } else {
                              var9.field3013[var20] = Integer.MAX_VALUE;
                           }
                        }

                        if (!var21 && var9.field3013 != null) {
                           var9.field3013[var20] = 0;
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
                     if ((MouseHandler.MouseHandler_currentButton == 1 || !SceneTilePaint.mouseCam && MouseHandler.MouseHandler_currentButton == 4) && var35) {
                        var36 = true;
                     }

                     var21 = false;
                     if ((MouseHandler.MouseHandler_lastButton == 1 || !SceneTilePaint.mouseCam && MouseHandler.MouseHandler_lastButton == 4) && MouseHandler.MouseHandler_lastPressedX >= var12 && MouseHandler.MouseHandler_lastPressedY >= var13 && MouseHandler.MouseHandler_lastPressedX < var14 && MouseHandler.MouseHandler_lastPressedY < var15) {
                        var21 = true;
                     }

                     if (var21) {
                        class18.clickWidget(var9, MouseHandler.MouseHandler_lastPressedX - var26, MouseHandler.MouseHandler_lastPressedY - var11);
                     }

                     if (var9.method1740()) {
                        if (var21) {
                           Client.field572.addFirst(new class200(0, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
                        }

                        if (var36) {
                           Client.field572.addFirst(new class200(1, MouseHandler.MouseHandler_x - var26, MouseHandler.MouseHandler_y - var11, var9));
                        }
                     }

                     if (var9.contentType == 1400) {
                        KitDefinition.worldMap.method2197(var17, var18, var35 & var36, var35 & var21);
                     }

                     if (Client.clickedWidget != null && var9 != Client.clickedWidget && var35 && class136.method740(Clock.getWidgetFlags(var9))) {
                        Client.draggedOnWidget = var9;
                     }

                     if (var9 == Client.clickedWidgetParent) {
                        Client.field590 = true;
                        Client.field544 = var26;
                        Client.field458 = var11;
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

                        if (Client.clickedWidget != null || class368.dragInventoryWidget != null || Client.isMenuOpen) {
                           var21 = false;
                           var36 = false;
                           var35 = false;
                        }

                        if (!var9.field2934 && var21) {
                           var9.field2934 = true;
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

                        if (var9.field2934 && var36 && var9.onClickRepeat != null) {
                           var28 = new ScriptEvent();
                           var28.isMouseInputEvent = true;
                           var28.widget = var9;
                           var28.mouseX = MouseHandler.MouseHandler_x - var26;
                           var28.mouseY = MouseHandler.MouseHandler_y - var11;
                           var28.args = var9.onClickRepeat;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (var9.field2934 && !var36) {
                           var9.field2934 = false;
                           if (var9.onRelease != null) {
                              var28 = new ScriptEvent();
                              var28.isMouseInputEvent = true;
                              var28.widget = var9;
                              var28.mouseX = MouseHandler.MouseHandler_x - var26;
                              var28.mouseY = MouseHandler.MouseHandler_y - var11;
                              var28.args = var9.onRelease;
                              Client.field571.addFirst(var28);
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
                              Client.field571.addFirst(var28);
                           }
                        }

                        if (var9.onTimer != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onTimer;
                           Client.field570.addFirst(var28);
                        }

                        ScriptEvent var29;
                        int var37;
                        int var38;
                        if (var9.onVarTransmit != null && Client.changedVarpCount > var9.field2969) {
                           if (var9.varTransmitTriggers != null && Client.changedVarpCount - var9.field2969 <= 32) {
                              label654:
                              for(var37 = var9.field2969; var37 < Client.changedVarpCount; ++var37) {
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

                           var9.field2969 = Client.changedVarpCount;
                        }

                        if (var9.onInvTransmit != null && Client.changedItemContainersCount > var9.field2990) {
                           if (var9.invTransmitTriggers != null && Client.changedItemContainersCount - var9.field2990 <= 32) {
                              label630:
                              for(var37 = var9.field2990; var37 < Client.changedItemContainersCount; ++var37) {
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

                           var9.field2990 = Client.changedItemContainersCount;
                        }

                        if (var9.onStatTransmit != null && Client.changedSkillsCount > var9.field2961) {
                           if (var9.statTransmitTriggers != null && Client.changedSkillsCount - var9.field2961 <= 32) {
                              label606:
                              for(var37 = var9.field2961; var37 < Client.changedSkillsCount; ++var37) {
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

                           var9.field2961 = Client.changedSkillsCount;
                        }

                        if (Client.chatCycle > var9.field2896 && var9.onChatTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onChatTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field560 > var9.field2896 && var9.onFriendTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onFriendTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field455 > var9.field2896 && var9.onClanTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onClanTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field562 > var9.field2896 && var9.field2878 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2878;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field358 > var9.field2896 && var9.field2985 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2985;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field622 > var9.field2896 && var9.onStockTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onStockTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field565 > var9.field2896 && var9.field2891 != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.field2891;
                           Client.scriptEvents.addFirst(var28);
                        }

                        if (Client.field566 > var9.field2896 && var9.onMiscTransmit != null) {
                           var28 = new ScriptEvent();
                           var28.widget = var9;
                           var28.args = var9.onMiscTransmit;
                           Client.scriptEvents.addFirst(var28);
                        }

                        var9.field2896 = Client.cycleCntr;
                        if (var9.onKey != null) {
                           for(var37 = 0; var37 < Client.field555; ++var37) {
                              ScriptEvent var30 = new ScriptEvent();
                              var30.widget = var9;
                              var30.keyTyped = Client.field596[var37];
                              var30.keyPressed = Client.field619[var37];
                              var30.args = var9.onKey;
                              Client.scriptEvents.addFirst(var30);
                           }
                        }

                        ScriptEvent var31;
                        int[] var39;
                        if (var9.field2980 != null) {
                           var39 = Client.keyHandlerInstance.method1084();

                           for(var23 = 0; var23 < var39.length; ++var23) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.keyTyped = var39[var23];
                              var31.args = var9.field2980;
                              Client.scriptEvents.addFirst(var31);
                           }
                        }

                        if (var9.field2975 != null) {
                           var39 = Client.keyHandlerInstance.method1085();

                           for(var23 = 0; var23 < var39.length; ++var23) {
                              var31 = new ScriptEvent();
                              var31.widget = var9;
                              var31.keyTyped = var39[var23];
                              var31.args = var9.field2975;
                              Client.scriptEvents.addFirst(var31);
                           }
                        }
                     }
                  }

                  if (!var9.isIf3) {
                     if (Client.clickedWidget != null || class368.dragInventoryWidget != null || Client.isMenuOpen) {
                        continue;
                     }

                     if ((var9.mouseOverRedirect >= 0 || var9.mouseOverColor != 0) && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        if (var9.mouseOverRedirect >= 0) {
                           WorldMapScaleHandler.mousedOverWidgetIf1 = var0[var9.mouseOverRedirect];
                        } else {
                           WorldMapScaleHandler.mousedOverWidgetIf1 = var9;
                        }
                     }

                     if (var9.type == 8 && MouseHandler.MouseHandler_x >= var12 && MouseHandler.MouseHandler_y >= var13 && MouseHandler.MouseHandler_x < var14 && MouseHandler.MouseHandler_y < var15) {
                        class380.field3655 = var9;
                     }

                     if (var9.scrollHeight > var9.height) {
                        SoundSystem.method234(var9, var26 + var9.width, var11, var9.height, var9.scrollHeight, MouseHandler.MouseHandler_x, MouseHandler.MouseHandler_y);
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

                           if (class87.widgetDragDuration == 0) {
                              Client.clickedWidget = null;
                              Client.clickedWidgetParent = null;
                           }

                           if (!Client.isMenuOpen) {
                              FriendsChat.addCancelMenuEntry();
                           }
                        }

                        class378.updateRootInterface(var32.group, var12, var13, var14, var15, var26, var11);
                     }
                  }
               }
            }
         }
      }

   }
}
