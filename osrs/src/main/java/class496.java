import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("tn")
class class496 implements Iterator {
	@ObfuscatedName("au")
	int field4093;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Lth;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class497 this$0;

	@ObfuscatedSignature(
		descriptor = "(Lth;)V"
	)
	class496(class497 var1) {
		this.this$0 = var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.field4093 < this.this$0.method2322();
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		int var1 = ++this.field4093 - 1;
		class456 var2 = (class456)this.this$0.field4095.get((long)var1);
		return var2 != null ? var2 : this.this$0.method2482(var1);
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public void remove() {
		throw new UnsupportedOperationException();
	}
}