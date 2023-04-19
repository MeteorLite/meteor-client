import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sh")
public class class478 implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lsh;"
   )
   public static final class478 field4028 = new class478(1, 0, Integer.class, new class475());
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lsh;"
   )
   public static final class478 field4027 = new class478(0, 1, Long.class, new class477());
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lsh;"
   )
   public static final class478 field4026 = new class478(2, 2, String.class, new class479());
   @ObfuscatedName("ac")
   public final int field4029;
   @ObfuscatedName("au")
   public final int field4030;
   @ObfuscatedName("ab")
   public final Class field4031;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Lss;"
   )
   final class474 field4032;

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/Class;Lss;)V"
   )
   class478(int var1, int var2, Class var3, class474 var4) {
      this.field4029 = var1;
      this.field4030 = var2;
      this.field4031 = var3;
      this.field4032 = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field4030;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(Lsg;I)Ljava/lang/Object;",
      garbageValue = "-1183771146"
   )
   public Object method2435(Buffer var1) {
      return this.field4032.vmethod8273(var1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lnm;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "435790040"
   )
   public static void method2438(AbstractArchive var0, String var1, String var2, int var3, boolean var4) {
      if (var0.isValidFileName(var1, var2)) {
         int var5 = var0.getGroupId(var1);
         int var6 = var0.getFileId(var5, var2);
         Message.method355(var0, var5, var6, var3, var4);
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(S)Llg;",
      garbageValue = "-11844"
   )
   public static PacketBufferNode method2430() {
      PacketBufferNode var0 = SpotAnimationDefinition.method1044();
      var0.clientPacket = null;
      var0.clientPacketLength = 0;
      var0.packetBuffer = new PacketBuffer(5000);
      return var0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)[Lsh;",
      garbageValue = "-1831694021"
   )
   public static class478[] method2432() {
      return new class478[]{field4028, field4027, field4026};
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Class;S)Lsh;",
      garbageValue = "-16288"
   )
   public static class478 method2431(Class var0) {
      class478[] var1 = method2432();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class478 var3 = var1[var2];
         if (var3.field4031 == var0) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Lsg;I)V",
      garbageValue = "779443646"
   )
   public static void method2440(Object var0, Buffer var1) {
      class474 var2 = method2433(var0.getClass());
      var2.vmethod8274(var0, var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Class;I)Lss;",
      garbageValue = "-1458293291"
   )
   static class474 method2433(Class var0) {
      class478 var1 = method2431(var0);
      if (var1 == null) {
         throw new IllegalArgumentException();
      } else {
         return var1.field4032;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "0"
   )
   static final int method2437(int var0, int var1) {
      if (var0 == -2) {
         return 12345678;
      } else if (var0 == -1) {
         if (var1 < 2) {
            var1 = 2;
         } else if (var1 > 126) {
            var1 = 126;
         }

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

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "0"
   )
   static int method2436(int var0, Script var1, boolean var2) {
      if (var0 == 3800) {
         if (ItemComposition.guestClanSettings != null) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
            class133.field1286 = ItemComposition.guestClanSettings;
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
               class133.field1286 = Client.currentClanSettings[var3];
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         } else if (var0 == 3802) {
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = class133.field1286.name;
            return 1;
         } else if (var0 == 3803) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.allowGuests ? 1 : 0;
            return 1;
         } else if (var0 == 3804) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.field1369;
            return 1;
         } else if (var0 == 3805) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.field1359;
            return 1;
         } else if (var0 == 3806) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.field1360;
            return 1;
         } else if (var0 == 3807) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.field1351;
            return 1;
         } else if (var0 == 3809) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.memberCount;
            return 1;
         } else if (var0 == 3810) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = class133.field1286.memberNames[var3];
            return 1;
         } else if (var0 == 3811) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.memberRanks[var3];
            return 1;
         } else if (var0 == 3812) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.bannedMemberCount;
            return 1;
         } else if (var0 == 3813) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = class133.field1286.bannedMemberNames[var3];
            return 1;
         } else {
            int var5;
            int var6;
            if (var0 == 3814) {
               Interpreter.Interpreter_intStackSize -= 3;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.method852(var3, var6, var5);
               return 1;
            } else if (var0 == 3815) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.currentOwner;
               return 1;
            } else if (var0 == 3816) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.field1374;
               return 1;
            } else if (var0 == 3817) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.method851(Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize]);
               return 1;
            } else if (var0 == 3818) {
               Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = class133.field1286.getSortedMembers()[Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]];
               return 1;
            } else if (var0 == 3819) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               WorldMapScaleHandler.method1567(var6, var3);
               return 1;
            } else if (var0 == 3820) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.field1366[var3];
               return 1;
            } else {
               if (var0 == 3821) {
                  Interpreter.Interpreter_intStackSize -= 3;
                  var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
                  var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
                  Clock.method970(var5, var3, var4);
               }

               if (var0 == 3822) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class133.field1286.field1375[var3] ? 1 : 0;
                  return 1;
               } else if (var0 == 3850) {
                  if (MouseHandler.guestClanChannel != null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                     class147.field1346 = MouseHandler.guestClanChannel;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 3851) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  if (Client.currentClanChannels[var3] != null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
                     class147.field1346 = Client.currentClanChannels[var3];
                     Login.field763 = var3;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 3852) {
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = class147.field1346.name;
                  return 1;
               } else if (var0 == 3853) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class147.field1346.field1401;
                  return 1;
               } else if (var0 == 3854) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class147.field1346.field1396;
                  return 1;
               } else if (var0 == 3855) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class147.field1346.method898();
                  return 1;
               } else if (var0 == 3856) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = ((ClanChannelMember)class147.field1346.members.get(var3)).username.getName();
                  return 1;
               } else if (var0 == 3857) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((ClanChannelMember)class147.field1346.members.get(var3)).rank;
                  return 1;
               } else if (var0 == 3858) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ((ClanChannelMember)class147.field1346.members.get(var3)).world;
                  return 1;
               } else if (var0 == 3859) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  class151.method872(Login.field763, var3);
                  return 1;
               } else if (var0 == 3860) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class147.field1346.method897(Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize]);
                  return 1;
               } else if (var0 == 3861) {
                  Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = class147.field1346.getSortedMembers()[Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]];
                  return 1;
               } else if (var0 == 3890) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Players.varclan != null ? 1 : 0;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

    @ObfuscatedName("nm")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;B)V",
            garbageValue = "90"
    )
    static final void clanKickUser(String var0) {
      if (UserComparator5.friendsChat != null) {
         PacketBufferNode var1 = class330.getPacketBufferNode(ClientPacket.field2550, Client.packetWriter.isaacCipher);
         var1.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var0));
         var1.packetBuffer.writeStringCp1252NullTerminated(var0);
         Client.packetWriter.addNode(var1);
      }
   }
}
