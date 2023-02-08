import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("il")
@Implements("WorldMapLabel")
public class WorldMapLabel {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "[[Lkz;"
    )
    public static Widget[][] Widget_interfaceComponents;
    @ObfuscatedName("ix")
    static int selectedItemWidget;
    @ObfuscatedName("f")
    String text;
    @ObfuscatedName("w")
    int width;
    @ObfuscatedName("v")
    int height;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lip;"
    )
    WorldMapLabelSize size;

   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;IILip;)V"
   )
   WorldMapLabel(String var1, int var2, int var3, WorldMapLabelSize var4) {
      this.text = var1;
      this.width = var2;
      this.height = var3;
      this.size = var4;
   }
}
