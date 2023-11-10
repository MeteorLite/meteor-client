import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("at")
	long[] field1867;
	@ObfuscatedName("ah")
	int field1863;
	@ObfuscatedName("ar")
	int field1864;
	@ObfuscatedName("ao")
	long field1866;
	@ObfuscatedName("ab")
	int field1862;
	@ObfuscatedName("au")
	int field1865;

	MilliClock() {
		this.field1867 = new long[10];
		this.field1863 = 256;
		this.field1864 = 1;
		this.field1862 = 0;
		this.field1866 = SpotAnimationDefinition.method962();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1867[var1] = this.field1866;
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1366277024"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1867[var1] = 0L;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "-2001388980"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1863;
		int var4 = this.field1864;
		this.field1863 = 300;
		this.field1864 = 1;
		this.field1866 = SpotAnimationDefinition.method962();
		if (this.field1867[this.field1865] == 0L) {
			this.field1863 = var3;
			this.field1864 = var4;
		} else if (this.field1866 > this.field1867[this.field1865]) {
			this.field1863 = (int)((long)(var1 * 2560) / (this.field1866 - this.field1867[this.field1865]));
		}

		if (this.field1863 < 25) {
			this.field1863 = 25;
		}

		if (this.field1863 > 256) {
			this.field1863 = 256;
			this.field1864 = (int)((long)var1 - (this.field1866 - this.field1867[this.field1865]) / 10L);
		}

		if (this.field1864 > var1) {
			this.field1864 = var1;
		}

		this.field1867[this.field1865] = this.field1866;
		this.field1865 = (this.field1865 + 1) % 10;
		int var5;
		if (this.field1864 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field1867[var5]) {
					this.field1867[var5] += (long)this.field1864;
				}
			}
		}

		if (this.field1864 < var2) {
			this.field1864 = var2;
		}

		class219.method1104((long)this.field1864);

		for (var5 = 0; this.field1862 < 256; this.field1862 += this.field1863) {
			++var5;
		}

		this.field1862 &= 255;
		return var5;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Loi;",
		garbageValue = "-1866806569"
	)
	public static class364[] method1100() {
		return new class364[]{class364.field3509, class364.field3510, class364.field3511, class364.field3508};
	}

	@ObfuscatedName("nn")
	@ObfuscatedSignature(
		descriptor = "(Lnn;IIIB)V",
		garbageValue = "42"
	)
	static final void method1103(Widget var0, int var1, int var2, int var3) {
		SpriteMask var4 = var0.method1851(HealthBarDefinition.widgetDefinition, false);
		if (var4 != null) {
			if (Client.minimapState < 3) {
				ItemLayer.compass.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, 25, 25, Client.camAngleY, 256, var4.xStarts, var4.xWidths);
			} else {
				Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
			}

		}
	}
}