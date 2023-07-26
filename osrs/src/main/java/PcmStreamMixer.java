import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	NodeDeque field163;
	@ObfuscatedName("ar")
	int field161;
	@ObfuscatedName("am")
	int field160;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field163 = new NodeDeque();
		this.field161 = 0;
		this.field160 = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lby;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lby;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("ar")
	void method179() {
		if (this.field161 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field163.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field163.previous()) {
				var1.field294 -= this.field161;
			}

			this.field160 -= this.field161;
			this.field161 = 0;
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(Lsb;Lcs;)V"
	)
	void method180(Node var1, PcmStreamMixerListener var2) {
		while (this.field163.sentinel != var1 && ((PcmStreamMixerListener)var1).field294 <= var2.field294) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field160 = ((PcmStreamMixerListener)this.field163.sentinel.previous).field294;
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(Lcs;)V"
	)
	void method181(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field163.sentinel.previous;
		if (var2 == this.field163.sentinel) {
			this.field160 = -1;
		} else {
			this.field160 = ((PcmStreamMixerListener)var2).field294;
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "()Lby;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "()Lby;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("az")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("av")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field160 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field161 < this.field160) {
				this.field161 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field160 - this.field161;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field161 += var4;
			this.method179();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field163.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field294 = 0;
					this.method181(var5);
				} else {
					var5.field294 = var7;
					this.method180(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("ap")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("aq")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field160 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field161 + var1 < this.field160) {
				this.field161 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field160 - this.field161;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field161 += var2;
			this.method179();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field163.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field294 = 0;
					this.method181(var3);
				} else {
					var3.field294 = var5;
					this.method180(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("at")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
