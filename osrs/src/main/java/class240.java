import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
public class class240 implements WorldMapSection {
	@ObfuscatedName("at")
	int field2015;
	@ObfuscatedName("ah")
	int field2011;
	@ObfuscatedName("ar")
	int field2014;
	@ObfuscatedName("ao")
	int field2013;
	@ObfuscatedName("ab")
	int field2009;
	@ObfuscatedName("au")
	int field2016;
	@ObfuscatedName("aa")
	int field2008;
	@ObfuscatedName("ac")
	int field2010;
	@ObfuscatedName("al")
	int field2012;
	@ObfuscatedName("az")
	int field2017;

	class240() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljv;B)V",
		garbageValue = "16"
	)
	@Export("expandBounds")
	public void expandBounds(WorldMapArea var1) {
		if (var1.regionLowX > this.field2009) {
			var1.regionLowX = this.field2009;
		}

		if (var1.regionHighX < this.field2009) {
			var1.regionHighX = this.field2009;
		}

		if (var1.regionLowY > this.field2016) {
			var1.regionLowY = this.field2016;
		}

		if (var1.regionHighY < this.field2016) {
			var1.regionHighY = this.field2016;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(IIIB)Z",
		garbageValue = "2"
	)
	@Export("containsCoord")
	public boolean containsCoord(int var1, int var2, int var3) {
		if (var1 >= this.field2015 && var1 < this.field2011 + this.field2015) {
			return var2 >= (this.field2014 << 6) + (this.field2008 << 3) && var2 <= (this.field2014 << 6) + (this.field2008 << 3) + 7 && var3 >= (this.field2013 << 6) + (this.field2010 << 3) && var3 <= (this.field2013 << 6) + (this.field2010 << 3) + 7;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(III)Z",
		garbageValue = "542110974"
	)
	@Export("containsPosition")
	public boolean containsPosition(int var1, int var2) {
		return var1 >= (this.field2009 << 6) + (this.field2012 << 3) && var1 <= (this.field2009 << 6) + (this.field2012 << 3) + 7 && var2 >= (this.field2016 << 6) + (this.field2017 << 3) && var2 <= (this.field2016 << 6) + (this.field2017 << 3) + 7;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(IIIS)[I",
		garbageValue = "12300"
	)
	@Export("getBorderTileLengths")
	public int[] getBorderTileLengths(int var1, int var2, int var3) {
		if (!this.containsCoord(var1, var2, var3)) {
			return null;
		} else {
			int[] var4 = new int[]{var2 + (this.field2009 * 64 - this.field2014 * 64) + (this.field2012 * 8 - this.field2008 * 8), var3 + (this.field2016 * 64 - this.field2013 * 64) + (this.field2017 * 8 - this.field2010 * 8)};
			return var4;
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(III)Lmh;",
		garbageValue = "-1535299153"
	)
	@Export("coord")
	public Coord coord(int var1, int var2) {
		if (!this.containsPosition(var1, var2)) {
			return null;
		} else {
			int var3 = this.field2014 * 64 - this.field2009 * 64 + (this.field2008 * 8 - this.field2012 * 8) + var1;
			int var4 = var2 + (this.field2013 * 64 - this.field2016 * 64) + (this.field2010 * 8 - this.field2017 * 8);
			return new Coord(this.field2015, var3, var4);
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)V",
		garbageValue = "-10"
	)
	@Export("read")
	public void read(Buffer var1) {
		this.field2015 = var1.readUnsignedByte();
		this.field2011 = var1.readUnsignedByte();
		this.field2014 = var1.readUnsignedShort();
		this.field2008 = var1.readUnsignedByte();
		this.field2013 = var1.readUnsignedShort();
		this.field2010 = var1.readUnsignedByte();
		this.field2009 = var1.readUnsignedShort();
		this.field2012 = var1.readUnsignedByte();
		this.field2016 = var1.readUnsignedShort();
		this.field2017 = var1.readUnsignedByte();
		this.method1292();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "7"
	)
	void method1292() {
	}

	@ObfuscatedName("iq")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-976406979"
	)
	static final int method1293(int var0) {
		return Math.min(Math.max(var0, 128), 383);
	}

	@ObfuscatedName("og")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-28"
	)
	static void method1294(int var0) {
		SequenceDefinition var1 = DynamicObject.SequenceDefinition_get(var0);
		if (var1.isCachedModelIdSet()) {
			if (MouseRecorder.method469(var1.SequenceDefinition_cachedModelId) == 2) {
				Client.field607.add(var1.SequenceDefinition_cachedModelId);
			}

		}
	}
}