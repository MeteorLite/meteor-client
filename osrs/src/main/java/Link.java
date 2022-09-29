import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("oy")
public class Link {
	@ObfuscatedName("n")
	@ObfuscatedSignature(
		descriptor = "Loy;"
	)
	public Link previous;
	@ObfuscatedName("k")
	@ObfuscatedSignature(
		descriptor = "Loy;"
	)
	public Link next;

	@ObfuscatedName("c")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}
}
