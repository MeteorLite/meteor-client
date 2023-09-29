import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;

@ObfuscatedName("qg")
@Implements("FadeInTask")
public class FadeInTask extends SongTask {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lmv;"
	)
	MusicSong field3749;
	@ObfuscatedName("al")
	int field3748;

	@ObfuscatedSignature(
		descriptor = "(Lqm;IZI)V"
	)
	public FadeInTask(SongTask var1, int var2, boolean var3, int var4) {
		super(var1);
		this.field3749 = null;
		this.field3748 = 0;
		super.field3753 = "FadeInTask";
		if (var2 >= 0) {
			if (var3 && var2 < class319.field2791.size()) {
				this.field3749 = (MusicSong)class319.field2791.get(var2);
			} else if (!var3 && var2 < class319.musicSongs.size()) {
				this.field3749 = (MusicSong)class319.musicSongs.get(var2);
			}

			this.field3748 = var4;
		}
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(B)Z",
		garbageValue = "-90"
	)
	@Export("vmethod2142")
	public boolean vmethod2142() {
		if (this.field3749 != null && this.field3749.midiPcmStream != null) {
			this.field3749.field2886 = true;

			try {
				if (this.field3749.field2888 < (float)this.field3749.musicTrackVolume && this.field3749.midiPcmStream.isReady()) {
					float var1 = this.field3748 == 0 ? (float)this.field3748 : (float)this.field3749.musicTrackVolume / (float)this.field3748;
					MusicSong var10000 = this.field3749;
					var10000.field2888 += 0.0F == var1 ? (float)this.field3749.musicTrackVolume : var1;
					if (this.field3749.field2888 > (float)this.field3749.musicTrackVolume) {
						this.field3749.field2888 = (float)this.field3749.musicTrackVolume;
					}

					this.field3749.midiPcmStream.setPcmStreamVolume((int)this.field3749.field2888);
					return false;
				}
			} catch (Exception var3) {
				this.method2170(var3.getMessage());
				return true;
			}

			this.field3749.field2886 = false;
			return true;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(I)Ldy;",
		garbageValue = "1147627487"
	)
	static ClientPreferences method2164() {
		AccessFile var0 = null;
		ClientPreferences var1 = new ClientPreferences();

		try {
			var0 = class17.getPreferencesFile("", UrlRequester.field1163.name, false);
			byte[] var2 = new byte[(int)var0.length()];

			int var4;
			for (int var3 = 0; var3 < var2.length; var3 += var4) {
				var4 = var0.read(var2, var3, var2.length - var3);
				if (var4 == -1) {
					throw new IOException();
				}
			}

			var1 = new ClientPreferences(new Buffer(var2));
		} catch (Exception var6) {
		}

		try {
			if (var0 != null) {
				var0.close();
			}
		} catch (Exception var5) {
		}

		return var1;
	}
}