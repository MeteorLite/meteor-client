import java.io.IOException;
import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class19 implements Callable {
   @ObfuscatedName("uh")
   @Export("cameraMoveToSpeed")
   static int cameraMoveToSpeed;
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "Lgn;"
   )
   static ClanChannel field60;
   @ObfuscatedName("sf")
   @ObfuscatedSignature(
      descriptor = "Lgn;"
   )
   @Export("guestClanChannel")
   static ClanChannel guestClanChannel;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lak;"
   )
   final class10 field57;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lam;"
   )
   @Export("this$0")
   @ObfuscatedName("this$0")
   final class14 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lam;Lak;)V"
   )
   class19(class14 var1, class10 var2) {
      this.this$0 = var1;
      this.field57 = var2;
   }

   @Export("call")
   @ObfuscatedName("call")
   public Object call() throws Exception {
      try {
         while(this.field57.method33()) {
            Login.method429(10L);
         }
      } catch (IOException var2) {
         return new class20("Error servicing REST query: " + var2.getMessage());
      }

      return this.field57.method34();
   }

   @ObfuscatedName("bj")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)I",
      garbageValue = "-608378874"
   )
   public static int method79(String var0) {
      return var0.length() + 2;
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "190436510"
   )
   @Export("updateGameState")
   static void updateGameState(int var0) {
      if (var0 != Client.gameState) {
         if (Client.gameState == 30) {
            Client.field585.method1082();
         }

         if (Client.gameState == 0) {
            class392.client.method157();
         }

         if (var0 == 20 || var0 == 40 || var0 == 45 || var0 == 50) {
            class60.method325(0);
            Client.field423 = 0;
            Client.field390 = 0;
            Client.timer.method2038(var0);
            if (var0 != 20) {
               class130.method716(false);
            }
         }

         if (var0 != 20 && var0 != 40 && FloorDecoration.field1908 != null) {
            FloorDecoration.field1908.close();
            FloorDecoration.field1908 = null;
         }

         if (Client.gameState == 25) {
            Client.field376 = 0;
            Client.field500 = 0;
            Client.field354 = 1;
            Client.field422 = 0;
            Client.field647 = 1;
         }

         if (var0 != 5 && var0 != 10) {
            if (var0 == 20) {
               int var3 = Client.gameState == 11 ? 4 : 0;
               PlayerComposition.method1640(AABB.archive10, class143.archive8, false, var3);
            } else if (var0 == 11) {
               PlayerComposition.method1640(AABB.archive10, class143.archive8, false, 4);
            } else if (var0 == 50) {
               Tile.setLoginResponseString("", "Updating date of birth...", "");
               PlayerComposition.method1640(AABB.archive10, class143.archive8, false, 7);
            } else {
               ModeWhere.method1899();
            }
         } else {
            boolean var1 = WorldMapSectionType.clientPreferences.method537() >= Client.param21;
            int var2 = var1 ? 0 : 12;
            PlayerComposition.method1640(AABB.archive10, class143.archive8, true, var2);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-194934658"
   )
   @Export("playJingle")
   static void playJingle(int var0, int var1) {
      if (WorldMapSectionType.clientPreferences.getCurrentMusicVolume() != 0 && var0 != -1) {
         class163.method853(class36.field149, var0, 0, WorldMapSectionType.clientPreferences.getCurrentMusicVolume(), false);
         Client.playingJingle = true;
      }

   }

   @ObfuscatedName("ja")
   @ObfuscatedSignature(
      descriptor = "(ZLsq;B)V",
      garbageValue = "-16"
   )
   static final void method78(boolean var0, PacketBuffer var1) {
      while(true) {
         byte var2 = 16;
         int var3 = 1 << var2;
         if (var1.bitsRemaining(Client.packetWriter.serverPacketLength) >= var2 + 12) {
            int var4 = var1.readBits(var2);
            if (var4 != var3 - 1) {
               boolean var5 = false;
               if (Client.npcs[var4] == null) {
                  Client.npcs[var4] = new NPC();
                  var5 = true;
               }

               NPC var6 = Client.npcs[var4];
               Client.npcIndices[++Client.npcCount - 1] = var4;
               var6.npcCycle = Client.cycle;
               int var10 = var1.readBits(1);
               if (var10 == 1) {
                  Client.field535[++Client.field413 - 1] = var4;
               }

               var6.definition = class188.getNpcDefinition(var1.readBits(14));
               int var9;
               if (var0) {
                  var9 = var1.readBits(8);
                  if (var9 > 127) {
                     var9 -= 256;
                  }
               } else {
                  var9 = var1.readBits(5);
                  if (var9 > 15) {
                     var9 -= 32;
                  }
               }

               int var7 = var1.readBits(1);
               boolean var11 = var1.readBits(1) == 1;
               if (var11) {
                  var1.readBits(32);
               }

               int var8;
               if (var0) {
                  var8 = var1.readBits(8);
                  if (var8 > 127) {
                     var8 -= 256;
                  }
               } else {
                  var8 = var1.readBits(5);
                  if (var8 > 15) {
                     var8 -= 32;
                  }
               }

               int var12 = Client.field485[var1.readBits(3)];
               if (var5) {
                  var6.orientation = var6.rotation = var12;
               }

               class418.method2176(var6);
               if (var6.field998 == 0) {
                  var6.rotation = 0;
               }

               var6.method561(BuddyRankComparator.localPlayer.pathX[0] + var8, BuddyRankComparator.localPlayer.pathY[0] + var9, var7 == 1);
               continue;
            }
         }

         var1.exportIndex();
         return;
      }
   }
}
