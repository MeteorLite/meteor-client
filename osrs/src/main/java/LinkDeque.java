import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mf")
public class LinkDeque {
	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "Lpg;"
	)
	Link sentinel;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lpg;"
	)
	Link current;

	public LinkDeque() {
		this.sentinel = new Link();
		this.sentinel.previous = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(Lpg;)V"
	)
	public void addFirst(Link var1) {
		if (var1.next != null) {
			var1.remove();
		}

		var1.next = this.sentinel.next;
		var1.previous = this.sentinel;
		var1.next.previous = var1;
		var1.previous.next = var1;
	}

	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "()Lpg;"
	)
	public Link last() {
		Link var1 = this.sentinel.previous;
		if (var1 == this.sentinel) {
			this.current = null;
			return null;
		} else {
			this.current = var1.previous;
			return var1;
		}
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "()Lpg;"
	)
	public Link previous() {
		Link var1 = this.current;
		if (var1 == this.sentinel) {
			this.current = null;
			return null;
		} else {
			this.current = var1.previous;
			return var1;
		}
	}
}
