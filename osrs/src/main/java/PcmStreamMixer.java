import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bl")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	NodeDeque field161;
	@ObfuscatedName("ao")
	int field159;
	@ObfuscatedName("at")
	int field160;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field161 = new NodeDeque();
		this.field159 = 0;
		this.field160 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lbw;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lbw;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("ao")
	void method177() {
		if (this.field159 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field161.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field161.previous()) {
				var1.field294 -= this.field159;
			}

			this.field160 -= this.field159;
			this.field159 = 0;
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lsj;Lcs;)V"
	)
	void method178(Node var1, PcmStreamMixerListener var2) {
		while (this.field161.sentinel != var1 && ((PcmStreamMixerListener)var1).field294 <= var2.field294) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field160 = ((PcmStreamMixerListener)this.field161.sentinel.previous).field294;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lcs;)V"
	)
	void method179(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field161.sentinel.previous;
		if (var2 == this.field161.sentinel) {
			this.field160 = -1;
		} else {
			this.field160 = ((PcmStreamMixerListener)var2).field294;
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("ap")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("aa")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field160 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field159 < this.field160) {
				this.field159 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field160 - this.field159;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field159 += var4;
			this.method177();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field161.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field294 = 0;
					this.method179(var5);
				} else {
					var5.field294 = var7;
					this.method178(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("af")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("ad")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field160 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field159 + var1 < this.field160) {
				this.field159 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field160 - this.field159;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field159 += var2;
			this.method177();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field161.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field294 = 0;
					this.method179(var3);
				} else {
					var3.field294 = var5;
					this.method178(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("aq")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}