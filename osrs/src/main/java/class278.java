import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class278 {
   @ObfuscatedName("gq")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1680827583"
   )
   @Export("logOut")
   static final void logOut() {
      Client.packetWriter.close();
      FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
      FloorUnderlayDefinition.FloorUnderlayDefinition_cached.clear();
      class27.method120();
      MusicPatchNode.method1627();
      NPCComposition.NpcDefinition_cached.clear();
      NPCComposition.NpcDefinition_cachedModels.clear();
      ItemComposition.ItemDefinition_cached.clear();
      ItemComposition.ItemDefinition_cachedModels.clear();
      ItemComposition.ItemDefinition_cachedSprites.clear();
      SequenceDefinition.SequenceDefinition_cached.clear();
      SequenceDefinition.SequenceDefinition_cachedFrames.clear();
      SequenceDefinition.SequenceDefinition_cachedModel.clear();
      class155.method825();
      class162.method850();
      VarpDefinition.VarpDefinition_cached.clear();
      KitDefinition.HitSplatDefinition_cachedSprites.method2348();
      Messages.HitSplatDefinition_cached.method2348();
      HitSplatDefinition.HitSplatDefinition_cached.clear();
      HitSplatDefinition.HitSplatDefinition_cachedSprites.clear();
      HitSplatDefinition.HitSplatDefinition_cachedFonts.clear();
      HealthBarDefinition.HealthBarDefinition_cached.clear();
      HealthBarDefinition.HealthBarDefinition_cachedSprites.clear();
      UserComparator4.method648();
      UrlRequest.method645();
      WorldMapElement.WorldMapElement_cachedSprites.clear();
      DbTableType.DBTableType_cache.clear();
      DbRowType.DBRowType_cache.clear();
      Client.Widget_cachedModels.clear();
      Client.Widget_cachedFonts.clear();
      PlayerComposition.PlayerAppearance_cachedModels.clear();
      Widget.Widget_cachedSprites.clear();
      Widget.Widget_cachedModels.clear();
      Widget.Widget_cachedFonts.clear();
      Widget.Widget_cachedSpriteMasks.clear();
      ((TextureProvider)Rasterizer3D.Rasterizer3D_textureLoader).clear();
      Script.Script_cached.clear();
      Client.archive5.method2069();
      UserComparator5.field1148.clearFiles();
      class290.archive7.clearFiles();
      class135.archive4.clearFiles();
      class175.field1434.clearFiles();
      ClientPreferences.archive9.clearFiles();
      class308.archive6.clearFiles();
      Clock.archive11.clearFiles();
      class143.archive8.clearFiles();
      class20.field63.clearFiles();
      AABB.archive10.clearFiles();
      class36.field149.clearFiles();
      class167.archive12.clearFiles();
      class320.field3001.clearFiles();
      class1.scene.clear();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].clear();
      }

      Client.field585.method1082();
      System.gc();
      class293.musicPlayerStatus = 1;
      class364.musicTrackArchive = null;
      IntHashTable.musicTrackGroupId = -1;
      class293.musicTrackFileId = -1;
      class368.musicTrackVolume = 0;
      class293.musicTrackBoolean = false;
      AbstractRasterProvider.pcmSampleLength = 2;
      Client.currentTrackGroupId = -1;
      Client.playingJingle = false;
      class389.method2048();
      class19.updateGameState(10);
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-2107824411"
   )
   static final void method1536(int var0, int var1) {
      if (var0 < 128) {
         var0 = 128;
      }

      if (var0 > 383) {
         var0 = 383;
      }

      if (class311.cameraPitch < var0) {
         class311.cameraPitch = (var0 - class311.cameraPitch) * Skeleton.cameraLookAtAcceleration / 1000 + class311.cameraPitch + GrandExchangeOfferUnitPriceComparator.cameraLookAtSpeed;
         if (class311.cameraPitch > var0) {
            class311.cameraPitch = var0;
         }
      }

      if (class311.cameraPitch > var0) {
         class311.cameraPitch -= (class311.cameraPitch - var0) * Skeleton.cameraLookAtAcceleration / 1000 + GrandExchangeOfferUnitPriceComparator.cameraLookAtSpeed;
         if (class311.cameraPitch < var0) {
            class311.cameraPitch = var0;
         }
      }

      int var2 = var1 - class110.cameraYaw;
      if (var2 > 1024) {
         var2 -= 2048;
      }

      if (var2 < -1024) {
         var2 += 2048;
      }

      if (var2 > 0) {
         class110.cameraYaw = class110.cameraYaw + GrandExchangeOfferUnitPriceComparator.cameraLookAtSpeed + var2 * Skeleton.cameraLookAtAcceleration / 1000;
         class110.cameraYaw &= 2047;
      }

      if (var2 < 0) {
         class110.cameraYaw -= -var2 * Skeleton.cameraLookAtAcceleration / 1000 + GrandExchangeOfferUnitPriceComparator.cameraLookAtSpeed;
         class110.cameraYaw &= 2047;
      }

      int var3 = var1 - class110.cameraYaw;
      if (var3 > 1024) {
         var3 -= 2048;
      }

      if (var3 < -1024) {
         var3 += 2048;
      }

      if (var3 < 0 && var2 > 0 || var3 > 0 && var2 < 0) {
         class110.cameraYaw = var1;
      }

   }

   @ObfuscatedName("kz")
   @ObfuscatedSignature(
      descriptor = "([Lmy;Lmy;ZB)V",
      garbageValue = "17"
   )
   @Export("revalidateWidgetScroll")
   static void revalidateWidgetScroll(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0 ? var1.scrollWidth * 1522996103 * 1656635959 : var1.width * -2118454371 * 1075980981;
      int var4 = var1.scrollHeight != 0 ? var1.scrollHeight * 421465179 * 1561805779 : var1.height * -1008795697 * 1352771375;
      Script.resizeInterface(var0, var1.id, var3, var4, var2);
      if (var1.children != null) {
         Script.resizeInterface(var1.children, var1.id, var3, var4, var2);
      }

      InterfaceParent var5 = (InterfaceParent)Client.interfaceParents.get((long)var1.id);
      if (var5 != null) {
         int var6 = var5.group;
         if (GrandExchangeEvent.loadInterface(var6)) {
            Script.resizeInterface(class155.Widget_interfaceComponents[var6], -1, var3, var4, var2);
         }
      }

      if (var1.contentType == 1337) {
         ;
      }

   }
}
