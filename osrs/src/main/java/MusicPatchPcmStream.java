import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mh")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("cq")
	@Export("param9")
	static String param9;
	@ObfuscatedName("da")
	@ObfuscatedSignature(
		descriptor = "[Luk;"
	)
	@Export("worldSelectArrows")
	static IndexedSprite[] worldSelectArrows;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Llf;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Low;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lbl;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		descriptor = "(Llf;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lmg;[IIIII)V",
		garbageValue = "-1470888543"
	)
	void method1693(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2790[var1.field2854] & 4) != 0 && var1.field2853 < 0) {
			int var6 = this.superStream.field2798[var1.field2854] / PcmPlayer.field181;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2855) / var6;
				if (var7 > var4) {
					var1.field2855 += var6 * var4;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2855 += var7 * var6 - 1048576;
				int var8 = PcmPlayer.field181 / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2792[var1.field2854] == 0) {
					var1.stream = RawPcmStream.method235(var1.rawSound, var10.method250(), var10.method241(), var10.method242());
				} else {
					var1.stream = RawPcmStream.method235(var1.rawSound, var10.method250(), 0, var10.method242());
					this.superStream.method1642(var1, var1.table.field2830[var1.field2847] < 0);
					var1.stream.method246(var8, var10.method241());
				}

				if (var1.table.field2830[var1.field2847] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method248(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method252()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lmg;II)V",
		garbageValue = "-2042371851"
	)
	void method1694(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2790[var1.field2854] & 4) != 0 && var1.field2853 < 0) {
			int var3 = this.superStream.field2798[var1.field2854] / PcmPlayer.field181;
			int var4 = (var3 + 1048575 - var1.field2855) / var3;
			var1.field2855 = var3 * var2 + var1.field2855 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2792[var1.field2854] == 0) {
					var1.stream = RawPcmStream.method235(var1.rawSound, var1.stream.method250(), var1.stream.method241(), var1.stream.method242());
				} else {
					var1.stream = RawPcmStream.method235(var1.rawSound, var1.stream.method250(), 0, var1.stream.method242());
					this.superStream.method1642(var1, var1.table.field2830[var1.field2847] < 0);
				}

				if (var1.table.field2830[var1.field2847] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2855 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
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

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
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

	@ObfuscatedName("ap")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("aa")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method1665(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2846) {
						this.method1693(var6, var1, var4, var5, var5 + var4);
						var6.field2846 -= var5;
						break;
					}

					this.method1693(var6, var1, var4, var6.field2846, var4 + var5);
					var4 += var6.field2846;
					var5 -= var6.field2846;
				} while(!this.superStream.method1666(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("ad")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method1665(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2846) {
						this.method1694(var3, var2);
						var3.field2846 -= var2;
						break;
					}

					this.method1694(var3, var3.field2846);
					var2 -= var3.field2846;
				} while(!this.superStream.method1666(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(S)I",
		garbageValue = "8192"
	)
	public static int method1690() {
		return ++MouseHandler.MouseHandler_idleCycles - 1;
	}
}