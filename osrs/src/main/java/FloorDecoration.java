import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("km")
@Implements("FloorDecoration")
public final class FloorDecoration {
	@ObfuscatedName("aa")
	static int field2162;
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
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("renderable")
	public Renderable renderable;
	@ObfuscatedName("ab")
	@Export("tag")
	public long tag;
	@ObfuscatedName("au")
	@Export("flags")
	int flags;

	FloorDecoration() {
	}
}