import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rs")
public class class453 extends class455 {
   @ObfuscatedName("af")
   int field3887 = 0;
   @ObfuscatedName("an")
   int field3891 = 0;
   @ObfuscatedName("aw")
   int field3888 = 0;
   @ObfuscatedName("ac")
   int field3886 = 0;
   @ObfuscatedName("au")
   int field3890 = 0;
   @ObfuscatedName("ab")
   int field3889 = 0;

   public class453(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      super(var7, var8);
      this.field3887 = var1;
      this.field3891 = var2;
      this.field3888 = var3;
      this.field3886 = var4;
      this.field3890 = var5;
      this.field3889 = var6;
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2116561795"
   )
   public int vmethod2321() {
      double var1 = this.method2323();
      return (int)Math.round((double)(this.field3886 - this.field3887) * var1 + (double)this.field3887);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2107399454"
   )
   public int vmethod2319() {
      double var1 = this.method2323();
      return (int)Math.round(var1 * (double)(this.field3890 - this.field3891) + (double)this.field3891);
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "0"
   )
   public int vmethod2320() {
      double var1 = this.method2323();
      return (int)Math.round((double)this.field3888 + (double)(this.field3889 - this.field3888) * var1);
   }
}
