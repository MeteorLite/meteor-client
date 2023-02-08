import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
    @ObfuscatedName("n")
    static int gameCyclesToDo;
    @ObfuscatedName("f")
    int group;
    @ObfuscatedName("w")
    int type;
   @ObfuscatedName("v")
   boolean field854 = false;

    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "(B)Lji;",
            garbageValue = "73"
    )
    static PacketBufferNode createPacketBufferNode() {
      return PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0 ? new PacketBufferNode() : PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
   }
}
