import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bq")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
   @ObfuscatedName("gh")
   static int field162;
   @ObfuscatedName("lv")
   @Export("oculusOrbFocalPointY")
   static int oculusOrbFocalPointY;
   @ObfuscatedName("sb")
   @ObfuscatedSignature(
      descriptor = "Lpa;"
   )
   @Export("friendsChat")
   static FriendsChat friendsChat;
   @ObfuscatedName("aj")
   @Export("id")
   int id;
   @ObfuscatedName("al")
   @Export("size")
   int size;
   @ObfuscatedName("ac")
   @Export("operations")
   int[] operations;
   @ObfuscatedName("ab")
   @Export("creationErrors")
   int[] creationErrors;
   @ObfuscatedName("an")
   Field[] fields;
   @ObfuscatedName("ao")
   @Export("intReplaceValues")
   int[] intReplaceValues;
   @ObfuscatedName("av")
   @Export("methods")
   Method[] methods;
   @ObfuscatedName("aq")
   @Export("arguments")
   byte[][][] arguments;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "-1962053314"
   )
   public static boolean method180(char var0) {
      if ((var0 < ' ' || var0 >= 127) && (var0 <= 127 || var0 >= 160) && (var0 <= 160 || var0 > 255)) {
         if (var0 != 0) {
            char[] var1 = class365.cp1252AsciiExtension;

            for(int var2 = 0; var2 < var1.length; ++var2) {
               char var3 = var1[var2];
               if (var0 == var3) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-983265887"
   )
   static void method178() {
      if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
         Login.currentLoginField = 1;
      } else {
         Login.currentLoginField = 0;
      }

   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "-80"
   )
   static int method179(int var0, Script var1, boolean var2) {
      if (var0 == 3800) {
         if (WorldMapCacheName.guestClanSettings != null) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
            class366.field3544 = WorldMapCacheName.guestClanSettings;
         } else {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else {
         int var3;
         if (var0 == 3801) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (Client.currentClanSettings[var3] != null) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
               class366.field3544 = Client.currentClanSettings[var3];
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else if (var0 == 3802) {
            Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = class366.field3544.name;
            return 1;
         } else if (var0 == 3803) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.allowGuests ? 1 : 0;
            return 1;
         } else if (var0 == 3804) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.field1342;
            return 1;
         } else if (var0 == 3805) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.field1346;
            return 1;
         } else if (var0 == 3806) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.field1343;
            return 1;
         } else if (var0 == 3807) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.field1344;
            return 1;
         } else if (var0 == 3809) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.memberCount;
            return 1;
         } else if (var0 == 3810) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = class366.field3544.memberNames[var3];
            return 1;
         } else if (var0 == 3811) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.memberRanks[var3];
            return 1;
         } else if (var0 == 3812) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.bannedMemberCount;
            return 1;
         } else if (var0 == 3813) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = class366.field3544.bannedMemberNames[var3];
            return 1;
         } else {
            int var5;
            int var6;
            if (var0 == 3814) {
               Interpreter.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.method791(var3, var6, var5);
               return 1;
            } else if (var0 == 3815) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.currentOwner;
               return 1;
            } else if (var0 == 3816) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.field1352;
               return 1;
            } else if (var0 == 3817) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.method809(Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize]);
               return 1;
            } else if (var0 == 3818) {
               Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = class366.field3544.getSortedMembers()[Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]];
               return 1;
            } else if (var0 == 3819) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               class199.method1003(var6, var3);
               return 1;
            } else if (var0 == 3820) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.field1349[var3];
               return 1;
            } else {
               if (var0 == 3821) {
                  Interpreter.Interpreter_intStackSize -= 3;
                  var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
                  var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
                  WorldMapArea.method1358(var5, var3, var4);
               }

               if (var0 == 3822) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class366.field3544.field1350[var3] ? 1 : 0;
                  return 1;
               } else if (var0 == 3850) {
                  if (class19.guestClanChannel != null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                     class19.field60 = class19.guestClanChannel;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 3851) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  if (Client.currentClanChannels[var3] != null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                     class19.field60 = Client.currentClanChannels[var3];
                     class208.field1826 = var3;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 3852) {
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = class19.field60.name;
                  return 1;
               } else if (var0 == 3853) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class19.field60.field1388;
                  return 1;
               } else if (var0 == 3854) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class19.field60.field1385;
                  return 1;
               } else if (var0 == 3855) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class19.field60.method843();
                  return 1;
               } else if (var0 == 3856) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = ((ClanChannelMember)class19.field60.members.get(var3)).username.getName();
                  return 1;
               } else if (var0 == 3857) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((ClanChannelMember)class19.field60.members.get(var3)).rank;
                  return 1;
               } else if (var0 == 3858) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((ClanChannelMember)class19.field60.members.get(var3)).world;
                  return 1;
               } else if (var0 == 3859) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  class20.method83(class208.field1826, var3);
                  return 1;
               } else if (var0 == 3860) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class19.field60.method846(Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize]);
                  return 1;
               } else if (var0 == 3861) {
                  Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = class19.field60.getSortedMembers()[Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]];
                  return 1;
               } else if (var0 == 3890) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class188.field1522 != null ? 1 : 0;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
