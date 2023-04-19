import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rp")
@Implements("Node")
public class Node {
    @ObfuscatedName("hr")
    public long key;
    @ObfuscatedName("hc")
    @ObfuscatedSignature(
            descriptor = "Lrp;"
    )
    public Node previous;
    @ObfuscatedName("hg")
    @ObfuscatedSignature(
            descriptor = "Lrp;"
    )
    public Node next;

    @ObfuscatedName("ga")
    public void remove() {
      if (this.next != null) {
         this.next.previous = this.previous;
         this.previous.next = this.next;
         this.previous = null;
         this.next = null;
      }
   }

    @ObfuscatedName("gt")
    public boolean hasNext() {
      return this.next != null;
   }
}
