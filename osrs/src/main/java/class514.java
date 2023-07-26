import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tr")
public class class514 {
	@ObfuscatedName("aw")
	int[] field4118;
	@ObfuscatedName("ay")
	short[] field4119;

	@ObfuscatedSignature(
		descriptor = "(Lhi;)V"
	)
	public class514(NPCComposition var1) {
		this.field4118 = new int[8];
		this.field4119 = new short[8];
		int var2 = 0;
		if (var1.method973()) {
			var2 = var1.method974().length;
			System.arraycopy(var1.method974(), 0, this.field4118, 0, var2);
			System.arraycopy(var1.method976(), 0, this.field4119, 0, var2);
		}

		for (int var3 = var2; var3 < 8; ++var3) {
			this.field4118[var3] = -1;
			this.field4119[var3] = -1;
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)[I",
		garbageValue = "128"
	)
	public int[] method2583() {
		return this.field4118;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)[S",
		garbageValue = "-145680326"
	)
	public short[] method2584() {
		return this.field4119;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IISI)V",
		garbageValue = "-467719790"
	)
	public void method2585(int var1, int var2, short var3) {
		this.field4118[var1] = var2;
		this.field4119[var1] = var3;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "([I[SB)V",
		garbageValue = "-45"
	)
	public void method2586(int[] var1, short[] var2) {
		this.field4118 = var1;
		this.field4119 = var2;
	}
}
