import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("os")
public class class376 implements Iterator {
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Ltc;"
   )
   static IndexedSprite field3605;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Loe;"
   )
   class377 field3602;
   @ObfuscatedName("an")
   int field3604 = 0;
   @ObfuscatedName("aw")
   int field3603;

   @ObfuscatedSignature(
      descriptor = "(Loe;)V"
   )
   class376(class377 var1) {
      this.field3603 = this.field3602.field3607;
      this.field3602 = var1;
   }

    @ObfuscatedName("hasNext")
    public boolean hasNext() {
      return this.field3604 < this.field3602.field3610;
   }

    @ObfuscatedName("remove")
    public void remove() {
      throw new UnsupportedOperationException();
   }

    @ObfuscatedName("next")
    public Object next() {
      if (this.field3602.field3607 != this.field3603) {
         throw new ConcurrentModificationException();
      } else if (this.field3604 < this.field3602.field3610) {
         Object var1 = this.field3602.field3608[this.field3604].field3600;
         ++this.field3604;
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }
}
