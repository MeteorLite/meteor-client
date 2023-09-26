import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;

@ObfuscatedName("fy")
public enum class140 implements class386 {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1301(0, 0),
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1304(1, 1),
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1303(2, 2),
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1308(3, 3),
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1306(4, 4),
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1302(5, 5),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1307(6, 6),
	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1300(7, 7),
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lfy;"
	)
	field1305(8, 8);

	@ObfuscatedName("tr")
	@ObfuscatedSignature(
		descriptor = "Lbm;"
	)
	@Export("pcmStreamMixer")
	static PcmStreamMixer pcmStreamMixer;
	@ObfuscatedName("av")
	final int field1310;
	@ObfuscatedName("ag")
	final int field1309;

	class140(int var3, int var4) {
		this.field1310 = var3;
		this.field1309 = var4;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "-1243971674"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.field1309;
	}

	@ObfuscatedName("hu")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "71"
	)
	@Export("reloadJS5")
	static void reloadJS5() {
		if (class33.varcs.hasUnwrittenChanges()) {
			class33.varcs.write();
		}

		MusicPatchNode2.method1658();
		if (class233.mouseRecorder != null) {
			class233.mouseRecorder.isRunning = false;
		}

		class233.mouseRecorder = null;
		Client.packetWriter.close();
		if (GameEngine.taskHandler != null) {
			try {
				GameEngine.taskHandler.close();
			} catch (Exception var3) {
			}
		}

		GameEngine.taskHandler = null;
		class214.method1052();
		WorldMapSection0.method1551();
		class10.scene.clear();

		for (int var1 = 0; var1 < 4; ++var1) {
			Client.collisionMaps[var1].clear();
		}

		class434.worldMap = null;
		ItemComposition.method1088(0, 0);
		class470.method2362();
		Client.playingJingle = false;
		SoundCache.method228();
		if (class171.pcmPlayer1 != null) {
			class171.pcmPlayer1.shutdown();
		}

		class59.field309.method1969();
		WorldMapDecorationType.method1898();
		if (AbstractWorldMapIcon.urlRequester != null) {
			AbstractWorldMapIcon.urlRequester.close();
		}

		HealthBar.method577();
		JagexCache.JagexCache_dat2File = null;
		JagexCache.JagexCache_idx255File = null;
		UserComparator8.JagexCache_idxFiles = null;
		class232.method1192();
		UserComparator10.field1188 = null;
		Client.archiveLoaders.clear();
		Client.field551 = 0;
		class59.field309 = new JagNetThread();
		AbstractWorldMapIcon.urlRequester = new class115(class159.client.field660, 217);

		try {
			class139.method735("oldschool", UserComparator3.field1184, SoundSystem.field211.name, 0, 23);
		} catch (IOException var2) {
			throw new RuntimeException(var2);
		}

		UserComparator10.field1188 = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		GameEngine.taskHandler = new TaskHandler();
		class159.client.method155();
		Client.field416 = class94.field929;
		DefaultsGroup.updateGameState(0);
	}

	@ObfuscatedName("lu")
	@ObfuscatedSignature(
		descriptor = "(Lnm;IIZI)V",
		garbageValue = "1653848905"
	)
	@Export("alignWidgetSize")
	static void alignWidgetSize(Widget var0, int var1, int var2, boolean var3) {
		int var4 = var0.width;
		int var5 = var0.height;
		if (var0.widthAlignment == 0) {
			var0.width = var0.rawWidth;
		} else if (var0.widthAlignment == 1) {
			var0.width = var1 - var0.rawWidth;
		} else if (var0.widthAlignment == 2) {
			var0.width = var0.rawWidth * var1 >> 14;
		}

		if (var0.heightAlignment == 0) {
			var0.height = var0.rawHeight;
		} else if (var0.heightAlignment == 1) {
			var0.height = var2 - var0.rawHeight;
		} else if (var0.heightAlignment == 2) {
			var0.height = var2 * var0.rawHeight >> 14;
		}

		if (var0.widthAlignment == 4) {
			var0.width = var0.height * var0.field3017 / var0.field3012;
		}

		if (var0.heightAlignment == 4) {
			var0.height = var0.field3012 * var0.width / var0.field3017;
		}

		if (var0.contentType == 1337) {
			Client.viewportWidget = var0;
		}

		if (var0.type == 12) {
			var0.method1877().method1768(var0.width, var0.height);
		}

		if (var3 && var0.onResize != null && (var4 != var0.width || var5 != var0.height)) {
			ScriptEvent var6 = new ScriptEvent();
			var6.widget = var0;
			var6.args = var0.onResize;
			Client.scriptEvents.addFirst(var6);
		}

	}
}