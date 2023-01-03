import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oc")
public class class411 {
   @ObfuscatedName("h")
   float field3774;
   @ObfuscatedName("e")
   float field3767;
   @ObfuscatedName("v")
   float field3768;
   @ObfuscatedName("x")
   float field3775;
   @ObfuscatedName("m")
   float field3770;
   @ObfuscatedName("q")
   float field3771;
   @ObfuscatedName("f")
   float field3772;
   @ObfuscatedName("r")
   float field3773;
   @ObfuscatedName("u")
   float field3766;
   @ObfuscatedName("b")
   float field3777;
   @ObfuscatedName("j")
   float field3776;
   @ObfuscatedName("g")
   float field3769;

   static {
      new class411();
   }

   class411() {
      this.method2147();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "55"
   )
   void method2147() {
      this.field3769 = 0.0F;
      this.field3776 = 0.0F;
      this.field3777 = 0.0F;
      this.field3773 = 0.0F;
      this.field3772 = 0.0F;
      this.field3771 = 0.0F;
      this.field3775 = 0.0F;
      this.field3768 = 0.0F;
      this.field3767 = 0.0F;
      this.field3766 = 1.0F;
      this.field3770 = 1.0F;
      this.field3774 = 1.0F;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(FB)V",
      garbageValue = "117"
   )
   void method2145(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3767;
      float var5 = this.field3770;
      float var6 = this.field3773;
      float var7 = this.field3776;
      this.field3767 = var4 * var2 - var3 * this.field3768;
      this.field3768 = var2 * this.field3768 + var4 * var3;
      this.field3770 = var2 * var5 - var3 * this.field3771;
      this.field3771 = var5 * var3 + this.field3771 * var2;
      this.field3773 = var2 * var6 - this.field3766 * var3;
      this.field3766 = var6 * var3 + this.field3766 * var2;
      this.field3776 = var7 * var2 - var3 * this.field3769;
      this.field3769 = var2 * this.field3769 + var3 * var7;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(FB)V",
      garbageValue = "-45"
   )
   void method2146(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3774;
      float var5 = this.field3775;
      float var6 = this.field3772;
      float var7 = this.field3777;
      this.field3774 = var3 * this.field3768 + var4 * var2;
      this.field3768 = var2 * this.field3768 - var4 * var3;
      this.field3775 = var3 * this.field3771 + var2 * var5;
      this.field3771 = this.field3771 * var2 - var5 * var3;
      this.field3772 = var3 * this.field3766 + var6 * var2;
      this.field3766 = var2 * this.field3766 - var3 * var6;
      this.field3777 = this.field3769 * var3 + var7 * var2;
      this.field3769 = this.field3769 * var2 - var7 * var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(FI)V",
      garbageValue = "-1457477658"
   )
   void method2149(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3774;
      float var5 = this.field3775;
      float var6 = this.field3772;
      float var7 = this.field3777;
      this.field3774 = var4 * var2 - var3 * this.field3767;
      this.field3767 = var4 * var3 + this.field3767 * var2;
      this.field3775 = var5 * var2 - var3 * this.field3770;
      this.field3770 = var5 * var3 + this.field3770 * var2;
      this.field3772 = var6 * var2 - this.field3773 * var3;
      this.field3773 = var2 * this.field3773 + var3 * var6;
      this.field3777 = var2 * var7 - this.field3776 * var3;
      this.field3776 = var7 * var3 + this.field3776 * var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(FFFB)V",
      garbageValue = "11"
   )
   void method2148(float var1, float var2, float var3) {
      this.field3777 += var1;
      this.field3776 += var2;
      this.field3769 += var3;
   }

   @ObfuscatedName("toString")
   public String toString() {
      return this.field3774 + "," + this.field3775 + "," + this.field3772 + "," + this.field3777 + "\n" + this.field3767 + "," + this.field3770 + "," + this.field3773 + "," + this.field3776 + "\n" + this.field3768 + "," + this.field3771 + "," + this.field3766 + "," + this.field3769;
   }
}
