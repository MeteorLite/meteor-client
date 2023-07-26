import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("pg")
public class class392 implements Iterator {
	@ObfuscatedName("aw")
	@ObfuscatedSignature(
		descriptor = "Lpd;"
	)
	class393 field3654;
	@ObfuscatedName("ay")
	int field3653;
	@ObfuscatedName("ar")
	int field3652;

	@ObfuscatedSignature(
		descriptor = "(Lpd;)V"
	)
	class392(class393 var1) {
		this.field3653 = 0;
		this.field3652 = this.field3654.field3656;
		this.field3654 = var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.field3653 < this.field3654.field3655;
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		if (this.field3654.field3656 != this.field3652) {
			throw new ConcurrentModificationException();
		} else if (this.field3653 < this.field3654.field3655) {
			Object var1 = this.field3654.field3658[this.field3653].field3651;
			++this.field3653;
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
