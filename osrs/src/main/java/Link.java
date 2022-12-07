import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pr")
public class Link {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lpr;"
   )
   public Link previous;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lpr;"
   )
   public Link next;

   @ObfuscatedName("h")
   public void remove() {
      if (this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
