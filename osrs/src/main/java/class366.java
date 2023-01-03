import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nm")
public class class366 extends AbstractQueue {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "[Lnb;"
   )
   class364[] field3586;
   @ObfuscatedName("e")
   Map field3582;
   @ObfuscatedName("v")
   int field3583;
   @ObfuscatedName("x")
   final Comparator field3584;
   @ObfuscatedName("m")
   int field3585;

   public class366(int var1, Comparator var2) {
      this.field3585 = 0;
      this.field3586 = new class364[var1];
      this.field3582 = new HashMap();
      this.field3584 = var2;
   }

   public class366(int var1) {
      this(var1, (Comparator)null);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-417662224"
   )
   void method1915() {
      int var1 = (this.field3586.length << 1) + 1;
      this.field3586 = (class364[])((class364[])Arrays.copyOf(this.field3586, var1));
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-77"
   )
   void method1913(int var1) {
      class364 var2;
      int var3;
      for(var2 = this.field3586[var1]; var1 > 0; var1 = var3) {
         var3 = var1 - 1 >>> 1;
         class364 var4 = this.field3586[var3];
         if (this.field3584 != null) {
            if (this.field3584.compare(var2.field3576, var4.field3576) >= 0) {
               break;
            }
         } else if (((Comparable)var2.field3576).compareTo(var4.field3576) >= 0) {
            break;
         }

         this.field3586[var1] = var4;
         this.field3586[var1].field3577 = var1;
      }

      this.field3586[var1] = var2;
      this.field3586[var1].field3577 = var1;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "0"
   )
   void method1914(int var1) {
      class364 var2 = this.field3586[var1];

      int var8;
      for(int var3 = this.field3583 >>> 1; var1 < var3; var1 = var8) {
         int var4 = (var1 << 1) + 1;
         class364 var5 = this.field3586[var4];
         int var6 = (var1 << 1) + 2;
         class364 var7 = this.field3586[var6];
         if (this.field3584 != null) {
            if (var6 < this.field3583 && this.field3584.compare(var5.field3576, var7.field3576) > 0) {
               var8 = var6;
            } else {
               var8 = var4;
            }
         } else if (var6 < this.field3583 && ((Comparable)var5.field3576).compareTo(var7.field3576) > 0) {
            var8 = var6;
         } else {
            var8 = var4;
         }

         if (this.field3584 != null) {
            if (this.field3584.compare(var2.field3576, this.field3586[var8].field3576) <= 0) {
               break;
            }
         } else if (((Comparable)var2.field3576).compareTo(this.field3586[var8].field3576) <= 0) {
            break;
         }

         this.field3586[var1] = this.field3586[var8];
         this.field3586[var1].field3577 = var1;
      }

      this.field3586[var1] = var2;
      this.field3586[var1].field3577 = var1;
   }

   @Export("remove")
   @ObfuscatedName("remove")
   public boolean remove(Object var1) {
      class364 var2 = (class364)this.field3582.remove(var1);
      if (var2 == null) {
         return false;
      } else {
         ++this.field3585;
         --this.field3583;
         if (this.field3583 == var2.field3577) {
            this.field3586[this.field3583] = null;
            return true;
         } else {
            class364 var3 = this.field3586[this.field3583];
            this.field3586[this.field3583] = null;
            this.field3586[var2.field3577] = var3;
            this.field3586[var2.field3577].field3577 = var2.field3577;
            this.method1914(var2.field3577);
            if (var3 == this.field3586[var2.field3577]) {
               this.method1913(var2.field3577);
            }

            return true;
         }
      }
   }

   @Export("peek")
   @ObfuscatedName("peek")
   public Object peek() {
      return this.field3583 == 0 ? null : this.field3586[0].field3576;
   }

   @Export("size")
   @ObfuscatedName("size")
   public int size() {
      return this.field3583;
   }

   @Export("poll")
   @ObfuscatedName("poll")
   public Object poll() {
      if (this.field3583 == 0) {
         return null;
      } else {
         ++this.field3585;
         Object var1 = this.field3586[0].field3576;
         this.field3582.remove(var1);
         --this.field3583;
         if (this.field3583 == 0) {
            this.field3586[this.field3583] = null;
         } else {
            this.field3586[0] = this.field3586[this.field3583];
            this.field3586[0].field3577 = 0;
            this.field3586[this.field3583] = null;
            this.method1914(0);
         }

         return var1;
      }
   }

   @Export("contains")
   @ObfuscatedName("contains")
   public boolean contains(Object var1) {
      return this.field3582.containsKey(var1);
   }

   @Export("toArray")
   @ObfuscatedName("toArray")
   public Object[] toArray() {
      Object[] var1 = super.toArray();
      if (this.field3584 != null) {
         Arrays.sort(var1, this.field3584);
      } else {
         Arrays.sort(var1);
      }

      return var1;
   }

   @Export("iterator")
   @ObfuscatedName("iterator")
   public Iterator iterator() {
      return new class365(this);
   }

   @Export("offer")
   @ObfuscatedName("offer")
   public boolean offer(Object var1) {
      if (this.field3582.containsKey(var1)) {
         throw new IllegalArgumentException("");
      } else {
         ++this.field3585;
         int var2 = this.field3583;
         if (var2 >= this.field3586.length) {
            this.method1915();
         }

         ++this.field3583;
         if (var2 == 0) {
            this.field3586[0] = new class364(var1, 0);
            this.field3582.put(var1, this.field3586[0]);
         } else {
            this.field3586[var2] = new class364(var1, var2);
            this.field3582.put(var1, this.field3586[var2]);
            this.method1913(var2);
         }

         return true;
      }
   }
}
