import java.awt.FontMetrics;
import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bb")
public class class27 {
    @ObfuscatedName("bi")
    static FontMetrics loginScreenFontMetrics;
   @ObfuscatedName("aq")
   int[] field82 = new int[112];
   @ObfuscatedName("al")
   int[] field83 = new int[192];

   public class27() {
      Arrays.fill(this.field82, 3);
      Arrays.fill(this.field83, 3);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "0"
   )
   public void method114(int var1, int var2) {
      if (this.method121(var1) && this.method123(var2)) {
         this.field82[var1] = var2;
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(CII)V",
      garbageValue = "48495477"
   )
   public void method115(char var1, int var2) {
      if (this.method125(var1) && this.method123(var2)) {
         this.field83[var1] = var2;
      }

   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-428082252"
   )
   public int method116(int var1) {
      return this.method121(var1) ? this.field82[var1] : 0;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(CB)I",
      garbageValue = "32"
   )
   public int method117(char var1) {
      return this.method125(var1) ? this.field83[var1] : 0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1749930084"
   )
   public boolean method118(int var1) {
      return this.method121(var1) && (this.field82[var1] == 1 || this.field82[var1] == 3);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "-528043848"
   )
   public boolean method119(char var1) {
      return this.method125(var1) && (this.field83[var1] == 1 || this.field83[var1] == 3);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1380991347"
   )
   public boolean method120(int var1) {
      return this.method121(var1) && (this.field82[var1] == 2 || this.field82[var1] == 3);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1152812714"
   )
   public boolean method124(char var1) {
      return this.method125(var1) && (this.field83[var1] == 2 || this.field83[var1] == 3);
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "2137123671"
   )
   boolean method121(int var1) {
      if (var1 >= 0 && var1 < 112) {
         return true;
      } else {
         System.out.println("Invalid keycode: " + var1);
         return false;
      }
   }

   @ObfuscatedName("aa")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1305668583"
   )
   boolean method125(char var1) {
      if (var1 >= 0 && var1 < 192) {
         return true;
      } else {
         System.out.println("Invalid keychar: " + var1);
         return false;
      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1805766557"
   )
   boolean method123(int var1) {
      if (var1 >= 0 && var1 < 4) {
         return true;
      } else {
         System.out.println("Invalid mode: " + var1);
         return false;
      }
   }

   @ObfuscatedName("jh")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-52"
   )
   static final void method122() {
      Language.method1946(false);
      Client.field427 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < class4.regionLandArchives.length; ++var1) {
         if (FontName.regionMapArchiveIds[var1] != -1 && class4.regionLandArchives[var1] == null) {
            class4.regionLandArchives[var1] = GrandExchangeOfferTotalQuantityComparator.archive9.takeFile(FontName.regionMapArchiveIds[var1], 0);
            if (class4.regionLandArchives[var1] == null) {
               var0 = false;
               ++Client.field427;
            }
         }

         if (Archive.regionLandArchiveIds[var1] != -1 && ObjectSound.regionMapArchives[var1] == null) {
            ObjectSound.regionMapArchives[var1] = GrandExchangeOfferTotalQuantityComparator.archive9.takeFileEncrypted(Archive.regionLandArchiveIds[var1], 0, GameObject.xteaKeys[var1]);
            if (ObjectSound.regionMapArchives[var1] == null) {
               var0 = false;
               ++Client.field427;
            }
         }
      }

      if (!var0) {
         Client.field489 = 1;
      } else {
         Client.field425 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < class4.regionLandArchives.length; ++var1) {
            byte[] var2 = ObjectSound.regionMapArchives[var1];
            if (var2 != null) {
               var3 = (WorldMapAreaData.regions[var1] >> 8) * 64 - WorldMapData_0.baseX;
               var4 = (WorldMapAreaData.regions[var1] & 255) * 64 - GameObject.baseY;
               if (Client.isInInstance) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= KitDefinition.method994(var2, var3, var4);
            }
         }

