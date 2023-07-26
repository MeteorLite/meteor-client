import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("RouteStrategy")
public abstract class RouteStrategy {
	@ObfuscatedName("aw")
	@Export("approxDestinationX")
	public int approxDestinationX;
	@ObfuscatedName("ay")
	@Export("approxDestinationY")
	public int approxDestinationY;
	@ObfuscatedName("ar")
	@Export("approxDestinationSizeX")
	public int approxDestinationSizeX;
	@ObfuscatedName("am")
	@Export("approxDestinationSizeY")
	public int approxDestinationSizeY;

	protected RouteStrategy() {
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(IIILij;I)Z",
		garbageValue = "2142084611"
	)
	@Export("hasArrived")
	protected abstract boolean hasArrived(int var1, int var2, int var3, CollisionMap var4);

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(IIS)V",
		garbageValue = "-1978"
	)
	public static void method1107(int var0, int var1) {
		ArchiveLoader.method464(var0, var1, 0, 0);
		class306.field2755.clear();
		if (!class306.musicSongs.isEmpty() && (var0 != 0 || var1 != 0)) {
			class306.field2760.add(new DelayFadeTask((SongTask)null, class306.musicPlayerStatus));
			class306.field2760.add(new FadeOutTask((SongTask)null, 0, false, class306.field2753));
		}

		ArrayList var2 = class162.method847();
		class306.field2760.add(new class402((SongTask)null, var2));
	}

	@ObfuscatedName("bc")
	@ObfuscatedSignature(
		descriptor = "(ILdc;ZS)I",
		garbageValue = "-21358"
	)
	static int method1108(int var0, Script var1, boolean var2) {
		if (var0 == 5630) {
			Client.logoutTimer = 250;
			return 1;
		} else {
			return 2;
		}
	}

	@ObfuscatedName("il")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "-774340966"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field611 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (Huffman.getWindowedMode() == 1) {
			TileItem.client.setMaxCanvasSize(765, 503);
		} else {
			TileItem.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			LoadSongTask.method2108();
		}

	}
}
