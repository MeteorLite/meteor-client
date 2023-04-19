import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bz")
public class class33 {
    @ObfuscatedName("lg")
    static int oculusOrbFocalPointX;
   @ObfuscatedName("aq")
   int field97;
   @ObfuscatedName("al")
   int field98;

   class33(int var1, int var2) {
      this.field97 = var1;
      this.field98 = var2;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lbe;I)Z",
      garbageValue = "2098097689"
   )
   boolean method142(class29 var1) {
      if (var1 == null) {
         return false;
      } else {
         switch(this.field97) {
         case 1:
            return var1.vmethod3949(this.field98);
         case 2:
            return var1.vmethod3989(this.field98);
         case 3:
            return var1.vmethod3951((char)this.field98);
         case 4:
            return var1.vmethod3953(this.field98 == 1);
         default:
            return false;
         }
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)[Llf;",
      garbageValue = "0"
   )
   static LoginPacket[] method145() {
      return new LoginPacket[]{LoginPacket.RECONNECT_LOGIN_CONNECTION, LoginPacket.field2704, LoginPacket.field2701, LoginPacket.NEW_LOGIN_CONNECTION, LoginPacket.field2705, LoginPacket.field2700};
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;Lnm;I)Z",
      garbageValue = "2112098628"
   )
   public static boolean method150(AbstractArchive var0, AbstractArchive var1) {
      WorldMapElement.WorldMapElement_archive = var1;
      if (!var0.isFullyLoaded()) {
         return false;
      } else {
         class328.WorldMapElement_count = var0.getGroupFileCount(35);
         WorldMapElement.WorldMapElement_cached = new WorldMapElement[class328.WorldMapElement_count];

         for(int var2 = 0; var2 < class328.WorldMapElement_count; ++var2) {
            byte[] var3 = var0.takeFile(35, var2);
            WorldMapElement.WorldMapElement_cached[var2] = new WorldMapElement(var2);
            if (var3 != null) {
               WorldMapElement.WorldMapElement_cached[var2].decode(new Buffer(var3));
               WorldMapElement.WorldMapElement_cached[var2].method985();
            }
         }

         return true;
      }
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(II)Lho;",
            garbageValue = "367699395"
    )
    public static ParamComposition getParamDefinition(int var0) {
      ParamComposition var1 = (ParamComposition)ParamComposition.ParamDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = ParamComposition.ParamDefinition_archive.takeFile(11, var0);
         var1 = new ParamComposition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         ParamComposition.ParamDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "-101"
   )
   static int method152(int var0, Script var1, boolean var2) {
      if (var0 < 1000) {
         return LoginScreenAnimation.method553(var0, var1, var2);
      } else if (var0 < 1100) {
         return class131.method766(var0, var1, var2);
      } else if (var0 < 1200) {
         return class31.method135(var0, var1, var2);
      } else if (var0 < 1300) {
         return Varcs.method654(var0, var1, var2);
      } else if (var0 < 1400) {
         return StructComposition.method1070(var0, var1, var2);
      } else if (var0 < 1500) {
         return class121.method719(var0, var1, var2);
      } else if (var0 < 1600) {
         return class244.method1391(var0, var1, var2);
      } else if (var0 < 1700) {
         return AbstractUserComparator.method2166(var0, var1, var2);
      } else if (var0 < 1800) {
         return DefaultsGroup.method2226(var0, var1, var2);
      } else if (var0 < 1900) {
         return Rasterizer3D.method1216(var0, var1, var2);
      } else if (var0 < 2000) {
         return class13.method48(var0, var1, var2);
      } else if (var0 < 2100) {
         return class131.method766(var0, var1, var2);
      } else if (var0 < 2200) {
         return class31.method135(var0, var1, var2);
      } else if (var0 < 2300) {
         return Varcs.method654(var0, var1, var2);
      } else if (var0 < 2400) {
         return StructComposition.method1070(var0, var1, var2);
      } else if (var0 < 2500) {
         return class121.method719(var0, var1, var2);
      } else if (var0 < 2600) {
         return class31.method134(var0, var1, var2);
      } else if (var0 < 2700) {
         return MouseHandler.method194(var0, var1, var2);
      } else if (var0 < 2800) {
         return SceneTilePaint.method1347(var0, var1, var2);
      } else if (var0 < 2900) {
         return method147(var0, var1, var2);
      } else if (var0 < 3000) {
         return class13.method48(var0, var1, var2);
      } else if (var0 < 3200) {
         return NetFileRequest.method1877(var0, var1, var2);
      } else if (var0 < 3300) {
         return ObjectComposition.method1094(var0, var1, var2);
      } else if (var0 < 3400) {
         return class130.method765(var0, var1, var2);
      } else if (var0 < 3500) {
         return class380.method2045(var0, var1, var2);
      } else if (var0 < 3600) {
         return HitSplatDefinition.method1081(var0, var1, var2);
      } else if (var0 < 3700) {
         return WorldMapAreaData.method1556(var0, var1, var2);
      } else if (var0 < 3800) {
         return FloorOverlayDefinition.method1121(var0, var1, var2);
      } else if (var0 < 3900) {
         return class478.method2436(var0, var1, var2);
      } else if (var0 < 4000) {
         return class18.method69(var0, var1, var2);
      } else if (var0 < 4100) {
         return UserComparator3.method700(var0, var1, var2);
      } else if (var0 < 4200) {
         return ApproximateRouteStrategy.method361(var0, var1, var2);
      } else if (var0 < 4300) {
         return MusicPatchPcmStream.method1665(var0, var1, var2);
      } else if (var0 < 5100) {
         return UserComparator6.method714(var0, var1, var2);
      } else if (var0 < 5400) {
         return UserComparator4.method683(var0, var1, var2);
      } else if (var0 < 5600) {
         return TaskHandler.method949(var0, var1, var2);
      } else if (var0 < 5700) {
         return Client.method368(var0, var1, var2);
      } else if (var0 < 6300) {
         return class327.method1843(var0, var1, var2);
      } else if (var0 < 6600) {
         return WorldMapArea.method1431(var0, var1, var2);
      } else if (var0 < 6700) {
         return MouseRecorder.method496(var0, var1, var2);
      } else if (var0 < 6800) {
         return class282.method1590(var0, var1, var2);
      } else if (var0 < 6900) {
         return NetFileRequest.method1878(var0, var1, var2);
      } else if (var0 < 7000) {
         return UserComparator7.method694(var0, var1, var2);
      } else if (var0 < 7100) {
         return SoundSystem.method247(var0, var1, var2);
      } else if (var0 < 7200) {
         return class163.method916(var0, var1, var2);
      } else if (var0 < 7300) {
         return class16.method60(var0, var1, var2);
      } else if (var0 < 7500) {
         return class126.method754(var0, var1, var2);
      } else if (var0 < 7600) {
         return class144.method821(var0, var1, var2);
      } else {
         return var0 < 7700 ? FriendSystem.method425(var0, var1, var2) : 2;
      }
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;I)Ljava/lang/Class;",
            garbageValue = "1290821012"
    )
    static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      if (var0.equals("B")) {
         return Byte.TYPE;
      } else if (var0.equals("I")) {
         return Integer.TYPE;
      } else if (var0.equals("S")) {
         return Short.TYPE;
      } else if (var0.equals("J")) {
         return Long.TYPE;
      } else if (var0.equals("Z")) {
         return Boolean.TYPE;
      } else if (var0.equals("F")) {
         return Float.TYPE;
      } else if (var0.equals("D")) {
         return Double.TYPE;
      } else if (var0.equals("C")) {
         return Character.TYPE;
      } else {
         return var0.equals("void") ? Void.TYPE : Reflection.findClass(var0);
      }
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "([BB)Lch;",
            garbageValue = "1"
    )
    static Script newScript(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.array.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.array.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intArgumentCount = var2.readUnsignedShort();
      var1.stringArgumentCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if (var6 > 0) {
         var1.switches = var1.newIterableNodeHashTable(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            IterableNodeHashTable var9 = new IterableNodeHashTable(var8 > 0 ? class70.method442(var8) : 1);
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.put(new IntegerNode(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var1.field794 = var2.readStringCp1252NullTerminatedOrNull();
      var1.opcodes = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.opcodes[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if (var8 == 3) {
            var1.stringOperands[var7] = var2.readStringCp1252NullTerminated();
         } else if (var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2064360869"
   )
   static final void method143() {
      VerticalAlignment.method1036("You can't add yourself to your own friend list");
   }

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(Lbm;I)V",
      garbageValue = "626811319"
   )
   static void method151(GameEngine var0) {
      class207 var1 = Client.keyHandlerInstance;
      class207 var2 = var1;

      while(var2.method1154()) {
         if (var2.field1867 == 13) {
            class138.method800();
            return;
         }

         if (var2.field1867 == 96) {
            if (Login.worldSelectPage > 0 && PlayerType.worldSelectLeftSprite != null) {
               --Login.worldSelectPage;
            }
         } else if (var2.field1867 == 97 && Login.worldSelectPage < Login.worldSelectPagesCount && class13.worldSelectRightSprite != null) {
            ++Login.worldSelectPage;
         }
      }

      if (MouseHandler.MouseHandler_lastButton == 1 || !class473.mouseCam && MouseHandler.MouseHandler_lastButton == 4) {
         int var3 = Login.xPadding + 280;
         if (MouseHandler.MouseHandler_lastPressedX >= var3 && MouseHandler.MouseHandler_lastPressedX <= var3 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
            FillMode.changeWorldSelectSorting(0, 0);
            return;
         }

         if (MouseHandler.MouseHandler_lastPressedX >= var3 + 15 && MouseHandler.MouseHandler_lastPressedX <= var3 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
            FillMode.changeWorldSelectSorting(0, 1);
            return;
         }

         int var4 = Login.xPadding + 390;
         if (MouseHandler.MouseHandler_lastPressedX >= var4 && MouseHandler.MouseHandler_lastPressedX <= var4 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
            FillMode.changeWorldSelectSorting(1, 0);
            return;
         }

         if (MouseHandler.MouseHandler_lastPressedX >= var4 + 15 && MouseHandler.MouseHandler_lastPressedX <= var4 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
            FillMode.changeWorldSelectSorting(1, 1);
            return;
         }

         int var5 = Login.xPadding + 500;
         if (MouseHandler.MouseHandler_lastPressedX >= var5 && MouseHandler.MouseHandler_lastPressedX <= var5 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
            FillMode.changeWorldSelectSorting(2, 0);
            return;
         }

         if (MouseHandler.MouseHandler_lastPressedX >= var5 + 15 && MouseHandler.MouseHandler_lastPressedX <= var5 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
            FillMode.changeWorldSelectSorting(2, 1);
            return;
         }

         int var6 = Login.xPadding + 610;
         if (MouseHandler.MouseHandler_lastPressedX >= var6 && MouseHandler.MouseHandler_lastPressedX <= var6 + 14 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
            FillMode.changeWorldSelectSorting(3, 0);
            return;
         }

         if (MouseHandler.MouseHandler_lastPressedX >= var6 + 15 && MouseHandler.MouseHandler_lastPressedX <= var6 + 80 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedY <= 18) {
            FillMode.changeWorldSelectSorting(3, 1);
            return;
         }

         if (MouseHandler.MouseHandler_lastPressedX >= Login.xPadding + 708 && MouseHandler.MouseHandler_lastPressedY >= 4 && MouseHandler.MouseHandler_lastPressedX <= Login.xPadding + 708 + 50 && MouseHandler.MouseHandler_lastPressedY <= 20) {
            class138.method800();
            return;
         }

         if (Login.hoveredWorldIndex != -1) {
            World var7 = class31.World_worlds[Login.hoveredWorldIndex];
            FloorOverlayDefinition.changeWorld(var7);
            class138.method800();
            return;
         }

         if (Login.worldSelectPage > 0 && PlayerType.worldSelectLeftSprite != null && MouseHandler.MouseHandler_lastPressedX >= 0 && MouseHandler.MouseHandler_lastPressedX <= PlayerType.worldSelectLeftSprite.subWidth && MouseHandler.MouseHandler_lastPressedY >= class262.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class262.canvasHeight / 2 + 50) {
            --Login.worldSelectPage;
         }

         if (Login.worldSelectPage < Login.worldSelectPagesCount && class13.worldSelectRightSprite != null && MouseHandler.MouseHandler_lastPressedX >= GameEngine.canvasWidth - class13.worldSelectRightSprite.subWidth - 5 && MouseHandler.MouseHandler_lastPressedX <= GameEngine.canvasWidth && MouseHandler.MouseHandler_lastPressedY >= class262.canvasHeight / 2 - 50 && MouseHandler.MouseHandler_lastPressedY <= class262.canvasHeight / 2 + 50) {
            ++Login.worldSelectPage;
         }
      }

   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "-328074717"
   )
   static int method147(int var0, Script var1, boolean var2) {
      Widget var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
      if (var0 == 2800) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class195.Widget_unpackTargetMask(KeyHandler.getWidgetFlags(var3));
         return 1;
      } else if (var0 != 2801) {
         if (var0 == 2802) {
            if (var3.dataText == null) {
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
            } else {
               Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.dataText;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         --var4;
         if (var3.actions != null && var4 < var3.actions.length && var3.actions[var4] != null) {
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var3.actions[var4];
         } else {
            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
         }

         return 1;
      }
   }

    @ObfuscatedName("jm")
    @ObfuscatedSignature(
            descriptor = "(Lde;IIIIII)V",
            garbageValue = "1538298261"
    )
    static final void drawActor2d(Actor var0, int var1, int var2, int var3, int var4, int var5) {
      if (var0 != null && var0.isVisible()) {
         if (var0 instanceof NPC) {
            NPCComposition var6 = ((NPC)var0).definition;
            if (var6.transforms != null) {
               var6 = var6.transform();
            }

            if (var6 == null) {
               return;
            }
         }

         int var75 = Players.Players_count;
         int[] var7 = Players.Players_indices;
         boolean var8 = var1 < var75;
         int var9 = -2;
         int var10;
         if (var0.overheadText != null && (!var8 || !var0.showPublicPlayerChat && (Client.publicChatMode == 4 || !var0.isAutoChatting && (Client.publicChatMode == 0 || Client.publicChatMode == 3 || Client.publicChatMode == 1 && ((Player)var0).isFriend())))) {
            var10 = var0.defaultHeight;
            class374.worldToScreen(var0.x, var0.y, var10);
            if (Client.viewportTempX > -1 && Client.overheadTextCount < Client.overheadTextLimit) {
               Client.overheadTextXOffsets[Client.overheadTextCount] = class137.fontBold12.stringWidth(var0.overheadText) / 2;
               Client.overheadTextAscents[Client.overheadTextCount] = class137.fontBold12.ascent;
               Client.overheadTextXs[Client.overheadTextCount] = Client.viewportTempX;
               Client.overheadTextYs[Client.overheadTextCount] = Client.viewportTempY - var9;
               Client.overheadTextColors[Client.overheadTextCount] = var0.field957;
               Client.overheadTextEffects[Client.overheadTextCount] = var0.field1002;
               Client.overheadTextCyclesRemaining[Client.overheadTextCount] = var0.overheadTextCyclesRemaining;
               Client.overheadText[Client.overheadTextCount] = var0.overheadText;
               ++Client.overheadTextCount;
               var9 += 12;
            }
         }

         int var15;
         int var22;
         int var23;
         if (!var0.healthBars.method1971()) {
            UserComparator6.method716(var0, var0.defaultHeight + 15);

            for(HealthBar var76 = (HealthBar)var0.healthBars.last(); var76 != null; var76 = (HealthBar)var0.healthBars.previous()) {
               HealthBarUpdate var11 = var76.get(Client.cycle);
               if (var11 == null) {
                  if (var76.isEmpty()) {
                     var76.remove();
                  }
               } else {
                  HealthBarDefinition var12 = var76.definition;
                  SpritePixels var13 = var12.getBackSprite();
                  SpritePixels var14 = var12.getFrontSprite();
                  int var16 = 0;
                  if (var13 != null && var14 != null) {
                     if (var12.widthPadding * 2 < var14.subWidth) {
                        var16 = var12.widthPadding;
                     }

                     var15 = var14.subWidth - var16 * 2;
                  } else {
                     var15 = var12.width;
                  }

                  int var17 = 255;
                  boolean var18 = true;
                  int var19 = Client.cycle - var11.cycle;
                  int var20 = var15 * var11.health2 / var12.width;
                  int var21;
                  int var95;
                  if (var11.cycleOffset > var19) {
                     var21 = var12.field1533 == 0 ? 0 : var12.field1533 * (var19 / var12.field1533);
                     var22 = var15 * var11.health / var12.width;
                     var95 = var21 * (var20 - var22) / var11.cycleOffset + var22;
                  } else {
                     var95 = var20;
                     var21 = var12.int5 + var11.cycleOffset - var19;
                     if (var12.int3 >= 0) {
                        var17 = (var21 << 8) / (var12.int5 - var12.int3);
                     }
                  }

                  if (var11.health2 > 0 && var95 < 1) {
                     var95 = 1;
                  }

                  if (var13 != null && var14 != null) {
                     if (var15 == var95) {
                        var95 += var16 * 2;
                     } else {
                        var95 += var16;
                     }

                     var21 = var13.subHeight;
                     var9 += var21;
                     var22 = var2 + Client.viewportTempX - (var15 >> 1);
                     var23 = var3 + Client.viewportTempY - var9;
                     var22 -= var16;
                     if (var17 >= 0 && var17 < 255) {
                        var13.drawTransAt(var22, var23, var17);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var22 + var95, var23 + var21);
                        var14.drawTransAt(var22, var23, var17);
                     } else {
                        var13.drawTransBgAt(var22, var23);
                        Rasterizer2D.Rasterizer2D_expandClip(var22, var23, var95 + var22, var23 + var21);
                        var14.drawTransBgAt(var22, var23);
                     }

                     Rasterizer2D.Rasterizer2D_setClip(var2, var3, var2 + var4, var3 + var5);
                     var9 += 2;
                  } else {
                     var9 += 5;
                     if (Client.viewportTempX > -1) {
                        var21 = var2 + Client.viewportTempX - (var15 >> 1);
                        var22 = var3 + Client.viewportTempY - var9;
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21, var22, var95, 5, 65280);
                        Rasterizer2D.Rasterizer2D_fillRectangle(var21 + var95, var22, var15 - var95, 5, 16711680);
                     }

                     var9 += 2;
                  }
               }
            }
         }

         if (var9 == -2) {
            var9 += 7;
         }

         int var77;
         Player var97;
         if (var8 && var0.playerCycle == Client.cycle && class13.method46((Player)var0)) {
            var97 = (Player)var0;
            if (var8) {
               var77 = var0.defaultHeight + 15;
               class374.worldToScreen(var0.x, var0.y, var77);
               AbstractFont var91 = (AbstractFont)Client.fontsMap.get(FontName.FontName_plain12);
               var9 += 4;
               var91.drawCentered(var97.username.getName(), var2 + Client.viewportTempX, var3 + Client.viewportTempY - var9, 16777215, 0);
               var9 += 18;
            }
         }

         if (var8) {
            var97 = (Player)var0;
            if (var97.isHidden) {
               return;
            }

            if (var97.headIconPk != -1 || var97.headIconPrayer != -1) {
               var77 = var0.defaultHeight + 15;
               class374.worldToScreen(var0.x, var0.y, var77);
               if (Client.viewportTempX > -1) {
                  if (var97.headIconPk != -1) {
                     var9 += 25;
                     class36.headIconPkSprites[var97.headIconPk].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
                  }

                  if (var97.headIconPrayer != -1) {
                     var9 += 25;
                     class425.headIconPrayerSprites[var97.headIconPrayer].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
                  }
               }
            }

            if (var1 >= 0 && Client.hintArrowType == 10 && var7[var1] == Client.hintArrowPlayerIndex) {
               var77 = var0.defaultHeight + 15;
               class374.worldToScreen(var0.x, var0.y, var77);
               if (Client.viewportTempX > -1) {
                  var9 += KitDefinition.headIconHintSprites[1].subHeight;
                  KitDefinition.headIconHintSprites[1].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - var9);
               }
            }
         } else {
            NPC var98 = (NPC)var0;
            int[] var90 = var98.method596();
            short[] var92 = var98.method602();
            int var78;
            if (var92 != null && var90 != null) {
               for(var78 = 0; var78 < var92.length; ++var78) {
                  if (var92[var78] >= 0 && var90[var78] >= 0) {
                     long var79 = (long)var90[var78] << 8 | (long)var92[var78];
                     SpritePixels var81 = (SpritePixels)Client.archive5.method2126(var79);
                     if (var81 == null) {
                        SpritePixels[] var82 = UserComparator3.method699(class452.archive8, var90[var78], 0);
                        if (var82 != null && var92[var78] < var82.length) {
                           var81 = var82[var92[var78]];
                           Client.archive5.method2122(var79, var81);
                        }
                     }

                     if (var81 != null) {
                        UserComparator6.method716(var0, var0.defaultHeight + 15);
                        if (Client.viewportTempX > -1) {
                           var81.drawTransBgAt(var2 + Client.viewportTempX - (var81.subWidth >> 1), Client.viewportTempY + (var3 - var81.subHeight) - 4);
                        }
                     }
                  }
               }
            }

            if (Client.hintArrowType == 1 && Client.npcIndices[var1 - var75] == Client.hintArrowNpcIndex && Client.cycle % 20 < 10) {
               var78 = var0.defaultHeight + 15;
               class374.worldToScreen(var0.x, var0.y, var78);
               if (Client.viewportTempX > -1) {
                  KitDefinition.headIconHintSprites[0].drawTransBgAt(var2 + Client.viewportTempX - 12, var3 + Client.viewportTempY - 28);
               }
            }
         }

         for(var10 = 0; var10 < 4; ++var10) {
            var77 = var0.hitSplatCycles[var10];
            int var83 = var0.hitSplatTypes[var10];
            HitSplatDefinition var93 = null;
            int var84 = 0;
            if (var83 >= 0) {
               if (var77 <= Client.cycle) {
                  continue;
               }

               var93 = class122.method738(var0.hitSplatTypes[var10]);
               var84 = var93.field1672;
               if (var93 != null && var93.transforms != null) {
                  var93 = var93.transform();
                  if (var93 == null) {
                     var0.hitSplatCycles[var10] = -1;
                     continue;
                  }
               }
            } else if (var77 < 0) {
               continue;
            }

            var15 = var0.hitSplatTypes2[var10];
            HitSplatDefinition var99 = null;
            if (var15 >= 0) {
               var99 = class122.method738(var15);
               if (var99 != null && var99.transforms != null) {
                  var99 = var99.transform();
               }
            }

            if (var77 - var84 <= Client.cycle) {
               if (var93 == null) {
                  var0.hitSplatCycles[var10] = -1;
               } else {
                  UserComparator6.method716(var0, var0.defaultHeight / 2);
                  if (Client.viewportTempX > -1) {
                     boolean var94 = true;
                     if (var10 == 1) {
                        Client.viewportTempY -= 20;
                     }

                     if (var10 == 2) {
                        Client.viewportTempX -= 15;
                        Client.viewportTempY -= 10;
                     }

                     if (var10 == 3) {
                        Client.viewportTempX += 15;
                        Client.viewportTempY -= 10;
                     }

                     SpritePixels var85 = null;
                     SpritePixels var86 = null;
                     SpritePixels var87 = null;
                     SpritePixels var88 = null;
                     var22 = 0;
                     var23 = 0;
                     int var24 = 0;
                     int var25 = 0;
                     int var26 = 0;
                     int var27 = 0;
                     int var28 = 0;
                     int var29 = 0;
                     SpritePixels var30 = null;
                     SpritePixels var31 = null;
                     SpritePixels var32 = null;
                     SpritePixels var33 = null;
                     int var34 = 0;
                     int var35 = 0;
                     int var36 = 0;
                     int var37 = 0;
                     int var38 = 0;
                     int var39 = 0;
                     int var40 = 0;
                     int var41 = 0;
                     int var42 = 0;
                     var85 = var93.method1076();
                     int var43;
                     if (var85 != null) {
                        var22 = var85.subWidth;
                        var43 = var85.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var26 = var85.xOffset;
                     }

                     var86 = var93.method1077();
                     if (var86 != null) {
                        var23 = var86.subWidth;
                        var43 = var86.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var27 = var86.xOffset;
                     }

                     var87 = var93.method1072();
                     if (var87 != null) {
                        var24 = var87.subWidth;
                        var43 = var87.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var28 = var87.xOffset;
                     }

                     var88 = var93.method1078();
                     if (var88 != null) {
                        var25 = var88.subWidth;
                        var43 = var88.subHeight;
                        if (var43 > var42) {
                           var42 = var43;
                        }

                        var29 = var88.xOffset;
                     }

                     if (var99 != null) {
                        var30 = var99.method1076();
                        if (var30 != null) {
                           var34 = var30.subWidth;
                           var43 = var30.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var38 = var30.xOffset;
                        }

                        var31 = var99.method1077();
                        if (var31 != null) {
                           var35 = var31.subWidth;
                           var43 = var31.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var39 = var31.xOffset;
                        }

                        var32 = var99.method1072();
                        if (var32 != null) {
                           var36 = var32.subWidth;
                           var43 = var32.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var40 = var32.xOffset;
                        }

                        var33 = var99.method1078();
                        if (var33 != null) {
                           var37 = var33.subWidth;
                           var43 = var33.subHeight;
                           if (var43 > var42) {
                              var42 = var43;
                           }

                           var41 = var33.xOffset;
                        }
                     }

                     Font var89 = var93.getFont();
                     if (var89 == null) {
                        var89 = Language.fontPlain11;
                     }

                     Font var44;
                     if (var99 != null) {
                        var44 = var99.getFont();
                        if (var44 == null) {
                           var44 = Language.fontPlain11;
                        }
                     } else {
                        var44 = Language.fontPlain11;
                     }

                     String var45 = null;
                     String var46 = null;
                     boolean var47 = false;
                     int var48 = 0;
                     var45 = var93.getString(var0.hitSplatValues[var10]);
                     int var96 = var89.stringWidth(var45);
                     if (var99 != null) {
                        var46 = var99.getString(var0.hitSplatValues2[var10]);
                        var48 = var44.stringWidth(var46);
                     }

                     int var49 = 0;
                     int var50 = 0;
                     if (var23 > 0) {
                        if (var87 == null && var88 == null) {
                           var49 = 1;
                        } else {
                           var49 = var96 / var23 + 1;
                        }
                     }

                     if (var99 != null && var35 > 0) {
                        if (var32 == null && var33 == null) {
                           var50 = 1;
                        } else {
                           var50 = var48 / var35 + 1;
                        }
                     }

                     int var51 = 0;
                     int var52 = var51;
                     if (var22 > 0) {
                        var51 += var22;
                     }

                     var51 += 2;
                     int var53 = var51;
                     if (var24 > 0) {
                        var51 += var24;
                     }

                     int var54 = var51;
                     int var55 = var51;
                     int var56;
                     if (var23 > 0) {
                        var56 = var49 * var23;
                        var51 += var56;
                        var55 += (var56 - var96) / 2;
                     } else {
                        var51 += var96;
                     }

                     var56 = var51;
                     if (var25 > 0) {
                        var51 += var25;
                     }

                     int var57 = 0;
                     int var58 = 0;
                     int var59 = 0;
                     int var60 = 0;
                     int var61 = 0;
                     int var62;
                     if (var99 != null) {
                        var51 += 2;
                        var57 = var51;
                        if (var34 > 0) {
                           var51 += var34;
                        }

                        var51 += 2;
                        var58 = var51;
                        if (var36 > 0) {
                           var51 += var36;
                        }

                        var59 = var51;
                        var61 = var51;
                        if (var35 > 0) {
                           var62 = var35 * var50;
                           var51 += var62;
                           var61 += (var62 - var48) / 2;
                        } else {
                           var51 += var48;
                        }

                        var60 = var51;
                        if (var37 > 0) {
                           var51 += var37;
                        }
                     }

                     var62 = var0.hitSplatCycles[var10] - Client.cycle;
                     int var63 = var93.field1663 - var62 * var93.field1663 / var93.field1672;
                     int var64 = var62 * var93.field1676 / var93.field1672 + -var93.field1676;
                     int var65 = var63 + (var2 + Client.viewportTempX - (var51 >> 1));
                     int var66 = var64 + (var3 + Client.viewportTempY - 12);
                     int var67 = var66;
                     int var68 = var66 + var42;
                     int var69 = var66 + var93.field1680 + 15;
                     int var70 = var69 - var89.maxAscent;
                     int var71 = var69 + var89.maxDescent;
                     if (var70 < var66) {
                        var67 = var70;
                     }

                     if (var71 > var68) {
                        var68 = var71;
                     }

                     int var72 = 0;
                     int var73;
                     int var74;
                     if (var99 != null) {
                        var72 = var66 + var99.field1680 + 15;
                        var73 = var72 - var44.maxAscent;
                        var74 = var72 + var44.maxDescent;
                        if (var73 < var67) {
                           ;
                        }

                        if (var74 > var68) {
                           ;
                        }
                     }

                     var73 = 255;
                     if (var93.field1683 >= 0) {
                        var73 = (var62 << 8) / (var93.field1672 - var93.field1683);
                     }

                     if (var73 >= 0 && var73 < 255) {
                        if (var85 != null) {
                           var85.drawTransAt(var65 + var52 - var26, var66, var73);
                        }

                        if (var87 != null) {
                           var87.drawTransAt(var53 + var65 - var28, var66, var73);
                        }

                        if (var86 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var86.drawTransAt(var74 * var23 + (var54 + var65 - var27), var66, var73);
                           }
                        }

                        if (var88 != null) {
                           var88.drawTransAt(var65 + var56 - var29, var66, var73);
                        }

                        var89.drawAlpha(var45, var55 + var65, var69, var93.textColor, 0, var73);
                        if (var99 != null) {
                           if (var30 != null) {
                              var30.drawTransAt(var57 + var65 - var38, var66, var73);
                           }

                           if (var32 != null) {
                              var32.drawTransAt(var58 + var65 - var40, var66, var73);
                           }

                           if (var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawTransAt(var35 * var74 + (var65 + var59 - var39), var66, var73);
                              }
                           }

                           if (var33 != null) {
                              var33.drawTransAt(var60 + var65 - var41, var66, var73);
                           }

                           var44.drawAlpha(var46, var65 + var61, var72, var99.textColor, 0, var73);
                        }
                     } else {
                        if (var85 != null) {
                           var85.drawTransBgAt(var52 + var65 - var26, var66);
                        }

                        if (var87 != null) {
                           var87.drawTransBgAt(var53 + var65 - var28, var66);
                        }

                        if (var86 != null) {
                           for(var74 = 0; var74 < var49; ++var74) {
                              var86.drawTransBgAt(var23 * var74 + (var54 + var65 - var27), var66);
                           }
                        }

                        if (var88 != null) {
                           var88.drawTransBgAt(var65 + var56 - var29, var66);
                        }

                        var89.draw(var45, var65 + var55, var69, var93.textColor | -16777216, 0);
                        if (var99 != null) {
                           if (var30 != null) {
                              var30.drawTransBgAt(var57 + var65 - var38, var66);
                           }

                           if (var32 != null) {
                              var32.drawTransBgAt(var58 + var65 - var40, var66);
                           }

                           if (var31 != null) {
                              for(var74 = 0; var74 < var50; ++var74) {
                                 var31.drawTransBgAt(var74 * var35 + (var65 + var59 - var39), var66);
                              }
                           }

                           if (var33 != null) {
                              var33.drawTransBgAt(var65 + var60 - var41, var66);
                           }

                           var44.draw(var46, var65 + var61, var72, var99.textColor | -16777216, 0);
                        }
                     }
                  }
               }
            }
         }

      }
   }

    @ObfuscatedName("jz")
    @ObfuscatedSignature(
            descriptor = "(IIIIIIIIIII)V",
            garbageValue = "87894197"
    )
    static final void updatePendingSpawn(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      PendingSpawn var10 = null;

      for(PendingSpawn var11 = (PendingSpawn)Client.pendingSpawns.last(); var11 != null; var11 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if (var0 == var11.plane && var11.x == var1 && var2 == var11.y && var3 == var11.type) {
            var10 = var11;
            break;
         }
      }

      if (var10 == null) {
         var10 = new PendingSpawn();
         var10.plane = var0;
         var10.type = var3;
         var10.x = var1;
         var10.y = var2;
         var10.field931 = -1;
         Messages.method656(var10);
         Client.pendingSpawns.addFirst(var10);
      }

      var10.id = var4;
      var10.objectType = var5;
      var10.rotation = var6;
      var10.startCycle = var8;
      var10.endCycle = var9;
      var10.method524(var7);
   }
}
