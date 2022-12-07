import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pl")
public class Node {
   @ObfuscatedName("gt")
   public long key;
   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      descriptor = "Lpl;"
   )
   public Node previous;
   @ObfuscatedName("gw")
   @ObfuscatedSignature(
      descriptor = "Lpl;"
   )
   public Node next;

   @ObfuscatedName("fd")
   public void remove() {
      if (this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }

   @ObfuscatedName("fr")
   public boolean hasNext() {
      return this.next != null;
   }
}
