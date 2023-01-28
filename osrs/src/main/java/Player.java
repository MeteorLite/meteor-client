import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
@Implements("Player")
public final class Player extends Actor {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   Username username;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lko;"
   )
   PlayerComposition appearance;
   @ObfuscatedName("v")
   int headIconPk = -1;
   @ObfuscatedName("x")
   int headIconPrayer = -1;
   @ObfuscatedName("q")
   String[] actions = new String[3];
   @ObfuscatedName("f")
   int combatLevel;
   @ObfuscatedName("r")
   int skillLevel;
   @ObfuscatedName("u")
   int tileHeight;
   @ObfuscatedName("b")
   int animationCycleStart;
   @ObfuscatedName("j")
   int animationCycleEnd;
   @ObfuscatedName("g")
   int field892;
   @ObfuscatedName("i")
   int baseTileHeight;
   @ObfuscatedName("o")
   int field898;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lhh;"
   )
   Model attachedModel;
   @ObfuscatedName("k")
   int minX;
   @ObfuscatedName("a")
   int minY;
   @ObfuscatedName("s")
   int maxX;
   @ObfuscatedName("l")
   int maxY;
   @ObfuscatedName("t")
   boolean isUnanimated;
   @ObfuscatedName("c")
   int team;
   @ObfuscatedName("p")
   boolean isHidden;
   @ObfuscatedName("d")
   int plane;
   @ObfuscatedName("y")
   int index;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Loh;"
   )
   TriBool isFriendTriBool;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Loh;"
   )
   TriBool isInFriendsChat;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Loh;"
   )
   TriBool isInClanChat;
   @ObfuscatedName("ad")
   boolean hasMovementPending;
   @ObfuscatedName("ao")
   int tileX;
   @ObfuscatedName("am")
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;B)V",
      garbageValue = "-126"
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
               var9 = NPCComposition.ItemDefinition_get(var5[var6] - 512).team;
               if (var9 != 0) {
                  this.team = var9;
               }
            }
         }
      }

      int[] var25 = new int[5];

      for(var7 = 0; var7 < 5; ++var7) {
         var8 = var1.readUnsignedByte();
         if (var8 < 0 || var8 >= TriBool.field3706[var7].length) {
            var8 = 0;
         }

         var25[var7] = var8;
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

      this.username = new Username(var1.readStringCp1252NullTerminated(), SecureRandomFuture.loginType);
      this.clearIsFriend();
      this.clearIsInFriendsChat();
      this.clearIsInClanChat();
      if (this == class155.localPlayer) {
         RunException.localPlayerName = this.username.getName();
      }

      this.combatLevel = var1.readUnsignedByte();
      this.skillLevel = var1.readUnsignedShort();
      this.isHidden = var1.readUnsignedByte() == 1;
      if (Client.gameBuild == 0 && Client.staffModLevel >= 2) {
         this.isHidden = false;
      }

      ObjTypeCustomisation[] var26 = null;
      boolean var27 = false;
      var9 = var1.readUnsignedShort();
      var27 = (var9 >> 15 & 1) == 1;
      int var10;
      if (var9 > 0 && var9 != 32768) {
         var26 = new ObjTypeCustomisation[12];

         for(var10 = 0; var10 < 12; ++var10) {
            int var11 = var9 >> 12 - var10 & 1;
            if (var11 == 1) {
               int var15 = var5[var10] - 512;
               int var16 = var1.readUnsignedByte();
               boolean var17 = (var16 & 1) != 0;
               boolean var18 = (var16 & 2) != 0;
               ObjTypeCustomisation var19 = new ObjTypeCustomisation(var15);
               int var20;
               int[] var21;
               boolean var22;
               int var23;
               short var24;
               if (var17) {
                  var20 = var1.readUnsignedByte();
                  var21 = new int[]{var20 & 15, var20 >> 4 & 15};
                  var22 = var19.recol != null && var21.length == var19.recol.length;

                  for(var23 = 0; var23 < 2; ++var23) {
                     if (var21[var23] != 15) {
                        var24 = (short)var1.readUnsignedShort();
                        if (var22) {
                           var19.recol[var21[var23]] = var24;
                        }
                     }
                  }
               }

               if (var18) {
                  var20 = var1.readUnsignedByte();
                  var21 = new int[]{var20 & 15, var20 >> 4 & 15};
                  var22 = var19.retex != null && var21.length == var19.retex.length;

                  for(var23 = 0; var23 < 2; ++var23) {
                     if (var21[var23] != 15) {
                        var24 = (short)var1.readUnsignedShort();
                        if (var22) {
                           var19.retex[var21[var23]] = var24;
                        }
                     }
                  }
               }

               var26[var10] = var19;
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

      this.appearance.setAppearance(var5, var26, var27, var25, var2, var4, var3);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(I)Lhh;",
      garbageValue = "-1279733976"
   )
   protected final Model getModel() {
      if (this.appearance == null) {
         return null;
      } else {
         SequenceDefinition var1 = super.sequence != -1 && super.sequenceDelay == 0 ? AABB.SequenceDefinition_get(super.sequence) : null;
         SequenceDefinition var2 = super.movementSequence == -1 || this.isUnanimated || super.idleSequence == super.movementSequence && var1 != null ? null : AABB.SequenceDefinition_get(super.movementSequence);
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
               var5 = ClanSettings.SpotAnimationDefinition_get(super.spotAnimation).getModel(super.spotAnimationFrame);
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
                  var5.offsetBy(this.field892 - super.x, this.baseTileHeight - this.tileHeight, this.field898 - super.y);
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

                  var5.offsetBy(super.x - this.field892, this.tileHeight - this.baseTileHeight, super.y - this.field898);
               }
            }

            var3.isSingleTile = true;
            if (super.recolourAmount != 0 && Client.cycle >= super.recolourStartCycle && Client.cycle < super.recolourEndCycle) {
               var3.overrideHue = super.recolourHue;
               var3.overrideSaturation = super.recolourSaturation;
               var3.overrideLuminance = super.recolourLuminance;
               var3.overrideAmount = super.recolourAmount;
               var3.field2180 = (short)var4;
            } else {
               var3.overrideAmount = 0;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1926444781"
   )
   boolean isFriend() {
      if (this.isFriendTriBool == TriBool.TriBool_unknown) {
         this.checkIsFriend();
      }

      return this.isFriendTriBool == TriBool.TriBool_true;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2039939693"
   )
   void clearIsFriend() {
      this.isFriendTriBool = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1595665678"
   )
   void checkIsFriend() {
      this.isFriendTriBool = DefaultsGroup.friendSystem.isFriendAndHasWorld(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2081819034"
   )
   boolean isFriendsChatMember() {
      if (this.isInFriendsChat == TriBool.TriBool_unknown) {
         this.updateIsInFriendsChat();
      }

      return this.isInFriendsChat == TriBool.TriBool_true;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-569605526"
   )
   void clearIsInFriendsChat() {
      this.isInFriendsChat = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-347308341"
   )
   void updateIsInFriendsChat() {
      this.isInFriendsChat = class281.friendsChat != null && class281.friendsChat.contains(this.username) ? TriBool.TriBool_true : TriBool.TriBool_false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1510805877"
   )
   void updateIsInClanChat() {
      for(int var1 = 0; var1 < 4; ++var1) {
         if (Client.currentClanSettings[var1] != null && Client.currentClanSettings[var1].method778(this.username.getName()) != -1 && var1 != 2) {
            this.isInClanChat = TriBool.TriBool_true;
            return;
         }
      }

      this.isInClanChat = TriBool.TriBool_false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "4"
   )
   void clearIsInClanChat() {
      this.isInClanChat = TriBool.TriBool_unknown;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1874201876"
   )
   boolean isClanMember() {
      if (this.isInClanChat == TriBool.TriBool_unknown) {
         this.updateIsInClanChat();
      }

      return this.isInClanChat == TriBool.TriBool_true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-97"
   )
   int transformedSize() {
      return this.appearance != null && this.appearance.npcTransformId != -1 ? class129.getNpcDefinition(this.appearance.npcTransformId).size : 1;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(IILgs;B)V",
      garbageValue = "72"
   )
   final void move(int var1, int var2, MoveSpeed var3) {
      if (super.sequence != -1 && AABB.SequenceDefinition_get(super.sequence).priority == 1) {
         super.sequence = -1;
      }

      super.movingOrientation = -1;
      if (var1 >= 0 && var1 < 104 && var2 >= 0 && var2 < 104) {
         if (super.pathX[0] >= 0 && super.pathX[0] < 104 && super.pathY[0] >= 0 && super.pathY[0] < 104) {
            if (var3 == MoveSpeed.RUN) {
               Player var4 = this;
               MoveSpeed var5 = MoveSpeed.RUN;
               int var6 = super.pathX[0];
               int var7 = super.pathY[0];
               int var8 = this.transformedSize();
               if (var6 >= var8 && var6 < 104 - var8 && var7 >= var8 && var7 < 104 - var8 && var1 >= var8 && var1 < 104 - var8 && var2 >= var8 && var2 < 104 - var8) {
                  int var9 = Clock.method899(var6, var7, this.transformedSize(), FloorDecoration.method1134(var1, var2), Client.collisionMaps[this.plane], true, Client.field651, Client.field630);
                  if (var9 >= 1) {
                     for(int var10 = 0; var10 < var9 - 1; ++var10) {
                        var4.method497(Client.field651[var10], Client.field630[var10], var5);
                     }
                  }
               }
            }

            this.method497(var1, var2, var3);
         } else {
            this.resetPath(var1, var2);
         }
      } else {
         this.resetPath(var1, var2);
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "1"
   )
   void resetPath(int var1, int var2) {
      super.pathLength = 0;
      super.field1004 = 0;
      super.field991 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      int var3 = this.transformedSize();
      super.x = var3 * 64 + super.pathX[0] * 128;
      super.y = var3 * 64 + super.pathY[0] * 128;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(IILgs;I)V",
      garbageValue = "-1656318959"
   )
   final void method497(int var1, int var2, MoveSpeed var3) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2124571860"
   )
   final boolean isVisible() {
      return this.appearance != null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1940154294"
   )
   public static void method505(int var0) {
      MouseHandler.MouseHandler_idleCycles = var0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "127"
   )
   public static int iLog(int var0) {
      int var1 = 0;
      if (var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if (var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if (var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if (var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if (var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var0 + var1;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-113"
   )
   static void method503(String var0, String var1, String var2) {
      class12.setLoginIndex(7);
      TaskHandler.setLoginResponseString(var0, var1, var2);
   }

   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "1541200375"
   )
   static int method506(int var0, Script var1, boolean var2) {
      if (var0 == 7108) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = FloorUnderlayDefinition.method981() ? 1 : 0;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("gk")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2090346069"
   )
   static final void logOut() {
      Client.packetWriter.close();
      ModeWhere.method1868();
      ReflectionCheck.scene.clear();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].clear();
      }

      Client.field417.method1065();
      System.gc();
      class384.method2011(2);
      Client.currentTrackGroupId = -1;
      Client.playingJingle = false;
      UrlRequester.method644();
      class140.updateGameState(10);
   }

   @ObfuscatedName("ki")
   @ObfuscatedSignature(
      descriptor = "(Lkd;IIZI)V",
      garbageValue = "-1694823923"
   )
   static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
      int var4 = var0.width;
      int var5 = var0.height;
      if (var0.widthAlignment == 0) {
         var0.width = var0.rawWidth;
      } else if (var0.widthAlignment == 1) {
         var0.width = var1 - var0.rawWidth;
      } else if (var0.widthAlignment == 2) {
         var0.width = var0.rawWidth * var1 >> 14;
      }

      if (var0.heightAlignment == 0) {
         var0.height = var0.rawHeight;
      } else if (var0.heightAlignment == 1) {
         var0.height = var2 - var0.rawHeight;
      } else if (var0.heightAlignment == 2) {
         var0.height = var2 * var0.rawHeight >> 14;
      }

      if (var0.widthAlignment == 4) {
         var0.width = var0.height * var0.field2983 / var0.field2884;
      }

      if (var0.heightAlignment == 4) {
         var0.height = var0.field2884 * var0.width / var0.field2983;
      }

      if (var0.contentType == 1337) {
         Client.viewportWidget = var0;
      }

      if (var0.type == 12) {
         var0.method1724().method1639(var0.width, var0.height);
      }

      if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
         ScriptEvent var6 = new ScriptEvent();
         var6.widget = var0;
         var6.args = var0.onResize;
         Client.scriptEvents.addFirst(var6);
      }

   }

   @ObfuscatedName("mt")
   @ObfuscatedSignature(
      descriptor = "(Lkd;IIII)V",
      garbageValue = "1708267953"
   )
   static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
      Client.playPcmPlayers();
      SpriteMask var4 = var0.getSpriteMask(false);
      if (var4 != null) {
         Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
         if (Client.minimapState != 2 && Client.minimapState != 5) {
            int var5 = Client.camAngleY & 2047;
            int var6 = class155.localPlayer.x / 32 + 48;
            int var7 = 464 - class155.localPlayer.y / 32;
            GameObject.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.mapIconCount; ++var8) {
               var9 = Client.mapIconXs[var8] * 4 + 2 - class155.localPlayer.x / 32;
               var10 = Client.mapIconYs[var8] * 4 + 2 - class155.localPlayer.y / 32;
               class282.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  NodeDeque var14 = Client.groundItems[class383.Client_plane][var8][var9];
                  if (var14 != null) {
                     var11 = var8 * 4 + 2 - class155.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - class155.localPlayer.y / 32;
                     class282.drawSpriteOnMinimap(var1, var2, var11, var12, class281.mapDotSprites[0], var4);
                  }
               }
            }

            for(var8 = 0; var8 < Client.npcCount; ++var8) {
               NPC var15 = Client.npcs[Client.npcIndices[var8]];
               if (var15 != null && var15.isVisible()) {
                  NPCComposition var17 = var15.definition;
                  if (var17 != null && var17.transforms != null) {
                     var17 = var17.transform();
                  }

                  if (var17 != null && var17.drawMapDot && var17.isInteractable) {
                     var11 = var15.x / 32 - class155.localPlayer.x / 32;
                     var12 = var15.y / 32 - class155.localPlayer.y / 32;
                     class282.drawSpriteOnMinimap(var1, var2, var11, var12, class281.mapDotSprites[1], var4);
                  }
               }
            }

            var8 = Players.Players_count;
            int[] var18 = Players.Players_indices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var16 = Client.players[var18[var10]];
               if (var16 != null && var16.isVisible() && !var16.isHidden && var16 != class155.localPlayer) {
                  var12 = var16.x / 32 - class155.localPlayer.x / 32;
                  int var13 = var16.y / 32 - class155.localPlayer.y / 32;
                  if (var16.isFriend()) {
                     class282.drawSpriteOnMinimap(var1, var2, var12, var13, class281.mapDotSprites[3], var4);
                  } else if (class155.localPlayer.team != 0 && var16.team != 0 && var16.team == class155.localPlayer.team) {
                     class282.drawSpriteOnMinimap(var1, var2, var12, var13, class281.mapDotSprites[4], var4);
                  } else if (var16.isFriendsChatMember()) {
                     class282.drawSpriteOnMinimap(var1, var2, var12, var13, class281.mapDotSprites[5], var4);
                  } else if (var16.isClanMember()) {
                     class282.drawSpriteOnMinimap(var1, var2, var12, var13, class281.mapDotSprites[6], var4);
                  } else {
                     class282.drawSpriteOnMinimap(var1, var2, var12, var13, class281.mapDotSprites[2], var4);
                  }
               }
            }

            if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
               if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
                  NPC var19 = Client.npcs[Client.hintArrowNpcIndex];
                  if (var19 != null) {
                     var11 = var19.x / 32 - class155.localPlayer.x / 32;
                     var12 = var19.y / 32 - class155.localPlayer.y / 32;
                     GameEngine.worldToMinimap(var1, var2, var11, var12, class144.mapMarkerSprites[1], var4);
                  }
               }

               if (Client.hintArrowType == 2) {
                  var10 = Client.hintArrowX * 4 - class154.baseX * 4 + 2 - class155.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - class365.baseY * 4 + 2 - class155.localPlayer.y / 32;
                  GameEngine.worldToMinimap(var1, var2, var10, var11, class144.mapMarkerSprites[1], var4);
               }

               if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
                  Player var20 = Client.players[Client.hintArrowPlayerIndex];
                  if (var20 != null) {
                     var11 = var20.x / 32 - class155.localPlayer.x / 32;
                     var12 = var20.y / 32 - class155.localPlayer.y / 32;
                     GameEngine.worldToMinimap(var1, var2, var11, var12, class144.mapMarkerSprites[1], var4);
                  }
               }
            }

            if (Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - class155.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - class155.localPlayer.y / 32;
               class282.drawSpriteOnMinimap(var1, var2, var10, var11, class144.mapMarkerSprites[0], var4);
            }

            if (!class155.localPlayer.isHidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
         }

         Client.field577[var3] = true;
      }
   }
}
