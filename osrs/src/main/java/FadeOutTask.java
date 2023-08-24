import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("px")
@Implements("FadeOutTask")
public class FadeOutTask extends SongTask {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lmu;"
	)
	MusicSong field3717;
	@ObfuscatedName("ae")
	int field3716;

	@ObfuscatedSignature(
		descriptor = "(Lpm;IZI)V"
	)
	public FadeOutTask(SongTask var1, int var2, boolean var3, int var4) {
		super(var1);
		this.field3717 = null;
		this.field3716 = 0;
		super.field3722 = "FadeOutTask";
		if (var2 >= 0) {
			if (var3 && var2 < class305.field2774.size()) {
				this.field3717 = (MusicSong)class305.field2774.get(var2);
			} else if (!var3 && var2 < class305.musicSongs.size()) {
				this.field3717 = (MusicSong)class305.musicSongs.get(var2);
			}

			this.field3716 = var4;
		}
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1604030758"
	)
	public boolean vmethod2142() {
		if (this.field3717 != null && this.field3717.midiPcmStream != null) {
			this.field3717.field2862 = true;

			try {
				if (this.field3717.field2867 > 0.0F && this.field3717.midiPcmStream.isReady()) {
					float var1 = this.field3716 == 0 ? (float)this.field3716 : (float)this.field3717.musicTrackVolume / (float)this.field3716;
					MusicSong var10000 = this.field3717;
					var10000.field2867 -= var1 == 0.0F ? (float)this.field3717.musicTrackVolume : var1;
					if (this.field3717.field2867 < 0.0F) {
						this.field3717.field2867 = 0.0F;
					}

					this.field3717.midiPcmStream.setPcmStreamVolume((int)this.field3717.field2867);
					return false;
				}
			} catch (Exception var3) {
				this.method2138(var3.getMessage());
				return true;
			}

			this.field3717.field2862 = false;
			return true;
		} else {
			return true;
		}
	}
}