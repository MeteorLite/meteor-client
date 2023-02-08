import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dp")
public class class120 {
   @ObfuscatedName("f")
   int field1173;
   @ObfuscatedName("w")
   float field1167;
   @ObfuscatedName("v")
   float field1169 = Float.MAX_VALUE;
   @ObfuscatedName("s")
   float field1170 = Float.MAX_VALUE;
   @ObfuscatedName("z")
   float field1172 = Float.MAX_VALUE;
   @ObfuscatedName("j")
   float field1171 = Float.MAX_VALUE;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Ldp;"
   )
   class120 field1168;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(Lrd;IB)V",
      garbageValue = "119"
   )
   void method669(Buffer var1, int var2) {
      this.field1173 = var1.readShort();
      this.field1167 = var1.method2428();
      this.field1169 = var1.method2428();
      this.field1170 = var1.method2428();
      this.field1172 = var1.method2428();
      this.field1171 = var1.method2428();
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-16"
   )
   static int method670() {
      if (Client.archiveLoaders != null && Client.archiveLoadersDone < Client.archiveLoaders.size()) {
         int var0 = 0;

         for(int var1 = 0; var1 <= Client.archiveLoadersDone; ++var1) {
            var0 += ((ArchiveLoader)Client.archiveLoaders.get(var1)).loadedCount;
         }

         return var0 * 10000 / Client.field664;
      } else {
         return 10000;
      }
   }

   @ObfuscatedName("gg")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "421431963"
   )
   static final void method671() {
      int[] var0 = Players.Players_indices;

      int var1;
      for(var1 = 0; var1 < Players.Players_count; ++var1) {
         Player var2 = Client.players[var0[var1]];
         if (var2 != null && var2.overheadTextCyclesRemaining > 0) {
            --var2.overheadTextCyclesRemaining;
            if (var2.overheadTextCyclesRemaining == 0) {
               var2.overheadText = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.npcs[var4];
         if (var3 != null && var3.overheadTextCyclesRemaining > 0) {
            --var3.overheadTextCyclesRemaining;
            if (var3.overheadTextCyclesRemaining == 0) {
               var3.overheadText = null;
            }
         }
      }

   }
}
