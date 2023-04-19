import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class96 {
   @ObfuscatedName("ar")
   @Export("cacheSubPaths")
   public static String[] cacheSubPaths;
   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "Lqu;"
   )
   static Bounds field1063;
   @ObfuscatedName("ls")
   static int field1064;
   @ObfuscatedName("qe")
   @Export("widgetDragDuration")
   static int widgetDragDuration;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)J",
      garbageValue = "55191168"
   )
   @Export("clockNow")
   public static final synchronized long clockNow() {
      long var0 = System.currentTimeMillis();
      if (var0 < class293.field2711) {
         class293.field2712 += class293.field2711 - var0;
      }

      class293.field2711 = var0;
      return var0 + class293.field2712;
   }
}
