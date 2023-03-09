import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
@Implements("SoundSystem")
public class SoundSystem implements Runnable {
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("scriptActiveWidget")
   static Widget scriptActiveWidget;
   @ObfuscatedName("au")
   @Export("ByteArrayPool_altSizeArrayCounts")
   public static int[] ByteArrayPool_altSizeArrayCounts;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "[Lbd;"
   )
   @Export("players")
   volatile PcmPlayer[] players = new PcmPlayer[2];

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      try {
         for(int var1 = 0; var1 < 2; ++var1) {
            PcmPlayer var2 = this.players[var1];
            if (var2 != null) {
               var2.run();
            }
         }
      } catch (Exception var4) {
         class364.RunException_sendStackTrace((String)null, var4);
      }

   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "27"
   )
   static int method225(int var0, Script var1, boolean var2) {
      if (var0 == 5000) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.publicChatMode;
         return 1;
      } else if (var0 == 5001) {
         Interpreter.Interpreter_intStackSize -= 3;
         Client.publicChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         class207.privateChatMode = class181.method924(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         if (class207.privateChatMode == null) {
            class207.privateChatMode = PrivateChatMode.field4086;
         }

         Client.tradeChatMode = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         PacketBufferNode var11 = UserComparator9.getPacketBufferNode(ClientPacket.field2449, Client.packetWriter.isaacCipher);
         var11.packetBuffer.writeByte(Client.publicChatMode);
         var11.packetBuffer.writeByte(class207.privateChatMode.id);
         var11.packetBuffer.writeByte(Client.tradeChatMode);
         Client.packetWriter.addNode(var11);
         return 1;
      } else {
         String var3;
         int var4;
         int var5;
         PacketBufferNode var6;
         if (var0 == 5002) {
            var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
            Interpreter.Interpreter_intStackSize -= 2;
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var6 = UserComparator9.getPacketBufferNode(ClientPacket.field2503, Client.packetWriter.isaacCipher);
            var6.packetBuffer.writeByte(WorldMapLabel.stringCp1252NullTerminatedByteSize(var3) + 2);
            var6.packetBuffer.writeStringCp1252NullTerminated(var3);
            var6.packetBuffer.writeByte(var4 - 1);
            var6.packetBuffer.writeByte(var5);
            Client.packetWriter.addNode(var6);
            return 1;
         } else {
            int var7;
            Message var8;
            if (var0 == 5003) {
               Interpreter.Interpreter_intStackSize -= 2;
               var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var8 = TaskHandler.Messages_getByChannelAndID(var7, var4);
               if (var8 != null) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.count;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.cycle;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               Message var9;
               if (var0 == 5004) {
                  var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var9 = class208.Messages_getMessage(var7);
                  if (var9 != null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.type;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.cycle;
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  }

                  return 1;
               } else if (var0 == 5005) {
                  if (class207.privateChatMode == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class207.privateChatMode.id;
                  }

                  return 1;
               } else {
                  PacketBufferNode var12;
                  if (var0 == 5008) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                     var12 = BuddyRankComparator.method670(var4, var3, class69.clientLanguage, -1);
                     Client.packetWriter.addNode(var12);
                     return 1;
                  } else if (var0 == 5009) {
                     HealthBar.Interpreter_stringStackSize -= 2;
                     var3 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize];
                     String var13 = Interpreter.Interpreter_stringStack[HealthBar.Interpreter_stringStackSize + 1];
                     var12 = UserComparator9.getPacketBufferNode(ClientPacket.field2507, Client.packetWriter.isaacCipher);
                     var12.packetBuffer.writeShort(0);
                     int var10 = var12.packetBuffer.offset;
                     var12.packetBuffer.writeStringCp1252NullTerminated(var3);
                     ClanChannel.method840(var12.packetBuffer, var13);
                     var12.packetBuffer.writeLengthShort(var12.packetBuffer.offset - var10);
                     Client.packetWriter.addNode(var12);
                     return 1;
                  } else if (var0 == 5010) {
                     var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                     Interpreter.Interpreter_intStackSize -= 2;
                     var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                     var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                     var6 = BuddyRankComparator.method670(var4, var3, class69.clientLanguage, var5);
                     Client.packetWriter.addNode(var6);
                     return 1;
                  } else if (var0 != 5015) {
                     if (var0 == 5016) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.tradeChatMode;
                        return 1;
                     } else if (var0 == 5017) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SecureRandomCallable.Messages_getHistorySize(var7);
                        return 1;
                     } else if (var0 == 5018) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class1.Messages_getLastChatID(var7);
                        return 1;
                     } else if (var0 == 5019) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class329.method1800(var7);
                        return 1;
                     } else if (var0 == 5020) {
                        var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                        class122.doCheat(var3);
                        return 1;
                     } else if (var0 == 5021) {
                        Client.field510 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize].toLowerCase().trim();
                        return 1;
                     } else if (var0 == 5022) {
                        Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = Client.field510;
                        return 1;
                     } else if (var0 == 5023) {
                        var3 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
                        System.out.println(var3);
                        return 1;
                     } else if (var0 == 5030) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
                        var8 = TaskHandler.Messages_getByChannelAndID(var7, var4);
                        if (var8 != null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.count;
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.cycle;
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var8.sender != null ? var8.sender : "";
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var8.prefix != null ? var8.prefix : "";
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var8.text != null ? var8.text : "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.isFromFriend() ? 1 : (var8.isFromIgnored() ? 2 : 0);
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                        }

                        return 1;
                     } else if (var0 == 5031) {
                        var7 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                        var9 = class208.Messages_getMessage(var7);
                        if (var9 != null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.type;
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.cycle;
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9.sender != null ? var9.sender : "";
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9.prefix != null ? var9.prefix : "";
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var9.text != null ? var9.text : "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var9.isFromFriend() ? 1 : (var9.isFromIgnored() ? 2 : 0);
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                        }

                        return 1;
                     } else {
                        return 2;
                     }
                  } else {
                     if (BuddyRankComparator.localPlayer != null && BuddyRankComparator.localPlayer.username != null) {
                        var3 = BuddyRankComparator.localPlayer.username.getName();
                     } else {
                        var3 = "";
                     }

                     Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var3;
                     return 1;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1153770034"
   )
   static final void method224() {
      BoundaryObject.method1298(false);
      Client.field500 = 0;
      boolean var0 = true;

      int var1;
      for(var1 = 0; var1 < GrandExchangeOfferOwnWorldComparator.regionLandArchives.length; ++var1) {
         if (PacketBuffer.regionMapArchiveIds[var1] != -1 && GrandExchangeOfferOwnWorldComparator.regionLandArchives[var1] == null) {
            GrandExchangeOfferOwnWorldComparator.regionLandArchives[var1] = ClientPreferences.archive9.takeFile(PacketBuffer.regionMapArchiveIds[var1], 0);
            if (GrandExchangeOfferOwnWorldComparator.regionLandArchives[var1] == null) {
               var0 = false;
               ++Client.field500;
            }
         }

         if (class123.regionLandArchiveIds[var1] != -1 && class372.regionMapArchives[var1] == null) {
            class372.regionMapArchives[var1] = ClientPreferences.archive9.takeFileEncrypted(class123.regionLandArchiveIds[var1], 0, ModelData0.xteaKeys[var1]);
            if (class372.regionMapArchives[var1] == null) {
               var0 = false;
               ++Client.field500;
            }
         }
      }

      if (!var0) {
         Client.field376 = 1;
      } else {
         Client.field422 = 0;
         var0 = true;

         int var3;
         int var4;
         for(var1 = 0; var1 < GrandExchangeOfferOwnWorldComparator.regionLandArchives.length; ++var1) {
            byte[] var2 = class372.regionMapArchives[var1];
            if (var2 != null) {
               var3 = (class12.regions[var1] >> 8) * 64 - GameEngine.baseX;
               var4 = (class12.regions[var1] & 255) * 64 - class178.baseY;
               if (Client.isInInstance) {
                  var3 = 10;
                  var4 = 10;
               }

               var0 &= class150.method787(var2, var3, var4);
            }
         }

         if (!var0) {
            Client.field376 = 2;
         } else {
            if (Client.field376 != 0) {
               class16.drawLoadingMessage("Loading - please wait." + "<br>" + " (" + 100 + "%" + ")", true);
            }

            EnumComposition.playPcmPlayers();
            class1.scene.clear();

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

            EnumComposition.playPcmPlayers();
            class12.method42();
            var1 = GrandExchangeOfferOwnWorldComparator.regionLandArchives.length;
            class389.method2048();
            BoundaryObject.method1298(true);
            int var17;
            if (!Client.isInInstance) {
               byte[] var5;
               for(var15 = 0; var15 < var1; ++var15) {
                  var3 = (class12.regions[var15] >> 8) * 64 - GameEngine.baseX;
                  var4 = (class12.regions[var15] & 255) * 64 - class178.baseY;
                  var5 = GrandExchangeOfferOwnWorldComparator.regionLandArchives[var15];
                  if (var5 != null) {
                     EnumComposition.playPcmPlayers();
                     Decimator.method311(var5, var3, var4, class124.timeOfPreviousKeyPress * 8 - 48, ArchiveDiskActionHandler.field3408 * 8 - 48, Client.collisionMaps);
                  }
               }

               for(var15 = 0; var15 < var1; ++var15) {
                  var3 = (class12.regions[var15] >> 8) * 64 - GameEngine.baseX;
                  var4 = (class12.regions[var15] & 255) * 64 - class178.baseY;
                  var5 = GrandExchangeOfferOwnWorldComparator.regionLandArchives[var15];
                  if (var5 == null && ArchiveDiskActionHandler.field3408 < 800) {
                     EnumComposition.playPcmPlayers();
                     class350.method1886(var3, var4, 64, 64);
                  }
               }

               BoundaryObject.method1298(true);

               for(var15 = 0; var15 < var1; ++var15) {
                  byte[] var16 = class372.regionMapArchives[var15];
                  if (var16 != null) {
                     var4 = (class12.regions[var15] >> 8) * 64 - GameEngine.baseX;
                     var17 = (class12.regions[var15] & 255) * 64 - class178.baseY;
                     EnumComposition.playPcmPlayers();
                     WorldMapDecoration.method1458(var16, var4, var17, class1.scene, Client.collisionMaps);
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
                  EnumComposition.playPcmPlayers();

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

                           for(int var12 = 0; var12 < class12.regions.length; ++var12) {
                              if (class12.regions[var12] == var11 && GrandExchangeOfferOwnWorldComparator.regionLandArchives[var12] != null) {
                                 int var13 = (var9 - var3) * 8;
                                 int var14 = (var10 - var4) * 8;
                                 class220.method1179(GrandExchangeOfferOwnWorldComparator.regionLandArchives[var12], var15, var3 * 8, var4 * 8, var7, (var9 & 7) * 8, (var10 & 7) * 8, var8, var13, var14, Client.collisionMaps);
                                 var19 = true;
                                 break;
                              }
                           }
                        }

                        if (!var19) {
                           MenuAction.method420(var15, var3 * 8, var4 * 8);
                        }
                     }
                  }
               }

               for(var15 = 0; var15 < 13; ++var15) {
                  for(var3 = 0; var3 < 13; ++var3) {
                     var4 = Client.instanceChunkTemplates[0][var15][var3];
                     if (var4 == -1) {
                        class350.method1886(var15 * 8, var3 * 8, 8, 8);
                     }
                  }
               }

               BoundaryObject.method1298(true);

               for(var15 = 0; var15 < 4; ++var15) {
                  EnumComposition.playPcmPlayers();

                  for(var3 = 0; var3 < 13; ++var3) {
                     for(var4 = 0; var4 < 13; ++var4) {
                        var17 = Client.instanceChunkTemplates[var15][var3][var4];
                        if (var17 != -1) {
                           var6 = var17 >> 24 & 3;
                           var7 = var17 >> 1 & 3;
                           var8 = var17 >> 14 & 1023;
                           var9 = var17 >> 3 & 2047;
                           var10 = (var8 / 8 << 8) + var9 / 8;

                           for(var11 = 0; var11 < class12.regions.length; ++var11) {
                              if (class12.regions[var11] == var10 && class372.regionMapArchives[var11] != null) {
                                 Tiles.method449(class372.regionMapArchives[var11], var15, var3 * 8, var4 * 8, var6, (var8 & 7) * 8, (var9 & 7) * 8, var7, class1.scene, Client.collisionMaps);
                                 break;
                              }
                           }
                        }
                     }
                  }
               }
            }

            BoundaryObject.method1298(true);
            EnumComposition.playPcmPlayers();
            UserComparator7.method655(class1.scene, Client.collisionMaps);
            BoundaryObject.method1298(true);
            var15 = Tiles.Tiles_minPlane;
            if (var15 > TaskHandler.Client_plane) {
               var15 = TaskHandler.Client_plane;
            }

            if (var15 < TaskHandler.Client_plane - 1) {
               var15 = TaskHandler.Client_plane - 1;
            }

            if (Client.isLowDetail) {
               class1.scene.init(Tiles.Tiles_minPlane);
            } else {
               class1.scene.init(0);
            }

            for(var3 = 0; var3 < 104; ++var3) {
               for(var4 = 0; var4 < 104; ++var4) {
                  class148.updateItemPile(var3, var4);
               }
            }

            EnumComposition.playPcmPlayers();
            UserComparator8.method652();
            ObjectComposition.ObjectDefinition_cachedModelData.clear();
            PacketBufferNode var18;
            if (class392.client.hasFrame()) {
               var18 = UserComparator9.getPacketBufferNode(ClientPacket.field2513, Client.packetWriter.isaacCipher);
               var18.packetBuffer.writeInt(1057001181);
               Client.packetWriter.addNode(var18);
            }

            if (!Client.isInInstance) {
               var3 = (class124.timeOfPreviousKeyPress - 6) / 8;
               var4 = (class124.timeOfPreviousKeyPress + 6) / 8;
               var17 = (ArchiveDiskActionHandler.field3408 - 6) / 8;
               var6 = (ArchiveDiskActionHandler.field3408 + 6) / 8;

               for(var7 = var3 - 1; var7 <= var4 + 1; ++var7) {
                  for(var8 = var17 - 1; var8 <= var6 + 1; ++var8) {
                     if (var7 < var3 || var7 > var4 || var8 < var17 || var8 > var6) {
                        ClientPreferences.archive9.loadRegionFromName("m" + var7 + "_" + var8);
                        ClientPreferences.archive9.loadRegionFromName("l" + var7 + "_" + var8);
                     }
                  }
               }
            }

            class19.updateGameState(30);
            EnumComposition.playPcmPlayers();
            class36.method176();
            var18 = UserComparator9.getPacketBufferNode(ClientPacket.field2422, Client.packetWriter.isaacCipher);
            Client.packetWriter.addNode(var18);
            Strings.method1804();
         }
      }
   }
}
