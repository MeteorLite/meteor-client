import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ok")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("h")
   @Export("lowX")
   public int lowX;
   @ObfuscatedName("e")
   @Export("lowY")
   public int lowY;
   @ObfuscatedName("v")
   @Export("highX")
   public int highX;
   @ObfuscatedName("x")
   @Export("highY")
   public int highY;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.setLow(var1, var2);
      this.setHigh(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "0"
   )
   @Export("setLow")
   public void setLow(int var1, int var2) {
      this.lowX = var1;
      this.lowY = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "6"
   )
   @Export("setHigh")
   public void setHigh(int var1, int var2) {
      this.highX = var1;
      this.highY = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "829301461"
   )
   public boolean method2116(int var1, int var2) {
      return var1 >= this.lowX && var1 < this.highX + this.lowX && var2 >= this.lowY && var2 < this.lowY + this.highY;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Lok;Lok;I)V",
      garbageValue = "114731737"
   )
   public void method2121(Bounds var1, Bounds var2) {
      this.method2117(var1, var2);
      this.method2118(var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Lok;Lok;I)V",
      garbageValue = "-451265312"
   )
   void method2117(Bounds var1, Bounds var2) {
      var2.lowX = this.lowX;
      var2.highX = this.highX;
      if (this.lowX < var1.lowX) {
         var2.highX = (var2.highX * 866368565 - (var1.lowX * 866368565 - this.lowX * 866368565)) * -1664174563;
         var2.lowX = var1.lowX;
      }

      if (var2.method2119() > var1.method2119()) {
         var2.highX -= var2.method2119() - var1.method2119();
      }

      if (var2.highX < 0) {
         var2.highX = 0;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(Lok;Lok;I)V",
      garbageValue = "-1783178271"
   )
   void method2118(Bounds var1, Bounds var2) {
      var2.lowY = this.lowY;
      var2.highY = this.highY;
      if (this.lowY < var1.lowY) {
         var2.highY = (var2.highY * 1582333657 - (var1.lowY * 1582333657 - this.lowY * 1582333657)) * -1804459671;
         var2.lowY = var1.lowY;
      }

      if (var2.method2120() > var1.method2120()) {
         var2.highY -= var2.method2120() - var1.method2120();
      }

      if (var2.highY < 0) {
         var2.highY = 0;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "75"
   )
   int method2119() {
      return this.lowX + this.highX;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "0"
   )
   int method2120() {
      return this.highY + this.lowY;
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return null;
   }
}
