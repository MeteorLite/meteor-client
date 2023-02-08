import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("et")
public class class151 extends class155 {
   @ObfuscatedName("b")
   static int field1365;
    @ObfuscatedName("ec")
    @ObfuscatedSignature(
            descriptor = "Llm;"
    )
    static Archive archive11;
   @ObfuscatedName("f")
   String field1366;
   @ObfuscatedName("w")
   int field1368;
   @ObfuscatedName("v")
   byte field1367;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfn;"
   )
   final class156 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfn;)V"
   )
   class151(class156 var1) {
      this.this$0 = var1;
      this.field1366 = null;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)V",
            garbageValue = "-123"
    )
    void vmethod3238(Buffer var1) {
      if (var1.readUnsignedByte() != 255) {
         --var1.offset;
         var1.readLong();
      }

      this.field1366 = var1.readStringCp1252NullTerminatedOrNull();
      this.field1368 = var1.readUnsignedShort();
      this.field1367 = var1.readByte();
      var1.readLong();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lfm;I)V",
            garbageValue = "127147356"
    )
    void vmethod3239(ClanChannel var1) {
      ClanChannelMember var2 = new ClanChannelMember();
      var2.username = new Username(this.field1366);
      var2.world = this.field1368;
      var2.rank = this.field1367;
      var1.addMember(var2);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-1068248433"
   )
   static int method813(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if (var0 == 3400) {
         class302.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
         EnumComposition var5 = UserComparator10.getEnum(var3);
         if (var5.outputType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.outputCount; ++var6) {
            if (var4 == var5.keys[var6]) {
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var5.strVals[var6];
               var5 = null;
               break;
            }
         }

         if (var5 != null) {
            Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var5.defaultStr;
         }

         return 1;
      } else if (var0 != 3408) {
         if (var0 == 3411) {
            var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
            EnumComposition var10 = UserComparator10.getEnum(var3);
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var10.size();
            return 1;
         } else {
            return 2;
         }
      } else {
         class302.Interpreter_intStackSize -= 4;
         var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
         int var9 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
         var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 3];
         EnumComposition var7 = UserComparator10.getEnum(var9);
         if (var3 == var7.inputType && var4 == var7.outputType) {
            for(int var8 = 0; var8 < var7.outputCount; ++var8) {
               if (var6 == var7.keys[var8]) {
                  if (var4 == 115) {
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var7.strVals[var8];
                  } else {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if (var7 != null) {
               if (var4 == 115) {
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var7.defaultStr;
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if (var4 == 115) {
               Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "null";
            } else {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
