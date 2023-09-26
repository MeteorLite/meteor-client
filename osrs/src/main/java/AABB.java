import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jl")
@Implements("AABB")
public class AABB {
	@ObfuscatedName("gi")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	static Archive field2123;
	@ObfuscatedName("ac")
	@Export("xMid")
	int xMid;
	@ObfuscatedName("al")
	@Export("yMid")
	int yMid;
	@ObfuscatedName("ak")
	@Export("zMid")
	int zMid;
	@ObfuscatedName("ax")
	@Export("xMidOffset")
	int xMidOffset;
	@ObfuscatedName("ao")
	@Export("yMidOffset")
	int yMidOffset;
	@ObfuscatedName("ah")
	@Export("zMidOffset")
	int zMidOffset;

	AABB(int var1, int var2, int var3, int var4, int var5, int var6) {
		this.xMid = var1;
		this.yMid = var2;
		this.zMid = var3;
		this.xMidOffset = var4;
		this.yMidOffset = var5;
		this.zMidOffset = var6;
	}
}