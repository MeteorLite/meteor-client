import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Ljd;"
   )
   @Export("WorldMapLabelSize_small")
   public static final WorldMapLabelSize WorldMapLabelSize_small = new WorldMapLabelSize(1, 0, 4);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Ljd;"
   )
   @Export("WorldMapLabelSize_medium")
   public static final WorldMapLabelSize WorldMapLabelSize_medium = new WorldMapLabelSize(2, 1, 2);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Ljd;"
   )
   @Export("WorldMapLabelSize_large")
   public static final WorldMapLabelSize WorldMapLabelSize_large = new WorldMapLabelSize(0, 2, 0);
   @ObfuscatedName("ab")
   final int field2236;
   @ObfuscatedName("an")
   final int field2237;
   @ObfuscatedName("ao")
   final int field2233;

   WorldMapLabelSize(int var1, int var2, int var3) {
      this.field2236 = var1;
      this.field2237 = var2;
      this.field2233 = var3;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(FI)Z",
      garbageValue = "-160354962"
   )
   boolean method1314(float var1) {
      return var1 >= (float)this.field2233;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)[Ljd;",
      garbageValue = "280981839"
   )
   static WorldMapLabelSize[] method1315() {
      return new WorldMapLabelSize[]{WorldMapLabelSize_small, WorldMapLabelSize_medium, WorldMapLabelSize_large};
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IIS)I",
      garbageValue = "-20257"
   )
   static int method1318(int var0, int var1) {
      if (var0 == -2) {
         return 12345678;
      } else if (var0 == -1) {
         if (var1 < 0) {
            var1 = 0;
         } else if (var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if (var1 < 2) {
            var1 = 2;
         } else if (var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "([BI)Ljn;",
      garbageValue = "-999397643"
   )
   static WorldMapSprite method1316(byte[] var0) {
      return var0 == null ? new WorldMapSprite() : new WorldMapSprite(class139.method748(var0).pixels);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)[Lhe;",
      garbageValue = "-106"
   )
   static VerticalAlignment[] method1317() {
      return new VerticalAlignment[]{VerticalAlignment.field1594, VerticalAlignment.field1592, VerticalAlignment.VerticalAlignment_centered};
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(IS)I",
      garbageValue = "16256"
   )
   public static int method1313(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }
}
