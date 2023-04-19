import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lc")
@Implements("MusicPatchPcmStream")
public class MusicPatchPcmStream extends PcmStream {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    MidiPcmStream superStream;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lnh;"
    )
    NodeDeque queue = new NodeDeque();
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lbn;"
    )
    PcmStreamMixer mixer = new PcmStreamMixer();

   @ObfuscatedSignature(
      descriptor = "(Lln;)V"
   )
   MusicPatchPcmStream(MidiPcmStream var1) {
      this.superStream = var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Llq;[IIIII)V",
      garbageValue = "1090554723"
   )
   void method1670(MusicPatchNode var1, int[] var2, int var3, int var4, int var5) {
      if ((this.superStream.field2746[var1.field2801] & 4) != 0 && var1.field2798 < 0) {
         int var6 = this.superStream.field2751[var1.field2801] / PcmPlayer.field201;

         while(true) {
            int var7 = (var6 + 1048575 - var1.field2803) / var6;
            if (var7 > var4) {
               var1.field2803 += var6 * var4;
               break;
            }

            var1.stream.fill(var2, var3, var7);
            var3 += var7;
            var4 -= var7;
            var1.field2803 += var6 * var7 - 1048576;
            int var8 = PcmPlayer.field201 / 100;
            int var9 = 262144 / var6;
            if (var9 < var8) {
               var8 = var9;
            }

            RawPcmStream var10 = var1.stream;
            if (this.superStream.field2749[var1.field2801] == 0) {
               var1.stream = RawPcmStream.method294(var1.rawSound, var10.method270(), var10.method262(), var10.method285());
            } else {
               var1.stream = RawPcmStream.method294(var1.rawSound, var10.method270(), 0, var10.method285());
               this.superStream.method1639(var1, var1.patch.field2771[var1.field2788] < 0);
               var1.stream.method298(var8, var10.method262());
            }

            if (var1.patch.field2771[var1.field2788] < 0) {
               var1.stream.setNumLoops(-1);
            }

            var10.method268(var8);
            var10.fill(var2, var3, var5 - var3);
            if (var10.method299()) {
               this.mixer.addSubStream(var10);
            }
         }
      }

      var1.stream.fill(var2, var3, var4);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Llq;IB)V",
      garbageValue = "1"
   )
   void method1668(MusicPatchNode var1, int var2) {
      if ((this.superStream.field2746[var1.field2801] & 4) != 0 && var1.field2798 < 0) {
         int var3 = this.superStream.field2751[var1.field2801] / PcmPlayer.field201;
         int var4 = (var3 + 1048575 - var1.field2803) / var3;
         var1.field2803 = var3 * var2 + var1.field2803 & 1048575;
         if (var4 <= var2) {
            if (this.superStream.field2749[var1.field2801] == 0) {
               var1.stream = RawPcmStream.method294(var1.rawSound, var1.stream.method270(), var1.stream.method262(), var1.stream.method285());
            } else {
               var1.stream = RawPcmStream.method294(var1.rawSound, var1.stream.method270(), 0, var1.stream.method285());
               this.superStream.method1639(var1, var1.patch.field2771[var1.field2788] < 0);
            }

            if (var1.patch.field2771[var1.field2788] < 0) {
               var1.stream.setNumLoops(-1);
            }

            var2 = var1.field2803 / var3;
         }
      }

      var1.stream.skip(var2);
   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "()Lbp;"
    )
    protected PcmStream firstSubStream() {
      MusicPatchNode var1 = (MusicPatchNode)this.queue.last();
      if (var1 == null) {
         return null;
      } else {
         return (PcmStream)(var1.stream != null ? var1.stream : this.nextSubStream());
      }
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "()Lbp;"
    )
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

    @ObfuscatedName("al")
    protected int vmethod5648() {
      return 0;
   }

    @ObfuscatedName("at")
    protected void fill(int[] var1, int var2, int var3) {
      this.mixer.fill(var1, var2, var3);

      for(MusicPatchNode var6 = (MusicPatchNode)this.queue.last(); var6 != null; var6 = (MusicPatchNode)this.queue.previous()) {
         if (!this.superStream.method1646(var6)) {
            int var4 = var2;
            int var5 = var3;

            do {
               if (var5 <= var6.field2796) {
                  this.method1670(var6, var1, var4, var5, var5 + var4);
                  var6.field2796 -= var5;
                  break;
               }

               this.method1670(var6, var1, var4, var6.field2796, var4 + var5);
               var4 += var6.field2796;
               var5 -= var6.field2796;
            } while(!this.superStream.method1638(var6, var1, var4, var5));
         }
      }

   }

    @ObfuscatedName("ay")
    protected void skip(int var1) {
      this.mixer.skip(var1);

      for(MusicPatchNode var3 = (MusicPatchNode)this.queue.last(); var3 != null; var3 = (MusicPatchNode)this.queue.previous()) {
         if (!this.superStream.method1646(var3)) {
            int var2 = var1;

            do {
               if (var2 <= var3.field2796) {
                  this.method1668(var3, var2);
                  var3.field2796 -= var2;
                  break;
               }

               this.method1668(var3, var3.field2796);
               var2 -= var3.field2796;
            } while(!this.superStream.method1638(var3, (int[])null, 0, var2));
         }
      }

   }

   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "41"
   )
   static int method1665(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 4200) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if (var0 == 4201) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = HealthBarUpdate.ItemDefinition_get(var3);
            if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 4202) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = HealthBarUpdate.ItemDefinition_get(var3);
            if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 4203) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var3).price;
            return 1;
         } else if (var0 == 4204) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
            return 1;
         } else {
            ItemComposition var6;
            if (var0 == 4205) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var6 = HealthBarUpdate.ItemDefinition_get(var3);
               if (var6.noteTemplate == -1 && var6.note >= 0) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if (var0 == 4206) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var6 = HealthBarUpdate.ItemDefinition_get(var3);
               if (var6.noteTemplate >= 0 && var6.note >= 0) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if (var0 == 4207) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
               return 1;
            } else if (var0 == 4208) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var6 = HealthBarUpdate.ItemDefinition_get(var3);
               if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if (var0 == 4209) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var6 = HealthBarUpdate.ItemDefinition_get(var3);
               if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if (var0 == 4210) {
               String var7 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
               var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               class68.findItemDefinitions(var7, var4 == 1);
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class264.foundItemIdCount;
               return 1;
            } else if (var0 != 4211) {
               if (var0 == 4212) {
                  FontName.foundItemIndex = 0;
                  return 1;
               } else if (var0 == 4213) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var4 = HealthBarUpdate.ItemDefinition_get(var3).getShiftClickIndex();
                  if (var4 == -1) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 + 1;
                  }

                  return 1;
               } else if (var0 == 4214) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var3).maleModel;
                  return 1;
               } else if (var0 == 4215) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var3).maleModel1;
                  return 1;
               } else if (var0 == 4216) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = HealthBarUpdate.ItemDefinition_get(var3).maleModel2;
                  return 1;
               } else if (var0 == 4217) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var6 = HealthBarUpdate.ItemDefinition_get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.field1774;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if (class399.foundItemIds != null && FontName.foundItemIndex < class264.foundItemIdCount) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class399.foundItemIds[++FontName.foundItemIndex - 1] & '\uffff';
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }
}
