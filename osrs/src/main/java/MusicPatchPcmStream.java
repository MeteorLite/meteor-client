import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mm")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Llc;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lod;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lbe;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		descriptor = "(Llc;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lmw;[IIIIB)V",
		garbageValue = "106"
	)
	void method1654(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2780[var1.field2843] & 4) != 0 && var1.field2829 < 0) {
			int var6 = this.superStream.field2775[var1.field2843] / PcmPlayer.field181;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2835) / var6;
				if (var7 > var4) {
					var1.field2835 += var6 * var4;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2835 += var7 * var6 - 1048576;
				int var8 = PcmPlayer.field181 / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2779[var1.field2843] == 0) {
					var1.stream = RawPcmStream.method240(var1.rawSound, var10.method255(), var10.method246(), var10.method247());
				} else {
					var1.stream = RawPcmStream.method240(var1.rawSound, var10.method255(), 0, var10.method247());
					this.superStream.method1601(var1, var1.table.field2818[var1.field2834] < 0);
					var1.stream.method251(var8, var10.method246());
				}

				if (var1.table.field2818[var1.field2834] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method253(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method257()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lmw;IB)V",
		garbageValue = "1"
	)
	void method1655(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2780[var1.field2843] & 4) != 0 && var1.field2829 < 0) {
			int var3 = this.superStream.field2775[var1.field2843] / PcmPlayer.field181;
			int var4 = (var3 + 1048575 - var1.field2835) / var3;
			var1.field2835 = var3 * var2 + var1.field2835 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2779[var1.field2843] == 0) {
					var1.stream = RawPcmStream.method240(var1.rawSound, var1.stream.method255(), var1.stream.method246(), var1.stream.method247());
				} else {
					var1.stream = RawPcmStream.method240(var1.rawSound, var1.stream.method255(), 0, var1.stream.method247());
					this.superStream.method1601(var1, var1.table.field2818[var1.field2834] < 0);
				}

				if (var1.table.field2818[var1.field2834] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2835 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "()Lby;"
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

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "()Lby;"
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

	@ObfuscatedName("az")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("av")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method1623(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2836) {
						this.method1654(var6, var1, var4, var5, var4 + var5);
						var6.field2836 -= var5;
						break;
					}

					this.method1654(var6, var1, var4, var6.field2836, var5 + var4);
					var4 += var6.field2836;
					var5 -= var6.field2836;
				} while(!this.superStream.method1624(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("aq")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method1623(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2836) {
						this.method1655(var3, var2);
						var3.field2836 -= var2;
						break;
					}

					this.method1655(var3, var3.field2836);
					var2 -= var3.field2836;
				} while(!this.superStream.method1624(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;S)Ljava/lang/String;",
		garbageValue = "-15982"
	)
	public static String method1652(CharSequence var0) {
		long var3 = 0L;
		int var5 = var0.length();

		for (int var6 = 0; var6 < var5; ++var6) {
			var3 *= 37L;
			char var7 = var0.charAt(var6);
			if (var7 >= 'A' && var7 <= 'Z') {
				var3 += (long)(var7 + 1 - 65);
			} else if (var7 >= 'a' && var7 <= 'z') {
				var3 += (long)(var7 + 1 - 97);
			} else if (var7 >= '0' && var7 <= '9') {
				var3 += (long)(var7 + 27 - 48);
			}

			if (var3 >= 177917621779460413L) {
				break;
			}
		}

		while (0L == var3 % 37L && var3 != 0L) {
			var3 /= 37L;
		}

		String var8 = class170.base37DecodeLong(var3);
		if (var8 == null) {
			var8 = "";
		}

		return var8;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(II)Ljava/lang/String;",
		garbageValue = "-1653228105"
	)
	@Export("colorStartTag")
	static String colorStartTag(int var0) {
		return "<col=" + Integer.toHexString(var0) + ">";
	}
}
