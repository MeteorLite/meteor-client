import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dh")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Ltj;"
   )
   @Export("username")
   Username username;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Llc;"
   )
   @Export("appearance")
   PlayerComposition appearance;
   @ObfuscatedName("ac")
   @Export("headIconPk")
   int headIconPk = -1;
   @ObfuscatedName("ab")
   @Export("headIconPrayer")
   int headIconPrayer = -1;
   @ObfuscatedName("av")
   @Export("actions")
   String[] actions = new String[3];
   @ObfuscatedName("aq")
   @Export("combatLevel")
   int combatLevel;
   @ObfuscatedName("ap")
   @Export("skillLevel")
   int skillLevel;
   @ObfuscatedName("ar")
   @Export("tileHeight")
   int tileHeight;
   @ObfuscatedName("ak")
   @Export("animationCycleStart")
   int animationCycleStart;
   @ObfuscatedName("ax")
   @Export("animationCycleEnd")
   int animationCycleEnd;
   @ObfuscatedName("as")
   int field891;
   @ObfuscatedName("ay")
   @Export("baseTileHeight")
   int baseTileHeight;
   @ObfuscatedName("am")
   int field893;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "Lix;"
   )
   @Export("attachedModel")
   Model attachedModel;
   @ObfuscatedName("ae")
   @Export("minX")
   int minX;
   @ObfuscatedName("au")
   @Export("minY")
   int minY;
   @ObfuscatedName("ag")
   @Export("maxX")
   int maxX;
   @ObfuscatedName("at")
   @Export("maxY")
   int maxY;
   @ObfuscatedName("af")
   @Export("isUnanimated")
   boolean isUnanimated;
   @ObfuscatedName("ai")
   @Export("team")
   int team;
   @ObfuscatedName("aw")
   @Export("isHidden")
   boolean isHidden;
   @ObfuscatedName("aa")
   @Export("plane")
   int plane;
   @ObfuscatedName("ah")
   @Export("index")
   int index;
   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "Lpf;"
   )
   @Export("isFriendTriBool")
   TriBool isFriendTriBool;
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      descriptor = "Lpf;"
   )
   @Export("isInFriendsChat")
   TriBool isInFriendsChat;
   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      descriptor = "Lpf;"
   )
   @Export("isInClanChat")
   TriBool isInClanChat;
   @ObfuscatedName("bo")
   @Export("hasMovementPending")
   boolean hasMovementPending;
   @ObfuscatedName("bs")
   @Export("tileX")
   int tileX;
   @ObfuscatedName("bg")
   @Export("tileY")
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

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "1240368093"
   )
   @Export("read")
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
               var9 = ParamComposition.ItemDefinition_get(var5[var6] - 512).team;
               if (var9 != 0) {
                  this.team = var9;
               }
            }
         }
      }

      int[] var12 = new int[5];

      for(var7 = 0; var7 < 5; ++var7) {
         var8 = var1.readUnsignedByte();
         if (var8 < 0 || var8 >= CollisionMap.field1830[var7].length) {
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

      this.username = new Username(var1.readStringCp1252NullTerminated(), Occluder.loginType);
      this.clearIsFriend();
      this.clearIsInFriendsChat();
      this.clearIsInClanChat();
      if (this == BuddyRankComparator.localPlayer) {
         RunException.localPlayerName = this.username.getName();
      }

      this.combatLevel = var1.readUnsignedByte();
      this.skillLevel = var1.readUnsignedShort();
      this.isHidden = var1.readUnsignedByte() == 1;
      if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
         this.isHidden = false;
      }

      ObjTypeCustomisation[] var13 = null;
      boolean var15 = false;
      var9 = var1.readUnsignedShort();
      var15 = (var9 >> 15 & 1) == 1;
      int var10;
      if (var9 > 0 && var9 != 32768) {
         var13 = new ObjTypeCustomisation[12];

         for(var10 = 0; var10 < 12; ++var10) {
            int var11 = var9 >> 12 - var10 & 1;
            if (var11 == 1) {
               var13[var10] = PlayerComposition.method1650(var5[var10] - 512, var1);
            }
         }
      }

      for(var10 = 0; var10 < 3; ++var10) {
         this.actions[var10] = var1.readStringCp1252NullTerminated();
      }

      int var14 = var1.readUnsignedByte();
      if (this.appearance == null) {
         this.appearance = new PlayerComposition();
      }

      this.appearance.setAppearance(var5, var13, var15, var12, var2, var4, var14);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Lix;",
      garbageValue = "-1998422213"
   )
   @Export("getModel")
   protected final Model getModel() {
      if (this.appearance == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? Coord.SequenceDefinition_get(super.sequence) : null;
         SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.movementSequence == super.idleSequence && var1 != null ? null : Coord.SequenceDefinition_get(super.movementSequence);
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
               var5 = DevicePcmPlayerProvider.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
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
                  var5.offsetBy(this.field891 - super.x, this.baseTileHeight - this.tileHeight, this.field893 - super.y);
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

                  var5.offsetBy(super.x - this.field891, this.tileHeight - this.baseTileHeight, super.y - this.field893);
               }
            }

            var3.isSingleTile = true;
            if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
               var3.overrideHue = super.recolourHue;
               var3.overrideSaturation = super.recolourSaturation;
               var3.overrideLuminance = super.recolourLuminance;
               var3.overrideAmount = super.recolourAmount;
               var3.field2173 = (short)var4;
            } else {
               var3.overrideAmount = 0;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "86"
   )
   @Export("isFriend")
   boolean isFriend() {
      if (this.isFriendTriBool == TriBool.TriBool_unknown) {
         this.checkIsFriend();
      }

      return this.isFriendTriBool == TriBool.TriBool_true;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "95"
   )
   @Export("clearIsFriend")
   void clearIsFriend() {
      this.isFriendTriBool = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "2"
   )
   @Export("checkIsFriend")
   void checkIsFriend() {
      this.isFriendTriBool = class6.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-124834401"
   )
   @Export("isFriendsChatMember")
   boolean isFriendsChatMember() {
      if (this.isInFriendsChat == TriBool.TriBool_unknown) {
         this.updateIsInFriendsChat();
      }

      return this.isInFriendsChat == TriBool.TriBool_true;
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1990954496"
   )
   @Export("clearIsInFriendsChat")
   void clearIsInFriendsChat() {
      this.isInFriendsChat = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "935675147"
   )
   @Export("updateIsInFriendsChat")
   void updateIsInFriendsChat() {
      this.isInFriendsChat = ReflectionCheck.friendsChat != null && ReflectionCheck.friendsChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(S)V",
      garbageValue = "16307"
   )
   @Export("updateIsInClanChat")
   void updateIsInClanChat() {
      for(int var1 = 0; var1 < 4; ++var1) {
         if (Client.currentClanSettings[var1] != null && Client.currentClanSettings[var1].method809(this.username.getName()) != -1 && var1 != 2) {
            this.isInClanChat = TriBool.TriBool_true;
            return;
         }
      }

      this.isInClanChat = TriBool.TriBool_false;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1603914179"
   )
   @Export("clearIsInClanChat")
   void clearIsInClanChat() {
      this.isInClanChat = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1596852971"
   )
   @Export("isClanMember")
   boolean isClanMember() {
      if (this.isInClanChat == TriBool.TriBool_unknown) {
         this.updateIsInClanChat();
      }

      return this.isInClanChat == TriBool.TriBool_true;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "89"
   )
   @Export("transformedSize")
   int transformedSize() {
      return this.appearance != null && this.appearance.npcTransformId != -1 ? class188.getNpcDefinition(this.appearance.npcTransformId).size : 1;
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "(IILis;I)V",
      garbageValue = "467719152"
   )
   @Export("move")
   final void move(int var1, int var2, MoveSpeed var3) {
      if (super.sequence != -1 && Coord.SequenceDefinition_get(super.sequence).priority == 1) {
         super.sequence = -1;
      }

      this.method507();
      if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if (var3 == MoveSpeed.RUN) {
               class269.method1516(this, var1, var2, MoveSpeed.RUN);
            }

            this.method491(var1, var2, var3);
         } else {
            this.resetPath(var1, var2);
         }
      } else {
         this.resetPath(var1, var2);
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "-90"
   )
   @Export("resetPath")
   void resetPath(int var1, int var2) {
      super.pathLength = 0;
      super.field1004 = 0;
      super.field1003 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.transformedSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = super.pathY[0] * 128 + var3 * 64;
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(IILis;S)V",
      garbageValue = "-3935"
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

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1187706422"
   )
   @Export("isVisible")
   final boolean isVisible() {
      return this.appearance != null;
   }

   @ObfuscatedName("gf")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1116085058"
   )
   @Export("forceDisconnect")
   static final void forceDisconnect(int var0) {
      class278.logOut();
      switch(var0) {
      case 1:
         class14.method52(24);
         Tile.setLoginResponseString("", "You were disconnected from the server.", "");
         break;
      case 2:
         class14.method52(24);
         Tile.setLoginResponseString("The game servers are currently being updated.", "Please wait a few minutes and try again.", "");
      }

   }

   @ObfuscatedName("kq")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Lmy;I)Ljava/lang/String;",
      garbageValue = "-1754511416"
   )
   static String method497(String var0, Widget var1) {
      if (var0.indexOf("%") != -1) {
         for(int var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var3 = var0.indexOf("%" + var2);
               if (var3 == -1) {
                  break;
               }

               String var4 = var0.substring(0, var3);
               int var6 = Language.method1895(var1, var2 - 1);
               String var5;
               if (var6 < 999999999) {
                  var5 = Integer.toString(var6);
               } else {
                  var5 = "*";
               }

               var0 = var4 + var5 + var0.substring(var3 + 2);
            }
         }
      }

      return var0;
   }
}
