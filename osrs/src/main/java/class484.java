import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rd")
public class class484 {
   @ObfuscatedName("e")
   int field4092;
   @ObfuscatedName("v")
   int field4099;
   @ObfuscatedName("x")
   int field4093;
   @ObfuscatedName("m")
   int field4094;
   @ObfuscatedName("q")
   int field4090;
   @ObfuscatedName("f")
   int field4097;
   @ObfuscatedName("r")
   int field4098 = 0;
   @ObfuscatedName("u")
   int field4096 = 0;
   @ObfuscatedName("b")
   boolean field4091;
   @ObfuscatedName("j")
   int field4095;
   @ObfuscatedName("g")
   int field4100;
   @ObfuscatedName("i")
   int field4101;
   @ObfuscatedName("o")
   int field4102;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIIIIIIIIIZI)V",
      garbageValue = "1188082077"
   )
   public void method2500(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, boolean var11) {
      this.field4092 = var1;
      this.field4099 = var2;
      this.field4093 = var3;
      this.field4094 = var4;
      this.field4090 = var5;
      this.field4097 = var6;
      this.field4098 = var9;
      this.field4096 = var10;
      this.field4091 = var11;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "-2046878836"
   )
   public void method2499(int var1, int var2, int var3, int var4) {
      this.field4095 = var1;
      this.field4100 = var2;
      this.field4101 = var3;
      this.field4102 = var4;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lnu;Lnv;B)V",
      garbageValue = "28"
   )
   public void method2498(class368 var1, Font var2) {
      if (var2 != null) {
         int var3 = var2.ascent;
         int var4 = Math.min(this.field4094, (int)(0.9F * (float)var3));
         int var5 = this.field4092 - this.field4090;
         int var6 = var3 + (this.field4099 - this.field4097);
         Rasterizer2D.Rasterizer2D_setClip(this.field4092, this.field4099, this.field4093 + this.field4092, this.field4099 + this.field4094);
         int var7 = this.field4096;
         int var8 = this.field4098;
         if (var7 > var8) {
            int var9 = var7;
            var7 = var8;
            var8 = var9;
         }

         class372 var19 = var1.method1942(0, var7);
         class372 var10 = var1.method1942(var7, var8);
         class372 var11 = var1.method1942(var8, var1.method1921());
         class372 var12 = var1.method1942(0, this.field4098);
         int var14;
         int var16;
         if (!var10.method1984()) {
            int var13 = var2.maxDescent + var2.maxAscent;

            for(var14 = 0; var14 < var10.method1988(); ++var14) {
               class370 var15 = var10.method1987(var14);
               var16 = var5 + var15.field3599;
               int var17 = var2.charWidth(var15.field3597);
               int var18 = var6 + var15.field3598 - var3;
               Rasterizer2D.Rasterizer2D_fillRectangle(var16, var18, var17, var13, this.field4102);
            }
         }

         if (!var19.method1984()) {
            var2.method1963(var19, var5, var6, this.field4095, this.field4100, -1);
         }

         if (!var10.method1984()) {
            var2.method1963(var10, var5, var6, this.field4101, this.field4100, -1);
         }

         if (!var11.method1984()) {
            var2.method1963(var11, var5, var6, this.field4095, this.field4100, -1);
         }

         if (this.field4091) {
            class440 var20 = var12.method1986();
            var14 = var5 + (Integer)var20.field3917;
            int var21 = var6 + (Integer)var20.field3916;
            var16 = var21 - var4;
            Rasterizer2D.Rasterizer2D_drawLine(var14, var21, var14, var16, this.field4095);
            if (this.field4100 != -1) {
               Rasterizer2D.Rasterizer2D_drawLine(var14 + 1, var21 + 1, var14 + 1, var16 + 1, this.field4100);
            }
         }

      }
   }
}
