import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
final class class100 implements class301 {
    @ObfuscatedName("n")
    public static int[] SpriteBuffer_spritePalette;
    @ObfuscatedName("k")
    static int[] Tiles_hue;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lrg;"
   )
   static IndexedSprite field1079;
   // $FF: synthetic field
   @ObfuscatedSignature(
           descriptor = "Lkz;"
   )
   @ObfuscatedName("val$cc")
   final Widget val$cc;

   @ObfuscatedSignature(
      descriptor = "(Lkz;)V"
   )
   class100(Widget var1) {
      this.val$cc = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1666573426"
    )
    public void vmethod5708() {
      if (this.val$cc != null && this.val$cc.method1747().field2805 != null) {
         ScriptEvent var1 = new ScriptEvent();
         var1.method461(this.val$cc);
         var1.setArgs(this.val$cc.method1747().field2805);
         class12.getScriptEvents().addFirst(var1);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-121"
   )
   public static void method595() {
      class488.SpriteBuffer_xOffsets = null;
      ApproximateRouteStrategy.SpriteBuffer_yOffsets = null;
      FriendsList.SpriteBuffer_spriteWidths = null;
      class132.SpriteBuffer_spriteHeights = null;
      SpriteBuffer_spritePalette = null;
      class140.SpriteBuffer_pixels = null;
   }
}
