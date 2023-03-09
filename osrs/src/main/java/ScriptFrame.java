import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
@Implements("ScriptFrame")
public class ScriptFrame {
   @ObfuscatedName("vy")
   static Iterator field339;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lcv;"
   )
   @Export("script")
   Script script;
   @ObfuscatedName("al")
   @Export("pc")
   int pc = -1;
   @ObfuscatedName("ac")
   @Export("intLocals")
   int[] intLocals;
   @ObfuscatedName("ab")
   @Export("stringLocals")
   String[] stringLocals;

   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "1931889583"
   )
   static int method322(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if (var0 == 4000) {
         Interpreter.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 + var3;
         return 1;
      } else if (var0 == 4001) {
         Interpreter.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 - var4;
         return 1;
      } else if (var0 == 4002) {
         Interpreter.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4 * var3;
         return 1;
      } else if (var0 == 4003) {
         Interpreter.Interpreter_intStackSize -= 2;
         var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 / var4;
         return 1;
      } else if (var0 == 4004) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)var3);
         return 1;
      } else if (var0 == 4005) {
         var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(Math.random() * (double)(var3 + 1));
         return 1;
      } else {
         int var5;
         int var6;
         int var7;
         if (var0 == 4006) {
            Interpreter.Interpreter_intStackSize -= 5;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
            var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 4];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 + (var7 - var5) * (var4 - var3) / (var6 - var5);
            return 1;
         } else if (var0 == 4007) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 + var3 * var4 / 100;
            return 1;
         } else if (var0 == 4008) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 | 1 << var4;
            return 1;
         } else if (var0 == 4009) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & -1 - (1 << var4);
            return 1;
         } else if (var0 == 4010) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var3 & 1 << var4) != 0 ? 1 : 0;
            return 1;
         } else if (var0 == 4011) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 % var4;
            return 1;
         } else if (var0 == 4012) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            if (var3 == 0) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
            } else {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, (double)var4);
            }

            return 1;
         } else if (var0 == 4013) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            if (var3 == 0) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               return 1;
            } else {
               switch(var4) {
               case 0:
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Integer.MAX_VALUE;
                  break;
               case 1:
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
                  break;
               case 2:
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.sqrt((double)var3);
                  break;
               case 3:
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.cbrt((double)var3);
                  break;
               case 4:
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.sqrt(Math.sqrt((double)var3));
                  break;
               default:
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)Math.pow((double)var3, 1.0D / (double)var4);
               }

               return 1;
            }
         } else if (var0 == 4014) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & var4;
            return 1;
         } else if (var0 == 4015) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 | var4;
            return 1;
         } else if (var0 == 4016) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 < var4 ? var3 : var4;
            return 1;
         } else if (var0 == 4017) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 > var4 ? var3 : var4;
            return 1;
         } else if (var0 == 4018) {
            Interpreter.Interpreter_intStackSize -= 3;
            long var9 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            long var11 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            long var13 = (long)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (int)(var9 * var13 / var11);
            return 1;
         } else if (var0 == 4025) {
            var3 = class287.method1548(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
            return 1;
         } else if (var0 == 4026) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 ^ 1 << var4;
            return 1;
         } else if (var0 == 4027) {
            Interpreter.Interpreter_intStackSize -= 3;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class331.method1803(var3, var4, var5);
            return 1;
         } else if (var0 == 4028) {
            Interpreter.Interpreter_intStackSize -= 3;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = UserComparator8.method653(var3, var4, var5);
            return 1;
         } else if (var0 == 4029) {
            Interpreter.Interpreter_intStackSize -= 3;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            var6 = 31 - var5;
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 << var6 >>> var4 + var6;
            return 1;
         } else if (var0 == 4030) {
            Interpreter.Interpreter_intStackSize -= 4;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
            var3 = UserComparator8.method653(var3, var5, var6);
            var7 = class206.method1081(var6 - var5 + 1);
            if (var4 > var7) {
               var4 = var7;
            }

            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 | var4 << var5;
            return 1;
         } else if (var0 == 4032) {
            Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = SequenceDefinition.method1064(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]);
            return 1;
         } else if (var0 == 4033) {
            Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = NPC.method582(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]);
            return 1;
         } else if (var0 == 4034) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            var5 = WorldMapRegion.method1381(var3, var4);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5;
            return 1;
         } else if (var0 == 4035) {
            Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1] = Math.abs(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize - 1]);
            return 1;
         } else if (var0 == 4036) {
            String var15 = Interpreter.Interpreter_stringStack[--HealthBar.Interpreter_stringStackSize];
            var4 = -1;
            if (class162.isNumber(var15)) {
               var4 = GrandExchangeEvent.method1867(var15);
            }

            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var4;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("bx")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZI)I",
      garbageValue = "124991534"
   )
   static int method324(int var0, Script var1, boolean var2) {
      return 2;
   }

   @ObfuscatedName("kk")
   @ObfuscatedSignature(
      descriptor = "(II)V",
      garbageValue = "1564152216"
   )
   static final void method323(int var0) {
      if (var0 >= 0) {
         int var1 = Client.menuArguments1[var0];
         int var2 = Client.menuArguments2[var0];
         int var3 = Client.menuOpcodes[var0];
         int var4 = Client.menuIdentifiers[var0];
         int var5 = Client.menuItemIds[var0];
         String var6 = Client.menuActions[var0];
         String var7 = Client.menuTargets[var0];
         class287.menuAction(var1, var2, var3, var4, var5, var6, var7, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
      }
   }
}
