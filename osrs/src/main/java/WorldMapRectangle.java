import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public final class WorldMapRectangle {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -175790253
   )
   int width;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 424237321
   )
   int height;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 602652957
   )
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -422577093
   )
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
