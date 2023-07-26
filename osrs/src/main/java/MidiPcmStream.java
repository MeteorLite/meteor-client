import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("bo")
	static AtomicBoolean field2766;
	@ObfuscatedName("br")
	static ThreadPoolExecutor field2765;
	@ObfuscatedName("rb")
	@ObfuscatedSignature(
		descriptor = "Lgf;"
	)
	@Export("mouseWheel")
	static class174 mouseWheel;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lsm;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("ay")
	int field2769;
	@ObfuscatedName("ar")
	int field2768;
	@ObfuscatedName("am")
	int[] field2778;
	@ObfuscatedName("as")
	int[] field2783;
	@ObfuscatedName("aj")
	int[] field2776;
	@ObfuscatedName("ag")
	int[] field2774;
	@ObfuscatedName("az")
	int[] field2786;
	@ObfuscatedName("av")
	int[] field2785;
	@ObfuscatedName("ap")
	int[] field2781;
	@ObfuscatedName("aq")
	int[] field2782;
	@ObfuscatedName("at")
	int[] field2784;
	@ObfuscatedName("ao")
	int[] field2780;
	@ObfuscatedName("ac")
	int[] field2772;
	@ObfuscatedName("ak")
	int[] field2777;
	@ObfuscatedName("an")
	int[] field2779;
	@ObfuscatedName("af")
	int[] field2773;
	@ObfuscatedName("ai")
	int[] field2775;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "[[Lmw;"
	)
	MusicPatchNode[][] field2792;
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "[[Lmw;"
	)
	MusicPatchNode[][] field2793;
	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "Llb;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("bn")
	boolean field2767;
	@ObfuscatedName("ba")
	@Export("track")
	int track;
	@ObfuscatedName("bf")
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("bs")
	long field2790;
	@ObfuscatedName("bp")
	long field2789;
	@ObfuscatedName("bv")
	@ObfuscatedSignature(
		descriptor = "Lmm;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;
	@ObfuscatedName("bq")
	PriorityQueue field2787;
	@ObfuscatedName("bw")
	public int field2795;

	static {
		field2766 = null;
		field2765 = null;
	}

	public MidiPcmStream() {
		this.field2769 = 256;
		this.field2768 = 1000000;
		this.field2778 = new int[16];
		this.field2783 = new int[16];
		this.field2776 = new int[16];
		this.field2774 = new int[16];
		this.field2786 = new int[16];
		this.field2785 = new int[16];
		this.field2781 = new int[16];
		this.field2782 = new int[16];
		this.field2784 = new int[16];
		this.field2780 = new int[16];
		this.field2772 = new int[16];
		this.field2777 = new int[16];
		this.field2779 = new int[16];
		this.field2773 = new int[16];
		this.field2775 = new int[16];
		this.field2792 = new MusicPatchNode[16][128];
		this.field2793 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.field2787 = new PriorityQueue(5, new class317());
		this.field2795 = 0;
		this.musicPatches = new NodeHashTable(128);
		this.method1609();
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "3"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2769 = var1;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1139038647"
	)
	public int method1588() {
		return this.field2769;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lmp;Lnd;Lbh;S)Z",
		garbageValue = "195"
	)
	public synchronized boolean method1589(MusicTrack var1, AbstractArchive var2, SoundCache var3) {
		boolean var4 = true;
		synchronized(this.field2787) {
			this.field2787.clear();
		}

		for (class319 var5 = (class319)var1.field2826.first(); var5 != null; var5 = (class319)var1.field2826.next()) {
			int var12 = (int)var5.key;
			MusicPatch var7 = (MusicPatch)this.musicPatches.get((long)var12);
			if (var7 == null) {
				byte[] var9 = var2.takeFileFlat(var12);
				MusicPatch var8;
				if (var9 == null) {
					var8 = null;
				} else {
					var8 = new MusicPatch(var9);
				}

				var7 = var8;
				if (var8 == null) {
					var4 = false;
					continue;
				}

				this.musicPatches.put(var8, (long)var12);
			}

			if (!var7.method1642(var3, var5.field2861)) {
				var4 = false;
			} else if (this.field2787 != null) {
				synchronized(this.field2787) {
					Iterator var15 = var7.field2816.iterator();

					while (var15.hasNext()) {
						class53 var10 = (class53)var15.next();
						this.field2787.add(new class310(var5.field2860, var10));
					}
				}
			}
		}

		return var4;
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1319222681"
	)
	public void method1590() {
		if (this.field2787 != null) {
			if (field2766 != null) {
				field2766.set(true);
			}

			field2766 = new AtomicBoolean(false);
			AtomicBoolean var1 = field2766;
			if (field2765 == null) {
				int var2 = Runtime.getRuntime().availableProcessors();
				field2765 = new ThreadPoolExecutor(0, var2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new class309(this));
			}

			field2765.submit(new class313(this, var1));
		}
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-59"
	)
	public synchronized void method1591() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "()Lby;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "()Lby;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("az")
	protected synchronized int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("av")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2768 / PcmPlayer.field181;

			do {
				long var5 = (long)var4 * (long)var3 + this.field2790;
				if (this.field2789 - var5 >= 0L) {
					this.field2790 = var5;
					break;
				}

				int var7 = (int)((this.field2789 - this.field2790 + (long)var4 - 1L) / (long)var4);
				this.field2790 += (long)var4 * (long)var7;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method1622();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-80"
	)
	public synchronized void method1592() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("aq")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2768 / PcmPlayer.field181;

			do {
				long var3 = this.field2790 + (long)var1 * (long)var2;
				if (this.field2789 - var3 >= 0L) {
					this.field2790 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field2789 - this.field2790) - 1L) / (long)var2);
				this.field2790 += (long)var2 * (long)var5;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method1622();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lmp;ZI)V",
		garbageValue = "1966762890"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2767 = var2;
		this.field2790 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2789 = this.midiFile.method1636(this.trackLength);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-38"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method1609();
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-53"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-958919488"
	)
	public synchronized boolean method1596() {
		return this.musicPatches.method2430() > 0;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-736064552"
	)
	public synchronized void method1597(int var1, int var2) {
		this.method1598(var1, var2);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1708470262"
	)
	void method1598(int var1, int var2) {
		this.field2774[var1] = var2;
		this.field2785[var1] = var2 & -128;
		this.method1599(var1, var2);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1087105384"
	)
	void method1599(int var1, int var2) {
		if (var2 != this.field2786[var1]) {
			this.field2786[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2793[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "2143768499"
	)
	void method1600(int var1, int var2, int var3) {
		this.method1602(var1, var2, 64);
		if ((this.field2780[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2843 == var1 && var4.field2829 < 0) {
					this.field2792[var1][var4.field2834] = null;
					this.field2792[var1][var2] = var4;
					int var5 = (var4.field2838 * var4.field2837 >> 12) + var4.field2842;
					var4.field2842 += var2 - var4.field2834 << 8;
					var4.field2837 = var5 - var4.field2842;
					var4.field2838 = 4096;
					var4.field2834 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2786[var1]);
		if (var9 != null) {
			if (var9.rawSounds[var2] != null) {
				RawSound var8 = var9.rawSounds[var2].method296();
				if (var8 != null) {
					MusicPatchNode var6 = new MusicPatchNode();
					var6.field2843 = var1;
					var6.table = var9;
					var6.rawSound = var8;
					var6.field2846 = var9.field2817[var2];
					var6.field2839 = var9.field2812[var2];
					var6.field2834 = var2;
					var6.field2832 = var3 * var3 * var9.field2811[var2] * var9.field2814 + 1024 >> 11;
					var6.field2845 = var9.field2810[var2] & 255;
					var6.field2842 = (var2 << 8) - (var9.field2818[var2] & 32767);
					var6.field2840 = 0;
					var6.field2833 = 0;
					var6.field2844 = 0;
					var6.field2829 = -1;
					var6.field2841 = 0;
					if (this.field2779[var1] == 0) {
						var6.stream = RawPcmStream.method240(var8, this.method1614(var6), this.method1615(var6), this.method1616(var6));
					} else {
						var6.stream = RawPcmStream.method240(var8, this.method1614(var6), 0, this.method1616(var6));
						this.method1601(var6, var9.field2818[var2] < 0);
					}

					if (var9.field2818[var2] < 0) {
						var6.stream.setNumLoops(-1);
					}

					if (var6.field2839 >= 0) {
						MusicPatchNode var7 = this.field2793[var1][var6.field2839];
						if (var7 != null && var7.field2829 < 0) {
							this.field2792[var1][var7.field2834] = null;
							var7.field2829 = 0;
						}

						this.field2793[var1][var6.field2839] = var6;
					}

					this.patchStream.queue.addFirst(var6);
					this.field2792[var1][var2] = var6;
				}
			}
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lmw;ZI)V",
		garbageValue = "1613914943"
	)
	void method1601(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field168) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)this.field2779[var1.field2843] * (long)var5 >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method249();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2779[var1.field2843] >> 6);
		}

		var1.stream.method248(var4);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "-1076595045"
	)
	void method1602(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2792[var1][var2];
		if (var4 != null) {
			this.field2792[var1][var2] = null;
			if ((this.field2780[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var4.field2843 == var5.field2843 && var5.field2829 < 0 && var4 != var5) {
						var4.field2829 = 0;
						break;
					}
				}
			} else {
				var4.field2829 = 0;
			}

		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "2035773529"
	)
	void method1603(int var1, int var2, int var3) {
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "105"
	)
	void method1604(int var1, int var2) {
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1823688205"
	)
	void method1605(int var1, int var2) {
		this.field2781[var1] = var2;
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-361813593"
	)
	void method1606(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2843 == var1) {
				if (var2.stream != null) {
					var2.stream.method253(PcmPlayer.field181 / 100);
					if (var2.stream.method257()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method1659();
				}

				if (var2.field2829 < 0) {
					this.field2792[var2.field2843][var2.field2834] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1673747519"
	)
	void method1607(int var1) {
		if (var1 >= 0) {
			this.field2778[var1] = 12800;
			this.field2783[var1] = 8192;
			this.field2776[var1] = 16383;
			this.field2781[var1] = 8192;
			this.field2782[var1] = 0;
			this.field2784[var1] = 8192;
			this.method1610(var1);
			this.method1611(var1);
			this.field2780[var1] = 0;
			this.field2772[var1] = 32767;
			this.field2777[var1] = 256;
			this.field2779[var1] = 0;
			this.method1613(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method1607(var1);
			}

		}
	}

	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-694816578"
	)
	void method1608(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2843 == var1) && var2.field2829 < 0) {
				this.field2792[var2.field2843][var2.field2834] = null;
				var2.field2829 = 0;
			}
		}

	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1070396160"
	)
	void method1609() {
		this.method1606(-1);
		this.method1607(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2786[var1] = this.field2774[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2785[var1] = this.field2774[var1] & -128;
		}

	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1321540000"
	)
	void method1610(int var1) {
		if ((this.field2780[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2843 == var1 && this.field2792[var1][var2.field2834] == null && var2.field2829 < 0) {
					var2.field2829 = 0;
				}
			}
		}

	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2058782045"
	)
	void method1611(int var1) {
		if ((this.field2780[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2843 == var1) {
					var2.field2835 = 0;
				}
			}
		}

	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-76"
	)
	void method1612(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method1602(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method1600(var3, var4, var5);
			} else {
				this.method1602(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method1603(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2785[var3] = (var5 << 14) + (this.field2785[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2785[var3] = (var5 << 7) + (this.field2785[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2782[var3] = (var5 << 7) + (this.field2782[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2782[var3] = var5 + (this.field2782[var3] & -128);
			}

			if (var4 == 5) {
				this.field2784[var3] = (var5 << 7) + (this.field2784[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2784[var3] = var5 + (this.field2784[var3] & -128);
			}

			if (var4 == 7) {
				this.field2778[var3] = (var5 << 7) + (this.field2778[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2778[var3] = var5 + (this.field2778[var3] & -128);
			}

			if (var4 == 10) {
				this.field2783[var3] = (var5 << 7) + (this.field2783[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2783[var3] = var5 + (this.field2783[var3] & -128);
			}

			if (var4 == 11) {
				this.field2776[var3] = (var5 << 7) + (this.field2776[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2776[var3] = var5 + (this.field2776[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2780;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2780;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2780;
					var10000[var3] |= 2;
				} else {
					this.method1610(var3);
					var10000 = this.field2780;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2772[var3] = (var5 << 7) + (this.field2772[var3] & 127);
			}

			if (var4 == 98) {
				this.field2772[var3] = (this.field2772[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2772[var3] = (var5 << 7) + (this.field2772[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2772[var3] = (this.field2772[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method1606(var3);
			}

			if (var4 == 121) {
				this.method1607(var3);
			}

			if (var4 == 123) {
				this.method1608(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2772[var3];
				if (var6 == 16384) {
					this.field2777[var3] = (var5 << 7) + (this.field2777[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2772[var3];
				if (var6 == 16384) {
					this.field2777[var3] = var5 + (this.field2777[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2779[var3] = (var5 << 7) + (this.field2779[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2779[var3] = var5 + (this.field2779[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2780;
					var10000[var3] |= 4;
				} else {
					this.method1611(var3);
					var10000 = this.field2780;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method1613(var3, (var5 << 7) + (this.field2773[var3] & -16257));
			}

			if (var4 == 49) {
				this.method1613(var3, var5 + (this.field2773[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method1599(var3, var4 + this.field2785[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method1604(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method1605(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method1609();
			}
		}
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1175935963"
	)
	void method1613(int var1, int var2) {
		this.field2773[var1] = var2;
		this.field2775[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(Lmw;I)I",
		garbageValue = "389364679"
	)
	int method1614(MusicPatchNode var1) {
		int var2 = (var1.field2838 * var1.field2837 >> 12) + var1.field2842;
		var2 += (this.field2781[var1.field2843] - 8192) * this.field2777[var1.field2843] >> 12;
		MusicPatchNode2 var3 = var1.field2846;
		int var4;
		if (var3.field2750 > 0 && (var3.field2744 > 0 || this.field2782[var1.field2843] > 0)) {
			var4 = var3.field2744 << 2;
			int var5 = var3.field2749 << 1;
			if (var1.field2831 < var5) {
				var4 = var4 * var1.field2831 / var5;
			}

			var4 += this.field2782[var1.field2843] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2830 & 511));
			var2 += (int)((double)var4 * var6);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)PcmPlayer.field181 + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(Lmw;B)I",
		garbageValue = "92"
	)
	int method1615(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2846;
		int var3 = this.field2776[var1.field2843] * this.field2778[var1.field2843] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2832 + 16384 >> 15;
		var3 = var3 * this.field2769 + 128 >> 8;
		if (var2.field2747 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2747 * 1.953125E-5D * (double)var1.field2840) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2742 != null) {
			var4 = var1.field2833;
			var5 = var2.field2742[var1.field2844 + 1];
			if (var1.field2844 < var2.field2742.length - 2) {
				var6 = (var2.field2742[var1.field2844] & 255) << 8;
				var7 = (var2.field2742[var1.field2844 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2742[var1.field2844 + 3] - var5) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field2829 > 0 && var2.field2743 != null) {
			var4 = var1.field2829;
			var5 = var2.field2743[var1.field2841 + 1];
			if (var1.field2841 < var2.field2743.length - 2) {
				var6 = (var2.field2743[var1.field2841] & 255) << 8;
				var7 = (var2.field2743[var1.field2841 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2743[var1.field2841 + 3] - var5) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(Lmw;B)I",
		garbageValue = "5"
	)
	int method1616(MusicPatchNode var1) {
		int var2 = this.field2783[var1.field2843];
		return var2 < 8192 ? var2 * var1.field2845 + 32 >> 6 : 16384 - ((128 - var1.field2845) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("bt")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-128"
	)
	void method1622() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2789; var2 == this.trackLength; var3 = this.midiFile.method1636(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2767 || var2 == 0) {
							this.method1609();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method1612(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2789 = var3;
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(Lmw;I)Z",
		garbageValue = "1539883938"
	)
	boolean method1623(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2829 >= 0) {
				var1.remove();
				if (var1.field2839 > 0 && var1 == this.field2793[var1.field2843][var1.field2839]) {
					this.field2793[var1.field2843][var1.field2839] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(Lmw;[IIIS)Z",
		garbageValue = "20993"
	)
	boolean method1624(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2836 = PcmPlayer.field181 / 100;
		if (var1.field2829 < 0 || var1.stream != null && !var1.stream.method256()) {
			int var5 = var1.field2838;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2784[var1.field2843]) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2838 = var5;
			}

			var1.stream.method254(this.method1614(var1));
			MusicPatchNode2 var6 = var1.field2846;
			boolean var7 = false;
			++var1.field2831;
			var1.field2830 += var6.field2750;
			double var8 = (double)((var1.field2834 - 60 << 8) + (var1.field2838 * var1.field2837 >> 12)) * 5.086263020833333E-6D;
			if (var6.field2747 > 0) {
				if (var6.field2745 > 0) {
					var1.field2840 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2745 * var8) + 0.5D);
				} else {
					var1.field2840 += 128;
				}
			}

			if (var6.field2742 != null) {
				if (var6.field2746 > 0) {
					var1.field2833 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2746 * var8) + 0.5D);
				} else {
					var1.field2833 += 128;
				}

				while (var1.field2844 < var6.field2742.length - 2 && var1.field2833 > (var6.field2742[var1.field2844 + 2] & 255) << 8) {
					var1.field2844 += 2;
				}

				if (var6.field2742.length - 2 == var1.field2844 && var6.field2742[var1.field2844 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2829 >= 0 && var6.field2743 != null && (this.field2780[var1.field2843] & 1) == 0 && (var1.field2839 < 0 || var1 != this.field2793[var1.field2843][var1.field2839])) {
				if (var6.field2748 > 0) {
					var1.field2829 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2748 * var8) + 0.5D);
				} else {
					var1.field2829 += 128;
				}

				while (var1.field2841 < var6.field2743.length - 2 && var1.field2829 > (var6.field2743[var1.field2841 + 2] & 255) << 8) {
					var1.field2841 += 2;
				}

				if (var6.field2743.length - 2 == var1.field2841) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method253(var1.field2836);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method257()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method1659();
				if (var1.field2829 >= 0) {
					var1.remove();
					if (var1.field2839 > 0 && var1 == this.field2793[var1.field2843][var1.field2839]) {
						this.field2793[var1.field2843][var1.field2839] = null;
					}
				}

				return true;
			} else {
				var1.stream.method252(var1.field2836, this.method1615(var1), this.method1616(var1));
				return false;
			}
		} else {
			var1.method1659();
			var1.remove();
			if (var1.field2839 > 0 && var1 == this.field2793[var1.field2843][var1.field2839]) {
				this.field2793[var1.field2843][var1.field2839] = null;
			}

			return true;
		}
	}
}
