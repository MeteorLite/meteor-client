import java.util.Iterator;
import java.util.NoSuchElementException;
import net.runelite.mapping.Export;

public class RuneLiteIterableLinkDeque implements Iterator {
	public final LinkDeque linkDeque;
	public Link link;

	public RuneLiteIterableLinkDeque(LinkDeque var1) {
		this.linkDeque = var1;
		this.link = this.linkDeque.sentinel.previous;
	}

	public boolean hasNext() {
		return this.link != this.linkDeque.sentinel;
	}

	public Link next() {
		if (this.link == this.linkDeque.sentinel) {
			throw new NoSuchElementException();
		} else {
			Link var1 = this.link;
			this.link = this.link.previous;
			return var1;
		}
	}

	public void remove() {
		Link var1 = this.link.next;
		if (var1 == this.linkDeque.sentinel) {
			throw new IllegalStateException();
		} else {
			var1.remove();
		}
	}
}
