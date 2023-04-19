import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qu")
@Implements("Bounds")
public class Bounds {
    @ObfuscatedName("af")
    public int lowX;
    @ObfuscatedName("an")
    public int lowY;
    @ObfuscatedName("aw")
    public int highX;
    @ObfuscatedName("ac")
    public int highY;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.setLow(var1, var2);
      this.setHigh(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(IIB)V",
            garbageValue = "26"
    )
    public void setLow(int var1, int var2) {
      this.lowX = var1;
      this.lowY = var2;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(IIB)V",
            garbageValue = "-6"
    )
    public void setHigh(int var1, int var2) {
      this.highX = var1;
      this.highY = var2;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "917820097"
   )
   public boolean method2232(int var1, int var2) {
      return var1 >= this.lowX && var1 < this.highX + this.lowX && var2 >= this.lowY && var2 < this.lowY + this.highY;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lqu;Lqu;I)V",
      garbageValue = "-1323788808"
   )
   public void method2236(Bounds var1, Bounds var2) {
      this.method2233(var1, var2);
      this.method2234(var1, var2);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Lqu;Lqu;B)V",
      garbageValue = "0"
   )
   void method2233(Bounds var1, Bounds var2) {
      var2.lowX = this.lowX;
      var2.highX = this.highX;
      if (this.lowX < var1.lowX) {
         var2.highX = (var2.highX * -1469434281 - (var1.lowX * -1469434281 - this.lowX * -1469434281)) * 944313703;
         var2.lowX = var1.lowX;
      }

      if (var2.method2235() > var1.method2235()) {
         var2.highX -= var2.method2235() - var1.method2235();
      }

      if (var2.highX < 0) {
         var2.highX = 0;
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lqu;Lqu;I)V",
      garbageValue = "924152232"
   )
   void method2234(Bounds var1, Bounds var2) {
      var2.lowY = this.lowY;
      var2.highY = this.highY;
      if (this.lowY < var1.lowY) {
         var2.highY = (var2.highY * 149296003 - (var1.lowY * 149296003 - this.lowY * 149296003)) * -1376251093;
         var2.lowY = var1.lowY;
      }

      if (var2.method2237() > var1.method2237()) {
         var2.highY -= var2.method2237() - var1.method2237();
      }

      if (var2.highY < 0) {
         var2.highY = 0;
      }

   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1027665402"
   )
   int method2235() {
      return this.highX + this.lowX;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1021516763"
   )
   int method2237() {
      return this.highY + this.lowY;
   }

    @ObfuscatedName("toString")
    public String toString() {
      return null;
   }
}
