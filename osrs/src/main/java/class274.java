import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class274 implements WorldMapSection {
	@ObfuscatedName("cx")
	static int field2399;
	@ObfuscatedName("ac")
	int field2401;
	@ObfuscatedName("al")
	int field2404;
	@ObfuscatedName("ak")
	int field2403;
	@ObfuscatedName("ax")
	int field2409;
	@ObfuscatedName("ao")
	int field2406;
	@ObfuscatedName("ah")
	int field2402;
	@ObfuscatedName("ar")
	int field2407;
	@ObfuscatedName("ab")
	int field2400;
	@ObfuscatedName("am")
	int field2405;
	@ObfuscatedName("av")
	int field2408;

	class274() {
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lkz;I)V",
		garbageValue = "1844466074"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2406) {
			var1.regionLowX = this.field2406;
		}

		if (var1.regionHighX < this.field2406) {
			var1.regionHighX = this.field2406;
		}

		if (var1.regionLowY > this.field2402) {
			var1.regionLowY = this.field2402;
		}

		if (var1.regionHighY < this.field2402) {
			var1.regionHighY = this.field2402;
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(IIII)Z",
		garbageValue = "-1135530948"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field2401 && var1 < this.field2401 + this.field2404) {
			return var2 >= (this.field2403 << 6) + (this.field2407 << 3) && var2 <= (this.field2403 << 6) + (this.field2407 << 3) + 7 && var3 >= (this.field2409 << 6) + (this.field2400 << 3) && var3 <= (this.field2409 << 6) + (this.field2400 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "1124460333"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field2406 << 6) + (this.field2405 << 3) && var1 <= (this.field2406 << 6) + (this.field2405 << 3) + 7 && var2 >= (this.field2402 << 6) + (this.field2408 << 3) && var2 <= (this.field2402 << 6) + (this.field2408 << 3) + 7;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IIII)[I",
		garbageValue = "557011185"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.field2406 * 64 - this.field2403 * 64) + (this.field2405 * 8 - this.field2407 * 8), var3 + (this.field2402 * 64 - this.field2409 * 64) + (this.field2408 * 8 - this.field2400 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(III)Lmo;",
		garbageValue = "-1670709360"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field2403 * 64 - this.field2406 * 64 + (this.field2407 * 8 - this.field2405 * 8) + var1;
			int var4 = var2 + (this.field2409 * 64 - this.field2402 * 64) + (this.field2400 * 8 - this.field2408 * 8);
			return new Coord(this.field2401, var3, var4);
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lul;I)V",
		garbageValue = "-801073373"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field2401 = var1.readUnsignedByte();
		this.field2404 = var1.readUnsignedByte();
		this.field2403 = var1.readUnsignedShort();
		this.field2407 = var1.readUnsignedByte();
		this.field2409 = var1.readUnsignedShort();
		this.field2400 = var1.readUnsignedByte();
		this.field2406 = var1.readUnsignedShort();
		this.field2405 = var1.readUnsignedByte();
		this.field2402 = var1.readUnsignedShort();
		this.field2408 = var1.readUnsignedByte();
		this.method1535();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "54"
	)
	void method1535() {
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-1696512982"
	)
	static int method1536(int var0) {
		return (int)Math.pow(2.0D, (double)(7.0F + (float)var0 / 256.0F));
	}
}