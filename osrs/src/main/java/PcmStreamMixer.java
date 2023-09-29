import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	NodeDeque field161;
	@ObfuscatedName("ak")
	int field158;
	@ObfuscatedName("ax")
	int field159;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field161 = new NodeDeque();
		this.field158 = 0;
		this.field159 = -1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lbi;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lbi;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("ak")
	void method187() {
		if (this.field158 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field161.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field161.previous()) {
				var1.field293 -= this.field158;
			}

			this.field159 -= this.field158;
			this.field158 = 0;
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Lsj;Lcc;)V"
	)
	void method188(Node var1, PcmStreamMixerListener var2) {
		while (this.field161.sentinel != var1 && ((PcmStreamMixerListener)var1).field293 <= var2.field293) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field159 = ((PcmStreamMixerListener)this.field161.sentinel.previous).field293;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lcc;)V"
	)
	void method189(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field161.sentinel.previous;
		if (var2 == this.field161.sentinel) {
			this.field159 = -1;
		} else {
			this.field159 = ((PcmStreamMixerListener)var2).field293;
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "()Lbi;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "()Lbi;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("ab")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("am")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field159 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field158 < this.field159) {
				this.field158 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field159 - this.field158;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field158 += var4;
			this.method187();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field161.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field293 = 0;
					this.method189(var5);
				} else {
					var5.field293 = var7;
					this.method188(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("av")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("ag")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field159 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field158 + var1 < this.field159) {
				this.field158 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field159 - this.field158;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field158 += var2;
			this.method187();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field161.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field293 = 0;
					this.method189(var3);
				} else {
					var3.field293 = var5;
					this.method188(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("aa")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}