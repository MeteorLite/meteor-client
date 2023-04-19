import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class146 extends class139 {
    @ObfuscatedName("bk")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    static AbstractArchive Widget_fontsArchive;
   @ObfuscatedName("af")
   boolean field1342;
   @ObfuscatedName("an")
   byte field1339;
   @ObfuscatedName("aw")
   byte field1340;
   @ObfuscatedName("ac")
   byte field1341;
   @ObfuscatedName("au")
   byte field1338;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfa;)V"
   )
   class146(class142 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "168736686"
    )
    void vmethod3254(Buffer var1) {
      this.field1342 = var1.readUnsignedByte() == 1;
      this.field1339 = var1.readByte();
      this.field1340 = var1.readByte();
      this.field1341 = var1.readByte();
      this.field1338 = var1.readByte();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfj;I)V",
            garbageValue = "1712319228"
    )
    void vmethod3248(ClanSettings var1) {
      var1.allowGuests = this.field1342;
      var1.field1369 = this.field1339;
      var1.field1359 = this.field1340;
      var1.field1360 = this.field1341;
      var1.field1351 = this.field1338;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(II)Lmd;",
      garbageValue = "1082139872"
   )
   public static GameBuild method832(int var0) {
      GameBuild[] var1 = new GameBuild[]{GameBuild.LIVE, GameBuild.BUILDLIVE, GameBuild.RC, GameBuild.WIP};
      GameBuild[] var2 = var1;

      for(int var3 = 0; var3 < var2.length; ++var3) {
         GameBuild var4 = var2[var3];
         if (var0 == var4.buildId) {
            return var4;
         }
      }

      return null;
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "615247476"
   )
   public static int method833(int var0) {
      return (var0 & class484.field4044) - 1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "520752062"
   )
   public static final void method829() {
      ViewportMouse.ViewportMouse_isInViewport = false;
      ViewportMouse.ViewportMouse_entityCount = 0;
   }

    @ObfuscatedName("kb")
    @ObfuscatedSignature(
            descriptor = "(ZLsq;I)V",
            garbageValue = "-1232221421"
    )
    static final void updateNpcs(boolean var0, PacketBuffer var1) {
      Client.field484 = 0;
      Client.field416 = 0;
      class30.method131(var1);
      ItemLayer.method1181(var0, var1);

      int var2;
      int var3;
      for(var2 = 0; var2 < Client.field416; ++var2) {
         var3 = Client.field417[var2];
         NPC var4 = Client.npcs[var3];
         int var5 = var1.readUnsignedByte();
         int var6;
         if ((var5 & 128) != 0) {
            var6 = var1.readUnsignedByte();
            var5 += var6 << 8;
         }

         if ((var5 & 256) != 0) {
            var6 = var1.readUnsignedByte();
            var5 += var6 << 16;
         }

         int var7;
         int var8;
         if ((var5 & 64) != 0) {
            var6 = var1.readUnsignedShort();
            if (var6 == 65535) {
               var6 = -1;
            }

            var7 = var1.readUnsignedByteAdd();
            if (var6 == var4.sequence && var6 != -1) {
               var8 = ItemContainer.SequenceDefinition_get(var6).replyMode;
               if (var8 == 1) {
                  var4.sequenceFrame = 0;
                  var4.sequenceFrameCycle = 0;
                  var4.sequenceDelay = var7;
                  var4.currentSequenceFrameIndex = 0;
               }

               if (var8 == 2) {
                  var4.currentSequenceFrameIndex = 0;
               }
            } else if (var6 == -1 || var4.sequence == -1 || ItemContainer.SequenceDefinition_get(var6).forcedPriority >= ItemContainer.SequenceDefinition_get(var4.sequence).forcedPriority) {
               var4.sequence = var6;
               var4.sequenceFrame = 0;
               var4.sequenceFrameCycle = 0;
               var4.sequenceDelay = var7;
               var4.currentSequenceFrameIndex = 0;
               var4.field1006 = var4.pathLength;
            }
         }

         if ((var5 & 32) != 0) {
            var4.targetIndex = var1.readUnsignedShort();
            var4.targetIndex += var1.readUnsignedByteAdd() << 16;
            var6 = 16777215;
            if (var6 == var4.targetIndex) {
               var4.targetIndex = -1;
            }
         }

         if ((var5 & 2) != 0) {
            var4.overheadText = var1.readStringCp1252NullTerminated();
            var4.overheadTextCyclesRemaining = 100;
         }

         int var9;
         int var10;
         int var11;
         if ((var5 & 4) != 0) {
            var6 = var1.readUnsignedByte();
            int var12;
            if (var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var8 = var1.readUShortSmart();
                  if (var8 == 32767) {
                     var8 = var1.readUShortSmart();
                     var10 = var1.readUShortSmart();
                     var9 = var1.readUShortSmart();
                     var11 = var1.readUShortSmart();
                  } else if (var8 != 32766) {
                     var10 = var1.readUShortSmart();
                  } else {
                     var8 = -1;
                  }

                  var12 = var1.readUShortSmart();
                  var4.addHitSplat(var8, var10, var9, var11, Client.cycle, var12);
               }
            }

            var7 = var1.readUnsignedByteNeg();
            if (var7 > 0) {
               for(var8 = 0; var8 < var7; ++var8) {
                  var9 = var1.readUShortSmart();
                  var10 = var1.readUShortSmart();
                  if (var10 != 32767) {
                     var11 = var1.readUShortSmart();
                     var12 = var1.readUnsignedByte();
                     int var13 = var10 > 0 ? var1.readUnsignedByteNeg() : var12;
                     var4.addHealthBar(var9, Client.cycle, var10, var11, var12, var13);
                  } else {
                     var4.removeHealthBar(var9);
                  }
               }
            }
         }

         if ((var5 & 8) != 0) {
            var4.definition = AbstractArchive.getNpcDefinition(var1.readUnsignedShortAddLE());
            class142.method811(var4);
            var4.method606();
         }

         if ((var5 & 1) != 0) {
            var6 = var1.readUnsignedShort();
            var7 = var1.readIntLE();
            var4.updateSpotAnimation(0, var6, var7 >> 16, var7 & '\uffff');
         }

         if ((var5 & 16) != 0) {
            var6 = var1.readUnsignedShortAdd();
            var7 = var1.readUnsignedShortAdd();
            var4.field938 = var1.readUnsignedByteAdd() == 1;
            if (Client.param25 >= 212) {
               var4.field993 = var6;
               var4.field970 = var7;
            } else {
               var8 = var4.x - (var6 - WorldMapData_0.baseX - WorldMapData_0.baseX) * 64;
               var9 = var4.y - (var7 - GameObject.baseY - GameObject.baseY) * 64;
               if (var8 != 0 || var9 != 0) {
                  var11 = (int)(Math.atan2((double)var8, (double)var9) * 325.94932345220167D) & 2047;
                  var4.movingOrientation = var11;
               }
            }
         }

         if ((var5 & 16384) != 0) {
            var4.field983 = var1.readByte();
            var4.field985 = var1.readByteNeg();
            var4.field984 = var1.readByteNeg();
            var4.field1003 = var1.readByteNeg();
            var4.spotAnimation = var1.readUnsignedShortAdd() + Client.cycle;
            var4.exactMoveArrive1Cycle = var1.readUnsignedShortLE() + Client.cycle;
            var4.exactMoveDirection = var1.readUnsignedShortAddLE();
            var4.pathLength = 1;
            var4.field1006 = 0;
            var4.field983 += var4.pathX[0];
            var4.field985 += var4.pathY[0];
            var4.field984 += var4.pathX[0];
            var4.field1003 += var4.pathY[0];
         }

         if ((var5 & '耀') != 0) {
            var4.combatLevelChange = var1.readInt();
         }

         if ((var5 & 2048) != 0) {
            var4.recolourStartCycle = Client.cycle + var1.readUnsignedShortLE();
            var4.recolourEndCycle = Client.cycle + var1.readUnsignedShort();
            var4.recolourHue = var1.readByteAdd();
            var4.recolourSaturation = var1.readByteNeg();
            var4.recolourLuminance = var1.readUnsignedByteSub();
            var4.recolourAmount = (byte)var1._readUnsignedByteSub();
         }

         if ((var5 & 512) != 0) {
            var4.method592(var1.readStringCp1252NullTerminated());
         }

         if ((var5 & 8192) != 0) {
            var4.method607(var1.readUnsignedByte());
         }

         int[] var15;
         short[] var16;
         short[] var17;
         long var18;
         boolean var20;
         if ((var5 & 4096) != 0) {
            var6 = var1._readUnsignedByteSub();
            if ((var6 & 1) == 1) {
               var4.method608();
            } else {
               var15 = null;
               if ((var6 & 2) == 2) {
                  var8 = var1._readUnsignedByteSub();
                  var15 = new int[var8];

                  for(var9 = 0; var9 < var8; ++var9) {
                     var10 = var1.readUnsignedShort();
                     var10 = var10 == 65535 ? -1 : var10;
                     var15[var9] = var10;
                  }
               }

               var16 = null;
               if ((var6 & 4) == 4) {
                  var9 = 0;
                  if (var4.definition.recolorTo != null) {
                     var9 = var4.definition.recolorTo.length;
                  }

                  var16 = new short[var9];

                  for(var10 = 0; var10 < var9; ++var10) {
                     var16[var10] = (short)var1.readUnsignedShortLE();
                  }
               }

               var17 = null;
               if ((var6 & 8) == 8) {
                  var10 = 0;
                  if (var4.definition.retextureTo != null) {
                     var10 = var4.definition.retextureTo.length;
                  }

                  var17 = new short[var10];

                  for(var11 = 0; var11 < var10; ++var11) {
                     var17[var11] = (short)var1.readUnsignedShortAdd();
                  }
               }

               var20 = false;
               if ((var6 & 16) != 0) {
                  var20 = var1.readUnsignedByte() == 1;
               }

               var18 = (long)(++NPC.field1047 - 1);
               var4.method598(new NewShit(var18, var15, var16, var17, var20));
            }
         }

         if ((var5 & 1024) != 0) {
            var6 = var1.readUnsignedByteAdd();
            if ((var6 & 1) == 1) {
               var4.method601();
            } else {
               var15 = null;
               if ((var6 & 2) == 2) {
                  var8 = var1.readUnsignedByteAdd();
                  var15 = new int[var8];

                  for(var9 = 0; var9 < var8; ++var9) {
                     var10 = var1.readUnsignedShortAddLE();
                     var10 = var10 == 65535 ? -1 : var10;
                     var15[var9] = var10;
                  }
               }

               var16 = null;
               if ((var6 & 4) == 4) {
                  var9 = 0;
                  if (var4.definition.recolorTo != null) {
                     var9 = var4.definition.recolorTo.length;
                  }

                  var16 = new short[var9];

                  for(var10 = 0; var10 < var9; ++var10) {
                     var16[var10] = (short)var1.readUnsignedShortLE();
                  }
               }

               var17 = null;
               if ((var6 & 8) == 8) {
                  var10 = 0;
                  if (var4.definition.retextureTo != null) {
                     var10 = var4.definition.retextureTo.length;
                  }

                  var17 = new short[var10];

                  for(var11 = 0; var11 < var10; ++var11) {
                     var17[var11] = (short)var1.readUnsignedShortAddLE();
                  }
               }

               var20 = false;
               if ((var6 & 16) != 0) {
                  var20 = var1.readUnsignedByte() == 1;
               }

               var18 = (long)(++NPC.field1050 - 1);
               var4.method600(new NewShit(var18, var15, var16, var17, var20));
            }
         }

         if ((var5 & 131072) != 0) {
            var6 = var1._readUnsignedByteSub();
            var15 = new int[8];
            var16 = new short[8];

            for(var9 = 0; var9 < 8; ++var9) {
               if ((var6 & 1 << var9) != 0) {
                  var15[var9] = var1.method2516();
                  var16[var9] = (short)var1.method2491();
               } else {
                  var15[var9] = -1;
                  var16[var9] = -1;
               }
            }

            var4.method603(var15, var16);
         }

         if ((var5 & 262144) != 0) {
            var6 = var1.readInt();
            var4.turnLeftSequence = (var6 & 1) != 0 ? var1.readUnsignedShort() : var4.definition.turnLeftSequence * 1526449071 * -2117504177;
            var4.turnRightSequence = (var6 & 2) != 0 ? var1.readUnsignedShort() : var4.definition.turnRightSequence * 1635935495 * 1325267127;
            var4.walkSequence = (var6 & 4) != 0 ? var1.readUnsignedShortAddLE() : var4.definition.walkSequence * 849832979 * 1653161499;
            var4.walkBackSequence = (var6 & 8) != 0 ? var1.readUnsignedShort() : var4.definition.walkBackSequence * -820247353 * 606174455;
            var4.walkLeftSequence = (var6 & 16) != 0 ? var1.readUnsignedShort() : var4.definition.walkLeftSequence * 1030172671 * 429445119;
            var4.walkRightSequence = (var6 & 32) != 0 ? var1.readUnsignedShort() : var4.definition.walkRightSequence * -1237616413 * -2142663477;
            var4.runSequence = (var6 & 64) != 0 ? var1.readUnsignedShort() : var4.definition.runSequence * -1565402875 * 1104808909;
            var4.runBackSequence = (var6 & 128) != 0 ? var1.readUnsignedShortLE() : var4.definition.runBackSequence * -1535672631 * 1434909561;
            var4.runLeftSequence = (var6 & 256) != 0 ? var1.readUnsignedShortLE() : var4.definition.runLeftSequence * -1171795391 * -257868351;
            var4.runRightSequence = (var6 & 512) != 0 ? var1.readUnsignedShortLE() : var4.definition.runRightSequence * 1924156607 * -1734270145;
            var4.crawlSequence = (var6 & 1024) != 0 ? var1.readUnsignedShort() : var4.definition.crawlSequence * -237251001 * -1186532489;
            var4.crawlBackSequence = (var6 & 2048) != 0 ? var1.readUnsignedShort() : var4.definition.crawlBackSequence * 1456216629 * -1296177123;
            var4.crawlLeftSequence = (var6 & 4096) != 0 ? var1.readUnsignedShortAdd() : var4.definition.crawlLeftSequence * -750567499 * -2136803683;
            var4.crawlRightSequence = (var6 & 8192) != 0 ? var1.readUnsignedShortAddLE() : var4.definition.crawlRightSequence * 2044090389 * 1520351037;
            var4.idleSequence = (var6 & 16384) != 0 ? var1.readUnsignedShortAdd() : var4.definition.idleSequence * 1304162881 * 1235033537;
         }

         if ((var5 & 65536) != 0) {
            var6 = var1.readUnsignedByteAdd();

            for(var7 = 0; var7 < var6; ++var7) {
               var8 = var1._readUnsignedByteSub();
               var9 = var1.readUnsignedShortAddLE();
               var10 = var1.readIntLE();
               var4.updateSpotAnimation(var8, var9, var10 >> 16, var10 & '\uffff');
            }
         }
      }

      for(var2 = 0; var2 < Client.field484; ++var2) {
         var3 = Client.field485[var2];
         if (Client.npcs[var3].npcCycle != Client.cycle) {
            Client.npcs[var3].definition = null;
            Client.npcs[var3] = null;
         }
      }

      if (var1.offset != Client.packetWriter.serverPacketLength) {
         throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
      } else {
         for(var2 = 0; var2 < Client.npcCount; ++var2) {
            if (Client.npcs[Client.npcIndices[var2]] == null) {
               throw new RuntimeException(var2 + "," + Client.npcCount);
            }
         }

      }
   }
}
