import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("h")
   @Export("x")
   int x;
   @ObfuscatedName("e")
   @Export("y")
   int y;
   @ObfuscatedName("v")
   @Export("z")
   int z;
   @ObfuscatedName("x")
   @Export("magnitude")
   int magnitude;

   VertexNormal() {
   }

   @ObfuscatedSignature(
      descriptor = "(Lhl;)V"
   )
   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }
}
