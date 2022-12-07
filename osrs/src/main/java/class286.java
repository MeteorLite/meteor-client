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
   @ObfuscatedGetter(
      intValue = -248283575
   )
   public static int musicPlayerStatus = 0;
   @ObfuscatedName("q")
   public static boolean PcmPlayer_stereo;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -334824875
   )
   public static int musicTrackFileId;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 623704693
   )
   public static int pcmSampleLength;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "Lkc;"
   )
   static MusicTrack musicTrack;
}
