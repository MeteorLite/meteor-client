import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iw")
@Implements("Frames")
public class Frames extends DualNode {
   @ObfuscatedName("ax")
   static int field2055;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "[Lig;"
   )
   @Export("frames")
   Animation[] frames;

   @ObfuscatedSignature(
      descriptor = "(Lne;Lne;IZ)V"
   )
   Frames(AbstractArchive var1, AbstractArchive var2, int var3, boolean var4) {
      NodeDeque var5 = new NodeDeque();
      int var6 = var1.getGroupFileCount(var3);
      this.frames = new Animation[var6];
      int[] var7 = var1.getGroupFileIds(var3);

      for(int var8 = 0; var8 < var7.length; ++var8) {
         byte[] var9 = var1.takeFile(var3, var7[var8]);
         Skeleton var10 = null;
         int var11 = (var9[0] & 255) << 8 | var9[1] & 255;

         for(Skeleton var12 = (Skeleton)var5.last(); var12 != null; var12 = (Skeleton)var5.previous()) {
            if (var11 == var12.id) {
               var10 = var12;
               break;
            }
         }

         if (var10 == null) {
            byte[] var13;
            if (var4) {
               var13 = var2.getFile(0, var11);
            } else {
               var13 = var2.getFile(var11, 0);
            }

            var10 = new Skeleton(var11, var13);
            var5.addFirst(var10);
         }

         this.frames[var7[var8]] = new Animation(var9, var10);
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1355530944"
   )
   @Export("hasAlphaTransform")
   public boolean hasAlphaTransform(int var1) {
      return this.frames[var1].hasAlphaTransform;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(Lsq;ILdh;II)V",
      garbageValue = "1494438010"
   )
   static final void method1250(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = MoveSpeed.STATIONARY.speed;
      int var5;
      if ((var3 & 8192) != 0) {
         var2.spotAnimation = var0.readUnsignedShortLEA();
         var5 = var0.method2455();
         var2.spotAnimHeight = var5 >> 16;
         var2.spotAnimationStartCycle = (var5 & '\uffff') + Client.cycle;
         var2.spotAnimationFrame = 0;
         var2.field964 = 0;
         if (var2.spotAnimationStartCycle > Client.cycle) {
            var2.spotAnimationFrame = -1;
         }

         if (var2.spotAnimation == 65535) {
            var2.spotAnimation = -1;
         }
      }

      if ((var3 & 64) != 0) {
         var5 = var0.readUnsignedByte();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytesAReverse(var6, 0, var5);
         Players.cachedAppearanceBuffer[var1] = var7;
         var2.read(var7);
      }

      if ((var3 & 4096) != 0) {
         var2.exactMoveDeltaX1 = var0.method2432();
         var2.exactMoveDeltaY1 = var0.method2432();
         var2.exactMoveDeltaX2 = var0.method2432();
         var2.exactMoveDeltaY2 = var0.method2396();
         var2.exactMoveArrive1Cycle = var0.readUnsignedShort() + Client.cycle;
         var2.exactMoveArrive2Cycle = var0.readUnsignedShortLE() + Client.cycle;
         var2.exactMoveDirection = var0.method2437();
         if (var2.hasMovementPending) {
            var2.exactMoveDeltaX1 += var2.tileX;
            var2.exactMoveDeltaY1 += var2.tileY;
            var2.exactMoveDeltaX2 += var2.tileX;
            var2.exactMoveDeltaY2 += var2.tileY;
            var2.pathLength = 0;
         } else {
            var2.exactMoveDeltaX1 += var2.pathX[0];
            var2.exactMoveDeltaY1 += var2.pathY[0];
            var2.exactMoveDeltaX2 += var2.pathX[0];
            var2.exactMoveDeltaY2 += var2.pathY[0];
            var2.pathLength = 1;
         }

         var2.field1004 = 0;
      }

      int var8;
      int var9;
      int var12;
      int var13;
      if ((var3 & 4) != 0) {
         var5 = var0.method2405();
         int var10;
         int var11;
         int var14;
         if (var5 > 0) {
            for(var13 = 0; var13 < var5; ++var13) {
               var8 = -1;
               var9 = -1;
               var10 = -1;
               var14 = var0.readUShortSmart();
               if (var14 == 32767) {
                  var14 = var0.readUShortSmart();
                  var9 = var0.readUShortSmart();
                  var8 = var0.readUShortSmart();
                  var10 = var0.readUShortSmart();
               } else if (var14 != 32766) {
                  var9 = var0.readUShortSmart();
               } else {
                  var14 = -1;
               }

               var11 = var0.readUShortSmart();
               var2.addHitSplat(var14, var9, var8, var10, Client.cycle, var11);
            }
         }

         var13 = var0.readUnsignedShortA();
         if (var13 > 0) {
            for(var14 = 0; var14 < var13; ++var14) {
               var8 = var0.readUShortSmart();
               var9 = var0.readUShortSmart();
               if (var9 != 32767) {
                  var10 = var0.readUShortSmart();
                  var11 = var0.method2405();
                  var12 = var9 > 0 ? var0.method2405() : var11;
                  var2.addHealthBar(var8, Client.cycle, var9, var10, var11, var12);
               } else {
                  var2.removeHealthBar(var8);
               }
            }
         }
      }

      if ((var3 & 256) != 0) {
         var4 = var0.method2433();
      }

      if ((var3 & 1) != 0) {
         var5 = var0.readUnsignedShortLEA();
         PlayerType var17 = (PlayerType)SpriteMask.findEnumerated(MoveSpeed.PlayerType_values(), var0.method2405());
         boolean var19 = var0.method2430() == 1;
         var8 = var0.method2430();
         var9 = var0.offset;
         if (var2.username != null && var2.appearance != null) {
            boolean var18 = false;
            if (var17.isUser && class6.friendSystem.isIgnored(var2.username)) {
               var18 = true;
            }

            if (!var18 && Client.field540 == 0 && !var2.isHidden) {
               Players.field1079.offset = 0;
               var0.method2448(Players.field1079.array, 0, var8);
               Players.field1079.offset = 0;
               String var15 = AbstractFont.escapeBrackets(class33.method136(class279.readString(Players.field1079)));
               var2.overheadText = var15.trim();
               var2.field952 = var5 >> 8;
               var2.field945 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.isAutoChatting = var19;
               var2.showPublicPlayerChat = var2 != BuddyRankComparator.localPlayer && var17.isUser && "" != Client.field510 && var15.toLowerCase().indexOf(Client.field510) == -1;
               if (var17.isPrivileged) {
                  var12 = var19 ? 91 : 1;
               } else {
                  var12 = var19 ? 90 : 2;
               }

               if (var17.modIcon != -1) {
                  MusicPatchNode.addGameMessage(var12, class7.addImageTag(var17.modIcon) + var2.username.getName(), var15);
               } else {
                  MusicPatchNode.addGameMessage(var12, var2.username.getName(), var15);
               }
            }
         }

         var0.offset = var9 + var8;
      }

      if ((var3 & 16384) != 0) {
         Players.playerMovementSpeeds[var1] = (MoveSpeed)SpriteMask.findEnumerated(VarcInt.method938(), var0.method2432());
      }

      if ((var3 & 16) != 0) {
         var5 = var0.readUnsignedShort();
         if (var5 == 65535) {
            var5 = -1;
         }

         var13 = var0.method2430();
         Language.performPlayerAnimation(var2, var5, var13);
      }

      if ((var3 & 2048) != 0) {
         var2.recolourStartCycle = Client.cycle + var0.readUnsignedShort();
         var2.recolourEndCycle = Client.cycle + var0.method2437();
         var2.recolourHue = var0.method2432();
         var2.recolourSaturation = var0.readByte();
         var2.recolourLuminance = var0.method2396();
         var2.recolourAmount = (byte)var0.method2405();
      }

      if ((var3 & 128) != 0) {
         var2.movingOrientation = var0.readUnsignedShortLEA();
         if (var2.pathLength == 0) {
            var2.orientation = var2.movingOrientation;
            var2.method507();
         }
      }

      if ((var3 & 32) != 0) {
         var2.overheadText = var0.readStringCp1252NullTerminated();
         if (var2.overheadText.charAt(0) == '~') {
            var2.overheadText = var2.overheadText.substring(1);
            MusicPatchNode.addGameMessage(2, var2.username.getName(), var2.overheadText);
         } else if (var2 == BuddyRankComparator.localPlayer) {
            MusicPatchNode.addGameMessage(2, var2.username.getName(), var2.overheadText);
         }

         var2.isAutoChatting = false;
         var2.field952 = 0;
         var2.field945 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      if ((var3 & 1024) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readStringCp1252NullTerminated();
         }
      }

      if ((var3 & 8) != 0) {
         var2.targetIndex = var0.method2437();
         var2.targetIndex += var0.method2430() << 16;
         var5 = 16777215;
         if (var2.targetIndex == var5) {
            var2.targetIndex = -1;
         }
      }

      if (var2.hasMovementPending) {
         if (var4 == 127) {
            var2.resetPath(var2.tileX, var2.tileY);
         } else {
            MoveSpeed var16;
            if (var4 != MoveSpeed.STATIONARY.speed) {
               var16 = (MoveSpeed)SpriteMask.findEnumerated(VarcInt.method938(), var4);
            } else {
               var16 = Players.playerMovementSpeeds[var1];
            }

            var2.move(var2.tileX, var2.tileY, var16);
         }
      }

   }

   @ObfuscatedName("md")
   @ObfuscatedSignature(
      descriptor = "(IIIILsn;Llx;I)V",
      garbageValue = "1091031252"
   )
   @Export("worldToMinimap")
   static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpriteMask var5) {
      int var6 = var3 * var3 + var2 * var2;
      if (var6 > 4225 && var6 < 90000) {
         int var7 = Client.camAngleY & 2047;
         int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
         int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.width / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         class136.redHintArrowSprite.method2542(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class149.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
      }

   }
}
