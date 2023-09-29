import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("ql")
public class class423 extends SongTask {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	AbstractArchive field3758;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	AbstractArchive field3759;
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lom;"
	)
	AbstractArchive field3757;

	@ObfuscatedSignature(
		descriptor = "(Lqm;Lom;Lom;Lom;)V"
	)
	public class423(SongTask var1, AbstractArchive var2, AbstractArchive var3, AbstractArchive var4) {
		super(var1);
		this.field3758 = var2;
		this.field3759 = var3;
		this.field3757 = var4;
		super.field3753 = "LoadSongTask";
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-90"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		int var1 = 0;
		Iterator var2 = class319.musicSongs.iterator();

		while (true) {
			while (var2.hasNext()) {
				MusicSong var3 = (MusicSong)var2.next();
				if (var3 != null && var3.midiPcmStream.field2833 > 1 && var3.midiPcmStream.method1670()) {
					this.method2170("Attempted to load patches of already loading midiplayer!");
					return true;
				}

				if (var3 != null && !var3.field2887) {
					try {
						if (var3.musicTrackArchive != null && var3.musicTrackGroupId != -1 && var3.musicTrackFileId != -1) {
							if (var3.field2892 == null) {
								var3.field2892 = MusicTrack.readTrack(var3.musicTrackArchive, var3.musicTrackGroupId, var3.musicTrackFileId);
								if (var3.field2892 == null) {
									continue;
								}
							}

							if (var3.field2883 == null) {
								var3.field2883 = new SoundCache(this.field3757, this.field3759);
							}

							if (var3.midiPcmStream.method1663(var3.field2892, this.field3758, var3.field2883)) {
								++var1;
								var3.field2887 = true;
								var3.midiPcmStream.method1664();
							}
						} else {
							++var1;
						}
					} catch (Exception var5) {
						class190.RunException_sendStackTrace((String)null, var5);
						this.method2170(var5.getMessage());
						return true;
					}
				} else {
					++var1;
				}
			}

			if (var1 == class319.musicSongs.size()) {
				return true;
			}

			return false;
		}
	}
}