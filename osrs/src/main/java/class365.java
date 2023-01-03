import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nx")
public class class365 implements Iterator {
   @ObfuscatedName("hq")
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Lnm;"
   )
   class366 field3578;
   @ObfuscatedName("e")
   int field3579 = 0;
   @ObfuscatedName("v")
   int field3580;

   @ObfuscatedSignature(
      descriptor = "(Lnm;)V"
   )
   class365(class366 var1) {
      this.field3580 = this.field3578.field3585;
      this.field3578 = var1;
   }

   @Export("hasNext")
   @ObfuscatedName("hasNext")
   public boolean hasNext() {
      return this.field3579 < this.field3578.field3583;
   }

   @Export("next")
   @ObfuscatedName("next")
   public Object next() {
      if (this.field3578.field3585 != this.field3580) {
         throw new ConcurrentModificationException();
      } else if (this.field3579 < this.field3578.field3583) {
         Object var1 = this.field3578.field3586[this.field3579].field3576;
         ++this.field3579;
         return var1;
      } else {
         throw new NoSuchElementException();
      }
   }

   @Export("remove")
   @ObfuscatedName("remove")
   public void remove() {
      throw new UnsupportedOperationException();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-337661484"
   )
   static int method1912(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 != 1927 && var0 != 2927) {
         int var4;
         if (var0 == 1928) {
            var3 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
            var4 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
            if (var4 >= 1 && var4 <= 10) {
               class98 var5 = new class98(var4, var3.id, var3.childIndex, var3.itemId);
               Interpreter.field696.add(var5);
               return 1;
            } else {
               throw new RuntimeException();
            }
         } else if (var0 == 2928) {
            class87.Interpreter_intStackSize -= 3;
            int var7 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
            int var8 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
            if (var8 >= 1 && var8 <= 10) {
               class98 var6 = new class98(var8, var7, var4, ObjTypeCustomisation.getWidget(var7).itemId);
               Interpreter.field696.add(var6);
               return 1;
            } else {
               throw new RuntimeException();
            }
         } else {
            return 2;
         }
      } else if (Interpreter.field700 >= 10) {
         throw new RuntimeException();
      } else {
         if (var0 >= 2000) {
            var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
         } else {
            var3 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
         }

         if (var3.onResize == null) {
            return 0;
         } else {
            ScriptEvent var9 = new ScriptEvent();
            var9.widget = var3;
            var9.args = var3.onResize;
            var9.field851 = Interpreter.field700 + 1;
            Client.scriptEvents.addFirst(var9);
            return 1;
         }
      }
   }
}
