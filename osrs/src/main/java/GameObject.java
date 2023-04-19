import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("jc")
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("jd")
   @Export("xteaKeys")
   static int[][] xteaKeys;
   @ObfuscatedName("af")
   @Export("plane")
   int plane;
   @ObfuscatedName("an")
   @Export("startX")
   int startX;
   @ObfuscatedName("aw")
   @Export("z")
   int z;
   @ObfuscatedName("ac")
   @Export("centerX")
   int centerX;
   @ObfuscatedName("au")
   @Export("centerY")
   int centerY;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Liv;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("aq")
   @Export("orientation")
   int orientation;
   @ObfuscatedName("al")
   @Export("endX")
   int endX;
   @ObfuscatedName("at")
   @Export("startY")
   int startY;
   @ObfuscatedName("aa")
   @Export("endY")
   int endY;
   @ObfuscatedName("ay")
   int field2271;
   @ObfuscatedName("ao")
   @Export("lastDrawn")
   int lastDrawn;
   @ObfuscatedName("ax")
   @Export("tag")
   public long tag = 0L;
   @ObfuscatedName("ai")
   @Export("flags")
   int flags = 0;
}
