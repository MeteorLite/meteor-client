import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lj")
@Implements("MusicPatchNode2")
public class MusicPatchNode2 {
   @ObfuscatedName("aj")
   byte[] field2669;
   @ObfuscatedName("al")
   byte[] field2664;
   @ObfuscatedName("ac")
   int field2665;
   @ObfuscatedName("ab")
   int field2666;
   @ObfuscatedName("an")
   int field2671;
   @ObfuscatedName("ao")
   int field2668;
   @ObfuscatedName("av")
   int field2670;
   @ObfuscatedName("aq")
   int field2663;
   @ObfuscatedName("ap")
   int field2667;

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(III)V",
      garbageValue = "-287993147"
   )
   @Export("changeWorldSelectSorting")
   static void changeWorldSelectSorting(int var0, int var1) {
      int[] var2 = new int[4];
      int[] var3 = new int[4];
      var2[0] = var0;
      var3[0] = var1;
      int var4 = 1;

      for(int var5 = 0; var5 < 4; ++var5) {
         if (World.World_sortOption1[var5] != var0) {
            var2[var4] = World.World_sortOption1[var5];
            var3[var4] = World.World_sortOption2[var5];
            ++var4;
         }
      }

      World.World_sortOption1 = var2;
      World.World_sortOption2 = var3;
      class16.sortWorlds(class260.World_worlds, 0, class260.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
   }
}
