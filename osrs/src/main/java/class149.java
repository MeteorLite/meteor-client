import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
public class class149 extends class139 {
   @ObfuscatedName("ha")
   static long field1336;
    @ObfuscatedName("og")
    static int selectedSpellFlags;
   @ObfuscatedName("f")
   int field1335;
   @ObfuscatedName("w")
   String field1337;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class149(class142 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1335 = var1.readInt();
      this.field1337 = var1.readStringCp1252NullTerminated();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method801(this.field1335, this.field1337);
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(II)Ljava/lang/String;",
            garbageValue = "1768978340"
    )
    static String colorStartTag(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
