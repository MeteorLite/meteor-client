import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("br")
@Implements("Decimator")
public class Decimator {
    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "Lclient;"
    )
    static Client client;
    @ObfuscatedName("es")
    @ObfuscatedSignature(
            descriptor = "Lov;"
    )
    static AbstractSocket js5Socket;
    @ObfuscatedName("s")
    int inputRate;
    @ObfuscatedName("z")
    int outputRate;
    @ObfuscatedName("j")
    int[][] table;

   public Decimator(int var1, int var2) {
      if (var2 != var1) {
         int var4 = var1;
         int var5 = var2;
         if (var2 > var1) {
            var4 = var2;
            var5 = var1;
         }

         while(var5 != 0) {
            int var6 = var4 % var5;
            var4 = var5;
            var5 = var6;
         }

         var1 /= var4;
         var2 /= var4;
         this.inputRate = var1;
         this.outputRate = var2;
         this.table = new int[var1][14];

         for(int var7 = 0; var7 < var1; ++var7) {
            int[] var8 = this.table[var7];
            double var9 = (double)var7 / (double)var1 + 6.0D;
            int var11 = (int)Math.floor(1.0D + (var9 - 7.0D));
            if (var11 < 0) {
               var11 = 0;
            }

            int var12 = (int)Math.ceil(var9 + 7.0D);
            if (var12 > 14) {
               var12 = 14;
            }

            for(double var13 = (double)var2 / (double)var1; var11 < var12; ++var11) {
               double var15 = ((double)var11 - var9) * 3.141592653589793D;
               double var17 = var13;
               if (var15 < -1.0E-4D || var15 > 1.0E-4D) {
                  var17 = var13 * (Math.sin(var15) / var15);
               }

               var17 *= 0.54D + 0.46D * Math.cos(((double)var11 - var9) * 0.2243994752564138D);
               var8[var11] = (int)Math.floor(0.5D + var17 * 65536.0D);
            }
         }

      }
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "([BB)[B",
            garbageValue = "29"
    )
    byte[] resample(byte[] var1) {
      if (this.table != null) {
         int var2 = (int)((long)this.outputRate * (long)var1.length / (long)this.inputRate) + 14;
         int[] var3 = new int[var2];
         int var4 = 0;
         int var5 = 0;

         int var6;
         for(var6 = 0; var6 < var1.length; ++var6) {
            byte var7 = var1[var6];
            int[] var8 = this.table[var5];

            int var9;
            for(var9 = 0; var9 < 14; ++var9) {
               var3[var9 + var4] += var8[var9] * var7;
            }

            var5 += this.outputRate;
            var9 = var5 / this.inputRate;
            var4 += var9;
            var5 -= var9 * this.inputRate;
         }

         var1 = new byte[var2];

         for(var6 = 0; var6 < var2; ++var6) {
            int var10 = var3[var6] + '耀' >> 16;
            if (var10 < -128) {
               var1[var6] = -128;
            } else if (var10 > 127) {
               var1[var6] = 127;
            } else {
               var1[var6] = (byte)var10;
            }
         }
      }

      return var1;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(IB)I",
            garbageValue = "-23"
    )
    int scaleRate(int var1) {
      if (this.table != null) {
         var1 = (int)((long)this.outputRate * (long)var1 / (long)this.inputRate);
      }

      return var1;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(II)I",
            garbageValue = "-61929497"
    )
    int scalePosition(int var1) {
      if (this.table != null) {
         var1 = (int)((long)this.outputRate * (long)var1 / (long)this.inputRate) + 6;
      }

      return var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;I)J",
      garbageValue = "-1891594649"
   )
   public static long method308(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if (var5 >= 'A' && var5 <= 'Z') {
            var1 += (long)(var5 + 1 - 65);
         } else if (var5 >= 'a' && var5 <= 'z') {
            var1 += (long)(var5 + 1 - 97);
         } else if (var5 >= '0' && var5 <= '9') {
            var1 += (long)(var5 + 27 - 48);
         }

         if (var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && 0L != var1) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-383062820"
   )
   static final void method306(String var0) {
      ZoneOperation.addGameMessage(30, "", var0);
   }

    @ObfuscatedName("he")
    @ObfuscatedSignature(
            descriptor = "(Lcl;ZI)V",
            garbageValue = "-1568414212"
    )
    static void addPlayerToScene(Player var0, boolean var1) {
      if (var0 != null && var0.isVisible() && !var0.isHidden) {
         var0.isUnanimated = false;
         if ((Client.isLowDetail && Players.Players_count > 50 || Players.Players_count > 200) && var1 && var0.idleSequence == var0.movementSequence) {
            var0.isUnanimated = true;
         }

         int var2 = var0.x >> 7;
         int var3 = var0.y >> 7;
         if (var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
            long var4 = ItemLayer.calculateTag(0, 0, 0, false, var0.index);
            if (var0.attachedModel != null && Client.cycle >= var0.animationCycleStart && Client.cycle < var0.animationCycleEnd) {
               var0.isUnanimated = false;
               var0.tileHeight = GrandExchangeOfferNameComparator.getTileHeight(var0.x, var0.y, class103.Client_plane);
               var0.playerCycle = Client.cycle;
               WorldMapAreaData.scene.addNullableObject(class103.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.minX, var0.minY, var0.maxX, var0.maxY);
            } else {
               if ((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if (Client.tileLastDrawnActor[var2][var3] == Client.viewportDrawCount) {
                     return;
                  }

                  Client.tileLastDrawnActor[var2][var3] = Client.viewportDrawCount;
               }

               var0.tileHeight = GrandExchangeOfferNameComparator.getTileHeight(var0.x, var0.y, class103.Client_plane);
               var0.playerCycle = Client.cycle;
               WorldMapAreaData.scene.drawEntity(class103.Client_plane, var0.x, var0.y, var0.tileHeight, 60, var0, var0.rotation, var4, var0.isWalking);
            }
         }
      }

   }

    @ObfuscatedName("iu")
    @ObfuscatedSignature(
            descriptor = "(Ljs;B)V",
            garbageValue = "0"
    )
    static final void processZoneOperation(ZoneOperation var0) {
      PacketBuffer var1 = Client.packetWriter.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      if (ZoneOperation.field2546 == var0) {
         var2 = var1.readUnsignedByteS();
         var3 = var1.readUnsignedByte();
         var4 = var3 >> 2;
         var5 = var3 & 3;
         var6 = Client.OBJECT_TYPE_TO_STUB_TYPE[var4];
         var7 = var1.readUnsignedByte();
         var8 = (var7 >> 4 & 7) + class373.field3599;
         var9 = (var7 & 7) + KeyHandler.field86;
         if (var8 >= 0 && var9 >= 0 && var8 < 103 && var9 < 103) {
            if (var6 == 0) {
               BoundaryObject var10 = WorldMapAreaData.scene.method1200(class103.Client_plane, var8, var9);
               if (var10 != null) {
                  var11 = class124.Entity_unpackID(var10.tag);
                  if (var4 == 2) {
                     var10.renderable1 = new DynamicObject(var11, 2, var5 + 4, class103.Client_plane, var8, var9, var2, false, var10.renderable1);
                     var10.renderable2 = new DynamicObject(var11, 2, var5 + 1 & 3, class103.Client_plane, var8, var9, var2, false, var10.renderable2);
                  } else {
                     var10.renderable1 = new DynamicObject(var11, var4, var5, class103.Client_plane, var8, var9, var2, false, var10.renderable1);
                  }
               }
            }

            if (var6 == 1) {
               WallDecoration var39 = WorldMapAreaData.scene.method1201(class103.Client_plane, var8, var9);
               if (var39 != null) {
                  var11 = class124.Entity_unpackID(var39.tag);
                  if (var4 != 4 && var4 != 5) {
                     if (var4 == 6) {
                        var39.renderable1 = new DynamicObject(var11, 4, var5 + 4, class103.Client_plane, var8, var9, var2, false, var39.renderable1);
                     } else if (var4 == 7) {
                        var39.renderable1 = new DynamicObject(var11, 4, (var5 + 2 & 3) + 4, class103.Client_plane, var8, var9, var2, false, var39.renderable1);
                     } else if (var4 == 8) {
                        var39.renderable1 = new DynamicObject(var11, 4, var5 + 4, class103.Client_plane, var8, var9, var2, false, var39.renderable1);
                        var39.renderable2 = new DynamicObject(var11, 4, (var5 + 2 & 3) + 4, class103.Client_plane, var8, var9, var2, false, var39.renderable2);
                     }
                  } else {
                     var39.renderable1 = new DynamicObject(var11, 4, var5, class103.Client_plane, var8, var9, var2, false, var39.renderable1);
                  }
               }
            }

            if (var6 == 2) {
               GameObject var40 = WorldMapAreaData.scene.getGameObject(class103.Client_plane, var8, var9);
               if (var4 == 11) {
                  var4 = 10;
               }

               if (var40 != null) {
                  var40.renderable = new DynamicObject(class124.Entity_unpackID(var40.tag), var4, var5, class103.Client_plane, var8, var9, var2, false, var40.renderable);
               }
            }

            if (var6 == 3) {
               FloorDecoration var41 = WorldMapAreaData.scene.getFloorDecoration(class103.Client_plane, var8, var9);
               if (var41 != null) {
                  var41.renderable = new DynamicObject(class124.Entity_unpackID(var41.tag), 22, var5, class103.Client_plane, var8, var9, var2, false, var41.renderable);
               }
            }
         }

      } else {
         TileItem var45;
         if (ZoneOperation.field2549 == var0) {
            var2 = var1.readUnsignedByte();
            var3 = (var2 >> 4 & 7) + class373.field3599;
            var4 = (var2 & 7) + KeyHandler.field86;
            var5 = var1.method2401();
            var1.method2401();
            var1.readUnsignedShortLEA();
            var6 = var1.readUnsignedByteS();
            var7 = var1.readInt();
            var1.method2401();
            var1.readUnsignedByteS();
            if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
               var45 = new TileItem();
               var45.id = var6;
               var45.quantity = var7;
               var45.method594(var5);
               if (Client.groundItems[class103.Client_plane][var3][var4] == null) {
                  Client.groundItems[class103.Client_plane][var3][var4] = new NodeDeque();
               }

               Client.groundItems[class103.Client_plane][var3][var4].addFirst(var45);
               ClientPacket.updateItemPile(var3, var4);
            }

         } else {
            int var32;
            if (ZoneOperation.field2550 == var0) {
               var2 = var1.readUnsignedShortLEA();
               var3 = var1.readUnsignedShortA();
               var4 = var3 >> 4 & 15;
               var5 = var3 & 7;
               var6 = var1.method2401();
               var7 = var1.method2401();
               var8 = (var7 >> 4 & 7) + class373.field3599;
               var9 = (var7 & 7) + KeyHandler.field86;
               if (var8 >= 0 && var9 >= 0 && var8 < 104 && var9 < 104) {
                  var32 = var4 + 1;
                  if (class387.localPlayer.pathX[0] >= var8 - var32 && class387.localPlayer.pathX[0] <= var32 + var8 && class387.localPlayer.pathY[0] >= var9 - var32 && class387.localPlayer.pathY[0] <= var32 + var9 && PacketWriter.clientPreferences.getAreaSoundEffectsVolume() != 0 && var5 > 0 && Client.soundEffectCount < 50) {
                     Client.soundEffectIds[Client.soundEffectCount] = var2;
                     Client.queuedSoundEffectLoops[Client.soundEffectCount] = var5;
                     Client.queuedSoundEffectDelays[Client.soundEffectCount] = var6;
                     Client.soundEffects[Client.soundEffectCount] = null;
                     Client.soundLocations[Client.soundEffectCount] = var4 + (var9 << 8) + (var8 << 16);
                     ++Client.soundEffectCount;
                  }
               }
            }

            NodeDeque var33;
            if (ZoneOperation.field2542 == var0) {
               var2 = var1.method2401();
               var3 = (var2 >> 4 & 7) + class373.field3599;
               var4 = (var2 & 7) + KeyHandler.field86;
               var5 = var1.readUnsignedShortLEA();
               var6 = var1.method2416();
               if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  var33 = Client.groundItems[class103.Client_plane][var3][var4];
                  if (var33 != null) {
                     for(var45 = (TileItem)var33.last(); var45 != null; var45 = (TileItem)var33.previous()) {
                        if ((var5 & 32767) == var45.id && var6 == var45.quantity) {
                           var45.remove();
                           break;
                        }
                     }

                     if (var33.last() == null) {
                        Client.groundItems[class103.Client_plane][var3][var4] = null;
                     }

                     ClientPacket.updateItemPile(var3, var4);
                  }
               }

            } else if (ZoneOperation.field2539 == var0) {
               var2 = var1.readUnsignedByte();
               var3 = (var2 >> 4 & 7) + class373.field3599;
               var4 = (var2 & 7) + KeyHandler.field86;
               var5 = var1.readUnsignedByteA();
               var6 = var5 >> 2;
               var7 = var5 & 3;
               var8 = Client.OBJECT_TYPE_TO_STUB_TYPE[var6];
               if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                  ObjTypeCustomisation.updatePendingSpawn(class103.Client_plane, var3, var4, var8, -1, var6, var7, 31, 0, -1);
               }

            } else if (ZoneOperation.field2544 == var0) {
               var2 = var1.method2401();
               var3 = var1.readUnsignedShortLEA();
               var4 = var1.readUnsignedShortA();
               var5 = (var4 >> 4 & 7) + class373.field3599;
               var6 = (var4 & 7) + KeyHandler.field86;
               var7 = var1.readUnsignedByte();
               var8 = var7 >> 2;
               var9 = var7 & 3;
               var32 = Client.OBJECT_TYPE_TO_STUB_TYPE[var8];
               if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  ObjTypeCustomisation.updatePendingSpawn(class103.Client_plane, var5, var6, var32, var3, var8, var9, var2, 0, -1);
               }

            } else {
               NodeDeque var31;
               TileItem var34;
               if (ZoneOperation.field2543 == var0) {
                  var2 = var1.readUnsignedShortLEA();
                  var3 = var1.readUnsignedShortLE();
                  var4 = var1.readUnsignedShortLE();
                  var5 = var1.method2401();
                  var6 = (var5 >> 4 & 7) + class373.field3599;
                  var7 = (var5 & 7) + KeyHandler.field86;
                  if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                     var31 = Client.groundItems[class103.Client_plane][var6][var7];
                     if (var31 != null) {
                        for(var34 = (TileItem)var31.last(); var34 != null; var34 = (TileItem)var31.previous()) {
                           if ((var3 & 32767) == var34.id && var4 == var34.quantity) {
                              var34.quantity = var2;
                              break;
                           }
                        }

                        ClientPacket.updateItemPile(var6, var7);
                     }
                  }

               } else if (ZoneOperation.field2548 == var0) {
                  var2 = var1.readUnsignedByte();
                  var3 = (var2 >> 4 & 7) + class373.field3599;
                  var4 = (var2 & 7) + KeyHandler.field86;
                  var5 = var1.method2401();
                  var6 = var1.readUnsignedShort();
                  if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                     var33 = Client.groundItems[class103.Client_plane][var3][var4];
                     if (var33 != null) {
                        for(var45 = (TileItem)var33.last(); var45 != null; var45 = (TileItem)var33.previous()) {
                           if ((var6 & 32767) == var45.id) {
                              var45.method594(var5);
                              break;
                           }
                        }
                     }
                  }

               } else {
                  int var12;
                  int var13;
                  int var14;
                  byte var46;
                  if (ZoneOperation.field2540 == var0) {
                     var2 = var1.readUnsignedShort();
                     byte var36 = var1.readByte();
                     byte var37 = var1.method2431();
                     var5 = var1.readUnsignedByteS();
                     var6 = var1.method2401();
                     var7 = var6 >> 2;
                     var8 = var6 & 3;
                     var9 = Client.OBJECT_TYPE_TO_STUB_TYPE[var7];
                     var46 = var1.readByte();
                     var11 = var1.readUnsignedShort();
                     var12 = var1.readUnsignedByteA();
                     var13 = (var12 >> 4 & 7) + class373.field3599;
                     var14 = (var12 & 7) + KeyHandler.field86;
                     int var15 = var1.readUnsignedByteS();
                     byte var16 = var1.method2404();
                     Player var17;
                     if (var15 == Client.localPlayerIndex) {
                        var17 = class387.localPlayer;
                     } else {
                        var17 = Client.players[var15];
                     }

                     if (var17 != null) {
                        ObjectComposition var18 = class463.getObjectDefinition(var2);
                        int var19;
                        int var20;
                        if (var8 != 1 && var8 != 3) {
                           var19 = var18.sizeX;
                           var20 = var18.sizeY;
                        } else {
                           var19 = var18.sizeY;
                           var20 = var18.sizeX;
                        }

                        int var21 = var13 + (var19 >> 1);
                        int var22 = var13 + (var19 + 1 >> 1);
                        int var23 = var14 + (var20 >> 1);
                        int var24 = var14 + (var20 + 1 >> 1);
                        int[][] var25 = Tiles.Tiles_heights[class103.Client_plane];
                        int var26 = var25[var21][var23] + var25[var22][var23] + var25[var21][var24] + var25[var22][var24] >> 2;
                        int var27 = (var13 << 7) + (var19 << 6);
                        int var28 = (var14 << 7) + (var20 << 6);
                        Model var29 = var18.getModel(var7, var8, var25, var27, var26, var28);
                        if (var29 != null) {
                           ObjTypeCustomisation.updatePendingSpawn(class103.Client_plane, var13, var14, var9, -1, 0, 0, 31, var5 + 1, var11 + 1);
                           var17.animationCycleStart = var5 + Client.cycle;
                           var17.animationCycleEnd = var11 + Client.cycle;
                           var17.attachedModel = var29;
                           var17.field902 = var19 * 64 + var13 * 128;
                           var17.field908 = var20 * 64 + var14 * 128;
                           var17.baseTileHeight = var26;
                           byte var30;
                           if (var46 > var16) {
                              var30 = var46;
                              var46 = var16;
                              var16 = var30;
                           }

                           if (var36 > var37) {
                              var30 = var36;
                              var36 = var37;
                              var37 = var30;
                           }

                           var17.minX = var46 + var13;
                           var17.maxX = var13 + var16;
                           var17.minY = var36 + var14;
                           var17.maxY = var37 + var14;
                        }
                     }
                  }

                  if (ZoneOperation.field2545 != var0) {
                     Projectile var35;
                     if (ZoneOperation.field2541 == var0) {
                        var2 = var1.readUnsignedShortLE();
                        var3 = var1.readUnsignedByte();
                        var4 = var1.method2413();
                        var5 = var1.readUnsignedByteA();
                        var6 = var1.method2401() * 4;
                        var7 = var1.readUnsignedShortA() * 4;
                        var8 = var1.readUnsignedByteS();
                        var9 = var1.readUnsignedByteS();
                        var46 = var1.method2431();
                        byte var42 = var1.method2442();
                        var12 = var1.readUnsignedShortA();
                        var13 = (var12 >> 4 & 7) + class373.field3599;
                        var14 = (var12 & 7) + KeyHandler.field86;
                        var11 = var42 + var13;
                        var32 = var46 + var14;
                        if (var13 >= 0 && var14 >= 0 && var13 < 104 && var14 < 104 && var11 >= 0 && var32 >= 0 && var11 < 104 && var32 < 104 && var2 != 65535) {
                           var13 = var13 * 128 + 64;
                           var14 = var14 * 128 + 64;
                           var11 = var11 * 128 + 64;
                           var32 = var32 * 128 + 64;
                           var35 = new Projectile(var2, class103.Client_plane, var13, var14, GrandExchangeOfferNameComparator.getTileHeight(var13, var14, class103.Client_plane) - var7, var8 + Client.cycle, var9 + Client.cycle, var3, var5, var4, var6);
                           var35.setDestination(var11, var32, GrandExchangeOfferNameComparator.getTileHeight(var11, var32, class103.Client_plane) - var6, var8 + Client.cycle);
                           Client.projectiles.addFirst(var35);
                        }

                     } else if (ZoneOperation.field2547 == var0) {
                        var2 = var1.readUnsignedByte();
                        var3 = var1.readUnsignedByteA();
                        var4 = (var3 >> 4 & 7) + class373.field3599;
                        var5 = (var3 & 7) + KeyHandler.field86;
                        var6 = var1.readUnsignedByteS();
                        var7 = var1.readUnsignedByte();
                        byte var38 = var1.method2404();
                        var9 = var1.readUnsignedShortLE();
                        var32 = var1.readUnsignedShortA() * 4;
                        var11 = var1.method2409();
                        var12 = var1.method2401() * 4;
                        var13 = var1.readUnsignedShortLEA();
                        byte var43 = var1.method2442();
                        var14 = var43 + var4;
                        var8 = var38 + var5;
                        if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104 && var14 >= 0 && var8 >= 0 && var14 < 104 && var8 < 104 && var6 != 65535) {
                           var4 = var4 * 128 + 64;
                           var5 = var5 * 128 + 64;
                           var14 = var14 * 128 + 64;
                           var8 = var8 * 128 + 64;
                           var35 = new Projectile(var6, class103.Client_plane, var4, var5, GrandExchangeOfferNameComparator.getTileHeight(var4, var5, class103.Client_plane) - var12, var9 + Client.cycle, var13 + Client.cycle, var2, var7, var11, var32);
                           var35.setDestination(var14, var8, GrandExchangeOfferNameComparator.getTileHeight(var14, var8, class103.Client_plane) - var32, var9 + Client.cycle);
                           Client.projectiles.addFirst(var35);
                        }

                     } else if (ZoneOperation.field2551 == var0) {
                        var2 = var1.readUnsignedShortA();
                        var3 = (var2 >> 4 & 7) + class373.field3599;
                        var4 = (var2 & 7) + KeyHandler.field86;
                        var5 = var1.readUnsignedShortLE();
                        var6 = var1.readUnsignedByteA();
                        var7 = var1.readUnsignedShort();
                        if (var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104) {
                           var3 = var3 * 128 + 64;
                           var4 = var4 * 128 + 64;
                           GraphicsObject var44 = new GraphicsObject(var7, class103.Client_plane, var3, var4, GrandExchangeOfferNameComparator.getTileHeight(var3, var4, class103.Client_plane) - var6, var5, Client.cycle);
                           Client.graphicsObjects.addFirst(var44);
                        }

                     }
                  } else {
                     var2 = var1.readUnsignedShortLE();
                     var3 = var1.method2415();
                     var4 = var1.method2416();
                     var5 = var1.readUnsignedByte();
                     var6 = (var5 >> 4 & 7) + class373.field3599;
                     var7 = (var5 & 7) + KeyHandler.field86;
                     if (var6 >= 0 && var7 >= 0 && var6 < 104 && var7 < 104) {
                        var31 = Client.groundItems[class103.Client_plane][var6][var7];
                        if (var31 != null) {
                           for(var34 = (TileItem)var31.last(); var34 != null; var34 = (TileItem)var31.previous()) {
                              if ((var2 & 32767) == var34.id && var3 == var34.quantity) {
                                 var34.quantity = var4;
                                 break;
                              }
                           }

                           ClientPacket.updateItemPile(var6, var7);
                        }
                     }

                  }
               }
            }
         }
      }
   }
}
