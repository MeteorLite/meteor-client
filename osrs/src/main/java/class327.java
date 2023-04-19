import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mg")
public class class327 {
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "(Lnm;B)V",
      garbageValue = "6"
   )
   public static void method1842(AbstractArchive var0) {
      DbRowType.field4040 = var0;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "46"
   )
   static int method1843(int var0, Script var1, boolean var2) {
      if (var0 == 6200) {
         Interpreter.Interpreter_intStackSize -= 2;
         Client.field625 = (short)VertexNormal.method1346(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize]);
         if (Client.field625 <= 0) {
            Client.field625 = 256;
         }

         Client.field626 = (short)VertexNormal.method1346(Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1]);
         if (Client.field626 <= 0) {
            Client.field626 = 256;
         }

         return 1;
      } else if (var0 == 6201) {
         Interpreter.Interpreter_intStackSize -= 2;
         Client.zoomHeight = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         if (Client.zoomHeight <= 0) {
            Client.zoomHeight = 256;
         }

         Client.zoomWidth = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         if (Client.zoomWidth <= 0) {
            Client.zoomWidth = 320;
         }

         return 1;
      } else if (var0 == 6202) {
         Interpreter.Interpreter_intStackSize -= 4;
         Client.field440 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize];
         if (Client.field440 <= 0) {
            Client.field440 = 1;
         }

         Client.field630 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 1];
         if (Client.field630 <= 0) {
            Client.field630 = 32767;
         } else if (Client.field630 < Client.field440) {
            Client.field630 = Client.field440;
         }

         Client.field488 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 2];
         if (Client.field488 <= 0) {
            Client.field488 = 1;
         }

         Client.field562 = (short)Interpreter.Interpreter_intStack[Interpreter.Interpreter_intStackSize + 3];
         if (Client.field562 <= 0) {
            Client.field562 = 32767;
         } else if (Client.field562 < Client.field488) {
            Client.field562 = Client.field488;
         }

         return 1;
      } else if (var0 == 6203) {
         if (Client.viewportWidget != null) {
            class36.setViewportShape(0, 0, Client.viewportWidget.width, Client.viewportWidget.height, false);
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportWidth;
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.viewportHeight;
         } else {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = -1;
         }

         return 1;
      } else if (var0 == 6204) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomHeight;
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.zoomWidth;
         return 1;
      } else if (var0 == 6205) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SoundSystem.method246(Client.field625);
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = SoundSystem.method246(Client.field626);
         return 1;
      } else if (var0 == 6220) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         return 1;
      } else if (var0 == 6221) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         return 1;
      } else if (var0 == 6222) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = GameEngine.canvasWidth;
         return 1;
      } else if (var0 == 6223) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = class262.canvasHeight;
         return 1;
      } else {
         return 2;
      }
   }
}
