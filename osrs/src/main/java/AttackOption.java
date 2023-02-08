import java.awt.Desktop;
import java.awt.Desktop.Action;
import java.net.URI;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("AttackOption")
public enum AttackOption implements class349 {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lco;"
    )
    AttackOption_dependsOnCombatLevels(0),
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lco;"
    )
    AttackOption_alwaysRightClick(1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lco;"
   )
   field1067(2),
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "Lco;"
    )
    AttackOption_hidden(3),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Lco;"
   )
   field1071(4);

    @ObfuscatedName("tv")
    static int cameraLookAtAcceleration;
    @ObfuscatedName("j")
    final int id;

   AttackOption(int var3) {
      this.id = var3;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.id;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;ZZI)V",
            garbageValue = "2124220394"
    )
    public static void openURL(String var0, boolean var1, boolean var2) {
      if (var1) {
         if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Action.BROWSE)) {
            try {
               Desktop.getDesktop().browse(new URI(var0));
               return;
            } catch (Exception var4) {
               ;
            }
         }

         if (class31.field99.startsWith("win")) {
            class158.method839(var0, 0);
         } else if (class31.field99.startsWith("mac")) {
            class154.method823(var0, 1, "openjs");
         } else {
            class158.method839(var0, 2);
         }
      } else {
         class158.method839(var0, 3);
      }

   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "457231157"
   )
   static final void method589(int var0) {
      int[] var1 = class31.sceneMinimapSprite.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if ((Tiles.Tiles_renderFlags[var0][var5][var3] & 24) == 0) {
               WorldMapAreaData.scene.drawTileMinimap(var1, var4, 512, var0, var5, var3);
            }

            if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var5][var3] & 8) != 0) {
               WorldMapAreaData.scene.drawTileMinimap(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class31.sceneMinimapSprite.setRaster();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if ((Tiles.Tiles_renderFlags[var0][var6][var5] & 24) == 0) {
               AbstractWorldMapIcon.drawObject(var0, var6, var5, var3, var4);
            }

            if (var0 < 3 && (Tiles.Tiles_renderFlags[var0 + 1][var6][var5] & 8) != 0) {
               AbstractWorldMapIcon.drawObject(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.mapIconCount = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            long var7 = WorldMapAreaData.scene.getFloorDecorationTag(class103.Client_plane, var5, var6);
            if (0L != var7) {
               int var9 = class124.Entity_unpackID(var7);
               int var10 = class463.getObjectDefinition(var9).mapIconId;
               if (var10 >= 0 && class4.WorldMapElement_get(var10).field1494) {
                  Client.mapIcons[Client.mapIconCount] = class4.WorldMapElement_get(var10).getSpriteBool(false);
                  Client.mapIconXs[Client.mapIconCount] = var5;
                  Client.mapIconYs[Client.mapIconCount] = var6;
                  ++Client.mapIconCount;
               }
            }
         }
      }

      KeyHandler.rasterProvider.apply();
   }
}
