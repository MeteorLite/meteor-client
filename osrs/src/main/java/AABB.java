import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ip")
@Implements("AABB")
public class AABB {
	@ObfuscatedName("au")
	@Export("xMid")
	int xMid;
	@ObfuscatedName("ae")
	@Export("yMid")
	int yMid;
	@ObfuscatedName("ao")
	@Export("zMid")
	int zMid;
	@ObfuscatedName("at")
	@Export("xMidOffset")
	int xMidOffset;
	@ObfuscatedName("ac")
	@Export("yMidOffset")
	int yMidOffset;
	@ObfuscatedName("ai")
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