import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("di")
final class class103 implements class304 {
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lmy;"
   )
   @Export("val$cc")
   @ObfuscatedName("val$cc")
   final Widget val$cc;

   @ObfuscatedSignature(
      descriptor = "(Lmy;)V"
   )
   class103(Widget var1) {
      this.val$cc = var1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "177803302"
   )
   @Export("vmethod5708")
   public void vmethod5708() {
      if (this.val$cc != null && this.val$cc.method1768().field2785 != null) {
         ScriptEvent var1 = new ScriptEvent();
         var1.method467(this.val$cc);
         var1.setArgs(this.val$cc.method1768().field2785);
         class144.getScriptEvents().addFirst(var1);
      }

   }

   @ObfuscatedName("ar")
   @ObfuscatedSignature(
      descriptor = "(IIIZIB)J",
      garbageValue = "107"
   )
   @Export("calculateTag")
   public static long calculateTag(int var0, int var1, int var2, boolean var3, int var4) {
      long var5 = (long)((var0 & 127) << 0 | (var1 & 127) << 7 | (var2 & 3) << 14) | ((long)var4 & 4294967295L) << 17;
      if (var3) {
         var5 |= 65536L;
      }

      return var5;
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "26"
   )
   static int method601(int var0, Script var1, boolean var2) {
      if (var0 == 3300) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.cycle;
         return 1;
      } else {
         int var3;
         int var4;
         if (var0 == 3301) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SecureRandomCallable.method454(var3, var4);
            return 1;
         } else if (var0 == 3302) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class130.ItemContainer_getCount(var3, var4);
            return 1;
         } else if (var0 == 3303) {
            Interpreter.Interpreter_intStackSize -= 2;
            var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapData_0.method1311(var3, var4);
            return 1;
         } else if (var0 == 3304) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = InterfaceParent.getInvDefinition(var3).size;
            return 1;
         } else if (var0 == 3305) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.currentLevels[var3];
            return 1;
         } else if (var0 == 3306) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.levels[var3];
            return 1;
         } else if (var0 == 3307) {
            var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.experience[var3];
            return 1;
         } else {
            int var5;
            if (var0 == 3308) {
               var3 = TaskHandler.Client_plane;
               var4 = (BuddyRankComparator.localPlayer.x >> 7) + GameEngine.baseX;
               var5 = (BuddyRankComparator.localPlayer.y >> 7) + class178.baseY;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = (var4 << 14) + var5 + (var3 << 28);
               return 1;
            } else if (var0 == 3309) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 >> 14 & 16383;
               return 1;
            } else if (var0 == 3310) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 >> 28;
               return 1;
            } else if (var0 == 3311) {
               var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3 & 16383;
               return 1;
            } else if (var0 == 3312) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.isMembersWorld ? 1 : 0;
               return 1;
            } else if (var0 == 3313) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + '耀';
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SecureRandomCallable.method454(var3, var4);
               return 1;
            } else if (var0 == 3314) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + '耀';
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class130.ItemContainer_getCount(var3, var4);
               return 1;
            } else if (var0 == 3315) {
               Interpreter.Interpreter_intStackSize -= 2;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize] + '耀';
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = WorldMapData_0.method1311(var3, var4);
               return 1;
            } else if (var0 == 3316) {
               if (Client.staffModLevel >= 2) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.staffModLevel;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3317) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.rebootTimer;
               return 1;
            } else if (var0 == 3318) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.worldId;
               return 1;
            } else if (var0 == 3321) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.runEnergy / 100;
               return 1;
            } else if (var0 == 3322) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.weight;
               return 1;
            } else if (var0 == 3323) {
               if (Client.playerMod) {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
               } else {
                  Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
               }

               return 1;
            } else if (var0 == 3324) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.worldProperties;
               return 1;
            } else if (var0 == 3325) {
               Interpreter.Interpreter_intStackSize -= 4;
               var3 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
               var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
               var5 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
               int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
               var3 += var4 << 14;
               var3 += var5 << 28;
               var3 += var6;
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3;
               return 1;
            } else if (var0 == 3326) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.lastMouseRecordX;
               return 1;
            } else if (var0 == 3327) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.lastMouseRecordY;
               return 1;
            } else if (var0 == 3331) {
               Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.runEnergy;
               return 1;
            } else {
               return 2;
            }
         }
      }
   }

   @ObfuscatedName("ma")
   @ObfuscatedSignature(
      descriptor = "(Lmy;I)V",
      garbageValue = "1656599991"
   )
   static final void method602(Widget var0) {
      int var1 = var0.contentType;
      if (var1 == 324) {
         if (Client.field628 == -1) {
            Client.field628 = var0.spriteId2;
            Client.field590 = var0.spriteId;
         }

         if (Client.playerAppearance.field2790 == 1) {
            var0.spriteId2 = Client.field628;
         } else {
            var0.spriteId2 = Client.field590;
         }

      } else if (var1 == 325) {
         if (Client.field628 == -1) {
            Client.field628 = var0.spriteId2;
            Client.field590 = var0.spriteId;
         }

         if (Client.playerAppearance.field2790 == 1) {
            var0.spriteId2 = Client.field590;
         } else {
            var0.spriteId2 = Client.field628;
         }

      } else if (var1 == 327) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 0;
      } else if (var1 == 328) {
         var0.modelAngleX = 150;
         var0.modelAngleY = (int)(Math.sin((double)Client.cycle / 40.0D) * 256.0D) & 2047;
         var0.modelType = 5;
         var0.modelId = 1;
      }
   }
}
