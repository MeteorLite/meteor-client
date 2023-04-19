import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iq")
@Implements("AABB")
public class AABB {
   @ObfuscatedName("ci")
   @ObfuscatedSignature(
      descriptor = "Lmd;"
   )
   static GameBuild field2070;
   @ObfuscatedName("af")
   int xMid;
   @ObfuscatedName("an")
   int yMid;
   @ObfuscatedName("aw")
   int zMid;
   @ObfuscatedName("ac")
   int xMidOffset;
   @ObfuscatedName("au")
   int yMidOffset;
   @ObfuscatedName("ab")
   int zMidOffset;

   AABB(int var1, int var2, int var3, int var4, int var5, int var6) {
      this.xMid = var1;
      this.yMid = var2;
      this.zMid = var3;
      this.xMidOffset = var4;
      this.yMidOffset = var5;
      this.zMidOffset = var6;
   }
}
