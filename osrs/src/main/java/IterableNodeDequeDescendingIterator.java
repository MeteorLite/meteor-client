import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mf")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Lmt;"
    )
    IterableNodeDeque deque;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lpr;"
   )
   Node field3556;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lpr;"
    )
    Node last = null;

   @ObfuscatedSignature(
      descriptor = "(Lmt;)V"
   )
   IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
      this.setDeque(var1);
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lmt;)V"
    )
    void setDeque(IterableNodeDeque var1) {
      this.deque = var1;
      this.start();
   }

    @ObfuscatedName("w")
    void start() {
      this.field3556 = this.deque != null ? this.deque.sentinel.previous : null;
      this.last = null;
   }

    @ObfuscatedName("next")
    public Object next() {
      Node var1 = this.field3556;
      if (var1 == this.deque.sentinel) {
         var1 = null;
         this.field3556 = null;
      } else {
         this.field3556 = var1.previous;
      }

      this.last = var1;
      return var1;
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

    @ObfuscatedName("hasNext")
    public boolean hasNext() {
      return this.deque.sentinel != this.field3556 && this.field3556 != null;
   }
}
