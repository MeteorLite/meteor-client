import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hl")
public class VertexNormal {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1166515679
   )
   int x;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -570873925
   )
   int y;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -603264981
   )
   int z;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1940343767
   )
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
