import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qt")
@Implements("FadeInTask")
public class FadeInTask extends SongTask {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	MusicSong field3753;
	@ObfuscatedName("ah")
	int field3752;

	@ObfuscatedSignature(
		descriptor = "(Lql;IZI)V"
	)
	public FadeInTask(SongTask var1, int var2, boolean var3, int var4) {
		super(var1);
		this.field3753 = null;
		this.field3752 = 0;
		super.field3756 = "FadeInTask";
		if (var2 >= 0) {
			if (var3 && var2 < class316.field2790.size()) {
				this.field3753 = (MusicSong)class316.field2790.get(var2);
			} else if (!var3 && var2 < class316.musicSongs.size()) {
				this.field3753 = (MusicSong)class316.musicSongs.get(var2);
			}

			this.field3752 = var4;
		}
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-799935345"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		if (this.field3753 != null && this.field3753.midiPcmStream != null) {
			this.field3753.field2884 = true;

			try {
				if (this.field3753.field2886 < (float)this.field3753.musicTrackVolume && this.field3753.midiPcmStream.isReady()) {
					float var1 = this.field3752 == 0 ? (float)this.field3752 : (float)this.field3753.musicTrackVolume / (float)this.field3752;
					MusicSong var10000 = this.field3753;
					var10000.field2886 += var1 == 0.0F ? (float)this.field3753.musicTrackVolume : var1;
					if (this.field3753.field2886 > (float)this.field3753.musicTrackVolume) {
						this.field3753.field2886 = (float)this.field3753.musicTrackVolume;
					}

					this.field3753.midiPcmStream.setPcmStreamVolume((int)this.field3753.field2886);
					return false;
				}
			} catch (Exception var3) {
				this.method2160(var3.getMessage());
				return true;
			}

			this.field3753.field2884 = false;
			return true;
		} else {
			return true;
		}
	}
}