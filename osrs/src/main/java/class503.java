import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("tz")
final class class503 implements class498 {
	@ObfuscatedName("cy")
	static int field4107;

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Ltm;I)V",
		garbageValue = "465506048"
	)
	@Export("vmethod8274")
	public void vmethod8274(Object var1, Buffer var2) {
		this.method2498((String)var1, var2);
	}

	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "(Ltm;I)Ljava/lang/Object;",
		garbageValue = "-295239457"
	)
	@Export("vmethod8273")
	public Object vmethod8273(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("ai")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Ltm;I)V",
		garbageValue = "-1097671055"
	)
	void method2498(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}

	@ObfuscatedName("ab")
	@ObfuscatedSignature(
		descriptor = "(I)V",
		garbageValue = "2008641376"
	)
	static final void method2501() {
		UserComparator8.method673("You can't add yourself to your own ignore list");
	}
}