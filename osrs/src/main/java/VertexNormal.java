import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("VertexNormal")
public class VertexNormal {
    @ObfuscatedName("af")
    int x;
    @ObfuscatedName("an")
    int y;
    @ObfuscatedName("aw")
    int z;
    @ObfuscatedName("ac")
    int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      descriptor = "(Lib;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-2041739406"
   )
   static int method1346(int var0) {
      return (int)Math.pow(2.0D, (double)((float)var0 / 256.0F + 7.0F));
   }
}
