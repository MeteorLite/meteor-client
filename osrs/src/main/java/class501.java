import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tg")
final class class501 implements class498 {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Ltm;I)V",
		garbageValue = "465506048"
	)
	@Export("vmethod8274")
	public void vmethod8274(Object var1, Buffer var2) {
		this.method2491((Long)var1, var2);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)Ljava/lang/Object;",
		garbageValue = "-295239457"
	)
	@Export("vmethod8273")
	public Object vmethod8273(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Long;Ltm;B)V",
		garbageValue = "-19"
	)
	void method2491(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}
}