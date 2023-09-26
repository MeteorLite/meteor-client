import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bq")
@Implements("VorbisMapping")
public class VorbisMapping {
	@ObfuscatedName("ac")
	int field249;
	@ObfuscatedName("al")
	int field250;
	@ObfuscatedName("ak")
	int[] field251;
	@ObfuscatedName("ax")
	int[] field252;

	VorbisMapping() {
		class60 var1 = VorbisSample.field267;
		var1.method327(16);
		this.field249 = var1.method328() != 0 ? var1.method327(4) + 1 : 1;
		if (var1.method328() != 0) {
			var1.method327(8);
		}

		var1.method327(2);
		if (this.field249 > 1) {
			this.field250 = var1.method327(4);
		}

		this.field251 = new int[this.field249];
		this.field252 = new int[this.field249];

		for (int var2 = 0; var2 < this.field249; ++var2) {
			var1.method327(8);
			this.field251[var2] = var1.method327(8);
			this.field252[var2] = var1.method327(8);
		}

	}
}