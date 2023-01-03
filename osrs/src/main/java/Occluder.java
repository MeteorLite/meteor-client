import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hv")
@Implements("Occluder")
public final class Occluder {
   @ObfuscatedName("h")
   @Export("minTileX")
   int minTileX;
   @ObfuscatedName("e")
   @Export("maxTileX")
   int maxTileX;
   @ObfuscatedName("v")
   @Export("minTileY")
   int minTileY;
   @ObfuscatedName("x")
   @Export("maxTileY")
   int maxTileY;
   @ObfuscatedName("m")
   @Export("type")
   int type;
   @ObfuscatedName("q")
   @Export("minX")
   int minX;
   @ObfuscatedName("f")
   @Export("maxX")
   int maxX;
   @ObfuscatedName("r")
   @Export("minZ")
   int minZ;
   @ObfuscatedName("u")
   @Export("maxZ")
   int maxZ;
   @ObfuscatedName("b")
   @Export("minY")
   int minY;
   @ObfuscatedName("j")
   @Export("maxY")
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
   @Export("Entity_unpackID")
   public static int Entity_unpackID(long var0) {
      return (int)(var0 >>> 17 & 4294967295L);
   }
}
