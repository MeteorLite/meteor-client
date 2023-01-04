import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.Queue;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("UrlRequester")
public abstract class UrlRequester implements Runnable {
   @ObfuscatedName("h")
   final Thread field1142 = new Thread(this);
   @ObfuscatedName("e")
   volatile boolean isClosed;
   @ObfuscatedName("v")
   Queue requests = new LinkedList();
   @ObfuscatedName("x")
   int field1139;

   UrlRequester(int var1) {
      this.field1142.setPriority(1);
      this.field1142.start();
      this.field1139 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ldm;I)V",
      garbageValue = "756674113"
   )
   abstract void vmethod2700(UrlRequest var1) throws IOException;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URLConnection;I)V",
      garbageValue = "-572226816"
   )
   void method639(URLConnection var1) {
      var1.setConnectTimeout(5000);
      var1.setReadTimeout(5000);
      var1.setUseCaches(false);
      var1.setRequestProperty("Connection", "close");
      var1.setRequestProperty("User-Agent", "OldSchoolRuneScape/" + this.field1139);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URLConnection;Ldm;B)V",
      garbageValue = "-37"
   )
   void method642(URLConnection var1, UrlRequest var2) {
      DataInputStream var3 = null;

      try {
         int var5 = var1.getContentLength();
         var3 = new DataInputStream(var1.getInputStream());
         byte[] var4;
         if (var5 >= 0) {
            var4 = new byte[var5];
            var3.readFully(var4);
         } else {
            var4 = new byte[0];
            byte[] var6 = ItemContainer.ByteArrayPool_getArray(5000);

            byte[] var8;
            for(int var7 = var3.read(var6, 0, var6.length); var7 > -1; var4 = var8) {
               var8 = new byte[var4.length + var7];
               System.arraycopy(var4, 0, var8, 0, var4.length);
               System.arraycopy(var6, 0, var8, var4.length, var7);
            }

            class200.ByteArrayPool_release(var6);
         }

         var2.response0 = var4;
      } catch (IOException var10) {
         ;
      }

      if (var3 != null) {
         try {
            var3.close();
         } catch (IOException var9) {
            ;
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Ljava/net/URL;B)Ldm;",
      garbageValue = "1"
   )
   public UrlRequest request(URL var1) {
      UrlRequest var2 = new UrlRequest(var1);
      synchronized(this) {
         this.requests.add(var2);
         this.notify();
         return var2;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-73462571"
   )
   public void close() {
      this.isClosed = true;

      try {
         synchronized(this) {
            this.notify();
         }

         this.field1142.join();
      } catch (InterruptedException var4) {
         ;
      }

   }

   @ObfuscatedName("run")
   public void run() {
      while(!this.isClosed) {
         try {
            UrlRequest var1;
            synchronized(this) {
               var1 = (UrlRequest)this.requests.poll();
               if (var1 == null) {
                  try {
                     this.wait();
                  } catch (InterruptedException var5) {
                     ;
                  }
                  continue;
               }
            }

            this.vmethod2700(var1);
         } catch (Exception var7) {
            class132.RunException_sendStackTrace((String)null, var7);
         }
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "8"
   )
   static void method644() {
      for(ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var0.stream1 != null) {
            ApproximateRouteStrategy.pcmStreamMixer.removeSubStream(var0.stream1);
            var0.stream1 = null;
         }

         if (var0.stream2 != null) {
            ApproximateRouteStrategy.pcmStreamMixer.removeSubStream(var0.stream2);
            var0.stream2 = null;
         }
      }

      ObjectSound.objectSounds.clear();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;Lly;ZI)V",
      garbageValue = "-414686361"
   )
   public static void method645(AbstractArchive var0, AbstractArchive var1, boolean var2) {
      ObjectComposition.ObjectDefinition_archive = var0;
      SoundSystem.ObjectDefinition_modelsArchive = var1;
      ObjectComposition.ObjectDefinition_isLowDetail = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(IIIIIILhc;Lgw;I)V",
      garbageValue = "14932540"
   )
   static final void addObjects(int var0, int var1, int var2, int var3, int var4, int var5, Scene var6, CollisionMap var7) {
      if (!Client.isLowDetail || (Tiles.Tiles_renderFlags[0][var1][var2] & 2) != 0 || (Tiles.Tiles_renderFlags[var0][var1][var2] & 16) == 0) {
         if (var0 < Tiles.Tiles_minPlane) {
            Tiles.Tiles_minPlane = var0;
         }

         ObjectComposition var8 = VarpDefinition.getObjectDefinition(var3);
         int var9;
         int var10;
         if (var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if (var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = (var9 + 1 >> 1) + var1;
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if (var10 + var2 <= 104) {
            var13 = (var10 >> 1) + var2;
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = Tiles.Tiles_heights[var0];
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         long var19 = GameEngine.calculateTag(var1, var2, 2, var8.int1 == 0, var3);
         int var21 = var5 + (var4 << 6);
         if (var8.int3 == 1) {
            var21 += 256;
         }

         int var23;
         int var24;
         if (var8.hasSound()) {
            ObjectSound var22 = new ObjectSound();
            var22.plane = var0;
            var22.x = var1 * 128;
            var22.y = var2 * 128;
            var23 = var8.sizeX;
            var24 = var8.sizeY;
            if (var4 == 1 || var4 == 3) {
               var23 = var8.sizeY;
               var24 = var8.sizeX;
            }

            var22.maxX = (var23 + var1) * 128;
            var22.maxY = (var24 + var2) * 128;
            var22.soundEffectId = var8.ambientSoundId;
            var22.field680 = var8.int7 * 128;
            var22.field675 = var8.int5;
            var22.field672 = var8.int6;
            var22.soundEffectIds = var8.soundEffectIds;
            if (var8.transforms != null) {
               var22.obj = var8;
               var22.set();
            }

            ObjectSound.objectSounds.addFirst(var22);
            if (var22.soundEffectIds != null) {
               var22.field683 = var22.field675 + (int)(Math.random() * (double)(var22.field672 - var22.field675));
            }
         }

         Object var34;
         if (var5 == 22) {
            if (!Client.isLowDetail || var8.int1 != 0 || var8.interactType == 1 || var8.boolean2) {
               if (var8.animationId == -1 && var8.transforms == null) {
                  var34 = var8.getEntity(22, var4, var15, var17, var16, var18);
               } else {
                  var34 = new DynamicObject(var3, 22, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
               }

               var6.newFloorDecoration(var0, var1, var2, var16, (Renderable)var34, var19, var21);
               if (var8.interactType == 1 && var7 != null) {
                  var7.setBlockedByFloorDec(var1, var2);
               }

            }
         } else if (var5 != 10 && var5 != 11) {
            if (var5 >= 12) {
               if (var8.animationId == -1 && var8.transforms == null) {
                  var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
               } else {
                  var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
               }

               var6.method1186(var0, var1, var2, var16, 1, 1, (Renderable)var34, 0, var19, var21);
               if (var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                  class159.field1401[var0][var1][var2] |= 2340;
               }

               if (var8.interactType != 0 && var7 != null) {
                  var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
               }

            } else if (var5 == 0) {
               if (var8.animationId == -1 && var8.transforms == null) {
                  var34 = var8.getEntity(0, var4, var15, var17, var16, var18);
               } else {
                  var34 = new DynamicObject(var3, 0, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
               }

               var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var34, (Renderable)null, Tiles.field821[var4], 0, var19, var21);
               if (var4 == 0) {
                  if (var8.clipped) {
                     Canvas.field68[var0][var1][var2] = 50;
                     Canvas.field68[var0][var1][var2 + 1] = 50;
                  }

                  if (var8.modelClipped) {
                     class159.field1401[var0][var1][var2] |= 585;
                  }
               } else if (var4 == 1) {
                  if (var8.clipped) {
                     Canvas.field68[var0][var1][var2 + 1] = 50;
                     Canvas.field68[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if (var8.modelClipped) {
                     class159.field1401[var0][var1][var2 + 1] |= 1170;
                  }
               } else if (var4 == 2) {
                  if (var8.clipped) {
                     Canvas.field68[var0][var1 + 1][var2] = 50;
                     Canvas.field68[var0][var1 + 1][var2 + 1] = 50;
                  }

                  if (var8.modelClipped) {
                     class159.field1401[var0][var1 + 1][var2] |= 585;
                  }
               } else if (var4 == 3) {
                  if (var8.clipped) {
                     Canvas.field68[var0][var1][var2] = 50;
                     Canvas.field68[var0][var1 + 1][var2] = 50;
                  }

                  if (var8.modelClipped) {
                     class159.field1401[var0][var1][var2] |= 1170;
                  }
               }

               if (var8.interactType != 0 && var7 != null) {
                  var7.method1091(var1, var2, var5, var4, var8.boolean1);
               }

               if (var8.int2 != 16) {
                  var6.method1191(var0, var1, var2, var8.int2);
               }

            } else if (var5 == 1) {
               if (var8.animationId == -1 && var8.transforms == null) {
                  var34 = var8.getEntity(1, var4, var15, var17, var16, var18);
               } else {
                  var34 = new DynamicObject(var3, 1, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
               }

               var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var34, (Renderable)null, Tiles.field825[var4], 0, var19, var21);
               if (var8.clipped) {
                  if (var4 == 0) {
                     Canvas.field68[var0][var1][var2 + 1] = 50;
                  } else if (var4 == 1) {
                     Canvas.field68[var0][var1 + 1][var2 + 1] = 50;
                  } else if (var4 == 2) {
                     Canvas.field68[var0][var1 + 1][var2] = 50;
                  } else if (var4 == 3) {
                     Canvas.field68[var0][var1][var2] = 50;
                  }
               }

               if (var8.interactType != 0 && var7 != null) {
                  var7.method1091(var1, var2, var5, var4, var8.boolean1);
               }

            } else {
               int var28;
               if (var5 == 2) {
                  var28 = var4 + 1 & 3;
                  Object var29;
                  Object var30;
                  if (var8.animationId == -1 && var8.transforms == null) {
                     var29 = var8.getEntity(2, var4 + 4, var15, var17, var16, var18);
                     var30 = var8.getEntity(2, var28, var15, var17, var16, var18);
                  } else {
                     var29 = new DynamicObject(var3, 2, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     var30 = new DynamicObject(var3, 2, var28, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                  }

                  var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var29, (Renderable)var30, Tiles.field821[var4], Tiles.field821[var28], var19, var21);
                  if (var8.modelClipped) {
                     if (var4 == 0) {
                        class159.field1401[var0][var1][var2] |= 585;
                        class159.field1401[var0][var1][1 + var2] |= 1170;
                     } else if (var4 == 1) {
                        class159.field1401[var0][var1][var2 + 1] |= 1170;
                        class159.field1401[var0][var1 + 1][var2] |= 585;
                     } else if (var4 == 2) {
                        class159.field1401[var0][var1 + 1][var2] |= 585;
                        class159.field1401[var0][var1][var2] |= 1170;
                     } else if (var4 == 3) {
                        class159.field1401[var0][var1][var2] |= 1170;
                        class159.field1401[var0][var1][var2] |= 585;
                     }
                  }

                  if (var8.interactType != 0 && var7 != null) {
                     var7.method1091(var1, var2, var5, var4, var8.boolean1);
                  }

                  if (var8.int2 != 16) {
                     var6.method1191(var0, var1, var2, var8.int2);
                  }

               } else if (var5 == 3) {
                  if (var8.animationId == -1 && var8.transforms == null) {
                     var34 = var8.getEntity(3, var4, var15, var17, var16, var18);
                  } else {
                     var34 = new DynamicObject(var3, 3, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                  }

                  var6.newBoundaryObject(var0, var1, var2, var16, (Renderable)var34, (Renderable)null, Tiles.field825[var4], 0, var19, var21);
                  if (var8.clipped) {
                     if (var4 == 0) {
                        Canvas.field68[var0][var1][var2 + 1] = 50;
                     } else if (var4 == 1) {
                        Canvas.field68[var0][var1 + 1][var2 + 1] = 50;
                     } else if (var4 == 2) {
                        Canvas.field68[var0][var1 + 1][var2] = 50;
                     } else if (var4 == 3) {
                        Canvas.field68[var0][var1][var2] = 50;
                     }
                  }

                  if (var8.interactType != 0 && var7 != null) {
                     var7.method1091(var1, var2, var5, var4, var8.boolean1);
                  }

               } else if (var5 == 9) {
                  if (var8.animationId == -1 && var8.transforms == null) {
                     var34 = var8.getEntity(var5, var4, var15, var17, var16, var18);
                  } else {
                     var34 = new DynamicObject(var3, var5, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                  }

                  var6.method1186(var0, var1, var2, var16, 1, 1, (Renderable)var34, 0, var19, var21);
                  if (var8.interactType != 0 && var7 != null) {
                     var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
                  }

                  if (var8.int2 != 16) {
                     var6.method1191(var0, var1, var2, var8.int2);
                  }

               } else if (var5 == 4) {
                  if (var8.animationId == -1 && var8.transforms == null) {
                     var34 = var8.getEntity(4, var4, var15, var17, var16, var18);
                  } else {
                     var34 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                  }

                  var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var34, (Renderable)null, Tiles.field821[var4], 0, 0, 0, var19, var21);
               } else {
                  Object var25;
                  long var31;
                  if (var5 == 5) {
                     var28 = 16;
                     var31 = var6.getBoundaryObjectTag(var0, var1, var2);
                     if (var31 != 0L) {
                        var28 = VarpDefinition.getObjectDefinition(Occluder.Entity_unpackID(var31)).int2;
                     }

                     if (var8.animationId == -1 && var8.transforms == null) {
                        var25 = var8.getEntity(4, var4, var15, var17, var16, var18);
                     } else {
                        var25 = new DynamicObject(var3, 4, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, Tiles.field821[var4], 0, var28 * Tiles.field824[var4], var28 * Tiles.field818[var4], var19, var21);
                  } else if (var5 == 6) {
                     var28 = 8;
                     var31 = var6.getBoundaryObjectTag(var0, var1, var2);
                     if (0L != var31) {
                        var28 = VarpDefinition.getObjectDefinition(Occluder.Entity_unpackID(var31)).int2 / 2;
                     }

                     if (var8.animationId == -1 && var8.transforms == null) {
                        var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
                     } else {
                        var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)null, 256, var4, var28 * Tiles.field826[var4], var28 * Tiles.field814[var4], var19, var21);
                  } else if (var5 == 7) {
                     var23 = var4 + 2 & 3;
                     if (var8.animationId == -1 && var8.transforms == null) {
                        var34 = var8.getEntity(4, var23 + 4, var15, var17, var16, var18);
                     } else {
                        var34 = new DynamicObject(var3, 4, var23 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var34, (Renderable)null, 256, var23, 0, 0, var19, var21);
                  } else if (var5 == 8) {
                     var28 = 8;
                     var31 = var6.getBoundaryObjectTag(var0, var1, var2);
                     if (0L != var31) {
                        var28 = VarpDefinition.getObjectDefinition(Occluder.Entity_unpackID(var31)).int2 / 2;
                     }

                     int var27 = var4 + 2 & 3;
                     Object var26;
                     if (var8.animationId == -1 && var8.transforms == null) {
                        var25 = var8.getEntity(4, var4 + 4, var15, var17, var16, var18);
                        var26 = var8.getEntity(4, var27 + 4, var15, var17, var16, var18);
                     } else {
                        var25 = new DynamicObject(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                        var26 = new DynamicObject(var3, 4, var27 + 4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
                     }

                     var6.newWallDecoration(var0, var1, var2, var16, (Renderable)var25, (Renderable)var26, 256, var4, var28 * Tiles.field826[var4], var28 * Tiles.field814[var4], var19, var21);
                  }
               }
            }
         } else {
            if (var8.animationId == -1 && var8.transforms == null) {
               var34 = var8.getEntity(10, var4, var15, var17, var16, var18);
            } else {
               var34 = new DynamicObject(var3, 10, var4, var0, var1, var2, var8.animationId, var8.boolean3, (Renderable)null);
            }

            if (var34 != null && var6.method1186(var0, var1, var2, var16, var9, var10, (Renderable)var34, var5 == 11 ? 256 : 0, var19, var21) && var8.clipped) {
               var23 = 15;
               if (var34 instanceof Model) {
                  var23 = ((Model)var34).method1256() / 4;
                  if (var23 > 30) {
                     var23 = 30;
                  }
               }

               for(var24 = 0; var24 <= var9; ++var24) {
                  for(int var33 = 0; var33 <= var10; ++var33) {
                     if (var23 > Canvas.field68[var0][var24 + var1][var33 + var2]) {
                        Canvas.field68[var0][var24 + var1][var33 + var2] = (byte)var23;
                     }
                  }
               }
            }

            if (var8.interactType != 0 && var7 != null) {
               var7.addGameObject(var1, var2, var9, var10, var8.boolean1);
            }

         }
      }
   }

   @ObfuscatedName("my")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;B)V",
      garbageValue = "0"
   )
   static void method640(String var0) {
      class133.param9 = var0;

      try {
         String var1 = BuddyRankComparator.client.getParameter(Integer.toString(18));
         String var2 = BuddyRankComparator.client.getParameter(Integer.toString(13));
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if (var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + JagexCache.method875(Message.clockNow() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class27.method101(BuddyRankComparator.client, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }
}
