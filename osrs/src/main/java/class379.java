import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("on")
public class class379 {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Low;"
   )
   class375 field3602;
   @ObfuscatedName("al")
   int field3600 = 0;
   @ObfuscatedName("ac")
   int field3601 = 0;

   @ObfuscatedSignature(
      descriptor = "(Low;II)V"
   )
   class379(class375 var1, int var2, int var3) {
      this.field3602 = var1;
      this.field3600 = var2;
      this.field3601 = var3;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/lang/String;",
      garbageValue = "416543852"
   )
   public String method2021() {
      if (this.method2023()) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(this.method2024());

         for(int var2 = this.field3600; var2 < this.field3601; ++var2) {
            class377 var3 = this.field3602.method1987(var2);
            var1.append(var3.field3577);
         }

         return var1.toString();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "1204217006"
   )
   boolean method2022(int var1) {
      return this.field3602.method1986() == 2 || this.field3602.method1986() == 1 && (!this.field3602.field3568 || this.field3601 - 1 != var1);
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "-1264391217"
   )
   public boolean method2023() {
      return this.field3601 == this.field3600;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(B)I",
      garbageValue = "-53"
   )
   public int method2024() {
      return this.field3601 - this.field3600;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Lod;I)Z",
      garbageValue = "728286722"
   )
   boolean method2025(class377 var1) {
      if (this.field3602.field3572 == 2) {
         return true;
      } else if (this.field3602.field3572 == 0) {
         return false;
      } else {
         return this.field3602.method1948() != var1;
      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1415953893"
   )
   int method2027() {
      if (this.method2023()) {
         return 0;
      } else {
         class377 var1 = this.field3602.method1987(this.field3601 - 1);
         if (var1.field3577 == '\n') {
            return 0;
         } else if (this.method2025(var1)) {
            return this.field3602.field3569.advances[42];
         } else {
            int var2 = this.field3602.field3569.advances[var1.field3577];
            if (var2 == 0) {
               return var1.field3577 == '\t' ? this.field3602.field3569.advances[32] * 3 : this.field3602.field3569.advances[32];
            } else {
               return var2;
            }
         }
      }
   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      descriptor = "(B)Lrv;",
      garbageValue = "93"
   )
   public class451 method2028() {
      if (this.method2023()) {
         return new class451(0, 0);
      } else {
         class377 var1 = this.field3602.method1987(this.field3601 - 1);
         return new class451(var1.field3576 + this.method2027(), var1.field3575);
      }
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      descriptor = "(IB)Lod;",
      garbageValue = "-99"
   )
   public class377 method2026(int var1) {
      return var1 >= 0 && var1 < this.method2024() ? this.field3602.method1987(this.field3600 + var1) : null;
   }
}
