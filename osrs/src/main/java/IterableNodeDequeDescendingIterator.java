import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("pj")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "Lpy;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Lsj;"
	)
	Node field3672;
	@ObfuscatedName("ak")
	@ObfuscatedSignature(
		descriptor = "Lsj;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		descriptor = "(Lpy;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(Lpy;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("al")
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