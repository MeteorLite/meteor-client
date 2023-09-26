import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("BuddyRankComparator")
public class BuddyRankComparator extends AbstractUserComparator {
	@ObfuscatedName("ac")
	@Export("reversed")
	final boolean reversed;

	public BuddyRankComparator(boolean var1) {
		this.reversed = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lri;Lri;I)I",
		garbageValue = "383953435"
	)
	@Export("compareBuddy")
	int compareBuddy(Buddy var1, Buddy var2) {
		if (var2.rank != var1.rank) {
			return this.reversed ? var1.rank - var2.rank : var2.rank - var1.rank;
		} else {
			return this.compareUser(var1, var2);
		}
	}

	@Export("compare")
	@ObfuscatedName("compare")
	public int compare(Object var1, Object var2) {
		return this.compareBuddy((Buddy)var1, (Buddy)var2);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1321294301"
	)
	static void method687() {
		World.Tiles_underlays = null;
		VertexNormal.Tiles_overlays = null;
		SecureRandomFuture.Tiles_shapes = null;
		class199.field1563 = null;
		UserComparator6.field1191 = null;
		Tiles.field835 = null;
		class158.field1387 = null;
		SecureRandomFuture.Tiles_hue = null;
		class135.Tiles_saturation = null;
		Tiles.Tiles_lightness = null;
		WorldMapSection2.Tiles_hueMultiplier = null;
		Script.field812 = null;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "0"
	)
	protected static final int method688() {
		return GameEngine.keyHandler.getIdleCycles();
	}
}