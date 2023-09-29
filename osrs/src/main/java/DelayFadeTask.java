import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qb")
@Implements("DelayFadeTask")
public class DelayFadeTask extends SongTask {
	@ObfuscatedName("ac")
	long field3745;
	@ObfuscatedName("al")
	int field3744;

	@ObfuscatedSignature(
		descriptor = "(Lqm;I)V"
	)
	public DelayFadeTask(SongTask var1, int var2) {
		super(var1);
		this.field3744 = var2;
		super.field3753 = "DelayFadeTask";
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-90"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		if (this.field3745 < (long)this.field3744) {
			++this.field3745;
			return false;
		} else {
			return true;
		}
	}
}