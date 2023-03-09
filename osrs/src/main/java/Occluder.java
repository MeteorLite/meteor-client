import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      descriptor = "Lrm;"
   )
   @Export("loginType")
   static LoginType loginType;
   @ObfuscatedName("aj")
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("al")
   @Export("maxTileX")
   int maxTileX;
   @ObfuscatedName("ac")
   @Export("minTileY")
   int minTileY;
   @ObfuscatedName("ab")
   @Export("maxTileY")
   int maxTileY;
   @ObfuscatedName("an")
   @Export("type")
   int type;
   @ObfuscatedName("ao")
   @Export("minX")
   int minX;
   @ObfuscatedName("av")
   @Export("maxX")
   int maxX;
   @ObfuscatedName("aq")
   @Export("minZ")
   int minZ;
   @ObfuscatedName("ap")
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("ar")
   @Export("minY")
   int minY;
   @ObfuscatedName("ak")
   @Export("maxY")
   int maxY;
   @ObfuscatedName("ax")
   int field2067;
   @ObfuscatedName("as")
   int field2068;
   @ObfuscatedName("ay")
   int field2056;
   @ObfuscatedName("am")
   int field2070;
   @ObfuscatedName("az")
   int field2059;
   @ObfuscatedName("ae")
   int field2072;
   @ObfuscatedName("au")
   int field2069;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(S)[Lej;",
      garbageValue = "22012"
   )
   static class125[] method1252() {
      return new class125[]{class125.field1194, class125.field1193, class125.field1189, class125.field1188, class125.field1190};
   }

   @ObfuscatedName("iw")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "-3"
   )
   static int method1251(int var0, int var1) {
      int var2 = var1 - 334;
      if (var2 < 0) {
         var2 = 0;
      } else if (var2 > 100) {
         var2 = 100;
      }

      int var3 = (Client.zoomWidth - Client.zoomHeight) * var2 / 100 + Client.zoomHeight;
      return var0 * var3 / 256;
   }
}
