import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
@Implements("MusicPatchNode")
public class MusicPatchNode extends Node {
   @ObfuscatedName("fu")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive19")
   static Archive archive19;
   @ObfuscatedName("aj")
   int field2755;
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Llb;"
   )
   @Export("patch")
   MusicPatch patch;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lbe;"
   )
   @Export("rawSound")
   RawSound rawSound;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Llj;"
   )
   MusicPatchNode2 field2737;
   @ObfuscatedName("an")
   int field2734;
   @ObfuscatedName("ao")
   int field2739;
   @ObfuscatedName("av")
   int field2754;
   @ObfuscatedName("aq")
   int field2741;
   @ObfuscatedName("ap")
   int field2742;
   @ObfuscatedName("ar")
   int field2743;
   @ObfuscatedName("ak")
   int field2744;
   @ObfuscatedName("ax")
   int field2740;
   @ObfuscatedName("as")
   int field2746;
   @ObfuscatedName("ay")
   int field2747;
   @ObfuscatedName("am")
   int field2751;
   @ObfuscatedName("az")
   int field2749;
   @ObfuscatedName("ae")
   int field2750;
   @ObfuscatedName("au")
   int field2738;
   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "Lbn;"
   )
   @Export("stream")
   RawPcmStream stream;
   @ObfuscatedName("at")
   int field2753;
   @ObfuscatedName("ai")
   int field2748;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1067363009"
   )
   void method1624() {
      this.patch = null;
      this.rawSound = null;
      this.field2737 = null;
      this.stream = null;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "871011997"
   )
   @Export("addGameMessage")
   static void addGameMessage(int var0, String var1, String var2) {
      class12.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2022661591"
   )
   public static boolean method1625() {
      try {
         if (class293.musicPlayerStatus == 2) {
            if (BufferedNetSocket.musicTrack == null) {
               BufferedNetSocket.musicTrack = MusicTrack.readTrack(class364.musicTrackArchive, IntHashTable.musicTrackGroupId, class293.musicTrackFileId);
               if (BufferedNetSocket.musicTrack == null) {
                  return false;
               }
            }

            if (class293.soundCache == null) {
               class293.soundCache = new SoundCache(class293.soundEffectsArchive, class293.musicSamplesArchive);
            }

            if (class293.midiPcmStream.loadMusicTrack(BufferedNetSocket.musicTrack, class293.musicPatchesArchive, class293.soundCache, 22050)) {
               class293.midiPcmStream.clearAll();
               class293.midiPcmStream.setPcmStreamVolume(class368.musicTrackVolume);
               class293.midiPcmStream.setMusicTrack(BufferedNetSocket.musicTrack, class293.musicTrackBoolean);
               class293.musicPlayerStatus = 0;
               BufferedNetSocket.musicTrack = null;
               class293.soundCache = null;
               class364.musicTrackArchive = null;
               return true;
            }
         }
      } catch (Exception var1) {
         var1.printStackTrace();
         class293.midiPcmStream.clear();
         class293.musicPlayerStatus = 0;
         BufferedNetSocket.musicTrack = null;
         class293.soundCache = null;
         class364.musicTrackArchive = null;
      }

      return false;
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "2127102250"
   )
   public static void method1627() {
      ObjectComposition.ObjectDefinition_cached.clear();
      ObjectComposition.ObjectDefinition_cachedModelData.clear();
      ObjectComposition.ObjectDefinition_cachedEntities.clear();
      ObjectComposition.ObjectDefinition_cachedModels.clear();
   }
}
