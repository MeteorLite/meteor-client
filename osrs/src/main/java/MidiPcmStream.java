import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ln")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
    @ObfuscatedName("oh")
    @ObfuscatedSignature(
            descriptor = "Lmq;"
    )
    static Widget mousedOverWidgetIf1;
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lrc;"
    )
    NodeHashTable musicPatches = new NodeHashTable(128);
   @ObfuscatedName("an")
   int field2757 = 256;
   @ObfuscatedName("aw")
   int field2735 = 1000000;
   @ObfuscatedName("ac")
   int[] field2744 = new int[16];
   @ObfuscatedName("au")
   int[] field2752 = new int[16];
   @ObfuscatedName("ab")
   int[] field2738 = new int[16];
   @ObfuscatedName("aq")
   int[] field2739 = new int[16];
   @ObfuscatedName("al")
   int[] field2745 = new int[16];
   @ObfuscatedName("at")
   int[] field2741 = new int[16];
   @ObfuscatedName("aa")
   int[] field2742 = new int[16];
   @ObfuscatedName("ay")
   int[] field2740 = new int[16];
   @ObfuscatedName("ao")
   int[] field2760 = new int[16];
   @ObfuscatedName("as")
   int[] field2746 = new int[16];
   @ObfuscatedName("aj")
   int[] field2747 = new int[16];
   @ObfuscatedName("ak")
   int[] field2736 = new int[16];
   @ObfuscatedName("az")
   int[] field2749 = new int[16];
   @ObfuscatedName("ad")
   int[] field2750 = new int[16];
   @ObfuscatedName("ae")
   int[] field2751 = new int[16];
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "[[Llq;"
   )
   MusicPatchNode[][] field2733 = new MusicPatchNode[16][128];
   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "[[Llq;"
   )
   MusicPatchNode[][] field2753 = new MusicPatchNode[16][128];
    @ObfuscatedName("bb")
    @ObfuscatedSignature(
            descriptor = "Llt;"
    )
    MidiFileReader midiFile = new MidiFileReader();
   @ObfuscatedName("bi")
   boolean field2759;
    @ObfuscatedName("be")
    int track;
    @ObfuscatedName("bk")
    int trackLength;
   @ObfuscatedName("bx")
   long field2758;
   @ObfuscatedName("bo")
   long field2737;
    @ObfuscatedName("bz")
    @ObfuscatedSignature(
            descriptor = "Llc;"
    )
    MusicPatchPcmStream patchStream = new MusicPatchPcmStream(this);

   public MidiPcmStream() {
      this.method1626();
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(IB)V",
            garbageValue = "19"
    )
    public synchronized void setPcmStreamVolume(int var1) {
      this.field2757 = var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "29"
   )
   public int method1644() {
      return this.field2757;
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(Lld;Lnm;Lba;II)Z",
            garbageValue = "-1174424990"
    )
    public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
      var1.method1673();
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

         if (!var9.method1663(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if (var5) {
         var1.clear();
      }

      return var5;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-371554309"
    )
    public synchronized void clearAll() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.clear();
      }

   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "34803635"
    )
    public synchronized void removeAll() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.remove();
      }

   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "()Lbp;"
    )
    protected synchronized PcmStream firstSubStream() {
      return this.patchStream;
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "()Lbp;"
    )
    protected synchronized PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("al")
   protected synchronized int vmethod5648() {
      return 0;
   }

    @ObfuscatedName("at")
    protected synchronized void fill(int[] var1, int var2, int var3) {
      if (this.midiFile.isReady()) {
         int var4 = this.midiFile.division * this.field2735 / PcmPlayer.field201;

         do {
            long var5 = (long)var3 * (long)var4 + this.field2758;
            if (this.field2737 - var5 >= 0L) {
               this.field2758 = var5;
               break;
            }

            int var7 = (int)((this.field2737 - this.field2758 + (long)var4 - 1L) / (long)var4);
            this.field2758 += (long)var4 * (long)var7;
            this.patchStream.fill(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method1637();
         } while(this.midiFile.isReady());
      }

      this.patchStream.fill(var1, var2, var3);
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(Lld;ZI)V",
            garbageValue = "-972368442"
    )
    public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
      this.clear();
      this.midiFile.parse(var1.midi);
      this.field2759 = var2;
      this.field2758 = 0L;
      int var3 = this.midiFile.trackCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.midiFile.gotoTrack(var4);
         this.midiFile.readTrackLength(var4);
         this.midiFile.markTrackPosition(var4);
      }

      this.track = this.midiFile.getPrioritizedTrack();
      this.trackLength = this.midiFile.trackLengths[this.track];
      this.field2737 = this.midiFile.method1656(this.trackLength);
   }

    @ObfuscatedName("ay")
    protected synchronized void skip(int var1) {
      if (this.midiFile.isReady()) {
         int var2 = this.midiFile.division * this.field2735 / PcmPlayer.field201;

         do {
            long var3 = this.field2758 + (long)var2 * (long)var1;
            if (this.field2737 - var3 >= 0L) {
               this.field2758 = var3;
               break;
            }

            int var5 = (int)((this.field2737 - this.field2758 + (long)var2 - 1L) / (long)var2);
            this.field2758 += (long)var5 * (long)var2;
            this.patchStream.skip(var5);
            var1 -= var5;
            this.method1637();
         } while(this.midiFile.isReady());
      }

      this.patchStream.skip(var1);
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "4"
    )
    public synchronized void clear() {
      this.midiFile.clear();
      this.method1626();
   }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1577692860"
    )
    public synchronized boolean isReady() {
      return this.midiFile.isReady();
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "-114"
   )
   public synchronized void method1618(int var1, int var2) {
      this.method1619(var1, var2);
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "-22"
   )
   void method1619(int var1, int var2) {
      this.field2739[var1] = var2;
      this.field2741[var1] = var2 & -128;
      this.method1641(var1, var2);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1627005536"
   )
   void method1641(int var1, int var2) {
      if (var2 != this.field2745[var1]) {
         this.field2745[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2753[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "-1380723164"
   )
   void method1620(int var1, int var2, int var3) {
      this.method1621(var1, var2, 64);
      if ((this.field2746[var1] & 2) != 0) {
         for(MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
            if (var4.field2801 == var1 && var4.field2798 < 0) {
               this.field2733[var1][var4.field2788] = null;
               this.field2733[var1][var2] = var4;
               int var5 = (var4.field2793 * var4.field2792 >> 12) + var4.field2804;
               var4.field2804 += var2 - var4.field2788 << 8;
               var4.field2792 = var5 - var4.field2804;
               var4.field2793 = 4096;
               var4.field2788 = var2;
               return;
            }
         }
      }

      MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2745[var1]);
      if (var9 != null) {
         RawSound var8 = var9.rawSounds[var2];
         if (var8 != null) {
            MusicPatchNode var6 = new MusicPatchNode();
            var6.field2801 = var1;
            var6.patch = var9;
            var6.rawSound = var8;
            var6.field2786 = var9.field2775[var2];
            var6.field2784 = var9.field2776[var2];
            var6.field2788 = var2;
            var6.field2789 = var3 * var3 * var9.field2773[var2] * var9.field2772 + 1024 >> 11;
            var6.field2790 = var9.field2774[var2] & 255;
            var6.field2804 = (var2 << 8) - (var9.field2771[var2] & 32767);
            var6.field2794 = 0;
            var6.field2795 = 0;
            var6.field2802 = 0;
            var6.field2798 = -1;
            var6.field2783 = 0;
            if (this.field2749[var1] == 0) {
               var6.stream = RawPcmStream.method294(var8, this.method1630(var6), this.method1631(var6), this.method1632(var6));
            } else {
               var6.stream = RawPcmStream.method294(var8, this.method1630(var6), 0, this.method1632(var6));
               this.method1639(var6, var9.field2771[var2] < 0);
            }

            if (var9.field2771[var2] < 0) {
               var6.stream.setNumLoops(-1);
            }

            if (var6.field2784 >= 0) {
               MusicPatchNode var7 = this.field2753[var1][var6.field2784];
               if (var7 != null && var7.field2798 < 0) {
                  this.field2733[var1][var7.field2788] = null;
                  var7.field2798 = 0;
               }

               this.field2753[var1][var6.field2784] = var6;
            }

            this.patchStream.queue.addFirst(var6);
            this.field2733[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(Llq;ZI)V",
      garbageValue = "2140923303"
   )
   void method1639(MusicPatchNode var1, boolean var2) {
      int var3 = var1.rawSound.samples.length;
      int var4;
      if (var2 && var1.rawSound.field176) {
         int var5 = var3 + var3 - var1.rawSound.start;
         var4 = (int)((long)this.field2749[var1.field2801] * (long)var5 >> 6);
         var3 <<= 8;
         if (var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.stream.method264();
         }
      } else {
         var4 = (int)((long)this.field2749[var1.field2801] * (long)var3 >> 6);
      }

      var1.stream.method263(var4);
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(IIIB)V",
      garbageValue = "71"
   )
   void method1621(int var1, int var2, int var3) {
      MusicPatchNode var4 = this.field2733[var1][var2];
      if (var4 != null) {
         this.field2733[var1][var2] = null;
         if ((this.field2746[var1] & 2) != 0) {
            for(MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
               if (var5.field2801 == var4.field2801 && var5.field2798 < 0 && var5 != var4) {
                  var4.field2798 = 0;
                  break;
               }
            }
         } else {
            var4.field2798 = 0;
         }

      }
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "-939740093"
   )
   void method1622(int var1, int var2, int var3) {
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1736841186"
   )
   void method1642(int var1, int var2) {
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1611025845"
   )
   void method1623(int var1, int var2) {
      this.field2742[var1] = var2;
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1037039964"
   )
   void method1624(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if (var1 < 0 || var2.field2801 == var1) {
            if (var2.stream != null) {
               var2.stream.method268(PcmPlayer.field201 / 100);
               if (var2.stream.method299()) {
                  this.patchStream.mixer.addSubStream(var2.stream);
               }

               var2.method1679();
            }

            if (var2.field2798 < 0) {
               this.field2733[var2.field2801][var2.field2788] = null;
            }

            var2.remove();
         }
      }

   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1613137555"
   )
   void method1625(int var1) {
      if (var1 >= 0) {
         this.field2744[var1] = 12800;
         this.field2752[var1] = 8192;
         this.field2738[var1] = 16383;
         this.field2742[var1] = 8192;
         this.field2740[var1] = 0;
         this.field2760[var1] = 8192;
         this.method1640(var1);
         this.method1627(var1);
         this.field2746[var1] = 0;
         this.field2747[var1] = 32767;
         this.field2736[var1] = 256;
         this.field2749[var1] = 0;
         this.method1629(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method1625(var1);
         }

      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-2058759132"
   )
   void method1612(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if ((var1 < 0 || var2.field2801 == var1) && var2.field2798 < 0) {
            this.field2733[var2.field2801][var2.field2788] = null;
            var2.field2798 = 0;
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-964267539"
   )
   void method1626() {
      this.method1624(-1);
      this.method1625(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2745[var1] = this.field2739[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2741[var1] = this.field2739[var1] & -128;
      }

   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-109"
   )
   void method1640(int var1) {
      if ((this.field2746[var1] & 2) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field2801 == var1 && this.field2733[var1][var2.field2788] == null && var2.field2798 < 0) {
               var2.field2798 = 0;
            }
         }
      }

   }

   @ObfuscatedName("bn")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1437271181"
   )
   void method1627(int var1) {
      if ((this.field2746[var1] & 4) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field2801 == var1) {
               var2.field2803 = 0;
            }
         }
      }

   }

   @ObfuscatedName("bs")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1376449037"
   )
   void method1628(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if (var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method1621(var3, var4, var5);
      } else if (var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var5 > 0) {
            this.method1620(var3, var4, var5);
         } else {
            this.method1621(var3, var4, 64);
         }

      } else if (var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method1622(var3, var4, var5);
      } else if (var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var4 == 0) {
            this.field2741[var3] = (var5 << 14) + (this.field2741[var3] & -2080769);
         }

         if (var4 == 32) {
            this.field2741[var3] = (var5 << 7) + (this.field2741[var3] & -16257);
         }

         if (var4 == 1) {
            this.field2740[var3] = (var5 << 7) + (this.field2740[var3] & -16257);
         }

         if (var4 == 33) {
            this.field2740[var3] = var5 + (this.field2740[var3] & -128);
         }

         if (var4 == 5) {
            this.field2760[var3] = (var5 << 7) + (this.field2760[var3] & -16257);
         }

         if (var4 == 37) {
            this.field2760[var3] = var5 + (this.field2760[var3] & -128);
         }

         if (var4 == 7) {
            this.field2744[var3] = (var5 << 7) + (this.field2744[var3] & -16257);
         }

         if (var4 == 39) {
            this.field2744[var3] = var5 + (this.field2744[var3] & -128);
         }

         if (var4 == 10) {
            this.field2752[var3] = (var5 << 7) + (this.field2752[var3] & -16257);
         }

         if (var4 == 42) {
            this.field2752[var3] = var5 + (this.field2752[var3] & -128);
         }

         if (var4 == 11) {
            this.field2738[var3] = (var5 << 7) + (this.field2738[var3] & -16257);
         }

         if (var4 == 43) {
            this.field2738[var3] = var5 + (this.field2738[var3] & -128);
         }

         if (var4 == 64) {
            if (var5 >= 64) {
               this.field2746[var3] |= 1;
            } else {
               this.field2746[var3] &= -2;
            }
         }

         if (var4 == 65) {
            if (var5 >= 64) {
               this.field2746[var3] |= 2;
            } else {
               this.method1640(var3);
               this.field2746[var3] &= -3;
            }
         }

         if (var4 == 99) {
            this.field2747[var3] = (var5 << 7) + (this.field2747[var3] & 127);
         }

         if (var4 == 98) {
            this.field2747[var3] = (this.field2747[var3] & 16256) + var5;
         }

         if (var4 == 101) {
            this.field2747[var3] = (var5 << 7) + (this.field2747[var3] & 127) + 16384;
         }

         if (var4 == 100) {
            this.field2747[var3] = (this.field2747[var3] & 16256) + var5 + 16384;
         }

         if (var4 == 120) {
            this.method1624(var3);
         }

         if (var4 == 121) {
            this.method1625(var3);
         }

         if (var4 == 123) {
            this.method1612(var3);
         }

         int var6;
         if (var4 == 6) {
            var6 = this.field2747[var3];
            if (var6 == 16384) {
               this.field2736[var3] = (var5 << 7) + (this.field2736[var3] & -16257);
            }
         }

         if (var4 == 38) {
            var6 = this.field2747[var3];
            if (var6 == 16384) {
               this.field2736[var3] = var5 + (this.field2736[var3] & -128);
            }
         }

         if (var4 == 16) {
            this.field2749[var3] = (var5 << 7) + (this.field2749[var3] & -16257);
         }

         if (var4 == 48) {
            this.field2749[var3] = var5 + (this.field2749[var3] & -128);
         }

         if (var4 == 81) {
            if (var5 >= 64) {
               this.field2746[var3] |= 4;
            } else {
               this.method1627(var3);
               this.field2746[var3] &= -5;
            }
         }

         if (var4 == 17) {
            this.method1629(var3, (var5 << 7) + (this.field2750[var3] & -16257));
         }

         if (var4 == 49) {
            this.method1629(var3, var5 + (this.field2750[var3] & -128));
         }

      } else if (var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method1641(var3, var4 + this.field2741[var3]);
      } else if (var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method1642(var3, var4);
      } else if (var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method1623(var3, var4);
      } else {
         var2 = var1 & 255;
         if (var2 == 255) {
            this.method1626();
         }
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-1731550836"
   )
   void method1629(int var1, int var2) {
      this.field2750[var1] = var2;
      this.field2751[var1] = (int)(2097152.0D * Math.pow(2.0D, 5.4931640625E-4D * (double)var2) + 0.5D);
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(Llq;I)I",
      garbageValue = "1667221549"
   )
   int method1630(MusicPatchNode var1) {
      int var2 = (var1.field2792 * var1.field2793 >> 12) + var1.field2804;
      var2 += (this.field2742[var1.field2801] - 8192) * this.field2736[var1.field2801] >> 12;
      MusicPatchNode2 var3 = var1.field2786;
      int var4;
      if (var3.field2724 > 0 && (var3.field2723 > 0 || this.field2740[var1.field2801] > 0)) {
         var4 = var3.field2723 << 2;
         int var5 = var3.field2721 << 1;
         if (var1.field2799 < var5) {
            var4 = var4 * var1.field2799 / var5;
         }

         var4 += this.field2740[var1.field2801] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2791 & 511));
         var2 += (int)(var6 * (double)var4);
      }

      var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)PcmPlayer.field201 + 0.5D);
      return var4 < 1 ? 1 : var4;
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "(Llq;I)I",
      garbageValue = "-606314672"
   )
   int method1631(MusicPatchNode var1) {
      MusicPatchNode2 var2 = var1.field2786;
      int var3 = this.field2744[var1.field2801] * this.field2738[var1.field2801] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2789 + 16384 >> 15;
      var3 = var3 * this.field2757 + 128 >> 8;
      if (var2.field2719 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2719 * (double)var1.field2794 * 1.953125E-5D) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if (var2.field2718 != null) {
         var4 = var1.field2795;
         var5 = var2.field2718[var1.field2802 + 1];
         if (var1.field2802 < var2.field2718.length - 2) {
            var6 = (var2.field2718[var1.field2802] & 255) << 8;
            var7 = (var2.field2718[var1.field2802 + 2] & 255) << 8;
            var5 += (var2.field2718[var1.field2802 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if (var1.field2798 > 0 && var2.field2717 != null) {
         var4 = var1.field2798;
         var5 = var2.field2717[var1.field2783 + 1];
         if (var1.field2783 < var2.field2717.length - 2) {
            var6 = (var2.field2717[var1.field2783] & 255) << 8;
            var7 = (var2.field2717[var1.field2783 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2717[var1.field2783 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(Llq;I)I",
      garbageValue = "-941309509"
   )
   int method1632(MusicPatchNode var1) {
      int var2 = this.field2752[var1.field2801];
      return var2 < 8192 ? var2 * var1.field2790 + 32 >> 6 : 16384 - ((128 - var1.field2790) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("bp")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "486029060"
   )
   void method1637() {
      int var1 = this.track;
      int var2 = this.trackLength;

      long var3;
      for(var3 = this.field2737; var2 == this.trackLength; var3 = this.midiFile.method1656(var2)) {
         while(var2 == this.midiFile.trackLengths[var1]) {
            this.midiFile.gotoTrack(var1);
            int var5 = this.midiFile.readMessage(var1);
            if (var5 == 1) {
               this.midiFile.setTrackDone();
               this.midiFile.markTrackPosition(var1);
               if (this.midiFile.isDone()) {
                  if (!this.field2759 || var2 == 0) {
                     this.method1626();
                     this.midiFile.clear();
                     return;
                  }

                  this.midiFile.reset(var3);
               }
               break;
            }

            if ((var5 & 128) != 0) {
               this.method1628(var5);
            }

            this.midiFile.readTrackLength(var1);
            this.midiFile.markTrackPosition(var1);
         }

         var1 = this.midiFile.getPrioritizedTrack();
         var2 = this.midiFile.trackLengths[var1];
      }

      this.track = var1;
      this.trackLength = var2;
      this.field2737 = var3;
   }

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      descriptor = "(Llq;S)Z",
      garbageValue = "19212"
   )
   boolean method1646(MusicPatchNode var1) {
      if (var1.stream == null) {
         if (var1.field2798 >= 0) {
            var1.remove();
            if (var1.field2784 > 0 && var1 == this.field2753[var1.field2801][var1.field2784]) {
               this.field2753[var1.field2801][var1.field2784] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(Llq;[IIII)Z",
      garbageValue = "577556390"
   )
   boolean method1638(MusicPatchNode var1, int[] var2, int var3, int var4) {
      var1.field2796 = PcmPlayer.field201 / 100;
      if (var1.field2798 < 0 || var1.stream != null && !var1.stream.method296()) {
         int var5 = var1.field2793;
         if (var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2760[var1.field2801] * 4.921259842519685E-4D) + 0.5D);
            if (var5 < 0) {
               var5 = 0;
            }

            var1.field2793 = var5;
         }

         var1.stream.method269(this.method1630(var1));
         MusicPatchNode2 var6 = var1.field2786;
         boolean var7 = false;
         ++var1.field2799;
         var1.field2791 += var6.field2724;
         double var8 = 5.086263020833333E-6D * (double)((var1.field2788 - 60 << 8) + (var1.field2792 * var1.field2793 >> 12));
         if (var6.field2719 > 0) {
            if (var6.field2722 > 0) {
               var1.field2794 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2722 * var8) + 0.5D);
            } else {
               var1.field2794 += 128;
            }
         }

         if (var6.field2718 != null) {
            if (var6.field2720 > 0) {
               var1.field2795 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2720 * var8) + 0.5D);
            } else {
               var1.field2795 += 128;
            }

            while(var1.field2802 < var6.field2718.length - 2 && var1.field2795 > (var6.field2718[var1.field2802 + 2] & 255) << 8) {
               var1.field2802 += 2;
            }

            if (var6.field2718.length - 2 == var1.field2802 && var6.field2718[var1.field2802 + 1] == 0) {
               var7 = true;
            }
         }

         if (var1.field2798 >= 0 && var6.field2717 != null && (this.field2746[var1.field2801] & 1) == 0 && (var1.field2784 < 0 || var1 != this.field2753[var1.field2801][var1.field2784])) {
            if (var6.field2725 > 0) {
               var1.field2798 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2725 * var8) + 0.5D);
            } else {
               var1.field2798 += 128;
            }

            while(var1.field2783 < var6.field2717.length - 2 && var1.field2798 > (var6.field2717[var1.field2783 + 2] & 255) << 8) {
               var1.field2783 += 2;
            }

            if (var6.field2717.length - 2 == var1.field2783) {
               var7 = true;
            }
         }

         if (var7) {
            var1.stream.method268(var1.field2796);
            if (var2 != null) {
               var1.stream.fill(var2, var3, var4);
            } else {
               var1.stream.skip(var4);
            }

            if (var1.stream.method299()) {
               this.patchStream.mixer.addSubStream(var1.stream);
            }

            var1.method1679();
            if (var1.field2798 >= 0) {
               var1.remove();
               if (var1.field2784 > 0 && var1 == this.field2753[var1.field2801][var1.field2784]) {
                  this.field2753[var1.field2801][var1.field2784] = null;
               }
            }

            return true;
         } else {
            var1.stream.method267(var1.field2796, this.method1631(var1), this.method1632(var1));
            return false;
         }
      } else {
         var1.method1679();
         var1.remove();
         if (var1.field2784 > 0 && var1 == this.field2753[var1.field2801][var1.field2784]) {
            this.field2753[var1.field2801][var1.field2784] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;I)V",
      garbageValue = "-2144469370"
   )
   public static void method1647(AbstractArchive var0) {
      EnumComposition.EnumDefinition_archive = var0;
   }
}
