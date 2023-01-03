import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mz")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("h")
   byte state;
   @ObfuscatedName("e")
   public int id;
   @ObfuscatedName("v")
   public int unitPrice;
   @ObfuscatedName("x")
   public int totalQuantity;
   @ObfuscatedName("m")
   public int currentQuantity;
   @ObfuscatedName("q")
   public int currentPrice;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      descriptor = "(Lqy;Z)V",
      garbageValue = "0"
   )
   public GrandExchangeOffer(Buffer var1, boolean var2) {
      this.state = var1.readByte();
      this.id = var1.readUnsignedShort();
      this.unitPrice = var1.readInt();
      this.totalQuantity = var1.readInt();
      this.currentQuantity = var1.readInt();
      this.currentPrice = var1.readInt();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "1"
   )
   public int status() {
      return this.state & 7;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-1498486537"
   )
   public int type() {
      return (this.state & 8) == 8 ? 1 : 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-125"
   )
   void method1843(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "312309253"
   )
   void method1841(int var1) {
      this.state &= -9;
      if (var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }
}
