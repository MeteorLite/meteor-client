import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qp")
public final class NodeHashTable {
   @ObfuscatedName("h")
   int size;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "[Lpl;"
   )
   Node[] buckets;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lpl;"
   )
   Node currentGet;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lpl;"
   )
   Node current;
   @ObfuscatedName("m")
   int index = 0;

   public NodeHashTable(int var1) {
      this.size = var1;
      this.buckets = new Node[var1];

      for(int var2 = 0; var2 < var1; ++var2) {
         Node var3 = this.buckets[var2] = new Node();
         var3.previous = var3;
         var3.next = var3;
      }

   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(J)Lpl;"
   )
   public Node get(long var1) {
      Node var3 = this.buckets[(int)(var1 & (long)(this.size - 1))];

      for(this.currentGet = var3.previous; var3 != this.currentGet; this.currentGet = this.currentGet.previous) {
         if (this.currentGet.key == var1) {
            Node var4 = this.currentGet;
            this.currentGet = this.currentGet.previous;
            return var4;
         }
      }

      this.currentGet = null;
      return null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lpl;J)V"
   )
   public void put(Node var1, long var2) {
      if (var1.next != null) {
         var1.remove();
      }

      Node var4 = this.buckets[(int)(var2 & (long)(this.size - 1))];
      var1.next = var4.next;
      var1.previous = var4;
      var1.next.previous = var1;
      var1.previous.next = var1;
      var1.key = var2;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "()Lpl;"
   )
   public Node first() {
      this.index = 0;
      return this.next();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "()Lpl;"
   )
   public Node next() {
      Node var1;
      if (this.index > 0 && this.buckets[this.index - 1] != this.current) {
         var1 = this.current;
         this.current = var1.previous;
         return var1;
      } else {
         do {
            if (this.index >= this.size) {
               return null;
            }

            var1 = this.buckets[this.index++].previous;
         } while(var1 == this.buckets[this.index - 1]);

         this.current = var1.previous;
         return var1;
      }
   }
}
