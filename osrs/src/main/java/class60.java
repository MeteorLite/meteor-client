import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
public class class60 {
	@ObfuscatedName("ac")
	byte[] field315;
	@ObfuscatedName("al")
	int field317;
	@ObfuscatedName("ak")
	int field316;

	class60() {
		this.field315 = null;
		this.field317 = 0;
		this.field316 = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "1668070165"
	)
	int method327(int var1) {
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = 0; var1 >= 8 - this.field316; var1 -= var4) {
			var4 = 8 - this.field316;
			int var5 = (1 << var4) - 1;
			var2 += (this.field315[this.field317] >> this.field316 & var5) << var3;
			this.field316 = 0;
			++this.field317;
			var3 += var4;
		}

		if (var1 > 0) {
			var4 = (1 << var1) - 1;
			var2 += (this.field315[this.field317] >> this.field316 & var4) << var3;
			this.field316 += var1;
		}

		return var2;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1671970145"
	)
	int method328() {
		int var1 = this.field315[this.field317] >> this.field316 & 1;
		++this.field316;
		this.field317 += this.field316 >> 3;
		this.field316 &= 7;
		return var1;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "([BIS)V",
		garbageValue = "-20687"
	)
	void method329(byte[] var1, int var2) {
		this.field315 = var1;
		this.field317 = var2;
		this.field316 = 0;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IB)Z",
		garbageValue = "1"
	)
	public static boolean method330(int var0) {
		return var0 >= WorldMapDecorationType.field3150.id && var0 <= WorldMapDecorationType.field3153.id || var0 == WorldMapDecorationType.field3152.id;
	}
}