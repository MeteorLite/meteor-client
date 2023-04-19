import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public abstract class class155 extends Node {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "-1949352075"
    )
    abstract void vmethod3238(Buffer var1);

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lgj;B)V",
            garbageValue = "-49"
    )
    abstract void vmethod3239(ClanChannel var1);

    @ObfuscatedName("mb")
    @ObfuscatedSignature(
            descriptor = "(Lmq;IIII)V",
            garbageValue = "715793835"
    )
    static final void drawMinimap(Widget var0, int var1, int var2, int var3) {
      class323.playPcmPlayers();
      SpriteMask var4 = var0.getSpriteMask(false);
      if (var4 != null) {
         Rasterizer2D.Rasterizer2D_setClip(var1, var2, var4.width + var1, var2 + var4.height);
         if (Client.minimapState != 2 && Client.minimapState != 5) {
            int var5 = Client.camAngleY & 2047;
            int var6 = MusicPatchNode.localPlayer.x / 32 + 48;
            int var7 = 464 - MusicPatchNode.localPlayer.y / 32;
            UrlRequester.sceneMinimapSprite.drawRotatedMaskedCenteredAround(var1, var2, var4.width, var4.height, var6, var7, var5, 256, var4.xStarts, var4.xWidths);

            int var8;
            int var9;
            int var10;
            for(var8 = 0; var8 < Client.mapIconCount; ++var8) {
               var9 = Client.mapIconXs[var8] * 4 + 2 - MusicPatchNode.localPlayer.x / 32;
               var10 = Client.mapIconYs[var8] * 4 + 2 - MusicPatchNode.localPlayer.y / 32;
               class426.drawSpriteOnMinimap(var1, var2, var9, var10, Client.mapIcons[var8], var4);
            }

            int var11;
            int var12;
            for(var8 = 0; var8 < 104; ++var8) {
               for(var9 = 0; var9 < 104; ++var9) {
                  NodeDeque var14 = Client.groundItems[GameEngine.Client_plane][var8][var9];
                  if (var14 != null) {
                     var11 = var8 * 4 + 2 - MusicPatchNode.localPlayer.x / 32;
                     var12 = var9 * 4 + 2 - MusicPatchNode.localPlayer.y / 32;
                     class426.drawSpriteOnMinimap(var1, var2, var11, var12, class477.mapDotSprites[0], var4);
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
                     var11 = var15.x / 32 - MusicPatchNode.localPlayer.x / 32;
                     var12 = var15.y / 32 - MusicPatchNode.localPlayer.y / 32;
                     class426.drawSpriteOnMinimap(var1, var2, var11, var12, class477.mapDotSprites[1], var4);
                  }
               }
            }

            var8 = Players.Players_count;
            int[] var18 = Players.Players_indices;

            for(var10 = 0; var10 < var8; ++var10) {
               Player var16 = Client.players[var18[var10]];
               if (var16 != null && var16.isVisible() && !var16.isHidden && var16 != MusicPatchNode.localPlayer) {
                  var12 = var16.x / 32 - MusicPatchNode.localPlayer.x / 32;
                  int var13 = var16.y / 32 - MusicPatchNode.localPlayer.y / 32;
                  if (var16.isFriend()) {
                     class426.drawSpriteOnMinimap(var1, var2, var12, var13, class477.mapDotSprites[3], var4);
                  } else if (MusicPatchNode.localPlayer.team != 0 && var16.team != 0 && var16.team == MusicPatchNode.localPlayer.team) {
                     class426.drawSpriteOnMinimap(var1, var2, var12, var13, class477.mapDotSprites[4], var4);
                  } else if (var16.isFriendsChatMember()) {
                     class426.drawSpriteOnMinimap(var1, var2, var12, var13, class477.mapDotSprites[5], var4);
                  } else if (var16.isClanMember()) {
                     class426.drawSpriteOnMinimap(var1, var2, var12, var13, class477.mapDotSprites[6], var4);
                  } else {
                     class426.drawSpriteOnMinimap(var1, var2, var12, var13, class477.mapDotSprites[2], var4);
                  }
               }
            }

            if (Client.hintArrowType != 0 && Client.cycle % 20 < 10) {
               if (Client.hintArrowType == 1 && Client.hintArrowNpcIndex >= 0 && Client.hintArrowNpcIndex < Client.npcs.length) {
                  NPC var19 = Client.npcs[Client.hintArrowNpcIndex];
                  if (var19 != null) {
                     var11 = var19.x / 32 - MusicPatchNode.localPlayer.x / 32;
                     var12 = var19.y / 32 - MusicPatchNode.localPlayer.y / 32;
                     class485.worldToMinimap(var1, var2, var11, var12, Players.mapMarkerSprites[1], var4);
                  }
               }

               if (Client.hintArrowType == 2) {
                  var10 = Client.hintArrowX * 4 - WorldMapData_0.baseX * 4 + 2 - MusicPatchNode.localPlayer.x / 32;
                  var11 = Client.hintArrowY * 4 - GameObject.baseY * 4 + 2 - MusicPatchNode.localPlayer.y / 32;
                  class485.worldToMinimap(var1, var2, var10, var11, Players.mapMarkerSprites[1], var4);
               }

               if (Client.hintArrowType == 10 && Client.hintArrowPlayerIndex >= 0 && Client.hintArrowPlayerIndex < Client.players.length) {
                  Player var20 = Client.players[Client.hintArrowPlayerIndex];
                  if (var20 != null) {
                     var11 = var20.x / 32 - MusicPatchNode.localPlayer.x / 32;
                     var12 = var20.y / 32 - MusicPatchNode.localPlayer.y / 32;
                     class485.worldToMinimap(var1, var2, var11, var12, Players.mapMarkerSprites[1], var4);
                  }
               }
            }

            if (Client.destinationX != 0) {
               var10 = Client.destinationX * 4 + 2 - MusicPatchNode.localPlayer.x / 32;
               var11 = Client.destinationY * 4 + 2 - MusicPatchNode.localPlayer.y / 32;
               class426.drawSpriteOnMinimap(var1, var2, var10, var11, Players.mapMarkerSprites[0], var4);
            }

            if (!MusicPatchNode.localPlayer.isHidden) {
               Rasterizer2D.Rasterizer2D_fillRectangle(var4.width / 2 + var1 - 1, var4.height / 2 + var2 - 1, 3, 3, 16777215);
            }
         } else {
            Rasterizer2D.Rasterizer2D_fillMaskedRectangle(var1, var2, 0, var4.xStarts, var4.xWidths);
         }

         Client.field574[var3] = true;
      }
   }
}
