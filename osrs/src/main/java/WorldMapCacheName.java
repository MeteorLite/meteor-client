import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lh")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Llh;"
	)
	public static final WorldMapCacheName field2482;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Llh;"
	)
	public static final WorldMapCacheName field2484;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Llh;"
	)
	public static final WorldMapCacheName field2483;
	@ObfuscatedName("ax")
	@ObfuscatedSignature(
		descriptor = "Llh;"
	)
	static final WorldMapCacheName field2486;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Llh;"
	)
	public static final WorldMapCacheName field2485;
	@ObfuscatedName("ah")
	@Export("name")
	public final String name;

	static {
		field2482 = new WorldMapCacheName("details");
		field2484 = new WorldMapCacheName("compositemap");
		field2483 = new WorldMapCacheName("compositetexture");
		field2486 = new WorldMapCacheName("area");
		field2485 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(I[BLrw;B)V",
		garbageValue = "21"
	)
	static void method1592(int var0, byte[] var1, ArchiveDisk var2) {
		ArchiveDiskAction var3 = new ArchiveDiskAction();
		var3.type = 0;
		var3.key = (long)var0;
		var3.data = var1;
		var3.archiveDisk = var2;
		synchronized(ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue) {
			ArchiveDiskActionHandler.ArchiveDiskActionHandler_requestQueue.addFirst(var3);
		}

		class87.method461();
	}
}