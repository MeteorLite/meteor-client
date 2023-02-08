import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
@Implements("HitSplatDefinition")
public class HitSplatDefinition extends DualNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   public static AbstractArchive field1649;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lln;"
    )
    public static AbstractArchive HitSplatDefinition_fontsArchive;
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    public static EvictingDualNodeHashTable HitSplatDefinition_cached = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    public static EvictingDualNodeHashTable HitSplatDefinition_cachedSprites = new EvictingDualNodeHashTable(64);
    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "Lja;"
    )
    public static EvictingDualNodeHashTable HitSplatDefinition_cachedFonts = new EvictingDualNodeHashTable(20);
    @ObfuscatedName("r")
    int fontId = -1;
    @ObfuscatedName("b")
    public int textColor = 16777215;
   @ObfuscatedName("m")
   public int field1655 = 70;
   @ObfuscatedName("t")
   int field1650 = -1;
   @ObfuscatedName("h")
   int field1642 = -1;
   @ObfuscatedName("p")
   int field1652 = -1;
   @ObfuscatedName("o")
   int field1644 = -1;
   @ObfuscatedName("u")
   public int field1654 = 0;
   @ObfuscatedName("x")
   public int field1661 = 0;
   @ObfuscatedName("a")
   public int field1656 = -1;
   @ObfuscatedName("q")
   String field1657 = "";
   @ObfuscatedName("d")
   public int field1658 = -1;
   @ObfuscatedName("e")
   public int field1659 = 0;
    @ObfuscatedName("g")
    public int[] transforms;
    @ObfuscatedName("y")
    int transformVarbit = -1;
    @ObfuscatedName("af")
    int transformVarp = -1;

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Lrd;B)V",
            garbageValue = "-76"
    )
    void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(Lrd;II)V",
            garbageValue = "-1689532457"
    )
    void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.fontId = var1.method2419();
      } else if (var2 == 2) {
         this.textColor = var1.readMedium();
      } else if (var2 == 3) {
         this.field1650 = var1.method2419();
      } else if (var2 == 4) {
         this.field1652 = var1.method2419();
      } else if (var2 == 5) {
         this.field1642 = var1.method2419();
      } else if (var2 == 6) {
         this.field1644 = var1.method2419();
      } else if (var2 == 7) {
         this.field1654 = var1.readShort();
      } else if (var2 == 8) {
         this.field1657 = var1.readStringCp1252NullCircumfixed();
      } else if (var2 == 9) {
         this.field1655 = var1.readUnsignedShort();
      } else if (var2 == 10) {
         this.field1661 = var1.readShort();
      } else if (var2 == 11) {
         this.field1656 = 0;
      } else if (var2 == 12) {
         this.field1658 = var1.readUnsignedByte();
      } else if (var2 == 13) {
         this.field1659 = var1.readShort();
      } else if (var2 == 14) {
         this.field1656 = var1.readUnsignedShort();
      } else if (var2 == 17 || var2 == 18) {
         this.transformVarbit = var1.readUnsignedShort();
         if (this.transformVarbit == 65535) {
            this.transformVarbit = -1;
         }

         this.transformVarp = var1.readUnsignedShort();
         if (this.transformVarp == 65535) {
            this.transformVarp = -1;
         }

         int var3 = -1;
         if (var2 == 18) {
            var3 = var1.readUnsignedShort();
            if (var3 == 65535) {
               var3 = -1;
            }
         }

         int var4 = var1.readUnsignedByte();
         this.transforms = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.transforms[var5] = var1.readUnsignedShort();
            if (this.transforms[var5] == 65535) {
               this.transforms[var5] = -1;
            }
         }

         this.transforms[var4 + 1] = var3;
      }

   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(B)Lgb;",
            garbageValue = "-50"
    )
    public final HitSplatDefinition transform() {
      int var1 = -1;
      if (this.transformVarbit != -1) {
         var1 = SecureRandomFuture.getVarbit(this.transformVarbit);
      } else if (this.transformVarp != -1) {
         var1 = Varps.Varps_main[this.transformVarp];
      }

      int var2;
      if (var1 >= 0 && var1 < this.transforms.length - 1) {
         var2 = this.transforms[var1];
      } else {
         var2 = this.transforms[this.transforms.length - 1];
      }

      return var2 != -1 ? ChatChannel.method446(var2) : null;
   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(II)Ljava/lang/String;",
            garbageValue = "-690048949"
    )
    public String getString(int var1) {
      String var2 = this.field1657;

      while(true) {
         int var3 = var2.indexOf("%1");
         if (var3 < 0) {
            return var2;
         }

         var2 = var2.substring(0, var3) + ParamComposition.intToString(var1, false) + var2.substring(var3 + 2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)Lrs;",
      garbageValue = "1965935121"
   )
   public SpritePixels method1007() {
      if (this.field1650 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1650);
         if (var1 != null) {
            return var1;
         } else {
            var1 = BZip2State.SpriteBuffer_getSprite(field1649, this.field1650, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1650);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(I)Lrs;",
      garbageValue = "-28423300"
   )
   public SpritePixels method1009() {
      if (this.field1642 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1642);
         if (var1 != null) {
            return var1;
         } else {
            var1 = BZip2State.SpriteBuffer_getSprite(field1649, this.field1642, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1642);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(S)Lrs;",
      garbageValue = "-13683"
   )
   public SpritePixels method1011() {
      if (this.field1652 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1652);
         if (var1 != null) {
            return var1;
         } else {
            var1 = BZip2State.SpriteBuffer_getSprite(field1649, this.field1652, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1652);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(I)Lrs;",
      garbageValue = "1628743674"
   )
   public SpritePixels method1006() {
      if (this.field1644 < 0) {
         return null;
      } else {
         SpritePixels var1 = (SpritePixels)HitSplatDefinition_cachedSprites.get((long)this.field1644);
         if (var1 != null) {
            return var1;
         } else {
            var1 = BZip2State.SpriteBuffer_getSprite(field1649, this.field1644, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedSprites.put(var1, (long)this.field1644);
            }

            return var1;
         }
      }
   }

    @ObfuscatedName("k")
    @ObfuscatedSignature(
            descriptor = "(S)Lnv;",
            garbageValue = "-3862"
    )
    public Font getFont() {
      if (this.fontId == -1) {
         return null;
      } else {
         Font var1 = (Font)HitSplatDefinition_cachedFonts.get((long)this.fontId);
         if (var1 != null) {
            return var1;
         } else {
            var1 = class33.method129(field1649, HitSplatDefinition_fontsArchive, this.fontId, 0);
            if (var1 != null) {
               HitSplatDefinition_cachedFonts.put(var1, (long)this.fontId);
            }

            return var1;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "(Lru;ILcl;IB)V",
      garbageValue = "-77"
   )
   static final void method1013(PacketBuffer var0, int var1, Player var2, int var3) {
      byte var4 = MoveSpeed.STATIONARY.speed;
      if ((var3 & 1024) != 0) {
         var2.recolourStartCycle = Client.cycle + var0.readUnsignedShortLEA();
         var2.recolourEndCycle = Client.cycle + var0.readUnsignedByteS();
         var2.recolourHue = var0.method2431();
         var2.recolourSaturation = var0.method2404();
         var2.recolourLuminance = var0.method2442();
         var2.recolourAmount = (byte)var0.readUnsignedByteA();
      }

      int var5;
      if ((var3 & 4) != 0) {
         var5 = var0.method2401();
         byte[] var6 = new byte[var5];
         Buffer var7 = new Buffer(var6);
         var0.readBytesAReverse(var6, 0, var5);
         Players.cachedAppearanceBuffer[var1] = var7;
         var2.read(var7);
      }

      int var8;
      int var9;
      int var12;
      if ((var3 & 8) != 0) {
         var5 = var0.readUnsignedShortLEA();
         PlayerType var17 = (PlayerType)class4.findEnumerated(ArchiveLoader.PlayerType_values(), var0.readUnsignedShortA());
         boolean var13 = var0.readUnsignedByteA() == 1;
         var8 = var0.readUnsignedByteA();
         var9 = var0.offset;
         if (var2.username != null && var2.appearance != null) {
            boolean var10 = false;
            if (var17.isUser && WorldMapElement.friendSystem.isIgnored(var2.username)) {
               var10 = true;
            }

            if (!var10 && Client.field494 == 0 && !var2.isHidden) {
               Players.field1091.offset = 0;
               var0.readBytes(Players.field1091.array, 0, var8);
               Players.field1091.offset = 0;
               String var11 = AbstractFont.escapeBrackets(ParamComposition.method994(class163.readString(Players.field1091)));
               var2.overheadText = var11.trim();
               var2.field937 = var5 >> 8;
               var2.field961 = var5 & 255;
               var2.overheadTextCyclesRemaining = 150;
               var2.isAutoChatting = var13;
               var2.showPublicPlayerChat = var2 != class387.localPlayer && var17.isUser && "" != Client.field604 && var11.toLowerCase().indexOf(Client.field604) == -1;
               if (var17.isPrivileged) {
                  var12 = var13 ? 91 : 1;
               } else {
                  var12 = var13 ? 90 : 2;
               }

               if (var17.modIcon != -1) {
                  ZoneOperation.addGameMessage(var12, ObjectSound.addImageTag(var17.modIcon) + var2.username.getName(), var11);
               } else {
                  ZoneOperation.addGameMessage(var12, var2.username.getName(), var11);
               }
            }
         }

         var0.offset = var8 + var9;
      }

      if ((var3 & 16384) != 0) {
         MoveSpeed[] var14 = Players.playerMovementSpeeds;
         MoveSpeed[] var19 = new MoveSpeed[]{MoveSpeed.WALK, MoveSpeed.STATIONARY, MoveSpeed.RUN, MoveSpeed.CRAWL};
         var14[var1] = (MoveSpeed)class4.findEnumerated(var19, var0.method2404());
      }

      if ((var3 & 4096) != 0) {
         for(var5 = 0; var5 < 3; ++var5) {
            var2.actions[var5] = var0.readStringCp1252NullTerminated();
         }
      }

      if ((var3 & 128) != 0) {
         var2.movingOrientation = var0.readUnsignedShort();
         if (var2.pathLength == 0) {
            var2.orientation = var2.movingOrientation;
            var2.movingOrientation = -1;
         }
      }

      if ((var3 & 2048) != 0) {
         var2.spotAnimation = var0.readUnsignedShortLE();
         var5 = var0.readInt();
         var2.spotAnimHeight = var5 >> 16;
         var2.spotAnimationStartCycle = (var5 & '\uffff') + Client.cycle;
         var2.spotAnimationFrame = 0;
         var2.spotAnimFrameCycle = 0;
         if (var2.spotAnimationStartCycle > Client.cycle) {
            var2.spotAnimationFrame = -1;
         }

         if (var2.spotAnimation == 65535) {
            var2.spotAnimation = -1;
         }
      }

      if ((var3 & 1) != 0) {
         var2.overheadText = var0.readStringCp1252NullTerminated();
         if (var2.overheadText.charAt(0) == '~') {
            var2.overheadText = var2.overheadText.substring(1);
            ZoneOperation.addGameMessage(2, var2.username.getName(), var2.overheadText);
         } else if (var2 == class387.localPlayer) {
            ZoneOperation.addGameMessage(2, var2.username.getName(), var2.overheadText);
         }

         var2.isAutoChatting = false;
         var2.field937 = 0;
         var2.field961 = 0;
         var2.overheadTextCyclesRemaining = 150;
      }

      int var15;
      if ((var3 & 2) != 0) {
         var5 = var0.readUnsignedShortLE();
         if (var5 == 65535) {
            var5 = -1;
         }

         var15 = var0.readUnsignedByteA();
         PendingSpawn.performPlayerAnimation(var2, var5, var15);
      }

      if ((var3 & 32) != 0) {
         var5 = var0.method2401();
         int var16;
         int var20;
         int var21;
         if (var5 > 0) {
            for(var15 = 0; var15 < var5; ++var15) {
               var8 = -1;
               var9 = -1;
               var20 = -1;
               var21 = var0.readUShortSmart();
               if (var21 == 32767) {
                  var21 = var0.readUShortSmart();
                  var9 = var0.readUShortSmart();
                  var8 = var0.readUShortSmart();
                  var20 = var0.readUShortSmart();
               } else if (var21 != 32766) {
                  var9 = var0.readUShortSmart();
               } else {
                  var21 = -1;
               }

               var16 = var0.readUShortSmart();
               var2.addHitSplat(var21, var9, var8, var20, Client.cycle, var16);
            }
         }

         var15 = var0.readUnsignedByteA();
         if (var15 > 0) {
            for(var21 = 0; var21 < var15; ++var21) {
               var8 = var0.readUShortSmart();
               var9 = var0.readUShortSmart();
               if (var9 != 32767) {
                  var20 = var0.readUShortSmart();
                  var16 = var0.method2401();
                  var12 = var9 > 0 ? var0.method2401() : var16;
                  var2.addHealthBar(var8, Client.cycle, var9, var20, var16, var12);
               } else {
                  var2.removeHealthBar(var8);
               }
            }
         }
      }

      if ((var3 & 256) != 0) {
         var2.exactMoveDeltaX1 = var0.readByte();
         var2.exactMoveDeltaY1 = var0.method2442();
         var2.exactMoveDeltaX2 = var0.method2431();
         var2.exactMoveDeltaY2 = var0.method2404();
         var2.exactMoveArrive1Cycle = var0.readUnsignedShortLEA() + Client.cycle;
         var2.exactMoveArrive2Cycle = var0.readUnsignedShortLE() + Client.cycle;
         var2.exactMoveDirection = var0.readUnsignedShortLE();
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

         var2.field1006 = 0;
      }

      if ((var3 & 512) != 0) {
         var4 = var0.method2442();
      }

      if ((var3 & 16) != 0) {
         var2.targetIndex = var0.readUnsignedShortLEA();
         if (class323.isLargePlayerInfo) {
            var2.targetIndex += var0.readUnsignedByte() << 16;
            var5 = 16777215;
         } else {
            var5 = 65535;
         }

         if (var2.targetIndex == var5) {
            var2.targetIndex = -1;
         }
      }

      if (var2.hasMovementPending) {
         if (var4 == 127) {
            var2.resetPath(var2.tileX, var2.tileY);
         } else {
            MoveSpeed var22;
            if (var4 != MoveSpeed.STATIONARY.speed) {
               MoveSpeed[] var18 = new MoveSpeed[]{MoveSpeed.WALK, MoveSpeed.STATIONARY, MoveSpeed.RUN, MoveSpeed.CRAWL};
               var22 = (MoveSpeed)class4.findEnumerated(var18, var4);
            } else {
               var22 = Players.playerMovementSpeeds[var1];
            }

            var2.move(var2.tileX, var2.tileY, var22);
         }
      }

   }
}
