import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pe")
public final class class394 {
   @ObfuscatedName("aj")
   final Comparator field3648;
   @ObfuscatedName("al")
   final Map field3645;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Lop;"
   )
   final class373 field3644;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lop;"
   )
   final class373 field3642;
   @ObfuscatedName("an")
   final long field3643;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Lpm;"
   )
   final class392 field3647;
   @ObfuscatedName("av")
   final int field3646;

   @ObfuscatedSignature(
      descriptor = "(JILpm;)V"
   )
   class394(long var1, int var3, class392 var4) {
      this.field3648 = new class393(this);
      this.field3643 = var1;
      this.field3646 = var3;
      this.field3647 = var4;
      if (this.field3646 == -1) {
         this.field3645 = new HashMap(64);
         this.field3644 = new class373(64, this.field3648);
         this.field3642 = null;
      } else {
         if (this.field3647 == null) {
            throw new IllegalArgumentException("");
         }

         this.field3645 = new HashMap(this.field3646);
         this.field3644 = new class373(this.field3646, this.field3648);
         this.field3642 = new class373(this.field3646);
      }

   }

   @ObfuscatedSignature(
      descriptor = "(ILpm;)V"
   )
   public class394(int var1, class392 var2) {
      this(-1L, var1, var2);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-121"
   )
   boolean method2070() {
      return this.field3646 != -1;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;B)Ljava/lang/Object;",
      garbageValue = "-9"
   )
   public Object method2066(Object var1) {
      synchronized(this) {
         if (this.field3643 != -1L) {
            this.method2068();
         }

         class395 var3 = (class395)this.field3645.get(var1);
         if (var3 == null) {
            return null;
         } else {
            this.method2067(var3, false);
            return var3.field3652;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "-388203843"
   )
   public Object method2071(Object var1, Object var2) {
      synchronized(this) {
         if (this.field3643 != -1L) {
            this.method2068();
         }

         class395 var4 = (class395)this.field3645.get(var1);
         if (var4 != null) {
            Object var8 = var4.field3652;
            var4.field3652 = var2;
            this.method2067(var4, false);
            return var8;
         } else {
            class395 var5;
            if (this.method2070() && this.field3645.size() == this.field3646) {
               var5 = (class395)this.field3642.remove();
               this.field3645.remove(var5.field3650);
               this.field3644.remove(var5);
            }

            var5 = new class395(var2, var1);
            this.field3645.put(var1, var5);
            this.method2067(var5, true);
            return null;
         }
      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(Lpn;ZI)V",
      garbageValue = "-797803936"
   )
   void method2067(class395 var1, boolean var2) {
      if (!var2) {
         this.field3644.remove(var1);
         if (this.method2070() && !this.field3642.remove(var1)) {
            throw new IllegalStateException("");
         }
      }

      var1.field3649 = System.currentTimeMillis();
      if (this.method2070()) {
         switch(this.field3647.field3639) {
         case 0:
            ++var1.field3651;
            break;
         case 1:
            var1.field3651 = var1.field3649;
         }

         this.field3642.add(var1);
      }

      this.field3644.add(var1);
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1617279865"
   )
   void method2068() {
      if (this.field3643 == -1L) {
         throw new IllegalStateException("");
      } else {
         long var1 = System.currentTimeMillis() - this.field3643;

         while(!this.field3644.isEmpty()) {
            class395 var3 = (class395)this.field3644.peek();
            if (var3.field3649 >= var1) {
               return;
            }

            this.field3645.remove(var3.field3650);
            this.field3644.remove(var3);
            if (this.method2070()) {
               this.field3642.remove(var3);
            }
         }

      }
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1379189598"
   )
   public void method2069() {
      synchronized(this) {
         this.field3645.clear();
         this.field3644.clear();
         if (this.method2070()) {
            this.field3642.clear();
         }

      }
   }
}
