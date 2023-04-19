import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class class192 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lhl;"
   )
   static final class192 field1617;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lhl;"
   )
   static final class192 field1612;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lhl;"
   )
   static final class192 field1613;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lhl;"
   )
   static final class192 field1611;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lhl;"
   )
   static final class192 field1615;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lhl;"
   )
   static final class192 field1616;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lhl;"
   )
   static final class192 field1618;
    @ObfuscatedName("nf")
    static int menuX;

   static {
      field1617 = new class192(0, class204.field1839);
      field1612 = new class192(1, class204.field1840);
      field1613 = new class192(2, class204.field1835);
      field1611 = new class192(3, class204.field1837);
      field1615 = new class192(4, class204.field1834);
      field1616 = new class192(5, class204.field1838);
      field1618 = new class192(6, class204.field1843);
   }

   @ObfuscatedSignature(
      descriptor = "(ILhp;)V"
   )
   class192(int var1, class204 var2) {
   }

    @ObfuscatedName("lj")
    @ObfuscatedSignature(
            descriptor = "(Lmq;IIB)V",
            garbageValue = "-121"
    )
    static void alignWidgetPosition(Widget var0, int var1, int var2) {
      if (var0.xAlignment == 0) {
         var0.x = var0.rawX;
      } else if (var0.xAlignment == 1) {
         var0.x = var0.rawX + (var1 - var0.width) / 2;
      } else if (var0.xAlignment == 2) {
         var0.x = var1 - var0.width - var0.rawX;
      } else if (var0.xAlignment == 3) {
         var0.x = var0.rawX * var1 >> 14;
      } else if (var0.xAlignment == 4) {
         var0.x = (var0.rawX * var1 >> 14) + (var1 - var0.width) / 2;
      } else {
         var0.x = var1 - var0.width - (var0.rawX * var1 >> 14);
      }

      if (var0.yAlignment == 0) {
         var0.y = var0.rawY;
      } else if (var0.yAlignment == 1) {
         var0.y = (var2 - var0.height) / 2 + var0.rawY;
      } else if (var0.yAlignment == 2) {
         var0.y = var2 - var0.height - var0.rawY;
      } else if (var0.yAlignment == 3) {
         var0.y = var2 * var0.rawY >> 14;
      } else if (var0.yAlignment == 4) {
         var0.y = (var2 - var0.height) / 2 + (var2 * var0.rawY >> 14);
      } else {
         var0.y = var2 - var0.height - (var2 * var0.rawY >> 14);
      }

   }
}
