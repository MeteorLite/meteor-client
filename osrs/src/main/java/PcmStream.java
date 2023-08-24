import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bw")
@Implements("PcmStream")
public abstract class PcmStream extends Node {
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lbw;"
	)
	@Export("after")
	PcmStream after;
	@ObfuscatedName("ag")
	int field249;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lcp;"
	)
	@Export("sound")
	AbstractSound sound;
	@ObfuscatedName("ax")
	@Export("active")
	volatile boolean active;

	protected PcmStream() {
		this.active = true;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
	)
	@Export("firstSubStream")
	protected abstract PcmStream firstSubStream();

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
	)
	@Export("nextSubStream")
	protected abstract PcmStream nextSubStream();

	@ObfuscatedName("ap")
	@Export("vmethod5648")
	protected abstract int vmethod5648();

	@ObfuscatedName("aa")
	@Export("fill")
	protected abstract void fill(int[] var1, int var2, int var3);

	@ObfuscatedName("ad")
	@Export("skip")
	protected abstract void skip(int var1);

	@ObfuscatedName("br")
	@Export("vmethod1019")
	int vmethod1019() {
		return 255;
	}

	@ObfuscatedName("fq")
	@Export("update")
	final void update(int[] var1, int var2, int var3) {
		if (this.active) {
			this.fill(var1, var2, var3);
		} else {
			this.skip(var3);
		}

	}
}