import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rx")
public class class474 {
   @ObfuscatedName("f")
   int[] field4007 = new int[8];
   @ObfuscatedName("w")
   short[] field4008 = new short[8];

   @ObfuscatedSignature(
      descriptor = "(Lgo;)V"
   )
   public class474(NPCComposition var1) {
      int var2 = 0;
      if (var1.method964()) {
         var2 = var1.method970().length;
         System.arraycopy(var1.method970(), 0, this.field4007, 0, var2);
         System.arraycopy(var1.method967(), 0, this.field4008, 0, var2);
      }

      for(int var3 = var2; var3 < 8; ++var3) {
         this.field4007[var3] = -1;
         this.field4008[var3] = -1;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)[I",
      garbageValue = "1293507413"
   )
   public int[] method2445() {
      return this.field4007;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(B)[S",
      garbageValue = "-114"
   )
   public short[] method2446() {
      return this.field4008;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IISS)V",
      garbageValue = "150"
   )
   public void method2447(int var1, int var2, short var3) {
      this.field4007[var1] = var2;
      this.field4008[var1] = var3;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "([I[SB)V",
      garbageValue = "-84"
   )
   public void method2448(int[] var1, short[] var2) {
      this.field4007 = var1;
      this.field4008 = var2;
   }
}
