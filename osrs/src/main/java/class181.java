import java.util.concurrent.ThreadFactory;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gt")
final class class181 implements ThreadFactory {
   @ObfuscatedName("aq")
   @Export("SpriteBuffer_spritePalette")
   public static int[] SpriteBuffer_spritePalette;

   public Thread newThread(Runnable var1) {
      return new Thread(var1, "OSRS Maya Anim Load");
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)Ltg;",
      garbageValue = "2034130252"
   )
   public static PrivateChatMode method924(int var0) {
      PrivateChatMode[] var1 = new PrivateChatMode[]{PrivateChatMode.field4086, PrivateChatMode.field4083, PrivateChatMode.field4085};
      PrivateChatMode[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         PrivateChatMode var4 = var2[var3];
         if (var0 == var4.id) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lew;FZI)F",
      garbageValue = "-1190281991"
   )
   static float method922(class127 var0, float var1, boolean var2) {
      float var3 = 0.0F;
      if (var0 != null && var0.method703() != 0) {
         float var4 = (float)var0.field1203[0].field1165;
         float var5 = (float)var0.field1203[var0.method703() - 1].field1165;
         float var6 = var5 - var4;
         if (0.0D == (double)var6) {
            return var0.field1203[0].field1158;
         } else {
            float var7 = 0.0F;
            if (var1 > var5) {
               var7 = (var1 - var5) / var6;
            } else {
               var7 = (var1 - var4) / var6;
            }

            double var8 = (double)((int)var7);
            float var10 = Math.abs((float)((double)var7 - var8));
            float var11 = var10 * var6;
            var8 = Math.abs(var8 + 1.0D);
            double var12 = var8 / 2.0D;
            double var14 = (double)((int)var12);
            var10 = (float)(var12 - var14);
            float var16;
            float var17;
            if (var2) {
               if (var0.field1201 == class125.field1190) {
                  if ((double)var10 != 0.0D) {
                     var11 += var4;
                  } else {
                     var11 = var5 - var11;
                  }
               } else if (var0.field1201 != class125.field1189 && var0.field1201 != class125.field1188) {
                  if (var0.field1201 == class125.field1193) {
                     var11 = var4 - var1;
                     var16 = var0.field1203[0].field1159;
                     var17 = var0.field1203[0].field1160;
                     var3 = var0.field1203[0].field1158;
                     if ((double)var16 != 0.0D) {
                        var3 -= var11 * var17 / var16;
                     }

                     return var3;
                  }
               } else {
                  var11 = var5 - var11;
               }
            } else if (var0.field1214 == class125.field1190) {
               if (0.0D != (double)var10) {
                  var11 = var5 - var11;
               } else {
                  var11 += var4;
               }
            } else if (var0.field1214 != class125.field1189 && var0.field1214 != class125.field1188) {
               if (var0.field1214 == class125.field1193) {
                  var11 = var1 - var5;
                  var16 = var0.field1203[var0.method703() - 1].field1161;
                  var17 = var0.field1203[var0.method703() - 1].field1162;
                  var3 = var0.field1203[var0.method703() - 1].field1158;
                  if (0.0D != (double)var16) {
                     var3 += var11 * var17 / var16;
                  }

                  return var3;
               }
            } else {
               var11 += var4;
            }

            var3 = AttackOption.method590(var0, var11);
            float var18;
            if (var2 && var0.field1201 == class125.field1188) {
               var18 = var0.field1203[var0.method703() - 1].field1158 - var0.field1203[0].field1158;
               var3 = (float)((double)var3 - var8 * (double)var18);
            } else if (!var2 && var0.field1214 == class125.field1188) {
               var18 = var0.field1203[var0.method703() - 1].field1158 - var0.field1203[0].field1158;
               var3 = (float)((double)var3 + var8 * (double)var18);
            }

            return var3;
         }
      } else {
         return var3;
      }
   }

   @ObfuscatedName("jt")
   @ObfuscatedSignature(
      descriptor = "(Lsq;I)V",
      garbageValue = "-1830172640"
   )
   static final void method923(PacketBuffer var0) {
      for(int var1 = 0; var1 < Client.field413; ++var1) {
         int var2 = Client.field535[var1];
         NPC var3 = Client.npcs[var2];
         int var4 = var0.readUnsignedByte();
         int var5;
         if ((var4 & 8) != 0) {
            var5 = var0.readUnsignedByte();
            var4 += var5 << 8;
         }

         if ((var4 & 4096) != 0) {
            var5 = var0.readUnsignedByte();
            var4 += var5 << 16;
         }

         int var6;
         int var7;
         if ((var4 & 16) != 0) {
            var5 = var0.readUnsignedShortLEA();
            if (var5 == 65535) {
               var5 = -1;
            }

            var6 = var0.method2430();
            if (var5 == var3.sequence && var5 != -1) {
               var7 = Coord.SequenceDefinition_get(var5).replyMode;
               if (var7 == 1) {
                  var3.sequenceFrame = 0;
                  var3.sequenceFrameCycle = 0;
                  var3.sequenceDelay = var6;
                  var3.currentSequenceFrameIndex = 0;
               }

               if (var7 == 2) {
                  var3.currentSequenceFrameIndex = 0;
               }
            } else if (var5 == -1 || var3.sequence == -1 || Coord.SequenceDefinition_get(var5).forcedPriority >= Coord.SequenceDefinition_get(var3.sequence).forcedPriority) {
               var3.sequence = var5;
               var3.sequenceFrame = 0;
               var3.sequenceFrameCycle = 0;
               var3.sequenceDelay = var6;
               var3.currentSequenceFrameIndex = 0;
               var3.field1004 = var3.pathLength;
            }
         }

         int var8;
         int[] var13;
         short[] var14;
         if ((var4 & 131072) != 0) {
            var5 = var0.readUnsignedByte();
            var13 = new int[8];
            var14 = new short[8];

            for(var8 = 0; var8 < 8; ++var8) {
               if ((var5 & 1 << var8) != 0) {
                  var13[var8] = var0.method2423();
                  var14[var8] = (short)var0.method2415();
               } else {
                  var13[var8] = -1;
                  var14[var8] = -1;
               }
            }

            var3.method567(var13, var14);
         }

         if ((var4 & 8192) != 0) {
            var3.method572(var0.readUnsignedShortA());
         }

         if ((var4 & 4) != 0) {
            var3.targetIndex = var0.method2437();
            var3.targetIndex += var0.method2405() << 16;
            var5 = 16777215;
            if (var5 == var3.targetIndex) {
               var3.targetIndex = -1;
            }
         }

         if ((var4 & 65536) != 0) {
            var5 = var0.readUnsignedByteS();
            var3.turnLeftSequence = (var5 & 1) != 0 ? var0.readUnsignedShortLEA() : var3.definition.turnLeftSequence * 1406295179 * 441854755;
            var3.turnRightSequence = (var5 & 2) != 0 ? var0.readUnsignedShortLE() : var3.definition.turnRightSequence * 1189253961 * -397750535;
            var3.walkSequence = (var5 & 4) != 0 ? var0.method2437() : var3.definition.walkSequence * 1152348467 * -1377177093;
            var3.walkBackSequence = (var5 & 8) != 0 ? var0.readUnsignedShort() : var3.definition.walkBackSequence * 222425699 * -274981045;
            var3.walkLeftSequence = (var5 & 16) != 0 ? var0.readUnsignedShortLE() : var3.definition.walkLeftSequence * 617555963 * -530199757;
            var3.walkRightSequence = (var5 & 32) != 0 ? var0.readUnsignedShortLE() : var3.definition.walkRightSequence * -379647223 * 498463545;
            var3.runSequence = (var5 & 64) != 0 ? var0.method2437() : var3.definition.runSequence * -1285996051 * -945601563;
            var3.runBackSequence = (var5 & 128) != 0 ? var0.readUnsignedShortLEA() : var3.definition.runBackSequence * 325542601 * -586131591;
            var3.runLeftSequence = (var5 & 256) != 0 ? var0.method2437() : var3.definition.runLeftSequence * -1302350385 * -1601228497;
            var3.runRightSequence = (var5 & 512) != 0 ? var0.method2437() : var3.definition.runRightSequence * -1419952353 * 1903000799;
            var3.crawlSequence = (var5 & 1024) != 0 ? var0.method2437() : var3.definition.crawlSequence * -1974099217 * 1194052623;
            var3.crawlBackSequence = (var5 & 2048) != 0 ? var0.method2437() : var3.definition.crawlBackSequence * -1679540715 * -943021763;
            var3.crawlLeftSequence = (var5 & 4096) != 0 ? var0.readUnsignedShortLE() : var3.definition.crawlLeftSequence * -754382153 * -166464761;
            var3.crawlRightSequence = (var5 & 8192) != 0 ? var0.readUnsignedShortLEA() : var3.definition.crawlRightSequence * 1277541461 * 750870781;
            var3.idleSequence = (var5 & 16384) != 0 ? var0.readUnsignedShort() : var3.definition.idleSequence * -1822581491 * 1877440965;
         }

         if ((var4 & 32) != 0) {
            var3.spotAnimation = var0.readUnsignedShortLEA();
            var5 = var0.readInt();
            var3.spotAnimHeight = var5 >> 16;
            var3.spotAnimationStartCycle = (var5 & '\uffff') + Client.cycle;
            var3.spotAnimationFrame = 0;
            var3.field964 = 0;
            if (var3.spotAnimationStartCycle > Client.cycle) {
               var3.spotAnimationFrame = -1;
            }

            if (var3.spotAnimation == 65535) {
               var3.spotAnimation = -1;
            }
         }

         int var9;
         int var10;
         if ((var4 & 1) != 0) {
            var5 = var0.readUnsignedByte();
            int var11;
            if (var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
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

            var6 = var0.readUnsignedShortA();
            if (var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = var0.readUShortSmart();
                  var9 = var0.readUShortSmart();
                  if (var9 != 32767) {
                     var10 = var0.readUShortSmart();
                     var11 = var0.readUnsignedShortA();
                     int var12 = var9 > 0 ? var0.readUnsignedShortA() : var11;
                     var3.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
                  } else {
                     var3.removeHealthBar(var8);
                  }
               }
            }
         }

         if ((var4 & '耀') != 0) {
            var3.recolourStartCycle = Client.cycle + var0.readUnsignedShortLEA();
            var3.recolourEndCycle = Client.cycle + var0.readUnsignedShort();
            var3.recolourHue = var0.readByte();
            var3.recolourSaturation = var0.method2396();
            var3.recolourLuminance = var0.method2396();
            var3.recolourAmount = (byte)var0.readUnsignedByte();
         }

         if ((var4 & 512) != 0) {
            var3.combatLevelChange = var0.readInt();
         }

         short[] var15;
         long var16;
         if ((var4 & 2048) != 0) {
            var5 = var0.readUnsignedByte();
            if ((var5 & 1) == 1) {
               var3.method575();
            } else {
               var13 = null;
               if ((var5 & 2) == 2) {
                  var7 = var0.method2405();
                  var13 = new int[var7];

                  for(var8 = 0; var8 < var7; ++var8) {
                     var9 = var0.method2437();
                     var9 = var9 == 65535 ? -1 : var9;
                     var13[var8] = var9;
                  }
               }

               var14 = null;
               if ((var5 & 4) == 4) {
                  var8 = 0;
                  if (var3.definition.recolorTo != null) {
                     var8 = var3.definition.recolorTo.length;
                  }

                  var14 = new short[var8];

                  for(var9 = 0; var9 < var8; ++var9) {
                     var14[var9] = (short)var0.readUnsignedShort();
                  }
               }

               var15 = null;
               if ((var5 & 8) == 8) {
                  var9 = 0;
                  if (var3.definition.retextureTo != null) {
                     var9 = var3.definition.retextureTo.length;
                  }

                  var15 = new short[var9];

                  for(var10 = 0; var10 < var9; ++var10) {
                     var15[var10] = (short)var0.method2437();
                  }
               }

               var16 = (long)(++NPC.field1054 - 1);
               var3.method568(new NewShit(var16, var13, var14, var15));
            }
         }

         if ((var4 & 256) != 0) {
            var3.method580(var0.readStringCp1252NullTerminated());
         }

         if ((var4 & 2) != 0) {
            var3.overheadText = var0.readStringCp1252NullTerminated();
            var3.overheadTextCyclesRemaining = 100;
         }

         if ((var4 & 1024) != 0) {
            var3.exactMoveDeltaX1 = var0.method2433();
            var3.exactMoveDeltaY1 = var0.method2396();
            var3.exactMoveDeltaX2 = var0.readByte();
            var3.exactMoveDeltaY2 = var0.method2433();
            var3.exactMoveArrive1Cycle = var0.method2437() + Client.cycle;
            var3.exactMoveArrive2Cycle = var0.method2437() + Client.cycle;
            var3.exactMoveDirection = var0.method2437();
            var3.pathLength = 1;
            var3.field1004 = 0;
            var3.exactMoveDeltaX1 += var3.pathX[0];
            var3.exactMoveDeltaY1 += var3.pathY[0];
            var3.exactMoveDeltaX2 += var3.pathX[0];
            var3.exactMoveDeltaY2 += var3.pathY[0];
         }

         if ((var4 & 64) != 0) {
            var3.definition = class188.getNpcDefinition(var0.readUnsignedShort());
            class418.method2176(var3);
            var3.method573();
         }

         if ((var4 & 128) != 0) {
            var5 = var0.readUnsignedShortLE();
            var6 = var0.readUnsignedShortLE();
            var3.field946 = var0.readUnsignedByte() == 1;
            if (Client.param25 >= 212) {
               var3.field969 = var5;
               var3.field965 = var6;
            } else {
               var7 = var3.x - (var5 - GameEngine.baseX - GameEngine.baseX) * 64;
               var8 = var3.y - (var6 - class178.baseY - class178.baseY) * 64;
               if (var7 != 0 || var8 != 0) {
                  var3.movingOrientation = HitSplatDefinition.method1020(var7, var8);
               }
            }
         }

         if ((var4 & 16384) != 0) {
            var5 = var0.method2430();
            if ((var5 & 1) == 1) {
               var3.method578();
            } else {
               var13 = null;
               if ((var5 & 2) == 2) {
                  var7 = var0.method2405();
                  var13 = new int[var7];

                  for(var8 = 0; var8 < var7; ++var8) {
                     var9 = var0.readUnsignedShortLEA();
                     var9 = var9 == 65535 ? -1 : var9;
                     var13[var8] = var9;
                  }
               }

               var14 = null;
               if ((var5 & 4) == 4) {
                  var8 = 0;
                  if (var3.definition.recolorTo != null) {
                     var8 = var3.definition.recolorTo.length;
                  }

                  var14 = new short[var8];

                  for(var9 = 0; var9 < var8; ++var9) {
                     var14[var9] = (short)var0.readUnsignedShortLE();
                  }
               }

               var15 = null;
               if ((var5 & 8) == 8) {
                  var9 = 0;
                  if (var3.definition.retextureTo != null) {
                     var9 = var3.definition.retextureTo.length;
                  }

                  var15 = new short[var9];

                  for(var10 = 0; var10 < var9; ++var10) {
                     var15[var10] = (short)var0.readUnsignedShortLEA();
                  }
               }

               var16 = (long)(++NPC.field1052 - 1);
               var3.method570(new NewShit(var16, var13, var14, var15));
            }
         }
      }

   }
}
