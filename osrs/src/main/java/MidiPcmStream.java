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

@ObfuscatedName("mt")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("bo")
	static AtomicBoolean field2804;
	@ObfuscatedName("bp")
	static ThreadPoolExecutor field2803;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Ltf;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("al")
	int field2807;
	@ObfuscatedName("ak")
	int field2806;
	@ObfuscatedName("ax")
	int[] field2823;
	@ObfuscatedName("ao")
	int[] field2817;
	@ObfuscatedName("ah")
	int[] field2815;
	@ObfuscatedName("ar")
	int[] field2819;
	@ObfuscatedName("ab")
	int[] field2811;
	@ObfuscatedName("am")
	int[] field2816;
	@ObfuscatedName("av")
	int[] field2821;
	@ObfuscatedName("ag")
	int[] field2814;
	@ObfuscatedName("aa")
	int[] field2810;
	@ObfuscatedName("ae")
	int[] field2812;
	@ObfuscatedName("aw")
	int[] field2822;
	@ObfuscatedName("aq")
	int[] field2818;
	@ObfuscatedName("az")
	int[] field2824;
	@ObfuscatedName("at")
	int[] field2820;
	@ObfuscatedName("af")
	int[] field2813;
	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "[[Lms;"
	)
	MusicPatchNode[][] field2830;
	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "[[Lms;"
	)
	MusicPatchNode[][] field2831;
	@ObfuscatedName("bk")
	@ObfuscatedSignature(
		descriptor = "Lmf;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("by")
	boolean field2805;
	@ObfuscatedName("bd")
	@Export("track")
	int track;
	@ObfuscatedName("be")
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("bv")
	long field2827;
	@ObfuscatedName("ba")
	long field2826;
	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "Lmn;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;
	@ObfuscatedName("bb")
	PriorityQueue field2825;
	@ObfuscatedName("bt")
	public int field2833;

	static {
		field2804 = null;
		field2803 = null;
	}

	public MidiPcmStream() {
		this.field2807 = 256;
		this.field2806 = 1000000;
		this.field2823 = new int[16];
		this.field2817 = new int[16];
		this.field2815 = new int[16];
		this.field2819 = new int[16];
		this.field2811 = new int[16];
		this.field2816 = new int[16];
		this.field2821 = new int[16];
		this.field2814 = new int[16];
		this.field2810 = new int[16];
		this.field2812 = new int[16];
		this.field2822 = new int[16];
		this.field2818 = new int[16];
		this.field2824 = new int[16];
		this.field2820 = new int[16];
		this.field2813 = new int[16];
		this.field2830 = new MusicPatchNode[16][128];
		this.field2831 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.field2825 = new PriorityQueue(5, new class330());
		this.field2833 = 0;
		this.musicPatches = new NodeHashTable(128);
		this.method1683();
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "109"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2807 = var1;
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-13"
	)
	public int method1662() {
		return this.field2807;
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lmk;Lom;Lbl;I)Z",
		garbageValue = "-1830159532"
	)
	public synchronized boolean method1663(MusicTrack var1, AbstractArchive var2, SoundCache var3) {
		boolean var4 = true;
		synchronized(this.field2825) {
			this.field2825.clear();
		}

		for (class332 var5 = (class332)var1.field2860.first(); var5 != null; var5 = (class332)var1.field2860.next()) {
			int var12 = (int)var5.key;
			MusicPatch var7 = (MusicPatch)this.musicPatches.get((long)var12);
			if (var7 == null) {
				var7 = ZoneOperation.method1643(var2, var12);
				if (var7 == null) {
					var4 = false;
					continue;
				}

				this.musicPatches.put(var7, (long)var12);
			}

			if (!var7.method1714(var3, var5.field2896)) {
				var4 = false;
			} else if (this.field2825 != null) {
				synchronized(this.field2825) {
					Iterator var9 = var7.field2851.iterator();

					while (var9.hasNext()) {
						class53 var10 = (class53)var9.next();
						this.field2825.add(new class323(var5.field2895, var10));
					}
				}
			}
		}

		return var4;
	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-38"
	)
	public void method1664() {
		if (this.field2825 != null) {
			if (field2804 != null) {
				field2804.set(true);
			}

			field2804 = new AtomicBoolean(false);
			AtomicBoolean var1 = field2804;
			if (field2803 == null) {
				int var2 = Runtime.getRuntime().availableProcessors();
				field2803 = new ThreadPoolExecutor(0, var2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new class322(this));
			}

			field2803.submit(new class326(this, var1));
		}
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "356838086"
	)
	public synchronized void method1665() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "()Lbi;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "()Lbi;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("ab")
	protected synchronized int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("am")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2806 / PcmPlayer.field179;

			do {
				long var5 = this.field2827 + (long)var3 * (long)var4;
				if (this.field2826 - var5 >= 0L) {
					this.field2827 = var5;
					break;
				}

				int var7 = (int)((this.field2826 - this.field2827 + (long)var4 - 1L) / (long)var4);
				this.field2827 += (long)var7 * (long)var4;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method1696();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "64"
	)
	public synchronized void method1666() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("ag")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2806 / PcmPlayer.field179;

			do {
				long var3 = this.field2827 + (long)var1 * (long)var2;
				if (this.field2826 - var3 >= 0L) {
					this.field2827 = var3;
					break;
				}

				int var5 = (int)((this.field2826 - this.field2827 + (long)var2 - 1L) / (long)var2);
				this.field2827 += (long)var5 * (long)var2;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method1696();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Lmk;ZI)V",
		garbageValue = "-1812900871"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2805 = var2;
		this.field2827 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2826 = this.midiFile.method1710(this.trackLength);
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1705880184"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method1683();
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1826603097"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-1035642858"
	)
	public synchronized boolean method1670() {
		return this.musicPatches.method2491() > 0;
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "1"
	)
	public synchronized void method1671(int var1, int var2) {
		this.method1672(var1, var2);
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(IIS)V",
		garbageValue = "160"
	)
	void method1672(int var1, int var2) {
		this.field2819[var1] = var2;
		this.field2816[var1] = var2 & -128;
		this.method1673(var1, var2);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "2093622252"
	)
	void method1673(int var1, int var2) {
		if (var2 != this.field2811[var1]) {
			this.field2811[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2831[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "-1932106886"
	)
	void method1674(int var1, int var2, int var3) {
		this.method1676(var1, var2, 64);
		if ((this.field2812[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2865 == var1 && var4.field2876 < 0) {
					this.field2830[var1][var4.field2868] = null;
					this.field2830[var1][var2] = var4;
					int var5 = (var4.field2867 * var4.field2878 >> 12) + var4.field2870;
					var4.field2870 += var2 - var4.field2868 << 8;
					var4.field2878 = var5 - var4.field2870;
					var4.field2867 = 4096;
					var4.field2868 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2811[var1]);
		if (var9 != null) {
			if (var9.rawSounds[var2] != null) {
				RawSound var8 = var9.rawSounds[var2].method300();
				if (var8 != null) {
					MusicPatchNode var6 = new MusicPatchNode();
					var6.field2865 = var1;
					var6.table = var9;
					var6.rawSound = var8;
					var6.field2881 = var9.field2852[var2];
					var6.field2872 = var9.field2845[var2];
					var6.field2868 = var2;
					var6.field2875 = var3 * var3 * var9.field2847[var2] * var9.field2849 + 1024 >> 11;
					var6.field2864 = var9.field2846[var2] & 255;
					var6.field2870 = (var2 << 8) - (var9.field2853[var2] & 32767);
					var6.field2863 = 0;
					var6.field2873 = 0;
					var6.field2879 = 0;
					var6.field2876 = -1;
					var6.field2869 = 0;
					if (this.field2824[var1] == 0) {
						var6.stream = RawPcmStream.method244(var8, this.method1688(var6), this.method1689(var6), this.method1690(var6));
					} else {
						var6.stream = RawPcmStream.method244(var8, this.method1688(var6), 0, this.method1690(var6));
						this.method1675(var6, var9.field2853[var2] < 0);
					}

					if (var9.field2853[var2] < 0) {
						var6.stream.setNumLoops(-1);
					}

					if (var6.field2872 >= 0) {
						MusicPatchNode var7 = this.field2831[var1][var6.field2872];
						if (var7 != null && var7.field2876 < 0) {
							this.field2830[var1][var7.field2868] = null;
							var7.field2876 = 0;
						}

						this.field2831[var1][var6.field2872] = var6;
					}

					this.patchStream.queue.addFirst(var6);
					this.field2830[var1][var2] = var6;
				}
			}
		}
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lms;ZI)V",
		garbageValue = "240911451"
	)
	void method1675(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field166) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)this.field2824[var1.field2865] * (long)var5 >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method253();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2824[var1.field2865] >> 6);
		}

		var1.stream.method252(var4);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "-1358549088"
	)
	void method1676(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2830[var1][var2];
		if (var4 != null) {
			this.field2830[var1][var2] = null;
			if ((this.field2812[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2865 == var4.field2865 && var5.field2876 < 0 && var5 != var4) {
						var4.field2876 = 0;
						break;
					}
				}
			} else {
				var4.field2876 = 0;
			}

		}
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "714069724"
	)
	void method1677(int var1, int var2, int var3) {
	}

	@ObfuscatedName("bb")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-454645454"
	)
	void method1678(int var1, int var2) {
	}

	@ObfuscatedName("bo")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-2005247777"
	)
	void method1679(int var1, int var2) {
		this.field2821[var1] = var2;
	}

	@ObfuscatedName("bp")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "7"
	)
	void method1680(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2865 == var1) {
				if (var2.stream != null) {
					var2.stream.method257(PcmPlayer.field179 / 100);
					if (var2.stream.method261()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method1727();
				}

				if (var2.field2876 < 0) {
					this.field2830[var2.field2865][var2.field2868] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-58"
	)
	void method1681(int var1) {
		if (var1 >= 0) {
			this.field2823[var1] = 12800;
			this.field2817[var1] = 8192;
			this.field2815[var1] = 16383;
			this.field2821[var1] = 8192;
			this.field2814[var1] = 0;
			this.field2810[var1] = 8192;
			this.method1684(var1);
			this.method1685(var1);
			this.field2812[var1] = 0;
			this.field2822[var1] = 32767;
			this.field2818[var1] = 256;
			this.field2824[var1] = 0;
			this.method1687(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method1681(var1);
			}

		}
	}

	@ObfuscatedName("br")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1157620765"
	)
	void method1682(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2865 == var1) && var2.field2876 < 0) {
				this.field2830[var2.field2865][var2.field2868] = null;
				var2.field2876 = 0;
			}
		}

	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "421748536"
	)
	void method1683() {
		this.method1680(-1);
		this.method1681(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2811[var1] = this.field2819[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2816[var1] = this.field2819[var1] & -128;
		}

	}

	@ObfuscatedName("bu")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "666381709"
	)
	void method1684(int var1) {
		if ((this.field2812[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2865 == var1 && this.field2830[var1][var2.field2868] == null && var2.field2876 < 0) {
					var2.field2876 = 0;
				}
			}
		}

	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "3"
	)
	void method1685(int var1) {
		if ((this.field2812[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2865 == var1) {
					var2.field2874 = 0;
				}
			}
		}

	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "1231976764"
	)
	void method1686(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method1676(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method1674(var3, var4, var5);
			} else {
				this.method1676(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method1677(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2816[var3] = (var5 << 14) + (this.field2816[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2816[var3] = (var5 << 7) + (this.field2816[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2814[var3] = (var5 << 7) + (this.field2814[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2814[var3] = var5 + (this.field2814[var3] & -128);
			}

			if (var4 == 5) {
				this.field2810[var3] = (var5 << 7) + (this.field2810[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2810[var3] = var5 + (this.field2810[var3] & -128);
			}

			if (var4 == 7) {
				this.field2823[var3] = (var5 << 7) + (this.field2823[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2823[var3] = var5 + (this.field2823[var3] & -128);
			}

			if (var4 == 10) {
				this.field2817[var3] = (var5 << 7) + (this.field2817[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2817[var3] = var5 + (this.field2817[var3] & -128);
			}

			if (var4 == 11) {
				this.field2815[var3] = (var5 << 7) + (this.field2815[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2815[var3] = var5 + (this.field2815[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2812;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2812;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2812;
					var10000[var3] |= 2;
				} else {
					this.method1684(var3);
					var10000 = this.field2812;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2822[var3] = (var5 << 7) + (this.field2822[var3] & 127);
			}

			if (var4 == 98) {
				this.field2822[var3] = (this.field2822[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2822[var3] = (var5 << 7) + (this.field2822[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2822[var3] = (this.field2822[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method1680(var3);
			}

			if (var4 == 121) {
				this.method1681(var3);
			}

			if (var4 == 123) {
				this.method1682(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2822[var3];
				if (var6 == 16384) {
					this.field2818[var3] = (var5 << 7) + (this.field2818[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2822[var3];
				if (var6 == 16384) {
					this.field2818[var3] = var5 + (this.field2818[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2824[var3] = (var5 << 7) + (this.field2824[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2824[var3] = var5 + (this.field2824[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2812;
					var10000[var3] |= 4;
				} else {
					this.method1685(var3);
					var10000 = this.field2812;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method1687(var3, (var5 << 7) + (this.field2820[var3] & -16257));
			}

			if (var4 == 49) {
				this.method1687(var3, var5 + (this.field2820[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method1673(var3, var4 + this.field2816[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method1678(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method1679(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method1683();
			}
		}
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1065588896"
	)
	void method1687(int var1, int var2) {
		this.field2820[var1] = var2;
		this.field2813[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
	}

	@ObfuscatedName("bg")
	@ObfuscatedSignature(
		descriptor = "(Lms;S)I",
		garbageValue = "2001"
	)
	int method1688(MusicPatchNode var1) {
		int var2 = (var1.field2878 * var1.field2867 >> 12) + var1.field2870;
		var2 += (this.field2821[var1.field2865] - 8192) * this.field2818[var1.field2865] >> 12;
		MusicPatchNode2 var3 = var1.field2881;
		int var4;
		if (var3.field2781 > 0 && (var3.field2786 > 0 || this.field2814[var1.field2865] > 0)) {
			var4 = var3.field2786 << 2;
			int var5 = var3.field2784 << 1;
			if (var1.field2871 < var5) {
				var4 = var4 * var1.field2871 / var5;
			}

			var4 += this.field2814[var1.field2865] >> 7;
			double var6 = Math.sin((double)(var1.field2877 & 511) * 0.01227184630308513D);
			var2 += (int)((double)var4 * var6);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)PcmPlayer.field179 + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "(Lms;B)I",
		garbageValue = "59"
	)
	int method1689(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2881;
		int var3 = this.field2815[var1.field2865] * this.field2823[var1.field2865] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2875 + 16384 >> 15;
		var3 = var3 * this.field2807 + 128 >> 8;
		if (var2.field2783 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2783 * (double)var1.field2863 * 1.953125E-5D) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2779 != null) {
			var4 = var1.field2873;
			var5 = var2.field2779[var1.field2879 + 1];
			if (var1.field2879 < var2.field2779.length - 2) {
				var6 = (var2.field2779[var1.field2879] & 255) << 8;
				var7 = (var2.field2779[var1.field2879 + 2] & 255) << 8;
				var5 += (var4 - var6) * (var2.field2779[var1.field2879 + 3] - var5) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field2876 > 0 && var2.field2780 != null) {
			var4 = var1.field2876;
			var5 = var2.field2780[var1.field2869 + 1];
			if (var1.field2869 < var2.field2780.length - 2) {
				var6 = (var2.field2780[var1.field2869] & 255) << 8;
				var7 = (var2.field2780[var1.field2869 + 2] & 255) << 8;
				var5 += (var2.field2780[var1.field2869 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(Lms;B)I",
		garbageValue = "2"
	)
	int method1690(MusicPatchNode var1) {
		int var2 = this.field2817[var1.field2865];
		return var2 < 8192 ? var2 * var1.field2864 + 32 >> 6 : 16384 - ((128 - var1.field2864) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2129137394"
	)
	void method1696() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2826; var2 == this.trackLength; var3 = this.midiFile.method1710(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2805 || var2 == 0) {
							this.method1683();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method1686(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2826 = var3;
	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(Lms;B)Z",
		garbageValue = "-28"
	)
	boolean method1697(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2876 >= 0) {
				var1.remove();
				if (var1.field2872 > 0 && var1 == this.field2831[var1.field2865][var1.field2872]) {
					this.field2831[var1.field2865][var1.field2872] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(Lms;[IIIS)Z",
		garbageValue = "27530"
	)
	boolean method1698(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2866 = PcmPlayer.field179 / 100;
		if (var1.field2876 < 0 || var1.stream != null && !var1.stream.method260()) {
			int var5 = var1.field2867;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2810[var1.field2865] * 4.921259842519685E-4D) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2867 = var5;
			}

			var1.stream.method258(this.method1688(var1));
			MusicPatchNode2 var6 = var1.field2881;
			boolean var7 = false;
			++var1.field2871;
			var1.field2877 += var6.field2781;
			double var8 = (double)((var1.field2868 - 60 << 8) + (var1.field2878 * var1.field2867 >> 12)) * 5.086263020833333E-6D;
			if (var6.field2783 > 0) {
				if (var6.field2782 > 0) {
					var1.field2863 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2782 * var8) + 0.5D);
				} else {
					var1.field2863 += 128;
				}
			}

			if (var6.field2779 != null) {
				if (var6.field2787 > 0) {
					var1.field2873 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2787 * var8) + 0.5D);
				} else {
					var1.field2873 += 128;
				}

				while (var1.field2879 < var6.field2779.length - 2 && var1.field2873 > (var6.field2779[var1.field2879 + 2] & 255) << 8) {
					var1.field2879 += 2;
				}

				if (var6.field2779.length - 2 == var1.field2879 && var6.field2779[var1.field2879 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2876 >= 0 && var6.field2780 != null && (this.field2812[var1.field2865] & 1) == 0 && (var1.field2872 < 0 || var1 != this.field2831[var1.field2865][var1.field2872])) {
				if (var6.field2785 > 0) {
					var1.field2876 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2785 * var8) + 0.5D);
				} else {
					var1.field2876 += 128;
				}

				while (var1.field2869 < var6.field2780.length - 2 && var1.field2876 > (var6.field2780[var1.field2869 + 2] & 255) << 8) {
					var1.field2869 += 2;
				}

				if (var6.field2780.length - 2 == var1.field2869) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method257(var1.field2866);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method261()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method1727();
				if (var1.field2876 >= 0) {
					var1.remove();
					if (var1.field2872 > 0 && var1 == this.field2831[var1.field2865][var1.field2872]) {
						this.field2831[var1.field2865][var1.field2872] = null;
					}
				}

				return true;
			} else {
				var1.stream.method256(var1.field2866, this.method1689(var1), this.method1690(var1));
				return false;
			}
		} else {
			var1.method1727();
			var1.remove();
			if (var1.field2872 > 0 && var1 == this.field2831[var1.field2865][var1.field2872]) {
				this.field2831[var1.field2865][var1.field2872] = null;
			}

			return true;
		}
	}
}