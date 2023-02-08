import java.util.concurrent.ScheduledExecutorService;

import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
@Implements("PcmPlayer")
public class PcmPlayer {
    @ObfuscatedName("j")
    protected static boolean PcmPlayer_stereo;
    @ObfuscatedName("n")
    static ScheduledExecutorService soundSystemExecutor;
    @ObfuscatedName("m")
    protected int[] samples;
    @ObfuscatedName("t")
    @ObfuscatedSignature(
            descriptor = "Lan;"
    )
    PcmStream stream;
   @ObfuscatedName("h")
   int field202 = 32;
    @ObfuscatedName("p")
    long timeMs = class153.clockNow();
    @ObfuscatedName("o")
    int capacity;
   @ObfuscatedName("u")
   int field204;
   @ObfuscatedName("x")
   int field214;
   @ObfuscatedName("a")
   long field198 = 0L;
   @ObfuscatedName("q")
   int field207 = 0;
   @ObfuscatedName("d")
   int field208 = 0;
   @ObfuscatedName("e")
   int field209 = 0;
   @ObfuscatedName("g")
   long field210 = 0L;
   @ObfuscatedName("y")
   boolean field199 = true;
   @ObfuscatedName("ar")
   int field212 = 0;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "[Lan;"
   )
   PcmStream[] field213 = new PcmStream[8];
   @ObfuscatedName("at")
   @ObfuscatedSignature(
      descriptor = "[Lan;"
   )
   PcmStream[] field205 = new PcmStream[8];

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1600330502"
    )
    protected void init() throws Exception {
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "742720329"
    )
    protected void open(int var1) throws Exception {
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-1573553273"
    )
    protected int position() throws Exception {
      return this.capacity;
   }

    @ObfuscatedName("s")
    protected void write() throws Exception {
   }

    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-892812272"
    )
    protected void close() {
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1285037243"
    )
    protected void discard() throws Exception {
   }

    @ObfuscatedName("d")
    @ObfuscatedSignature(
            descriptor = "(Lan;I)V",
            garbageValue = "-116833836"
    )
    public final synchronized void setStream(PcmStream var1) {
      this.stream = var1;
   }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1435721898"
    )
    public final synchronized void run() {
      if (this.samples != null) {
         long var1 = class153.clockNow();

         try {
            if (0L != this.field198) {
               if (var1 < this.field198) {
                  return;
               }

               this.open(this.capacity);
               this.field198 = 0L;
               this.field199 = true;
            }

            int var3 = this.position();
            if (this.field209 - var3 > this.field207) {
               this.field207 = this.field209 - var3;
            }

            int var4 = this.field214 + this.field204;
            if (var4 + 256 > 16384) {
               var4 = 16128;
            }

            if (var4 + 256 > this.capacity) {
               this.capacity += 1024;
               if (this.capacity > 16384) {
                  this.capacity = 16384;
               }

               this.close();
               this.open(this.capacity);
               var3 = 0;
               this.field199 = true;
               if (var4 + 256 > this.capacity) {
                  var4 = this.capacity - 256;
                  this.field214 = var4 - this.field204;
               }
            }

            while(var3 < var4) {
               this.fill(this.samples, 256);
               this.write();
               var3 += 256;
            }

            if (var1 > this.field210) {
               if (!this.field199) {
                  if (this.field207 == 0 && this.field208 == 0) {
                     this.close();
                     this.field198 = var1 + 2000L;
                     return;
                  }

                  this.field214 = Math.min(this.field208, this.field207);
                  this.field208 = this.field207;
               } else {
                  this.field199 = false;
               }

               this.field207 = 0;
               this.field210 = var1 + 2000L;
            }

            this.field209 = var3;
         } catch (Exception var7) {
            this.close();
            this.field198 = var1 + 2000L;
         }

         try {
            if (var1 > this.timeMs + 500000L) {
               var1 = this.timeMs;
            }

            while(var1 > 5000L + this.timeMs) {
               this.skip(256);
               this.timeMs += (long)(256000 / class284.field2683);
            }
         } catch (Exception var6) {
            this.timeMs = var1;
         }

      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1131218520"
   )
   public final void method201() {
      this.field199 = true;
   }

    @ObfuscatedName("y")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-1800360111"
    )
    public final synchronized void tryDiscard() {
      this.field199 = true;

      try {
         this.discard();
      } catch (Exception var2) {
         this.close();
         this.field198 = class153.clockNow() + 2000L;
      }

   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(S)V",
            garbageValue = "-16415"
    )
    public final synchronized void shutdown() {
      if (class266.soundSystem != null) {
         boolean var1 = true;

         for(int var2 = 0; var2 < 2; ++var2) {
            if (this == class266.soundSystem.players[var2]) {
               class266.soundSystem.players[var2] = null;
            }

            if (class266.soundSystem.players[var2] != null) {
               var1 = false;
            }
         }

         if (var1) {
            soundSystemExecutor.shutdownNow();
            soundSystemExecutor = null;
            class266.soundSystem = null;
         }
      }

      this.close();
      this.samples = null;
   }

    @ObfuscatedName("aa")
    @ObfuscatedSignature(
            descriptor = "(II)V",
            garbageValue = "1488629152"
    )
    final void skip(int var1) {
      this.field212 -= var1;
      if (this.field212 < 0) {
         this.field212 = 0;
      }

      if (this.stream != null) {
         this.stream.skip(var1);
      }

   }

    @ObfuscatedName("ai")
    final void fill(int[] var1, int var2) {
      int var3 = var2;
      if (PcmPlayer_stereo) {
         var3 = var2 << 1;
      }

      class377.clearIntArray(var1, 0, var3);
      this.field212 -= var2;
      if (this.stream != null && this.field212 <= 0) {
         this.field212 += class284.field2683 >> 4;
         class31.PcmStream_disable(this.stream);
         this.method204(this.stream, this.stream.vmethod1019());
         int var4 = 0;
         int var5 = 255;

         int var6;
         PcmStream var10;
         label105:
         for(var6 = 7; var5 != 0; --var6) {
            int var7;
            int var8;
            if (var6 < 0) {
               var7 = var6 & 3;
               var8 = -(var6 >> 2);
            } else {
               var7 = var6;
               var8 = 0;
            }

            for(int var9 = var5 >>> var7 & 286331153; var9 != 0; var9 >>>= 4) {
               if ((var9 & 1) != 0) {
                  var5 &= ~(1 << var7);
                  var10 = null;
                  PcmStream var11 = this.field213[var7];

                  label99:
                  while(true) {
                     while(true) {
                        if (var11 == null) {
                           break label99;
                        }

                        AbstractSound var12 = var11.sound;
                        if (var12 != null && var12.position > var8) {
                           var5 |= 1 << var7;
                           var10 = var11;
                           var11 = var11.after;
                        } else {
                           var11.active = true;
                           int var13 = var11.vmethod5648();
                           var4 += var13;
                           if (var12 != null) {
                              var12.position += var13;
                           }

                           if (var4 >= this.field202) {
                              break label105;
                           }

                           PcmStream var14 = var11.firstSubStream();
                           if (var14 != null) {
                              for(int var15 = var11.field256; var14 != null; var14 = var11.nextSubStream()) {
                                 this.method204(var14, var15 * var14.vmethod1019() >> 8);
                              }
                           }

                           PcmStream var16 = var11.after;
                           var11.after = null;
                           if (var10 == null) {
                              this.field213[var7] = var16;
                           } else {
                              var10.after = var16;
                           }

                           if (var16 == null) {
                              this.field205[var7] = var10;
                           }

                           var11 = var16;
                        }
                     }
                  }
               }

               var7 += 4;
               ++var8;
            }
         }

         for(var6 = 0; var6 < 8; ++var6) {
            PcmStream var17 = this.field213[var6];
            PcmStream[] var18 = this.field213;
            this.field205[var6] = null;

            for(var18[var6] = null; var17 != null; var17 = var10) {
               var10 = var17.after;
               var17.after = null;
            }
         }
      }

      if (this.field212 < 0) {
         this.field212 = 0;
      }

      if (this.stream != null) {
         this.stream.fill(var1, 0, var2);
      }

      this.timeMs = class153.clockNow();
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Lan;II)V",
      garbageValue = "-967266641"
   )
   final void method204(PcmStream var1, int var2) {
      int var3 = var2 >> 5;
      PcmStream var4 = this.field205[var3];
      if (var4 == null) {
         this.field213[var3] = var1;
      } else {
         var4.after = var1;
      }

      this.field205[var3] = var1;
      var1.field256 = var2;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;B)I",
      garbageValue = "-55"
   )
   public static int method216(CharSequence var0) {
      int var1 = var0.length();
      int var2 = 0;

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if (var4 <= 127) {
            ++var2;
         } else if (var4 <= 2047) {
            var2 += 2;
         } else {
            var2 += 3;
         }
      }

      return var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1346222802"
   )
   static int method213() {
      return class28.KeyHandler_keyCodes.length;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "2137110263"
   )
   static int method215(int var0, Script var1, boolean var2) {
      return 2;
   }

    @ObfuscatedName("gp")
    @ObfuscatedSignature(
            descriptor = "(Lcb;II)V",
            garbageValue = "163232913"
    )
    static final void updateActorSequence(Actor var0, int var1) {
      int var2;
      int var3;
      int var4;
      int var5;
      SequenceDefinition var11;
      SequenceDefinition var12;
      if (var0.exactMoveArrive1Cycle >= Client.cycle) {
         var2 = Math.max(1, var0.exactMoveArrive1Cycle - Client.cycle);
         var3 = var0.field939 * 64 + var0.exactMoveDeltaX1 * 128;
         var4 = var0.field939 * 64 + var0.exactMoveDeltaY1 * 128;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field951 = 0;
         var0.orientation = var0.exactMoveDirection;
      } else {
         int var7;
         int var8;
         if (var0.exactMoveArrive2Cycle >= Client.cycle) {
            boolean var14 = var0.exactMoveArrive2Cycle == Client.cycle || var0.sequence == -1 || var0.sequenceDelay != 0;
            if (!var14) {
               var11 = class85.SequenceDefinition_get(var0.sequence);
               if (var11 != null && !var11.isCachedModelIdSet()) {
                  var14 = var0.sequenceFrameCycle + 1 > var11.frameLengths[var0.sequenceFrame];
               } else {
                  var14 = true;
               }
            }

            if (var14) {
               var3 = var0.exactMoveArrive2Cycle - var0.exactMoveArrive1Cycle;
               var4 = Client.cycle - var0.exactMoveArrive1Cycle;
               var5 = var0.field939 * 64 + var0.exactMoveDeltaX1 * 128;
               int var6 = var0.field939 * 64 + var0.exactMoveDeltaY1 * 128;
               var7 = var0.field939 * 64 + var0.exactMoveDeltaX2 * 128;
               var8 = var0.field939 * 64 + var0.exactMoveDeltaY2 * 128;
               var0.x = (var4 * var7 + var5 * (var3 - var4)) / var3;
               var0.y = (var8 * var4 + var6 * (var3 - var4)) / var3;
            }

            var0.field951 = 0;
            var0.orientation = var0.exactMoveDirection;
            var0.rotation = var0.orientation;
         } else {
            var0.movementSequence = var0.idleSequence;
            if (var0.pathLength == 0) {
               var0.field951 = 0;
            } else {
               label615: {
                  if (var0.sequence != -1 && var0.sequenceDelay == 0) {
                     var12 = class85.SequenceDefinition_get(var0.sequence);
                     if (var0.field1006 > 0 && var12.precedenceAnimating == 0) {
                        ++var0.field951;
                        break label615;
                     }

                     if (var0.field1006 <= 0 && var12.priority == 0) {
                        ++var0.field951;
                        break label615;
                     }
                  }

                  var2 = var0.x;
                  var3 = var0.y;
                  var4 = var0.field939 * 64 + var0.pathX[var0.pathLength - 1] * 128;
                  var5 = var0.field939 * 64 + var0.pathY[var0.pathLength - 1] * 128;
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
                        if (var0.orientation != var0.rotation && var0.targetIndex == -1 && var0.field1004 != 0) {
                           var9 = 2;
                        }

                        if (var0.pathLength > 2) {
                           var9 = 6;
                        }

                        if (var0.pathLength > 3) {
                           var9 = 8;
                        }

                        if (var0.field951 > 0 && var0.pathLength > 1) {
                           var9 = 8;
                           --var0.field951;
                        }
                     } else {
                        if (var0.pathLength > 1) {
                           var9 = 6;
                        }

                        if (var0.pathLength > 2) {
                           var9 = 8;
                        }

                        if (var0.field951 > 0 && var0.pathLength > 1) {
                           var9 = 8;
                           --var0.field951;
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
                        } else if (var0.movementSequence == var0.walkRightSequence && var0.runRightSequence != -1) {
                           var0.movementSequence = var0.runRightSequence;
                        }
                     } else if (var9 <= 1) {
                        if (var0.walkSequence == var0.movementSequence && var0.crawlSequence != -1) {
                           var0.movementSequence = var0.crawlSequence;
                        } else if (var0.movementSequence == var0.walkBackSequence && var0.crawlBackSequence != -1) {
                           var0.movementSequence = var0.crawlBackSequence;
                        } else if (var0.walkLeftSequence == var0.movementSequence && var0.crawlLeftSequence != -1) {
                           var0.movementSequence = var0.crawlLeftSequence;
                        } else if (var0.movementSequence == var0.walkRightSequence && var0.crawlRightSequence != -1) {
                           var0.movementSequence = var0.crawlRightSequence;
                        }
                     }

                     if (var4 != var2 || var5 != var3) {
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
         var0.spotAnimation = -1;
         var0.exactMoveArrive1Cycle = 0;
         var0.exactMoveArrive2Cycle = 0;
         var0.x = var0.field939 * 64 + var0.pathX[0] * 128;
         var0.y = var0.pathY[0] * 128 + var0.field939 * 64;
         var0.method501();
      }

      if (class387.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.sequence = -1;
         var0.spotAnimation = -1;
         var0.exactMoveArrive1Cycle = 0;
         var0.exactMoveArrive2Cycle = 0;
         var0.x = var0.field939 * 64 + var0.pathX[0] * 128;
         var0.y = var0.field939 * 64 + var0.pathY[0] * 128;
         var0.method501();
      }

      if (var0.field1004 != 0) {
         if (var0.targetIndex != -1) {
            Object var16 = null;
            var3 = class323.isLargePlayerInfo ? 65536 : '耀';
            if (var0.targetIndex < var3) {
               var16 = Client.npcs[var0.targetIndex];
            } else if (var0.targetIndex >= var3) {
               var16 = Client.players[var0.targetIndex - var3];
            }

            if (var16 != null) {
               var4 = var0.x - ((Actor)var16).x;
               var5 = var0.y - ((Actor)var16).y;
               if (var4 != 0 || var5 != 0) {
                  var0.orientation = (int)(Math.atan2((double)var4, (double)var5) * 325.949D) & 2047;
               }
            } else if (var0.false0) {
               var0.targetIndex = -1;
               var0.false0 = false;
            }
         }

         if (var0.movingOrientation != -1 && (var0.pathLength == 0 || var0.field951 > 0)) {
            var0.orientation = var0.movingOrientation;
            var0.movingOrientation = -1;
         }

         var2 = var0.orientation - var0.rotation & 2047;
         if (var2 == 0 && var0.false0) {
            var0.targetIndex = -1;
            var0.false0 = false;
         }

         if (var2 != 0) {
            ++var0.field967;
            boolean var15;
            if (var2 > 1024) {
               var0.rotation -= var0.instantTurn ? var2 : var0.field1004 * 1730223223 * 372079943;
               var15 = true;
               if (var2 < var0.field1004 || var2 > 2048 - var0.field1004) {
                  var0.rotation = var0.orientation;
                  var15 = false;
               }

               if (!var0.instantTurn && var0.movementSequence == var0.idleSequence && (var0.field967 > 25 || var15)) {
                  if (var0.turnLeftSequence != -1) {
                     var0.movementSequence = var0.turnLeftSequence;
                  } else {
                     var0.movementSequence = var0.walkSequence;
                  }
               }
            } else {
               var0.rotation += var0.instantTurn ? var2 : var0.field1004 * 372079943 * 1730223223;
               var15 = true;
               if (var2 < var0.field1004 || var2 > 2048 - var0.field1004) {
                  var0.rotation = var0.orientation;
                  var15 = false;
               }

               if (!var0.instantTurn && var0.movementSequence == var0.idleSequence && (var0.field967 > 25 || var15)) {
                  if (var0.turnRightSequence != -1) {
                     var0.movementSequence = var0.turnRightSequence;
                  } else {
                     var0.movementSequence = var0.walkSequence;
                  }
               }
            }

            var0.rotation &= 2047;
            var0.instantTurn = false;
         } else {
            var0.field967 = 0;
         }
      }

      var0.isWalking = false;
      if (var0.movementSequence != -1) {
         var12 = class85.SequenceDefinition_get(var0.movementSequence);
         if (var12 != null) {
            if (!var12.isCachedModelIdSet() && var12.frameIds != null) {
               ++var0.movementFrameCycle;
               if (var0.movementFrame < var12.frameIds.length && var0.movementFrameCycle > var12.frameLengths[var0.movementFrame]) {
                  var0.movementFrameCycle = 1;
                  ++var0.movementFrame;
                  SoundCache.method228(var12, var0.movementFrame, var0.x, var0.y);
               }

               if (var0.movementFrame >= var12.frameIds.length) {
                  if (var12.frameCount > 0) {
                     var0.movementFrame -= var12.frameCount;
                     if (var12.field1799) {
                        ++var0.field976;
                     }

                     if (var0.movementFrame < 0 || var0.movementFrame >= var12.frameIds.length || var12.field1799 && var0.field976 >= var12.iterations) {
                        var0.movementFrameCycle = 0;
                        var0.movementFrame = 0;
                        var0.field976 = 0;
                     }
                  } else {
                     var0.movementFrameCycle = 0;
                     var0.movementFrame = 0;
                  }

                  SoundCache.method228(var12, var0.movementFrame, var0.x, var0.y);
               }
            } else if (var12.isCachedModelIdSet()) {
               ++var0.movementFrame;
               var3 = var12.method1060();
               if (var0.movementFrame < var3) {
                  StudioGame.method1784(var12, var0.movementFrame, var0.x, var0.y);
               } else {
                  if (var12.frameCount > 0) {
                     var0.movementFrame -= var12.frameCount;
                     if (var12.field1799) {
                        ++var0.field976;
                     }

                     if (var0.movementFrame < 0 || var0.movementFrame >= var3 || var12.field1799 && var0.field976 >= var12.iterations) {
                        var0.movementFrame = 0;
                        var0.movementFrameCycle = 0;
                        var0.field976 = 0;
                     }
                  } else {
                     var0.movementFrameCycle = 0;
                     var0.movementFrame = 0;
                  }

                  StudioGame.method1784(var12, var0.movementFrame, var0.x, var0.y);
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

         var2 = MouseRecorder.SpotAnimationDefinition_get(var0.spotAnimation).sequence;
         if (var2 != -1) {
            var11 = class85.SequenceDefinition_get(var2);
            if (var11 != null && var11.frameIds != null && !var11.isCachedModelIdSet()) {
               ++var0.spotAnimFrameCycle;
               if (var0.spotAnimationFrame < var11.frameIds.length && var0.spotAnimFrameCycle > var11.frameLengths[var0.spotAnimationFrame]) {
                  var0.spotAnimFrameCycle = 1;
                  ++var0.spotAnimationFrame;
                  SoundCache.method228(var11, var0.spotAnimationFrame, var0.x, var0.y);
               }

               if (var0.spotAnimationFrame >= var11.frameIds.length && (var0.spotAnimationFrame < 0 || var0.spotAnimationFrame >= var11.frameIds.length)) {
                  var0.spotAnimation = -1;
               }
            } else if (var11.isCachedModelIdSet()) {
               ++var0.spotAnimationFrame;
               var4 = var11.method1060();
               if (var0.spotAnimationFrame < var4) {
                  StudioGame.method1784(var11, var0.spotAnimationFrame, var0.x, var0.y);
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
         var12 = class85.SequenceDefinition_get(var0.sequence);
         if (var12.precedenceAnimating == 1 && var0.field1006 > 0 && var0.exactMoveArrive1Cycle <= Client.cycle && var0.exactMoveArrive2Cycle < Client.cycle) {
            var0.sequenceDelay = 1;
            return;
         }
      }

      if (var0.sequence != -1 && var0.sequenceDelay == 0) {
         var12 = class85.SequenceDefinition_get(var0.sequence);
         if (var12 == null) {
            var0.sequence = -1;
         } else if (!var12.isCachedModelIdSet() && var12.frameIds != null) {
            ++var0.sequenceFrameCycle;
            if (var0.sequenceFrame < var12.frameIds.length && var0.sequenceFrameCycle > var12.frameLengths[var0.sequenceFrame]) {
               var0.sequenceFrameCycle = 1;
               ++var0.sequenceFrame;
               SoundCache.method228(var12, var0.sequenceFrame, var0.x, var0.y);
            }

            if (var0.sequenceFrame >= var12.frameIds.length) {
               var0.sequenceFrame -= var12.frameCount;
               ++var0.currentSequenceFrameIndex;
               if (var0.currentSequenceFrameIndex >= var12.iterations) {
                  var0.sequence = -1;
               } else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var12.frameIds.length) {
                  SoundCache.method228(var12, var0.sequenceFrame, var0.x, var0.y);
               } else {
                  var0.sequence = -1;
               }
            }

            var0.isWalking = var12.stretches;
         } else if (var12.isCachedModelIdSet()) {
            ++var0.sequenceFrame;
            var3 = var12.method1060();
            if (var0.sequenceFrame < var3) {
               StudioGame.method1784(var12, var0.sequenceFrame, var0.x, var0.y);
            } else {
               var0.sequenceFrame -= var12.frameCount;
               ++var0.currentSequenceFrameIndex;
               if (var0.currentSequenceFrameIndex >= var12.iterations) {
                  var0.sequence = -1;
               } else if (var0.sequenceFrame >= 0 && var0.sequenceFrame < var3) {
                  StudioGame.method1784(var12, var0.sequenceFrame, var0.x, var0.y);
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

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1696311323"
   )
   static void method210() {
      if (Client.combatTargetPlayerIndex >= 0 && Client.players[Client.combatTargetPlayerIndex] != null) {
         Decimator.addPlayerToScene(Client.players[Client.combatTargetPlayerIndex], false);
      }

   }
}
