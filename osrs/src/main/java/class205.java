import java.util.Arrays;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gl")
public class class205 implements class29 {
    @ObfuscatedName("cx")
    @ObfuscatedSignature(
            descriptor = "Lrg;"
    )
    static IndexedSprite worldSelectRightSprite;
   @ObfuscatedName("f")
   char[] field1819 = new char[128];
   @ObfuscatedName("w")
   int[] field1820 = new int[128];
   @ObfuscatedName("v")
   public int[] field1821 = new int[128];
    @ObfuscatedName("s")
    public int pressedKeysCount = 0;
   @ObfuscatedName("z")
   int[] field1830 = new int[128];
   @ObfuscatedName("j")
   int field1822 = 0;
   @ObfuscatedName("i")
   int field1825 = 0;
   @ObfuscatedName("n")
   int field1824 = 0;
   @ObfuscatedName("l")
   int field1827 = 0;
   @ObfuscatedName("k")
   boolean[] field1831 = new boolean[112];
   @ObfuscatedName("c")
   boolean[] field1829 = new boolean[112];
   @ObfuscatedName("r")
   boolean[] field1823 = new boolean[112];
   @ObfuscatedName("b")
   public char field1826;
   @ObfuscatedName("m")
   public int field1832;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(IB)Z",
            garbageValue = "110"
    )
    public boolean vmethod3949(int var1) {
      this.method1082(var1);
      this.field1831[var1] = true;
      this.field1829[var1] = true;
      this.field1823[var1] = false;
      this.field1821[++this.pressedKeysCount - 1] = var1;
      return true;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(IB)Z",
            garbageValue = "11"
    )
    public boolean vmethod3989(int var1) {
      this.field1831[var1] = false;
      this.field1829[var1] = false;
      this.field1823[var1] = true;
      this.field1830[++this.field1822 - 1] = var1;
      return true;
   }

    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "(CI)Z",
            garbageValue = "783044550"
    )
    public boolean vmethod3951(char var1) {
      int var2 = this.field1824 + 1 & 127;
      if (var2 != this.field1825) {
         this.field1820[this.field1824] = -1;
         this.field1819[this.field1824] = var1;
         this.field1824 = var2;
      }

      return false;
   }

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(ZI)Z",
            garbageValue = "653857297"
    )
    public boolean vmethod3953(boolean var1) {
      return false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1103025753"
   )
   void method1082(int var1) {
      int var2 = this.field1824 + 1 & 127;
      if (var2 != this.field1825) {
         this.field1820[this.field1824] = var1;
         this.field1819[this.field1824] = 0;
         this.field1824 = var2;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "8"
   )
   public void method1084() {
      this.field1825 = this.field1827;
      this.field1827 = this.field1824;
      this.pressedKeysCount = 0;
      this.field1822 = 0;
      Arrays.fill(this.field1829, false);
      Arrays.fill(this.field1823, false);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "51"
   )
   public final boolean method1085() {
      if (this.field1827 == this.field1825) {
         return false;
      } else {
         this.field1832 = this.field1820[this.field1825];
         this.field1826 = this.field1819[this.field1825];
         this.field1825 = this.field1825 + 1 & 127;
         return true;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      descriptor = "(IB)Z",
      garbageValue = "0"
   )
   public boolean method1086(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1829[var1] : false;
   }

    @ObfuscatedName("e")
    @ObfuscatedSignature(
            descriptor = "(IB)Z",
            garbageValue = "44"
    )
    public boolean getKeyPressed(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1831[var1] : false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "32514287"
   )
   public boolean method1089(int var1) {
      return var1 >= 0 && var1 < 112 ? this.field1823[var1] : false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      descriptor = "(B)[I",
      garbageValue = "-100"
   )
   public int[] method1090() {
      int[] var1 = new int[this.pressedKeysCount];

      for(int var2 = 0; var2 < this.pressedKeysCount; ++var2) {
         var1[var2] = this.field1821[var2];
      }

      return var1;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "848909243"
   )
   public int[] method1088() {
      int[] var1 = new int[this.field1822];

      for(int var2 = 0; var2 < this.field1822; ++var2) {
         var1[var2] = this.field1830[var2];
      }

      return var1;
   }

    @ObfuscatedName("je")
    @ObfuscatedSignature(
            descriptor = "(IIB)V",
            garbageValue = "-90"
    )
    static void resumePauseWidget(int var0, int var1) {
      PacketBufferNode var2 = Renderable.getPacketBufferNode(ClientPacket.field2523, Client.packetWriter.isaacCipher);
      var2.packetBuffer.writeShort(var1);
      var2.packetBuffer.writeInt(var0);
      Client.packetWriter.addNode(var2);
   }
}
