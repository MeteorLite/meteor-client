import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ok")
public final class class391 {
    @ObfuscatedName("cc")
    @ObfuscatedSignature(
            descriptor = "[Lrg;"
    )
    static IndexedSprite[] worldSelectArrows;
   @ObfuscatedName("f")
   final Comparator field3677;
   @ObfuscatedName("w")
   final Map field3672;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lng;"
   )
   final class370 field3673;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lng;"
   )
   final class370 field3671;
   @ObfuscatedName("z")
   final long field3674;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Lnr;"
   )
   final class389 field3676;
   @ObfuscatedName("i")
   final int field3675;

   @ObfuscatedSignature(
      descriptor = "(JILnr;)V"
   )
   class391(long var1, int var3, class389 var4) {
      this.field3677 = new class390(this);
      this.field3674 = var1;
      this.field3675 = var3;
      this.field3676 = var4;
      if (this.field3675 == -1) {
         this.field3672 = new HashMap(64);
         this.field3673 = new class370(64, this.field3677);
         this.field3671 = null;
      } else {
         if (this.field3676 == null) {
            throw new IllegalArgumentException("");
         }

         this.field3672 = new HashMap(this.field3675);
         this.field3673 = new class370(this.field3675, this.field3677);
         this.field3671 = new class370(this.field3675);
      }

   }

   @ObfuscatedSignature(
      descriptor = "(ILnr;)V"
   )
   public class391(int var1, class389 var2) {
      this(-1L, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-74"
   )
   boolean method2050() {
      return this.field3675 != -1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "-554777055"
   )
   public Object method2051(Object var1) {
      synchronized(this) {
         if (-1L != this.field3674) {
            this.method2054();
         }

         class392 var3 = (class392)this.field3672.get(var1);
         if (var3 == null) {
            return null;
         } else {
            this.method2053(var3, false);
            return var3.field3682;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "-2094667345"
   )
   public Object method2052(Object var1, Object var2) {
      synchronized(this) {
         if (this.field3674 != -1L) {
            this.method2054();
         }

         class392 var4 = (class392)this.field3672.get(var1);
         if (var4 != null) {
            Object var8 = var4.field3682;
            var4.field3682 = var2;
            this.method2053(var4, false);
            return var8;
         } else {
            class392 var5;
            if (this.method2050() && this.field3672.size() == this.field3675) {
               var5 = (class392)this.field3671.remove();
               this.field3672.remove(var5.field3680);
               this.field3673.remove(var5);
            }

            var5 = new class392(var2, var1);
            this.field3672.put(var1, var5);
            this.method2053(var5, true);
            return null;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(Loh;ZI)V",
      garbageValue = "1998527527"
   )
   void method2053(class392 var1, boolean var2) {
      if (!var2) {
         this.field3673.remove(var1);
         if (this.method2050() && !this.field3671.remove(var1)) {
            throw new IllegalStateException("");
         }
      }

      var1.field3681 = System.currentTimeMillis();
      if (this.method2050()) {
         switch(this.field3676.field3668) {
         case 0:
            var1.field3679 = var1.field3681;
            break;
         case 1:
            ++var1.field3679;
         }

         this.field3671.add(var1);
      }

      this.field3673.add(var1);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-95573050"
   )
   void method2054() {
      if (this.field3674 == -1L) {
         throw new IllegalStateException("");
      } else {
         long var1 = System.currentTimeMillis() - this.field3674;

         while(!this.field3673.isEmpty()) {
            class392 var3 = (class392)this.field3673.peek();
            if (var3.field3681 >= var1) {
               return;
            }

            this.field3672.remove(var3.field3680);
            this.field3673.remove(var3);
            if (this.method2050()) {
               this.field3671.remove(var3);
            }
         }

      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "-15"
   )
   public void method2055() {
      synchronized(this) {
         this.field3672.clear();
         this.field3673.clear();
         if (this.method2050()) {
            this.field3671.clear();
         }

      }
   }
}
