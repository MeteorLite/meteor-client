import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lz")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
   @ObfuscatedName("vo")
   @ObfuscatedSignature(
      descriptor = "Lpv;"
   )
   @Export("masterDisk")
   static ArchiveDisk masterDisk;
   @ObfuscatedName("uo")
   @Export("cameraLookAtHeight")
   static int cameraLookAtHeight;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lrh;"
   )
   @Export("musicPatches")
   NodeHashTable musicPatches = new NodeHashTable(128);
   @ObfuscatedName("al")
   int field2682 = 256;
   @ObfuscatedName("ac")
   int field2683 = 1000000;
   @ObfuscatedName("ab")
   int[] field2684 = new int[16];
   @ObfuscatedName("an")
   int[] field2699 = new int[16];
   @ObfuscatedName("ao")
   int[] field2686 = new int[16];
   @ObfuscatedName("av")
   int[] field2687 = new int[16];
   @ObfuscatedName("aq")
   int[] field2688 = new int[16];
   @ObfuscatedName("ap")
   int[] field2681 = new int[16];
   @ObfuscatedName("ar")
   int[] field2690 = new int[16];
   @ObfuscatedName("ak")
   int[] field2707 = new int[16];
   @ObfuscatedName("ax")
   int[] field2685 = new int[16];
   @ObfuscatedName("at")
   int[] field2697 = new int[16];
   @ObfuscatedName("af")
   int[] field2694 = new int[16];
   @ObfuscatedName("ai")
   int[] field2695 = new int[16];
   @ObfuscatedName("aw")
   int[] field2700 = new int[16];
   @ObfuscatedName("aa")
   int[] field2689 = new int[16];
   @ObfuscatedName("ah")
   int[] field2698 = new int[16];
   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "[[Llp;"
   )
   MusicPatchNode[][] field2703 = new MusicPatchNode[16][128];
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "[[Llp;"
   )
   MusicPatchNode[][] field2696 = new MusicPatchNode[16][128];
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "Llm;"
   )
   @Export("midiFile")
   MidiFileReader midiFile = new MidiFileReader();
   @ObfuscatedName("bo")
   boolean field2702;
   @ObfuscatedName("bs")
   @Export("track")
   int track;
   @ObfuscatedName("bg")
   @Export("trackLength")
   int trackLength;
   @ObfuscatedName("bh")
   long field2705;
   @ObfuscatedName("bl")
   long field2706;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "Lld;"
   )
   @Export("patchStream")
   MusicPatchPcmStream patchStream = new MusicPatchPcmStream(this);

   public MidiPcmStream() {
      this.method1574();
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-2026232471"
   )
   @Export("setPcmStreamVolume")
   public synchronized void setPcmStreamVolume(int var1) {
      this.field2682 = var1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1058020738"
   )
   public int method1564() {
      return this.field2682;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Llh;Lne;Lbb;II)Z",
      garbageValue = "-1261281110"
   )
   @Export("loadMusicTrack")
   synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
      var1.method1621();
      boolean var5 = true;
      int[] var6 = null;
      if (var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
         int var8 = (int)var7.key;
         MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
         if (var9 == null) {
            byte[] var11 = var2.takeFileFlat(var8);
            MusicPatch var10;
            if (var11 == null) {
               var10 = null;
            } else {
               var10 = new MusicPatch(var11);
            }

            var9 = var10;
            if (var10 == null) {
               var5 = false;
               continue;
            }

            this.musicPatches.put(var10, (long)var8);
         }

         if (!var9.method1611(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if (var5) {
         var1.clear();
      }

      return var5;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1680529445"
   )
   @Export("clearAll")
   synchronized void clearAll() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.clear();
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1951099218"
   )
   @Export("removeAll")
   public synchronized void removeAll() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.remove();
      }

   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "()Lbj;"
   )
   @Export("firstSubStream")
   protected synchronized PcmStream firstSubStream() {
      return this.patchStream;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "()Lbj;"
   )
   @Export("nextSubStream")
   protected synchronized PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("aq")
   protected synchronized int vmethod5648() {
      return 0;
   }

   @ObfuscatedName("ap")
   @Export("fill")
   protected synchronized void fill(int[] var1, int var2, int var3) {
      if (this.midiFile.isReady()) {
         int var4 = this.midiFile.division * this.field2683 / PcmPlayer.field194;

         do {
            long var5 = this.field2705 + (long)var4 * (long)var3;
            if (this.field2706 - var5 >= 0L) {
               this.field2705 = var5;
               break;
            }

            int var7 = (int)((this.field2706 - this.field2705 + (long)var4 - 1L) / (long)var4);
            this.field2705 += (long)var4 * (long)var7;
            this.patchStream.fill(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method1585();
         } while(this.midiFile.isReady());
      }

      this.patchStream.fill(var1, var2, var3);
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Llh;ZB)V",
      garbageValue = "-41"
   )
   @Export("setMusicTrack")
   synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
      this.clear();
      this.midiFile.parse(var1.midi);
      this.field2702 = var2;
      this.field2705 = 0L;
      int var3 = this.midiFile.trackCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.midiFile.gotoTrack(var4);
         this.midiFile.readTrackLength(var4);
         this.midiFile.markTrackPosition(var4);
      }

      this.track = this.midiFile.getPrioritizedTrack();
      this.trackLength = this.midiFile.trackLengths[this.track];
      this.field2706 = this.midiFile.method1599(this.trackLength);
   }

   @ObfuscatedName("ak")
   @Export("skip")
   protected synchronized void skip(int var1) {
      if (this.midiFile.isReady()) {
         int var2 = this.midiFile.division * this.field2683 / PcmPlayer.field194;

         do {
            long var3 = this.field2705 + (long)var1 * (long)var2;
            if (this.field2706 - var3 >= 0L) {
               this.field2705 = var3;
               break;
            }

            int var5 = (int)((this.field2706 - this.field2705 + (long)var2 - 1L) / (long)var2);
            this.field2705 += (long)var5 * (long)var2;
            this.patchStream.skip(var5);
            var1 -= var5;
            this.method1585();
         } while(this.midiFile.isReady());
      }

      this.patchStream.skip(var1);
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1515299645"
   )
   @Export("clear")
   public synchronized void clear() {
      this.midiFile.clear();
      this.method1574();
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "16"
   )
   @Export("isReady")
   public synchronized boolean isReady() {
      return this.midiFile.isReady();
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1455017401"
   )
   public synchronized void method1566(int var1, int var2) {
      this.method1567(var1, var2);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "-6"
   )
   void method1567(int var1, int var2) {
      this.field2687[var1] = var2;
      this.field2681[var1] = var2 & -128;
      this.method1592(var1, var2);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "1"
   )
   void method1592(int var1, int var2) {
      if (var2 != this.field2688[var1]) {
         this.field2688[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2696[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "-164791979"
   )
   void method1595(int var1, int var2, int var3) {
      this.method1568(var1, var2, 64);
      if ((this.field2697[var1] & 2) != 0) {
         for(MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
            if (var4.field2755 == var1 && var4.field2751 < 0) {
               this.field2703[var1][var4.field2739] = null;
               this.field2703[var1][var2] = var4;
               int var5 = (var4.field2744 * var4.field2743 >> 12) + var4.field2742;
               var4.field2742 += var2 - var4.field2739 << 8;
               var4.field2743 = var5 - var4.field2742;
               var4.field2744 = 4096;
               var4.field2739 = var2;
               return;
            }
         }
      }

      MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2688[var1]);
      if (var9 != null) {
         RawSound var8 = var9.rawSounds[var2];
         if (var8 != null) {
            MusicPatchNode var6 = new MusicPatchNode();
            var6.field2755 = var1;
            var6.patch = var9;
            var6.rawSound = var8;
            var6.field2737 = var9.field2720[var2];
            var6.field2734 = var9.field2724[var2];
            var6.field2739 = var2;
            var6.field2754 = var3 * var3 * var9.field2725[var2] * var9.field2723 + 1024 >> 11;
            var6.field2741 = var9.field2722[var2] & 255;
            var6.field2742 = (var2 << 8) - (var9.field2721[var2] & 32767);
            var6.field2740 = 0;
            var6.field2746 = 0;
            var6.field2747 = 0;
            var6.field2751 = -1;
            var6.field2749 = 0;
            if (this.field2700[var1] == 0) {
               var6.stream = RawPcmStream.method239(var8, this.method1578(var6), this.method1579(var6), this.method1580(var6));
            } else {
               var6.stream = RawPcmStream.method239(var8, this.method1578(var6), 0, this.method1580(var6));
               this.method1590(var6, var9.field2721[var2] < 0);
            }

            if (var9.field2721[var2] < 0) {
               var6.stream.setNumLoops(-1);
            }

            if (var6.field2734 >= 0) {
               MusicPatchNode var7 = this.field2696[var1][var6.field2734];
               if (var7 != null && var7.field2751 < 0) {
                  this.field2703[var1][var7.field2739] = null;
                  var7.field2751 = 0;
               }

               this.field2696[var1][var6.field2734] = var6;
            }

            this.patchStream.queue.addFirst(var6);
            this.field2703[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Llp;ZB)V",
      garbageValue = "109"
   )
   void method1590(MusicPatchNode var1, boolean var2) {
      int var3 = var1.rawSound.samples.length;
      int var4;
      if (var2 && var1.rawSound.field173) {
         int var5 = var3 + var3 - var1.rawSound.start;
         var4 = (int)((long)var5 * (long)this.field2700[var1.field2755] >> 6);
         var3 <<= 8;
         if (var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.stream.method243();
         }
      } else {
         var4 = (int)((long)this.field2700[var1.field2755] * (long)var3 >> 6);
      }

      var1.stream.method273(var4);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "2075556238"
   )
   void method1568(int var1, int var2, int var3) {
      MusicPatchNode var4 = this.field2703[var1][var2];
      if (var4 != null) {
         this.field2703[var1][var2] = null;
         if ((this.field2697[var1] & 2) != 0) {
            for(MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
               if (var4.field2755 == var5.field2755 && var5.field2751 < 0 && var4 != var5) {
                  var4.field2751 = 0;
                  break;
               }
            }
         } else {
            var4.field2751 = 0;
         }

      }
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "-2110724161"
   )
   void method1571(int var1, int var2, int var3) {
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IIS)V",
      garbageValue = "-11303"
   )
   void method1572(int var1, int var2) {
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-1657999339"
   )
   void method1573(int var1, int var2) {
      this.field2690[var1] = var2;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "-23831"
   )
   void method1570(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if (var1 < 0 || var2.field2755 == var1) {
            if (var2.stream != null) {
               var2.stream.method247(PcmPlayer.field194 / 100);
               if (var2.stream.method280()) {
                  this.patchStream.mixer.addSubStream(var2.stream);
               }

               var2.method1624();
            }

            if (var2.field2751 < 0) {
               this.field2703[var2.field2755][var2.field2739] = null;
            }

            var2.remove();
         }
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-569264191"
   )
   void method1589(int var1) {
      if (var1 >= 0) {
         this.field2684[var1] = 12800;
         this.field2699[var1] = 8192;
         this.field2686[var1] = 16383;
         this.field2690[var1] = 8192;
         this.field2707[var1] = 0;
         this.field2685[var1] = 8192;
         this.method1588(var1);
         this.method1575(var1);
         this.field2697[var1] = 0;
         this.field2694[var1] = 32767;
         this.field2695[var1] = 256;
         this.field2700[var1] = 0;
         this.method1577(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method1589(var1);
         }

      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1716555008"
   )
   void method1569(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if ((var1 < 0 || var2.field2755 == var1) && var2.field2751 < 0) {
            this.field2703[var2.field2755][var2.field2739] = null;
            var2.field2751 = 0;
         }
      }

   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-434781812"
   )
   void method1574() {
      this.method1570(-1);
      this.method1589(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2688[var1] = this.field2687[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2681[var1] = this.field2687[var1] & -128;
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "45"
   )
   void method1588(int var1) {
      if ((this.field2697[var1] & 2) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field2755 == var1 && this.field2703[var1][var2.field2739] == null && var2.field2751 < 0) {
               var2.field2751 = 0;
            }
         }
      }

   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1624323475"
   )
   void method1575(int var1) {
      if ((this.field2697[var1] & 4) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field2755 == var1) {
               var2.field2748 = 0;
            }
         }
      }

   }

   @ObfuscatedName("bu")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "25010659"
   )
   void method1576(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if (var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method1568(var3, var4, var5);
      } else if (var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var5 > 0) {
            this.method1595(var3, var4, var5);
         } else {
            this.method1568(var3, var4, 64);
         }

      } else if (var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method1571(var3, var4, var5);
      } else if (var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var4 == 0) {
            this.field2681[var3] = (var5 << 14) + (this.field2681[var3] & -2080769);
         }

         if (var4 == 32) {
            this.field2681[var3] = (var5 << 7) + (this.field2681[var3] & -16257);
         }

         if (var4 == 1) {
            this.field2707[var3] = (var5 << 7) + (this.field2707[var3] & -16257);
         }

         if (var4 == 33) {
            this.field2707[var3] = var5 + (this.field2707[var3] & -128);
         }

         if (var4 == 5) {
            this.field2685[var3] = (var5 << 7) + (this.field2685[var3] & -16257);
         }

         if (var4 == 37) {
            this.field2685[var3] = var5 + (this.field2685[var3] & -128);
         }

         if (var4 == 7) {
            this.field2684[var3] = (var5 << 7) + (this.field2684[var3] & -16257);
         }

         if (var4 == 39) {
            this.field2684[var3] = var5 + (this.field2684[var3] & -128);
         }

         if (var4 == 10) {
            this.field2699[var3] = (var5 << 7) + (this.field2699[var3] & -16257);
         }

         if (var4 == 42) {
            this.field2699[var3] = var5 + (this.field2699[var3] & -128);
         }

         if (var4 == 11) {
            this.field2686[var3] = (var5 << 7) + (this.field2686[var3] & -16257);
         }

         if (var4 == 43) {
            this.field2686[var3] = var5 + (this.field2686[var3] & -128);
         }

         if (var4 == 64) {
            if (var5 >= 64) {
               this.field2697[var3] |= 1;
            } else {
               this.field2697[var3] &= -2;
            }
         }

         if (var4 == 65) {
            if (var5 >= 64) {
               this.field2697[var3] |= 2;
            } else {
               this.method1588(var3);
               this.field2697[var3] &= -3;
            }
         }

         if (var4 == 99) {
            this.field2694[var3] = (var5 << 7) + (this.field2694[var3] & 127);
         }

         if (var4 == 98) {
            this.field2694[var3] = (this.field2694[var3] & 16256) + var5;
         }

         if (var4 == 101) {
            this.field2694[var3] = (var5 << 7) + (this.field2694[var3] & 127) + 16384;
         }

         if (var4 == 100) {
            this.field2694[var3] = (this.field2694[var3] & 16256) + var5 + 16384;
         }

         if (var4 == 120) {
            this.method1570(var3);
         }

         if (var4 == 121) {
            this.method1589(var3);
         }

         if (var4 == 123) {
            this.method1569(var3);
         }

         int var6;
         if (var4 == 6) {
            var6 = this.field2694[var3];
            if (var6 == 16384) {
               this.field2695[var3] = (var5 << 7) + (this.field2695[var3] & -16257);
            }
         }

         if (var4 == 38) {
            var6 = this.field2694[var3];
            if (var6 == 16384) {
               this.field2695[var3] = var5 + (this.field2695[var3] & -128);
            }
         }

         if (var4 == 16) {
            this.field2700[var3] = (var5 << 7) + (this.field2700[var3] & -16257);
         }

         if (var4 == 48) {
            this.field2700[var3] = var5 + (this.field2700[var3] & -128);
         }

         if (var4 == 81) {
            if (var5 >= 64) {
               this.field2697[var3] |= 4;
            } else {
               this.method1575(var3);
               this.field2697[var3] &= -5;
            }
         }

         if (var4 == 17) {
            this.method1577(var3, (var5 << 7) + (this.field2689[var3] & -16257));
         }

         if (var4 == 49) {
            this.method1577(var3, var5 + (this.field2689[var3] & -128));
         }

      } else if (var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method1592(var3, var4 + this.field2681[var3]);
      } else if (var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method1572(var3, var4);
      } else if (var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method1573(var3, var4);
      } else {
         var2 = var1 & 255;
         if (var2 == 255) {
            this.method1574();
         }
      }
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "0"
   )
   void method1577(int var1, int var2) {
      this.field2689[var1] = var2;
      this.field2698[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(Llp;B)I",
      garbageValue = "0"
   )
   int method1578(MusicPatchNode var1) {
      int var2 = (var1.field2743 * var1.field2744 >> 12) + var1.field2742;
      var2 += (this.field2690[var1.field2755] - 8192) * this.field2695[var1.field2755] >> 12;
      MusicPatchNode2 var3 = var1.field2737;
      int var4;
      if (var3.field2663 > 0 && (var3.field2670 > 0 || this.field2707[var1.field2755] > 0)) {
         var4 = var3.field2670 << 2;
         int var5 = var3.field2667 << 1;
         if (var1.field2750 < var5) {
            var4 = var4 * var1.field2750 / var5;
         }

         var4 += this.field2707[var1.field2755] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2738 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)PcmPlayer.field194 + 0.5D);
      return var4 < 1 ? 1 : var4;
   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      descriptor = "(Llp;B)I",
      garbageValue = "0"
   )
   int method1579(MusicPatchNode var1) {
      MusicPatchNode2 var2 = var1.field2737;
      int var3 = this.field2686[var1.field2755] * this.field2684[var1.field2755] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2754 + 16384 >> 15;
      var3 = var3 * this.field2682 + 128 >> 8;
      if (var2.field2665 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2665 * 1.953125E-5D * (double)var1.field2740) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if (var2.field2669 != null) {
         var4 = var1.field2746;
         var5 = var2.field2669[var1.field2747 + 1];
         if (var1.field2747 < var2.field2669.length - 2) {
            var6 = (var2.field2669[var1.field2747] & 255) << 8;
            var7 = (var2.field2669[var1.field2747 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2669[var1.field2747 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if (var1.field2751 > 0 && var2.field2664 != null) {
         var4 = var1.field2751;
         var5 = var2.field2664[var1.field2749 + 1];
         if (var1.field2749 < var2.field2664.length - 2) {
            var6 = (var2.field2664[var1.field2749] & 255) << 8;
            var7 = (var2.field2664[var1.field2749 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2664[var1.field2749 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(Llp;I)I",
      garbageValue = "-1478359391"
   )
   int method1580(MusicPatchNode var1) {
      int var2 = this.field2699[var1.field2755];
      return var2 < 8192 ? var2 * var1.field2741 + 32 >> 6 : 16384 - ((128 - var1.field2741) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "1307"
   )
   void method1585() {
      int var1 = this.track;
      int var2 = this.trackLength;

      long var3;
      for(var3 = this.field2706; var2 == this.trackLength; var3 = this.midiFile.method1599(var2)) {
         while(var2 == this.midiFile.trackLengths[var1]) {
            this.midiFile.gotoTrack(var1);
            int var5 = this.midiFile.readMessage(var1);
            if (var5 == 1) {
               this.midiFile.setTrackDone();
               this.midiFile.markTrackPosition(var1);
               if (this.midiFile.isDone()) {
                  if (!this.field2702 || var2 == 0) {
                     this.method1574();
                     this.midiFile.clear();
                     return;
                  }

                  this.midiFile.reset(var3);
               }
               break;
            }

            if ((var5 & 128) != 0) {
               this.method1576(var5);
            }

            this.midiFile.readTrackLength(var1);
            this.midiFile.markTrackPosition(var1);
         }

         var1 = this.midiFile.getPrioritizedTrack();
         var2 = this.midiFile.trackLengths[var1];
      }

      this.track = var1;
      this.trackLength = var2;
      this.field2706 = var3;
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(Llp;I)Z",
      garbageValue = "-561025908"
   )
   boolean method1586(MusicPatchNode var1) {
      if (var1.stream == null) {
         if (var1.field2751 >= 0) {
            var1.remove();
            if (var1.field2734 > 0 && var1 == this.field2696[var1.field2755][var1.field2734]) {
               this.field2696[var1.field2755][var1.field2734] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(Llp;[IIII)Z",
      garbageValue = "-189241326"
   )
   boolean method1587(MusicPatchNode var1, int[] var2, int var3, int var4) {
      var1.field2753 = PcmPlayer.field194 / 100;
      if (var1.field2751 < 0 || var1.stream != null && !var1.stream.method269()) {
         int var5 = var1.field2744;
         if (var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2685[var1.field2755]) + 0.5D);
            if (var5 < 0) {
               var5 = 0;
            }

            var1.field2744 = var5;
         }

         var1.stream.method248(this.method1578(var1));
         MusicPatchNode2 var6 = var1.field2737;
         boolean var7 = false;
         ++var1.field2750;
         var1.field2738 += var6.field2663;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2739 - 60 << 8) + (var1.field2743 * var1.field2744 >> 12));
         if (var6.field2665 > 0) {
            if (var6.field2668 > 0) {
               var1.field2740 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2668 * var8) + 0.5D);
            } else {
               var1.field2740 += 128;
            }
         }

         if (var6.field2669 != null) {
            if (var6.field2666 > 0) {
               var1.field2746 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2666) + 0.5D);
            } else {
               var1.field2746 += 128;
            }

            while(var1.field2747 < var6.field2669.length - 2 && var1.field2746 > (var6.field2669[var1.field2747 + 2] & 255) << 8) {
               var1.field2747 += 2;
            }

            if (var6.field2669.length - 2 == var1.field2747 && var6.field2669[var1.field2747 + 1] == 0) {
               var7 = true;
            }
         }

         if (var1.field2751 >= 0 && var6.field2664 != null && (this.field2697[var1.field2755] & 1) == 0 && (var1.field2734 < 0 || var1 != this.field2696[var1.field2755][var1.field2734])) {
            if (var6.field2671 > 0) {
               var1.field2751 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2671) + 0.5D);
            } else {
               var1.field2751 += 128;
            }

            while(var1.field2749 < var6.field2664.length - 2 && var1.field2751 > (var6.field2664[var1.field2749 + 2] & 255) << 8) {
               var1.field2749 += 2;
            }

            if (var6.field2664.length - 2 == var1.field2749) {
               var7 = true;
            }
         }

         if (var7) {
            var1.stream.method247(var1.field2753);
            if (var2 != null) {
               var1.stream.fill(var2, var3, var4);
            } else {
               var1.stream.skip(var4);
            }

            if (var1.stream.method280()) {
               this.patchStream.mixer.addSubStream(var1.stream);
            }

            var1.method1624();
            if (var1.field2751 >= 0) {
               var1.remove();
               if (var1.field2734 > 0 && var1 == this.field2696[var1.field2755][var1.field2734]) {
                  this.field2696[var1.field2755][var1.field2734] = null;
               }
            }

            return true;
         } else {
            var1.stream.method246(var1.field2753, this.method1579(var1), this.method1580(var1));
            return false;
         }
      } else {
         var1.method1624();
         var1.remove();
         if (var1.field2734 > 0 && var1 == this.field2696[var1.field2755][var1.field2734]) {
            this.field2696[var1.field2755][var1.field2734] = null;
         }

         return true;
      }
   }
}
