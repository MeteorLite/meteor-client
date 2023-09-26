import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class127 {
	@ObfuscatedName("ac")
	int field1200;
	@ObfuscatedName("al")
	float field1197;
	@ObfuscatedName("ak")
	float field1196;
	@ObfuscatedName("ax")
	float field1199;
	@ObfuscatedName("ao")
	float field1198;
	@ObfuscatedName("ah")
	float field1195;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lef;"
	)
	class127 field1194;

	class127() {
		this.field1196 = Float.MAX_VALUE;
		this.field1199 = Float.MAX_VALUE;
		this.field1198 = Float.MAX_VALUE;
		this.field1195 = Float.MAX_VALUE;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lul;II)V",
		garbageValue = "1810575829"
	)
	void method691(Buffer var1, int var2) {
		this.field1200 = var1.readShort();
		this.field1197 = var1.method2586();
		this.field1196 = var1.method2586();
		this.field1199 = var1.method2586();
		this.field1198 = var1.method2586();
		this.field1195 = var1.method2586();
	}

	@ObfuscatedName("ns")
	@ObfuscatedSignature(
		descriptor = "(Lnm;IIIB)V",
		garbageValue = "-59"
	)
	static final void method692(Widget var0, int var1, int var2, int var3) {
		SpriteMask var4 = var0.method1857(class33.field89, false);
		if (var4 != null) {
			if (Client.minimapState < 3) {
				JSException.compass.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

		}
	}
}