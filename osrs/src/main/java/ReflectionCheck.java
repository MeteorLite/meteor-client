import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bj")
@Implements("ReflectionCheck")
public class ReflectionCheck extends Node {
   @ObfuscatedName("aa")
   static int field166;
   @ObfuscatedName("bj")
   protected static String field167;
    @ObfuscatedName("af")
    int id;
    @ObfuscatedName("an")
    int size;
    @ObfuscatedName("aw")
    int[] operations;
    @ObfuscatedName("ac")
    int[] creationErrors;
   @ObfuscatedName("au")
   Field[] fields;
    @ObfuscatedName("ab")
    int[] intReplaceValues;
    @ObfuscatedName("aq")
    Method[] methods;
    @ObfuscatedName("al")
    byte[][][] arguments;

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;I)V",
      garbageValue = "-1333163047"
   )
   public static void method200(AbstractArchive var0) {
      DbTableType.field4036 = var0;
   }

    @ObfuscatedName("ii")
    @ObfuscatedSignature(
            descriptor = "(Lde;IB)V",
            garbageValue = "-110"
    )
    static final void updateActorSequence(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      SequenceDefinition var12;
      if (var0.spotAnimation >= Client.cycle) {
         var2 = Math.max(1, var0.spotAnimation - Client.cycle);
         var3 = var0.field936 * 64 + var0.field983 * 128;
         var4 = var0.field936 * 64 + var0.field985 * 128;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1005 = 0;
         var0.orientation = var0.exactMoveDirection;
      } else {
         int var8;
         if (var0.exactMoveArrive1Cycle >= Client.cycle) {
            boolean var15 = var0.exactMoveArrive1Cycle == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0;
            if (!var15) {
               SequenceDefinition var11 = ItemContainer.SequenceDefinition_get(var0.sequence);
               if (var11 != null && !var11.isCachedModelIdSet()) {
                  var15 = var0.sequenceFrameCycle + 1 > var11.frameLengths[var0.sequenceFrame];
               } else {
                  var15 = true;
               }
            }

            if (var15) {
               var3 = var0.exactMoveArrive1Cycle - var0.spotAnimation;
               var4 = Client.cycle - var0.spotAnimation;
               var5 = var0.field936 * 64 + var0.field983 * 128;
               var6 = var0.field936 * 64 + var0.field985 * 128;
               var7 = var0.field936 * 64 + var0.field984 * 128;
               var8 = var0.field936 * 64 + var0.field1003 * 128;
               var0.x = (var7 * var4 + var5 * (var3 - var4)) / var3;
               var0.y = (var4 * var8 + var6 * (var3 - var4)) / var3;
            }

            var0.field1005 = 0;
            var0.orientation = var0.exactMoveDirection;
            var0.rotation = var0.orientation;
         } else {
            var0.movementSequence = var0.idleSequence;
            if (var0.pathLength == 0) {
               var0.field1005 = 0;
            } else {
               label398: {
                  if (var0.sequence != -1 && var0.sequenceDelay == 0) {
                     var12 = ItemContainer.SequenceDefinition_get(var0.sequence);
                     if (var0.field1006 > 0 && var12.precedenceAnimating == 0) {
                        ++var0.field1005;
                        break label398;
                     }

                     if (var0.field1006 <= 0 && var12.priority == 0) {
                        ++var0.field1005;
                        break label398;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.field936 * 64 + var0.pathX[var0.pathLength - 1] * 128;
                  var5 = var0.field936 * 64 + var0.pathY[var0.pathLength - 1] * 128;
                  if (var2 < var4) {
                     if (var3 < var5) {
                        var0.orientation = 1280;
                     } else if (var3 > var5) {
                        var0.orientation = 1792;
                     } else {
                        var0.orientation = 1536;
                     }
                  } else if (var2 > var4) {
                     if (var3 < var5) {
                        var0.orientation = 768;
                     } else if (var3 > var5) {
                        var0.orientation = 256;
                     } else {
                        var0.orientation = 512;
                     }
                  } else if (var3 < var5) {
                     var0.orientation = 1024;
                  } else if (var3 > var5) {
                     var0.orientation = 0;
                  }

                  MoveSpeed var13 = var0.pathTraversed[var0.pathLength - 1];
                  if (var4 - var2 <= 256 && var4 - var2 >= -256 && var5 - var3 <= 256 && var5 - var3 >= -256) {
                     var7 = var0.orientation - var0.rotation & 2047;
                     if (var7 > 1024) {
                        var7 -= 2048;
                     }

                     var8 = var0.walkBackSequence;
                     if (var7 >= -256 && var7 <= 256) {
                        var8 = var0.walkSequence;
                     } else if (var7 >= 256 && var7 < 768) {
                        var8 = var0.walkRightSequence;
                     } else if (var7 >= -768 && var7 <= -256) {
                        var8 = var0.walkLeftSequence;
                     }

                     if (var8 == -1) {
                        var8 = var0.walkSequence;
                     }

                     var0.movementSequence = var8;
                     int var9 = 4;
                     boolean var10 = true;
                     if (var0 instanceof NPC) {
                        var10 = ((NPC)var0).definition.isClickable;
                     }

                     if (var10) {
                        if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field986 != 0) {
                           var9 = 2;
                        }

                        if (var0.pathLength > 2) {
                           var9 = 6;
                        }

                        if (var0.pathLength > 3) {
                           var9 = 8;
                        }

                        if (var0.field1005 > 0 && var0.pathLength > 1) {
                           var9 = 8;
                           --var0.field1005;
                        }
                     } else {
                        if (var0.pathLength > 1) {
                           var9 = 6;
                        }

                        if (var0.pathLength > 2) {
                           var9 = 8;
                        }

                        if (var0.field1005 > 0 && var0.pathLength > 1) {
                           var9 = 8;
                           --var0.field1005;
                        }
                     }

                     if (var13 == MoveSpeed.RUN) {
                        var9 <<= 1;
                     } else if (var13 == MoveSpeed.CRAWL) {
                        var9 >>= 1;
                     }

                     if (var9 >= 8) {
                        if (var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
                           var0.movementSequence = var0.runSequence;
                        } else if (var0.movementSequence == var0.walkBackSequence && var0.runBackSequence != -1) {
                           var0.movementSequence = var0.runBackSequence;
                        } else if (var0.walkLeftSequence == var0.movementSequence && var0.runLeftSequence != -1) {
                           var0.movementSequence = var0.runLeftSequence;
                        } else if (var0.walkRightSequence == var0.movementSequence && var0.runRightSequence != -1) {
                           var0.movementSequence = var0.runRightSequence;
                        }
                     } else if (var9 <= 1) {
                        if (var0.walkSequence == var0.movementSequence && var0.crawlSequence != -1) {
                           var0.movementSequence = var0.crawlSequence;
                        } else if (var0.walkBackSequence == var0.movementSequence && var0.crawlBackSequence != -1) {
                           var0.movementSequence = var0.crawlBackSequence;
                        } else if (var0.walkLeftSequence == var0.movementSequence && var0.crawlLeftSequence != -1) {
                           var0.movementSequence = var0.crawlLeftSequence;
                        } else if (var0.movementSequence == var0.walkRightSequence && var0.crawlRightSequence != -1) {
                           var0.movementSequence = var0.crawlRightSequence;
                        }
                     }

                     if (var4 != var2 || var3 != var5) {
                        if (var2 < var4) {
                           var0.x += var9;
                           if (var0.x > var4) {
                              var0.x = var4;
                           }
                        } else if (var2 > var4) {
                           var0.x -= var9;
                           if (var0.x < var4) {
                              var0.x = var4;
                           }
                        }

                        if (var3 < var5) {
                           var0.y += var9;
                           if (var0.y > var5) {
                              var0.y = var5;
                           }
                        } else if (var3 > var5) {
                           var0.y -= var9;
                           if (var0.y < var5) {
                              var0.y = var5;
                           }
                        }
                     }

                     if (var4 == var0.x && var5 == var0.y) {
                        --var0.pathLength;
                        if (var0.field1006 > 0) {
                           --var0.field1006;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.pathLength;
                     if (var0.field1006 > 0) {
                        --var0.field1006;
                     }
                  }
               }
            }
         }
      }

      if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.sequence = -1;
         var0.spotAnimation = 0;
         var0.exactMoveArrive1Cycle = 0;
         var0.method533();
         var0.x = var0.pathX[0] * 128 + var0.field936 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field936 * 64;
         var0.method536();
      }

      if (MusicPatchNode.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.sequence = -1;
         var0.spotAnimation = 0;
         var0.exactMoveArrive1Cycle = 0;
         var0.method533();
         var0.x = var0.pathX[0] * 128 + var0.field936 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field936 * 64;
         var0.method536();
      }

      if (var0.targetIndex != -1) {
         var12 = null;
         var3 = 65536;
         Object var19;
         if (var0.targetIndex < var3) {
            var19 = Client.npcs[var0.targetIndex];
         } else {
            var19 = Client.players[var0.targetIndex - var3];
         }

         if (var19 != null) {
            var4 = var0.x - ((Actor)var19).x;
            var5 = var0.y - ((Actor)var19).y;
            if (var4 != 0 || var5 != 0) {
               var7 = (int)(Math.atan2((double)var4, (double)var5) * 325.94932345220167D) & 2047;
               var0.orientation = var7;
            }
         } else if (var0.false0) {
            var0.targetIndex = -1;
            var0.false0 = false;
         }
      }

      if (var0.pathLength == 0 || var0.field1005 > 0) {
         var2 = -1;
         if (var0.field993 != -1 && var0.field970 != -1) {
            var3 = var0.field993 * 128 - WorldMapData_0.baseX * 128 + 64;
            var4 = var0.field970 * 128 - GameObject.baseY * 128 + 64;
            var5 = var0.x - var3;
            var6 = var0.y - var4;
            if (var5 != 0 || var6 != 0) {
               var7 = (int)(Math.atan2((double)var5, (double)var6) * 325.94932345220167D) & 2047;
               var2 = var7;
            }
         } else if (var0.movingOrientation != -1) {
            var2 = var0.movingOrientation;
         }

         if (var2 != -1) {
            var0.orientation = var2;
            if (var0.field938) {
               var0.rotation = var0.orientation;
            }
         }

         var0.method527();
      }

      var2 = var0.orientation - var0.rotation & 2047;
      if (var2 != 0) {
         boolean var16 = true;
         boolean var17 = true;
         ++var0.field999;
         var5 = var2 > 1024 ? -1 : 1;
         var0.rotation += var5 * var0.field986;
         boolean var18 = true;
         if (var2 < var0.field986 || var2 > 2048 - var0.field986) {
            var0.rotation = var0.orientation;
            var18 = false;
         }

         if (var0.field986 > 0 && var0.movementSequence == var0.idleSequence && (var0.field999 > 25 || var18)) {
            if (var5 == -1 && var0.turnLeftSequence != -1) {
               var0.movementSequence = var0.turnLeftSequence;
            } else if (var5 == 1 && var0.turnRightSequence != -1) {
               var0.movementSequence = var0.turnRightSequence;
            } else {
               var0.movementSequence = var0.walkSequence;
            }
         }

         var0.rotation &= 2047;
      } else {
         if (var0.false0) {
            var0.targetIndex = -1;
            var0.false0 = false;
         }

         var0.field999 = 0;
      }

      NetFileRequest.method1876(var0);
   }

    @ObfuscatedName("mt")
    @ObfuscatedSignature(
            descriptor = "(IIIIIIII)V",
            garbageValue = "-631543188"
    )
    static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (SoundSystem.loadInterface(var0)) {
         ViewportMouse.updateInterface(VerticalAlignment.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
