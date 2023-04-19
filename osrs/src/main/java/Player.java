import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dv")
@Implements("Player")
public final class Player extends Actor {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Ltm;"
    )
    Username username;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lmw;"
    )
    PlayerComposition appearance;
    @ObfuscatedName("ac")
    int headIconPk = -1;
    @ObfuscatedName("au")
    int headIconPrayer = -1;
    @ObfuscatedName("aq")
    String[] actions = new String[3];
    @ObfuscatedName("al")
    int combatLevel;
    @ObfuscatedName("at")
    int skillLevel;
    @ObfuscatedName("aa")
    int tileHeight;
    @ObfuscatedName("ay")
    int animationCycleStart;
    @ObfuscatedName("ao")
    int animationCycleEnd;
   @ObfuscatedName("ax")
   int field899;
    @ObfuscatedName("ai")
    int baseTileHeight;
   @ObfuscatedName("ag")
   int field903;
    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "Lit;"
    )
    Model attachedModel;
    @ObfuscatedName("av")
    int minX;
    @ObfuscatedName("ar")
    int minY;
    @ObfuscatedName("am")
    int maxX;
    @ObfuscatedName("as")
    int maxY;
    @ObfuscatedName("aj")
    boolean isUnanimated;
    @ObfuscatedName("ak")
    int team;
    @ObfuscatedName("az")
    boolean isHidden;
    @ObfuscatedName("ad")
    int plane;
    @ObfuscatedName("ae")
    int index;
    @ObfuscatedName("ap")
    @ObfuscatedSignature(
            descriptor = "Lpx;"
    )
    TriBool isFriendTriBool;
    @ObfuscatedName("by")
    @ObfuscatedSignature(
            descriptor = "Lpx;"
    )
    TriBool isInFriendsChat;
    @ObfuscatedName("bb")
    @ObfuscatedSignature(
            descriptor = "Lpx;"
    )
    TriBool isInClanChat;
    @ObfuscatedName("bi")
    boolean hasMovementPending;
    @ObfuscatedName("be")
    int tileX;
    @ObfuscatedName("bk")
    int tileY;

   Player() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.actions[var1] = "";
      }

      this.combatLevel = 0;
      this.skillLevel = 0;
      this.animationCycleStart = 0;
      this.animationCycleEnd = 0;
      this.isUnanimated = false;
      this.team = 0;
      this.isHidden = false;
      this.isFriendTriBool = TriBool.TriBool_unknown;
      this.isInFriendsChat = TriBool.TriBool_unknown;
      this.isInClanChat = TriBool.TriBool_unknown;
      this.hasMovementPending = false;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "-1448794473"
    )
    final void read(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      boolean var3 = true;
      this.headIconPk = var1.readByte();
      this.headIconPrayer = var1.readByte();
      int var4 = -1;
      this.team = 0;
      int[] var5 = new int[12];

      int var7;
      int var8;
      int var9;
      for(int var6 = 0; var6 < 12; ++var6) {
         var7 = var1.readUnsignedByte();
         if (var7 == 0) {
            var5[var6] = 0;
         } else {
            var8 = var1.readUnsignedByte();
            var5[var6] = var8 + (var7 << 8);
            if (var6 == 0 && var5[0] == 65535) {
               var4 = var1.readUnsignedShort();
               break;
            }

            if (var5[var6] >= 512) {
               var9 = HealthBarUpdate.ItemDefinition_get(var5[var6] - 512).team;
               if (var9 != 0) {
                  this.team = var9;
               }
            }
         }
      }

      int[] var13 = null;
      if (Client.param25 >= 213) {
         var13 = new int[12];

         for(var7 = 0; var7 < 12; ++var7) {
            var8 = var1.readUnsignedByte();
            if (var8 == 0) {
               var13[var7] = 0;
            } else {
               var9 = var1.readUnsignedByte();
               var13[var7] = var9 + (var8 << 8);
            }
         }
      }

      int[] var14 = new int[5];

      for(var8 = 0; var8 < 5; ++var8) {
         var9 = var1.readUnsignedByte();
         if (var9 < 0 || var9 >= PlayerComposition.field2828[var8].length) {
            var9 = 0;
         }

         var14[var8] = var9;
      }

      super.idleSequence = var1.readUnsignedShort();
      if (super.idleSequence == 65535) {
         super.idleSequence = -1;
      }

      super.turnLeftSequence = var1.readUnsignedShort();
      if (super.turnLeftSequence == 65535) {
         super.turnLeftSequence = -1;
      }

      super.turnRightSequence = super.turnLeftSequence;
      super.walkSequence = var1.readUnsignedShort();
      if (super.walkSequence == 65535) {
         super.walkSequence = -1;
      }

      super.walkBackSequence = var1.readUnsignedShort();
      if (super.walkBackSequence == 65535) {
         super.walkBackSequence = -1;
      }

      super.walkLeftSequence = var1.readUnsignedShort();
      if (super.walkLeftSequence == 65535) {
         super.walkLeftSequence = -1;
      }

      super.walkRightSequence = var1.readUnsignedShort();
      if (super.walkRightSequence == 65535) {
         super.walkRightSequence = -1;
      }

      super.runSequence = var1.readUnsignedShort();
      if (super.runSequence == 65535) {
         super.runSequence = -1;
      }

      this.username = new Username(var1.readStringCp1252NullTerminated(), class70.loginType);
      this.clearIsFriend();
      this.clearIsInFriendsChat();
      this.clearIsInClanChat();
      if (this == MusicPatchNode.localPlayer) {
         RunException.field4180 = this.username.getName();
      }

      this.combatLevel = var1.readUnsignedByte();
      this.skillLevel = var1.readUnsignedShort();
      this.isHidden = var1.readUnsignedByte() == 1;
      if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
         this.isHidden = false;
      }

      ObjTypeCustomisation[] var15 = null;
      boolean var17 = false;
      int var10 = var1.readUnsignedShort();
      var17 = (var10 >> 15 & 1) == 1;
      int var11;
      if (var10 > 0 && var10 != 32768) {
         var15 = new ObjTypeCustomisation[12];

         for(var11 = 0; var11 < 12; ++var11) {
            int var12 = var10 >> 12 - var11 & 1;
            if (var12 == 1) {
               var15[var11] = Projectile.method451(var5[var11] - 512, var1);
            }
         }
      }

      for(var11 = 0; var11 < 3; ++var11) {
         this.actions[var11] = var1.readStringCp1252NullTerminated();
      }

      int var16 = var1.readUnsignedByte();
      if (this.appearance == null) {
         this.appearance = new PlayerComposition();
      }

      this.appearance.method1692(var13, var5, var15, var17, var14, var2, var4, var16);
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(B)Lit;",
            garbageValue = "-112"
    )
    protected final Model getModel() {
      if (this.appearance == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? ItemContainer.SequenceDefinition_get(super.sequence) : null;
         SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.movementSequence == super.idleSequence && var1 != null ? null : ItemContainer.SequenceDefinition_get(super.movementSequence);
         Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
         if (var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.defaultHeight = var3.height;
            int var4 = var3.indicesCount;
            if (!this.isUnanimated) {
               var3 = this.method530(var3);
            }

            if (!this.isUnanimated && this.attachedModel != null) {
               if (Client.cycle >= this.animationCycleEnd) {
                  this.attachedModel = null;
               }

               if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
                  Model var5 = this.attachedModel;
                  var5.offsetBy(this.field899 - super.x, this.baseTileHeight - this.tileHeight, this.field903 - super.y);
                  if (super.orientation == 512) {
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                  } else if (super.orientation == 1024) {
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                  } else if (super.orientation == 1536) {
                     var5.rotateY90Ccw();
                  }

                  Model[] var6 = new Model[]{var3, var5};
                  var3 = new Model(var6, 2);
                  if (super.orientation == 512) {
                     var5.rotateY90Ccw();
                  } else if (super.orientation == 1024) {
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                  } else if (super.orientation == 1536) {
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                     var5.rotateY90Ccw();
                  }

                  var5.offsetBy(super.x - this.field899, this.tileHeight - this.baseTileHeight, super.y - this.field903);
               }
            }

            var3.isSingleTile = true;
            if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
               var3.overrideHue = super.recolourHue;
               var3.overrideSaturation = super.recolourSaturation;
               var3.overrideLuminance = super.recolourLuminance;
               var3.overrideAmount = super.recolourAmount;
               var3.field2196 = (short)var4;
            } else {
               var3.overrideAmount = 0;
            }

            return var3;
         }
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-1214578435"
    )
    boolean isFriend() {
      if (this.isFriendTriBool == TriBool.TriBool_unknown) {
         this.checkIsFriend();
      }

      return this.isFriendTriBool == TriBool.TriBool_true;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "2"
    )
    void clearIsFriend() {
      this.isFriendTriBool = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("at")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "94"
    )
    void checkIsFriend() {
      this.isFriendTriBool = World.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "-120"
    )
    boolean isFriendsChatMember() {
      if (this.isInFriendsChat == TriBool.TriBool_unknown) {
         this.updateIsInFriendsChat();
      }

      return this.isInFriendsChat == TriBool.TriBool_true;
   }

    @ObfuscatedName("ay")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "2091394919"
    )
    void clearIsInFriendsChat() {
      this.isInFriendsChat = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("ao")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "45"
    )
    void updateIsInFriendsChat() {
      this.isInFriendsChat = UserComparator5.friendsChat != null && UserComparator5.friendsChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

    @ObfuscatedName("ax")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "-64"
    )
    void updateIsInClanChat() {
      for(int var1 = 0; var1 < 4; ++var1) {
         if (Client.currentClanSettings[var1] != null && Client.currentClanSettings[var1].method851(this.username.getName()) != -1 && var1 != 2) {
            this.isInClanChat = TriBool.TriBool_true;
            return;
         }
      }

      this.isInClanChat = TriBool.TriBool_false;
   }

    @ObfuscatedName("ai")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "453146982"
    )
    void clearIsInClanChat() {
      this.isInClanChat = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("ag")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "0"
    )
    boolean isClanMember() {
      if (this.isInClanChat == TriBool.TriBool_unknown) {
         this.updateIsInClanChat();
      }

      return this.isInClanChat == TriBool.TriBool_true;
   }

    @ObfuscatedName("ah")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-83"
    )
    int transformedSize() {
      return this.appearance != null && this.appearance.npcTransformId != -1 ? AbstractArchive.getNpcDefinition(this.appearance.npcTransformId).size : 1;
   }

    @ObfuscatedName("av")
    @ObfuscatedSignature(
            descriptor = "(IILiu;B)V",
            garbageValue = "-1"
    )
    final void move(int var1, int var2, MoveSpeed var3) {
      if (super.sequence != -1 && ItemContainer.SequenceDefinition_get(super.sequence).priority == 1) {
         super.sequence = -1;
      }

      this.method527();
      if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if (var3 == MoveSpeed.RUN) {
               Decimator.method325(this, var1, var2, MoveSpeed.RUN);
            }

            this.method513(var1, var2, var3);
         } else {
            this.resetPath(var1, var2);
         }
      } else {
         this.resetPath(var1, var2);
      }

   }

    @ObfuscatedName("ar")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "-1060497849"
    )
    void resetPath(int var1, int var2) {
      super.pathLength = 0;
      super.field1006 = 0;
      super.field1005 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.transformedSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(IILiu;I)V",
      garbageValue = "475560620"
   )
   final void method513(int var1, int var2, MoveSpeed var3) {
      if (super.pathLength < 9) {
         ++super.pathLength;
      }

      for(int var4 = super.pathLength; var4 > 0; --var4) {
         super.pathX[var4] = super.pathX[var4 - 1];
         super.pathY[var4] = super.pathY[var4 - 1];
         super.pathTraversed[var4] = super.pathTraversed[var4 - 1];
      }

      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.pathTraversed[0] = var3;
   }

    @ObfuscatedName("as")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1666539507"
    )
    final boolean isVisible() {
      return this.appearance != null;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IIB)I",
      garbageValue = "0"
   )
   static int method520(int var0, int var1) {
      ItemContainer var2 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if (var2 == null) {
         return -1;
      } else {
         return var1 >= 0 && var1 < var2.ids.length ? var2.ids[var1] : -1;
      }
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1198190304"
   )
   static void method519() {
      if (class12.clearLoginScreen) {
         Login.titleboxSprite = null;
         class292.titlebuttonSprite = null;
         class396.runesSprite = null;
         class123.leftTitleSprite = null;
         ParamComposition.rightTitleSprite = null;
         Canvas.logoSprite = null;
         class148.title_muteSprite = null;
         Login.options_buttons_0Sprite = null;
         class158.options_buttons_2Sprite = null;
         class476.worldSelectBackSprites = null;
         class16.worldSelectFlagSprites = null;
         DevicePcmPlayerProvider.worldSelectArrows = null;
         World.worldSelectStars = null;
         class319.field3030 = null;
         class121.field1184.method555();
         class297.musicPlayerStatus = 1;
         class297.musicTrackArchive = null;
         class379.musicTrackGroupId = -1;
         VarpDefinition.musicTrackFileId = -1;
         class100.musicTrackVolume = 0;
         class120.musicTrackBoolean = false;
         class162.pcmSampleLength = 2;
         class177.method967(true);
         class12.clearLoginScreen = false;
      }
   }
}
