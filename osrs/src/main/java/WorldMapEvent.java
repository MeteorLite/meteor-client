import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.Iterator;

@ObfuscatedName("kl")
@Implements("WorldMapEvent")
public class WorldMapEvent {
	@ObfuscatedName("au")
	@Export("mapElement")
	public int mapElement;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lmc;"
	)
	@Export("coord1")
	public Coord coord1;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lmc;"
	)
	@Export("coord2")
	public Coord coord2;

	@ObfuscatedSignature(
		descriptor = "(ILmc;Lmc;)V"
	)
	public WorldMapEvent(int var1, Coord var2, Coord var3) {
		this.mapElement = var1;
		this.coord1 = var2;
		this.coord2 = var3;
	}

	@ObfuscatedName("nm")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "307364041"
	)
	static final void method1588(int var0) {
		var0 = Math.min(Math.max(var0, 0), 255);
		if (var0 != class449.clientPreferences.getCurrentMusicVolume()) {
			label36: {
				if (class449.clientPreferences.getCurrentMusicVolume() == 0) {
					boolean var1 = !class305.field2773.isEmpty();
					if (var1) {
						Archive var2 = class385.archive6;
						if (!class305.field2773.isEmpty()) {
							ArrayList var3 = new ArrayList();
							Iterator var4 = class305.field2773.iterator();

							while (var4.hasNext()) {
								MusicSong var5 = (MusicSong)var4.next();
								var5.field2865 = false;
								var5.field2866 = false;
								var5.field2862 = false;
								var5.field2863 = false;
								var5.musicTrackArchive = var2;
								var5.musicTrackVolume = var0;
								var5.field2867 = 0.0F;
								var3.add(var5);
							}

							class53.method291(var3, class305.musicPlayerStatus, class305.field2766, class305.field2769, class305.field2768, false);
						}

						Client.playingJingle = false;
						break label36;
					}
				}

				if (var0 == 0) {
					Script.method445(0, 0);
					Client.playingJingle = false;
				} else {
					class300.method1620(var0);
				}
			}

			class449.clientPreferences.setCurrentMusicVolume(var0);
		}

	}
}