import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("na")
public class class372 {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lnu;"
   )
   class368 field3624;
   @ObfuscatedName("e")
   int field3622 = 0;
   @ObfuscatedName("v")
   int field3623 = 0;

   @ObfuscatedSignature(
      descriptor = "(Lnu;II)V"
   )
   class372(class368 var1, int var2, int var3) {
      this.field3624 = var1;
      this.field3622 = var2;
      this.field3623 = var3;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(B)Ljava/lang/String;",
      garbageValue = "-8"
   )
   public String method1990() {
      if (this.method1984()) {
         return "";
      } else {
         StringBuilder var1 = new StringBuilder(this.method1988());

         for(int var2 = this.field3622; var2 < this.field3623; ++var2) {
            class370 var3 = this.field3624.method1918(var2);
            var1.append(var3.field3597);
         }

         return var1.toString();
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(II)Z",
      garbageValue = "-668291069"
   )
   boolean method1983(int var1) {
      return this.field3624.method1944() == 2 || this.field3624.method1944() == 1 && (!this.field3624.field3590 || this.field3623 - 1 != var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "866297201"
   )
   public boolean method1984() {
      return this.field3623 == this.field3622;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "200617085"
   )
   public int method1988() {
      return this.field3623 - this.field3622;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(Lnp;I)Z",
      garbageValue = "1865365167"
   )
   boolean method1985(class370 var1) {
      if (this.field3624.field3594 == 2) {
         return true;
      } else if (this.field3624.field3594 == 0) {
         return false;
      } else {
         return this.field3624.method1919() != var1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "1800300537"
   )
   int method1989() {
      if (this.method1984()) {
         return 0;
      } else {
         class370 var1 = this.field3624.method1918(this.field3623 - 1);
         if (var1.field3597 == '\n') {
            return 0;
         } else if (this.method1985(var1)) {
            return this.field3624.field3591.advances[42];
         } else {
            int var2 = this.field3624.field3591.advances[var1.field3597];
            if (var2 == 0) {
               return var1.field3597 == '\t' ? this.field3624.field3591.advances[32] * 3 : this.field3624.field3591.advances[32];
            } else {
               return var2;
            }
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)Lpg;",
      garbageValue = "1286003884"
   )
   public class440 method1986() {
      if (this.method1984()) {
         return new class440(0, 0);
      } else {
         class370 var1 = this.field3624.method1918(this.field3623 - 1);
         return new class440(var1.field3599 + this.method1989(), var1.field3598);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      descriptor = "(IB)Lnp;",
      garbageValue = "1"
   )
   public class370 method1987(int var1) {
      return var1 >= 0 && var1 < this.method1988() ? this.field3624.method1918(this.field3622 + var1) : null;
   }
}
