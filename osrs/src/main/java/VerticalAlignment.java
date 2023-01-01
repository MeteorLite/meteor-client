import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public enum VerticalAlignment implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lgl;"
   )
   field2073(0, 0),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lgl;"
   )
   VerticalAlignment_centered(2, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lgl;"
   )
   field2072(1, 2);

   @ObfuscatedName("fc")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive archive17;
   @ObfuscatedName("hm")
   static long field2075;
   @ObfuscatedName("x")
   public final int value;
   @ObfuscatedName("m")
   final int id;

   VerticalAlignment(int var3, int var4) {
      this.value = var3;
      this.id = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lrx;IIII)V",
      garbageValue = "-1925002094"
   )
   static void method3726(SpritePixels var0, int var1, int var2, int var3) {
      DemotingHashTable var4 = WorldMapRegion.WorldMapRegion_cachedSprites;
      long var6 = (long)(var3 << 16 | var1 << 8 | var2);
      var4.put(var0, var6, var0.pixels.length * 4);
   }
}
