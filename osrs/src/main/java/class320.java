import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("md")
public enum class320 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lmd;"
   )
   field2997(0),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lmd;"
   )
   field2995(1),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lmd;"
   )
   field3000(2),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lmd;"
   )
   field2998(3),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lmd;"
   )
   field2999(4);

   @ObfuscatedName("gm")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   static Archive field3001;
   @ObfuscatedName("ao")
   final int field2996;

   class320(int var3) {
      this.field2996 = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field2996;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-676660135"
   )
   static void method1787() {
      class150.field1331 = new int[2000];
      int var0 = 0;
      int var1 = 240;

      int var3;
      for(byte var2 = 12; var0 < 16; var1 -= var2) {
         var3 = class110.method639((double)((float)var1 / 360.0F), 0.9998999834060669D, (double)(0.425F * (float)var0 / 16.0F + 0.075F));
         class150.field1331[var0] = var3;
         ++var0;
      }

      var1 = 48;

      for(int var5 = var1 / 6; var0 < class150.field1331.length; var1 -= var5) {
         var3 = var0 * 2;

         for(int var4 = class110.method639((double)((float)var1 / 360.0F), 0.9998999834060669D, 0.5D); var0 < var3 && var0 < class150.field1331.length; ++var0) {
            class150.field1331[var0] = var4;
         }
      }

   }
}
