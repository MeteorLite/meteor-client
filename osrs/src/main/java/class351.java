import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nu")
public class class351 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lnu;"
   )
   static final class351 field3494 = new class351();
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lnu;"
   )
   static final class351 field3492 = new class351();
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lnu;"
   )
   static final class351 field3493 = new class351();
   @ObfuscatedName("ko")
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "-28082582"
   )
   static int method1888(int var0, Script var1, boolean var2) {
      String var3;
      int var4;
      if (var0 == 4100) {
         var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
         var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3 + var4;
         return 1;
      } else {
         String var9;
         if (var0 == 4101) {
            HealthBar.Interpreter_stringStackSize -= 2;
            var3 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize];
            var9 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 1];
            Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3 + var9;
            return 1;
         } else if (var0 == 4102) {
            var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
            var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3 + class393.intToString(var4, true);
            return 1;
         } else if (var0 == 4103) {
            var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
            Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.toLowerCase();
            return 1;
         } else {
            int var6;
            int var10;
            if (var0 == 4104) {
               var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               long var11 = 86400000L * (11745L + (long)var10);
               Interpreter.Interpreter_calendar.setTime(new Date(var11));
               var6 = Interpreter.Interpreter_calendar.get(5);
               int var17 = Interpreter.Interpreter_calendar.get(2);
               int var8 = Interpreter.Interpreter_calendar.get(1);
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var6 + "-" + Interpreter.Interpreter_MONTHS[var17] + "-" + var8;
               return 1;
            } else if (var0 != 4105) {
               if (var0 == 4106) {
                  var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = Integer.toString(var10);
                  return 1;
               } else if (var0 == 4107) {
                  HealthBar.Interpreter_stringStackSize -= 2;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = MoveSpeed.method1115(class188.compareStrings(Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize], Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 1], class69.clientLanguage));
                  return 1;
               } else {
                  int var5;
                  byte[] var13;
                  Font var14;
                  if (var0 == 4108) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var13 = TextureProvider.archive13.takeFile(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.lineCount(var3, var4);
                     return 1;
                  } else if (var0 == 4109) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var13 = TextureProvider.archive13.takeFile(var5, 0);
                     var14 = new Font(var13);
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14.lineWidth(var3, var4);
                     return 1;
                  } else if (var0 == 4110) {
                     HealthBar.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 1];
                     if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3;
                     } else {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9;
                     }

                     return 1;
                  } else if (var0 == 4111) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = AbstractFont.escapeBrackets(var3);
                     return 1;
                  } else if (var0 == 4112) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3 + (char)var4;
                     return 1;
                  } else if (var0 == 4113) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = MusicPatchPcmStream.isCharPrintable((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4114) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = PlayerComposition.isAlphaNumeric((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4115) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ArchiveDiskAction.isCharAlphabetic((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4116) {
                     var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class28.isDigit((char)var10) ? 1 : 0;
                     return 1;
                  } else if (var0 == 4117) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     if (var3 != null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.length();
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     }

                     return 1;
                  } else if (var0 == 4118) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.substring(var4, var5);
                     return 1;
                  } else if (var0 == 4119) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
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

                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var18.toString();
                     return 1;
                  } else if (var0 == 4120) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var4);
                     return 1;
                  } else if (var0 == 4121) {
                     HealthBar.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 1];
                     var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.indexOf(var9, var5);
                     return 1;
                  } else if (var0 == 4122) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3.toUpperCase();
                     return 1;
                  } else if (var0 == 4123) {
                     HealthBar.Interpreter_stringStackSize -= 3;
                     var3 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize];
                     var9 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 1];
                     String var15 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 2];
                     if (BuddyRankComparator.localPlayer.appearance == null) {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var15;
                        return 1;
                     } else {
                        switch(BuddyRankComparator.localPlayer.appearance.field2787) {
                        case 0:
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3;
                           break;
                        case 1:
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9;
                           break;
                        case 2:
                        default:
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var15;
                        }

                        return 1;
                     }
                  } else {
                     return 2;
                  }
               }
            } else {
               HealthBar.Interpreter_stringStackSize -= 2;
               var3 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize];
               var9 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 1];
               if (BuddyRankComparator.localPlayer.appearance != null && BuddyRankComparator.localPlayer.appearance.field2790 != 0) {
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9;
               } else {
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("kj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIIIZB)V",
      garbageValue = "55"
   )
   @Export("insertMenuItem")
   static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      if (!Client.isMenuOpen) {
         if (Client.menuOptionsCount < 500) {
            Client.menuActions[Client.menuOptionsCount] = var0;
            Client.menuTargets[Client.menuOptionsCount] = var1;
            Client.menuOpcodes[Client.menuOptionsCount] = var2;
            Client.menuIdentifiers[Client.menuOptionsCount] = var3;
            Client.menuArguments1[Client.menuOptionsCount] = var4;
            Client.menuArguments2[Client.menuOptionsCount] = var5;
            Client.menuItemIds[Client.menuOptionsCount] = var6;
            Client.menuShiftClick[Client.menuOptionsCount] = var7;
            ++Client.menuOptionsCount;
         }

      }
   }
}
