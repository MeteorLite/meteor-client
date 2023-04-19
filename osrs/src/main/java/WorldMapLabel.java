import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("WorldMapLabel")
public class WorldMapLabel {
   @ObfuscatedName("af")
   @Export("text")
   String text;
   @ObfuscatedName("an")
   @Export("width")
   int width;
   @ObfuscatedName("aw")
   @Export("height")
   int height;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Ljd;"
   )
   @Export("size")
   WorldMapLabelSize size;

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;IILjd;)V"
   )
   WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
      this.text = var1;
      this.width = var2;
      this.height = var3;
      this.size = var4;
   }
}
