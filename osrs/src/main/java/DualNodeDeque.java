import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mp")
@Implements("DualNodeDeque")
public final class DualNodeDeque {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lpu;"
	)
	@Export("sentinel")
	DualNode sentinel;

	public DualNodeDeque() {
		this.sentinel = new DualNode();
		this.sentinel.previousDual = this.sentinel;
		this.sentinel.nextDual = this.sentinel;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(Lpu;)V"
	)
	@Export("addFirst")
	public void addFirst(DualNode var1) {
		if (var1.nextDual != null) {
			var1.removeDual();
		}

		var1.nextDual = this.sentinel.nextDual;
		var1.previousDual = this.sentinel;
		var1.nextDual.previousDual = var1;
		var1.previousDual.nextDual = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "(Lpu;)V"
	)
	@Export("addLast")
	public void addLast(DualNode var1) {
		if (var1.nextDual != null) {
			var1.removeDual();
		}

		var1.nextDual = this.sentinel;
		var1.previousDual = this.sentinel.previousDual;
		var1.nextDual.previousDual = var1;
		var1.previousDual.nextDual = var1;
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "()Lpu;"
	)
	@Export("removeLast")
	public DualNode removeLast() {
		DualNode var1 = this.sentinel.previousDual;
		return var1 == this.sentinel ? null : var1;
	}
}
