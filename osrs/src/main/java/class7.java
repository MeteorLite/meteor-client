import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class7 {
    @ObfuscatedName("nk")
    static int menuWidth;
   @ObfuscatedName("f")
   ExecutorService field13 = Executors.newSingleThreadExecutor();
   @ObfuscatedName("w")
   Future field12;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lrd;"
   )
   final Buffer field11;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Ls;"
   )
   final class3 field14;

   @ObfuscatedSignature(
      descriptor = "(Lrd;Ls;)V"
   )
   public class7(Buffer var1, class3 var2) {
      this.field11 = var1;
      this.field14 = var2;
      this.method26();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-504541602"
   )
   public boolean method21() {
      return this.field12.isDone();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-2078703024"
   )
   public void method22() {
      this.field13.shutdown();
      this.field13 = null;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Lrd;",
      garbageValue = "-338612782"
   )
   public Buffer method25() {
      try {
         return (Buffer)this.field12.get();
      } catch (Exception var2) {
         return null;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2134403401"
   )
   void method26() {
      this.field12 = this.field13.submit(new class1(this, this.field11, this.field14));
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Lrs;IIIB)V",
      garbageValue = "1"
   )
   static void method24(SpritePixels var0, int var1, int var2, int var3) {
      WorldMapRegion.WorldMapRegion_cachedSprites.put(var0, ParamComposition.method993(var1, var2, var3), var0.pixels.length * 4);
   }

    @ObfuscatedName("n")
    @ObfuscatedSignature(
            descriptor = "(II)I",
            garbageValue = "833552828"
    )
    static int Messages_getLastChatID(int var0) {
      Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
      if (var1 == null) {
         return -1;
      } else {
         return var1.previousDual == Messages.Messages_queue.sentinel ? -1 : ((Message)var1.previousDual).count;
      }
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1889949053"
   )
   static final void method23() {
      for(int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
         --Client.queuedSoundEffectDelays[var0];
         if (Client.queuedSoundEffectDelays[var0] >= -10) {
            SoundEffect var9 = Client.soundEffects[var0];
            if (var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.readSoundEffect(DynamicObject.field826, Client.soundEffectIds[var0], 0);
               if (var9 == null) {
                  continue;
               }

               Client.queuedSoundEffectDelays[var0] += var9.calculateDelay();
               Client.soundEffects[var0] = var9;
            }

            if (Client.queuedSoundEffectDelays[var0] < 0) {
               int var2;
               if (Client.soundLocations[var0] != 0) {
                  int var3 = (Client.soundLocations[var0] & 255) * 128;
                  int var4 = Client.soundLocations[var0] >> 16 & 255;
                  int var5 = var4 * 128 + 64 - class387.localPlayer.x;
                  if (var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - class387.localPlayer.y;
                  if (var7 < 0) {
                     var7 = -var7;
                  }

                  int var8 = var7 + var5 - 128;
                  if (var8 > var3) {
                     Client.queuedSoundEffectDelays[var0] = -100;
                     continue;
                  }

                  if (var8 < 0) {
                     var8 = 0;
                  }

                  var2 = (var3 - var8) * PacketWriter.clientPreferences.getAreaSoundEffectsVolume() / var3;
               } else {
                  var2 = PacketWriter.clientPreferences.getCurrentSoundEffectsVolume();
               }

               if (var2 > 0) {
                  RawSound var10 = var9.toRawSound().resample(class257.decimator);
                  RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var2);
                  var11.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
                  class209.pcmStreamMixer.addSubStream(var11);
               }

               Client.queuedSoundEffectDelays[var0] = -100;
            }
         } else {
            --Client.soundEffectCount;

            for(int var1 = var0; var1 < Client.soundEffectCount; ++var1) {
               Client.soundEffectIds[var1] = Client.soundEffectIds[var1 + 1];
               Client.soundEffects[var1] = Client.soundEffects[var1 + 1];
               Client.queuedSoundEffectLoops[var1] = Client.queuedSoundEffectLoops[var1 + 1];
               Client.queuedSoundEffectDelays[var1] = Client.queuedSoundEffectDelays[var1 + 1];
               Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
            }

            --var0;
         }
      }

      if (Client.playingJingle && !DynamicObject.method441()) {
         if (PacketWriter.clientPreferences.getCurrentMusicVolume() != 0 && Client.currentTrackGroupId != -1) {
            class148.method784(class153.archive6, Client.currentTrackGroupId, 0, PacketWriter.clientPreferences.getCurrentMusicVolume(), false);
         }

         Client.playingJingle = false;
      }

   }

   @ObfuscatedName("is")
   @ObfuscatedSignature(
      descriptor = "(IIIIB)V",
      garbageValue = "-70"
   )
   static final void method27(int var0, int var1, int var2, int var3) {
      for(int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
         if (Client.rootWidgetWidths[var4] + Client.rootWidgetXs[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetYs[var4] + Client.rootWidgetHeights[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
            Client.field546[var4] = true;
         }
      }

   }
}
