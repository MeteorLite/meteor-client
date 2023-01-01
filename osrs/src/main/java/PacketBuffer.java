import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qx")
public class PacketBuffer extends Buffer {
   @ObfuscatedName("e")
   static final int[] field4909 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535, 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("aw")
   protected static boolean hasFocus;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lrg;"
   )
   IsaacCipher isaacCipher;
   @ObfuscatedName("v")
   int bitIndex;

   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "([II)V",
      garbageValue = "-925289865"
   )
   public void newIsaacCipher(int[] var1) {
      this.isaacCipher = new IsaacCipher(var1);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lrg;I)V",
      garbageValue = "-47723003"
   )
   public void setIsaacCipher(IsaacCipher var1) {
      this.isaacCipher = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "631229236"
   )
   public void writeByteIsaac(int var1) {
      super.array[++super.offset - 1] = (byte)(var1 + this.isaacCipher.nextInt());
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-91"
   )
   public int readByteIsaac() {
      return super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-2041069472"
   )
   public boolean method8496() {
      int var1 = super.array[super.offset] - this.isaacCipher.method9129() & 255;
      return var1 >= 128;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "0"
   )
   public int readSmartByteShortIsaac() {
      int var1 = super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255;
      return var1 < 128 ? var1 : (var1 - 128 << 8) + (super.array[++super.offset - 1] - this.isaacCipher.nextInt() & 255);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "([BIIB)V",
      garbageValue = "-68"
   )
   public void method8492(byte[] var1, int var2, int var3) {
      for(int var4 = 0; var4 < var3; ++var4) {
         var1[var4 + var2] = (byte)(super.array[++super.offset - 1] - this.isaacCipher.nextInt());
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "145468903"
   )
   public void importIndex() {
      this.bitIndex = super.offset * 8;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-1119572030"
   )
   public int readBits(int var1) {
      int var2 = this.bitIndex >> 3;
      int var3 = 8 - (this.bitIndex & 7);
      int var4 = 0;

      for(this.bitIndex += var1; var1 > var3; var3 = 8) {
         var4 += (super.array[var2++] & field4909[var3]) << var1 - var3;
         var1 -= var3;
      }

      if (var3 == var1) {
         var4 += super.array[var2] & field4909[var3];
      } else {
         var4 += super.array[var2] >> var3 - var1 & field4909[var1];
      }

      return var4;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-1856241799"
   )
   public void exportIndex() {
      super.offset = (this.bitIndex + 7) / 8;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(II)I",
      garbageValue = "-849194759"
   )
   public int bitsRemaining(int var1) {
      return var1 * 8 - this.bitIndex;
   }
}
