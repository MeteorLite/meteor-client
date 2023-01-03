import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
@Implements("WorldMapRectangle")
public final class WorldMapRectangle {
   @ObfuscatedName("h")
   @Export("width")
   int width;
   @ObfuscatedName("e")
   @Export("height")
   int height;
   @ObfuscatedName("v")
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @Export("y")
   int y;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lie;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      descriptor = "(Lie;)V"
   )
   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }
}
