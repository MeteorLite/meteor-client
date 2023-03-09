import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class18 {
   @ObfuscatedName("hm")
   static int[] field54;
   @ObfuscatedName("oz")
   @Export("selectedSpellWidget")
   static int selectedSpellWidget;
   @ObfuscatedName("su")
   @Export("ClanChat_inClanChat")
   static boolean ClanChat_inClanChat;
   @ObfuscatedName("aj")
   Future field56;
   @ObfuscatedName("al")
   String field52;

   class18(Future var1) {
      this.field56 = var1;
   }

   class18(String var1) {
      this.method68(var1);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-764874737"
   )
   void method68(String var1) {
      if (var1 == null) {
         var1 = "";
      }

      this.field52 = var1;
      if (this.field56 != null) {
         this.field56.cancel(true);
         this.field56 = null;
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "2045450839"
   )
   public final String method71() {
      return this.field52;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-26"
   )
   public boolean method72() {
      return this.field52 != null || this.field56 == null;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "84"
   )
   public final boolean method69() {
      return this.method72() ? true : this.field56.isDone();
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)Laf;",
      garbageValue = "15"
   )
   public final class20 method70() {
      if (this.method72()) {
         return new class20(this.field52);
      } else if (!this.method69()) {
         return null;
      } else {
         try {
            return (class20)this.field56.get();
         } catch (Exception var3) {
            String var2 = "Error retrieving REST request reply";
            System.err.println(var2 + "\r\n" + var3);
            this.method68(var2);
            return new class20(var2);
         }
      }
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(CI)B",
      garbageValue = "637215135"
   )
   @Export("charToByteCp1252")
   public static byte charToByteCp1252(char var0) {
      byte var1;
      if ((var0 <= 0 || var0 >= 128) && (var0 < 160 || var0 > 255)) {
         if (var0 == 8364) {
            var1 = -128;
         } else if (var0 == 8218) {
            var1 = -126;
         } else if (var0 == 402) {
            var1 = -125;
         } else if (var0 == 8222) {
            var1 = -124;
         } else if (var0 == 8230) {
            var1 = -123;
         } else if (var0 == 8224) {
            var1 = -122;
         } else if (var0 == 8225) {
            var1 = -121;
         } else if (var0 == 710) {
            var1 = -120;
         } else if (var0 == 8240) {
            var1 = -119;
         } else if (var0 == 352) {
            var1 = -118;
         } else if (var0 == 8249) {
            var1 = -117;
         } else if (var0 == 338) {
            var1 = -116;
         } else if (var0 == 381) {
            var1 = -114;
         } else if (var0 == 8216) {
            var1 = -111;
         } else if (var0 == 8217) {
            var1 = -110;
         } else if (var0 == 8220) {
            var1 = -109;
         } else if (var0 == 8221) {
            var1 = -108;
         } else if (var0 == 8226) {
            var1 = -107;
         } else if (var0 == 8211) {
            var1 = -106;
         } else if (var0 == 8212) {
            var1 = -105;
         } else if (var0 == 732) {
            var1 = -104;
         } else if (var0 == 8482) {
            var1 = -103;
         } else if (var0 == 353) {
            var1 = -102;
         } else if (var0 == 8250) {
            var1 = -101;
         } else if (var0 == 339) {
            var1 = -100;
         } else if (var0 == 382) {
            var1 = -98;
         } else if (var0 == 376) {
            var1 = -97;
         } else {
            var1 = 63;
         }
      } else {
         var1 = (byte)var0;
      }

      return var1;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(ILmy;IIIII[FI)Lmy;",
      garbageValue = "-860762282"
   )
   static Widget method67(int var0, Widget var1, int var2, int var3, int var4, int var5, int var6, float[] var7) {
      Widget var8 = new Widget();
      var8.type = var0;
      var8.parentId = var1.id;
      var8.childIndex = var2;
      var8.isIf3 = true;
      var8.xAlignment = var3;
      var8.yAlignment = var4;
      var8.widthAlignment = var5;
      var8.heightAlignment = var6;
      var8.rawX = (int)((float)var1.width * var7[0]);
      var8.rawY = (int)(var7[1] * (float)var1.height);
      var8.rawWidth = (int)((float)var1.width * var7[2]);
      var8.rawHeight = (int)((float)var1.height * var7[3]);
      return var8;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      descriptor = "(Ldq;B)V",
      garbageValue = "-65"
   )
   static final void method73(Actor var0) {
      var0.movementSequence = var0.idleSequence;
      if (var0.pathLength == 0) {
         var0.field1003 = 0;
      } else {
         if (var0.sequence != -1 && var0.sequenceDelay == 0) {
            SequenceDefinition var1 = Coord.SequenceDefinition_get(var0.sequence);
            if (var0.field1004 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field1003;
               return;
            }

            if (var0.field1004 <= 0 && var1.priority == 0) {
               ++var0.field1003;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = var0.field931 * 64 + var0.pathX[var0.pathLength - 1] * 128;
         int var4 = var0.field931 * 64 + var0.pathY[var0.pathLength - 1] * 128;
         if (var10 < var3) {
            if (var2 < var4) {
               var0.orientation = 1280;
            } else if (var2 > var4) {
               var0.orientation = 1792;
            } else {
               var0.orientation = 1536;
            }
         } else if (var10 > var3) {
            if (var2 < var4) {
               var0.orientation = 768;
            } else if (var2 > var4) {
               var0.orientation = 256;
            } else {
               var0.orientation = 512;
            }
         } else if (var2 < var4) {
            var0.orientation = 1024;
         } else if (var2 > var4) {
            var0.orientation = 0;
         }

         MoveSpeed var5 = var0.pathTraversed[var0.pathLength - 1];
         if (var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.orientation - var0.rotation & 2047;
            if (var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.walkBackSequence;
            if (var6 >= -256 && var6 <= 256) {
               var7 = var0.walkSequence;
            } else if (var6 >= 256 && var6 < 768) {
               var7 = var0.walkRightSequence;
            } else if (var6 >= -768 && var6 <= -256) {
               var7 = var0.walkLeftSequence;
            }

            if (var7 == -1) {
               var7 = var0.walkSequence;
            }

            var0.movementSequence = var7;
            int var8 = 4;
            boolean var9 = true;
            if (var0 instanceof NPC) {
               var9 = ((NPC)var0).definition.isClickable;
            }

            if (var9) {
               if (var0.orientation != var0.rotation && var0.targetIndex == -1 && var0.field998 != 0) {
                  var8 = 2;
               }

               if (var0.pathLength > 2) {
                  var8 = 6;
               }

               if (var0.pathLength > 3) {
                  var8 = 8;
               }

               if (var0.field1003 > 0 && var0.pathLength > 1) {
                  var8 = 8;
                  --var0.field1003;
               }
            } else {
               if (var0.pathLength > 1) {
                  var8 = 6;
               }

               if (var0.pathLength > 2) {
                  var8 = 8;
               }

               if (var0.field1003 > 0 && var0.pathLength > 1) {
                  var8 = 8;
                  --var0.field1003;
               }
            }

            if (var5 == MoveSpeed.RUN) {
               var8 <<= 1;
            } else if (var5 == MoveSpeed.CRAWL) {
               var8 >>= 1;
            }

            if (var8 >= 8) {
               if (var0.movementSequence == var0.walkSequence && var0.runSequence != -1) {
                  var0.movementSequence = var0.runSequence;
               } else if (var0.walkBackSequence == var0.movementSequence && var0.runBackSequence != -1) {
                  var0.movementSequence = var0.runBackSequence;
               } else if (var0.movementSequence == var0.walkLeftSequence && var0.runLeftSequence != -1) {
                  var0.movementSequence = var0.runLeftSequence;
               } else if (var0.walkRightSequence == var0.movementSequence && var0.runRightSequence != -1) {
                  var0.movementSequence = var0.runRightSequence;
               }
            } else if (var8 <= 1) {
               if (var0.walkSequence == var0.movementSequence && var0.crawlSequence != -1) {
                  var0.movementSequence = var0.crawlSequence;
               } else if (var0.walkBackSequence == var0.movementSequence && var0.crawlBackSequence != -1) {
                  var0.movementSequence = var0.crawlBackSequence;
               } else if (var0.walkLeftSequence == var0.movementSequence && var0.crawlLeftSequence != -1) {
                  var0.movementSequence = var0.crawlLeftSequence;
               } else if (var0.walkRightSequence == var0.movementSequence && var0.crawlRightSequence != -1) {
                  var0.movementSequence = var0.crawlRightSequence;
               }
            }

            if (var10 != var3 || var2 != var4) {
               if (var10 < var3) {
                  var0.x += var8;
                  if (var0.x > var3) {
                     var0.x = var3;
                  }
               } else if (var10 > var3) {
                  var0.x -= var8;
                  if (var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if (var2 < var4) {
                  var0.y += var8;
                  if (var0.y > var4) {
                     var0.y = var4;
                  }
               } else if (var2 > var4) {
                  var0.y -= var8;
                  if (var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if (var3 == var0.x && var4 == var0.y) {
               --var0.pathLength;
               if (var0.field1004 > 0) {
                  --var0.field1004;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.pathLength;
            if (var0.field1004 > 0) {
               --var0.field1004;
            }

         }
      }
   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2099476931"
   )
   static final void method75() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.last(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.previous()) {
         if (var0.endCycle > 0) {
            --var0.endCycle;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if (var0.endCycle == 0) {
            if (var0.objectId >= 0) {
               var2 = var0.objectId;
               var3 = var0.field919;
               var4 = WallDecoration.getObjectDefinition(var2);
               if (var3 == 11) {
                  var3 = 10;
               }

               if (var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method1030(var3);
               if (!var1) {
                  continue;
               }
            }

            class149.addPendingSpawnToScene(var0.plane, var0.type, var0.x, var0.y, var0.objectId, var0.field917, var0.field919, var0.field922);
            var0.remove();
         } else {
            if (var0.startCycle > 0) {
               --var0.startCycle;
            }

            if (var0.startCycle == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102) {
               if (var0.id >= 0) {
                  var2 = var0.id;
                  var3 = var0.objectType;
                  var4 = WallDecoration.getObjectDefinition(var2);
                  if (var3 == 11) {
                     var3 = 10;
                  }

                  if (var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method1030(var3);
                  if (!var1) {
                     continue;
                  }
               }

               class149.addPendingSpawnToScene(var0.plane, var0.type, var0.x, var0.y, var0.id, var0.rotation, var0.objectType, var0.field922);
               var0.startCycle = -1;
               if (var0.objectId == var0.id && var0.objectId == -1) {
                  var0.remove();
               } else if (var0.id == var0.objectId && var0.field917 == var0.rotation && var0.objectType == var0.field919) {
                  var0.remove();
               }
            }
         }
      }

   }
}
