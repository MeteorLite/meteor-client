import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

@ObfuscatedName("av")
@Implements("Canvas")
public final class Canvas extends java.awt.Canvas {
	@ObfuscatedName("wb")
	@ObfuscatedSignature(
		descriptor = "Lsi;"
	)
	@Export("worldMap")
	static WorldMap worldMap;
	@ObfuscatedName("ae")
	static long field61;
	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "Lbe;"
	)
	@Export("soundSystem")
	static SoundSystem soundSystem;
	@ObfuscatedName("pr")
	@Export("selectedSpellFlags")
	static int selectedSpellFlags;
	@ObfuscatedName("au")
	@Export("component")
	Component component;

	Canvas(Component var1) {
		this.component = var1;
	}

	public final void update(Graphics var1) {
		this.component.update(var1);
	}

	public final void paint(Graphics var1) {
		this.component.paint(var1);
	}

	@ObfuscatedName("hr")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1772266899"
	)
	static final void method77() {
		int var3;
		for (int var0 = 0; var0 < Client.soundEffectCount; ++var0) {
			int var10002 = Client.queuedSoundEffectDelays[var0]--;
			if (Client.queuedSoundEffectDelays[var0] >= -10) {
				SoundEffect var9 = Client.soundEffects[var0];
				if (var9 == null) {
					Object var10000 = null;
					var9 = SoundEffect.readSoundEffect(class28.field81, Client.soundEffectIds[var0], 0);
					if (var9 == null) {
						continue;
					}

					int[] var18 = Client.queuedSoundEffectDelays;
					var18[var0] += var9.calculateDelay();
					Client.soundEffects[var0] = var9;
				}

				if (Client.queuedSoundEffectDelays[var0] < 0) {
					int var2;
					if (Client.soundLocations[var0] != 0) {
						var3 = (Client.soundLocations[var0] & 255) * 128;
						int var4 = Client.soundLocations[var0] >> 16 & 255;
						int var5 = var4 * 128 + 64 - VarbitComposition.localPlayer.x;
						if (var5 < 0) {
							var5 = -var5;
						}

						int var6 = Client.soundLocations[var0] >> 8 & 255;
						int var7 = var6 * 128 + 64 - VarbitComposition.localPlayer.y;
						if (var7 < 0) {
							var7 = -var7;
						}

						int var8 = var7 + var5 - 128;
						if (var8 > var3) {
							Client.queuedSoundEffectDelays[var0] = -100;
							continue;
						}

						if (var8 < 0) {
							var8 = 0;
						}

						var2 = (var3 - var8) * class449.clientPreferences.getAreaSoundEffectsVolume() / var3;
					} else {
						var2 = class449.clientPreferences.getCurrentSoundEffectsVolume();
					}

					if (var2 > 0) {
						RawSound var10 = var9.toRawSound().resample(class330.decimator);
						RawPcmStream var11 = RawPcmStream.createRawPcmStream(var10, 100, var2);
						var11.setNumLoops(Client.queuedSoundEffectLoops[var0] - 1);
						class162.pcmStreamMixer.addSubStream(var11);
					}

					Client.queuedSoundEffectDelays[var0] = -100;
				}
			} else {
				--Client.soundEffectCount;

				for (int var1 = var0; var1 < Client.soundEffectCount; ++var1) {
					Client.soundEffectIds[var1] = Client.soundEffectIds[var1 + 1];
					Client.soundEffects[var1] = Client.soundEffects[var1 + 1];
					Client.queuedSoundEffectLoops[var1] = Client.queuedSoundEffectLoops[var1 + 1];
					Client.queuedSoundEffectDelays[var1] = Client.queuedSoundEffectDelays[var1 + 1];
					Client.soundLocations[var1] = Client.soundLocations[var1 + 1];
				}

				--var0;
			}
		}

		if (Client.playingJingle) {
			boolean var15;
			if (!class305.field2771.isEmpty()) {
				var15 = true;
			} else if (!class305.musicSongs.isEmpty() && class305.musicSongs.get(0) != null && ((MusicSong)class305.musicSongs.get(0)).midiPcmStream != null) {
				var15 = ((MusicSong)class305.musicSongs.get(0)).midiPcmStream.isReady();
			} else {
				var15 = false;
			}

			if (!var15) {
				if (class449.clientPreferences.getCurrentMusicVolume() != 0) {
					boolean var16 = !class305.field2773.isEmpty();
					if (var16) {
						Archive var12 = class385.archive6;
						var3 = class449.clientPreferences.getCurrentMusicVolume();
						if (!class305.field2773.isEmpty()) {
							ArrayList var17 = new ArrayList();
							Iterator var13 = class305.field2773.iterator();

							while (var13.hasNext()) {
								MusicSong var14 = (MusicSong)var13.next();
								var14.field2865 = false;
								var14.field2866 = false;
								var14.field2862 = false;
								var14.field2863 = false;
								var14.musicTrackArchive = var12;
								var14.musicTrackVolume = var3;
								var14.field2867 = 0.0F;
								var17.add(var14);
							}

							class53.method291(var17, class305.musicPlayerStatus, class305.field2766, class305.field2769, class305.field2768, false);
						}
					}
				}

				Client.playingJingle = false;
			}
		}

	}
}