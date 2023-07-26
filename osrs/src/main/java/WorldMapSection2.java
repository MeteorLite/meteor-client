import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("aw")
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("ay")
	@Export("planes")
	int planes;
	@ObfuscatedName("ar")
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("am")
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("as")
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("aj")
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("ag")
	int field2308;
	@ObfuscatedName("az")
	int field2317;
	@ObfuscatedName("av")
	int field2314;
	@ObfuscatedName("ap")
	int field2311;

	WorldMapSection2() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljs;I)V",
		garbageValue = "104966018"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2308) {
			var1.regionLowX = this.field2308;
		}

		if (var1.regionHighX < this.field2314) {
			var1.regionHighX = this.field2314;
		}

		if (var1.regionLowY > this.field2317) {
			var1.regionLowY = this.field2317;
		}

		if (var1.regionHighY < this.field2311) {
			var1.regionHighY = this.field2311;
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IIIB)Z",
		garbageValue = "37"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
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
		return var1 >> 6 >= this.field2308 && var1 >> 6 <= this.field2314 && var2 >> 6 >= this.field2317 && var2 >> 6 <= this.field2311;
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
			int[] var4 = new int[]{var2 + (this.field2308 * 64 - this.regionStartX * 64), var3 + (this.field2317 * 64 - this.regionStartY * 64)};
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
			int var3 = this.regionStartX * 64 - this.field2308 * 64 + var1;
			int var4 = var2 + (this.regionStartY * 64 - this.field2317 * 64);
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)V",
		garbageValue = "706418314"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field2308 = var1.readUnsignedShort();
		this.field2317 = var1.readUnsignedShort();
		this.field2314 = var1.readUnsignedShort();
		this.field2311 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1492337341"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(B)Ljava/security/SecureRandom;",
		garbageValue = "63"
	)
	static SecureRandom method1377() {
		SecureRandom var0 = new SecureRandom();
		var0.nextInt();
		return var0;
	}
}
