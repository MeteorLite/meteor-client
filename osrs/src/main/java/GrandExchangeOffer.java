import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nb")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
   @ObfuscatedName("cq")
   static String field3530;
    @ObfuscatedName("af")
    byte state;
    @ObfuscatedName("an")
    public int id;
    @ObfuscatedName("aw")
    public int unitPrice;
    @ObfuscatedName("ac")
    public int totalQuantity;
    @ObfuscatedName("au")
    public int currentQuantity;
    @ObfuscatedName("ab")
    public int currentPrice;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      descriptor = "(Lsg;Z)V",
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

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-746702541"
    )
    public int status() {
      return this.state & 7;
   }

    @ObfuscatedName("ac")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-79"
    )
    public int type() {
      return (this.state & 8) == 8 ? 1 : 0;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "99"
   )
   void method1928(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "2014183796"
   )
   void method1927(int var1) {
      this.state &= -9;
      if (var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "([Ljava/lang/String;[SI)V",
      garbageValue = "-680765702"
   )
   public static void method1930(String[] var0, short[] var1) {
      class309.sortItemsByName(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "2076819739"
   )
   public static int method1929(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if (var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if (var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }

    @ObfuscatedName("au")
    @ObfuscatedSignature(
            descriptor = "(I)[Lta;",
            garbageValue = "1113408540"
    )
    public static FillMode[] FillMode_values() {
      return new FillMode[]{FillMode.field4120, FillMode.SOLID, FillMode.field4119};
   }
}
