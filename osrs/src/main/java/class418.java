import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("qw")
public class class418 extends SongTask {
	@ObfuscatedSignature(
		descriptor = "(Lqm;)V"
	)
	public class418(SongTask var1) {
		super(var1);
		super.field3753 = "StartSongTask";
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-90"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		Iterator var1 = class319.musicSongs.iterator();

		while (var1.hasNext()) {
			MusicSong var2 = (MusicSong)var1.next();
			if (var2 != null && !var2.field2884 && var2.midiPcmStream != null) {
				try {
					var2.midiPcmStream.method1665();
					var2.midiPcmStream.setPcmStreamVolume(0);
					if (var2.field2892 != null) {
						var2.midiPcmStream.setMusicTrack(var2.field2892, var2.musicTrackBoolean);
					}

					var2.field2892 = null;
					var2.field2883 = null;
					var2.musicTrackArchive = null;
					var2.field2884 = true;
				} catch (Exception var4) {
					class190.RunException_sendStackTrace((String)null, var4);
					this.method2170(var4.getMessage());
					return true;
				}
			}
		}

		super.field3752 = true;
		return true;
	}
}