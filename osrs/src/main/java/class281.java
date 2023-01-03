import java.io.File;
import java.util.HashMap;
import java.util.TimeZone;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
@ObfuscatedName("jg")
public final class class281 {
   @ObfuscatedName("sf")
   @ObfuscatedSignature(
      descriptor = "Lnc;"
   )
   static FriendsChat friendsChat;
   @ObfuscatedName("sa")
   static boolean ClanChat_inClanChat;
   @ObfuscatedName("v")
   static final HashMap field2690 = new HashMap();
   @ObfuscatedName("m")
   public static File cacheDir;
   @ObfuscatedName("jk")
   @ObfuscatedSignature(
      descriptor = "[Lrx;"
   )
   static SpritePixels[] mapDotSprites;

   static {
      java.util.Calendar.getInstance(method1530("Europe/London"));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)Ljava/util/TimeZone;",
      garbageValue = "32904762"
   )
   static TimeZone method1530(String var0) {
      HashMap var1 = field2690;
      synchronized(field2690) {
         TimeZone var2 = (TimeZone)field2690.get(var0);
         if (var2 == null) {
            var2 = TimeZone.getTimeZone(var0);
            field2690.put(var0, var2);
         }

         return var2;
      }
   }

   @ObfuscatedName("iq")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "12"
   )
   static void method1531() {
      int var0 = Players.Players_count;
      int[] var1 = Players.Players_indices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if (var1[var2] != Client.combatTargetPlayerIndex && var1[var2] != Client.localPlayerIndex) {
            WorldMapAreaData.addPlayerToScene(Client.players[var1[var2]], true);
         }
      }

   }

   @ObfuscatedName("iv")
   @ObfuscatedSignature(
      descriptor = "(IIZI)V",
      garbageValue = "283375352"
   )
   static final void method1528(int var0, int var1, boolean var2) {
      if (!var2 || var0 != class17.field50 || MusicPatchNode2.field2707 != var1) {
         class17.field50 = var0;
         MusicPatchNode2.field2707 = var1;
         class140.updateGameState(25);
         SoundSystem.drawLoadingMessage("Loading - please wait.", true);
         int var3 = class154.baseX;
         int var4 = class365.baseY;
         class154.baseX = (var0 - 6) * 8;
         class365.baseY = (var1 - 6) * 8;
         int var5 = class154.baseX - var3;
         int var6 = class365.baseY - var4;
         var3 = class154.baseX;
         var4 = class365.baseY;

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
            for(var14 = var10; var11 != var14; var14 += var12) {
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
         class145.cameraX -= var5 << 7;
         ClanChannel.cameraZ -= var6 << 7;
         class29.oculusOrbFocalPointX -= var5 << 7;
         class14.oculusOrbFocalPointY -= var6 << 7;
         Client.field464 = -1;
         Client.graphicsObjects.clear();
         Client.projectiles.clear();

         for(var14 = 0; var14 < 4; ++var14) {
            Client.collisionMaps[var14].clear();
         }

      }
   }

   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1604095117"
   )
   static final boolean method1532(int var0) {
      if (var0 < 0) {
         return false;
      } else {
         int var1 = Client.menuOpcodes[var0];
         if (var1 >= 2000) {
            var1 -= 2000;
         }

         return var1 == 1007;
      }
   }

   @ObfuscatedName("lk")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-1475515227"
   )
   static boolean method1529(int var0) {
      for(int var1 = 0; var1 < Client.field555; ++var1) {
         if (Client.field596[var1] == var0) {
            return true;
         }
      }

      return false;
   }
}
