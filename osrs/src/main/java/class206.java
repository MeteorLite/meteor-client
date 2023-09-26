import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;

@ObfuscatedName("ho")
public class class206 extends DualNode {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llr;"
	)
	@Export("Widget_cachedSpriteMasks")
	public static EvictingDualNodeHashTable Widget_cachedSpriteMasks;

	static {
		Widget_cachedSpriteMasks = new EvictingDualNodeHashTable(64);
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "-926597754"
	)
	@Export("someMusicMethod")
	public static void someMusicMethod(int var0, int var1, int var2, int var3) {
		if (class319.musicSongs.size() > 1 && class319.musicSongs.get(0) != null && ((MusicSong)class319.musicSongs.get(0)).midiPcmStream.isReady() && class319.musicSongs.get(1) != null && ((MusicSong)class319.musicSongs.get(1)).midiPcmStream.isReady()) {
			MouseHandler.method177(var0, var1, var2, var3);
			class319.field2798.add(new SwapSongTask((SongTask)null));
			ArrayList var4 = new ArrayList();
			var4.add(new DelayFadeTask(new FadeInTask((SongTask)null, 1, false, class319.field2795), class319.field2793));
			var4.add(new DelayFadeTask(new FadeOutTask((SongTask)null, 0, false, class319.field2794), class319.musicPlayerStatus));
			class319.field2798.add(new ConcurrentMidiTask((SongTask)null, var4));
			if (class319.field2789.get(0) != null && class319.field2789.get(1) != null) {
				MusicSong var5 = (MusicSong)class319.field2789.get(0);
				class319.field2789.set(0, class319.musicSongs.get(1));
				class319.field2789.set(1, var5);
			}
		}

	}
}