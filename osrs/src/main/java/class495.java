import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tl")
public class class495 {
   @ObfuscatedName("gc")
   static int field4082;
   @ObfuscatedName("al")
   int field4070;
   @ObfuscatedName("ac")
   int field4071;
   @ObfuscatedName("ab")
   int field4072;
   @ObfuscatedName("an")
   int field4073;
   @ObfuscatedName("ao")
   int field4081;
   @ObfuscatedName("av")
   int field4076;
   @ObfuscatedName("aq")
   int field4074 = 0;
   @ObfuscatedName("ap")
   int field4077 = 0;
   @ObfuscatedName("ar")
   boolean field4078;
   @ObfuscatedName("ak")
   int field4069;
   @ObfuscatedName("ax")
   int field4075;
   @ObfuscatedName("as")
   int field4080;
   @ObfuscatedName("ay")
   int field4079;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIIIZI)V",
      garbageValue = "-1262493748"
   )
   public void method2562(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
      this.field4070 = var1;
      this.field4071 = var2;
      this.field4072 = var3;
      this.field4073 = var4;
      this.field4081 = var5;
      this.field4076 = var6;
      this.field4074 = var7;
      this.field4077 = var8;
      this.field4078 = var9;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "1697791116"
   )
   public void method2560(int var1, int var2, int var3, int var4) {
      this.field4069 = var1;
      this.field4075 = var2;
      this.field4080 = var3;
      this.field4079 = var4;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Low;Loe;I)V",
      garbageValue = "1245058623"
   )
   public void method2561(class375 var1, Font var2) {
      if (var2 != null) {
         int var3 = var2.ascent;
         int var4 = Math.min(this.field4073, (int)((float)var3 * 0.9F));
         int var5 = var1.method1982(this.field4072);
         int var6 = var1.method1977(this.field4073);
         int var7 = var5 + (this.field4070 - this.field4081);
         int var8 = var3 + var6 + (this.field4071 - this.field4076);
         Rasterizer2D.Rasterizer2D_setClip(this.field4070, this.field4071, this.field4072 + this.field4070, this.field4073 + this.field4071);
         int var9 = this.field4077;
         int var10 = this.field4074;
         if (var9 > var10) {
            int var11 = var9;
            var9 = var10;
            var10 = var11;
         }

         class379 var21 = var1.method1958(0, var9);
         class379 var12 = var1.method1958(var9, var10);
         class379 var13 = var1.method1958(var10, var1.method1950());
         class379 var14 = var1.method1958(0, this.field4074);
         int var16;
         int var18;
         if (!var12.method2023()) {
            int var15 = var2.maxDescent + var2.maxAscent;

            for(var16 = 0; var16 < var12.method2024(); ++var16) {
               class377 var17 = var12.method2026(var16);
               var18 = var7 + var17.field3576;
               int var19 = var2.charWidth(var17.field3577);
               int var20 = var8 + var17.field3575 - var3;
               Rasterizer2D.Rasterizer2D_fillRectangle(var18, var20, var19, var15, this.field4079);
            }
         }

         if (!var21.method2023()) {
            var2.method2001(var21, var7, var8, this.field4069, this.field4075, -1);
         }

         if (!var12.method2023()) {
            var2.method2001(var12, var7, var8, this.field4080, this.field4075, -1);
         }

         if (!var13.method2023()) {
            var2.method2001(var13, var7, var8, this.field4069, this.field4075, -1);
         }

         if (this.field4078) {
            class451 var22 = var14.method2028();
            var16 = var7 + (Integer)var22.field3892;
            int var23 = var8 + (Integer)var22.field3893;
            var18 = var23 - var4;
            Rasterizer2D.Rasterizer2D_drawLine(var16, var23, var16, var18, this.field4069);
            if (this.field4075 != -1) {
               Rasterizer2D.Rasterizer2D_drawLine(var16 + 1, var23 + 1, var16 + 1, var18 + 1, this.field4075);
            }
         }

      }
   }
}
