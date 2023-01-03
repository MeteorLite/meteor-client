import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("WorldMapID")
public class WorldMapID {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Liv;"
   )
   static final WorldMapID field2385 = new WorldMapID(0);
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Liv;"
   )
   static final WorldMapID field2384 = new WorldMapID(1);
   @ObfuscatedName("lw")
   @ObfuscatedSignature(
      descriptor = "Lkd;"
   )
   @Export("hoveredItemContainer")
   static Widget hoveredItemContainer;
   @ObfuscatedName("v")
   @Export("value")
   final int value;

   WorldMapID(int var1) {
      this.value = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/String;[IIII)V",
      garbageValue = "-71600503"
   )
   static void method1449(String[] var0, int[] var1, int var2, int var3) {
      if (var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         int var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if (var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               int var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1449(var0, var1, var2, var5 - 1);
         method1449(var0, var1, var5 + 1, var3);
      }

   }

   @ObfuscatedName("nv")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   static void method1448() {
      if (GameEngine.field129 != null) {
         Client.field646 = Client.cycle;
         GameEngine.field129.method1852();

         for(int var0 = 0; var0 < Client.players.length; ++var0) {
            if (Client.players[var0] != null) {
               GameEngine.field129.method1849((Client.players[var0].x >> 7) + class154.baseX, (Client.players[var0].y >> 7) + class365.baseY);
            }
         }
      }

   }
}
