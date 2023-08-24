import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("BoundaryObject")
public final class BoundaryObject {
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
	@Export("orientationA")
	int orientationA;
	@ObfuscatedName("ac")
	@Export("orientationB")
	int orientationB;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	@Export("renderable1")
	public Renderable renderable1;
	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "Lik;"
	)
	@Export("renderable2")
	public Renderable renderable2;
	@ObfuscatedName("ap")
	@Export("tag")
	public long tag;
	@ObfuscatedName("aa")
	@Export("flags")
	int flags;

	BoundaryObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;II)Z",
		garbageValue = "1066903143"
	)
	static boolean method1384(String var0, int var1) {
		return class299.method1618(var0, var1, "openjs");
	}
}