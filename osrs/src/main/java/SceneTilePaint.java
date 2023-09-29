import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("jz")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
	@ObfuscatedName("ac")
	@Export("swColor")
	int swColor;
	@ObfuscatedName("al")
	@Export("seColor")
	int seColor;
	@ObfuscatedName("ak")
	@Export("neColor")
	int neColor;
	@ObfuscatedName("ax")
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("ao")
	@Export("texture")
	int texture;
	@ObfuscatedName("ah")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("ar")
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
}