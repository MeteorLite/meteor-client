import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("h")
   int minTileX;
   @ObfuscatedName("e")
   int maxTileX;
   @ObfuscatedName("v")
   int minTileY;
   @ObfuscatedName("x")
   int maxTileY;
   @ObfuscatedName("m")
   int type;
   @ObfuscatedName("q")
   int minX;
   @ObfuscatedName("f")
   int maxX;
   @ObfuscatedName("r")
   int minZ;
   @ObfuscatedName("u")
   int maxZ;
   @ObfuscatedName("b")
   int minY;
   @ObfuscatedName("j")
   int maxY;
   @ObfuscatedName("g")
   int field2067;
   @ObfuscatedName("i")
   int field2076;
   @ObfuscatedName("o")
   int field2077;
   @ObfuscatedName("n")
   int field2078;
   @ObfuscatedName("k")
   int field2079;
   @ObfuscatedName("a")
   int field2080;
   @ObfuscatedName("s")
   int field2081;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "8"
   )
   public static void method1241() {
      try {
         if (class286.musicPlayerStatus == 1) {
            int var0 = class251.midiPcmStream.method1568();
            if (var0 > 0 && class251.midiPcmStream.isReady()) {
               var0 -= class286.pcmSampleLength;
               if (var0 < 0) {
                  var0 = 0;
               }

               class251.midiPcmStream.setPcmStreamVolume(var0);
               return;
            }

            class251.midiPcmStream.clear();
            class251.midiPcmStream.removeAll();
            if (class304.musicTrackArchive != null) {
               class286.musicPlayerStatus = 2;
            } else {
               class286.musicPlayerStatus = 0;
            }

            class286.musicTrack = null;
            ItemContainer.soundCache = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class251.midiPcmStream.clear();
         class286.musicPlayerStatus = 0;
         class286.musicTrack = null;
         ItemContainer.soundCache = null;
         class304.musicTrackArchive = null;
      }

   }

   @ObfuscatedName("f")
   public static int Entity_unpackID(long var0) {
      return (int)(var0 >>> 17 & 4294967295L);
   }
}
