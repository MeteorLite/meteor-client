import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("sr")
public class class469 implements class474 {
	@ObfuscatedName("fa")
	@ObfuscatedSignature(
		descriptor = "Lok;"
	)
	static Archive field3930;
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lts;"
	)
	public final class504 field3931;

	@ObfuscatedSignature(
		descriptor = "(Lty;)V"
	)
	class469(class505 var1) {
		this.field3931 = var1;
	}

	@ObfuscatedSignature(
		descriptor = "(Lsm;)V"
	)
	public class469(class470 var1) {
		this(new class505(var1));
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "11"
	)
	public int method2358(int var1) {
		return this.field3931.vmethod8144(var1);
	}
}