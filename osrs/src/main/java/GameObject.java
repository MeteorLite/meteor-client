import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("aw")
	@Export("plane")
	int plane;
	@ObfuscatedName("ay")
	@Export("z")
	int z;
	@ObfuscatedName("ar")
	@Export("centerX")
	int centerX;
	@ObfuscatedName("am")
	@Export("centerY")
	int centerY;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lit;"
	)
	@Export("renderable")
	public Renderable renderable;
	@ObfuscatedName("aj")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("ag")
	@Export("startX")
	int startX;
	@ObfuscatedName("az")
	@Export("endX")
	int endX;
	@ObfuscatedName("av")
	@Export("startY")
	int startY;
	@ObfuscatedName("ap")
	@Export("endY")
	int endY;
	@ObfuscatedName("aq")
	int field2282;
	@ObfuscatedName("at")
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("ah")
	@Export("tag")
	public long tag;
	@ObfuscatedName("ax")
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIB)I",
		garbageValue = "37"
	)
	public static int method1358(int var0, int var1, int var2, int var3, int var4, int var5) {
		if ((var5 & 1) == 1) {
			int var6 = var3;
			var3 = var4;
			var4 = var6;
		}

		var2 &= 3;
		if (var2 == 0) {
			return var0;
		} else if (var2 == 1) {
			return var1;
		} else {
			return var2 == 2 ? 7 - var0 - (var3 - 1) : 7 - var1 - (var4 - 1);
		}
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-982961579"
	)
	static int method1359(int var0) {
		return (int)Math.pow(2.0D, (double)((float)var0 / 256.0F + 7.0F));
	}
}
