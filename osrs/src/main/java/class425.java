import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("qr")
public final class class425 implements Comparable {
	@ObfuscatedName("aw")
	Object field3767;
	@ObfuscatedName("ay")
	Object field3768;
	@ObfuscatedName("ar")
	long field3770;
	@ObfuscatedName("am")
	long field3769;

	class425(Object var1, Object var2) {
		this.field3767 = var1;
		this.field3768 = var2;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Lqr;I)I",
		garbageValue = "1914660180"
	)
	int method2152(class425 var1) {
		if (this.field3769 < var1.field3769) {
			return -1;
		} else {
			return this.field3769 > var1.field3769 ? 1 : 0;
		}
	}

	@Export("equals")
	@ObfuscatedName("equals")
	public boolean equals(Object var1) {
		if (var1 instanceof class425) {
			return this.field3768.equals(((class425)var1).field3768);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Export("hashCode")
	@ObfuscatedName("hashCode")
	public int hashCode() {
		return this.field3768.hashCode();
	}

	@Export("compareTo")
	@ObfuscatedName("compareTo")
	public int compareTo(Object var1) {
		return this.method2152((class425)var1);
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "686402889"
	)
	static int method2153() {
		return ++Messages.Messages_count - 1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(S)[Lhl;",
		garbageValue = "215"
	)
	static VerticalAlignment[] method2151() {
		return new VerticalAlignment[]{VerticalAlignment.field1616, VerticalAlignment.field1615, VerticalAlignment.VerticalAlignment_centered};
	}

	@ObfuscatedName("aj")
	@ObfuscatedSignature(
		descriptor = "(Lnd;IB)V",
		garbageValue = "-49"
	)
	static void method2154(AbstractArchive var0, int var1) {
		if ((var1 & 536870912) != 0) {
			Login.logoSprite = class451.SpriteBuffer_getIndexedSpriteByName(var0, "logo_deadman_mode", "");
		} else if ((var1 & 1073741824) != 0) {
			Login.logoSprite = class451.SpriteBuffer_getIndexedSpriteByName(var0, "logo_seasonal_mode", "");
		} else if ((var1 & 256) != 0) {
			Login.logoSprite = class451.SpriteBuffer_getIndexedSpriteByName(var0, "logo_speedrunning", "");
		} else {
			Login.logoSprite = class451.SpriteBuffer_getIndexedSpriteByName(var0, "logo", "");
		}

	}
}
