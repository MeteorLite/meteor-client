import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mn")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("ar")
	public static int field2855;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lpf;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lbm;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		descriptor = "(Lmt;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lms;[IIIII)V",
		garbageValue = "1027988933"
	)
	void method1723(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2812[var1.field2865] & 4) != 0 && var1.field2876 < 0) {
			int var6 = this.superStream.field2813[var1.field2865] / PcmPlayer.field179;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2874) / var6;
				if (var7 > var4) {
					var1.field2874 += var4 * var6;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2874 += var7 * var6 - 1048576;
				int var8 = PcmPlayer.field179 / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2824[var1.field2865] == 0) {
					var1.stream = RawPcmStream.method244(var1.rawSound, var10.method259(), var10.method250(), var10.method251());
				} else {
					var1.stream = RawPcmStream.method244(var1.rawSound, var10.method259(), 0, var10.method251());
					this.superStream.method1675(var1, var1.table.field2853[var1.field2868] < 0);
					var1.stream.method255(var8, var10.method250());
				}

				if (var1.table.field2853[var1.field2868] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method257(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method261()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(Lms;II)V",
		garbageValue = "1919662235"
	)
	void method1724(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2812[var1.field2865] & 4) != 0 && var1.field2876 < 0) {
			int var3 = this.superStream.field2813[var1.field2865] / PcmPlayer.field179;
			int var4 = (var3 + 1048575 - var1.field2874) / var3;
			var1.field2874 = var3 * var2 + var1.field2874 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2824[var1.field2865] == 0) {
					var1.stream = RawPcmStream.method244(var1.rawSound, var1.stream.method259(), var1.stream.method250(), var1.stream.method251());
				} else {
					var1.stream = RawPcmStream.method244(var1.rawSound, var1.stream.method259(), 0, var1.stream.method251());
					this.superStream.method1675(var1, var1.table.field2853[var1.field2868] < 0);
				}

				if (var1.table.field2853[var1.field2868] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2874 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "()Lbi;"
	)
	@Export("firstSubStream")
	protected PcmStream firstSubStream() {
		MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
		if (var1 == null) {
			return null;
		} else {
			return (PcmStream)(var1.stream != null ? var1.stream : this.nextSubStream());
		}
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "()Lbi;"
	)
	@Export("nextSubStream")
	protected PcmStream nextSubStream() {
		MusicPatchNode var1;
		do {
			var1 = (MusicPatchNode)this.queue.previous();
			if (var1 == null) {
				return null;
			}
		} while(var1.stream == null);

		return var1.stream;
	}

	@ObfuscatedName("ab")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("am")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method1697(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2866) {
						this.method1723(var6, var1, var4, var5, var5 + var4);
						var6.field2866 -= var5;
						break;
					}

					this.method1723(var6, var1, var4, var6.field2866, var4 + var5);
					var4 += var6.field2866;
					var5 -= var6.field2866;
				} while(!this.superStream.method1698(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("ag")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method1697(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2866) {
						this.method1724(var3, var2);
						var3.field2866 -= var2;
						break;
					}

					this.method1724(var3, var3.field2866);
					var2 -= var3.field2866;
				} while(!this.superStream.method1698(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "120235827"
	)
	public static void method1725() {
		ObjectComposition.ObjectDefinition_cached.clear();
		ObjectComposition.ObjectDefinition_cachedModelData.clear();
		ObjectComposition.ObjectDefinition_cachedEntities.clear();
		ObjectComposition.HitSplatDefinition_cachedSprites.clear();
	}
}