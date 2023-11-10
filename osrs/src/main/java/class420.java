import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("qo")
public class class420 extends SongTask {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	AbstractArchive field3762;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	AbstractArchive field3761;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lol;"
	)
	AbstractArchive field3760;

	@ObfuscatedSignature(
		descriptor = "(Lql;Lol;Lol;Lol;)V"
	)
	public class420(SongTask var1, AbstractArchive var2, AbstractArchive var3, AbstractArchive var4) {
		super(var1);
		this.field3762 = var2;
		this.field3761 = var3;
		this.field3760 = var4;
		super.field3756 = "LoadSongTask";
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-799935345"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		int var1 = 0;
		Iterator var2 = class316.musicSongs.iterator();

		while (true) {
			while (var2.hasNext()) {
				MusicSong var3 = (MusicSong)var2.next();
				if (var3 != null && var3.midiPcmStream.field2830 > 1 && var3.midiPcmStream.method1661()) {
					this.method2160("Attempted to load patches of already loading midiplayer!");
					return true;
				}

				if (var3 != null && !var3.field2882) {
					try {
						if (var3.musicTrackArchive != null && var3.musicTrackGroupId != -1 && var3.musicTrackFileId != -1) {
							if (var3.field2891 == null) {
								var3.field2891 = MusicTrack.readTrack(var3.musicTrackArchive, var3.musicTrackGroupId, var3.musicTrackFileId);
								if (var3.field2891 == null) {
									continue;
								}
							}

							if (var3.field2881 == null) {
								var3.field2881 = new SoundCache(this.field3760, this.field3761);
							}

							if (var3.midiPcmStream.method1654(var3.field2891, this.field3762, var3.field2881)) {
								++var1;
								var3.field2882 = true;
								var3.midiPcmStream.method1655();
							}
						} else {
							++var1;
						}
					} catch (Exception var5) {
						GrandExchangeOfferWorldComparator.RunException_sendStackTrace((String)null, var5);
						this.method2160(var5.getMessage());
						return true;
					}
				} else {
					++var1;
				}
			}

			if (var1 == class316.musicSongs.size()) {
				return true;
			}

			return false;
		}
	}
}