import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sc")
public enum FillMode implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lsc;"
   )
   @Export("SOLID")
   SOLID(0, 0),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lsc;"
   )
   field4040(1, 1),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lsc;"
   )
   field4041(2, 2);

   @ObfuscatedName("ab")
   public final int field4039;
   @ObfuscatedName("an")
   final int field4042;

   FillMode(int var3, int var4) {
      this.field4039 = var3;
      this.field4042 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field4042;
   }
}
