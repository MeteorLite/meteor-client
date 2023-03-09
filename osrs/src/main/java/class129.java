import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class129 implements class352 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1254 = new class129(0, 0, (String)null, -1, -1);
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1236 = new class129(1, 1, (String)null, 0, 2);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1238 = new class129(2, 2, (String)null, 1, 2);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1237 = new class129(3, 3, (String)null, 2, 2);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1249 = new class129(4, 4, (String)null, 3, 1);
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1239 = new class129(5, 5, (String)null, 4, 1);
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1240 = new class129(6, 6, (String)null, 5, 1);
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1241 = new class129(7, 7, (String)null, 6, 3);
   @ObfuscatedName("ap")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1242 = new class129(8, 8, (String)null, 7, 3);
   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1243 = new class129(9, 9, (String)null, 8, 3);
   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1244 = new class129(10, 10, (String)null, 0, 7);
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1245 = new class129(11, 11, (String)null, 1, 7);
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1246 = new class129(12, 12, (String)null, 2, 7);
   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1247 = new class129(13, 13, (String)null, 3, 7);
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1248 = new class129(14, 14, (String)null, 4, 7);
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1235 = new class129(15, 15, (String)null, 5, 7);
   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   static final class129 field1250 = new class129(16, 16, (String)null, 0, 5);
   @ObfuscatedName("au")
   final int field1253;
   @ObfuscatedName("ag")
   final int field1251;
   @ObfuscatedName("at")
   final int field1252;

   @ObfuscatedSignature(
      descriptor = "(IILjava/lang/String;II)V",
      garbageValue = "-1"
   )
   class129(int var1, int var2, String var3, int var4, int var5) {
      this.field1253 = var1;
      this.field1251 = var2;
      this.field1252 = var4;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1409646049"
   )
   @Export("rsOrdinal")
   public int rsOrdinal() {
      return this.field1251;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "52"
   )
   int method711() {
      return this.field1252;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "18"
   )
   static final void method712() {
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
