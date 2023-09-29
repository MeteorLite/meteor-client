import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("up")
public class class530 {
	@ObfuscatedName("ac")
	int[] field4190;
	@ObfuscatedName("al")
	short[] field4191;

	@ObfuscatedSignature(
		descriptor = "(Lhw;)V"
	)
	public class530(NPCComposition var1) {
		this.field4190 = new int[8];
		this.field4191 = new short[8];
		int var2 = 0;
		if (var1.method1018()) {
			var2 = var1.method1019().length;
			System.arraycopy(var1.method1019(), 0, this.field4190, 0, var2);
			System.arraycopy(var1.method1021(), 0, this.field4191, 0, var2);
		}

		for (int var3 = var2; var3 < 8; ++var3) {
			this.field4190[var3] = -1;
			this.field4191[var3] = -1;
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "-1994168844"
	)
	public int[] method2639() {
		return this.field4190;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)[S",
		garbageValue = "-2141879918"
	)
	public short[] method2640() {
		return this.field4191;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IISB)V",
		garbageValue = "44"
	)
	public void method2641(int var1, int var2, short var3) {
		this.field4190[var1] = var2;
		this.field4191[var1] = var3;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "([I[SI)V",
		garbageValue = "-616052812"
	)
	public void method2642(int[] var1, short[] var2) {
		this.field4190 = var1;
		this.field4191 = var2;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "-47"
	)
	static final int method2643(int var0, int var1) {
		int var2 = class432.method2193(45365 + var0, 91923 + var1, 4) - 128 + (class432.method2193(10294 + var0, 37821 + var1, 2) - 128 >> 1) + (class432.method2193(var0, var1, 1) - 128 >> 2);
		var2 = (int)(0.3D * (double)var2) + 35;
		if (var2 < 10) {
			var2 = 10;
		} else if (var2 > 60) {
			var2 = 60;
		}

		return var2;
	}
}