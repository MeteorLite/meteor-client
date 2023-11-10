import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rl")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("at")
	@Export("compass")
	public int compass;
	@ObfuscatedName("ah")
	public int field3884;
	@ObfuscatedName("ar")
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("ao")
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("ab")
	public int field3882;
	@ObfuscatedName("au")
	public int field3890;
	@ObfuscatedName("aa")
	public int field3881;
	@ObfuscatedName("ac")
	public int field3883;
	@ObfuscatedName("al")
	public int field3885;
	@ObfuscatedName("az")
	public int field3891;
	@ObfuscatedName("ap")
	public int field3887;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3884 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3882 = -1;
		this.field3890 = -1;
		this.field3881 = -1;
		this.field3883 = -1;
		this.field3885 = -1;
		this.field3891 = -1;
		this.field3887 = -1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lol;B)V",
		garbageValue = "78"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3878.group);
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
				this.compass = var3.readNullableLargeSmart();
				this.field3884 = var3.readNullableLargeSmart();
				this.mapScenes = var3.readNullableLargeSmart();
				this.headIconsPk = var3.readNullableLargeSmart();
				this.field3882 = var3.readNullableLargeSmart();
				this.field3890 = var3.readNullableLargeSmart();
				this.field3881 = var3.readNullableLargeSmart();
				this.field3883 = var3.readNullableLargeSmart();
				this.field3885 = var3.readNullableLargeSmart();
				this.field3891 = var3.readNullableLargeSmart();
				this.field3887 = var3.readNullableLargeSmart();
			}
		}
	}
}