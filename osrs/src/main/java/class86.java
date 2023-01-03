import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
public enum class86 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lcy;"
   )
   field870(0, -1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lcy;"
   )
   field863(1, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lcy;"
   )
   field862(2, 7),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lcy;"
   )
   field865(3, 8),
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lcy;"
   )
   field866(4, 9);

   @ObfuscatedName("b")
   public static short[] field869;
   @ObfuscatedName("qu")
   @ObfuscatedSignature(
      descriptor = "Lff;"
   )
   @Export("mouseWheel")
   static class166 mouseWheel;
   @ObfuscatedName("q")
   final int field864;
   @ObfuscatedName("f")
   final int field868;

   class86(int var3, int var4) {
      this.field864 = var3;
      this.field868 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field868;
   }
}
