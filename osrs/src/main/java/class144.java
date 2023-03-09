import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class144 extends class140 {
   @ObfuscatedName("av")
   @Export("SpriteBuffer_spriteHeights")
   public static int[] SpriteBuffer_spriteHeights;
   @ObfuscatedName("ap")
   @Export("SpriteBuffer_pixels")
   public static byte[][] SpriteBuffer_pixels;
   @ObfuscatedName("aj")
   int field1308;
   @ObfuscatedName("al")
   byte field1309;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lfo;"
   )
   final class143 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lfo;)V"
   )
   class144(class143 var1) {
      this.this$0 = var1;
      this.field1308 = -1;
   }

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      descriptor = "(Lsy;I)V",
      garbageValue = "-1979280996"
   )
   @Export("vmethod3254")
   void vmethod3254(Buffer var1) {
      this.field1308 = var1.readUnsignedShort();
      this.field1309 = var1.readByte();
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      descriptor = "(Lfi;B)V",
      garbageValue = "29"
   )
   @Export("vmethod3248")
   void vmethod3248(ClanSettings var1) {
      var1.method795(this.field1308, this.field1309);
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      descriptor = "(B)Lnj;",
      garbageValue = "82"
   )
   @Export("getScriptEvents")
   public static NodeDeque getScriptEvents() {
      return Client.scriptEvents;
   }
}
