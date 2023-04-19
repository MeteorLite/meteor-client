import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("go")
public class class157 extends class139 {
    @ObfuscatedName("aw")
    @ObfuscatedSignature(
            descriptor = "Lnm;"
    )
    static AbstractArchive ObjectDefinition_modelsArchive;
   @ObfuscatedName("af")
   int field1391;
   @ObfuscatedName("an")
   int field1393;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfa;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfa;)V"
   )
   class157(class142 var1) {
      this.this$0 = var1;
   }

    @ObfuscatedName("af")
    @ObfuscatedSignature(
            descriptor = "(Lsg;I)V",
            garbageValue = "168736686"
    )
    void vmethod3254(Buffer var1) {
      this.field1391 = var1.readInt();
      this.field1393 = var1.readInt();
   }

    @ObfuscatedName("an")
    @ObfuscatedSignature(
            descriptor = "(Lfj;I)V",
            garbageValue = "1712319228"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method861(this.field1391, this.field1393);
   }
}
