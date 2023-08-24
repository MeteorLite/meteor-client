import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.LinkedList;

@ObfuscatedName("ke")
@Implements("AbstractWorldMapData")
public abstract class AbstractWorldMapData {
	@ObfuscatedName("ac")
	int field2429;
	@ObfuscatedName("ai")
	int field2432;
	@ObfuscatedName("az")
	@Export("regionX")
	int regionX;
	@ObfuscatedName("ap")
	@Export("regionY")
	int regionY;
	@ObfuscatedName("aa")
	int field2428;
	@ObfuscatedName("af")
	@Export("planes")
	int planes;
	@ObfuscatedName("ad")
	@Export("groupId")
	int groupId;
	@ObfuscatedName("aq")
	@Export("fileId")
	int fileId;
	@ObfuscatedName("al")
	@Export("floorUnderlayIds")
	short[][][] floorUnderlayIds;
	@ObfuscatedName("an")
	@Export("floorOverlayIds")
	short[][][] floorOverlayIds;
	@ObfuscatedName("ar")
	byte[][][] field2427;
	@ObfuscatedName("ab")
	byte[][][] field2426;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "[[[[Lkn;"
	)
	@Export("decorations")
	WorldMapDecoration[][][][] decorations;
	@ObfuscatedName("am")
	boolean field2424;
	@ObfuscatedName("ax")
	boolean field2425;

	AbstractWorldMapData() {
		this.groupId = -1;
		this.fileId = -1;
		new LinkedList();
		this.field2424 = false;
		this.field2425 = false;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "2049371979"
	)
	@Export("readGeography")
	abstract void readGeography(Buffer var1);

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2138999943"
	)
	@Export("isFullyLoaded")
	boolean isFullyLoaded() {
		return this.field2424 && this.field2425;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lnu;I)V",
		garbageValue = "-1524601998"
	)
	@Export("loadGeography")
	void loadGeography(AbstractArchive var1) {
		if (!this.isFullyLoaded()) {
			byte[] var2 = var1.takeFile(this.groupId, this.fileId);
			if (var2 != null) {
				this.readGeography(new Buffer(var2));
				this.field2424 = true;
				this.field2425 = true;
			}

		}
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1792319302"
	)
	@Export("reset")
	void reset() {
		this.floorUnderlayIds = null;
		this.floorOverlayIds = null;
		this.field2427 = null;
		this.field2426 = null;
		this.decorations = null;
		this.field2424 = false;
		this.field2425 = false;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(IILtm;I)V",
		garbageValue = "-938397050"
	)
	@Export("readTile")
	void readTile(int var1, int var2, Buffer var3) {
		int var4 = var3.readUnsignedByte();
		if (var4 != 0) {
			if ((var4 & 1) != 0) {
				this.method1522(var1, var2, var3, var4);
			} else {
				this.method1523(var1, var2, var3, var4);
			}

		}
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(IILtm;IS)V",
		garbageValue = "23970"
	)
	void method1522(int var1, int var2, Buffer var3, int var4) {
		boolean var5 = (var4 & 2) != 0;
		if (var5) {
			this.floorOverlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
		}

		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
	}

	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "(IILtm;II)V",
		garbageValue = "-835370941"
	)
	void method1523(int var1, int var2, Buffer var3, int var4) {
		int var5 = ((var4 & 24) >> 3) + 1;
		boolean var6 = (var4 & 2) != 0;
		boolean var7 = (var4 & 4) != 0;
		this.floorUnderlayIds[0][var1][var2] = (short)var3.readUnsignedShort();
		int var8;
		int var9;
		int var11;
		if (var6) {
			var8 = var3.readUnsignedByte();

			for (var9 = 0; var9 < var8; ++var9) {
				int var10 = var3.readUnsignedShort();
				if (var10 != 0) {
					this.floorOverlayIds[var9][var1][var2] = (short)var10;
					var11 = var3.readUnsignedByte();
					this.field2427[var9][var1][var2] = (byte)(var11 >> 2);
					this.field2426[var9][var1][var2] = (byte)(var11 & 3);
				}
			}
		}

		if (var7) {
			for (var8 = 0; var8 < var5; ++var8) {
				var9 = var3.readUnsignedByte();
				if (var9 != 0) {
					WorldMapDecoration[] var14 = this.decorations[var8][var1][var2] = new WorldMapDecoration[var9];

					for (var11 = 0; var11 < var9; ++var11) {
						int var12 = var3.method2563();
						int var13 = var3.readUnsignedByte();
						var14[var11] = new WorldMapDecoration(var12, var13 >> 2, var13 & 3);
					}
				}
			}
		}

	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1240357684"
	)
	@Export("getRegionX")
	int getRegionX() {
		return this.regionX;
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "65280"
	)
	@Export("getRegionY")
	int getRegionY() {
		return this.regionY;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Ldk;",
		garbageValue = "-74962306"
	)
	static class90[] method1517() {
		return new class90[]{class90.field889, class90.field892, class90.field888, class90.field893, class90.field891, class90.field890};
	}

	@ObfuscatedName("ho")
	@ObfuscatedSignature(
		descriptor = "(B)Liz;",
		garbageValue = "100"
	)
	public static class212 method1526() {
		return Client.keyHandlerInstance;
	}
}