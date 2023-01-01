import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public final class WorldMapRectangle {
   @ObfuscatedName("h")
   int width;
   @ObfuscatedName("e")
   int height;
   @ObfuscatedName("v")
   int x;
   @ObfuscatedName("x")
   int y;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lie;"
   )
   @ObfuscatedName("this$0")
   final WorldMapManager this$0;

   @ObfuscatedSignature(
      descriptor = "(Lie;)V"
   )
   WorldMapRectangle(WorldMapManager var1) {
      this.this$0 = var1;
   }
}
