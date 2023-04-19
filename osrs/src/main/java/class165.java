import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gh")
public class class165 extends class177 {
   @ObfuscatedName("af")
   String field1416;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lgy;"
   )
   final class166 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lgy;Ljava/lang/String;Ljava/lang/String;)V"
   )
   class165(class166 var1, String var2, String var3) {
      super(var1, var2);
      this.this$0 = var1;
      this.field1416 = var3;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-41"
    )
    public int vmethod3379() {
      return 1;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)Ljava/lang/String;",
            garbageValue = "88"
    )
    public String vmethod3380() {
      return this.field1416;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(IB)Lmq;",
            garbageValue = "5"
    )
    public static Widget getWidget(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if (VerticalAlignment.Widget_interfaceComponents[var1] == null || VerticalAlignment.Widget_interfaceComponents[var1][var2] == null) {
         boolean var3 = SoundSystem.loadInterface(var1);
         if (!var3) {
            return null;
         }
      }

      return VerticalAlignment.Widget_interfaceComponents[var1][var2];
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1235100026"
   )
   public static void method921() {
      ParamComposition.ParamDefinition_cached.clear();
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIIILie;Lif;I)V",
      garbageValue = "-1255092021"
   )
   static final void method923(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, CollisionMap var9) {
      ObjectComposition var10 = class144.getObjectDefinition(var4);
      int var11 = var7 >= 0 ? var7 : var10.animationId * 1292954189 * -1142530427;
      int var12;
      int var13;
      if (var5 != 1 && var5 != 3) {
         var12 = var10.sizeX;
         var13 = var10.sizeY;
      } else {
         var12 = var10.sizeY;
         var13 = var10.sizeX;
      }

      int var14;
      int var15;
      if (var12 + var2 <= 104) {
         var14 = (var12 >> 1) + var2;
         var15 = var2 + (var12 + 1 >> 1);
      } else {
         var14 = var2;
         var15 = var2 + 1;
      }

      int var16;
      int var17;
      if (var3 + var13 <= 104) {
         var16 = var3 + (var13 >> 1);
         var17 = var3 + (var13 + 1 >> 1);
      } else {
         var16 = var3;
         var17 = var3 + 1;
      }

      int[][] var18 = Tiles.Tiles_heights[var1];
      int var19 = var18[var14][var16] + var18[var15][var16] + var18[var14][var17] + var18[var15][var17] >> 2;
      int var20 = (var2 << 7) + (var12 << 6);
      int var21 = (var3 << 7) + (var13 << 6);
      long var22 = FaceNormal.calculateTag(var2, var3, 2, var10.int1 == 0, var4);
      int var24 = (var5 << 6) + var6;
      if (var10.int3 == 1) {
         var24 += 256;
      }

      Object var25;
      if (var6 == 22) {
         if (var11 == -1 && var10.transforms == null) {
            var25 = var10.getModel(22, var5, var18, var20, var19, var21);
         } else {
            var25 = new DynamicObject(var4, 22, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
         }

         var8.newFloorDecoration(var0, var2, var3, var19, (Renderable)var25, var22, var24);
         if (var10.interactType == 1) {
            var9.setBlockedByFloorDec(var2, var3);
         }

      } else if (var6 != 10 && var6 != 11) {
         if (var6 >= 12) {
            if (var11 == -1 && var10.transforms == null) {
               var25 = var10.getModel(var6, var5, var18, var20, var19, var21);
            } else {
               var25 = new DynamicObject(var4, var6, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
            }

            var8.method1288(var0, var2, var3, var19, 1, 1, (Renderable)var25, 0, var22, var24);
            if (var10.interactType != 0) {
               var9.addGameObject(var2, var3, var12, var13, var10.boolean1);
            }

         } else if (var6 == 0) {
            if (var11 == -1 && var10.transforms == null) {
               var25 = var10.getModel(0, var5, var18, var20, var19, var21);
            } else {
               var25 = new DynamicObject(var4, 0, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
            }

            var8.newBoundaryObject(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, Tiles.field820[var5], 0, var22, var24);
            if (var10.interactType != 0) {
               var9.method1163(var2, var3, var6, var5, var10.boolean1);
            }

         } else if (var6 == 1) {
            if (var11 == -1 && var10.transforms == null) {
               var25 = var10.getModel(1, var5, var18, var20, var19, var21);
            } else {
               var25 = new DynamicObject(var4, 1, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
            }

            var8.newBoundaryObject(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, Tiles.field829[var5], 0, var22, var24);
            if (var10.interactType != 0) {
               var9.method1163(var2, var3, var6, var5, var10.boolean1);
            }

         } else {
            int var31;
            if (var6 == 2) {
               var31 = var5 + 1 & 3;
               Object var26;
               Object var27;
               if (var11 == -1 && var10.transforms == null) {
                  var26 = var10.getModel(2, var5 + 4, var18, var20, var19, var21);
                  var27 = var10.getModel(2, var31, var18, var20, var19, var21);
               } else {
                  var26 = new DynamicObject(var4, 2, var5 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
                  var27 = new DynamicObject(var4, 2, var31, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
               }

               var8.newBoundaryObject(var0, var2, var3, var19, (Renderable)var26, (Renderable)var27, Tiles.field820[var5], Tiles.field820[var31], var22, var24);
               if (var10.interactType != 0) {
                  var9.method1163(var2, var3, var6, var5, var10.boolean1);
               }

            } else if (var6 == 3) {
               if (var11 == -1 && var10.transforms == null) {
                  var25 = var10.getModel(3, var5, var18, var20, var19, var21);
               } else {
                  var25 = new DynamicObject(var4, 3, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
               }

               var8.newBoundaryObject(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, Tiles.field829[var5], 0, var22, var24);
               if (var10.interactType != 0) {
                  var9.method1163(var2, var3, var6, var5, var10.boolean1);
               }

            } else if (var6 == 9) {
               if (var11 == -1 && var10.transforms == null) {
                  var25 = var10.getModel(var6, var5, var18, var20, var19, var21);
               } else {
                  var25 = new DynamicObject(var4, var6, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
               }

               var8.method1288(var0, var2, var3, var19, 1, 1, (Renderable)var25, 0, var22, var24);
               if (var10.interactType != 0) {
                  var9.addGameObject(var2, var3, var12, var13, var10.boolean1);
               }

            } else if (var6 == 4) {
               if (var11 == -1 && var10.transforms == null) {
                  var25 = var10.getModel(4, var5, var18, var20, var19, var21);
               } else {
                  var25 = new DynamicObject(var4, 4, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
               }

               var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, Tiles.field820[var5], 0, 0, 0, var22, var24);
            } else {
               Object var28;
               long var32;
               if (var6 == 5) {
                  var31 = 16;
                  var32 = var8.getBoundaryObjectTag(var0, var2, var3);
                  if (var32 != 0L) {
                     var31 = class144.getObjectDefinition(InterfaceParent.Entity_unpackID(var32)).int2;
                  }

                  if (var11 == -1 && var10.transforms == null) {
                     var28 = var10.getModel(4, var5, var18, var20, var19, var21);
                  } else {
                     var28 = new DynamicObject(var4, 4, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
                  }

                  var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var28, (Renderable)null, Tiles.field820[var5], 0, var31 * Tiles.field830[var5], var31 * Tiles.field827[var5], var22, var24);
               } else if (var6 == 6) {
                  var31 = 8;
                  var32 = var8.getBoundaryObjectTag(var0, var2, var3);
                  if (0L != var32) {
                     var31 = class144.getObjectDefinition(InterfaceParent.Entity_unpackID(var32)).int2 / 2;
                  }

                  if (var11 == -1 && var10.transforms == null) {
                     var28 = var10.getModel(4, var5 + 4, var18, var20, var19, var21);
                  } else {
                     var28 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
                  }

                  var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var28, (Renderable)null, 256, var5, var31 * Tiles.field832[var5], var31 * Tiles.field833[var5], var22, var24);
               } else if (var6 == 7) {
                  int var34 = var5 + 2 & 3;
                  if (var11 == -1 && var10.transforms == null) {
                     var25 = var10.getModel(4, var34 + 4, var18, var20, var19, var21);
                  } else {
                     var25 = new DynamicObject(var4, 4, var34 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
                  }

                  var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var25, (Renderable)null, 256, var34, 0, 0, var22, var24);
               } else if (var6 == 8) {
                  var31 = 8;
                  var32 = var8.getBoundaryObjectTag(var0, var2, var3);
                  if (0L != var32) {
                     var31 = class144.getObjectDefinition(InterfaceParent.Entity_unpackID(var32)).int2 / 2;
                  }

                  int var30 = var5 + 2 & 3;
                  Object var29;
                  if (var11 == -1 && var10.transforms == null) {
                     var28 = var10.getModel(4, var5 + 4, var18, var20, var19, var21);
                     var29 = var10.getModel(4, var30 + 4, var18, var20, var19, var21);
                  } else {
                     var28 = new DynamicObject(var4, 4, var5 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
                     var29 = new DynamicObject(var4, 4, var30 + 4, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
                  }

                  var8.newWallDecoration(var0, var2, var3, var19, (Renderable)var28, (Renderable)var29, 256, var5, var31 * Tiles.field832[var5], var31 * Tiles.field833[var5], var22, var24);
               }
            }
         }
      } else {
         if (var11 == -1 && var10.transforms == null) {
            var25 = var10.getModel(10, var5, var18, var20, var19, var21);
         } else {
            var25 = new DynamicObject(var4, 10, var5, var1, var2, var3, var11, var10.boolean3, (Renderable)null);
         }

         if (var25 != null) {
            var8.method1288(var0, var2, var3, var19, var12, var13, (Renderable)var25, var6 == 11 ? 256 : 0, var22, var24);
         }

         if (var10.interactType != 0) {
            var9.addGameObject(var2, var3, var12, var13, var10.boolean1);
         }

      }
   }
}
