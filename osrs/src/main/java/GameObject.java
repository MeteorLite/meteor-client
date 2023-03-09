import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("GameObject")
public final class GameObject {
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("scriptDotWidget")
   static Widget scriptDotWidget;
   @ObfuscatedName("aj")
   @Export("plane")
   int plane;
   @ObfuscatedName("al")
   @Export("z")
   int z;
   @ObfuscatedName("ac")
   @Export("centerX")
   int centerX;
   @ObfuscatedName("ab")
   @Export("centerY")
   int centerY;
   @ObfuscatedName("an")
   @Export("startX")
   int startX;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("av")
   @Export("orientation")
   int orientation;
   @ObfuscatedName("aq")
   @Export("endX")
   int endX;
   @ObfuscatedName("ap")
   @Export("startY")
   int startY;
   @ObfuscatedName("ar")
   @Export("endY")
   int endY;
   @ObfuscatedName("ak")
   int field2228;
   @ObfuscatedName("ax")
   @Export("lastDrawn")
   int lastDrawn;
   @ObfuscatedName("as")
   @Export("tag")
   public long tag = 0L;
   @ObfuscatedName("ay")
   @Export("flags")
   int flags = 0;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "-88"
   )
   public static int method1307(int var0) {
      return var0 >>> 4 & class473.field3964;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)[Lsc;",
      garbageValue = "-41"
   )
   @Export("FillMode_values")
   public static FillMode[] FillMode_values() {
      return new FillMode[]{FillMode.field4040, FillMode.field4041, FillMode.SOLID};
   }
}
