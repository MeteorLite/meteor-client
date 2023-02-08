import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("ViewportMouse")
public class ViewportMouse {
    @ObfuscatedName("f")
    static boolean ViewportMouse_isInViewport = false;
    @ObfuscatedName("w")
    static int ViewportMouse_x = 0;
    @ObfuscatedName("v")
    static int ViewportMouse_y = 0;
    @ObfuscatedName("s")
    static boolean ViewportMouse_false0 = false;
   @ObfuscatedName("i")
   static int field2177;
    @ObfuscatedName("m")
    public static int ViewportMouse_entityCount = 0;
    @ObfuscatedName("t")
    public static long[] ViewportMouse_entityTags = new long[1000];

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1193422924"
   )
   public static boolean method1295(int var0) {
      return (var0 >> 28 & 1) != 0;
   }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(Lkz;IIII)V",
            garbageValue = "498385779"
    )
    static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
      if (var0.field2939 == null) {
         throw new RuntimeException();
      } else {
         var0.field2939[var1] = var2;
         var0.field2940[var1] = var3;
      }
   }
}
