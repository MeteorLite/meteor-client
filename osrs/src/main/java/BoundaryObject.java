import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("je")
@Implements("BoundaryObject")
public final class BoundaryObject {
	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "Lnd;"
	)
	public static AbstractArchive field2256;
	@ObfuscatedName("aw")
	@Export("z")
	int z;
	@ObfuscatedName("ay")
	@Export("x")
	int x;
	@ObfuscatedName("ar")
	@Export("y")
	int y;
	@ObfuscatedName("am")
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("as")
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lit;"
	)
	@Export("renderable1")
	public Renderable renderable1;
	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "Lit;"
	)
	@Export("renderable2")
	public Renderable renderable2;
	@ObfuscatedName("az")
	@Export("tag")
	public long tag;
	@ObfuscatedName("av")
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}
}
