import java.util.ArrayList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lkp;"
	)
	public static final WorldMapCacheName field2449;
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lkp;"
	)
	public static final WorldMapCacheName field2450;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lkp;"
	)
	public static final WorldMapCacheName field2447;
	@ObfuscatedName("am")
	@ObfuscatedSignature(
		descriptor = "Lkp;"
	)
	static final WorldMapCacheName field2451;
	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "Lkp;"
	)
	public static final WorldMapCacheName field2448;
	@ObfuscatedName("aj")
	@Export("name")
	public final String name;

	static {
		field2449 = new WorldMapCacheName("details");
		field2450 = new WorldMapCacheName("compositemap");
		field2447 = new WorldMapCacheName("compositetexture");
		field2451 = new WorldMapCacheName("area");
		field2448 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;Lnd;Lnd;Ljava/util/ArrayList;B)Z",
		garbageValue = "1"
	)
	public static boolean method1521(AbstractArchive var0, AbstractArchive var1, AbstractArchive var2, ArrayList var3) {
		class306.musicPatchesArchive = var0;
		class306.musicSamplesArchive = var1;
		class306.soundEffectsArchive = var2;
		class306.midiPcmStream = var3;
		return true;
	}
}
