import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oj")
@Implements("Bounds")
public class Bounds {
    @ObfuscatedName("f")
    public int lowX;
    @ObfuscatedName("w")
    public int lowY;
    @ObfuscatedName("v")
    public int highX;
    @ObfuscatedName("s")
    public int highY;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.setLow(var1, var2);
      this.setHigh(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IIB)V",
            garbageValue = "95"
    )
    public void setLow(int var1, int var2) {
      this.lowX = var1;
      this.lowY = var2;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "1018354355"
    )
    public void setHigh(int var1, int var2) {
      this.highX = var1;
      this.highY = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "1452685232"
   )
   public boolean method2160(int var1, int var2) {
      return var1 >= this.lowX && var1 < this.lowX + this.highX && var2 >= this.lowY && var2 < this.highY + this.lowY;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Loj;Loj;I)V",
      garbageValue = "-1630455550"
   )
   public void method2161(Bounds var1, Bounds var2) {
      this.method2164(var1, var2);
      this.method2165(var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Loj;Loj;I)V",
      garbageValue = "-1461632973"
   )
   void method2164(Bounds var1, Bounds var2) {
      var2.lowX = this.lowX;
      var2.highX = this.highX;
      if (this.lowX < var1.lowX) {
         var2.highX = (var2.highX * 1795339931 - (var1.lowX * 1795339931 - this.lowX * 1795339931)) * -820822125;
         var2.lowX = var1.lowX;
      }

      if (var2.method2162() > var1.method2162()) {
         var2.highX -= var2.method2162() - var1.method2162();
      }

      if (var2.highX < 0) {
         var2.highX = 0;
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Loj;Loj;I)V",
      garbageValue = "-1126623052"
   )
   void method2165(Bounds var1, Bounds var2) {
      var2.lowY = this.lowY;
      var2.highY = this.highY;
      if (this.lowY < var1.lowY) {
         var2.highY = (var2.highY * -168455399 - (var1.lowY * -168455399 - this.lowY * -168455399)) * 1249777961;
         var2.lowY = var1.lowY;
      }

      if (var2.method2163() > var1.method2163()) {
         var2.highY -= var2.method2163() - var1.method2163();
      }

      if (var2.highY < 0) {
         var2.highY = 0;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1598763426"
   )
   int method2162() {
      return this.highX + this.lowX;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1508699322"
   )
   int method2163() {
      return this.highY + this.lowY;
   }

    @ObfuscatedName("toString")
    public String toString() {
      return null;
   }
}
