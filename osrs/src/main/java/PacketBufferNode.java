import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      descriptor = "[Ljx;"
   )
   @Export("PacketBufferNode_packetBufferNodes")
   static PacketBufferNode[] PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
   @ObfuscatedName("q")
   @Export("PacketBufferNode_packetBufferNodeCount")
   static int PacketBufferNode_packetBufferNodeCount = 0;
   @ObfuscatedName("au")
   @ObfuscatedSignature(
      descriptor = "Lly;"
   )
   @Export("Widget_fontsArchive")
   static AbstractArchive Widget_fontsArchive;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      descriptor = "Ljp;"
   )
   @Export("clientPacket")
   public ClientPacket clientPacket;
   @ObfuscatedName("e")
   @Export("clientPacketLength")
   public int clientPacketLength;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "Lqx;"
   )
   @Export("packetBuffer")
   public PacketBuffer packetBuffer;
   @ObfuscatedName("x")
   @Export("index")
   public int index;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)V",
      garbageValue = "-383779244"
   )
   @Export("release")
   public void release() {
      if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
         PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
      }
   }
}
