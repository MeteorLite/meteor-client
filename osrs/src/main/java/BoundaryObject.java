import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("ac")
	@Export("z")
	int z;
	@ObfuscatedName("al")
	@Export("x")
	int x;
	@ObfuscatedName("ak")
	@Export("y")
	int y;
	@ObfuscatedName("ax")
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("ao")
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ljy;"
	)
	@Export("renderable1")
	public Renderable renderable1;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ljy;"
	)
	@Export("renderable2")
	public Renderable renderable2;
	@ObfuscatedName("ab")
	@Export("tag")
	public long tag;
	@ObfuscatedName("am")
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}
}