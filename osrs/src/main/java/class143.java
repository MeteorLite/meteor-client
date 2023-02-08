import java.security.SecureRandom;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eh")
public class class143 extends class139 {
    @ObfuscatedName("d")
    static int loginBoxCenter;
   @ObfuscatedName("f")
   int field1310;
   @ObfuscatedName("w")
   byte field1312;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class143(class142 var1) {
      this.this$0 = var1;
      this.field1310 = -1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1310 = var1.readUnsignedShort();
      this.field1312 = var1.readByte();
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method804(this.field1310, this.field1312);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      descriptor = "(I)Ljava/security/SecureRandom;",
      garbageValue = "-1336695793"
   )
   static SecureRandom method764() {
      SecureRandom var0 = new SecureRandom();
      var0.nextInt();
      return var0;
   }
}
