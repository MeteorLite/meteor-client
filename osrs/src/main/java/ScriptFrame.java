import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("ScriptFrame")
public class ScriptFrame {
   @ObfuscatedName("ug")
   static int field343;
    @ObfuscatedName("bc")
    @ObfuscatedSignature(
            descriptor = "Lclient;"
    )
    static Client client;
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lch;"
    )
    Script script;
    @ObfuscatedName("an")
    int pc = -1;
    @ObfuscatedName("aw")
    int[] intLocals;
    @ObfuscatedName("ac")
    String[] stringLocals;

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1705605824"
   )
   public static int method344(int var0) {
      return NPCComposition.method1035(ViewportMouse.ViewportMouse_entityTags[var0]);
   }

    @ObfuscatedName("ls")
    @ObfuscatedSignature(
            descriptor = "(IIIII)V",
            garbageValue = "-1708655552"
    )
    static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
      if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
         MenuAction.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      long var4 = -1L;
      long var6 = -1L;

      int var8;
      for(var8 = 0; var8 < KeyHandler.method109(); ++var8) {
         long var9 = class30.method130(var8);
         if (var6 != var9) {
            var6 = var9;
            int var11 = FaceNormal.method1294(var8);
            int var12 = method344(var8);
            int var13 = TextureProvider.method1306(ViewportMouse.ViewportMouse_entityTags[var8]);
            int var15 = InterfaceParent.Entity_unpackID(ViewportMouse.ViewportMouse_entityTags[var8]);
            int var16 = var15;
            int var20;
            if (var13 == 2 && class31.scene.getObjectFlags(GameEngine.Client_plane, var11, var12, var9) >= 0) {
               ObjectComposition var17 = class144.getObjectDefinition(var15);
               if (var17.transforms != null) {
                  var17 = var17.transform();
               }

               if (var17 == null) {
                  continue;
               }

               PendingSpawn var18 = null;

               for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.last(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.previous()) {
                  if (var19.plane == GameEngine.Client_plane && var11 == var19.x && var12 == var19.y && var16 == var19.id) {
                     var18 = var19;
                     break;
                  }
               }

               if (Client.isItemSelected == 1) {
                  MenuAction.insertMenuItemNoShift("Use", Client.field364 + " " + "->" + " " + class383.colorStartTag(65535) + var17.name, 1, var16, var11, var12);
               } else if (Client.isSpellSelected) {
                  if ((SecureRandomFuture.selectedSpellFlags & 4) == 4) {
                     MenuAction.insertMenuItemNoShift(Client.field530, Client.field522 + " " + "->" + " " + class383.colorStartTag(65535) + var17.name, 2, var16, var11, var12);
                  }
               } else {
                  String[] var32 = var17.actions;
                  if (var32 != null) {
                     for(var20 = 4; var20 >= 0; --var20) {
                        if ((var18 == null || var18.method525(var20)) && var32[var20] != null) {
                           short var21 = 0;
                           if (var20 == 0) {
                              var21 = 3;
                           }

                           if (var20 == 1) {
                              var21 = 4;
                           }

                           if (var20 == 2) {
                              var21 = 5;
                           }

                           if (var20 == 3) {
                              var21 = 6;
                           }

                           if (var20 == 4) {
                              var21 = 1001;
                           }

                           MenuAction.insertMenuItemNoShift(var32[var20], class383.colorStartTag(65535) + var17.name, var21, var16, var11, var12);
                        }
                     }
                  }

                  MenuAction.insertMenuItemNoShift("Examine", class383.colorStartTag(65535) + var17.name, 1002, var17.id, var11, var12);
               }
            }

            int var23;
            Player var24;
            NPC var33;
            int[] var34;
            if (var13 == 1) {
               NPC var28 = Client.npcs[var16];
               if (var28 == null) {
                  continue;
               }

               if (var28.definition.size == 1 && (var28.x & 127) == 64 && (var28.y & 127) == 64) {
                  for(var23 = 0; var23 < Client.npcCount; ++var23) {
                     var33 = Client.npcs[Client.npcIndices[var23]];
                     if (var33 != null && var28 != var33 && var33.definition.size == 1 && var28.x == var33.x && var28.y == var33.y) {
                        InvDefinition.addNpcToMenu(var33, Client.npcIndices[var23], var11, var12);
                     }
                  }

                  var23 = Players.Players_count;
                  var34 = Players.Players_indices;

                  for(var20 = 0; var20 < var23; ++var20) {
                     var24 = Client.players[var34[var20]];
                     if (var24 != null && var24.x == var28.x && var24.y == var28.y) {
                        DynamicObject.addPlayerToMenu(var24, var34[var20], var11, var12);
                     }
                  }
               }

               InvDefinition.addNpcToMenu(var28, var16, var11, var12);
            }

            if (var13 == 0) {
               Player var29 = Client.players[var16];
               if (var29 == null) {
                  continue;
               }

               if ((var29.x & 127) == 64 && (var29.y & 127) == 64) {
                  for(var23 = 0; var23 < Client.npcCount; ++var23) {
                     var33 = Client.npcs[Client.npcIndices[var23]];
                     if (var33 != null && var33.definition.size == 1 && var29.x == var33.x && var33.y == var29.y) {
                        InvDefinition.addNpcToMenu(var33, Client.npcIndices[var23], var11, var12);
                     }
                  }

                  var23 = Players.Players_count;
                  var34 = Players.Players_indices;

                  for(var20 = 0; var20 < var23; ++var20) {
                     var24 = Client.players[var34[var20]];
                     if (var24 != null && var29 != var24 && var29.x == var24.x && var24.y == var29.y) {
                        DynamicObject.addPlayerToMenu(var24, var34[var20], var11, var12);
                     }
                  }
               }

               if (var16 != Client.combatTargetPlayerIndex) {
                  DynamicObject.addPlayerToMenu(var29, var16, var11, var12);
               } else {
                  var4 = var9;
               }
            }

            if (var13 == 3) {
               NodeDeque var30 = Client.groundItems[GameEngine.Client_plane][var11][var12];
               if (var30 != null) {
                  for(TileItem var31 = (TileItem)var30.first(); var31 != null; var31 = (TileItem)var30.next()) {
                     ItemComposition var35 = HealthBarUpdate.ItemDefinition_get(var31.id);
                     if (Client.isItemSelected == 1) {
                        MenuAction.insertMenuItemNoShift("Use", Client.field364 + " " + "->" + " " + class383.colorStartTag(16748608) + var35.name, 16, var31.id, var11, var12);
                     } else if (Client.isSpellSelected) {
                        if ((SecureRandomFuture.selectedSpellFlags & 1) == 1) {
                           MenuAction.insertMenuItemNoShift(Client.field530, Client.field522 + " " + "->" + " " + class383.colorStartTag(16748608) + var35.name, 17, var31.id, var11, var12);
                        }
                     } else {
                        String[] var25 = var35.groundActions;

                        for(int var36 = 4; var36 >= 0; --var36) {
                           if (var31.method625(var36)) {
                              if (var25 != null && var25[var36] != null) {
                                 byte var22 = 0;
                                 if (var36 == 0) {
                                    var22 = 18;
                                 }

                                 if (var36 == 1) {
                                    var22 = 19;
                                 }

                                 if (var36 == 2) {
                                    var22 = 20;
                                 }

                                 if (var36 == 3) {
                                    var22 = 21;
                                 }

                                 if (var36 == 4) {
                                    var22 = 22;
                                 }

                                 MenuAction.insertMenuItemNoShift(var25[var36], class383.colorStartTag(16748608) + var35.name, var22, var31.id, var11, var12);
                              } else if (var36 == 2) {
                                 MenuAction.insertMenuItemNoShift("Take", class383.colorStartTag(16748608) + var35.name, 20, var31.id, var11, var12);
                              }
                           }
                        }

                        MenuAction.insertMenuItemNoShift("Examine", class383.colorStartTag(16748608) + var35.name, 1004, var31.id, var11, var12);
                     }
                  }
               }
            }
         }
      }

      if (var4 != -1L) {
         var8 = (int)(var4 >>> 0 & 127L);
         int var10 = NPCComposition.method1035(var4);
         Player var27 = Client.players[Client.combatTargetPlayerIndex];
         DynamicObject.addPlayerToMenu(var27, Client.combatTargetPlayerIndex, var8, var10);
      }

   }

   @ObfuscatedName("mg")
   static final void method341(double var0) {
      class18.method72(var0);
      ((TextureProvider)Rasterizer3D.clips.Rasterizer3D_textureLoader).setBrightness(var0);
      class127.method761();
      class20.clientPreferences.setBrightness(var0);
   }

   @ObfuscatedName("nt")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)V",
      garbageValue = "-42"
   )
   static void method343(String var0) {
      class108.param9 = var0;

      try {
         String var1 = client.getParameter(Integer.toString(18));
         String var2 = client.getParameter(Integer.toString(13));
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if (var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class136.method789(class96.clockNow() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class26.method111(client, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }
}
