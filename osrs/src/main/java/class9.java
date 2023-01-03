import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("b")
public class class9 implements class345 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lb;"
   )
   public static final class9 field25 = new class9(0, "POST", true, true);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lb;"
   )
   public static final class9 field16 = new class9(1, "GET", true, false);
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lb;"
   )
   static final class9 field24 = new class9(2, "PUT", false, true);
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lb;"
   )
   static final class9 field18 = new class9(3, "PATCH", false, true);
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lb;"
   )
   static final class9 field19 = new class9(4, "DELETE", false, true);
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "Lrx;"
   )
   static SpritePixels rightTitleSprite;
   @ObfuscatedName("bx")
   static String field23;
   @ObfuscatedName("er")
   @ObfuscatedSignature(
      descriptor = "Lln;"
   )
   static Archive archive7;
   @ObfuscatedName("q")
   int field26;
   @ObfuscatedName("f")
   String field20;
   @ObfuscatedName("r")
   boolean field17;
   @ObfuscatedName("u")
   boolean field22;

   class9(int var1, String var2, boolean var3, boolean var4) {
      this.field26 = var1;
      this.field20 = var2;
      this.field17 = var3;
      this.field22 = var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "2030872852"
   )
   boolean method25() {
      return this.field17;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "96"
   )
   public int rsOrdinal() {
      return this.field26;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "923368011"
   )
   public String method26() {
      return this.field20;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "12"
   )
   boolean method27() {
      return this.field22;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Lqr;",
      garbageValue = "2126474190"
   )
   public static class456 method33(int var0) {
      int var1 = class454.field3965[var0];
      if (var1 == 1) {
         return class456.field3970;
      } else if (var1 == 2) {
         return class456.field3968;
      } else {
         return var1 == 3 ? class456.field3967 : null;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IIB)V",
      garbageValue = "6"
   )
   static void changeWorldSelectSorting(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if (World.World_sortOption1[var5] != var0) {
            var2[var4] = World.World_sortOption1[var5];
            var3[var4] = World.World_sortOption2[var5];
            ++var4;
         }
      }

      World.World_sortOption1 = var2;
      World.World_sortOption2 = var3;
      class420.sortWorlds(World.World_worlds, 0, World.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(Lkd;IIIB)V",
      garbageValue = "0"
   )
   static final void Widget_setKeyRate(Widget var0, int var1, int var2, int var3) {
      if (var0.field2954 == null) {
         throw new RuntimeException();
      } else {
         var0.field2954[var1] = var2;
         var0.field2949[var1] = var3;
      }
   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1971964072"
   )
   static final void method31() {
      int var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      if (Client.oculusOrbState == 0) {
         var0 = class155.localPlayer.x;
         var1 = class155.localPlayer.y;
         if (class29.oculusOrbFocalPointX - var0 < -500 || class29.oculusOrbFocalPointX - var0 > 500 || class14.oculusOrbFocalPointY - var1 < -500 || class14.oculusOrbFocalPointY - var1 > 500) {
            class29.oculusOrbFocalPointX = var0;
            class14.oculusOrbFocalPointY = var1;
         }

         if (var0 != class29.oculusOrbFocalPointX) {
            class29.oculusOrbFocalPointX += (var0 - class29.oculusOrbFocalPointX) / 16;
         }

         if (var1 != class14.oculusOrbFocalPointY) {
            class14.oculusOrbFocalPointY += (var1 - class14.oculusOrbFocalPointY) / 16;
         }

         var2 = class29.oculusOrbFocalPointX >> 7;
         var3 = class14.oculusOrbFocalPointY >> 7;
         var4 = SpotAnimationDefinition.getTileHeight(class29.oculusOrbFocalPointX, class14.oculusOrbFocalPointY, class383.Client_plane);
         var5 = 0;
         int var6;
         if (var2 > 3 && var3 > 3 && var2 < 100 && var3 < 100) {
            for(var6 = var2 - 4; var6 <= var2 + 4; ++var6) {
               for(int var7 = var3 - 4; var7 <= var3 + 4; ++var7) {
                  int var8 = class383.Client_plane;
                  if (var8 < 3 && (Tiles.Tiles_renderFlags[1][var6][var7] & 2) == 2) {
                     ++var8;
                  }

                  int var9 = var4 - Tiles.Tiles_heights[var8][var6][var7];
                  if (var9 > var5) {
                     var5 = var9;
                  }
               }
            }
         }

         var6 = var5 * 192;
         if (var6 > 98048) {
            var6 = 98048;
         }

         if (var6 < 32768) {
            var6 = 32768;
         }

         if (var6 > Client.field449) {
            Client.field449 += (var6 - Client.field449) / 24;
         } else if (var6 < Client.field449) {
            Client.field449 += (var6 - Client.field449) / 80;
         }

         ApproximateRouteStrategy.field347 = SpotAnimationDefinition.getTileHeight(class155.localPlayer.x, class155.localPlayer.y, class383.Client_plane) - Client.camFollowHeight;
      } else if (Client.oculusOrbState == 1) {
         if (Client.field374 && class155.localPlayer != null) {
            var0 = class155.localPlayer.pathX[0];
            var1 = class155.localPlayer.pathY[0];
            if (var0 >= 0 && var1 >= 0 && var0 < 104 && var1 < 104) {
               class29.oculusOrbFocalPointX = class155.localPlayer.x;
               var2 = SpotAnimationDefinition.getTileHeight(class155.localPlayer.x, class155.localPlayer.y, class383.Client_plane) - Client.camFollowHeight;
               if (var2 < ApproximateRouteStrategy.field347) {
                  ApproximateRouteStrategy.field347 = var2;
               }

               class14.oculusOrbFocalPointY = class155.localPlayer.y;
               Client.field374 = false;
            }
         }

         short var10 = -1;
         if (Client.keyHandlerInstance.getKeyPressed(33)) {
            var10 = 0;
         } else if (Client.keyHandlerInstance.getKeyPressed(49)) {
            var10 = 1024;
         }

         if (Client.keyHandlerInstance.getKeyPressed(48)) {
            if (var10 == 0) {
               var10 = 1792;
            } else if (var10 == 1024) {
               var10 = 1280;
            } else {
               var10 = 1536;
            }
         } else if (Client.keyHandlerInstance.getKeyPressed(50)) {
            if (var10 == 0) {
               var10 = 256;
            } else if (var10 == 1024) {
               var10 = 768;
            } else {
               var10 = 512;
            }
         }

         byte var11 = 0;
         if (Client.keyHandlerInstance.getKeyPressed(35)) {
            var11 = -1;
         } else if (Client.keyHandlerInstance.getKeyPressed(51)) {
            var11 = 1;
         }

         var2 = 0;
         if (var10 >= 0 || var11 != 0) {
            var2 = Client.keyHandlerInstance.getKeyPressed(81) ? Client.oculusOrbSlowedSpeed * 807828661 * -912813667 : Client.oculusOrbNormalSpeed * -904534999 * -892471271;
            var2 *= 16;
            Client.field441 = var10;
            Client.field442 = var11;
         }

         if (Client.field483 < var2) {
            Client.field483 += var2 / 8;
            if (Client.field483 > var2) {
               Client.field483 = var2;
            }
         } else if (Client.field483 > var2) {
            Client.field483 = Client.field483 * 9 / 10;
         }

         if (Client.field483 > 0) {
            var3 = Client.field483 / 16;
            if (Client.field441 >= 0) {
               var0 = Client.field441 - class128.cameraYaw & 2047;
               var4 = Rasterizer3D.Rasterizer3D_sine[var0];
               var5 = Rasterizer3D.Rasterizer3D_cosine[var0];
               class29.oculusOrbFocalPointX += var4 * var3 / 65536;
               class14.oculusOrbFocalPointY += var5 * var3 / 65536;
            }

            if (Client.field442 != 0) {
               ApproximateRouteStrategy.field347 += var3 * Client.field442;
               if (ApproximateRouteStrategy.field347 > 0) {
                  ApproximateRouteStrategy.field347 = 0;
               }
            }
         } else {
            Client.field441 = -1;
            Client.field442 = -1;
         }

         if (Client.keyHandlerInstance.getKeyPressed(13)) {
            Client.packetWriter.addNode(class136.getPacketBufferNode(ClientPacket.field2457, Client.packetWriter.isaacCipher));
            Client.oculusOrbState = 0;
         }
      }

      if (MouseHandler.MouseHandler_currentButton == 4 && SceneTilePaint.mouseCam) {
         var0 = MouseHandler.MouseHandler_y - Client.mouseCamClickedY;
         Client.camAngleDX = var0 * 2;
         Client.mouseCamClickedY = var0 != -1 && var0 != 1 ? (Client.mouseCamClickedY + MouseHandler.MouseHandler_y) / 2 : MouseHandler.MouseHandler_y * -1144061877 * -467089053;
         var1 = Client.mouseCamClickedX - MouseHandler.MouseHandler_x;
         Client.camAngleDY = var1 * 2;
         Client.mouseCamClickedX = var1 != -1 && var1 != 1 ? (MouseHandler.MouseHandler_x + Client.mouseCamClickedX) / 2 : MouseHandler.MouseHandler_x * 1055725291 * 638181827;
      } else {
         if (Client.keyHandlerInstance.getKeyPressed(96)) {
            Client.camAngleDY += (-24 - Client.camAngleDY) / 2;
         } else if (Client.keyHandlerInstance.getKeyPressed(97)) {
            Client.camAngleDY += (24 - Client.camAngleDY) / 2;
         } else {
            Client.camAngleDY /= 2;
         }

         if (Client.keyHandlerInstance.getKeyPressed(98)) {
            Client.camAngleDX += (12 - Client.camAngleDX) / 2;
         } else if (Client.keyHandlerInstance.getKeyPressed(99)) {
            Client.camAngleDX += (-12 - Client.camAngleDX) / 2;
         } else {
            Client.camAngleDX /= 2;
         }

         Client.mouseCamClickedY = MouseHandler.MouseHandler_y;
         Client.mouseCamClickedX = MouseHandler.MouseHandler_x;
      }

      Client.camAngleY = Client.camAngleDY / 2 + Client.camAngleY & 2047;
      Client.camAngleX += Client.camAngleDX / 2;
      if (Client.camAngleX < 128) {
         Client.camAngleX = 128;
      }

      if (Client.camAngleX > 383) {
         Client.camAngleX = 383;
      }

   }

   @ObfuscatedName("lo")
   @ObfuscatedSignature(
      descriptor = "(Lcx;ZB)V",
      garbageValue = "93"
   )
   static final void closeInterface(InterfaceParent var0, boolean var1) {
      int var2 = var0.group;
      int var3 = (int)var0.key;
      var0.remove();
      if (var1) {
         HitSplatDefinition.method1006(var2);
      }

      VarpDefinition.method909(var2);
      Widget var4 = ObjTypeCustomisation.getWidget(var3);
      if (var4 != null) {
         class69.invalidateWidget(var4);
      }

      if (Client.rootInterface != -1) {
         GrandExchangeOfferAgeComparator.runIntfCloseListeners(Client.rootInterface, 1);
      }

   }
}
