import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ks")
public class class282 {
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(IIIB)I",
      garbageValue = "1"
   )
   static int method1589(int var0, int var1, int var2) {
      return var0 << 28 | var1 << 14 | var2;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(ILnm;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-541968853"
   )
   public static void method1592(int var0, AbstractArchive var1, String var2, String var3, int var4, boolean var5) {
      if (var1.isValidFileName(var2, var3)) {
         int var6 = var1.getGroupId(var2);
         int var7 = var1.getFileId(var6, var3);
         Actor.method538(var0, var1, var6, var7, var4, var5);
      }

   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZI)I",
      garbageValue = "784584297"
   )
   static int method1590(int var0, Script var1, boolean var2) {
      if (var0 == 6754) {
         int var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         NPCComposition var4 = AbstractArchive.getNpcDefinition(var3);
         Interpreter.Interpreter_stringStack[++SecureRandomCallable.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
         return 1;
      } else {
         NPCComposition var5;
         if (var0 == 6764) {
            Interpreter.Interpreter_intStackSize -= 2;
            var5 = AbstractArchive.getNpcDefinition(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
            int var6 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5.method1030(var6);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5.method1032(var6);
            return 1;
         } else if (var0 == 6765) {
            var5 = AbstractArchive.getNpcDefinition(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var5 != null ? var5.combatLevel * 2062903815 * -959716425 : 0;
            return 1;
         } else {
            return 2;
         }
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      descriptor = "(Lmq;II)V",
      garbageValue = "-872142615"
   )
   public static void method1591(Widget var0, int var1) {
      ItemComposition var2 = HealthBarUpdate.ItemDefinition_get(var1);
      var0.field2894.equipment[var2.maleModel] = var1 + 512;
      if (var2.maleModel1 != -1) {
         var0.field2894.equipment[var2.maleModel1] = 0;
      }

      if (var2.maleModel2 != -1) {
         var0.field2894.equipment[var2.maleModel2] = 0;
      }

      var0.field2894.method1702();
   }
}
