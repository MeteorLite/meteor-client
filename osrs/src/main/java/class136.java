import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public enum class136 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lft;"
   )
   field1280(1, 0),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lft;"
   )
   field1281(3, 1),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lft;"
   )
   field1282(2, 2),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lft;"
   )
   field1283(0, 3),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lft;"
   )
   field1284(4, 4);

   @ObfuscatedName("ji")
   @ObfuscatedSignature(
      descriptor = "Lsn;"
   )
   @Export("redHintArrowSprite")
   static SpritePixels redHintArrowSprite;
   @ObfuscatedName("ao")
   public final int field1287;
   @ObfuscatedName("av")
   @Export("id")
   final int id;

   class136(int var3, int var4) {
      this.field1287 = var3;
      this.id = var4;
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

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lew;FFFFFFFFB)V",
      garbageValue = "-88"
   )
   static void method735(class127 var0, float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var0 != null) {
         var0.field1207 = var1;
         float var9 = var4 - var1;
         float var10 = var8 - var5;
         float var11 = var2 - var1;
         float var12 = 0.0F;
         float var13 = 0.0F;
         if ((double)var11 != 0.0D) {
            var12 = (var6 - var5) / var11;
         }

         var11 = var4 - var3;
         if (0.0D != (double)var11) {
            var13 = (var8 - var7) / var11;
         }

         float var14 = 1.0F / (var9 * var9);
         float var15 = var9 * var12;
         float var16 = var13 * var9;
         var0.field1223 = (var16 + var15 - var10 - var10) * var14 / var9;
         var0.field1208 = (var10 + var10 + var10 - var15 - var15 - var16) * var14;
         var0.field1209 = var12;
         var0.field1202 = var5;
      }
   }
}
