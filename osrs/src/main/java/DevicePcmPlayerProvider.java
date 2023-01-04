import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("DevicePcmPlayerProvider")
public class DevicePcmPlayerProvider implements class51 {
   @ObfuscatedName("ty")
   @ObfuscatedSignature(
      descriptor = "Lby;"
   )
   static Decimator decimator;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)Lax;",
      garbageValue = "999216376"
   )
   public PcmPlayer player() {
      return new DevicePcmPlayer();
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-98"
   )
   static void method84(int var0) {
      class12.setLoginIndex(14);
      Login.field732 = var0;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      descriptor = "(Lkd;IIB)V",
      garbageValue = "1"
   )
   static final void checkIfMinimapClicked(Widget var0, int var1, int var2) {
      if (Client.minimapState == 0 || Client.minimapState == 3) {
         if (!Client.isMenuOpen && (MouseHandler.MouseHandler_lastButton == 1 || !SceneTilePaint.mouseCam && MouseHandler.MouseHandler_lastButton == 4)) {
            SpriteMask var3 = var0.getSpriteMask(true);
            if (var3 == null) {
               return;
            }

            int var4 = MouseHandler.MouseHandler_lastPressedX - var1;
            int var5 = MouseHandler.MouseHandler_lastPressedY - var2;
            if (var3.contains(var4, var5)) {
               var4 -= var3.width / 2;
               var5 -= var3.height / 2;
               int var6 = Client.camAngleY & 2047;
               int var7 = Rasterizer3D.Rasterizer3D_sine[var6];
               int var8 = Rasterizer3D.Rasterizer3D_cosine[var6];
               int var9 = var7 * var5 + var4 * var8 >> 11;
               int var10 = var5 * var8 - var4 * var7 >> 11;
               int var11 = var9 + class155.localPlayer.x >> 7;
               int var12 = class155.localPlayer.y - var10 >> 7;
               PacketBufferNode var13 = class136.getPacketBufferNode(ClientPacket.field2481, Client.packetWriter.isaacCipher);
               var13.packetBuffer.writeByte(18);
               var13.packetBuffer.writeByteS(Client.keyHandlerInstance.getKeyPressed(82) ? (Client.keyHandlerInstance.getKeyPressed(81) ? 2 : 1) : 0);
               var13.packetBuffer.writeShortLE(var11 + class154.baseX);
               var13.packetBuffer.writeShortA(var12 + class365.baseY);
               var13.packetBuffer.writeByte(var4);
               var13.packetBuffer.writeByte(var5);
               var13.packetBuffer.writeShort(Client.camAngleY);
               var13.packetBuffer.writeByte(57);
               var13.packetBuffer.writeByte(0);
               var13.packetBuffer.writeByte(0);
               var13.packetBuffer.writeByte(89);
               var13.packetBuffer.writeShort(class155.localPlayer.x);
               var13.packetBuffer.writeShort(class155.localPlayer.y);
               var13.packetBuffer.writeByte(63);
               Client.packetWriter.addNode(var13);
               Client.destinationX = var11;
               Client.destinationY = var12;
            }
         }

      }
   }

   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      descriptor = "(ZS)V",
      garbageValue = "226"
   )
   static final void addNpcsToScene(boolean var0) {
      for(int var1 = 0; var1 < Client.npcCount; ++var1) {
         NPC var2 = Client.npcs[Client.npcIndices[var1]];
         if (var2 != null && var2.isVisible() && var2.definition.isVisible == var0 && var2.definition.transformIsVisible()) {
            int var3 = var2.x >> 7;
            int var4 = var2.y >> 7;
            if (var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
               if (var2.field933 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if (Client.tileLastDrawnActor[var3][var4] == Client.viewportDrawCount) {
                     continue;
                  }

                  Client.tileLastDrawnActor[var3][var4] = Client.viewportDrawCount;
               }

               long var5 = GameEngine.calculateTag(0, 0, 1, !var2.definition.isInteractable, Client.npcIndices[var1]);
               var2.playerCycle = Client.cycle;
               ReflectionCheck.scene.drawEntity(class383.Client_plane, var2.x, var2.y, SpotAnimationDefinition.getTileHeight(var2.field933 * 64 - 64 + var2.x, var2.field933 * 64 - 64 + var2.y, class383.Client_plane), var2.field933 * 64 - 64 + 60, var2, var2.rotation, var5, var2.isWalking);
            }
         }
      }

   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      descriptor = "(Ljn;I)V",
      garbageValue = "2022149498"
   )
   static final void method80(class276 var0) {
      PacketBuffer var1 = Client.packetWriter.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      TileItem var8;
      if (class276.field2548 == var0) {
         var2 = var1.readUnsignedByte();
         var3 = var1.readUnsignedShortA();
         var4 = var1.readInt();
         var5 = var1.readUnsignedByteA();
         var6 = (var5 >> 4 & 7) + InvDefinition.regionChunkX;
         var7 = (var5 & 7) + class125.regionChunkY;
         if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
            var8 = new TileItem();
            var8.id = var3;
            var8.quantity = var4;
            var8.method603(var2);
            if (Client.groundItems[class383.Client_plane][var6][var7] == null) {
               Client.groundItems[class383.Client_plane][var6][var7] = new NodeDeque();
            }

            Client.groundItems[class383.Client_plane][var6][var7].addFirst(var8);
            class358.updateItemPile(var6, var7);
         }

      } else if (class276.field2543 == var0) {
         var2 = var1.readUnsignedShortA();
         var3 = var1.readUnsignedByte();
         var4 = var1.readUnsignedByteC();
         var5 = (var4 >> 4 & 7) + InvDefinition.regionChunkX;
         var6 = (var4 & 7) + class125.regionChunkY;
         var7 = var1.readUnsignedShortA();
         if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
            var5 = var5 * 128 + 64;
            var6 = var6 * 128 + 64;
            GraphicsObject var38 = new GraphicsObject(var7, class383.Client_plane, var5, var6, SpotAnimationDefinition.getTileHeight(var5, var6, class383.Client_plane) - var3, var2, Client.cycle);
            Client.graphicsObjects.addFirst(var38);
         }

      } else if (class276.field2546 == var0) {
         var2 = var1.readUnsignedByte();
         var3 = (var2 >> 4 & 7) + InvDefinition.regionChunkX;
         var4 = (var2 & 7) + class125.regionChunkY;
         var1.readUnsignedShortLEA();
         var5 = var1.readUnsignedByteS();
         var1.readUnsignedShortLE();
         var6 = var1.readInt();
         var1.readUnsignedByteC();
         var1.readUnsignedByteC();
         var7 = var1.readUnsignedShort();
         if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
            var8 = new TileItem();
            var8.id = var7;
            var8.quantity = var6;
            var8.method603(var5);
            if (Client.groundItems[class383.Client_plane][var3][var4] == null) {
               Client.groundItems[class383.Client_plane][var3][var4] = new NodeDeque();
            }

            Client.groundItems[class383.Client_plane][var3][var4].addFirst(var8);
            class358.updateItemPile(var3, var4);
         }

      } else {
         int var9;
         int var10;
         int var12;
         byte var13;
         byte var14;
         Projectile var15;
         int var31;
         int var39;
         int var41;
         int var42;
         if (class276.field2554 == var0) {
            var2 = var1.readUnsignedByteS() * 4;
            var3 = var1.readUnsignedByte();
            var4 = (var3 >> 4 & 7) + InvDefinition.regionChunkX;
            var5 = (var3 & 7) + class125.regionChunkY;
            var6 = var1.readUnsignedShortA();
            var7 = var1.readUnsignedShortA();
            var31 = var1.readUnsignedByteA() * 4;
            var9 = var1.readUnsignedByteS();
            var10 = var1.readUnsignedByte();
            var39 = var1.readShort();
            var12 = var1.readUnsignedShortA();
            var13 = var1.readByteS();
            var14 = var1.readByte();
            var41 = var13 + var4;
            var42 = var14 + var5;
            if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104 && var41 >= 0 && var42 >= 0 && var41 < 104 && var42 < 104 && var12 != 65535) {
               var4 = var4 * 128 + 64;
               var5 = var5 * 128 + 64;
               var41 = var41 * 128 + 64;
               var42 = var42 * 128 + 64;
               var15 = new Projectile(var12, class383.Client_plane, var4, var5, SpotAnimationDefinition.getTileHeight(var4, var5, class383.Client_plane) - var31, var6 + Client.cycle, var7 + Client.cycle, var10, var9, var39, var2);
               var15.setDestination(var41, var42, SpotAnimationDefinition.getTileHeight(var41, var42, class383.Client_plane) - var2, var6 + Client.cycle);
               Client.projectiles.addFirst(var15);
            }

         } else if (class276.field2541 == var0) {
            var2 = var1.readUnsignedByteC();
            var3 = var2 >> 2;
            var4 = var2 & 3;
            var5 = Client.OBJECT_TYPE_TO_STUB_TYPE[var3];
            var6 = var1.readUnsignedByteC();
            var7 = (var6 >> 4 & 7) + InvDefinition.regionChunkX;
            var31 = (var6 & 7) + class125.regionChunkY;
            var9 = var1.readUnsignedByteC();
            var10 = var1.readUnsignedShortLE();
            if (var7 >= 0 && var31 >= 0 && var7 < 104 && var31 < 104) {
               class11.updatePendingSpawn(class383.Client_plane, var7, var31, var5, var10, var3, var4, var9, 0, -1);
            }

         } else {
            NodeDeque var32;
            if (class276.field2552 == var0) {
               var2 = var1.readUnsignedByteA();
               var3 = (var2 >> 4 & 7) + InvDefinition.regionChunkX;
               var4 = (var2 & 7) + class125.regionChunkY;
               var5 = var1.readUnsignedShort();
               var6 = var1.method2373();
               if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  var32 = Client.groundItems[class383.Client_plane][var3][var4];
                  if (var32 != null) {
                     for(var8 = (TileItem)var32.last(); var8 != null; var8 = (TileItem)var32.previous()) {
                        if ((var5 & 32767) == var8.id && var6 == var8.quantity) {
                           var8.remove();
                           break;
                        }
                     }

                     if (var32.last() == null) {
                        Client.groundItems[class383.Client_plane][var3][var4] = null;
                     }

                     class358.updateItemPile(var3, var4);
                  }
               }

            } else if (class276.field2549 == var0) {
               var2 = var1.readUnsignedByteA();
               var3 = var2 >> 2;
               var4 = var2 & 3;
               var5 = Client.OBJECT_TYPE_TO_STUB_TYPE[var3];
               var6 = var1.readUnsignedByteA();
               var7 = (var6 >> 4 & 7) + InvDefinition.regionChunkX;
               var31 = (var6 & 7) + class125.regionChunkY;
               if (var7 >= 0 && var31 >= 0 && var7 < 104 && var31 < 104) {
                  class11.updatePendingSpawn(class383.Client_plane, var7, var31, var5, -1, var3, var4, 31, 0, -1);
               }

            } else {
               if (class276.field2542 == var0) {
                  var2 = var1.readUnsignedByte();
                  var3 = var1.readUnsignedShortLEA();
                  var4 = var1.readUnsignedByteC();
                  var5 = (var4 >> 4 & 7) + InvDefinition.regionChunkX;
                  var6 = (var4 & 7) + class125.regionChunkY;
                  var7 = var1.readUnsignedByteA();
                  var31 = var7 >> 4 & 15;
                  var9 = var7 & 7;
                  if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     var10 = var31 + 1;
                     if (class155.localPlayer.pathX[0] >= var5 - var10 && class155.localPlayer.pathX[0] <= var5 + var10 && class155.localPlayer.pathY[0] >= var6 - var10 && class155.localPlayer.pathY[0] <= var10 + var6 && StructComposition.clientPreferences.getAreaSoundEffectsVolume() != 0 && var9 > 0 && Client.soundEffectCount < 50) {
                        Client.soundEffectIds[Client.soundEffectCount] = var3;
                        Client.queuedSoundEffectLoops[Client.soundEffectCount] = var9;
                        Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
                        Client.soundEffects[Client.soundEffectCount] = null;
                        Client.soundLocations[Client.soundEffectCount] = var31 + (var6 << 8) + (var5 << 16);
                        ++Client.soundEffectCount;
                     }
                  }
               }

               if (class276.field2547 == var0) {
                  var2 = var1.readUnsignedByteC();
                  var3 = var1.readUnsignedShortLE();
                  var4 = var1.readUnsignedShortA();
                  var5 = var1.readUnsignedByte() * 4;
                  var6 = var1.readUnsignedByteC();
                  var7 = (var6 >> 4 & 7) + InvDefinition.regionChunkX;
                  var31 = (var6 & 7) + class125.regionChunkY;
                  var9 = var1.readUnsignedByte() * 4;
                  var10 = var1.readUnsignedShortLE();
                  var39 = var1.readUnsignedByteC();
                  byte var40 = var1.readByteS();
                  var13 = var1.readByteC();
                  var42 = var1.method2348();
                  var41 = var13 + var7;
                  var12 = var40 + var31;
                  if (var7 >= 0 && var31 >= 0 && var7 < 104 && var31 < 104 && var41 >= 0 && var12 >= 0 && var41 < 104 && var12 < 104 && var4 != 65535) {
                     var7 = var7 * 128 + 64;
                     var31 = var31 * 128 + 64;
                     var41 = var41 * 128 + 64;
                     var12 = var12 * 128 + 64;
                     var15 = new Projectile(var4, class383.Client_plane, var7, var31, SpotAnimationDefinition.getTileHeight(var7, var31, class383.Client_plane) - var5, var10 + Client.cycle, var3 + Client.cycle, var2, var39, var42, var9);
                     var15.setDestination(var41, var12, SpotAnimationDefinition.getTileHeight(var41, var12, class383.Client_plane) - var9, var10 + Client.cycle);
                     Client.projectiles.addFirst(var15);
                  }

               } else if (class276.field2551 == var0) {
                  var2 = var1.readUnsignedShortA();
                  var3 = var1.readUnsignedShortLEA();
                  var4 = var1.readUnsignedByteS();
                  var5 = (var4 >> 4 & 7) + InvDefinition.regionChunkX;
                  var6 = (var4 & 7) + class125.regionChunkY;
                  var7 = var1.readUnsignedShortLE();
                  if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                     NodeDeque var37 = Client.groundItems[class383.Client_plane][var5][var6];
                     if (var37 != null) {
                        for(TileItem var33 = (TileItem)var37.last(); var33 != null; var33 = (TileItem)var37.previous()) {
                           if ((var7 & 32767) == var33.id && var3 == var33.quantity) {
                              var33.quantity = var2;
                              break;
                           }
                        }

                        class358.updateItemPile(var5, var6);
                     }
                  }

               } else {
                  if (class276.field2550 == var0) {
                     var2 = var1.readUnsignedByteA();
                     var3 = var2 >> 2;
                     var4 = var2 & 3;
                     var5 = Client.OBJECT_TYPE_TO_STUB_TYPE[var3];
                     var6 = var1.readUnsignedShortLE();
                     var7 = var1.readUnsignedShortA();
                     var31 = var1.readUnsignedByteA();
                     var9 = (var31 >> 4 & 7) + InvDefinition.regionChunkX;
                     var10 = (var31 & 7) + class125.regionChunkY;
                     byte var11 = var1.readByteS();
                     var12 = var1.readUnsignedShortLE();
                     var13 = var1.readByteS();
                     var14 = var1.readByte();
                     byte var34 = var1.readByteC();
                     int var16 = var1.readUnsignedShortA();
                     Player var17;
                     if (var16 == Client.localPlayerIndex) {
                        var17 = class155.localPlayer;
                     } else {
                        var17 = Client.players[var16];
                     }

                     if (var17 != null) {
                        ObjectComposition var18 = VarpDefinition.getObjectDefinition(var7);
                        int var19;
                        int var20;
                        if (var4 != 1 && var4 != 3) {
                           var19 = var18.sizeX;
                           var20 = var18.sizeY;
                        } else {
                           var19 = var18.sizeY;
                           var20 = var18.sizeX;
                        }

                        int var21 = var9 + (var19 >> 1);
                        int var22 = var9 + (var19 + 1 >> 1);
                        int var23 = var10 + (var20 >> 1);
                        int var24 = var10 + (var20 + 1 >> 1);
                        int[][] var25 = Tiles.Tiles_heights[class383.Client_plane];
                        int var26 = var25[var21][var24] + var25[var21][var23] + var25[var22][var23] + var25[var22][var24] >> 2;
                        int var27 = (var9 << 7) + (var19 << 6);
                        int var28 = (var10 << 7) + (var20 << 6);
                        Model var29 = var18.getModel(var3, var4, var25, var27, var26, var28);
                        if (var29 != null) {
                           class11.updatePendingSpawn(class383.Client_plane, var9, var10, var5, -1, 0, 0, 31, var6 + 1, var12 + 1);
                           var17.animationCycleStart = var6 + Client.cycle;
                           var17.animationCycleEnd = var12 + Client.cycle;
                           var17.attachedModel = var29;
                           var17.field892 = var19 * 64 + var9 * 128;
                           var17.field898 = var20 * 64 + var10 * 128;
                           var17.tileHeight2 = var26;
                           byte var30;
                           if (var14 > var11) {
                              var30 = var14;
                              var14 = var11;
                              var11 = var30;
                           }

                           if (var34 > var13) {
                              var30 = var34;
                              var34 = var13;
                              var13 = var30;
                           }

                           var17.minX = var9 + var14;
                           var17.maxX = var9 + var11;
                           var17.minY = var10 + var34;
                           var17.maxY = var10 + var13;
                        }
                     }
                  }

                  if (class276.field2553 == var0) {
                     var2 = var1.readUnsignedByteC();
                     var3 = (var2 >> 4 & 7) + InvDefinition.regionChunkX;
                     var4 = (var2 & 7) + class125.regionChunkY;
                     var5 = var1.readUnsignedShortLEA();
                     var6 = var1.readUnsignedByteA();
                     var7 = var6 >> 2;
                     var31 = var6 & 3;
                     var9 = Client.OBJECT_TYPE_TO_STUB_TYPE[var7];
                     if (var3 >= 0 && var4 >= 0 && var3 < 103 && var4 < 103) {
                        if (var9 == 0) {
                           BoundaryObject var35 = ReflectionCheck.scene.getWallObject(class383.Client_plane, var3, var4);
                           if (var35 != null) {
                              var39 = Occluder.Entity_unpackID(var35.tag);
                              if (var7 == 2) {
                                 var35.renderable1 = new DynamicObject(var39, 2, var31 + 4, class383.Client_plane, var3, var4, var5, false, var35.renderable1);
                                 var35.renderable2 = new DynamicObject(var39, 2, var31 + 1 & 3, class383.Client_plane, var3, var4, var5, false, var35.renderable2);
                              } else {
                                 var35.renderable1 = new DynamicObject(var39, var7, var31, class383.Client_plane, var3, var4, var5, false, var35.renderable1);
                              }
                           }
                        }

                        if (var9 == 1) {
                           WallDecoration var44 = ReflectionCheck.scene.getDecorativeObject(class383.Client_plane, var3, var4);
                           if (var44 != null) {
                              var39 = Occluder.Entity_unpackID(var44.tag);
                              if (var7 != 4 && var7 != 5) {
                                 if (var7 == 6) {
                                    var44.renderable1 = new DynamicObject(var39, 4, var31 + 4, class383.Client_plane, var3, var4, var5, false, var44.renderable1);
                                 } else if (var7 == 7) {
                                    var44.renderable1 = new DynamicObject(var39, 4, (var31 + 2 & 3) + 4, class383.Client_plane, var3, var4, var5, false, var44.renderable1);
                                 } else if (var7 == 8) {
                                    var44.renderable1 = new DynamicObject(var39, 4, var31 + 4, class383.Client_plane, var3, var4, var5, false, var44.renderable1);
                                    var44.renderable2 = new DynamicObject(var39, 4, (var31 + 2 & 3) + 4, class383.Client_plane, var3, var4, var5, false, var44.renderable2);
                                 }
                              } else {
                                 var44.renderable1 = new DynamicObject(var39, 4, var31, class383.Client_plane, var3, var4, var5, false, var44.renderable1);
                              }
                           }
                        }

                        if (var9 == 2) {
                           GameObject var45 = ReflectionCheck.scene.getGameObject(class383.Client_plane, var3, var4);
                           if (var7 == 11) {
                              var7 = 10;
                           }

                           if (var45 != null) {
                              var45.renderable = new DynamicObject(Occluder.Entity_unpackID(var45.tag), var7, var31, class383.Client_plane, var3, var4, var5, false, var45.renderable);
                           }
                        }

                        if (var9 == 3) {
                           FloorDecoration var46 = ReflectionCheck.scene.getFloorDecoration(class383.Client_plane, var3, var4);
                           if (var46 != null) {
                              var46.renderable = new DynamicObject(Occluder.Entity_unpackID(var46.tag), 22, var31, class383.Client_plane, var3, var4, var5, false, var46.renderable);
                           }
                        }
                     }

                  } else if (class276.field2544 == var0) {
                     var2 = var1.readUnsignedShortA();
                     var1.readUnsignedShort();
                     var3 = var1.readUnsignedByteA();
                     var4 = (var3 >> 4 & 7) + InvDefinition.regionChunkX;
                     var5 = (var3 & 7) + class125.regionChunkY;
                     if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                        NodeDeque var36 = Client.groundItems[class383.Client_plane][var4][var5];
                        if (var36 != null) {
                           for(TileItem var43 = (TileItem)var36.last(); var43 != null; var43 = (TileItem)var36.previous()) {
                              if ((var2 & 32767) == var43.id) {
                                 var43.remove();
                                 break;
                              }
                           }

                           if (var36.last() == null) {
                              Client.groundItems[class383.Client_plane][var4][var5] = null;
                           }

                           class358.updateItemPile(var4, var5);
                        }
                     }

                  } else if (class276.field2545 == var0) {
                     var2 = var1.readUnsignedShortLEA();
                     var3 = var1.readUnsignedByteC();
                     var4 = (var3 >> 4 & 7) + InvDefinition.regionChunkX;
                     var5 = (var3 & 7) + class125.regionChunkY;
                     var6 = var1.readUnsignedByteS();
                     if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
                        var32 = Client.groundItems[class383.Client_plane][var4][var5];
                        if (var32 != null) {
                           for(var8 = (TileItem)var32.last(); var8 != null; var8 = (TileItem)var32.previous()) {
                              if ((var2 & 32767) == var8.id) {
                                 var8.method603(var6);
                                 break;
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
