import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pk")
public final class class398 {
   @ObfuscatedName("af")
   final Comparator field3694;
   @ObfuscatedName("an")
   final Map field3693;
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Loe;"
   )
   final class377 field3697;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Loe;"
   )
   final class377 field3692;
   @ObfuscatedName("au")
   final long field3695;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Lpy;"
   )
   final class396 field3696;
   @ObfuscatedName("aq")
   final int field3698;

   @ObfuscatedSignature(
      descriptor = "(JILpy;)V"
   )
   class398(long var1, int var3, class396 var4) {
      this.field3694 = new class397(this);
      this.field3695 = var1;
      this.field3698 = var3;
      this.field3696 = var4;
      if (this.field3698 == -1) {
         this.field3693 = new HashMap(64);
         this.field3697 = new class377(64, this.field3694);
         this.field3692 = null;
      } else {
         if (this.field3696 == null) {
            throw new IllegalArgumentException("");
         }

         this.field3693 = new HashMap(this.field3698);
         this.field3697 = new class377(this.field3698, this.field3694);
         this.field3692 = new class377(this.field3698);
      }

   }

   @ObfuscatedSignature(
      descriptor = "(ILpy;)V"
   )
   public class398(int var1, class396 var2) {
      this(-1L, var1, var2);
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "-119"
   )
   boolean method2121() {
      return this.field3698 != -1;
   }

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;S)Ljava/lang/Object;",
      garbageValue = "12054"
   )
   public Object method2126(Object var1) {
      synchronized(this) {
         if (-1L != this.field3695) {
            this.method2124();
         }

         class399 var3 = (class399)this.field3693.get(var1);
         if (var3 == null) {
            return null;
         } else {
            this.method2123(var3, false);
            return var3.field3699;
         }
      }
   }

   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;",
      garbageValue = "747668912"
   )
   public Object method2122(Object var1, Object var2) {
      synchronized(this) {
         if (this.field3695 != -1L) {
            this.method2124();
         }

         class399 var4 = (class399)this.field3693.get(var1);
         if (var4 != null) {
            Object var8 = var4.field3699;
            var4.field3699 = var2;
            this.method2123(var4, false);
            return var8;
         } else {
            class399 var5;
            if (this.method2121() && this.field3693.size() == this.field3698) {
               var5 = (class399)this.field3692.remove();
               this.field3693.remove(var5.field3700);
               this.field3697.remove(var5);
            }

            var5 = new class399(var2, var1);
            this.field3693.put(var1, var5);
            this.method2123(var5, true);
            return null;
         }
      }
   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "(Lpj;ZB)V",
      garbageValue = "-8"
   )
   void method2123(class399 var1, boolean var2) {
      if (!var2) {
         this.field3697.remove(var1);
         if (this.method2121() && !this.field3692.remove(var1)) {
            throw new IllegalStateException("");
         }
      }

      var1.field3701 = System.currentTimeMillis();
      if (this.method2121()) {
         switch(this.field3696.field3688) {
         case 0:
            ++var1.field3702;
            break;
         case 1:
            var1.field3702 = var1.field3701;
         }

         this.field3692.add(var1);
      }

      this.field3697.add(var1);
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   void method2124() {
      if (this.field3695 == -1L) {
         throw new IllegalStateException("");
      } else {
         long var1 = System.currentTimeMillis() - this.field3695;

         while(!this.field3697.isEmpty()) {
            class399 var3 = (class399)this.field3697.peek();
            if (var3.field3701 >= var1) {
               return;
            }

            this.field3693.remove(var3.field3700);
            this.field3697.remove(var3);
            if (this.method2121()) {
               this.field3692.remove(var3);
            }
         }

      }
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1971799995"
   )
   public void method2127() {
      synchronized(this) {
         this.field3693.clear();
         this.field3697.clear();
         if (this.method2121()) {
            this.field3692.clear();
         }

      }
   }

   @ObfuscatedName("ay")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-262861184"
   )
   public static void method2125() {
      class503.SpriteBuffer_xOffsets = null;
      class17.SpriteBuffer_yOffsets = null;
      class97.SpriteBuffer_spriteWidths = null;
      class138.SpriteBuffer_spriteHeights = null;
      class394.SpriteBuffer_spritePalette = null;
      VarbitComposition.SpriteBuffer_pixels = null;
   }
}
