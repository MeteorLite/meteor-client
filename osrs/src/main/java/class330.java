import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lo")
public enum class330 implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Llo;"
   )
   field3403(-1),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Llo;"
   )
   field3407(0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Llo;"
   )
   field3404(1),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Llo;"
   )
   field3405(2);

   @ObfuscatedName("z")
   final int field3406;

   class330(int var3) {
      this.field3406 = var3;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.field3406;
   }
}
