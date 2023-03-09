import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("op")
public class class373 extends AbstractQueue {
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "[Lob;"
   )
   class371[] field3560;
   @ObfuscatedName("al")
   Map field3558;
   @ObfuscatedName("ac")
   int field3559;
   @ObfuscatedName("ab")
   final Comparator field3561;
   @ObfuscatedName("an")
   int field3562;

   public class373(int var1, Comparator var2) {
      this.field3562 = 0;
      this.field3560 = new class371[var1];
      this.field3558 = new HashMap();
      this.field3561 = var2;
   }

   public class373(int var1) {
      this(var1, (Comparator)null);
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1216129727"
   )
   void method1943() {
      int var1 = (this.field3560.length << 1) + 1;
      this.field3560 = (class371[])((class371[])Arrays.copyOf(this.field3560, var1));
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "-1481495660"
   )
   void method1944(int var1) {
      class371 var2;
      int var3;
      for(var2 = this.field3560[var1]; var1 > 0; var1 = var3) {
         var3 = var1 - 1 >>> 1;
         class371 var4 = this.field3560[var3];
         if (this.field3561 != null) {
            if (this.field3561.compare(var2.field3553, var4.field3553) >= 0) {
               break;
            }
         } else if (((Comparable)var2.field3553).compareTo(var4.field3553) >= 0) {
            break;
         }

         this.field3560[var1] = var4;
         this.field3560[var1].field3551 = var1;
      }

      this.field3560[var1] = var2;
      this.field3560[var1].field3551 = var1;
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1540192029"
   )
   void method1945(int var1) {
      class371 var2 = this.field3560[var1];

      int var8;
      for(int var3 = this.field3559 >>> 1; var1 < var3; var1 = var8) {
         int var4 = (var1 << 1) + 1;
         class371 var5 = this.field3560[var4];
         int var6 = (var1 << 1) + 2;
         class371 var7 = this.field3560[var6];
         if (this.field3561 != null) {
            if (var6 < this.field3559 && this.field3561.compare(var5.field3553, var7.field3553) > 0) {
               var8 = var6;
            } else {
               var8 = var4;
            }
         } else if (var6 < this.field3559 && ((Comparable)var5.field3553).compareTo(var7.field3553) > 0) {
            var8 = var6;
         } else {
            var8 = var4;
         }

         if (this.field3561 != null) {
            if (this.field3561.compare(var2.field3553, this.field3560[var8].field3553) <= 0) {
               break;
            }
         } else if (((Comparable)var2.field3553).compareTo(this.field3560[var8].field3553) <= 0) {
            break;
         }

         this.field3560[var1] = this.field3560[var8];
         this.field3560[var1].field3551 = var1;
      }

      this.field3560[var1] = var2;
      this.field3560[var1].field3551 = var1;
   }

   @Export("remove")
   @ObfuscatedName("remove")
   public boolean remove(Object var1) {
      class371 var2 = (class371)this.field3558.remove(var1);
      if (var2 == null) {
         return false;
      } else {
         ++this.field3562;
         --this.field3559;
         if (this.field3559 == var2.field3551) {
            this.field3560[this.field3559] = null;
            return true;
         } else {
            class371 var3 = this.field3560[this.field3559];
            this.field3560[this.field3559] = null;
            this.field3560[var2.field3551] = var3;
            this.field3560[var2.field3551].field3551 = var2.field3551;
            this.method1945(var2.field3551);
            if (var3 == this.field3560[var2.field3551]) {
               this.method1944(var2.field3551);
            }

            return true;
         }
      }
   }

   @Export("peek")
   @ObfuscatedName("peek")
   public Object peek() {
      return this.field3559 == 0 ? null : this.field3560[0].field3553;
   }

   @Export("poll")
   @ObfuscatedName("poll")
   public Object poll() {
      if (this.field3559 == 0) {
         return null;
      } else {
         ++this.field3562;
         Object var1 = this.field3560[0].field3553;
         this.field3558.remove(var1);
         --this.field3559;
         if (this.field3559 == 0) {
            this.field3560[this.field3559] = null;
         } else {
            this.field3560[0] = this.field3560[this.field3559];
            this.field3560[0].field3551 = 0;
            this.field3560[this.field3559] = null;
            this.method1945(0);
         }

         return var1;
      }
   }

   @Export("contains")
   @ObfuscatedName("contains")
   public boolean contains(Object var1) {
      return this.field3558.containsKey(var1);
   }

   @Export("toArray")
   @ObfuscatedName("toArray")
   public Object[] toArray() {
      Object[] var1 = super.toArray();
      if (this.field3561 != null) {
         Arrays.sort(var1, this.field3561);
      } else {
         Arrays.sort(var1);
      }

      return var1;
   }

   @Export("iterator")
   @ObfuscatedName("iterator")
   public Iterator iterator() {
      return new class372(this);
   }

   @Export("offer")
   @ObfuscatedName("offer")
   public boolean offer(Object var1) {
      if (this.field3558.containsKey(var1)) {
         throw new IllegalArgumentException("");
      } else {
         ++this.field3562;
         int var2 = this.field3559;
         if (var2 >= this.field3560.length) {
            this.method1943();
         }

         ++this.field3559;
         if (var2 == 0) {
            this.field3560[0] = new class371(var1, 0);
            this.field3558.put(var1, this.field3560[0]);
         } else {
            this.field3560[var2] = new class371(var1, var2);
            this.field3558.put(var1, this.field3560[var2]);
            this.method1944(var2);
         }

         return true;
      }
   }

   @Export("size")
   @ObfuscatedName("size")
   public int size() {
      return this.field3559;
   }
}
