import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kd")
public class class261 implements WorldMapSection {
	@ObfuscatedName("aw")
	int field2368;
	@ObfuscatedName("ay")
	int field2369;
	@ObfuscatedName("ar")
	int field2365;
	@ObfuscatedName("am")
	int field2363;
	@ObfuscatedName("as")
	int field2366;
	@ObfuscatedName("aj")
	int field2362;
	@ObfuscatedName("ag")
	int field2361;
	@ObfuscatedName("az")
	int field2370;
	@ObfuscatedName("av")
	int field2367;
	@ObfuscatedName("ap")
	int field2364;

	class261() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljs;I)V",
		garbageValue = "104966018"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2366) {
			var1.regionLowX = this.field2366;
		}

		if (var1.regionHighX < this.field2366) {
			var1.regionHighX = this.field2366;
		}

		if (var1.regionLowY > this.field2362) {
			var1.regionLowY = this.field2362;
		}

		if (var1.regionHighY < this.field2362) {
			var1.regionHighY = this.field2362;
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IIIB)Z",
		garbageValue = "37"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field2368 && var1 < this.field2368 + this.field2369) {
			return var2 >= (this.field2365 << 6) + (this.field2361 << 3) && var2 <= (this.field2365 << 6) + (this.field2361 << 3) + 7 && var3 >= (this.field2363 << 6) + (this.field2370 << 3) && var3 <= (this.field2363 << 6) + (this.field2370 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "-1055724816"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field2366 << 6) + (this.field2367 << 3) && var1 <= (this.field2366 << 6) + (this.field2367 << 3) + 7 && var2 >= (this.field2362 << 6) + (this.field2364 << 3) && var2 <= (this.field2362 << 6) + (this.field2364 << 3) + 7;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IIII)[I",
		garbageValue = "1968685542"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.field2366 * 64 - this.field2365 * 64) + (this.field2367 * 8 - this.field2361 * 8), var3 + (this.field2362 * 64 - this.field2363 * 64) + (this.field2364 * 8 - this.field2370 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IIB)Lmr;",
		garbageValue = "119"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field2365 * 64 - this.field2366 * 64 + (this.field2361 * 8 - this.field2367 * 8) + var1;
			int var4 = var2 + (this.field2363 * 64 - this.field2362 * 64) + (this.field2370 * 8 - this.field2364 * 8);
			return new Coord(this.field2368, var3, var4);
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "706418314"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field2368 = var1.readUnsignedByte();
		this.field2369 = var1.readUnsignedByte();
		this.field2365 = var1.readUnsignedShort();
		this.field2361 = var1.readUnsignedByte();
		this.field2363 = var1.readUnsignedShort();
		this.field2370 = var1.readUnsignedByte();
		this.field2366 = var1.readUnsignedShort();
		this.field2367 = var1.readUnsignedByte();
		this.field2362 = var1.readUnsignedShort();
		this.field2364 = var1.readUnsignedByte();
		this.method1467();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "522198435"
	)
	void method1467() {
	}
}
