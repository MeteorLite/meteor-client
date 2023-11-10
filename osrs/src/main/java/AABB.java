import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ku")
@Implements("AABB")
public class AABB {
	@ObfuscatedName("at")
	@Export("xMid")
	int xMid;
	@ObfuscatedName("ah")
	@Export("yMid")
	int yMid;
	@ObfuscatedName("ar")
	@Export("zMid")
	int zMid;
	@ObfuscatedName("ao")
	@Export("xMidOffset")
	int xMidOffset;
	@ObfuscatedName("ab")
	@Export("yMidOffset")
	int yMidOffset;
	@ObfuscatedName("au")
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