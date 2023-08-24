import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ObfuscatedName("pr")
public class class391 implements Iterator {
	@ObfuscatedName("au")
	@ObfuscatedSignature(
		descriptor = "Lpa;"
	)
	class392 field3661;
	@ObfuscatedName("ae")
	int field3659;
	@ObfuscatedName("ao")
	int field3660;

	@ObfuscatedSignature(
		descriptor = "(Lpa;)V"
	)
	class391(class392 var1) {
		this.field3659 = 0;
		this.field3660 = this.field3661.field3663;
		this.field3661 = var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.field3659 < this.field3661.field3664;
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		if (this.field3661.field3663 != this.field3660) {
			throw new ConcurrentModificationException();
		} else if (this.field3659 < this.field3661.field3664) {
			Object var1 = this.field3661.field3666[this.field3659].field3658;
			++this.field3659;
			return var1;
		} else {
			throw new NoSuchElementException();
		}
	}

	@Export("remove")
	@ObfuscatedName("remove")
	public void remove() {
		throw new UnsupportedOperationException();
	}
}