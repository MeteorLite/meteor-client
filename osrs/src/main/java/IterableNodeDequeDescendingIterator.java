import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("ot")
@Implements("IterableNodeDequeDescendingIterator")
public class IterableNodeDequeDescendingIterator implements Iterator {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Loc;"
	)
	@Export("deque")
	IterableNodeDeque deque;
	@ObfuscatedName("ae")
	@ObfuscatedSignature(
		descriptor = "Lsj;"
	)
	Node field3634;
	@ObfuscatedName("ao")
	@ObfuscatedSignature(
		descriptor = "Lsj;"
	)
	@Export("last")
	Node last;

	@ObfuscatedSignature(
		descriptor = "(Loc;)V"
	)
	IterableNodeDequeDescendingIterator(IterableNodeDeque var1) {
		this.last = null;
		this.setDeque(var1);
	}

	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "(Loc;)V"
	)
	@Export("setDeque")
	void setDeque(IterableNodeDeque var1) {
		this.deque = var1;
		this.start();
	}

	@ObfuscatedName("ae")
	@Export("start")
	void start() {
		this.field3634 = this.deque != null ? this.deque.sentinel.previous : null;
		this.last = null;
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		Node var1 = this.field3634;
		if (var1 == this.deque.sentinel) {
			var1 = null;
			this.field3634 = null;
		} else {
			this.field3634 = var1.previous;
		}

		this.last = var1;
		return var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.deque.sentinel != this.field3634 && this.field3634 != null;
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public void remove() {
		this.last.remove();
		this.last = null;
	}
}