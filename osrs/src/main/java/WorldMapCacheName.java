import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kr")
@Implements("WorldMapCacheName")
public class WorldMapCacheName {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lkr;"
	)
	public static final WorldMapCacheName field2471;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lkr;"
	)
	public static final WorldMapCacheName field2469;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lkr;"
	)
	public static final WorldMapCacheName field2470;
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lkr;"
	)
	static final WorldMapCacheName field2472;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lkr;"
	)
	public static final WorldMapCacheName field2468;
	@ObfuscatedName("ai")
	@Export("name")
	public final String name;

	static {
		field2471 = new WorldMapCacheName("details");
		field2469 = new WorldMapCacheName("compositemap");
		field2470 = new WorldMapCacheName("compositetexture");
		field2472 = new WorldMapCacheName("area");
		field2468 = new WorldMapCacheName("labels");
	}

	WorldMapCacheName(String var1) {
		this.name = var1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(IB)Lhm;",
		garbageValue = "101"
	)
	public static HitSplatDefinition method1564(int var0) {
		HitSplatDefinition var1 = (HitSplatDefinition)HitSplatDefinition.HitSplatDefinition_cached.get((long)var0);
		if (var1 != null) {
			return var1;
		} else {
			byte[] var2 = HitSplatDefinition.HitSplatDefinition_archive.takeFile(32, var0);
			var1 = new HitSplatDefinition();
			if (var2 != null) {
				var1.decode(new Buffer(var2));
			}

			HitSplatDefinition.HitSplatDefinition_cached.put(var1, (long)var0);
			return var1;
		}
	}
}