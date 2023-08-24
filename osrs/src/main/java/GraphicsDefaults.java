import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.lang.management.GarbageCollectorMXBean;

@ObfuscatedName("rr")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("bi")
	@Export("garbageCollector")
	static GarbageCollectorMXBean garbageCollector;
	@ObfuscatedName("au")
	@Export("compass")
	public int compass;
	@ObfuscatedName("ae")
	public int field3850;
	@ObfuscatedName("ao")
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("at")
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("ac")
	public int field3848;
	@ObfuscatedName("ai")
	public int field3852;
	@ObfuscatedName("az")
	public int field3857;
	@ObfuscatedName("ap")
	public int field3854;
	@ObfuscatedName("aa")
	public int field3847;
	@ObfuscatedName("af")
	public int field3851;
	@ObfuscatedName("ad")
	public int field3849;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3850 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3848 = -1;
		this.field3852 = -1;
		this.field3857 = -1;
		this.field3854 = -1;
		this.field3847 = -1;
		this.field3851 = -1;
		this.field3849 = -1;
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Lnu;I)V",
		garbageValue = "497895580"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3844.group);
		Buffer var3 = new Buffer(var2);

		while (true) {
			int var4 = var3.readUnsignedByte();
			if (var4 == 0) {
				return;
			}

			switch(var4) {
			case 1:
				var3.readMedium();
				break;
			case 2:
				this.compass = var3.method2563();
				this.field3850 = var3.method2563();
				this.mapScenes = var3.method2563();
				this.headIconsPk = var3.method2563();
				this.field3848 = var3.method2563();
				this.field3852 = var3.method2563();
				this.field3857 = var3.method2563();
				this.field3854 = var3.method2563();
				this.field3847 = var3.method2563();
				this.field3851 = var3.method2563();
				this.field3849 = var3.method2563();
			}
		}
	}
}