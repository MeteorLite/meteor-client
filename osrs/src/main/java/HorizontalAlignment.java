import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("he")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements class371 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lhe;"
	)
	field1574(0, 0),
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lhe;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(2, 1),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lhe;"
	)
	field1573(1, 2);

	@ObfuscatedName("at")
	@Export("value")
	public final int value;
	@ObfuscatedName("ac")
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(B)I",
		garbageValue = "41"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Llb;I)V",
		garbageValue = "819955380"
	)
	public static void method975(class311 var0) {
		class305.field2778.remove(var0);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;I)Ljava/lang/String;",
		garbageValue = "2133819886"
	)
	public static String method977(String var0) {
		return var0 != null && !var0.isEmpty() && var0.charAt(0) != '#' ? var0 : "";
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "36"
	)
	@Export("Messages_getHistorySize")
	static int Messages_getHistorySize(int var0) {
		ChatChannel var1 = (ChatChannel)Messages.Messages_channels.get(var0);
		return var1 == null ? 0 : var1.size();
	}

	@ObfuscatedName("oh")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZB)Ljava/lang/String;",
		garbageValue = "2"
	)
	static String method978(String var0, boolean var1) {
		String var2 = var1 ? "https://" : "http://";
		if (Client.gameBuild == 1) {
			var0 = var0 + "-wtrc";
		} else if (Client.gameBuild == 2) {
			var0 = var0 + "-wtqa";
		} else if (Client.gameBuild == 3) {
			var0 = var0 + "-wtwip";
		} else if (Client.gameBuild == 5) {
			var0 = var0 + "-wti";
		} else if (Client.gameBuild == 4) {
			var0 = "local";
		}

		String var3 = "";
		if (MusicPatchPcmStream.param9 != null) {
			var3 = "/p=" + MusicPatchPcmStream.param9;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + ClanChannelMember.clientLanguage + "/a=" + WorldMapSectionType.field2416 + var3 + "/";
	}
}