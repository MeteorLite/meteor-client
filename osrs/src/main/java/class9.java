import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("x")
public class class9 implements MouseWheel {
	@ObfuscatedName("ul")
	@ObfuscatedSignature(
		descriptor = "Los;"
	)
	@Export("platformInfo")
	static PlatformInfo platformInfo;
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lx;"
	)
	public static final class9 field34;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lx;"
	)
	public static final class9 field32;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lx;"
	)
	static final class9 field33;
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Lx;"
	)
	static final class9 field37;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Lx;"
	)
	static final class9 field35;
	@ObfuscatedName("ff")
	@ObfuscatedGetter(
		intValue = -516341067
	)
	static int field31;
	@ObfuscatedName("w")
	@ObfuscatedGetter(
		intValue = -355301615
	)
	int field38;
	@ObfuscatedName("s")
	String field40;
	@ObfuscatedName("q")
	boolean field36;
	@ObfuscatedName("m")
	boolean field39;

	static {
		field34 = new class9(0, "POST", true, true);
		field32 = new class9(1, "GET", true, false);
		field33 = new class9(2, "PUT", false, true);
		field37 = new class9(3, "PATCH", false, true);
		field35 = new class9(4, "DELETE", false, true);
	}

	class9(int var1, String var2, boolean var3, boolean var4) {
		this.field38 = var1;
		this.field40 = var2;
		this.field36 = var3;
		this.field39 = var4;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-2133594239"
	)
	boolean method87() {
		return this.field36;
	}

	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "1"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field38;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(I)Ljava/lang/String;",
		garbageValue = "-338873662"
	)
	public String method75() {
		return this.field40;
	}

	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1305116386"
	)
	boolean method76() {
		return this.field39;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "1"
	)
	static final int method83(int var0, int var1) {
		if (var0 == -1) {
			return 12345678;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}

	@ObfuscatedName("gx")
	@ObfuscatedSignature(
		descriptor = "(IS)V",
		garbageValue = "17950"
	)
	@Export("playSong")
	static void playSong(int var0) {
		if (var0 == -1 && !Client.playingJingle) {
			class17.method267();
		} else if (var0 != -1 && var0 != Client.currentTrackGroupId && Player.clientPreferences.method2402() != 0 && !Client.playingJingle) {
			Archive var1 = class14.archive6;
			int var2 = Player.clientPreferences.method2402();
			class274.musicPlayerStatus = 1;
			class274.musicTrackArchive = var1;
			class274.musicTrackGroupId = var0;
			StructComposition.musicTrackFileId = 0;
			class269.musicTrackVolume = var2;
			TriBool.musicTrackBoolean = false;
			VarcInt.pcmSampleLength = 2;
		}

		Client.currentTrackGroupId = var0;
	}

	@ObfuscatedName("ih")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-1657093407"
	)
	static final void method89(int var0, int var1, int var2, int var3) {
		for (int var4 = 0; var4 < Client.rootWidgetCount; ++var4) {
			if (Client.rootWidgetWidths[var4] + Client.rootWidgetXs[var4] > var0 && Client.rootWidgetXs[var4] < var0 + var2 && Client.rootWidgetYs[var4] + Client.rootWidgetHeights[var4] > var1 && Client.rootWidgetYs[var4] < var3 + var1) {
				Client.field714[var4] = true;
			}
		}

	}

	@ObfuscatedName("lt")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;B)V",
		garbageValue = "37"
	)
	@Export("clanKickUser")
	static final void clanKickUser(String var0) {
		if (class145.friendsChat != null) {
			PacketBufferNode var1 = class120.getPacketBufferNode(ClientPacket.field3002, Client.packetWriter.isaacCipher);
			var1.packetBuffer.writeByte(class357.stringCp1252NullTerminatedByteSize(var0));
			var1.packetBuffer.writeStringCp1252NullTerminated(var0);
			Client.packetWriter.addNode(var1);
		}
	}
}
