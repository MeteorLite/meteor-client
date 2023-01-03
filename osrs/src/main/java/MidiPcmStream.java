import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
@Implements("MidiPcmStream")
public class MidiPcmStream extends PcmStream {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lqp;"
   )
   NodeHashTable musicPatches = new NodeHashTable(128);
   @ObfuscatedName("e")
   int field2724 = 256;
   @ObfuscatedName("v")
   int field2732 = 1000000;
   @ObfuscatedName("x")
   int[] field2721 = new int[16];
   @ObfuscatedName("m")
   int[] field2725 = new int[16];
   @ObfuscatedName("q")
   int[] field2729 = new int[16];
   @ObfuscatedName("f")
   int[] field2723 = new int[16];
   @ObfuscatedName("r")
   int[] field2743 = new int[16];
   @ObfuscatedName("u")
   int[] field2735 = new int[16];
   @ObfuscatedName("b")
   int[] field2726 = new int[16];
   @ObfuscatedName("j")
   int[] field2727 = new int[16];
   @ObfuscatedName("g")
   int[] field2728 = new int[16];
   @ObfuscatedName("t")
   int[] field2718 = new int[16];
   @ObfuscatedName("c")
   int[] field2730 = new int[16];
   @ObfuscatedName("p")
   int[] field2731 = new int[16];
   @ObfuscatedName("d")
   int[] field2720 = new int[16];
   @ObfuscatedName("y")
   int[] field2733 = new int[16];
   @ObfuscatedName("z")
   int[] field2734 = new int[16];
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "[[Lkx;"
   )
   MusicPatchNode[][] field2719 = new MusicPatchNode[16][128];
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "[[Lkx;"
   )
   MusicPatchNode[][] field2736 = new MusicPatchNode[16][128];
   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "Lkm;"
   )
   MidiFileReader midiFile = new MidiFileReader();
   @ObfuscatedName("ao")
   boolean field2717;
   @ObfuscatedName("am")
   int track;
   @ObfuscatedName("av")
   int trackLength;
   @ObfuscatedName("au")
   long field2741;
   @ObfuscatedName("ar")
   long field2742;
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "Lkg;"
   )
   MusicPatchPcmStream patchStream = new MusicPatchPcmStream(this);

   public MidiPcmStream() {
      this.method1571();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "9"
   )
   synchronized void setPcmStreamVolume(int var1) {
      this.field2724 = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-278818537"
   )
   int method1568() {
      return this.field2724;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lkc;Lly;Laj;II)Z",
      garbageValue = "-1248465768"
   )
   synchronized boolean loadMusicTrack(MusicTrack var1, AbstractArchive var2, SoundCache var3, int var4) {
      var1.method1600();
      boolean var5 = true;
      int[] var6 = null;
      if (var4 > 0) {
         var6 = new int[]{var4};
      }

      for(ByteArrayNode var7 = (ByteArrayNode)var1.table.first(); var7 != null; var7 = (ByteArrayNode)var1.table.next()) {
         int var8 = (int)var7.key;
         MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)var8);
         if (var9 == null) {
            var9 = class338.method1833(var2, var8);
            if (var9 == null) {
               var5 = false;
               continue;
            }

            this.musicPatches.put(var9, (long)var8);
         }

         if (!var9.method1589(var3, var7.byteArray, var6)) {
            var5 = false;
         }
      }

      if (var5) {
         var1.clear();
      }

      return var5;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   synchronized void clearAll() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.clear();
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "16022"
   )
   synchronized void removeAll() {
      for(MusicPatch var1 = (MusicPatch)this.musicPatches.first(); var1 != null; var1 = (MusicPatch)this.musicPatches.next()) {
         var1.remove();
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   protected synchronized PcmStream firstSubStream() {
      return this.patchStream;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
   )
   protected synchronized PcmStream nextSubStream() {
      return null;
   }

   @ObfuscatedName("r")
   protected synchronized int vmethod5648() {
      return 0;
   }

   @ObfuscatedName("u")
   protected synchronized void fill(int[] var1, int var2, int var3) {
      if (this.midiFile.isReady()) {
         int var4 = this.midiFile.division * this.field2732 / PcmPlayer.field198;

         do {
            long var5 = (long)var4 * (long)var3 + this.field2741;
            if (this.field2742 - var5 >= 0L) {
               this.field2741 = var5;
               break;
            }

            int var7 = (int)(((long)var4 + (this.field2742 - this.field2741) - 1L) / (long)var4);
            this.field2741 += (long)var7 * (long)var4;
            this.patchStream.fill(var1, var2, var7);
            var2 += var7;
            var3 -= var7;
            this.method1558();
         } while(this.midiFile.isReady());
      }

      this.patchStream.fill(var1, var2, var3);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(Lkc;ZI)V",
      garbageValue = "951999290"
   )
   synchronized void setMusicTrack(MusicTrack var1, boolean var2) {
      this.clear();
      this.midiFile.parse(var1.midi);
      this.field2717 = var2;
      this.field2741 = 0L;
      int var3 = this.midiFile.trackCount();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.midiFile.gotoTrack(var4);
         this.midiFile.readTrackLength(var4);
         this.midiFile.markTrackPosition(var4);
      }

      this.track = this.midiFile.getPrioritizedTrack();
      this.trackLength = this.midiFile.trackLengths[this.track];
      this.field2742 = this.midiFile.method1586(this.trackLength);
   }

   @ObfuscatedName("j")
   protected synchronized void skip(int var1) {
      if (this.midiFile.isReady()) {
         int var2 = this.midiFile.division * this.field2732 / PcmPlayer.field198;

         do {
            long var3 = (long)var1 * (long)var2 + this.field2741;
            if (this.field2742 - var3 >= 0L) {
               this.field2741 = var3;
               break;
            }

            int var5 = (int)(((long)var2 + (this.field2742 - this.field2741) - 1L) / (long)var2);
            this.field2741 += (long)var5 * (long)var2;
            this.patchStream.skip(var5);
            var1 -= var5;
            this.method1558();
         } while(this.midiFile.isReady());
      }

      this.patchStream.skip(var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "20"
   )
   synchronized void clear() {
      this.midiFile.clear();
      this.method1571();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "32"
   )
   synchronized boolean isReady() {
      return this.midiFile.isReady();
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "71"
   )
   public synchronized void method1542(int var1, int var2) {
      this.method1543(var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "-46"
   )
   void method1543(int var1, int var2) {
      this.field2723[var1] = var2;
      this.field2735[var1] = var2 & -128;
      this.method1544(var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-582359120"
   )
   void method1544(int var1, int var2) {
      if (var2 != this.field2743[var1]) {
         this.field2743[var1] = var2;

         for(int var3 = 0; var3 < 128; ++var3) {
            this.field2736[var1][var3] = null;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "-477011775"
   )
   void method1545(int var1, int var2, int var3) {
      this.method1562(var1, var2, 64);
      if ((this.field2718[var1] & 2) != 0) {
         for(MusicPatchNode var4 = (MusicPatchNode)this.patchStream.queue.first(); var4 != null; var4 = (MusicPatchNode)this.patchStream.queue.next()) {
            if (var4.field2780 == var1 && var4.field2768 < 0) {
               this.field2719[var1][var4.field2772] = null;
               this.field2719[var1][var2] = var4;
               int var5 = (var4.field2777 * var4.field2767 >> 12) + var4.field2775;
               var4.field2775 += var2 - var4.field2772 << 8;
               var4.field2767 = var5 - var4.field2775;
               var4.field2777 = 4096;
               var4.field2772 = var2;
               return;
            }
         }
      }

      MusicPatch var9 = (MusicPatch)this.musicPatches.get((long)this.field2743[var1]);
      if (var9 != null) {
         RawSound var8 = var9.rawSounds[var2];
         if (var8 != null) {
            MusicPatchNode var6 = new MusicPatchNode();
            var6.field2780 = var1;
            var6.patch = var9;
            var6.rawSound = var8;
            var6.field2781 = var9.field2755[var2];
            var6.field2771 = var9.field2758[var2];
            var6.field2772 = var2;
            var6.field2776 = var3 * var3 * var9.field2757[var2] * var9.field2756 + 1024 >> 11;
            var6.field2774 = var9.field2760[var2] & 255;
            var6.field2775 = (var2 << 8) - (var9.field2754[var2] & 32767);
            var6.field2778 = 0;
            var6.field2773 = 0;
            var6.field2769 = 0;
            var6.field2768 = -1;
            var6.field2782 = 0;
            if (this.field2720[var1] == 0) {
               var6.stream = RawPcmStream.method292(var8, this.method1551(var6), this.method1552(var6), this.method1553(var6));
            } else {
               var6.stream = RawPcmStream.method292(var8, this.method1551(var6), 0, this.method1553(var6));
               this.method1565(var6, var9.field2754[var2] < 0);
            }

            if (var9.field2754[var2] < 0) {
               var6.stream.setNumLoops(-1);
            }

            if (var6.field2771 >= 0) {
               MusicPatchNode var7 = this.field2736[var1][var6.field2771];
               if (var7 != null && var7.field2768 < 0) {
                  this.field2719[var1][var7.field2772] = null;
                  var7.field2768 = 0;
               }

               this.field2736[var1][var6.field2771] = var6;
            }

            this.patchStream.queue.addFirst(var6);
            this.field2719[var1][var2] = var6;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Lkx;ZI)V",
      garbageValue = "1046946935"
   )
   void method1565(MusicPatchNode var1, boolean var2) {
      int var3 = var1.rawSound.samples.length;
      int var4;
      if (var2 && var1.rawSound.field173) {
         int var5 = var3 + var3 - var1.rawSound.start;
         var4 = (int)((long)this.field2720[var1.field2780] * (long)var5 >> 6);
         var3 <<= 8;
         if (var4 >= var3) {
            var4 = var3 + var3 - 1 - var4;
            var1.stream.method256();
         }
      } else {
         var4 = (int)((long)var3 * (long)this.field2720[var1.field2780] >> 6);
      }

      var1.stream.method255(var4);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "676426616"
   )
   void method1562(int var1, int var2, int var3) {
      MusicPatchNode var4 = this.field2719[var1][var2];
      if (var4 != null) {
         this.field2719[var1][var2] = null;
         if ((this.field2718[var1] & 2) != 0) {
            for(MusicPatchNode var5 = (MusicPatchNode)this.patchStream.queue.last(); var5 != null; var5 = (MusicPatchNode)this.patchStream.queue.previous()) {
               if (var5.field2780 == var4.field2780 && var5.field2768 < 0 && var4 != var5) {
                  var4.field2768 = 0;
                  break;
               }
            }
         } else {
            var4.field2768 = 0;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "484115766"
   )
   void method1564(int var1, int var2, int var3) {
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "1185959546"
   )
   void method1570(int var1, int var2) {
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-1772680532"
   )
   void method1546(int var1, int var2) {
      this.field2726[var1] = var2;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1248985050"
   )
   void method1550(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if (var1 < 0 || var2.field2780 == var1) {
            if (var2.stream != null) {
               var2.stream.method259(PcmPlayer.field198 / 100);
               if (var2.stream.method286()) {
                  this.patchStream.mixer.addSubStream(var2.stream);
               }

               var2.method1603();
            }

            if (var2.field2768 < 0) {
               this.field2719[var2.field2780][var2.field2772] = null;
            }

            var2.remove();
         }
      }

   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-712942864"
   )
   void method1547(int var1) {
      if (var1 >= 0) {
         this.field2721[var1] = 12800;
         this.field2725[var1] = 8192;
         this.field2729[var1] = 16383;
         this.field2726[var1] = 8192;
         this.field2727[var1] = 0;
         this.field2728[var1] = 8192;
         this.method1573(var1);
         this.method1549(var1);
         this.field2718[var1] = 0;
         this.field2730[var1] = 32767;
         this.field2731[var1] = 256;
         this.field2720[var1] = 0;
         this.method1572(var1, 8192);
      } else {
         for(var1 = 0; var1 < 16; ++var1) {
            this.method1547(var1);
         }

      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "914760617"
   )
   void method1548(int var1) {
      for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
         if ((var1 < 0 || var2.field2780 == var1) && var2.field2768 < 0) {
            this.field2719[var2.field2780][var2.field2772] = null;
            var2.field2768 = 0;
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-17"
   )
   void method1571() {
      this.method1550(-1);
      this.method1547(-1);

      int var1;
      for(var1 = 0; var1 < 16; ++var1) {
         this.field2743[var1] = this.field2723[var1];
      }

      for(var1 = 0; var1 < 16; ++var1) {
         this.field2735[var1] = this.field2723[var1] & -128;
      }

   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-992120375"
   )
   void method1573(int var1) {
      if ((this.field2718[var1] & 2) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field2780 == var1 && this.field2719[var1][var2.field2772] == null && var2.field2768 < 0) {
               var2.field2768 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1159932724"
   )
   void method1549(int var1) {
      if ((this.field2718[var1] & 4) != 0) {
         for(MusicPatchNode var2 = (MusicPatchNode)this.patchStream.queue.last(); var2 != null; var2 = (MusicPatchNode)this.patchStream.queue.previous()) {
            if (var2.field2780 == var1) {
               var2.field2787 = 0;
            }
         }
      }

   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "27"
   )
   void method1555(int var1) {
      int var2 = var1 & 240;
      int var3;
      int var4;
      int var5;
      if (var2 == 128) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method1562(var3, var4, var5);
      } else if (var2 == 144) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var5 > 0) {
            this.method1545(var3, var4, var5);
         } else {
            this.method1562(var3, var4, 64);
         }

      } else if (var2 == 160) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         this.method1564(var3, var4, var5);
      } else if (var2 == 176) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         var5 = var1 >> 16 & 127;
         if (var4 == 0) {
            this.field2735[var3] = (var5 << 14) + (this.field2735[var3] & -2080769);
         }

         if (var4 == 32) {
            this.field2735[var3] = (var5 << 7) + (this.field2735[var3] & -16257);
         }

         if (var4 == 1) {
            this.field2727[var3] = (var5 << 7) + (this.field2727[var3] & -16257);
         }

         if (var4 == 33) {
            this.field2727[var3] = var5 + (this.field2727[var3] & -128);
         }

         if (var4 == 5) {
            this.field2728[var3] = (var5 << 7) + (this.field2728[var3] & -16257);
         }

         if (var4 == 37) {
            this.field2728[var3] = var5 + (this.field2728[var3] & -128);
         }

         if (var4 == 7) {
            this.field2721[var3] = (var5 << 7) + (this.field2721[var3] & -16257);
         }

         if (var4 == 39) {
            this.field2721[var3] = var5 + (this.field2721[var3] & -128);
         }

         if (var4 == 10) {
            this.field2725[var3] = (var5 << 7) + (this.field2725[var3] & -16257);
         }

         if (var4 == 42) {
            this.field2725[var3] = var5 + (this.field2725[var3] & -128);
         }

         if (var4 == 11) {
            this.field2729[var3] = (var5 << 7) + (this.field2729[var3] & -16257);
         }

         if (var4 == 43) {
            this.field2729[var3] = var5 + (this.field2729[var3] & -128);
         }

         if (var4 == 64) {
            if (var5 >= 64) {
               this.field2718[var3] |= 1;
            } else {
               this.field2718[var3] &= -2;
            }
         }

         if (var4 == 65) {
            if (var5 >= 64) {
               this.field2718[var3] |= 2;
            } else {
               this.method1573(var3);
               this.field2718[var3] &= -3;
            }
         }

         if (var4 == 99) {
            this.field2730[var3] = (var5 << 7) + (this.field2730[var3] & 127);
         }

         if (var4 == 98) {
            this.field2730[var3] = (this.field2730[var3] & 16256) + var5;
         }

         if (var4 == 101) {
            this.field2730[var3] = (var5 << 7) + (this.field2730[var3] & 127) + 16384;
         }

         if (var4 == 100) {
            this.field2730[var3] = (this.field2730[var3] & 16256) + var5 + 16384;
         }

         if (var4 == 120) {
            this.method1550(var3);
         }

         if (var4 == 121) {
            this.method1547(var3);
         }

         if (var4 == 123) {
            this.method1548(var3);
         }

         int var6;
         if (var4 == 6) {
            var6 = this.field2730[var3];
            if (var6 == 16384) {
               this.field2731[var3] = (var5 << 7) + (this.field2731[var3] & -16257);
            }
         }

         if (var4 == 38) {
            var6 = this.field2730[var3];
            if (var6 == 16384) {
               this.field2731[var3] = var5 + (this.field2731[var3] & -128);
            }
         }

         if (var4 == 16) {
            this.field2720[var3] = (var5 << 7) + (this.field2720[var3] & -16257);
         }

         if (var4 == 48) {
            this.field2720[var3] = var5 + (this.field2720[var3] & -128);
         }

         if (var4 == 81) {
            if (var5 >= 64) {
               this.field2718[var3] |= 4;
            } else {
               this.method1549(var3);
               this.field2718[var3] &= -5;
            }
         }

         if (var4 == 17) {
            this.method1572(var3, (var5 << 7) + (this.field2733[var3] & -16257));
         }

         if (var4 == 49) {
            this.method1572(var3, var5 + (this.field2733[var3] & -128));
         }

      } else if (var2 == 192) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method1544(var3, var4 + this.field2735[var3]);
      } else if (var2 == 208) {
         var3 = var1 & 15;
         var4 = var1 >> 8 & 127;
         this.method1570(var3, var4);
      } else if (var2 == 224) {
         var3 = var1 & 15;
         var4 = (var1 >> 8 & 127) + (var1 >> 9 & 16256);
         this.method1546(var3, var4);
      } else {
         var2 = var1 & 255;
         if (var2 == 255) {
            this.method1571();
         }
      }
   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "181224742"
   )
   void method1572(int var1, int var2) {
      this.field2733[var1] = var2;
      this.field2734[var1] = (int)(2097152.0D * Math.pow(2.0D, (double)var2 * 5.4931640625E-4D) + 0.5D);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Lkx;I)I",
      garbageValue = "1148770502"
   )
   int method1551(MusicPatchNode var1) {
      int var2 = (var1.field2767 * var1.field2777 >> 12) + var1.field2775;
      var2 += (this.field2726[var1.field2780] - 8192) * this.field2731[var1.field2780] >> 12;
      MusicPatchNode2 var3 = var1.field2781;
      int var4;
      if (var3.field2705 > 0 && (var3.field2704 > 0 || this.field2727[var1.field2780] > 0)) {
         var4 = var3.field2704 << 2;
         int var5 = var3.field2700 << 1;
         if (var1.field2783 < var5) {
            var4 = var4 * var1.field2783 / var5;
         }

         var4 += this.field2727[var1.field2780] >> 7;
         double var6 = Math.sin(0.01227184630308513D * (double)(var1.field2784 & 511));
         var2 += (int)((double)var4 * var6);
      }

      var4 = (int)((double)(var1.rawSound.sampleRate * 256) * Math.pow(2.0D, 3.255208333333333E-4D * (double)var2) / (double)PcmPlayer.field198 + 0.5D);
      return var4 < 1 ? 1 : var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lkx;I)I",
      garbageValue = "1303045954"
   )
   int method1552(MusicPatchNode var1) {
      MusicPatchNode2 var2 = var1.field2781;
      int var3 = this.field2721[var1.field2780] * this.field2729[var1.field2780] + 4096 >> 13;
      var3 = var3 * var3 + 16384 >> 15;
      var3 = var3 * var1.field2776 + 16384 >> 15;
      var3 = var3 * this.field2724 + 128 >> 8;
      if (var2.field2701 > 0) {
         var3 = (int)((double)var3 * Math.pow(0.5D, (double)var1.field2778 * 1.953125E-5D * (double)var2.field2701) + 0.5D);
      }

      int var4;
      int var5;
      int var6;
      int var7;
      if (var2.field2703 != null) {
         var4 = var1.field2773;
         var5 = var2.field2703[var1.field2769 + 1];
         if (var1.field2769 < var2.field2703.length - 2) {
            var6 = (var2.field2703[var1.field2769] & 255) << 8;
            var7 = (var2.field2703[var1.field2769 + 2] & 255) << 8;
            var5 += (var2.field2703[var1.field2769 + 3] - var5) * (var4 - var6) / (var7 - var6);
         }

         var3 = var5 * var3 + 32 >> 6;
      }

      if (var1.field2768 > 0 && var2.field2699 != null) {
         var4 = var1.field2768;
         var5 = var2.field2699[var1.field2782 + 1];
         if (var1.field2782 < var2.field2699.length - 2) {
            var6 = (var2.field2699[var1.field2782] & 255) << 8;
            var7 = (var2.field2699[var1.field2782 + 2] & 255) << 8;
            var5 += (var4 - var6) * (var2.field2699[var1.field2782 + 3] - var5) / (var7 - var6);
         }

         var3 = var3 * var5 + 32 >> 6;
      }

      return var3;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lkx;I)I",
      garbageValue = "402004555"
   )
   int method1553(MusicPatchNode var1) {
      int var2 = this.field2725[var1.field2780];
      return var2 < 8192 ? var2 * var1.field2774 + 32 >> 6 : 16384 - ((128 - var1.field2774) * (16384 - var2) + 32 >> 6);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1623545318"
   )
   void method1558() {
      int var1 = this.track;
      int var2 = this.trackLength;

      long var3;
      for(var3 = this.field2742; var2 == this.trackLength; var3 = this.midiFile.method1586(var2)) {
         while(var2 == this.midiFile.trackLengths[var1]) {
            this.midiFile.gotoTrack(var1);
            int var5 = this.midiFile.readMessage(var1);
            if (var5 == 1) {
               this.midiFile.setTrackDone();
               this.midiFile.markTrackPosition(var1);
               if (this.midiFile.isDone()) {
                  if (!this.field2717 || var2 == 0) {
                     this.method1571();
                     this.midiFile.clear();
                     return;
                  }

                  this.midiFile.reset(var3);
               }
               break;
            }

            if ((var5 & 128) != 0) {
               this.method1555(var5);
            }

            this.midiFile.readTrackLength(var1);
            this.midiFile.markTrackPosition(var1);
         }

         var1 = this.midiFile.getPrioritizedTrack();
         var2 = this.midiFile.trackLengths[var1];
      }

      this.track = var1;
      this.trackLength = var2;
      this.field2742 = var3;
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(Lkx;B)Z",
      garbageValue = "1"
   )
   boolean method1559(MusicPatchNode var1) {
      if (var1.stream == null) {
         if (var1.field2768 >= 0) {
            var1.remove();
            if (var1.field2771 > 0 && var1 == this.field2736[var1.field2780][var1.field2771]) {
               this.field2736[var1.field2780][var1.field2771] = null;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(Lkx;[IIIB)Z",
      garbageValue = "-44"
   )
   boolean method1560(MusicPatchNode var1, int[] var2, int var3, int var4) {
      var1.field2786 = PcmPlayer.field198 / 100;
      if (var1.field2768 < 0 || var1.stream != null && !var1.stream.method262()) {
         int var5 = var1.field2777;
         if (var5 > 0) {
            var5 -= (int)(16.0D * Math.pow(2.0D, 4.921259842519685E-4D * (double)this.field2728[var1.field2780]) + 0.5D);
            if (var5 < 0) {
               var5 = 0;
            }

            var1.field2777 = var5;
         }

         var1.stream.method260(this.method1551(var1));
         MusicPatchNode2 var6 = var1.field2781;
         boolean var7 = false;
         ++var1.field2783;
         var1.field2784 += var6.field2705;
         double var8 = (double)((var1.field2772 - 60 << 8) + (var1.field2767 * var1.field2777 >> 12)) * 5.086263020833333E-6D;
         if (var6.field2701 > 0) {
            if (var6.field2698 > 0) {
               var1.field2778 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2698 * var8) + 0.5D);
            } else {
               var1.field2778 += 128;
            }
         }

         if (var6.field2703 != null) {
            if (var6.field2706 > 0) {
               var1.field2773 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2706 * var8) + 0.5D);
            } else {
               var1.field2773 += 128;
            }

            while(var1.field2769 < var6.field2703.length - 2 && var1.field2773 > (var6.field2703[var1.field2769 + 2] & 255) << 8) {
               var1.field2769 += 2;
            }

            if (var6.field2703.length - 2 == var1.field2769 && var6.field2703[var1.field2769 + 1] == 0) {
               var7 = true;
            }
         }

         if (var1.field2768 >= 0 && var6.field2699 != null && (this.field2718[var1.field2780] & 1) == 0 && (var1.field2771 < 0 || var1 != this.field2736[var1.field2780][var1.field2771])) {
            if (var6.field2702 > 0) {
               var1.field2768 += (int)(128.0D * Math.pow(2.0D, (double)var6.field2702 * var8) + 0.5D);
            } else {
               var1.field2768 += 128;
            }

            while(var1.field2782 < var6.field2699.length - 2 && var1.field2768 > (var6.field2699[var1.field2782 + 2] & 255) << 8) {
               var1.field2782 += 2;
            }

            if (var6.field2699.length - 2 == var1.field2782) {
               var7 = true;
            }
         }

         if (var7) {
            var1.stream.method259(var1.field2786);
            if (var2 != null) {
               var1.stream.fill(var2, var3, var4);
            } else {
               var1.stream.skip(var4);
            }

            if (var1.stream.method286()) {
               this.patchStream.mixer.addSubStream(var1.stream);
            }

            var1.method1603();
            if (var1.field2768 >= 0) {
               var1.remove();
               if (var1.field2771 > 0 && var1 == this.field2736[var1.field2780][var1.field2771]) {
                  this.field2736[var1.field2780][var1.field2771] = null;
               }
            }

            return true;
         } else {
            var1.stream.method258(var1.field2786, this.method1552(var1), this.method1553(var1));
            return false;
         }
      } else {
         var1.method1603();
         var1.remove();
         if (var1.field2771 > 0 && var1 == this.field2736[var1.field2780][var1.field2771]) {
            this.field2736[var1.field2780][var1.field2771] = null;
         }

         return true;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)[Ldp;",
      garbageValue = "-36297467"
   )
   static class124[] method1566() {
      return new class124[]{class124.field1199, class124.field1194, class124.field1195, class124.field1200, class124.field1197};
   }
}
