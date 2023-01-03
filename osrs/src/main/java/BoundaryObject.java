import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
@Implements("BoundaryObject")
public final class BoundaryObject {
   @ObfuscatedName("az")
   protected static String field2215;
   @ObfuscatedName("h")
   @Export("z")
   int z;
   @ObfuscatedName("e")
   @Export("x")
   int x;
   @ObfuscatedName("v")
   @Export("y")
   int y;
   @ObfuscatedName("x")
   @Export("orientationA")
   int orientationA;
   @ObfuscatedName("m")
   @Export("orientationB")
   int orientationB;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   @Export("renderable1")
   public Renderable renderable1;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   @Export("renderable2")
   public Renderable renderable2;
   @ObfuscatedName("r")
   @Export("tag")
   public long tag = 0L;
   @ObfuscatedName("u")
   @Export("flags")
   int flags = 0;
}
