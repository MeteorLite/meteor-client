import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class30 {
   @ObfuscatedName("nm")
   @Export("menuHeight")
   static int menuHeight;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(IIIIIILir;Liz;I)V",
      garbageValue = "795706327"
   )
   @Export("addObjects")
   static final void addObjects(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
      if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
         if (var0 < Tiles.Tiles_minPlane) {
            Tiles.Tiles_minPlane = var0;
         }

         ObjectComposition var8 = WallDecoration.getObjectDefinition(var3);
         int var9;
         int var10;
         if (var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if (var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if (var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = Tiles.Tiles_heights[var0];
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         long var19 = class103.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
         int var21 = var5 + (var4 << 6);
         if (var8.int3 == 1) {
            var21 += 256;
         }

         if (var8.hasSound()) {
            class388.method2044(var0, var1, var2, var8, var4);
         }

         Object var22;
         if (var5 == 22) {
            if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
               if (var8.animationId == -1 && var8.transforms == null) {
                  var22 = var8.getEntity(22, var4, var15, var17, var16, var18);
               } else {
                  var22 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
               }

               var6.newFloorDecoration(var0, var1, var2, var16, (Renderable)var22, var19, var21);
               if (var8.interactType == 1 && var7 != null) {
                  var7.setBlockedByFloorDec(var1, var2);
               }

            }
         } else {
            int var31;
            if (var5 != 10 && var5 != 11) {
               if (var5 >= 12) {
                  if (var8.animationId == -1 && var8.transforms == null) {
                     var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
                  } else {
                     var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                  }

                  var6.method1240(var0, var1, var2, var16, 1, 1, (Renderable)var22, 0, var19, var21);
                  if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class17.field51[var0][var1][var2] |= 2340;
                  }

                  if (var8.interactType != 0 && var7 != null) {
                     var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
                  }

               } else if (var5 == 0) {
                  if (var8.animationId == -1 && var8.transforms == null) {
                     var22 = var8.getEntity(0, var4, var15, var17, var16, var18);
                  } else {
                     var22 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                  }

                  var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field824[var4], 0, var19, var21);
                  if (var4 == 0) {
                     if (var8.clipped) {
                        Decimator.field300[var0][var1][var2] = 50;
                        Decimator.field300[var0][var1][var2 + 1] = 50;
                     }

                     if (var8.modelClipped) {
                        class17.field51[var0][var1][var2] |= 585;
                     }
                  } else if (var4 == 1) {
                     if (var8.clipped) {
                        Decimator.field300[var0][var1][var2 + 1] = 50;
                        Decimator.field300[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if (var8.modelClipped) {
                        class17.field51[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if (var4 == 2) {
                     if (var8.clipped) {
                        Decimator.field300[var0][var1 + 1][var2] = 50;
                        Decimator.field300[var0][var1 + 1][var2 + 1] = 50;
                     }

                     if (var8.modelClipped) {
                        class17.field51[var0][var1 + 1][var2] |= 585;
                     }
                  } else if (var4 == 3) {
                     if (var8.clipped) {
                        Decimator.field300[var0][var1][var2] = 50;
                        Decimator.field300[var0][var1 + 1][var2] = 50;
                     }

                     if (var8.modelClipped) {
                        class17.field51[var0][var1][var2] |= 1170;
                     }
                  }

                  if (var8.interactType != 0 && var7 != null) {
                     var7.method1100(var1, var2, var5, var4, var8.boolean1);
                  }

                  if (var8.int2 != 16) {
                     var6.method1239(var0, var1, var2, var8.int2);
                  }

               } else if (var5 == 1) {
                  if (var8.animationId == -1 && var8.transforms == null) {
                     var22 = var8.getEntity(1, var4, var15, var17, var16, var18);
                  } else {
                     var22 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                  }

                  var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field832[var4], 0, var19, var21);
                  if (var8.clipped) {
                     if (var4 == 0) {
                        Decimator.field300[var0][var1][var2 + 1] = 50;
                     } else if (var4 == 1) {
                        Decimator.field300[var0][var1 + 1][var2 + 1] = 50;
                     } else if (var4 == 2) {
                        Decimator.field300[var0][var1 + 1][var2] = 50;
                     } else if (var4 == 3) {
                        Decimator.field300[var0][var1][var2] = 50;
                     }
                  }

                  if (var8.interactType != 0 && var7 != null) {
                     var7.method1100(var1, var2, var5, var4, var8.boolean1);
                  }

               } else {
                  int var28;
                  if (var5 == 2) {
                     var28 = var4 + 1 & 3;
                     Object var23;
                     Object var24;
                     if (var8.animationId == -1 && var8.transforms == null) {
                        var23 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
                        var24 = var8.getEntity(2, var28, var15, var17, var16, var18);
                     } else {
                        var23 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                        var24 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     }

                     var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var23, (Renderable)var24, Tiles.field824[var4], Tiles.field824[var28], var19, var21);
                     if (var8.modelClipped) {
                        if (var4 == 0) {
                           class17.field51[var0][var1][var2] |= 585;
                           class17.field51[var0][var1][var2 + 1] |= 1170;
                        } else if (var4 == 1) {
                           class17.field51[var0][var1][var2 + 1] |= 1170;
                           class17.field51[var0][var1 + 1][var2] |= 585;
                        } else if (var4 == 2) {
                           class17.field51[var0][var1 + 1][var2] |= 585;
                           class17.field51[var0][var1][var2] |= 1170;
                        } else if (var4 == 3) {
                           class17.field51[var0][var1][var2] |= 1170;
                           class17.field51[var0][var1][var2] |= 585;
                        }
                     }

                     if (var8.interactType != 0 && var7 != null) {
                        var7.method1100(var1, var2, var5, var4, var8.boolean1);
                     }

                     if (var8.int2 != 16) {
                        var6.method1239(var0, var1, var2, var8.int2);
                     }

                  } else if (var5 == 3) {
                     if (var8.animationId == -1 && var8.transforms == null) {
                        var22 = var8.getEntity(3, var4, var15, var17, var16, var18);
                     } else {
                        var22 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     }

                     var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field832[var4], 0, var19, var21);
                     if (var8.clipped) {
                        if (var4 == 0) {
                           Decimator.field300[var0][var1][var2 + 1] = 50;
                        } else if (var4 == 1) {
                           Decimator.field300[var0][var1 + 1][var2 + 1] = 50;
                        } else if (var4 == 2) {
                           Decimator.field300[var0][var1 + 1][var2] = 50;
                        } else if (var4 == 3) {
                           Decimator.field300[var0][var1][var2] = 50;
                        }
                     }

                     if (var8.interactType != 0 && var7 != null) {
                        var7.method1100(var1, var2, var5, var4, var8.boolean1);
                     }

                  } else if (var5 == 9) {
                     if (var8.animationId == -1 && var8.transforms == null) {
                        var22 = var8.getEntity(var5, var4, var15, var17, var16, var18);
                     } else {
                        var22 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     }

                     var6.method1240(var0, var1, var2, var16, 1, 1, (Renderable)var22, 0, var19, var21);
                     if (var8.interactType != 0 && var7 != null) {
                        var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
                     }

                     if (var8.int2 != 16) {
                        var6.method1239(var0, var1, var2, var8.int2);
                     }

                  } else if (var5 == 4) {
                     if (var8.animationId == -1 && var8.transforms == null) {
                        var22 = var8.getEntity(4, var4, var15, var17, var16, var18);
                     } else {
                        var22 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, Tiles.field824[var4], 0, 0, 0, var19, var21);
                  } else {
                     Object var25;
                     long var29;
                     if (var5 == 5) {
                        var28 = 16;
                        var29 = var6.getBoundaryObjectTag(var0, var1, var2);
                        if (var29 != 0L) {
                           var28 = WallDecoration.getObjectDefinition(class279.Entity_unpackID(var29)).int2;
                        }

                        if (var8.animationId == -1 && var8.transforms == null) {
                           var25 = var8.getEntity(4, var4, var15, var17, var16, var18);
                        } else {
                           var25 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                        }

                        var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, Tiles.field824[var4], 0, var28 * Tiles.field826[var4], var28 * Tiles.field828[var4], var19, var21);
                     } else if (var5 == 6) {
                        var28 = 8;
                        var29 = var6.getBoundaryObjectTag(var0, var1, var2);
                        if (0L != var29) {
                           var28 = WallDecoration.getObjectDefinition(class279.Entity_unpackID(var29)).int2 / 2;
                        }

                        if (var8.animationId == -1 && var8.transforms == null) {
                           var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
                        } else {
                           var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                        }

                        var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, 256, var4, var28 * Tiles.field829[var4], var28 * Tiles.field830[var4], var19, var21);
                     } else if (var5 == 7) {
                        var31 = var4 + 2 & 3;
                        if (var8.animationId == -1 && var8.transforms == null) {
                           var22 = var8.getEntity(4, var31 + 4, var15, var17, var16, var18);
                        } else {
                           var22 = new DynamicObject(var3, 4, var31 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                        }

                        var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var22, (Renderable)null, 256, var31, 0, 0, var19, var21);
                     } else if (var5 == 8) {
                        var28 = 8;
                        var29 = var6.getBoundaryObjectTag(var0, var1, var2);
                        if (0L != var29) {
                           var28 = WallDecoration.getObjectDefinition(class279.Entity_unpackID(var29)).int2 / 2;
                        }

                        int var27 = var4 + 2 & 3;
                        Object var26;
                        if (var8.animationId == -1 && var8.transforms == null) {
                           var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
                           var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
                        } else {
                           var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                           var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                        }

                        var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)var26, 256, var4, var28 * Tiles.field829[var4], var28 * Tiles.field830[var4], var19, var21);
                     }
                  }
               }
            } else {
               if (var8.animationId == -1 && var8.transforms == null) {
                  var22 = var8.getEntity(10, var4, var15, var17, var16, var18);
               } else {
                  var22 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
               }

               if (var22 != null && var6.method1240(var0, var1, var2, var16, var9, var10, (Renderable)var22, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
                  var31 = 15;
                  if (var22 instanceof Model) {
                     var31 = ((Model)var22).method1284() / 4;
                     if (var31 > 30) {
                        var31 = 30;
                     }
                  }

                  for(int var32 = 0; var32 <= var9; ++var32) {
                     for(int var33 = 0; var33 <= var10; ++var33) {
                        if (var31 > Decimator.field300[var0][var32 + var1][var33 + var2]) {
                           Decimator.field300[var0][var32 + var1][var33 + var2] = (byte)var31;
                        }
                     }
                  }
               }

               if (var8.interactType != 0 && var7 != null) {
                  var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
               }

            }
         }
      }
   }
}
