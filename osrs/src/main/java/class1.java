import java.util.concurrent.Callable;

import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
public class class1 implements Callable {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Ldm;"
   )
   static UrlRequest World_request;
   @ObfuscatedName("a")
   static int field2;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lqy;"
   )
   final Buffer field3;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lx;"
   )
   final class3 field1;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lr;"
   )
   @ObfuscatedName("this$0")
   final class7 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lr;Lqy;Lx;)V"
   )
   class1(class7 var1, Buffer var2, class3 var3) {
      this.this$0 = var1;
      this.field3 = var2;
      this.field1 = var3;
   }

   @ObfuscatedName("call")
   public Object call() {
      return this.field1.vmethod12(this.field3);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-2058763970"
   )
   static final void method3(String var0) {
      StringBuilder var10000 = (new StringBuilder()).append(var0);
      Object var10001 = null;
      String var1 = var10000.append(" is already on your friend list").toString();
      KitDefinition.addGameMessage(30, "", var1);
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      descriptor = "(IIII)V",
      garbageValue = "1539382446"
   )
   static void queueSoundEffect(int var0, int var1, int var2) {
      if (StructComposition.clientPreferences.getCurrentSoundEffectsVolume() != 0 && var1 != 0 && Client.soundEffectCount < 50) {
         Client.soundEffectIds[Client.soundEffectCount] = var0;
         Client.queuedSoundEffectLoops[Client.soundEffectCount] = var1;
         Client.queuedSoundEffectDelays[Client.soundEffectCount] = var2;
         Client.soundEffects[Client.soundEffectCount] = null;
         Client.soundLocations[Client.soundEffectCount] = 0;
         ++Client.soundEffectCount;
      }

   }

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      descriptor = "(Lqx;B)V",
      garbageValue = "0"
   )
   static final void method2(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.field409; ++var1) {
         int var2 = Client.field410[var1];
         NPC var3 = Client.npcs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         if ((var4 & 1) != 0) {
            var5 = var0.readUnsignedByte();
            var4 += var5 << 8;
         }

         if ((var4 & 2048) != 0) {
            var5 = var0.readUnsignedByte();
            var4 += var5 << 16;
         }

         if ((var4 & 131072) != 0) {
            var5 = var0.readIntLE();
            var3.turnLeftSequence = (var5 & 1) != 0 ? var0.readUnsignedShortLEA() : var3.definition.turnLeftSequence * 274326889 * 2133129945;
            var3.turnRightSequence = (var5 & 2) != 0 ? var0.readUnsignedShort() : var3.definition.turnRightSequence * -634834111 * -398107455;
            var3.walkSequence = (var5 & 4) != 0 ? var0.readUnsignedShort() : var3.definition.walkSequence * 1055098755 * 1587887915;
            var3.walkBackSequence = (var5 & 8) != 0 ? var0.readUnsignedShort() : var3.definition.walkBackSequence * 1430199505 * -501040079;
            var3.walkLeftSequence = (var5 & 16) != 0 ? var0.readUnsignedShort() : var3.definition.walkLeftSequence * 1601988001 * 141606497;
            var3.walkRightSequence = (var5 & 32) != 0 ? var0.readUnsignedShortLE() : var3.definition.walkRightSequence * 1871825673 * 253702969;
            var3.runSequence = (var5 & 64) != 0 ? var0.readUnsignedShortA() : var3.definition.runSequence * 154044717 * -2080788827;
            var3.runBackSequence = (var5 & 128) != 0 ? var0.readUnsignedShortLE() : var3.definition.runBackSequence * 1788894577 * 752796561;
            var3.runLeftSequence = (var5 & 256) != 0 ? var0.readUnsignedShortLE() : var3.definition.runLeftSequence * 1054411661 * 1998925637;
            var3.runRightSequence = (var5 & 512) != 0 ? var0.readUnsignedShortLEA() : var3.definition.runRightSequence * -500654361 * 875795671;
            var3.crawlSequence = (var5 & 1024) != 0 ? var0.readUnsignedShortA() : var3.definition.crawlSequence * 903143861 * -1829256035;
            var3.crawlBackSequence = (var5 & 2048) != 0 ? var0.readUnsignedShortLE() : var3.definition.crawlBackSequence * -630313423 * 1152150225;
            var3.crawlLeftSequence = (var5 & 4096) != 0 ? var0.readUnsignedShortLE() : var3.definition.crawlLeftSequence * -1129939695 * -63171599;
            var3.crawlRightSequence = (var5 & 8192) != 0 ? var0.readUnsignedShortA() : var3.definition.crawlRightSequence * -2023873033 * -1710216249;
            var3.idleSequence = (var5 & 16384) != 0 ? var0.readUnsignedShortLE() : var3.definition.idleSequence * -499537861 * -171249421;
         }

         if ((var4 & 4) != 0) {
            var3.definition = class129.getNpcDefinition(var0.readUnsignedShortLE());
            GameObject.method1299(var3);
            var3.method581();
         }

         if ((var4 & 1024) != 0) {
            var3.recolourStartCycle = Client.cycle + var0.readUnsignedShortLEA();
            var3.recolourEndCycle = Client.cycle + var0.readUnsignedShortLEA();
            var3.recolourHue = var0.readByteC();
            var3.recolourSaturation = var0.readByte();
            var3.recolourLuminance = var0.readByteC();
            var3.recolourAmount = (byte)var0.readUnsignedByteA();
         }

         int[] var6;
         int var7;
         int var8;
         int var9;
         int var10;
         short[] var13;
         short[] var14;
         long var15;
         if ((var4 & 512) != 0) {
            var5 = var0.readUnsignedByteA();
            if ((var5 & 1) == 1) {
               var3.method587();
            } else {
               var6 = null;
               if ((var5 & 2) == 2) {
                  var7 = var0.readUnsignedByteS();
                  var6 = new int[var7];

                  for(var8 = 0; var8 < var7; ++var8) {
                     var9 = var0.readUnsignedShortLE();
                     var9 = var9 == 65535 ? -1 : var9;
                     var6[var8] = var9;
                  }
               }

               var13 = null;
               if ((var5 & 4) == 4) {
                  var8 = 0;
                  if (var3.definition.recolorTo != null) {
                     var8 = var3.definition.recolorTo.length;
                  }

                  var13 = new short[var8];

                  for(var9 = 0; var9 < var8; ++var9) {
                     var13[var9] = (short)var0.readUnsignedShortLEA();
                  }
               }

               var14 = null;
               if ((var5 & 8) == 8) {
                  var9 = 0;
                  if (var3.definition.retextureTo != null) {
                     var9 = var3.definition.retextureTo.length;
                  }

                  var14 = new short[var9];

                  for(var10 = 0; var10 < var9; ++var10) {
                     var14[var10] = (short)var0.readUnsignedShortLE();
                  }
               }

               var15 = (long)(++NPC.field1051 - 1);
               var3.method584(new NewShit(var15, var6, var13, var14));
            }
         }

         if ((var4 & 8192) != 0) {
            var3.combatLevelChange = var0.method2373();
         }

         int var17;
         if ((var4 & 32) != 0) {
            var5 = var0.readUnsignedShortA();
            if (var5 == 65535) {
               var5 = -1;
            }

            var17 = var0.readUnsignedByte();
            if (var5 == var3.sequence && var5 != -1) {
               var7 = AABB.SequenceDefinition_get(var5).replyMode;
               if (var7 == 1) {
                  var3.sequenceFrame = 0;
                  var3.sequenceFrameCycle = 0;
                  var3.sequenceDelay = var17;
                  var3.currentSequenceFrameIndex = 0;
               }

               if (var7 == 2) {
                  var3.currentSequenceFrameIndex = 0;
               }
            } else if (var5 == -1 || var3.sequence == -1 || AABB.SequenceDefinition_get(var5).forcedPriority >= AABB.SequenceDefinition_get(var3.sequence).forcedPriority) {
               var3.sequence = var5;
               var3.sequenceFrame = 0;
               var3.sequenceFrameCycle = 0;
               var3.sequenceDelay = var17;
               var3.currentSequenceFrameIndex = 0;
               var3.field1004 = var3.pathLength;
            }
         }

         if ((var4 & 16) != 0) {
            var5 = var0.readUnsignedByteC();
            int var11;
            if (var5 > 0) {
               for(var17 = 0; var17 < var5; ++var17) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = var0.readUShortSmart();
                  if (var7 == 32767) {
                     var7 = var0.readUShortSmart();
                     var9 = var0.readUShortSmart();
                     var8 = var0.readUShortSmart();
                     var10 = var0.readUShortSmart();
                  } else if (var7 != 32766) {
                     var9 = var0.readUShortSmart();
                  } else {
                     var7 = -1;
                  }

                  var11 = var0.readUShortSmart();
                  var3.addHitSplat(var7, var9, var8, var10, Client.cycle, var11);
               }
            }

            var17 = var0.readUnsignedByte();
            if (var17 > 0) {
               for(var7 = 0; var7 < var17; ++var7) {
                  var8 = var0.readUShortSmart();
                  var9 = var0.readUShortSmart();
                  if (var9 != 32767) {
                     var10 = var0.readUShortSmart();
                     var11 = var0.readUnsignedByteC();
                     int var12 = var9 > 0 ? var0.readUnsignedByteA() : var11;
                     var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
                  } else {
                     var3.removeHealthBar(var8);
                  }
               }
            }
         }

         if ((var4 & 128) != 0) {
            var3.overheadText = var0.readStringCp1252NullTerminated();
            var3.overheadTextCyclesRemaining = 100;
         }

         if ((var4 & 4096) != 0) {
            var3.method574(var0.readUnsignedByte());
         }

         if ((var4 & 256) != 0) {
            var3.method590(var0.readStringCp1252NullTerminated());
         }

         if ((var4 & 8) != 0) {
            var5 = var0.readUnsignedShort();
            var17 = var0.readUnsignedShort();
            var3.instantTurn = var0.readUnsignedByte() == 1;
            var7 = var3.x - (var5 - class154.baseX - class154.baseX) * 64;
            var8 = var3.y - (var17 - class365.baseY - class365.baseY) * 64;
            if (var7 != 0 || var8 != 0) {
               var3.movingOrientation = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if ((var4 & '耀') != 0) {
            var3.exactMoveDeltaX1 = var0.readByteC();
            var3.exactMoveDeltaY1 = var0.readByte();
            var3.exactMoveDeltaX2 = var0.readByteC();
            var3.exactMoveDeltaY2 = var0.readByteS();
            var3.exactMoveArrive1Cycle = var0.readUnsignedShort() + Client.cycle;
            var3.exactMoveArrive2Cycle = var0.readUnsignedShortLE() + Client.cycle;
            var3.exactMoveDirection = var0.readUnsignedShort();
            var3.pathLength = 1;
            var3.field1004 = 0;
            var3.exactMoveDeltaX1 += var3.pathX[0];
            var3.exactMoveDeltaY1 += var3.pathY[0];
            var3.exactMoveDeltaX2 += var3.pathX[0];
            var3.exactMoveDeltaY2 += var3.pathY[0];
         }

         if ((var4 & 16384) != 0) {
            var5 = var0.readUnsignedByteS();
            if ((var5 & 1) == 1) {
               var3.method586();
            } else {
               var6 = null;
               if ((var5 & 2) == 2) {
                  var7 = var0.readUnsignedByte();
                  var6 = new int[var7];

                  for(var8 = 0; var8 < var7; ++var8) {
                     var9 = var0.readUnsignedShortA();
                     var9 = var9 == 65535 ? -1 : var9;
                     var6[var8] = var9;
                  }
               }

               var13 = null;
               if ((var5 & 4) == 4) {
                  var8 = 0;
                  if (var3.definition.recolorTo != null) {
                     var8 = var3.definition.recolorTo.length;
                  }

                  var13 = new short[var8];

                  for(var9 = 0; var9 < var8; ++var9) {
                     var13[var9] = (short)var0.readUnsignedShortLE();
                  }
               }

               var14 = null;
               if ((var5 & 8) == 8) {
                  var9 = 0;
                  if (var3.definition.retextureTo != null) {
                     var9 = var3.definition.retextureTo.length;
                  }

                  var14 = new short[var9];

                  for(var10 = 0; var10 < var9; ++var10) {
                     var14[var10] = (short)var0.readUnsignedShortA();
                  }
               }

               var15 = (long)(++NPC.field1053 - 1);
               var3.method582(new NewShit(var15, var6, var13, var14));
            }
         }

         if ((var4 & 64) != 0) {
            var3.targetIndex = var0.readUnsignedShort();
            if (ParamComposition.field1638) {
               var3.targetIndex += var0.readUnsignedByteS() << 16;
               var5 = 16777215;
            } else {
               var5 = 65535;
            }

            if (var5 == var3.targetIndex) {
               var3.targetIndex = -1;
            }
         }

         if ((var4 & 2) != 0) {
            var3.spotAnimation = var0.readUnsignedShort();
            var5 = var0.method2373();
            var3.spotAnimHeight = var5 >> 16;
            var3.spotAnimationStartCycle = (var5 & '\uffff') + Client.cycle;
            var3.spotAnimationFrame = 0;
            var3.spotAnimFrameCycle = 0;
            if (var3.spotAnimationStartCycle > Client.cycle) {
               var3.spotAnimationFrame = -1;
            }

            if (var3.spotAnimation == 65535) {
               var3.spotAnimation = -1;
            }
         }

         if ((var4 & 65536) != 0) {
            var5 = var0.readUnsignedByteS();
            var6 = new int[8];
            var13 = new short[8];

            for(var8 = 0; var8 < 8; ++var8) {
               if ((var5 & 1 << var8) != 0) {
                  var6[var8] = var0.method2362();
                  var13[var8] = (short)var0.method2407();
               } else {
                  var6[var8] = -1;
                  var13[var8] = -1;
               }
            }

            var3.method580(var6, var13);
         }
      }

   }
}
