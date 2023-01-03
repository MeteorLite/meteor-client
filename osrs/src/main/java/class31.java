import javax.imageio.ImageIO;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class31 {
   @ObfuscatedName("tz")
   static int cameraMoveToSpeed;
   @ObfuscatedName("h")
   static long field84;
   @ObfuscatedName("fv")
   static int currentPort;

   static {
      ImageIO.setUseCache(false);
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "1"
   )
   static void runWidgetOnLoadListener(int var0) {
      if (var0 != -1) {
         if (Players.loadInterface(var0)) {
            Widget[] var1 = class71.Widget_interfaceComponents[var0];

            for(int var2 = 0; var2 < var1.length; ++var2) {
               Widget var3 = var1[var2];
               if (var3.onLoad != null) {
                  ScriptEvent var4 = new ScriptEvent();
                  var4.widget = var3;
                  var4.args = var3.onLoad;
                  class125.runScript(var4, 5000000, 0);
               }
            }

         }
      }
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "352173417"
   )
   static final void method124() {
      class280.method1527(class102.field1084, Frames.field2063, MusicPatchNode2.field2708);
      class158.method834(NPCComposition.field1594, class101.field1083);
      if (class102.field1084 == class145.cameraX && class414.cameraY == Frames.field2063 && MusicPatchNode2.field2708 == ClanChannel.cameraZ && class97.cameraPitch == NPCComposition.field1594 && class101.field1083 == class128.cameraYaw) {
         Client.field617 = false;
         Client.isCameraLocked = false;
         class109.cameraLookAtX = 0;
         class146.cameraLookAtY = 0;
         class104.cameraLookAtHeight = 0;
         class415.cameraLookAtSpeed = 0;
         LoginScreenAnimation.cameraLookAtAcceleration = 0;
         Tile.cameraMoveToAcceleration = 0;
         cameraMoveToSpeed = 0;
         class155.cameraMoveToX = 0;
         class34.cameraMoveToY = 0;
         Script.cameraMoveToHeight = 0;
      }

   }

   @ObfuscatedName("it")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1979436321"
   )
   static final void method125() {
      for(Projectile var0 = (Projectile)Client.projectiles.last(); var0 != null; var0 = (Projectile)Client.projectiles.previous()) {
         if (var0.plane == class383.Client_plane && Client.cycle <= var0.cycleEnd) {
            if (Client.cycle >= var0.cycleStart) {
               if (var0.targetIndex > 0) {
                  NPC var1 = Client.npcs[var0.targetIndex - 1];
                  if (var1 != null && var1.x >= 0 && var1.x < 13312 && var1.y >= 0 && var1.y < 13312) {
                     var0.setDestination(var1.x, var1.y, SpotAnimationDefinition.getTileHeight(var1.x, var1.y, var0.plane) - var0.endHeight, Client.cycle);
                  }
               }

               if (var0.targetIndex < 0) {
                  int var2 = -var0.targetIndex - 1;
                  Player var3;
                  if (var2 == Client.localPlayerIndex) {
                     var3 = class155.localPlayer;
                  } else {
                     var3 = Client.players[var2];
                  }

                  if (var3 != null && var3.x >= 0 && var3.x < 13312 && var3.y >= 0 && var3.y < 13312) {
                     var0.setDestination(var3.x, var3.y, SpotAnimationDefinition.getTileHeight(var3.x, var3.y, var0.plane) - var0.endHeight, Client.cycle);
                  }
               }

               var0.advance(Client.field408);
               ReflectionCheck.scene.drawEntity(class383.Client_plane, (int)var0.x, (int)var0.y, (int)var0.z, 60, var0, var0.yaw, -1L, false);
            }
         } else {
            var0.remove();
         }
      }

   }
}
