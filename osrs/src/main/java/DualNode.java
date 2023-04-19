import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rk")
@Implements("DualNode")
public class DualNode extends Node {
    @ObfuscatedName("ef")
    public long keyDual;
    @ObfuscatedName("ez")
    @ObfuscatedSignature(
            descriptor = "Lrk;"
    )
    public DualNode previousDual;
    @ObfuscatedName("ej")
    @ObfuscatedSignature(
            descriptor = "Lrk;"
    )
    public DualNode nextDual;

    @ObfuscatedName("fs")
    public void removeDual() {
      if (this.nextDual != null) {
         this.nextDual.previousDual = this.previousDual;
         this.previousDual.nextDual = this.nextDual;
         this.previousDual = null;
         this.nextDual = null;
      }
   }
}
