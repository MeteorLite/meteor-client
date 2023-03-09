import java.util.Collection;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ni")
@Implements("IterableNodeDeque")
public class IterableNodeDeque implements Iterable, Collection {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lru;"
   )
   @Export("sentinel")
   Node sentinel = new Node();
   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "Lru;"
   )
   Node field3530;

   public IterableNodeDeque() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("aj")
   @Export("rsClear")
   public void rsClear() {
      while(this.sentinel.previous != this.sentinel) {
         this.sentinel.previous.remove();
      }

   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lru;)V"
   )
   @Export("addFirst")
   public void addFirst(Node var1) {
      if (var1.next != null) {
         var1.remove();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lru;)V"
   )
   @Export("addLast")
   public void addLast(Node var1) {
      if (var1.next != null) {
         var1.remove();
      }

      var1.next = this.sentinel;
      var1.previous = this.sentinel.previous;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "()Lru;"
   )
   @Export("last")
   public Node last() {
      return this.method1924((Node)null);
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(Lru;)Lru;"
   )
   Node method1924(Node var1) {
      Node var2;
      if (var1 == null) {
         var2 = this.sentinel.previous;
      } else {
         var2 = var1;
      }

      if (var2 == this.sentinel) {
         this.field3530 = null;
         return null;
      } else {
         this.field3530 = var2.previous;
         return var2;
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "()Lru;"
   )
   @Export("previous")
   public Node previous() {
      Node var1 = this.field3530;
      if (var1 == this.sentinel) {
         this.field3530 = null;
         return null;
      } else {
         this.field3530 = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("aq")
   int method1919() {
      int var1 = 0;

      for(Node var2 = this.sentinel.previous; var2 != this.sentinel; var2 = var2.previous) {
         ++var1;
      }

      return var1;
   }

   @ObfuscatedName("ap")
   public boolean method1920() {
      return this.sentinel.previous == this.sentinel;
   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "()[Lru;"
   )
   Node[] method1921() {
      Node[] var1 = new Node[this.method1919()];
      int var2 = 0;

      for(Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
         var1[var2++] = var3;
      }

      return var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(Lru;)Z"
   )
   boolean method1925(Node var1) {
      this.addFirst(var1);
      return true;
   }

   @Export("iterator")
   @ObfuscatedName("iterator")
   public Iterator iterator() {
      return new IterableNodeDequeDescendingIterator(this);
   }

   public boolean contains(Object var1) {
      throw new RuntimeException();
   }

   @Export("toArray")
   @ObfuscatedName("toArray")
   public Object[] toArray() {
      return this.method1921();
   }

   @Export("toArray")
   @ObfuscatedName("toArray")
   public Object[] toArray(Object[] var1) {
      int var2 = 0;

      for(Node var3 = this.sentinel.previous; var3 != this.sentinel; var3 = var3.previous) {
         var1[var2++] = var3;
      }

      return var1;
   }

   public boolean remove(Object var1) {
      throw new RuntimeException();
   }

   public boolean containsAll(Collection var1) {
      throw new RuntimeException();
   }

   public boolean addAll(Collection var1) {
      throw new RuntimeException();
   }

   public boolean removeAll(Collection var1) {
      throw new RuntimeException();
   }

   @Export("add")
   @ObfuscatedName("add")
   public boolean add(Object var1) {
      return this.method1925((Node)var1);
   }

   public boolean retainAll(Collection var1) {
      throw new RuntimeException();
   }

   @Export("isEmpty")
   @ObfuscatedName("isEmpty")
   public boolean isEmpty() {
      return this.method1920();
   }

   @Export("hashCode")
   @ObfuscatedName("hashCode")
   public int hashCode() {
      return super.hashCode();
   }

   @Export("clear")
   @ObfuscatedName("clear")
   public void clear() {
      this.rsClear();
   }

   @Export("size")
   @ObfuscatedName("size")
   public int size() {
      return this.method1919();
   }

   @Export("equals")
   @ObfuscatedName("equals")
   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lru;Lru;)V"
   )
   @Export("IterableNodeDeque_addBefore")
   public static void IterableNodeDeque_addBefore(Node var0, Node var1) {
      if (var0.next != null) {
         var0.remove();
      }

      var0.next = var1;
      var0.previous = var1.previous;
      var0.next.previous = var0;
      var0.previous.next = var0;
   }
}
