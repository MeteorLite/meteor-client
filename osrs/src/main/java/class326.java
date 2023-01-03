import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("le")
public enum class326 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lle;"
   )
   field3404(-1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lle;"
   )
   field3401(0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lle;"
   )
   field3405(1),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lle;"
   )
   field3402(2);

   @ObfuscatedName("m")
   final int field3403;

   class326(int var3) {
      this.field3403 = var3;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.field3403;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)Loj;",
      garbageValue = "1"
   )
   public static class410 method1778() {
      class410[] var0 = class410.field3761;
      synchronized(class410.field3761) {
         if (class410.field3760 == 0) {
            return new class410();
         } else {
            class410.field3761[--class410.field3760].method2131();
            return class410.field3761[class410.field3760];
         }
      }
   }
}
