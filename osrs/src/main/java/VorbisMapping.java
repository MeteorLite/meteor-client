import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("br")
@Implements("VorbisMapping")
public class VorbisMapping {
	@ObfuscatedName("at")
	int field247;
	@ObfuscatedName("ah")
	int field246;
	@ObfuscatedName("ar")
	int[] field249;
	@ObfuscatedName("ao")
	int[] field248;

	VorbisMapping() {
		class60 var1 = VorbisSample.field264;
		var1.method335(16);
		this.field247 = var1.method336() != 0 ? var1.method335(4) + 1 : 1;
		if (var1.method336() != 0) {
			var1.method335(8);
		}

		var1.method335(2);
		if (this.field247 > 1) {
			this.field246 = var1.method335(4);
		}

		this.field249 = new int[this.field247];
		this.field248 = new int[this.field247];

		for (int var2 = 0; var2 < this.field247; ++var2) {
			var1.method335(8);
			this.field249[var2] = var1.method335(8);
			this.field248[var2] = var1.method335(8);
		}

	}
}