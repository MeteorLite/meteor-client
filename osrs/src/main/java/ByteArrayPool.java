import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@ObfuscatedName("qq")
@Implements("ByteArrayPool")
public class ByteArrayPool {
	@ObfuscatedName("ab")
	static final Object field3781;
	@ObfuscatedName("au")
	@Export("ByteArrayPool_smallCount")
	static int ByteArrayPool_smallCount;
	@ObfuscatedName("aa")
	@Export("ByteArrayPool_mediumCount")
	static int ByteArrayPool_mediumCount;
	@ObfuscatedName("ac")
	@Export("ByteArrayPool_largeCount")
	static int ByteArrayPool_largeCount;
	@ObfuscatedName("al")
	static int field3774;
	@ObfuscatedName("az")
	static int field3779;
	@ObfuscatedName("ap")
	static int field3775;
	@ObfuscatedName("av")
	static int field3777;
	@ObfuscatedName("ax")
	static int field3778;
	@ObfuscatedName("as")
	@Export("ByteArrayPool_small")
	static byte[][] ByteArrayPool_small;
	@ObfuscatedName("ay")
	@Export("ByteArrayPool_medium")
	static byte[][] ByteArrayPool_medium;
	@ObfuscatedName("ak")
	@Export("ByteArrayPool_large")
	static byte[][] ByteArrayPool_large;
	@ObfuscatedName("aj")
	static byte[][] field3768;
	@ObfuscatedName("aw")
	static ArrayList field3780;

	static {
		field3781 = new Object();
		ByteArrayPool_smallCount = 0;
		ByteArrayPool_mediumCount = 0;
		ByteArrayPool_largeCount = 0;
		field3774 = 0;
		field3779 = 1000;
		field3775 = 250;
		field3777 = 100;
		field3778 = 50;
		ByteArrayPool_small = new byte[1000][];
		ByteArrayPool_medium = new byte[250][];
		ByteArrayPool_large = new byte[100][];
		field3768 = new byte[50][];
		field3780 = new ArrayList();
		Renderable.method1514();
		new HashMap();
	}

	@ObfuscatedName("hb")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "1234231525"
	)
	@Export("reloadJS5")
	static void reloadJS5() {
		if (class176.varcs.hasUnwrittenChanges()) {
			class176.varcs.write();
		}

		class53.method307();
		if (Message.mouseRecorder != null) {
			Message.mouseRecorder.isRunning = false;
		}

		Message.mouseRecorder = null;
		Client.packetWriter.close();
		if (GameEngine.taskHandler != null) {
			try {
				GameEngine.taskHandler.close();
			} catch (Exception var3) {
			}
		}

		GameEngine.taskHandler = null;
		ObjectSound.method424();
		class182.method921();
		class36.scene.clear();

		for (int var1 = 0; var1 < 4; ++var1) {
			Client.collisionMaps[var1].clear();
		}

		NewShit.worldMap = null;
		WorldMapManager.method1265(0, 0);
		class472.method2350();
		Client.playingJingle = false;
		WorldMapSectionType.method1311();
		if (MusicPatchPcmStream.pcmPlayer1 != null) {
			MusicPatchPcmStream.pcmPlayer1.shutdown();
		}

		WorldMapSectionType.field2038.method1962();
		class227.method1164();
		if (class60.urlRequester != null) {
			class60.urlRequester.close();
		}

		HealthBarDefinition.method916();
		JagexCache.JagexCache_dat2File = null;
		JagexCache.JagexCache_idx255File = null;
		KeyHandler.JagexCache_idxFiles = null;
		ObjTypeCustomisation.method876();
		class302.field2511 = null;
		Client.archiveLoaders.clear();
		Client.field549 = 0;
		WorldMapSectionType.field2038 = new JagNetThread();
		class60.urlRequester = new class113(SpriteMask.client.field661, 218);

		try {
			class339.method1744("oldschool", ItemLayer.field2109, class191.field1585.name, 0, 23);
		} catch (IOException var2) {
			throw new RuntimeException(var2);
		}

		class302.field2511 = new ArchiveDisk(255, JagexCache.JagexCache_dat2File, JagexCache.JagexCache_idx255File, 500000);
		GameEngine.taskHandler = new TaskHandler();
		SpriteMask.client.method164();
		Client.field414 = class92.field942;
		WorldMapSection2.updateGameState(0);
	}
}