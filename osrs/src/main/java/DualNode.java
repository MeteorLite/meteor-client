import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pw")
public class DualNode extends Node {
   @ObfuscatedName("dw")
   public long keyDual;
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      descriptor = "Lpw;"
   )
   public DualNode previousDual;
   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      descriptor = "Lpw;"
   )
   public DualNode nextDual;

   @ObfuscatedName("do")
   public void removeDual() {
      if (this.nextDual != null) {
         this.nextDual.previousDual = this.previousDual;
         this.previousDual.nextDual = this.nextDual;
         this.previousDual = null;
         this.nextDual = null;
      }
   }
}
