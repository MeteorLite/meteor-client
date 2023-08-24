import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jw")
@Implements("WallDecoration")
public final class WallDecoration {
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "[Ltd;"
	)
	@Export("JagexCache_idxFiles")
	public static BufferedFile[] JagexCache_idxFiles;
	@ObfuscatedName("au")
	@Export("z")
	int z;
	@ObfuscatedName("ae")
	@Export("x")
	int x;
	@ObfuscatedName("ao")
	@Export("y")
	int y;
	@ObfuscatedName("at")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("ac")
	@Export("orientation2")
	int orientation2;
	@ObfuscatedName("ai")
	@Export("xOffset")
	int xOffset;
	@ObfuscatedName("az")
	@Export("yOffset")
	int yOffset;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	@Export("renderable1")
	public Renderable renderable1;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	@Export("renderable2")
	public Renderable renderable2;
	@ObfuscatedName("af")
	@Export("tag")
	public long tag;
	@ObfuscatedName("ad")
	@Export("flags")
	int flags;

	WallDecoration() {
		this.tag = 0L;
		this.flags = 0;
	}
}