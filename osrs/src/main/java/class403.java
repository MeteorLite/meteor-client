import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

@ObfuscatedName("pg")
public class class403 implements Iterator {
	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "Lps;"
	)
	class404 field3699;
	@ObfuscatedName("ah")
	int field3697;
	@ObfuscatedName("ar")
	int field3698;

	@ObfuscatedSignature(
		descriptor = "(Lps;)V"
	)
	class403(class404 var1) {
		this.field3697 = 0;
		this.field3698 = this.field3699.field3700;
		this.field3699 = var1;
	}

	@Export("hasNext")
	@ObfuscatedName("hasNext")
	public boolean hasNext() {
		return this.field3697 < this.field3699.field3701;
	}

	@Export("next")
	@ObfuscatedName("next")
	public Object next() {
		if (this.field3699.field3700 != this.field3698) {
			throw new ConcurrentModificationException();
		} else if (this.field3697 < this.field3699.field3701) {
			Object var1 = this.field3699.field3703[this.field3697].field3696;
			++this.field3697;
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

	@ObfuscatedName("aq")
	@ObfuscatedSignature(
		descriptor = "(IIB)I",
		garbageValue = "14"
	)
	static final int method2044(int var0, int var1) {
		if (var0 == -2) {
			return 12345678;
		} else if (var0 == -1) {
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return var1;
		} else {
			var1 = (var0 & 127) * var1 / 128;
			if (var1 < 2) {
				var1 = 2;
			} else if (var1 > 126) {
				var1 = 126;
			}

			return (var0 & 65408) + var1;
		}
	}
}