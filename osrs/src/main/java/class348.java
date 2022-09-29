import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("mr")
public class class348 implements Iterator {
	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "Lmh;"
	)
	class349 field4209;
	@ObfuscatedName("p")
	@ObfuscatedGetter(
		intValue = 1976768071
	)
	int field4211;
	@ObfuscatedName("f")
	@ObfuscatedGetter(
		intValue = -1367600821
	)
	int field4210;

	@ObfuscatedSignature(
		descriptor = "(Lmh;)V"
	)
	class348(class349 var1) {
		this.field4211 = 0;
		this.field4210 = this.field4209.field4214;
		this.field4209 = var1;
	}

	public boolean hasNext() {
		return this.field4211 < this.field4209.field4216;
	}

	public Object next() {
		if (this.field4209.field4214 != this.field4210) {
			throw new ConcurrentModificationException();
		} else if (this.field4211 < this.field4209.field4216) {
			Object var1 = this.field4209.field4212[this.field4211].field4204;
			++this.field4211;
			return var1;
		} else {
			throw new NoSuchElementException();
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

	@ObfuscatedName("c")
	@ObfuscatedSignature(
		descriptor = "(Lcf;B)V",
		garbageValue = "-24"
	)
	@Export("runScriptEvent")
	public static void runScriptEvent(ScriptEvent var0) {
		AbstractWorldMapData.runScript(var0, 500000, 475000);
	}
}
