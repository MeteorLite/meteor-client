import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ji")
@Implements("PacketBufferNode")
public class PacketBufferNode extends Node {
    @ObfuscatedName("z")
    @ObfuscatedSignature(
            descriptor = "[Lji;"
    )
    static PacketBufferNode[] PacketBufferNode_packetBufferNodes = new PacketBufferNode[300];
    @ObfuscatedName("j")
    static int PacketBufferNode_packetBufferNodeCount = 0;
    @ObfuscatedName("io")
    @ObfuscatedSignature(
            descriptor = "Lrs;"
    )
    static SpritePixels redHintArrowSprite;
    @ObfuscatedName("f")
    @ObfuscatedSignature(
            descriptor = "Ljv;"
    )
    ClientPacket clientPacket;
    @ObfuscatedName("w")
    int clientPacketLength;
    @ObfuscatedName("v")
    @ObfuscatedSignature(
            descriptor = "Lru;"
    )
    public PacketBuffer packetBuffer;
    @ObfuscatedName("s")
    public int index;

    @ObfuscatedName("s")
    @ObfuscatedSignature(
            descriptor = "(B)V",
            garbageValue = "2"
    )
    public void release() {
      if (PacketBufferNode_packetBufferNodeCount < PacketBufferNode_packetBufferNodes.length) {
         PacketBufferNode_packetBufferNodes[++PacketBufferNode_packetBufferNodeCount - 1] = this;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      descriptor = "(I)[Lck;",
      garbageValue = "-1678569517"
   )
   static class86[] method1537() {
      return new class86[]{class86.field886, class86.field882, class86.field884, class86.field888, class86.field885, class86.field883};
   }

   @ObfuscatedName("lz")
   @ObfuscatedSignature(
      descriptor = "(B)V",
      garbageValue = "1"
   )
   static final void method1538() {
      for(int var0 = 0; var0 < Players.Players_count; ++var0) {
         Player var1 = Client.players[Players.Players_indices[var0]];
         var1.clearIsInFriendsChat();
      }

   }
}
