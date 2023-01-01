import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kn")
public class class286 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive musicPatchesArchive;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive musicSamplesArchive;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive soundEffectsArchive;
   @ObfuscatedName("m")
   public static int musicPlayerStatus = 0;
   @ObfuscatedName("q")
   public static boolean PcmPlayer_stereo;
   @ObfuscatedName("r")
   public static int musicTrackFileId;
   @ObfuscatedName("b")
   public static int pcmSampleLength;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "Lkc;"
   )
   static MusicTrack musicTrack;
}
