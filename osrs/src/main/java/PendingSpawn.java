import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
@Implements("PendingSpawn")
public final class PendingSpawn extends Node {
   @ObfuscatedName("aj")
   @Export("plane")
   int plane;
   @ObfuscatedName("al")
   @Export("type")
   int type;
   @ObfuscatedName("ac")
   @Export("x")
   int x;
   @ObfuscatedName("ab")
   @Export("y")
   int y;
   @ObfuscatedName("an")
   @Export("objectId")
   int objectId;
   @ObfuscatedName("ao")
   int field917;
   @ObfuscatedName("av")
   int field919;
   @ObfuscatedName("aq")
   @Export("id")
   int id;
   @ObfuscatedName("ap")
   @Export("rotation")
   int rotation;
   @ObfuscatedName("ar")
   @Export("objectType")
   int objectType;
   @ObfuscatedName("ak")
   int field922;
   @ObfuscatedName("as")
   int field923 = 31;
   @ObfuscatedName("ay")
   @Export("startCycle")
   int startCycle = 0;
   @ObfuscatedName("am")
   @Export("endCycle")
   int endCycle = -1;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1524864888"
   )
   void method499(int var1) {
      this.field923 = var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "37"
   )
   boolean method500(int var1) {
      if (var1 >= 0 && var1 <= 4) {
         return (this.field923 & 1 << var1) != 0;
      } else {
         return true;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IIILip;Liz;I)Z",
      garbageValue = "806683414"
   )
   static final boolean method498(int var0, int var1, int var2, RouteStrategy var3, CollisionMap var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class212.directions[var7][var8] = 99;
      class212.distances[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class212.bufferX[var11] = var0;
      int var20 = var11 + 1;
      class212.bufferY[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label265:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label242:
                     do {
                        if (var20 == var12) {
                           class212.field1848 = var5;
                           class83.field841 = var6;
                           return false;
                        }

                        var5 = class212.bufferX[var12];
                        var6 = class212.bufferY[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.xInset;
                        var15 = var6 - var4.yInset;
                        if (var3.hasArrived(var2, var5, var6, var4)) {
                           class212.field1848 = var5;
                           class83.field841 = var6;
                           return true;
                        }

                        var16 = class212.distances[var18][var19] + 1;
                        if (var18 > 0 && class212.directions[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if (var17 >= var2 - 1) {
                                 class212.bufferX[var20] = var5 - 1;
                                 class212.bufferY[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class212.directions[var18 - 1][var19] = 2;
                                 class212.distances[var18 - 1][var19] = var16;
                                 break;
                              }

                              if ((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if (var18 < 128 - var2 && class212.directions[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if (var17 >= var2 - 1) {
                                 class212.bufferX[var20] = var5 + 1;
                                 class212.bufferY[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class212.directions[var18 + 1][var19] = 8;
                                 class212.distances[var18 + 1][var19] = var16;
                                 break;
                              }

                              if ((var13[var14 + var2][var17 + var15] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if (var19 > 0 && class212.directions[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if (var17 >= var2 - 1) {
                                 class212.bufferX[var20] = var5;
                                 class212.bufferY[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class212.directions[var18][var19 - 1] = 1;
                                 class212.distances[var18][var19 - 1] = var16;
                                 break;
                              }

                              if ((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if (var19 < 128 - var2 && class212.directions[var18][var19 + 1] == 0 && (var13[var14][var15 + var2] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if (var17 >= var2 - 1) {
                                 class212.bufferX[var20] = var5;
                                 class212.bufferY[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class212.directions[var18][var19 + 1] = 4;
                                 class212.distances[var18][var19 + 1] = var16;
                                 break;
                              }

                              if ((var13[var17 + var14][var15 + var2] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if (var18 > 0 && var19 > 0 && class212.directions[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if (var17 >= var2) {
                                 class212.bufferX[var20] = var5 - 1;
                                 class212.bufferY[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class212.directions[var18 - 1][var19 - 1] = 3;
                                 class212.distances[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if ((var13[var14 - 1][var17 + (var15 - 1)] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if (var18 < 128 - var2 && var19 > 0 && class212.directions[var18 + 1][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if (var17 >= var2) {
                                 class212.bufferX[var20] = var5 + 1;
                                 class212.bufferY[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class212.directions[var18 + 1][var19 - 1] = 9;
                                 class212.distances[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if ((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if (var18 > 0 && var19 < 128 - var2 && class212.directions[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if ((var13[var14 - 1][var17 + var15] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 + var2] & 19137016) != 0) {
                                 continue label242;
                              }
                           }

                           class212.bufferX[var20] = var5 - 1;
                           class212.bufferY[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class212.directions[var18 - 1][var19 + 1] = 6;
                           class212.distances[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class212.directions[var18 + 1][var19 + 1] != 0);
            } while((var13[var14 + var2][var15 + var2] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if ((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label265;
               }
            }

            class212.bufferX[var20] = var5 + 1;
            class212.bufferY[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class212.directions[var18 + 1][var19 + 1] = 12;
            class212.distances[var18 + 1][var19 + 1] = var16;
         }
      }
   }

   @ObfuscatedName("gj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-183595775"
   )
   static final void method501() {
      if (Client.logoutTimer > 0) {
         class278.logOut();
      } else {
         Client.timer.method2035();
         class19.updateGameState(40);
         FloorDecoration.field1908 = Client.packetWriter.getSocket();
         Client.packetWriter.removeSocket();
      }
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "-587511051"
   )
   static final void method502(int var0, int var1, int var2) {
      if (class381.cameraX < var0) {
         class381.cameraX = (var0 - class381.cameraX) * class313.cameraMoveToAcceleration / 1000 + class381.cameraX + class19.cameraMoveToSpeed;
         if (class381.cameraX > var0) {
            class381.cameraX = var0;
         }
      }

      if (class381.cameraX > var0) {
         class381.cameraX -= (class381.cameraX - var0) * class313.cameraMoveToAcceleration / 1000 + class19.cameraMoveToSpeed;
         if (class381.cameraX < var0) {
            class381.cameraX = var0;
         }
      }

      if (class351.cameraY < var1) {
         class351.cameraY = (var1 - class351.cameraY) * class313.cameraMoveToAcceleration / 1000 + class351.cameraY + class19.cameraMoveToSpeed;
         if (class351.cameraY > var1) {
            class351.cameraY = var1;
         }
      }

      if (class351.cameraY > var1) {
         class351.cameraY -= (class351.cameraY - var1) * class313.cameraMoveToAcceleration / 1000 + class19.cameraMoveToSpeed;
         if (class351.cameraY < var1) {
            class351.cameraY = var1;
         }
      }

      if (class471.cameraZ < var2) {
         class471.cameraZ = (var2 - class471.cameraZ) * class313.cameraMoveToAcceleration / 1000 + class471.cameraZ + class19.cameraMoveToSpeed;
         if (class471.cameraZ > var2) {
            class471.cameraZ = var2;
         }
      }

      if (class471.cameraZ > var2) {
         class471.cameraZ -= (class471.cameraZ - var2) * class313.cameraMoveToAcceleration / 1000 + class19.cameraMoveToSpeed;
         if (class471.cameraZ < var2) {
            class471.cameraZ = var2;
         }
      }

   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      descriptor = "(Ldq;IB)V",
      garbageValue = "-47"
   )
   static final void method504(Actor var0, int var1) {
      GrandExchangeOfferUnitPriceComparator.worldToScreen(var0.x, var0.y, var1);
   }

   @ObfuscatedName("nz")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;ZB)V",
      garbageValue = "49"
   )
   @Export("findItemDefinitions")
   static void findItemDefinitions(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < ChatChannel.ItemDefinition_fileCount; ++var4) {
         ItemComposition var5 = ParamComposition.ItemDefinition_get(var4);
         if ((!var1 || var5.isTradable) && var5.noteTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if (var3 >= 250) {
               class323.foundItemIdCount = -1;
               GrandExchangeEvents.foundItemIds = null;
               return;
            }

            if (var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      GrandExchangeEvents.foundItemIds = var2;
      class173.foundItemIndex = 0;
      class323.foundItemIdCount = var3;
      String[] var8 = new String[class323.foundItemIdCount];

      for(int var9 = 0; var9 < class323.foundItemIdCount; ++var9) {
         var8[var9] = ParamComposition.ItemDefinition_get(var2[var9]).name;
      }

      short[] var10 = GrandExchangeEvents.foundItemIds;
      MouseRecorder.sortItemsByName(var8, var10, 0, var8.length - 1);
   }
}
