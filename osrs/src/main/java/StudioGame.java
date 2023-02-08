import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("le")
@Implements("StudioGame")
public enum StudioGame implements class349 {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lle;"
    )
    runescape("runescape", "RuneScape", 0),
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lle;"
    )
    stellardawn("stellardawn", "Stellar Dawn", 1),
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lle;"
    )
    game3("game3", "Game 3", 2),
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lle;"
    )
    game4("game4", "Game 4", 3),
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "Lle;"
    )
    game5("game5", "Game 5", 4),
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lle;"
    )
    oldscape("oldscape", "RuneScape 2007", 5);

    @ObfuscatedName("cl")
    @ObfuscatedSignature(
            descriptor = "Lrg;"
    )
    static IndexedSprite worldSelectLeftSprite;
    @ObfuscatedName("i")
    public final String name;
    @ObfuscatedName("n")
    final int id;

   StudioGame(String var3, String var4, int var5) {
      this.name = var3;
      this.id = var5;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.id;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/util/Date;",
      garbageValue = "1538018106"
   )
   static Date method1786() {
      java.util.Calendar var0 = java.util.Calendar.getInstance();
      var0.set(2, 0);
      var0.set(5, 1);
      var0.set(1, 1900);
      return var0.getTime();
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "62754255"
   )
   static int method1785(int var0, Script var1, boolean var2) {
      if (var0 == 5000) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else if (var0 == 5001) {
         class302.Interpreter_intStackSize -= 3;
         Client.publicChatMode = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         class288.privateChatMode = NewShit.method955(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]);
         if (class288.privateChatMode == null) {
            class288.privateChatMode = PrivateChatMode.field4117;
         }

         Client.tradeChatMode = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
         PacketBufferNode var11 = Renderable.getPacketBufferNode(ClientPacket.field2436, Client.packetWriter.isaacCipher);
         var11.packetBuffer.writeByte(Client.publicChatMode);
         var11.packetBuffer.writeByte(class288.privateChatMode.id);
         var11.packetBuffer.writeByte(Client.tradeChatMode);
         Client.packetWriter.addNode(var11);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         PacketBufferNode var6;
         if (var0 == 5002) {
            var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
            class302.Interpreter_intStackSize -= 2;
            var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
            var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            var6 = Renderable.getPacketBufferNode(ClientPacket.field2472, Client.packetWriter.isaacCipher);
            var6.packetBuffer.writeByte(class96.stringCp1252NullTerminatedByteSize(var3) + 2);
            var6.packetBuffer.writeStringCp1252NullTerminated(var3);
            var6.packetBuffer.writeByte(var4 - 1);
            var6.packetBuffer.writeByte(var5);
            Client.packetWriter.addNode(var6);
            return 1;
         } else {
            int var7;
            Message var8;
            if (var0 == 5003) {
               class302.Interpreter_intStackSize -= 2;
               var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
               var8 = Message.Messages_getByChannelAndID(var7, var4);
               if (var8 != null) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var8.count;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var8.cycle;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               Message var9;
               if (var0 == 5004) {
                  var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var9 = class17.Messages_getMessage(var7);
                  if (var9 != null) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var9.type;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var9.cycle;
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
                  } else {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 5005) {
                  if (class288.privateChatMode == null) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class288.privateChatMode.id;
                  }

                  return 1;
               } else {
                  PacketBufferNode var12;
                  if (var0 == 5008) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     var12 = class96.method579(var4, var3, class36.clientLanguage, -1);
                     Client.packetWriter.addNode(var12);
                     return 1;
                  } else if (var0 == 5009) {
                     class20.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize];
                     String var13 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 1];
                     var12 = Renderable.getPacketBufferNode(ClientPacket.field2443, Client.packetWriter.isaacCipher);
                     var12.packetBuffer.writeShort(0);
                     int var10 = var12.packetBuffer.offset;
                     var12.packetBuffer.writeStringCp1252NullTerminated(var3);
                     ServerPacket.method1540(var12.packetBuffer, var13);
                     var12.packetBuffer.writeLengthShort(var12.packetBuffer.offset - var10);
                     Client.packetWriter.addNode(var12);
                     return 1;
                  } else if (var0 == 5010) {
                     var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                     class302.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                     var6 = class96.method579(var4, var3, class36.clientLanguage, var5);
                     Client.packetWriter.addNode(var6);
                     return 1;
                  } else if (var0 != 5015) {
                     if (var0 == 5016) {
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.tradeChatMode;
                        return 1;
                     } else if (var0 == 5017) {
                        var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Projectile.Messages_getHistorySize(var7);
                        return 1;
                     } else if (var0 == 5018) {
                        var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class7.Messages_getLastChatID(var7);
                        return 1;
                     } else if (var0 == 5019) {
                        var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = WorldMapSection1.method1465(var7);
                        return 1;
                     } else if (var0 == 5020) {
                        var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                        ScriptFrame.doCheat(var3);
                        return 1;
                     } else if (var0 == 5021) {
                        Client.field604 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize].toLowerCase().trim();
                        return 1;
                     } else if (var0 == 5022) {
                        Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = Client.field604;
                        return 1;
                     } else if (var0 == 5023) {
                        var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                        System.out.println(var3);
                        return 1;
                     } else if (var0 == 5030) {
                        class302.Interpreter_intStackSize -= 2;
                        var7 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                        var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                        var8 = Message.Messages_getByChannelAndID(var7, var4);
                        if (var8 != null) {
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var8.count;
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var8.cycle;
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                        } else {
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if (var0 == 5031) {
                        var7 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                        var9 = class17.Messages_getMessage(var7);
                        if (var9 != null) {
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var9.type;
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var9.cycle;
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                        } else {
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = -1;
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     if (class387.localPlayer != null && class387.localPlayer.username != null) {
                        var3 = class387.localPlayer.username.getName();
                     } else {
                        var3 = "";
                     }

                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var3;
                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      descriptor = "(Lge;IIII)V",
      garbageValue = "1802078195"
   )
   static void method1784(SequenceDefinition var0, int var1, int var2, int var3) {
      if (Client.soundEffectCount < 50 && PacketWriter.clientPreferences.getAreaSoundEffectsVolume() != 0) {
         if (var0.animMayaFrameSounds != null && var0.animMayaFrameSounds.containsKey(var1)) {
            class461.method2333((Integer)var0.animMayaFrameSounds.get(var1), var2, var3);
         }
      }
   }
}
