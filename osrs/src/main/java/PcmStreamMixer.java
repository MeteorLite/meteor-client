import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("PcmStreamMixer")
public class PcmStreamMixer extends PcmStream {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	@Export("subStreams")
	NodeDeque subStreams;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	NodeDeque field262;
	@ObfuscatedName("f")
	int field263;
	@ObfuscatedName("n")
	int field264;

	public PcmStreamMixer() {
		this.subStreams = new NodeDeque();
		this.field262 = new NodeDeque();
		this.field263 = 0;
		this.field264 = -1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lay;)V"
	)
	@Export("addSubStream")
	public final synchronized void addSubStream(PcmStream var1) {
		this.subStreams.addLast(var1);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Lay;)V"
	)
	@Export("removeSubStream")
	public final synchronized void removeSubStream(PcmStream var1) {
		var1.remove();
	}

	@ObfuscatedName("f")
	void method657() {
		if (this.field263 > 0) {
			for (PcmStreamMixerListener var1 = (PcmStreamMixerListener)this.field262.last(); var1 != null; var1 = (PcmStreamMixerListener)this.field262.previous()) {
				var1.field408 -= this.field263;
			}

			this.field264 -= this.field263;
			this.field263 = 0;
		}

	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Lov;Lau;)V"
	)
	void method680(Node var1, PcmStreamMixerListener var2) {
		while (this.field262.sentinel != var1 && ((PcmStreamMixerListener)var1).field408 <= var2.field408) {
			var1 = var1.previous;
		}

		NodeDeque.NodeDeque_addBefore(var2, var1);
		this.field264 = ((PcmStreamMixerListener)this.field262.sentinel.previous).field408;
	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(Lau;)V"
	)
	void method655(PcmStreamMixerListener var1) {
		var1.remove();
		var1.remove2();
		Node var2 = this.field262.sentinel.previous;
		if (var2 == this.field262.sentinel) {
			this.field264 = -1;
		} else {
			this.field264 = ((PcmStreamMixerListener)var2).field408;
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "()Lay;"
	)
	protected PcmStream firstSubStream() {
		return (PcmStream)this.subStreams.last();
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "()Lay;"
	)
	protected PcmStream nextSubStream() {
		return (PcmStream)this.subStreams.previous();
	}

	@ObfuscatedName("q")
	protected int vmethod5612() {
		return 0;
	}

	@ObfuscatedName("m")
	@Export("fill")
	public final synchronized void fill(int[] var1, int var2, int var3) {
		do {
			if (this.field264 < 0) {
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			if (var3 + this.field263 < this.field264) {
				this.field263 += var3;
				this.updateSubStreams(var1, var2, var3);
				return;
			}

			int var4 = this.field264 - this.field263;
			this.updateSubStreams(var1, var2, var4);
			var2 += var4;
			var3 -= var4;
			this.field263 += var4;
			this.method657();
			PcmStreamMixerListener var5 = (PcmStreamMixerListener)this.field262.last();
			synchronized(var5) {
				int var7 = var5.update();
				if (var7 < 0) {
					var5.field408 = 0;
					this.method655(var5);
				} else {
					var5.field408 = var7;
					this.method680(var5.previous, var5);
				}
			}
		} while(var3 != 0);

	}

	@ObfuscatedName("x")
	@Export("updateSubStreams")
	void updateSubStreams(int[] var1, int var2, int var3) {
		for (PcmStream var4 = (PcmStream)this.subStreams.last(); var4 != null; var4 = (PcmStream)this.subStreams.previous()) {
			var4.update(var1, var2, var3);
		}

	}

	@ObfuscatedName("j")
	@Export("skip")
	public final synchronized void skip(int var1) {
		do {
			if (this.field264 < 0) {
				this.skipSubStreams(var1);
				return;
			}

			if (this.field263 + var1 < this.field264) {
				this.field263 += var1;
				this.skipSubStreams(var1);
				return;
			}

			int var2 = this.field264 - this.field263;
			this.skipSubStreams(var2);
			var1 -= var2;
			this.field263 += var2;
			this.method657();
			PcmStreamMixerListener var3 = (PcmStreamMixerListener)this.field262.last();
			synchronized(var3) {
				int var5 = var3.update();
				if (var5 < 0) {
					var3.field408 = 0;
					this.method655(var3);
				} else {
					var3.field408 = var5;
					this.method680(var3.previous, var3);
				}
			}
		} while(var1 != 0);

	}

	@ObfuscatedName("v")
	@Export("skipSubStreams")
	void skipSubStreams(int var1) {
		for (PcmStream var2 = (PcmStream)this.subStreams.last(); var2 != null; var2 = (PcmStream)this.subStreams.previous()) {
			var2.skip(var1);
		}

	}
}
