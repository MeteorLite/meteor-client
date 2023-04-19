import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("of")
public class class372 {
    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(Lsg;IIIIIIB)V",
            garbageValue = "-110"
    )
    static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      boolean var7 = var1 >= 0 && var1 < 4 && var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104;
      int var8;
      if (var7) {
         Tiles.Tiles_renderFlags[var1][var2][var3] = 0;

         while(true) {
            var8 = var0.readUnsignedShort();
            if (var8 == 0) {
               if (var1 == 0) {
                  int[] var9 = Tiles.Tiles_heights[0][var2];
                  int var12 = var4 + 932731;
                  int var13 = var5 + 556238;
                  int var14 = class101.method634(var12 + '넵', var13 + 91923, 4) - 128 + (class101.method634(var12 + 10294, var13 + '鎽', 2) - 128 >> 1) + (class101.method634(var12, var13, 1) - 128 >> 2);
                  var14 = (int)((double)var14 * 0.3D) + 35;
                  if (var14 < 10) {
                     var14 = 10;
                  } else if (var14 > 60) {
                     var14 = 60;
                  }

                  var9[var3] = -var14 * 8;
               } else {
                  Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if (var8 == 1) {
               int var15 = var0.readUnsignedByte();
               if (var15 == 1) {
                  var15 = 0;
               }

               if (var1 == 0) {
                  Tiles.Tiles_heights[0][var2][var3] = -var15 * 8;
               } else {
                  Tiles.Tiles_heights[var1][var2][var3] = Tiles.Tiles_heights[var1 - 1][var2][var3] - var15 * 8;
               }
               break;
            }

            if (var8 <= 49) {
               Tiles.Tiles_overlays[var1][var2][var3] = (short)var0.readShort();
               Tiles.Tiles_shapes[var1][var2][var3] = (byte)((var8 - 2) / 4);
               Tiles.field824[var1][var2][var3] = (byte)(var8 - 2 + var6 & 3);
            } else if (var8 <= 81) {
               Tiles.Tiles_renderFlags[var1][var2][var3] = (byte)(var8 - 49);
            } else {
               class186.Tiles_underlays[var1][var2][var3] = (short)(var8 - 81);
            }
         }
      } else {
         while(true) {
            var8 = var0.readUnsignedShort();
            if (var8 == 0) {
               break;
            }

            if (var8 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if (var8 <= 49) {
               var0.readShort();
            }
         }
      }

   }
}
