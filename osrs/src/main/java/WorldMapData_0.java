import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
@Implements("WorldMapData_0")
public class WorldMapData_0 extends AbstractWorldMapData {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "106235772"
   )
   void init(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != WorldMapID.field2385.value) {
         throw new IllegalStateException("");
      } else {
         super.minPlane = var1.readUnsignedByte();
         super.planes = var1.readUnsignedByte();
         super.regionXLow = var1.readUnsignedShort();
         super.regionYLow = var1.readUnsignedShort();
         super.regionX = var1.readUnsignedShort();
         super.regionY = var1.readUnsignedShort();
         super.groupId = var1.method2362();
         super.fileId = var1.method2362();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1703912011"
   )
   void readGeography(Buffer var1) {
      super.planes = Math.min(super.planes, 4);
      super.floorUnderlayIds = new short[1][64][64];
      super.floorOverlayIds = new short[super.planes][64][64];
      super.field2359 = new byte[super.planes][64][64];
      super.field2360 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if (var2 != class251.field2379.value) {
         throw new IllegalStateException("");
      } else {
         int var3 = var1.readUnsignedByte();
         int var4 = var1.readUnsignedByte();
         if (var3 == super.regionX && var4 == super.regionY) {
            for(int var5 = 0; var5 < 64; ++var5) {
               for(int var6 = 0; var6 < 64; ++var6) {
                  this.readTile(var5, var6, var1);
               }
            }

         } else {
            throw new IllegalStateException("");
         }
      }
   }

   @ObfuscatedName("hashCode")
   public int hashCode() {
      return super.regionX | super.regionY << 8;
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (!(var1 instanceof WorldMapData_0)) {
         return false;
      } else {
         WorldMapData_0 var2 = (WorldMapData_0)var1;
         return super.regionX == var2.regionX && var2.regionY == super.regionY;
      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      descriptor = "(IIIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "649826417"
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
         var9 = class136.getPacketBufferNode(ClientPacket.field2453, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeShortLE(var3);
         var9.packetBuffer.writeShortLE(class365.baseY + var1);
         var9.packetBuffer.writeShortLE(class101.selectedItemSlot);
         var9.packetBuffer.writeShortA(HealthBarUpdate.selectedItemId);
         var9.packetBuffer.writeIntLE(ModeWhere.selectedItemWidget);
         var9.packetBuffer.writeShortA(var0 + class154.baseX);
         var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 2) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field2536, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeShortLEA(var0 + class154.baseX);
         var9.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
         var9.packetBuffer.method2382(class358.selectedSpellWidget);
         var9.packetBuffer.writeShortA(Client.selectedSpellItemId);
         var9.packetBuffer.writeShort(class365.baseY + var1);
         var9.packetBuffer.writeByteC(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShortA(var3);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 3) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field2501, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShortLEA(var0 + class154.baseX);
         var9.packetBuffer.writeShortA(class365.baseY + var1);
         var9.packetBuffer.writeShort(var3);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 4) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field2484, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShortLE(var3);
         var9.packetBuffer.writeShortLEA(class365.baseY + var1);
         var9.packetBuffer.writeShortLE(var0 + class154.baseX);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 5) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field2464, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShortLEA(class365.baseY + var1);
         var9.packetBuffer.writeShortA(var0 + class154.baseX);
         var9.packetBuffer.writeShortA(var3);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 6) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field2455, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeShort(var3);
         var9.packetBuffer.writeByteC(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeShortLEA(class365.baseY + var1);
         var9.packetBuffer.writeShortLE(var0 + class154.baseX);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field2466, Client.packetWriter.isaacCipher);
               var10.packetBuffer.method2382(ModeWhere.selectedItemWidget);
               var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.writeShortLEA(var3);
               var10.packetBuffer.writeShortA(class101.selectedItemSlot);
               var10.packetBuffer.writeShortA(HealthBarUpdate.selectedItemId);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field2437, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeShortA(Client.selectedSpellChildIndex);
               var10.packetBuffer.writeShortLEA(var3);
               var10.packetBuffer.method2383(class358.selectedSpellWidget);
               var10.packetBuffer.writeShortA(Client.selectedSpellItemId);
               var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field2521, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeShortLE(var3);
               var10.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field2452, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeShortLEA(var3);
               var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field2524, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeShortA(var3);
               var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field2486, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeByteC(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.writeShort(var3);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field2451, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeShortLEA(var3);
               var10.packetBuffer.writeByteC(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
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
                  var10 = class136.getPacketBufferNode(ClientPacket.field2470, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                  var10.packetBuffer.method2383(ModeWhere.selectedItemWidget);
                  var10.packetBuffer.writeShortLEA(class101.selectedItemSlot);
                  var10.packetBuffer.writeShortLEA(HealthBarUpdate.selectedItemId);
                  var10.packetBuffer.writeShortA(var3);
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
                  var10 = class136.getPacketBufferNode(ClientPacket.field2480, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeShort(var3);
                  var10.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                  var10.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
                  var10.packetBuffer.writeInt(class358.selectedSpellWidget);
                  var10.packetBuffer.writeShortLEA(Client.selectedSpellItemId);
                  Client.packetWriter.addNode(var10);
               }
            } else if (var2 == 16) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field2445, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShort(var3);
               var9.packetBuffer.writeShortA(class365.baseY + var1);
               var9.packetBuffer.writeByteC(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortLEA(class101.selectedItemSlot);
               var9.packetBuffer.writeInt(ModeWhere.selectedItemWidget);
               var9.packetBuffer.writeShortLEA(HealthBarUpdate.selectedItemId);
               var9.packetBuffer.writeShortA(var0 + class154.baseX);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 17) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field2448, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShort(class365.baseY + var1);
               var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
               var9.packetBuffer.method2383(class358.selectedSpellWidget);
               var9.packetBuffer.writeShortLEA(var0 + class154.baseX);
               var9.packetBuffer.writeShort(var3);
               var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShort(Client.selectedSpellItemId);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 18) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field2494, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortLE(class365.baseY + var1);
               var9.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortLEA(var3);
               var9.packetBuffer.writeShortLE(var0 + class154.baseX);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 19) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field2490, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortLE(var3);
               var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShort(class365.baseY + var1);
               var9.packetBuffer.writeShortA(var0 + class154.baseX);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 20) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field2446, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortA(var0 + class154.baseX);
               var9.packetBuffer.writeShortLE(var3);
               var9.packetBuffer.writeShortLE(class365.baseY + var1);
               var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 21) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field2496, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortA(var0 + class154.baseX);
               var9.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShort(class365.baseY + var1);
               var9.packetBuffer.writeShort(var3);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 22) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field2507, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShortLEA(class365.baseY + var1);
               var9.packetBuffer.writeShortLE(var3);
               var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShortLE(var0 + class154.baseX);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 23) {
               if (Client.isMenuOpen) {
                  ReflectionCheck.scene.setViewportWalking();
               } else {
                  ReflectionCheck.scene.menuOpen(class383.Client_plane, var0, var1, true);
               }
            } else {
               PacketBufferNode var13;
               Widget var17;
               if (var2 == 24) {
                  var17 = ObjTypeCustomisation.getWidget(var1);
                  if (var17 != null) {
                     boolean var12 = true;
                     if (var17.contentType > 0) {
                        var12 = NPC.method592(var17);
                     }

                     if (var12) {
                        var13 = class136.getPacketBufferNode(ClientPacket.field2517, Client.packetWriter.isaacCipher);
                        var13.packetBuffer.writeInt(var1);
                        Client.packetWriter.addNode(var13);
                     }
                  }
               } else {
                  if (var2 == 25) {
                     var17 = AttackOption.getWidgetChild(var1, var0);
                     if (var17 != null) {
                        Widget.Widget_runOnTargetLeave();
                        class32.selectSpell(var1, var0, PacketWriter.Widget_unpackTargetMask(Clock.getWidgetFlags(var17)), var4);
                        Client.isItemSelected = 0;
                        Client.selectedSpellActionName = ArchiveLoader.Widget_getSpellActionName(var17);
                        if (Client.selectedSpellActionName == null) {
                           Client.selectedSpellActionName = "null";
                        }

                        if (var17.isIf3) {
                           Client.selectedSpellName = var17.dataText + MouseRecorder.colorStartTag(16777215);
                        } else {
                           Client.selectedSpellName = MouseRecorder.colorStartTag(65280) + var17.spellName + MouseRecorder.colorStartTag(16777215);
                        }
                     }

                     return;
                  }

                  if (var2 == 26) {
                     WorldMapSectionType.method1429();
                  } else {
                     int var11;
                     Widget var15;
                     if (var2 == 28) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2517, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeInt(var1);
                        Client.packetWriter.addNode(var9);
                        var15 = ObjTypeCustomisation.getWidget(var1);
                        if (var15 != null && var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
                           var11 = var15.cs1Instructions[0][1];
                           Varps.Varps_main[var11] = 1 - Varps.Varps_main[var11];
                           MouseRecorder.changeGameOptions(var11);
                        }
                     } else if (var2 == 29) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2517, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeInt(var1);
                        Client.packetWriter.addNode(var9);
                        var15 = ObjTypeCustomisation.getWidget(var1);
                        if (var15 != null && var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
                           var11 = var15.cs1Instructions[0][1];
                           if (Varps.Varps_main[var11] != var15.cs1ComparisonValues[0]) {
                              Varps.Varps_main[var11] = var15.cs1ComparisonValues[0];
                              MouseRecorder.changeGameOptions(var11);
                           }
                        }
                     } else if (var2 == 30) {
                        if (Client.meslayerContinueWidget == null) {
                           class262.resumePauseWidget(var1, var0);
                           Client.meslayerContinueWidget = AttackOption.getWidgetChild(var1, var0);
                           class69.invalidateWidget(Client.meslayerContinueWidget);
                        }
                     } else if (var2 == 31) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2515, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method2383(var1);
                        var9.packetBuffer.writeIntLE(ModeWhere.selectedItemWidget);
                        var9.packetBuffer.writeShort(var4);
                        var9.packetBuffer.writeShortLE(class101.selectedItemSlot);
                        var9.packetBuffer.writeShortLE(var0);
                        var9.packetBuffer.writeShort(HealthBarUpdate.selectedItemId);
                        Client.packetWriter.addNode(var9);
                        Client.field469 = 0;
                        MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                        Client.field470 = var0;
                     } else if (var2 == 32) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2433, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeShortLE(Client.selectedSpellChildIndex);
                        var9.packetBuffer.writeShortLEA(var4);
                        var9.packetBuffer.method2382(class358.selectedSpellWidget);
                        var9.packetBuffer.writeShortLEA(var0);
                        var9.packetBuffer.writeIntLE(var1);
                        Client.packetWriter.addNode(var9);
                        Client.field469 = 0;
                        MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                        Client.field470 = var0;
                     } else if (var2 == 33) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2479, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeShortLE(var0);
                        var9.packetBuffer.method2383(var1);
                        var9.packetBuffer.writeShortA(var4);
                        Client.packetWriter.addNode(var9);
                        Client.field469 = 0;
                        MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                        Client.field470 = var0;
                     } else if (var2 == 34) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2485, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeShortLEA(var4);
                        var9.packetBuffer.writeIntLE(var1);
                        var9.packetBuffer.writeShortLE(var0);
                        Client.packetWriter.addNode(var9);
                        Client.field469 = 0;
                        MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                        Client.field470 = var0;
                     } else if (var2 == 35) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2477, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeInt(var1);
                        var9.packetBuffer.writeShortA(var4);
                        var9.packetBuffer.writeShortA(var0);
                        Client.packetWriter.addNode(var9);
                        Client.field469 = 0;
                        MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                        Client.field470 = var0;
                     } else if (var2 == 36) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2506, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method2383(var1);
                        var9.packetBuffer.writeShort(var0);
                        var9.packetBuffer.writeShortLEA(var4);
                        Client.packetWriter.addNode(var9);
                        Client.field469 = 0;
                        MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                        Client.field470 = var0;
                     } else if (var2 == 37) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field2488, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method2383(var1);
                        var9.packetBuffer.writeShort(var4);
                        var9.packetBuffer.writeShortA(var0);
                        Client.packetWriter.addNode(var9);
                        Client.field469 = 0;
                        MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                        Client.field470 = var0;
                     } else {
                        if (var2 == 38) {
                           Widget.Widget_runOnTargetLeave();
                           var17 = ObjTypeCustomisation.getWidget(var1);
                           Client.isItemSelected = 1;
                           class101.selectedItemSlot = var0;
                           ModeWhere.selectedItemWidget = var1;
                           HealthBarUpdate.selectedItemId = var4;
                           class69.invalidateWidget(var17);
                           Client.selectedItemName = MouseRecorder.colorStartTag(16748608) + NPCComposition.ItemDefinition_get(var4).name + MouseRecorder.colorStartTag(16777215);
                           if (Client.selectedItemName == null) {
                              Client.selectedItemName = "null";
                           }

                           return;
                        }

                        if (var2 == 39) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field2443, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeInt(var1);
                           var9.packetBuffer.writeShortA(var4);
                           var9.packetBuffer.writeShortLEA(var0);
                           Client.packetWriter.addNode(var9);
                           Client.field469 = 0;
                           MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                           Client.field470 = var0;
                        } else if (var2 == 40) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field2523, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShort(var0);
                           var9.packetBuffer.writeInt(var1);
                           var9.packetBuffer.writeShortLE(var4);
                           Client.packetWriter.addNode(var9);
                           Client.field469 = 0;
                           MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                           Client.field470 = var0;
                        } else if (var2 == 41) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field2500, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.method2382(var1);
                           var9.packetBuffer.writeShortLEA(var0);
                           var9.packetBuffer.writeShortA(var4);
                           Client.packetWriter.addNode(var9);
                           Client.field469 = 0;
                           MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                           Client.field470 = var0;
                        } else if (var2 == 42) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field2440, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShortLE(var0);
                           var9.packetBuffer.writeShortLE(var4);
                           var9.packetBuffer.method2383(var1);
                           Client.packetWriter.addNode(var9);
                           Client.field469 = 0;
                           MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                           Client.field470 = var0;
                        } else if (var2 == 43) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field2495, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShort(var4);
                           var9.packetBuffer.writeShortA(var0);
                           var9.packetBuffer.writeIntLE(var1);
                           Client.packetWriter.addNode(var9);
                           Client.field469 = 0;
                           MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                           Client.field470 = var0;
                        } else if (var2 == 44) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = class136.getPacketBufferNode(ClientPacket.field2475, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              var10.packetBuffer.writeShort(var3);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field2531, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShortA(var3);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field2478, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeByte(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              var10.packetBuffer.writeShortLEA(var3);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field2431, Client.packetWriter.isaacCipher);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field2472, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShortLE(var3);
                              var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field2450, Client.packetWriter.isaacCipher);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field2489, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShortLEA(var3);
                              var10.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field2522, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShortLEA(var3);
                              var10.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              Client.packetWriter.addNode(var10);
                           }
                        } else if (var2 != 1007 && var2 != 57) {
                           if (var2 == 58) {
                              var17 = AttackOption.getWidgetChild(var1, var0);
                              if (var17 != null) {
                                 if (var17.field2976 != null) {
                                    ScriptEvent var18 = new ScriptEvent();
                                    var18.widget = var17;
                                    var18.opIndex = var3;
                                    var18.targetName = var6;
                                    var18.args = var17.field2976;
                                    WorldMapElement.runScriptEvent(var18);
                                 }

                                 var10 = class136.getPacketBufferNode(ClientPacket.field2537, Client.packetWriter.isaacCipher);
                                 var10.packetBuffer.writeShortLE(Client.selectedSpellItemId);
                                 var10.packetBuffer.writeInt(var1);
                                 var10.packetBuffer.method2383(class358.selectedSpellWidget);
                                 var10.packetBuffer.writeShortLEA(Client.selectedSpellChildIndex);
                                 var10.packetBuffer.writeShortLE(var0);
                                 var10.packetBuffer.writeShortLEA(var4);
                                 Client.packetWriter.addNode(var10);
                              }
                           } else if (var2 == 1001) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var9 = class136.getPacketBufferNode(ClientPacket.field2503, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.writeShortLEA(class365.baseY + var1);
                              var9.packetBuffer.writeShort(var0 + class154.baseX);
                              var9.packetBuffer.writeShortA(var3);
                              var9.packetBuffer.writeByteA(Client.keyHandlerInstance.getKeyPressed(82) ? 1 : 0);
                              Client.packetWriter.addNode(var9);
                           } else if (var2 == 1002) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              var9 = class136.getPacketBufferNode(ClientPacket.field2535, Client.packetWriter.isaacCipher);
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
                                    var13 = class136.getPacketBufferNode(ClientPacket.field2487, Client.packetWriter.isaacCipher);
                                    var13.packetBuffer.writeShortLEA(var19.id);
                                    Client.packetWriter.addNode(var13);
                                 }
                              }
                           } else if (var2 == 1004) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              var9 = class136.getPacketBufferNode(ClientPacket.field2516, Client.packetWriter.isaacCipher);
                              var9.packetBuffer.writeShortA(var0 + class154.baseX);
                              var9.packetBuffer.writeShort(class365.baseY + var1);
                              var9.packetBuffer.writeShortLEA(var3);
                              Client.packetWriter.addNode(var9);
                           } else if (var2 == 1005) {
                              var17 = ObjTypeCustomisation.getWidget(var1);
                              if (var17 != null && var17.itemQuantities[var0] >= 100000) {
                                 KitDefinition.addGameMessage(27, "", var17.itemQuantities[var0] + " x " + NPCComposition.ItemDefinition_get(var4).name);
                              } else {
                                 var10 = class136.getPacketBufferNode(ClientPacket.field2511, Client.packetWriter.isaacCipher);
                                 var10.packetBuffer.writeShortLEA(var4);
                                 Client.packetWriter.addNode(var10);
                              }

                              Client.field469 = 0;
                              MusicPatchPcmStream.field2764 = ObjTypeCustomisation.getWidget(var1);
                              Client.field470 = var0;
                           } else if (var2 == 1012 || var2 == 1010 || var2 == 1009 || var2 == 1008 || var2 == 1011) {
                              KitDefinition.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
                           }
                        } else {
                           var17 = AttackOption.getWidgetChild(var1, var0);
                           if (var17 != null) {
                              ModelData0.widgetDefaultMenuAction(var3, var1, var0, var4, var6);
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
         class69.invalidateWidget(ObjTypeCustomisation.getWidget(ModeWhere.selectedItemWidget));
      }

      if (Client.isSpellSelected) {
         Widget.Widget_runOnTargetLeave();
      }

      if (MusicPatchPcmStream.field2764 != null && Client.field469 == 0) {
         class69.invalidateWidget(MusicPatchPcmStream.field2764);
      }

   }

   @ObfuscatedName("nu")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1283712243"
   )
   static void method1303() {
      StructComposition.clientPreferences.method549(Client.param21);
   }
}
