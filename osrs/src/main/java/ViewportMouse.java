import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
public class ViewportMouse {
   @ObfuscatedName("h")
   public static boolean ViewportMouse_isInViewport = false;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 233603823
   )
   public static int ViewportMouse_x = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1918112547
   )
   public static int ViewportMouse_y = 0;
   @ObfuscatedName("x")
   public static boolean ViewportMouse_false0 = false;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1060045251
   )
   static int field2746;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 242710193
   )
   static int field2747;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -61886565
   )
   static int field2749;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2117851361
   )
   static int field2742;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1096761705
   )
   public static int ViewportMouse_entityCount = 0;
   @ObfuscatedName("n")
   public static long[] ViewportMouse_entityTags = new long[1000];

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1012943456"
   )
   public static boolean isCharAlphabetic(char var0) {
      return var0 >= 'A' && var0 <= 'Z' || var0 >= 'a' && var0 <= 'z';
   }
}
