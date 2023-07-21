import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
	@ObfuscatedName("aw")
	@Export("swColor")
	int swColor;
	@ObfuscatedName("ay")
	@Export("seColor")
	int seColor;
	@ObfuscatedName("ar")
	@Export("neColor")
	int neColor;
	@ObfuscatedName("am")
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("as")
	@Export("texture")
	int texture;
	@ObfuscatedName("aj")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("ag")
	@Export("rgb")
	int rgb;

	SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
		this.isFlat = true;
		this.swColor = var1;
		this.seColor = var2;
		this.neColor = var3;
		this.nwColor = var4;
		this.texture = var5;
		this.rgb = var6;
		this.isFlat = var7;
	}

	@ObfuscatedName("hf")
	@ObfuscatedSignature(
		descriptor = "(B)Lih;",
		garbageValue = "107"
	)
	public static class213 method1324() {
		return Client.keyHandlerInstance;
	}
}
