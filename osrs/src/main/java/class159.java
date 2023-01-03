import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public class class159 extends class152 {
   @ObfuscatedName("n")
   static int[][][] field1401;
   @ObfuscatedName("h")
   String field1399;
   @ObfuscatedName("e")
   byte field1398;
   @ObfuscatedName("v")
   byte field1400;
   // $FF: synthetic field
   @ObfuscatedSignature(
      descriptor = "Led;"
   )
   final class153 this$0;

   @ObfuscatedSignature(
      descriptor = "(Led;)V"
   )
   class159(class153 var1) {
      this.this$0 = var1;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "(Lqy;I)V",
      garbageValue = "468341515"
   )
   @Export("vmethod3238")
   void vmethod3238(Buffer var1) {
      this.field1399 = var1.readStringCp1252NullTerminatedOrNull();
      if (this.field1399 != null) {
         var1.readUnsignedByte();
         this.field1398 = var1.readByte();
         this.field1400 = var1.readByte();
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      descriptor = "(Lfn;I)V",
      garbageValue = "1227548281"
   )
   @Export("vmethod3239")
   void vmethod3239(ClanChannel var1) {
      var1.name = this.field1399;
      if (this.field1399 != null) {
         var1.field1390 = this.field1398;
         var1.field1392 = this.field1400;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(IIII)I",
      garbageValue = "1927602287"
   )
   public static int method839(int var0, int var1, int var2) {
      int var3 = Actor.method516(var2 - var1 + 1);
      var3 <<= var1;
      return var0 & ~var3;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      descriptor = "(I)Z",
      garbageValue = "1850938391"
   )
   public static boolean method838() {
      return class286.musicPlayerStatus != 0 ? true : class251.midiPcmStream.isReady();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;II)V",
      garbageValue = "-141846119"
   )
   static final void method837(String var0, int var1) {
      PacketBufferNode var2 = class136.getPacketBufferNode(ClientPacket.field2473, Client.packetWriter.isaacCipher);
      var2.packetBuffer.writeByte(class13.stringCp1252NullTerminatedByteSize(var0) + 1);
      var2.packetBuffer.method2368(var1);
      var2.packetBuffer.writeStringCp1252NullTerminated(var0);
      Client.packetWriter.addNode(var2);
   }
}
