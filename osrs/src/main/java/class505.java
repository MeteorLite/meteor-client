import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ObfuscatedName("ty")
public class class505 implements class504 {
	@ObfuscatedName("ac")
	Map field4095;
	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "Luv;"
	)
	final class537 field4096;

	@ObfuscatedSignature(
		descriptor = "(Luv;)V"
	)
	public class505(class537 var1) {
		this.field4096 = var1;
	}

	@ObfuscatedName("ac")
	@ObfuscatedSignature(
		descriptor = "(II)I",
		garbageValue = "-3541308"
	)
	@Export("vmethod8144")
	public int vmethod8144(int var1) {
		if (this.field4095 != null) {
			class538 var2 = (class538)this.field4095.get(var1);
			if (var2 != null) {
				return (Integer)var2.field4242;
			}
		}

		return (Integer)this.field4096.vmethod8697(var1);
	}

	@ObfuscatedName("al")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/Object;B)V",
		garbageValue = "78"
	)
	@Export("vmethod8143")
	public void vmethod8143(int var1, Object var2) {
		if (this.field4095 == null) {
			this.field4095 = new HashMap();
			this.field4095.put(var1, new class538(var1, var2));
		} else {
			class538 var3 = (class538)this.field4095.get(var1);
			if (var3 == null) {
				this.field4095.put(var1, new class538(var1, var2));
			} else {
				var3.field4242 = var2;
			}
		}

	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return this.field4095 == null ? Collections.emptyList().iterator() : this.field4095.values().iterator();
	}
}