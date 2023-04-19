import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dl")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
    @ObfuscatedName("at")
    public static int ItemDefinition_fileCount;
    @ObfuscatedName("af")
    boolean isRunning = true;
    @ObfuscatedName("an")
    Object lock = new Object();
    @ObfuscatedName("aw")
    int index = 0;
    @ObfuscatedName("ac")
    int[] xs = new int[500];
    @ObfuscatedName("au")
    int[] ys = new int[500];
    @ObfuscatedName("ab")
    long[] millis = new long[500];

    @ObfuscatedName("run")
    public void run() {
      for(; this.isRunning; PlayerComposition.method1704(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if (this.index < 500) {
               this.xs[this.index] = MouseHandler.MouseHandler_x;
               this.ys[this.index] = MouseHandler.MouseHandler_y;
               this.millis[this.index] = MouseHandler.MouseHandler_millis;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(CI)Z",
      garbageValue = "1929251930"
   )
   static final boolean method494(char var0) {
      return var0 == 160 || var0 == ' ' || var0 == '_' || var0 == '-';
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(IB)Lcq;",
            garbageValue = "32"
    )
    static Message Messages_getMessage(int var0) {
      return (Message)Messages.Messages_hashTable.get((long)var0);
   }

   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "-471758785"
   )
   static int method496(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 6600) {
         var3 = GameEngine.Client_plane;
         int var9 = (MusicPatchNode.localPlayer.x >> 7) + WorldMapData_0.baseX;
         int var5 = (MusicPatchNode.localPlayer.y >> 7) + GameObject.baseY;
         class88.getWorldMap().method2381(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapArea var11;
         if (var0 == 6601) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            String var16 = "";
            var11 = class88.getWorldMap().getMapArea(var3);
            if (var11 != null) {
               var16 = var11.getExternalName();
            }

            Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var16;
            return 1;
         } else if (var0 == 6602) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class88.getWorldMap().setCurrentMapAreaId(var3);
            return 1;
         } else if (var0 == 6603) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getZoomLevel();
            return 1;
         } else if (var0 == 6604) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            class88.getWorldMap().setZoomPercentage(var3);
            return 1;
         } else if (var0 == 6605) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().isCacheLoaded() ? 1 : 0;
            return 1;
         } else {
            Coord var15;
            if (var0 == 6606) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class88.getWorldMap().setWorldMapPositionTarget(var15.x, var15.y);
               return 1;
            } else if (var0 == 6607) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class88.getWorldMap().setWorldMapPositionTargetInstant(var15.x, var15.y);
               return 1;
            } else if (var0 == 6608) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class88.getWorldMap().jumpToSourceCoord(var15.plane, var15.x, var15.y);
               return 1;
            } else if (var0 == 6609) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
               class88.getWorldMap().jumpToSourceCoordInstant(var15.plane, var15.x, var15.y);
               return 1;
            } else if (var0 == 6610) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getDisplayX();
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getDisplayY();
               return 1;
            } else {
               WorldMapArea var13;
               if (var0 == 6611) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var13 = class88.getWorldMap().getMapArea(var3);
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getOrigin().packed();
                  }

                  return 1;
               } else if (var0 == 6612) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var13 = class88.getWorldMap().getMapArea(var3);
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var13.getRegionHighX() - var13.getRegionLowX() + 1) * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var13.getRegionHighY() - var13.getRegionLowY() + 1) * 64;
                  }

                  return 1;
               } else if (var0 == 6613) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var13 = class88.getWorldMap().getMapArea(var3);
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getRegionLowX() * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getRegionLowY() * 64;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getRegionHighX() * 64 + 64 - 1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getRegionHighY() * 64 + 64 - 1;
                  }

                  return 1;
               } else if (var0 == 6614) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var13 = class88.getWorldMap().getMapArea(var3);
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getZoom();
                  }

                  return 1;
               } else if (var0 == 6615) {
                  var15 = class88.getWorldMap().getDisplayCoord();
                  if (var15 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.x;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var15.y;
                  }

                  return 1;
               } else if (var0 == 6616) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().currentMapAreaId();
                  return 1;
               } else if (var0 == 6617) {
                  var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                  var13 = class88.getWorldMap().getCurrentMapArea();
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.position(var15.plane, var15.x, var15.y);
                     if (var14 == null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                     } else {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14[0];
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coord var7;
                  if (var0 == 6618) {
                     var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                     var13 = class88.getWorldMap().getCurrentMapArea();
                     if (var13 == null) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.coord(var15.x, var15.y);
                        if (var7 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.packed();
                        }

                        return 1;
                     }
                  } else {
                     Coord var12;
                     if (var0 == 6619) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        class220.method1229(var3, var12, false);
                        return 1;
                     } else if (var0 == 6620) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        class220.method1229(var3, var12, true);
                        return 1;
                     } else if (var0 == 6621) {
                        Interpreter.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                        var11 = class88.getWorldMap().getMapArea(var3);
                        if (var11 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
                           return 1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
                           return 1;
                        }
                     } else if (var0 == 6622) {
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getDisplayWith();
                        Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getDisplayHeight();
                        return 1;
                     } else if (var0 == 6623) {
                        var15 = new Coord(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        var13 = class88.getWorldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
                        if (var13 == null) {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var13.getId();
                        }

                        return 1;
                     } else if (var0 == 6624) {
                        class88.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        return 1;
                     } else if (var0 == 6625) {
                        class88.getWorldMap().resetMaxFlashCount();
                        return 1;
                     } else if (var0 == 6626) {
                        class88.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
                        return 1;
                     } else if (var0 == 6627) {
                        class88.getWorldMap().resetCyclesPerFlash();
                        return 1;
                     } else {
                        boolean var10;
                        if (var0 == 6628) {
                           var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                           class88.getWorldMap().setPerpetualFlash(var10);
                           return 1;
                        } else if (var0 == 6629) {
                           var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                           class88.getWorldMap().flashElement(var3);
                           return 1;
                        } else if (var0 == 6630) {
                           var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                           class88.getWorldMap().flashCategory(var3);
                           return 1;
                        } else if (var0 == 6631) {
                           class88.getWorldMap().stopCurrentFlashes();
                           return 1;
                        } else if (var0 == 6632) {
                           var10 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
                           class88.getWorldMap().setElementsDisabled(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if (var0 == 6633) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
                              class88.getWorldMap().disableElement(var3, var4);
                              return 1;
                           } else if (var0 == 6634) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1] == 1;
                              class88.getWorldMap().setCategoryDisabled(var3, var4);
                              return 1;
                           } else if (var0 == 6635) {
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().getElementsDisabled() ? 1 : 0;
                              return 1;
                           } else if (var0 == 6636) {
                              var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().isElementDisabled(var3) ? 1 : 0;
                              return 1;
                           } else if (var0 == 6637) {
                              var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class88.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
                              return 1;
                           } else if (var0 == 6638) {
                              Interpreter.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
                              var12 = new Coord(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
                              var7 = class88.getWorldMap().method2386(var3, var12);
                              if (var7 == null) {
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                              } else {
                                 Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var7.packed();
                              }

                              return 1;
                           } else {
                              AbstractWorldMapIcon var8;
                              if (var0 == 6639) {
                                 var8 = class88.getWorldMap().iconStart();
                                 if (var8 == null) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.getElement();
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.coord2.packed();
                                 }

                                 return 1;
                              } else if (var0 == 6640) {
                                 var8 = class88.getWorldMap().iconNext();
                                 if (var8 == null) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.getElement();
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var8.coord2.packed();
                                 }

                                 return 1;
                              } else {
                                 WorldMapElement var6;
                                 if (var0 == 6693) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var6 = class354.WorldMapElement_get(var3);
                                    if (var6.name == null) {
                                       Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = "";
                                    } else {
                                       Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var6.name;
                                    }

                                    return 1;
                                 } else if (var0 == 6694) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var6 = class354.WorldMapElement_get(var3);
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.textSize;
                                    return 1;
                                 } else if (var0 == 6695) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var6 = class354.WorldMapElement_get(var3);
                                    if (var6 == null) {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.category;
                                    }

                                    return 1;
                                 } else if (var0 == 6696) {
                                    var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                                    var6 = class354.WorldMapElement_get(var3);
                                    if (var6 == null) {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.sprite1;
                                    }

                                    return 1;
                                 } else if (var0 == 6697) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ByteArrayPool.worldMapEvent.mapElement;
                                    return 1;
                                 } else if (var0 == 6698) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ByteArrayPool.worldMapEvent.coord1.packed();
                                    return 1;
                                 } else if (var0 == 6699) {
                                    Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ByteArrayPool.worldMapEvent.coord2.packed();
                                    return 1;
                                 } else {
                                    return 2;
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
