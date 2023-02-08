import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mj")
@Implements("IterableDualNodeQueueIterator")
public class IterableDualNodeQueueIterator implements Iterator {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lmc;"
    )
    IterableDualNodeQueue queue;
    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "Lpi;"
    )
    DualNode head;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lpi;"
    )
    DualNode last = null;

   @ObfuscatedSignature(
      descriptor = "(Lmc;)V"
   )
   IterableDualNodeQueueIterator(IterableDualNodeQueue var1) {
      this.queue = var1;
      this.head = this.queue.sentinel.previousDual;
      this.last = null;
   }

    @ObfuscatedName("next")
    public Object next() {
      DualNode var1 = this.head;
      if (var1 == this.queue.sentinel) {
         var1 = null;
         this.head = null;
      } else {
         this.head = var1.previousDual;
      }

      this.last = var1;
      return var1;
   }

    @ObfuscatedName("hasNext")
    public boolean hasNext() {
      return this.queue.sentinel != this.head;
   }

    @ObfuscatedName("remove")
    public void remove() {
      if (this.last == null) {
         throw new IllegalStateException();
      } else {
         this.last.removeDual();
         this.last = null;
      }
   }
}
