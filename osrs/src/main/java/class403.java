import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("pd")
public class class403 extends SongTask {
	@ObfuscatedName("ae")
	@Export("clearLoginScreen")
	static boolean clearLoginScreen;

	@ObfuscatedSignature(
		descriptor = "(Lpm;)V"
	)
	public class403(SongTask var1) {
		super(var1);
		super.field3722 = "StartSongTask";
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1604030758"
	)
	public boolean vmethod2142() {
		Iterator var1 = class305.musicSongs.iterator();

		while (var1.hasNext()) {
			MusicSong var2 = (MusicSong)var1.next();
			if (var2 != null && !var2.field2865 && var2.midiPcmStream != null) {
				try {
					var2.midiPcmStream.method1632();
					var2.midiPcmStream.setPcmStreamVolume(0);
					if (var2.field2872 != null) {
						var2.midiPcmStream.setMusicTrack(var2.field2872, var2.musicTrackBoolean);
					}

					var2.field2872 = null;
					var2.field2861 = null;
					var2.musicTrackArchive = null;
					var2.field2865 = true;
				} catch (Exception var4) {
					Messages.RunException_sendStackTrace((String)null, var4);
					this.method2138(var4.getMessage());
					return true;
				}
			}
		}

		super.field3721 = true;
		return true;
	}
}