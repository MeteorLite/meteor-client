import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("aj")
   @Export("x")
   int x;
   @ObfuscatedName("al")
   @Export("y")
   int y;
   @ObfuscatedName("ac")
   @Export("z")
   int z;
   @ObfuscatedName("ab")
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      descriptor = "(Liy;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
