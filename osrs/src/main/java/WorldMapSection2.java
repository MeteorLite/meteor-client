import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
	@ObfuscatedName("i")
	@ObfuscatedSignature(
		descriptor = "Llv;"
	)
	@Export("Widget_modelsArchive")
	public static AbstractArchive Widget_modelsArchive;
	@ObfuscatedName("c")
	@ObfuscatedGetter(
		intValue = 404728087
	)
	@Export("minPlane")
	int minPlane;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 228867237
	)
	@Export("planes")
	int planes;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = 1205780547
	)
	@Export("regionStartX")
	int regionStartX;
	@ObfuscatedName("n")
	@ObfuscatedGetter(
		intValue = 1825898847
	)
	@Export("regionStartY")
	int regionStartY;
	@ObfuscatedName("k")
	@ObfuscatedGetter(
		intValue = 582205469
	)
	@Export("regionEndX")
	int regionEndX;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1246333681
	)
	@Export("regionEndY")
	int regionEndY;
	@ObfuscatedName("s")
	@ObfuscatedGetter(
		intValue = -136277373
	)
	int field2717;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = -941785029
	)
	int field2724;
	@ObfuscatedName("m")
	@ObfuscatedGetter(
		intValue = 175247255
	)
	int field2725;
	@ObfuscatedName("x")
	@ObfuscatedGetter(
		intValue = 498499109
	)
	int field2726;

	WorldMapSection2() {
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lht;I)V",
		garbageValue = "1697283195"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2717) {
			var1.regionLowX = this.field2717;
		}

		if (var1.regionHighX < this.field2725) {
			var1.regionHighX = this.field2725;
		}

		if (var1.regionLowY > this.field2724) {
			var1.regionLowY = this.field2724;
		}

		if (var1.regionHighY < this.field2726) {
			var1.regionHighY = this.field2726;
		}

	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(IIIB)Z",
		garbageValue = "-24"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.minPlane && var1 < this.planes + this.minPlane) {
			return var2 >> 6 >= this.regionStartX && var2 >> 6 <= this.regionEndX && var3 >> 6 >= this.regionStartY && var3 >> 6 <= this.regionEndY;
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
		return var1 >> 6 >= this.field2717 && var1 >> 6 <= this.field2725 && var2 >> 6 >= this.field2724 && var2 >> 6 <= this.field2726;
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
			int[] var4 = new int[]{this.field2717 * 64 - this.regionStartX * 64 + var2, var3 + (this.field2724 * 64 - this.regionStartY * 64)};
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
			int var3 = this.regionStartX * 64 - this.field2717 * 64 + var1;
			int var4 = this.regionStartY * 64 - this.field2724 * 64 + var2;
			return new Coord(this.minPlane, var3, var4);
		}
	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "(Lqq;I)V",
		garbageValue = "53690591"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.minPlane = var1.readUnsignedByte();
		this.planes = var1.readUnsignedByte();
		this.regionStartX = var1.readUnsignedShort();
		this.regionStartY = var1.readUnsignedShort();
		this.regionEndX = var1.readUnsignedShort();
		this.regionEndY = var1.readUnsignedShort();
		this.field2717 = var1.readUnsignedShort();
		this.field2724 = var1.readUnsignedShort();
		this.field2725 = var1.readUnsignedShort();
		this.field2726 = var1.readUnsignedShort();
		this.postRead();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "705799780"
	)
	@Export("postRead")
	void postRead() {
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "36"
	)
	public static void method4729(int var0) {
		if (var0 != -1) {
			if (class83.Widget_loadedInterfaces[var0]) {
				MouseHandler.Widget_archive.clearFilesGroup(var0);
				if (Calendar.Widget_interfaceComponents[var0] != null) {
					boolean var1 = true;

					for (int var2 = 0; var2 < Calendar.Widget_interfaceComponents[var0].length; ++var2) {
						if (Calendar.Widget_interfaceComponents[var0][var2] != null) {
							if (Calendar.Widget_interfaceComponents[var0][var2].type != 2) {
								Calendar.Widget_interfaceComponents[var0][var2] = null;
							} else {
								var1 = false;
							}
						}
					}

					if (var1) {
						Calendar.Widget_interfaceComponents[var0] = null;
					}

					class83.Widget_loadedInterfaces[var0] = false;
				}
			}
		}
	}
}
