import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tz")
public class class506 {
   @ObfuscatedName("an")
   int field4149;
   @ObfuscatedName("aw")
   int field4150;
   @ObfuscatedName("ac")
   int field4151;
   @ObfuscatedName("au")
   int field4152;
   @ObfuscatedName("ab")
   int field4153;
   @ObfuscatedName("aq")
   int field4154;
   @ObfuscatedName("al")
   int field4156 = 0;
   @ObfuscatedName("at")
   int field4155 = 0;
   @ObfuscatedName("aa")
   boolean field4158;
   @ObfuscatedName("ay")
   int field4157;
   @ObfuscatedName("ao")
   int field4148;
   @ObfuscatedName("ax")
   int field4159;
   @ObfuscatedName("ai")
   int field4160;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIIIZI)V",
      garbageValue = "1599579546"
   )
   public void method2637(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, boolean var9) {
      this.field4149 = var1;
      this.field4150 = var2;
      this.field4151 = var3;
      this.field4152 = var4;
      this.field4153 = var5;
      this.field4154 = var6;
      this.field4156 = var7;
      this.field4155 = var8;
      this.field4158 = var9;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "561435765"
   )
   public void method2639(int var1, int var2, int var3, int var4) {
      this.field4157 = var1;
      this.field4148 = var2;
      this.field4159 = var3;
      this.field4160 = var4;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Loq;Lon;B)V",
      garbageValue = "-20"
   )
   public void method2638(class379 var1, Font var2) {
      if (var2 != null) {
         int var3 = var2.ascent;
         int var4 = Math.min(this.field4152, (int)((float)var3 * 0.9F));
         int var5 = var1.method2039(this.field4151);
         int var6 = var1.method2040(this.field4152);
         int var7 = var5 + (this.field4149 - this.field4153);
         int var8 = var6 + var3 + (this.field4150 - this.field4154);
         Rasterizer2D.Rasterizer2D_setClip(this.field4149, this.field4150, this.field4151 + this.field4149, this.field4152 + this.field4150);
         int var9 = this.field4155;
         int var10 = this.field4156;
         if (var9 > var10) {
            int var11 = var9;
            var9 = var10;
            var10 = var11;
         }

         class383 var21 = var1.method2035(0, var9);
         class383 var12 = var1.method2035(var9, var10);
         class383 var13 = var1.method2035(var10, var1.method2006());
         class383 var14 = var1.method2035(0, this.field4156);
         int var16;
         int var18;
         if (!var12.method2078()) {
            int var15 = var2.maxAscent + var2.maxDescent;

            for(var16 = 0; var16 < var12.method2079(); ++var16) {
               class381 var17 = var12.method2080(var16);
               var18 = var7 + var17.field3623;
               int var19 = var2.charWidth(var17.field3624);
               int var20 = var8 + var17.field3625 - var3;
               Rasterizer2D.Rasterizer2D_fillRectangle(var18, var20, var19, var15, this.field4160);
            }
         }

         if (!var21.method2078()) {
            var2.method2056(var21, var7, var8, this.field4157, this.field4148, -1);
         }

         if (!var12.method2078()) {
            var2.method2056(var12, var7, var8, this.field4159, this.field4148, -1);
         }

         if (!var13.method2078()) {
            var2.method2056(var13, var7, var8, this.field4157, this.field4148, -1);
         }

         if (this.field4158) {
            class461 var22 = var14.method2077();
            var16 = var7 + (Integer)var22.field3972;
            int var23 = var8 + (Integer)var22.field3973;
            var18 = var23 - var4;
            Rasterizer2D.Rasterizer2D_drawLine(var16, var23, var16, var18, this.field4157);
            if (this.field4148 != -1) {
               Rasterizer2D.Rasterizer2D_drawLine(var16 + 1, var23 + 1, var16 + 1, var18 + 1, this.field4148);
            }
         }

      }
   }
}
