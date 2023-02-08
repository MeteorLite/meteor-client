import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ny")
public class class380 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      descriptor = "(Ljava/lang/String;I)V",
      garbageValue = "-1330257380"
   )
   static final void method2019(String var0) {
      PacketBufferNode var1 = Renderable.getPacketBufferNode(ClientPacket.field2435, Client.packetWriter.isaacCipher);
      var1.packetBuffer.writeByte(class96.stringCp1252NullTerminatedByteSize(var0));
      var1.packetBuffer.writeStringCp1252NullTerminated(var0);
      Client.packetWriter.addNode(var1);
   }
}
