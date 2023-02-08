import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ky")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
   @ObfuscatedName("fc")
   static int field2725;
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lqg;"
    )
    NodeHashTable musicPatches = new NodeHashTable(128);
   @ObfuscatedName("v")
   int field2710 = 256;
   @ObfuscatedName("s")
   int field2711 = 1000000;
   @ObfuscatedName("z")
   int[] field2712 = new int[16];
   @ObfuscatedName("j")
   int[] field2736 = new int[16];
   @ObfuscatedName("i")
   int[] field2714 = new int[16];
   @ObfuscatedName("n")
   int[] field2732 = new int[16];
   @ObfuscatedName("l")
   int[] field2716 = new int[16];
   @ObfuscatedName("k")
   int[] field2713 = new int[16];
   @ObfuscatedName("c")
   int[] field2718 = new int[16];
   @ObfuscatedName("r")
   int[] field2724 = new int[16];
   @ObfuscatedName("b")
   int[] field2720 = new int[16];
   @ObfuscatedName("x")
   int[] field2719 = new int[16];
   @ObfuscatedName("a")
   int[] field2722 = new int[16];
   @ObfuscatedName("q")
   int[] field2723 = new int[16];
   @ObfuscatedName("d")
   int[] field2728 = new int[16];
   @ObfuscatedName("e")
   int[] field2709 = new int[16];
   @ObfuscatedName("g")
   int[] field2717 = new int[16];
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "[[Lkv;"
   )
   MusicPatchNode[][] field2727 = new MusicPatchNode[16][128];
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "[[Lkv;"
   )
   MusicPatchNode[][] field2735 = new MusicPatchNode[16][128];
    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "Lkj;"
    )
    MidiFileReader midiFile = new MidiFileReader();
   @ObfuscatedName("ai")
   boolean field2715;
    @ObfuscatedName("ag")
    int track;
    @ObfuscatedName("aw")
    int trackLength;
   @ObfuscatedName("ar")
   long field2733;
   @ObfuscatedName("al")
   long field2734;
    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "Lkt;"
    )
    MusicPatchPcmStream patchStream = new MusicPatchPcmStream(this);

   public MidiPcmStream() {
      this.method1573();
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "-921376443"
    )
    public synchronized void setPcmStreamVolume(int var1) {
      this.field2710 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-548589206"
   )
   public int method1556() {
      return this.field2710;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lkd;Lln;Lah;IB)Z",
            garbageValue = "81"
    )
    public synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
      var1.method1618();
      boolean var5 = true;
      int[] var6 = null;
      if (var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
         int var8 = (int)var7.key;
         MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
         if (var9 == null) {
            var9 = class155.method831(var2, var8);
            if (var9 == null) {
               var5 = false;
               continue;
            }

            this.musicPatches.put(var9, (long)var8);
         }

         if (!var9.method1606(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if (var5) {
         var1.clear();
      }

      return var5;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-128962148"
    )
    public synchronized void clearAll() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.clear();
      }

   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-693763094"
    )
    public synchronized void removeAll() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.remove();
      }

   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected synchronized PcmStream firstSubStream() {
      return this.patchStream;
   }

    @ObfuscatedName("i")
    @ObfuscatedSignature(
            descriptor = "()Lan;"
    )
    protected synchronized PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("n")
   protected synchronized int vmethod5648() {
      return 0;
   }

    @ObfuscatedName("l")
    protected synchronized void fill(int[] var1, int var2, int var3) {
      if (this.midiFile.isReady()) {
         int var4 = this.midiFile.division * this.field2711 / class284.field2683;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2733;
            if (this.field2734 - var5 >= 0L) {
               this.field2733 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2734 - this.field2733) - 1L) / (long)var4);
            this.field2733 += (long)var4 * (long)var7;
            this.patchStream.fill(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method1586();
         } while(this.midiFile.isReady());
      }

      this.patchStream.fill(var1, var2, var3);
   }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(Lkd;ZI)V",
            garbageValue = "1213360117"
    )
    public synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
      this.clear();
      this.midiFile.parse(var1.midi);
      this.field2715 = var2;
      this.field2733 = 0L;
      int var3 = this.midiFile.trackCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.midiFile.gotoTrack(var4);
         this.midiFile.readTrackLength(var4);
         this.midiFile.markTrackPosition(var4);
      }

      this.track = this.midiFile.getPrioritizedTrack();
      this.trackLength = this.midiFile.trackLengths[this.track];
      this.field2734 = this.midiFile.method1600(this.trackLength);
   }

    @ObfuscatedName("c")
    protected synchronized void skip(int var1) {
      if (this.midiFile.isReady()) {
         int var2 = this.midiFile.division * this.field2711 / class284.field2683;

         do {
            long var3 = this.field2733 + (long)var1 * (long)var2;
            if (this.field2734 - var3 >= 0L) {
               this.field2733 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2734 - this.field2733) - 1L) / (long)var2);
            this.field2733 += (long)var2 * (long)var5;
            this.patchStream.skip(var5);
            var1 -= var5;
            this.method1586();
         } while(this.midiFile.isReady());
      }

      this.patchStream.skip(var1);
   }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "2145050906"
    )
    public synchronized void clear() {
      this.midiFile.clear();
      this.method1573();
   }

    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-643635418"
    )
    public synchronized boolean isReady() {
      return this.midiFile.isReady();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "120"
   )
   public synchronized void method1562(int var1, int var2) {
      this.method1563(var1, var2);
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-571066266"
   )
   void method1563(int var1, int var2) {
      this.field2732[var1] = var2;
      this.field2713[var1] = var2 & -128;
      this.method1564(var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1695536423"
   )
   void method1564(int var1, int var2) {
      if (var2 != this.field2716[var1]) {
         this.field2716[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2735[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "1757055647"
   )
   void method1565(int var1, int var2, int var3) {
      this.method1567(var1, var2, 64);
      if ((this.field2719[var1] & 2) != 0) {
         for(MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
            if (var4.field2771 == var1 && var4.field2775 < 0) {
               this.field2727[var1][var4.field2766] = null;
               this.field2727[var1][var2] = var4;
               int var5 = (var4.field2763 * var4.field2774 >> 12) + var4.field2769;
               var4.field2769 += var2 - var4.field2766 << 8;
               var4.field2763 = var5 - var4.field2769;
               var4.field2774 = 4096;
               var4.field2766 = var2;
               return;
            }
         }
      }

      MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2716[var1]);
      if (var9 != null) {
         RawSound var8 = var9.rawSounds[var2];
         if (var8 != null) {
            MusicPatchNode var6 = new MusicPatchNode();
            var6.field2771 = var1;
            var6.patch = var9;
            var6.rawSound = var8;
            var6.field2764 = var9.field2747[var2];
            var6.field2765 = var9.field2751[var2];
            var6.field2766 = var2;
            var6.field2767 = var3 * var3 * var9.field2748[var2] * var9.field2750 + 1024 >> 11;
            var6.field2768 = var9.field2749[var2] & 255;
            var6.field2769 = (var2 << 8) - (var9.field2755[var2] & 32767);
            var6.field2772 = 0;
            var6.field2773 = 0;
            var6.field2777 = 0;
            var6.field2775 = -1;
            var6.field2761 = 0;
            if (this.field2728[var1] == 0) {
               var6.stream = RawPcmStream.method257(var8, this.method1577(var6), this.method1578(var6), this.method1554(var6));
            } else {
               var6.stream = RawPcmStream.method257(var8, this.method1577(var6), 0, this.method1554(var6));
               this.method1584(var6, var9.field2755[var2] < 0);
            }

            if (var9.field2755[var2] < 0) {
               var6.stream.setNumLoops(-1);
            }

            if (var6.field2765 >= 0) {
               MusicPatchNode var7 = this.field2735[var1][var6.field2765];
               if (var7 != null && var7.field2775 < 0) {
                  this.field2727[var1][var7.field2766] = null;
                  var7.field2775 = 0;
               }

               this.field2735[var1][var6.field2765] = var6;
            }

            this.patchStream.queue.addFirst(var6);
            this.field2727[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(Lkv;ZI)V",
      garbageValue = "1738453403"
   )
   void method1584(MusicPatchNode var1, boolean var2) {
      int var3 = var1.rawSound.samples.length;
      int var4;
      if (var2 && var1.rawSound.field184) {
         int var5 = var3 + var3 - var1.rawSound.start;
         var4 = (int)((long)this.field2728[var1.field2771] * (long)var5 >> 6);
         var3 <<= 8;
         if (var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.stream.method255();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2728[var1.field2771] >> 6);
      }

      var1.stream.method240(var4);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(IIIB)V",
      garbageValue = "74"
   )
   void method1567(int var1, int var2, int var3) {
      MusicPatchNode var4 = this.field2727[var1][var2];
      if (var4 != null) {
         this.field2727[var1][var2] = null;
         if ((this.field2719[var1] & 2) != 0) {
            for(MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
               if (var5.field2771 == var4.field2771 && var5.field2775 < 0 && var4 != var5) {
                  var4.field2775 = 0;
                  break;
               }
            }
         } else {
            var4.field2775 = 0;
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "-2120112247"
   )
   void method1568(int var1, int var2, int var3) {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1370666986"
   )
   void method1569(int var1, int var2) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1376092933"
   )
   void method1570(int var1, int var2) {
      this.field2718[var1] = var2;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-110"
   )
   void method1571(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if (var1 < 0 || var2.field2771 == var1) {
            if (var2.stream != null) {
               var2.stream.method243(class284.field2683 / 100);
               if (var2.stream.method247()) {
                  this.patchStream.mixer.addSubStream(var2.stream);
               }

               var2.method1620();
            }

            if (var2.field2775 < 0) {
               this.field2727[var2.field2771][var2.field2766] = null;
            }

            var2.remove();
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-525596200"
   )
   void method1572(int var1) {
      if (var1 >= 0) {
         this.field2712[var1] = 12800;
         this.field2736[var1] = 8192;
         this.field2714[var1] = 16383;
         this.field2718[var1] = 8192;
         this.field2724[var1] = 0;
         this.field2720[var1] = 8192;
         this.method1574(var1);
         this.method1575(var1);
         this.field2719[var1] = 0;
         this.field2722[var1] = 32767;
         this.field2723[var1] = 256;
         this.field2728[var1] = 0;
         this.method1555(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method1572(var1);
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1393661383"
   )
   void method1585(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if ((var1 < 0 || var2.field2771 == var1) && var2.field2775 < 0) {
            this.field2727[var2.field2771][var2.field2766] = null;
            var2.field2775 = 0;
         }
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1548255752"
   )
   void method1573() {
      this.method1571(-1);
      this.method1572(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2716[var1] = this.field2732[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2713[var1] = this.field2732[var1] & -128;
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-446668646"
   )
   void method1574(int var1) {
      if ((this.field2719[var1] & 2) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field2771 == var1 && this.field2727[var1][var2.field2766] == null && var2.field2775 < 0) {
               var2.field2775 = 0;
            }
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1107503455"
   )
   void method1575(int var1) {
      if ((this.field2719[var1] & 4) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field2771 == var1) {
               var2.field2781 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1277317735"
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
         this.method1567(var3, var4, var5);
      } else if (var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var5 > 0) {
            this.method1565(var3, var4, var5);
         } else {
            this.method1567(var3, var4, 64);
         }

      } else if (var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method1568(var3, var4, var5);
      } else if (var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var4 == 0) {
            this.field2713[var3] = (var5 << 14) + (this.field2713[var3] & -2080769);
         }

         if (var4 == 32) {
            this.field2713[var3] = (var5 << 7) + (this.field2713[var3] & -16257);
         }

         if (var4 == 1) {
            this.field2724[var3] = (var5 << 7) + (this.field2724[var3] & -16257);
         }

         if (var4 == 33) {
            this.field2724[var3] = var5 + (this.field2724[var3] & -128);
         }

         if (var4 == 5) {
            this.field2720[var3] = (var5 << 7) + (this.field2720[var3] & -16257);
         }

         if (var4 == 37) {
            this.field2720[var3] = var5 + (this.field2720[var3] & -128);
         }

         if (var4 == 7) {
            this.field2712[var3] = (var5 << 7) + (this.field2712[var3] & -16257);
         }

         if (var4 == 39) {
            this.field2712[var3] = var5 + (this.field2712[var3] & -128);
         }

         if (var4 == 10) {
            this.field2736[var3] = (var5 << 7) + (this.field2736[var3] & -16257);
         }

         if (var4 == 42) {
            this.field2736[var3] = var5 + (this.field2736[var3] & -128);
         }

         if (var4 == 11) {
            this.field2714[var3] = (var5 << 7) + (this.field2714[var3] & -16257);
         }

         if (var4 == 43) {
            this.field2714[var3] = var5 + (this.field2714[var3] & -128);
         }

         if (var4 == 64) {
            if (var5 >= 64) {
               this.field2719[var3] |= 1;
            } else {
               this.field2719[var3] &= -2;
            }
         }

         if (var4 == 65) {
            if (var5 >= 64) {
               this.field2719[var3] |= 2;
            } else {
               this.method1574(var3);
               this.field2719[var3] &= -3;
            }
         }

         if (var4 == 99) {
            this.field2722[var3] = (var5 << 7) + (this.field2722[var3] & 127);
         }

         if (var4 == 98) {
            this.field2722[var3] = (this.field2722[var3] & 16256) + var5;
         }

         if (var4 == 101) {
            this.field2722[var3] = (var5 << 7) + (this.field2722[var3] & 127) + 16384;
         }

         if (var4 == 100) {
            this.field2722[var3] = (this.field2722[var3] & 16256) + var5 + 16384;
         }

         if (var4 == 120) {
            this.method1571(var3);
         }

         if (var4 == 121) {
            this.method1572(var3);
         }

         if (var4 == 123) {
            this.method1585(var3);
         }

         int var6;
         if (var4 == 6) {
            var6 = this.field2722[var3];
            if (var6 == 16384) {
               this.field2723[var3] = (var5 << 7) + (this.field2723[var3] & -16257);
            }
         }

         if (var4 == 38) {
            var6 = this.field2722[var3];
            if (var6 == 16384) {
               this.field2723[var3] = var5 + (this.field2723[var3] & -128);
            }
         }

         if (var4 == 16) {
            this.field2728[var3] = (var5 << 7) + (this.field2728[var3] & -16257);
         }

         if (var4 == 48) {
            this.field2728[var3] = var5 + (this.field2728[var3] & -128);
         }

         if (var4 == 81) {
            if (var5 >= 64) {
               this.field2719[var3] |= 4;
            } else {
               this.method1575(var3);
               this.field2719[var3] &= -5;
            }
         }

         if (var4 == 17) {
            this.method1555(var3, (var5 << 7) + (this.field2709[var3] & -16257));
         }

         if (var4 == 49) {
            this.method1555(var3, var5 + (this.field2709[var3] & -128));
         }

      } else if (var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method1564(var3, var4 + this.field2713[var3]);
      } else if (var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method1569(var3, var4);
      } else if (var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method1570(var3, var4);
      } else {
         var2 = var1 & 255;
         if (var2 == 255) {
            this.method1573();
         }
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-800776544"
   )
   void method1555(int var1, int var2) {
      this.field2709[var1] = var2;
      this.field2717[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(Lkv;I)I",
      garbageValue = "-20440613"
   )
   int method1577(MusicPatchNode var1) {
      int var2 = (var1.field2774 * var1.field2763 >> 12) + var1.field2769;
      var2 += (this.field2718[var1.field2771] - 8192) * this.field2723[var1.field2771] >> 12;
      MusicPatchNode2 var3 = var1.field2764;
      int var4;
      if (var3.field2700 > 0 && (var3.field2695 > 0 || this.field2724[var1.field2771] > 0)) {
         var4 = var3.field2695 << 2;
         int var5 = var3.field2696 << 1;
         if (var1.field2776 < var5) {
            var4 = var4 * var1.field2776 / var5;
         }

         var4 += this.field2724[var1.field2771] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2778 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, (double)var2 * 3.255208333333333E-4D) / (double)class284.field2683 + 0.5D);
      return var4 < 1 ? 1 : var4;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(Lkv;B)I",
      garbageValue = "40"
   )
   int method1578(MusicPatchNode var1) {
      MusicPatchNode2 var2 = var1.field2764;
      int var3 = this.field2714[var1.field2771] * this.field2712[var1.field2771] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2767 + 16384 >> 15;
      var3 = var3 * this.field2710 + 128 >> 8;
      if (var2.field2692 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var2.field2692 * 1.953125E-5D * (double)var1.field2772) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if (var2.field2699 != null) {
         var4 = var1.field2773;
         var5 = var2.field2699[var1.field2777 + 1];
         if (var1.field2777 < var2.field2699.length - 2) {
            var6 = (var2.field2699[var1.field2777] & 255) << 8;
            var7 = (var2.field2699[var1.field2777 + 2] & 255) << 8;
            var5 += (var2.field2699[var1.field2777 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      if (var1.field2775 > 0 && var2.field2697 != null) {
         var4 = var1.field2775;
         var5 = var2.field2697[var1.field2761 + 1];
         if (var1.field2761 < var2.field2697.length - 2) {
            var6 = (var2.field2697[var1.field2761] & 255) << 8;
            var7 = (var2.field2697[var1.field2761 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2697[var1.field2761 + 3] - var5) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(Lkv;S)I",
      garbageValue = "3641"
   )
   int method1554(MusicPatchNode var1) {
      int var2 = this.field2736[var1.field2771];
      return var2 < 8192 ? var2 * var1.field2768 + 32 >> 6 : 16384 - ((128 - var1.field2768) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "-25173"
   )
   void method1586() {
      int var1 = this.track;
      int var2 = this.trackLength;

      long var3;
      for(var3 = this.field2734; var2 == this.trackLength; var3 = this.midiFile.method1600(var2)) {
         while(var2 == this.midiFile.trackLengths[var1]) {
            this.midiFile.gotoTrack(var1);
            int var5 = this.midiFile.readMessage(var1);
            if (var5 == 1) {
               this.midiFile.setTrackDone();
               this.midiFile.markTrackPosition(var1);
               if (this.midiFile.isDone()) {
                  if (!this.field2715 || var2 == 0) {
                     this.method1573();
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
      this.field2734 = var3;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(Lkv;I)Z",
      garbageValue = "1287702671"
   )
   boolean method1582(MusicPatchNode var1) {
      if (var1.stream == null) {
         if (var1.field2775 >= 0) {
            var1.remove();
            if (var1.field2765 > 0 && var1 == this.field2735[var1.field2771][var1.field2765]) {
               this.field2735[var1.field2771][var1.field2765] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lkv;[IIII)Z",
      garbageValue = "-834801053"
   )
   boolean method1566(MusicPatchNode var1, int[] var2, int var3, int var4) {
      var1.field2780 = class284.field2683 / 100;
      if (var1.field2775 < 0 || var1.stream != null && !var1.stream.method246()) {
         int var5 = var1.field2774;
         if (var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, (double)this.field2720[var1.field2771] * 4.921259842519685E-4D) + 0.5D);
            if (var5 < 0) {
               var5 = 0;
            }

            var1.field2774 = var5;
         }

         var1.stream.method277(this.method1577(var1));
         MusicPatchNode2 var6 = var1.field2764;
         boolean var7 = false;
         ++var1.field2776;
         var1.field2778 += var6.field2700;
         double var8 = (double)((var1.field2766 - 60 << 8) + (var1.field2774 * var1.field2763 >> 12)) * 5.086263020833333E-6D;
         if (var6.field2692 > 0) {
            if (var6.field2698 > 0) {
               var1.field2772 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2698) + 0.5D);
            } else {
               var1.field2772 += 128;
            }
         }

         if (var6.field2699 != null) {
            if (var6.field2693 > 0) {
               var1.field2773 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2693) + 0.5D);
            } else {
               var1.field2773 += 128;
            }

            while(var1.field2777 < var6.field2699.length - 2 && var1.field2773 > (var6.field2699[var1.field2777 + 2] & 255) << 8) {
               var1.field2777 += 2;
            }

            if (var6.field2699.length - 2 == var1.field2777 && var6.field2699[var1.field2777 + 1] == 0) {
               var7 = true;
            }
         }

         if (var1.field2775 >= 0 && var6.field2697 != null && (this.field2719[var1.field2771] & 1) == 0 && (var1.field2765 < 0 || var1 != this.field2735[var1.field2771][var1.field2765])) {
            if (var6.field2694 > 0) {
               var1.field2775 += (int)(128.0D * Math.pow(2.0D, var8 * (double)var6.field2694) + 0.5D);
            } else {
               var1.field2775 += 128;
            }

            while(var1.field2761 < var6.field2697.length - 2 && var1.field2775 > (var6.field2697[var1.field2761 + 2] & 255) << 8) {
               var1.field2761 += 2;
            }

            if (var6.field2697.length - 2 == var1.field2761) {
               var7 = true;
            }
         }

         if (var7) {
            var1.stream.method243(var1.field2780);
            if (var2 != null) {
               var1.stream.fill(var2, var3, var4);
            } else {
               var1.stream.skip(var4);
            }

            if (var1.stream.method247()) {
               this.patchStream.mixer.addSubStream(var1.stream);
            }

            var1.method1620();
            if (var1.field2775 >= 0) {
               var1.remove();
               if (var1.field2765 > 0 && var1 == this.field2735[var1.field2771][var1.field2765]) {
                  this.field2735[var1.field2771][var1.field2765] = null;
               }
            }

            return true;
         } else {
            var1.stream.method242(var1.field2780, this.method1578(var1), this.method1554(var1));
            return false;
         }
      } else {
         var1.method1620();
         var1.remove();
         if (var1.field2765 > 0 && var1 == this.field2735[var1.field2771][var1.field2765]) {
            this.field2735[var1.field2771][var1.field2765] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "8"
   )
   public static int method1590(int var0) {
      return var0 >>> 4 & class469.field3998;
   }
}
