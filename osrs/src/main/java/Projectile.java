import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
@Implements("Projectile")
public final class Projectile extends Renderable {
   @ObfuscatedName("vs")
   @ObfuscatedSignature(
      descriptor = "Lnz;"
   )
   @Export("grandExchangeEvents")
   static GrandExchangeEvents grandExchangeEvents;
   @ObfuscatedName("aj")
   @Export("id")
   int id;
   @ObfuscatedName("al")
   @Export("plane")
   int plane;
   @ObfuscatedName("ac")
   @Export("sourceX")
   int sourceX;
   @ObfuscatedName("ab")
   @Export("sourceY")
   int sourceY;
   @ObfuscatedName("an")
   @Export("sourceZ")
   int sourceZ;
   @ObfuscatedName("ao")
   @Export("endHeight")
   int endHeight;
   @ObfuscatedName("av")
   @Export("cycleStart")
   int cycleStart;
   @ObfuscatedName("aq")
   @Export("cycleEnd")
   int cycleEnd;
   @ObfuscatedName("ap")
   @Export("slope")
   int slope;
   @ObfuscatedName("ar")
   @Export("startHeight")
   int startHeight;
   @ObfuscatedName("ak")
   @Export("targetIndex")
   int targetIndex;
   @ObfuscatedName("ax")
   @Export("isMoving")
   boolean isMoving = false;
   @ObfuscatedName("as")
   @Export("x")
   double x;
   @ObfuscatedName("ay")
   @Export("y")
   double y;
   @ObfuscatedName("am")
   @Export("z")
   double z;
   @ObfuscatedName("az")
   @Export("speedX")
   double speedX;
   @ObfuscatedName("ae")
   @Export("speedY")
   double speedY;
   @ObfuscatedName("au")
   @Export("speed")
   double speed;
   @ObfuscatedName("ag")
   @Export("speedZ")
   double speedZ;
   @ObfuscatedName("at")
   @Export("accelerationZ")
   double accelerationZ;
   @ObfuscatedName("af")
   @Export("yaw")
   int yaw;
   @ObfuscatedName("ai")
   @Export("pitch")
   int pitch;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lhx;"
   )
   @Export("sequenceDefinition")
   SequenceDefinition sequenceDefinition;
   @ObfuscatedName("aa")
   @Export("frame")
   int frame = 0;
   @ObfuscatedName("ah")
   @Export("frameCycle")
   int frameCycle = 0;

   Projectile(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11) {
      this.id = var1;
      this.plane = var2;
      this.sourceX = var3;
      this.sourceY = var4;
      this.sourceZ = var5;
      this.cycleStart = var6;
      this.cycleEnd = var7;
      this.slope = var8;
      this.startHeight = var9;
      this.targetIndex = var10;
      this.endHeight = var11;
      this.isMoving = false;
      int var12 = DevicePcmPlayerProvider.SpotAnimationDefinition_get(this.id).sequence;
      if (var12 != -1) {
         this.sequenceDefinition = Coord.SequenceDefinition_get(var12);
      } else {
         this.sequenceDefinition = null;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "-734315858"
   )
   @Export("setDestination")
   final void setDestination(int var1, int var2, int var3, int var4) {
      double var5;
      if (!this.isMoving) {
         var5 = (double)(var1 - this.sourceX);
         double var7 = (double)(var2 - this.sourceY);
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.x = (double)this.sourceX + (double)this.startHeight * var5 / var9;
         this.y = (double)this.sourceY + var7 * (double)this.startHeight / var9;
         this.z = (double)this.sourceZ;
      }

      var5 = (double)(this.cycleEnd + 1 - var4);
      this.speedX = ((double)var1 - this.x) / var5;
      this.speedY = ((double)var2 - this.y) / var5;
      this.speed = Math.sqrt(this.speedX * this.speedX + this.speedY * this.speedY);
      if (!this.isMoving) {
         this.speedZ = -this.speed * Math.tan(0.02454369D * (double)this.slope);
      }

      this.accelerationZ = 2.0D * ((double)var3 - this.z - var5 * this.speedZ) / (var5 * var5);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Lix;",
      garbageValue = "-1998422213"
   )
   @Export("getModel")
   protected final Model getModel() {
      SpotAnimationDefinition var1 = DevicePcmPlayerProvider.SpotAnimationDefinition_get(this.id);
      Model var2 = var1.getModel(this.frame);
      if (var2 == null) {
         return null;
      } else {
         var2.rotateZ(this.pitch);
         return var2;
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(IS)V",
      garbageValue = "-18055"
   )
   @Export("advance")
   final void advance(int var1) {
      this.isMoving = true;
      this.x += (double)var1 * this.speedX;
      this.y += this.speedY * (double)var1;
      this.z += (double)var1 * this.speedZ + (double)var1 * this.accelerationZ * 0.5D * (double)var1;
      this.speedZ += (double)var1 * this.accelerationZ;
      this.yaw = (int)(Math.atan2(this.speedX, this.speedY) * 325.949D) + 1024 & 2047;
      this.pitch = (int)(Math.atan2(this.speedZ, this.speed) * 325.949D) & 2047;
      if (this.sequenceDefinition != null) {
         if (!this.sequenceDefinition.isCachedModelIdSet()) {
            this.frameCycle += var1;

            while(true) {
               do {
                  do {
                     if (this.frameCycle <= this.sequenceDefinition.frameLengths[this.frame]) {
                        return;
                     }

                     this.frameCycle -= this.sequenceDefinition.frameLengths[this.frame];
                     ++this.frame;
                  } while(this.frame < this.sequenceDefinition.frameIds.length);

                  this.frame -= this.sequenceDefinition.frameCount;
               } while(this.frame >= 0 && this.frame < this.sequenceDefinition.frameIds.length);

               this.frame = 0;
            }
         } else {
            this.frame += var1;
            int var2 = this.sequenceDefinition.method1066();
            if (this.frame >= var2) {
               this.frame = var2 - this.sequenceDefinition.frameCount;
            }
         }
      }

   }

   @ObfuscatedName("ic")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "-1450357664"
   )
   @Export("drawEntities")
   static final void drawEntities(int var0, int var1, int var2, int var3) {
      ++Client.viewportDrawCount;
      if (BuddyRankComparator.localPlayer.x >> 7 == Client.destinationX && BuddyRankComparator.localPlayer.y >> 7 == Client.destinationY) {
         Client.destinationX = 0;
      }

      if (Client.renderSelf) {
         class220.addPlayerToScene(BuddyRankComparator.localPlayer, false);
      }

      if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
         class220.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
      }

      AbstractWorldMapIcon.addNpcsToScene(true);
      InterfaceParent.method465();
      AbstractWorldMapIcon.addNpcsToScene(false);
      class11.method38();

      for(GraphicsObject var4 = (GraphicsObject)Client.graphicsObjects.last(); var4 != null; var4 = (GraphicsObject)Client.graphicsObjects.previous()) {
         if (var4.plane == TaskHandler.Client_plane && !var4.isFinished) {
            if (Client.cycle >= var4.cycleStart) {
               var4.advance(Client.field504);
               if (var4.isFinished) {
                  var4.remove();
               } else {
                  class1.scene.drawEntity(var4.plane, var4.x, var4.y, var4.z, 60, var4, 0, -1L, false);
               }
            }
         } else {
            var4.remove();
         }
      }

      Language.setViewportShape(var0, var1, var2, var3, true);
      var0 = Client.viewportOffsetX;
      var1 = Client.viewportOffsetY;
      var2 = Client.viewportWidth;
      var3 = Client.viewportHeight;
      Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
      Rasterizer3D.Rasterizer3D_setClipFromRasterizer2D();
      int var36 = Client.camAngleX;
      if (Client.field375 / 256 > var36) {
         var36 = Client.field375 / 256;
      }

      if (Client.cameraShaking[4] && Client.cameraMoveIntensity[4] + 128 > var36) {
         var36 = Client.cameraMoveIntensity[4] + 128;
      }

      int var5 = Client.camAngleY & 2047;
      int var6 = GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX;
      int var7 = class128.field1233;
      int var8 = ReflectionCheck.oculusOrbFocalPointY;
      int var11 = var36 * 3 + 600;
      BufferedSink.method2162(var6, var7, var8, var36, var5, var11, var3);
      int var12;
      int var13;
      int var14;
      if (!Client.isCameraLocked) {
         var12 = class143.method760();
      } else {
         if (WorldMapSectionType.clientPreferences.getRoofsHidden()) {
            var13 = TaskHandler.Client_plane;
         } else {
            var14 = WorldMapDecorationType.getTileHeight(class381.cameraX, class471.cameraZ, TaskHandler.Client_plane);
            if (var14 - class351.cameraY < 800 && (Tiles.Tiles_renderFlags[TaskHandler.Client_plane][class381.cameraX >> 7][class471.cameraZ >> 7] & 4) != 0) {
               var13 = TaskHandler.Client_plane;
            } else {
               var13 = 3;
            }
         }

         var12 = var13;
      }

      var13 = class381.cameraX;
      var14 = class351.cameraY;
      int var15 = class471.cameraZ;
      int var16 = class311.cameraPitch;
      int var17 = class110.cameraYaw;

      int var18;
      int var19;
      for(var18 = 0; var18 < 5; ++var18) {
         if (Client.cameraShaking[var18]) {
            var19 = (int)(Math.random() * (double)(Client.cameraShakeIntensity[var18] * 2 + 1) - (double)Client.cameraShakeIntensity[var18] + Math.sin((double)Client.cameraShakeSpeed[var18] / 100.0D * (double)Client.cameraShakeCycle[var18]) * (double)Client.cameraMoveIntensity[var18]);
            if (var18 == 0) {
               class381.cameraX += var19;
            }

            if (var18 == 1) {
               class351.cameraY += var19;
            }

            if (var18 == 2) {
               class471.cameraZ += var19;
            }

            if (var18 == 3) {
               class110.cameraYaw = var19 + class110.cameraYaw & 2047;
            }

            if (var18 == 4) {
               class311.cameraPitch += var19;
               if (class311.cameraPitch < 128) {
                  class311.cameraPitch = 128;
               }

               if (class311.cameraPitch > 383) {
                  class311.cameraPitch = 383;
               }
            }
         }
      }

      var18 = MouseHandler.MouseHandler_x;
      var19 = MouseHandler.MouseHandler_y;
      if (MouseHandler.MouseHandler_lastButton != 0) {
         var18 = MouseHandler.MouseHandler_lastPressedX;
         var19 = MouseHandler.MouseHandler_lastPressedY;
      }

      if (var18 >= var0 && var18 < var0 + var2 && var19 >= var1 && var19 < var3 + var1) {
         Client.method370(var18 - var0, var19 - var1);
      } else {
         ViewportMouse.ViewportMouse_isInViewport = false;
         ViewportMouse.ViewportMouse_entityCount = 0;
      }

      EnumComposition.playPcmPlayers();
      Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
      EnumComposition.playPcmPlayers();
      int var20 = Rasterizer3D.Rasterizer3D_zoom;
      Rasterizer3D.Rasterizer3D_zoom = Client.viewportZoom;
      class1.scene.draw(class381.cameraX, class351.cameraY, class471.cameraZ, class311.cameraPitch, class110.cameraYaw, var12);
      Rasterizer3D.Rasterizer3D_zoom = var20;
      EnumComposition.playPcmPlayers();
      class1.scene.clearTempGameObjects();
      Client.overheadTextCount = 0;
      boolean var21 = false;
      int var22 = -1;
      int var23 = -1;
      int var24 = Players.Players_count;
      int[] var25 = Players.Players_indices;

      int var26;
      for(var26 = 0; var26 < var24 + Client.npcCount; ++var26) {
         Object var27;
         if (var26 < var24) {
            var27 = Client.players[var25[var26]];
            if (var25[var26] == Client.combatTargetPlayerIndex) {
               var21 = true;
               var22 = var26;
               continue;
            }

            if (var27 == BuddyRankComparator.localPlayer) {
               var23 = var26;
               continue;
            }
         } else {
            var27 = Client.npcs[Client.npcIndices[var26 - var24]];
         }

         ArchiveLoader.drawActor2d((Actor)var27, var26, var0, var1, var2, var3);
      }

      if (Client.renderSelf && var23 != -1) {
         ArchiveLoader.drawActor2d(BuddyRankComparator.localPlayer, var23, var0, var1, var2, var3);
      }

      if (var21) {
         ArchiveLoader.drawActor2d(Client.players[Client.combatTargetPlayerIndex], var22, var0, var1, var2, var3);
      }

      for(var26 = 0; var26 < Client.overheadTextCount; ++var26) {
         int var37 = Client.overheadTextXs[var26];
         int var28 = Client.overheadTextYs[var26];
         int var29 = Client.overheadTextXOffsets[var26];
         int var30 = Client.overheadTextAscents[var26];
         boolean var31 = true;

         while(var31) {
            var31 = false;

            for(int var32 = 0; var32 < var26; ++var32) {
               if (var28 + 2 > Client.overheadTextYs[var32] - Client.overheadTextAscents[var32] && var28 - var30 < Client.overheadTextYs[var32] + 2 && var37 - var29 < Client.overheadTextXOffsets[var32] + Client.overheadTextXs[var32] && var29 + var37 > Client.overheadTextXs[var32] - Client.overheadTextXOffsets[var32] && Client.overheadTextYs[var32] - Client.overheadTextAscents[var32] < var28) {
                  var28 = Client.overheadTextYs[var32] - Client.overheadTextAscents[var32];
                  var31 = true;
               }
            }
         }

         Client.viewportTempX = Client.overheadTextXs[var26];
         Client.viewportTempY = Client.overheadTextYs[var26] = var28;
         String var38 = Client.overheadText[var26];
         if (Client.chatEffects == 0) {
            int var33 = 16776960;
            if (Client.overheadTextColors[var26] < 6) {
               var33 = Client.field578[Client.overheadTextColors[var26]];
            }

            if (Client.overheadTextColors[var26] == 6) {
               var33 = Client.viewportDrawCount % 20 < 10 ? 16711680 : 16776960;
            }

            if (Client.overheadTextColors[var26] == 7) {
               var33 = Client.viewportDrawCount % 20 < 10 ? 255 : '\uffff';
            }

            if (Client.overheadTextColors[var26] == 8) {
               var33 = Client.viewportDrawCount % 20 < 10 ? '뀀' : 8454016;
            }

            int var34;
            if (Client.overheadTextColors[var26] == 9) {
               var34 = 150 - Client.overheadTextCyclesRemaining[var26];
               if (var34 < 50) {
                  var33 = var34 * 1280 + 16711680;
               } else if (var34 < 100) {
                  var33 = 16776960 - (var34 - 50) * 327680;
               } else if (var34 < 150) {
                  var33 = (var34 - 100) * 5 + '\uff00';
               }
            }

            if (Client.overheadTextColors[var26] == 10) {
               var34 = 150 - Client.overheadTextCyclesRemaining[var26];
               if (var34 < 50) {
                  var33 = var34 * 5 + 16711680;
               } else if (var34 < 100) {
                  var33 = 16711935 - (var34 - 50) * 327680;
               } else if (var34 < 150) {
                  var33 = (var34 - 100) * 327680 + 255 - (var34 - 100) * 5;
               }
            }

            if (Client.overheadTextColors[var26] == 11) {
               var34 = 150 - Client.overheadTextCyclesRemaining[var26];
               if (var34 < 50) {
                  var33 = 16777215 - var34 * 327685;
               } else if (var34 < 100) {
                  var33 = (var34 - 50) * 327685 + '\uff00';
               } else if (var34 < 150) {
                  var33 = 16777215 - (var34 - 100) * 327680;
               }
            }

            if (Client.overheadTextEffects[var26] == 0) {
               class7.fontBold12.drawCentered(var38, var0 + Client.viewportTempX, Client.viewportTempY + var1, var33, 0);
            }

            if (Client.overheadTextEffects[var26] == 1) {
               class7.fontBold12.drawCenteredWave(var38, var0 + Client.viewportTempX, Client.viewportTempY + var1, var33, 0, Client.viewportDrawCount);
            }

            if (Client.overheadTextEffects[var26] == 2) {
               class7.fontBold12.drawCenteredWave2(var38, var0 + Client.viewportTempX, Client.viewportTempY + var1, var33, 0, Client.viewportDrawCount);
            }

            if (Client.overheadTextEffects[var26] == 3) {
               class7.fontBold12.drawCenteredShake(var38, var0 + Client.viewportTempX, Client.viewportTempY + var1, var33, 0, Client.viewportDrawCount, 150 - Client.overheadTextCyclesRemaining[var26]);
            }

            if (Client.overheadTextEffects[var26] == 4) {
               var34 = (150 - Client.overheadTextCyclesRemaining[var26]) * (class7.fontBold12.stringWidth(var38) + 100) / 150;
               Rasterizer2D.Rasterizer2D_expandClip(var0 + Client.viewportTempX - 50, var1, var0 + Client.viewportTempX + 50, var3 + var1);
               class7.fontBold12.draw(var38, var0 + Client.viewportTempX + 50 - var34, Client.viewportTempY + var1, var33, 0);
               Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
            }

            if (Client.overheadTextEffects[var26] == 5) {
               var34 = 150 - Client.overheadTextCyclesRemaining[var26];
               int var35 = 0;
               if (var34 < 25) {
                  var35 = var34 - 25;
               } else if (var34 > 125) {
                  var35 = var34 - 125;
               }

               Rasterizer2D.Rasterizer2D_expandClip(var0, Client.viewportTempY + var1 - class7.fontBold12.ascent - 1, var0 + var2, Client.viewportTempY + var1 + 5);
               class7.fontBold12.drawCentered(var38, var0 + Client.viewportTempX, var35 + Client.viewportTempY + var1, var33, 0);
               Rasterizer2D.Rasterizer2D_setClip(var0, var1, var0 + var2, var3 + var1);
            }
         } else {
            class7.fontBold12.drawCentered(var38, var0 + Client.viewportTempX, Client.viewportTempY + var1, 16776960, 0);
         }
      }

      Coord.method1633(var0, var1);
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).animate(Client.field504);
      Client.field540 = 0;
      int var39 = (BuddyRankComparator.localPlayer.x >> 7) + GameEngine.baseX;
      var22 = (BuddyRankComparator.localPlayer.y >> 7) + class178.baseY;
      if (var39 >= 3053 && var39 <= 3156 && var22 >= 3056 && var22 <= 3136) {
         Client.field540 = 1;
      }

      if (var39 >= 3072 && var39 <= 3118 && var22 >= 9492 && var22 <= 9535) {
         Client.field540 = 1;
      }

      if (Client.field540 == 1 && var39 >= 3139 && var39 <= 3199 && var22 >= 3008 && var22 <= 3062) {
         Client.field540 = 0;
      }

      class381.cameraX = var13;
      class351.cameraY = var14;
      class471.cameraZ = var15;
      class311.cameraPitch = var16;
      class110.cameraYaw = var17;
      if (Client.isLoading) {
         byte var40 = 0;
         var22 = var40 + NetCache.NetCache_pendingPriorityWritesCount + NetCache.NetCache_pendingPriorityResponsesCount;
         if (var22 == 0) {
            Client.isLoading = false;
         }
      }

      if (Client.isLoading) {
         Rasterizer2D.Rasterizer2D_fillRectangle(var0, var1, var2, var3, 0);
         class16.drawLoadingMessage("Loading - please wait.", false);
      }

   }
}
