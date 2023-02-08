import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("re")
public enum FillMode implements class349 {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lre;"
    )
    SOLID(0, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lre;"
   )
   field4072(1, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lre;"
   )
   field4073(2, 2);

   @ObfuscatedName("s")
   public final int field4071;
   @ObfuscatedName("z")
   final int field4075;

   FillMode(int var3, int var4) {
      this.field4071 = var3;
      this.field4075 = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.field4075;
   }
}
