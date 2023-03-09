import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Players")
public class Players {
   @ObfuscatedName("ac")
   @Export("activityFlags")
   static byte[] activityFlags = new byte[2048];
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "[Lis;"
   )
   @Export("playerMovementSpeeds")
   static MoveSpeed[] playerMovementSpeeds = new MoveSpeed[2048];
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "[Lsy;"
   )
   @Export("cachedAppearanceBuffer")
   static Buffer[] cachedAppearanceBuffer = new Buffer[2048];
   @ObfuscatedName("ao")
   @Export("Players_count")
   static int Players_count = 0;
   @ObfuscatedName("av")
   @Export("Players_indices")
   static int[] Players_indices = new int[2048];
   @ObfuscatedName("aq")
   @Export("Players_emptyIdxCount")
   static int Players_emptyIdxCount = 0;
   @ObfuscatedName("ap")
   @Export("Players_emptyIndices")
   static int[] Players_emptyIndices = new int[2048];
   @ObfuscatedName("ar")
   @Export("Players_regions")
   static int[] Players_regions = new int[2048];
   @ObfuscatedName("ak")
   @Export("Players_orientations")
   static int[] Players_orientations = new int[2048];
   @ObfuscatedName("ax")
   @Export("Players_targetIndices")
   static int[] Players_targetIndices = new int[2048];
   @ObfuscatedName("as")
   @Export("Players_pendingUpdateCount")
   static int Players_pendingUpdateCount = 0;
   @ObfuscatedName("ay")
   @Export("Players_pendingUpdateIndices")
   static int[] Players_pendingUpdateIndices = new int[2048];
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Lsy;"
   )
   static Buffer field1079 = new Buffer(new byte[5000]);

   @ObfuscatedName("gy")
   @ObfuscatedSignature(
      descriptor = "(Lmx;Ljava/lang/String;I)V",
      garbageValue = "1745805921"
   )
   static void method603(Archive var0, String var1) {
      ArchiveLoader var2 = new ArchiveLoader(var0, var1);
      Client.archiveLoaders.add(var2);
      Client.field587 += var2.groupCount;
   }
}
