import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tw")
public class class515 {
	@ObfuscatedName("au")
	int[] field4163;
	@ObfuscatedName("ae")
	short[] field4164;

	@ObfuscatedSignature(
		descriptor = "(Lhw;)V"
	)
	public class515(NPCComposition var1) {
		this.field4163 = new int[8];
		this.field4164 = new short[8];
		int var2 = 0;
		if (var1.method992()) {
			var2 = var1.method993().length;
			System.arraycopy(var1.method993(), 0, this.field4163, 0, var2);
			System.arraycopy(var1.method995(), 0, this.field4164, 0, var2);
		}

		for (int var3 = var2; var3 < 8; ++var3) {
			this.field4163[var3] = -1;
			this.field4164[var3] = -1;
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)[I",
		garbageValue = "-122"
	)
	public int[] method2602() {
		return this.field4163;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)[S",
		garbageValue = "80"
	)
	public short[] method2603() {
		return this.field4164;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IISI)V",
		garbageValue = "-1005641077"
	)
	public void method2604(int var1, int var2, short var3) {
		this.field4163[var1] = var2;
		this.field4164[var1] = var3;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "([I[SB)V",
		garbageValue = "1"
	)
	public void method2605(int[] var1, short[] var2) {
		this.field4163 = var1;
		this.field4164 = var2;
	}
}