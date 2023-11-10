import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@ObfuscatedName("mn")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("wg")
	@ObfuscatedSignature(
		descriptor = "Los;"
	)
	public static class381 field2799;
	@ObfuscatedName("bp")
	static AtomicBoolean field2801;
	@ObfuscatedName("bw")
	static ThreadPoolExecutor field2800;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ltw;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("ah")
	int field2803;
	@ObfuscatedName("ar")
	int field2804;
	@ObfuscatedName("ao")
	int[] field2816;
	@ObfuscatedName("ab")
	int[] field2808;
	@ObfuscatedName("au")
	int[] field2818;
	@ObfuscatedName("aa")
	int[] field2807;
	@ObfuscatedName("ac")
	int[] field2809;
	@ObfuscatedName("al")
	int[] field2814;
	@ObfuscatedName("az")
	int[] field2821;
	@ObfuscatedName("ap")
	int[] field2817;
	@ObfuscatedName("av")
	int[] field2819;
	@ObfuscatedName("ai")
	int[] field2813;
	@ObfuscatedName("aw")
	int[] field2820;
	@ObfuscatedName("ae")
	int[] field2811;
	@ObfuscatedName("an")
	int[] field2815;
	@ObfuscatedName("ag")
	int[] field2812;
	@ObfuscatedName("ad")
	int[] field2810;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "[[Lmw;"
	)
	MusicPatchNode[][] field2826;
	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "[[Lmw;"
	)
	MusicPatchNode[][] field2827;
	@ObfuscatedName("bd")
	@ObfuscatedSignature(
		descriptor = "Lmx;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("bl")
	boolean field2802;
	@ObfuscatedName("bi")
	@Export("track")
	int track;
	@ObfuscatedName("bv")
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("bf")
	long field2823;
	@ObfuscatedName("bg")
	long field2824;
	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "Lmj;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;
	@ObfuscatedName("bm")
	PriorityQueue field2822;
	@ObfuscatedName("bj")
	public int field2830;

	static {
		field2801 = null;
		field2800 = null;
	}

	public MidiPcmStream() {
		this.field2803 = 256;
		this.field2804 = 1000000;
		this.field2816 = new int[16];
		this.field2808 = new int[16];
		this.field2818 = new int[16];
		this.field2807 = new int[16];
		this.field2809 = new int[16];
		this.field2814 = new int[16];
		this.field2821 = new int[16];
		this.field2817 = new int[16];
		this.field2819 = new int[16];
		this.field2813 = new int[16];
		this.field2820 = new int[16];
		this.field2811 = new int[16];
		this.field2815 = new int[16];
		this.field2812 = new int[16];
		this.field2810 = new int[16];
		this.field2826 = new MusicPatchNode[16][128];
		this.field2827 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.field2822 = new PriorityQueue(5, new class327());
		this.field2830 = 0;
		this.musicPatches = new NodeHashTable(128);
		this.method1674();
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-19"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2803 = var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "30"
	)
	public int method1653() {
		return this.field2803;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(Lms;Lol;Lbc;I)Z",
		garbageValue = "289790936"
	)
	public synchronized boolean method1654(MusicTrack var1, AbstractArchive var2, SoundCache var3) {
		boolean var4 = true;
		synchronized(this.field2822) {
			this.field2822.clear();
		}

		for (class329 var5 = (class329)var1.field2857.first(); var5 != null; var5 = (class329)var1.field2857.next()) {
			int var12 = (int)var5.key;
			MusicPatch var7 = (MusicPatch)this.musicPatches.get((long)var12);
			if (var7 == null) {
				var7 = LoginScreenAnimation.method521(var2, var12);
				if (var7 == null) {
					var4 = false;
					continue;
				}

				this.musicPatches.put(var7, (long)var12);
			}

			if (!var7.method1710(var3, var5.field2894)) {
				var4 = false;
			} else if (this.field2822 != null) {
				synchronized(this.field2822) {
					Iterator var9 = var7.field2848.iterator();

					while (var9.hasNext()) {
						class53 var10 = (class53)var9.next();
						this.field2822.add(new class320(var5.field2893, var10));
					}
				}
			}
		}

		return var4;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "121"
	)
	public void method1655() {
		if (this.field2822 != null) {
			if (field2801 != null) {
				field2801.set(true);
			}

			field2801 = new AtomicBoolean(false);
			AtomicBoolean var1 = field2801;
			if (field2800 == null) {
				int var2 = Runtime.getRuntime().availableProcessors();
				field2800 = new ThreadPoolExecutor(0, var2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new class319(this));
			}

			field2800.submit(new class323(this, var1));
		}
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1842485318"
	)
	public synchronized void method1656() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "()Lbk;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "()Lbk;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("ac")
	protected synchronized int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("al")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2804 / PcmPlayer.field179;

			do {
				long var5 = (long)var3 * (long)var4 + this.field2823;
				if (this.field2824 - var5 >= 0L) {
					this.field2823 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field2824 - this.field2823) - 1L) / (long)var4);
				this.field2823 += (long)var4 * (long)var7;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method1687();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-64"
	)
	public synchronized void method1657() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("ap")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2804 / PcmPlayer.field179;

			do {
				long var3 = (long)var1 * (long)var2 + this.field2823;
				if (this.field2824 - var3 >= 0L) {
					this.field2823 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field2824 - this.field2823) - 1L) / (long)var2);
				this.field2823 += (long)var2 * (long)var5;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method1687();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Lms;ZI)V",
		garbageValue = "-624556623"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2802 = var2;
		this.field2823 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2824 = this.midiFile.method1701(this.trackLength);
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "84"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method1674();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "2096879002"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(S)Z",
		garbageValue = "26568"
	)
	public synchronized boolean method1661() {
		return this.musicPatches.method2468() > 0;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-438742560"
	)
	public synchronized void method1662(int var1, int var2) {
		this.method1663(var1, var2);
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "31"
	)
	void method1663(int var1, int var2) {
		this.field2807[var1] = var2;
		this.field2814[var1] = var2 & -128;
		this.method1664(var1, var2);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "39"
	)
	void method1664(int var1, int var2) {
		if (var2 != this.field2809[var1]) {
			this.field2809[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2827[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "123"
	)
	void method1665(int var1, int var2, int var3) {
		this.method1667(var1, var2, 64);
		if ((this.field2813[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2872 == var1 && var4.field2876 < 0) {
					this.field2826[var1][var4.field2873] = null;
					this.field2826[var1][var2] = var4;
					int var5 = (var4.field2877 * var4.field2870 >> 12) + var4.field2868;
					var4.field2868 += var2 - var4.field2873 << 8;
					var4.field2877 = var5 - var4.field2868;
					var4.field2870 = 4096;
					var4.field2873 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2809[var1]);
		if (var9 != null) {
			if (var9.rawSounds[var2] != null) {
				RawSound var8 = var9.rawSounds[var2].method305();
				if (var8 != null) {
					MusicPatchNode var6 = new MusicPatchNode();
					var6.field2872 = var1;
					var6.table = var9;
					var6.rawSound = var8;
					var6.field2878 = var9.field2849[var2];
					var6.field2862 = var9.field2843[var2];
					var6.field2873 = var2;
					var6.field2861 = var3 * var3 * var9.field2842[var2] * var9.field2846 + 1024 >> 11;
					var6.field2863 = var9.field2844[var2] & 255;
					var6.field2868 = (var2 << 8) - (var9.field2850[var2] & 32767);
					var6.field2874 = 0;
					var6.field2875 = 0;
					var6.field2871 = 0;
					var6.field2876 = -1;
					var6.field2867 = 0;
					if (this.field2815[var1] == 0) {
						var6.stream = RawPcmStream.method249(var8, this.method1679(var6), this.method1680(var6), this.method1681(var6));
					} else {
						var6.stream = RawPcmStream.method249(var8, this.method1679(var6), 0, this.method1681(var6));
						this.method1666(var6, var9.field2850[var2] < 0);
					}

					if (var9.field2850[var2] < 0) {
						var6.stream.setNumLoops(-1);
					}

					if (var6.field2862 >= 0) {
						MusicPatchNode var7 = this.field2827[var1][var6.field2862];
						if (var7 != null && var7.field2876 < 0) {
							this.field2826[var1][var7.field2873] = null;
							var7.field2876 = 0;
						}

						this.field2827[var1][var6.field2862] = var6;
					}

					this.patchStream.queue.addFirst(var6);
					this.field2826[var1][var2] = var6;
				}
			}
		}
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Lmw;ZB)V",
		garbageValue = "8"
	)
	void method1666(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field165) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)this.field2815[var1.field2872] * (long)var5 >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method258();
			}
		} else {
			var4 = (int)((long)this.field2815[var1.field2872] * (long)var3 >> 6);
		}

		var1.stream.method257(var4);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "-1277420327"
	)
	void method1667(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2826[var1][var2];
		if (var4 != null) {
			this.field2826[var1][var2] = null;
			if ((this.field2813[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2872 == var4.field2872 && var5.field2876 < 0 && var5 != var4) {
						var4.field2876 = 0;
						break;
					}
				}
			} else {
				var4.field2876 = 0;
			}

		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(IIIB)V",
		garbageValue = "-84"
	)
	void method1668(int var1, int var2, int var3) {
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "0"
	)
	void method1669(int var1, int var2) {
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IIS)V",
		garbageValue = "-5960"
	)
	void method1670(int var1, int var2) {
		this.field2821[var1] = var2;
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2098056782"
	)
	void method1671(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2872 == var1) {
				if (var2.stream != null) {
					var2.stream.method262(PcmPlayer.field179 / 100);
					if (var2.stream.method266()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method1724();
				}

				if (var2.field2876 < 0) {
					this.field2826[var2.field2872][var2.field2873] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "1"
	)
	void method1672(int var1) {
		if (var1 >= 0) {
			this.field2816[var1] = 12800;
			this.field2808[var1] = 8192;
			this.field2818[var1] = 16383;
			this.field2821[var1] = 8192;
			this.field2817[var1] = 0;
			this.field2819[var1] = 8192;
			this.method1675(var1);
			this.method1676(var1);
			this.field2813[var1] = 0;
			this.field2820[var1] = 32767;
			this.field2811[var1] = 256;
			this.field2815[var1] = 0;
			this.method1678(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method1672(var1);
			}

		}
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-2027347232"
	)
	void method1673(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2872 == var1) && var2.field2876 < 0) {
				this.field2826[var2.field2872][var2.field2873] = null;
				var2.field2876 = 0;
			}
		}

	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "3235279"
	)
	void method1674() {
		this.method1671(-1);
		this.method1672(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2809[var1] = this.field2807[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2814[var1] = this.field2807[var1] & -128;
		}

	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "936925077"
	)
	void method1675(int var1) {
		if ((this.field2813[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2872 == var1 && this.field2826[var1][var2.field2873] == null && var2.field2876 < 0) {
					var2.field2876 = 0;
				}
			}
		}

	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "31"
	)
	void method1676(int var1) {
		if ((this.field2813[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2872 == var1) {
					var2.field2864 = 0;
				}
			}
		}

	}

	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1011808650"
	)
	void method1677(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method1667(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method1665(var3, var4, var5);
			} else {
				this.method1667(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method1668(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2814[var3] = (var5 << 14) + (this.field2814[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2814[var3] = (var5 << 7) + (this.field2814[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2817[var3] = (var5 << 7) + (this.field2817[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2817[var3] = var5 + (this.field2817[var3] & -128);
			}

			if (var4 == 5) {
				this.field2819[var3] = (var5 << 7) + (this.field2819[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2819[var3] = var5 + (this.field2819[var3] & -128);
			}

			if (var4 == 7) {
				this.field2816[var3] = (var5 << 7) + (this.field2816[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2816[var3] = var5 + (this.field2816[var3] & -128);
			}

			if (var4 == 10) {
				this.field2808[var3] = (var5 << 7) + (this.field2808[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2808[var3] = var5 + (this.field2808[var3] & -128);
			}

			if (var4 == 11) {
				this.field2818[var3] = (var5 << 7) + (this.field2818[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2818[var3] = var5 + (this.field2818[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2813;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2813;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2813;
					var10000[var3] |= 2;
				} else {
					this.method1675(var3);
					var10000 = this.field2813;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2820[var3] = (var5 << 7) + (this.field2820[var3] & 127);
			}

			if (var4 == 98) {
				this.field2820[var3] = (this.field2820[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2820[var3] = (var5 << 7) + (this.field2820[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2820[var3] = (this.field2820[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method1671(var3);
			}

			if (var4 == 121) {
				this.method1672(var3);
			}

			if (var4 == 123) {
				this.method1673(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2820[var3];
				if (var6 == 16384) {
					this.field2811[var3] = (var5 << 7) + (this.field2811[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2820[var3];
				if (var6 == 16384) {
					this.field2811[var3] = var5 + (this.field2811[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2815[var3] = (var5 << 7) + (this.field2815[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2815[var3] = var5 + (this.field2815[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2813;
					var10000[var3] |= 4;
				} else {
					this.method1676(var3);
					var10000 = this.field2813;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method1678(var3, (var5 << 7) + (this.field2812[var3] & -16257));
			}

			if (var4 == 49) {
				this.method1678(var3, var5 + (this.field2812[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method1664(var3, var4 + this.field2814[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method1669(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method1670(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method1674();
			}
		}
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "23"
	)
	void method1678(int var1, int var2) {
		this.field2812[var1] = var2;
		this.field2810[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
	}

	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "(Lmw;I)I",
		garbageValue = "2086193831"
	)
	int method1679(MusicPatchNode var1) {
		int var2 = (var1.field2877 * var1.field2870 >> 12) + var1.field2868;
		var2 += (this.field2821[var1.field2872] - 8192) * this.field2811[var1.field2872] >> 12;
		MusicPatchNode2 var3 = var1.field2878;
		int var4;
		if (var3.field2782 > 0 && (var3.field2780 > 0 || this.field2817[var1.field2872] > 0)) {
			var4 = var3.field2780 << 2;
			int var5 = var3.field2783 << 1;
			if (var1.field2866 < var5) {
				var4 = var4 * var1.field2866 / var5;
			}

			var4 += this.field2817[var1.field2872] >> 7;
			double var6 = Math.sin((double)(var1.field2869 & 511) * 0.01227184630308513D);
			var2 += (int)((double)var4 * var6);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)PcmPlayer.field179 + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(Lmw;B)I",
		garbageValue = "-88"
	)
	int method1680(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2878;
		int var3 = this.field2816[var1.field2872] * this.field2818[var1.field2872] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2861 + 16384 >> 15;
		var3 = var3 * this.field2803 + 128 >> 8;
		if (var2.field2785 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field2874 * (double)var2.field2785) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2779 != null) {
			var4 = var1.field2875;
			var5 = var2.field2779[var1.field2871 + 1];
			if (var1.field2871 < var2.field2779.length - 2) {
				var6 = (var2.field2779[var1.field2871] & 255) << 8;
				var7 = (var2.field2779[var1.field2871 + 2] & 255) << 8;
				var5 += (var2.field2779[var1.field2871 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		if (var1.field2876 > 0 && var2.field2778 != null) {
			var4 = var1.field2876;
			var5 = var2.field2778[var1.field2867 + 1];
			if (var1.field2867 < var2.field2778.length - 2) {
				var6 = (var2.field2778[var1.field2867] & 255) << 8;
				var7 = (var2.field2778[var1.field2867 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2778[var1.field2867 + 3] - var5) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(Lmw;B)I",
		garbageValue = "-7"
	)
	int method1681(MusicPatchNode var1) {
		int var2 = this.field2808[var1.field2872];
		return var2 < 8192 ? var2 * var1.field2863 + 32 >> 6 : 16384 - ((128 - var1.field2863) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("cf")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1708238703"
	)
	void method1687() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2824; var2 == this.trackLength; var3 = this.midiFile.method1701(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2802 || var2 == 0) {
							this.method1674();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method1677(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2824 = var3;
	}

	@ObfuscatedName("cg")
	@ObfuscatedSignature(
		descriptor = "(Lmw;I)Z",
		garbageValue = "1582725415"
	)
	boolean method1688(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2876 >= 0) {
				var1.remove();
				if (var1.field2862 > 0 && var1 == this.field2827[var1.field2872][var1.field2862]) {
					this.field2827[var1.field2872][var1.field2862] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("cv")
	@ObfuscatedSignature(
		descriptor = "(Lmw;[IIII)Z",
		garbageValue = "1206952354"
	)
	boolean method1689(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2865 = PcmPlayer.field179 / 100;
		if (var1.field2876 < 0 || var1.stream != null && !var1.stream.method265()) {
			int var5 = var1.field2870;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2819[var1.field2872] * 4.921259842519685E-4D) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2870 = var5;
			}

			var1.stream.method263(this.method1679(var1));
			MusicPatchNode2 var6 = var1.field2878;
			boolean var7 = false;
			++var1.field2866;
			var1.field2869 += var6.field2782;
			double var8 = (double)((var1.field2873 - 60 << 8) + (var1.field2877 * var1.field2870 >> 12)) * 5.086263020833333E-6D;
			if (var6.field2785 > 0) {
				if (var6.field2786 > 0) {
					var1.field2874 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2786 * var8) + 0.5D);
				} else {
					var1.field2874 += 128;
				}
			}

			if (var6.field2779 != null) {
				if (var6.field2784 > 0) {
					var1.field2875 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2784 * var8) + 0.5D);
				} else {
					var1.field2875 += 128;
				}

				while (var1.field2871 < var6.field2779.length - 2 && var1.field2875 > (var6.field2779[var1.field2871 + 2] & 255) << 8) {
					var1.field2871 += 2;
				}

				if (var6.field2779.length - 2 == var1.field2871 && var6.field2779[var1.field2871 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2876 >= 0 && var6.field2778 != null && (this.field2813[var1.field2872] & 1) == 0 && (var1.field2862 < 0 || var1 != this.field2827[var1.field2872][var1.field2862])) {
				if (var6.field2781 > 0) {
					var1.field2876 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2781 * var8) + 0.5D);
				} else {
					var1.field2876 += 128;
				}

				while (var1.field2867 < var6.field2778.length - 2 && var1.field2876 > (var6.field2778[var1.field2867 + 2] & 255) << 8) {
					var1.field2867 += 2;
				}

				if (var6.field2778.length - 2 == var1.field2867) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method262(var1.field2865);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method266()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method1724();
				if (var1.field2876 >= 0) {
					var1.remove();
					if (var1.field2862 > 0 && var1 == this.field2827[var1.field2872][var1.field2862]) {
						this.field2827[var1.field2872][var1.field2862] = null;
					}
				}

				return true;
			} else {
				var1.stream.method261(var1.field2865, this.method1680(var1), this.method1681(var1));
				return false;
			}
		} else {
			var1.method1724();
			var1.remove();
			if (var1.field2862 > 0 && var1 == this.field2827[var1.field2872][var1.field2862]) {
				this.field2827[var1.field2872][var1.field2862] = null;
			}

			return true;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1188911227"
	)
	static void method1651() {
		Tiles.Tiles_minPlane = 99;
		class74.Tiles_underlays = new short[4][104][104];
		Interpreter.Tiles_overlays = new short[4][104][104];
		ViewportMouse.Tiles_shapes = new byte[4][104][104];
		class369.field3559 = new byte[4][104][104];
		class344.field3130 = new int[4][105][105];
		class93.field948 = new byte[4][105][105];
		Tiles.field843 = new int[105][105];
		class337.Tiles_hue = new int[104];
		Tiles.Tiles_saturation = new int[104];
		class185.Tiles_lightness = new int[104];
		MenuAction.Tiles_hueMultiplier = new int[104];
		WorldMapLabelSize.field1943 = new int[104];
	}
}