import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mi")
public class class319 {
   @ObfuscatedName("ea")
   @Export("mouseCam")
   static boolean mouseCam;

   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/CharSequence;IB)I",
      garbageValue = "-20"
   )
   public static int method1784(CharSequence var0, int var1) {
      return class146.method771(var0, var1, true);
   }

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "-127"
   )
   static int method1785(int var0, Script var1, boolean var2) {
      Widget var3 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
      if (var0 == 1500) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if (var0 == 1501) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if (var0 == 1502) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if (var0 == 1503) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if (var0 == 1504) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
         return 1;
      } else if (var0 == 1505) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
