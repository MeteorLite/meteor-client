import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lmi;"
	)
	@Export("scriptDotWidget")
	static Widget scriptDotWidget;
	@ObfuscatedName("au")
	@Export("plane")
	int plane;
	@ObfuscatedName("ae")
	@Export("z")
	int z;
	@ObfuscatedName("ao")
	@Export("centerX")
	int centerX;
	@ObfuscatedName("at")
	@Export("centerY")
	int centerY;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	@Export("renderable")
	public Renderable renderable;
	@ObfuscatedName("ai")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("az")
	@Export("startX")
	int startX;
	@ObfuscatedName("ap")
	@Export("endX")
	int endX;
	@ObfuscatedName("aa")
	@Export("startY")
	int startY;
	@ObfuscatedName("af")
	@Export("endY")
	int endY;
	@ObfuscatedName("ad")
	int field2306;
	@ObfuscatedName("aq")
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("al")
	@Export("tag")
	public long tag;
	@ObfuscatedName("an")
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}
}