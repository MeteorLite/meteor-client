import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("te")
final class class500 implements class499 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Object;Lty;I)V",
		garbageValue = "-791895690"
	)
	@Export("vmethod8274")
	public void vmethod8274(Object var1, Buffer var2) {
		this.method2461((Integer)var1, var2);
	}

	@ObfuscatedName("ay")
	@ObfuscatedSignature(
		descriptor = "(Lty;I)Ljava/lang/Object;",
		garbageValue = "1270618633"
	)
	@Export("vmethod8273")
	public Object vmethod8273(Buffer var1) {
		return var1.readInt();
	}

	@ObfuscatedName("av")
	@ObfuscatedSignature(
		descriptor = "(Ljava/lang/Integer;Lty;I)V",
		garbageValue = "-603205344"
	)
	void method2461(Integer var1, Buffer var2) {
		var2.writeInt(var1);
	}
}
