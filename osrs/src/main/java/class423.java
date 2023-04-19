import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qr")
public class class423 {
   @ObfuscatedName("af")
   float field3784;
   @ObfuscatedName("an")
   float field3782;
   @ObfuscatedName("aw")
   float field3783;

   static {
      new class423(0.0F, 0.0F, 0.0F);
      new class423(1.0F, 1.0F, 1.0F);
      new class423(1.0F, 0.0F, 0.0F);
      new class423(0.0F, 1.0F, 0.0F);
      new class423(0.0F, 0.0F, 1.0F);
   }

   class423(float var1, float var2, float var3) {
      this.field3784 = var1;
      this.field3782 = var2;
      this.field3783 = var3;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)F",
      garbageValue = "79"
   )
   final float method2239() {
      return (float)Math.sqrt((double)(this.field3783 * this.field3783 + this.field3784 * this.field3784 + this.field3782 * this.field3782));
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.field3784 + ", " + this.field3782 + ", " + this.field3783;
   }
}
