import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("ViewportMouse")
public class ViewportMouse {
   @ObfuscatedName("h")
   @Export("ViewportMouse_isInViewport")
   public static boolean ViewportMouse_isInViewport = false;
   @ObfuscatedName("e")
   @Export("ViewportMouse_x")
   public static int ViewportMouse_x = 0;
   @ObfuscatedName("v")
   @Export("ViewportMouse_y")
   public static int ViewportMouse_y = 0;
   @ObfuscatedName("x")
   @Export("ViewportMouse_false0")
   public static boolean ViewportMouse_false0 = false;
   @ObfuscatedName("q")
   static int field2185;
   @ObfuscatedName("b")
   static int field2186;
   @ObfuscatedName("j")
   static int field2187;
   @ObfuscatedName("i")
   static int field2181;
   @ObfuscatedName("o")
   @Export("ViewportMouse_entityCount")
   public static int ViewportMouse_entityCount = 0;
   @ObfuscatedName("n")
   @Export("ViewportMouse_entityTags")
   public static long[] ViewportMouse_entityTags = new long[1000];

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1012943456"
   )
   @Export("isCharAlphabetic")
   public static boolean isCharAlphabetic(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
