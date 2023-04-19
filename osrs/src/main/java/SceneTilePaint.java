import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("SceneTilePaint")
public final class SceneTilePaint {
    @ObfuscatedName("af")
    int swColor;
    @ObfuscatedName("an")
    int seColor;
    @ObfuscatedName("aw")
    int neColor;
    @ObfuscatedName("ac")
    int nwColor;
    @ObfuscatedName("au")
    int texture;
    @ObfuscatedName("ab")
    boolean isFlat = true;
    @ObfuscatedName("aq")
    int rgb;

   SceneTilePaint(int var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      this.swColor = var1;
      this.seColor = var2;
      this.neColor = var3;
      this.nwColor = var4;
      this.texture = var5;
      this.rgb = var6;
      this.isFlat = var7;
   }

    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "(Lsg;B)Ljava/lang/String;",
            garbageValue = "98"
    )
    public static String readString(Buffer var0) {
      String var1;
      try {
         int var2 = var0.readUShortSmart();
         if (var2 > 32767) {
            var2 = 32767;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class319.huffman.decompress(var0.array, var0.offset, var3, 0, var2);
         String var4 = Buffer.decodeStringCp1252(var3, 0, var2);
         var1 = var4;
      } catch (Exception var6) {
         var1 = "Cabbage";
      }

      return var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZB)I",
      garbageValue = "115"
   )
   static int method1347(int var0, Script var1, boolean var2) {
      Widget var3;
      if (var0 == 2700) {
         var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemId;
         return 1;
      } else if (var0 == 2701) {
         var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         if (var3.itemId != -1) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.itemQuantity;
         } else {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if (var0 == 2702) {
         int var5 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize];
         InterfaceParent var4 = (InterfaceParent)Client.interfaceParents.get((long)var5);
         if (var4 != null) {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 1;
         } else {
            Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = 0;
         }

         return 1;
      } else if (var0 == 2706) {
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = Client.rootInterface;
         return 1;
      } else if (var0 == 2707) {
         var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         Interpreter.Interpreter_intStack[++Interpreter.Interpreter_intStackSize - 1] = var3.method1807() ? 1 : 0;
         return 1;
      } else if (var0 == 2708) {
         var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         return BufferedSource.method2214(var3);
      } else if (var0 == 2709) {
         var3 = class165.getWidget(Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize]);
         return class4.method11(var3);
      } else {
         return 2;
      }
   }

    @ObfuscatedName("lv")
    @ObfuscatedSignature(
            descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIIIZB)V",
            garbageValue = "18"
    )
    static final void insertMenuItem(String var0, String var1, int var2, int var3, int var4, int var5, int var6, boolean var7) {
      if (!Client.isMenuOpen) {
         if (Client.menuOptionsCount < 500) {
            Client.menuActions[Client.menuOptionsCount] = var0;
            Client.menuTargets[Client.menuOptionsCount] = var1;
            Client.menuOpcodes[Client.menuOptionsCount] = var2;
            Client.menuIdentifiers[Client.menuOptionsCount] = var3;
            Client.menuArguments1[Client.menuOptionsCount] = var4;
            Client.menuArguments2[Client.menuOptionsCount] = var5;
            Client.menuItemIds[Client.menuOptionsCount] = var6;
            Client.menuShiftClick[Client.menuOptionsCount] = var7;
            ++Client.menuOptionsCount;
         }

      }
   }
}
