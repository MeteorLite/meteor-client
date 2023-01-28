import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hs")
@Implements("FloorDecoration")
public final class FloorDecoration {
   @ObfuscatedName("u")
   public static byte[][] SpriteBuffer_pixels;
   @ObfuscatedName("cx")
   @ObfuscatedSignature(
      descriptor = "[Lra;"
   )
   static IndexedSprite[] worldSelectArrows;
   @ObfuscatedName("h")
   int z;
   @ObfuscatedName("e")
   int x;
   @ObfuscatedName("v")
   int y;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lhr;"
   )
   public Renderable renderable;
   @ObfuscatedName("m")
   public long tag;
   @ObfuscatedName("q")
   int flags;

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      descriptor = "(Lct;IB)V",
      garbageValue = "13"
   )
   static final void updateActorSequence(Actor var0, int var1) {
      SequenceDefinition var3;
      int var4;
      int var11;
      SequenceDefinition var12;
      int var14;
      if (var0.exactMoveArrive1Cycle >= Client.cycle) {
         class273.method1518(var0);
      } else {
         int var5;
         int var7;
         int var8;
         if (var0.exactMoveArrive2Cycle >= Client.cycle) {
            boolean var2 = var0.exactMoveArrive2Cycle == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0;
            if (!var2) {
               var3 = AABB.SequenceDefinition_get(var0.sequence);
               if (var3 != null && !var3.isCachedModelIdSet()) {
                  var2 = var0.sequenceFrameCycle + 1 > var3.frameLengths[var0.sequenceFrame];
               } else {
                  var2 = true;
               }
            }

            if (var2) {
               var11 = var0.exactMoveArrive2Cycle - var0.exactMoveArrive1Cycle;
               var4 = Client.cycle - var0.exactMoveArrive1Cycle;
               var5 = var0.field933 * 64 + var0.exactMoveDeltaX1 * 128;
               int var6 = var0.field933 * 64 + var0.exactMoveDeltaY1 * 128;
               var7 = var0.field933 * 64 + var0.exactMoveDeltaX2 * 128;
               var8 = var0.field933 * 64 + var0.exactMoveDeltaY2 * 128;
               var0.x = (var7 * var4 + var5 * (var11 - var4)) / var11;
               var0.y = (var8 * var4 + var6 * (var11 - var4)) / var11;
            }

            var0.field991 = 0;
            var0.orientation = var0.exactMoveDirection;
            var0.rotation = var0.orientation;
         } else {
            var0.movementSequence = var0.idleSequence;
            if (var0.pathLength == 0) {
               var0.field991 = 0;
            } else {
               label498: {
                  if (var0.sequence != -1 && var0.sequenceDelay == 0) {
                     var12 = AABB.SequenceDefinition_get(var0.sequence);
                     if (var0.field1004 > 0 && var12.precedenceAnimating == 0) {
                        ++var0.field991;
                        break label498;
                     }

                     if (var0.field1004 <= 0 && var12.priority == 0) {
                        ++var0.field991;
                        break label498;
                     }
                  }

                  var14 = var0.x;
                  var11 = var0.y;
                  var4 = var0.field933 * 64 + var0.pathX[var0.pathLength - 1] * 128;
                  var5 = var0.field933 * 64 + var0.pathY[var0.pathLength - 1] * 128;
                  if (var14 < var4) {
                     if (var11 < var5) {
                        var0.orientation = 1280;
                     } else if (var11 > var5) {
                        var0.orientation = 1792;
                     } else {
                        var0.orientation = 1536;
                     }
                  } else if (var14 > var4) {
                     if (var11 < var5) {
                        var0.orientation = 768;
                     } else if (var11 > var5) {
                        var0.orientation = 256;
                     } else {
                        var0.orientation = 512;
                     }
                  } else if (var11 < var5) {
                     var0.orientation = 1024;
                  } else if (var11 > var5) {
                     var0.orientation = 0;
                  }

                  MoveSpeed var13 = var0.pathTraversed[var0.pathLength - 1];
                  if (var4 - var14 <= 256 && var4 - var14 >= -256 && var5 - var11 <= 256 && var5 - var11 >= -256) {
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
                        if (var0.rotation != var0.orientation && var0.targetIndex == -1 && var0.field1001 != 0) {
                           var9 = 2;
                        }

                        if (var0.pathLength > 2) {
                           var9 = 6;
                        }

                        if (var0.pathLength > 3) {
                           var9 = 8;
                        }

                        if (var0.field991 > 0 && var0.pathLength > 1) {
                           var9 = 8;
                           --var0.field991;
                        }
                     } else {
                        if (var0.pathLength > 1) {
                           var9 = 6;
                        }

                        if (var0.pathLength > 2) {
                           var9 = 8;
                        }

                        if (var0.field991 > 0 && var0.pathLength > 1) {
                           var9 = 8;
                           --var0.field991;
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
                        } else if (var0.movementSequence == var0.walkBackSequence && var0.crawlBackSequence != -1) {
                           var0.movementSequence = var0.crawlBackSequence;
                        } else if (var0.movementSequence == var0.walkLeftSequence && var0.crawlLeftSequence != -1) {
                           var0.movementSequence = var0.crawlLeftSequence;
                        } else if (var0.movementSequence == var0.walkRightSequence && var0.crawlRightSequence != -1) {
                           var0.movementSequence = var0.crawlRightSequence;
                        }
                     }

                     if (var4 != var14 || var11 != var5) {
                        if (var14 < var4) {
                           var0.x += var9;
                           if (var0.x > var4) {
                              var0.x = var4;
                           }
                        } else if (var14 > var4) {
                           var0.x -= var9;
                           if (var0.x < var4) {
                              var0.x = var4;
                           }
                        }

                        if (var11 < var5) {
                           var0.y += var9;
                           if (var0.y > var5) {
                              var0.y = var5;
                           }
                        } else if (var11 > var5) {
                           var0.y -= var9;
                           if (var0.y < var5) {
                              var0.y = var5;
                           }
                        }
                     }

                     if (var4 == var0.x && var5 == var0.y) {
                        --var0.pathLength;
                        if (var0.field1004 > 0) {
                           --var0.field1004;
                        }
                     }
                  } else {
                     var0.x = var4;
                     var0.y = var5;
                     --var0.pathLength;
                     if (var0.field1004 > 0) {
                        --var0.field1004;
                     }
                  }
               }
            }
         }
      }

      if (var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.sequence = -1;
         var0.spotAnimation = -1;
         var0.exactMoveArrive1Cycle = 0;
         var0.exactMoveArrive2Cycle = 0;
         var0.x = var0.field933 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field933 * 64 + var0.pathY[0] * 128;
         var0.method512();
      }

      if (class155.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.sequence = -1;
         var0.spotAnimation = -1;
         var0.exactMoveArrive1Cycle = 0;
         var0.exactMoveArrive2Cycle = 0;
         var0.x = var0.pathX[0] * 128 + var0.field933 * 64;
         var0.y = var0.field933 * 64 + var0.pathY[0] * 128;
         var0.method512();
      }

      FriendSystem.method413(var0);
      var0.isWalking = false;
      if (var0.movementSequence != -1) {
         var12 = AABB.SequenceDefinition_get(var0.movementSequence);
         if (var12 != null) {
            if (!var12.isCachedModelIdSet() && var12.frameIds != null) {
               ++var0.movementFrameCycle;
               if (var0.movementFrame < var12.frameIds.length && var0.movementFrameCycle > var12.frameLengths[var0.movementFrame]) {
                  var0.movementFrameCycle = 1;
                  ++var0.movementFrame;
                  FriendsChat.method2036(var12, var0.movementFrame, var0.x, var0.y);
               }

               if (var0.movementFrame >= var12.frameIds.length) {
                  if (var12.frameCount > 0) {
                     var0.movementFrame -= var12.frameCount;
                     if (var12.field1807) {
                        ++var0.field970;
                     }

                     if (var0.movementFrame < 0 || var0.movementFrame >= var12.frameIds.length || var12.field1807 && var0.field970 >= var12.iterations) {
                        var0.movementFrameCycle = 0;
                        var0.movementFrame = 0;
                        var0.field970 = 0;
                     }
                  } else {
                     var0.movementFrameCycle = 0;
                     var0.movementFrame = 0;
                  }

                  FriendsChat.method2036(var12, var0.movementFrame, var0.x, var0.y);
               }
            } else if (var12.isCachedModelIdSet()) {
               ++var0.movementFrame;
               var11 = var12.method1056();
               if (var0.movementFrame < var11) {
                  class20.method72(var12, var0.movementFrame, var0.x, var0.y);
               } else {
                  if (var12.frameCount > 0) {
                     var0.movementFrame -= var12.frameCount;
                     if (var12.field1807) {
                        ++var0.field970;
                     }

                     if (var0.movementFrame < 0 || var0.movementFrame >= var11 || var12.field1807 && var0.field970 >= var12.iterations) {
                        var0.movementFrame = 0;
                        var0.movementFrameCycle = 0;
                        var0.field970 = 0;
                     }
                  } else {
                     var0.movementFrameCycle = 0;
                     var0.movementFrame = 0;
                  }

                  class20.method72(var12, var0.movementFrame, var0.x, var0.y);
               }
            } else {
               var0.movementSequence = -1;
            }
         } else {
            var0.movementSequence = -1;
         }
      }

      if (var0.spotAnimation != -1 && Client.cycle >= var0.spotAnimationStartCycle) {
         if (var0.spotAnimationFrame < 0) {
            var0.spotAnimationFrame = 0;
         }

         var14 = ClanSettings.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
         if (var14 != -1) {
            var3 = AABB.SequenceDefinition_get(var14);
            if (var3 != null && var3.frameIds != null && !var3.isCachedModelIdSet()) {
               ++var0.spotAnimFrameCycle;
               if (var0.spotAnimationFrame < var3.frameIds.length && var0.spotAnimFrameCycle > var3.frameLengths[var0.spotAnimationFrame]) {
                  var0.spotAnimFrameCycle = 1;
                  ++var0.spotAnimationFrame;
                  FriendsChat.method2036(var3, var0.spotAnimationFrame, var0.x, var0.y);
               }

               if (var0.spotAnimationFrame >= var3.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var3.frameIds.length)) {
                  var0.spotAnimation = -1;
               }
            } else if (var3.isCachedModelIdSet()) {
               ++var0.spotAnimationFrame;
               var4 = var3.method1056();
               if (var0.spotAnimationFrame < var4) {
                  class20.method72(var3, var0.spotAnimationFrame, var0.x, var0.y);
               } else if (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var4) {
                  var0.spotAnimation = -1;
               }
            } else {
               var0.spotAnimation = -1;
            }
         } else {
            var0.spotAnimation = -1;
         }
      }

      if (var0.sequence != -1 && var0.sequenceDelay <= 1) {
         var12 = AABB.SequenceDefinition_get(var0.sequence);
         if (var12.precedenceAnimating == 1 && var0.field1004 > 0 && var0.exactMoveArrive1Cycle <= Client.cycle && var0.exactMoveArrive2Cycle < Client.cycle) {
            var0.sequenceDelay = 1;
            return;
         }
      }

      if (var0.sequence != -1 && var0.sequenceDelay == 0) {
         var12 = AABB.SequenceDefinition_get(var0.sequence);
         if (var12 == null) {
            var0.sequence = -1;
         } else if (!var12.isCachedModelIdSet() && var12.frameIds != null) {
            ++var0.sequenceFrameCycle;
            if (var0.sequenceFrame < var12.frameIds.length && var0.sequenceFrameCycle > var12.frameLengths[var0.sequenceFrame]) {
               var0.sequenceFrameCycle = 1;
               ++var0.sequenceFrame;
               FriendsChat.method2036(var12, var0.sequenceFrame, var0.x, var0.y);
            }

            if (var0.sequenceFrame >= var12.frameIds.length) {
               var0.sequenceFrame -= var12.frameCount;
               ++var0.currentSequenceFrameIndex;
               if (var0.currentSequenceFrameIndex >= var12.iterations) {
                  var0.sequence = -1;
               } else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var12.frameIds.length) {
                  FriendsChat.method2036(var12, var0.sequenceFrame, var0.x, var0.y);
               } else {
                  var0.sequence = -1;
               }
            }

            var0.isWalking = var12.stretches;
         } else if (var12.isCachedModelIdSet()) {
            ++var0.sequenceFrame;
            var11 = var12.method1056();
            if (var0.sequenceFrame < var11) {
               class20.method72(var12, var0.sequenceFrame, var0.x, var0.y);
            } else {
               var0.sequenceFrame -= var12.frameCount;
               ++var0.currentSequenceFrameIndex;
               if (var0.currentSequenceFrameIndex >= var12.iterations) {
                  var0.sequence = -1;
               } else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var11) {
                  class20.method72(var12, var0.sequenceFrame, var0.x, var0.y);
               } else {
                  var0.sequence = -1;
               }
            }
         } else {
            var0.sequence = -1;
         }
      }

      if (var0.sequenceDelay > 0) {
         --var0.sequenceDelay;
      }

   }

   @ObfuscatedName("jv")
   @ObfuscatedSignature(
      descriptor = "(III)Lgg;",
      garbageValue = "1330231937"
   )
   static RouteStrategy method1134(int var0, int var1) {
      Client.field650.approxDestinationX = var0;
      Client.field650.approxDestinationY = var1;
      Client.field650.approxDestinationSizeX = 1;
      Client.field650.approxDestinationSizeY = 1;
      return Client.field650;
   }
}
