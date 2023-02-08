import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public class class144 extends class139 {
    @ObfuscatedName("ep")
    @ObfuscatedSignature(
            descriptor = "Llm;"
    )
    static Archive archive4;
   @ObfuscatedName("f")
   int field1317;
   @ObfuscatedName("w")
   int field1313;
   @ObfuscatedName("v")
   int field1315;
   @ObfuscatedName("s")
   int field1316;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class144(class142 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1317 = var1.readInt();
      this.field1316 = var1.readInt();
      this.field1313 = var1.readUnsignedByte();
      this.field1315 = var1.readUnsignedByte();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method799(this.field1317, this.field1316, this.field1313, this.field1315);
   }

    @ObfuscatedName("ky")
    @ObfuscatedSignature(
            descriptor = "(IIIIIIII)V",
            garbageValue = "-1463294808"
    )
    static final void updateRootInterface(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (class153.loadInterface(var0)) {
         class85.updateInterface(WorldMapLabel.Widget_interfaceComponents[var0], -1, var1, var2, var3, var4, var5, var6);
      }
   }
}
