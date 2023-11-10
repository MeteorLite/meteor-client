import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ta")
final class class515 implements class510 {
	@ObfuscatedName("ox")
	@Export("menuHeight")
	static int menuHeight;

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Luj;B)V",
		garbageValue = "-42"
	)
	@Export("vmethod8274")
	public void vmethod8274(Object var1, Buffer var2) {
		this.method2510((String)var1, var2);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(Luj;B)Ljava/lang/Object;",
		garbageValue = "-69"
	)
	@Export("vmethod8273")
	public Object vmethod8273(Buffer var1) {
		return var1.readStringCp1252NullTerminated();
	}

	@ObfuscatedName("aa")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/String;Luj;I)V",
		garbageValue = "919376125"
	)
	void method2510(String var1, Buffer var2) {
		var2.writeStringCp1252NullTerminated(var1);
	}
}