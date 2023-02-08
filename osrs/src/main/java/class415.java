import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oy")
public class class415 {
   @ObfuscatedName("f")
   float field3768;
   @ObfuscatedName("w")
   float field3767;
   @ObfuscatedName("v")
   float field3766;

   static {
      new class415(0.0F, 0.0F, 0.0F);
      new class415(1.0F, 1.0F, 1.0F);
      new class415(1.0F, 0.0F, 0.0F);
      new class415(0.0F, 1.0F, 0.0F);
      new class415(0.0F, 0.0F, 1.0F);
   }

   class415(float var1, float var2, float var3) {
      this.field3768 = var1;
      this.field3767 = var2;
      this.field3766 = var3;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)F",
      garbageValue = "-98"
   )
   final float method2166() {
      return (float)Math.sqrt((double)(this.field3766 * this.field3766 + this.field3767 * this.field3767 + this.field3768 * this.field3768));
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.field3768 + ", " + this.field3767 + ", " + this.field3766;
   }
}
