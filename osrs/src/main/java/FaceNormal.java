import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("FaceNormal")
public class FaceNormal {
	@ObfuscatedName("at")
	@Export("x")
	int x;
	@ObfuscatedName("ah")
	@Export("y")
	int y;
	@ObfuscatedName("ar")
	@Export("z")
	int z;

	FaceNormal() {
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Lld;",
		garbageValue = "1253542503"
	)
	static PacketBufferNode method1516() {
		return PacketBufferNode.PacketBufferNode_packetBufferNodeCount == 0 ? new PacketBufferNode() : PacketBufferNode.PacketBufferNode_packetBufferNodes[--PacketBufferNode.PacketBufferNode_packetBufferNodeCount];
	}
}