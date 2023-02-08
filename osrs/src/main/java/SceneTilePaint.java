import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("hc")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("m")
   static int[] field2195;
    @ObfuscatedName("f")
    int swColor;
    @ObfuscatedName("w")
    int seColor;
    @ObfuscatedName("v")
    int neColor;
    @ObfuscatedName("s")
    int nwColor;
    @ObfuscatedName("z")
    int texture;
    @ObfuscatedName("j")
    boolean isFlat = true;
    @ObfuscatedName("i")
    int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.isFlat = var7;
   }
}
