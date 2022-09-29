import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hh")
public class class229 implements WorldMapSection {
	@ObfuscatedName("cr")
	public static char field2794;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 890623543
	)
	int field2791;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -127091579
	)
	int field2786;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1060411529
	)
	int field2785;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 632643049
	)
	int field2787;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = -722115847
	)
	int field2788;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -574751975
	)
	int field2789;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -1379378373
	)
	int field2784;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -1957778393
	)
	int field2790;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = -306154069
	)
	int field2792;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 619275975
	)
	int field2793;

	class229() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lht;I)V",
		garbageValue = "1697283195"
	)
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2788) {
			var1.regionLowX = this.field2788;
		}

		if (var1.regionHighX < this.field2788) {
			var1.regionHighX = this.field2788;
		}

		if (var1.regionLowY > this.field2789) {
			var1.regionLowY = this.field2789;
		}

		if (var1.regionHighY < this.field2789) {
			var1.regionHighY = this.field2789;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IIIB)Z",
		garbageValue = "-24"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field2791 && var1 < this.field2786 + this.field2791) {
			return var2 >= (this.field2785 << 6) + (this.field2784 << 3) && var2 <= (this.field2785 << 6) + (this.field2784 << 3) + 7 && var3 >= (this.field2787 << 6) + (this.field2790 << 3) && var3 <= (this.field2787 << 6) + (this.field2790 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "-428509434"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field2788 << 6) + (this.field2792 << 3) && var1 <= (this.field2788 << 6) + (this.field2792 << 3) + 7 && var2 >= (this.field2789 << 6) + (this.field2793 << 3) && var2 <= (this.field2789 << 6) + (this.field2793 << 3) + 7;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(IIIB)[I",
		garbageValue = "-81"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{this.field2788 * 64 - this.field2785 * 64 + var2 + (this.field2792 * 8 - this.field2784 * 8), var3 + (this.field2789 * 64 - this.field2787 * 64) + (this.field2793 * 8 - this.field2790 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(III)Lkz;",
		garbageValue = "244140613"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field2785 * 64 - this.field2788 * 64 + (this.field2784 * 8 - this.field2792 * 8) + var1;
			int var4 = this.field2787 * 64 - this.field2789 * 64 + var2 + (this.field2790 * 8 - this.field2793 * 8);
			return new Coord(this.field2791, var3, var4);
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "53690591"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field2791 = var1.readUnsignedByte();
		this.field2786 = var1.readUnsignedByte();
		this.field2785 = var1.readUnsignedShort();
		this.field2784 = var1.readUnsignedByte();
		this.field2787 = var1.readUnsignedShort();
		this.field2790 = var1.readUnsignedByte();
		this.field2788 = var1.readUnsignedShort();
		this.field2792 = var1.readUnsignedByte();
		this.field2789 = var1.readUnsignedShort();
		this.field2793 = var1.readUnsignedByte();
		this.method5002();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "989821121"
	)
	void method5002() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/String;[SI)V",
		garbageValue = "1924570041"
	)
	public static void method5022(String[] var0, short[] var1) {
		class433.sortItemsByName(var0, var1, 0, var0.length - 1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(II)Lpt;",
		garbageValue = "1302667977"
	)
	public static class437 method5021(int var0) {
		class437 var1 = (class437)class437.DBTableType_cache.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = class437.field4708.takeFile(39, var0);
			var1 = new class437();
			if (var2 != null) {
				var1.method7808(new Buffer(var2));
			}

			var1.method7809();
			class437.DBTableType_cache.put(var1, (long)var0);
			return var1;
		}
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(ILbt;ZI)I",
		garbageValue = "-1818370618"
	)
	static int method5006(int var0, Script var1, boolean var2) {
		if (var0 == 5630) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}
}
