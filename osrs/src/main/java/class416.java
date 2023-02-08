import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pl")
public final class class416 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "[Lpl;"
   )
   public static class416[] field3770 = new class416[0];
   @ObfuscatedName("v")
   static int field3769;
   @ObfuscatedName("z")
   float field3774;
   @ObfuscatedName("j")
   float field3771;
   @ObfuscatedName("i")
   float field3772;
   @ObfuscatedName("n")
   float field3773;

   static {
      class365.method1926(100);
      new class416();
   }

   public class416() {
      this.method2168();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-88"
   )
   public void method2170() {
      class416[] var1 = field3770;
      synchronized(field3770) {
         if (class388.field3666 < field3769 - 1) {
            field3770[++class388.field3666 - 1] = this;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(FFFFI)V",
      garbageValue = "-1022734820"
   )
   void method2167(float var1, float var2, float var3, float var4) {
      this.field3771 = var1;
      this.field3772 = var2;
      this.field3773 = var3;
      this.field3774 = var4;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(FFFFI)V",
      garbageValue = "1628774920"
   )
   public void method2171(float var1, float var2, float var3, float var4) {
      float var5 = (float)Math.sin((double)(var4 * 0.5F));
      float var6 = (float)Math.cos((double)(var4 * 0.5F));
      this.field3771 = var1 * var5;
      this.field3772 = var2 * var5;
      this.field3773 = var5 * var3;
      this.field3774 = var6;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1066361998"
   )
   public final void method2168() {
      this.field3773 = 0.0F;
      this.field3772 = 0.0F;
      this.field3771 = 0.0F;
      this.field3774 = 1.0F;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Lpl;I)V",
      garbageValue = "232975455"
   )
   public final void method2169(class416 var1) {
      this.method2167(var1.field3772 * this.field3773 + this.field3774 * var1.field3771 + var1.field3774 * this.field3771 - this.field3772 * var1.field3773, this.field3771 * var1.field3773 + this.field3772 * var1.field3774 - var1.field3771 * this.field3773 + var1.field3772 * this.field3774, var1.field3774 * this.field3773 + var1.field3771 * this.field3772 - this.field3771 * var1.field3772 + var1.field3773 * this.field3774, var1.field3774 * this.field3774 - this.field3771 * var1.field3771 - var1.field3772 * this.field3772 - var1.field3773 * this.field3773);
   }

    @ObfuscatedName("equals")
    public boolean equals(Object var1) {
      if (!(var1 instanceof class416)) {
         return false;
      } else {
         class416 var2 = (class416)var1;
         return this.field3771 == var2.field3771 && var2.field3772 == this.field3772 && var2.field3773 == this.field3773 && var2.field3774 == this.field3774;
      }
   }

    @ObfuscatedName("hashCode")
    public int hashCode() {
      boolean var1 = true;
      float var2 = 1.0F;
      var2 = var2 * 31.0F + this.field3771;
      var2 = this.field3772 + var2 * 31.0F;
      var2 = this.field3773 + var2 * 31.0F;
      var2 = var2 * 31.0F + this.field3774;
      return (int)var2;
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.field3771 + "," + this.field3772 + "," + this.field3773 + "," + this.field3774;
   }
}
