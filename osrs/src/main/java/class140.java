import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ed")
public class class140 extends class139 {
    @ObfuscatedName("l")
    public static byte[][] SpriteBuffer_pixels;
   @ObfuscatedName("f")
   int field1302;
   @ObfuscatedName("w")
   boolean field1301;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lex;"
   )
   final class142 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lex;)V"
   )
   class140(class142 var1) {
      this.this$0 = var1;
      this.field1302 = -1;
   }

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(Lrd;S)V",
            garbageValue = "-5782"
    )
    void vmethod3254(Buffer var1) {
      this.field1302 = var1.readUnsignedShort();
      this.field1301 = var1.readUnsignedByte() == 1;
   }

    @ObfuscatedName("w")
    @ObfuscatedSignature(
            descriptor = "(Leb;B)V",
            garbageValue = "-26"
    )
    void vmethod3248(ClanSettings var1) {
      var1.method797(this.field1302, this.field1301);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "1251147466"
   )
   static void method754() {
      Messages.Messages_channels.clear();
      Messages.Messages_hashTable.clear();
      Messages.Messages_queue.clear();
      Messages.Messages_count = 0;
   }

   @ObfuscatedName("j")
   public static int method751(long var0) {
      return (int)(var0 >>> 7 & 127L);
   }
}
