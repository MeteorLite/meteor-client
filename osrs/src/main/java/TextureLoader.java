import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("js")
@Implements("TextureLoader")
public interface TextureLoader {
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(II)[I",
		garbageValue = "-1284455059"
	)
	@Export("getTexturePixels")
	int[] getTexturePixels(int var1);

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1228029354"
	)
	@Export("getAverageTextureRGB")
	int getAverageTextureRGB(int var1);

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "89"
	)
	@Export("vmethod3989")
	boolean vmethod3989(int var1);

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1328264692"
	)
	@Export("isLowDetail")
	boolean isLowDetail(int var1);
}