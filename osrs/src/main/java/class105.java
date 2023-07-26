import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
final class class105 implements class324 {
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lmt;"
	)
	@Export("val$cc")
	@ObfuscatedName("val$cc")
	final Widget val$cc;

	@ObfuscatedSignature(
		descriptor = "(Lmt;)V"
	)
	class105(Widget var1) {
		this.val$cc = var1;
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "-3"
	)
	@Export("vmethod5708")
	public void vmethod5708() {
		if (this.val$cc != null && this.val$cc.method1808().field2883 != null) {
			ScriptEvent var1 = new ScriptEvent();
			var1.method474(this.val$cc);
			var1.setArgs(this.val$cc.method1808().field2883);
			ClientPacket.getScriptEvents().addFirst(var1);
		}

	}

	@ObfuscatedName("as")
	@ObfuscatedSignature(
		descriptor = "(IB)Lcx;",
		garbageValue = "-95"
	)
	@Export("Messages_getMessage")
	static Message Messages_getMessage(int var0) {
		return (Message)Messages.Messages_hashTable.get((long)var0);
	}

	@ObfuscatedName("ht")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "16"
	)
	static final void method618() {
		if (VerticalAlignment.pcmPlayer1 != null) {
			VerticalAlignment.pcmPlayer1.run();
		}

	}
}
