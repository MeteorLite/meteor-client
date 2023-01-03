import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ds")
@Implements("UserComparator8")
public class UserComparator8 extends AbstractUserComparator {
   @ObfuscatedName("tu")
   @ObfuscatedSignature(
      descriptor = "Lax;"
   )
   static PcmPlayer pcmPlayer1;
   @ObfuscatedName("fi")
   static int field1154;
   @ObfuscatedName("h")
   final boolean reversed;

   public UserComparator8(boolean var1) {
      this.reversed = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Loa;Loa;B)I",
      garbageValue = "81"
   )
   int compareBuddy(Buddy var1, Buddy var2) {
      if (Client.worldId == var1.world) {
         if (var2.world != Client.worldId) {
            return this.reversed ? -1 : 1;
         }
      } else if (var2.world == Client.worldId) {
         return this.reversed ? 1 : -1;
      }

      return this.compareUser(var1, var2);
   }

   @ObfuscatedName("compare")
   public int compare(Object var1, Object var2) {
      return this.compareBuddy((Buddy)var1, (Buddy)var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lql;III)I",
      garbageValue = "2141786547"
   )
   static int method661(IterableNodeHashTable var0, int var1, int var2) {
      if (var0 == null) {
         return var2;
      } else {
         IntegerNode var3 = (IntegerNode)var0.get((long)var1);
         return var3 == null ? var2 : var3.integer;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-100254626"
   )
   static int method662(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if (var0 == 100) {
         class87.Interpreter_intStackSize -= 3;
         var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
         int var5 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 2];
         if (var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = ObjTypeCustomisation.getWidget(var3);
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
                  var12.method1743();
                  var12.method1724().method1674(new class101(var12));
                  var12.method1724().method1673(new class102(var12));
               }

               var6.children[var5] = var12;
               if (var2) {
                  class190.scriptDotWidget = var12;
               } else {
                  class360.scriptActiveWidget = var12;
               }

               class69.invalidateWidget(var6);
               return 1;
            }
         }
      } else {
         Widget var9;
         if (var0 == 101) {
            var9 = var2 ? class190.scriptDotWidget : class360.scriptActiveWidget;
            Widget var10 = ObjTypeCustomisation.getWidget(var9.id);
            var10.children[var9.childIndex] = null;
            class69.invalidateWidget(var10);
            return 1;
         } else if (var0 == 102) {
            var9 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
            var9.children = null;
            class69.invalidateWidget(var9);
            return 1;
         } else if (var0 != 200) {
            if (var0 == 201) {
               var9 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
               if (var9 != null) {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
                  if (var2) {
                     class190.scriptDotWidget = var9;
                  } else {
                     class360.scriptActiveWidget = var9;
                  }
               } else {
                  Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class87.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[class87.Interpreter_intStackSize + 1];
            Widget var11 = AttackOption.getWidgetChild(var3, var4);
            if (var11 != null && var4 != -1) {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
               if (var2) {
                  class190.scriptDotWidget = var11;
               } else {
                  class360.scriptActiveWidget = var11;
               }
            } else {
               Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
