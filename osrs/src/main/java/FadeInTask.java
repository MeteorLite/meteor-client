import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pb")
public class FadeInTask extends SongTask {
	@ObfuscatedName("ue")
	static int field3706;
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lmj;"
	)
	MusicSong field3708;
	@ObfuscatedName("ay")
	int field3707;

	@ObfuscatedSignature(
		descriptor = "(Lpp;IZI)V"
	)
	public FadeInTask(SongTask var1, int var2, boolean var3, int var4) {
		super(var1);
		this.field3708 = null;
		this.field3707 = 0;
		super.field3712 = "FadeInTask";
		if (var2 >= 0) {
			if (var3 && var2 < class306.field2758.size()) {
				this.field3708 = (MusicSong)class306.field2758.get(var2);
			} else if (!var3 && var2 < class306.musicSongs.size()) {
				this.field3708 = (MusicSong)class306.musicSongs.get(var2);
			}

			this.field3707 = var4;
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		if (this.field3708 != null && this.field3708.midiPcmStream != null) {
			this.field3708.field2851 = true;

			try {
				if (this.field3708.field2853 < (float)this.field3708.field2854 && this.field3708.midiPcmStream.isReady()) {
					float var2 = this.field3707 == 0 ? (float)this.field3707 : (float)this.field3708.field2854 / (float)this.field3707;
					MusicSong var10000 = this.field3708;
					var10000.field2853 += var2 == 0.0F ? (float)this.field3708.field2854 : var2;
					if (this.field3708.field2853 > (float)this.field3708.field2854) {
						this.field3708.field2853 = (float)this.field3708.field2854;
					}

					this.field3708.midiPcmStream.setPcmStreamVolume((int)this.field3708.field2853);
					return false;
				}
			} catch (Exception var4) {
				this.method2102(var4.getMessage());
				return true;
			}

			this.field3708.field2851 = false;
			return true;
		} else {
			return true;
		}
	}
}
