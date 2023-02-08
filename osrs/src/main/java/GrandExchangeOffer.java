import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mi")
@Implements("GrandExchangeOffer")
public class GrandExchangeOffer {
    @ObfuscatedName("ir")
    static int[][] xteaKeys;
    @ObfuscatedName("f")
    byte state;
    @ObfuscatedName("w")
    public int id;
    @ObfuscatedName("v")
    public int unitPrice;
    @ObfuscatedName("s")
    public int totalQuantity;
    @ObfuscatedName("z")
    public int currentQuantity;
    @ObfuscatedName("j")
    public int currentPrice;

   public GrandExchangeOffer() {
   }

   @ObfuscatedSignature(
      descriptor = "(Lrd;Z)V",
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

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "-47"
    )
    public int status() {
      return this.state & 7;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "-8448203"
    )
    public int type() {
      return (this.state & 8) == 8 ? 1 : 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-161610158"
   )
   void method1860(int var1) {
      this.state &= -8;
      this.state = (byte)(this.state | var1 & 7);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "10"
   )
   void method1858(int var1) {
      this.state &= -9;
      if (var1 == 1) {
         this.state = (byte)(this.state | 8);
      }

   }

    @ObfuscatedName("lt")
    @ObfuscatedSignature(
            descriptor = "(I)V",
            garbageValue = "-615655692"
    )
    static final void Clan_leaveChat() {
      PacketBufferNode var0 = Renderable.getPacketBufferNode(ClientPacket.field2528, Client.packetWriter.isaacCipher);
      var0.packetBuffer.writeByte(0);
      Client.packetWriter.addNode(var0);
   }
}
