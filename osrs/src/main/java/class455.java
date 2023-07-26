import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("rt")
public class class455 implements class460 {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lse;"
	)
	public final class490 field3883;

	@ObfuscatedSignature(
		descriptor = "(Lsj;)V"
	)
	class455(class491 var1) {
		this.field3883 = var1;
	}

	@ObfuscatedSignature(
		descriptor = "(Lrn;)V"
	)
	public class455(class456 var1) {
		this(new class491(var1));
	}

	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "2097742109"
	)
	public int method2297(int var1) {
		return this.field3883.vmethod8144(var1);
	}
}
