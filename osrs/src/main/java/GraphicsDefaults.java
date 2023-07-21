import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ru")
@Implements("GraphicsDefaults")
public class GraphicsDefaults {
	@ObfuscatedName("aw")
	@Export("compass")
	public int compass;
	@ObfuscatedName("ay")
	public int field3841;
	@ObfuscatedName("ar")
	@Export("mapScenes")
	public int mapScenes;
	@ObfuscatedName("am")
	@Export("headIconsPk")
	public int headIconsPk;
	@ObfuscatedName("as")
	public int field3838;
	@ObfuscatedName("aj")
	public int field3833;
	@ObfuscatedName("ag")
	public int field3832;
	@ObfuscatedName("az")
	public int field3842;
	@ObfuscatedName("av")
	public int field3839;
	@ObfuscatedName("ap")
	public int field3835;
	@ObfuscatedName("aq")
	public int field3836;

	public GraphicsDefaults() {
		this.compass = -1;
		this.field3841 = -1;
		this.mapScenes = -1;
		this.headIconsPk = -1;
		this.field3838 = -1;
		this.field3833 = -1;
		this.field3832 = -1;
		this.field3842 = -1;
		this.field3839 = -1;
		this.field3835 = -1;
		this.field3836 = -1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lnd;I)V",
		garbageValue = "-1842345605"
	)
	@Export("decode")
	public void decode(AbstractArchive var1) {
		byte[] var2 = var1.takeFileFlat(DefaultsGroup.field3830.group);
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
				this.compass = var3.method2543();
				this.field3841 = var3.method2543();
				this.mapScenes = var3.method2543();
				this.headIconsPk = var3.method2543();
				this.field3838 = var3.method2543();
				this.field3833 = var3.method2543();
				this.field3832 = var3.method2543();
				this.field3842 = var3.method2543();
				this.field3839 = var3.method2543();
				this.field3835 = var3.method2543();
				this.field3836 = var3.method2543();
			}
		}
	}
}
