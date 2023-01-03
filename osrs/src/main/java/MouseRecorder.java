import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cs")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      descriptor = "Lpz;"
   )
   @Export("WorldMapElement_fonts")
   static Fonts WorldMapElement_fonts;
   @ObfuscatedName("h")
   @Export("isRunning")
   boolean isRunning = true;
   @ObfuscatedName("e")
   @Export("lock")
   Object lock = new Object();
   @ObfuscatedName("v")
   @Export("index")
   int index = 0;
   @ObfuscatedName("x")
   @Export("xs")
   int[] xs = new int[500];
   @ObfuscatedName("m")
   @Export("ys")
   int[] ys = new int[500];
   @ObfuscatedName("q")
   @Export("millis")
   long[] millis = new long[500];

   @Export("run")
   @ObfuscatedName("run")
   public void run() {
      for(; this.isRunning; class12.method44(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if (this.index < 500) {
               this.xs[this.index] = MouseHandler.MouseHandler_x;
               this.ys[this.index] = MouseHandler.MouseHandler_y;
               this.millis[this.index] = MouseHandler.MouseHandler_millis;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(IB)Ljava/lang/String;",
      garbageValue = "3"
   )
   @Export("colorStartTag")
   static String colorStartTag(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      descriptor = "(ILbm;ZI)I",
      garbageValue = "-732526221"
   )
   static int method476(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 == 2700) {
         var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if (var0 == 2701) {
         var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
         if (var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if (var0 == 2702) {
         int var5 = Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize];
         InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
         if (var4 != null) {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 1;
         } else {
            Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if (var0 == 2706) {
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = Client.rootInterface;
         return 1;
      } else if (var0 == 2707) {
         var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
         Interpreter.Interpreter_intStack[++class87.Interpreter_intStackSize - 1] = var3.method1727() ? 1 : 0;
         return 1;
      } else if (var0 == 2708) {
         var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
         return class300.method1619(var3);
      } else if (var0 == 2709) {
         var3 = ObjTypeCustomisation.getWidget(Interpreter.Interpreter_intStack[--class87.Interpreter_intStackSize]);
         return LoginScreenAnimation.method527(var3);
      } else {
         return 2;
      }
   }

   @ObfuscatedName("lv")
   @ObfuscatedSignature(
      descriptor = "(IB)V",
      garbageValue = "-91"
   )
   @Export("changeGameOptions")
   static final void changeGameOptions(int var0) {
      class136.method738();
      HealthBar.method571();
      int var1 = class109.VarpDefinition_get(var0).type;
      if (var1 != 0) {
         int var2 = Varps.Varps_main[var0];
         if (var1 == 1) {
            if (var2 == 1) {
               FileSystem.method879(0.9D);
            }

            if (var2 == 2) {
               FileSystem.method879(0.8D);
            }

            if (var2 == 3) {
               FileSystem.method879(0.7D);
            }

            if (var2 == 4) {
               FileSystem.method879(0.6D);
            }
         }

         if (var1 == 3) {
            if (var2 == 0) {
               class299.method1613(255);
            }

            if (var2 == 1) {
               class299.method1613(192);
            }

            if (var2 == 2) {
               class299.method1613(128);
            }

            if (var2 == 3) {
               class299.method1613(64);
            }

            if (var2 == 4) {
               class299.method1613(0);
            }
         }

         if (var1 == 4) {
            if (var2 == 0) {
               class7.method15(127);
            }

            if (var2 == 1) {
               class7.method15(96);
            }

            if (var2 == 2) {
               class7.method15(64);
            }

            if (var2 == 3) {
               class7.method15(32);
            }

            if (var2 == 4) {
               class7.method15(0);
            }
         }

         if (var1 == 5) {
            Client.leftClickOpensMenu = var2 == 1;
         }

         if (var1 == 6) {
            Client.chatEffects = var2;
         }

         if (var1 == 9) {
            Client.field530 = var2;
         }

         if (var1 == 10) {
            if (var2 == 0) {
               class18.method64(127);
            }

            if (var2 == 1) {
               class18.method64(96);
            }

            if (var2 == 2) {
               class18.method64(64);
            }

            if (var2 == 3) {
               class18.method64(32);
            }

            if (var2 == 4) {
               class18.method64(0);
            }
         }

         if (var1 == 17) {
            Client.followerIndex = var2 & '\uffff';
         }

         AttackOption[] var3;
         if (var1 == 18) {
            var3 = new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden, AttackOption.field1075, AttackOption.field1074};
            Client.playerAttackOption = (AttackOption)World.findEnumerated(var3, var2);
            if (Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if (var1 == 19) {
            if (var2 == -1) {
               Client.combatTargetPlayerIndex = -1;
            } else {
               Client.combatTargetPlayerIndex = var2 & 2047;
            }
         }

         if (var1 == 22) {
            var3 = new AttackOption[]{AttackOption.AttackOption_dependsOnCombatLevels, AttackOption.AttackOption_alwaysRightClick, AttackOption.AttackOption_hidden, AttackOption.field1075, AttackOption.field1074};
            Client.npcAttackOption = (AttackOption)World.findEnumerated(var3, var2);
            if (Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }
}
