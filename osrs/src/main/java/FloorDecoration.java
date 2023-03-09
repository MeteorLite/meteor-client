import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ib")
@Implements("FloorDecoration")
public final class FloorDecoration {
   @ObfuscatedName("ig")
   @ObfuscatedSignature(
      descriptor = "Lpj;"
   )
   static AbstractSocket field1908;
   @ObfuscatedName("aj")
   @Export("z")
   int z;
   @ObfuscatedName("al")
   @Export("x")
   int x;
   @ObfuscatedName("ac")
   @Export("y")
   int y;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   @Export("renderable")
   public Renderable renderable;
   @ObfuscatedName("an")
   @Export("tag")
   public long tag;
   @ObfuscatedName("ao")
   @Export("flags")
   int flags;
}
