import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
public final class ItemLayer {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -550242183
   )
   int z;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -733443873
   )
   int x;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 659820055
   )
   int y;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   Renderable first;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   Renderable second;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   Renderable third;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -8382761698159618857L
   )
   long tag;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -999463859
   )
   int height;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IIIB)Lrx;",
      garbageValue = "-109"
   )
   static SpritePixels method4197(int var0, int var1, int var2) {
      DemotingHashTable var3 = WorldMapRegion.WorldMapRegion_cachedSprites;
      long var4 = (long)(var2 << 16 | var0 << 8 | var1);
      return (SpritePixels)var3.get(var4);
   }

   @ObfuscatedName("ne")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "54505361"
   )
   static void method4198(boolean var0) {
      Client.leftClickOpensMenu = var0;
   }
}
