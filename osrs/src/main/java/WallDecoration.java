import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("WallDecoration")
public final class WallDecoration {
    @ObfuscatedName("f")
    int z;
    @ObfuscatedName("w")
    int x;
    @ObfuscatedName("v")
    int y;
    @ObfuscatedName("s")
    int orientation;
    @ObfuscatedName("z")
    int orientation2;
    @ObfuscatedName("j")
    int xOffset;
    @ObfuscatedName("i")
    int yOffset;
    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "Lhd;"
    )
    public Renderable renderable1;
    @ObfuscatedName("l")
    @ObfuscatedSignature(
            descriptor = "Lhd;"
    )
    public Renderable renderable2;
    @ObfuscatedName("k")
    public long tag = 0L;
    @ObfuscatedName("c")
    int flags = 0;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1258682815"
   )
   public static boolean method1307(int var0) {
      return var0 >= WorldMapDecorationType.field3038.id && var0 <= WorldMapDecorationType.field3032.id || var0 == WorldMapDecorationType.field3037.id;
   }

   @ObfuscatedName("s")
   public static int method1305(long var0) {
      return (int)(var0 >>> 0 & 127L);
   }

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      descriptor = "(Lkz;I)Lkz;",
      garbageValue = "1159720695"
   )
   static Widget method1306(Widget var0) {
      Widget var2 = var0;
      int var3 = ClanChannel.method846(class173.getWidgetFlags(var0));
      Widget var1;
      if (var3 == 0) {
         var1 = null;
      } else {
         int var4 = 0;

         while(true) {
            if (var4 >= var3) {
               var1 = var2;
               break;
            }

            var2 = class133.getWidget(var2.parentId);
            if (var2 == null) {
               var1 = null;
               break;
            }

            ++var4;
         }
      }

      Widget var5 = var1;
      if (var1 == null) {
         var5 = var0.parent;
      }

      return var5;
   }
}
