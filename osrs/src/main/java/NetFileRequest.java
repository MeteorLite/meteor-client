import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ns")
@Implements("NetFileRequest")
public class NetFileRequest extends DualNode {
   @ObfuscatedName("cf")
   @Export("otp")
   static String otp;
   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "Lmx;"
   )
   @Export("archive")
   public Archive archive;
   @ObfuscatedName("al")
   @Export("crc")
   public int crc;
   @ObfuscatedName("ac")
   @Export("padding")
   public byte padding;

   @ObfuscatedName("ag")
   @ObfuscatedSignature(
      descriptor = "(ILcv;ZB)I",
      garbageValue = "81"
   )
   static int method1824(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 != 1927 && var0 != 2927) {
         int var4;
         if (var0 == 1928) {
            var3 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
            var4 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
            if (var4 >= 1 && var4 <= 10) {
               class99 var5 = new class99(var4, var3.id, var3.childIndex, var3.itemId);
               Interpreter.field693.add(var5);
               return 1;
            } else {
               throw new RuntimeException();
            }
         } else if (var0 == 2928) {
            Interpreter.Interpreter_intStackSize -= 3;
            int var7 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
            var4 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
            int var8 = Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
            if (var8 >= 1 && var8 <= 10) {
               class99 var6 = new class99(var8, var7, var4, WorldMapSection1.getWidget(var7).itemId);
               Interpreter.field693.add(var6);
               return 1;
            } else {
               throw new RuntimeException();
            }
         } else {
            return 2;
         }
      } else if (Interpreter.field694 >= 10) {
         throw new RuntimeException();
      } else {
         if (var0 >= 2000) {
            var3 = WorldMapSection1.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         } else {
            var3 = var2 ? GameObject.scriptDotWidget : SoundSystem.scriptActiveWidget;
         }

         if (var3.onResize == null) {
            return 0;
         } else {
            ScriptEvent var9 = new ScriptEvent();
            var9.widget = var3;
            var9.args = var3.onResize;
            var9.field853 = Interpreter.field694 + 1;
            Client.scriptEvents.addFirst(var9);
            return 1;
         }
      }
   }
}
