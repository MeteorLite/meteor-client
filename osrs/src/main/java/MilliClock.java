import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gn")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("aw")
	long[] field1474;
	@ObfuscatedName("ay")
	int field1472;
	@ObfuscatedName("ar")
	int field1470;
	@ObfuscatedName("am")
	long field1473;
	@ObfuscatedName("as")
	int field1471;
	@ObfuscatedName("aj")
	int field1469;

	public MilliClock() {
		this.field1474 = new long[10];
		this.field1472 = 256;
		this.field1470 = 1;
		this.field1471 = 0;
		this.field1473 = class113.clockNow();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1474[var1] = this.field1473;
		}

	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1541664401"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1474[var1] = 0L;
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "64"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1472;
		int var4 = this.field1470;
		this.field1472 = 300;
		this.field1470 = 1;
		this.field1473 = class113.clockNow();
		if (0L == this.field1474[this.field1469]) {
			this.field1472 = var3;
			this.field1470 = var4;
		} else if (this.field1473 > this.field1474[this.field1469]) {
			this.field1472 = (int)((long)(var1 * 2560) / (this.field1473 - this.field1474[this.field1469]));
		}

		if (this.field1472 < 25) {
			this.field1472 = 25;
		}

		if (this.field1472 > 256) {
			this.field1472 = 256;
			this.field1470 = (int)((long)var1 - (this.field1473 - this.field1474[this.field1469]) / 10L);
		}

		if (this.field1470 > var1) {
			this.field1470 = var1;
		}

		this.field1474[this.field1469] = this.field1473;
		this.field1469 = (this.field1469 + 1) % 10;
		int var5;
		if (this.field1470 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (this.field1474[var5] != 0L) {
					this.field1474[var5] += (long)this.field1470;
				}
			}
		}

		if (this.field1470 < var2) {
			this.field1470 = var2;
		}

		class13.method44((long)this.field1470);

		for (var5 = 0; this.field1471 < 256; this.field1471 += this.field1472) {
			++var5;
		}

		this.field1471 &= 255;
		return var5;
	}
}
