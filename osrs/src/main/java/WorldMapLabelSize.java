import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jb")
@Implements("WorldMapLabelSize")
public class WorldMapLabelSize {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Ljb;"
	)
	@Export("WorldMapLabelSize_small")
	public static final WorldMapLabelSize WorldMapLabelSize_small;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Ljb;"
	)
	@Export("WorldMapLabelSize_medium")
	public static final WorldMapLabelSize WorldMapLabelSize_medium;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ljb;"
	)
	@Export("WorldMapLabelSize_large")
	public static final WorldMapLabelSize WorldMapLabelSize_large;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Let;"
	)
	@Export("World_request")
	static UrlRequest World_request;
	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "Lnb;"
	)
	static GameBuild field2323;
	@ObfuscatedName("at")
	final int field2326;
	@ObfuscatedName("ac")
	final int field2324;
	@ObfuscatedName("ai")
	final int field2325;

	static {
		WorldMapLabelSize_small = new WorldMapLabelSize(2, 0, 4);
		WorldMapLabelSize_medium = new WorldMapLabelSize(0, 1, 2);
		WorldMapLabelSize_large = new WorldMapLabelSize(1, 2, 0);
	}

	WorldMapLabelSize(int var1, int var2, int var3) {
		this.field2326 = var1;
		this.field2324 = var2;
		this.field2325 = var3;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(FI)Z",
		garbageValue = "-122455389"
	)
	boolean method1394(float var1) {
		return var1 >= (float)this.field2325;
	}

	@ObfuscatedName("mx")
	@ObfuscatedSignature(
		descriptor = "(Lmi;I)Lmi;",
		garbageValue = "1356224559"
	)
	static Widget method1395(Widget var0) {
		Widget var1 = BuddyRankComparator.method691(var0);
		if (var1 == null) {
			var1 = var0.parent;
		}

		return var1;
	}
}