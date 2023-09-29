import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ui")
@Implements("AbstractRasterProvider")
public abstract class AbstractRasterProvider {
	@ObfuscatedName("ak")
	@Export("pixels")
	public int[] pixels;
	@ObfuscatedName("ax")
	@Export("width")
	public int width;
	@ObfuscatedName("ao")
	@Export("height")
	public int height;
	@ObfuscatedName("ah")
	protected float[] field4252;

	protected AbstractRasterProvider() {
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-237304267"
	)
	@Export("drawFull")
	public abstract void drawFull(int var1, int var2);

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "-3"
	)
	@Export("draw")
	public abstract void draw(int var1, int var2, int var3, int var4);

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1751275534"
	)
	@Export("apply")
	public final void apply() {
		Rasterizer2D.method2659(this.pixels, this.width, this.height, this.field4252);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "952320023"
	)
	public final void method2685(boolean var1) {
		this.field4252 = var1 ? new float[this.width * this.height + 1] : null;
	}
}