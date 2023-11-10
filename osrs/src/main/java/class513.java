import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("td")
final class class513 implements class510 {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Luj;B)V",
		garbageValue = "-42"
	)
	@Export("vmethod8274")
	public void vmethod8274(Object var1, Buffer var2) {
		this.method2500((Long)var1, var2);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)Ljava/lang/Object;",
		garbageValue = "-69"
	)
	@Export("vmethod8273")
	public Object vmethod8273(Buffer var1) {
		return var1.readLong();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Long;Luj;B)V",
		garbageValue = "79"
	)
	void method2500(Long var1, Buffer var2) {
		var2.writeLong(var1);
	}
}