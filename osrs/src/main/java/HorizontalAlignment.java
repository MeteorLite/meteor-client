import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hz")
@Implements("HorizontalAlignment")
public enum HorizontalAlignment implements class372 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lhz;"
	)
	field1558(1, 0),
	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "Lhz;"
	)
	@Export("HorizontalAlignment_centered")
	HorizontalAlignment_centered(0, 1),
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lhz;"
	)
	field1557(2, 2);

	@ObfuscatedName("am")
	@Export("value")
	public final int value;
	@ObfuscatedName("as")
	@Export("id")
	final int id;

	HorizontalAlignment(int var3, int var4) {
		this.value = var3;
		this.id = var4;
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(I)I",
		garbageValue = "1644350448"
	)
	@Export("rsOrdinal")
	public int rsOrdinal() {
		return this.id;
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(I)Z",
		garbageValue = "-858932897"
	)
	public static boolean method960() {
		return !class306.field2755.isEmpty();
	}

	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "(Lbj;I)V",
		garbageValue = "-539334926"
	)
	public static final void method959(class51 var0) {
		class309.pcmPlayerProvider = var0;
	}
}
