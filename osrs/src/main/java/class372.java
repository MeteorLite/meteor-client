import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oi")
public class class372 implements Iterator {
   @ObfuscatedName("ja")
   @Export("regionMapArchives")
   static byte[][] regionMapArchives;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lop;"
   )
   class373 field3555;
   @ObfuscatedName("al")
   int field3554 = 0;
   @ObfuscatedName("ac")
   int field3556;

   @ObfuscatedSignature(
      descriptor = "(Lop;)V"
   )
   class372(class373 var1) {
      this.field3556 = this.field3555.field3562;
      this.field3555 = var1;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.field3554 < this.field3555.field3559;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      if (this.field3555.field3562 != this.field3556) {
         throw new ConcurrentModificationException();
      } else if (this.field3554 < this.field3555.field3559) {
         Object var1 = this.field3555.field3560[this.field3554].field3553;
         ++this.field3554;
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }

   @Export("remove")
   @ObfuscatedName("remove")
   public void remove() {
      throw new UnsupportedOperationException();
   }
}
