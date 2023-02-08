import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mz")
public final class class361 {
   @ObfuscatedName("vl")
   static long field3568;
    @ObfuscatedName("v")
    public static int WorldMapElement_count;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2129750678"
   )
   static void method1925() {
      if (Client.Login_isUsernameRemembered && Login.Login_username != null && Login.Login_username.length() > 0) {
         Login.currentLoginField = 1;
      } else {
         Login.currentLoginField = 0;
      }

   }

   @ObfuscatedName("ht")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-116"
   )
   static final void method1923() {
      Projectile.method431(false);
      Client.field433 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class4.regionLandArchives.length; ++var1) {
         if (Renderable.regionMapArchiveIds[var1] != -1 && class4.regionLandArchives[var1] == null) {
            class4.regionLandArchives[var1] = NetCache.archive9.takeFile(Renderable.regionMapArchiveIds[var1], 0);
            if (class4.regionLandArchives[var1] == null) {
               var0 = false;
               ++Client.field433;
            }
         }

         if (class217.regionLandArchiveIds[var1] != -1 && class323.regionMapArchives[var1] == null) {
            class323.regionMapArchives[var1] = NetCache.archive9.takeFileEncrypted(class217.regionLandArchiveIds[var1], 0, GrandExchangeOffer.xteaKeys[var1]);
            if (class323.regionMapArchives[var1] == null) {
               var0 = false;
               ++Client.field433;
            }
         }
      }

      if (!var0) {
         Client.field609 = 1;
      } else {
         Client.field435 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class4.regionLandArchives.length; ++var1) {
            byte[] var2 = class323.regionMapArchives[var1];
            if (var2 != null) {
               var3 = (MusicPatch.regions[var1] >> 8) * 64 - ParamComposition.baseX;
               var4 = (MusicPatch.regions[var1] & 255) * 64 - Client.baseY;
               if (Client.isInInstance) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= NetFileRequest.method1807(var2, var3, var4);
            }
         }

         if (!var0) {
            Client.field609 = 2;
         } else {
            if (Client.field609 != 0) {
               class165.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            HorizontalAlignment.playPcmPlayers();
            WorldMapAreaData.scene.clear();

            for(var1 = 0; var1 < 4; ++var1) {
               Client.collisionMaps[var1].clear();
            }

            int var15;
            for(var1 = 0; var1 < 4; ++var1) {
               for(var15 = 0; var15 < 104; ++var15) {
                  for(var3 = 0; var3 < 104; ++var3) {
                     Tiles.Tiles_renderFlags[var1][var15][var3] = 0;
                  }
               }
            }

            HorizontalAlignment.playPcmPlayers();
            HorizontalAlignment.method951();
            var1 = class4.regionLandArchives.length;
            UserComparator4.method647();
            Projectile.method431(true);
            int var17;
            if (!Client.isInInstance) {
               byte[] var5;
               for(var15 = 0; var15 < var1; ++var15) {
                  var3 = (MusicPatch.regions[var15] >> 8) * 64 - ParamComposition.baseX;
                  var4 = (MusicPatch.regions[var15] & 255) * 64 - Client.baseY;
                  var5 = class4.regionLandArchives[var15];
                  if (var5 != null) {
                     HorizontalAlignment.playPcmPlayers();
                     class121.method673(var5, var3, var4, class303.timeOfPreviousKeyPress * 8 - 48, ScriptFrame.field343 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var15 = 0; var15 < var1; ++var15) {
                  var3 = (MusicPatch.regions[var15] >> 8) * 64 - ParamComposition.baseX;
                  var4 = (MusicPatch.regions[var15] & 255) * 64 - Client.baseY;
                  var5 = class4.regionLandArchives[var15];
                  if (var5 == null && ScriptFrame.field343 < 800) {
                     HorizontalAlignment.playPcmPlayers();
                     class14.method53(var3, var4, 64, 64);
                  }
               }

               Projectile.method431(true);

               for(var15 = 0; var15 < var1; ++var15) {
                  byte[] var16 = class323.regionMapArchives[var15];
                  if (var16 != null) {
                     var4 = (MusicPatch.regions[var15] >> 8) * 64 - ParamComposition.baseX;
                     var17 = (MusicPatch.regions[var15] & 255) * 64 - Client.baseY;
                     HorizontalAlignment.playPcmPlayers();
                     NetFileRequest.method1808(var16, var4, var17, WorldMapAreaData.scene, Client.collisionMaps);
                  }
               }
            }

            int var6;
            int var7;
            int var8;
            if (Client.isInInstance) {
               int var9;
               int var10;
               int var11;
               for(var15 = 0; var15 < 4; ++var15) {
                  HorizontalAlignment.playPcmPlayers();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        boolean var19 = false;
                        var6 = Client.instanceChunkTemplates[var15][var3][var4];
                        if (var6 != -1) {
                           var7 = var6 >> 24 & 3;
                           var8 = var6 >> 1 & 3;
                           var9 = var6 >> 14 & 1023;
                           var10 = var6 >> 3 & 2047;
                           var11 = (var9 / 8 << 8) + var10 / 8;

                           for(int var12 = 0; var12 < MusicPatch.regions.length; ++var12) {
                              if (MusicPatch.regions[var12] == var11 && class4.regionLandArchives[var12] != null) {
                                 int var13 = (var9 - var3) * 8;
                                 int var14 = (var10 - var4) * 8;
                                 class142.method760(class4.regionLandArchives[var12], var15, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, var13, var14, Client.collisionMaps);
                                 var19 = true;
                                 break;
                              }
                           }
                        }

                        if (!var19) {
                           class237.method1316(var15, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var15 = 0; var15 < 13; ++var15) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.instanceChunkTemplates[0][var15][var3];
                     if (var4 == -1) {
                        class14.method53(var15 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               Projectile.method431(true);

               for(var15 = 0; var15 < 4; ++var15) {
                  HorizontalAlignment.playPcmPlayers();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var17 = Client.instanceChunkTemplates[var15][var3][var4];
                        if (var17 != -1) {
                           var6 = var17 >> 24 & 3;
                           var7 = var17 >> 1 & 3;
                           var8 = var17 >> 14 & 1023;
                           var9 = var17 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < MusicPatch.regions.length; ++var11) {
                              if (MusicPatch.regions[var11] == var10 && class323.regionMapArchives[var11] != null) {
                                 Tiles.method447(class323.regionMapArchives[var11], var15, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, WorldMapAreaData.scene, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            Projectile.method431(true);
            HorizontalAlignment.playPcmPlayers();
            FontName.method2292(WorldMapAreaData.scene, Client.collisionMaps);
            Projectile.method431(true);
            var15 = Tiles.Tiles_minPlane;
            if (var15 > class103.Client_plane) {
               var15 = class103.Client_plane;
            }

            if (var15 < class103.Client_plane - 1) {
               var15 = class103.Client_plane - 1;
            }

            if (Client.isLowDetail) {
               WorldMapAreaData.scene.init(Tiles.Tiles_minPlane);
            } else {
               WorldMapAreaData.scene.init(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  ClientPacket.updateItemPile(var3, var4);
               }
            }

            HorizontalAlignment.playPcmPlayers();
            Language.method1881();
            ObjectComposition.ObjectDefinition_cachedModelData.clear();
            PacketBufferNode var18;
            if (Decimator.client.hasFrame()) {
               var18 = Renderable.getPacketBufferNode(ClientPacket.field2464, Client.packetWriter.isaacCipher);
               var18.packetBuffer.writeInt(1057001181);
               Client.packetWriter.addNode(var18);
            }

            if (!Client.isInInstance) {
               var3 = (class303.timeOfPreviousKeyPress - 6) / 8;
               var4 = (class303.timeOfPreviousKeyPress + 6) / 8;
               var17 = (ScriptFrame.field343 - 6) / 8;
               var6 = (ScriptFrame.field343 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var8 = var17 - 1; var8 <= var6 + 1; ++var8) {
                     if (var7 < var3 || var7 > var4 || var8 < var17 || var8 > var6) {
                        NetCache.archive9.loadRegionFromName("m" + var7 + "_" + var8);
                        NetCache.archive9.loadRegionFromName("l" + var7 + "_" + var8);
                     }
                  }
               }
            }

            class246.updateGameState(30);
            HorizontalAlignment.playPcmPlayers();
            Timer.method2027();
            var18 = Renderable.getPacketBufferNode(ClientPacket.field2503, Client.packetWriter.isaacCipher);
            Client.packetWriter.addNode(var18);
            class204.method1075();
         }
      }
   }

    @ObfuscatedName("ls")
    @ObfuscatedSignature(
            descriptor = "(IIIILrs;Lkb;I)V",
            garbageValue = "-301110153"
    )
    static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpriteMask var5) {
      int var6 = var3 * var3 + var2 * var2;
      if (var6 > 4225 && var6 < 90000) {
         int var7 = Client.camAngleY & 2047;
         int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
         int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
         int var10 = var3 * var8 + var9 * var2 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.width / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         PacketBufferNode.redHintArrowSprite.method2517(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class31.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
      }

   }
}
