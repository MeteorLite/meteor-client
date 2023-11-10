import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("um")
public class class527 {
	@ObfuscatedName("at")
	int[] field4191;
	@ObfuscatedName("ah")
	short[] field4192;

	@ObfuscatedSignature(
		descriptor = "(Lhw;)V"
	)
	public class527(NPCComposition var1) {
		this.field4191 = new int[8];
		this.field4192 = new short[8];
		int var2 = 0;
		if (var1.method947()) {
			var2 = var1.method948().length;
			System.arraycopy(var1.method948(), 0, this.field4191, 0, var2);
			System.arraycopy(var1.method950(), 0, this.field4192, 0, var2);
		}

		for (int var3 = var2; var3 < 8; ++var3) {
			this.field4191[var3] = -1;
			this.field4192[var3] = -1;
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[I",
		garbageValue = "1522434870"
	)
	public int[] method2619() {
		return this.field4191;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)[S",
		garbageValue = "-2015204847"
	)
	public short[] method2620() {
		return this.field4192;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IISI)V",
		garbageValue = "-561705498"
	)
	public void method2621(int var1, int var2, short var3) {
		this.field4191[var1] = var2;
		this.field4192[var1] = var3;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "([I[SI)V",
		garbageValue = "1404172969"
	)
	public void method2622(int[] var1, short[] var2) {
		this.field4191 = var1;
		this.field4192 = var2;
	}
}