import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hx")
@Implements("Occluder")
public final class Occluder {
    @ObfuscatedName("th")
    static int cameraMoveToX;
    @ObfuscatedName("f")
    int minTileX;
    @ObfuscatedName("w")
    int maxTileX;
    @ObfuscatedName("v")
    int minTileY;
    @ObfuscatedName("s")
    int maxTileY;
    @ObfuscatedName("z")
    int type;
    @ObfuscatedName("j")
    int minX;
    @ObfuscatedName("i")
    int maxX;
    @ObfuscatedName("n")
    int minZ;
    @ObfuscatedName("l")
    int maxZ;
    @ObfuscatedName("k")
    int minY;
    @ObfuscatedName("c")
    int maxY;
   @ObfuscatedName("r")
   int field2066;
   @ObfuscatedName("b")
   int field2072;
   @ObfuscatedName("m")
   int field2071;
   @ObfuscatedName("t")
   int field2074;
   @ObfuscatedName("h")
   int field2073;
   @ObfuscatedName("p")
   int field2078;
   @ObfuscatedName("o")
   int field2077;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/applet/Applet;Ljava/lang/String;I)V",
      garbageValue = "1977226602"
   )
   public static void method1251(Applet var0, String var1) {
      class31.field100 = var0;
      if (var1 != null) {
         class31.field99 = var1;
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)V",
      garbageValue = "-76"
   )
   static void method1250(String var0) {
      String var1;
      if (var0 != null && !var0.isEmpty() && var0.charAt(0) != '#') {
         var1 = var0;
      } else {
         var1 = "";
      }

      Login.field762 = var1;
   }
}
