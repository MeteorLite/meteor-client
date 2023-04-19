import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eg")
@Implements("UserComparator6")
public class UserComparator6 extends AbstractUserComparator {
    @ObfuscatedName("eq")
    @ObfuscatedSignature(
            descriptor = "Ldl;"
    )
    static MouseRecorder mouseRecorder;
    @ObfuscatedName("af")
    final boolean reversed;

   public UserComparator6(boolean var1) {
      this.reversed = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lpb;Lpb;I)I",
            garbageValue = "2114105554"
    )
    int compareBuddy(Buddy var1, Buddy var2) {
      if (var1.world != 0 && var2.world != 0) {
         return this.reversed ? var1.getUsername().compareToTyped(var2.getUsername()) : var2.getUsername().compareToTyped(var1.getUsername());
      } else {
         return this.compareUser(var1, var2);
      }
   }

    @ObfuscatedName("compare")
    public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("an")
   static boolean method715(long var0) {
      return TextureProvider.method1306(var0) == 2;
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "-45"
   )
   static int method714(int var0, Script var1, boolean var2) {
      if (var0 == 5000) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else if (var0 == 5001) {
         Interpreter.Interpreter_intStackSize -= 3;
         Client.publicChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         FloorUnderlayDefinition.privateChatMode = class399.method2129(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         if (FloorUnderlayDefinition.privateChatMode == null) {
            FloorUnderlayDefinition.privateChatMode = PrivateChatMode.field4161;
         }

         Client.tradeChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         PacketBufferNode var11 = class330.getPacketBufferNode(ClientPacket.field2502, Client.packetWriter.isaacCipher);
         var11.packetBuffer.writeByte(Client.publicChatMode);
         var11.packetBuffer.writeByte(FloorUnderlayDefinition.privateChatMode.id);
         var11.packetBuffer.writeByte(Client.tradeChatMode);
         Client.packetWriter.addNode(var11);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         PacketBufferNode var6;
         if (var0 == 5002) {
            var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
            Interpreter.Interpreter_intStackSize -= 2;
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var6 = class330.getPacketBufferNode(ClientPacket.okjsnafkajsfn, Client.packetWriter.isaacCipher);
            var6.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var3) + 2);
            var6.packetBuffer.writeStringCp1252NullTerminated(var3);
            var6.packetBuffer.writeByte(var4 - 1);
            var6.packetBuffer.writeByte(var5);
            Client.packetWriter.addNode(var6);
            return 1;
         } else {
            int var7;
            Message var8;
            if (var0 == 5003) {
               Interpreter.Interpreter_intStackSize -= 2;
               var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var8 = Actor.Messages_getByChannelAndID(var7, var4);
               if (var8 != null) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.count;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.cycle;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               Message var9;
               if (var0 == 5004) {
                  var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var9 = MouseRecorder.Messages_getMessage(var7);
                  if (var9 != null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.type;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.cycle;
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 5005) {
                  if (FloorUnderlayDefinition.privateChatMode == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FloorUnderlayDefinition.privateChatMode.id;
                  }

                  return 1;
               } else {
                  PacketBufferNode var12;
                  if (var0 == 5008) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     var12 = class314.method1774(var4, var3, ClanSettings.clientLanguage, -1);
                     Client.packetWriter.addNode(var12);
                     return 1;
                  } else if (var0 == 5009) {
                     SecureRandomCallable.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize];
                     String var13 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 1];
                     var12 = class330.getPacketBufferNode(ClientPacket.field2522, Client.packetWriter.isaacCipher);
                     var12.packetBuffer.writeShort(0);
                     int var10 = var12.packetBuffer.offset;
                     var12.packetBuffer.writeStringCp1252NullTerminated(var3);
                     WorldMapArea.method1432(var12.packetBuffer, var13);
                     var12.packetBuffer.writeLengthShort(var12.packetBuffer.offset - var10);
                     Client.packetWriter.addNode(var12);
                     return 1;
                  } else if (var0 == 5010) {
                     var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var6 = class314.method1774(var4, var3, ClanSettings.clientLanguage, var5);
                     Client.packetWriter.addNode(var6);
                     return 1;
                  } else if (var0 != 5015) {
                     if (var0 == 5016) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.tradeChatMode;
                        return 1;
                     } else if (var0 == 5017) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = World.Messages_getHistorySize(var7);
                        return 1;
                     } else if (var0 == 5018) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = FaceNormal.Messages_getLastChatID(var7);
                        return 1;
                     } else if (var0 == 5019) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = BuddyRankComparator.method707(var7);
                        return 1;
                     } else if (var0 == 5020) {
                        var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                        DynamicObject.doCheat(var3);
                        return 1;
                     } else if (var0 == 5021) {
                        Client.field586 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize].toLowerCase().trim();
                        return 1;
                     } else if (var0 == 5022) {
                        Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = Client.field586;
                        return 1;
                     } else if (var0 == 5023) {
                        var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                        System.out.println(var3);
                        return 1;
                     } else if (var0 == 5030) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                        var8 = Actor.Messages_getByChannelAndID(var7, var4);
                        if (var8 != null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.count;
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.cycle;
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if (var0 == 5031) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        var9 = MouseRecorder.Messages_getMessage(var7);
                        if (var9 != null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.type;
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.cycle;
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     if (MusicPatchNode.localPlayer != null && MusicPatchNode.localPlayer.username != null) {
                        var3 = MusicPatchNode.localPlayer.username.getName();
                     } else {
                        var3 = "";
                     }

                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3;
                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      descriptor = "(Lde;II)V",
      garbageValue = "1654924432"
   )
   static final void method716(Actor var0, int var1) {
      class374.worldToScreen(var0.x, var0.y, var1);
   }
}
