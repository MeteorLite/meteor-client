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
   @Export("xMid")
   int xMid;
   @ObfuscatedName("an")
   @Export("yMid")
   int yMid;
   @ObfuscatedName("aw")
   @Export("zMid")
   int zMid;
   @ObfuscatedName("ac")
   @Export("xMidOffset")
   int xMidOffset;
   @ObfuscatedName("au")
   @Export("yMidOffset")
   int yMidOffset;
   @ObfuscatedName("ab")
   @Export("zMidOffset")
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
