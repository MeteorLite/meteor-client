import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("Player")
public final class Player extends Actor {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lsi;"
    )
    Username username;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lka;"
    )
    PlayerComposition appearance;
    @ObfuscatedName("v")
    int headIconPk = -1;
    @ObfuscatedName("s")
    int headIconPrayer = -1;
    @ObfuscatedName("j")
    String[] actions = new String[3];
    @ObfuscatedName("i")
    int combatLevel;
    @ObfuscatedName("n")
    int skillLevel;
    @ObfuscatedName("l")
    int tileHeight;
    @ObfuscatedName("k")
    int animationCycleStart;
    @ObfuscatedName("c")
    int animationCycleEnd;
   @ObfuscatedName("r")
   int field902;
    @ObfuscatedName("b")
    int baseTileHeight;
   @ObfuscatedName("m")
   int field908;
    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "Lhs;"
    )
    Model attachedModel;
    @ObfuscatedName("h")
    int minX;
    @ObfuscatedName("p")
    int minY;
    @ObfuscatedName("o")
    int maxX;
    @ObfuscatedName("u")
    int maxY;
    @ObfuscatedName("x")
    boolean isUnanimated;
    @ObfuscatedName("a")
    int team;
    @ObfuscatedName("q")
    boolean isHidden;
    @ObfuscatedName("d")
    int plane;
    @ObfuscatedName("e")
    int index;
    @ObfuscatedName("g")
    @ObfuscatedSignature(
            descriptor = "Lot;"
    )
    TriBool isFriendTriBool;
    @ObfuscatedName("y")
    @ObfuscatedSignature(
            descriptor = "Lot;"
    )
    TriBool isInFriendsChat;
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lot;"
    )
    TriBool isInClanChat;
    @ObfuscatedName("aa")
    boolean hasMovementPending;
    @ObfuscatedName("ai")
    int tileX;
    @ObfuscatedName("ag")
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

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;I)V",
            garbageValue = "1042470094"
    )
    final void read(Buffer var1) {
      var1.offset = 0;
      int var2 = var1.readUnsignedByte();
      int var3 = -1;
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
               var9 = TileItem.ItemDefinition_get(var5[var6] - 512).team;
               if (var9 != 0) {
                  this.team = var9;
               }
            }
         }
      }

      int[] var12 = new int[5];

      for(var7 = 0; var7 < 5; ++var7) {
         var8 = var1.readUnsignedByte();
         if (var8 < 0 || var8 >= UserComparator8.field1152[var7].length) {
            var8 = 0;
         }

         var12[var7] = var8;
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

      this.username = new Username(var1.readStringCp1252NullTerminated(), WorldMapCacheName.loginType);
      this.clearIsFriend();
      this.clearIsInFriendsChat();
      this.clearIsInClanChat();
      if (this == class387.localPlayer) {
         RunException.localPlayerName = this.username.getName();
      }

      this.combatLevel = var1.readUnsignedByte();
      this.skillLevel = var1.readUnsignedShort();
      this.isHidden = var1.readUnsignedByte() == 1;
      if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
         this.isHidden = false;
      }

      ObjTypeCustomisation[] var13 = null;
      boolean var14 = false;
      var9 = var1.readUnsignedShort();
      var14 = (var9 >> 15 & 1) == 1;
      int var10;
      if (var9 > 0 && var9 != 32768) {
         var13 = new ObjTypeCustomisation[12];

         for(var10 = 0; var10 < 12; ++var10) {
            int var11 = var9 >> 12 - var10 & 1;
            if (var11 == 1) {
               var13[var10] = class194.method982(var5[var10] - 512, var1);
            }
         }
      }

      for(var10 = 0; var10 < 3; ++var10) {
         this.actions[var10] = var1.readStringCp1252NullTerminated();
      }

      if (Client.param25 > 208) {
         var3 = var1.readUnsignedByte();
      }

      if (this.appearance == null) {
         this.appearance = new PlayerComposition();
      }

      this.appearance.setAppearance(var5, var13, var14, var12, var2, var4, var3);
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(I)Lhs;",
            garbageValue = "922199662"
    )
    protected final Model getModel() {
      if (this.appearance == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? class85.SequenceDefinition_get(super.sequence) : null;
         SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.movementSequence == super.idleSequence && var1 != null ? null : class85.SequenceDefinition_get(super.movementSequence);
         Model var3 = this.appearance.getModel(var1, super.sequenceFrame, var2, super.movementFrame);
         if (var3 == null) {
            return null;
         } else {
            var3.calculateBoundsCylinder();
            super.defaultHeight = var3.height;
            int var4 = var3.indicesCount;
            Model var5;
            Model[] var6;
            if (!this.isUnanimated && super.spotAnimation != -1 && super.spotAnimationFrame != -1) {
               var5 = MouseRecorder.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
               if (var5 != null) {
                  var5.offsetBy(0, -super.spotAnimHeight, 0);
                  var6 = new Model[]{var3, var5};
                  var3 = new Model(var6, 2);
               }
            }

            if (!this.isUnanimated && this.attachedModel != null) {
               if (Client.cycle >= this.animationCycleEnd) {
                  this.attachedModel = null;
               }

               if (Client.cycle >= this.animationCycleStart && Client.cycle < this.animationCycleEnd) {
                  var5 = this.attachedModel;
                  var5.offsetBy(this.field902 - super.x, this.baseTileHeight - this.tileHeight, this.field908 - super.y);
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

                  var6 = new Model[]{var3, var5};
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

                  var5.offsetBy(super.x - this.field902, this.tileHeight - this.baseTileHeight, super.y - this.field908);
               }
            }

            var3.isSingleTile = true;
            if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
               var3.overrideHue = super.recolourHue;
               var3.overrideSaturation = super.recolourSaturation;
               var3.overrideLuminance = super.recolourLuminance;
               var3.overrideAmount = super.recolourAmount;
               var3.field2176 = (short)var4;
            } else {
               var3.overrideAmount = 0;
            }

            return var3;
         }
      }
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(B)Z",
            garbageValue = "-82"
    )
    boolean isFriend() {
      if (this.isFriendTriBool == TriBool.TriBool_unknown) {
         this.checkIsFriend();
      }

      return this.isFriendTriBool == TriBool.TriBool_true;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1022662395"
    )
    void clearIsFriend() {
      this.isFriendTriBool = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-2031372111"
    )
    void checkIsFriend() {
      this.isFriendTriBool = WorldMapElement.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

    @ObfuscatedName("c")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "1928367871"
    )
    boolean isFriendsChatMember() {
      if (this.isInFriendsChat == TriBool.TriBool_unknown) {
         this.updateIsInFriendsChat();
      }

      return this.isInFriendsChat == TriBool.TriBool_true;
   }

    @ObfuscatedName("r")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1261781469"
    )
    void clearIsInFriendsChat() {
      this.isInFriendsChat = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("b")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "0"
    )
    void updateIsInFriendsChat() {
      this.isInFriendsChat = class463.friendsChat != null && class463.friendsChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

    @ObfuscatedName("m")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-112748742"
    )
    void updateIsInClanChat() {
      for(int var1 = 0; var1 < 4; ++var1) {
         if (Client.currentClanSettings[var1] != null && Client.currentClanSettings[var1].method808(this.username.getName()) != -1 && var1 != 2) {
            this.isInClanChat = TriBool.TriBool_true;
            return;
         }
      }

      this.isInClanChat = TriBool.TriBool_false;
   }

    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "533945573"
    )
    void clearIsInClanChat() {
      this.isInClanChat = TriBool.TriBool_unknown;
   }

    @ObfuscatedName("h")
    @ObfuscatedSignature(
            descriptor = "(S)Z",
            garbageValue = "-13423"
    )
    boolean isClanMember() {
      if (this.isInClanChat == TriBool.TriBool_unknown) {
         this.updateIsInClanChat();
      }

      return this.isInClanChat == TriBool.TriBool_true;
   }

    @ObfuscatedName("p")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1966414464"
    )
    int transformedSize() {
      return this.appearance != null && this.appearance.npcTransformId != -1 ? class137.getNpcDefinition(this.appearance.npcTransformId).size : 1;
   }

    @ObfuscatedName("o")
    @ObfuscatedSignature(
            descriptor = "(IILhz;I)V",
            garbageValue = "-1093803417"
    )
    final void move(int var1, int var2, MoveSpeed var3) {
      if (super.sequence != -1 && class85.SequenceDefinition_get(super.sequence).priority == 1) {
         super.sequence = -1;
      }

      super.movingOrientation = -1;
      if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if (var3 == MoveSpeed.RUN) {
               GrandExchangeEvent.method1855(this, var1, var2, MoveSpeed.RUN);
            }

            this.method491(var1, var2, var3);
         } else {
            this.resetPath(var1, var2);
         }
      } else {
         this.resetPath(var1, var2);
      }

   }

    @ObfuscatedName("u")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "575533768"
    )
    void resetPath(int var1, int var2) {
      super.pathLength = 0;
      super.field1006 = 0;
      super.field951 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.transformedSize();
      super.x = super.pathX[0] * 128 + var3 * 64;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IILhz;I)V",
      garbageValue = "-25109221"
   )
   final void method491(int var1, int var2, MoveSpeed var3) {
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

    @ObfuscatedName("a")
    @ObfuscatedSignature(
            descriptor = "(I)Z",
            garbageValue = "-967333967"
    )
    final boolean isVisible() {
      return this.appearance != null;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "([BB)Liy;",
      garbageValue = "-51"
   )
   static WorldMapSprite method479(byte[] var0) {
      return var0 == null ? new WorldMapSprite() : new WorldMapSprite(class266.method1505(var0).pixels);
   }

   @ObfuscatedName("kh")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-871927405"
   )
   static final void method488(int var0) {
      var0 = Math.min(Math.max(var0, 0), 255);
      if (var0 != PacketWriter.clientPreferences.getCurrentMusicVolume()) {
         if (PacketWriter.clientPreferences.getCurrentMusicVolume() == 0 && Client.currentTrackGroupId != -1) {
            class148.method784(class153.archive6, Client.currentTrackGroupId, 0, var0, false);
            Client.playingJingle = false;
         } else if (var0 == 0) {
            class177.method905();
            Client.playingJingle = false;
         } else if (class290.musicPlayerStatus != 0) {
            class290.musicTrackVolume = var0;
         } else {
            class290.midiPcmStream.setPcmStreamVolume(var0);
         }

         PacketWriter.clientPreferences.setCurrentMusicVolume(var0);
      }

   }

   @ObfuscatedName("lo")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "855399495"
   )
   static final void method486(int var0, int var1) {
      if (Client.currentClanChannels[var0] != null) {
         if (var1 >= 0 && var1 < Client.currentClanChannels[var0].method844()) {
            ClanChannelMember var2 = (ClanChannelMember)Client.currentClanChannels[var0].members.get(var1);
            if (var2.rank == -1) {
               PacketBufferNode var3 = Renderable.getPacketBufferNode(ClientPacket.field2442, Client.packetWriter.isaacCipher);
               var3.packetBuffer.writeByte(3 + class96.stringCp1252NullTerminatedByteSize(var2.username.getName()));
               var3.packetBuffer.writeByte(var0);
               var3.packetBuffer.writeShort(var1);
               var3.packetBuffer.writeStringCp1252NullTerminated(var2.username.getName());
               Client.packetWriter.addNode(var3);
            }
         }
      }
   }
}
