import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Iterator;

@ObfuscatedName("tx")
class class508 implements Iterator {
	@ObfuscatedName("at")
	int field4119;
	// $FF: synthetic field
	@ObfuscatedSignature(
		descriptor = "Ltl;"
	)
	@Export("this$0")
	@ObfuscatedName("this$0")
	final class509 this$0;

	@ObfuscatedSignature(
		descriptor = "(Ltl;)V"
	)
	class508(class509 var1) {
		this.this$0 = var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.field4119 < this.this$0.method2338();
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		int var1 = ++this.field4119 - 1;
		class468 var2 = (class468)this.this$0.field4121.get((long)var1);
		return var2 != null ? var2 : this.this$0.method2492(var1);
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public void remove() {
		throw new UnsupportedOperationException();
	}
}