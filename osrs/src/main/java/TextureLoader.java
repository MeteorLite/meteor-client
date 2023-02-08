import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
@Implements("TextureLoader")
public interface TextureLoader {
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(II)[I",
            garbageValue = "1661663667"
    )
    int[] getTexturePixels(int var1);

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(II)I",
            garbageValue = "-1511027024"
    )
    int getAverageTextureRGB(int var1);

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(IS)Z",
            garbageValue = "27425"
    )
    boolean vmethod4645(int var1);

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(IB)Z",
            garbageValue = "81"
    )
    boolean isLowDetail(int var1);
}
