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

@ObfuscatedName("lf")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
	@ObfuscatedName("bf")
	static AtomicBoolean field2780;
	@ObfuscatedName("bq")
	static ThreadPoolExecutor field2779;
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lso;"
	)
	@Export("musicPatches")
	NodeHashTable musicPatches;
	@ObfuscatedName("ae")
	int field2782;
	@ObfuscatedName("ao")
	int field2783;
	@ObfuscatedName("at")
	int[] field2796;
	@ObfuscatedName("ac")
	int[] field2787;
	@ObfuscatedName("ai")
	int[] field2791;
	@ObfuscatedName("az")
	int[] field2800;
	@ObfuscatedName("ap")
	int[] field2793;
	@ObfuscatedName("aa")
	int[] field2786;
	@ObfuscatedName("af")
	int[] field2789;
	@ObfuscatedName("ad")
	int[] field2788;
	@ObfuscatedName("aq")
	int[] field2794;
	@ObfuscatedName("ah")
	int[] field2790;
	@ObfuscatedName("as")
	int[] field2795;
	@ObfuscatedName("ay")
	int[] field2799;
	@ObfuscatedName("aj")
	int[] field2792;
	@ObfuscatedName("av")
	int[] field2797;
	@ObfuscatedName("aw")
	int[] field2798;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "[[Lmg;"
	)
	MusicPatchNode[][] field2805;
	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "[[Lmg;"
	)
	MusicPatchNode[][] field2806;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "Llq;"
	)
	@Export("midiFile")
	MidiFileReader midiFile;
	@ObfuscatedName("bk")
	boolean field2781;
	@ObfuscatedName("bv")
	@Export("track")
	int track;
	@ObfuscatedName("bt")
	@Export("trackLength")
	int trackLength;
	@ObfuscatedName("bd")
	long field2802;
	@ObfuscatedName("by")
	long field2803;
	@ObfuscatedName("bs")
	@ObfuscatedSignature(
		descriptor = "Lmh;"
	)
	@Export("patchStream")
	MusicPatchPcmStream patchStream;
	@ObfuscatedName("bm")
	PriorityQueue field2801;
	@ObfuscatedName("ba")
	public int field2809;

	static {
		field2780 = null;
		field2779 = null;
	}

	public MidiPcmStream() {
		this.field2782 = 256;
		this.field2783 = 1000000;
		this.field2796 = new int[16];
		this.field2787 = new int[16];
		this.field2791 = new int[16];
		this.field2800 = new int[16];
		this.field2793 = new int[16];
		this.field2786 = new int[16];
		this.field2789 = new int[16];
		this.field2788 = new int[16];
		this.field2794 = new int[16];
		this.field2790 = new int[16];
		this.field2795 = new int[16];
		this.field2799 = new int[16];
		this.field2792 = new int[16];
		this.field2797 = new int[16];
		this.field2798 = new int[16];
		this.field2805 = new MusicPatchNode[16][128];
		this.field2806 = new MusicPatchNode[16][128];
		this.midiFile = new MidiFileReader();
		this.patchStream = new MusicPatchPcmStream(this);
		this.field2801 = new PriorityQueue(5, new class316());
		this.field2809 = 0;
		this.musicPatches = new NodeHashTable(128);
		this.method1650();
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "178339919"
	)
	@Export("setPcmStreamVolume")
	public synchronized void setPcmStreamVolume(int var1) {
		this.field2782 = var1;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1304608444"
	)
	public int method1629() {
		return this.field2782;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(Lmv;Lnu;Lbi;I)Z",
		garbageValue = "2146420949"
	)
	public synchronized boolean method1630(MusicTrack var1, AbstractArchive var2, SoundCache var3) {
		boolean var4 = true;
		synchronized(this.field2801) {
			this.field2801.clear();
		}

		for (class318 var5 = (class318)var1.field2837.first(); var5 != null; var5 = (class318)var1.field2837.next()) {
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

			if (!var7.method1682(var3, var5.field2876)) {
				var4 = false;
			} else if (this.field2801 != null) {
				synchronized(this.field2801) {
					Iterator var15 = var7.field2828.iterator();

					while (var15.hasNext()) {
						class53 var10 = (class53)var15.next();
						this.field2801.add(new class309(var5.field2875, var10));
					}
				}
			}
		}

		return var4;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-932325376"
	)
	public void method1631() {
		if (this.field2801 != null) {
			if (field2780 != null) {
				field2780.set(true);
			}

			field2780 = new AtomicBoolean(false);
			AtomicBoolean var1 = field2780;
			if (field2779 == null) {
				int var2 = Runtime.getRuntime().availableProcessors();
				field2779 = new ThreadPoolExecutor(0, var2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new class308(this));
			}

			field2779.submit(new class312(this, var1));
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2076204033"
	)
	public synchronized void method1632() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.clear();
		}

	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
	)
	@Export("firstSubStream")
	protected synchronized PcmStream firstSubStream() {
		return this.patchStream;
	}

	@ObfuscatedName("az")
	@ObfuscatedSignature(
		descriptor = "()Lbw;"
	)
	@Export("nextSubStream")
	protected synchronized PcmStream nextSubStream() {
		return null;
	}

	@ObfuscatedName("ap")
	protected synchronized int vmethod5648() {
		return 0;
	}

	@ObfuscatedName("aa")
	@Export("fill")
	protected synchronized void fill(int[] var1, int var2, int var3) {
		if (this.midiFile.isReady()) {
			int var4 = this.midiFile.division * this.field2783 / PcmPlayer.field181;

			do {
				long var5 = (long)var4 * (long)var3 + this.field2802;
				if (this.field2803 - var5 >= 0L) {
					this.field2802 = var5;
					break;
				}

				int var7 = (int)(((long)var4 + (this.field2803 - this.field2802) - 1L) / (long)var4);
				this.field2802 += (long)var4 * (long)var7;
				this.patchStream.fill(var1, var2, var7);
				var2 += var7;
				var3 -= var7;
				this.method1664();
			} while(this.midiFile.isReady());
		}

		this.patchStream.fill(var1, var2, var3);
	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-1876288055"
	)
	public synchronized void method1633() {
		for (MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
			var1.remove();
		}

	}

	@ObfuscatedName("ad")
	@Export("skip")
	protected synchronized void skip(int var1) {
		if (this.midiFile.isReady()) {
			int var2 = this.midiFile.division * this.field2783 / PcmPlayer.field181;

			do {
				long var3 = this.field2802 + (long)var1 * (long)var2;
				if (this.field2803 - var3 >= 0L) {
					this.field2802 = var3;
					break;
				}

				int var5 = (int)(((long)var2 + (this.field2803 - this.field2802) - 1L) / (long)var2);
				this.field2802 += (long)var2 * (long)var5;
				this.patchStream.skip(var5);
				var1 -= var5;
				this.method1664();
			} while(this.midiFile.isReady());
		}

		this.patchStream.skip(var1);
	}

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(Lmv;ZI)V",
		garbageValue = "718932503"
	)
	@Export("setMusicTrack")
	public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
		this.clear();
		this.midiFile.parse(var1.midi);
		this.field2781 = var2;
		this.field2802 = 0L;
		int var3 = this.midiFile.trackCount();

		for (int var4 = 0; var4 < var3; ++var4) {
			this.midiFile.gotoTrack(var4);
			this.midiFile.readTrackLength(var4);
			this.midiFile.markTrackPosition(var4);
		}

		this.track = this.midiFile.getPrioritizedTrack();
		this.trackLength = this.midiFile.trackLengths[this.track];
		this.field2803 = this.midiFile.method1678(this.trackLength);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "965115955"
	)
	@Export("clear")
	public synchronized void clear() {
		this.midiFile.clear();
		this.method1650();
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-12"
	)
	@Export("isReady")
	public synchronized boolean isReady() {
		return this.midiFile.isReady();
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "8"
	)
	public synchronized boolean method1637() {
		return this.musicPatches.method2456() > 0;
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1830042203"
	)
	public synchronized void method1638(int var1, int var2) {
		this.method1639(var1, var2);
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "-22"
	)
	void method1639(int var1, int var2) {
		this.field2800[var1] = var2;
		this.field2786[var1] = var2 & -128;
		this.method1640(var1, var2);
	}

	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "71"
	)
	void method1640(int var1, int var2) {
		if (var2 != this.field2793[var1]) {
			this.field2793[var1] = var2;

			for (int var3 = 0; var3 < 128; ++var3) {
				this.field2806[var1][var3] = null;
			}
		}

	}

	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "896950696"
	)
	void method1641(int var1, int var2, int var3) {
		this.method1643(var1, var2, 64);
		if ((this.field2790[var1] & 2) != 0) {
			for (MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
				if (var4.field2854 == var1 && var4.field2853 < 0) {
					this.field2805[var1][var4.field2847] = null;
					this.field2805[var1][var2] = var4;
					int var5 = (var4.field2844 * var4.field2843 >> 12) + var4.field2840;
					var4.field2840 += var2 - var4.field2847 << 8;
					var4.field2844 = var5 - var4.field2840;
					var4.field2843 = 4096;
					var4.field2847 = var2;
					return;
				}
			}
		}

		MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2793[var1]);
		if (var9 != null) {
			if (var9.rawSounds[var2] != null) {
				RawSound var8 = var9.rawSounds[var2].method292();
				if (var8 != null) {
					MusicPatchNode var6 = new MusicPatchNode();
					var6.field2854 = var1;
					var6.table = var9;
					var6.rawSound = var8;
					var6.field2857 = var9.field2829[var2];
					var6.field2842 = var9.field2824[var2];
					var6.field2847 = var2;
					var6.field2856 = var3 * var3 * var9.field2822[var2] * var9.field2826 + 1024 >> 11;
					var6.field2851 = var9.field2823[var2] & 255;
					var6.field2840 = (var2 << 8) - (var9.field2830[var2] & 32767);
					var6.field2852 = 0;
					var6.field2848 = 0;
					var6.field2850 = 0;
					var6.field2853 = -1;
					var6.field2841 = 0;
					if (this.field2792[var1] == 0) {
						var6.stream = RawPcmStream.method235(var8, this.method1656(var6), this.method1657(var6), this.method1658(var6));
					} else {
						var6.stream = RawPcmStream.method235(var8, this.method1656(var6), 0, this.method1658(var6));
						this.method1642(var6, var9.field2830[var2] < 0);
					}

					if (var9.field2830[var2] < 0) {
						var6.stream.setNumLoops(-1);
					}

					if (var6.field2842 >= 0) {
						MusicPatchNode var7 = this.field2806[var1][var6.field2842];
						if (var7 != null && var7.field2853 < 0) {
							this.field2805[var1][var7.field2847] = null;
							var7.field2853 = 0;
						}

						this.field2806[var1][var6.field2842] = var6;
					}

					this.patchStream.queue.addFirst(var6);
					this.field2805[var1][var2] = var6;
				}
			}
		}
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Lmg;ZS)V",
		garbageValue = "5717"
	)
	void method1642(MusicPatchNode var1, boolean var2) {
		int var3 = var1.rawSound.samples.length;
		int var4;
		if (var2 && var1.rawSound.field167) {
			int var5 = var3 + var3 - var1.rawSound.start;
			var4 = (int)((long)var5 * (long)this.field2792[var1.field2854] >> 6);
			var3 <<= 8;
			if (var4 >= var3) {
				var4 = var3 + var3 - 1 - var4;
				var1.stream.method244();
			}
		} else {
			var4 = (int)((long)var3 * (long)this.field2792[var1.field2854] >> 6);
		}

		var1.stream.method243(var4);
	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "1002745448"
	)
	void method1643(int var1, int var2, int var3) {
		MusicPatchNode var4 = this.field2805[var1][var2];
		if (var4 != null) {
			this.field2805[var1][var2] = null;
			if ((this.field2790[var1] & 2) != 0) {
				for (MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
					if (var5.field2854 == var4.field2854 && var5.field2853 < 0 && var4 != var5) {
						var4.field2853 = 0;
						break;
					}
				}
			} else {
				var4.field2853 = 0;
			}

		}
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(IIII)V",
		garbageValue = "-1830352831"
	)
	void method1644(int var1, int var2, int var3) {
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "-1399006127"
	)
	void method1645(int var1, int var2) {
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "1713272694"
	)
	void method1646(int var1, int var2) {
		this.field2789[var1] = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "405588365"
	)
	void method1647(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if (var1 < 0 || var2.field2854 == var1) {
				if (var2.stream != null) {
					var2.stream.method248(PcmPlayer.field181 / 100);
					if (var2.stream.method252()) {
						this.patchStream.mixer.addSubStream(var2.stream);
					}

					var2.method1696();
				}

				if (var2.field2853 < 0) {
					this.field2805[var2.field2854][var2.field2847] = null;
				}

				var2.remove();
			}
		}

	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "11"
	)
	void method1648(int var1) {
		if (var1 >= 0) {
			this.field2796[var1] = 12800;
			this.field2787[var1] = 8192;
			this.field2791[var1] = 16383;
			this.field2789[var1] = 8192;
			this.field2788[var1] = 0;
			this.field2794[var1] = 8192;
			this.method1652(var1);
			this.method1653(var1);
			this.field2790[var1] = 0;
			this.field2795[var1] = 32767;
			this.field2799[var1] = 256;
			this.field2792[var1] = 0;
			this.method1655(var1, 8192);
		} else {
			for (var1 = 0; var1 < 16; ++var1) {
				this.method1648(var1);
			}

		}
	}

	@ObfuscatedName("bh")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "2"
	)
	void method1649(int var1) {
		for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
			if ((var1 < 0 || var2.field2854 == var1) && var2.field2853 < 0) {
				this.field2805[var2.field2854][var2.field2847] = null;
				var2.field2853 = 0;
			}
		}

	}

	@ObfuscatedName("bm")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1873768041"
	)
	void method1650() {
		this.method1647(-1);
		this.method1648(-1);

		int var1;
		for (var1 = 0; var1 < 16; ++var1) {
			this.field2793[var1] = this.field2800[var1];
		}

		for (var1 = 0; var1 < 16; ++var1) {
			this.field2786[var1] = this.field2800[var1] & -128;
		}

	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1931071556"
	)
	void method1652(int var1) {
		if ((this.field2790[var1] & 2) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2854 == var1 && this.field2805[var1][var2.field2847] == null && var2.field2853 < 0) {
					var2.field2853 = 0;
				}
			}
		}

	}

	@ObfuscatedName("bq")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1591565057"
	)
	void method1653(int var1) {
		if ((this.field2790[var1] & 4) != 0) {
			for (MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
				if (var2.field2854 == var1) {
					var2.field2855 = 0;
				}
			}
		}

	}

	@ObfuscatedName("ba")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "-60"
	)
	void method1654(int var1) {
		int var2 = var1 & 240;
		int var3;
		int var4;
		int var5;
		if (var2 == 128) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method1643(var3, var4, var5);
		} else if (var2 == 144) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var5 > 0) {
				this.method1641(var3, var4, var5);
			} else {
				this.method1643(var3, var4, 64);
			}

		} else if (var2 == 160) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			this.method1644(var3, var4, var5);
		} else if (var2 == 176) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			var5 = var1 >> 16 & 127;
			if (var4 == 0) {
				this.field2786[var3] = (var5 << 14) + (this.field2786[var3] & -2080769);
			}

			if (var4 == 32) {
				this.field2786[var3] = (var5 << 7) + (this.field2786[var3] & -16257);
			}

			if (var4 == 1) {
				this.field2788[var3] = (var5 << 7) + (this.field2788[var3] & -16257);
			}

			if (var4 == 33) {
				this.field2788[var3] = var5 + (this.field2788[var3] & -128);
			}

			if (var4 == 5) {
				this.field2794[var3] = (var5 << 7) + (this.field2794[var3] & -16257);
			}

			if (var4 == 37) {
				this.field2794[var3] = var5 + (this.field2794[var3] & -128);
			}

			if (var4 == 7) {
				this.field2796[var3] = (var5 << 7) + (this.field2796[var3] & -16257);
			}

			if (var4 == 39) {
				this.field2796[var3] = var5 + (this.field2796[var3] & -128);
			}

			if (var4 == 10) {
				this.field2787[var3] = (var5 << 7) + (this.field2787[var3] & -16257);
			}

			if (var4 == 42) {
				this.field2787[var3] = var5 + (this.field2787[var3] & -128);
			}

			if (var4 == 11) {
				this.field2791[var3] = (var5 << 7) + (this.field2791[var3] & -16257);
			}

			if (var4 == 43) {
				this.field2791[var3] = var5 + (this.field2791[var3] & -128);
			}

			int[] var10000;
			if (var4 == 64) {
				if (var5 >= 64) {
					var10000 = this.field2790;
					var10000[var3] |= 1;
				} else {
					var10000 = this.field2790;
					var10000[var3] &= -2;
				}
			}

			if (var4 == 65) {
				if (var5 >= 64) {
					var10000 = this.field2790;
					var10000[var3] |= 2;
				} else {
					this.method1652(var3);
					var10000 = this.field2790;
					var10000[var3] &= -3;
				}
			}

			if (var4 == 99) {
				this.field2795[var3] = (var5 << 7) + (this.field2795[var3] & 127);
			}

			if (var4 == 98) {
				this.field2795[var3] = (this.field2795[var3] & 16256) + var5;
			}

			if (var4 == 101) {
				this.field2795[var3] = (var5 << 7) + (this.field2795[var3] & 127) + 16384;
			}

			if (var4 == 100) {
				this.field2795[var3] = (this.field2795[var3] & 16256) + var5 + 16384;
			}

			if (var4 == 120) {
				this.method1647(var3);
			}

			if (var4 == 121) {
				this.method1648(var3);
			}

			if (var4 == 123) {
				this.method1649(var3);
			}

			int var6;
			if (var4 == 6) {
				var6 = this.field2795[var3];
				if (var6 == 16384) {
					this.field2799[var3] = (var5 << 7) + (this.field2799[var3] & -16257);
				}
			}

			if (var4 == 38) {
				var6 = this.field2795[var3];
				if (var6 == 16384) {
					this.field2799[var3] = var5 + (this.field2799[var3] & -128);
				}
			}

			if (var4 == 16) {
				this.field2792[var3] = (var5 << 7) + (this.field2792[var3] & -16257);
			}

			if (var4 == 48) {
				this.field2792[var3] = var5 + (this.field2792[var3] & -128);
			}

			if (var4 == 81) {
				if (var5 >= 64) {
					var10000 = this.field2790;
					var10000[var3] |= 4;
				} else {
					this.method1653(var3);
					var10000 = this.field2790;
					var10000[var3] &= -5;
				}
			}

			if (var4 == 17) {
				this.method1655(var3, (var5 << 7) + (this.field2797[var3] & -16257));
			}

			if (var4 == 49) {
				this.method1655(var3, var5 + (this.field2797[var3] & -128));
			}

		} else if (var2 == 192) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method1640(var3, var4 + this.field2786[var3]);
		} else if (var2 == 208) {
			var3 = var1 & 15;
			var4 = var1 >> 8 & 127;
			this.method1645(var3, var4);
		} else if (var2 == 224) {
			var3 = var1 & 15;
			var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
			this.method1646(var3, var4);
		} else {
			var2 = var1 & 255;
			if (var2 == 255) {
				this.method1650();
			}
		}
	}

	@ObfuscatedName("bl")
	@ObfuscatedSignature(
		descriptor = "(III)V",
		garbageValue = "943957578"
	)
	void method1655(int var1, int var2) {
		this.field2797[var1] = var2;
		this.field2798[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
	}

	@ObfuscatedName("be")
	@ObfuscatedSignature(
		descriptor = "(Lmg;B)I",
		garbageValue = "-57"
	)
	int method1656(MusicPatchNode var1) {
		int var2 = (var1.field2843 * var1.field2844 >> 12) + var1.field2840;
		var2 += (this.field2789[var1.field2854] - 8192) * this.field2799[var1.field2854] >> 12;
		MusicPatchNode2 var3 = var1.field2857;
		int var4;
		if (var3.field2763 > 0 && (var3.field2765 > 0 || this.field2788[var1.field2854] > 0)) {
			var4 = var3.field2765 << 2;
			int var5 = var3.field2759 << 1;
			if (var1.field2845 < var5) {
				var4 = var4 * var1.field2845 / var5;
			}

			var4 += this.field2788[var1.field2854] >> 7;
			double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2849 & 511));
			var2 += (int)((double)var4 * var6);
		}

		var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)PcmPlayer.field181 + 0.5D);
		return var4 < 1 ? 1 : var4;
	}

	@ObfuscatedName("bi")
	@ObfuscatedSignature(
		descriptor = "(Lmg;I)I",
		garbageValue = "-1224155709"
	)
	int method1657(MusicPatchNode var1) {
		MusicPatchNode2 var2 = var1.field2857;
		int var3 = this.field2796[var1.field2854] * this.field2791[var1.field2854] + 4096 >> 13;
		var3 = var3 * var3 + 16384 >> 15;
		var3 = var3 * var1.field2856 + 16384 >> 15;
		var3 = var3 * this.field2782 + 128 >> 8;
		if (var2.field2762 > 0) {
			var3 = (int)((double)var3 * Math.pow(0.5D, 1.953125E-5D * (double)var1.field2852 * (double)var2.field2762) + 0.5D);
		}

		int var4;
		int var5;
		int var6;
		int var7;
		if (var2.field2758 != null) {
			var4 = var1.field2848;
			var5 = var2.field2758[var1.field2850 + 1];
			if (var1.field2850 < var2.field2758.length - 2) {
				var6 = (var2.field2758[var1.field2850] & 255) << 8;
				var7 = (var2.field2758[var1.field2850 + 2] & 255) << 8;
				var5 += (var2.field2758[var1.field2850 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var5 * var3 + 32 >> 6;
		}

		if (var1.field2853 > 0 && var2.field2757 != null) {
			var4 = var1.field2853;
			var5 = var2.field2757[var1.field2841 + 1];
			if (var1.field2841 < var2.field2757.length - 2) {
				var6 = (var2.field2757[var1.field2841] & 255) << 8;
				var7 = (var2.field2757[var1.field2841 + 2] & 255) << 8;
				var5 += (var2.field2757[var1.field2841 + 3] - var5) * (var4 - var6) / (var7 - var6);
			}

			var3 = var3 * var5 + 32 >> 6;
		}

		return var3;
	}

	@ObfuscatedName("bz")
	@ObfuscatedSignature(
		descriptor = "(Lmg;I)I",
		garbageValue = "-1781769455"
	)
	int method1658(MusicPatchNode var1) {
		int var2 = this.field2787[var1.field2854];
		return var2 < 8192 ? var2 * var1.field2851 + 32 >> 6 : 16384 - ((128 - var1.field2851) * (16384 - var2) + 32 >> 6);
	}

	@ObfuscatedName("bx")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-25"
	)
	void method1664() {
		int var1 = this.track;
		int var2 = this.trackLength;

		long var3;
		for (var3 = this.field2803; var2 == this.trackLength; var3 = this.midiFile.method1678(var2)) {
			while (var2 == this.midiFile.trackLengths[var1]) {
				this.midiFile.gotoTrack(var1);
				int var5 = this.midiFile.readMessage(var1);
				if (var5 == 1) {
					this.midiFile.setTrackDone();
					this.midiFile.markTrackPosition(var1);
					if (this.midiFile.isDone()) {
						if (!this.field2781 || var2 == 0) {
							this.method1650();
							this.midiFile.clear();
							return;
						}

						this.midiFile.reset(var3);
					}
					break;
				}

				if ((var5 & 128) != 0) {
					this.method1654(var5);
				}

				this.midiFile.readTrackLength(var1);
				this.midiFile.markTrackPosition(var1);
			}

			var1 = this.midiFile.getPrioritizedTrack();
			var2 = this.midiFile.trackLengths[var1];
		}

		this.track = var1;
		this.trackLength = var2;
		this.field2803 = var3;
	}

	@ObfuscatedName("bn")
	@ObfuscatedSignature(
		descriptor = "(Lmg;I)Z",
		garbageValue = "845643756"
	)
	boolean method1665(MusicPatchNode var1) {
		if (var1.stream == null) {
			if (var1.field2853 >= 0) {
				var1.remove();
				if (var1.field2842 > 0 && var1 == this.field2806[var1.field2854][var1.field2842]) {
					this.field2806[var1.field2854][var1.field2842] = null;
				}
			}

			return true;
		} else {
			return false;
		}
	}

	@ObfuscatedName("bw")
	@ObfuscatedSignature(
		descriptor = "(Lmg;[IIII)Z",
		garbageValue = "1875808849"
	)
	boolean method1666(MusicPatchNode var1, int[] var2, int var3, int var4) {
		var1.field2846 = PcmPlayer.field181 / 100;
		if (var1.field2853 < 0 || var1.stream != null && !var1.stream.method251()) {
			int var5 = var1.field2843;
			if (var5 > 0) {
				var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2794[var1.field2854]) + 0.5D);
				if (var5 < 0) {
					var5 = 0;
				}

				var1.field2843 = var5;
			}

			var1.stream.method249(this.method1656(var1));
			MusicPatchNode2 var6 = var1.field2857;
			boolean var7 = false;
			++var1.field2845;
			var1.field2849 += var6.field2763;
			double var8 = 5.086263020833333E-6D * (double)((var1.field2847 - 60 << 8) + (var1.field2844 * var1.field2843 >> 12));
			if (var6.field2762 > 0) {
				if (var6.field2761 > 0) {
					var1.field2852 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2761 * var8) + 0.5D);
				} else {
					var1.field2852 += 128;
				}
			}

			if (var6.field2758 != null) {
				if (var6.field2764 > 0) {
					var1.field2848 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2764) + 0.5D);
				} else {
					var1.field2848 += 128;
				}

				while (var1.field2850 < var6.field2758.length - 2 && var1.field2848 > (var6.field2758[var1.field2850 + 2] & 255) << 8) {
					var1.field2850 += 2;
				}

				if (var6.field2758.length - 2 == var1.field2850 && var6.field2758[var1.field2850 + 1] == 0) {
					var7 = true;
				}
			}

			if (var1.field2853 >= 0 && var6.field2757 != null && (this.field2790[var1.field2854] & 1) == 0 && (var1.field2842 < 0 || var1 != this.field2806[var1.field2854][var1.field2842])) {
				if (var6.field2760 > 0) {
					var1.field2853 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2760) + 0.5D);
				} else {
					var1.field2853 += 128;
				}

				while (var1.field2841 < var6.field2757.length - 2 && var1.field2853 > (var6.field2757[var1.field2841 + 2] & 255) << 8) {
					var1.field2841 += 2;
				}

				if (var6.field2757.length - 2 == var1.field2841) {
					var7 = true;
				}
			}

			if (var7) {
				var1.stream.method248(var1.field2846);
				if (var2 != null) {
					var1.stream.fill(var2, var3, var4);
				} else {
					var1.stream.skip(var4);
				}

				if (var1.stream.method252()) {
					this.patchStream.mixer.addSubStream(var1.stream);
				}

				var1.method1696();
				if (var1.field2853 >= 0) {
					var1.remove();
					if (var1.field2842 > 0 && var1 == this.field2806[var1.field2854][var1.field2842]) {
						this.field2806[var1.field2854][var1.field2842] = null;
					}
				}

				return true;
			} else {
				var1.stream.method247(var1.field2846, this.method1657(var1), this.method1658(var1));
				return false;
			}
		} else {
			var1.method1696();
			var1.remove();
			if (var1.field2842 > 0 && var1 == this.field2806[var1.field2854][var1.field2842]) {
				this.field2806[var1.field2854][var1.field2842] = null;
			}

			return true;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)[Lnn;",
		garbageValue = "1169137618"
	)
	@Export("PlayerType_values")
	public static PlayerType[] PlayerType_values() {
		return new PlayerType[]{PlayerType.field3487, PlayerType.PlayerType_ultimateIronman, PlayerType.field3493, PlayerType.PlayerType_jagexModerator, PlayerType.PlayerType_playerModerator, PlayerType.field3496, PlayerType.field3489, PlayerType.PlayerType_ironman, PlayerType.PlayerType_normal, PlayerType.field3490, PlayerType.field3485, PlayerType.field3497, PlayerType.PlayerType_hardcoreIronman, PlayerType.field3492, PlayerType.field3500, PlayerType.field3495, PlayerType.field3484};
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(B)[Lum;",
		garbageValue = "37"
	)
	@Export("FillMode_values")
	public static FillMode[] FillMode_values() {
		return new FillMode[]{FillMode.field4230, FillMode.field4231, FillMode.SOLID};
	}

	@ObfuscatedName("an")
	@ObfuscatedSignature(
		descriptor = "(II)Ljt;",
		garbageValue = "2017214624"
	)
	@Export("getFrames")
	static Frames getFrames(int var0) {
		Frames var1 = (Frames)SequenceDefinition.SequenceDefinition_cachedFrames.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			var1 = ArchiveLoader.method464(VarpDefinition.SequenceDefinition_animationsArchive, class485.SequenceDefinition_skeletonsArchive, var0, false);
			if (var1 != null) {
				SequenceDefinition.SequenceDefinition_cachedFrames.put(var1, (long)var0);
			}

			return var1;
		}
	}
}