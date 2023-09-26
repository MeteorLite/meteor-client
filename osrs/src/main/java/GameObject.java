import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kl")
@Implements("GameObject")
public final class GameObject {
	@ObfuscatedName("ac")
	@Export("plane")
	int plane;
	@ObfuscatedName("al")
	@Export("z")
	int z;
	@ObfuscatedName("ak")
	@Export("centerX")
	int centerX;
	@ObfuscatedName("ax")
	@Export("centerY")
	int centerY;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ljy;"
	)
	@Export("renderable")
	public Renderable renderable;
	@ObfuscatedName("ah")
	@Export("orientation")
	int orientation;
	@ObfuscatedName("ar")
	@Export("startX")
	int startX;
	@ObfuscatedName("ab")
	@Export("endX")
	int endX;
	@ObfuscatedName("am")
	@Export("startY")
	int startY;
	@ObfuscatedName("av")
	@Export("endY")
	int endY;
	@ObfuscatedName("ag")
	int field2319;
	@ObfuscatedName("aa")
	@Export("lastDrawn")
	int lastDrawn;
	@ObfuscatedName("ap")
	@Export("tag")
	public long tag;
	@ObfuscatedName("ay")
	@Export("flags")
	int flags;

	GameObject() {
		this.tag = 0L;
		this.flags = 0;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "([Ljava/lang/String;[SB)V",
		garbageValue = "84"
	)
	public static void method1426(String[] var0, short[] var1) {
		VarpDefinition.sortItemsByName(var0, var1, 0, var0.length - 1);
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "2128713491"
	)
	public static int method1427(int var0) {
		return class479.field3939[var0 & 16383];
	}
}