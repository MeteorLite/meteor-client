import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rw")
public abstract class class456 {
   @ObfuscatedName("al")
   int field3896 = 0;
   @ObfuscatedName("at")
   int field3894 = 0;
   @ObfuscatedName("aa")
   double field3897 = 0.0D;
   @ObfuscatedName("ay")
   int field3895 = 0;

   class456(int var1, int var2) {
      this.field3896 = var1;
      this.field3894 = 0;
      this.field3895 = var2 >= 0 && var2 <= 27 ? var2 : 0;
      this.field3897 = class70.method443(this.field3894, this.field3896, this.field3895);
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1607949165"
   )
   public void method2322() {
      if (this.field3894 < this.field3896) {
         ++this.field3894;
         this.field3897 = class70.method443(this.field3894, this.field3896, this.field3895);
      }

   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)D",
      garbageValue = "1089057010"
   )
   double method2323() {
      return this.field3897;
   }
}
