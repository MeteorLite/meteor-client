import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("px")
public class FadeOutTask extends SongTask {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lmj;"
	)
	MusicSong field3705;
	@ObfuscatedName("ay")
	int field3704;

	@ObfuscatedSignature(
		descriptor = "(Lpp;IZI)V"
	)
	public FadeOutTask(SongTask var1, int var2, boolean var3, int var4) {
		super(var1);
		this.field3705 = null;
		this.field3704 = 0;
		super.field3712 = "FadeOutTask";
		if (var2 >= 0) {
			if (var3 && var2 < class306.field2758.size()) {
				this.field3705 = (MusicSong)class306.field2758.get(var2);
			} else if (!var3 && var2 < class306.musicSongs.size()) {
				this.field3705 = (MusicSong)class306.musicSongs.get(var2);
			}

			this.field3704 = var4;
		}
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "994462530"
	)
	public boolean vmethod2107(int var1) {
		if (this.field3705 != null && this.field3705.midiPcmStream != null) {
			this.field3705.field2851 = true;

			try {
				if (this.field3705.field2853 > 0.0F && this.field3705.midiPcmStream.isReady()) {
					float var2 = this.field3704 == 0 ? (float)this.field3704 : (float)this.field3705.field2854 / (float)this.field3704;
					MusicSong var10000 = this.field3705;
					var10000.field2853 -= 0.0F == var2 ? (float)this.field3705.field2854 : var2;
					if (this.field3705.field2853 < 0.0F) {
						this.field3705.field2853 = 0.0F;
					}

					this.field3705.midiPcmStream.setPcmStreamVolume((int)this.field3705.field2853);
					return false;
				}
			} catch (Exception var4) {
				this.method2102(var4.getMessage());
				return true;
			}

			this.field3705.field2851 = false;
			return true;
		} else {
			return true;
		}
	}

	@ObfuscatedName("ag")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1708215021"
	)
	public static void method2095() {
		FloorOverlayDefinition.FloorOverlayDefinition_cached.clear();
	}

	@ObfuscatedName("hk")
	@ObfuscatedSignature(
		descriptor = "(Lig;IIII)V",
		garbageValue = "1446109595"
	)
	static void method2096(SequenceDefinition var0, int var1, int var2, int var3) {
		if (Client.soundEffectCount < 50 && class150.clientPreferences.getAreaSoundEffectsVolume() != 0) {
			if (var0.soundEffects != null && var1 < var0.soundEffects.length) {
				SoundSystem.method220(var0.soundEffects[var1], var2, var3);
			}
		}
	}
}
