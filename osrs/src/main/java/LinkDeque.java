import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ma")
public class LinkDeque {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lpr;"
   )
   Link sentinel = new Link();
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "Lpr;"
   )
   Link current;

   public LinkDeque() {
      this.sentinel.previous = this.sentinel;
      this.sentinel.next = this.sentinel;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lpr;)V"
   )
   public void method6845(Link var1) {
      if (var1.next != null) {
         var1.remove();
      }

      var1.next = this.sentinel.next;
      var1.previous = this.sentinel;
      var1.next.previous = var1;
      var1.previous.next = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "()Lpr;"
   )
   public Link method6844() {
      Link var1 = this.sentinel.previous;
      if (var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "()Lpr;"
   )
   public Link method6846() {
      Link var1 = this.current;
      if (var1 == this.sentinel) {
         this.current = null;
         return null;
      } else {
         this.current = var1.previous;
         return var1;
      }
   }
}
