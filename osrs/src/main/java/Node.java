import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ov")
@Implements("Node")
public class Node {
	@ObfuscatedName("gb")
	@Export("key")
	public long key;
	@ObfuscatedName("ga")
	@ObfuscatedSignature(
		descriptor = "Lov;"
	)
	@Export("previous")
	public Node previous;
	@ObfuscatedName("gn")
	@ObfuscatedSignature(
		descriptor = "Lov;"
	)
	@Export("next")
	public Node next;

	@ObfuscatedName("fa")
	@Export("remove")
	public void remove() {
		if (this.next != null) {
			this.next.previous = this.previous;
			this.previous.next = this.next;
			this.previous = null;
			this.next = null;
		}
	}

	@ObfuscatedName("fd")
	@Export("hasNext")
	public boolean hasNext() {
		return this.next != null;
	}
}
