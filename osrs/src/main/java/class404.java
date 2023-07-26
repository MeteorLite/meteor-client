import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pi")
public class class404 extends SongTask {
	@ObfuscatedSignature(
		descriptor = "(Lpp;)V"
	)
	public class404(SongTask var1) {
		super(var1);
		super.field3712 = "StartSongTask";
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		Iterator var2 = class306.musicSongs.iterator();

		while (var2.hasNext()) {
			MusicSong var3 = (MusicSong)var2.next();
			if (var3 != null && !var3.field2852 && var3.midiPcmStream != null) {
				try {
					var3.midiPcmStream.method1591();
					var3.midiPcmStream.setPcmStreamVolume(0);
					if (var3.field2858 != null) {
						var3.midiPcmStream.setMusicTrack(var3.field2858, var3.musicTrackBoolean);
					}

					var3.field2858 = null;
					var3.field2848 = null;
					var3.musicTrackArchive = null;
					var3.field2852 = true;
				} catch (Exception var5) {
					var5.printStackTrace();
					this.method2102(var5.getMessage());
					return true;
				}
			}
		}

		super.field3711 = true;
		return true;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;B)V",
		garbageValue = "108"
	)
	public static void method2093(AbstractArchive var0) {
		DbTableType.field4098 = var0;
	}
}
