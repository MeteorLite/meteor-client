import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
@Implements("MilliClock")
public class MilliClock extends Clock {
	@ObfuscatedName("j")
	@ObfuscatedSignature(
		descriptor = "Lqu;"
	)
	@Export("logoSprite")
	static IndexedSprite logoSprite;
	@ObfuscatedName("e")
	@ObfuscatedSignature(
		descriptor = "Lqq;"
	)
	public static Buffer field1810;
	@ObfuscatedName("c")
	long[] field1804;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -392846051
	)
	int field1805;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 706631097
	)
	int field1803;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		longValue = -7069218525651298561L
	)
	long field1809;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -1321269335
	)
	int field1801;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = 1583430667
	)
	int field1806;

	MilliClock() {
		this.field1804 = new long[10];
		this.field1805 = 256;
		this.field1803 = 1;
		this.field1801 = 0;
		this.field1809 = Language.method6232();

		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1804[var1] = this.field1809;
		}

	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2049257466"
	)
	@Export("mark")
	public void mark() {
		for (int var1 = 0; var1 < 10; ++var1) {
			this.field1804[var1] = 0L;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "-4"
	)
	@Export("wait")
	public int wait(int var1, int var2) {
		int var3 = this.field1805;
		int var4 = this.field1803;
		this.field1805 = 300;
		this.field1803 = 1;
		this.field1809 = Language.method6232();
		if (0L == this.field1804[this.field1806]) {
			this.field1805 = var3;
			this.field1803 = var4;
		} else if (this.field1809 > this.field1804[this.field1806]) {
			this.field1805 = (int)((long)(var1 * 2560) / (this.field1809 - this.field1804[this.field1806]));
		}

		if (this.field1805 < 25) {
			this.field1805 = 25;
		}

		if (this.field1805 > 256) {
			this.field1805 = 256;
			this.field1803 = (int)((long)var1 - (this.field1809 - this.field1804[this.field1806]) / 10L);
		}

		if (this.field1803 > var1) {
			this.field1803 = var1;
		}

		this.field1804[this.field1806] = this.field1809;
		this.field1806 = (this.field1806 + 1) % 10;
		int var5;
		if (this.field1803 > 1) {
			for (var5 = 0; var5 < 10; ++var5) {
				if (0L != this.field1804[var5]) {
					this.field1804[var5] += (long)this.field1803;
				}
			}
		}

		if (this.field1803 < var2) {
			this.field1803 = var2;
		}

		class28.method412((long)this.field1803);

		for (var5 = 0; this.field1801 < 256; this.field1801 += this.field1805) {
			++var5;
		}

		this.field1801 &= 255;
		return var5;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "-1341812392"
	)
	public static boolean method3478(int var0) {
		return var0 >= WorldMapDecorationType.field3572.id && var0 <= WorldMapDecorationType.field3563.id || var0 == WorldMapDecorationType.field3583.id;
	}

	@ObfuscatedName("f")
	public static int method3477(long var0) {
		return (int)(var0 >>> 7 & 127L);
	}

	@ObfuscatedName("ie")
	@ObfuscatedSignature(
		descriptor = "(IIIIIIIIIB)V",
		garbageValue = "-32"
	)
	@Export("updatePendingSpawn")
	static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
		PendingSpawn var9 = null;

		for (PendingSpawn var10 = (PendingSpawn)Client.pendingSpawns.last(); var10 != null; var10 = (PendingSpawn)Client.pendingSpawns.previous()) {
			if (var0 == var10.plane && var10.x == var1 && var2 == var10.y && var3 == var10.type) {
				var9 = var10;
				break;
			}
		}

		if (var9 == null) {
			var9 = new PendingSpawn();
			var9.plane = var0;
			var9.type = var3;
			var9.x = var1;
			var9.y = var2;
			class20.method302(var9);
			Client.pendingSpawns.addFirst(var9);
		}

		var9.id = var4;
		var9.field1123 = var5;
		var9.orientation = var6;
		var9.delay = var7;
		var9.hitpoints = var8;
	}
}
