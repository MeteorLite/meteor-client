import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ta")
public enum FillMode implements class356 {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lta;"
    )
    SOLID(0, 0),
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lta;"
   )
   field4119(1, 1),
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Lta;"
   )
   field4120(2, 2);

   @ObfuscatedName("ac")
   public final int field4118;
   @ObfuscatedName("au")
   final int field4121;

   FillMode(int var3, int var4) {
      this.field4118 = var3;
      this.field4121 = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field4121;
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "-358854286"
    )
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
      class123.sortWorlds(class31.World_worlds, 0, class31.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
   }
}
