import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eq")
public class class137 extends class136 {
   @ObfuscatedName("fl")
   static int js5Port;
   @ObfuscatedName("qa")
   @ObfuscatedSignature(
      descriptor = "Lqk;"
   )
   static class451 HitSplatDefinition_cachedSprites;
   @ObfuscatedName("h")
   int field1293;
   @ObfuscatedName("e")
   boolean field1291;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Lem;"
   )
   final class139 this$0;

   @ObfuscatedSignature(
      descriptor = "(Lem;)V"
   )
   class137(class139 var1) {
      this.this$0 = var1;
      this.field1293 = -1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "1101327225"
   )
   void vmethod3254(Buffer var1) {
      this.field1293 = var1.readUnsignedShort();
      this.field1291 = var1.readUnsignedByte() == 1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lep;I)V",
      garbageValue = "839088249"
   )
   void vmethod3248(ClanSettings var1) {
      var1.method794(this.field1293, this.field1291);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "(IB)I",
      garbageValue = "124"
   )
   static int Messages_getHistorySize(int var0) {
      ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
      return var1 == null ? 0 : var1.size();
   }
}
