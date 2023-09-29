import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Arrays;

@ObfuscatedName("oq")
@Implements("Strings")
public class Strings {
	@ObfuscatedName("fz")
	public static String field3355;
	@ObfuscatedName("kv")
	public static String field3466;
	@ObfuscatedName("kx")
	public static String field3468;
	@ObfuscatedName("kt")
	public static String field3464;

	static {
		field3355 = "Please visit the support page for assistance.";
		field3466 = "";
		field3468 = "Page has opened in the browser.";
		field3464 = "";
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "5563087"
	)
	public static boolean method1907() {
		if (!class319.field2798.isEmpty()) {
			return true;
		} else {
			return !class319.musicSongs.isEmpty() && class319.musicSongs.get(0) != null && ((MusicSong)class319.musicSongs.get(0)).midiPcmStream != null ? ((MusicSong)class319.musicSongs.get(0)).midiPcmStream.isReady() : false;
		}
	}

	@ObfuscatedName("bf")
	@ObfuscatedSignature(
		descriptor = "(Lnm;Lni;ZB)V",
		garbageValue = "-63"
	)
	public static void method1908(Widget var0, PlayerComposition var1, boolean var2) {
		var0.modelType = 7;
		var0.field3127 = new PlayerComposition(var1);
		if (!var2) {
			var0.field3127.equipment = Arrays.copyOf(var0.field3127.field2944, var0.field3127.field2944.length);
			var0.field3127.method1760();
		}

	}
}