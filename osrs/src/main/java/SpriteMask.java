import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
public class SpriteMask extends DualNode {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1698600083
   )
   public final int width;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 430835713
   )
   public final int height;
   @ObfuscatedName("v")
   public final int[] xWidths;
   @ObfuscatedName("x")
   public final int[] xStarts;

   SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.width = var1;
      this.height = var2;
      this.xWidths = var3;
      this.xStarts = var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(III)Z",
      garbageValue = "-203203339"
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
}
