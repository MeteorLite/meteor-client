import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ft")
public class class131 implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lft;"
	)
	static final class131 field1268;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lft;"
	)
	static final class131 field1264;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lft;"
	)
	static final class131 field1266;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lft;"
	)
	static final class131 field1267;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lft;"
	)
	static final class131 field1263;
	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "Lft;"
	)
	static final class131 field1265;
	@ObfuscatedName("az")
	final int field1271;
	@ObfuscatedName("ap")
	final int field1270;
	@ObfuscatedName("aa")
	final int field1269;

	static {
		field1268 = new class131(0, 0, (String)null, 0);
		field1264 = new class131(1, 1, (String)null, 9);
		field1266 = new class131(2, 2, (String)null, 3);
		field1267 = new class131(3, 3, (String)null, 6);
		field1263 = new class131(4, 4, (String)null, 1);
		field1265 = new class131(5, 5, (String)null, 3);
	}

	class131(int var1, int var2, String var3, int var4) {
		this.field1271 = var1;
		this.field1270 = var2;
		this.field1269 = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1270;
	}

	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "149385670"
	)
	int method727() {
		return this.field1269;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IIIIB)V",
		garbageValue = "50"
	)
	static void method729(int var0, int var1, int var2, int var3) {
		for (ObjectSound var4 = (ObjectSound)ObjectSound.objectSounds.last(); var4 != null; var4 = (ObjectSound)ObjectSound.objectSounds.previous()) {
			if (var4.soundEffectId != -1 || var4.soundEffectIds != null) {
				int var5 = 0;
				if (var1 > var4.maxX) {
					var5 += var1 - var4.maxX;
				} else if (var1 < var4.x) {
					var5 += var4.x - var1;
				}

				if (var2 > var4.maxY) {
					var5 += var2 - var4.maxY;
				} else if (var2 < var4.y) {
					var5 += var4.y - var2;
				}

				if (var5 - 64 <= var4.field702 && class449.clientPreferences.getAreaSoundEffectsVolume() != 0 && var0 == var4.plane) {
					var5 -= 64;
					if (var5 < 0) {
						var5 = 0;
					}

					int var6 = (var4.field702 - var5) * class449.clientPreferences.getAreaSoundEffectsVolume() / var4.field702;
					if (var4.stream1 == null) {
						if (var4.soundEffectId >= 0) {
							SoundEffect var7 = SoundEffect.readSoundEffect(class28.field81, var4.soundEffectId, 0);
							if (var7 != null) {
								RawSound var8 = var7.toRawSound().resample(class330.decimator);
								RawPcmStream var9 = RawPcmStream.createRawPcmStream(var8, 100, var6);
								var9.setNumLoops(-1);
								class162.pcmStreamMixer.addSubStream(var9);
								var4.stream1 = var9;
							}
						}
					} else {
						var4.stream1.method238(var6);
					}

					if (var4.stream2 == null) {
						if (var4.soundEffectIds != null && (var4.field698 -= var3) <= 0) {
							int var11 = (int)(Math.random() * (double)var4.soundEffectIds.length);
							SoundEffect var12 = SoundEffect.readSoundEffect(class28.field81, var4.soundEffectIds[var11], 0);
							if (var12 != null) {
								RawSound var13 = var12.toRawSound().resample(class330.decimator);
								RawPcmStream var10 = RawPcmStream.createRawPcmStream(var13, 100, var6);
								var10.setNumLoops(0);
								class162.pcmStreamMixer.addSubStream(var10);
								var4.stream2 = var10;
								var4.field698 = var4.field696 + (int)(Math.random() * (double)(var4.field694 - var4.field696));
							}
						}
					} else {
						var4.stream2.method238(var6);
						if (!var4.stream2.hasNext()) {
							var4.stream2 = null;
						}
					}
				} else {
					if (var4.stream1 != null) {
						class162.pcmStreamMixer.removeSubStream(var4.stream1);
						var4.stream1 = null;
					}

					if (var4.stream2 != null) {
						class162.pcmStreamMixer.removeSubStream(var4.stream2);
						var4.stream2 = null;
					}
				}
			}
		}

	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IZIZI)V",
		garbageValue = "-761761706"
	)
	@Export("sortWorldList")
	static void sortWorldList(int var0, boolean var1, int var2, boolean var3) {
		if (class176.World_worlds != null) {
			Occluder.doWorldSorting(0, class176.World_worlds.length - 1, var0, var1, var2, var3);
		}

	}

	@ObfuscatedName("nk")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "-87"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (ReflectionCheck.friendsChat != null) {
			PacketBufferNode var1 = ApproximateRouteStrategy.getPacketBufferNode(ClientPacket.CLAN_KICKUSER, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(AbstractSocket.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}