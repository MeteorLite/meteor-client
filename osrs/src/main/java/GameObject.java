import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("le")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("aj")
	static String[] field2480;
	@ObfuscatedName("at")
	@Export("plane")
	int plane;
	@ObfuscatedName("ah")
	@Export("z")
	int z;
	@ObfuscatedName("ar")
	@Export("centerX")
	int centerX;
	@ObfuscatedName("ao")
	@Export("centerY")
	int centerY;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lkt;"
	)
	@Export("renderable")
	public Renderable renderable;
	@ObfuscatedName("au")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("aa")
	@Export("startX")
	int startX;
	@ObfuscatedName("ac")
	@Export("endX")
	int endX;
	@ObfuscatedName("al")
	@Export("startY")
	int startY;
	@ObfuscatedName("az")
	@Export("endY")
	int endY;
	@ObfuscatedName("ap")
	int field2486;
	@ObfuscatedName("av")
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("ax")
	@Export("tag")
	public long tag;
	@ObfuscatedName("as")
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}
}