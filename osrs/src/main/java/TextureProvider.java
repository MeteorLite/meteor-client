import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ia")
@Implements("TextureProvider")
public class TextureProvider implements TextureLoader {
   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive13")
   static Archive archive13;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "[Lii;"
   )
   @Export("textures")
   Texture[] textures;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lnj;"
   )
   @Export("deque")
   NodeDeque deque = new NodeDeque();
   @ObfuscatedName("ac")
   @Export("capacity")
   int capacity;
   @ObfuscatedName("ab")
   @Export("remaining")
   int remaining = 0;
   @ObfuscatedName("an")
   @Export("brightness")
   double brightness = 1.0D;
   @ObfuscatedName("ao")
   @Export("textureSize")
   int textureSize = 128;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   @Export("archive")
   AbstractArchive archive;

   @ObfuscatedSignature(
      descriptor = "(Lne;Lne;IDI)V"
   )
   public TextureProvider(AbstractArchive var1, AbstractArchive var2, int var3, double var4, int var6) {
      this.archive = var2;
      this.capacity = var3;
      this.remaining = this.capacity;
      this.brightness = var4;
      this.textureSize = var6;
      int[] var7 = var1.getGroupFileIds(0);
      int var8 = var7.length;
      this.textures = new Texture[var1.getGroupFileCount(0)];

      for(int var9 = 0; var9 < var8; ++var9) {
         Buffer var10 = new Buffer(var1.takeFile(0, var7[var9]));
         this.textures[var7[var9]] = new Texture(var10);
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-848273151"
   )
   @Export("getLoadedPercentage")
   public int getLoadedPercentage() {
      int var1 = 0;
      int var2 = 0;
      Texture[] var3 = this.textures;

      for(int var4 = 0; var4 < var3.length; ++var4) {
         Texture var5 = var3[var4];
         if (var5 != null && var5.fileIds != null) {
            var1 += var5.fileIds.length;
            int[] var6 = var5.fileIds;

            for(int var7 = 0; var7 < var6.length; ++var7) {
               int var8 = var6[var7];
               if (this.archive.method1830(var8)) {
                  ++var2;
               }
            }
         }
      }

      if (var1 == 0) {
         return 0;
      } else {
         return var2 * 100 / var1;
      }
   }

   @ObfuscatedName("al")
   @Export("setBrightness")
   public void setBrightness(double var1) {
      this.brightness = var1;
      this.clear();
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)[I",
      garbageValue = "599010973"
   )
   @Export("getTexturePixels")
   public int[] getTexturePixels(int var1) {
      Texture var2 = this.textures[var1];
      if (var2 != null) {
         if (var2.pixels != null) {
            this.deque.addLast(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }

         boolean var3 = var2.load(this.brightness, this.textureSize, this.archive);
         if (var3) {
            if (this.remaining == 0) {
               Texture var4 = (Texture)this.deque.removeFirst();
               var4.reset();
            } else {
               --this.remaining;
            }

            this.deque.addLast(var2);
            var2.isLoaded = true;
            return var2.pixels;
         }
      }

      return null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(IS)I",
      garbageValue = "-1822"
   )
   @Export("getAverageTextureRGB")
   public int getAverageTextureRGB(int var1) {
      return this.textures[var1] != null ? this.textures[var1].averageRGB : 0;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "2046582382"
   )
   @Export("vmethod4645")
   public boolean vmethod4645(int var1) {
      return this.textures[var1].field1915;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1479518028"
   )
   @Export("isLowDetail")
   public boolean isLowDetail(int var1) {
      return this.textureSize == 64;
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "19136782"
   )
   @Export("clear")
   public void clear() {
      for(int var1 = 0; var1 < this.textures.length; ++var1) {
         if (this.textures[var1] != null) {
            this.textures[var1].reset();
         }
      }

      this.deque = new NodeDeque();
      this.remaining = this.capacity;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "48"
   )
   @Export("animate")
   public void animate(int var1) {
      for(int var2 = 0; var2 < this.textures.length; ++var2) {
         Texture var3 = this.textures[var2];
         if (var3 != null && var3.animationDirection != 0 && var3.isLoaded) {
            var3.animate(var1);
            var3.isLoaded = false;
         }
      }

   }

   @ObfuscatedName("kc")
   @ObfuscatedSignature(
      descriptor = "(IIIII)V",
      garbageValue = "888042879"
   )
   @Export("addSceneMenuOptions")
   static final void addSceneMenuOptions(int var0, int var1, int var2, int var3) {
      if (Client.isItemSelected == 0 && !Client.isSpellSelected) {
         class110.insertMenuItemNoShift("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      long var4 = -1L;
      long var6 = -1L;

      int var8;
      for(var8 = 0; var8 < class196.method986(); ++var8) {
         long var9 = class166.method866(var8);
         if (var9 != var6) {
            var6 = var9;
            int var11 = class132.method720(var8);
            int var12 = MoveSpeed.method1114(ViewportMouse.ViewportMouse_entityTags[var8]);
            int var13 = var12;
            long var16 = ViewportMouse.ViewportMouse_entityTags[var8];
            int var15 = (int)(var16 >>> 14 & 3L);
            int var23 = class11.method39(var8);
            int var20;
            if (var15 == 2 && class1.scene.getObjectFlags(TaskHandler.Client_plane, var11, var12, var9) >= 0) {
               ObjectComposition var17 = WallDecoration.getObjectDefinition(var23);
               if (var17.transforms != null) {
                  var17 = var17.transform();
               }

               if (var17 == null) {
                  continue;
               }

               PendingSpawn var18 = null;

               for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.last(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.previous()) {
                  if (var19.plane == TaskHandler.Client_plane && var11 == var19.x && var13 == var19.y && var23 == var19.id) {
                     var18 = var19;
                     break;
                  }
               }

               if (Client.isItemSelected == 1) {
                  class110.insertMenuItemNoShift("Use", Client.field513 + " " + "->" + " " + Canvas.colorStartTag(65535) + var17.name, 1, var23, var11, var13);
               } else if (Client.isSpellSelected) {
                  if ((class90.selectedSpellFlags & 4) == 4) {
                     class110.insertMenuItemNoShift(Client.field583, Client.field518 + " " + "->" + " " + Canvas.colorStartTag(65535) + var17.name, 2, var23, var11, var13);
                  }
               } else {
                  String[] var33 = var17.actions;
                  if (var33 != null) {
                     for(var20 = 4; var20 >= 0; --var20) {
                        if ((var18 == null || var18.method500(var20)) && var33[var20] != null) {
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

                           class110.insertMenuItemNoShift(var33[var20], Canvas.colorStartTag(65535) + var17.name, var21, var23, var11, var13);
                        }
                     }
                  }

                  class110.insertMenuItemNoShift("Examine", Canvas.colorStartTag(65535) + var17.name, 1002, var17.id, var11, var13);
               }
            }

            int var24;
            Player var25;
            NPC var34;
            int[] var35;
            if (var15 == 1) {
               NPC var29 = Client.npcs[var23];
               if (var29 == null) {
                  continue;
               }

               if (var29.definition.size == 1 && (var29.x & 127) == 64 && (var29.y & 127) == 64) {
                  for(var24 = 0; var24 < Client.npcCount; ++var24) {
                     var34 = Client.npcs[Client.npcIndices[var24]];
                     if (var34 != null && var34 != var29 && var34.definition.size == 1 && var34.x == var29.x && var34.y == var29.y) {
                        class260.addNpcToMenu(var34, Client.npcIndices[var24], var11, var13);
                     }
                  }

                  var24 = Players.Players_count;
                  var35 = Players.Players_indices;

                  for(var20 = 0; var20 < var24; ++var20) {
                     var25 = Client.players[var35[var20]];
                     if (var25 != null && var29.x == var25.x && var29.y == var25.y) {
                        class16.addPlayerToMenu(var25, var35[var20], var11, var13);
                     }
                  }
               }

               class260.addNpcToMenu(var29, var23, var11, var13);
            }

            if (var15 == 0) {
               Player var30 = Client.players[var23];
               if (var30 == null) {
                  continue;
               }

               if ((var30.x & 127) == 64 && (var30.y & 127) == 64) {
                  for(var24 = 0; var24 < Client.npcCount; ++var24) {
                     var34 = Client.npcs[Client.npcIndices[var24]];
                     if (var34 != null && var34.definition.size == 1 && var34.x == var30.x && var34.y == var30.y) {
                        class260.addNpcToMenu(var34, Client.npcIndices[var24], var11, var13);
                     }
                  }

                  var24 = Players.Players_count;
                  var35 = Players.Players_indices;

                  for(var20 = 0; var20 < var24; ++var20) {
                     var25 = Client.players[var35[var20]];
                     if (var25 != null && var30 != var25 && var30.x == var25.x && var25.y == var30.y) {
                        class16.addPlayerToMenu(var25, var35[var20], var11, var13);
                     }
                  }
               }

               if (var23 != Client.combatTargetPlayerIndex) {
                  class16.addPlayerToMenu(var30, var23, var11, var13);
               } else {
                  var4 = var9;
               }
            }

            if (var15 == 3) {
               NodeDeque var31 = Client.groundItems[TaskHandler.Client_plane][var11][var13];
               if (var31 != null) {
                  for(TileItem var32 = (TileItem)var31.first(); var32 != null; var32 = (TileItem)var31.next()) {
                     ItemComposition var36 = ParamComposition.ItemDefinition_get(var32.id);
                     if (Client.isItemSelected == 1) {
                        class110.insertMenuItemNoShift("Use", Client.field513 + " " + "->" + " " + Canvas.colorStartTag(16748608) + var36.name, 16, var32.id, var11, var13);
                     } else if (Client.isSpellSelected) {
                        if ((class90.selectedSpellFlags & 1) == 1) {
                           class110.insertMenuItemNoShift(Client.field583, Client.field518 + " " + "->" + " " + Canvas.colorStartTag(16748608) + var36.name, 17, var32.id, var11, var13);
                        }
                     } else {
                        String[] var26 = var36.groundActions;

                        for(int var37 = 4; var37 >= 0; --var37) {
                           if (var32.method593(var37)) {
                              if (var26 != null && var26[var37] != null) {
                                 byte var22 = 0;
                                 if (var37 == 0) {
                                    var22 = 18;
                                 }

                                 if (var37 == 1) {
                                    var22 = 19;
                                 }

                                 if (var37 == 2) {
                                    var22 = 20;
                                 }

                                 if (var37 == 3) {
                                    var22 = 21;
                                 }

                                 if (var37 == 4) {
                                    var22 = 22;
                                 }

                                 class110.insertMenuItemNoShift(var26[var37], Canvas.colorStartTag(16748608) + var36.name, var22, var32.id, var11, var13);
                              } else if (var37 == 2) {
                                 class110.insertMenuItemNoShift("Take", Canvas.colorStartTag(16748608) + var36.name, 20, var32.id, var11, var13);
                              }
                           }
                        }

                        class110.insertMenuItemNoShift("Examine", Canvas.colorStartTag(16748608) + var36.name, 1004, var32.id, var11, var13);
                     }
                  }
               }
            }
         }
      }

      if (-1L != var4) {
         var8 = (int)(var4 >>> 0 & 127L);
         int var10 = MoveSpeed.method1114(var4);
         Player var28 = Client.players[Client.combatTargetPlayerIndex];
         class16.addPlayerToMenu(var28, Client.combatTargetPlayerIndex, var8, var10);
      }

   }
}
