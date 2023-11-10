import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bk")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lbk;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("aj")
	int field244;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lcl;"
	)
	@Export("sound")
	AbstractSound sound;
	@ObfuscatedName("aq")
	@Export("active")
	volatile boolean active;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "()Lbk;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "()Lbk;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("ac")
	@Export("vmethod5648")
	protected abstract int vmethod5648();

	@ObfuscatedName("al")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("ap")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("bx")
	@Export("vmethod1019")
	int vmethod1019() {
		return 255;
	}

	@ObfuscatedName("ft")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}