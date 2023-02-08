import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bv")
@Implements("Tiles")
public final class Tiles {
    @ObfuscatedName("f")
    static int[][][] Tiles_heights = new int[4][105][105];
    @ObfuscatedName("w")
    static byte[][][] Tiles_renderFlags = new byte[4][104][104];
    @ObfuscatedName("v")
    static int Tiles_minPlane = 99;
    @ObfuscatedName("s")
    static short[][][] Tiles_underlays;
    @ObfuscatedName("j")
    static byte[][][] Tiles_shapes;
   @ObfuscatedName("i")
   static byte[][][] field835;
   @ObfuscatedName("n")
   static byte[][][] field836;
    @ObfuscatedName("r")
    static int[] Tiles_lightness;
   @ObfuscatedName("u")
   static final int[] field838 = new int[]{1, 2, 4, 8};
   @ObfuscatedName("x")
   static final int[] field839 = new int[]{16, 32, 64, 128};
   @ObfuscatedName("a")
   static final int[] field840 = new int[]{1, 0, -1, 0};
   @ObfuscatedName("q")
   static final int[] field830 = new int[]{0, -1, 0, 1};
   @ObfuscatedName("d")
   static final int[] field841 = new int[]{1, -1, -1, 1};
   @ObfuscatedName("e")
   static final int[] field842 = new int[]{-1, -1, 1, 1};
    @ObfuscatedName("g")
    static int rndHue = (int)(Math.random() * 17.0D) - 8;
    @ObfuscatedName("y")
    static int rndLightness = (int)(Math.random() * 33.0D) - 16;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "([BIIIIIIILhn;[Lgv;)V"
   )
   static final void method447(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, Scene var8, CollisionMap[] var9) {
      Buffer var10 = new Buffer(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2433();
         if (var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.readUShortSmart();
            if (var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.readUnsignedByte();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if (var17 == var4 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               ObjectComposition var21 = class463.getObjectDefinition(var11);
               int var22 = var2 + WorldMapRegion.method1391(var16 & 7, var15 & 7, var7, var21.sizeX, var21.sizeY, var20);
               int var25 = var16 & 7;
               int var26 = var15 & 7;
               int var28 = var21.sizeX;
               int var29 = var21.sizeY;
               int var30;
               if ((var20 & 1) == 1) {
                  var30 = var28;
                  var28 = var29;
                  var29 = var30;
               }

               int var27 = var7 & 3;
               int var24;
               if (var27 == 0) {
                  var24 = var26;
               } else if (var27 == 1) {
                  var24 = 7 - var25 - (var28 - 1);
               } else if (var27 == 2) {
                  var24 = 7 - var26 - (var29 - 1);
               } else {
                  var24 = var25;
               }

               var30 = var3 + var24;
               if (var22 > 0 && var30 > 0 && var22 < 103 && var30 < 103) {
                  int var31 = var1;
                  if ((Tiles_renderFlags[1][var22][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  CollisionMap var32 = null;
                  if (var31 >= 0) {
                     var32 = var9[var31];
                  }

                  UserList.addObjects(var1, var22, var30, var11, var20 + var7 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "1451168135"
   )
   static int method449(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 != 1927 && var0 != 2927) {
         int var4;
         if (var0 == 1928) {
            var3 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
            var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            if (var4 >= 1 && var4 <= 10) {
               class97 var5 = new class97(var4, var3.id, var3.childIndex, var3.itemId);
               Interpreter.field714.add(var5);
               return 1;
            } else {
               throw new RuntimeException();
            }
         } else if (var0 == 2928) {
            class302.Interpreter_intStackSize -= 3;
            int var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            int var8 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
            if (var8 >= 1 && var8 <= 10) {
               class97 var6 = new class97(var8, var7, var4, class133.getWidget(var7).itemId);
               Interpreter.field714.add(var6);
               return 1;
            } else {
               throw new RuntimeException();
            }
         } else {
            return 2;
         }
      } else if (Interpreter.field712 >= 10) {
         throw new RuntimeException();
      } else {
         if (var0 >= 2000) {
            var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
         } else {
            var3 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
         }

         if (var3.onResize == null) {
            return 0;
         } else {
            ScriptEvent var9 = new ScriptEvent();
            var9.widget = var3;
            var9.args = var3.onResize;
            var9.field866 = Interpreter.field712 + 1;
            Client.scriptEvents.addFirst(var9);
            return 1;
         }
      }
   }

   @ObfuscatedName("mm")
   @ObfuscatedSignature(
      descriptor = "(IB)Lqc;",
      garbageValue = "-124"
   )
   static class467 method448(int var0) {
      class467 var1 = (class467)Client.Widget_cachedModels.get((long)var0);
      if (var1 == null) {
         var1 = new class467(Canvas.field75, WorldMapLabelSize.method1319(var0), MidiPcmStream.method1590(var0));
         Client.Widget_cachedModels.put(var1, (long)var0);
      }

      return var1;
   }
}
