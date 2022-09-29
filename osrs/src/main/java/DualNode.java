import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oa")
@Implements("DualNode")
public class DualNode extends Node {
	@ObfuscatedName("dr")
	@Export("keyDual")
	public long keyDual;
	@ObfuscatedName("dq")
	@ObfuscatedSignature(
		descriptor = "Loa;"
	)
	@Export("previousDual")
	public DualNode previousDual;
	@ObfuscatedName("dl")
	@ObfuscatedSignature(
		descriptor = "Loa;"
	)
	@Export("nextDual")
	public DualNode nextDual;

	@ObfuscatedName("dj")
	@Export("removeDual")
	public void removeDual() {
		if (this.nextDual != null) {
			this.nextDual.previousDual = this.previousDual;
			this.previousDual.nextDual = this.nextDual;
			this.previousDual = null;
			this.nextDual = null;
		}
	}
}
