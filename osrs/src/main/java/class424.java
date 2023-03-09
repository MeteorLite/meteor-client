import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qs")
public enum class424 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lqs;"
   )
   field3764(1, 1),
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lqs;"
   )
   field3763(3, 2),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lqs;"
   )
   field3766(0, 3),
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lqs;"
   )
   field3765(2, 10);

   @ObfuscatedName("an")
   final int field3762;
   @ObfuscatedName("ao")
   final int field3767;

   class424(int var3, int var4) {
      this.field3762 = var3;
      this.field3767 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field3767;
   }
}