         if (!var0) {
            Client.field489 = 2;
         } else {
            if (Client.field489 != 0) {
               WorldMapDecoration.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            class323.playPcmPlayers();
            class31.scene.clear();

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

            class323.playPcmPlayers();
            class137.method792();
            var1 = class4.regionLandArchives.length;
            StructComposition.method1068();
            Language.method1946(true);
            int var17;
            if (!Client.isInInstance) {
               byte[] var5;
               for(var15 = 0; var15 < var1; ++var15) {
                  var3 = (WorldMapAreaData.regions[var15] >> 8) * 64 - WorldMapData_0.baseX;
                  var4 = (WorldMapAreaData.regions[var15] & 255) * 64 - GameObject.baseY;
                  var5 = class4.regionLandArchives[var15];
                  if (var5 != null) {
                     class323.playPcmPlayers();
                     WallDecoration.method1384(var5, var3, var4, class28.timeOfPreviousKeyPress * 8 - 48, class425.field3798 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var15 = 0; var15 < var1; ++var15) {
                  var3 = (WorldMapAreaData.regions[var15] >> 8) * 64 - WorldMapData_0.baseX;
                  var4 = (WorldMapAreaData.regions[var15] & 255) * 64 - GameObject.baseY;
                  var5 = class4.regionLandArchives[var15];
                  if (var5 == null && class425.field3798 < 800) {
                     class323.playPcmPlayers();
                     class122.method736(var3, var4, 64, 64);
                  }
               }

               Language.method1946(true);

               for(var15 = 0; var15 < var1; ++var15) {
                  byte[] var16 = ObjectSound.regionMapArchives[var15];
                  if (var16 != null) {
                     var4 = (WorldMapAreaData.regions[var15] >> 8) * 64 - WorldMapData_0.baseX;
                     var17 = (WorldMapAreaData.regions[var15] & 255) * 64 - GameObject.baseY;
                     class323.playPcmPlayers();
                     class147.method837(var16, var4, var17, class31.scene, Client.collisionMaps);
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
                  class323.playPcmPlayers();

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

                           for(int var12 = 0; var12 < WorldMapAreaData.regions.length; ++var12) {
                              if (WorldMapAreaData.regions[var12] == var11 && class4.regionLandArchives[var12] != null) {
                                 int var13 = (var9 - var3) * 8;
                                 int var14 = (var10 - var4) * 8;
                                 class19.method78(class4.regionLandArchives[var12], var15, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, var13, var14, Client.collisionMaps);
                                 var19 = true;
                                 break;
                              }
                           }
                        }

                        if (!var19) {
                           TextureProvider.method1307(var15, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var15 = 0; var15 < 13; ++var15) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.instanceChunkTemplates[0][var15][var3];
                     if (var4 == -1) {
                        class122.method736(var15 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               Language.method1946(true);

               for(var15 = 0; var15 < 4; ++var15) {
                  class323.playPcmPlayers();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var17 = Client.instanceChunkTemplates[var15][var3][var4];
                        if (var17 != -1) {
                           var6 = var17 >> 24 & 3;
                           var7 = var17 >> 1 & 3;
                           var8 = var17 >> 14 & 1023;
                           var9 = var17 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < WorldMapAreaData.regions.length; ++var11) {
                              if (WorldMapAreaData.regions[var11] == var10 && ObjectSound.regionMapArchives[var11] != null) {
                                 Tiles.method473(ObjectSound.regionMapArchives[var11], var15, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, class31.scene, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            Language.method1946(true);
            class323.playPcmPlayers();
            class10.method39(class31.scene, Client.collisionMaps);
            Language.method1946(true);
            var15 = Tiles.Tiles_minPlane;
            if (var15 > GameEngine.Client_plane) {
               var15 = GameEngine.Client_plane;
            }

            if (var15 < GameEngine.Client_plane - 1) {
               var15 = GameEngine.Client_plane - 1;
            }

            if (Client.isLowDetail) {
               class31.scene.init(Tiles.Tiles_minPlane);
            } else {
               class31.scene.init(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class121.updateItemPile(var3, var4);
               }
            }

            class323.playPcmPlayers();
            KeyHandler.method107();
            ObjectComposition.ObjectDefinition_cachedModelData.clear();
            PacketBufferNode var18;
            if (ScriptFrame.client.hasFrame()) {
               var18 = class330.getPacketBufferNode(ClientPacket.field2500, Client.packetWriter.isaacCipher);
               var18.packetBuffer.writeInt(1057001181);
               Client.packetWriter.addNode(var18);
            }

            if (!Client.isInInstance) {
               var3 = (class28.timeOfPreviousKeyPress - 6) / 8;
               var4 = (class28.timeOfPreviousKeyPress + 6) / 8;
               var17 = (class425.field3798 - 6) / 8;
               var6 = (class425.field3798 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var8 = var17 - 1; var8 <= var6 + 1; ++var8) {
                     if (var7 < var3 || var7 > var4 || var8 < var17 || var8 > var6) {
                        GrandExchangeOfferTotalQuantityComparator.archive9.loadRegionFromName("m" + var7 + "_" + var8);
                        GrandExchangeOfferTotalQuantityComparator.archive9.loadRegionFromName("l" + var7 + "_" + var8);
                     }
                  }
               }
            }

            class138.updateGameState(30);
            class323.playPcmPlayers();
            Renderable.method1291();
            var18 = class330.getPacketBufferNode(ClientPacket.field2538, Client.packetWriter.isaacCipher);
            Client.packetWriter.addNode(var18);
            NPC.method611();
         }
      }
   }
}
