import java.io.IOException;
import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dn")
@Implements("InterfaceParent")
public class InterfaceParent extends Node {
	@ObfuscatedName("aw")
	@Export("group")
	int group;
	@ObfuscatedName("ay")
	@Export("type")
	int type;
	@ObfuscatedName("ar")
	boolean field856;

	InterfaceParent() {
		this.field856 = false;
	}

	@ObfuscatedName("ap")
	@ObfuscatedSignature(
		descriptor = "(II)Z",
		garbageValue = "143844531"
	)
	public static boolean method470(int var0) {
		boolean var1 = false;
		boolean var2 = false;
		if (!class306.field2760.isEmpty()) {
			class407 var3 = (class407)class306.field2760.get(0);
			if (var3 == null) {
				class306.field2760.remove(0);
			} else if (var3.vmethod2107(var0)) {
				if (var3.method2098()) {
					System.out.println("Error in midimanager.service: " + var3.method2100());
					var1 = true;
				} else {
					if (var3.method2101() != null) {
						class306.field2760.add(1, var3.method2101());
					}

					var2 = var3.method2099();
				}

				class306.field2760.remove(0);
			} else {
				var2 = var3.method2099();
			}
		}

		if (var1) {
			class306.field2760.clear();
			ArrayList var4 = class162.method847();
			class306.field2760.add(new class402((class407)null, var4));
		}

		return var2;
	}

	@ObfuscatedName("hv")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "-2055389038"
	)
	static void method471() {
		if (PendingSpawn.varcs.hasUnwrittenChanges()) {
			PendingSpawn.varcs.write();
		}

		if (class497.mouseRecorder != null) {
			class497.mouseRecorder.isRunning = false;
		}

		class497.mouseRecorder = null;
		Client.packetWriter.close();
		if (GameEngine.taskHandler != null) {
			try {
				GameEngine.taskHandler.close();
			} catch (Exception var3) {
			}
		}

		GameEngine.taskHandler = null;
		class159.method836();
		class197.archive2.clearFiles();
		FontName.archive13.clearFiles();
		ReflectionCheck.field151.clearFiles();
		class191.field1546.clearFiles();
		World.field670.clearFiles();
		class106.field1099.clearFiles();
		Varcs.field1130.clearFiles();
		Interpreter.field713.clearFiles();
		class10.compass = null;
		SoundCache.redHintArrowSprite = null;
		class282.mapSceneSprites = null;
		DbTableType.headIconPkSprites = null;
		class17.headIconPrayerSprites = null;
		class345.headIconHintSprites = null;
		DynamicObject.mapMarkerSprites = null;
		class211.crossSprites = null;
		MusicPatchNode2.mapDotSprites = null;
		class302.scrollBarSprites = null;
		AbstractWorldMapIcon.field2442 = null;
		UserComparator5.scene.clear();

		int var1;
		for (var1 = 0; var1 < 4; ++var1) {
			Client.collisionMaps[var1].clear();
		}

		class127.worldMap = null;
		RouteStrategy.method1107(0, 0);
		class306.field2755.clear();
		Client.playingJingle = false;
		class133.method727();
		if (VerticalAlignment.pcmPlayer1 != null) {
			VerticalAlignment.pcmPlayer1.shutdown();
		}

		class153.field1356.method1904();
		ArchiveDiskAction.method1847();
		if (WorldMapLabel.urlRequester != null) {
			WorldMapLabel.urlRequester.close();
		}

		try {
			JagexCache.JagexCache_dat2File.close();

			for (var1 = 0; var1 < JagexCache.field1450; ++var1) {
				class302.JagexCache_idxFiles[var1].close();
			}

			JagexCache.JagexCache_idx255File.close();
			JagexCache.JagexCache_randomDat.close();
		} catch (Exception var4) {
		}

		JagexCache.JagexCache_dat2File = null;
		JagexCache.JagexCache_idx255File = null;
		class302.JagexCache_idxFiles = null;
		FileSystem.FileSystem_cacheFiles.clear();
		class158.masterDisk = null;
		Client.archiveLoaders.clear();
		Client.field548 = 0;
		class153.field1356 = new JagNetThread();
		WorldMapLabel.urlRequester = new class113(TileItem.client.field655, 215);

		try {
			ObjTypeCustomisation.method923("oldschool", VarpDefinition.field1494, ArchiveLoader.field849.name, 0, 22);
		} catch (IOException var2) {
			throw new RuntimeException(var2);
		}

		class158.masterDisk = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		GameEngine.taskHandler = new TaskHandler();
		Client.field412 = class92.field937;
		class129.updateGameState(0);
	}
}
