import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pn")
@Implements("DelayFadeTask")
public class DelayFadeTask extends SongTask {
	@ObfuscatedName("ag")
	static String[] field3712;
	@ObfuscatedName("au")
	long field3714;
	@ObfuscatedName("ae")
	int field3713;

	@ObfuscatedSignature(
		descriptor = "(Lpm;I)V"
	)
	public DelayFadeTask(SongTask var1, int var2) {
		super(var1);
		this.field3713 = var2;
		super.field3722 = "DelayFadeTask";
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1604030758"
	)
	public boolean vmethod2142() {
		if (this.field3714 < (long)this.field3713) {
			++this.field3714;
			return false;
		} else {
			return true;
		}
	}
}