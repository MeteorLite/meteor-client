import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ll")
@Implements("SpriteMask")
public class SpriteMask extends DualNode {
   @ObfuscatedName("gn")
   static String field2808;
    @ObfuscatedName("af")
    public final int width;
    @ObfuscatedName("an")
    public final int height;
    @ObfuscatedName("aw")
    public final int[] xWidths;
    @ObfuscatedName("ac")
    public final int[] xStarts;

   SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.width = var1;
      this.height = var2;
      this.xWidths = var3;
      this.xStarts = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(III)Z",
            garbageValue = "-746690647"
    )
    public boolean contains(int var1, int var2) {
      if (var2 >= 0 && var2 < this.xStarts.length) {
         int var3 = this.xStarts[var2];
         if (var1 >= var3 && var1 <= var3 + this.xWidths[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "575322475"
   )
   public static int method1682(int var0, int var1, int var2) {
      var2 &= 3;
      if (var2 == 0) {
         return var0;
      } else if (var2 == 1) {
         return var1;
      } else {
         return var2 == 2 ? 7 - var0 : 7 - var1;
      }
   }
}
