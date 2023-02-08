import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("MoveSpeed")
public enum MoveSpeed implements class349 {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lhz;"
    )
    STATIONARY((byte)-1),
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lhz;"
    )
    CRAWL((byte)0),
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lhz;"
    )
    WALK((byte)1),
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lhz;"
    )
    RUN((byte)2);

    @ObfuscatedName("qp")
    @ObfuscatedSignature(
            descriptor = "Lqt;"
    )
    static class458 HitSplatDefinition_cached;
    @ObfuscatedName("z")
    public byte speed;

   MoveSpeed(byte var3) {
      this.speed = var3;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.speed;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(IIS)I",
      garbageValue = "-30044"
   )
   public static int method1110(int var0, int var1) {
      return (-3 - var0 << 8) + var1;
   }
}
