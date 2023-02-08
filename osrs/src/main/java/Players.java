import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cn")
@Implements("Players")
public class Players {
    @ObfuscatedName("tt")
    static int cameraLookAtY;
    @ObfuscatedName("v")
    static byte[] activityFlags = new byte[2048];
    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "[Lhz;"
    )
    static MoveSpeed[] playerMovementSpeeds = new MoveSpeed[2048];
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "[Lrd;"
    )
    static Buffer[] cachedAppearanceBuffer = new Buffer[2048];
    @ObfuscatedName("j")
    static int Players_count = 0;
    @ObfuscatedName("i")
    static int[] Players_indices = new int[2048];
    @ObfuscatedName("n")
    static int Players_emptyIdxCount = 0;
    @ObfuscatedName("l")
    static int[] Players_emptyIndices = new int[2048];
    @ObfuscatedName("k")
    static int[] Players_regions = new int[2048];
    @ObfuscatedName("c")
    static int[] Players_orientations = new int[2048];
    @ObfuscatedName("r")
    static int[] Players_targetIndices = new int[2048];
    @ObfuscatedName("b")
    static int Players_pendingUpdateCount = 0;
    @ObfuscatedName("m")
    static int[] Players_pendingUpdateIndices = new int[2048];
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      descriptor = "Lrd;"
   )
   static Buffer field1091 = new Buffer(new byte[5000]);

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(ILoi;Llm;I)V",
      garbageValue = "-1261818676"
   )
   static void method602(int var0, ArchiveDisk var1, Archive var2) {
      ArchiveDiskAction var3 = new ArchiveDiskAction();
      var3.type = 1;
      var3.key = (long)var0;
      var3.archiveDisk = var1;
      var3.archive = var2;
      NodeDeque var4 = ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue;
      synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
         ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
      }

      class288.method1550();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "4"
   )
   public static int method600(int var0) {
      return WallDecoration.method1305(ViewportMouse.ViewportMouse_entityTags[var0]);
   }

    @ObfuscatedName("j")
    @ObfuscatedSignature(
            descriptor = "(Lbw;Lbw;IZI)I",
            garbageValue = "1916884447"
    )
    static int compareWorlds(World var0, World var1, int var2, boolean var3) {
      if (var2 == 1) {
         int var4 = var0.population;
         int var5 = var1.population;
         if (!var3) {
            if (var4 == -1) {
               var4 = 2001;
            }

            if (var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else if (var2 == 2) {
         return var0.location - var1.location;
      } else if (var2 == 3) {
         if (var0.activity.equals("-")) {
            if (var1.activity.equals("-")) {
               return 0;
            } else {
               return var3 ? -1 : 1;
            }
         } else if (var1.activity.equals("-")) {
            return var3 ? 1 : -1;
         } else {
            return var0.activity.compareTo(var1.activity);
         }
      } else if (var2 == 4) {
         return var0.method381() ? (var1.method381() ? 0 : 1) : (var1.method381() ? -1 : 0);
      } else if (var2 == 5) {
         return var0.method384() ? (var1.method384() ? 0 : 1) : (var1.method384() ? -1 : 0);
      } else if (var2 == 6) {
         return var0.isPvp() ? (var1.isPvp() ? 0 : 1) : (var1.isPvp() ? -1 : 0);
      } else if (var2 == 7) {
         return var0.isMembersOnly() ? (var1.isMembersOnly() ? 0 : 1) : (var1.isMembersOnly() ? -1 : 0);
      } else {
         return var0.id - var1.id;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "-1515481571"
   )
   static final int method601(int var0, int var1) {
      if (var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if (var1 < 2) {
            var1 = 2;
         } else if (var1 > 126) {
            var1 = 126;
         }

         return (var0 & 'ﾀ') + var1;
      }
   }
}
