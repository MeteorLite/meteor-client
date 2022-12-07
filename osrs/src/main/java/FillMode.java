import net.runelite.mapping.ObfuscatedGetter;
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
   field4998(1, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lrv;"
   )
   field4997(2, 2);

   @ObfuscatedName("p")
   public static String operatingSystemName;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1399928939
   )
   public final int field4995;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2002378091
   )
   final int field4999;

   FillMode(int var3, int var4) {
      this.field4995 = var3;
      this.field4999 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.field4999;
   }
}
