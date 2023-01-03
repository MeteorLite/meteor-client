import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dj")
public class class126 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ldj;"
   )
   static final class126 field1228 = new class126(0, 0, (String)null, 0);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Ldj;"
   )
   static final class126 field1226 = new class126(1, 1, (String)null, 9);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Ldj;"
   )
   static final class126 field1230 = new class126(2, 2, (String)null, 3);
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Ldj;"
   )
   static final class126 field1227 = new class126(3, 3, (String)null, 6);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Ldj;"
   )
   static final class126 field1229 = new class126(4, 4, (String)null, 1);
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "Ldj;"
   )
   static final class126 field1225 = new class126(5, 5, (String)null, 3);
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      descriptor = "Lep;"
   )
   static ClanSettings field1235;
   @ObfuscatedName("ba")
   static int field1232;
   @ObfuscatedName("f")
   final int field1231;
   @ObfuscatedName("r")
   final int field1233;
   @ObfuscatedName("u")
   final int field1234;

   class126(int var1, int var2, String var3, int var4) {
      this.field1231 = var1;
      this.field1233 = var2;
      this.field1234 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.field1233;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1367110649"
   )
   int method707() {
      return this.field1234;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lly;Lly;I)V",
      garbageValue = "-237323188"
   )
   public static void method709(AbstractArchive var0, AbstractArchive var1) {
      HealthBarDefinition.HealthBarDefinition_archive = var0;
      HealthBarDefinition.field1513 = var1;
   }

   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "1965818056"
   )
   static int method710(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 6600) {
         var3 = class383.Client_plane;
         int var9 = (class155.localPlayer.x >> 7) + class154.baseX;
         int var5 = (class155.localPlayer.y >> 7) + class365.baseY;
         Client.getWorldMap().method2204(var3, var9, var5, true);
         return 1;
      } else {
         WorldMapArea var11;
         if (var0 == 6601) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            String var16 = "";
            var11 = Client.getWorldMap().getMapArea(var3);
            if (var11 != null) {
               var16 = var11.getExternalName();
            }

            Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var16;
            return 1;
         } else if (var0 == 6602) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            Client.getWorldMap().setCurrentMapAreaId(var3);
            return 1;
         } else if (var0 == 6603) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().getZoomLevel();
            return 1;
         } else if (var0 == 6604) {
            var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            Client.getWorldMap().setZoomPercentage(var3);
            return 1;
         } else if (var0 == 6605) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().isCacheLoaded() ? 1 : 0;
            return 1;
         } else {
            Coord var15;
            if (var0 == 6606) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
               Client.getWorldMap().setWorldMapPositionTarget(var15.x, var15.y);
               return 1;
            } else if (var0 == 6607) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
               Client.getWorldMap().setWorldMapPositionTargetInstant(var15.x, var15.y);
               return 1;
            } else if (var0 == 6608) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
               Client.getWorldMap().jumpToSourceCoord(var15.plane, var15.x, var15.y);
               return 1;
            } else if (var0 == 6609) {
               var15 = new Coord(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
               Client.getWorldMap().jumpToSourceCoordInstant(var15.plane, var15.x, var15.y);
               return 1;
            } else if (var0 == 6610) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().getDisplayX();
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().getDisplayY();
               return 1;
            } else {
               WorldMapArea var13;
               if (var0 == 6611) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var13 = Client.getWorldMap().getMapArea(var3);
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13.getOrigin().packed();
                  }

                  return 1;
               } else if (var0 == 6612) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var13 = Client.getWorldMap().getMapArea(var3);
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = (var13.getRegionHighX() - var13.getRegionLowX() + 1) * 64;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = (var13.getRegionHighY() - var13.getRegionLowY() + 1) * 64;
                  }

                  return 1;
               } else if (var0 == 6613) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var13 = Client.getWorldMap().getMapArea(var3);
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13.getRegionLowX() * 64;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13.getRegionLowY() * 64;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13.getRegionHighX() * 64 + 64 - 1;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13.getRegionHighY() * 64 + 64 - 1;
                  }

                  return 1;
               } else if (var0 == 6614) {
                  var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                  var13 = Client.getWorldMap().getMapArea(var3);
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13.getZoom();
                  }

                  return 1;
               } else if (var0 == 6615) {
                  var15 = Client.getWorldMap().getDisplayCoord();
                  if (var15 == null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                  } else {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var15.x;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var15.y;
                  }

                  return 1;
               } else if (var0 == 6616) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().currentMapAreaId();
                  return 1;
               } else if (var0 == 6617) {
                  var15 = new Coord(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                  var13 = Client.getWorldMap().getCurrentMapArea();
                  if (var13 == null) {
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                     Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                     return 1;
                  } else {
                     int[] var14 = var13.position(var15.plane, var15.x, var15.y);
                     if (var14 == null) {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                     } else {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var14[0];
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var14[1];
                     }

                     return 1;
                  }
               } else {
                  Coord var7;
                  if (var0 == 6618) {
                     var15 = new Coord(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                     var13 = Client.getWorldMap().getCurrentMapArea();
                     if (var13 == null) {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                        return 1;
                     } else {
                        var7 = var13.coord(var15.x, var15.y);
                        if (var7 == null) {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7.packed();
                        }

                        return 1;
                     }
                  } else {
                     Coord var12;
                     if (var0 == 6619) {
                        class87.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
                        AttackOption.method600(var3, var12, false);
                        return 1;
                     } else if (var0 == 6620) {
                        class87.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
                        AttackOption.method600(var3, var12, true);
                        return 1;
                     } else if (var0 == 6621) {
                        class87.Interpreter_intStackSize -= 2;
                        var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                        var12 = new Coord(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
                        var11 = Client.getWorldMap().getMapArea(var3);
                        if (var11 == null) {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
                           return 1;
                        } else {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var11.containsCoord(var12.plane, var12.x, var12.y) ? 1 : 0;
                           return 1;
                        }
                     } else if (var0 == 6622) {
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().getDisplayWith();
                        Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().getDisplayHeight();
                        return 1;
                     } else if (var0 == 6623) {
                        var15 = new Coord(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                        var13 = Client.getWorldMap().mapAreaAtCoord(var15.plane, var15.x, var15.y);
                        if (var13 == null) {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                        } else {
                           Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var13.getId();
                        }

                        return 1;
                     } else if (var0 == 6624) {
                        Client.getWorldMap().setMaxFlashCount(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                        return 1;
                     } else if (var0 == 6625) {
                        Client.getWorldMap().resetMaxFlashCount();
                        return 1;
                     } else if (var0 == 6626) {
                        Client.getWorldMap().setCyclesPerFlash(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
                        return 1;
                     } else if (var0 == 6627) {
                        Client.getWorldMap().resetCyclesPerFlash();
                        return 1;
                     } else {
                        boolean var10;
                        if (var0 == 6628) {
                           var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                           Client.getWorldMap().setPerpetualFlash(var10);
                           return 1;
                        } else if (var0 == 6629) {
                           var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                           Client.getWorldMap().flashElement(var3);
                           return 1;
                        } else if (var0 == 6630) {
                           var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                           Client.getWorldMap().flashCategory(var3);
                           return 1;
                        } else if (var0 == 6631) {
                           Client.getWorldMap().stopCurrentFlashes();
                           return 1;
                        } else if (var0 == 6632) {
                           var10 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize] == 1;
                           Client.getWorldMap().setElementsDisabled(var10);
                           return 1;
                        } else {
                           boolean var4;
                           if (var0 == 6633) {
                              class87.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                              var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1] == 1;
                              Client.getWorldMap().disableElement(var3, var4);
                              return 1;
                           } else if (var0 == 6634) {
                              class87.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                              var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1] == 1;
                              Client.getWorldMap().setCategoryDisabled(var3, var4);
                              return 1;
                           } else if (var0 == 6635) {
                              Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().getElementsDisabled() ? 1 : 0;
                              return 1;
                           } else if (var0 == 6636) {
                              var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().isElementDisabled(var3) ? 1 : 0;
                              return 1;
                           } else if (var0 == 6637) {
                              var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                              Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.getWorldMap().isCategoryDisabled(var3) ? 1 : 0;
                              return 1;
                           } else if (var0 == 6638) {
                              class87.Interpreter_intStackSize -= 2;
                              var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
                              var12 = new Coord(Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1]);
                              var7 = Client.getWorldMap().method2235(var3, var12);
                              if (var7 == null) {
                                 Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                              } else {
                                 Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var7.packed();
                              }

                              return 1;
                           } else {
                              AbstractWorldMapIcon var8;
                              if (var0 == 6639) {
                                 var8 = Client.getWorldMap().iconStart();
                                 if (var8 == null) {
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.getElement();
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.coord2.packed();
                                 }

                                 return 1;
                              } else if (var0 == 6640) {
                                 var8 = Client.getWorldMap().iconNext();
                                 if (var8 == null) {
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                                 } else {
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.getElement();
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var8.coord2.packed();
                                 }

                                 return 1;
                              } else {
                                 WorldMapElement var6;
                                 if (var0 == 6693) {
                                    var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                                    var6 = JagexCache.WorldMapElement_get(var3);
                                    if (var6.name == null) {
                                       Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = "";
                                    } else {
                                       Interpreter.Interpreter_stringStack[++Interpreter.Interpreter_stringStackSize - 1] = var6.name;
                                    }

                                    return 1;
                                 } else if (var0 == 6694) {
                                    var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                                    var6 = JagexCache.WorldMapElement_get(var3);
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var6.textSize;
                                    return 1;
                                 } else if (var0 == 6695) {
                                    var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                                    var6 = JagexCache.WorldMapElement_get(var3);
                                    if (var6 == null) {
                                       Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var6.category;
                                    }

                                    return 1;
                                 } else if (var0 == 6696) {
                                    var3 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
                                    var6 = JagexCache.WorldMapElement_get(var3);
                                    if (var6 == null) {
                                       Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = -1;
                                    } else {
                                       Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var6.sprite1;
                                    }

                                    return 1;
                                 } else if (var0 == 6697) {
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.worldMapEvent.mapElement;
                                    return 1;
                                 } else if (var0 == 6698) {
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.worldMapEvent.coord1.packed();
                                    return 1;
                                 } else if (var0 == 6699) {
                                    Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = GrandExchangeOfferUnitPriceComparator.worldMapEvent.coord2.packed();
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
