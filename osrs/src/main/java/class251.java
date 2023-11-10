import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("jd")
public class class251 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Ljd;"
	)
	static final class251 field2079;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Ljd;"
	)
	static final class251 field2078;
	@ObfuscatedName("ar")
	final int field2080;

	static {
		field2079 = new class251(0);
		field2078 = new class251(1);
	}

	class251(int var1) {
		this.field2080 = var1;
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "([FIFI)F",
		garbageValue = "-1267695907"
	)
	static float method1335(float[] var0, int var1, float var2) {
		float var3 = var0[var1];

		for (int var4 = var1 - 1; var4 >= 0; --var4) {
			var3 = var0[var4] + var2 * var3;
		}

		return var3;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-1945515950"
	)
	public static void method1334(int var0) {
		if (!class316.musicSongs.isEmpty()) {
			Iterator var1 = class316.musicSongs.iterator();

			while (var1.hasNext()) {
				MusicSong var2 = (MusicSong)var1.next();
				if (var2 != null) {
					var2.musicTrackVolume = var0;
				}
			}

			MusicSong var3 = (MusicSong)class316.musicSongs.get(0);
			if (var3 != null && var3.midiPcmStream != null && var3.midiPcmStream.isReady() && !var3.field2884) {
				var3.midiPcmStream.setPcmStreamVolume(var0);
				var3.field2886 = (float)var0;
			}
		}

	}

	@ObfuscatedName("ne")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;ZB)Ljava/lang/String;",
		garbageValue = "24"
	)
	static String method1336(String var0, boolean var1) {
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
		if (MenuAction.param9 != null) {
			var3 = "/p=" + MenuAction.param9;
		}

		String var4 = "runescape.com";
		return var2 + var0 + "." + var4 + "/l=" + class85.clientLanguage + "/a=" + DevicePcmPlayerProvider.field66 + var3 + "/";
	}
}