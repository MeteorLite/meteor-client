import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ms")
public enum class324 implements class356 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3039(0),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3038(1),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3041(2),
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3040(3),
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lms;"
   )
   field3042(4);

   @ObfuscatedName("ab")
   final int field3043;

   class324(int var3) {
      this.field3043 = var3;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field3043;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(IIIIS)V",
      garbageValue = "-14431"
   )
   static void method1839(int var0, int var1, int var2, int var3) {
      for(ObjectSound var4 = (ObjectSound)ObjectSound.objectSounds.last(); var4 != null; var4 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if (var4.soundEffectId != -1 || var4.soundEffectIds != null) {
            int var5 = 0;
            if (var1 > var4.maxX) {
               var5 += var1 - var4.maxX;
            } else if (var1 < var4.x) {
               var5 += var4.x - var1;
            }

            if (var2 > var4.maxY) {
               var5 += var2 - var4.maxY;
            } else if (var2 < var4.y) {
               var5 += var4.y - var2;
            }

            if (var5 - 64 <= var4.field673 && class20.clientPreferences.getAreaSoundEffectsVolume() != 0 && var0 == var4.plane) {
               var5 -= 64;
               if (var5 < 0) {
                  var5 = 0;
               }

               int var6 = (var4.field673 - var5) * class20.clientPreferences.getAreaSoundEffectsVolume() / var4.field673;
               if (var4.stream1 == null) {
                  if (var4.soundEffectId >= 0) {
                     SoundEffect var7 = SoundEffect.readSoundEffect(class426.field3811, var4.soundEffectId, 0);
                     if (var7 != null) {
                        RawSound var8 = var7.toRawSound().resample(WorldMapSectionType.decimator);
                        RawPcmStream var9 = RawPcmStream.createRawPcmStream(var8, 100, var6);
                        var9.setNumLoops(-1);
                        class130.pcmStreamMixer.addSubStream(var9);
                        var4.stream1 = var9;
                     }
                  }
               } else {
                  var4.stream1.method295(var6);
               }

               if (var4.stream2 == null) {
                  if (var4.soundEffectIds != null && (var4.field679 -= var3) <= 0) {
                     int var11 = (int)(Math.random() * (double)var4.soundEffectIds.length);
                     SoundEffect var12 = SoundEffect.readSoundEffect(class426.field3811, var4.soundEffectIds[var11], 0);
                     if (var12 != null) {
                        RawSound var13 = var12.toRawSound().resample(WorldMapSectionType.decimator);
                        RawPcmStream var10 = RawPcmStream.createRawPcmStream(var13, 100, var6);
                        var10.setNumLoops(0);
                        class130.pcmStreamMixer.addSubStream(var10);
                        var4.stream2 = var10;
                        var4.field679 = var4.field681 + (int)(Math.random() * (double)(var4.field682 - var4.field681));
                     }
                  }
               } else {
                  var4.stream2.method295(var6);
                  if (!var4.stream2.hasNext()) {
                     var4.stream2 = null;
                  }
               }
            } else {
               if (var4.stream1 != null) {
                  class130.pcmStreamMixer.removeSubStream(var4.stream1);
                  var4.stream1 = null;
               }

               if (var4.stream2 != null) {
                  class130.pcmStreamMixer.removeSubStream(var4.stream2);
                  var4.stream2 = null;
               }
            }
         }
      }

   }

   @ObfuscatedName("ni")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "896497182"
   )
   static void method1838() {
      if (Client.oculusOrbOnLocalPlayer && MusicPatchNode.localPlayer != null) {
         int var0 = MusicPatchNode.localPlayer.pathX[0];
         int var1 = MusicPatchNode.localPlayer.pathY[0];
         if (var0 < 0 || var1 < 0 || var0 >= 104 || var1 >= 104) {
            return;
         }

         class33.oculusOrbFocalPointX = MusicPatchNode.localPlayer.x;
         int var2 = class147.getTileHeight(MusicPatchNode.localPlayer.x, MusicPatchNode.localPlayer.y, GameEngine.Client_plane) - Client.camFollowHeight;
         if (var2 < class96.field1064) {
            class96.field1064 = var2;
         }

         class144.oculusOrbFocalPointY = MusicPatchNode.localPlayer.y;
         Client.oculusOrbOnLocalPlayer = false;
      }

   }
}
