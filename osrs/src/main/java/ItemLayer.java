import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ij")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("qy")
   static int field1861;
   @ObfuscatedName("aj")
   @Export("z")
   int z;
   @ObfuscatedName("al")
   @Export("x")
   int x;
   @ObfuscatedName("ac")
   @Export("y")
   int y;
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   @Export("first")
   Renderable first;
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   @Export("second")
   Renderable second;
   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      descriptor = "Liq;"
   )
   @Export("third")
   Renderable third;
   @ObfuscatedName("av")
   @Export("tag")
   long tag;
   @ObfuscatedName("aq")
   @Export("height")
   int height;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(III)I",
      garbageValue = "1889722857"
   )
   static final int method1120(int var0, int var1) {
      int var2 = Varcs.method617(var0 + '넵', var1 + 91923, 4) - 128 + (Varcs.method617(var0 + 10294, var1 + '鎽', 2) - 128 >> 1) + (Varcs.method617(var0, var1, 1) - 128 >> 2);
      var2 = (int)((double)var2 * 0.3D) + 35;
      if (var2 < 10) {
         var2 = 10;
      } else if (var2 > 60) {
         var2 = 60;
      }

      return var2;
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "15567612"
   )
   static int method1119(int var0, Script var1, boolean var2) {
      int var3;
      if (var0 == 4200) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = ParamComposition.ItemDefinition_get(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if (var0 == 4201) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = ParamComposition.ItemDefinition_get(var3);
            if (var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 4202) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = ParamComposition.ItemDefinition_get(var3);
            if (var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               Interpreter.Interpreter_stringStack[++HealthBar.Interpreter_stringStackSize - 1] = "";
            }

            return 1;
         } else if (var0 == 4203) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ParamComposition.ItemDefinition_get(var3).price;
            return 1;
         } else if (var0 == 4204) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ParamComposition.ItemDefinition_get(var3).isStackable == 1 ? 1 : 0;
            return 1;
         } else {
            ItemComposition var6;
            if (var0 == 4205) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var6 = ParamComposition.ItemDefinition_get(var3);
               if (var6.noteTemplate == -1 && var6.note >= 0) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if (var0 == 4206) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var6 = ParamComposition.ItemDefinition_get(var3);
               if (var6.noteTemplate >= 0 && var6.note >= 0) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.note;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if (var0 == 4207) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ParamComposition.ItemDefinition_get(var3).isMembersOnly ? 1 : 0;
               return 1;
            } else if (var0 == 4208) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var6 = ParamComposition.ItemDefinition_get(var3);
               if (var6.placeholderTemplate == -1 && var6.placeholder >= 0) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if (var0 == 4209) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               var6 = ParamComposition.ItemDefinition_get(var3);
               if (var6.placeholderTemplate >= 0 && var6.placeholder >= 0) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.placeholder;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               }

               return 1;
            } else if (var0 == 4210) {
               String var7 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
               var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               PendingSpawn.findItemDefinitions(var7, var4 == 1);
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class323.foundItemIdCount;
               return 1;
            } else if (var0 != 4211) {
               if (var0 == 4212) {
                  class173.foundItemIndex = 0;
                  return 1;
               } else if (var0 == 4213) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var4 = ParamComposition.ItemDefinition_get(var3).getShiftClickIndex();
                  if (var4 == -1) {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
                  } else {
                     Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 + 1;
                  }

                  return 1;
               } else if (var0 == 4214) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ParamComposition.ItemDefinition_get(var3).maleModel;
                  return 1;
               } else if (var0 == 4215) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ParamComposition.ItemDefinition_get(var3).maleModel1;
                  return 1;
               } else if (var0 == 4216) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = ParamComposition.ItemDefinition_get(var3).maleModel2;
                  return 1;
               } else if (var0 == 4217) {
                  var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
                  var6 = ParamComposition.ItemDefinition_get(var3);
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var6.field1758;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if (GrandExchangeEvents.foundItemIds != null && class173.foundItemIndex < class323.foundItemIdCount) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GrandExchangeEvents.foundItemIds[++class173.foundItemIndex - 1] & '\uffff';
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("ih")
   @ObfuscatedSignature(
      descriptor = "(B)Z",
      garbageValue = "13"
   )
   static boolean method1118() {
      return (Client.drawPlayerNames & 2) != 0;
   }
}
