import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qc")
public class class426 {
   @ObfuscatedName("fa")
   @ObfuscatedSignature(
      descriptor = "Lnd;"
   )
   static Archive field3811;
   @ObfuscatedName("af")
   float field3810;
   @ObfuscatedName("an")
   float field3799;
   @ObfuscatedName("aw")
   float field3800;
   @ObfuscatedName("ac")
   float field3801;
   @ObfuscatedName("au")
   float field3802;
   @ObfuscatedName("ab")
   float field3803;
   @ObfuscatedName("aq")
   float field3804;
   @ObfuscatedName("al")
   float field3805;
   @ObfuscatedName("at")
   float field3806;
   @ObfuscatedName("aa")
   float field3807;
   @ObfuscatedName("ay")
   float field3808;
   @ObfuscatedName("ao")
   float field3809;

   static {
      new class426();
   }

   class426() {
      this.method2269();
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-23475"
   )
   void method2269() {
      this.field3809 = 0.0F;
      this.field3808 = 0.0F;
      this.field3807 = 0.0F;
      this.field3805 = 0.0F;
      this.field3804 = 0.0F;
      this.field3803 = 0.0F;
      this.field3801 = 0.0F;
      this.field3800 = 0.0F;
      this.field3799 = 0.0F;
      this.field3806 = 1.0F;
      this.field3802 = 1.0F;
      this.field3810 = 1.0F;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(FI)V",
      garbageValue = "-1749175533"
   )
   void method2266(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3799;
      float var5 = this.field3802;
      float var6 = this.field3805;
      float var7 = this.field3808;
      this.field3799 = var4 * var2 - this.field3800 * var3;
      this.field3800 = this.field3800 * var2 + var3 * var4;
      this.field3802 = var2 * var5 - var3 * this.field3803;
      this.field3803 = this.field3803 * var2 + var5 * var3;
      this.field3805 = var6 * var2 - var3 * this.field3806;
      this.field3806 = this.field3806 * var2 + var3 * var6;
      this.field3808 = var2 * var7 - this.field3809 * var3;
      this.field3809 = var3 * var7 + var2 * this.field3809;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(FI)V",
      garbageValue = "1665202061"
   )
   void method2267(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3810;
      float var5 = this.field3801;
      float var6 = this.field3804;
      float var7 = this.field3807;
      this.field3810 = var3 * this.field3800 + var2 * var4;
      this.field3800 = var2 * this.field3800 - var4 * var3;
      this.field3801 = var3 * this.field3803 + var5 * var2;
      this.field3803 = this.field3803 * var2 - var5 * var3;
      this.field3804 = var3 * this.field3806 + var2 * var6;
      this.field3806 = this.field3806 * var2 - var3 * var6;
      this.field3807 = var2 * var7 + var3 * this.field3809;
      this.field3809 = var2 * this.field3809 - var7 * var3;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(FB)V",
      garbageValue = "61"
   )
   void method2268(float var1) {
      float var2 = (float)Math.cos((double)var1);
      float var3 = (float)Math.sin((double)var1);
      float var4 = this.field3810;
      float var5 = this.field3801;
      float var6 = this.field3804;
      float var7 = this.field3807;
      this.field3810 = var4 * var2 - this.field3799 * var3;
      this.field3799 = var2 * this.field3799 + var4 * var3;
      this.field3801 = var5 * var2 - this.field3802 * var3;
      this.field3802 = var3 * var5 + var2 * this.field3802;
      this.field3804 = var2 * var6 - this.field3805 * var3;
      this.field3805 = var2 * this.field3805 + var3 * var6;
      this.field3807 = var2 * var7 - var3 * this.field3808;
      this.field3808 = var2 * this.field3808 + var3 * var7;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(FFFB)V",
      garbageValue = "117"
   )
   void method2265(float var1, float var2, float var3) {
      this.field3807 += var1;
      this.field3808 += var2;
      this.field3809 += var3;
   }

    @ObfuscatedName("toString")
    public String toString() {
      return this.field3810 + "," + this.field3801 + "," + this.field3804 + "," + this.field3807 + "\n" + this.field3799 + "," + this.field3802 + "," + this.field3805 + "," + this.field3808 + "\n" + this.field3800 + "," + this.field3803 + "," + this.field3806 + "," + this.field3809;
   }

    @ObfuscatedName("ns")
    @ObfuscatedSignature(
            descriptor = "(IIIILtq;Lll;I)V",
            garbageValue = "-1609285207"
    )
    static final void drawSpriteOnMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpriteMask var5) {
      if (var4 != null) {
         int var6 = Client.camAngleY & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if (var7 <= 6400) {
            int var8 = Rasterizer3D.Rasterizer3D_sine[var6];
            int var9 = Rasterizer3D.Rasterizer3D_cosine[var6];
            int var10 = var9 * var2 + var3 * var8 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if (var7 > 2500) {
               var4.method2609(var10 + var5.width / 2 - var4.width / 2, var5.height / 2 - var11 - var4.height / 2, var0, var1, var5.width, var5.height, var5.xStarts, var5.xWidths);
            } else {
               var4.drawTransBgAt(var0 + var10 + var5.width / 2 - var4.width / 2, var5.height / 2 + var1 - var11 - var4.height / 2);
            }

         }
      }
   }
}
