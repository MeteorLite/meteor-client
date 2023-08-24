import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qb")
@Implements("Buddy")
public class Buddy extends User {
	@ObfuscatedName("ac")
	@Export("world")
	public int world;
	@ObfuscatedName("ai")
	@Export("int2")
	public int int2;
	@ObfuscatedName("az")
	@Export("rank")
	public int rank;

	Buddy() {
		this.world = -1;
	}

	@ObfuscatedName("by")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2111367662"
	)
	@Export("set")
	void set(int var1, int var2) {
		this.world = var1;
		this.int2 = var2;
	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-12"
	)
	@Export("getWorld")
	public int getWorld() {
		return this.world;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-120"
	)
	@Export("hasWorld")
	public boolean hasWorld() {
		return this.world > 0;
	}
}