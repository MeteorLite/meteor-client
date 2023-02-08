import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pi")
@Implements("DualNode")
public class DualNode extends Node {
    @ObfuscatedName("dg")
    public long keyDual;
    @ObfuscatedName("dm")
    @ObfuscatedSignature(
            descriptor = "Lpi;"
    )
    public DualNode previousDual;
    @ObfuscatedName("dn")
    @ObfuscatedSignature(
            descriptor = "Lpi;"
    )
    public DualNode nextDual;

    @ObfuscatedName("dx")
    public void removeDual() {
      if (this.nextDual != null) {
         this.nextDual.previousDual = this.previousDual;
         this.previousDual.nextDual = this.nextDual;
         this.previousDual = null;
         this.nextDual = null;
      }
   }
}
