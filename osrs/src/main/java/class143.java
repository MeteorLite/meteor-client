import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fo")
public abstract class class143 extends Node {
	class143() {
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)V",
		garbageValue = "209179459"
	)
	@Export("vmethod3254")
	abstract void vmethod3254(Buffer var1);

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Lfi;B)V",
		garbageValue = "73"
	)
	@Export("vmethod3248")
	abstract void vmethod3248(ClanSettings var1);

	@ObfuscatedName("om")
	@ObfuscatedSignature(
		descriptor = "(Lmi;B)Z",
		garbageValue = "-83"
	)
	@Export("isComponentHidden")
	static boolean isComponentHidden(Widget var0) {
		return var0.isHidden;
	}
}