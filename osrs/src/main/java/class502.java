import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@ObfuscatedName("tq")
public class class502 implements class501 {
	@ObfuscatedName("at")
	Map field4089;
	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "Lur;"
	)
	final class534 field4090;

	@ObfuscatedSignature(
		descriptor = "(Lur;)V"
	)
	public class502(class534 var1) {
		this.field4090 = var1;
	}

	@ObfuscatedName("at")
	@ObfuscatedSignature(
		descriptor = "(IB)I",
		garbageValue = "-17"
	)
	@Export("vmethod8144")
	public int vmethod8144(int var1) {
		if (this.field4089 != null) {
			class535 var2 = (class535)this.field4089.get(var1);
			if (var2 != null) {
				return (Integer)var2.field4243;
			}
		}

		return (Integer)this.field4090.vmethod8697(var1);
	}

	@ObfuscatedName("ah")
	@ObfuscatedSignature(
		descriptor = "(ILjava/lang/Object;B)V",
		garbageValue = "-122"
	)
	@Export("vmethod8143")
	public void vmethod8143(int var1, Object var2) {
		if (this.field4089 == null) {
			this.field4089 = new HashMap();
			this.field4089.put(var1, new class535(var1, var2));
		} else {
			class535 var3 = (class535)this.field4089.get(var1);
			if (var3 == null) {
				this.field4089.put(var1, new class535(var1, var2));
			} else {
				var3.field4243 = var2;
			}
		}

	}

	@Export("iterator")
	@ObfuscatedName("iterator")
	public Iterator iterator() {
		return this.field4089 == null ? Collections.emptyList().iterator() : this.field4089.values().iterator();
	}
}