import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("ac")
	long[] field1475;
	@ObfuscatedName("al")
	int field1472;
	@ObfuscatedName("ak")
	int field1471;
	@ObfuscatedName("ax")
	long field1474;
	@ObfuscatedName("ao")
	int field1473;
	@ObfuscatedName("ah")
	int field1470;

	MilliClock() {
		this.field1475 = new long[10];
		this.field1472 = 256;
		this.field1471 = 1;
		this.field1473 = 0;
		this.field1474 = GrandExchangeOfferTotalQuantityComparator.method1971();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1475[var1] = this.field1474;
		}

	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "436321701"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1475[var1] = 0L;
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(III)I",
		garbageValue = "712947185"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1472;
		int var4 = this.field1471;
		this.field1472 = 300;
		this.field1471 = 1;
		this.field1474 = GrandExchangeOfferTotalQuantityComparator.method1971();
		if (this.field1475[this.field1470] == 0L) {
			this.field1472 = var3;
			this.field1471 = var4;
		} else if (this.field1474 > this.field1475[this.field1470]) {
			this.field1472 = (int)((long)(var1 * 2560) / (this.field1474 - this.field1475[this.field1470]));
		}

		if (this.field1472 < 25) {
			this.field1472 = 25;
		}

		if (this.field1472 > 256) {
			this.field1472 = 256;
			this.field1471 = (int)((long)var1 - (this.field1474 - this.field1475[this.field1470]) / 10L);
		}

		if (this.field1471 > var1) {
			this.field1471 = var1;
		}

		this.field1475[this.field1470] = this.field1474;
		this.field1470 = (this.field1470 + 1) % 10;
		int var5;
		if (this.field1471 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (this.field1475[var5] != 0L) {
					this.field1475[var5] += (long)this.field1471;
				}
			}
		}

		if (this.field1471 < var2) {
			this.field1471 = var2;
		}

		Players.method623((long)this.field1471);

		for (var5 = 0; this.field1473 < 256; this.field1473 += this.field1472) {
			++var5;
		}

		this.field1473 &= 255;
		return var5;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lom;I)V",
		garbageValue = "2111970758"
	)
	public static void method935(AbstractArchive var0) {
		DbTableType.field4138 = var0;
	}
}