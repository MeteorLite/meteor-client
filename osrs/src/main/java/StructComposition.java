import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ht")
@Implements("StructComposition")
public class StructComposition extends DualNode {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    static AbstractArchive StructDefinition_archive;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lkh;"
    )
    static EvictingDualNodeHashTable StructDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lro;"
    )
    IterableNodeHashTable params;

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1436129588"
    )
    void postDecode() {
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "-1875219485"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(Lsg;II)V",
            garbageValue = "-1196220711"
    )
    void decodeNext(Buffer var1, int var2) {
      if (var2 == 249) {
         this.params = ChatChannel.readStringIntParameters(var1, this.params);
      }

   }

    @ObfuscatedName("ab")
    @ObfuscatedSignature(
            descriptor = "(IIB)I",
            garbageValue = "-33"
    )
    public int getIntParam(int var1, int var2) {
      IterableNodeHashTable var4 = this.params;
      int var3;
      if (var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if (var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.integer;
         }
      }

      return var3;
   }

    @ObfuscatedName("aq")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;I)Ljava/lang/String;",
            garbageValue = "1937714582"
    )
    public String getStringParam(int var1, String var2) {
      return EnumComposition.method1014(this.params, var1, var2);
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "([Lnj;IS)Lnj;",
            garbageValue = "173"
    )
    public static class356 findEnumerated(class356[] var0, int var1) {
      class356[] var2 = var0;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         class356 var4 = var2[var3];
         if (var1 == var4.rsOrdinal()) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   static void method1068() {
      for(ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var0.stream1 != null) {
            class130.pcmStreamMixer.removeSubStream(var0.stream1);
            var0.stream1 = null;
         }

         if (var0.stream2 != null) {
            class130.pcmStreamMixer.removeSubStream(var0.stream2);
            var0.stream2 = null;
         }
      }

      ObjectSound.objectSounds.clear();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "1887051425"
   )
   public static int method1071(int var0) {
      return var0 >> 17 & 7;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "-1159908779"
   )
   static int method1070(int var0, Script var1, boolean var2) {
      boolean var3 = true;
      Widget var4;
      if (var0 >= 2000) {
         var0 -= 1000;
         var4 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         var3 = false;
      } else {
         var4 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
      }

      int var11;
      if (var0 == 1300) {
         var11 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] - 1;
         if (var11 >= 0 && var11 <= 9) {
            var4.setAction(var11, Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize]);
            return 1;
         } else {
            --SecureRandomCallable.Interpreter_stringStackSize;
            return 1;
         }
      } else {
         int var6;
         if (var0 == 1301) {
            Interpreter.Interpreter_intStackSize -= 2;
            var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var4.parent = SoundSystem.getWidgetChild(var11, var6);
            return 1;
         } else if (var0 == 1302) {
            var4.isScrollBar = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            return 1;
         } else if (var0 == 1303) {
            var4.dragZoneSize = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            return 1;
         } else if (var0 == 1304) {
            var4.dragThreshold = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            return 1;
         } else if (var0 == 1305) {
            var4.dataText = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
            return 1;
         } else if (var0 == 1306) {
            var4.spellActionName = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
            return 1;
         } else if (var0 == 1307) {
            var4.actions = null;
            return 1;
         } else if (var0 == 1308) {
            var4.prioritizeMenuEntry = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
            return 1;
         } else if (var0 == 1309) {
            --Interpreter.Interpreter_intStackSize;
            return 1;
         } else {
            int var7;
            byte[] var9;
            if (var0 != 1350) {
               byte var5;
               if (var0 == 1351) {
                  Interpreter.Interpreter_intStackSize -= 2;
                  var5 = 10;
                  var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]};
                  byte[] var10 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]};
                  class7.Widget_setKey(var4, var5, var9, var10);
                  return 1;
               } else if (var0 == 1352) {
                  Interpreter.Interpreter_intStackSize -= 3;
                  var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] - 1;
                  var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                  var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
                  if (var11 >= 0 && var11 <= 9) {
                     class68.Widget_setKeyRate(var4, var11, var6, var7);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if (var0 == 1353) {
                  var5 = 10;
                  var6 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  class68.Widget_setKeyRate(var4, var5, var6, var7);
                  return 1;
               } else if (var0 == 1354) {
                  --Interpreter.Interpreter_intStackSize;
                  var11 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] - 1;
                  if (var11 >= 0 && var11 <= 9) {
                     ModeWhere.Widget_setKeyIgnoreHeld(var4, var11);
                     return 1;
                  } else {
                     throw new RuntimeException();
                  }
               } else if (var0 == 1355) {
                  var5 = 10;
                  ModeWhere.Widget_setKeyIgnoreHeld(var4, var5);
                  return 1;
               } else {
                  return 2;
               }
            } else {
               byte[] var8 = null;
               var9 = null;
               if (var3) {
                  Interpreter.Interpreter_intStackSize -= 10;

                  for(var7 = 0; var7 < 10 && Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize] >= 0; var7 += 2) {
                     ;
                  }

                  if (var7 > 0) {
                     var8 = new byte[var7 / 2];
                     var9 = new byte[var7 / 2];

                     for(var7 -= 2; var7 >= 0; var7 -= 2) {
                        var8[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize];
                        var9[var7 / 2] = (byte)Interpreter.Interpreter_intStack[var7 + Interpreter.Interpreter_intStackSize + 1];
                     }
                  }
               } else {
                  Interpreter.Interpreter_intStackSize -= 2;
                  var8 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]};
                  var9 = new byte[]{(byte)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]};
               }

               var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] - 1;
               if (var7 >= 0 && var7 <= 9) {
                  class7.Widget_setKey(var4, var7, var8, var9);
                  return 1;
               } else {
                  throw new RuntimeException();
               }
            }
         }
      }
   }
}
