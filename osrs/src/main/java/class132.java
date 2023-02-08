import java.util.concurrent.Callable;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("er")
class class132 implements Callable {
    @ObfuscatedName("i")
    public static int[] SpriteBuffer_spriteHeights;
    @ObfuscatedName("o")
    public static int[] ByteArrayPool_altSizeArrayCounts;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lei;"
   )
   final class133 this$0;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lrd;"
   )
   final Buffer val$p;
   // $FF: synthetic field
   final int val$version;

   @ObfuscatedSignature(
      descriptor = "(Lei;Lrd;I)V"
   )
   class132(class133 var1, Buffer var2, int var3) {
      this.this$0 = var1;
      this.val$p = var2;
      this.val$version = var3;
   }

   public Object call() {
      this.this$0.method725(this.val$p, this.val$version);
      return null;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZI)I",
      garbageValue = "-1917361698"
   )
   static int method717(int var0, Script var1, boolean var2) {
      Widget var3 = class133.getWidget(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
      if (var0 == 2500) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.x;
         return 1;
      } else if (var0 == 2501) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.y;
         return 1;
      } else if (var0 == 2502) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.width;
         return 1;
      } else if (var0 == 2503) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.height;
         return 1;
      } else if (var0 == 2504) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.isHidden ? 1 : 0;
         return 1;
      } else if (var0 == 2505) {
         Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }
}
