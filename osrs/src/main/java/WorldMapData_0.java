import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hd")
public class WorldMapData_0 extends AbstractWorldMapData {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "106235772"
   )
   void init(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      if (var2 != WorldMapID.field2984.value) {
         throw new IllegalStateException("");
      } else {
         super.minPlane = var1.readUnsignedByte();
         super.planes = var1.readUnsignedByte();
         super.regionXLow = var1.readUnsignedShort() * 4096;
         super.regionYLow = var1.readUnsignedShort() * 4096;
         super.regionX = var1.readUnsignedShort();
         super.regionY = var1.readUnsignedShort();
         super.groupId = var1.method8568();
         super.fileId = var1.method8568();
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
      super.field2950 = new byte[super.planes][64][64];
      super.field2951 = new byte[super.planes][64][64];
      super.decorations = new WorldMapDecoration[super.planes][64][64][];
      int var2 = var1.readUnsignedByte();
      if (var2 != class251.field2976.value) {
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

   public int hashCode() {
      return super.regionX | super.regionY << 8;
   }

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
         var9 = class136.getPacketBufferNode(ClientPacket.field3069, Client.packetWriter.isaacCipher);
         var9.packetBuffer.method8607(var3);
         var9.packetBuffer.method8607(class365.baseY * 64 + var1);
         var9.packetBuffer.method8607(class101.selectedItemSlot);
         var9.packetBuffer.writeIntME(HealthBarUpdate.selectedItemId);
         var9.packetBuffer.method8599(ModeWhere.selectedItemWidget);
         var9.packetBuffer.writeIntME(class154.baseX * 64 + var0);
         var9.packetBuffer.writeByte(Client.something.getKeyPressed(82) ? 1 : 0);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 2) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field3152, Client.packetWriter.isaacCipher);
         var9.packetBuffer.method8589(class154.baseX * 64 + var0);
         var9.packetBuffer.method8607(Client.selectedSpellChildIndex);
         var9.packetBuffer.method8600(class358.selectedSpellWidget);
         var9.packetBuffer.writeIntME(Client.selectedSpellItemId);
         var9.packetBuffer.writeShort(class365.baseY * 64 + var1);
         var9.packetBuffer.method8579(Client.something.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.writeIntME(var3);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 3) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field3117, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeByte(Client.something.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.method8589(class154.baseX * 64 + var0);
         var9.packetBuffer.writeIntME(class365.baseY * 64 + var1);
         var9.packetBuffer.writeShort(var3);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 4) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field3100, Client.packetWriter.isaacCipher);
         var9.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.method8607(var3);
         var9.packetBuffer.method8589(class365.baseY * 64 + var1);
         var9.packetBuffer.method8607(class154.baseX * 64 + var0);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 5) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field3080, Client.packetWriter.isaacCipher);
         var9.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.method8589(class365.baseY * 64 + var1);
         var9.packetBuffer.writeIntME(class154.baseX * 64 + var0);
         var9.packetBuffer.writeIntME(var3);
         Client.packetWriter.addNode(var9);
      } else if (var2 == 6) {
         Client.mouseCrossX = var7;
         Client.mouseCrossY = var8;
         Client.mouseCrossColor = 2;
         Client.mouseCrossState = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         var9 = class136.getPacketBufferNode(ClientPacket.field3071, Client.packetWriter.isaacCipher);
         var9.packetBuffer.writeShort(var3);
         var9.packetBuffer.method8579(Client.something.getKeyPressed(82) ? 1 : 0);
         var9.packetBuffer.method8589(class365.baseY * 64 + var1);
         var9.packetBuffer.method8607(class154.baseX * 64 + var0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field3082, Client.packetWriter.isaacCipher);
               var10.packetBuffer.method8600(ModeWhere.selectedItemWidget);
               var10.packetBuffer.method8580(Client.something.getKeyPressed(82) ? 1 : 0);
               var10.packetBuffer.method8589(var3);
               var10.packetBuffer.writeIntME(class101.selectedItemSlot);
               var10.packetBuffer.writeIntME(HealthBarUpdate.selectedItemId);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field3053, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeIntME(Client.selectedSpellChildIndex);
               var10.packetBuffer.method8589(var3);
               var10.packetBuffer.method8601(class358.selectedSpellWidget);
               var10.packetBuffer.writeIntME(Client.selectedSpellItemId);
               var10.packetBuffer.method8580(Client.something.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field3137, Client.packetWriter.isaacCipher);
               var10.packetBuffer.method8607(var3);
               var10.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field3068, Client.packetWriter.isaacCipher);
               var10.packetBuffer.method8589(var3);
               var10.packetBuffer.writeByte(Client.something.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field3140, Client.packetWriter.isaacCipher);
               var10.packetBuffer.writeIntME(var3);
               var10.packetBuffer.writeByte(Client.something.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field3102, Client.packetWriter.isaacCipher);
               var10.packetBuffer.method8579(Client.something.getKeyPressed(82) ? 1 : 0);
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
               var10 = class136.getPacketBufferNode(ClientPacket.field3067, Client.packetWriter.isaacCipher);
               var10.packetBuffer.method8589(var3);
               var10.packetBuffer.method8579(Client.something.getKeyPressed(82) ? 1 : 0);
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
                  var10 = class136.getPacketBufferNode(ClientPacket.field3086, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.method8580(Client.something.getKeyPressed(82) ? 1 : 0);
                  var10.packetBuffer.method8601(ModeWhere.selectedItemWidget);
                  var10.packetBuffer.method8589(class101.selectedItemSlot);
                  var10.packetBuffer.method8589(HealthBarUpdate.selectedItemId);
                  var10.packetBuffer.writeIntME(var3);
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
                  var10 = class136.getPacketBufferNode(ClientPacket.field3096, Client.packetWriter.isaacCipher);
                  var10.packetBuffer.writeShort(var3);
                  var10.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
                  var10.packetBuffer.method8607(Client.selectedSpellChildIndex);
                  var10.packetBuffer.writeInt(class358.selectedSpellWidget);
                  var10.packetBuffer.method8589(Client.selectedSpellItemId);
                  Client.packetWriter.addNode(var10);
               }
            } else if (var2 == 16) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field3061, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShort(var3);
               var9.packetBuffer.writeIntME(class365.baseY * 64 + var1);
               var9.packetBuffer.method8579(Client.something.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.method8589(class101.selectedItemSlot);
               var9.packetBuffer.writeInt(ModeWhere.selectedItemWidget);
               var9.packetBuffer.method8589(HealthBarUpdate.selectedItemId);
               var9.packetBuffer.writeIntME(class154.baseX * 64 + var0);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 17) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field3064, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeShort(class365.baseY * 64 + var1);
               var9.packetBuffer.writeShort(Client.selectedSpellChildIndex);
               var9.packetBuffer.method8601(class358.selectedSpellWidget);
               var9.packetBuffer.method8589(class154.baseX * 64 + var0);
               var9.packetBuffer.writeShort(var3);
               var9.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShort(Client.selectedSpellItemId);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 18) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field3110, Client.packetWriter.isaacCipher);
               var9.packetBuffer.method8607(class365.baseY * 64 + var1);
               var9.packetBuffer.writeByte(Client.something.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.method8589(var3);
               var9.packetBuffer.method8607(class154.baseX * 64 + var0);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 19) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field3106, Client.packetWriter.isaacCipher);
               var9.packetBuffer.method8607(var3);
               var9.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShort(class365.baseY * 64 + var1);
               var9.packetBuffer.writeIntME(class154.baseX * 64 + var0);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 20) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field3062, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeIntME(class154.baseX * 64 + var0);
               var9.packetBuffer.method8607(var3);
               var9.packetBuffer.method8607(class365.baseY * 64 + var1);
               var9.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 21) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field3112, Client.packetWriter.isaacCipher);
               var9.packetBuffer.writeIntME(class154.baseX * 64 + var0);
               var9.packetBuffer.method8580(Client.something.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.writeShort(class365.baseY * 64 + var1);
               var9.packetBuffer.writeShort(var3);
               Client.packetWriter.addNode(var9);
            } else if (var2 == 22) {
               Client.mouseCrossX = var7;
               Client.mouseCrossY = var8;
               Client.mouseCrossColor = 2;
               Client.mouseCrossState = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               var9 = class136.getPacketBufferNode(ClientPacket.field3123, Client.packetWriter.isaacCipher);
               var9.packetBuffer.method8589(class365.baseY * 64 + var1);
               var9.packetBuffer.method8607(var3);
               var9.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
               var9.packetBuffer.method8607(class154.baseX * 64 + var0);
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
                  var17 = class175.getWidget(var1);
                  if (var17 != null) {
                     boolean var12 = true;
                     if (var17.contentType > 0) {
                        var12 = NPC.method2583(var17);
                     }

                     if (var12) {
                        var13 = class136.getPacketBufferNode(ClientPacket.field3133, Client.packetWriter.isaacCipher);
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
                     WorldMapSectionType.method5236();
                  } else {
                     int var11;
                     Widget var15;
                     if (var2 == 28) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field3133, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeInt(var1);
                        Client.packetWriter.addNode(var9);
                        var15 = class175.getWidget(var1);
                        if (var15 != null && var15.cs1Instructions != null && var15.cs1Instructions[0][0] == 5) {
                           var11 = var15.cs1Instructions[0][1];
                           Varps.Varps_main[var11] = 1 - Varps.Varps_main[var11];
                           MouseRecorder.changeGameOptions(var11);
                        }
                     } else if (var2 == 29) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field3133, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeInt(var1);
                        Client.packetWriter.addNode(var9);
                        var15 = class175.getWidget(var1);
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
                        var9 = class136.getPacketBufferNode(ClientPacket.field3131, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method8601(var1);
                        var9.packetBuffer.method8599(ModeWhere.selectedItemWidget);
                        var9.packetBuffer.writeShort(var4);
                        var9.packetBuffer.method8607(class101.selectedItemSlot);
                        var9.packetBuffer.method8607(var0);
                        var9.packetBuffer.writeShort(HealthBarUpdate.selectedItemId);
                        Client.packetWriter.addNode(var9);
                        Client.field624 = 0;
                        MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                        Client.field625 = var0;
                     } else if (var2 == 32) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field3049, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method8607(Client.selectedSpellChildIndex);
                        var9.packetBuffer.method8589(var4);
                        var9.packetBuffer.method8600(class358.selectedSpellWidget);
                        var9.packetBuffer.method8589(var0);
                        var9.packetBuffer.method8599(var1);
                        Client.packetWriter.addNode(var9);
                        Client.field624 = 0;
                        MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                        Client.field625 = var0;
                     } else if (var2 == 33) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field3095, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method8607(var0);
                        var9.packetBuffer.method8601(var1);
                        var9.packetBuffer.writeIntME(var4);
                        Client.packetWriter.addNode(var9);
                        Client.field624 = 0;
                        MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                        Client.field625 = var0;
                     } else if (var2 == 34) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field3101, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method8589(var4);
                        var9.packetBuffer.method8599(var1);
                        var9.packetBuffer.method8607(var0);
                        Client.packetWriter.addNode(var9);
                        Client.field624 = 0;
                        MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                        Client.field625 = var0;
                     } else if (var2 == 35) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field3093, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.writeInt(var1);
                        var9.packetBuffer.writeIntME(var4);
                        var9.packetBuffer.writeIntME(var0);
                        Client.packetWriter.addNode(var9);
                        Client.field624 = 0;
                        MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                        Client.field625 = var0;
                     } else if (var2 == 36) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field3122, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method8601(var1);
                        var9.packetBuffer.writeShort(var0);
                        var9.packetBuffer.method8589(var4);
                        Client.packetWriter.addNode(var9);
                        Client.field624 = 0;
                        MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                        Client.field625 = var0;
                     } else if (var2 == 37) {
                        var9 = class136.getPacketBufferNode(ClientPacket.field3104, Client.packetWriter.isaacCipher);
                        var9.packetBuffer.method8601(var1);
                        var9.packetBuffer.writeShort(var4);
                        var9.packetBuffer.writeIntME(var0);
                        Client.packetWriter.addNode(var9);
                        Client.field624 = 0;
                        MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                        Client.field625 = var0;
                     } else {
                        if (var2 == 38) {
                           Widget.Widget_runOnTargetLeave();
                           var17 = class175.getWidget(var1);
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
                           var9 = class136.getPacketBufferNode(ClientPacket.field3059, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeInt(var1);
                           var9.packetBuffer.writeIntME(var4);
                           var9.packetBuffer.method8589(var0);
                           Client.packetWriter.addNode(var9);
                           Client.field624 = 0;
                           MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                           Client.field625 = var0;
                        } else if (var2 == 40) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field3139, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShort(var0);
                           var9.packetBuffer.writeInt(var1);
                           var9.packetBuffer.method8607(var4);
                           Client.packetWriter.addNode(var9);
                           Client.field624 = 0;
                           MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                           Client.field625 = var0;
                        } else if (var2 == 41) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field3116, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.method8600(var1);
                           var9.packetBuffer.method8589(var0);
                           var9.packetBuffer.writeIntME(var4);
                           Client.packetWriter.addNode(var9);
                           Client.field624 = 0;
                           MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                           Client.field625 = var0;
                        } else if (var2 == 42) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field3056, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.method8607(var0);
                           var9.packetBuffer.method8607(var4);
                           var9.packetBuffer.method8601(var1);
                           Client.packetWriter.addNode(var9);
                           Client.field624 = 0;
                           MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                           Client.field625 = var0;
                        } else if (var2 == 43) {
                           var9 = class136.getPacketBufferNode(ClientPacket.field3111, Client.packetWriter.isaacCipher);
                           var9.packetBuffer.writeShort(var4);
                           var9.packetBuffer.writeIntME(var0);
                           var9.packetBuffer.method8599(var1);
                           Client.packetWriter.addNode(var9);
                           Client.field624 = 0;
                           MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                           Client.field625 = var0;
                        } else if (var2 == 44) {
                           var16 = Client.players[var3];
                           if (var16 != null) {
                              Client.mouseCrossX = var7;
                              Client.mouseCrossY = var8;
                              Client.mouseCrossColor = 2;
                              Client.mouseCrossState = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              var10 = class136.getPacketBufferNode(ClientPacket.field3091, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeByte(Client.something.getKeyPressed(82) ? 1 : 0);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field3147, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeIntME(var3);
                              var10.packetBuffer.writeByte(Client.something.getKeyPressed(82) ? 1 : 0);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field3094, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeByte(Client.something.getKeyPressed(82) ? 1 : 0);
                              var10.packetBuffer.method8589(var3);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field3047, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.writeShort(var3);
                              var10.packetBuffer.method8580(Client.something.getKeyPressed(82) ? 1 : 0);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field3088, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.method8607(var3);
                              var10.packetBuffer.method8580(Client.something.getKeyPressed(82) ? 1 : 0);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field3066, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.method8580(Client.something.getKeyPressed(82) ? 1 : 0);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field3105, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.method8589(var3);
                              var10.packetBuffer.method8580(Client.something.getKeyPressed(82) ? 1 : 0);
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
                              var10 = class136.getPacketBufferNode(ClientPacket.field3138, Client.packetWriter.isaacCipher);
                              var10.packetBuffer.method8589(var3);
                              var10.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
                              Client.packetWriter.addNode(var10);
                           }
                        } else {
                           label652: {
                              if (var2 != 57) {
                                 if (var2 == 58) {
                                    var17 = AttackOption.getWidgetChild(var1, var0);
                                    if (var17 != null) {
                                       if (var17.field3654 != null) {
                                          ScriptEvent var19 = new ScriptEvent();
                                          var19.widget = var17;
                                          var19.opIndex = var3;
                                          var19.targetName = var6;
                                          var19.args = var17.field3654;
                                          WorldMapElement.runScriptEvent(var19);
                                       }

                                       var10 = class136.getPacketBufferNode(ClientPacket.field3153, Client.packetWriter.isaacCipher);
                                       var10.packetBuffer.method8607(Client.selectedSpellItemId);
                                       var10.packetBuffer.writeInt(var1);
                                       var10.packetBuffer.method8601(class358.selectedSpellWidget);
                                       var10.packetBuffer.method8589(Client.selectedSpellChildIndex);
                                       var10.packetBuffer.method8607(var0);
                                       var10.packetBuffer.method8589(var4);
                                       Client.packetWriter.addNode(var10);
                                    }
                                    break label652;
                                 }

                                 if (var2 == 1001) {
                                    Client.mouseCrossX = var7;
                                    Client.mouseCrossY = var8;
                                    Client.mouseCrossColor = 2;
                                    Client.mouseCrossState = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    var9 = class136.getPacketBufferNode(ClientPacket.field3119, Client.packetWriter.isaacCipher);
                                    var9.packetBuffer.method8589(class365.baseY * 64 + var1);
                                    var9.packetBuffer.writeShort(class154.baseX * 64 + var0);
                                    var9.packetBuffer.writeIntME(var3);
                                    var9.packetBuffer.method8578(Client.something.getKeyPressed(82) ? 1 : 0);
                                    Client.packetWriter.addNode(var9);
                                    break label652;
                                 }

                                 if (var2 == 1002) {
                                    Client.mouseCrossX = var7;
                                    Client.mouseCrossY = var8;
                                    Client.mouseCrossColor = 2;
                                    Client.mouseCrossState = 0;
                                    var9 = class136.getPacketBufferNode(ClientPacket.field3151, Client.packetWriter.isaacCipher);
                                    var9.packetBuffer.method8589(var3);
                                    Client.packetWriter.addNode(var9);
                                    break label652;
                                 }

                                 if (var2 == 1003) {
                                    Client.mouseCrossX = var7;
                                    Client.mouseCrossY = var8;
                                    Client.mouseCrossColor = 2;
                                    Client.mouseCrossState = 0;
                                    var14 = Client.npcs[var3];
                                    if (var14 != null) {
                                       NPCComposition var18 = var14.definition;
                                       if (var18.transforms != null) {
                                          var18 = var18.transform();
                                       }

                                       if (var18 != null) {
                                          var13 = class136.getPacketBufferNode(ClientPacket.field3103, Client.packetWriter.isaacCipher);
                                          var13.packetBuffer.method8589(var18.id);
                                          Client.packetWriter.addNode(var13);
                                       }
                                    }
                                    break label652;
                                 }

                                 if (var2 == 1004) {
                                    Client.mouseCrossX = var7;
                                    Client.mouseCrossY = var8;
                                    Client.mouseCrossColor = 2;
                                    Client.mouseCrossState = 0;
                                    var9 = class136.getPacketBufferNode(ClientPacket.field3132, Client.packetWriter.isaacCipher);
                                    var9.packetBuffer.writeIntME(class154.baseX * 64 + var0);
                                    var9.packetBuffer.writeShort(class365.baseY * 64 + var1);
                                    var9.packetBuffer.method8589(var3);
                                    Client.packetWriter.addNode(var9);
                                    break label652;
                                 }

                                 if (var2 == 1005) {
                                    var17 = class175.getWidget(var1);
                                    if (var17 != null && var17.itemQuantities[var0] >= 100000) {
                                       KitDefinition.addGameMessage(27, "", var17.itemQuantities[var0] + " x " + NPCComposition.ItemDefinition_get(var4).name);
                                    } else {
                                       var10 = class136.getPacketBufferNode(ClientPacket.field3127, Client.packetWriter.isaacCipher);
                                       var10.packetBuffer.method8589(var4);
                                       Client.packetWriter.addNode(var10);
                                    }

                                    Client.field624 = 0;
                                    MusicPatchPcmStream.field3411 = class175.getWidget(var1);
                                    Client.field625 = var0;
                                    break label652;
                                 }

                                 if (var2 != 1007) {
                                    if (var2 == 1008 || var2 == 1009 || var2 == 1011 || var2 == 1010 || var2 == 1012) {
                                       KitDefinition.worldMap.worldMapMenuAction(var2, var3, new Coord(var0), new Coord(var1));
                                    }
                                    break label652;
                                 }
                              }

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
      }

      if (Client.isItemSelected != 0) {
         Client.isItemSelected = 0;
         class69.invalidateWidget(class175.getWidget(ModeWhere.selectedItemWidget));
      }

      if (Client.isSpellSelected) {
         Widget.Widget_runOnTargetLeave();
      }

      if (MusicPatchPcmStream.field3411 != null && Client.field624 == 0) {
         class69.invalidateWidget(MusicPatchPcmStream.field3411);
      }

   }

   @ObfuscatedName("nu")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1283712243"
   )
   static void method4848() {
      StructComposition.clientPreferences.method2431(Client.field511);
   }
}
