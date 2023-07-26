import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oc")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
	@ObfuscatedName("aw")
	@Export("state")
	byte state;
	@ObfuscatedName("ay")
	@Export("id")
	public int id;
	@ObfuscatedName("ar")
	@Export("unitPrice")
	public int unitPrice;
	@ObfuscatedName("am")
	@Export("totalQuantity")
	public int totalQuantity;
	@ObfuscatedName("as")
	@Export("currentQuantity")
	public int currentQuantity;
	@ObfuscatedName("aj")
	@Export("currentPrice")
	public int currentPrice;

	public GrandExchangeOffer() {
	}

	@ObfuscatedSignature(
		descriptor = "(Lty;Z)V",
		garbageValue = "0"
	)
	public GrandExchangeOffer(Buffer var1, boolean var2) {
		this.state = var1.readByte();
		this.id = var1.readUnsignedShort();
		this.unitPrice = var1.readInt();
		this.totalQuantity = var1.readInt();
		this.currentQuantity = var1.readInt();
		this.currentPrice = var1.readInt();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1630378592"
	)
	@Export("status")
	public int status() {
		return this.state & 7;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1876480089"
	)
	@Export("type")
	public int type() {
		return (this.state & 8) == 8 ? 1 : 0;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1208558885"
	)
	void method1924(int var1) {
		this.state &= -8;
		this.state = (byte)(this.state | var1 & 7);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "336856274"
	)
	void method1925(int var1) {
		this.state &= -9;
		if (var1 == 1) {
			this.state = (byte)(this.state | 8);
		}

	}

	@ObfuscatedName("cb")
	@ObfuscatedSignature(
		descriptor = "(ILmr;ZI)V",
		garbageValue = "1667240320"
	)
	static void method1926(int var0, Coord var1, boolean var2) {
		WorldMapArea var3 = class102.getWorldMap().getMapArea(var0);
		int var4 = class136.localPlayer.plane;
		int var5 = (class136.localPlayer.x >> 7) + AbstractArchive.baseX;
		int var6 = (class136.localPlayer.y >> 7) + class148.baseY;
		Coord var7 = new Coord(var4, var5, var6);
		class102.getWorldMap().method2375(var3, var7, var1, var2);
	}
}
