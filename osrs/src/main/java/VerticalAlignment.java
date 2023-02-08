import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gd")
@Implements("VerticalAlignment")
public enum VerticalAlignment implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lgd;"
   )
   field1598(1, 0),
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lgd;"
    )
    VerticalAlignment_centered(2, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lgd;"
   )
   field1600(0, 2);

   @ObfuscatedName("l")
   static int field1595;
   @ObfuscatedName("bi")
   static String field1594;
    @ObfuscatedName("s")
    public final int value;
    @ObfuscatedName("z")
    final int id;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.id;
   }
}
