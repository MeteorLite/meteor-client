import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bc")
@Implements("VorbisMapping")
public class VorbisMapping {
	@ObfuscatedName("au")
	int field252;
	@ObfuscatedName("ae")
	int field251;
	@ObfuscatedName("ao")
	int[] field253;
	@ObfuscatedName("at")
	int[] field254;

	VorbisMapping() {
		class60 var1 = VorbisSample.field267;
		var1.method325(16);
		this.field252 = var1.method326() != 0 ? var1.method325(4) + 1 : 1;
		if (var1.method326() != 0) {
			var1.method325(8);
		}

		var1.method325(2);
		if (this.field252 > 1) {
			this.field251 = var1.method325(4);
		}

		this.field253 = new int[this.field252];
		this.field254 = new int[this.field252];

		for (int var2 = 0; var2 < this.field252; ++var2) {
			var1.method325(8);
			this.field253[var2] = var1.method325(8);
			this.field254[var2] = var1.method325(8);
		}

	}
}