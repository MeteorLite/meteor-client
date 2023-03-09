import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qe")
public class class419 {
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Lsn;"
   )
   @Export("rightTitleSprite")
   static SpritePixels rightTitleSprite;
   @ObfuscatedName("aj")
   float field3733;
   @ObfuscatedName("al")
   float field3731;
   @ObfuscatedName("ac")
   float field3734;

   static {
      new class419(0.0F, 0.0F, 0.0F);
      new class419(1.0F, 1.0F, 1.0F);
      new class419(1.0F, 0.0F, 0.0F);
      new class419(0.0F, 1.0F, 0.0F);
      new class419(0.0F, 0.0F, 1.0F);
   }

   class419(float var1, float var2, float var3) {
      this.field3733 = var1;
      this.field3731 = var2;
      this.field3734 = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)F",
      garbageValue = "84"
   )
   final float method2178() {
      return (float)Math.sqrt((double)(this.field3731 * this.field3731 + this.field3733 * this.field3733 + this.field3734 * this.field3734));
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return this.field3733 + ", " + this.field3731 + ", " + this.field3734;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lne;Lne;I)I",
      garbageValue = "2060927087"
   )
   static int method2177(AbstractArchive var0, AbstractArchive var1) {
      int var2 = 0;
      String[] var3 = Login.field759;

      int var4;
      String var5;
      for(var4 = 0; var4 < var3.length; ++var4) {
         var5 = var3[var4];
         if (var0.tryLoadFileByNames(var5, "")) {
            ++var2;
         }
      }

      var3 = Login.field760;

      for(var4 = 0; var4 < var3.length; ++var4) {
         var5 = var3[var4];
         if (var1.tryLoadFileByNames(var5, "")) {
            ++var2;
         }
      }

      var3 = Login.field761;

      for(var4 = 0; var4 < var3.length; ++var4) {
         var5 = var3[var4];
         if (var1.getGroupId(var5) != -1 && var1.tryLoadFileByNames(var5, "")) {
            ++var2;
         }
      }

      return var2;
   }
}
