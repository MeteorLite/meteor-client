import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ly")
public enum class317 implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   field3024(0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   field3025(1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   field3023(2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   field3026(3),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   field3027(4);

   @ObfuscatedName("j")
   final int field3028;

   class317(int var3) {
      this.field3028 = var3;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.field3028;
   }

    @ObfuscatedName("ld")
    @ObfuscatedSignature(
            descriptor = "(Lkz;B)Ljava/lang/String;",
            garbageValue = "-20"
    )
    static String Widget_getSpellActionName(Widget var0) {
      if (MenuAction.Widget_unpackTargetMask(class173.getWidgetFlags(var0)) == 0) {
         return null;
      } else {
         return var0.spellActionName != null && var0.spellActionName.trim().length() != 0 ? var0.spellActionName : null;
      }
   }
}
