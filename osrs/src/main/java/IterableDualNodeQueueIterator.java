import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ok")
@Implements("IterableDualNodeQueueIterator")
public class IterableDualNodeQueueIterator implements Iterator {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Lox;"
    )
    IterableDualNodeQueue queue;
    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "Lrk;"
    )
    DualNode head;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lrk;"
    )
    DualNode last = null;

   @ObfuscatedSignature(
      descriptor = "(Lox;)V"
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
