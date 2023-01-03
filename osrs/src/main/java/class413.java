import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("om")
public enum class413 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lom;"
   )
   field3784(2, 1),
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lom;"
   )
   field3780(0, 2),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lom;"
   )
   field3781(1, 3),
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lom;"
   )
   field3782(3, 10);

   @ObfuscatedName("m")
   final int field3783;
   @ObfuscatedName("q")
   final int field3785;

   class413(int var3, int var4) {
      this.field3783 = var3;
      this.field3785 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.field3785;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZB)I",
      garbageValue = "16"
   )
   static int method2154(int var0, Script var1, boolean var2) {
      String var3;
      if (var0 == 3100) {
         var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
         KitDefinition.addGameMessage(0, "", var3);
         return 1;
      } else if (var0 == 3101) {
         class87.Interpreter_intStackSize -= 2;
         class262.performPlayerAnimation(class155.localPlayer, Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize], Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
         return 1;
      } else if (var0 == 3103) {
         if (!Interpreter.field697) {
            Interpreter.field694 = true;
         }

         return 1;
      } else {
         int var10;
         if (var0 == 3104) {
            var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
            var10 = 0;
            if (class346.isNumber(var3)) {
               var10 = class412.method2151(var3);
            }

            PacketBufferNode var12 = class136.getPacketBufferNode(ClientPacket.field2461, Client.packetWriter.isaacCipher);
            var12.packetBuffer.writeInt(var10);
            Client.packetWriter.addNode(var12);
            return 1;
         } else {
            PacketBufferNode var15;
            if (var0 == 3105) {
               var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var15 = class136.getPacketBufferNode(ClientPacket.field2476, Client.packetWriter.isaacCipher);
               var15.packetBuffer.writeByte(var3.length() + 1);
               var15.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.addNode(var15);
               return 1;
            } else if (var0 == 3106) {
               var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
               var15 = class136.getPacketBufferNode(ClientPacket.field2509, Client.packetWriter.isaacCipher);
               var15.packetBuffer.writeByte(var3.length() + 1);
               var15.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.addNode(var15);
               return 1;
            } else {
               int var8;
               String var14;
               if (var0 == 3107) {
                  var8 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var14 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                  PcmPlayer.method229(var8, var14);
                  return 1;
               } else if (var0 == 3108) {
                  class87.Interpreter_intStackSize -= 3;
                  var8 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                  int var9 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
                  Widget var13 = ObjTypeCustomisation.getWidget(var9);
                  class18.clickWidget(var13, var8, var10);
                  return 1;
               } else if (var0 == 3109) {
                  class87.Interpreter_intStackSize -= 2;
                  var8 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                  Widget var11 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
                  class18.clickWidget(var11, var8, var10);
                  return 1;
               } else if (var0 == 3110) {
                  SceneTilePaint.mouseCam = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3111) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = StructComposition.clientPreferences.getRoofsHidden() ? 1 : 0;
                  return 1;
               } else if (var0 == 3112) {
                  StructComposition.clientPreferences.setRoofsHidden(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3113) {
                  var3 = Interpreter.Interpreter_stringStack[--Interpreter.Interpreter_stringStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                  ModeWhere.openURL(var3, var4, false);
                  return 1;
               } else if (var0 == 3115) {
                  var8 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var15 = class136.getPacketBufferNode(ClientPacket.field2518, Client.packetWriter.isaacCipher);
                  var15.packetBuffer.writeShort(var8);
                  Client.packetWriter.addNode(var15);
                  return 1;
               } else if (var0 == 3116) {
                  var8 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  Interpreter.Interpreter_stringStackSize -= 2;
                  var14 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize];
                  String var5 = Interpreter.Interpreter_stringStack[Interpreter.Interpreter_stringStackSize + 1];
                  if (var14.length() > 500) {
                     return 1;
                  } else if (var5.length() > 500) {
                     return 1;
                  } else {
                     PacketBufferNode var6 = class136.getPacketBufferNode(ClientPacket.field2499, Client.packetWriter.isaacCipher);
                     var6.packetBuffer.writeShort(1 + class13.stringCp1252NullTerminatedByteSize(var14) + class13.stringCp1252NullTerminatedByteSize(var5));
                     var6.packetBuffer.writeByteS(var8);
                     var6.packetBuffer.writeStringCp1252NullTerminated(var5);
                     var6.packetBuffer.writeStringCp1252NullTerminated(var14);
                     Client.packetWriter.addNode(var6);
                     return 1;
                  }
               } else if (var0 == 3117) {
                  Client.shiftClickDrop = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3118) {
                  Client.showMouseOverText = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3119) {
                  Client.renderSelf = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3120) {
                  if (Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 1;
                  } else {
                     Client.drawPlayerNames &= -2;
                  }

                  return 1;
               } else if (var0 == 3121) {
                  if (Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 2;
                  } else {
                     Client.drawPlayerNames &= -3;
                  }

                  return 1;
               } else if (var0 == 3122) {
                  if (Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 4;
                  } else {
                     Client.drawPlayerNames &= -5;
                  }

                  return 1;
               } else if (var0 == 3123) {
                  if (Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1) {
                     Client.drawPlayerNames |= 8;
                  } else {
                     Client.drawPlayerNames &= -9;
                  }

                  return 1;
               } else if (var0 == 3124) {
                  Client.drawPlayerNames = 0;
                  return 1;
               } else if (var0 == 3125) {
                  Client.showMouseCross = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3126) {
                  Client.showLoadingMessages = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3127) {
                  class358.setTapToDrop(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3128) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = TextureProvider.getTapToDrop() ? 1 : 0;
                  return 1;
               } else if (var0 == 3129) {
                  class87.Interpreter_intStackSize -= 2;
                  Client.oculusOrbNormalSpeed = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                  Client.oculusOrbSlowedSpeed = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
                  return 1;
               } else if (var0 == 3130) {
                  class87.Interpreter_intStackSize -= 2;
                  return 1;
               } else if (var0 == 3131) {
                  --class87.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3132) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = CollisionMap.canvasWidth;
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Language.canvasHeight;
                  return 1;
               } else if (var0 == 3133) {
                  --class87.Interpreter_intStackSize;
                  return 1;
               } else if (var0 == 3134) {
                  return 1;
               } else if (var0 == 3135) {
                  class87.Interpreter_intStackSize -= 2;
                  return 1;
               } else if (var0 == 3136) {
                  Client.field636 = 3;
                  Client.field528 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3137) {
                  Client.field636 = 2;
                  Client.field528 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3138) {
                  Client.field636 = 0;
                  return 1;
               } else if (var0 == 3139) {
                  Client.field636 = 1;
                  return 1;
               } else if (var0 == 3140) {
                  Client.field636 = 3;
                  Client.field528 = var2 ? class190.scriptDotWidget.id * 1023837327 * -353756561 : class360.scriptActiveWidget.id * 1023837327 * -353756561;
                  return 1;
               } else {
                  boolean var16;
                  if (var0 == 3141) {
                     var16 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     StructComposition.clientPreferences.setHideUsername(var16);
                     return 1;
                  } else if (var0 == 3142) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = StructComposition.clientPreferences.getHideUsername() ? 1 : 0;
                     return 1;
                  } else if (var0 == 3143) {
                     var16 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     Client.Login_isUsernameRemembered = var16;
                     if (!var16) {
                        StructComposition.clientPreferences.setRememberedUsername("");
                     }

                     return 1;
                  } else if (var0 == 3144) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
                     return 1;
                  } else if (var0 == 3145) {
                     return 1;
                  } else if (var0 == 3146) {
                     var16 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                     StructComposition.clientPreferences.getTitleMusicDisabled(!var16);
                     return 1;
                  } else if (var0 == 3147) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = StructComposition.clientPreferences.getTitleMusicDisabled() ? 0 : 1;
                     return 1;
                  } else if (var0 == 3148) {
                     return 1;
                  } else if (var0 == 3149) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3150) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3151) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3152) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3153) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Login.Login_loadingPercent;
                     return 1;
                  } else if (var0 == 3154) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = GraphicsObject.method420();
                     return 1;
                  } else if (var0 == 3155) {
                     --Interpreter.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3156) {
                     return 1;
                  } else if (var0 == 3157) {
                     class87.Interpreter_intStackSize -= 2;
                     return 1;
                  } else if (var0 == 3158) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3159) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3160) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3161) {
                     --class87.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3162) {
                     --class87.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3163) {
                     --Interpreter.Interpreter_stringStackSize;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3164) {
                     --class87.Interpreter_intStackSize;
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     return 1;
                  } else if (var0 == 3165) {
                     --class87.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3166) {
                     class87.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3167) {
                     class87.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3168) {
                     class87.Interpreter_intStackSize -= 2;
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                     return 1;
                  } else if (var0 == 3169) {
                     return 1;
                  } else if (var0 == 3170) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3171) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3172) {
                     --class87.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 3173) {
                     --class87.Interpreter_intStackSize;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3174) {
                     --class87.Interpreter_intStackSize;
                     return 1;
                  } else if (var0 == 3175) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3176) {
                     return 1;
                  } else if (var0 == 3177) {
                     return 1;
                  } else if (var0 == 3178) {
                     --Interpreter.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3179) {
                     return 1;
                  } else if (var0 == 3180) {
                     --Interpreter.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3181) {
                     class14.method49(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                     return 1;
                  } else if (var0 == 3182) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = class273.method1517();
                     return 1;
                  } else if (var0 == 3189) {
                     var8 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                     SequenceDefinition var7 = AABB.SequenceDefinition_get(var8);
                     if (var7.isCachedModelIdSet()) {
                        Login.method434(var7.SequenceDefinition_cachedModelId);
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("lr")
   @ObfuscatedSignature(
      descriptor = "(Lkd;I)V",
      garbageValue = "-458709619"
   )
   static final void method2152(Widget var0) {
      int var1 = var0.contentType;
      if (var1 == 324) {
         if (Client.field637 == -1) {
            Client.field637 = var0.spriteId2;
            Client.field638 = var0.spriteId;
         }

         if (Client.playerAppearance.field2818 == 1) {
            var0.spriteId2 = Client.field637;
         } else {
            var0.spriteId2 = Client.field638;
         }

      } else if (var1 == 325) {
         if (Client.field637 == -1) {
            Client.field637 = var0.spriteId2;
            Client.field638 = var0.spriteId;
         }

         if (Client.playerAppearance.field2818 == 1) {
            var0.spriteId2 = Client.field638;
         } else {
            var0.spriteId2 = Client.field637;
         }

      } else if (var1 == 327) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if (var1 == 328) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
