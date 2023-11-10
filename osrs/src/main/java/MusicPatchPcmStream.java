import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mj")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
	@ObfuscatedName("tf")
	@ObfuscatedSignature(
		descriptor = "Lby;"
	)
	@Export("pcmPlayer1")
	static PcmPlayer pcmPlayer1;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lmn;"
	)
	@Export("superStream")
	MidiPcmStream superStream;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lon;"
	)
	@Export("queue")
	NodeDeque queue;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lbn;"
	)
	@Export("mixer")
	PcmStreamMixer mixer;

	@ObfuscatedSignature(
		descriptor = "(Lmn;)V"
	)
	MusicPatchPcmStream(MidiPcmStream var1) {
		this.queue = new NodeDeque();
		this.mixer = new PcmStreamMixer();
		this.superStream = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lmw;[IIIII)V",
		garbageValue = "-1281472428"
	)
	void method1719(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
		if ((this.superStream.field2813[var1.field2872] & 4) != 0 && var1.field2876 < 0) {
			int var6 = this.superStream.field2810[var1.field2872] / PcmPlayer.field179;

			while (true) {
				int var7 = (var6 + 1048575 - var1.field2864) / var6;
				if (var7 > var4) {
					var1.field2864 += var4 * var6;
					break;
				}

				var1.stream.fill(var2, var3, var7);
				var3 += var7;
				var4 -= var7;
				var1.field2864 += var6 * var7 - 1048576;
				int var8 = PcmPlayer.field179 / 100;
				int var9 = 262144 / var6;
				if (var9 < var8) {
					var8 = var9;
				}

				RawPcmStream var10 = var1.stream;
				if (this.superStream.field2815[var1.field2872] == 0) {
					var1.stream = RawPcmStream.method249(var1.rawSound, var10.method264(), var10.method255(), var10.method256());
				} else {
					var1.stream = RawPcmStream.method249(var1.rawSound, var10.method264(), 0, var10.method256());
					this.superStream.method1666(var1, var1.table.field2850[var1.field2873] < 0);
					var1.stream.method260(var8, var10.method255());
				}

				if (var1.table.field2850[var1.field2873] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var10.method262(var8);
				var10.fill(var2, var3, var5 - var3);
				if (var10.method266()) {
					this.mixer.addSubStream(var10);
				}
			}
		}

		var1.stream.fill(var2, var3, var4);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lmw;II)V",
		garbageValue = "-1821439633"
	)
	void method1721(MusicPatchNode var1, int var2) {
		if ((this.superStream.field2813[var1.field2872] & 4) != 0 && var1.field2876 < 0) {
			int var3 = this.superStream.field2810[var1.field2872] / PcmPlayer.field179;
			int var4 = (var3 + 1048575 - var1.field2864) / var3;
			var1.field2864 = var3 * var2 + var1.field2864 & 1048575;
			if (var4 <= var2) {
				if (this.superStream.field2815[var1.field2872] == 0) {
					var1.stream = RawPcmStream.method249(var1.rawSound, var1.stream.method264(), var1.stream.method255(), var1.stream.method256());
				} else {
					var1.stream = RawPcmStream.method249(var1.rawSound, var1.stream.method264(), 0, var1.stream.method256());
					this.superStream.method1666(var1, var1.table.field2850[var1.field2873] < 0);
				}

				if (var1.table.field2850[var1.field2873] < 0) {
					var1.stream.setNumLoops(-1);
				}

				var2 = var1.field2864 / var3;
			}
		}

		var1.stream.skip(var2);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "()Lbk;"
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

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "()Lbk;"
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

	@ObfuscatedName("ac")
	@Export("vmethod5648")
	protected int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("al")
	@Export("fill")
	protected void fill(int[] var1, int var2, int var3) {
		this.mixer.fill(var1, var2, var3);

		for (MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method1688(var6)) {
				int var4 = var2;
				int var5 = var3;

				do {
					if (var5 <= var6.field2865) {
						this.method1719(var6, var1, var4, var5, var5 + var4);
						var6.field2865 -= var5;
						break;
					}

					this.method1719(var6, var1, var4, var6.field2865, var5 + var4);
					var4 += var6.field2865;
					var5 -= var6.field2865;
				} while(!this.superStream.method1689(var6, var1, var4, var5));
			}
		}

	}

	@ObfuscatedName("ap")
	@Export("skip")
	protected void skip(int var1) {
		this.mixer.skip(var1);

		for (MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
			if (!this.superStream.method1688(var3)) {
				int var2 = var1;

				do {
					if (var2 <= var3.field2865) {
						this.method1721(var3, var2);
						var3.field2865 -= var2;
						break;
					}

					this.method1721(var3, var3.field2865);
					var2 -= var3.field2865;
				} while(!this.superStream.method1689(var3, (int[])null, 0, var2));
			}
		}

	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)[B",
		garbageValue = "125922381"
	)
	public static byte[] method1720(CharSequence var0) {
		int var1 = var0.length();
		byte[] var2 = new byte[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			char var4 = var0.charAt(var3);
			if ((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
				if (var4 == 8364) {
					var2[var3] = -128;
				} else if (var4 == 8218) {
					var2[var3] = -126;
				} else if (var4 == 402) {
					var2[var3] = -125;
				} else if (var4 == 8222) {
					var2[var3] = -124;
				} else if (var4 == 8230) {
					var2[var3] = -123;
				} else if (var4 == 8224) {
					var2[var3] = -122;
				} else if (var4 == 8225) {
					var2[var3] = -121;
				} else if (var4 == 710) {
					var2[var3] = -120;
				} else if (var4 == 8240) {
					var2[var3] = -119;
				} else if (var4 == 352) {
					var2[var3] = -118;
				} else if (var4 == 8249) {
					var2[var3] = -117;
				} else if (var4 == 338) {
					var2[var3] = -116;
				} else if (var4 == 381) {
					var2[var3] = -114;
				} else if (var4 == 8216) {
					var2[var3] = -111;
				} else if (var4 == 8217) {
					var2[var3] = -110;
				} else if (var4 == 8220) {
					var2[var3] = -109;
				} else if (var4 == 8221) {
					var2[var3] = -108;
				} else if (var4 == 8226) {
					var2[var3] = -107;
				} else if (var4 == 8211) {
					var2[var3] = -106;
				} else if (var4 == 8212) {
					var2[var3] = -105;
				} else if (var4 == 732) {
					var2[var3] = -104;
				} else if (var4 == 8482) {
					var2[var3] = -103;
				} else if (var4 == 353) {
					var2[var3] = -102;
				} else if (var4 == 8250) {
					var2[var3] = -101;
				} else if (var4 == 339) {
					var2[var3] = -100;
				} else if (var4 == 382) {
					var2[var3] = -98;
				} else if (var4 == 376) {
					var2[var3] = -97;
				} else {
					var2[var3] = 63;
				}
			} else {
				var2[var3] = (byte)var4;
			}
		}

		return var2;
	}
}