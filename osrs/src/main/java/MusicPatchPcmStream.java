import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kg")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
   @ObfuscatedName("lp")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   static Widget field2764;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lka;"
   )
   @Export("superStream")
   MidiPcmStream superStream;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lmq;"
   )
   @Export("queue")
   NodeDeque queue = new NodeDeque();
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Laz;"
   )
   @Export("mixer")
   PcmStreamMixer mixer = new PcmStreamMixer();

   @ObfuscatedSignature(
      descriptor = "(Lka;)V"
   )
   MusicPatchPcmStream(MidiPcmStream var1) {
      this.superStream = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lkx;[IIIII)V",
      garbageValue = "771309267"
   )
   void method1598(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
      if ((this.superStream.field2718[var1.field2780] & 4) != 0 && var1.field2768 < 0) {
         int var6 = this.superStream.field2734[var1.field2780] / PcmPlayer.field198;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2787) / var6;
            if (var7 > var4) {
               var1.field2787 += var4 * var6;
               break;
            }

            var1.stream.fill(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2787 += var7 * var6 - 1048576;
            int var8 = PcmPlayer.field198 / 100;
            int var9 = 262144 / var6;
            if (var9 < var8) {
               var8 = var9;
            }

            RawPcmStream var10 = var1.stream;
            if (this.superStream.field2720[var1.field2780] == 0) {
               var1.stream = RawPcmStream.method292(var1.rawSound, var10.method261(), var10.method284(), var10.method263());
            } else {
               var1.stream = RawPcmStream.method292(var1.rawSound, var10.method261(), 0, var10.method263());
               this.superStream.method1565(var1, var1.patch.field2754[var1.field2772] < 0);
               var1.stream.method257(var8, var10.method284());
            }

            if (var1.patch.field2754[var1.field2772] < 0) {
               var1.stream.setNumLoops(-1);
            }

            var10.method259(var8);
            var10.fill(var2, var3, var5 - var3);
            if (var10.method286()) {
               this.mixer.addSubStream(var10);
            }
         }
      }

      var1.stream.fill(var2, var3, var4);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lkx;II)V",
      garbageValue = "-81280386"
   )
   void method1596(MusicPatchNode var1, int var2) {
      if ((this.superStream.field2718[var1.field2780] & 4) != 0 && var1.field2768 < 0) {
         int var3 = this.superStream.field2734[var1.field2780] / PcmPlayer.field198;
         int var4 = (var3 + 1048575 - var1.field2787) / var3;
         var1.field2787 = var3 * var2 + var1.field2787 & 1048575;
         if (var4 <= var2) {
            if (this.superStream.field2720[var1.field2780] == 0) {
               var1.stream = RawPcmStream.method292(var1.rawSound, var1.stream.method261(), var1.stream.method284(), var1.stream.method263());
            } else {
               var1.stream = RawPcmStream.method292(var1.rawSound, var1.stream.method261(), 0, var1.stream.method263());
               this.superStream.method1565(var1, var1.patch.field2754[var1.field2772] < 0);
            }

            if (var1.patch.field2754[var1.field2772] < 0) {
               var1.stream.setNumLoops(-1);
            }

            var2 = var1.field2787 / var3;
         }
      }

      var1.stream.skip(var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "()Laa;"
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

   @ObfuscatedName("r")
   @Export("vmethod5648")
   protected int vmethod5648() {
      return 0;
   }

   @ObfuscatedName("u")
   @Export("fill")
   protected void fill(int[] var1, int var2, int var3) {
      this.mixer.fill(var1, var2, var3);

      for(MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
         if (!this.superStream.method1559(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if (var5 <= var6.field2786) {
                  this.method1598(var6, var1, var4, var5, var4 + var5);
                  var6.field2786 -= var5;
                  break;
               }

               this.method1598(var6, var1, var4, var6.field2786, var5 + var4);
               var4 += var6.field2786;
               var5 -= var6.field2786;
            } while(!this.superStream.method1560(var6, var1, var4, var5));
         }
      }

   }

   @ObfuscatedName("j")
   @Export("skip")
   protected void skip(int var1) {
      this.mixer.skip(var1);

      for(MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
         if (!this.superStream.method1559(var3)) {
            int var2 = var1;

            do {
               if (var2 <= var3.field2786) {
                  this.method1596(var3, var2);
                  var3.field2786 -= var2;
                  break;
               }

               this.method1596(var3, var3.field2786);
               var2 -= var3.field2786;
            } while(!this.superStream.method1560(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIS)I",
      garbageValue = "255"
   )
   static int method1599(int var0, int var1) {
      if (var0 == -2) {
         return 12345678;
      } else if (var0 == -1) {
         if (var1 < 0) {
            var1 = 0;
         } else if (var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if (var1 < 2) {
            var1 = 2;
         } else if (var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-1863786248"
   )
   static int method1593(int var0, Script var1, boolean var2) {
      Widget var3 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
      if (var0 == 1700) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if (var0 == 1701) {
         if (var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if (var0 == 1702) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.childIndex;
         return 1;
      } else if (var0 == 1707) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.method1727() ? 1 : 0;
         return 1;
      } else if (var0 == 1708) {
         return class300.method1619(var3);
      } else {
         return var0 == 1709 ? LoginScreenAnimation.method527(var3) : 2;
      }
   }
}
