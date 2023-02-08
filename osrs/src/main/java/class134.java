import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public enum class134 implements class349 {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1282(0, 0),
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1271(1, 1),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1272(2, 2),
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1273(3, 3),
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1274(4, 4),
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1281(5, 5),
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1276(6, 6),
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1275(7, 7),
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "Lel;"
   )
   field1278(8, 8);

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      descriptor = "Lle;"
   )
   static StudioGame field1270;
   @ObfuscatedName("bu")
   static int field1277;
   @ObfuscatedName("k")
   final int field1279;
   @ObfuscatedName("c")
   final int field1280;

   class134(int var3, int var4) {
      this.field1279 = var3;
      this.field1280 = var4;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)I",
            garbageValue = "3"
    )
    public int rsOrdinal() {
      return this.field1280;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
            garbageValue = "-116"
    )
    static void addChatMessage(int var0, String var1, String var2, String var3) {
      ChatChannel var4 = (ChatChannel)Messages.Messages_channels.get(var0);
      if (var4 == null) {
         var4 = new ChatChannel();
         Messages.Messages_channels.put(var0, var4);
      }

      Message var5 = var4.addMessage(var0, var1, var2, var3);
      Messages.Messages_hashTable.put(var5, (long)var5.count);
      Messages.Messages_queue.add(var5);
      Client.chatCycle = Client.cycleCntr;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "328947468"
   )
   public static void method730() {
      KitDefinition.KitDefinition_cached.clear();
   }

   @ObfuscatedName("ae")
   @ObfuscatedSignature(
      descriptor = "(ILba;ZB)I",
      garbageValue = "-33"
   )
   static int method732(int var0, Script var1, boolean var2) {
      if (var0 == 6754) {
         int var3 = Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize];
         NPCComposition var4 = class137.getNpcDefinition(var3);
         Interpreter.Interpreter_stringStack[++class20.Interpreter_stringStackSize - 1] = var4 != null ? var4.name : "";
         return 1;
      } else {
         NPCComposition var5;
         if (var0 == 6764) {
            class302.Interpreter_intStackSize -= 2;
            var5 = class137.getNpcDefinition(Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize]);
            int var6 = Interpreter.Interpreter_intStack[class302.Interpreter_intStackSize + 1];
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5.method969(var6);
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5.method966(var6);
            return 1;
         } else if (var0 == 6765) {
            var5 = class137.getNpcDefinition(Interpreter.Interpreter_intStack[--class302.Interpreter_intStackSize]);
            Interpreter.Interpreter_intStack[++class302.Interpreter_intStackSize - 1] = var5 != null ? var5.combatLevel * 1652634765 * 176795205 : 0;
            return 1;
         } else {
            return 2;
         }
      }
   }
}
