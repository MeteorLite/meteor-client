import java.awt.Component;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ck")
@Implements("Players")
public class Players {
	@ObfuscatedName("f")
	static byte[] field1290;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "[Lga;"
	)
	static class193[] field1291;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "[Lqq;"
	)
	static Buffer[] field1292;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -1742411547
	)
	@Export("Players_count")
	static int Players_count;
	@ObfuscatedName("s")
	@Export("Players_indices")
	static int[] Players_indices;
	@ObfuscatedName("q")
	@ObfuscatedGetter(
		intValue = 842704609
	)
	@Export("Players_emptyIdxCount")
	static int Players_emptyIdxCount;
	@ObfuscatedName("m")
	@Export("Players_emptyIndices")
	static int[] Players_emptyIndices;
	@ObfuscatedName("x")
	@Export("Players_regions")
	static int[] Players_regions;
	@ObfuscatedName("j")
	@Export("Players_orientations")
	static int[] Players_orientations;
	@ObfuscatedName("v")
	@Export("Players_targetIndices")
	static int[] Players_targetIndices;
	@ObfuscatedName("h")
	@ObfuscatedGetter(
		intValue = 1336760617
	)
	@Export("Players_pendingUpdateCount")
	static int Players_pendingUpdateCount;
	@ObfuscatedName("t")
	@Export("Players_pendingUpdateIndices")
	static int[] Players_pendingUpdateIndices;
	@ObfuscatedName("u")
	@ObfuscatedSignature(
		descriptor = "Lqq;"
	)
	static Buffer field1302;
	@ObfuscatedName("bj")
	@ObfuscatedSignature(
		descriptor = "Lpn;"
	)
	@Export("loginType")
	static LoginType loginType;

	static {
		field1290 = new byte[2048];
		field1291 = new class193[2048];
		field1292 = new Buffer[2048];
		Players_count = 0;
		Players_indices = new int[2048];
		Players_emptyIdxCount = 0;
		Players_emptyIndices = new int[2048];
		Players_regions = new int[2048];
		Players_orientations = new int[2048];
		Players_targetIndices = new int[2048];
		Players_pendingUpdateCount = 0;
		Players_pendingUpdateIndices = new int[2048];
		field1302 = new Buffer(new byte[5000]);
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(Ljava/awt/Component;I)V",
		garbageValue = "1351614638"
	)
	static void method2569(Component var0) {
		var0.removeKeyListener(KeyHandler.KeyHandler_instance);
		var0.removeFocusListener(KeyHandler.KeyHandler_instance);
		KeyHandler.field131 = -1;
	}

	@ObfuscatedName("hg")
	@ObfuscatedSignature(
		descriptor = "(ZI)V",
		garbageValue = "1280446"
	)
	static final void method2581(boolean var0) {
		class14.playPcmPlayers();
		++Client.packetWriter.pendingWrites;
		if (Client.packetWriter.pendingWrites >= 50 || var0) {
			Client.packetWriter.pendingWrites = 0;
			if (!Client.hadNetworkError && Client.packetWriter.getSocket() != null) {
				PacketBufferNode var1 = class120.getPacketBufferNode(ClientPacket.field2986, Client.packetWriter.isaacCipher);
				Client.packetWriter.addNode(var1);

				try {
					Client.packetWriter.flush();
				} catch (IOException var3) {
					Client.hadNetworkError = true;
				}
			}

		}
	}
}
