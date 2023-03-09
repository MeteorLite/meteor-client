import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sm")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
   @ObfuscatedName("ar")
   @Export("pcmSampleLength")
   public static int pcmSampleLength;
   @ObfuscatedName("ac")
   @Export("pixels")
   public int[] pixels;
   @ObfuscatedName("ab")
   @Export("width")
   public int width;
   @ObfuscatedName("an")
   @Export("height")
   public int height;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-234209918"
   )
   @Export("drawFull")
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)V",
      garbageValue = "-98"
   )
   @Export("draw")
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "29"
   )
   @Export("apply")
   public final void apply() {
      Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
   }
}
