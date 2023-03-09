import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hg")
@Implements("EnumComposition")
public class EnumComposition extends DualNode {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lne;"
   )
   @Export("EnumDefinition_archive")
   static AbstractArchive EnumDefinition_archive;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lkt;"
   )
   @Export("EnumDefinition_cached")
   static EvictingDualNodeHashTable EnumDefinition_cached = new EvictingDualNodeHashTable(64);
   @ObfuscatedName("jx")
   @ObfuscatedSignature(
      descriptor = "[Lsn;"
   )
   @Export("headIconHintSprites")
   static SpritePixels[] headIconHintSprites;
   @ObfuscatedName("ac")
   @Export("inputType")
   public char inputType;
   @ObfuscatedName("ab")
   @Export("outputType")
   public char outputType;
   @ObfuscatedName("an")
   @Export("defaultStr")
   public String defaultStr = "null";
   @ObfuscatedName("ao")
   @Export("defaultInt")
   public int defaultInt;
   @ObfuscatedName("av")
   @Export("outputCount")
   public int outputCount = 0;
   @ObfuscatedName("aq")
   @Export("keys")
   public int[] keys;
   @ObfuscatedName("ap")
   @Export("intVals")
   public int[] intVals;
   @ObfuscatedName("ar")
   @Export("strVals")
   public String[] strVals;

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "1329154788"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if (var2 == 0) {
            return;
         }

         this.decodeNext(var1, var2);
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lsy;IB)V",
      garbageValue = "-35"
   )
   @Export("decodeNext")
   void decodeNext(Buffer var1, int var2) {
      if (var2 == 1) {
         this.inputType = (char)var1.readUnsignedByte();
      } else if (var2 == 2) {
         this.outputType = (char)var1.readUnsignedByte();
      } else if (var2 == 3) {
         this.defaultStr = var1.readStringCp1252NullTerminated();
      } else if (var2 == 4) {
         this.defaultInt = var1.readInt();
      } else {
         int var3;
         if (var2 == 5) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.strVals = new String[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.strVals[var3] = var1.readStringCp1252NullTerminated();
            }
         } else if (var2 == 6) {
            this.outputCount = var1.readUnsignedShort();
            this.keys = new int[this.outputCount];
            this.intVals = new int[this.outputCount];

            for(var3 = 0; var3 < this.outputCount; ++var3) {
               this.keys[var3] = var1.readInt();
               this.intVals[var3] = var1.readInt();
            }
         }
      }

   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-548958041"
   )
   @Export("size")
   public int size() {
      return this.outputCount;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-297669766"
   )
   @Export("playPcmPlayers")
   static final void playPcmPlayers() {
      if (ViewportMouse.pcmPlayer1 != null) {
         ViewportMouse.pcmPlayer1.run();
      }

      if (Interpreter.pcmPlayer0 != null) {
         Interpreter.pcmPlayer0.run();
      }

   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "323203445"
   )
   static final void method953() {
      for(int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
         --Client.queuedSoundEffectDelays[var0];
         if (Client.queuedSoundEffectDelays[var0] >= -10) {
            SoundEffect var9 = Client.soundEffects[var0];
            if (var9 == null) {
               Object var10000 = null;
               var9 = SoundEffect.readSoundEffect(class175.field1434, Client.soundEffectIds[var0], 0);
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
                  int var5 = var4 * 128 + 64 - BuddyRankComparator.localPlayer.x;
                  if (var5 < 0) {
                     var5 = -var5;
                  }

                  int var6 = Client.soundLocations[var0] >> 8 & 255;
                  int var7 = var6 * 128 + 64 - BuddyRankComparator.localPlayer.y;
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

                  var2 = (var3 - var8) * WorldMapSectionType.clientPreferences.getAreaSoundEffectsVolume() / var3;
               } else {
                  var2 = WorldMapSectionType.clientPreferences.getCurrentSoundEffectsVolume();
               }

               if (var2 > 0) {
                  RawSound var10 = var9.toRawSound().resample(TaskHandler.decimator);
                  RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var2);
                  var11.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
                  class323.pcmStreamMixer.addSubStream(var11);
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

      if (Client.playingJingle) {
         boolean var12;
         if (class293.musicPlayerStatus != 0) {
            var12 = true;
         } else {
            var12 = class293.midiPcmStream.isReady();
         }

         if (!var12) {
            if (WorldMapSectionType.clientPreferences.getCurrentMusicVolume() != 0 && Client.currentTrackGroupId != -1) {
               class163.method853(class308.archive6, Client.currentTrackGroupId, 0, WorldMapSectionType.clientPreferences.getCurrentMusicVolume(), false);
            }

            Client.playingJingle = false;
         }
      }

   }
}
