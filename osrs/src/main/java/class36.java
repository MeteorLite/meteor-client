import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class36 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lni;"
   )
   @Export("reflectionChecks")
   public static IterableNodeDeque reflectionChecks = new IterableNodeDeque();
   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   static Archive field149;
   @ObfuscatedName("kd")
   @ObfuscatedSignature(
      descriptor = "[Lsp;"
   )
   @Export("modIconSprites")
   static IndexedSprite[] modIconSprites;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "-105"
   )
   public static int method175(int var0) {
      return var0 >>> 12;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-75"
   )
   static void method176() {
      Tiles.Tiles_underlays = null;
      Tiles.Tiles_overlays = null;
      class16.Tiles_shapes = null;
      Tiles.field823 = null;
      class17.field51 = null;
      Decimator.field300 = null;
      class306.field2773 = null;
      Tiles.Tiles_hue = null;
      class134.Tiles_saturation = null;
      Language.Tiles_lightness = null;
      TileItem.Tiles_hueMultiplier = null;
      Interpreter.field696 = null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IIB)Lmy;",
      garbageValue = "1"
   )
   @Export("getWidgetChild")
   public static Widget getWidgetChild(int var0, int var1) {
      Widget var2 = WorldMapSection1.getWidget(var0);
      if (var1 == -1) {
         return var2;
      } else {
         return var2 != null && var2.children != null && var1 < var2.children.length ? var2.children[var1] : null;
      }
   }
}
