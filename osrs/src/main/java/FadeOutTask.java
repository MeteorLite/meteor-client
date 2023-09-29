import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qk")
@Implements("FadeOutTask")
public class FadeOutTask extends SongTask {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lmv;"
	)
	MusicSong field3747;
	@ObfuscatedName("al")
	int field3746;

	@ObfuscatedSignature(
		descriptor = "(Lqm;IZI)V"
	)
	public FadeOutTask(SongTask var1, int var2, boolean var3, int var4) {
		super(var1);
		this.field3747 = null;
		this.field3746 = 0;
		super.field3753 = "FadeOutTask";
		if (var2 >= 0) {
			if (var3 && var2 < class319.field2791.size()) {
				this.field3747 = (MusicSong)class319.field2791.get(var2);
			} else if (!var3 && var2 < class319.musicSongs.size()) {
				this.field3747 = (MusicSong)class319.musicSongs.get(var2);
			}

			this.field3746 = var4;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-90"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		if (this.field3747 != null && this.field3747.midiPcmStream != null) {
			this.field3747.field2886 = true;

			try {
				if (this.field3747.field2888 > 0.0F && this.field3747.midiPcmStream.isReady()) {
					float var1 = this.field3746 == 0 ? (float)this.field3746 : (float)this.field3747.musicTrackVolume / (float)this.field3746;
					MusicSong var10000 = this.field3747;
					var10000.field2888 -= var1 == 0.0F ? (float)this.field3747.musicTrackVolume : var1;
					if (this.field3747.field2888 < 0.0F) {
						this.field3747.field2888 = 0.0F;
					}

					this.field3747.midiPcmStream.setPcmStreamVolume((int)this.field3747.field2888);
					return false;
				}
			} catch (Exception var3) {
				this.method2170(var3.getMessage());
				return true;
			}

			this.field3747.field2886 = false;
			return true;
		} else {
			return true;
		}
	}
}