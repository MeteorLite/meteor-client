import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hk")
public class class217 {
   @ObfuscatedName("ig")
   static int[] regionLandArchiveIds;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "[Ldc;"
   )
   class122[] field1982;
   @ObfuscatedName("v")
   int field1981;

   @ObfuscatedSignature(
      descriptor = "(Lrd;I)V"
   )
   class217(Buffer var1, int var2) {
      this.field1982 = new class122[var2];
      this.field1981 = var1.readUnsignedByte();

      for(int var3 = 0; var3 < this.field1982.length; ++var3) {
         class122 var4 = new class122(this.field1981, var1, false);
         this.field1982[var3] = var4;
      }

      this.method1179();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1141045260"
   )
   void method1179() {
      class122[] var1 = this.field1982;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class122 var3 = var1[var2];
         if (var3.field1184 >= 0) {
            var3.field1192 = this.field1982[var3.field1184];
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "20"
   )
   public int method1178() {
      return this.field1982.length;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)Ldc;",
      garbageValue = "-1083474755"
   )
   class122 method1176(int var1) {
      return var1 >= this.method1178() ? null : this.field1982[var1];
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(B)[Ldc;",
      garbageValue = "-24"
   )
   class122[] method1180() {
      return this.field1982;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(Lei;II)V",
      garbageValue = "76193627"
   )
   void method1181(class133 var1, int var2) {
      this.method1175(var1, var2, (boolean[])null, false);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(Lei;I[ZZI)V",
      garbageValue = "-1598359679"
   )
   void method1175(class133 var1, int var2, boolean[] var3, boolean var4) {
      int var5 = var1.method726();
      int var6 = 0;
      class122[] var7 = this.method1180();

      for(int var8 = 0; var8 < var7.length; ++var8) {
         class122 var9 = var7[var8];
         if (var3 == null || var4 == var3[var6]) {
            var1.method721(var2, var9, var6, var5);
         }

         ++var6;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "1299309656"
   )
   static int method1182(int var0, Script var1, boolean var2) {
      String var3;
      if (var0 == 3100) {
         var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
         ZoneOperation.addGameMessage(0, "", var3);
         return 1;
      } else if (var0 == 3101) {
         class302.Interpreter_intStackSize -= 2;
         PendingSpawn.performPlayerAnimation(class387.localPlayer, Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1]);
         return 1;
      } else if (var0 == 3103) {
         if (!Interpreter.field715) {
            Interpreter.field705 = true;
         }

         return 1;
      } else {
         int var10;
         if (var0 == 3104) {
            var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
            var10 = 0;
            if (class142.isNumber(var3)) {
               var10 = WorldMapScaleHandler.method1502(var3);
            }

            PacketBufferNode var12 = Renderable.getPacketBufferNode(ClientPacket.field2516, Client.packetWriter.isaacCipher);
            var12.packetBuffer.writeInt(var10);
            Client.packetWriter.addNode(var12);
            return 1;
         } else {
            PacketBufferNode var14;
            if (var0 == 3105) {
               var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               var14 = Renderable.getPacketBufferNode(ClientPacket.field2483, Client.packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(var3.length() + 1);
               var14.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.addNode(var14);
               return 1;
            } else if (var0 == 3106) {
               var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
               var14 = Renderable.getPacketBufferNode(ClientPacket.field2431, Client.packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(var3.length() + 1);
               var14.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.addNode(var14);
               return 1;
            } else {
               String var7;
               int var8;
               if (var0 == 3107) {
                  var8 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var7 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                  WorldMapIcon_0.method1426(var8, var7);
                  return 1;
               } else if (var0 == 3108) {
                  class302.Interpreter_intStackSize -= 3;
                  var8 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                  int var9 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
                  Widget var13 = class133.getWidget(var9);
                  UserComparator9.clickWidget(var13, var8, var10);
                  return 1;
               } else if (var0 == 3109) {
                  class302.Interpreter_intStackSize -= 2;
                  var8 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                  Widget var11 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
                  UserComparator9.clickWidget(var11, var8, var10);
                  return 1;
               } else if (var0 == 3110) {
                  ClanMate.mouseCam = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3111) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = PacketWriter.clientPreferences.getRoofsHidden() ? 1 : 0;
                  return 1;
               } else if (var0 == 3112) {
                  PacketWriter.clientPreferences.setRoofsHidden(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3113) {
                  var3 = Interpreter.Interpreter_stringStack[--class20.Interpreter_stringStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                  AttackOption.openURL(var3, var4, false);
                  return 1;
               } else if (var0 == 3115) {
                  var8 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  var14 = Renderable.getPacketBufferNode(ClientPacket.field2515, Client.packetWriter.isaacCipher);
                  var14.packetBuffer.writeShort(var8);
                  Client.packetWriter.addNode(var14);
                  return 1;
               } else if (var0 == 3116) {
                  var8 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  class20.Interpreter_stringStackSize -= 2;
                  var7 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize];
                  String var5 = Interpreter.Interpreter_stringStack[class20.Interpreter_stringStackSize + 1];
                  if (var7.length() > 500) {
                     return 1;
                  } else if (var5.length() > 500) {
                     return 1;
                  } else {
                     PacketBufferNode var6 = Renderable.getPacketBufferNode(ClientPacket.field2498, Client.packetWriter.isaacCipher);
                     var6.packetBuffer.writeShort(1 + class96.stringCp1252NullTerminatedByteSize(var7) + class96.stringCp1252NullTerminatedByteSize(var5));
                     var6.packetBuffer.writeStringCp1252NullTerminated(var5);
                     var6.packetBuffer.writeStringCp1252NullTerminated(var7);
                     var6.packetBuffer.method2399(var8);
                     Client.packetWriter.addNode(var6);
                     return 1;
                  }
               } else if (var0 == 3117) {
                  Client.shiftClickDrop = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3118) {
                  Client.showMouseOverText = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3119) {
                  Client.renderSelf = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3120) {
                  if (Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 1;
                  } else {
                     Client.drawPlayerNames &= -2;
                  }

                  return 1;
               } else if (var0 == 3121) {
                  if (Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 2;
                  } else {
                     Client.drawPlayerNames &= -3;
                  }

                  return 1;
               } else if (var0 == 3122) {
                  if (Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 4;
                  } else {
                     Client.drawPlayerNames &= -5;
                  }

                  return 1;
               } else if (var0 == 3123) {
                  if (Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 8;
                  } else {
                     Client.drawPlayerNames &= -9;
                  }

                  return 1;
               } else if (var0 == 3124) {
                  Client.drawPlayerNames = 0;
                  return 1;
               } else if (var0 == 3125) {
                  Client.showMouseCross = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3126) {
                  Client.showLoadingMessages = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3127) {
                  class237.setTapToDrop(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3128) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Language.getTapToDrop() ? 1 : 0;
                  return 1;
               } else if (var0 == 3129) {
                  class302.Interpreter_intStackSize -= 2;
                  Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
                  Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
                  return 1;
               } else if (var0 == 3130) {
                  class302.Interpreter_intStackSize -= 2;
                  return 1;
               } else if (var0 == 3131) {
                  --class302.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3132) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = GameEngine.canvasWidth;
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class127.canvasHeight;
                  return 1;
               } else if (var0 == 3133) {
                  --class302.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3134) {
                  return 1;
               } else if (var0 == 3135) {
                  class302.Interpreter_intStackSize -= 2;
                  return 1;
               } else if (var0 == 3136) {
                  Client.field662 = 3;
                  Client.field545 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3137) {
                  Client.field662 = 2;
                  Client.field545 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3138) {
                  Client.field662 = 0;
                  return 1;
               } else if (var0 == 3139) {
                  Client.field662 = 1;
                  return 1;
               } else if (var0 == 3140) {
                  Client.field662 = 3;
                  Client.field545 = var2 ? Interpreter.scriptDotWidget.id * -1493443793 * -62043185 : class85.scriptActiveWidget.id * -1493443793 * -62043185;
                  return 1;
               } else {
                  boolean var15;
                  if (var0 == 3141) {
                     var15 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     PacketWriter.clientPreferences.setIsUsernameHidden(var15);
                     return 1;
                  } else if (var0 == 3142) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = PacketWriter.clientPreferences.getIsUsernameHidden() ? 1 : 0;
                     return 1;
                  } else if (var0 == 3143) {
                     var15 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     Client.Login_isUsernameRemembered = var15;
                     if (!var15) {
                        PacketWriter.clientPreferences.setUsernameToRemember("");
                     }

                     return 1;
                  } else if (var0 == 3144) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
                     return 1;
                  } else if (var0 == 3145) {
                     return 1;
                  } else if (var0 == 3146) {
                     var15 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize] == 1;
                     PacketWriter.clientPreferences.getTitleMusicDisabled(!var15);
                     return 1;
                  } else if (var0 == 3147) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = PacketWriter.clientPreferences.getTitleMusicDisabled() ? 0 : 1;
                     return 1;
                  } else if (var0 == 3148) {
                     return 1;
                  } else if (var0 == 3149) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3150) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3151) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3152) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3153) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
                     return 1;
                  } else if (var0 == 3154) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class120.method670();
                     return 1;
                  } else if (var0 == 3155) {
                     --class20.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3156) {
                     return 1;
                  } else if (var0 == 3157) {
                     class302.Interpreter_intStackSize -= 2;
                     return 1;
                  } else if (var0 == 3158) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3159) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3160) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3161) {
                     --class302.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3162) {
                     --class302.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3163) {
                     --class20.Interpreter_stringStackSize;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3164) {
                     --class302.Interpreter_intStackSize;
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     return 1;
                  } else if (var0 == 3165) {
                     --class302.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3166) {
                     class302.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3167) {
                     class302.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3168) {
                     class302.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = "";
                     return 1;
                  } else if (var0 == 3169) {
                     return 1;
                  } else if (var0 == 3170) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3171) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3172) {
                     --class302.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 3173) {
                     --class302.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3174) {
                     --class302.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 3175) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3176) {
                     return 1;
                  } else if (var0 == 3177) {
                     return 1;
                  } else if (var0 == 3178) {
                     --class20.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3179) {
                     return 1;
                  } else if (var0 == 3180) {
                     --class20.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3181) {
                     LoginScreenAnimation.method516(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
                     return 1;
                  } else if (var0 == 3182) {
                     Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = class463.method2340();
                     return 1;
                  } else if (var0 == 3189) {
                     var8 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
                     Archive.method1806(var8);
                     return 1;
                  } else {
                     return 2;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZS)I",
      garbageValue = "10769"
   )
   static int method1177(int var0, Script var1, boolean var2) {
      if (var0 == 5630) {
         Client.logoutTimer = 250;
         return 1;
      } else {
         return 2;
      }
   }
}
