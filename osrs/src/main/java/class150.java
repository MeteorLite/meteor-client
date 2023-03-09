import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class150 extends class140 {
   @ObfuscatedName("ap")
   static int[] field1331;
   @ObfuscatedName("aj")
   int field1333;
   @ObfuscatedName("al")
   String field1332;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class150(class143 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      this.field1333 = var1.readInt();
      this.field1332 = var1.readStringCp1252NullTerminated();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method802(this.field1333, this.field1332);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "([BIIB)Z",
      garbageValue = "67"
   )
   static final boolean method787(byte[] var0, int var1, int var2) {
      boolean var3 = true;
      Buffer var4 = new Buffer(var0);
      int var5 = -1;

      label57:
      while(true) {
         int var6 = var4.method2451();
         if (var6 == 0) {
            return var3;
         }

         var5 += var6;
         int var7 = 0;
         boolean var8 = false;

         while(true) {
            int var9;
            while(!var8) {
               var9 = var4.readUShortSmart();
               if (var9 == 0) {
                  continue label57;
               }

               var7 += var9 - 1;
               int var10 = var7 & 63;
               int var11 = var7 >> 6 & 63;
               int var12 = var4.readUnsignedByte() >> 2;
               int var13 = var11 + var1;
               int var14 = var10 + var2;
               if (var13 > 0 && var14 > 0 && var13 < 103 && var14 < 103) {
                  ObjectComposition var15 = WallDecoration.getObjectDefinition(var5);
                  if (var12 != 22 || !Client.isLowDetail || var15.int1 != 0 || var15.interactType == 1 || var15.boolean2) {
                     if (!var15.needsModelFiles()) {
                        ++Client.field422;
                        var3 = false;
                     }

                     var8 = true;
                  }
               }
            }

            var9 = var4.readUShortSmart();
            if (var9 == 0) {
               break;
            }

            var4.readUnsignedByte();
         }
      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "2036952880"
   )
   static int method783(int var0, Script var1, boolean var2) {
      Widget var3 = WorldMapSection1.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      if (var0 == 2500) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if (var0 == 2501) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if (var0 == 2502) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if (var0 == 2503) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if (var0 == 2504) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
         return 1;
      } else if (var0 == 2505) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      descriptor = "(Lkz;I)V",
      garbageValue = "-1653447364"
   )
   @Export("processZoneOperation")
   static final void processZoneOperation(ZoneOperation var0) {
      PacketBuffer var1 = Client.packetWriter.packetBuffer;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      NodeDeque var7;
      TileItem var39;
      if (ZoneOperation.field2518 == var0) {
         var2 = var1.readUnsignedShort();
         var3 = var1.method2430();
         var4 = (var3 >> 4 & 7) + ZoneOperation.field2529;
         var5 = (var3 & 7) + class149.field1330;
         var6 = var1.readUnsignedByte();
         if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
            var7 = Client.groundItems[TaskHandler.Client_plane][var4][var5];
            if (var7 != null) {
               for(var39 = (TileItem)var7.last(); var39 != null; var39 = (TileItem)var7.previous()) {
                  if ((var2 & 32767) == var39.id) {
                     var39.method592(var6);
                     break;
                  }
               }
            }
         }

      } else {
         int var9;
         int var10;
         int var31;
         int var32;
         if (ZoneOperation.field2522 == var0) {
            var2 = var1.readUnsignedShortA();
            var3 = var2 >> 4 & 15;
            var4 = var2 & 7;
            var5 = var1.readUnsignedByte();
            var6 = (var5 >> 4 & 7) + ZoneOperation.field2529;
            var31 = (var5 & 7) + class149.field1330;
            var32 = var1.readUnsignedShortLE();
            var9 = var1.readUnsignedByte();
            if (var6 >= 0 && var31 >= 0 && var6 < 104 && var31 < 104) {
               var10 = var3 + 1;
               if (BuddyRankComparator.localPlayer.pathX[0] >= var6 - var10 && BuddyRankComparator.localPlayer.pathX[0] <= var10 + var6 && BuddyRankComparator.localPlayer.pathY[0] >= var31 - var10 && BuddyRankComparator.localPlayer.pathY[0] <= var10 + var31 && WorldMapSectionType.clientPreferences.getAreaSoundEffectsVolume() != 0 && var4 > 0 && Client.soundEffectCount < 50) {
                  Client.soundEffectIds[Client.soundEffectCount] = var32;
                  Client.queuedSoundEffectLoops[Client.soundEffectCount] = var4;
                  Client.queuedSoundEffectDelays[Client.soundEffectCount] = var9;
                  Client.soundEffects[Client.soundEffectCount] = null;
                  Client.soundLocations[Client.soundEffectCount] = var3 + (var31 << 8) + (var6 << 16);
                  ++Client.soundEffectCount;
               }
            }
         }

         int var11;
         if (ZoneOperation.field2523 == var0) {
            var2 = var1.readUnsignedShortA();
            var3 = var2 >> 2;
            var4 = var2 & 3;
            var5 = Client.OBJECT_TYPE_TO_STUB_TYPE[var3];
            var6 = var1.readUnsignedShortA();
            var31 = (var6 >> 4 & 7) + ZoneOperation.field2529;
            var32 = (var6 & 7) + class149.field1330;
            var9 = var1.readUnsignedShort();
            if (var31 >= 0 && var32 >= 0 && var31 < 103 && var32 < 103) {
               if (var5 == 0) {
                  BoundaryObject var33 = class1.scene.method1203(TaskHandler.Client_plane, var31, var32);
                  if (var33 != null) {
                     var11 = class279.Entity_unpackID(var33.tag);
                     if (var3 == 2) {
                        var33.renderable1 = new DynamicObject(var11, 2, var4 + 4, TaskHandler.Client_plane, var31, var32, var9, false, var33.renderable1);
                        var33.renderable2 = new DynamicObject(var11, 2, var4 + 1 & 3, TaskHandler.Client_plane, var31, var32, var9, false, var33.renderable2);
                     } else {
                        var33.renderable1 = new DynamicObject(var11, var3, var4, TaskHandler.Client_plane, var31, var32, var9, false, var33.renderable1);
                     }

                     return;
                  }
               }

               if (var5 == 1) {
                  WallDecoration var43 = class1.scene.method1204(TaskHandler.Client_plane, var31, var32);
                  if (var43 != null) {
                     var11 = class279.Entity_unpackID(var43.tag);
                     if (var3 != 4 && var3 != 5) {
                        if (var3 == 6) {
                           var43.renderable1 = new DynamicObject(var11, 4, var4 + 4, TaskHandler.Client_plane, var31, var32, var9, false, var43.renderable1);
                        } else if (var3 == 7) {
                           var43.renderable1 = new DynamicObject(var11, 4, (var4 + 2 & 3) + 4, TaskHandler.Client_plane, var31, var32, var9, false, var43.renderable1);
                        } else if (var3 == 8) {
                           var43.renderable1 = new DynamicObject(var11, 4, var4 + 4, TaskHandler.Client_plane, var31, var32, var9, false, var43.renderable1);
                           var43.renderable2 = new DynamicObject(var11, 4, (var4 + 2 & 3) + 4, TaskHandler.Client_plane, var31, var32, var9, false, var43.renderable2);
                        }
                     } else {
                        var43.renderable1 = new DynamicObject(var11, 4, var4, TaskHandler.Client_plane, var31, var32, var9, false, var43.renderable1);
                     }

                     return;
                  }
               }

               if (var5 == 2) {
                  GameObject var44 = class1.scene.getGameObject(TaskHandler.Client_plane, var31, var32);
                  if (var3 == 11) {
                     var3 = 10;
                  }

                  if (var44 != null) {
                     var44.renderable = new DynamicObject(class279.Entity_unpackID(var44.tag), var3, var4, TaskHandler.Client_plane, var31, var32, var9, false, var44.renderable);
                     return;
                  }
               }

               if (var5 == 3) {
                  FloorDecoration var45 = class1.scene.getFloorDecoration(TaskHandler.Client_plane, var31, var32);
                  if (var45 != null) {
                     var45.renderable = new DynamicObject(class279.Entity_unpackID(var45.tag), 22, var4, TaskHandler.Client_plane, var31, var32, var9, false, var45.renderable);
                     return;
                  }
               }

               class140.method752(TaskHandler.Client_plane, var31, var32, var5, var9);
            }

         } else if (ZoneOperation.field2524 == var0) {
            var2 = var1.method2437();
            var3 = var1.readInt();
            var4 = var1.method2430();
            var5 = (var4 >> 4 & 7) + ZoneOperation.field2529;
            var6 = (var4 & 7) + class149.field1330;
            var31 = var1.readInt();
            if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               NodeDeque var40 = Client.groundItems[TaskHandler.Client_plane][var5][var6];
               if (var40 != null) {
                  for(TileItem var34 = (TileItem)var40.last(); var34 != null; var34 = (TileItem)var40.previous()) {
                     if ((var2 & 32767) == var34.id && var31 == var34.quantity) {
                        var34.quantity = var3;
                        break;
                     }
                  }

                  class148.updateItemPile(var5, var6);
               }
            }

         } else if (ZoneOperation.field2519 == var0) {
            var2 = var1.readUnsignedShort();
            var3 = var1.method2455();
            var4 = var1.readUnsignedByte();
            var5 = (var4 >> 4 & 7) + ZoneOperation.field2529;
            var6 = (var4 & 7) + class149.field1330;
            if (var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
               var7 = Client.groundItems[TaskHandler.Client_plane][var5][var6];
               if (var7 != null) {
                  for(var39 = (TileItem)var7.last(); var39 != null; var39 = (TileItem)var7.previous()) {
                     if ((var2 & 32767) == var39.id && var3 == var39.quantity) {
                        var39.remove();
                        break;
                     }
                  }

                  if (var7.last() == null) {
                     Client.groundItems[TaskHandler.Client_plane][var5][var6] = null;
                  }

                  class148.updateItemPile(var5, var6);
               }
            }

         } else if (ZoneOperation.field2521 == var0) {
            var2 = var1.method2405();
            var3 = var1.readUnsignedShortLEA();
            var4 = var1.method2405();
            var5 = var4 >> 2;
            var6 = var4 & 3;
            var31 = Client.OBJECT_TYPE_TO_STUB_TYPE[var5];
            var32 = var1.readUnsignedByte();
            var9 = (var32 >> 4 & 7) + ZoneOperation.field2529;
            var10 = (var32 & 7) + class149.field1330;
            if (var9 >= 0 && var10 >= 0 && var9 < 104 && var10 < 104) {
               Decimator.updatePendingSpawn(TaskHandler.Client_plane, var9, var10, var31, var3, var5, var6, var2, 0, -1);
            }

         } else if (ZoneOperation.field2520 == var0) {
            var1.readUnsignedShortLE();
            var2 = var1.method2430();
            var3 = var1.readUnsignedShortLE();
            var1.method2405();
            var1.readUnsignedShort();
            var4 = var1.method2455();
            var1.method2405();
            var5 = var1.method2430();
            var6 = (var5 >> 4 & 7) + ZoneOperation.field2529;
            var31 = (var5 & 7) + class149.field1330;
            if (var6 >= 0 && var31 >= 0 && var6 < 104 && var31 < 104) {
               var39 = new TileItem();
               var39.id = var3;
               var39.quantity = var4;
               var39.method592(var2);
               if (Client.groundItems[TaskHandler.Client_plane][var6][var31] == null) {
                  Client.groundItems[TaskHandler.Client_plane][var6][var31] = new NodeDeque();
               }

               Client.groundItems[TaskHandler.Client_plane][var6][var31].addFirst(var39);
               class148.updateItemPile(var6, var31);
            }

         } else if (ZoneOperation.field2528 == var0) {
            var2 = var1.method2437();
            var3 = var1.readUnsignedShortA();
            var4 = (var3 >> 4 & 7) + ZoneOperation.field2529;
            var5 = (var3 & 7) + class149.field1330;
            var6 = var1.readUnsignedShortLEA();
            var31 = var1.readUnsignedByte();
            if (var4 >= 0 && var5 >= 0 && var4 < 104 && var5 < 104) {
               var4 = var4 * 128 + 64;
               var5 = var5 * 128 + 64;
               GraphicsObject var8 = new GraphicsObject(var6, TaskHandler.Client_plane, var4, var5, WorldMapDecorationType.getTileHeight(var4, var5, TaskHandler.Client_plane) - var31, var2, Client.cycle);
               Client.graphicsObjects.addFirst(var8);
            }

         } else {
            int var12;
            int var13;
            int var14;
            if (ZoneOperation.field2526 == var0) {
               var2 = var1.method2450();
               byte var37 = var1.method2396();
               var4 = var1.method2405() * 4;
               byte var38 = var1.readByte();
               var6 = var1.method2437();
               var31 = var1.readUnsignedByte();
               var32 = var1.method2437();
               var9 = var1.readUnsignedByte() * 4;
               var10 = var1.readUnsignedShortA();
               var11 = var1.readUnsignedShortA();
               var12 = (var11 >> 4 & 7) + ZoneOperation.field2529;
               var13 = (var11 & 7) + class149.field1330;
               var14 = var1.readUnsignedShortLE();
               var5 = var38 + var12;
               var3 = var37 + var13;
               if (var12 >= 0 && var13 >= 0 && var12 < 104 && var13 < 104 && var5 >= 0 && var3 >= 0 && var5 < 104 && var3 < 104 && var32 != 65535) {
                  var12 = var12 * 128 + 64;
                  var13 = var13 * 128 + 64;
                  var5 = var5 * 128 + 64;
                  var3 = var3 * 128 + 64;
                  Projectile var15 = new Projectile(var32, TaskHandler.Client_plane, var12, var13, WorldMapDecorationType.getTileHeight(var12, var13, TaskHandler.Client_plane) - var4, var14 + Client.cycle, var6 + Client.cycle, var10, var31, var2, var9);
                  var15.setDestination(var5, var3, WorldMapDecorationType.getTileHeight(var5, var3, TaskHandler.Client_plane) - var9, var14 + Client.cycle);
                  Client.projectiles.addFirst(var15);
               }

            } else if (ZoneOperation.field2527 == var0) {
               var2 = var1.readUnsignedByte();
               var3 = var2 >> 2;
               var4 = var2 & 3;
               var5 = Client.OBJECT_TYPE_TO_STUB_TYPE[var3];
               var6 = var1.readUnsignedByte();
               var31 = (var6 >> 4 & 7) + ZoneOperation.field2529;
               var32 = (var6 & 7) + class149.field1330;
               if (var31 >= 0 && var32 >= 0 && var31 < 104 && var32 < 104) {
                  Decimator.updatePendingSpawn(TaskHandler.Client_plane, var31, var32, var5, -1, var3, var4, 31, 0, -1);
               }

            } else {
               if (ZoneOperation.field2525 == var0) {
                  byte var36 = var1.method2396();
                  var3 = var1.readUnsignedShortA();
                  var4 = (var3 >> 4 & 7) + ZoneOperation.field2529;
                  var5 = (var3 & 7) + class149.field1330;
                  var6 = var1.readUnsignedShortLEA();
                  byte var42 = var1.method2432();
                  var32 = var1.method2437();
                  byte var41 = var1.method2433();
                  var10 = var1.readUnsignedShort();
                  var11 = var1.readUnsignedShortA();
                  var12 = var11 >> 2;
                  var13 = var11 & 3;
                  var14 = Client.OBJECT_TYPE_TO_STUB_TYPE[var12];
                  int var35 = var1.readUnsignedShort();
                  byte var16 = var1.method2433();
                  Player var17;
                  if (var6 == Client.localPlayerIndex) {
                     var17 = BuddyRankComparator.localPlayer;
                  } else {
                     var17 = Client.players[var6];
                  }

                  if (var17 != null) {
                     ObjectComposition var18 = WallDecoration.getObjectDefinition(var32);
                     int var19;
                     int var20;
                     if (var13 != 1 && var13 != 3) {
                        var19 = var18.sizeX;
                        var20 = var18.sizeY;
                     } else {
                        var19 = var18.sizeY;
                        var20 = var18.sizeX;
                     }

                     int var21 = var4 + (var19 >> 1);
                     int var22 = var4 + (var19 + 1 >> 1);
                     int var23 = var5 + (var20 >> 1);
                     int var24 = var5 + (var20 + 1 >> 1);
                     int[][] var25 = Tiles.Tiles_heights[TaskHandler.Client_plane];
                     int var26 = var25[var22][var24] + var25[var21][var24] + var25[var21][var23] + var25[var22][var23] >> 2;
                     int var27 = (var4 << 7) + (var19 << 6);
                     int var28 = (var5 << 7) + (var20 << 6);
                     Model var29 = var18.getModel(var12, var13, var25, var27, var26, var28);
                     if (var29 != null) {
                        Decimator.updatePendingSpawn(TaskHandler.Client_plane, var4, var5, var14, -1, 0, 0, 31, var35 + 1, var10 + 1);
                        var17.animationCycleStart = var35 + Client.cycle;
                        var17.animationCycleEnd = var10 + Client.cycle;
                        var17.attachedModel = var29;
                        var17.field891 = var19 * 64 + var4 * 128;
                        var17.field893 = var20 * 64 + var5 * 128;
                        var17.baseTileHeight = var26;
                        byte var30;
                        if (var16 > var41) {
                           var30 = var16;
                           var16 = var41;
                           var41 = var30;
                        }

                        if (var42 > var36) {
                           var30 = var42;
                           var42 = var36;
                           var36 = var30;
                        }

                        var17.minX = var16 + var4;
                        var17.maxX = var41 + var4;
                        var17.minY = var42 + var5;
                        var17.maxY = var36 + var5;
                     }
                  }
               }

            }
         }
      }
   }

   @ObfuscatedName("lb")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1445723028"
   )
   static boolean method788(int var0) {
      for(int var1 = 0; var1 < Client.field586; ++var1) {
         if (Client.field588[var1] == var0) {
            return true;
         }
      }

      return false;
   }
}
