import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tk")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
    @ObfuscatedName("aw")
    public int[] pixels;
    @ObfuscatedName("ac")
    public int width;
    @ObfuscatedName("au")
    public int height;
   @ObfuscatedName("ab")
   protected float[] pixelsFloat;

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "-893520439"
    )
    public abstract void drawFull(int var1, int var2);

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(IIIII)V",
            garbageValue = "868804024"
    )
    public abstract void draw(int var1, int var2, int var3, int var4);

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "0"
    )
    public final void apply() {
      Rasterizer2D.method2562(this.pixels, this.width, this.height, this.pixelsFloat);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(ZI)V",
      garbageValue = "-1022741876"
   )
   public final void method2590(boolean var1) {
      this.pixelsFloat = var1 ? new float[this.height * this.width + 1] : null;
   }
}
