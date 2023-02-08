import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fw")
@Implements("FileSystem")
public class FileSystem {
   @ObfuscatedName("f")
   static boolean FileSystem_hasPermissions = false;
   @ObfuscatedName("w")
   static File FileSystem_cacheDir;
   @ObfuscatedName("v")
   static Hashtable FileSystem_cacheFiles = new Hashtable(16);

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lkz;I)I",
      garbageValue = "-1394707617"
   )
   static int method895(Widget var0) {
      if (var0.type != 11) {
         --class20.Interpreter_stringStackSize;
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
         return 1;
      } else {
         String var1 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var0.method1740(var1);
         return 1;
      }
   }

   @ObfuscatedName("im")
   @ObfuscatedSignature(
           descriptor = "(IIIIILjava/lang/String;Ljava/lang/String;IIB)V",
           garbageValue = "1"
   )
   static final void menuAction(int var0, int var1, int var2, int var3, int var4, String var5, String var6, int var7, int var8) {
      if (var2 >= 2000) {
         var2 -= 2000;
      }

      PacketBufferNode var9;
      if (var2 == 1) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = Renderable.getPacketBufferNode(ClientPacket.field2524, Client.packetWriter.isaacCipher);
         var9.packetBuffer.method2414(WorldMapLabel.selectedItemWidget);
         var9.packetBuffer.writeShortLE(var0 + ParamComposition.baseX);
         var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShortLE(var3);
         var9.packetBuffer.writeShortLE(WorldMapIcon_0.selectedItemSlot);
         var9.packetBuffer.writeShortLE(class131.selectedItemId);
         var9.packetBuffer.writeShortLEA(Client.baseY + var1);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 2) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = Renderable.getPacketBufferNode(ClientPacket.field2471, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeShortA(Client.baseY + var1);
         var9.packetBuffer.writeShortLEA(Client.selectedSpellItemId);
         var9.packetBuffer.method2414(class9.selectedSpellWidget);
         var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShort(var0 + ParamComposition.baseX);
         var9.packetBuffer.writeShortA(var3);
         var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 3) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = Renderable.getPacketBufferNode(ClientPacket.field2452, Client.packetWriter.isaacCipher);
         var9.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShortLE(var0 + ParamComposition.baseX);
         var9.packetBuffer.writeShortA(var3);
         var9.packetBuffer.writeShort(Client.baseY + var1);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 4) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = Renderable.getPacketBufferNode(ClientPacket.field2470, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeShortLE(var3);
         var9.packetBuffer.writeShortLE(var0 + ParamComposition.baseX);
         var9.packetBuffer.writeShort(Client.baseY + var1);
         var9.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 5) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = Renderable.getPacketBufferNode(ClientPacket.field2446, Client.packetWriter.isaacCipher);
         var9.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShortLEA(Client.baseY + var1);
         var9.packetBuffer.writeShortLE(var0 + ParamComposition.baseX);
         var9.packetBuffer.writeShortA(var3);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 6) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = Renderable.getPacketBufferNode(ClientPacket.field2433, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeShortLE(var0 + ParamComposition.baseX);
         var9.packetBuffer.writeShort(Client.baseY + var1);
         var9.packetBuffer.writeShort(var3);
         var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         Client.packetWriter.addNode(var9);
      } else {
         PacketBufferNode var10;
         NPC var14;
         if (var2 == 7) {
            var14 = Client.npcs[var3];
            if (var14 != null) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var10 = Renderable.getPacketBufferNode(ClientPacket.field2437, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeShortLE(WorldMapIcon_0.selectedItemSlot);
               var10.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.writeShort(class131.selectedItemId);
               var10.packetBuffer.method2382(WorldMapLabel.selectedItemWidget);
               var10.packetBuffer.writeShortA(var3);
               Client.packetWriter.addNode(var10);
            }
         } else if (var2 == 8) {
            var14 = Client.npcs[var3];
            if (var14 != null) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var10 = Renderable.getPacketBufferNode(ClientPacket.field2536, Client.packetWriter.isaacCipher);
               var10.packetBuffer.method2414(class9.selectedSpellWidget);
               var10.packetBuffer.writeShortA(Client.selectedSpellChildIndex);
               var10.packetBuffer.writeShortLE(Client.selectedSpellItemId);
               var10.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.writeShortLE(var3);
               Client.packetWriter.addNode(var10);
            }
         } else if (var2 == 9) {
            var14 = Client.npcs[var3];
            if (var14 != null) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var10 = Renderable.getPacketBufferNode(ClientPacket.field2513, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.writeShortLE(var3);
               Client.packetWriter.addNode(var10);
            }
         } else if (var2 == 10) {
            var14 = Client.npcs[var3];
            if (var14 != null) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var10 = Renderable.getPacketBufferNode(ClientPacket.field2488, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.writeShortLEA(var3);
               Client.packetWriter.addNode(var10);
            }
         } else if (var2 == 11) {
            var14 = Client.npcs[var3];
            if (var14 != null) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var10 = Renderable.getPacketBufferNode(ClientPacket.field2499, Client.packetWriter.isaacCipher);
               var10.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.writeShort(var3);
               Client.packetWriter.addNode(var10);
            }
         } else if (var2 == 12) {
            var14 = Client.npcs[var3];
            if (var14 != null) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var10 = Renderable.getPacketBufferNode(ClientPacket.field2445, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.writeShortA(var3);
               Client.packetWriter.addNode(var10);
            }
         } else if (var2 == 13) {
            var14 = Client.npcs[var3];
            if (var14 != null) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var10 = Renderable.getPacketBufferNode(ClientPacket.field2492, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeShortLE(var3);
               var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               Client.packetWriter.addNode(var10);
            }
         } else {
            Player var16;
            if (var2 == 14) {
               var16 = Client.players[var3];
               if (var16 != null) {
                  Client.mouseCrossX = var7;
                  Client.mouseCrossY = var8;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var10 = Renderable.getPacketBufferNode(ClientPacket.field2476, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeShortLEA(var3);
                  var10.packetBuffer.writeShort(class131.selectedItemId);
                  var10.packetBuffer.method2441(WorldMapLabel.selectedItemWidget);
                  var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                  var10.packetBuffer.writeShortLE(WorldMapIcon_0.selectedItemSlot);
                  Client.packetWriter.addNode(var10);
               }
            } else if (var2 == 15) {
               var16 = Client.players[var3];
               if (var16 != null) {
                  Client.mouseCrossX = var7;
                  Client.mouseCrossY = var8;
                  Client.mouseCrossColor = 2;
                  Client.mouseCrossState = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  var10 = Renderable.getPacketBufferNode(ClientPacket.field2489, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                  var10.packetBuffer.writeShortLEA(var3);
                  var10.packetBuffer.writeInt(class9.selectedSpellWidget);
                  var10.packetBuffer.writeShortLEA(Client.selectedSpellItemId);
                  var10.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
                  Client.packetWriter.addNode(var10);
               }
            } else if (var2 == 16) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Renderable.getPacketBufferNode(ClientPacket.field2485, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortLEA(var3);
               var9.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortLE(WorldMapIcon_0.selectedItemSlot);
               var9.packetBuffer.writeShortLE(var0 + ParamComposition.baseX);
               var9.packetBuffer.method2414(WorldMapLabel.selectedItemWidget);
               var9.packetBuffer.writeShortA(Client.baseY + var1);
               var9.packetBuffer.writeShortA(class131.selectedItemId);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 17) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Renderable.getPacketBufferNode(ClientPacket.field2511, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShort(var0 + ParamComposition.baseX);
               var9.packetBuffer.writeShort(var3);
               var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortLE(Client.selectedSpellItemId);
               var9.packetBuffer.writeShortA(Client.selectedSpellChildIndex);
               var9.packetBuffer.method2382(class9.selectedSpellWidget);
               var9.packetBuffer.writeShortLEA(Client.baseY + var1);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 18) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Renderable.getPacketBufferNode(ClientPacket.field2533, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortLE(Client.baseY + var1);
               var9.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortLEA(var0 + ParamComposition.baseX);
               var9.packetBuffer.writeShortA(var3);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 19) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Renderable.getPacketBufferNode(ClientPacket.field2475, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortLEA(var3);
               var9.packetBuffer.writeShortLE(Client.baseY + var1);
               var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortA(var0 + ParamComposition.baseX);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 20) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Renderable.getPacketBufferNode(ClientPacket.field2461, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortA(var0 + ParamComposition.baseX);
               var9.packetBuffer.writeShortLEA(Client.baseY + var1);
               var9.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortLE(var3);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 21) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Renderable.getPacketBufferNode(ClientPacket.field2444, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortLEA(var3);
               var9.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortLE(var0 + ParamComposition.baseX);
               var9.packetBuffer.writeShortLEA(Client.baseY + var1);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 22) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = Renderable.getPacketBufferNode(ClientPacket.field2430, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortA(Client.baseY + var1);
               var9.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShort(var3);
               var9.packetBuffer.writeShortLEA(var0 + ParamComposition.baseX);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 23) {
               if (Client.isMenuOpen) {
                  WorldMapAreaData.scene.setViewportWalking();
               } else {
                  WorldMapAreaData.scene.menuOpen(class103.Client_plane, var0, var1, true);
               }
            } else {
               PacketBufferNode var11;
               Widget var17;
               if (var2 == 24) {
                  var17 = class133.getWidget(var1);
                  if (var17 != null) {
                     boolean var12 = true;
                     if (var17.contentType > 0) {
                        var12 = class276.method1527(var17);
                     }

                     if (var12) {
                        var11 = Renderable.getPacketBufferNode(ClientPacket.field2531, Client.packetWriter.isaacCipher);
                        var11.packetBuffer.writeInt(var1);
                        Client.packetWriter.addNode(var11);
                     }
                  }
               } else {
                  if (var2 == 25) {
                     var17 = class135.getWidgetChild(var1, var0);
                     if (var17 != null) {
                        class18.Widget_runOnTargetLeave();
                        ClanChannel.selectSpell(var1, var0, MenuAction.Widget_unpackTargetMask(class173.getWidgetFlags(var17)), var4);
                        Client.isItemSelected = 0;
                        Client.selectedSpellActionName = class317.Widget_getSpellActionName(var17);
                        if (Client.selectedSpellActionName == null) {
                           Client.selectedSpellActionName = "null";
                        }

                        if (var17.isIf3) {
                           Client.selectedSpellName = var17.dataText + class149.colorStartTag(16777215);
                        } else {
                           Client.selectedSpellName = class149.colorStartTag(65280) + var17.spellName + class149.colorStartTag(16777215);
                        }
                     }

                     return;
                  }

                  if (var2 == 26) {
                     SoundCache.method229();
                  } else {
                     int var13;
                     Widget var15;
                     if (var2 == 28) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2531, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeInt(var1);
                        Client.packetWriter.addNode(var9);
                        var15 = class133.getWidget(var1);
                        if (var15 != null && var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
                           var13 = var15.cs1Instructions[0][1];
                           Varps.Varps_main[var13] = 1 - Varps.Varps_main[var13];
                           ReflectionCheck.changeGameOptions(var13);
                        }
                     } else if (var2 == 29) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2531, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeInt(var1);
                        Client.packetWriter.addNode(var9);
                        var15 = class133.getWidget(var1);
                        if (var15 != null && var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
                           var13 = var15.cs1Instructions[0][1];
                           if (Varps.Varps_main[var13] != var15.cs1ComparisonValues[0]) {
                              Varps.Varps_main[var13] = var15.cs1ComparisonValues[0];
                              ReflectionCheck.changeGameOptions(var13);
                           }
                        }
                     } else if (var2 == 30) {
                        if (Client.meslayerContinueWidget == null) {
                           class205.resumePauseWidget(var1, var0);
                           Client.meslayerContinueWidget = class135.getWidgetChild(var1, var0);
                           LoginScreenAnimation.invalidateWidget(Client.meslayerContinueWidget);
                        }
                     } else if (var2 == 31) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2456, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeShortA(WorldMapIcon_0.selectedItemSlot);
                        var9.packetBuffer.writeShortLE(var4);
                        var9.packetBuffer.writeShortA(var0);
                        var9.packetBuffer.method2441(WorldMapLabel.selectedItemWidget);
                        var9.packetBuffer.writeInt(var1);
                        var9.packetBuffer.writeShortLEA(class131.selectedItemId);
                        Client.packetWriter.addNode(var9);
                        Client.field608 = 0;
                        class378.field3629 = class133.getWidget(var1);
                        Client.field487 = var0;
                     } else if (var2 == 32) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2448, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeShortLEA(var0);
                        var9.packetBuffer.writeInt(var1);
                        var9.packetBuffer.method2414(class9.selectedSpellWidget);
                        var9.packetBuffer.writeShortLE(var4);
                        var9.packetBuffer.writeShortA(Client.selectedSpellChildIndex);
                        Client.packetWriter.addNode(var9);
                        Client.field608 = 0;
                        class378.field3629 = class133.getWidget(var1);
                        Client.field487 = var0;
                     } else if (var2 == 33) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2506, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeShort(var0);
                        var9.packetBuffer.method2414(var1);
                        var9.packetBuffer.writeShortLEA(var4);
                        Client.packetWriter.addNode(var9);
                        Client.field608 = 0;
                        class378.field3629 = class133.getWidget(var1);
                        Client.field487 = var0;
                     } else if (var2 == 34) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2520, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method2382(var1);
                        var9.packetBuffer.writeShortLEA(var4);
                        var9.packetBuffer.writeShortLEA(var0);
                        Client.packetWriter.addNode(var9);
                        Client.field608 = 0;
                        class378.field3629 = class133.getWidget(var1);
                        Client.field487 = var0;
                     } else if (var2 == 35) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2462, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeShortLE(var0);
                        var9.packetBuffer.writeShortLEA(var4);
                        var9.packetBuffer.method2414(var1);
                        Client.packetWriter.addNode(var9);
                        Client.field608 = 0;
                        class378.field3629 = class133.getWidget(var1);
                        Client.field487 = var0;
                     } else if (var2 == 36) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2530, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method2414(var1);
                        var9.packetBuffer.writeShortA(var0);
                        var9.packetBuffer.writeShortA(var4);
                        Client.packetWriter.addNode(var9);
                        Client.field608 = 0;
                        class378.field3629 = class133.getWidget(var1);
                        Client.field487 = var0;
                     } else if (var2 == 37) {
                        var9 = Renderable.getPacketBufferNode(ClientPacket.field2505, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeShort(var0);
                        var9.packetBuffer.writeInt(var1);
                        var9.packetBuffer.writeShortA(var4);
                        Client.packetWriter.addNode(var9);
                        Client.field608 = 0;
                        class378.field3629 = class133.getWidget(var1);
                        Client.field487 = var0;
                     } else {
                        if (var2 == 38) {
                           class18.Widget_runOnTargetLeave();
                           var17 = class133.getWidget(var1);
                           Client.isItemSelected = 1;
                           WorldMapIcon_0.selectedItemSlot = var0;
                           WorldMapLabel.selectedItemWidget = var1;
                           class131.selectedItemId = var4;
                           LoginScreenAnimation.invalidateWidget(var17);
                           Client.selectedItemName = class149.colorStartTag(16748608) + TileItem.ItemDefinition_get(var4).name + class149.colorStartTag(16777215);
                           if (Client.selectedItemName == null) {
                              Client.selectedItemName = "null";
                           }

                           return;
                        }

                        if (var2 == 39) {
                           var9 = Renderable.getPacketBufferNode(ClientPacket.field2474, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShort(var4);
                           var9.packetBuffer.writeShort(var0);
                           var9.packetBuffer.writeInt(var1);
                           Client.packetWriter.addNode(var9);
                           Client.field608 = 0;
                           class378.field3629 = class133.getWidget(var1);
                           Client.field487 = var0;
                        } else if (var2 == 40) {
                           var9 = Renderable.getPacketBufferNode(ClientPacket.field2510, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShortLE(var0);
                           var9.packetBuffer.writeShortLE(var4);
                           var9.packetBuffer.method2441(var1);
                           Client.packetWriter.addNode(var9);
                           Client.field608 = 0;
                           class378.field3629 = class133.getWidget(var1);
                           Client.field487 = var0;
                        } else if (var2 == 41) {
                           var9 = Renderable.getPacketBufferNode(ClientPacket.field2467, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.method2441(var1);
                           var9.packetBuffer.writeShort(var4);
                           var9.packetBuffer.writeShort(var0);
                           Client.packetWriter.addNode(var9);
                           Client.field608 = 0;
                           class378.field3629 = class133.getWidget(var1);
                           Client.field487 = var0;
                        } else if (var2 == 42) {
                           var9 = Renderable.getPacketBufferNode(ClientPacket.field2493, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShort(var4);
                           var9.packetBuffer.writeShortA(var0);
                           var9.packetBuffer.method2382(var1);
                           Client.packetWriter.addNode(var9);
                           Client.field608 = 0;
                           class378.field3629 = class133.getWidget(var1);
                           Client.field487 = var0;
                        } else if (var2 == 43) {
                           var9 = Renderable.getPacketBufferNode(ClientPacket.field2473, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShortLEA(var4);
                           var9.packetBuffer.writeShortA(var0);
                           var9.packetBuffer.writeInt(var1);
                           Client.packetWriter.addNode(var9);
                           Client.field608 = 0;
                           class378.field3629 = class133.getWidget(var1);
                           Client.field487 = var0;
                        } else if (var2 == 44) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = Renderable.getPacketBufferNode(ClientPacket.field2450, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShortLEA(var3);
                              var10.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 == 45) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = Renderable.getPacketBufferNode(ClientPacket.field2521, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShortLE(var3);
                              var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 == 46) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = Renderable.getPacketBufferNode(ClientPacket.field2525, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              var10.packetBuffer.writeShortLE(var3);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 == 47) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = Renderable.getPacketBufferNode(ClientPacket.field2517, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShort(var3);
                              var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 == 48) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = Renderable.getPacketBufferNode(ClientPacket.field2479, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              var10.packetBuffer.writeShortA(var3);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 == 49) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = Renderable.getPacketBufferNode(ClientPacket.field2478, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              var10.packetBuffer.writeShort(var3);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 == 50) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = Renderable.getPacketBufferNode(ClientPacket.field2438, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShortLEA(var3);
                              var10.packetBuffer.method2399(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 == 51) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = Renderable.getPacketBufferNode(ClientPacket.field2440, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              var10.packetBuffer.writeShortLE(var3);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 != 57 && var2 != 1007) {
                           if (var2 == 58) {
                              var17 = class135.getWidgetChild(var1, var0);
                              if (var17 != null) {
                                 if (var17.field2969 != null) {
                                    ScriptEvent var18 = new ScriptEvent();
                                    var18.widget = var17;
                                    var18.opIndex = var3;
                                    var18.targetName = var6;
                                    var18.args = var17.field2969;
                                    WorldMapAreaData.runScriptEvent(var18);
                                 }

                                 var10 = Renderable.getPacketBufferNode(ClientPacket.field2497, Client.packetWriter.isaacCipher);
                                 var10.packetBuffer.writeShortA(var0);
                                 var10.packetBuffer.writeShortLEA(Client.selectedSpellItemId);
                                 var10.packetBuffer.method2414(class9.selectedSpellWidget);
                                 var10.packetBuffer.writeShortA(var4);
                                 var10.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
                                 var10.packetBuffer.method2414(var1);
                                 Client.packetWriter.addNode(var10);
                              }
                           } else if (var2 == 1001) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = Renderable.getPacketBufferNode(ClientPacket.field2535, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.writeShortA(Client.baseY + var1);
                              var9.packetBuffer.writeShortA(var0 + ParamComposition.baseX);
                              var9.packetBuffer.writeShortLE(var3);
                              var9.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              Client.packetWriter.addNode(var9);
                           } else if (var2 == 1002) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              var9 = Renderable.getPacketBufferNode(ClientPacket.field2429, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.writeShortLEA(var3);
                              Client.packetWriter.addNode(var9);
                           } else if (var2 == 1003) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              var14 = Client.npcs[var3];
                              if (var14 != null) {
                                 NPCComposition var19 = var14.definition;
                                 if (var19.transforms != null) {
                                    var19 = var19.transform();
                                 }

                                 if (var19 != null) {
                                    var11 = Renderable.getPacketBufferNode(ClientPacket.field2449, Client.packetWriter.isaacCipher);
                                    var11.packetBuffer.writeShortA(var19.id);
                                    Client.packetWriter.addNode(var11);
                                 }
                              }
                           } else if (var2 == 1004) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              var9 = Renderable.getPacketBufferNode(ClientPacket.field2529, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.writeShortA(var3);
                              var9.packetBuffer.writeShort(var0 + ParamComposition.baseX);
                              var9.packetBuffer.writeShortA(Client.baseY + var1);
                              Client.packetWriter.addNode(var9);
                           } else if (var2 == 1005) {
                              var17 = class133.getWidget(var1);
                              if (var17 != null && var17.itemQuantities[var0] >= 100000) {
                                 ZoneOperation.addGameMessage(27, "", var17.itemQuantities[var0] + " x " + TileItem.ItemDefinition_get(var4).name);
                              } else {
                                 var10 = Renderable.getPacketBufferNode(ClientPacket.field2460, Client.packetWriter.isaacCipher);
                                 var10.packetBuffer.writeShortLEA(var4);
                                 Client.packetWriter.addNode(var10);
                              }

                              Client.field608 = 0;
                              class378.field3629 = class133.getWidget(var1);
                              Client.field487 = var0;
                           } else if (var2 == 1009 || var2 == 1011 || var2 == 1010 || var2 == 1008 || var2 == 1012) {
                              GrandExchangeOfferUnitPriceComparator.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
                           }
                        } else {
                           var17 = class135.getWidgetChild(var1, var0);
                           if (var17 != null) {
                              class16.widgetDefaultMenuAction(var3, var1, var0, var4, var6);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if (Client.isItemSelected != 0) {
         Client.isItemSelected = 0;
         LoginScreenAnimation.invalidateWidget(class133.getWidget(WorldMapLabel.selectedItemWidget));
      }

      if (Client.isSpellSelected) {
         class18.Widget_runOnTargetLeave();
      }

      if (class378.field3629 != null && Client.field608 == 0) {
         LoginScreenAnimation.invalidateWidget(class378.field3629);
      }

   }
}
