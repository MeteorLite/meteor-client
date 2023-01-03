import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rv")
public enum FillMode implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lrv;"
   )
   SOLID(0, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lrv;"
   )
   field4063(1, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lrv;"
   )
   field4062(2, 2);

   @ObfuscatedName("p")
   public static String operatingSystemName;
   @ObfuscatedName("x")
   public final int field4060;
   @ObfuscatedName("m")
   final int field4064;

   FillMode(int var3, int var4) {
      this.field4060 = var3;
      this.field4064 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.field4064;
   }
}
