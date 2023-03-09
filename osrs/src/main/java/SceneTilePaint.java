import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("it")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("aj")
   @Export("swColor")
   int swColor;
   @ObfuscatedName("al")
   @Export("seColor")
   int seColor;
   @ObfuscatedName("ac")
   @Export("neColor")
   int neColor;
   @ObfuscatedName("ab")
   @Export("nwColor")
   int nwColor;
   @ObfuscatedName("an")
   @Export("texture")
   int texture;
   @ObfuscatedName("ao")
   @Export("isFlat")
   boolean isFlat = true;
   @ObfuscatedName("av")
   @Export("rgb")
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

   @ObfuscatedName("kr")
   @ObfuscatedSignature(
      descriptor = "(II)Ljava/lang/String;",
      garbageValue = "1985297196"
   )
   static String method1297(int var0) {
      if (var0 < 0) {
         return "";
      } else {
         return Client.menuTargets[var0].length() > 0 ? Client.menuActions[var0] + " " + Client.menuTargets[var0] : Client.menuActions[var0];
      }
   }
}
