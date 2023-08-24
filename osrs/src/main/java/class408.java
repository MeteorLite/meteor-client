import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("pp")
public class class408 extends SongTask {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	AbstractArchive field3728;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	AbstractArchive field3726;
	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	AbstractArchive field3727;

	@ObfuscatedSignature(
		descriptor = "(Lpm;Lnu;Lnu;Lnu;)V"
	)
	public class408(SongTask var1, AbstractArchive var2, AbstractArchive var3, AbstractArchive var4) {
		super(var1);
		this.field3728 = var2;
		this.field3726 = var3;
		this.field3727 = var4;
		super.field3722 = "LoadSongTask";
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "1604030758"
	)
	public boolean vmethod2142() {
		int var1 = 0;
		Iterator var2 = class305.musicSongs.iterator();

		while (true) {
			while (var2.hasNext()) {
				MusicSong var3 = (MusicSong)var2.next();
				if (var3 != null && var3.midiPcmStream.field2809 > 1 && var3.midiPcmStream.method1637()) {
					this.method2138("Attempted to load patches of already loading midiplayer!");
					return true;
				}

				if (var3 != null && !var3.field2866) {
					try {
						if (var3.musicTrackArchive != null && var3.musicTrackGroupId != -1 && var3.musicTrackFileId != -1) {
							if (var3.field2872 == null) {
								var3.field2872 = MusicTrack.readTrack(var3.musicTrackArchive, var3.musicTrackGroupId, var3.musicTrackFileId);
								if (var3.field2872 == null) {
									continue;
								}
							}

							if (var3.field2861 == null) {
								var3.field2861 = new SoundCache(this.field3727, this.field3726);
							}

							if (var3.midiPcmStream.method1630(var3.field2872, this.field3728, var3.field2861)) {
								++var1;
								var3.field2866 = true;
								var3.midiPcmStream.method1631();
							}
						} else {
							++var1;
						}
					} catch (Exception var5) {
						Messages.RunException_sendStackTrace((String)null, var5);
						this.method2138(var5.getMessage());
						return true;
					}
				} else {
					++var1;
				}
			}

			if (var1 == class305.musicSongs.size()) {
				return true;
			}

			return false;
		}
	}

	@ObfuscatedName("nr")
	@ObfuscatedSignature(
		descriptor = "(IIIILui;Lme;I)V",
		garbageValue = "-1567258086"
	)
	@Export("worldToMinimap")
	static final void worldToMinimap(int var0, int var1, int var2, int var3, SpritePixels var4, SpriteMask var5) {
		int var6 = var3 * var3 + var2 * var2;
		if (var6 > 4225 && var6 < 90000) {
			int var7 = Client.camAngleY & 2047;
			int var8 = Rasterizer3D.Rasterizer3D_sine[var7];
			int var9 = Rasterizer3D.Rasterizer3D_cosine[var7];
			int var10 = var3 * var8 + var9 * var2 >> 16;
			int var11 = var3 * var9 - var8 * var2 >> 16;
			double var12 = Math.atan2((double)var10, (double)var11);
			int var14 = var5.width / 2 - 25;
			int var15 = (int)(Math.sin(var12) * (double)var14);
			int var16 = (int)(Math.cos(var12) * (double)var14);
			byte var17 = 20;
			class167.redHintArrowSprite.method2686(var15 + (var0 + var5.width / 2 - var17 / 2), var5.height / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
		} else {
			class210.drawSpriteOnMinimap(var0, var1, var2, var3, var4, var5);
		}

	}
}