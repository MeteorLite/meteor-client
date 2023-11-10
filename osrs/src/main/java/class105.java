import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ew")
final class class105 implements class334 {
	@ObfuscatedName("dm")
	@ObfuscatedSignature(
		descriptor = "Lup;"
	)
	@Export("worldSelectRightSprite")
	static IndexedSprite worldSelectRightSprite;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lnn;"
	)
	@Export("val$cc")
	@ObfuscatedName("val$cc")
	final Widget val$cc;

	@ObfuscatedSignature(
		descriptor = "(Lnn;)V"
	)
	class105(Widget var1) {
		this.val$cc = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "5"
	)
	@Export("vmethod5708")
	public void vmethod5708() {
		if (this.val$cc != null && this.val$cc.method1874().field2933 != null) {
			ScriptEvent var1 = new ScriptEvent();
			var1.method467(this.val$cc);
			var1.setArgs(this.val$cc.method1874().field2933);
			FileSystem.getScriptEvents().addFirst(var1);
		}

	}
}