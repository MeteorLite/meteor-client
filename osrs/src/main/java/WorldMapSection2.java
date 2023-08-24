import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("au")
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("ae")
	@Export("planes")
	int planes;
	@ObfuscatedName("ao")
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("at")
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("ac")
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("ai")
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("az")
	int field2342;
	@ObfuscatedName("ap")
	int field2339;
	@ObfuscatedName("aa")
	int field2333;
	@ObfuscatedName("af")
	int field2336;

	WorldMapSection2() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljf;I)V",
		garbageValue = "-474032336"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2342) {
			var1.regionLowX = this.field2342;
		}

		if (var1.regionHighX < this.field2333) {
			var1.regionHighX = this.field2333;
		}

		if (var1.regionLowY > this.field2339) {
			var1.regionLowY = this.field2339;
		}

		if (var1.regionHighY < this.field2336) {
			var1.regionHighY = this.field2336;
		}

	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IIII)Z",
		garbageValue = "509257779"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.minPlane + this.planes) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIB)Z",
		garbageValue = "-94"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >> 6 >= this.field2342 && var1 >> 6 <= this.field2333 && var2 >> 6 >= this.field2339 && var2 >> 6 <= this.field2336;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIII)[I",
		garbageValue = "1978048199"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.field2342 * 64 - this.regionStartX * 64), var3 + (this.field2339 * 64 - this.regionStartY * 64)};
			return var4;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(III)Lmc;",
		garbageValue = "-1281040923"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.regionStartX * 64 - this.field2342 * 64 + var1;
			int var4 = var2 + (this.regionStartY * 64 - this.field2339 * 64);
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ltm;B)V",
		garbageValue = "47"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field2342 = var1.readUnsignedShort();
		this.field2339 = var1.readUnsignedShort();
		this.field2333 = var1.readUnsignedShort();
		this.field2336 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "1"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("ny")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "120"
	)
	static final void method1410() {
		Client.field511 = Client.cycleCntr;
		WorldMapIcon_0.field2397 = true;
	}

	@ObfuscatedName("os")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2063894036"
	)
	static void method1411() {
		if (Client.oculusOrbState == 1) {
			Client.oculusOrbOnLocalPlayer = true;
		}

	}
}