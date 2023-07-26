import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kt")
@Implements("WorldMapData_1")
public class WorldMapData_1 extends AbstractWorldMapData {
	@ObfuscatedName("aw")
	@Export("chunkXLow")
	int chunkXLow;
	@ObfuscatedName("ay")
	@Export("chunkYLow")
	int chunkYLow;
	@ObfuscatedName("ar")
	@Export("chunkX")
	int chunkX;
	@ObfuscatedName("am")
	@Export("chunkY")
	int chunkY;

	WorldMapData_1() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "5"
	)
	@Export("init")
	void init(Buffer var1) {
		int var2 = var1.readUnsignedByte();
		super.field2410 = var1.readUnsignedByte();
		super.planes = var1.readUnsignedByte();
		super.field2408 = var1.readUnsignedShort();
		super.field2405 = var1.readUnsignedShort();
		this.chunkXLow = var1.readUnsignedByte();
		this.chunkYLow = var1.readUnsignedByte();
		super.regionX = var1.readUnsignedShort();
		super.regionY = var1.readUnsignedShort();
		this.chunkX = var1.readUnsignedByte();
		this.chunkY = var1.readUnsignedByte();
		super.groupId = var1.method2543();
		super.fileId = var1.method2543();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lty;B)V",
		garbageValue = "81"
	)
	@Export("readGeography")
	void readGeography(Buffer var1) {
		super.planes = Math.min(super.planes, 4);
		super.floorUnderlayIds = new short[1][64][64];
		super.floorOverlayIds = new short[super.planes][64][64];
		super.field2402 = new byte[super.planes][64][64];
		super.field2403 = new byte[super.planes][64][64];
		super.decorations = new WorldMapDecoration[super.planes][64][64][];
		int var2 = var1.readUnsignedByte();
		int var3 = var1.readUnsignedByte();
		int var4 = var1.readUnsignedByte();
		int var5 = var1.readUnsignedByte();
		int var6 = var1.readUnsignedByte();
		if (var3 == super.regionX && var4 == super.regionY && var5 == this.chunkX && var6 == this.chunkY) {
			for (int var7 = 0; var7 < 8; ++var7) {
				for (int var8 = 0; var8 < 8; ++var8) {
					this.readTile(var7 + this.chunkX * 8, var8 + this.chunkY * 8, var1);
				}
			}

		} else {
			throw new IllegalStateException("");
		}
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "-6628"
	)
	@Export("getChunkXLow")
	int getChunkXLow() {
		return this.chunkXLow;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-2089356918"
	)
	@Export("getChunkYLow")
	int getChunkYLow() {
		return this.chunkYLow;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "91"
	)
	@Export("getChunkX")
	int getChunkX() {
		return this.chunkX;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-972374199"
	)
	@Export("getChunkY")
	int getChunkY() {
		return this.chunkY;
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (!(var1 instanceof WorldMapData_1)) {
			return false;
		} else {
			WorldMapData_1 var2 = (WorldMapData_1)var1;
			if (var2.regionX == super.regionX && var2.regionY == super.regionY) {
				return var2.chunkX == this.chunkX && var2.chunkY == this.chunkY;
			} else {
				return false;
			}
		}
	}

	public int hashCode() {
		return super.regionX | super.regionY << 8 | this.chunkX << 16 | this.chunkY << 24;
	}
}
