import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("bg")
@Implements("VorbisMapping")
public class VorbisMapping {
	@ObfuscatedName("aw")
	int field250;
	@ObfuscatedName("ay")
	int field251;
	@ObfuscatedName("ar")
	int[] field253;
	@ObfuscatedName("am")
	int[] field252;

	VorbisMapping() {
		class60 var1 = VorbisSample.field267;
		var1.method325(16);
		this.field250 = var1.method326() != 0 ? var1.method325(4) + 1 : 1;
		if (var1.method326() != 0) {
			var1.method325(8);
		}

		var1.method325(2);
		if (this.field250 > 1) {
			this.field251 = var1.method325(4);
		}

		this.field253 = new int[this.field250];
		this.field252 = new int[this.field250];

		for (int var2 = 0; var2 < this.field250; ++var2) {
			var1.method325(8);
			this.field253[var2] = var1.method325(8);
			this.field252[var2] = var1.method325(8);
		}

	}
}
