import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("WorldMapSectionType")
public enum WorldMapSectionType implements class383 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ljn;"
	)
	@Export("WORLDMAPSECTIONTYPE0")
	WORLDMAPSECTIONTYPE0(0, (byte)0),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ljn;"
	)
	@Export("WORLDMAPSECTIONTYPE1")
	WORLDMAPSECTIONTYPE1(1, (byte)1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Ljn;"
	)
	@Export("WORLDMAPSECTIONTYPE2")
	WORLDMAPSECTIONTYPE2(3, (byte)2),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Ljn;"
	)
	@Export("WORLDMAPSECTIONTYPE3")
	WORLDMAPSECTIONTYPE3(2, (byte)3);

	@ObfuscatedName("wp")
	@ObfuscatedSignature(
		descriptor = "Loz;"
	)
	static JagNetThread field2038;
	@ObfuscatedName("ab")
	@Export("type")
	final int type;
	@ObfuscatedName("au")
	@Export("id")
	final byte id;

	WorldMapSectionType(int var3, byte var4) {
		this.type = var3;
		this.id = var4;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "-11"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)[Ljn;",
		garbageValue = "-190919972"
	)
	static WorldMapSectionType[] method1309() {
		return new WorldMapSectionType[]{WORLDMAPSECTIONTYPE3, WORLDMAPSECTIONTYPE1, WORLDMAPSECTIONTYPE0, WORLDMAPSECTIONTYPE2};
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2050835652"
	)
	static void method1311() {
		for (ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var0.stream1 != null) {
				LoginScreenAnimation.pcmStreamMixer.removeSubStream(var0.stream1);
				var0.stream1 = null;
			}

			if (var0.stream2 != null) {
				LoginScreenAnimation.pcmStreamMixer.removeSubStream(var0.stream2);
				var0.stream2 = null;
			}
		}

		ObjectSound.objectSounds.clear();
	}

	@ObfuscatedName("lj")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
		garbageValue = "57610498"
	)
	@Export("insertMenuItemNoShift")
	public static final void insertMenuItemNoShift(String var0, String var1, int var2, int var3, int var4, int var5) {
		GrandExchangeOfferTotalQuantityComparator.insertMenuItem(var0, var1, var2, var3, var4, var5, -1, false);
	}

	@ObfuscatedName("nx")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1233384886"
	)
	@Export("Clan_leaveChat")
	static final void Clan_leaveChat() {
		PacketBufferNode var0 = class113.getPacketBufferNode(ClientPacket.f22, Client.packetWriter.isaacCipher);
		var0.packetBuffer.writeByte(0);
		Client.packetWriter.addNode(var0);
	}

	@ObfuscatedName("oz")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-113"
	)
	static void method1314() {
		if (MidiPcmStream.field2799 != null) {
			Client.field369 = Client.cycle;
			MidiPcmStream.field2799.method1986();

			for (int var0 = 0; var0 < Client.players.length; ++var0) {
				if (Client.players[var0] != null) {
					MidiPcmStream.field2799.method1985((Client.players[var0].x >> 7) + NewShit.baseX, (Client.players[var0].y >> 7) + class101.baseY);
				}
			}
		}

	}
}