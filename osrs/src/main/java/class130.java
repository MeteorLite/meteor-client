import java.util.concurrent.ThreadFactory;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
final class class130 implements ThreadFactory {
   @ObfuscatedName("o")
   public static String[] cacheSubPaths;
   @ObfuscatedName("nd")
   static int menuX;

   public Thread newThread(Runnable var1) {
      return new Thread(var1, "OSRS Maya Anim Load");
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-1879910170"
   )
   static int method715(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if (var0 == 100) {
         class302.Interpreter_intStackSize -= 3;
         var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
         int var5 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 2];
         if (var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = class133.getWidget(var3);
            if (var6.children == null) {
               var6.children = new Widget[var5 + 1];
            }

            if (var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if (var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.childIndex = var5;
               var12.isIf3 = true;
               if (var4 == 12) {
                  var12.method1744();
                  var12.method1750().method1677(new class100(var12));
                  var12.method1750().method1676(new class101(var12));
               }

               var6.children[var5] = var12;
               if (var2) {
                  Interpreter.scriptDotWidget = var12;
               } else {
                  class85.scriptActiveWidget = var12;
               }

               LoginScreenAnimation.invalidateWidget(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if (var0 == 101) {
            var9 = var2 ? Interpreter.scriptDotWidget : class85.scriptActiveWidget;
            Widget var10 = class133.getWidget(var9.id);
            var10.children[var9.childIndex] = null;
            LoginScreenAnimation.invalidateWidget(var10);
            return 1;
         } else if (var0 == 102) {
            var9 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
            var9.children = null;
            LoginScreenAnimation.invalidateWidget(var9);
            return 1;
         } else if (var0 != 200) {
            if (var0 == 201) {
               var9 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
               if (var9 != null) {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
                  if (var2) {
                     Interpreter.scriptDotWidget = var9;
                  } else {
                     class85.scriptActiveWidget = var9;
                  }
               } else {
                  Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class302.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            Widget var11 = class135.getWidgetChild(var3, var4);
            if (var11 != null && var4 != -1) {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 1;
               if (var2) {
                  Interpreter.scriptDotWidget = var11;
               } else {
                  class85.scriptActiveWidget = var11;
               }
            } else {
               Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
