import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("at")
	@Export("z")
	int z;
	@ObfuscatedName("ah")
	@Export("x")
	int x;
	@ObfuscatedName("ar")
	@Export("y")
	int y;
	@ObfuscatedName("ao")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("ab")
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("au")
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("aa")
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("renderable1")
	public Renderable renderable1;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("renderable2")
	public Renderable renderable2;
	@ObfuscatedName("az")
	@Export("tag")
	public long tag;
	@ObfuscatedName("ap")
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Luk;",
		garbageValue = "-1385996560"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.SOLID, FillMode.field4258, FillMode.field4259};
	}
}