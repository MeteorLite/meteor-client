import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pr")
@Implements("Link")
public class Link {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "Lpr;"
   )
   @Export("previous")
   public Link previous;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "Lpr;"
   )
   @Export("next")
   public Link next;

   @ObfuscatedName("h")
   @Export("remove")
   public void remove() {
      if (this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }
}
