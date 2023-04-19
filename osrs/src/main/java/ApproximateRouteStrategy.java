import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("ApproximateRouteStrategy")
public class ApproximateRouteStrategy extends RouteStrategy {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(IIILif;I)Z",
            garbageValue = "286986723"
    )
    protected boolean hasArrived(int var1, int var2, int var3, CollisionMap var4) {
      return var2 == super.approxDestinationX && var3 == super.approxDestinationY;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(II)Lgl;",
            garbageValue = "-1717461998"
    )
    public static InvDefinition getInvDefinition(int var0) {
      InvDefinition var1 = (InvDefinition)InvDefinition.InvDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = InvDefinition.InvDefinition_archive.takeFile(5, var0);
         var1 = new InvDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         InvDefinition.InvDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bz")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "16776960"
   )
   static int method361(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if (var0 == 4100) {
         var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
         var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var9;
         if (var0 == 4101) {
            SecureRandomCallable.Interpreter_stringStackSize -= 2;
            var3 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize];
            var9 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 1];
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3 + var9;
            return 1;
         } else if (var0 == 4102) {
            var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
            var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3 + KitDefinition.intToString(var4, true);
            return 1;
         } else if (var0 == 4103) {
            var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var10;
            if (var0 == 4104) {
               var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               long var11 = ((long)var10 + 11745L) * 86400000L;
               Interpreter.Interpreter_calendar.setTime(new Date(var11));
               var6 = Interpreter.Interpreter_calendar.get(5);
               int var17 = Interpreter.Interpreter_calendar.get(2);
               int var8 = Interpreter.Interpreter_calendar.get(1);
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var17] + "-" + var8;
               return 1;
            } else if (var0 != 4105) {
               if (var0 == 4106) {
                  var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if (var0 == 4107) {
                  SecureRandomCallable.Interpreter_stringStackSize -= 2;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = BuddyRankComparator.method712(class16.compareStrings(Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 1], ClanSettings.clientLanguage));
                  return 1;
               } else {
                  int var5;
                  byte[] var13;
                  Font var14;
                  if (var0 == 4108) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var13 = class128.archive13.takeFile(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
                     return 1;
                  } else if (var0 == 4109) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var13 = class128.archive13.takeFile(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
                     return 1;
                  } else if (var0 == 4110) {
                     SecureRandomCallable.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 1];
                     if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3;
                     } else {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9;
                     }

                     return 1;
                  } else if (var0 == 4111) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
                     return 1;
                  } else if (var0 == 4112) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if (var0 == 4113) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = VarcInt.isCharPrintable((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4114) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = MenuAction.isAlphaNumeric((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4115) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class134.isCharAlphabetic((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4116) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class149.isDigit((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4117) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     if (var3 != null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.length();
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if (var0 == 4118) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
                     return 1;
                  } else if (var0 == 4119) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     StringBuilder var18 = new StringBuilder(var3.length());
                     boolean var16 = false;

                     for(var6 = 0; var6 < var3.length(); ++var6) {
                        char var7 = var3.charAt(var6);
                        if (var7 == '<') {
                           var16 = true;
                        } else if (var7 == '>') {
                           var16 = false;
                        } else if (!var16) {
                           var18.append(var7);
                        }
                     }

                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var18.toString();
                     return 1;
                  } else if (var0 == 4120) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if (var0 == 4121) {
                     SecureRandomCallable.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 1];
                     var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
                     return 1;
                  } else if (var0 == 4122) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.toUpperCase();
                     return 1;
                  } else if (var0 == 4123) {
                     SecureRandomCallable.Interpreter_stringStackSize -= 3;
                     var3 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 1];
                     String var15 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 2];
                     if (MusicPatchNode.localPlayer.appearance == null) {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var15;
                        return 1;
                     } else {
                        switch(MusicPatchNode.localPlayer.appearance.field2831) {
                        case 0:
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3;
                           break;
                        case 1:
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9;
                           break;
                        case 2:
                        default:
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var15;
                        }

                        return 1;
                     }
                  } else {
                     return 2;
                  }
               }
            } else {
               SecureRandomCallable.Interpreter_stringStackSize -= 2;
               var3 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize];
               var9 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 1];
               if (MusicPatchNode.localPlayer.appearance != null && MusicPatchNode.localPlayer.appearance.field2840 != 0) {
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9;
               } else {
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("mc")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-458475537"
   )
   static final void method359(int var0) {
      var0 = Math.max(Math.min(var0, 100), 0);
      var0 = 100 - var0;
      float var1 = 0.5F + (float)var0 / 200.0F;
      ScriptFrame.method341((double)var1);
   }
}
