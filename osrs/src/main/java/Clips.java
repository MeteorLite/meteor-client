import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
@Implements("Clips")
public class Clips {
	@ObfuscatedName("at")
	boolean field2446;
	@ObfuscatedName("ah")
	public boolean field2457;
	@ObfuscatedName("ar")
	int field2452;
	@ObfuscatedName("au")
	public int field2458;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Llw;"
	)
	@Export("Rasterizer3D_textureLoader")
	public TextureLoader Rasterizer3D_textureLoader;
	@ObfuscatedName("ax")
	int field2454;
	@ObfuscatedName("as")
	int field2453;
	@ObfuscatedName("ay")
	int field2455;
	@ObfuscatedName("ak")
	int field2449;
	@ObfuscatedName("aj")
	@Export("clipNegativeMidX")
	int clipNegativeMidX;
	@ObfuscatedName("am")
	int field2450;
	@ObfuscatedName("aq")
	@Export("clipNegativeMidY")
	int clipNegativeMidY;
	@ObfuscatedName("ai")
	int field2447;
	@ObfuscatedName("aw")
	@Export("Rasterizer3D_rowOffsets")
	int[] Rasterizer3D_rowOffsets;

	Clips() {
		this.field2446 = false;
		this.field2457 = true;
		this.field2452 = 0;
		this.field2458 = 512;
		this.Rasterizer3D_rowOffsets = new int[1024];
	}

	@ObfuscatedName("at")
	void method1578() {
		this.field2454 = this.field2455 / 2;
		this.field2453 = this.field2449 / 2;
		this.clipNegativeMidX = -this.field2454;
		this.field2450 = this.field2455 - this.field2454;
		this.clipNegativeMidY = -this.field2453;
		this.field2447 = this.field2449 - this.field2453;
	}

	@ObfuscatedName("ah")
	void method1579(int var1, int var2, int var3, int var4) {
		this.field2454 = var1 - var2;
		this.field2453 = var3 - var4;
		this.clipNegativeMidX = -this.field2454;
		this.field2450 = this.field2455 - this.field2454;
		this.clipNegativeMidY = -this.field2453;
		this.field2447 = this.field2449 - this.field2453;
	}

	@ObfuscatedName("ar")
	void method1580(int var1, int var2, int var3) {
		this.field2446 = var1 < 0 || var1 > this.field2455 || var2 < 0 || var2 > this.field2455 || var3 < 0 || var3 > this.field2455;
	}
}