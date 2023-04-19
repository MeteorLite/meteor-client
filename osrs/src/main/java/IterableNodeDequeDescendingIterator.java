import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nq")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "Loi;"
    )
    IterableNodeDeque deque;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Lrp;"
   )
   Node field3579;
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lrp;"
    )
    Node last = null;

   @ObfuscatedSignature(
      descriptor = "(Loi;)V"
   )
   IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
      this.setDeque(var1);
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Loi;)V"
    )
    void setDeque(IterableNodeDeque var1) {
      this.deque = var1;
      this.start();
   }

    @ObfuscatedName("an")
    void start() {
      this.field3579 = this.deque != null ? this.deque.sentinel.previous : null;
      this.last = null;
   }

    @ObfuscatedName("hasNext")
    public boolean hasNext() {
      return this.deque.sentinel != this.field3579 && this.field3579 != null;
   }

    @ObfuscatedName("remove")
    public void remove() {
      if (this.last == null) {
         throw new IllegalStateException();
      } else {
         this.last.remove();
         this.last = null;
      }
   }

    @ObfuscatedName("next")
    public Object next() {
      Node var1 = this.field3579;
      if (var1 == this.deque.sentinel) {
         var1 = null;
         this.field3579 = null;
      } else {
         this.field3579 = var1.previous;
      }

      this.last = var1;
      return var1;
   }
}
