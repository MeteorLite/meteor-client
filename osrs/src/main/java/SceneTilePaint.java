import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hj")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
   @ObfuscatedName("l")
   public static byte[][][] ByteArrayPool_arrays;
   @ObfuscatedName("db")
   static boolean mouseCam;
   @ObfuscatedName("h")
   int swColor;
   @ObfuscatedName("e")
   int seColor;
   @ObfuscatedName("v")
   int neColor;
   @ObfuscatedName("x")
   int nwColor;
   @ObfuscatedName("m")
   int texture;
   @ObfuscatedName("q")
   boolean isFlat = true;
   @ObfuscatedName("f")
   int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.isFlat = var7;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(II)Lrt;",
      garbageValue = "631994565"
   )
   public static PrivateChatMode method1286(int var0) {
      PrivateChatMode[] var1 = new PrivateChatMode[]{PrivateChatMode.field4104, PrivateChatMode.field4106, PrivateChatMode.field4103};
      PrivateChatMode[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         PrivateChatMode var4 = var2[var3];
         if (var0 == var4.field4105) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZB)I",
      garbageValue = "-3"
   )
   static int method1285(int var0, Script var1, boolean var2) {
      if (var0 == 3800) {
         if (class20.guestClanSettings != null) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
            class126.field1235 = class20.guestClanSettings;
         } else {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else {
         int var3;
         if (var0 == 3801) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            if (Client.currentClanSettings[var3] != null) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
               class126.field1235 = Client.currentClanSettings[var3];
            } else {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else if (var0 == 3802) {
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class126.field1235.name;
            return 1;
         } else if (var0 == 3803) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.allowGuests ? 1 : 0;
            return 1;
         } else if (var0 == 3804) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.field1342;
            return 1;
         } else if (var0 == 3805) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.field1343;
            return 1;
         } else if (var0 == 3806) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.field1346;
            return 1;
         } else if (var0 == 3807) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.field1344;
            return 1;
         } else if (var0 == 3809) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.memberCount;
            return 1;
         } else if (var0 == 3810) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class126.field1235.memberNames[var3];
            return 1;
         } else if (var0 == 3811) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.memberRanks[var3];
            return 1;
         } else if (var0 == 3812) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.bannedMemberCount;
            return 1;
         } else if (var0 == 3813) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = class126.field1235.bannedMemberNames[var3];
            return 1;
         } else {
            int var5;
            int var6;
            if (var0 == 3814) {
               class87.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.method781(var3, var6, var5);
               return 1;
            } else if (var0 == 3815) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.currentOwner;
               return 1;
            } else if (var0 == 3816) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.field1352;
               return 1;
            } else if (var0 == 3817) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.method778(Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
               return 1;
            } else if (var0 == 3818) {
               Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize - 1] = class126.field1235.getSortedMembers()[Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize - 1]];
               return 1;
            } else if (var0 == 3819) {
               class87.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
               Archive.method1794(var6, var3);
               return 1;
            } else if (var0 == 3820) {
               var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.field1334[var3];
               return 1;
            } else {
               if (var0 == 3821) {
                  class87.Interpreter_intStackSize -= 3;
                  var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1] == 1;
                  var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
                  FaceNormal.method1237(var5, var3, var4);
               }

               if (var0 == 3822) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class126.field1235.field1338[var3] ? 1 : 0;
                  return 1;
               } else if (var0 == 3850) {
                  if (VarcInt.guestClanChannel != null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
                     VarcInt.field1497 = VarcInt.guestClanChannel;
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 3851) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  if (Client.currentClanChannels[var3] != null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
                     VarcInt.field1497 = Client.currentClanChannels[var3];
                     class13.field39 = var3;
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 3852) {
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = VarcInt.field1497.name;
                  return 1;
               } else if (var0 == 3853) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = VarcInt.field1497.field1392;
                  return 1;
               } else if (var0 == 3854) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = VarcInt.field1497.field1390;
                  return 1;
               } else if (var0 == 3855) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = VarcInt.field1497.method828();
                  return 1;
               } else if (var0 == 3856) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = ((ClanChannelMember)VarcInt.field1497.members.get(var3)).username.getName();
                  return 1;
               } else if (var0 == 3857) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ((ClanChannelMember)VarcInt.field1497.members.get(var3)).rank;
                  return 1;
               } else if (var0 == 3858) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = ((ClanChannelMember)VarcInt.field1497.members.get(var3)).world;
                  return 1;
               } else if (var0 == 3859) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  ScriptFrame.method332(class13.field39, var3);
                  return 1;
               } else if (var0 == 3860) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = VarcInt.field1497.method829(Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize]);
                  return 1;
               } else if (var0 == 3861) {
                  Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize - 1] = VarcInt.field1497.getSortedMembers()[Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize - 1]];
                  return 1;
               } else if (var0 == 3890) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = LoginScreenAnimation.field1028 != null ? 1 : 0;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }
}
