import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ow")
public class class408 {
   @ObfuscatedName("h")
   float field3751;
   @ObfuscatedName("e")
   float field3752;
   @ObfuscatedName("v")
   float field3750;

   static {
      new class408(0.0F, 0.0F, 0.0F);
      new class408(1.0F, 1.0F, 1.0F);
      new class408(1.0F, 0.0F, 0.0F);
      new class408(0.0F, 1.0F, 0.0F);
      new class408(0.0F, 0.0F, 1.0F);
   }

   class408(float var1, float var2, float var3) {
      this.field3751 = var1;
      this.field3752 = var2;
      this.field3750 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)F",
      garbageValue = "83"
   )
   final float method2122() {
      return (float)Math.sqrt((double)(this.field3751 * this.field3751 + this.field3752 * this.field3752 + this.field3750 * this.field3750));
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return this.field3751 + ", " + this.field3752 + ", " + this.field3750;
   }
}
