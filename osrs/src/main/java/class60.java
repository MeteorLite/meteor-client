import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class60 {
	@ObfuscatedName("au")
	byte[] field316;
	@ObfuscatedName("ae")
	int field317;
	@ObfuscatedName("ao")
	int field318;

	class60() {
		this.field316 = null;
		this.field317 = 0;
		this.field318 = 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-62"
	)
	int method325(int var1) {
		int var2 = 0;

		int var3;
		int var4;
		for (var3 = 0; var1 >= 8 - this.field318; var1 -= var4) {
			var4 = 8 - this.field318;
			int var5 = (1 << var4) - 1;
			var2 += (this.field316[this.field317] >> this.field318 & var5) << var3;
			this.field318 = 0;
			++this.field317;
			var3 += var4;
		}

		if (var1 > 0) {
			var4 = (1 << var1) - 1;
			var2 += (this.field316[this.field317] >> this.field318 & var4) << var3;
			this.field318 += var1;
		}

		return var2;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-36"
	)
	int method326() {
		int var1 = this.field316[this.field317] >> this.field318 & 1;
		++this.field318;
		this.field317 += this.field318 >> 3;
		this.field318 &= 7;
		return var1;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "([BII)V",
		garbageValue = "1812215657"
	)
	void method327(byte[] var1, int var2) {
		this.field316 = var1;
		this.field317 = var2;
		this.field318 = 0;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IZI)Ljava/lang/String;",
		garbageValue = "-1921565351"
	)
	@Export("intToString")
	public static String intToString(int var0, boolean var1) {
		return var1 && var0 >= 0 ? class102.method605(var0, 10, var1) : Integer.toString(var0);
	}
}