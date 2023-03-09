import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ms")
@Implements("WorldMapDecorationType")
public enum WorldMapDecorationType implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3014(0, 0),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3003(1, 0),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3004(2, 0),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3022(3, 0),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3006(9, 2),
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3007(4, 1),
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3008(5, 1),
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3009(6, 1),
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3010(7, 1),
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3011(8, 1),
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3012(12, 2),
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3013(13, 2),
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3019(14, 2),
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3025(15, 2),
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3016(16, 2),
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3015(17, 2),
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3018(18, 2),
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3021(19, 2),
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3020(20, 2),
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3005(21, 2),
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3002(10, 2),
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3017(11, 2),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3024(22, 3);

   @ObfuscatedName("aa")
   @Export("id")
   public final int id;

   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "0"
   )
   WorldMapDecorationType(int var3, int var4) {
      this.id = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1699192816"
   )
   @Export("Widget_unpackTargetMask")
   public static int Widget_unpackTargetMask(int var0) {
      return var0 >> 11 & 63;
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "-1370492228"
   )
   @Export("getTileHeight")
   static final int getTileHeight(int var0, int var1, int var2) {
      int var3 = var0 >> 7;
      int var4 = var1 >> 7;
      if (var3 >= 0 && var4 >= 0 && var3 <= 103 && var4 <= 103) {
         int var5 = var2;
         if (var2 < 3 && (Tiles.Tiles_renderFlags[1][var3][var4] & 2) == 2) {
            var5 = var2 + 1;
         }

         int var6 = var0 & 127;
         int var7 = var1 & 127;
         int var8 = (128 - var6) * Tiles.Tiles_heights[var5][var3][var4] + Tiles.Tiles_heights[var5][var3 + 1][var4] * var6 >> 7;
         int var9 = var6 * Tiles.Tiles_heights[var5][var3 + 1][var4 + 1] + Tiles.Tiles_heights[var5][var3][var4 + 1] * (128 - var6) >> 7;
         return var8 * (128 - var7) + var9 * var7 >> 7;
      } else {
         return 0;
      }
   }
}
