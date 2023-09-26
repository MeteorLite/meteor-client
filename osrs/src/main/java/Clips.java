import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("Clips")
public class Clips {
	@ObfuscatedName("ac")
	boolean field2278;
	@ObfuscatedName("al")
	public boolean field2289;
	@ObfuscatedName("ak")
	int field2282;
	@ObfuscatedName("ah")
	public int field2290;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lkg;"
	)
	@Export("Rasterizer3D_textureLoader")
	public TextureLoader Rasterizer3D_textureLoader;
	@ObfuscatedName("ap")
	int field2284;
	@ObfuscatedName("ay")
	int field2287;
	@ObfuscatedName("as")
	int field2285;
	@ObfuscatedName("aj")
	int field2281;
	@ObfuscatedName("an")
	@Export("clipNegativeMidX")
	int clipNegativeMidX;
	@ObfuscatedName("au")
	int field2286;
	@ObfuscatedName("ai")
	@Export("clipNegativeMidY")
	int clipNegativeMidY;
	@ObfuscatedName("ae")
	int field2279;
	@ObfuscatedName("aw")
	@Export("Rasterizer3D_rowOffsets")
	int[] Rasterizer3D_rowOffsets;

	Clips() {
		this.field2278 = false;
		this.field2289 = true;
		this.field2282 = 0;
		this.field2290 = 512;
		this.Rasterizer3D_rowOffsets = new int[1024];
	}

	@ObfuscatedName("ac")
	void method1400() {
		this.field2284 = this.field2285 / 2;
		this.field2287 = this.field2281 / 2;
		this.clipNegativeMidX = -this.field2284;
		this.field2286 = this.field2285 - this.field2284;
		this.clipNegativeMidY = -this.field2287;
		this.field2279 = this.field2281 - this.field2287;
	}

	@ObfuscatedName("al")
	void method1401(int var1, int var2, int var3, int var4) {
		this.field2284 = var1 - var2;
		this.field2287 = var3 - var4;
		this.clipNegativeMidX = -this.field2284;
		this.field2286 = this.field2285 - this.field2284;
		this.clipNegativeMidY = -this.field2287;
		this.field2279 = this.field2281 - this.field2287;
	}

	@ObfuscatedName("ak")
	void method1402(int var1, int var2, int var3) {
		this.field2278 = var1 < 0 || var1 > this.field2285 || var2 < 0 || var2 > this.field2285 || var3 < 0 || var3 > this.field2285;
	}
}