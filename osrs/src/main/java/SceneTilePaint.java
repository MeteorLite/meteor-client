import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ke")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
	@ObfuscatedName("at")
	@Export("swColor")
	int swColor;
	@ObfuscatedName("ah")
	@Export("seColor")
	int seColor;
	@ObfuscatedName("ar")
	@Export("neColor")
	int neColor;
	@ObfuscatedName("ao")
	@Export("nwColor")
	int nwColor;
	@ObfuscatedName("ab")
	@Export("texture")
	int texture;
	@ObfuscatedName("au")
	@Export("isFlat")
	boolean isFlat;
	@ObfuscatedName("aa")
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

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IZB)Ljava/lang/String;",
		garbageValue = "12"
	)
	@Export("intToString")
	public static String intToString(int var0, boolean var1) {
		return var1 && var0 >= 0 ? Players.method619(var0, 10, var1) : Integer.toString(var0);
	}
}