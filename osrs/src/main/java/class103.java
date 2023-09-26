import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("da")
public class class103 {
	@ObfuscatedName("kk")
	@ObfuscatedSignature(
		descriptor = "[Lud;"
	)
	@Export("mapDotSprites")
	static SpritePixels[] mapDotSprites;

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)Llx;",
		garbageValue = "-1015037603"
	)
	public static PacketBufferNode method599() {
		PacketBufferNode var0 = class306.method1639();
		var0.clientPacket = null;
		var0.clientPacketLength = 0;
		var0.packetBuffer = new PacketBuffer(5000);
		return var0;
	}
}