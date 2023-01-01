import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
public class PacketBufferNode extends Node {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "[Ljx;"
   )
   static PacketBufferNode[] PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
   @ObfuscatedName("q")
   static int PacketBufferNode_packetBufferNodeCount = 0;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   static AbstractArchive Widget_fontsArchive;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ljp;"
   )
   public ClientPacket clientPacket;
   @ObfuscatedName("e")
   public int clientPacketLength;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lqx;"
   )
   public PacketBuffer packetBuffer;
   @ObfuscatedName("x")
   public int index;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-383779244"
   )
   public void release() {
      if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
         PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
      }
   }
}
