import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("op")
public final class class409 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "[Lop;"
   )
   static class409[] field3754 = new class409[0];
   @ObfuscatedName("e")
   static int field3755 = 100;
   @ObfuscatedName("v")
   static int field3757;
   @ObfuscatedName("x")
   float field3753;
   @ObfuscatedName("m")
   float field3756;
   @ObfuscatedName("q")
   float field3758;
   @ObfuscatedName("f")
   float field3759;

   static {
      field3754 = new class409[100];
      field3757 = 0;
      new class409();
   }

   class409() {
      this.method2126();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1171063218"
   )
   public void method2127() {
      class409[] var1 = field3754;
      synchronized(field3754) {
         if (field3757 < field3755 - 1) {
            field3754[++field3757 - 1] = this;
         }

      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(FFFFI)V",
      garbageValue = "-1050402339"
   )
   void method2123(float var1, float var2, float var3, float var4) {
      this.field3756 = var1;
      this.field3753 = var2;
      this.field3758 = var3;
      this.field3759 = var4;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(FFFFI)V",
      garbageValue = "-733251402"
   )
   public void method2124(float var1, float var2, float var3, float var4) {
      float var5 = (float)Math.sin((double)(var4 * 0.5F));
      float var6 = (float)Math.cos((double)(0.5F * var4));
      this.field3756 = var5 * var1;
      this.field3753 = var5 * var2;
      this.field3758 = var3 * var5;
      this.field3759 = var6;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-48"
   )
   final void method2126() {
      this.field3758 = 0.0F;
      this.field3753 = 0.0F;
      this.field3756 = 0.0F;
      this.field3759 = 1.0F;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lop;I)V",
      garbageValue = "665164038"
   )
   public final void method2125(class409 var1) {
      this.method2123(this.field3758 * var1.field3753 + this.field3756 * var1.field3759 + var1.field3756 * this.field3759 - this.field3753 * var1.field3758, this.field3759 * var1.field3753 + (var1.field3759 * this.field3753 - var1.field3756 * this.field3758) + var1.field3758 * this.field3756, this.field3753 * var1.field3756 + var1.field3759 * this.field3758 - var1.field3753 * this.field3756 + this.field3759 * var1.field3758, var1.field3759 * this.field3759 - this.field3756 * var1.field3756 - var1.field3753 * this.field3753 - this.field3758 * var1.field3758);
   }

   @ObfuscatedName("hashCode")
   public int hashCode() {
      boolean var1 = true;
      float var2 = 1.0F;
      var2 = this.field3756 + var2 * 31.0F;
      var2 = this.field3753 + 31.0F * var2;
      var2 = var2 * 31.0F + this.field3758;
      var2 = this.field3759 + var2 * 31.0F;
      return (int)var2;
   }

   @ObfuscatedName("toString")
   public String toString() {
      return this.field3756 + "," + this.field3753 + "," + this.field3758 + "," + this.field3759;
   }

   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (!(var1 instanceof class409)) {
         return false;
      } else {
         class409 var2 = (class409)var1;
         return this.field3756 == var2.field3756 && this.field3753 == var2.field3753 && var2.field3758 == this.field3758 && this.field3759 == var2.field3759;
      }
   }
}
