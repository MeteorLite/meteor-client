import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rr")
public class class452 extends class455 {
    @ObfuscatedName("fv")
    @ObfuscatedSignature(
            descriptor = "Lnd;"
    )
    static Archive archive8;
   @ObfuscatedName("af")
   int field3884 = 0;
   @ObfuscatedName("an")
   int field3879 = 0;
   @ObfuscatedName("aw")
   double field3883 = 0.0D;
   @ObfuscatedName("ac")
   double field3881 = 0.0D;
   @ObfuscatedName("au")
   double field3882 = 0.0D;
   @ObfuscatedName("ab")
   double field3885 = 0.0D;
   @ObfuscatedName("aq")
   double field3878 = 0.0D;

   public class452(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10) {
      super(var9, var10);
      this.field3884 = var3;
      this.field3879 = var6;
      if ((var5 - var8) * (var7 - var1) == (var4 - var7) * (var8 - var2)) {
         this.field3883 = (double)var4;
         this.field3881 = (double)var5;
      } else {
         double var11 = (double)((float)(var7 + var1)) / 2.0D;
         double var13 = (double)((float)(var8 + var2)) / 2.0D;
         double var15 = (double)((float)(var4 + var7)) / 2.0D;
         double var17 = (double)((float)(var5 + var8)) / 2.0D;
         double var19 = (double)(var7 - var1) * -1.0D / (double)(var8 - var2);
         double var21 = (double)(var4 - var7) * -1.0D / (double)(var5 - var8);
         this.field3883 = (var17 + (var19 * var11 - var21 * var15) - var13) / (var19 - var21);
         this.field3881 = var13 + var19 * (this.field3883 - var11);
         this.field3882 = Math.sqrt(Math.pow(this.field3883 - (double)var1, 2.0D) + Math.pow(this.field3881 - (double)var2, 2.0D));
         this.field3885 = Math.atan2((double)var2 - this.field3881, (double)var1 - this.field3883);
         double var23 = Math.atan2((double)var8 - this.field3881, (double)var7 - this.field3883);
         this.field3878 = Math.atan2((double)var5 - this.field3881, (double)var4 - this.field3883);
         boolean var25 = this.field3885 <= var23 && var23 <= this.field3878 || this.field3878 <= var23 && var23 <= this.field3885;
         if (!var25) {
            this.field3878 += (double)(this.field3885 - this.field3878 > 0.0D ? 2 : -2) * 3.141592653589793D;
         }

      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2116561795"
   )
   public int vmethod2321() {
      double var1 = this.method2323();
      double var3 = this.field3885 + var1 * (this.field3878 - this.field3885);
      return (int)Math.round(this.field3883 + this.field3882 * Math.cos(var3));
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "2107399454"
   )
   public int vmethod2319() {
      double var1 = this.method2323();
      double var3 = (this.field3878 - this.field3885) * var1 + this.field3885;
      return (int)Math.round(this.field3881 + this.field3882 * Math.sin(var3));
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "0"
   )
   public int vmethod2320() {
      double var1 = this.method2323();
      return (int)Math.round((double)(this.field3879 - this.field3884) * var1 + (double)this.field3884);
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(Lnm;II)Ltc;",
      garbageValue = "988192085"
   )
   public static IndexedSprite method2313(AbstractArchive var0, int var1) {
      byte[] var3 = var0.takeFileFlat(var1);
      boolean var2;
      if (var3 == null) {
         var2 = false;
      } else {
         class485.SpriteBuffer_decode(var3);
         var2 = true;
      }

      return !var2 ? null : Strings.method1852();
   }

    @ObfuscatedName("lb")
    @ObfuscatedSignature(
            descriptor = "(Lmq;I)Z",
            garbageValue = "-1381305986"
    )
    static final boolean runCs1(Widget var0) {
      if (var0.cs1Comparisons == null) {
         return false;
      } else {
         for(int var1 = 0; var1 < var0.cs1Comparisons.length; ++var1) {
            int var2 = ArchiveLoader.method478(var0, var1);
            int var3 = var0.cs1ComparisonValues[var1];
            if (var0.cs1Comparisons[var1] == 2) {
               if (var2 >= var3) {
                  return false;
               }
            } else if (var0.cs1Comparisons[var1] == 3) {
               if (var2 <= var3) {
                  return false;
               }
            } else if (var0.cs1Comparisons[var1] == 4) {
               if (var2 == var3) {
                  return false;
               }
            } else if (var3 != var2) {
               return false;
            }
         }

         return true;
      }
   }
}
