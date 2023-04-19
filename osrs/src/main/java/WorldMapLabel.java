import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ku")
@Implements("WorldMapLabel")
public class WorldMapLabel {
    @ObfuscatedName("af")
    String text;
    @ObfuscatedName("an")
    int width;
    @ObfuscatedName("aw")
    int height;
    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "Ljd;"
    )
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
