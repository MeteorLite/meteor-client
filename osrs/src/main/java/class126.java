import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ey")
public class class126 implements class356 {
    @ObfuscatedName("wt")
    @ObfuscatedSignature(
            descriptor = "Lrb;"
    )
    static WorldMap worldMap;
   @ObfuscatedName("af")
   @ObfuscatedSignature(
      descriptor = "Ley;"
   )
   static final class126 field1243 = new class126(0, 0, (String)null, 0);
   @ObfuscatedName("an")
   @ObfuscatedSignature(
      descriptor = "Ley;"
   )
   static final class126 field1240 = new class126(1, 1, (String)null, 9);
   @ObfuscatedName("aw")
   @ObfuscatedSignature(
      descriptor = "Ley;"
   )
   static final class126 field1241 = new class126(2, 2, (String)null, 3);
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      descriptor = "Ley;"
   )
   static final class126 field1246 = new class126(3, 3, (String)null, 6);
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Ley;"
   )
   static final class126 field1247 = new class126(4, 4, (String)null, 1);
   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "Ley;"
   )
   static final class126 field1244 = new class126(5, 5, (String)null, 3);
    @ObfuscatedName("fj")
    @ObfuscatedSignature(
            descriptor = "Lnd;"
    )
    static Archive archive12;
    @ObfuscatedName("fm")
    @ObfuscatedSignature(
            descriptor = "Lnd;"
    )
    static Archive archive15;
   @ObfuscatedName("aq")
   final int field1245;
   @ObfuscatedName("al")
   final int field1250;
   @ObfuscatedName("at")
   final int field1242;

   class126(int var1, int var2, String var3, int var4) {
      this.field1245 = var1;
      this.field1250 = var2;
      this.field1242 = var4;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(I)I",
            garbageValue = "741942848"
    )
    public int rsOrdinal() {
      return this.field1250;
   }

   @ObfuscatedName("ab")
   @ObfuscatedSignature(
      descriptor = "(I)I",
      garbageValue = "-406434338"
   )
   int method755() {
      return this.field1242;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      descriptor = "(ILch;ZS)I",
      garbageValue = "15950"
   )
   static int method754(int var0, Script var1, boolean var2) {
      if (var0 == 7463) {
         boolean var3 = Interpreter.Interpreter_intStack[--Interpreter.Interpreter_intStackSize] == 1;
         GrandExchangeOfferOwnWorldComparator.method365(var3);
         return 1;
      } else {
         return 2;
      }
   }
}
