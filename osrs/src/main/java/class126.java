import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class126 implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Ldk;"
   )
   static final class126 field1227 = new class126(0, 0, (String)null, 0);
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Ldk;"
   )
   static final class126 field1229 = new class126(1, 1, (String)null, 9);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ldk;"
   )
   static final class126 field1235 = new class126(2, 2, (String)null, 3);
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Ldk;"
   )
   static final class126 field1230 = new class126(3, 3, (String)null, 6);
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Ldk;"
   )
   static final class126 field1232 = new class126(4, 4, (String)null, 1);
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Ldk;"
   )
   static final class126 field1231 = new class126(5, 5, (String)null, 3);
   @ObfuscatedName("i")
   final int field1228;
   @ObfuscatedName("n")
   final int field1233;
   @ObfuscatedName("l")
   final int field1234;

   class126(int var1, int var2, String var3, int var4) {
      this.field1228 = var1;
      this.field1233 = var2;
      this.field1234 = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.field1233;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "20"
   )
   int method708() {
      return this.field1234;
   }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "(CI)Z",
            garbageValue = "1018736825"
    )
    public static boolean isCharPrintable(char var0) {
      if (var0 >= ' ' && var0 <= '~') {
         return true;
      } else if (var0 >= 160 && var0 <= 255) {
         return true;
      } else {
         return var0 == 8364 || var0 == 338 || var0 == 8212 || var0 == 339 || var0 == 376;
      }
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZB)I",
      garbageValue = "50"
   )
   static int method709(int var0, Script var1, boolean var2) {
      return 2;
   }
}
