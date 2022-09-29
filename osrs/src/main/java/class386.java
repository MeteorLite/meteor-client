import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nz")
public class class386 {
	@ObfuscatedName("ij")
	@ObfuscatedSignature(
		descriptor = "(ZLqf;I)V",
		garbageValue = "2053789888"
	)
	@Export("updateNpcs")
	static final void updateNpcs(boolean var0, PacketBuffer var1) {
		Client.field625 = 0;
		Client.field549 = 0;
		UserComparator4.method2731();
		class272.method5399(var0, var1);
		WorldMapLabel.method5120(var1);

		int var2;
		for (var2 = 0; var2 < Client.field625; ++var2) {
			int var3 = Client.field775[var2];
			if (Client.npcs[var3].npcCycle != Client.cycle) {
				Client.npcs[var3].definition = null;
				Client.npcs[var3] = null;
			}
		}

		if (var1.offset != Client.packetWriter.serverPacketLength) {
			throw new RuntimeException(var1.offset + "," + Client.packetWriter.serverPacketLength);
		} else {
			for (var2 = 0; var2 < Client.npcCount; ++var2) {
				if (Client.npcs[Client.npcIndices[var2]] == null) {
					throw new RuntimeException(var2 + "," + Client.npcCount);
				}
			}

		}
	}
}
