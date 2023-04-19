import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("no")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
    @ObfuscatedName("fc")
    @ObfuscatedSignature(
            descriptor = "Lnd;"
    )
    static Archive archive10;
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lnd;"
    )
    Archive archive;
    @ObfuscatedName("an")
    int crc;
    @ObfuscatedName("aw")
    byte padding;

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "-19"
   )
   static int method1877(int var0, Script var1, boolean var2) {
      String var3;
      if (var0 == 3100) {
         var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
         UserComparator5.addGameMessage(0, "", var3);
         return 1;
      } else if (var0 == 3101) {
         Interpreter.Interpreter_intStackSize -= 2;
         FloorDecoration.performPlayerAnimation(MusicPatchNode.localPlayer, Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize], Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         return 1;
      } else if (var0 == 3103) {
         if (!Interpreter.field704) {
            Interpreter.field700 = true;
         }

         return 1;
      } else {
         int var10;
         if (var0 == 3104) {
            var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
            var10 = 0;
            if (WorldMapSectionType.isNumber(var3)) {
               var10 = PacketBufferNode.method1602(var3);
            }

            PacketBufferNode var12 = class330.getPacketBufferNode(ClientPacket.asfasgag, Client.packetWriter.isaacCipher);
            var12.packetBuffer.writeInt(var10);
            Client.packetWriter.addNode(var12);
            return 1;
         } else {
            PacketBufferNode var14;
            if (var0 == 3105) {
               var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
               var14 = class330.getPacketBufferNode(ClientPacket.field2529, Client.packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(var3.length() + 1);
               var14.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.addNode(var14);
               return 1;
            } else if (var0 == 3106) {
               var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
               var14 = class330.getPacketBufferNode(ClientPacket.field2518, Client.packetWriter.isaacCipher);
               var14.packetBuffer.writeByte(var3.length() + 1);
               var14.packetBuffer.writeStringCp1252NullTerminated(var3);
               Client.packetWriter.addNode(var14);
               return 1;
            } else {
               String var7;
               int var8;
               if (var0 == 3107) {
                  var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var7 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                  UserComparator7.method692(var8, var7);
                  return 1;
               } else if (var0 == 3108) {
                  Interpreter.Interpreter_intStackSize -= 3;
                  var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                  int var9 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
                  Widget var13 = class165.getWidget(var9);
                  class370.clickWidget(var13, var8, var10);
                  return 1;
               } else if (var0 == 3109) {
                  Interpreter.Interpreter_intStackSize -= 2;
                  var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                  var10 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                  Widget var11 = var2 ? SoundSystem.scriptDotWidget : class1.scriptActiveWidget;
                  class370.clickWidget(var11, var8, var10);
                  return 1;
               } else if (var0 == 3110) {
                  class473.mouseCam = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  return 1;
               } else if (var0 == 3111) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class20.clientPreferences.getRoofsHidden() ? 1 : 0;
                  return 1;
               } else if (var0 == 3112) {
                  class20.clientPreferences.setRoofsHidden(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3113) {
                  var3 = Interpreter.Interpreter_stringStack[--SecureRandomCallable.Interpreter_stringStackSize];
                  boolean var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                  Ignored.openURL(var3, var4, false);
                  return 1;
               } else if (var0 == 3115) {
                  var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var14 = class330.getPacketBufferNode(ClientPacket.field2525, Client.packetWriter.isaacCipher);
                  var14.packetBuffer.writeShort(var8);
                  Client.packetWriter.addNode(var14);
                  return 1;
               } else if (var0 == 3116) {
                  var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  SecureRandomCallable.Interpreter_stringStackSize -= 2;
                  var7 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize];
                  String var5 = Interpreter.Interpreter_stringStack[SecureRandomCallable.Interpreter_stringStackSize + 1];
                  if (var7.length() > 500) {
                     return 1;
                  } else if (var5.length() > 500) {
                     return 1;
                  } else {
                     PacketBufferNode var6 = class330.getPacketBufferNode(ClientPacket.nkasjndakjsn, Client.packetWriter.isaacCipher);
                     var6.packetBuffer.writeShort(1 + DynamicObject.stringCp1252NullTerminatedByteSize(var7) + DynamicObject.stringCp1252NullTerminatedByteSize(var5));
                     var6.packetBuffer.writeStringCp1252NullTerminated(var7);
                     var6.packetBuffer.writeByteSub(var8);
                     var6.packetBuffer.writeStringCp1252NullTerminated(var5);
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
                  Client.field482 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
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
                  class120.setTapToDrop(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1);
                  return 1;
               } else if (var0 == 3128) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class13.getTapToDrop() ? 1 : 0;
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
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class262.canvasHeight;
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
                  Client.field463 = 3;
                  Client.field526 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3137) {
                  Client.field463 = 2;
                  Client.field526 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  return 1;
               } else if (var0 == 3138) {
                  Client.field463 = 0;
                  return 1;
               } else if (var0 == 3139) {
                  Client.field463 = 1;
                  return 1;
               } else if (var0 == 3140) {
                  Client.field463 = 3;
                  Client.field526 = var2 ? SoundSystem.scriptDotWidget.id * 1713081171 * 346484955 : class1.scriptActiveWidget.id * 1713081171 * 346484955;
                  return 1;
               } else {
                  boolean var15;
                  if (var0 == 3141) {
                     var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     class20.clientPreferences.setIsUsernameHidden(var15);
                     return 1;
                  } else if (var0 == 3142) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class20.clientPreferences.getIsUsernameHidden() ? 1 : 0;
                     return 1;
                  } else if (var0 == 3143) {
                     var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     Client.Login_isUsernameRemembered = var15;
                     if (!var15) {
                        class20.clientPreferences.setUsernameToRemember("");
                     }

                     return 1;
                  } else if (var0 == 3144) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.Login_isUsernameRemembered ? 1 : 0;
                     return 1;
                  } else if (var0 == 3145) {
                     return 1;
                  } else if (var0 == 3146) {
                     var15 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                     class20.clientPreferences.getTitleMusicDisabled(!var15);
                     return 1;
                  } else if (var0 == 3147) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class20.clientPreferences.getTitleMusicDisabled() ? 0 : 1;
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
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = MouseHandler.method191();
                     return 1;
                  } else if (var0 == 3155) {
                     --SecureRandomCallable.Interpreter_stringStackSize;
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
                     --SecureRandomCallable.Interpreter_stringStackSize;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     return 1;
                  } else if (var0 == 3164) {
                     --Interpreter.Interpreter_intStackSize;
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
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
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
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
                     --SecureRandomCallable.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3179) {
                     return 1;
                  } else if (var0 == 3180) {
                     --SecureRandomCallable.Interpreter_stringStackSize;
                     return 1;
                  } else if (var0 == 3181) {
                     ApproximateRouteStrategy.method359(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                     return 1;
                  } else if (var0 == 3182) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class103.method636();
                     return 1;
                  } else if (var0 == 3189) {
                     var8 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     DevicePcmPlayerProvider.method90(var8);
                     return 1;
                  } else {
                     return 2;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZS)I",
      garbageValue = "-23771"
   )
   static int method1878(int var0, Script var1, boolean var2) {
      if (var0 == 6809) {
         int var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         ObjectComposition var4 = class144.getObjectDefinition(var3);
         Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("ik")
   @ObfuscatedSignature(
      descriptor = "(Lde;B)V",
      garbageValue = "-25"
   )
   static final void method1876(Actor var0) {
      var0.isWalking = false;
      if (var0.movementSequence != -1) {
         SequenceDefinition var1 = ItemContainer.SequenceDefinition_get(var0.movementSequence);
         if (var1 != null) {
            if (!var1.isCachedModelIdSet() && var1.frameIds != null) {
               ++var0.movementFrameCycle;
               if (var0.movementFrame < var1.frameIds.length && var0.movementFrameCycle > var1.frameLengths[var0.movementFrame]) {
                  var0.movementFrameCycle = 1;
                  ++var0.movementFrame;
                  ZoneOperation.method1599(var1, var0.movementFrame, var0.x, var0.y);
               }

               if (var0.movementFrame >= var1.frameIds.length) {
                  if (var1.frameCount > 0) {
                     var0.movementFrame -= var1.frameCount;
                     if (var1.field1823) {
                        ++var0.field975;
                     }

                     if (var0.movementFrame < 0 || var0.movementFrame >= var1.frameIds.length || var1.field1823 && var0.field975 >= var1.iterations) {
                        var0.movementFrameCycle = 0;
                        var0.movementFrame = 0;
                        var0.field975 = 0;
                     }
                  } else {
                     var0.movementFrameCycle = 0;
                     var0.movementFrame = 0;
                  }

                  ZoneOperation.method1599(var1, var0.movementFrame, var0.x, var0.y);
               }
            } else if (var1.isCachedModelIdSet()) {
               ++var0.movementFrame;
               int var2 = var1.method1128();
               if (var0.movementFrame < var2) {
                  KeyHandler.method108(var1, var0.movementFrame, var0.x, var0.y);
               } else {
                  if (var1.frameCount > 0) {
                     var0.movementFrame -= var1.frameCount;
                     if (var1.field1823) {
                        ++var0.field975;
                     }

                     if (var0.movementFrame < 0 || var0.movementFrame >= var2 || var1.field1823 && var0.field975 >= var1.iterations) {
                        var0.movementFrame = 0;
                        var0.movementFrameCycle = 0;
                        var0.field975 = 0;
                     }
                  } else {
                     var0.movementFrameCycle = 0;
                     var0.movementFrame = 0;
                  }

                  KeyHandler.method108(var1, var0.movementFrame, var0.x, var0.y);
               }
            } else {
               var0.movementSequence = -1;
            }
         } else {
            var0.movementSequence = -1;
         }
      }

      IterableNodeHashTableIterator var7 = new IterableNodeHashTableIterator(var0.method532());

      int var3;
      for(SpotAnimation var6 = (SpotAnimation)var7.method2390(); var6 != null; var6 = (SpotAnimation)var7.next()) {
         if (var6.id != -1 && Client.cycle >= var6.frame) {
            var3 = ItemContainer.SpotAnimationDefinition_get(var6.id).sequence;
            if (var3 == -1) {
               var6.remove();
               --var0.graphicsCount;
            } else {
               var6.field4169 = Math.max(var6.field4169, 0);
               SequenceDefinition var4 = ItemContainer.SequenceDefinition_get(var3);
               if (var4.frameIds != null && !var4.isCachedModelIdSet()) {
                  ++var6.field4168;
                  if (var6.field4169 < var4.frameIds.length && var6.field4168 > var4.frameLengths[var6.field4169]) {
                     var6.field4168 = 1;
                     ++var6.field4169;
                     ZoneOperation.method1599(var4, var6.field4169, var0.x, var0.y);
                  }

                  if (var6.field4169 >= var4.frameIds.length) {
                     var6.remove();
                     --var0.graphicsCount;
                  }
               } else if (var4.isCachedModelIdSet()) {
                  ++var6.field4169;
                  int var5 = var4.method1128();
                  if (var6.field4169 < var5) {
                     KeyHandler.method108(var4, var6.field4169, var0.x, var0.y);
                  } else {
                     var6.remove();
                     --var0.graphicsCount;
                  }
               } else {
                  var6.remove();
                  --var0.graphicsCount;
               }
            }
         }
      }

      SequenceDefinition var8;
      if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
         var8 = ItemContainer.SequenceDefinition_get(var0.sequence);
         if (var8.precedenceAnimating == 1 && var0.field1006 > 0 && var0.spotAnimation <= Client.cycle && var0.exactMoveArrive1Cycle < Client.cycle) {
            var0.sequenceDelay = 1;
            return;
         }
      }

      if (var0.sequence != -1 && var0.sequenceDelay == 0) {
         var8 = ItemContainer.SequenceDefinition_get(var0.sequence);
         if (var8 != null) {
            if (!var8.isCachedModelIdSet() && var8.frameIds != null) {
               ++var0.sequenceFrameCycle;
               if (var0.sequenceFrame < var8.frameIds.length && var0.sequenceFrameCycle > var8.frameLengths[var0.sequenceFrame]) {
                  var0.sequenceFrameCycle = 1;
                  ++var0.sequenceFrame;
                  ZoneOperation.method1599(var8, var0.sequenceFrame, var0.x, var0.y);
               }

               if (var0.sequenceFrame >= var8.frameIds.length) {
                  var0.sequenceFrame -= var8.frameCount;
                  ++var0.currentSequenceFrameIndex;
                  if (var0.currentSequenceFrameIndex >= var8.iterations) {
                     var0.sequence = -1;
                  } else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var8.frameIds.length) {
                     ZoneOperation.method1599(var8, var0.sequenceFrame, var0.x, var0.y);
                  } else {
                     var0.sequence = -1;
                  }
               }

               var0.isWalking = var8.stretches;
            } else if (var8.isCachedModelIdSet()) {
               ++var0.sequenceFrame;
               var3 = var8.method1128();
               if (var0.sequenceFrame < var3) {
                  KeyHandler.method108(var8, var0.sequenceFrame, var0.x, var0.y);
               } else {
                  var0.sequenceFrame -= var8.frameCount;
                  ++var0.currentSequenceFrameIndex;
                  if (var0.currentSequenceFrameIndex >= var8.iterations) {
                     var0.sequence = -1;
                  } else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var3) {
                     KeyHandler.method108(var8, var0.sequenceFrame, var0.x, var0.y);
                  } else {
                     var0.sequence = -1;
                  }
               }
            } else {
               var0.sequence = -1;
            }
         } else {
            var0.sequence = -1;
         }
      }

      if (var0.sequenceDelay > 0) {
         --var0.sequenceDelay;
      }

   }
}
