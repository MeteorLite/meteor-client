import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pg")
public class Link {
	@ObfuscatedName("x")
	@ObfuscatedSignature(
		descriptor = "Lpg;"
	)
	public Link previous;
	@ObfuscatedName("h")
	@ObfuscatedSignature(
		descriptor = "Lpg;"
	)
	public Link next;

	@ObfuscatedName("a")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}
}
