import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
public enum class6 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lf;"
   )
   field7(0, 0);

   @ObfuscatedName("e")
   final int field6;
   @ObfuscatedName("v")
   final int field8;

   class6(int var3, int var4) {
      this.field6 = var3;
      this.field8 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field8;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1148872564"
   )
   public static void method14() {
      class251.midiPcmStream.clear();
      class286.musicPlayerStatus = 1;
      class304.musicTrackArchive = null;
   }
}
