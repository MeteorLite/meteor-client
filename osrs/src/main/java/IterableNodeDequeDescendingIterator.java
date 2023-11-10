import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("pk")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lpm;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lsh;"
	)
	Node field3672;
	@ObfuscatedName("ar")
	@ObfuscatedSignature(
		descriptor = "Lsh;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		descriptor = "(Lpm;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(Lpm;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("ah")
	@Export("start")
	void start() {
		this.field3672 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		Node var1 = this.field3672;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3672 = null;
		} else {
			this.field3672 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.deque.sentinel != this.field3672 && this.field3672 != null;
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public void remove() {
		this.last.remove();
		this.last = null;
	}
}