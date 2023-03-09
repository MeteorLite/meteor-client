import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lt")
@Implements("Coord")
public class Coord {
   @ObfuscatedName("uv")
   static int field2766;
   @ObfuscatedName("aj")
   @Export("plane")
   public int plane;
   @ObfuscatedName("al")
   @Export("x")
   public int x;
   @ObfuscatedName("ac")
   @Export("y")
   public int y;

   @ObfuscatedSignature(
      descriptor = "(Llt;)V"
   )
   public Coord(Coord var1) {
      this.plane = var1.plane;
      this.x = var1.x;
      this.y = var1.y;
   }

   public Coord(int var1, int var2, int var3) {
      this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   public Coord(int var1) {
      if (var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.x = var1 >> 14 & 16383;
         this.y = var1 & 16383;
      }

   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-2027408234"
   )
   @Export("packed")
   public int packed() {
      return class249.method1424(this.plane, this.x, this.y);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Llt;I)Z",
      garbageValue = "2032380368"
   )
   @Export("equalsCoord")
   boolean equalsCoord(Coord var1) {
      if (this.plane != var1.plane) {
         return false;
      } else if (this.x != var1.x) {
         return false;
      } else {
         return this.y == var1.y;
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-11455619"
   )
   @Export("toString")
   String toString(String var1) {
      return this.plane + var1 + (this.x >> 6) + var1 + (this.y >> 6) + var1 + (this.x & 63) + var1 + (this.y & 63);
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         return !(var1 instanceof Coord) ? false : this.equalsCoord((Coord)var1);
      }
   }

   @Export("hashCode")
   @ObfuscatedName("hashCode")
   public int hashCode() {
      return this.packed();
   }

   @Export("toString")
   @ObfuscatedName("toString")
   public String toString() {
      return this.toString(",");
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(II)Lhx;",
      garbageValue = "218692626"
   )
   @Export("SequenceDefinition_get")
   public static SequenceDefinition SequenceDefinition_get(int var0) {
      SequenceDefinition var1 = (SequenceDefinition)SequenceDefinition.SequenceDefinition_cached.get((long)var0);
      if (var1 != null) {
         return var1;
      } else {
         byte[] var2 = HealthBar.SequenceDefinition_archive.takeFile(12, var0);
         var1 = new SequenceDefinition();
         if (var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.postDecode();
         SequenceDefinition.SequenceDefinition_cached.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ib")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-286114668"
   )
   static final void method1633(int var0, int var1) {
      if (Client.hintArrowType == 2) {
         GrandExchangeOfferUnitPriceComparator.worldToScreen((Client.hintArrowX - GameEngine.baseX << 7) + Client.hintArrowSubX, (Client.hintArrowY - class178.baseY << 7) + Client.hintArrowSubY, Client.hintArrowHeight * 2);
         if (Client.viewportTempX > -1 && Client.cycle % 20 < 10) {
            EnumComposition.headIconHintSprites[0].drawTransBgAt(var0 + Client.viewportTempX - 12, Client.viewportTempY + var1 - 28);
         }

      }
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      descriptor = "(IIZS)V",
      garbageValue = "-321"
   )
   static final void method1637(int var0, int var1, boolean var2) {
      if (!var2 || var0 != class124.timeOfPreviousKeyPress || ArchiveDiskActionHandler.field3408 != var1) {
         class124.timeOfPreviousKeyPress = var0;
         ArchiveDiskActionHandler.field3408 = var1;
         class19.updateGameState(25);
         class16.drawLoadingMessage("Loading - please wait.", true);
         int var3 = GameEngine.baseX;
         int var4 = class178.baseY;
         GameEngine.baseX = (var0 - 6) * 8;
         class178.baseY = (var1 - 6) * 8;
         int var5 = GameEngine.baseX - var3;
         int var6 = class178.baseY - var4;
         var3 = GameEngine.baseX;
         var4 = class178.baseY;

         int var7;
         int var9;
         for(var7 = 0; var7 < 65536; ++var7) {
            NPC var8 = Client.npcs[var7];
            if (var8 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var8.pathX[var9] -= var5;
                  var8.pathY[var9] -= var6;
               }

               var8.x -= var5 * 128;
               var8.y -= var6 * 128;
            }
         }

         for(var7 = 0; var7 < 2048; ++var7) {
            Player var21 = Client.players[var7];
            if (var21 != null) {
               for(var9 = 0; var9 < 10; ++var9) {
                  var21.pathX[var9] -= var5;
                  var21.pathY[var9] -= var6;
               }

               var21.x -= var5 * 128;
               var21.y -= var6 * 128;
            }
         }

         byte var20 = 0;
         byte var18 = 104;
         byte var22 = 1;
         if (var5 < 0) {
            var20 = 103;
            var18 = -1;
            var22 = -1;
         }

         byte var10 = 0;
         byte var11 = 104;
         byte var12 = 1;
         if (var6 < 0) {
            var10 = 103;
            var11 = -1;
            var12 = -1;
         }

         int var14;
         for(int var13 = var20; var13 != var18; var13 += var22) {
            for(var14 = var10; var14 != var11; var14 += var12) {
               int var15 = var13 + var5;
               int var16 = var14 + var6;

               for(int var17 = 0; var17 < 4; ++var17) {
                  if (var15 >= 0 && var16 >= 0 && var15 < 104 && var16 < 104) {
                     Client.groundItems[var17][var13][var14] = Client.groundItems[var17][var15][var16];
                  } else {
                     Client.groundItems[var17][var13][var14] = null;
                  }
               }
            }
         }

         for(PendingSpawn var19 = (PendingSpawn)Client.pendingSpawns.last(); var19 != null; var19 = (PendingSpawn)Client.pendingSpawns.previous()) {
            var19.x -= var5;
            var19.y -= var6;
            if (var19.x < 0 || var19.y < 0 || var19.x >= 104 || var19.y >= 104) {
               var19.remove();
            }
         }

         if (Client.destinationX != 0) {
            Client.destinationX -= var5;
            Client.destinationY -= var6;
         }

         Client.soundEffectCount = 0;
         Client.isCameraLocked = false;
         class381.cameraX -= var5 << 7;
         class471.cameraZ -= var6 << 7;
         GrandExchangeOfferOwnWorldComparator.oculusOrbFocalPointX -= var5 << 7;
         ReflectionCheck.oculusOrbFocalPointY -= var6 << 7;
         Client.field592 = -1;
         Client.graphicsObjects.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].clear();
         }

      }
   }

   @ObfuscatedName("lf")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1041793614"
   )
   @Export("getTapToDrop")
   static boolean getTapToDrop() {
      return Client.tapToDrop;
   }
}
