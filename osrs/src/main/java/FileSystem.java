import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;

@ObfuscatedName("im")
@Implements("FileSystem")
public class FileSystem {
	@ObfuscatedName("at")
	@Export("FileSystem_hasPermissions")
	static boolean FileSystem_hasPermissions;
	@ObfuscatedName("ah")
	@Export("FileSystem_cacheDir")
	static File FileSystem_cacheDir;
	@ObfuscatedName("ar")
	@Export("FileSystem_cacheFiles")
	static Hashtable FileSystem_cacheFiles;

	static {
		FileSystem_hasPermissions = false;
		FileSystem_cacheFiles = new Hashtable(16);
	}

	@ObfuscatedName("is")
	@ObfuscatedSignature(
		descriptor = "(IIB)V",
		garbageValue = "52"
	)
	@Export("playJingle")
	static void playJingle(int var0, int var1) {
		if (WorldMapIcon_1.clientPreferences.getCurrentMusicVolume() != 0 && var0 != -1) {
			ArrayList var2 = new ArrayList();
			var2.add(new MusicSong(PcmPlayer.field181, var0, 0, WorldMapIcon_1.clientPreferences.getCurrentMusicVolume(), false));
			PendingSpawn.method505(var2, 0, 0, 0, 0, true);
			Client.playingJingle = true;
		}

	}

	@ObfuscatedName("jq")
	@ObfuscatedSignature(
		descriptor = "(I)Lon;",
		garbageValue = "-187710170"
	)
	@Export("getScriptEvents")
	public static NodeDeque getScriptEvents() {
		return Client.scriptEvents;
	}
}