import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("du")
@Implements("ChatChannel")
public class ChatChannel {
   @ObfuscatedName("ao")
   @Export("PcmPlayer_stereo")
   protected static boolean PcmPlayer_stereo;
   @ObfuscatedName("ap")
   @Export("ItemDefinition_fileCount")
   public static int ItemDefinition_fileCount;
   @ObfuscatedName("ai")
   @Export("operatingSystemName")
   static String operatingSystemName;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "[Lct;"
   )
   @Export("messages")
   Message[] messages = new Message[100];
   @ObfuscatedName("ac")
   @Export("count")
   int count;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lct;",
      garbageValue = "-597460193"
   )
   @Export("addMessage")
   Message addMessage(int var1, String var2, String var3, String var4) {
      Message var5 = this.messages[99];

      for(int var6 = this.count; var6 > 0; --var6) {
         if (var6 != 100) {
            this.messages[var6] = this.messages[var6 - 1];
         }
      }

      if (var5 == null) {
         var5 = new Message(var1, var2, var4, var3);
      } else {
         var5.remove();
         var5.removeDual();
         var5.set(var1, var2, var4, var3);
      }

      this.messages[0] = var5;
      if (this.count < 100) {
         ++this.count;
      }

      return var5;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(IB)Lct;",
      garbageValue = "-25"
   )
   @Export("getMessage")
   Message getMessage(int var1) {
      return var1 >= 0 && var1 < this.count ? this.messages[var1] : null;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1376119256"
   )
   @Export("size")
   int size() {
      return this.count;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-6"
   )
   static void method445() {
      try {
         File var0 = new File(class16.userHomeDirectory, "random.dat");
         int var2;
         if (var0.exists()) {
            JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
         } else {
            label38:
            for(int var1 = 0; var1 < StudioGame.cacheSubPaths.length; ++var1) {
               for(var2 = 0; var2 < class164.cacheParentPaths.length; ++var2) {
                  File var3 = new File(class164.cacheParentPaths[var2] + StudioGame.cacheSubPaths[var1] + File.separatorChar + "random.dat");
                  if (var3.exists()) {
                     JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var3, "rw", 25L), 24, 0);
                     break label38;
                  }
               }
            }
         }

         if (JagexCache.JagexCache_randomDat == null) {
            RandomAccessFile var4 = new RandomAccessFile(var0, "rw");
            var2 = var4.read();
            var4.seek(0L);
            var4.write(var2);
            var4.seek(0L);
            var4.close();
            JagexCache.JagexCache_randomDat = new BufferedFile(new AccessFile(var0, "rw", 25L), 24, 0);
         }
      } catch (IOException var5) {
         ;
      }

   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "52"
   )
   static int method448(int var0, Script var1, boolean var2) {
      String var3;
      if (var0 == 3100) {
         var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
         MusicPatchNode.addGameMessage(0, "", var3);
         return 1;
      } else if (var0 == 3101) {
         Interpreter.Interpreter_intStackSize -= 2;
         Language.performPlayerAnimation(BuddyRankComparator.localPlayer, Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         return 1;
      } else if (var0 == 3103) {
         if (!Interpreter.field692) {
            Interpreter.field691 = true;
         }

         return 1;
      } else {
         int var10;
         if (var0 == 3104) {
            var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
            var10 = 0;
            if (class162.isNumber(var3)) {
               var10 = GrandExchangeEvent.method1867(var3);
            }

            PacketBufferNode var12 = UserComparator9.getPacketBufferNode(ClientPacket.field2429, Client.packetWriter.isaacCipher);
            var12.packetBuffer.writeInt(var10);
            Client.packetWriter.addNode(var12);
            return 1;
         } else {
            PacketBufferNode var14;
            if (var0 == 3105) {
               var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
               var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2474, Client.packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(var3.length() + 1);
               var14.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.addNode(var14);
               return 1;
            } else if (var0 == 3106) {
               var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
               var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2501, Client.packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(var3.length() + 1);
               var14.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.addNode(var14);
               return 1;
            } else {
               String var7;
               int var8;
               if (var0 == 3107) {
                  var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var7 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                  FontName.method2312(var8, var7);
                  return 1;
               } else if (var0 == 3108) {
                  Interpreter.Interpreter_intStackSize -= 3;
                  var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                  int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
                  Widget var13 = WorldMapSection1.getWidget(var9);
                  AbstractWorldMapData.clickWidget(var13, var8, var10);
                  return 1;
               } else if (var0 == 3109) {
                  Interpreter.Interpreter_intStackSize -= 2;
                  var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                  Widget var11 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
                  AbstractWorldMapData.clickWidget(var11, var8, var10);
                  return 1;
               } else if (var0 == 3110) {
                  class319.mouseCam = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3111) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapSectionType.clientPreferences.getRoofsHidden() ? 1 : 0;
                  return 1;
               } else if (var0 == 3112) {
                  WorldMapSectionType.clientPreferences.setRoofsHidden(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3113) {
                  var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  KeyHandler.openURL(var3, var4, false);
                  return 1;
               } else if (var0 == 3115) {
                  var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var14 = UserComparator9.getPacketBufferNode(ClientPacket.field2510, Client.packetWriter.isaacCipher);
                  var14.packetBuffer.writeShort(var8);
                  Client.packetWriter.addNode(var14);
                  return 1;
               } else if (var0 == 3116) {
                  var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  HealthBar.Interpreter_stringStackSize -= 2;
                  var7 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize];
                  String var5 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 1];
                  if (var7.length() > 500) {
                     return 1;
                  } else if (var5.length() > 500) {
                     return 1;
                  } else {
                     PacketBufferNode var6 = UserComparator9.getPacketBufferNode(ClientPacket.field2505, Client.packetWriter.isaacCipher);
                     var6.packetBuffer.writeShort(1 + WorldMapLabel.stringCp1252NullTerminatedByteSize(var7) + WorldMapLabel.stringCp1252NullTerminatedByteSize(var5));
                     var6.packetBuffer.writeByteSigned(var8);
                     var6.packetBuffer.writeStringCp1252NullTerminated(var5);
                     var6.packetBuffer.writeStringCp1252NullTerminated(var7);
                     Client.packetWriter.addNode(var6);
                     return 1;
                  }
               } else if (var0 == 3117) {
                  --Interpreter.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3118) {
                  Client.showMouseOverText = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3119) {
                  Client.renderSelf = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3120) {
                  if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 1;
                  } else {
                     Client.drawPlayerNames &= -2;
                  }

                  return 1;
               } else if (var0 == 3121) {
                  if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 2;
                  } else {
                     Client.drawPlayerNames &= -3;
                  }

                  return 1;
               } else if (var0 == 3122) {
                  if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 4;
                  } else {
                     Client.drawPlayerNames &= -5;
                  }

                  return 1;
               } else if (var0 == 3123) {
                  if (Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 8;
                  } else {
                     Client.drawPlayerNames &= -9;
                  }

                  return 1;
               } else if (var0 == 3124) {
                  Client.drawPlayerNames = 0;
                  return 1;
               } else if (var0 == 3125) {
                  Client.showMouseCross = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3126) {
                  Client.showLoadingMessages = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3127) {
                  ClanSettings.setTapToDrop(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3128) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Coord.getTapToDrop() ? 1 : 0;
                  return 1;
               } else if (var0 == 3129) {
                  Interpreter.Interpreter_intStackSize -= 2;
                  Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                  Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                  return 1;
               } else if (var0 == 3130) {
                  Interpreter.Interpreter_intStackSize -= 2;
                  return 1;
               } else if (var0 == 3131) {
                  --Interpreter.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3132) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GameEngine.canvasWidth;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class143.canvasHeight;
                  return 1;
               } else if (var0 == 3133) {
                  --Interpreter.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3134) {
                  return 1;
               } else if (var0 == 3135) {
                  Interpreter.Interpreter_intStackSize -= 2;
                  return 1;
               } else if (var0 == 3136) {
                  Client.field521 = 3;
                  Client.field635 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3137) {
                  Client.field521 = 2;
                  Client.field635 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3138) {
                  Client.field521 = 0;
                  return 1;
               } else if (var0 == 3139) {
                  Client.field521 = 1;
                  return 1;
               } else if (var0 == 3140) {
                  Client.field521 = 3;
                  Client.field635 = var2 ? GameObject.scriptDotWidget.id * -672060695 * -1052750503 : SoundSystem.scriptActiveWidget.id * -672060695 * -1052750503;
                  return 1;
               } else {
                  boolean var15;
                  if (var0 == 3141) {
                     var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     WorldMapSectionType.clientPreferences.setIsUsernameHidden(var15);
                     return 1;
                  } else if (var0 == 3142) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapSectionType.clientPreferences.getIsUsernameHidden() ? 1 : 0;
                     return 1;
                  } else if (var0 == 3143) {
                     var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     Client.Login_isUsernameRemembered = var15;
                     if (!var15) {
                        WorldMapSectionType.clientPreferences.setUsernameToRemember("");
                     }

                     return 1;
                  } else if (var0 == 3144) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
                     return 1;
                  } else if (var0 == 3145) {
                     return 1;
                  } else if (var0 == 3146) {
                     var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     WorldMapSectionType.clientPreferences.getTitleMusicDisabled(!var15);
                     return 1;
                  } else if (var0 == 3147) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapSectionType.clientPreferences.getTitleMusicDisabled() ? 0 : 1;
                     return 1;
                  } else if (var0 == 3148) {
                     return 1;
                  } else if (var0 == 3149) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3150) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3151) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3152) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3153) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
                     return 1;
                  } else if (var0 == 3154) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.method48();
                     return 1;
                  } else if (var0 == 3155) {
                     --HealthBar.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3156) {
                     return 1;
                  } else if (var0 == 3157) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     return 1;
                  } else if (var0 == 3158) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3159) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3160) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3161) {
                     --Interpreter.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3162) {
                     --Interpreter.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3163) {
                     --HealthBar.Interpreter_stringStackSize;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3164) {
                     --Interpreter.Interpreter_intStackSize;
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     return 1;
                  } else if (var0 == 3165) {
                     --Interpreter.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3166) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3167) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3168) {
                     Interpreter.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     return 1;
                  } else if (var0 == 3169) {
                     return 1;
                  } else if (var0 == 3170) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3171) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3172) {
                     --Interpreter.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 3173) {
                     --Interpreter.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3174) {
                     --Interpreter.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 3175) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3176) {
                     return 1;
                  } else if (var0 == 3177) {
                     return 1;
                  } else if (var0 == 3178) {
                     --HealthBar.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3179) {
                     return 1;
                  } else if (var0 == 3180) {
                     --HealthBar.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3181) {
                     Skeleton.method1188(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                     return 1;
                  } else if (var0 == 3182) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = NetCache.method1853();
                     return 1;
                  } else if (var0 == 3189) {
                     var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     PacketWriter.method628(var8);
                     return 1;
                  } else {
                     return 2;
                  }
               }
            }
         }
      }
   }
}
