import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("px")
public enum class420 implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lpx;"
   )
   field3798(0, 1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lpx;"
   )
   field3797(3, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lpx;"
   )
   field3796(1, 3),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lpx;"
   )
   field3799(2, 10);

   @ObfuscatedName("z")
   final int field3800;
   @ObfuscatedName("j")
   final int field3801;

   class420(int var3, int var4) {
      this.field3800 = var3;
      this.field3801 = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.field3801;
   }
}
