import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rm")
public abstract class AbstractRasterProvider {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -564851849
   )
   static int field4993;
   @ObfuscatedName("v")
   public int[] pixels;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1390359179
   )
   public int width;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -763025729
   )
   public int height;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "72"
   )
   public abstract void drawFull(int var1, int var2);

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)V",
      garbageValue = "-115"
   )
   public abstract void draw(int var1, int var2, int var3, int var4);

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-147706675"
   )
   public final void apply() {
      Rasterizer2D.Rasterizer2D_replace(this.pixels, this.width, this.height);
   }
}
