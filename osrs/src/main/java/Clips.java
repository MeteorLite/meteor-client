import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("Clips")
public class Clips {
	@ObfuscatedName("au")
	boolean field2268;
	@ObfuscatedName("ae")
	public boolean field2279;
	@ObfuscatedName("ao")
	int field2275;
	@ObfuscatedName("ai")
	public int field2280;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Ljs;"
	)
	@Export("Rasterizer3D_textureLoader")
	public TextureLoader Rasterizer3D_textureLoader;
	@ObfuscatedName("al")
	int field2272;
	@ObfuscatedName("an")
	int field2274;
	@ObfuscatedName("ar")
	int field2276;
	@ObfuscatedName("ab")
	int field2269;
	@ObfuscatedName("ag")
	@Export("clipNegativeMidX")
	int clipNegativeMidX;
	@ObfuscatedName("am")
	int field2273;
	@ObfuscatedName("ax")
	@Export("clipNegativeMidY")
	int clipNegativeMidY;
	@ObfuscatedName("ah")
	int field2271;
	@ObfuscatedName("as")
	@Export("Rasterizer3D_rowOffsets")
	int[] Rasterizer3D_rowOffsets;

	Clips() {
		this.field2268 = false;
		this.field2279 = true;
		this.field2275 = 0;
		this.field2280 = 512;
		this.Rasterizer3D_rowOffsets = new int[1024];
	}

	@ObfuscatedName("au")
	void method1361() {
		this.field2272 = this.field2276 / 2;
		this.field2274 = this.field2269 / 2;
		this.clipNegativeMidX = -this.field2272;
		this.field2273 = this.field2276 - this.field2272;
		this.clipNegativeMidY = -this.field2274;
		this.field2271 = this.field2269 - this.field2274;
	}

	@ObfuscatedName("ae")
	void method1362(int var1, int var2, int var3, int var4) {
		this.field2272 = var1 - var2;
		this.field2274 = var3 - var4;
		this.clipNegativeMidX = -this.field2272;
		this.field2273 = this.field2276 - this.field2272;
		this.clipNegativeMidY = -this.field2274;
		this.field2271 = this.field2269 - this.field2274;
	}

	@ObfuscatedName("ao")
	void method1363(int var1, int var2, int var3) {
		this.field2268 = var1 < 0 || var1 > this.field2276 || var2 < 0 || var2 > this.field2276 || var3 < 0 || var3 > this.field2276;
	}
}