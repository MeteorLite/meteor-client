import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
public class class158 extends class139 {
    @ObfuscatedName("p")
    public static String[] cacheParentPaths;
   @ObfuscatedName("f")
   int field1389;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class158(class142 var1) {
      this.this$0 = var1;
      this.field1389 = -1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1389 = var1.readUnsignedShort();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method805(this.field1389);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;II)Z",
      garbageValue = "-1623657899"
   )
   static boolean method839(String var0, int var1) {
      return class154.method823(var0, var1, "openjs");
   }
}
