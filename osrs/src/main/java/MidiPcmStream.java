import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = -2001840079
	)
	int field3234;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -2000403541
	)
	int field3235;
	@ObfuscatedName("n")
	int[] field3236;
	@ObfuscatedName("k")
	int[] field3237;
	@ObfuscatedName("s")
	int[] field3259;
	@ObfuscatedName("q")
	int[] field3239;
	@ObfuscatedName("m")
	int[] field3252;
	@ObfuscatedName("x")
	int[] field3241;
	@ObfuscatedName("j")
	int[] field3240;
	@ObfuscatedName("v")
	int[] field3238;
	@ObfuscatedName("h")
	int[] field3250;
	@ObfuscatedName("e")
	int[] field3246;
	@ObfuscatedName("g")
	int[] field3247;
	@ObfuscatedName("y")
	int[] field3244;
	@ObfuscatedName("i")
	int[] field3249;
	@ObfuscatedName("r")
	int[] field3233;
	@ObfuscatedName("z")
	int[] field3255;
	@ObfuscatedName("o")
	@ObfuscatedSignature(
		descriptor = "[[Ljb;"
	)
	MusicPatchNode[][] field3251;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "[[Ljb;"
	)
	MusicPatchNode[][] field3253;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ljo;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("ao")
	boolean field3242;
	@ObfuscatedName("ar")
	@ObfuscatedGetter(
		intValue = -440104839
	)
	@Export("track")
	int track;
	@ObfuscatedName("aq")
	@ObfuscatedGetter(
		intValue = 878500507
	)
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("ai")
	@ObfuscatedGetter(
		longValue = 6339965167519115271L
	)
	long field3258;
	@ObfuscatedName("an")
	@ObfuscatedGetter(
		longValue = -9196756782097180817L
	)
	long field3257;
	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "Ljh;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;

	public MidiPcmStream() {
		this.field3234 = 256;
		this.field3235 = 1000000;
		this.field3236 = new int[16];
		this.field3237 = new int[16];
		this.field3259 = new int[16];
		this.field3239 = new int[16];
		this.field3252 = new int[16];
		this.field3241 = new int[16];
		this.field3240 = new int[16];
		this.field3238 = new int[16];
		this.field3250 = new int[16];
		this.field3246 = new int[16];
		this.field3247 = new int[16];
		this.field3244 = new int[16];
		this.field3249 = new int[16];
		this.field3233 = new int[16];
		this.field3255 = new int[16];
		this.field3251 = new MusicPatchNode[16][128];
		this.field3253 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.musicPatches = new NodeHashTable(128);
		this.method5471();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-12"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field3234 = var1;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-7"
	)
	public int method5466() {
		return this.field3234;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Ljd;Llv;Lax;IS)Z",
		garbageValue = "-1601"
	)
	@Export("loadMusicTrack")
	synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
		var1.method5628();
		boolean var5 = true;
		int[] var6 = null;
		if (var4 > 0) {
			var6 = new int[]{var4};
		}

		for (ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
			int var8 = (int)var7.key;
			MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
			if (var9 == null) {
				var9 = class153.method3312(var2, var8);
				if (var9 == null) {
					var5 = false;
					continue;
				}

				this.musicPatches.put(var9, (long)var8);
			}

			if (!var9.method5594(var3, var7.byteArray, var6)) {
				var5 = false;
			}
		}

		if (var5) {
			var1.clear();
		}

		return var5;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1295892604"
	)
	@Export("clearAll")
	synchronized void clearAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1523729927"
	)
	@Export("removeAll")
	public synchronized void removeAll() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("w")
	@ObfuscatedSignature(
		descriptor = "()Lay;"
	)
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("s")
	@ObfuscatedSignature(
		descriptor = "()Lay;"
	)
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("q")
	protected synchronized int vmethod5612() {
		return 0;
	}

	@ObfuscatedName("m")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field3235 * -727379968 / PcmPlayer.field307;

			do {
				long var5 = (long)var3 * (long)var4 + this.field3258;
				if (this.field3257 - var5 >= 0L) {
					this.field3258 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field3257 - this.field3258) - 1L) / (long)var4);
				this.field3258 += (long)var4 * (long)var7;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method5443();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "(Ljd;ZI)V",
		garbageValue = "-436682604"
	)
	@Export("setMusicTrack")
	synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field3242 = var2;
		this.field3258 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field3257 = this.midiFile.method5534(this.trackLength);
	}

	@ObfuscatedName("j")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field3235 * -727379968 / PcmPlayer.field307;

			do {
				long var3 = this.field3258 + (long)var2 * (long)var1;
				if (this.field3257 - var3 >= 0L) {
					this.field3258 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field3257 - this.field3258) - 1L) / (long)var2);
				this.field3258 += (long)var2 * (long)var5;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method5443();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("v")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1036713647"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method5471();
	}

	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "347558801"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("t")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1578445253"
	)
	public synchronized void method5495(int var1, int var2) {
		this.method5419(var1, var2);
	}

	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-816736310"
	)
	void method5419(int var1, int var2) {
		this.field3239[var1] = var2;
		this.field3241[var1] = var2 & -128;
		this.method5420(var1, var2);
	}

	@ObfuscatedName("d")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "796300136"
	)
	void method5420(int var1, int var2) {
		if (var2 != this.field3252[var1]) {
			this.field3252[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field3253[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("b")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "1"
	)
	void method5421(int var1, int var2, int var3) {
		this.method5423(var1, var2, 64);
		if ((this.field3246[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field3303 == var1 && var4.field3300 < 0) {
					this.field3251[var1][var4.field3311] = null;
					this.field3251[var1][var2] = var4;
					int var8 = (var4.field3302 * var4.field3296 >> 12) + var4.field3293;
					var4.field3293 += var2 - var4.field3311 << 8;
					var4.field3302 = var8 - var4.field3293;
					var4.field3296 = 4096;
					var4.field3311 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field3252[var1]);
		if (var9 != null) {
			RawSound var5 = var9.rawSounds[var2];
			if (var5 != null) {
				MusicPatchNode var6 = new MusicPatchNode();
				var6.field3303 = var1;
				var6.patch = var9;
				var6.rawSound = var5;
				var6.field3307 = var9.field3282[var2];
				var6.field3314 = var9.field3281[var2];
				var6.field3311 = var2;
				var6.field3299 = var3 * var3 * var9.field3278[var2] * var9.field3280 + 1024 >> 11;
				var6.field3297 = var9.field3279[var2] & 255;
				var6.field3293 = (var2 << 8) - (var9.field3277[var2] & 32767);
				var6.field3304 = 0;
				var6.field3305 = 0;
				var6.field3306 = 0;
				var6.field3300 = -1;
				var6.field3308 = 0;
				if (this.field3249[var1] == 0) {
					var6.stream = RawPcmStream.method851(var5, this.method5435(var6), this.method5485(var6), this.method5437(var6));
				} else {
					var6.stream = RawPcmStream.method851(var5, this.method5435(var6), 0, this.method5437(var6));
					this.method5422(var6, var9.field3277[var2] < 0);
				}

				if (var9.field3277[var2] < 0) {
					var6.stream.setNumLoops(-1);
				}

				if (var6.field3314 >= 0) {
					MusicPatchNode var7 = this.field3253[var1][var6.field3314];
					if (var7 != null && var7.field3300 < 0) {
						this.field3251[var1][var7.field3311] = null;
						var7.field3300 = 0;
					}

					this.field3253[var1][var6.field3314] = var6;
				}

				this.patchStream.queue.addFirst(var6);
				this.field3251[var1][var2] = var6;
			}
		}
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(Ljb;ZI)V",
		garbageValue = "-208296340"
	)
	void method5422(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field273) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)var5 * (long)this.field3249[var1.field3303] >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method857();
			}
		} else {
			var4 = (int)((long)this.field3249[var1.field3303] * (long)var3 >> 6);
		}

		var1.stream.method859(var4);
	}

	@ObfuscatedName("l")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "180177235"
	)
	void method5423(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field3251[var1][var2];
		if (var4 != null) {
			this.field3251[var1][var2] = null;
			if ((this.field3246[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field3303 == var4.field3303 && var5.field3300 < 0 && var4 != var5) {
						var4.field3300 = 0;
						break;
					}
				}
			} else {
				var4.field3300 = 0;
			}

		}
	}

	@ObfuscatedName("e")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "-12"
	)
	void method5418(int var1, int var2, int var3) {
	}

	@ObfuscatedName("g")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-417707249"
	)
	void method5425(int var1, int var2) {
	}

	@ObfuscatedName("y")
	@ObfuscatedSignature(
		descriptor = "(IIS)V",
		garbageValue = "-7325"
	)
	void method5426(int var1, int var2) {
		this.field3240[var1] = var2;
	}

	@ObfuscatedName("i")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "5"
	)
	void method5427(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field3303 == var1) {
				if (var2.stream != null) {
					var2.stream.method864(PcmPlayer.field307 / 100);
					if (var2.stream.method892()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method5640();
				}

				if (var2.field3300 < 0) {
					this.field3251[var2.field3303][var2.field3311] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("r")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-10"
	)
	void method5441(int var1) {
		if (var1 >= 0) {
			this.field3236[var1] = 12800;
			this.field3237[var1] = 8192;
			this.field3259[var1] = 16383;
			this.field3240[var1] = 8192;
			this.field3238[var1] = 0;
			this.field3250[var1] = 8192;
			this.method5431(var1);
			this.method5510(var1);
			this.field3246[var1] = 0;
			this.field3247[var1] = 32767;
			this.field3244[var1] = 256;
			this.field3249[var1] = 0;
			this.method5434(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method5441(var1);
			}

		}
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "43"
	)
	void method5450(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field3303 == var1) && var2.field3300 < 0) {
				this.field3251[var2.field3303][var2.field3311] = null;
				var2.field3300 = 0;
			}
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "949461344"
	)
	void method5471() {
		this.method5427(-1);
		this.method5441(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field3252[var1] = this.field3239[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field3241[var1] = this.field3239[var1] & -128;
		}

	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "557355510"
	)
	void method5431(int var1) {
		if ((this.field3246[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field3303 == var1 && this.field3251[var1][var2.field3311] == null && var2.field3300 < 0) {
					var2.field3300 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1460947216"
	)
	void method5510(int var1) {
		if ((this.field3246[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field3303 == var1) {
					var2.field3313 = 0;
				}
			}
		}

	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "19292"
	)
	void method5433(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method5423(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method5421(var3, var4, var5);
			} else {
				this.method5423(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method5418(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field3241[var3] = (var5 << 14) + (this.field3241[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field3241[var3] = (var5 << 7) + (this.field3241[var3] & -16257);
			}

			if (var4 == 1) {
				this.field3238[var3] = (var5 << 7) + (this.field3238[var3] & -16257);
			}

			if (var4 == 33) {
				this.field3238[var3] = var5 + (this.field3238[var3] & -128);
			}

			if (var4 == 5) {
				this.field3250[var3] = (var5 << 7) + (this.field3250[var3] & -16257);
			}

			if (var4 == 37) {
				this.field3250[var3] = var5 + (this.field3250[var3] & -128);
			}

			if (var4 == 7) {
				this.field3236[var3] = (var5 << 7) + (this.field3236[var3] & -16257);
			}

			if (var4 == 39) {
				this.field3236[var3] = var5 + (this.field3236[var3] & -128);
			}

			if (var4 == 10) {
				this.field3237[var3] = (var5 << 7) + (this.field3237[var3] & -16257);
			}

			if (var4 == 42) {
				this.field3237[var3] = var5 + (this.field3237[var3] & -128);
			}

			if (var4 == 11) {
				this.field3259[var3] = (var5 << 7) + (this.field3259[var3] & -16257);
			}

			if (var4 == 43) {
				this.field3259[var3] = var5 + (this.field3259[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field3246;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field3246;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field3246;
					var10000[var3] |= 2;
				} else {
					this.method5431(var3);
					var10000 = this.field3246;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field3247[var3] = (var5 << 7) + (this.field3247[var3] & 127);
			}

			if (var4 == 98) {
				this.field3247[var3] = (this.field3247[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field3247[var3] = (var5 << 7) + (this.field3247[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field3247[var3] = (this.field3247[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method5427(var3);
			}

			if (var4 == 121) {
				this.method5441(var3);
			}

			if (var4 == 123) {
				this.method5450(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field3247[var3];
				if (var6 == 16384) {
					this.field3244[var3] = (var5 << 7) + (this.field3244[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field3247[var3];
				if (var6 == 16384) {
					this.field3244[var3] = var5 + (this.field3244[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field3249[var3] = (var5 << 7) + (this.field3249[var3] & -16257);
			}

			if (var4 == 48) {
				this.field3249[var3] = var5 + (this.field3249[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field3246;
					var10000[var3] |= 4;
				} else {
					this.method5510(var3);
					var10000 = this.field3246;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method5434(var3, (var5 << 7) + (this.field3233[var3] & -16257));
			}

			if (var4 == 49) {
				this.method5434(var3, var5 + (this.field3233[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method5420(var3, var4 + this.field3241[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method5425(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method5426(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method5471();
			}
		}
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "23"
	)
	void method5434(int var1, int var2) {
		this.field3233[var1] = var2;
		this.field3255[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Ljb;I)I",
		garbageValue = "-663837148"
	)
	int method5435(MusicPatchNode var1) {
		int var2 = (var1.field3296 * var1.field3302 >> 12) + var1.field3293;
		var2 += (this.field3240[var1.field3303] - 8192) * this.field3244[var1.field3303] >> 12;
		MusicPatchNode2 var3 = var1.field3307;
		int var4;
		if (var3.field3218 > 0 && (var3.field3214 > 0 || this.field3238[var1.field3303] > 0)) {
			var4 = var3.field3214 << 2;
			int var5 = var3.field3222 << 1;
			if (var1.field3309 < var5) {
				var4 = var4 * var1.field3309 / var5;
			}

			var4 += this.field3238[var1.field3303] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field3295 & 511));
			var2 += (int)(var6 * (double)var4);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)PcmPlayer.field307 + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(Ljb;B)I",
		garbageValue = "-35"
	)
	int method5485(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field3307;
		int var3 = this.field3236[var1.field3303] * this.field3259[var1.field3303] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field3299 + 16384 >> 15;
		var3 = var3 * this.field3234 + 128 >> 8;
		if (var2.field3213 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field3304 * 1.953125E-5D * (double)var2.field3213) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field3219 != null) {
			var4 = var1.field3305;
			var5 = var2.field3219[var1.field3306 * 4 + 1];
			if (var1.field3306 * 4 < var2.field3219.length - 2) {
				var6 = (var2.field3219[var1.field3306 * 4] & 255) << 8;
				var7 = (var2.field3219[var1.field3306 * 4 + 2] & 255) << 8;
				var5 += (var2.field3219[var1.field3306 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field3300 > 0 && var2.field3212 != null) {
			var4 = var1.field3300;
			var5 = var2.field3212[var1.field3308 * 4 + 1];
			if (var1.field3308 * 4 < var2.field3212.length - 2) {
				var6 = (var2.field3212[var1.field3308 * 4] & 255) << 8;
				var7 = (var2.field3212[var1.field3308 * 4 + 2] & 255) << 8;
				var5 += (var2.field3212[var1.field3308 * 4 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Ljb;I)I",
		garbageValue = "1147471590"
	)
	int method5437(MusicPatchNode var1) {
		int var2 = this.field3237[var1.field3303];
		return var2 < 8192 ? var2 * var1.field3297 + 32 >> 6 : 16384 - ((128 - var1.field3297) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2061183473"
	)
	void method5443() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field3257; var2 == this.trackLength; var3 = this.midiFile.method5534(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field3242 || var2 == 0) {
							this.method5471();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method5433(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field3257 = var3;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Ljb;B)Z",
		garbageValue = "91"
	)
	boolean method5448(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field3300 >= 0) {
				var1.remove();
				if (var1.field3314 > 0 && var1 == this.field3253[var1.field3303][var1.field3314]) {
					this.field3253[var1.field3303][var1.field3314] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(Ljb;[IIII)Z",
		garbageValue = "1090173342"
	)
	boolean method5445(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field3312 = PcmPlayer.field307 / 100;
		if (var1.field3300 < 0 || var1.stream != null && !var1.stream.method867()) {
			int var5 = var1.field3296;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field3250[var1.field3303]) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field3296 = var5;
			}

			var1.stream.method903(this.method5435(var1));
			MusicPatchNode2 var6 = var1.field3307;
			boolean var7 = false;
			++var1.field3309;
			var1.field3295 += var6.field3218;
			double var8 = 5.086263020833333E-6D * (double)((var1.field3311 - 60 << 8) + (var1.field3302 * var1.field3296 >> 12));
			if (var6.field3213 > 0) {
				if (var6.field3216 > 0) {
					var1.field3304 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3216) + 0.5D);
				} else {
					var1.field3304 += 128;
				}
			}

			if (var6.field3219 != null) {
				if (var6.field3217 > 0) {
					var1.field3305 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field3217) + 0.5D);
				} else {
					var1.field3305 += 128;
				}

				while (var1.field3306 * 4 < var6.field3219.length - 2 && var1.field3305 > (var6.field3219[var1.field3306 * 4 + 2] & 255) << 8) {
					var1.field3306 = var1.field3306 * 4 + 2;
				}

				if (var1.field3306 * 4 == var6.field3219.length - 2 && var6.field3219[var1.field3306 * 4 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field3300 >= 0 && var6.field3212 != null && (this.field3246[var1.field3303] & 1) == 0 && (var1.field3314 < 0 || var1 != this.field3253[var1.field3303][var1.field3314])) {
				if (var6.field3211 > 0) {
					var1.field3300 += (int)(128.0D * Math.pow(2.0D, (double)var6.field3211 * var8) + 0.5D);
				} else {
					var1.field3300 += 128;
				}

				while (var1.field3308 * 4 < var6.field3212.length - 2 && var1.field3300 > (var6.field3212[var1.field3308 * 4 + 2] & 255) << 8) {
					var1.field3308 = var1.field3308 * 4 + 2;
				}

				if (var1.field3308 * 4 == var6.field3212.length - 2) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method864(var1.field3312);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method892()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method5640();
				if (var1.field3300 >= 0) {
					var1.remove();
					if (var1.field3314 > 0 && var1 == this.field3253[var1.field3303][var1.field3314]) {
						this.field3253[var1.field3303][var1.field3314] = null;
					}
				}

				return true;
			} else {
				var1.stream.method863(var1.field3312, this.method5485(var1), this.method5437(var1));
				return false;
			}
		} else {
			var1.method5640();
			var1.remove();
			if (var1.field3314 > 0 && var1 == this.field3253[var1.field3303][var1.field3314]) {
				this.field3253[var1.field3303][var1.field3314] = null;
			}

			return true;
		}
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/CharSequence;I)I",
		garbageValue = "121575723"
	)
	public static int method5532(CharSequence var0) {
		return Calendar.method5674(var0, 10, true);
	}

	@ObfuscatedName("kz")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1091184200"
	)
	static boolean method5533() {
		return Client.tapToDrop || KeyHandler.KeyHandler_pressedKeys[81];
	}
}
