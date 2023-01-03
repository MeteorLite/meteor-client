import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("h")
   @Export("z")
   int z;
   @ObfuscatedName("e")
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   @Export("first")
   Renderable first;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   @Export("second")
   Renderable second;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   @Export("third")
   Renderable third;
   @ObfuscatedName("f")
   @Export("tag")
   long tag;
   @ObfuscatedName("r")
   @Export("height")
   int height;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIIB)Lrx;",
      garbageValue = "-109"
   )
   static SpritePixels method1107(int var0, int var1, int var2) {
      DemotingHashTable var3 = WorldMapRegion.WorldMapRegion_cachedSprites;
      long var4 = (long)(var2 << 16 | var0 << 8 | var1);
      return (SpritePixels)var3.get(var4);
   }

   @ObfuscatedName("ne")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "54505361"
   )
   static void method1108(boolean var0) {
      Client.leftClickOpensMenu = var0;
   }
}
