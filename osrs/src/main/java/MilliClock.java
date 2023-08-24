import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gr")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("au")
	long[] field1484;
	@ObfuscatedName("ae")
	int field1480;
	@ObfuscatedName("ao")
	int field1482;
	@ObfuscatedName("at")
	long field1483;
	@ObfuscatedName("ac")
	int field1479;
	@ObfuscatedName("ai")
	int field1481;

	public MilliClock() {
		this.field1484 = new long[10];
		this.field1480 = 256;
		this.field1482 = 1;
		this.field1479 = 0;
		this.field1483 = GameEngine.clockNow();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1484[var1] = this.field1483;
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1021685028"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1484[var1] = 0L;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "20"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1480;
		int var4 = this.field1482;
		this.field1480 = 300;
		this.field1482 = 1;
		this.field1483 = GameEngine.clockNow();
		if (0L == this.field1484[this.field1481]) {
			this.field1480 = var3;
			this.field1482 = var4;
		} else if (this.field1483 > this.field1484[this.field1481]) {
			this.field1480 = (int)((long)(var1 * 2560) / (this.field1483 - this.field1484[this.field1481]));
		}

		if (this.field1480 < 25) {
			this.field1480 = 25;
		}

		if (this.field1480 > 256) {
			this.field1480 = 256;
			this.field1482 = (int)((long)var1 - (this.field1483 - this.field1484[this.field1481]) / 10L);
		}

		if (this.field1482 > var1) {
			this.field1482 = var1;
		}

		this.field1484[this.field1481] = this.field1483;
		this.field1481 = (this.field1481 + 1) % 10;
		int var5;
		if (this.field1482 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field1484[var5]) {
					this.field1484[var5] += (long)this.field1482;
				}
			}
		}

		if (this.field1482 < var2) {
			this.field1482 = var2;
		}

		PendingSpawn.method505((long)this.field1482);

		for (var5 = 0; this.field1479 < 256; this.field1479 += this.field1480) {
			++var5;
		}

		this.field1479 &= 255;
		return var5;
	}
}