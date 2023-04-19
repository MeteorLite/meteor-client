import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public class class97 {
    @ObfuscatedName("ab")
    public static int[] SpriteBuffer_spriteWidths;
   @ObfuscatedName("af")
   int field1069;
   @ObfuscatedName("an")
   int field1066;
   @ObfuscatedName("aw")
   int field1067;
   @ObfuscatedName("ac")
   int field1065;

   class97(int var1, int var2, int var3, int var4) {
      this.field1069 = var1;
      this.field1066 = var2;
      this.field1067 = var3;
      this.field1065 = var4;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-112"
   )
   int method615() {
      return this.field1069;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1880152779"
   )
   int method613() {
      return this.field1066;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "7"
   )
   int method614() {
      return this.field1067;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2047344051"
   )
   int method616() {
      return this.field1065;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "2039313596"
   )
   static int method617(int var0, int var1) {
      if (var0 == -2) {
         return 12345678;
      } else if (var0 == -1) {
         if (var1 < 0) {
            var1 = 0;
         } else if (var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if (var1 < 2) {
            var1 = 2;
         } else if (var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
