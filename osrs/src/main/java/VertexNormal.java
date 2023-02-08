import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("VertexNormal")
public class VertexNormal {
    @ObfuscatedName("f")
    int x;
    @ObfuscatedName("w")
    int y;
    @ObfuscatedName("v")
    int z;
    @ObfuscatedName("s")
    int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      descriptor = "(Lht;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(II)J",
      garbageValue = "1903334964"
   )
   public static long method1298(int var0) {
      return ViewportMouse.ViewportMouse_entityTags[var0];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1985144350"
   )
   static void method1299() {
      WorldMapRegion.WorldMapRegion_cachedSprites.clear();
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "9"
   )
   public static void method1297() {
      PlayerComposition.PlayerAppearance_cachedModels.clear();
   }
}
