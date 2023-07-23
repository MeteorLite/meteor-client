import java.util.ArrayList;
import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("nu")
@Implements("StudioGame")
public enum StudioGame implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("runescape")
	runescape("runescape", "RuneScape", 0),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("stellardawn")
	stellardawn("stellardawn", "Stellar Dawn", 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("game3")
	game3("game3", "Game 3", 2),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("game4")
	game4("game4", "Game 4", 3),
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("game5")
	game5("game5", "Game 5", 4),
	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "Lnu;"
	)
	@Export("oldscape")
	oldscape("oldscape", "RuneScape 2007", 5);

	@ObfuscatedName("ag")
	@Export("name")
	public final String name;
	@ObfuscatedName("az")
	@Export("id")
	final int id;

	StudioGame(String var3, String var4, int var5) {
		this.name = var3;
		this.id = var5;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("mo")
	@ObfuscatedSignature(
		descriptor = "(IB)V",
		garbageValue = "0"
	)
	static final void method1839(int var0) {
		var0 = Math.min(Math.max(var0, 0), 255);
		if (var0 != class150.clientPreferences.getCurrentMusicVolume()) {
			label36: {
				if (class150.clientPreferences.getCurrentMusicVolume() == 0) {
					boolean var1 = !class306.field2755.isEmpty();
					if (var1) {
						Archive var2 = class13.archive6;
						if (!class306.field2755.isEmpty()) {
							ArrayList var3 = new ArrayList();
							Iterator var4 = class306.field2755.iterator();

							while (var4.hasNext()) {
								MusicSong var5 = (MusicSong)var4.next();
								var5.field2852 = false;
								var5.field2849 = false;
								var5.field2851 = false;
								var5.field2859 = var2;
								var5.field2854 = var0;
								var5.field2853 = 0.0F;
								var3.add(var5);
							}

							UserComparator4.method663(var3, class306.musicPlayerStatus, class306.field2753, class306.field2754, class306.field2751, false);
						}

						Client.playingJingle = false;
						break label36;
					}
				}

				if (var0 == 0) {
					RouteStrategy.method1107(0, 0);
					Client.playingJingle = false;
				} else {
					class7.method18(var0);
				}
			}

			class150.clientPreferences.setCurrentMusicVolume(var0);
		}

	}
}
