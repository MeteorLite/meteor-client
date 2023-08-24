import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;

import java.lang.ref.SoftReference;

@ObfuscatedName("lx")
@Implements("SoftWrapper")
public class SoftWrapper extends Wrapper {
	@ObfuscatedName("au")
	@Export("ref")
	SoftReference ref;

	SoftWrapper(Object var1, int var2) {
		super(var2);
		this.ref = new SoftReference(var1);
	}

	@ObfuscatedName("au")
	@Export("get")
	Object get() {
		return this.ref.get();
	}

	@ObfuscatedName("ae")
	@Export("isSoft")
	boolean isSoft() {
		return true;
	}
}