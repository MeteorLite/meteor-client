import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rj")
public class class491 {
    @ObfuscatedName("cq")
    @ObfuscatedSignature(
            descriptor = "[Lrs;"
    )
    static SpritePixels[] worldSelectBackSprites;
    @ObfuscatedName("qr")
    @ObfuscatedSignature(
            descriptor = "Lqt;"
    )
    static class458 HitSplatDefinition_cachedSprites;
   @ObfuscatedName("w")
   int field4113;
   @ObfuscatedName("v")
   int field4101;
   @ObfuscatedName("s")
   int field4103;
   @ObfuscatedName("z")
   int field4110;
   @ObfuscatedName("j")
   int field4104;
   @ObfuscatedName("i")
   int field4106;
   @ObfuscatedName("n")
   int field4102 = 0;
   @ObfuscatedName("l")
   int field4108 = 0;
   @ObfuscatedName("k")
   boolean field4109;
   @ObfuscatedName("c")
   int field4105;
   @ObfuscatedName("r")
   int field4111;
   @ObfuscatedName("b")
   int field4112;
   @ObfuscatedName("m")
   int field4107;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIIIIIZB)V",
      garbageValue = "86"
   )
   public void method2537(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, boolean var11) {
      this.field4113 = var1;
      this.field4101 = var2;
      this.field4103 = var3;
      this.field4110 = var4;
      this.field4104 = var5;
      this.field4106 = var6;
      this.field4102 = var9;
      this.field4108 = var10;
      this.field4109 = var11;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "-169216674"
   )
   public void method2535(int var1, int var2, int var3, int var4) {
      this.field4105 = var1;
      this.field4111 = var2;
      this.field4112 = var3;
      this.field4107 = var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lnp;Lnv;I)V",
      garbageValue = "887975010"
   )
   public void method2536(class372 var1, Font var2) {
      if (var2 != null) {
         int var3 = var2.ascent;
         int var4 = Math.min(this.field4110, (int)(0.9F * (float)var3));
         int var5 = this.field4113 - this.field4104;
         int var6 = var3 + (this.field4101 - this.field4106);
         Rasterizer2D.Rasterizer2D_setClip(this.field4113, this.field4101, this.field4103 + this.field4113, this.field4110 + this.field4101);
         int var7 = this.field4108;
         int var8 = this.field4102;
         if (var7 > var8) {
            int var9 = var7;
            var7 = var8;
            var8 = var9;
         }

         class376 var19 = var1.method1965(0, var7);
         class376 var10 = var1.method1965(var7, var8);
         class376 var11 = var1.method1965(var8, var1.method1967());
         class376 var12 = var1.method1965(0, this.field4102);
         int var14;
         int var16;
         if (!var10.method2006()) {
            int var13 = var2.maxDescent + var2.maxAscent;

            for(var14 = 0; var14 < var10.method2008(); ++var14) {
               class374 var15 = var10.method2011(var14);
               var16 = var5 + var15.field3601;
               int var17 = var2.charWidth(var15.field3603);
               int var18 = var6 + var15.field3602 - var3;
               Rasterizer2D.Rasterizer2D_fillRectangle(var16, var18, var17, var13, this.field4107);
            }
         }

         if (!var19.method2006()) {
            var2.method1985(var19, var5, var6, this.field4105, this.field4111, -1);
         }

         if (!var10.method2006()) {
            var2.method1985(var10, var5, var6, this.field4112, this.field4111, -1);
         }

         if (!var11.method2006()) {
            var2.method1985(var11, var5, var6, this.field4105, this.field4111, -1);
         }

         if (this.field4109) {
            class447 var20 = var12.method2010();
            var14 = var5 + (Integer)var20.field3927;
            int var21 = var6 + (Integer)var20.field3928;
            var16 = var21 - var4;
            Rasterizer2D.Rasterizer2D_drawLine(var14, var21, var14, var16, this.field4105);
            if (this.field4111 != -1) {
               Rasterizer2D.Rasterizer2D_drawLine(var14 + 1, var21 + 1, var14 + 1, var16 + 1, this.field4111);
            }
         }

      }
   }
}
