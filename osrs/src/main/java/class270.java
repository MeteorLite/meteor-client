import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ArrayList;
import java.util.Iterator;

@ObfuscatedName("ka")
public class class270 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lka;"
	)
	static final class270 field2453;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lka;"
	)
	static final class270 field2452;
	@ObfuscatedName("fb")
	static long field2451;
	@ObfuscatedName("ao")
	final int field2454;

	static {
		field2453 = new class270(0);
		field2452 = new class270(1);
	}

	class270(int var1) {
		this.field2454 = var1;
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Ljava/util/ArrayList;ZI)V",
		garbageValue = "544527881"
	)
	static void method1536(ArrayList var0, boolean var1) {
		if (!var1) {
			class305.field2773.clear();
		}

		Iterator var2 = var0.iterator();

		while (var2.hasNext()) {
			MusicSong var3 = (MusicSong)var2.next();
			if (var3.musicTrackGroupId != -1 && var3.musicTrackFileId != -1) {
				if (!var1) {
					class305.field2773.add(var3);
				}

				class305.field2774.add(var3);
			}
		}

	}

	@ObfuscatedName("af")
	@ObfuscatedSignature(
		descriptor = "(IIIII)V",
		garbageValue = "2021273787"
	)
	public static void method1537(int var0, int var1, int var2, int var3) {
		class305.musicPlayerStatus = var0;
		class305.field2766 = var1;
		class305.field2769 = var2;
		class305.field2768 = var3;
	}

	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "(CII)Ljava/lang/String;",
		garbageValue = "1203600347"
	)
	public static String method1538(char var0, int var1) {
		char[] var2 = new char[var1];

		for (int var3 = 0; var3 < var1; ++var3) {
			var2[var3] = var0;
		}

		return new String(var2);
	}

	@ObfuscatedName("jt")
	@ObfuscatedSignature(
		descriptor = "(II)V",
		garbageValue = "340629836"
	)
	@Export("setWindowedMode")
	static void setWindowedMode(int var0) {
		Client.field615 = 0L;
		if (var0 >= 2) {
			Client.isResizable = true;
		} else {
			Client.isResizable = false;
		}

		if (class218.getWindowedMode() == 1) {
			class219.client.setMaxCanvasSize(765, 503);
		} else {
			class219.client.setMaxCanvasSize(7680, 2160);
		}

		if (Client.gameState >= 25) {
			Message.method341();
		}

	}
}