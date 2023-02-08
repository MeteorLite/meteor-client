import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nk")
public class class369 implements Iterator {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lng;"
   )
   class370 field3583;
   @ObfuscatedName("w")
   int field3582 = 0;
   @ObfuscatedName("v")
   int field3584;

   @ObfuscatedSignature(
      descriptor = "(Lng;)V"
   )
   class369(class370 var1) {
      this.field3584 = this.field3583.field3588;
      this.field3583 = var1;
   }

    @ObfuscatedName("remove")
    public void remove() {
      throw new UnsupportedOperationException();
   }

    @ObfuscatedName("next")
    public Object next() {
      if (this.field3583.field3588 != this.field3584) {
         throw new ConcurrentModificationException();
      } else if (this.field3582 < this.field3583.field3587) {
         Object var1 = this.field3583.field3589[this.field3582].field3581;
         ++this.field3582;
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }

    @ObfuscatedName("hasNext")
    public boolean hasNext() {
      return this.field3582 < this.field3583.field3587;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(III)V",
            garbageValue = "-1585797932"
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
      class156.sortWorlds(class88.World_worlds, 0, class88.World_worlds.length - 1, World.World_sortOption1, World.World_sortOption2);
   }
}
