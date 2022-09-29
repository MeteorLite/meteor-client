import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("lp")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Llz;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("p")
	@ObfuscatedSignature(
		descriptor = "Lov;"
	)
	Node field4169;
	@ObfuscatedName("f")
	@ObfuscatedSignature(
		descriptor = "Lov;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		descriptor = "(Llz;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Llz;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("p")
	@Export("start")
	void start() {
		this.field4169 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	public Object next() {
		Node var1 = this.field4169;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field4169 = null;
		} else {
			this.field4169 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	public boolean hasNext() {
		return this.deque.sentinel != this.field4169 && this.field4169 != null;
	}

	public void remove() {
		this.last.remove();
		this.last = null;
	}
}
