import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ng")
public class class370 extends AbstractQueue {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "[Lnf;"
   )
   class368[] field3589;
   @ObfuscatedName("w")
   Map field3586;
   @ObfuscatedName("v")
   int field3587;
   @ObfuscatedName("s")
   final Comparator field3585;
   @ObfuscatedName("z")
   int field3588;

   public class370(int var1, Comparator var2) {
      this.field3588 = 0;
      this.field3589 = new class368[var1];
      this.field3586 = new HashMap();
      this.field3585 = var2;
   }

   public class370(int var1) {
      this(var1, (Comparator)null);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "119219884"
   )
   void method1930() {
      int var1 = (this.field3589.length << 1) + 1;
      this.field3589 = (class368[])((class368[])Arrays.copyOf(this.field3589, var1));
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "1"
   )
   void method1932(int var1) {
      class368 var2;
      int var3;
      for(var2 = this.field3589[var1]; var1 > 0; var1 = var3) {
         var3 = var1 - 1 >>> 1;
         class368 var4 = this.field3589[var3];
         if (this.field3585 != null) {
            if (this.field3585.compare(var2.field3581, var4.field3581) >= 0) {
               break;
            }
         } else if (((Comparable)var2.field3581).compareTo(var4.field3581) >= 0) {
            break;
         }

         this.field3589[var1] = var4;
         this.field3589[var1].field3580 = var1;
      }

      this.field3589[var1] = var2;
      this.field3589[var1].field3580 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-95"
   )
   void method1931(int var1) {
      class368 var2 = this.field3589[var1];

      int var8;
      for(int var3 = this.field3587 >>> 1; var1 < var3; var1 = var8) {
         int var4 = (var1 << 1) + 1;
         class368 var5 = this.field3589[var4];
         int var6 = (var1 << 1) + 2;
         class368 var7 = this.field3589[var6];
         if (this.field3585 != null) {
            if (var6 < this.field3587 && this.field3585.compare(var5.field3581, var7.field3581) > 0) {
               var8 = var6;
            } else {
               var8 = var4;
            }
         } else if (var6 < this.field3587 && ((Comparable)var5.field3581).compareTo(var7.field3581) > 0) {
            var8 = var6;
         } else {
            var8 = var4;
         }

         if (this.field3585 != null) {
            if (this.field3585.compare(var2.field3581, this.field3589[var8].field3581) <= 0) {
               break;
            }
         } else if (((Comparable)var2.field3581).compareTo(this.field3589[var8].field3581) <= 0) {
            break;
         }

         this.field3589[var1] = this.field3589[var8];
         this.field3589[var1].field3580 = var1;
      }

      this.field3589[var1] = var2;
      this.field3589[var1].field3580 = var1;
   }

    @ObfuscatedName("remove")
    public boolean remove(Object var1) {
      class368 var2 = (class368)this.field3586.remove(var1);
      if (var2 == null) {
         return false;
      } else {
         ++this.field3588;
         --this.field3587;
         if (var2.field3580 == this.field3587) {
            this.field3589[this.field3587] = null;
            return true;
         } else {
            class368 var3 = this.field3589[this.field3587];
            this.field3589[this.field3587] = null;
            this.field3589[var2.field3580] = var3;
            this.field3589[var2.field3580].field3580 = var2.field3580;
            this.method1931(var2.field3580);
            if (var3 == this.field3589[var2.field3580]) {
               this.method1932(var2.field3580);
            }

            return true;
         }
      }
   }

    @ObfuscatedName("peek")
    public Object peek() {
      return this.field3587 == 0 ? null : this.field3589[0].field3581;
   }

    @ObfuscatedName("size")
    public int size() {
      return this.field3587;
   }

    @ObfuscatedName("offer")
    public boolean offer(Object var1) {
      if (this.field3586.containsKey(var1)) {
         throw new IllegalArgumentException("");
      } else {
         ++this.field3588;
         int var2 = this.field3587;
         if (var2 >= this.field3589.length) {
            this.method1930();
         }

         ++this.field3587;
         if (var2 == 0) {
            this.field3589[0] = new class368(var1, 0);
            this.field3586.put(var1, this.field3589[0]);
         } else {
            this.field3589[var2] = new class368(var1, var2);
            this.field3586.put(var1, this.field3589[var2]);
            this.method1932(var2);
         }

         return true;
      }
   }

    @ObfuscatedName("poll")
    public Object poll() {
      if (this.field3587 == 0) {
         return null;
      } else {
         ++this.field3588;
         Object var1 = this.field3589[0].field3581;
         this.field3586.remove(var1);
         --this.field3587;
         if (this.field3587 == 0) {
            this.field3589[this.field3587] = null;
         } else {
            this.field3589[0] = this.field3589[this.field3587];
            this.field3589[0].field3580 = 0;
            this.field3589[this.field3587] = null;
            this.method1931(0);
         }

         return var1;
      }
   }

    @ObfuscatedName("toArray")
    public Object[] toArray() {
      Object[] var1 = super.toArray();
      if (this.field3585 != null) {
         Arrays.sort(var1, this.field3585);
      } else {
         Arrays.sort(var1);
      }

      return var1;
   }

    @ObfuscatedName("contains")
    public boolean contains(Object var1) {
      return this.field3586.containsKey(var1);
   }

    @ObfuscatedName("iterator")
    public Iterator iterator() {
      return new class369(this);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "78"
   )
   public static int method1934(int var0) {
      return var0 != 0 && var0 != 1 ? -1 : 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(IB)Lqn;",
      garbageValue = "-49"
   )
   public static class463 method1933(int var0) {
      int var1 = class461.field3976[var0];
      if (var1 == 1) {
         return class463.field3979;
      } else if (var1 == 2) {
         return class463.field3985;
      } else {
         return var1 == 3 ? class463.field3980 : null;
      }
   }
}
