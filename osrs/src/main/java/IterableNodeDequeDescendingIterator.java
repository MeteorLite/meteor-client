import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mu")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lmv;"
   )
   IterableNodeDeque deque;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lpl;"
   )
   Node field3550;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lpl;"
   )
   Node last = null;

   @ObfuscatedSignature(
      descriptor = "(Lmv;)V"
   )
   IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
      this.setDeque(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lmv;)V"
   )
   void setDeque(IterableNodeDeque var1) {
      this.deque = var1;
      this.start();
   }

   @ObfuscatedName("e")
   void start() {
      this.field3550 = this.deque != null ? this.deque.sentinel.previous : null;
      this.last = null;
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
      return this.deque.sentinel != this.field3550 && this.field3550 != null;
   }

   @ObfuscatedName("next")
   public Object next() {
      Node var1 = this.field3550;
      if (var1 == this.deque.sentinel) {
         var1 = null;
         this.field3550 = null;
      } else {
         this.field3550 = var1.previous;
      }

      this.last = var1;
      return var1;
   }
}
